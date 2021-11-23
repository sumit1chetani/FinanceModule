package com.dci.payroll.tds.professionaltaxslab;

import java.math.BigDecimal;
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
import com.dci.payroll.payroll.employeelop.EmployeeLopQueryUtil;



@Repository
public class ProfessionalTaxSlabDAOImpl implements ProfessionalTaxSlabDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ProfessionalTaxSlabDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ProfessionalTaxSlabBean> getProfessionalTaxSlabList() throws CustomException {
		List<ProfessionalTaxSlabBean> professionalTaxSlabList = new ArrayList<ProfessionalTaxSlabBean>();
		try {
			professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELECT_PTSLAB_LIST, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class));
			return professionalTaxSlabList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in ProfessionalTaxSlabDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<Map<String, Object>> getProfessionalGenerationListXL(String companyId, String branchId, int departmentId, String financialYear) throws CustomException {
		List<ProfessionalTaxSlabBean> professionalTaxSlabList = new ArrayList<ProfessionalTaxSlabBean>();
		try {
			List<Map<String, Object>> employeePtPayComponent = new ArrayList<Map<String, Object>>();

			Map<String, Object> empComponenetMap = null;

			String employeeId = null;
			String paycomponenetId = "PT";

			if (departmentId == 0) {

				professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELET_EMPLOYEE_PTSLB, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), companyId, branchId, null, employeeId, paycomponenetId, financialYear);
			} else {

				professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELET_EMPLOYEE_PTSLB, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), companyId, branchId, departmentId, employeeId, paycomponenetId, financialYear);
			}

			String tempEmployee = null;
			int i = 1;
			for (ProfessionalTaxSlabBean professionalTaxSlabBean : professionalTaxSlabList) {

				if (tempEmployee == null) {
					tempEmployee = professionalTaxSlabBean.getEmployeeId();
					empComponenetMap = new HashMap<String, Object>();
				}

				if (tempEmployee.equalsIgnoreCase(professionalTaxSlabBean.getEmployeeId())) {

					if (!empComponenetMap.containsKey("employeeId")) {
						empComponenetMap.put("employeeId", professionalTaxSlabBean.getEmployeeId());
					}

					if (!empComponenetMap.containsKey("employeeName")) {
						empComponenetMap.put("employeeName", professionalTaxSlabBean.getEmployeeName());
					}
					if (!empComponenetMap.containsKey("secondamount")) {
						empComponenetMap.put("secondamount", 0.0);
					}

					if (!empComponenetMap.containsKey("firstamount")) {
						empComponenetMap.put("firstamount", professionalTaxSlabBean.getAmount());
					} else {
						empComponenetMap.put("secondamount", professionalTaxSlabBean.getAmount());
					}

					if (professionalTaxSlabList.size() == i) {
						employeePtPayComponent.add(empComponenetMap);
					}

					tempEmployee = professionalTaxSlabBean.getEmployeeId();
				} else {

					employeePtPayComponent.add(empComponenetMap);
					empComponenetMap = new HashMap<String, Object>();

					if (!empComponenetMap.containsKey("employeeId")) {
						empComponenetMap.put("employeeId", professionalTaxSlabBean.getEmployeeId());
					}
					if (!empComponenetMap.containsKey("employeeName")) {
						empComponenetMap.put("employeeName", professionalTaxSlabBean.getEmployeeName());
					}
					if (!empComponenetMap.containsKey("secondamount")) {
						empComponenetMap.put("secondamount", 0.0);
					}
					if (!empComponenetMap.containsKey("firstamount")) {
						empComponenetMap.put("firstamount", professionalTaxSlabBean.getAmount());
					} else {
						empComponenetMap.put("secondamount", professionalTaxSlabBean.getAmount());
					}

					if (professionalTaxSlabList.size() == i) {
						employeePtPayComponent.add(empComponenetMap);
					}

					tempEmployee = professionalTaxSlabBean.getEmployeeId();
				}
				i++;

			}

			return employeePtPayComponent;
		} catch (DataAccessException e) {
			LOGGER.error("Error in ProfessionalTaxSlabDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public PtListDTO getProfessionalGenerationList(String companyId, String branchId, int departmentId, String financialYear) throws CustomException {
		List<ProfessionalTaxSlabBean> professionalTaxSlabList = new ArrayList<ProfessionalTaxSlabBean>();
		try {

			String employeeId = null;
			String paycomponenetId = "PT";

			if (departmentId == 0) {

				professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELET_EMPLOYEE_PTSLB, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), financialYear, companyId, branchId, null, employeeId, paycomponenetId);
			} else {

				professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELET_EMPLOYEE_PTSLB, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), financialYear, companyId, branchId, departmentId, employeeId, paycomponenetId);
			}

			PtSlabDTO dto = new PtSlabDTO();

			PtListDTO ldto = new PtListDTO();

			String tempEmpid = null;

			int i = 1;

			for (ProfessionalTaxSlabBean bean : professionalTaxSlabList) {

				if (tempEmpid == null) {
					tempEmpid = bean.getEmployeeId();
					dto = new PtSlabDTO();
				}
				if (tempEmpid.equals(bean.getEmployeeId())) {
					dto.setEmployeeId(bean.getEmployeeId());
					dto.setEmployeeName(bean.getEmployeeName());
					dto.getDateList().add(bean);
					tempEmpid = bean.getEmployeeId();
					if (professionalTaxSlabList.size() == i) {
						ldto.getEmplList().add(dto);
					}

				} else {
					ldto.getEmplList().add(dto);
					dto = new PtSlabDTO();
					dto.getDateList().add(bean);
					tempEmpid = bean.getEmployeeId();

				}
				i++;
			}

			return ldto;
		} catch (DataAccessException e) {
			LOGGER.error("Error in ProfessionalTaxSlabDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public PtListDTO getTypeList(String companyId, String branchId, String dept, String typeId, String financialYear) throws CustomException {
		List<ProfessionalTaxSlabBean> professionalTaxSlabList = new ArrayList<ProfessionalTaxSlabBean>();
		try {

			String employeeId = null;
			String paycomponenetId = typeId;

			if (dept == "") {

				professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELET_EMPLOYEE_PTSLB, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), financialYear, companyId, branchId, null, employeeId, paycomponenetId);
			} else {

				professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELET_EMPLOYEE_PTSLB, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), financialYear, companyId, branchId, dept, employeeId, paycomponenetId);
			}

			PtSlabDTO dto = new PtSlabDTO();

			PtListDTO ldto = new PtListDTO();

			String tempEmpid = null;

			int i = 1;

			for (ProfessionalTaxSlabBean bean : professionalTaxSlabList) {

				if (tempEmpid == null) {
					tempEmpid = bean.getEmployeeId();
					dto = new PtSlabDTO();
				}
				if (tempEmpid.equals(bean.getEmployeeId())) {
					dto.setEmployeeId(bean.getEmployeeId());
					dto.setEmployeeName(bean.getEmployeeName());
					dto.getDateList().add(bean);
					tempEmpid = bean.getEmployeeId();
					if (professionalTaxSlabList.size() == i) {
						ldto.getEmplList().add(dto);
					}

				} else {
					ldto.getEmplList().add(dto);
					dto = new PtSlabDTO();
					dto.getDateList().add(bean);
					tempEmpid = bean.getEmployeeId();

				}
				i++;
			}

			return ldto;
		} catch (DataAccessException e) {
			LOGGER.error("Error in ProfessionalTaxSlabDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertPtSlab(ProfessionalTaxSlabBean professionalTaxSlabBean) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		String autoGenTrnSchId = "";
		try {
			Map<String, Object> professionalMap = new HashMap<String, Object>();

			professionalMap.put("branch_id", professionalTaxSlabBean.getBranchId());
			professionalMap.put("range_from", professionalTaxSlabBean.getRangeFrom());
			professionalMap.put("range_to", professionalTaxSlabBean.getRangeTo());
			professionalMap.put("charge", professionalTaxSlabBean.getCharge());
			professionalMap.put("financial_year", professionalTaxSlabBean.getFinancialYear());
			namedParameterJdbcTemplate.update(ProfessionalTaxSlabQueryUtil.INSERT_PTSLAB, professionalMap);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in insertDesignation", e.getMessage());
			throw new CustomException("Tax Section Name '" + professionalTaxSlabBean.getBranchId() + "' already exists.");
		}
		return isSuccess;
	}

	@Override
	public ProfessionalTaxSlabBean getPtSlabById(String branchId, String financialYear, BigDecimal rangeFrom) throws CustomException {
		ProfessionalTaxSlabBean professionalTaxSlabBean = new ProfessionalTaxSlabBean();
		try {

			Object[] params = new Object[] { branchId };

			Map row = jdbcTemplate.queryForMap(ProfessionalTaxSlabQueryUtil.SELECT_PTSLABENTRYBYID, branchId, financialYear, rangeFrom);

			if (row.get("branch_id") != null) {
				professionalTaxSlabBean.setBranchId((String) row.get("branch_id"));

			}
			if (row.get("branch_name") != null) {
				professionalTaxSlabBean.setBranchName((String) row.get("branch_name"));

			}
			if (row.get("range_from") != null) {
				professionalTaxSlabBean.setRangeFrom((BigDecimal) row.get("range_from"));
			}
			if (row.get("range_to") != null) {
				professionalTaxSlabBean.setRangeTo((BigDecimal) row.get("range_to"));
			}
			if (row.get("charge") != null) {
				professionalTaxSlabBean.setCharge((BigDecimal) row.get("charge"));
			}
			if (row.get("financial_year") != null) {
				professionalTaxSlabBean.setFinancialYear((String) row.get("financial_year"));
			}

			professionalTaxSlabBean.setisEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLoanEntryId", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		return professionalTaxSlabBean;
	}

	@Override
	public boolean updatePTSlab(ProfessionalTaxSlabBean professionalTaxSlabBean) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {
			Map<String, Object> professionalMap = new HashMap<String, Object>();

			professionalMap.put("branch_id", professionalTaxSlabBean.getBranchId());

			professionalMap.put("range_from", professionalTaxSlabBean.getRangeFrom());
			professionalMap.put("range_to", professionalTaxSlabBean.getRangeTo());
			professionalMap.put("charge", professionalTaxSlabBean.getCharge());
			professionalMap.put("financial_year", professionalTaxSlabBean.getFinancialYear());

			namedParameterJdbcTemplate.update(ProfessionalTaxSlabQueryUtil.UPDATE_PTSLAB, professionalMap);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public List<ProfessionalTaxSlabBean> getFinancialYear(String companyId) throws CustomException {
		List<ProfessionalTaxSlabBean> professionalTaxSlabBeans = new ArrayList<ProfessionalTaxSlabBean>();
		try {
			professionalTaxSlabBeans = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELECT_FINANCIAL_YEAR_LIST, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), companyId, true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return professionalTaxSlabBeans;

	}

	@Override
	public List<ProfessionalTaxSlabBean> getLoginfinancialYear(String companyId) throws CustomException {
		List<ProfessionalTaxSlabBean> professionalTaxSlabBeans = new ArrayList<ProfessionalTaxSlabBean>();
		try {
			professionalTaxSlabBeans = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELECT_FINANCIAL_YEAR_LIST, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), companyId, true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return professionalTaxSlabBeans;

	}

	@Override
	public List<ProfessionalTaxSlabBean> getFinancialYearList() throws CustomException {
		List<ProfessionalTaxSlabBean> professionalTaxSlabBeans = new ArrayList<ProfessionalTaxSlabBean>();
		try {

			professionalTaxSlabBeans = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELECT_FINANCIAL_YEAR_BYID, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return professionalTaxSlabBeans;

	}

	@Override
	public boolean deletePTSlab(String branchId, String financialYear, BigDecimal rangeFrom) throws CustomException {
		boolean isSuccess = false;
		int val = 1;
		try {
			val = jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.DELETE_PTSLAB, branchId, financialYear, rangeFrom);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteBranch", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public ProfessionalTaxSlabBean uploadFile(MultipartFile file) {

		ArrayList<ProfessionalTaxSlabBean> lProfessionalTaxSlabBeans = new ArrayList<ProfessionalTaxSlabBean>();
		List<ProfessionalTaxSlabBean> empPtSlabList = new ArrayList<ProfessionalTaxSlabBean>();
		List<ProfessionalTaxSlabBean> monthyearList = new ArrayList<ProfessionalTaxSlabBean>();

		List<ProfessionalTaxSlabBean> checkempPtSlabList = new ArrayList<ProfessionalTaxSlabBean>();

		List<String> empIdList = new ArrayList<String>();
		ProfessionalTaxSlabBean professionalTaxSlabBean = null;
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
			} else {
			}

			int rowCnt = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowCnt += 1;
				if (rowCnt > 0) {
					Iterator<Cell> cellIterator = row.cellIterator();
					professionalTaxSlabBean = new ProfessionalTaxSlabBean();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:

							if (cell.getColumnIndex() == 0 && cell.getRowIndex() >= 3) {
								professionalTaxSlabBean.setEmployeeId(cell.getStringCellValue().trim());

								empPtSlabList = jdbcTemplate.query(EmployeeLopQueryUtil.CHECK_EMPLOYEE, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), cell.getStringCellValue().trim());

								if (empPtSlabList.size() == 0) {
									isValid = false;
									professionalTaxSlabBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is invalid in row " + cell.getRowIndex() + " ";

								}

								for (String e : empIdList) {
									if (e.equalsIgnoreCase(cell.getStringCellValue().trim())) {
										isValid = false;
										professionalTaxSlabBean.setisValid(false);
										sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is repeated in row  " + cell.getRowIndex() + " ";
									}

								}
								empIdList.add(cell.getStringCellValue().trim());

							}
							if (cell.getColumnIndex() == 1 && cell.getRowIndex() == 0) {

								monthyearList = jdbcTemplate.query(EmployeeLopQueryUtil.SELECT_MONTHLIST, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class));
								datestring = cell.getStringCellValue().trim();
								for (ProfessionalTaxSlabBean bean : monthyearList) {
									if (bean.getMonthValue().equalsIgnoreCase(cell.getStringCellValue().trim())) {
										isMonthValid = true;
									}
								}
								if (!isMonthValid) {
									isValid = false;
									professionalTaxSlabBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Month and  year should be current and previous month" + " ";
								}

							}
							break;

						case Cell.CELL_TYPE_NUMERIC:

							if (cell.getColumnIndex() == 2 && cell.getRowIndex() >= 3) {

								professionalTaxSlabBean.setAmount(cell.getNumericCellValue());

								professionalTaxSlabBean.setMonth(datestring);
							}
							if (cell.getColumnIndex() == 1 && cell.getRowIndex() == 0) {

								Date date1 = cell.getDateCellValue();
								String dateString = date1.toString();

								DateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
								Date date = inputFormat.parse(dateString);
								DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
								DateFormat outputFormat1 = new SimpleDateFormat("MMM YYYY");
								String datestr1 = outputFormat.format(date);
								datestring = outputFormat1.format(date);
								monthyearList = jdbcTemplate.query(EmployeeLopQueryUtil.SELECT_MONTHLIST, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class));
								for (ProfessionalTaxSlabBean bean : monthyearList) {
									if (bean.getMonthValue().equalsIgnoreCase(datestring)) {
										isMonthValid = true;
									}
								}
								if (!isMonthValid) {
									isValid = false;
									professionalTaxSlabBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Month and  year should be current and previous month" + " ";
								}

								professionalTaxSlabBean.setMonth(datestring);

							}

							break;

						}

					}
					lProfessionalTaxSlabBeans.add(professionalTaxSlabBean);
				}

			}
			professionalTaxSlabBean.setErrorMessage(sErrorCheck);
			if (isValid) {
				exportDataToDB(lProfessionalTaxSlabBeans);
				professionalTaxSlabBean.setisValid(true);
			}
			return professionalTaxSlabBean;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return professionalTaxSlabBean;

	}

	private void exportDataToDB(ArrayList<ProfessionalTaxSlabBean> lProfessionalTaxSlab) {
		// TODO Auto-generated method stub
		try {
			List<ProfessionalTaxSlabBean> professionalTaxSlabList = new ArrayList<ProfessionalTaxSlabBean>();
			for (ProfessionalTaxSlabBean objProfessionalTaxSlabBean : lProfessionalTaxSlab) {
				String EMPLOYEE_ID = objProfessionalTaxSlabBean.getEmployeeId();

				double AMOUNT = objProfessionalTaxSlabBean.getAmount();

				String MONTH_YEAR = objProfessionalTaxSlabBean.getMonth();

				professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELECT_PTSLAB_BY_ID, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), EMPLOYEE_ID, "PT", MONTH_YEAR);
				if (professionalTaxSlabList.size() == 0) {
					if (EMPLOYEE_ID != null && MONTH_YEAR != null && AMOUNT != 0) {

						jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.INSERT_SALARY, new Object[] { EMPLOYEE_ID, "PT", AMOUNT, MONTH_YEAR });
					}
				} else {
					if (professionalTaxSlabList.size() > 0) {
						if (EMPLOYEE_ID != null && MONTH_YEAR != null && AMOUNT >= 0) {

							if (AMOUNT > 0) {

								jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.UPDATE_SALARY, new Object[] { AMOUNT, EMPLOYEE_ID, "PT", MONTH_YEAR });
							} else {
								if (AMOUNT == 0) {

									jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.DELETE_SALARY, new Object[] { EMPLOYEE_ID, "PT", MONTH_YEAR });
								}
							}

						}

					}
				}

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the department table", e);
		}

	}

	@Override
	public boolean insertEmployeePTList(ArrayList<ProfessionalTaxSlabBean> lProfessionalTaxSlab) throws Exception {
		boolean isScucess = false;
		try {
			List<ProfessionalTaxSlabBean> professionalTaxSlabList = new ArrayList<ProfessionalTaxSlabBean>();
			for (ProfessionalTaxSlabBean objProfessionalTaxSlabBean : lProfessionalTaxSlab) {
				String EMPLOYEE_ID = objProfessionalTaxSlabBean.getEmployeeId();

				double AMOUNT = objProfessionalTaxSlabBean.getAmount();

				String MONTH_YEAR = objProfessionalTaxSlabBean.getMonthYear();

				professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELECT_PTSLAB, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), EMPLOYEE_ID, "PT", MONTH_YEAR);
				isScucess = true;
				if (professionalTaxSlabList.size() == 0) {
					if (EMPLOYEE_ID != null && MONTH_YEAR != null && AMOUNT != 0) {

						jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.INSERT_PT_SALARY, new Object[] { EMPLOYEE_ID, "PT", AMOUNT, MONTH_YEAR });
					}
				} else {
					if (professionalTaxSlabList.size() > 0) {
						if (EMPLOYEE_ID != null && MONTH_YEAR != null && AMOUNT >= 0) {

							if (AMOUNT > 0) {

								jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.UPDATE_PT_SALARY, new Object[] { AMOUNT, EMPLOYEE_ID, "PT", MONTH_YEAR });
							} else {
								if (AMOUNT == 0) {

									jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.DELETE_PT_SALARY, new Object[] { EMPLOYEE_ID, "PT", MONTH_YEAR });
								}
							}

						}

					}
				}

			}
			isScucess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the department table", e);
		}
		return isScucess;
	}

	@Override
	public boolean insertEmployeeDeductionList(ArrayList<ProfessionalTaxSlabBean> empLOPBean) throws Exception {
		boolean isScucess = false;
		try {
			List<ProfessionalTaxSlabBean> professionalTaxSlabList = new ArrayList<ProfessionalTaxSlabBean>();
			for (ProfessionalTaxSlabBean objProfessionalTaxSlabBean : empLOPBean) {
				String EMPLOYEE_ID = objProfessionalTaxSlabBean.getEmployeeId();

				double AMOUNT = objProfessionalTaxSlabBean.getAmount();

				String MONTH_YEAR = objProfessionalTaxSlabBean.getMonthYear();

				String typeId = objProfessionalTaxSlabBean.getTypeId();

				professionalTaxSlabList = jdbcTemplate.query(ProfessionalTaxSlabQueryUtil.SELECT_PTSLAB, new BeanPropertyRowMapper<ProfessionalTaxSlabBean>(ProfessionalTaxSlabBean.class), EMPLOYEE_ID, typeId, MONTH_YEAR);
				isScucess = true;
				if (professionalTaxSlabList.size() == 0) {
					if (EMPLOYEE_ID != null && MONTH_YEAR != null && AMOUNT != 0 && typeId != null) {

						jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.INSERT_PT_SALARY, new Object[] { EMPLOYEE_ID, typeId, AMOUNT, MONTH_YEAR });
					}
				} else {
					if (professionalTaxSlabList.size() > 0) {
						if (EMPLOYEE_ID != null && MONTH_YEAR != null && AMOUNT >= 0 && typeId != null) {

							if (AMOUNT > 0) {

								jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.UPDATE_PT_SALARY, new Object[] { AMOUNT, EMPLOYEE_ID, typeId, MONTH_YEAR });
							} else {
								if (AMOUNT == 0) {

									jdbcTemplate.update(ProfessionalTaxSlabQueryUtil.DELETE_PT_SALARY, new Object[] { EMPLOYEE_ID, typeId, MONTH_YEAR });
								}
							}

						}

					}
				}

			}
			isScucess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the department table", e);
		}
		return isScucess;
	}
}