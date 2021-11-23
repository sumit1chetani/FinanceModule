package com.dci.payroll.payroll.employeeTds;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.payroll.payroll.employeelop.EmployeeLopBean;
import com.dci.payroll.payroll.employeelop.EmployeeLopQueryUtil;
import com.dci.payroll.tds.TdsDeclaration.TdsDeclarationQueryUtill;



@Repository
public class EmployeeTdsDAOImpl implements EmployeeTdsDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeTdsDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EmployeeTdsBean> getEmployeeTdsList(String companyId, String branchId, String dept, String monthYear) throws CustomException {
		List<EmployeeTdsBean> eTdsList = new ArrayList<>();
		try {

			eTdsList = jdbcTemplate.query(EmployeeTdsQueryUtil.stdsList, new BeanPropertyRowMapper<>(EmployeeTdsBean.class), monthYear, monthYear, companyId, branchId, dept, monthYear);

		} catch (DataAccessException e) {
			LOGGER.error("Error in EmployeeTdsDAOImpl - getEmployeeTdsList ", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return eTdsList;
	}

	@Override
	public EmployeeTdsBean insertEmployeeTdsList(ArrayList<EmployeeTdsBean> employeeTdsBeans) throws CustomException {
		boolean isSuccess = false;
		EmployeeTdsBean result = new EmployeeTdsBean();
		try {
			List<EmployeeTdsBean> employeeTdsBeansList = new ArrayList<>();
			List<EmployeeTdsBean> employeePayComponent = new ArrayList<>();
			List<EmployeeTdsBean> employeeSalaryFix = new ArrayList<>();
			List<EmployeeTdsBean> employeeTdsList = new ArrayList<>();

			String errorMessage = "";
			String successMessage = "";

			Map<String, Object> tdsDeclarationMap = null;

			for (EmployeeTdsBean tdsBean : employeeTdsBeans) {
				tdsDeclarationMap = new HashMap<>();

				tdsDeclarationMap.put("employee_id", tdsBean.getEmployeeId());
				tdsDeclarationMap.put("pay_component_id", "TDS");
				tdsDeclarationMap.put("month_year", tdsBean.getMonthYearValue());
				tdsDeclarationMap.put("amount", tdsBean.getActualTds());

				employeeSalaryFix = jdbcTemplate.query(TdsDeclarationQueryUtill.CHECK_EMP_SALARY_FIX_EXISTS, new BeanPropertyRowMapper<>(EmployeeTdsBean.class), tdsBean.getEmployeeId(), tdsBean.getMonthYearValue());

				employeePayComponent = jdbcTemplate.query(TdsDeclarationQueryUtill.CHECK_EMP_PAYCOM_EXISTS, new BeanPropertyRowMapper<>(EmployeeTdsBean.class), tdsBean.getEmployeeId(), tdsBean.getMonthYearValue());

				if (employeePayComponent.size() != 0 && employeeSalaryFix.size() != 0) {
					employeeTdsList = jdbcTemplate.query(EmployeeTdsQueryUtil.CHECK_EMPLOYEE_IN_TDS, new BeanPropertyRowMapper<>(EmployeeTdsBean.class), tdsBean.getEmployeeId(), tdsBean.getMonthYearValue());
					if (employeeTdsList.size() == 0) {
						if (tdsBean.getEmployeeId() != null && tdsBean.getMonthYearValue() != null && tdsBean.getEstimatedTds() >= 0 && tdsBean.getActualTds() >= 0) {
							jdbcTemplate.update(EmployeeTdsQueryUtil.INSERT_EMPLOYEE_TDS_INSERT, new Object[] { tdsBean.getEmployeeId(), tdsBean.getMonthYearValue(), tdsBean.getActualTds(), tdsBean.getActualTds() });
							isSuccess = true;
						}
					} else {
						if (employeeTdsList.size() > 0) {
							if (tdsBean.getEmployeeId() != null && tdsBean.getMonthYearValue() != null && tdsBean.getEstimatedTds() >= 0 && tdsBean.getActualTds() >= 0) {
								if (tdsBean.getEstimatedTds() > 0 || tdsBean.getActualTds() > 0) {
									jdbcTemplate.update(EmployeeTdsQueryUtil.UPDATE_EMPLOYEE_TDS, new Object[] { tdsBean.getEstimatedTds(), tdsBean.getActualTds(), tdsBean.getEmployeeId(), tdsBean.getMonthYearValue() });
									successMessage += "TDS Updated for the Employee - '" + tdsBean.getEmployeeId() + " - " + tdsBean.getEmployeeName() + "'" + "<br>";
									isSuccess = true;
									result.setSuccessMessage(successMessage);
								} else {
									if (tdsBean.getEstimatedTds() == 0 && tdsBean.getActualTds() == 0) {
										jdbcTemplate.update(EmployeeTdsQueryUtil.DELETE_EMPLOYEE_IN_TDS, new Object[] { tdsBean.getEmployeeId(), tdsBean.getMonthYearValue() });
									}
								}

							}

						}
					}

					employeeTdsBeansList = jdbcTemplate.query(TdsDeclarationQueryUtill.CHECK_EMP_PAYCOM_PAID_EXISTS, new BeanPropertyRowMapper<>(EmployeeTdsBean.class), tdsBean.getEmployeeId(), tdsBean.getMonthYearValue(), "TDS");
					if (employeeTdsBeansList.size() == 0) {
						if (tdsBean.getActualTds() > 0) {
							namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.INSERT_EMP_PAYCOM_PAID, tdsDeclarationMap);
						}
					} else {
						if (tdsBean.getActualTds() > 0) {
							namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.UPDATE_EMP_PAYCOM_PAID, tdsDeclarationMap);
						} else {
							if (tdsBean.getActualTds() <= 0) {
								namedParameterJdbcTemplate.update(TdsDeclarationQueryUtill.DELETE_EMP_PAYCOM, tdsDeclarationMap);
							}
						}

					}
				} else if (employeePayComponent.size() == 0 && employeeSalaryFix.size() > 0 && tdsBean.getEstimatedTds() > 0 && tdsBean.getActualTds() > 0) {
					errorMessage += "Salary Not Generated for the Employee - '" + tdsBean.getEmployeeId() + " - " + tdsBean.getEmployeeName() + "'" + "<br>";
					result.setErrorMessage(errorMessage);
				}
			}
			result.setSuccess(isSuccess);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTdsDeclarationAdd", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return result;
	}

