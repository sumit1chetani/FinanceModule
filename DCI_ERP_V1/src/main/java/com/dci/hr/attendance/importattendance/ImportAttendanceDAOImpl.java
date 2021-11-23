package com.dci.hr.attendance.importattendance;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dci.master.employeeAdminMaster.EmployeeMasterQueryUtil;


@Repository
public class ImportAttendanceDAOImpl implements ImportAttendanceDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ImportAttendanceDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		ArrayList<ImportAttendanceBean> lImportAttendanceBean = new ArrayList<ImportAttendanceBean>();
		ImportAttendanceBean objImportAttendanceBean = null;
		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		String datestring = "";
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
				if (rowCnt > 1) {
					Iterator<Cell> cellIterator = row.cellIterator();
					String sDateCheck = "";
					objImportAttendanceBean = new ImportAttendanceBean();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0) {
								objImportAttendanceBean.setEmployeeId(getEmployeeId(cell.getStringCellValue().trim()));
							} else if (cell.getColumnIndex() == 1) {
								objImportAttendanceBean.setShiftId(String.valueOf(getShiftId(cell.getStringCellValue().trim())));
							} else if (cell.getColumnIndex() == 2) {
								objImportAttendanceBean.setAttendanceDate(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 3) {
								objImportAttendanceBean.setInTime(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 4) {
								objImportAttendanceBean.setOutTime(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 5) {
								objImportAttendanceBean.setDepartmentId(getDepartmentId(cell.getStringCellValue().trim()));
							}
							break;

						}
					}
					lImportAttendanceBean.add(objImportAttendanceBean);
				}

			}
			exportDataToDB(lImportAttendanceBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getDepartmentId(String departmentName) {
		int departmentId = 0;

		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(EmployeeMasterQueryUtil.GET_DEPARTMENT_ID, new Object[] { departmentName });
			for (Map row : rows) {
				departmentId = (int) row.get("dept_code");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return departmentId;
	}

	private int getShiftId(String shiftName) {
		int shiftId = 0;

		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(EmployeeMasterQueryUtil.GET_SHIFT_ID, new Object[] { shiftName });
			for (Map row : rows) {
				shiftId = (int) row.get("shift_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return shiftId;
	}

	private String getEmployeeId(String firstName) {
		String employeeId = "";
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(EmployeeMasterQueryUtil.GET_EMPLOYEE_ID, new Object[] { firstName });
			for (Map row : rows) {
				employeeId = (String) row.get("employee_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeId;
	}

	private void exportDataToDB(ArrayList<ImportAttendanceBean> lImportAttendanceBean) {
		// TODO Auto-generated method stub
		try {

			for (ImportAttendanceBean objImportAttendanceBean : lImportAttendanceBean) {

				String EMPLOYEE_ID = objImportAttendanceBean.getEmployeeId();
				int SHIFT_ID = Integer.parseInt(objImportAttendanceBean.getShiftId());
				int DEPT_ID = objImportAttendanceBean.getDepartmentId();

				String attendanceDate = objImportAttendanceBean.getAttendanceDate();
				DateFormat formatter;
				Date date = null;
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				try {
					date = formatter.parse(attendanceDate);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String IN_TIME = objImportAttendanceBean.getInTime();
				String OUT_TIME = objImportAttendanceBean.getOutTime();

				Date inTime = null, outTime = null;
				DateFormat df;

				df = new SimpleDateFormat("HH:mm:ss");
				try {
					inTime = df.parse(IN_TIME);
					outTime = df.parse(OUT_TIME);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				jdbcTemplate.update(ImportAttendanceQueryUtil.INSERT_ATTENDENCE_UPLOAD, new Object[] { EMPLOYEE_ID, SHIFT_ID, date, inTime, outTime, DEPT_ID });
			}

		} catch (Exception e) {
			LOGGER.error("Error in inserting into the department table", e);
		}

	}
}
