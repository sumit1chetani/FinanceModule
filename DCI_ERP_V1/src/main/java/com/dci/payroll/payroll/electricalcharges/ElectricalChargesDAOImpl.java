package com.dci.payroll.payroll.electricalcharges;

import java.util.ArrayList;
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
import com.dci.payroll.payroll.employeeTds.EmployeeTdsBean;
import com.dci.payroll.payroll.employeelop.EmployeeLopBean;
import com.dci.payroll.payroll.employeelop.EmployeeLopQueryUtil;



@Repository
public class ElectricalChargesDAOImpl implements ElectricalChargesDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ElectricalChargesDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ElectricalChargesBean> getemployeeEBList(String companyId, String branchId, Integer departmentId, String monthYear) throws Exception {
		List<ElectricalChargesBean> lchargesBeans = new ArrayList<ElectricalChargesBean>();
		try {
			lchargesBeans = jdbcTemplate.query(ElectricalChargesQueryUtil.ebList, new BeanPropertyRowMapper<ElectricalChargesBean>(ElectricalChargesBean.class), monthYear, monthYear, companyId, branchId, departmentId, monthYear);

		} catch (DataAccessException e) {
			LOGGER.error("Error in EmployeeLopDAOImpl - getEmployeeLopList ", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return lchargesBeans;

	}

	@Override
	public boolean insertEmployeeEbList(ArrayList<ElectricalChargesBean> chargesBeans) throws Exception {
		boolean isSuccess = false;
		List<ElectricalChargesBean> chargesBeanslist = new ArrayList<ElectricalChargesBean>();
		try {
			Map<String, Object> ebMap = null;
			for (ElectricalChargesBean bean : chargesBeans) {

				ebMap = new HashMap<String, Object>();
				ebMap.put("employeeId", bean.getEmployeeId());
				ebMap.put("monthYear", bean.getMonthYear());
				ebMap.put("monthValue", bean.getMonthValue());
				ebMap.put("units", bean.getUnits());
				ebMap.put("charges", bean.getCharges());
				chargesBeanslist = jdbcTemplate.query(ElectricalChargesQueryUtil.SELECT_EBLIST_ID_MONYR, new BeanPropertyRowMapper<ElectricalChargesBean>(ElectricalChargesBean.class), bean.getEmployeeId(), bean.getMonthValue());
				if (chargesBeanslist.size() == 0) {
					if (bean.getUnits() > 0) {
						namedParameterJdbcTemplate.update(ElectricalChargesQueryUtil.INSERT_EBLIST, ebMap);
					}
				} else {
					if (bean.getUnits() > 0) {
						namedParameterJdbcTemplate.update(ElectricalChargesQueryUtil.UPDATE_EBLIST, ebMap);
					} else {
						if (bean.getUnits() <= 0) {
							namedParameterJdbcTemplate.update(ElectricalChargesQueryUtil.DELETE_EBLIST, ebMap);
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
	public ElectricalChargesBean getChargeValue(Integer units) throws Exception {
		ElectricalChargesBean chargeBean = new ElectricalChargesBean();
		List<ElectricalChargesBean> lchargesBeans = new ArrayList<ElectricalChargesBean>();
		try {
			lchargesBeans = jdbcTemplate.query(ElectricalChargesQueryUtil.GET_CHARGEVALUE, new BeanPropertyRowMapper<ElectricalChargesBean>(ElectricalChargesBean.class), units);
			if (lchargesBeans.size() > 0) {
				for (ElectricalChargesBean bean : lchargesBeans) {
					chargeBean.setCharges(bean.getCharges());
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in EmployeeLopDAOImpl - getEmployeeLopList ", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return chargeBean;

	}

	@Override
	public boolean updatePayComponentList(ArrayList<ElectricalChargesBean> chargesBeans) throws Exception {

		boolean isSuccess = false;
		try {
			List<EmployeeTdsBean> employeeTdsBeansList = new ArrayList<EmployeeTdsBean>();

			Map<String, Object> ebDeclartionMap = null;

			for (ElectricalChargesBean bean : chargesBeans) {

				ebDeclartionMap = new HashMap<String, Object>();

				ebDeclartionMap.put("employee_id", bean.getEmployeeId());
				ebDeclartionMap.put("pay_component_id", "EB");
				ebDeclartionMap.put("month_year", bean.getMonthValue());
				ebDeclartionMap.put("amount", bean.getCharges());
				employeeTdsBeansList = jdbcTemplate.query(ElectricalChargesQueryUtil.CHECK_EMP_PAYCOM_PAID_EXISTS, new BeanPropertyRowMapper<EmployeeTdsBean>(EmployeeTdsBean.class), bean.getEmployeeId(), bean.getMonthValue(), "EB");

				if (employeeTdsBeansList.size() == 0) {

					if (bean.getCharges() > 0) {
						namedParameterJdbcTemplate.update(ElectricalChargesQueryUtil.INSERT_EMP_PAYCOM_PAID, ebDeclartionMap);
					}

				} else {
					if (bean.getCharges() > 0) {
						namedParameterJdbcTemplate.update(ElectricalChargesQueryUtil.UPDATE_EMP_PAYCOM_PAID, ebDeclartionMap);
					} else {
						if (bean.getCharges() <= 0) {
							namedParameterJdbcTemplate.update(ElectricalChargesQueryUtil.DELETE_EMP_PAYCOM, ebDeclartionMap);
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
	public ElectricalChargesBean uploadFile(MultipartFile file) {

		ArrayList<ElectricalChargesBean> lEmployeeLopBeans = new ArrayList<ElectricalChargesBean>();
		List<ElectricalChargesBean> ebList = new ArrayList<ElectricalChargesBean>();
		List<EmployeeLopBean> monthyearList = new ArrayList<EmployeeLopBean>();
		List<ElectricalChargesBean> checkLopList = new ArrayList<ElectricalChargesBean>();
		List<String> empIdList = new ArrayList<String>();
		ElectricalChargesBean chargesBean = null;
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
					chargesBean = new ElectricalChargesBean();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0 && cell.getRowIndex() >= 3) {
								chargesBean.setEmployeeId(cell.getStringCellValue().trim());
								ebList = jdbcTemplate.query(EmployeeLopQueryUtil.CHECK_EMPLOYEE, new BeanPropertyRowMapper<ElectricalChargesBean>(ElectricalChargesBean.class), cell.getStringCellValue().trim());
								if (ebList.size() == 0) {
									isValid = false;
									chargesBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is invalid in row " + cell.getRowIndex() + " ";

								}

								for (String e : empIdList) {
									if (e.equalsIgnoreCase(cell.getStringCellValue().trim())) {
										isValid = false;
										chargesBean.setisValid(false);
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
									chargesBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Month and  year should be current and previous month" + " ";
								}

							}
							break;

						case Cell.CELL_TYPE_NUMERIC:

							if (cell.getColumnIndex() == 2 && cell.getRowIndex() >= 3) {
								Double d = new Double(cell.getNumericCellValue());
								chargesBean.setUnits(d.intValue());
								chargesBean.setMonth(datestring);
							}

							break;

						}

					}
					lEmployeeLopBeans.add(chargesBean);
				}

			}
			chargesBean.setErrorMessage(sErrorCheck);
			if (isValid) {
				exportDataToDB(lEmployeeLopBeans);
				chargesBean.setisValid(true);
			}
			return chargesBean;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return chargesBean;
	}

	private void exportDataToDB(ArrayList<ElectricalChargesBean> lElectricalChargesBeans) {
		// TODO Auto-generated method stub
		try {

			List<ElectricalChargesBean> chargesBeanslist = new ArrayList<ElectricalChargesBean>();

			List<ElectricalChargesBean> getChargeList = new ArrayList<ElectricalChargesBean>();
			Map<String, Object> ebMap = null;
			for (ElectricalChargesBean bean : lElectricalChargesBeans) {

				ebMap = new HashMap<String, Object>();
				ebMap.put("employeeId", bean.getEmployeeId());
				ebMap.put("monthYear", bean.getMonth());
				ebMap.put("monthValue", bean.getMonthValue());

				ebMap.put("units", bean.getUnits());
				getChargeList = jdbcTemplate.query(ElectricalChargesQueryUtil.GET_CHARGEVALUE, new BeanPropertyRowMapper<ElectricalChargesBean>(ElectricalChargesBean.class), bean.getUnits());
				if (getChargeList.size() > 0) {
					for (ElectricalChargesBean besan : getChargeList) {

						bean.setCharges(besan.getCharges());
					}
				}

				chargesBeanslist = jdbcTemplate.query(ElectricalChargesQueryUtil.SELECT_EBXLLIST_ID_MONYR, new BeanPropertyRowMapper<ElectricalChargesBean>(ElectricalChargesBean.class), bean.getEmployeeId(), bean.getMonth());

				if (chargesBeanslist.size() == 0) {

					if (bean.getUnits() > 0) {
						namedParameterJdbcTemplate.update(ElectricalChargesQueryUtil.INSERT_EBLIST, ebMap);
					}
				} else {
					if (bean.getUnits() > 0) {

						namedParameterJdbcTemplate.update(ElectricalChargesQueryUtil.UPDATE_EBLIST, ebMap);
					} else {
						if (bean.getUnits() == 0) {

							namedParameterJdbcTemplate.update(ElectricalChargesQueryUtil.DELETE_EBLIST, ebMap);
						}
					}

				}

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the Employee Lop table", e);
		}

	}
}
