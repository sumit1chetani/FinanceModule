package com.dci.payroll.payroll.employeepaycomponent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jxls.common.Context;
import org.jxls.template.SimpleExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.payroll.payroll.employeelop.EmployeeLopBean;

import jxl.write.WritableWorkbook;

@Repository
public class EmployeePayComponentDAOImpl implements EmployeePayComponentDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeePayComponentDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	@Value("${folder.path.localPath}")
	private String localPath;
	@Value("${folder.path.serverPath}")
	private String server;

	@Override
	public List<Map<String, Object>> getEmployeePayComponentList(String employeeId) throws CustomException {
		List<EmployeePayComponentBean> empPayComList = new ArrayList<>();
		try {
			// Define Arraylist
			List<Map<String, Object>> employeePayComponenetList = new ArrayList<>();
			// Define Map
			Map<String, Object> empComponenetMap = null;

			String empId = employeeId;

			empPayComList = jdbcTemplate.query(EmployeePayComponentQueryUtil.selectEmpComponentList, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class), empId);

			String tempDate = null;
			int i = 1;

			for (EmployeePayComponentBean empPayComp : empPayComList) {

				if (tempDate == null) {

					tempDate = empPayComp.getFromdate();
					empComponenetMap = new HashMap<>();
				}

				if ((tempDate).equals(empPayComp.getFromdate())) {

					if (empComponenetMap.containsKey("fromdate")) {
					} else {
						empComponenetMap.put("fromdate", empPayComp.getFromdate());
						empComponenetMap.put("departmentId", empPayComp.getDepartmentId());
						empComponenetMap.put("departmentName", empPayComp.getDepartmentName());
						empComponenetMap.put("employeeId", empPayComp.getEmployeeId());
						empComponenetMap.put("employeeName", empPayComp.getEmployeeName());
					}

					if (("BASIC").equals(empPayComp.getPayComponentId()) || ("DA").equals(empPayComp.getPayComponentId()) || ("HRA").equals(empPayComp.getPayComponentId()) || ("MEDIC").equals(empPayComp.getPayComponentId()) || ("CONVE").equals(empPayComp.getPayComponentId()) || ("SPL").equals(empPayComp.getPayComponentId()) || ("CONS").equals(empPayComp.getPayComponentId()) ||

							("WF").equals(empPayComp.getPayComponentId()) || ("PFSEL").equals(empPayComp.getPayComponentId()) || ("OTDED").equals(empPayComp.getPayComponentId()) || ("OTEAR").equals(empPayComp.getPayComponentId()) || ("GROSS").equals(empPayComp.getPayComponentId()) || ("NET").equals(empPayComp.getPayComponentId())) {

						empComponenetMap.put(empPayComp.getPayComponentId(), empPayComp.getAmount());
					}
					if (empPayComList.size() == i) {
						employeePayComponenetList.add(empComponenetMap);
					}

					tempDate = empPayComp.getFromdate();

				} else {

					employeePayComponenetList.add(empComponenetMap);
					empComponenetMap = new HashMap<>();

					if (("BASIC").equals(empPayComp.getPayComponentId()) || ("DA").equals(empPayComp.getPayComponentId()) || ("HRA").equals(empPayComp.getPayComponentId()) || ("MEDIC").equals(empPayComp.getPayComponentId()) || ("CONVE").equals(empPayComp.getPayComponentId()) || ("SPL").equals(empPayComp.getPayComponentId()) ||

							("CONS").equals(empPayComp.getPayComponentId()) || ("WF").equals(empPayComp.getPayComponentId()) || ("PFSEL").equals(empPayComp.getPayComponentId()) || ("OTDED").equals(empPayComp.getPayComponentId()) || ("OTEAR").equals(empPayComp.getPayComponentId()) || ("GROSS").equals(empPayComp.getPayComponentId()) || ("NET").equals(empPayComp.getPayComponentId())) {

						empComponenetMap.put(empPayComp.getPayComponentId(), empPayComp.getAmount());

					}
					tempDate = empPayComp.getFromdate();

				}
				i++;

			}

			for (Map rmp : employeePayComponenetList) {
				rmp.get(empComponenetMap);
			}

			return employeePayComponenetList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeePayComponent List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<Map<String, Object>> getEmployeePayComponentList1() throws CustomException {
		List<EmployeePayComponentBean> empPayComList = new ArrayList<>();
		try {
			// Define Arraylist
			List<Map<String, Object>> employeePayComponenetList = new ArrayList<>();
			// Define Map
			Map<String, Object> empComponenetMap = null;

			empPayComList = jdbcTemplate.query(EmployeePayComponentQueryUtil.selectEmpComponentList1, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class));

			String tempDate = null;
			int i = 1;

			for (EmployeePayComponentBean empPayComp : empPayComList) {

				if (tempDate == null) {

					tempDate = empPayComp.getEmployeeId();
					// tempDate = empPayComp.getFromdate();
					empComponenetMap = new HashMap<>();
				}

				if ((tempDate).equals(empPayComp.getEmployeeId())) {

					// if ((tempDate).equals(empPayComp.getFromdate())) {

					if (empComponenetMap.containsKey("fromdate")) {
					} else {
						empComponenetMap.put("fromdate", empPayComp.getFromdate());
						empComponenetMap.put("departmentId", empPayComp.getDepartmentId());
						empComponenetMap.put("departmentName", empPayComp.getDepartmentName());
						empComponenetMap.put("employeeId", empPayComp.getEmployeeId());
						empComponenetMap.put("employeeName", empPayComp.getEmployeeName());
					}

					if (("BASIC").equals(empPayComp.getPayComponentId()) || ("DA").equals(empPayComp.getPayComponentId()) || ("HRA").equals(empPayComp.getPayComponentId()) || ("MEDIC").equals(empPayComp.getPayComponentId()) || ("CONVE").equals(empPayComp.getPayComponentId()) || ("SPL").equals(empPayComp.getPayComponentId()) || ("CONS").equals(empPayComp.getPayComponentId()) || ("WF").equals(empPayComp.getPayComponentId()) || ("PFSEL").equals(empPayComp.getPayComponentId()) || ("OTDED").equals(empPayComp.getPayComponentId())
							|| ("OTEAR").equals(empPayComp.getPayComponentId()) || ("GROSS").equals(empPayComp.getPayComponentId()) || ("NET").equals(empPayComp.getPayComponentId())) {

						empComponenetMap.put(empPayComp.getPayComponentId(), empPayComp.getAmount());
					}
					if (empPayComList.size() == i) {
						employeePayComponenetList.add(empComponenetMap);
					}
					tempDate = empPayComp.getEmployeeId();

					// tempDate = empPayComp.getFromdate();

				} else {

					employeePayComponenetList.add(empComponenetMap);
					empComponenetMap = new HashMap<>();

					if (("BASIC").equals(empPayComp.getPayComponentId()) || ("DA").equals(empPayComp.getPayComponentId()) || ("HRA").equals(empPayComp.getPayComponentId()) || ("MEDIC").equals(empPayComp.getPayComponentId()) || ("CONVE").equals(empPayComp.getPayComponentId()) || ("SPL").equals(empPayComp.getPayComponentId()) || ("CONS").equals(empPayComp.getPayComponentId()) ||

							("WF").equals(empPayComp.getPayComponentId()) || ("PFSEL").equals(empPayComp.getPayComponentId()) || ("OTDED").equals(empPayComp.getPayComponentId()) || ("OTEAR").equals(empPayComp.getPayComponentId()) || ("GROSS").equals(empPayComp.getPayComponentId()) || ("NET").equals(empPayComp.getPayComponentId())) {

						empComponenetMap.put(empPayComp.getPayComponentId(), empPayComp.getAmount());

					}
					tempDate = empPayComp.getEmployeeId();

					// tempDate = empPayComp.getFromdate();

				}
				i++;

			}

			for (Map rmp : employeePayComponenetList) {
				rmp.get(empComponenetMap);
			}

			return employeePayComponenetList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeePayComponent List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<Map<String, Object>> getEmployeePayComponentList2(String departmentId) throws CustomException {
		List<EmployeePayComponentBean> empPayComList = new ArrayList<>();
		try {
			// Define Arraylist
			List<Map<String, Object>> employeePayComponenetList = new ArrayList<>();
			// Define Map
			Map<String, Object> empComponenetMap = null;

			empPayComList = jdbcTemplate.query(EmployeePayComponentQueryUtil.selectEmpComponentList2, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class), departmentId);

			String tempDate = null;
			int i = 1;

			for (EmployeePayComponentBean empPayComp : empPayComList) {

				if (tempDate == null) {

					tempDate = empPayComp.getEmployeeId();
					empComponenetMap = new HashMap<>();
				}

				if ((tempDate).equals(empPayComp.getEmployeeId())) {

					if (empComponenetMap.containsKey("fromdate")) {
					} else {
						empComponenetMap.put("fromdate", empPayComp.getFromdate());
						empComponenetMap.put("departmentId", empPayComp.getDepartmentId());
						empComponenetMap.put("departmentName", empPayComp.getDepartmentName());
						empComponenetMap.put("employeeId", empPayComp.getEmployeeId());
						empComponenetMap.put("employeeName", empPayComp.getEmployeeName());
					}

					if (("BASIC").equals(empPayComp.getPayComponentId()) || ("DA").equals(empPayComp.getPayComponentId()) || ("HRA").equals(empPayComp.getPayComponentId()) || ("MEDIC").equals(empPayComp.getPayComponentId()) || ("CONVE").equals(empPayComp.getPayComponentId()) || ("SPL").equals(empPayComp.getPayComponentId()) || ("CONS").equals(empPayComp.getPayComponentId()) || ("WF").equals(empPayComp.getPayComponentId()) || ("PFSEL").equals(empPayComp.getPayComponentId()) || ("OTDED").equals(empPayComp.getPayComponentId())
							|| ("OTEAR").equals(empPayComp.getPayComponentId()) || ("GROSS").equals(empPayComp.getPayComponentId()) || ("NET").equals(empPayComp.getPayComponentId())) {

						empComponenetMap.put(empPayComp.getPayComponentId(), empPayComp.getAmount());
					}
					if (empPayComList.size() == i) {
						employeePayComponenetList.add(empComponenetMap);
					}

					tempDate = empPayComp.getEmployeeId();

				} else {

					employeePayComponenetList.add(empComponenetMap);
					empComponenetMap = new HashMap<>();

					if (("BASIC").equals(empPayComp.getPayComponentId()) || ("DA").equals(empPayComp.getPayComponentId()) || ("HRA").equals(empPayComp.getPayComponentId()) || ("MEDIC").equals(empPayComp.getPayComponentId()) || ("CONVE").equals(empPayComp.getPayComponentId()) || ("SPL").equals(empPayComp.getPayComponentId()) || ("CONS").equals(empPayComp.getPayComponentId()) ||

							("WF").equals(empPayComp.getPayComponentId()) || ("PFSEL").equals(empPayComp.getPayComponentId()) || ("OTDED").equals(empPayComp.getPayComponentId()) || ("OTEAR").equals(empPayComp.getPayComponentId()) || ("GROSS").equals(empPayComp.getPayComponentId()) || ("NET").equals(empPayComp.getPayComponentId())) {

						empComponenetMap.put(empPayComp.getPayComponentId(), empPayComp.getAmount());

					}
					tempDate = empPayComp.getEmployeeId();

				}
				i++;

			}

			for (Map rmp : employeePayComponenetList) {
				rmp.get(empComponenetMap);
			}

			return employeePayComponenetList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeePayComponent List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<Map<String, Object>> getEmployeePayComponentList3(String employeeId) throws CustomException {
		List<EmployeePayComponentBean> empPayComList = new ArrayList<>();
		try {
			// Define Arraylist
			List<Map<String, Object>> employeePayComponenetList = new ArrayList<>();
			// Define Map
			Map<String, Object> empComponenetMap = null;

			String empId = employeeId;

			empPayComList = jdbcTemplate.query(EmployeePayComponentQueryUtil.selectEmpComponentList3, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class), empId, empId);

			String tempDate = null;
			int i = 1;

			for (EmployeePayComponentBean empPayComp : empPayComList) {

				/*
				 * if (empPayComp.getEmployeeId() != "" &&
				 * empPayComp.getFromdate() != "") { String sql =
				 * "select count(*) from employee_pay_component_paid where employee_id = '"
				 * + empPayComp.getEmployeeId() + "'  and  month_year= '" +
				 * empPayComp.getFromdate() + "'"; int count =
				 * jdbcTemplate.queryForInt(sql); if (count == 0) {
				 * 
				 * empPayComp.setCheck(true);
				 * 
				 * } else { empPayComp.setCheck(false);
				 * 
				 * } }
				 */

				if (tempDate == null) {

					tempDate = empPayComp.getFromdate();
					empComponenetMap = new HashMap<>();
				}

				if ((tempDate).equals(empPayComp.getFromdate())) {

					if (empComponenetMap.containsKey("fromdate")) {
					} else {
						empComponenetMap.put("fromdate", empPayComp.getFromdate());
					}

					if (("BASIC").equals(empPayComp.getPayComponentId()) || ("DA").equals(empPayComp.getPayComponentId()) || ("HRA").equals(empPayComp.getPayComponentId()) || ("MEDIC").equals(empPayComp.getPayComponentId()) || ("CONVE").equals(empPayComp.getPayComponentId()) || ("SPL").equals(empPayComp.getPayComponentId()) || ("CONS").equals(empPayComp.getPayComponentId()) || ("WF").equals(empPayComp.getPayComponentId()) || ("PFSEL").equals(empPayComp.getPayComponentId()) || ("OTDED").equals(empPayComp.getPayComponentId())
							|| ("OTEAR").equals(empPayComp.getPayComponentId()) || ("GROSS").equals(empPayComp.getPayComponentId()) || ("NET").equals(empPayComp.getPayComponentId())) {

						empComponenetMap.put(empPayComp.getPayComponentId(), empPayComp.getAmount());
					}
					if (empPayComList.size() == i) {
						employeePayComponenetList.add(empComponenetMap);
					}

					tempDate = empPayComp.getFromdate();

				} else {

					employeePayComponenetList.add(empComponenetMap);
					empComponenetMap = new HashMap<>();

					if (("BASIC").equals(empPayComp.getPayComponentId()) || ("DA").equals(empPayComp.getPayComponentId()) || ("HRA").equals(empPayComp.getPayComponentId()) || ("MEDIC").equals(empPayComp.getPayComponentId()) || ("CONVE").equals(empPayComp.getPayComponentId()) || ("SPL").equals(empPayComp.getPayComponentId()) || ("CONS").equals(empPayComp.getPayComponentId()) ||

							("WF").equals(empPayComp.getPayComponentId()) || ("PFSEL").equals(empPayComp.getPayComponentId()) || ("OTDED").equals(empPayComp.getPayComponentId()) || ("OTEAR").equals(empPayComp.getPayComponentId()) || ("GROSS").equals(empPayComp.getPayComponentId()) || ("NET").equals(empPayComp.getPayComponentId())) {

						empComponenetMap.put(empPayComp.getPayComponentId(), empPayComp.getAmount());

					}
					tempDate = empPayComp.getFromdate();

				}
				i++;

			}

			for (Map rmp : employeePayComponenetList) {
				rmp.get(empComponenetMap);
			}

			return employeePayComponenetList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeePayComponent List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<EmployeePayComponentBean> getListByIdDate(String employeeId, String fromDate) throws CustomException {
		List<EmployeePayComponentBean> empPayComList = new ArrayList<>();
		try {

			empPayComList = jdbcTemplate.query(EmployeePayComponentQueryUtil.sEmpPayCombyIdDate, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class), employeeId, fromDate, employeeId);

			return empPayComList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeePayComponent List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertEmployeePayComponent(ArrayList<EmployeePayComponentBean> empPayComBean) throws CustomException {
		boolean isSuccess = false;
		try {
			Map<String, Object> empPayComMap = null;

			for (EmployeePayComponentBean empbean : empPayComBean) {

				empPayComMap = new HashMap<>();
				empPayComMap.put("employeeId", empbean.getEmployeeId());
				empPayComMap.put("fromDate", empbean.getFromdate());
				empPayComMap.put("payComponentId", empbean.getPayComponentId());
				empPayComMap.put("amount", empbean.getAmount());

				boolean arrearFlag = false;

				if (empbean.getArrears() == "true") {
					arrearFlag = true;

				} else if (empbean.getArrears() == "false") {
					arrearFlag = false;

				}
				empPayComMap.put("arrears", arrearFlag);
				if (empbean.getArrearsStartDate() != null) {

					if (empbean.getArrearsStartDate().isEmpty()) {
						empPayComMap.put("arrearsStartDate", null);

					} else {
						empPayComMap.put("arrearsStartDate", empbean.getArrearsStartDate());
					}

				} else {
					empPayComMap.put("arrearsStartDate", empbean.getArrearsStartDate());
				}
				// empPayComMap.put("toDate", empbean.getTodate());
				if (empbean.getAmount() > 0) {
					namedParameterJdbcTemplate.update(EmployeePayComponentQueryUtil.insertEmpPayCom, empPayComMap);
				}

			}

			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertEmployeePayComponent", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean updateEmployeePayComponent(ArrayList<EmployeePayComponentBean> empPayComBean) throws CustomException {
		boolean isSuccess = false;
		List<EmployeePayComponentBean> empPayComList = new ArrayList<>();
		try {
			Map<String, Object> empPayComMap = null;

			for (EmployeePayComponentBean empbean : empPayComBean) {
				empPayComMap = new HashMap<>();
				empPayComMap.put("employeeId", empbean.getEmployeeId());
				empPayComMap.put("fromDate", empbean.getFromdate());
				empPayComMap.put("payComponentId", empbean.getPayComponentId());
				empPayComMap.put("amount", empbean.getAmount());

				System.out.println("test"+ empbean.getAmount());
				boolean arrearFlag = false;

				if (empbean.getArrears() == "true") {
					arrearFlag = true;

				} else if (empbean.getArrears() == "false") {
					arrearFlag = false;

				}
				empPayComMap.put("arrears", arrearFlag);
				if (empbean.getArrearsStartDate() != null) {

					if (empbean.getArrearsStartDate().isEmpty()) {
						empPayComMap.put("arrearsStartDate", null);

					} else {
						empPayComMap.put("arrearsStartDate", empbean.getArrearsStartDate());
					}

				} else {
					empPayComMap.put("arrearsStartDate", empbean.getArrearsStartDate());
				}

				empPayComList = jdbcTemplate.query(EmployeePayComponentQueryUtil.checkEmpPayCom, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class), empbean.getPayComponentId(), empbean.getFromdate(), empbean.getEmployeeId());
				if (empPayComList.size() == 0) {
					if (empbean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(EmployeePayComponentQueryUtil.insertEmpPayCom, empPayComMap);
					}

				} else {
					if (empbean.getAmount() > 0) {
						namedParameterJdbcTemplate.update(EmployeePayComponentQueryUtil.updateEmpPayCom, empPayComMap);
					} else {
						if (empbean.getAmount() <= 0) {
							jdbcTemplate.update(EmployeePayComponentQueryUtil.deleteEmpPayComById, empbean.getEmployeeId(), empbean.getFromdate(), empbean.getPayComponentId());
						}
					}
				}
				isSuccess = true;

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in updateEmployeePayComponent", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean deleteEmployeePayComponenet(String employeeId, String fromDate) throws CustomException {
		boolean isSuccess = false;
		int val = 1;
		try {
			val = jdbcTemplate.update(EmployeePayComponentQueryUtil.deleteEmpPayCom, employeeId, fromDate);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteBranch", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public EmployeePayComponentBean getEmployeeMaxDate(String employeeId) throws CustomException {
		EmployeePayComponentBean employeePayComponentBean = new EmployeePayComponentBean();
		try {
			employeePayComponentBean = jdbcTemplate.queryForObject(EmployeePayComponentQueryUtil.getMaxFromDate, new Object[] { employeeId }, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class));

		} catch (DataAccessException e) {

			employeePayComponentBean = null;
			return employeePayComponentBean;
		}
		// TODO Auto-generated method stub
		return employeePayComponentBean;
	}

	@Override
	public EmployeePayComponentBean uploadFile(MultipartFile file) {
		ArrayList<ArrayList<EmployeePayComponentBean>> mainList = new ArrayList<>();
		ArrayList<EmployeePayComponentBean> sublist = null;
		List<EmployeePayComponentBean> empList = new ArrayList<>();
		EmployeePayComponentBean empbean = new EmployeePayComponentBean();
		List<EmployeePayComponentBean> monthyearList = new ArrayList<>();
		List<EmployeeLopBean> checkLopList = new ArrayList<>();
		List<String> empIdList = new ArrayList<>();
		EmployeePayComponentBean employeePayComponentBean = null;
		Map<String, Object> records = new HashMap<>();
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		String PrevEmployeeId = null;
		String datestring = "";
		String dbdatestring = null;
		String sErrorCheck = "";
		boolean isValid = true;
		boolean isMonthValid = true;
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
					String employeeId = null;

					String paycomponent = null;
					String amount = null;
					Iterator<Cell> cellIterator = row.cellIterator();
					sublist = new ArrayList<>();
					while (cellIterator.hasNext()) {
						employeePayComponentBean = new EmployeePayComponentBean();
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0 && cell.getRowIndex() >= 3) {
								employeeId = cell.getStringCellValue().trim();
								empList = jdbcTemplate.query(EmployeePayComponentQueryUtil.CHECK_EMPLOYEE, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class), cell.getStringCellValue().trim());
								if (empList.size() == 0) {
									isValid = false;
									employeePayComponentBean.setisValid(false);
									sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is invalid in row " + cell.getRowIndex() + " " + "\n";

								}
								for (String e : empIdList) {
									if (e.equalsIgnoreCase(cell.getStringCellValue().trim())) {
										isValid = false;
										employeePayComponentBean.setisValid(false);
										sErrorCheck = sErrorCheck + "Employee Id" + " " + cell.getStringCellValue().trim() + " " + "is repeated in row  " + cell.getRowIndex() + " " + "\n";
									}

								}

								if (isMonthValid) {
									String maxDate = null;
									empbean = jdbcTemplate.queryForObject(EmployeePayComponentQueryUtil.getMaxFromDate1, new Object[] { employeeId }, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class));
									if (empbean != null) {
										maxDate = empbean.getFromdate();
									}
									if (maxDate != null) {
										SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
										Date date1 = DATE_FORMAT.parse(maxDate);
										Date date2 = DATE_FORMAT.parse(datestring);
										String[] maxdatecell = maxDate.split("-");
										int maxdatemonth = Integer.parseInt(maxdatecell[1]);
										int maxdateyear = Integer.parseInt(maxdatecell[2]);
										String[] celldate = datestring.split("-");
										int cellmonth = Integer.parseInt(celldate[1]);
										int cellyear = Integer.parseInt(celldate[2]);
										if ((cellmonth >= maxdatemonth) && (cellyear >= maxdateyear)) {
										} else {
											isValid = false;
											sErrorCheck = sErrorCheck + "Salary Alreday Created " + employeeId + maxDate;

										}

									}

								}

								empIdList.add(cell.getStringCellValue().trim());
							}

							if (cell.getColumnIndex() >= 2 && cell.getRowIndex() == 2) {
								records.put(String.valueOf(cell.getColumnIndex()), cell.getStringCellValue().trim());
							}

							break;

						case Cell.CELL_TYPE_NUMERIC:

							if (cell.getColumnIndex() == 1 && cell.getRowIndex() == 0) {
								if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
									if (DateUtil.isCellDateFormatted(cell)) {
										SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
										String date = DATE_FORMAT.format(cell.getDateCellValue());
										datestring = date;
										String[] celldate = date.split("-");
										int cellmonth = Integer.parseInt(celldate[1]);
										int cellyear = Integer.parseInt(celldate[2]);

										Date date1 = DATE_FORMAT.parse(date);
										Date today = new Date();
										String currentdate = DATE_FORMAT.format(today);
										String[] currentdat = currentdate.split("-");
										int currentmonth = Integer.parseInt(currentdat[1]);
										int currentyear = Integer.parseInt(currentdat[2]);
										if ((cellmonth >= currentmonth) && (cellyear >= currentyear)) {
											dbdatestring = "01" + "-" + cellmonth + "-" + cellyear;
										} else {
											isMonthValid = false;
											isValid = false;
											sErrorCheck = sErrorCheck + "Month and Year Should be greater than or equval to current month year";
										}

									}
								}

							}

							if (cell.getColumnIndex() >= 2 && cell.getRowIndex() >= 3) {
								String payComponentId = null;
								int amount1 = (int) cell.getNumericCellValue();
								employeePayComponentBean.setAmount(amount1);
								for (Map.Entry<String, Object> entry : records.entrySet()) {
									String key = entry.getKey();
									Object value = entry.getValue();
									if (Integer.parseInt(key) == cell.getColumnIndex()) {
										payComponentId = (String) entry.getValue();
									}

								}
								employeePayComponentBean.setPayComponentId(payComponentId);
								employeePayComponentBean.setEmployeeId(employeeId);
								employeePayComponentBean.setFromdate(dbdatestring);

							}

							break;

						}

						if (cell.getColumnIndex() >= 0 && cell.getRowIndex() >= 3) {
							sublist.add(employeePayComponentBean);
						}

					}

					mainList.add(sublist);

				}

			}
			employeePayComponentBean.setErrorMessage(sErrorCheck);
			if (isValid) {

				exportDataToDB(mainList);
				employeePayComponentBean.setisValid(true);
			}
			return employeePayComponentBean;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeePayComponentBean;
	}

	private void exportDataToDB(ArrayList<ArrayList<EmployeePayComponentBean>> employeePayComponentlist) {
		try {

			List<EmployeePayComponentBean> empPayComList = new ArrayList<>();

			for (ArrayList<EmployeePayComponentBean> componentBean : employeePayComponentlist) {
				Map<String, Object> empPayComMap = null;

				for (EmployeePayComponentBean empbean : componentBean) {
					empPayComMap = new HashMap<>();
					empPayComMap.put("employeeId", empbean.getEmployeeId());
					empPayComMap.put("fromDate", empbean.getFromdate());
					empPayComMap.put("payComponentId", empbean.getPayComponentId());
					empPayComMap.put("amount", empbean.getAmount());
					boolean arrearFlag = false;

					if (empbean.getArrears() == "true") {
						arrearFlag = true;

					} else if (empbean.getArrears() == "false") {
						arrearFlag = false;

					}
					empPayComMap.put("arrears", arrearFlag);
					if (empbean.getArrearsStartDate() != null) {

						if (empbean.getArrearsStartDate().isEmpty()) {
							empPayComMap.put("arrearsStartDate", null);

						} else {
							empPayComMap.put("arrearsStartDate", empbean.getArrearsStartDate());
						}

					} else {
						empPayComMap.put("arrearsStartDate", empbean.getArrearsStartDate());
					}
					
					
					
					if (empbean.getEmployeeId() != null && empbean.getPayComponentId() != null) {
						empPayComList = jdbcTemplate.query(EmployeePayComponentQueryUtil.checkEmpPayCom, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class), empbean.getPayComponentId(), empbean.getFromdate(), empbean.getEmployeeId());

						if (empPayComList.size() == 0) {
							if (empbean.getAmount() > 0) {
								namedParameterJdbcTemplate.update(EmployeePayComponentQueryUtil.insertEmpPayCom, empPayComMap);
							}

						} else {
							if (empbean.getAmount() > 0) {
								namedParameterJdbcTemplate.update(EmployeePayComponentQueryUtil.updateEmpPayCom, empPayComMap);
							} else {
								if (empbean.getAmount() <= 0) {
									jdbcTemplate.update(EmployeePayComponentQueryUtil.deleteEmpPayCom, empbean.getEmployeeId(), empbean.getFromdate());
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

	@Override
	public List<EmployeePayComponentBean> getSampleExcelList(EmployeePayComponentBean employeePayComponentBean) throws CustomException {
		List<EmployeePayComponentBean> getSampleExcelList = new ArrayList<>();

		try {

			getSampleExcelList = jdbcTemplate.query(EmployeePayComponentQueryUtil.selectComponentName, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class));

			return getSampleExcelList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in taxsectionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public List<EmployeePayComponentBean> getEmployeeList(EmployeePayComponentBean employeePayComponentBean) throws CustomException {
		List<EmployeePayComponentBean> employeeList = new ArrayList<>();
		try {

			if (employeePayComponentBean.getDept() == null && employeePayComponentBean.getDept() == "" && employeePayComponentBean.getDept() == "undefined") {
				String depart = employeePayComponentBean.getDept();
				depart = null;
				employeeList = jdbcTemplate.query(EmployeePayComponentQueryUtil.selectEmployeeList, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class), employeePayComponentBean.getCompanyId(), employeePayComponentBean.getBranchId(), depart, null);
	
			}
			else{
				employeeList = jdbcTemplate.query(EmployeePayComponentQueryUtil.selectEmployeeList, new BeanPropertyRowMapper<>(EmployeePayComponentBean.class), employeePayComponentBean.getCompanyId(), employeePayComponentBean.getBranchId(), employeePayComponentBean.getDepartmentId(), null);

			}
			return employeeList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in taxsectionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeePayComponentResultBean getpayExport(List<Map<String, Object>> empPayComBean) throws Exception {
		EmployeePayComponentResultBean resultbean = new EmployeePayComponentResultBean();
		List<EmployeePayComponentBean> listbean = new ArrayList<>();
		List<String> head = new ArrayList<>();
		List<String> list = new ArrayList<>();
		Date currentDate = new Date();
		String fName = "PayRoll" + currentDate.getDate() + "_" + currentDate.getHours() + "_" + currentDate.getMinutes() + "_" + currentDate.getSeconds() + ".xls";
		String fileName = localPath + fName;
		WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(fileName));
		workbook.createSheet("Sheet1", 0);
		workbook.write();
		workbook.close();
		try (OutputStream os = new FileOutputStream(fileName)) {
			List<String> headers = Arrays.asList("Department Name", "Employee Name", "From Date", "Basic", "DA", "HRA", "CONVE", "SPL", "CONS", "Other Earnings", "Gross Pay", "MEDIC", "PFSEL", "Other Deduction", "Net Pay");

			for (Map<String, Object> m : empPayComBean) {
				EmployeePayComponentBean bean = new EmployeePayComponentBean();
				for (Map.Entry<String, Object> entry : m.entrySet()) {
					System.out.println(entry.getKey());
					if (entry.getKey().equals("OTEAR")) {
						bean.setOtherrarnings(entry.getValue().toString());
					} else if (entry.getKey().equals("PFCOM")) {
						bean.setPfcom(entry.getValue().toString());
					} else if (entry.getKey().equals("CONVE")) {
						bean.setConve(entry.getValue().toString());
					} else if (entry.getKey().equals("HRA")) {
						bean.setHra(entry.getValue().toString());
					} else if (entry.getKey().equals("GROSS")) {
						bean.setGrosspay(entry.getValue().toString());
					} else if (entry.getKey().equals("MEDIC")) {
						bean.setMedic(entry.getValue().toString());
					} else if (entry.getKey().equals("NET")) {
						bean.setPfesl(entry.getValue().toString());
					} else if (entry.getKey().equals("PFSEL")) {
						bean.setNerpay(entry.getValue().toString());
					} else if (entry.getKey().equals("DA")) {
						bean.setDa(entry.getValue().toString());
					} else if (entry.getKey().equals("BASIC")) {
						bean.setBasic(entry.getValue().toString());
					} else if (entry.getKey().equals("OTDED")) {
						bean.setOtded(entry.getValue().toString());
					} else if (entry.getKey().equals("fromdate")) {
						bean.setFromdate(entry.getValue().toString());
					} else if (entry.getKey().equals("departmentName")) {
						bean.setDepartmentName(entry.getValue().toString());
					} else if (entry.getKey().equals("employeeName")) {
						bean.setEmployeeName(entry.getValue().toString());
					} else if (entry.getKey().equals("SPL")) {
						bean.setSpl(entry.getValue().toString());
					} else if (entry.getKey().equals("CONS")) {
						bean.setCons(entry.getValue().toString());
					}

				}
				listbean.add(bean);

			}

			Context context = new Context();
			context.putVar("payRollList", listbean);
			SimpleExporter exporter1 = new SimpleExporter();

			exporter1.gridExport(headers, listbean, "departmentName,employeeName,fromdate,basic,da,hra,conve,spl,cons,otherrarnings,grosspay,medic,pfesl,otded,nerpay", os);
			resultbean.setFilePath(server + "/" + fName);
			resultbean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
			resultbean.setSuccess(false);
		}
		return resultbean;
	}

	@Override
	public boolean checkArrearDate(String arrearsStartDate) {
		EmployeePayComponentBean objEmployeePayComponentBean = new EmployeePayComponentBean();

		try {

			String executeQuery = "select count(*) from employee_arrear_earnings where to_date('" + arrearsStartDate + "','mm/yyyy') between to_date(arrear_from_date,'mm/yyyy')::date and to_date(arrear_to_date,'mm/yyyy')::date";

			int count = jdbcTemplate.queryForObject(executeQuery,Integer.class);

		} catch (Exception e) {
			e.printStackTrace();

		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployeePayComponentResultBean checkArrearDate(String arrearDate, String employeeId) {
		// TODO Auto-generated method stub

		EmployeePayComponentResultBean objEmployeePayComponentBean = new EmployeePayComponentResultBean();

		String yearSubStr = arrearDate.substring(3, 5);
		String monthSubStr = arrearDate.substring(6, 10);
		String daata = yearSubStr + monthSubStr;

		try {

			String executeQuery = "select count(*) from employee_arrear_earnings where employee_id= '" + employeeId + "' and  to_date('" + daata + "','mm/yyyy') between to_date(arrear_from_date,'mm/yyyy')::date and to_date(arrear_to_date,'mm/yyyy')::date";

			int count = jdbcTemplate.queryForObject(executeQuery,Integer.class);

			if (count >= 1) {
				objEmployeePayComponentBean.setArrearExist(true);

			} else {
				objEmployeePayComponentBean.setArrearExist(false);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return objEmployeePayComponentBean;
	}
}