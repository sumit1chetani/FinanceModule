package com.dci.payroll.payroll.employeelop;

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


@Repository
public class EmployeeLopDAOImpl implements EmployeeLopDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeLopDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EmployeeLopBean> getEmployeeLopList(String companyId, String branchId, String dept, String monthYear) throws CustomException {
		List<EmployeeLopBean> empLopList = new ArrayList<EmployeeLopBean>();
		try {
		//	empLopList = jdbcTemplate.query(EmployeeLopQueryUtil.sLopList, new BeanPropertyRowMapper<EmployeeLopBean>(EmployeeLopBean.class), monthYear, monthYear, companyId, branchId, dept, monthYear);
			empLopList = jdbcTemplate.query(EmployeeLopQueryUtil.sLopList, new BeanPropertyRowMapper<EmployeeLopBean>(EmployeeLopBean.class), monthYear, companyId, branchId, dept, monthYear);
			
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in EmployeeLopDAOImpl - getEmployeeLopList ", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return empLopList;
	}

	@Override
	public boolean insertEmployeeLopList(ArrayList<EmployeeLopBean> empLOPBean) throws CustomException {
		boolean isSuccess = false;
		List<EmployeeLopBean> empLopList = new ArrayList<EmployeeLopBean>();
		try {
			Map<String, Object> empLOPMap = null;
			for (EmployeeLopBean empLOP : empLOPBean) {

				empLOPMap = new HashMap<String, Object>();
				empLOPMap.put("employeeId", empLOP.getEmployeeId());
				empLOPMap.put("monthYear", empLOP.getMonthYear());
				empLOPMap.put("days", empLOP.getDays());

				empLopList = jdbcTemplate.query(EmployeeLopQueryUtil.SELECT_LOPLIST_ID_MONYR, new BeanPropertyRowMapper<EmployeeLopBean>(EmployeeLopBean.class), empLOP.getEmployeeId(), empLOP.getMonthYear());
				if (empLopList.size() == 0) {
					if (empLOP.getDays() > 0) {
						namedParameterJdbcTemplate.update(EmployeeLopQueryUtil.INSERT_LOPLIST, empLOPMap);
					}
				} else {
					namedParameterJdbcTemplate.update(EmployeeLopQueryUtil.UPDATE_LOPLIST, empLOPMap);
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
	public EmployeeLopBean uploadFile(MultipartFile file) {

		ArrayList<EmployeeLopBean> lEmployeeLopBeans = new ArrayList<EmployeeLopBean>();
		List<EmployeeLopBean> empLopList = new ArrayList<EmployeeLopBean>();
		List<EmployeeLopBean> monthyearList = new ArrayList<EmployeeLopBean>();
		List<EmployeeLopBean> checkLopList = new ArrayList<EmployeeLopBean>();
		List<String> empIdList = new ArrayList<String>();
		EmployeeLopBean objemployeeLopBean = null;
		Map<String, Object> records = new HashMap<String, Object>();
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
					objemployeeLopBean = new EmployeeLopBean();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0 && cell.getRowIndex() >= 3) {
								objemployeeLopBean.setEmployeeId(cell.getStringCellValue().trim());
								empLopList = jdbcTemplate.query(EmployeeLopQueryUtil.CHECK_EMPLOYEE, new BeanPropertyRowMapper<EmployeeLopBean>(EmployeeLopBean.class), cell.getStringCellValue().trim());
								if (empLopList.size() == 0) {
									isValid = false;
									objemployeeLopBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is invalid in row " + cell.getRowIndex() + " ";

								}

								for (String e : empIdList) {
									if (e.equalsIgnoreCase(cell.getStringCellValue().trim())) {
										isValid = false;
										objemployeeLopBean.setisValid(false);
										sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is repeated in row  " + cell.getRowIndex() + " ";
									}

								}
								empIdList.add(cell.getStringCellValue().trim());

							}
							if (cell.getColumnIndex() == 1 && cell.getRowIndex() == 0) {

								monthyearList = jdbcTemplate.query(EmployeeLopQueryUtil.SELECT_MONTHLIST, new BeanPropertyRowMapper<EmployeeLopBean>(EmployeeLopBean.class));
								datestring = cell.getStringCellValue().trim();
								for (EmployeeLopBean bean : monthyearList) {
									if (bean.getMonthValue().equalsIgnoreCase(cell.getStringCellValue().trim())) {
										isMonthValid = true;
									}
								}
								if (!isMonthValid) {
									isValid = false;
									objemployeeLopBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Month and  year should be current and previous month" + " ";
								}

							}
							break;

						case Cell.CELL_TYPE_NUMERIC:

							if (cell.getColumnIndex() == 2 && cell.getRowIndex() >= 3) {
								objemployeeLopBean.setDays(cell.getNumericCellValue());
								objemployeeLopBean.setMonth(datestring);
							}
							if (cell.getColumnIndex() == 1 && cell.getRowIndex() == 0) {
								Date date1 = cell.getDateCellValue();
								String dateString = date1.toString();

								DateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
								Date date = inputFormat.parse(dateString);
								DateFormat outputFormat1 = new SimpleDateFormat("MMM YYYY");
								datestring = outputFormat1.format(date);
								monthyearList = jdbcTemplate.query(EmployeeLopQueryUtil.SELECT_MONTHLIST, new BeanPropertyRowMapper<EmployeeLopBean>(EmployeeLopBean.class));
								for (EmployeeLopBean bean : monthyearList) {
									if (bean.getMonthValue().equalsIgnoreCase(datestring)) {
										isMonthValid = true;
									}
								}
								if (!isMonthValid) {
									isValid = false;
									objemployeeLopBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Month and  year should be current and previous month" + " ";
								}

								objemployeeLopBean.setMonth(datestring);
							}

							break;

						}

					}
					lEmployeeLopBeans.add(objemployeeLopBean);
				}

			}
			objemployeeLopBean.setErrorMessage(sErrorCheck);
			if (isValid) {
				exportDataToDB(lEmployeeLopBeans);
				objemployeeLopBean.setisValid(true);
			}
			return objemployeeLopBean;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objemployeeLopBean;
	}

	private void exportDataToDB(ArrayList<EmployeeLopBean> lEmployeeLopBeans) {
		// TODO Auto-generated method stub
		try {
			List<EmployeeLopBean> checkLopList = new ArrayList<EmployeeLopBean>();
			for (EmployeeLopBean empLOP : lEmployeeLopBeans) {

				String EMPLOYEE_ID = empLOP.getEmployeeId();
				String MONTH_YEAR = empLOP.getMonth();

				double DAYS = empLOP.getDays();

				checkLopList = jdbcTemplate.query(EmployeeLopQueryUtil.CHECK_EMPLOYEE_IN_LOP, new BeanPropertyRowMapper<EmployeeLopBean>(EmployeeLopBean.class), empLOP.getEmployeeId(), empLOP.getMonth());

				if (checkLopList.size() > 0) {
					if (EMPLOYEE_ID != null && MONTH_YEAR != null && DAYS != 0) {

						jdbcTemplate.update(EmployeeLopQueryUtil.UPDATE_LOPLIST_XL, new Object[] { DAYS, EMPLOYEE_ID, MONTH_YEAR });
					}
				} else {
					if (checkLopList.size() == 0) {
						if (EMPLOYEE_ID != null && MONTH_YEAR != null && DAYS != 0) {
							jdbcTemplate.update(EmployeeLopQueryUtil.INSERT_EMPLOYEE_LOP_UPLOAD, new Object[] { EMPLOYEE_ID, MONTH_YEAR, DAYS });
						}
					}

				}

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the Employee Lop table", e);
		}

	}

}