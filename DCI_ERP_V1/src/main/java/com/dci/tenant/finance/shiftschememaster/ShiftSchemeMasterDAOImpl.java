package com.dci.tenant.finance.shiftschememaster;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;

@Transactional("tenantTransactionManager")

@Repository
public class ShiftSchemeMasterDAOImpl implements ShiftSchemeMasterDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ShiftSchemeMasterDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ShiftSchemeMasterBean> getShiftSchemeMasterList() throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ShiftSchemeMasterBean> shiftSchemeMasterList = new ArrayList<ShiftSchemeMasterBean>();
		try {
			shiftSchemeMasterList = jdbcTemplate.query(ShiftSchemeMasterQueryUtil.GetShiftSchemeMasterList, new BeanPropertyRowMapper<ShiftSchemeMasterBean>(ShiftSchemeMasterBean.class), userDetail.getCompanyCode());
			return shiftSchemeMasterList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDesignationList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ShiftSchemeMasterResultBean getShiftNameList(ShiftSchemeMasterBean shiftSchemeMasterBean) throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ShiftSchemeMasterResultBean objSchemeMasterResultBean = new ShiftSchemeMasterResultBean();
		List<ShiftSchemeMasterBean> shiftNameList = new ArrayList<ShiftSchemeMasterBean>();

		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		ShiftSchemeMasterBean shiftSchemeMasterBean1 = new ShiftSchemeMasterBean();
		try {

			String fromDate = shiftSchemeMasterBean.getValidityFrom();

			Date date = formatter.parse(fromDate);
			String toDate = shiftSchemeMasterBean.getValidityTo();

			Date date1 = formatter.parse(toDate);

			shiftNameList = jdbcTemplate.query(ShiftSchemeMasterQueryUtil.SELECT_SHIFT_NAME_LIST, new BeanPropertyRowMapper<ShiftSchemeMasterBean>(ShiftSchemeMasterBean.class), date, userDetail.getCompanyCode());
			shiftSchemeMasterBean.setId("0");
			shiftSchemeMasterBean.setText("Weekly Off");
			shiftNameList.add(shiftSchemeMasterBean);
			shiftSchemeMasterBean1.setId("-1");
			shiftSchemeMasterBean1.setText("Week End");
			shiftNameList.add(shiftSchemeMasterBean1);

			objSchemeMasterResultBean.setShiftNameList(shiftNameList);

			objSchemeMasterResultBean.setSuccess(true);
			return objSchemeMasterResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Shift List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public void addShiftSchemeMaster(ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		boolean isSuccess = false;
		int value = 0, weekDay = 0;

		try {

			int rowCount = jdbcTemplate.queryForObject(ShiftSchemeMasterQueryUtil.sCheckShiftName, new Object[] { objShiftSchemeMasterBean.getSchemeName() },Integer.class);

			if (rowCount > 0) {
				throw new CustomException(ErrorMessage.NAME_ALREADY_EXISTS);
			} else {

				String fromDate = objShiftSchemeMasterBean.getValidityFrom();

				Date date = formatter.parse(fromDate);
				java.sql.Timestamp validityFrom = new Timestamp(date.getTime());

				String toDate = objShiftSchemeMasterBean.getValidityTo();

				Date date1 = formatter.parse(toDate);
				java.sql.Timestamp validityTo = new Timestamp(date1.getTime());

				int row = jdbcTemplate.update(ShiftSchemeMasterQueryUtil.INSERT_SHIFT_SCHEME, objShiftSchemeMasterBean.getSchemeName(), validityFrom, validityTo, userDetail.getCompanyCode());

				if (row != 0) {

					if (objShiftSchemeMasterBean.getSundayCompany() != null && !objShiftSchemeMasterBean.getSundayCompany().isEmpty()) {
						weekDay = 1;
						isSuccess = addShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getSundayCompany());
					}
					if (objShiftSchemeMasterBean.getMondayCompany() != null && !objShiftSchemeMasterBean.getMondayCompany().isEmpty()) {
						weekDay = 2;
						isSuccess = addShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getMondayCompany());
					}
					if (objShiftSchemeMasterBean.getTuesdayCompany() != null && !objShiftSchemeMasterBean.getTuesdayCompany().isEmpty()) {
						weekDay = 3;
						isSuccess = addShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getTuesdayCompany());
					}
					if (objShiftSchemeMasterBean.getWednesdayCompany() != null && !objShiftSchemeMasterBean.getWednesdayCompany().isEmpty()) {
						weekDay = 4;
						isSuccess = addShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getWednesdayCompany());
					}
					if (objShiftSchemeMasterBean.getThursdayCompany() != null && !objShiftSchemeMasterBean.getThursdayCompany().isEmpty()) {
						weekDay = 5;
						isSuccess = addShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getThursdayCompany());
					}
					if (objShiftSchemeMasterBean.getFridayCompany() != null && !objShiftSchemeMasterBean.getFridayCompany().isEmpty()) {
						weekDay = 6;
						isSuccess = addShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getFridayCompany());
					}
					if (objShiftSchemeMasterBean.getSaturdayCompany() != null && !objShiftSchemeMasterBean.getSaturdayCompany().isEmpty()) {
						weekDay = 7;
						isSuccess = addShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getSaturdayCompany());
					}
				}

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertShiftScheme", e.getMessage());
		}
	}

	@Override
	public void updateShiftSchemeMaster(ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception {
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		boolean isSuccess = false;
		int value = 0, weekDay = 0;

		try {
			boolean flag = false;
			String schemeName = jdbcTemplate.queryForObject(ShiftSchemeMasterQueryUtil.getSchemeName, String.class, objShiftSchemeMasterBean.getSchemeName());
			if (objShiftSchemeMasterBean.getSchemeName().equals(schemeName)) {
				flag = true;
			} else {

				int rowCount = jdbcTemplate.queryForObject(ShiftSchemeMasterQueryUtil.sCheckShiftName, new Object[] { objShiftSchemeMasterBean.getSchemeName() },Integer.class);

				if (rowCount > 0) {
					throw new CustomException(ErrorMessage.NAME_ALREADY_EXISTS);
				} else {
					flag = true;
				}
			}
			if (flag == true) {

				String fromDate = objShiftSchemeMasterBean.getValidityFrom();

				Date date = formatter.parse(fromDate);
				java.sql.Timestamp validityFrom = new Timestamp(date.getTime());

				String toDate = objShiftSchemeMasterBean.getValidityTo();

				Date date1 = formatter.parse(toDate);
				java.sql.Timestamp validityTo = new Timestamp(date1.getTime());

				int row = jdbcTemplate.update(ShiftSchemeMasterQueryUtil.UPDATE_SHIFT_SCHEME, objShiftSchemeMasterBean.getSchemeName(), validityFrom, validityTo, objShiftSchemeMasterBean.getSchemeName());

				if (row != 0) {

					if (objShiftSchemeMasterBean.getSundayCompany() != null && !objShiftSchemeMasterBean.getSundayCompany().isEmpty()) {
						weekDay = 1;
						isSuccess = updateShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getSundayCompany());
					}
					if (objShiftSchemeMasterBean.getMondayCompany() != null && !objShiftSchemeMasterBean.getMondayCompany().isEmpty()) {
						weekDay = 2;
						isSuccess = updateShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getMondayCompany());
					}
					if (objShiftSchemeMasterBean.getTuesdayCompany() != null && !objShiftSchemeMasterBean.getTuesdayCompany().isEmpty()) {
						weekDay = 3;
						isSuccess = updateShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getTuesdayCompany());
					}
					if (objShiftSchemeMasterBean.getWednesdayCompany() != null && !objShiftSchemeMasterBean.getWednesdayCompany().isEmpty()) {
						weekDay = 4;
						isSuccess = updateShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getWednesdayCompany());
					}
					if (objShiftSchemeMasterBean.getThursdayCompany() != null && !objShiftSchemeMasterBean.getThursdayCompany().isEmpty()) {
						weekDay = 5;
						isSuccess = updateShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getThursdayCompany());
					}
					if (objShiftSchemeMasterBean.getFridayCompany() != null && !objShiftSchemeMasterBean.getFridayCompany().isEmpty()) {
						weekDay = 6;
						isSuccess = updateShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getFridayCompany());
					}
					if (objShiftSchemeMasterBean.getSaturdayCompany() != null && !objShiftSchemeMasterBean.getSaturdayCompany().isEmpty()) {
						weekDay = 7;
						isSuccess = updateShiftMasterDetails(objShiftSchemeMasterBean.getSchemeName(), weekDay, objShiftSchemeMasterBean.getSaturdayCompany());
					}
				}

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in update Shift Scheme", e);
			e.printStackTrace();
		}
	}

	public boolean addShiftMasterDetails(String schemeName, int weekDay, String shiftId) throws Exception {
		boolean isSuccess = false;
		int val = 0;
		boolean weekOff = false;
		boolean weekEnd = false;
		try {

			if (shiftId.equals("-1")) {
				weekOff = false;
				weekEnd = true;
			} else if (shiftId.equals("0")) {
				weekOff = true;
				weekEnd = false;
			} else {
				weekOff = false;
				weekEnd = false;
			}
			String query = "INSERT INTO shifts_in_scheme ( scheme_name ,week_day,shift_id,weekly_off, week_end) values ('" + schemeName + "','" + weekDay + "','" + shiftId + "','" + weekOff + "','" + weekEnd + "')";

			val = jdbcTemplate.update(query);

			if (val != 0) {
				isSuccess = true;
			}

		} catch (Exception e) {
			LOGGER.error("Error in Add Shift Scheme Master", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public boolean deleteShiftSchemeMaster(ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception {
		boolean issucces = false;
		int value = 0, detailValue = 0, employeeValue = 0;
		try {
			System.out.println("Scheme Id" + objShiftSchemeMasterBean.getSchemeId());

			employeeValue = jdbcTemplate.queryForObject(ShiftSchemeMasterQueryUtil.sCheckShiftEmpDetails, new Object[] { objShiftSchemeMasterBean.getSchemeId() },Integer.class);

			System.out.println("Check Employee Id" + employeeValue);

			if (employeeValue == 0) {
				detailValue = jdbcTemplate.update(ShiftSchemeMasterQueryUtil.sDeleteShiftSchemeDetails, objShiftSchemeMasterBean.getSchemeName());
				value = jdbcTemplate.update(ShiftSchemeMasterQueryUtil.sDeleteShiftSchemeMaster, objShiftSchemeMasterBean.getSchemeId());
			}

			// employeeValue =
			// jdbcTemplate.update(ShiftSchemeMasterQueryUtil.sDeleteEmployeeShiftMaster,
			// objShiftSchemeMasterBean.getSchemeId());

			if (value != 0) {
				issucces = true;
			}
		} catch (Exception e) {
			LOGGER.error("Error in Delete", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		return issucces;
	}

	@Override
	public ShiftSchemeMasterBean getShiftSchemeMasterEditList(String schemeName) throws Exception {

		ShiftSchemeMasterBean objShiftSchemeMasterBean = new ShiftSchemeMasterBean();
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ShiftSchemeMasterQueryUtil.sGetShiftSchemeMasterEditList, new Object[] { schemeName });

			for (Map row : rows) {
				objShiftSchemeMasterBean.setSchemeName((String) row.get("schemeName"));
				objShiftSchemeMasterBean.setValidityFrom((String) row.get("validityFrom"));
				objShiftSchemeMasterBean.setValidityTo((String) row.get("validityTo"));
			}
		} catch (Exception e) {
			LOGGER.error("Error in Get Shift Scheme Master Edit List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return objShiftSchemeMasterBean;
	}

	public boolean updateShiftMasterDetails(String schemeName, int weekDay, String shiftId) throws Exception {
		boolean isSuccess = false;
		int val = 0;
		boolean weekOff = false;
		boolean weekEnd = false;
		try {

			if (shiftId.equals("-1")) {
				weekOff = false;
				weekEnd = true;
			} else if (shiftId.equals("0")) {
				weekOff = true;
				weekEnd = false;
			} else {
				weekOff = false;
				weekEnd = false;
			}

			int checkSchemeName = jdbcTemplate.queryForObject(ShiftSchemeMasterQueryUtil.sCheckSchemeName, new Object[] { schemeName, weekDay },Integer.class);

			if (checkSchemeName != 0) {

				String query = " Update shifts_in_scheme set shift_id = '" + Integer.valueOf(shiftId) + "', weekly_off='" + weekOff + "', week_end='" + weekEnd + "' WHERE scheme_name =  '" + schemeName + "' and week_day =  '" + weekDay + "'";

				val = jdbcTemplate.update(query);

				if (val != 0) {
					isSuccess = true;
				}
			} else {
				isSuccess = addShiftMasterDetails(schemeName, weekDay, shiftId);
			}

		} catch (Exception e) {
			LOGGER.error("Error in Update Shift Scheme Master", e);
			throw new CustomException(ErrorMessage.ERROR_UPDATE);
		}

		return isSuccess;
	}

	@Override
	public ArrayList getShiftSchemeMasterWeekList(String schemeName) throws Exception {
		ArrayList weekList = new ArrayList();

		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ShiftSchemeMasterQueryUtil.sGetShiftSchemeMasterWeekList, new Object[] { schemeName });

			for (Map row : rows) {
				ShiftSchemeMasterBean objMasterBean = new ShiftSchemeMasterBean();
				objMasterBean.setSchemeName((String) row.get("schemeName"));
				objMasterBean.setWeekDay((int) row.get("weekDay"));
				int shiftId = (int) row.get("shiftId");
				objMasterBean.setShiftName(String.valueOf(shiftId));
				weekList.add(objMasterBean);
			}

		} catch (Exception e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return weekList;
	}

	@Override
	public boolean uploadFile(MultipartFile file) {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		ArrayList<ShiftSchemeMasterBean> lShiftSchemeMasterBean = new ArrayList<ShiftSchemeMasterBean>();
		ShiftSchemeMasterBean objShiftSchemeMasterBean = null;
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
			} else {
				System.out.println("Not a valid file format");
			}

			int rowCnt = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowCnt += 1;
				if (rowCnt > 1) {
					Iterator<Cell> cellIterator = row.cellIterator();
					String sDateCheck = "";
					objShiftSchemeMasterBean = new ShiftSchemeMasterBean();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0) {
								objShiftSchemeMasterBean.setSchemeName(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 1) {
								objShiftSchemeMasterBean.setValidityFrom(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 2) {
								objShiftSchemeMasterBean.setValidityTo(cell.getStringCellValue().trim());
							}
							break;
						}
					}
					lShiftSchemeMasterBean.add(objShiftSchemeMasterBean);
				}

			}
			isSuccess = exportDataToDB(lShiftSchemeMasterBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private boolean exportDataToDB(ArrayList<ShiftSchemeMasterBean> lShiftSchemeMasterBean) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		try {

			for (ShiftSchemeMasterBean objShiftSchemeMasterBean : lShiftSchemeMasterBean) {

				String SCHEME_NAME = objShiftSchemeMasterBean.getSchemeName();
				String VALID_FROM = objShiftSchemeMasterBean.getValidityFrom();
				String VALID_TO = objShiftSchemeMasterBean.getValidityTo();
				DateFormat formatter;
				Date fromDate = null, toDate = null;
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				try {
					fromDate = formatter.parse(VALID_FROM);
					toDate = formatter.parse(VALID_TO);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				jdbcTemplate.update(ShiftSchemeMasterQueryUtil.INSERT_SHIFTSCHEME_UPLOAD, new Object[] { SCHEME_NAME, fromDate, toDate });
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the shiftscheme table", e);
		}
		return isSuccess;

	}
}