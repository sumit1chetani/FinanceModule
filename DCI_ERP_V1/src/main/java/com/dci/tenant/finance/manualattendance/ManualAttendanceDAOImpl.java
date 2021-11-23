package com.dci.tenant.finance.manualattendance;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

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

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;



@Repository
@Transactional("tenantTransactionManager")

public class ManualAttendanceDAOImpl implements ManualAttendanceDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ManualAttendanceDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ManualAttendance> getAttendanceList(int limit, int offset) throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ManualAttendance> attendanceDataList = new ArrayList<ManualAttendance>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManualAttendanceQueryUtil.SELECT_ATTENDANCE_LIST, userDetail.getCompanyCode());
			for (Map row : rows) {

				ManualAttendance objManualAttendance = new ManualAttendance();
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String attendanceDate = df.format(row.get("attendanceDate"));
				objManualAttendance.setAttendanceDate(attendanceDate);

				objManualAttendance.setInTime((String) row.get("inTime"));
				objManualAttendance.setOutTime((String) row.get("outTime"));
				objManualAttendance.setAttendanceId((int) row.get("attendanceId"));
				objManualAttendance.setShiftName((String) row.get("shiftName"));
				objManualAttendance.setDepartmentCode((String) row.get("departmentCode"));
				objManualAttendance.setHospitalName((String) row.get("hospitalName"));
				objManualAttendance.setBranchName((String) row.get("branchName"));
				objManualAttendance.setEmployeeName((String) row.get("employeeName"));
				//objManualAttendance.set((String) row.get("employeeName"));

				attendanceDataList.add(objManualAttendance);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeeDetailsList", e);
		}
		return attendanceDataList;
	}

	@Override
	public ManualAttendance getAttendanceById(Integer attendanceId) throws CustomException {
		ManualAttendance manualAttendance = null;
		try {
			manualAttendance = jdbcTemplate.queryForObject(ManualAttendanceQueryUtil.sGetAttendanceEditList, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class), attendanceId);
		} catch (DataAccessException e) {
e.printStackTrace();		}
		return manualAttendance;
	}

	@Override
	public boolean updateAttendance(ManualAttendance objManualAttendance) throws Exception {
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSuccess = false;
		int value = 0;
		try {

			String attendanceDate = objManualAttendance.getAttendanceDate();
			Date currentDate = new Date();
			DateFormat formatters;
			Date date = null;
			formatters = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = formatters.parse(attendanceDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String startTime = objManualAttendance.getInTime();
			String endTime = objManualAttendance.getOutTime();

			Map<String, Object> attendanceMap = new HashMap<String, Object>();
			attendanceMap.put("attendanceId", objManualAttendance.getAttendanceId());
			attendanceMap.put("attendanceDate", date);
			attendanceMap.put("inTime", startTime);
			attendanceMap.put("outTime", endTime);
			attendanceMap.put("shiftId", objManualAttendance.getShiftId());
			attendanceMap.put("modifiedDate",objManualAttendance. getToDate());
			attendanceMap.put("logInUser", user.getUserFullName());
			attendanceMap.put("toDate", objManualAttendance.getToDate());


			namedParameterJdbcTemplate.update(ManualAttendanceQueryUtil.UPDATE_ATTENDENCE, attendanceMap);

			isSuccess = true;
		} catch (Exception e) {
e.printStackTrace();	
}

		return isSuccess;
	}

	@Override
	public boolean deleteAttendance(Integer attendanceId) throws CustomException {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(ManualAttendanceQueryUtil.DELETE_ATTENDANCE, attendanceId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteAttendance", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		return isSuccess;

	}

	@Override
	public ManualAttendanceResultBean getDepartmentList(String branchId) throws CustomException {
		ManualAttendanceResultBean manualAttendanceResultBean = new ManualAttendanceResultBean();
		List<ManualAttendance> departmentList = new ArrayList<ManualAttendance>();
		try {
			departmentList = jdbcTemplate.query(ManualAttendanceQueryUtil.SELECT_DEPARTMENT_LIST, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class), branchId);
			manualAttendanceResultBean.setDepartmentList(departmentList);
			manualAttendanceResultBean.setSuccess(true);
			return manualAttendanceResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDepartmentList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManualAttendanceResultBean getEmployeeList(ManualAttendance manualattend) {
		ManualAttendanceResultBean manualAttendanceResultBean = new ManualAttendanceResultBean();
		ManualAttendance manualAttendance = new ManualAttendance();
		List<ManualAttendance> list = new ArrayList<ManualAttendance>();
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if (manualattend.getOption().equals("multiple")) {
				list = jdbcTemplate.query(ManualAttendanceQueryUtil.SELECT_EMPLOYEE_LIST_MULTIPLE, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class), manualattend.getDepartmentId(), manualattend.getBranchName(), manualattend.getShiftId(), manualattend.getAttendanceDate(), manualattend.getToDate());
			} else {
				list = jdbcTemplate.query(ManualAttendanceQueryUtil.SELECT_EMPLOYEE_LIST_SINGLE, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class), manualattend.getDepartmentId(), manualattend.getBranchName(), manualattend.getShiftId(), manualattend.getAttendanceDate());
			}
			manualAttendance = jdbcTemplate.queryForObject(ManualAttendanceQueryUtil.SELECT_SHIFTDETAILS, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class), manualattend.getShiftId());
			manualAttendanceResultBean.setEmployeeList(list);
			manualAttendanceResultBean.setManualattendance(manualAttendance);

		} catch (DataAccessException e) {
		}
		return manualAttendanceResultBean;
	}

	@Override
	public List getShiftTimingList(String shiftId) {
		List lShift = new ArrayList();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ManualAttendanceQueryUtil.SELECT_SHIFTTIMING_LIST, Integer.parseInt(shiftId));
			for (Map row : rows) {
				ManualAttendance bean = new ManualAttendance();
				bean.setShiftInTime((String) row.get("shiftInTime"));
				lShift.add(bean);
			}
		} catch (DataAccessException e) {
			// LOGGER.error("Error in getVessel", e);
		}
		return lShift;
	}

	@Override
	public ManualAttendanceResultBean getShiftList() throws CustomException {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ManualAttendanceResultBean manualAttendanceResultBean = new ManualAttendanceResultBean();
		List<ManualAttendance> shiftList = new ArrayList<ManualAttendance>();
		try {
			shiftList = jdbcTemplate.query(ManualAttendanceQueryUtil.SELECT_SHIFT_LIST, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class), user.getCompanyCode());
			manualAttendanceResultBean.setShiftList(shiftList);
			manualAttendanceResultBean.setSuccess(true);
			return manualAttendanceResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getShiftList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManualAttendanceResultBean getMyAttendanceDetails() throws CustomException {
		ManualAttendanceResultBean manualAttendanceResultBean = new ManualAttendanceResultBean();
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ManualAttendance manualAttendance;
		List<ManualAttendance> shiftDetails = new ArrayList<ManualAttendance>();
		List<ManualAttendance> myAttendanceDetails = new ArrayList<ManualAttendance>();
		Date currentDate = new Date();
		String hospital = user.getCompanyName();
		String branch = user.getBranchName();
		String employee = user.getFirstName();
		String employeeId = user.getUserId();
		try {
			shiftDetails = jdbcTemplate.query(ManualAttendanceQueryUtil.SELECT_MY_ATTENDANCE_DETAILS, new Object[] { currentDate, currentDate, currentDate, currentDate, user.getUserId() }, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class));
			manualAttendanceResultBean.setMyAttendanceDetails(shiftDetails);// myAttendanceList
			myAttendanceDetails = jdbcTemplate.query(ManualAttendanceQueryUtil.CHECK_MY_ATTENDANCE_DETAILS, new Object[] { user.getUserId(), currentDate }, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class));
			manualAttendanceResultBean.setShiftList(myAttendanceDetails);
			manualAttendanceResultBean.setSuccess(true);
			return manualAttendanceResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in myAttendanceDetails", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManualAttendance insertAttendance(ManualAttendance objAttendance) throws CustomException {
		ManualAttendance objFinal = new ManualAttendance();
		boolean isSuccess = false;
		int i = 1;

		try {
			boolean isActive = false;
			//EmployeeMasterBean objemp = new EmployeeMasterBean();
			String attendanceDate = objAttendance.getAttendanceDate();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date currentDate = new Date();
			SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
			String fromDate = objAttendance.getAttendanceDate();
			String toDate = objAttendance.getToDate();
			List<ManualAttendance> myAttendanceDetails = new ArrayList<ManualAttendance>();
			Map<String, Object> attendanceMap = new HashMap<String, Object>();
			if (toDate == null || toDate == "") {
				int count = 0;
				try {
					Date datefrm = myFormat.parse(fromDate);

					String startTime1 = objAttendance.getInTime() + ":" + "00";
					String endTime1 = objAttendance.getOutTime() + ":" + "00";
					String mode = "M";
					attendanceMap.put("attendanceDate", datefrm);
					attendanceMap.put("inTime", startTime1);
					attendanceMap.put("outTime", endTime1);
					attendanceMap.put("departmentId", objAttendance.getDepartmentId());
					attendanceMap.put("attendanceDate", objAttendance.getAttendanceDate());

					attendanceMap.put("shiftId", objAttendance.getShiftId());
					attendanceMap.put("employeeId", objAttendance.getEmployeeId());
					attendanceMap.put("mode", mode);
					attendanceMap.put("branchName", objAttendance.getBranchName());
					attendanceMap.put("hospitalName", objAttendance.getHospitalName());

					attendanceMap.put("createdDate", currentDate);
					attendanceMap.put("logInUser", objAttendance.getLogInUser());
					objAttendance.getEmployeeListId();
					//for (ManualAttendance object : empList) {
						myAttendanceDetails = jdbcTemplate.query(ManualAttendanceQueryUtil.CHECK_MY_ATTENDANCE_DETAILS, new Object[] {  objAttendance.getAttendanceDate() }, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class));
						if (myAttendanceDetails.size() == 0) {
							attendanceMap.put("employeeId", objAttendance);
							isSuccess = true;
							count = count + 1;
						 	jdbcTemplate.update(ManualAttendanceQueryUtil.INSERT_ATTENDANCE, objAttendance.getShiftId(),objAttendance.getAttendanceDate(),startTime1,endTime1,mode,objAttendance.getBranchName(),objAttendance.getHospitalName(),objAttendance.getDepartmentId(),objAttendance.getEmployeeId());
						} else {

						}

					

				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (count == 0) {
					objFinal.setSuccess(false);
					objFinal.setErrorMessage("Record Already Exists!");
				} else {
					if (count > 0) {
						objFinal.setSuccess(true);
					}
				}

			} else if (toDate != "" || toDate != null) {
				try {
					int count = 0;
					Date datefrm = myFormat.parse(fromDate);
					Date dateto = myFormat.parse(toDate);
					int days = (int) ((dateto.getTime() - datefrm.getTime()) / (1000 * 60 * 60 * 24));
					List<Date> dates = new ArrayList<Date>();
					long interval = 24 * 1000 * 60 * 60;
					long endTime = dateto.getTime();

					long curTime = datefrm.getTime();
					while (curTime <= endTime) {
						dates.add(new Date(curTime));
						curTime += interval;
					}
					for (int iCount = 0; iCount < dates.size(); iCount++) {

						Date lDate = dates.get(iCount);
						String ds = myFormat.format(lDate);
						Date sqeDate = myFormat.parse(ds);
						String startTime1 = objAttendance.getInTime() + ":" + "00";
						String endTime1 = objAttendance.getOutTime() + ":" + "00";
						String mode = "M";
						attendanceMap.put("attendanceDate", sqeDate);
						attendanceMap.put("inTime", startTime1);
						attendanceMap.put("outTime", endTime1);
						attendanceMap.put("departmentId", objAttendance.getDepartmentId());
						attendanceMap.put("shiftId", objAttendance.getShiftId());
						attendanceMap.put("employeeId", objAttendance.getEmployeeId());
						attendanceMap.put("mode", mode);
						attendanceMap.put("branchName", objAttendance.getBranchName());

						attendanceMap.put("createdDate", currentDate);
						attendanceMap.put("logInUser", objAttendance.getLogInUser());
						attendanceMap.put("attendanceDate", objAttendance.getAttendanceDate());
						attendanceMap.put("toDate", objAttendance.getToDate());


						List empList = objAttendance.getEmployeeListId();
						//for (Object object : empList) {
							myAttendanceDetails = jdbcTemplate.query(ManualAttendanceQueryUtil.CHECK_MY_ATTENDANCE_DETAILS1, new Object[] { objAttendance, ds }, new BeanPropertyRowMapper<ManualAttendance>(ManualAttendance.class));
							if (myAttendanceDetails.size() == 0) {
								attendanceMap.put("employeeId", objAttendance);
								isSuccess = true;
								count = count + 1;
								int j = jdbcTemplate.update(ManualAttendanceQueryUtil.INSERT_ATTENDANCE1, objAttendance.getShiftId(),objAttendance.getAttendanceDate(),startTime1,endTime1,currentDate,mode,objAttendance.getBranchName(),objAttendance.getDepartmentId(),objAttendance.getToDate());

							} else {
								

							}

						}
						if (count == 0) {
							objFinal.setSuccess(false);
							objFinal.setErrorMessage("Attendance has already been recorded.");
						} else {
							if (count > 0) {
								objFinal.setSuccess(true);
							}
						}
					}

				 catch (ParseException e) {
					e.printStackTrace();
				}
			}

		} catch (DataAccessException e) {
e.printStackTrace();
}

		return objFinal;
	}

	@Override
	public boolean saveMyAttendance(ManualAttendance objAttendance) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			boolean isActive = false;
			int value;
			String attendanceDate = objAttendance.getAttendanceDate();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date currentDate = new Date();
			SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
			String fromDate = objAttendance.getAttendanceDate();
			String toDate = objAttendance.getToDate();
			Map<String, Object> attendanceMap = new HashMap<String, Object>();
			try {
				Date datefrm = myFormat.parse(fromDate);

				String startTime1 = objAttendance.getMyInTime();
				String endTime1 = objAttendance.getMyOutTime();
				String mode = "M";
				String inTime = "00" + ":" + "00" + ":" + "00";
				String outTime = "00" + ":" + "00" + ":" + "00";
				String userId = user.getUserId();

				if (objAttendance.getCheckIn() == "" || objAttendance.getCheckIn() == null) {
					jdbcTemplate.update(ManualAttendanceQueryUtil.INSERT_MY_ATTENDANCE, currentDate, objAttendance.getMyInTime(), objAttendance.getDepartmentId(), objAttendance.getShiftId(), userId, mode, currentDate, objAttendance.getLogInUser());
					isSuccess = true;
				} else if (objAttendance.getCheckOut() == "" || objAttendance.getCheckOut() == null) {
					jdbcTemplate.update(ManualAttendanceQueryUtil.UPDATE_MY_OUT_ATTENDANCE, objAttendance.getMyOutTime(), userId, currentDate);
					isSuccess = true;
				}

			} catch (ParseException e) {
				e.printStackTrace();
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in My Attendance Add", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}
}
