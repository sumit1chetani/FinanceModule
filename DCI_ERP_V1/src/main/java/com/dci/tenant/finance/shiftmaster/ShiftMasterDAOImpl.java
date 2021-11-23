package com.dci.tenant.finance.shiftmaster;

import java.sql.Time;
import java.sql.Timestamp;
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
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;

@Transactional("tenantTransactionManager")

@Repository
public class ShiftMasterDAOImpl implements ShiftMasterDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ShiftMasterDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ShiftMasterBean> getShiftMasterList() throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ShiftMasterBean> shiftMasterList = new ArrayList<ShiftMasterBean>();

		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ShiftMasterQueryUtil.GetShiftMasterList, userDetail.getCompanyCode());

			for (Map row : rows) {
				ShiftMasterBean objShiftMasterBean = new ShiftMasterBean();
				objShiftMasterBean.setShiftId((int) row.get("shiftId"));
				objShiftMasterBean.setShiftCode((String) row.get("shiftCode"));
				objShiftMasterBean.setShiftName((String) row.get("shiftName"));
				objShiftMasterBean.setDescription((String) row.get("description"));
				objShiftMasterBean.setEffectFromDate((String) row.get("effectFromDate"));
				Time startTime = (Time) row.get("startTime");
				String startTm = String.valueOf(startTime).substring(0, 5);
				objShiftMasterBean.setStartTime(startTm);
				Time endTime = (Time) row.get("endTime");
				String endTm = String.valueOf(endTime).substring(0, 5);
				objShiftMasterBean.setEndTime(endTm);
				Time breakStartTime = (Time) row.get("breakStartTime");
				String breakStartTm = String.valueOf(breakStartTime).substring(0, 5);
				objShiftMasterBean.setBreakStartTime(breakStartTm);
				Time breakEndTime = (Time) row.get("breakEndTime");
				String breakEndTm = String.valueOf(breakEndTime).substring(0, 5);
				objShiftMasterBean.setBreakEndTime(breakEndTm);
				Time thresholdTime = (Time) row.get("thresholdTime");
				String thresholdTm = String.valueOf(thresholdTime).substring(0, 5);
				objShiftMasterBean.setThresholdTime(thresholdTm);
				boolean nightShift = (boolean) row.get("nightShift");
				objShiftMasterBean.setNightShift(String.valueOf(nightShift));
				Time lateAfter = (Time) row.get("lateAfter");
				String lateAft = String.valueOf(lateAfter).substring(0, 5);
				objShiftMasterBean.setLateAfter(lateAft);
				Time earlyExit = (Time) row.get("earlyExit");
				String earlyExt = String.valueOf(earlyExit).substring(0, 5);
				objShiftMasterBean.setEarlyExit(earlyExt);
				int timeAllowed = (int) row.get("noOfTimeAllowed");
				objShiftMasterBean.setNoOfTimeAllowed(String.valueOf(timeAllowed));
				String halfDay = String.valueOf((double) row.get("halfDay"));
				objShiftMasterBean.setHalfDay(halfDay);
				String fullDay = String.valueOf((double) row.get("fullDay"));
				objShiftMasterBean.setFullDay(fullDay);

				shiftMasterList.add(objShiftMasterBean);
			}

		} catch (Exception e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return shiftMasterList;
	}

	@Override
	public void addShiftMaster(ShiftMasterBean objShiftMasterBean) throws Exception {

		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		boolean isSuccess = false;
		int value = 0;

		try {

			int rowCountCode = jdbcTemplate.queryForObject(ShiftMasterQueryUtil.sCheckShiftCode, new Object[] { objShiftMasterBean.getShiftCode() },Integer.class);

			int rowCountName = jdbcTemplate.queryForObject(ShiftMasterQueryUtil.sCheckShiftName, new Object[] { objShiftMasterBean.getShiftName() },Integer.class);

			if (rowCountCode > 0) {
				throw new CustomException(ErrorMessage.CODE_ALREADY_EXISTS);
			} else if (rowCountName > 0) {
				throw new CustomException(ErrorMessage.NAME_ALREADY_EXISTS);
			} else {

				boolean nightShift = false;
				if (objShiftMasterBean.getNightShift().equalsIgnoreCase("Y")) {
					nightShift = true;
				}
				UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

				String effdate = objShiftMasterBean.getEffectFromDate();

				Date date = formatter.parse(effdate);
				java.sql.Timestamp EffDate = new Timestamp(date.getTime());

				String startTime = objShiftMasterBean.getStartTime() + ":" + "00";
				String endTime = objShiftMasterBean.getEndTime() + ":" + "00";
				String breakStartTime = objShiftMasterBean.getBreakStartTime() + ":" + "00";
				String breakEndTime = objShiftMasterBean.getBreakEndTime() + ":" + "00";
				String thresholdTime = objShiftMasterBean.getThresholdTime() + ":" + "00";
				String lateAfter = objShiftMasterBean.getLateAfter() + ":" + "00";
				String earlyExit = objShiftMasterBean.getEarlyExit() + ":" + "00";
				if(startTime.equals(":00")) {
					startTime="00:00:00";
				}
					if(endTime.equals(":00")) {
						endTime="00:00:00";
					}
						if( breakStartTime.equals(":00")) {
							breakStartTime="00:00:00";
						}
							if(breakEndTime.equals(":00") ) {
								breakEndTime="00:00:00";
							}
								if(thresholdTime.equals(":00")){
									thresholdTime="00:00:00";
								}
									if( lateAfter.equals(":00")) {
										lateAfter="00:00:00";
									}
										if(earlyExit.equals(":00") ) {
											earlyExit="00:00:00";
									}
							
				String query = "INSERT INTO shift ( shift_name, code, description, efect_from_date, start_time, end_time, break_start_time, break_end_time, threshold_time, is_night_shift, late_after, early_exit, number_of_time_allowed, min_working_hrs_half_day, min_working_hrs_full_day,company_id ) values ( '" + objShiftMasterBean.getShiftName() + "','" + objShiftMasterBean.getShiftCode() + "','" + objShiftMasterBean.getDescription() + "','" + EffDate + "','" + startTime + "','" + endTime + "'," + "'" + breakStartTime + "','" + breakEndTime + "','"
						+ thresholdTime + "','" + nightShift + "','" + lateAfter + "','" + earlyExit + "','" + objShiftMasterBean.getNoOfTimeAllowed() + "','" + objShiftMasterBean.getHalfDay() + "','" + objShiftMasterBean.getFullDay() + "','" + userDetail.getCompanyCode() + "') ";

				value = jdbcTemplate.update(query);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			LOGGER.error("Error in insertShiftMaster", e.getMessage());
		}
	}

	@Override
	public ShiftMasterBean getShiftMasterEditList(int shiftId) throws Exception {

		ShiftMasterBean objShiftMasterBean = new ShiftMasterBean();
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ShiftMasterQueryUtil.sGetShiftMasterEditList, new Object[] { shiftId });

			for (Map row : rows) {
				objShiftMasterBean.setShiftId((int) row.get("shiftId"));
				objShiftMasterBean.setShiftCode((String) row.get("shiftCode"));
				objShiftMasterBean.setShiftName((String) row.get("shiftName"));
				objShiftMasterBean.setDescription((String) row.get("description"));
				objShiftMasterBean.setEffectFromDate((String) row.get("effectFromDate"));
				Time startTime = (Time) row.get("startTime");
				String startTm = String.valueOf(startTime).substring(0, 5);
				objShiftMasterBean.setStartTime(startTm);
				Time endTime = (Time) row.get("endTime");
				String endTm = String.valueOf(endTime).substring(0, 5);
				objShiftMasterBean.setEndTime(endTm);
				Time breakStartTime = (Time) row.get("breakStartTime");
				String breakStartTm = String.valueOf(breakStartTime).substring(0, 5);
				objShiftMasterBean.setBreakStartTime(breakStartTm);
				Time breakEndTime = (Time) row.get("breakEndTime");
				String breakEndTm = String.valueOf(breakEndTime).substring(0, 5);
				objShiftMasterBean.setBreakEndTime(breakEndTm);
				Time thresholdTime = (Time) row.get("thresholdTime");
				String thresholdTm = String.valueOf(thresholdTime).substring(0, 5);
				objShiftMasterBean.setThresholdTime(thresholdTm);
				boolean nightShift = (boolean) row.get("nightShift");
				objShiftMasterBean.setNightShift(String.valueOf(nightShift));
				Time lateAfter = (Time) row.get("lateAfter");
				String lateAft = String.valueOf(lateAfter).substring(0, 5);
				objShiftMasterBean.setLateAfter(lateAft);
				Time earlyExit = (Time) row.get("earlyExit");
				String earlyExt = String.valueOf(earlyExit).substring(0, 5);
				objShiftMasterBean.setEarlyExit(earlyExt);
				int timeAllowed = (int) row.get("noOfTimeAllowed");
				objShiftMasterBean.setNoOfTimeAllowed(String.valueOf(timeAllowed));
				String halfDay = String.valueOf((double) row.get("halfDay"));
				objShiftMasterBean.setHalfDay(halfDay);
				String fullDay = String.valueOf((double) row.get("fullDay"));
				objShiftMasterBean.setFullDay(fullDay);
			}

		} catch (Exception e) {
			LOGGER.error("Error in Get Shift Master Edit List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return objShiftMasterBean;
	}

	@Override
	public boolean deleteShiftMaster(int shiftId) throws Exception {

		boolean issucces = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(ShiftMasterQueryUtil.sDeleteShiftMaster, shiftId);

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
	public void updateShiftMaster(ShiftMasterBean objShiftMasterBean) throws Exception {
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		boolean isSuccess = false;
		int value = 0;

		try {
			boolean flag = false;
			String shiftName = jdbcTemplate.queryForObject(ShiftMasterQueryUtil.getShiftName, String.class, objShiftMasterBean.getShiftId());
			if (objShiftMasterBean.getShiftName().equals(shiftName)) {
				flag = true;
			} else {

				int rowCountCode = jdbcTemplate.queryForObject(ShiftMasterQueryUtil.sCheckShiftCode, new Object[] { objShiftMasterBean.getShiftCode() },Integer.class);

				int rowCountName = jdbcTemplate.queryForObject(ShiftMasterQueryUtil.sCheckShiftName, new Object[] { objShiftMasterBean.getShiftName() } ,Integer.class);

				if (rowCountCode > 0) {
					throw new CustomException(ErrorMessage.CODE_ALREADY_EXISTS);
				} else if (rowCountName > 0) {
					throw new CustomException(ErrorMessage.NAME_ALREADY_EXISTS);
				} else {
					flag = true;
				}
			}
			if (flag == true) {

				boolean nightShift = false;
				if (objShiftMasterBean.getNightShift().equalsIgnoreCase("Y")) {
					nightShift = true;
				}

				String effdate = objShiftMasterBean.getEffectFromDate();

				Date date = formatter.parse(effdate);
				java.sql.Timestamp EffDate = new Timestamp(date.getTime());

				String startTime = objShiftMasterBean.getStartTime() + ":" + "00";
				String endTime = objShiftMasterBean.getEndTime() + ":" + "00";
				String breakStartTime = objShiftMasterBean.getBreakStartTime() + ":" + "00";
				String breakEndTime = objShiftMasterBean.getBreakEndTime() + ":" + "00";
				String thresholdTime = objShiftMasterBean.getThresholdTime() + ":" + "00";
				String lateAfter = objShiftMasterBean.getLateAfter() + ":" + "00";
				String earlyExit = objShiftMasterBean.getEarlyExit() + ":" + "00";

				String query = " Update shift set  shift_name = '" + objShiftMasterBean.getShiftName() + "', code ='" + objShiftMasterBean.getShiftCode() + "',description = '" + objShiftMasterBean.getDescription() + "'," + "efect_from_date ='" + EffDate + "'  ,start_time= '" + startTime + "'," + "end_time ='" + endTime + "',break_start_time = '" + breakStartTime + "',break_end_time = '" + breakEndTime + "'," + "threshold_time ='" + thresholdTime + "', is_night_shift= '" + nightShift + "', late_after ='" + lateAfter + "'," + "early_exit ='"
						+ earlyExit + "',number_of_time_allowed ='" + objShiftMasterBean.getNoOfTimeAllowed() + "',min_working_hrs_half_day ='" + objShiftMasterBean.getHalfDay() + "'," + "min_working_hrs_full_day= '" + objShiftMasterBean.getFullDay() + "'   WHERE shift_id =  '" + objShiftMasterBean.getShiftId() + "'";

				value = jdbcTemplate.update(query);

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in update Manage Shift", e);
		}
	}

	@Override
	public boolean uploadFile(MultipartFile file) {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		ArrayList<ShiftMasterBean> lShiftMasterBean = new ArrayList<ShiftMasterBean>();
		ShiftMasterBean objShiftMasterBean = null;
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
					objShiftMasterBean = new ShiftMasterBean();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (cell.getColumnIndex() == 0) {
								objShiftMasterBean.setShiftName(cell.getStringCellValue().trim());
							}
							if (cell.getColumnIndex() == 1) {
								objShiftMasterBean.setShiftCode(String.valueOf(cell.getStringCellValue()));
							} else if (cell.getColumnIndex() == 2) {
								objShiftMasterBean.setDescription(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 3) {
								objShiftMasterBean.setEffectFromDate(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 4) {
								objShiftMasterBean.setStartTime(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 5) {
								objShiftMasterBean.setEndTime(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 6) {
								objShiftMasterBean.setBreakStartTime(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 7) {
								objShiftMasterBean.setBreakEndTime(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 8) {
								objShiftMasterBean.setThresholdTime(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 9) {
								objShiftMasterBean.setNightShift(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 10) {
								objShiftMasterBean.setLateAfter(cell.getStringCellValue().trim());
							} else if (cell.getColumnIndex() == 11) {
								objShiftMasterBean.setEarlyExit(cell.getStringCellValue().trim());
							}
							break;

						case Cell.CELL_TYPE_NUMERIC:
							if (cell.getColumnIndex() == 1) {
								objShiftMasterBean.setShiftCode(String.valueOf(cell.getNumericCellValue()));
							} else if (cell.getColumnIndex() == 12) {
								objShiftMasterBean.setNoOfTimeAllowed(String.valueOf(cell.getNumericCellValue()));
							} else if (cell.getColumnIndex() == 13) {
								objShiftMasterBean.setHalfDay(String.valueOf(cell.getNumericCellValue()));
							} else if (cell.getColumnIndex() == 14) {
								objShiftMasterBean.setFullDay(String.valueOf(cell.getNumericCellValue()));
							}
							break;
						}
					}
					lShiftMasterBean.add(objShiftMasterBean);
				}

			}
			isSuccess = exportDataToDB(lShiftMasterBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private boolean exportDataToDB(ArrayList<ShiftMasterBean> lShiftMasterBean) {
		boolean isSuccess = false;
		// TODO Auto-generated method stub
		try {

			for (ShiftMasterBean objShiftMasterBean : lShiftMasterBean) {

				String SHIFT_NAME = objShiftMasterBean.getShiftName();
				String SHIFT_CODE = objShiftMasterBean.getShiftCode();

				// String SHIFT_CODE = String.valueOf(SHIFT_CODES);

				// Double shiftCode = new Double(SHIFT_CODES);
				// int shiftcode = shiftCode.intValue();
				// String SHIFT_CODE = String.valueOf(shiftcode);

				String DESCRIPTION = objShiftMasterBean.getDescription();
				String EFFECT_FRM_DATE = objShiftMasterBean.getEffectFromDate();
				DateFormat formatter;
				Date date = null;
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				try {
					date = formatter.parse(EFFECT_FRM_DATE);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String START_TIME = objShiftMasterBean.getStartTime();
				String END_TIME = objShiftMasterBean.getEndTime();
				String BREAK_START_TIME = objShiftMasterBean.getBreakStartTime();
				String BREAK_END_TIME = objShiftMasterBean.getBreakEndTime();
				String THRESHOLD_TIME = objShiftMasterBean.getThresholdTime();
				String NIGHT_SHIFT_TIME = objShiftMasterBean.getNightShift();
				boolean NIGHT_SHIFT = Boolean.valueOf(NIGHT_SHIFT_TIME);
				String LATE_AFTER = objShiftMasterBean.getLateAfter();
				String EARLY_EXIT = objShiftMasterBean.getEarlyExit();

				String TIMES_ALLOWED = objShiftMasterBean.getNoOfTimeAllowed();
				Double d = new Double(TIMES_ALLOWED);
				int NO_OF_TIMES_ALLOWED = d.intValue();

				String HALF_DAY = objShiftMasterBean.getHalfDay().trim();
				double WRK_HALF_DAY = Double.valueOf(HALF_DAY);

				String FULL_DAY = objShiftMasterBean.getFullDay().trim();
				double WRK_FULL_DAY = Double.valueOf(FULL_DAY);

				Date parsedDate = null, endDate = null, breakStartTime = null, breakEndTime = null, thresholdTime = null, nightShift = null, lateAfter = null, earlyExit = null;
				DateFormat df;

				df = new SimpleDateFormat("HH:mm:ss");
				try {
					parsedDate = df.parse(START_TIME);
					endDate = df.parse(END_TIME);
					breakStartTime = df.parse(BREAK_START_TIME);
					breakEndTime = df.parse(BREAK_END_TIME);
					thresholdTime = df.parse(THRESHOLD_TIME);
					lateAfter = df.parse(LATE_AFTER);
					earlyExit = df.parse(EARLY_EXIT);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*
				 * SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				 * String shoursfrom = sdf.format(row.get("hoursfrom"));
				 */

				jdbcTemplate.update(ShiftMasterQueryUtil.INSERT_SHIFT_UPLOAD, new Object[] { SHIFT_NAME, SHIFT_CODE, DESCRIPTION, date, parsedDate, endDate, breakStartTime, breakEndTime, thresholdTime, NIGHT_SHIFT, lateAfter, earlyExit, NO_OF_TIMES_ALLOWED, WRK_HALF_DAY, WRK_FULL_DAY });

				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting into the shift table", e);
		}
		return isSuccess;

	}
}