	@Override
	public EmployeeTdsBean uploadFile(MultipartFile file) {
		ArrayList<EmployeeTdsBean> lEmployeeLopBeans = new ArrayList<>();
		List<EmployeeLopBean> empLopList = new ArrayList<>();
		List<EmployeeLopBean> monthyearList = new ArrayList<>();
		List<EmployeeLopBean> checkLopList = new ArrayList<>();
		List<String> empIdList = new ArrayList<>();
		EmployeeTdsBean objemployeeTdsBean = null;
		Map<String, Object> records = new HashMap<>();
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		String PrevEmployeeId = null;
		String datestring = "";
		String sErrorCheck = "";
		boolean isValid = true;
		boolean isMonthValid = false;
		int stopExec = 0;
		Workbook workbook = null;
		try {
			if (fileName.endsWith("xls")) {
				workbook = new HSSFWorkbook(file.getInputStream());
				HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet.rowIterator();
			} else if (fileName.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet.rowIterator();
			}

			int rowCnt = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowCnt += 1;
				if (rowCnt > 0) {
					Iterator<Cell> cellIterator = row.cellIterator();
					objemployeeTdsBean = new EmployeeTdsBean();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0 && cell.getRowIndex() >= 3) {
								objemployeeTdsBean.setEmployeeId(cell.getStringCellValue().trim());
								empLopList = jdbcTemplate.query(EmployeeLopQueryUtil.CHECK_EMPLOYEE, new BeanPropertyRowMapper<>(EmployeeLopBean.class), cell.getStringCellValue().trim());
								if (empLopList.size() == 0) {
									isValid = false;
									objemployeeTdsBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is invalid in row " + cell.getRowIndex() + " ";

								}

								for (String e : empIdList) {
									if (e.equalsIgnoreCase(cell.getStringCellValue().trim())) {
										isValid = false;
										objemployeeTdsBean.setisValid(false);
										sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is repeated in row  " + cell.getRowIndex() + " ";
									}

								}
								empIdList.add(cell.getStringCellValue().trim());

							}
							if (cell.getColumnIndex() == 1 && cell.getRowIndex() == 0) {

								monthyearList = jdbcTemplate.query(EmployeeLopQueryUtil.SELECT_MONTHLIST, new BeanPropertyRowMapper<>(EmployeeLopBean.class));
								datestring = cell.getStringCellValue().trim();
								for (EmployeeLopBean bean : monthyearList) {
									if (bean.getMonthValue().equalsIgnoreCase(cell.getStringCellValue().trim())) {
										isMonthValid = true;
									}
								}
								if (!isMonthValid) {
									isValid = false;
									objemployeeTdsBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Month and  year should be current and previous month" + " ";
								}

							}
							break;

						case Cell.CELL_TYPE_NUMERIC:

							if (cell.getColumnIndex() == 2 && cell.getRowIndex() >= 3) {
								objemployeeTdsBean.setEstimatedTds(cell.getNumericCellValue());
								objemployeeTdsBean.setMonth(datestring);
							}
							if (cell.getColumnIndex() == 3 && cell.getRowIndex() >= 3) {

								objemployeeTdsBean.setActualTds(cell.getNumericCellValue());

							}
							if (cell.getColumnIndex() == 1 && cell.getRowIndex() == 0) {

								Date date1 = cell.getDateCellValue();
								String dateString = date1.toString();

								DateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
								Date date = inputFormat.parse(dateString);
								DateFormat outputFormat1 = new SimpleDateFormat("MMM YYYY");
								datestring = outputFormat1.format(date);
								monthyearList = jdbcTemplate.query(EmployeeLopQueryUtil.SELECT_MONTHLIST, new BeanPropertyRowMapper<>(EmployeeLopBean.class));
								for (EmployeeLopBean bean : monthyearList) {
									if (bean.getMonthValue().equalsIgnoreCase(datestring)) {
										isMonthValid = true;
									}
								}
								if (!isMonthValid) {
									isValid = false;
									objemployeeTdsBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Month and  year should be current and previous month" + " ";
								}

								objemployeeTdsBean.setMonth(datestring);

							}

							break;

						}

						checkLopList = jdbcTemplate.query(EmployeeTdsQueryUtil.CHECK_EMPLOYEE_IN_TDS, new BeanPropertyRowMapper<>(EmployeeLopBean.class), objemployeeTdsBean.getEmployeeId(), objemployeeTdsBean.getMonth());

						if (checkLopList.size() > 0) {
							int i = jdbcTemplate.update(EmployeeTdsQueryUtil.DELETE_EMPLOYEE_IN_TDS, objemployeeTdsBean.getEmployeeId(), objemployeeTdsBean.getMonth());
						}

					}
					lEmployeeLopBeans.add(objemployeeTdsBean);
				}

			}
			objemployeeTdsBean.setErrorMessage(sErrorCheck);

			if (isValid) {
				exportDataToDB(lEmployeeLopBeans);
				objemployeeTdsBean.setisValid(true);
			}
			return objemployeeTdsBean;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objemployeeTdsBean;
	}

	private void exportDataToDB(ArrayList<EmployeeTdsBean> lEmployeeLopBeans) {
		// TODO Auto-generated method stub
		try {

			List<EmployeeTdsBean> employeeTdsBeansList = new ArrayList<>();

			for (EmployeeTdsBean emploTdsBean : lEmployeeLopBeans) {

				String EMPLOYEE_ID = emploTdsBean.getEmployeeId();
				String MONTH_YEAR = emploTdsBean.getMonth();

				double estimatedAmount = emploTdsBean.getEstimatedTds();
				double actuvalTds = emploTdsBean.getActualTds();
				employeeTdsBeansList = jdbcTemplate.query(EmployeeTdsQueryUtil.CHECK_EMPLOYEE_IN_TDS_XL, new BeanPropertyRowMapper<>(EmployeeTdsBean.class), EMPLOYEE_ID, MONTH_YEAR);
				if (employeeTdsBeansList.size() == 0) {
					if (EMPLOYEE_ID != null && MONTH_YEAR != null && estimatedAmount >= 0 && actuvalTds >= 0) {

						jdbcTemplate.update(EmployeeTdsQueryUtil.INSERT_EMPLOYEE_IN_TDS, new Object[] { EMPLOYEE_ID, MONTH_YEAR, estimatedAmount, actuvalTds });
					}
				} else {
					if (employeeTdsBeansList.size() > 0) {
						if (EMPLOYEE_ID != null && MONTH_YEAR != null && estimatedAmount >= 0 && actuvalTds >= 0) {

							if (estimatedAmount > 0 || actuvalTds > 0) {

								jdbcTemplate.update(EmployeeTdsQueryUtil.UPDATE_EMPLOYEE_TDS_XL, new Object[] { estimatedAmount, actuvalTds, EMPLOYEE_ID, MONTH_YEAR });
							} else {
								if (estimatedAmount == 0 && actuvalTds == 0) {

									jdbcTemplate.update(EmployeeTdsQueryUtil.DELETE_EMPLOYEE_IN_TDS_XL, new Object[] { EMPLOYEE_ID, MONTH_YEAR });
								}
							}

						}

					}
				}

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the Employee Lop table", e);
		}

	}

}