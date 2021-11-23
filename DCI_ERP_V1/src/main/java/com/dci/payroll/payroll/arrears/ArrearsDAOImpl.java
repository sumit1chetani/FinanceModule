package com.dci.payroll.payroll.arrears;

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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.payroll.payroll.employeelop.EmployeeLopBean;
import com.dci.payroll.payroll.employeelop.EmployeeLopQueryUtil;
import com.dci.tenant.user.UserDetail;


@Repository
public class ArrearsDAOImpl implements ArrearsDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ArrearsDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ArrearsBean> getemployeeArrearList(String companyId, String branchId, Integer departmentId, String monthYear) throws Exception {
		List<ArrearsBean> larrearsBeans = new ArrayList<>();
		try {
			larrearsBeans = jdbcTemplate.query(ArrearsQueryUtil.GET_ARREARS_SALARY_LIST, new BeanPropertyRowMapper<>(ArrearsBean.class), monthYear, monthYear, companyId, branchId, departmentId, monthYear);

		} catch (DataAccessException e) {
			LOGGER.error("Error in ArrearsDAOImpl - ArrearsBean ", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return larrearsBeans;

	}

	@Override
	public boolean insert(ArrayList<ArrearsBean> arrearsBeans) throws Exception {
		boolean isSuccess = false;
		List<ArrearsBean> larrearsList = new ArrayList<>();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			Map<String, Object> ebMap = null;
			for (ArrearsBean bean : arrearsBeans) {

				ebMap = new HashMap<>();
				ebMap.put("employeeId", bean.getEmployeeId());
				ebMap.put("monthYear", bean.getMonthYear());
				ebMap.put("monthValue", bean.getMonthValue());

				ebMap.put("amount", bean.getAmount());
				ebMap.put("createdby", userDetail.getUserId());
				ebMap.put("modifiedby", userDetail.getUserId());
				// System.out.println(ebMap);

				larrearsList = jdbcTemplate.query(ArrearsQueryUtil.SELECT_ARREARSLIST_ID_MONYR, new BeanPropertyRowMapper<>(ArrearsBean.class), bean.getEmployeeId(), bean.getMonthValue());

				// System.out.println("size is" + larrearsList.size());

				if (larrearsList.size() == 0) {
					if (bean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(ArrearsQueryUtil.INSERT_ARREARSLIST, ebMap);
					}
				} else {
					if (bean.getAmount() > 0) {
						// System.out.println("UPDATE");
						namedParameterJdbcTemplate.update(ArrearsQueryUtil.UPDATE_ARREARSLIST, ebMap);
					} else {
						if (bean.getAmount() <= 0) {
							namedParameterJdbcTemplate.update(ArrearsQueryUtil.DELETE_ARREARSLIST, ebMap);
						}
					}

				}

			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertEmployeeLopList", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean updatePayComponentList(ArrayList<ArrearsBean> larrearsBeans) throws Exception {
		boolean isSuccess = false;
		try {
			List<ArrearsBean> employeeArrearBeansList = new ArrayList<>();

			Map<String, Object> arrearBeanMap = null;

			for (ArrearsBean bean : larrearsBeans) {

				arrearBeanMap = new HashMap<>();

				arrearBeanMap.put("employee_id", bean.getEmployeeId());
				arrearBeanMap.put("pay_component_id", "ARRSA");
				arrearBeanMap.put("month_year", bean.getMonthValue());
				arrearBeanMap.put("amount", bean.getAmount());
				arrearBeanMap.put("department_id", bean.getDepartmentId());
				// System.out.println("Map" + employeeTdsBeansList.size());

				// System.out.println(arrearBeanMap);

				employeeArrearBeansList = jdbcTemplate.query(ArrearsQueryUtil.CHECK_EMP_PAYCOM_PAID_EXISTS, new BeanPropertyRowMapper<>(ArrearsBean.class), bean.getEmployeeId(), bean.getMonthValue(), "ARRSA");

				if (employeeArrearBeansList.size() == 0) {

					// System.out.println("Arrear Bean Size is" +
					// employeeArrearBeansList.size());

					if (bean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(ArrearsQueryUtil.INSERT_EMP_PAYCOM_PAID, arrearBeanMap);
					}

				} else {
					if (bean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(ArrearsQueryUtil.UPDATE_EMP_PAYCOM_PAID, arrearBeanMap);
					} else {
						if (bean.getAmount() <= 0) {
							namedParameterJdbcTemplate.update(ArrearsQueryUtil.DELETE_EMP_PAYCOM, arrearBeanMap);
						}
					}

				}

			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTdsDeclarationAdd", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public ArrearsBean uploadFile(MultipartFile file) {
		ArrayList<ArrearsBean> lEmployeeLopBeans = new ArrayList<>();
		List<ArrearsBean> ebList = new ArrayList<>();
		List<EmployeeLopBean> monthyearList = new ArrayList<>();
		List<ArrearsBean> checkLopList = new ArrayList<>();
		List<String> empIdList = new ArrayList<>();
		ArrearsBean arrearBean = null;
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
			} else {
				// System.out.println("Not a valid file format");
			}

			int rowCnt = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowCnt += 1;
				if (rowCnt > 0) {
					Iterator<Cell> cellIterator = row.cellIterator();
					arrearBean = new ArrearsBean();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0 && cell.getRowIndex() >= 3) {
								arrearBean.setEmployeeId(cell.getStringCellValue().trim());
								ebList = jdbcTemplate.query(EmployeeLopQueryUtil.CHECK_EMPLOYEE, new BeanPropertyRowMapper<>(ArrearsBean.class), cell.getStringCellValue().trim());
								if (ebList.size() == 0) {
									isValid = false;
									arrearBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is invalid in row " + cell.getRowIndex() + " ";

								}

								for (String e : empIdList) {
									if (e.equalsIgnoreCase(cell.getStringCellValue().trim())) {
										isValid = false;
										arrearBean.setisValid(false);
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
										bean.setMonth(bean.getMonthYear());
									}
								}

								System.out.println("Column string is" + cell.getStringCellValue() + "DATe STrunb" + datestring);
								if (!isMonthValid) {
									isValid = false;
									arrearBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Month and  year should be current and previous month" + " ";
								}

							}
							break;

						case Cell.CELL_TYPE_NUMERIC:

							if (cell.getColumnIndex() == 2 && cell.getRowIndex() >= 3) {
								System.out.println("Column value is" + cell.getNumericCellValue() + "DATe STrunb" + datestring);
								Double d = new Double(cell.getNumericCellValue());
								arrearBean.setAmount(d.intValue());
								// System.out.println("Column converted is" +
								// chargesBean.getUnits());
								arrearBean.setMonth(datestring);
							}
							if (cell.getColumnIndex() == 1 && cell.getRowIndex() == 0) {
								System.out.println("Insided Date" + cell.getDateCellValue());
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
									arrearBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Month and  year should be current and previous month" + " ";
								}

								arrearBean.setMonth(datestring);

							}

							break;

						}

					}
					lEmployeeLopBeans.add(arrearBean);
				}

			}
			arrearBean.setErrorMessage(sErrorCheck);
			System.out.println("isvAlid" + isValid);
			if (isValid) {
				exportDataToDB(lEmployeeLopBeans);
				arrearBean.setisValid(true);
			}
			return arrearBean;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrearBean;
	}

	private void exportDataToDB(ArrayList<ArrearsBean> lArrearList) {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {

			List<ArrearsBean> chargesBeanslist = new ArrayList<>();

			Map<String, Object> ebMap = null;
			for (ArrearsBean bean : lArrearList) {

				ebMap = new HashMap<>();
				ebMap.put("employeeId", bean.getEmployeeId());
				ebMap.put("monthYear", bean.getMonth());
				ebMap.put("monthValue", bean.getMonthValue());

				ebMap.put("amount", bean.getAmount());
				ebMap.put("createdby", userDetail.getUserId());
				ebMap.put("modifiedby", userDetail.getUserId());

				System.out.println("ebMap" + ebMap);

				chargesBeanslist = jdbcTemplate.query(ArrearsQueryUtil.SELECT_EBXLLIST_ID_MONYR, new BeanPropertyRowMapper<>(ArrearsBean.class), bean.getEmployeeId(), bean.getMonth());

				if (chargesBeanslist.size() == 0) {

					if (bean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(ArrearsQueryUtil.INSERT_ARREARSLIST, ebMap);
					}
				} else {
					if (bean.getAmount() > 0) {

						namedParameterJdbcTemplate.update(ArrearsQueryUtil.UPDATE_ARREARSLIST, ebMap);
					} else {
						if (bean.getAmount() == 0) {

							namedParameterJdbcTemplate.update(ArrearsQueryUtil.DELETE_ARREARSLIST, ebMap);
						}
					}

				}

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the Employee arrears table", e);
		}

	}
}
