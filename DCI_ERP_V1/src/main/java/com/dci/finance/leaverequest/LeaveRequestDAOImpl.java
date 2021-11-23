package com.dci.finance.leaverequest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.finance.leaveApproval.LeaveAppCancelQueryUtil;
import com.dci.tenant.user.UserDetail;
import com.google.common.io.Files;

import liquibase.util.file.FilenameUtils;

@Repository
@Transactional("tenantTransactionManager")

public class LeaveRequestDAOImpl implements LeaveRequestDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LeaveRequestDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	/*
	 * @Value("${LeaveRequest.toapproval}") private String toAddress;
	 * 
	 * @Value("${LeaveRequest.Fromapproval}") private String fromadress;
	 * 
	 * @Value("${LeaveRequest.ccaproval}") private String ccaddress;
	 */

	@Value("${folder.path.localPath}")
	private String getFilePropertyUrl;

	@Value("${folder.path.serverPath}")
	private String getFileServerPath;

	@Value("${folder.path.localPath}")
	private String localPath;

	@Value("${folder.path.serverPath}")
	private String serverpath;

	@Override
	public List<LeaveRequestBean> getLeaveRequestList() {
		// TODO Auto-generated method stub

		List<LeaveRequestBean> getList = new ArrayList<LeaveRequestBean>();
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			String empId = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.SELECT_EMP_ID, String.class,
					teampUser.getUserId());

			if (empId.equalsIgnoreCase("E0001")) {
				getList = jdbcTemplate.query(LeaveRequestQueryUtil.getLeaveRequestQuery1,
						new BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class));

			} else {

				getList = jdbcTemplate.query(LeaveRequestQueryUtil.getLeaveRequestQuery,
						new BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class), teampUser.getUserId());

			}
		} catch (Exception e) {
			LOGGER.error("Error in getLeaveRequestList", e);

		}

		return getList;
	}

	@Override
	public LeaveRequestResultBean getLeaveList(LeaveRequestBean leaveRequestBean) throws Exception {
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String empId = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.SELECT_EMP_ID, String.class,
				teampUser.getUserId());

		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		List<LeaveRequestLeaveBean> resultList = new ArrayList<LeaveRequestLeaveBean>();
		// Date date= new Date();
		// Calendar cal = Calendar.getInstance();
		// cal.setTime(date);
		// int currentMonth = cal.get(Calendar.MONTH);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int curmonth = cal.get(cal.MONTH) + 1;
		int curmonthZero = cal.get(cal.MONTH) + 0;
		double clValue = 0;
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
					new Object[] { empId, empId });
			for (Map row : rows) {
				List<LeaveRequestLeaveBean> clList = new ArrayList<LeaveRequestLeaveBean>();
				int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
						Integer.class, empId);
				int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
						Integer.class, empId);
				LeaveRequestLeaveBean leaveBean = new LeaveRequestLeaveBean();
				LeaveRequestLeaveBean clleaveBean = new LeaveRequestLeaveBean();
				BigDecimal consume = ((BigDecimal) row.get("consumed"));
				BigDecimal bal = ((BigDecimal) row.get("balance"));
				BigDecimal allowed = ((BigDecimal) row.get("allowedLeave"));
				String allowedLeave = allowed.toString();
				String balance = bal.toString();
				String consumed = consume.toString();
				if (row.get("shortName").equals("CL")) {
					if (currentEmpDOJYear == year) {
						if (curmonth >= currentEmpDOJMonth) {
							if (curmonth == 12)
								curmonth += 1;

							double monthVal = curmonth - currentEmpDOJMonth;
							clValue = monthVal * 1.33;
							String newVal = String.valueOf(clValue);
							String[] arr = newVal.split("\\.");

							int[] clArr = new int[2];
							clArr[0] = Integer.parseInt(arr[1]);
							if (clArr[0] >= 80) {
								clValue = Math.round(clValue);
							}

							double leaveBalance = clValue - Double.parseDouble(consumed.toString());
							if (leaveRequestBean.getIsEdit().equals("false")) {
								clleaveBean.setAllowedLeave(String.valueOf(clValue));
								clleaveBean.setBalance(String.valueOf(new DecimalFormat("##.##").format(leaveBalance)));
							} else {
								leaveBean.setAllowedLeave(String.valueOf(clValue));
								leaveBean.setBalance(String.valueOf(new DecimalFormat("##.##").format(leaveBalance)));
							}
						}
					} else if (currentEmpDOJYear != year) {
						clValue = curmonthZero + 4;

						if (curmonth == 13)
							clValue += 1;

						double leaveBalance = clValue - Double.parseDouble(consumed.toString());
						if (leaveRequestBean.getIsEdit().equals("false")) {
							clleaveBean.setAllowedLeave(String.valueOf(clValue));
							clleaveBean.setBalance(String.valueOf(leaveBalance));
						} else {
							leaveBean.setAllowedLeave(String.valueOf(clValue));
							leaveBean.setBalance(String.valueOf(leaveBalance));
						}
					}
					if (leaveRequestBean.getIsEdit().equals("false")) {
						clleaveBean.setConsumed(consumed);
					} else {
						leaveBean.setConsumed(consumed);
					}

				} else if (row.get("shortName").equals("PL")) {
					if (currentEmpDOJYear == year) {
						if (curmonth >= currentEmpDOJMonth) {
							if (curmonth == 12)
								curmonth += 1;

							double monthVal = curmonth - currentEmpDOJMonth;
							clValue = monthVal * 1.33;
							String newVal = String.valueOf(clValue);
							String[] arr = newVal.split("\\.");

							int[] clArr = new int[2];
							clArr[0] = Integer.parseInt(arr[1]);
							if (clArr[0] >= 80) {
								clValue = Math.round(clValue);
							}

							double leaveBalance = clValue - Double.parseDouble(consumed.toString());
							if (leaveRequestBean.getIsEdit().equals("false")) {
								clleaveBean.setAllowedLeave(String.valueOf(clValue));
								clleaveBean.setBalance(String.valueOf(new DecimalFormat("##.##").format(leaveBalance)));
							} else {
								leaveBean.setAllowedLeave(String.valueOf(clValue));
								leaveBean.setBalance(String.valueOf(new DecimalFormat("##.##").format(leaveBalance)));
							}
						}
					} else if (currentEmpDOJYear != year) {
						clValue = curmonthZero + 4;

						if (curmonth == 13)
							clValue += 1;

						double leaveBalance = clValue - Double.parseDouble(consumed.toString());
						if (leaveRequestBean.getIsEdit().equals("false")) {
							clleaveBean.setAllowedLeave(String.valueOf(clValue));
							clleaveBean.setBalance(String.valueOf(leaveBalance));
						} else {
							leaveBean.setAllowedLeave(String.valueOf(clValue));
							leaveBean.setBalance(String.valueOf(leaveBalance));
						}
					}
					if (leaveRequestBean.getIsEdit().equals("false")) {
						clleaveBean.setConsumed(consumed);
					} else {
						leaveBean.setConsumed(consumed);
					}

				}

				/*
				 * else if (row.get("shortName").equals("PL")) {
				 * leaveBean.setAllowedLeave(allowedLeave); leaveBean.setBalance(balance);
				 * leaveBean.setConsumed(consumed); }
				 */ else {
					leaveBean.setAllowedLeave(allowedLeave);
					leaveBean.setBalance(balance);
					leaveBean.setConsumed(consumed);
				}
				// leaveBean.setConsumed(consumed);
				if (leaveRequestBean.getIsEdit().equals("false")) {
					if (row.get("shortName").equals("CL")) {
						clleaveBean.setEmpId((String) row.get("empId"));
						clleaveBean.setLeaveName((String) row.get("leaveName"));
						clleaveBean.setShortName((String) row.get("shortName"));
					} else {
						leaveBean.setEmpId((String) row.get("empId"));
						leaveBean.setLeaveName((String) row.get("leaveName"));
						leaveBean.setShortName((String) row.get("shortName"));
					}
				} else {
					leaveBean.setEmpId((String) row.get("empId"));
					leaveBean.setLeaveName((String) row.get("leaveName"));
					leaveBean.setShortName((String) row.get("shortName"));
				}

				if (row.get("shortName").equals("CL")) {
					clList.add(clleaveBean);
					resultBean.setClList(clList);
				}
				if (leaveRequestBean.getIsEdit().equals("false")) {
					if (!row.get("shortName").equals("CL")) {
						resultList.add(leaveBean);
					}
				} else if (row.get("shortName").equals("PL")) {
					clList.add(clleaveBean);
					resultBean.setClList(clList);
				} else if (leaveRequestBean.getIsEdit().equals("false")) {
					if (!row.get("shortName").equals("PL")) {
						resultList.add(leaveBean);
					}
				} else {
					resultList.add(leaveBean);
				}

			}

			String gen = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.gender, String.class, empId);
			if (gen.equals("M")) {
				List<Map<String, Object>> rows1 = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveMaleListQuery,
						new Object[] { empId, empId });
				for (Map row : rows1) {
					LeaveRequestLeaveBean leaveBean = new LeaveRequestLeaveBean();
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					BigDecimal bal = ((BigDecimal) row.get("balance"));
					BigDecimal allowed = ((BigDecimal) row.get("allowedLeave"));
					String allowedLeave = allowed.toString();
					String balance = bal.toString();
					String consumed = consume.toString();

					leaveBean.setEmpId((String) row.get("empId"));
					leaveBean.setLeaveName((String) row.get("leaveName"));
					leaveBean.setShortName((String) row.get("shortName"));
					leaveBean.setAllowedLeave(allowedLeave);
					leaveBean.setBalance(balance);
					leaveBean.setConsumed(consumed);
					resultList.add(leaveBean);

				}
			} else {
				List<Map<String, Object>> rows2 = jdbcTemplate
						.queryForList(LeaveRequestQueryUtil.getLeaveFemaleListQuery, new Object[] { empId, empId });
				for (Map row : rows2) {
					LeaveRequestLeaveBean leaveBean = new LeaveRequestLeaveBean();
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					BigDecimal bal = ((BigDecimal) row.get("balance"));
					BigDecimal allowed = ((BigDecimal) row.get("allowedLeave"));
					String allowedLeave = allowed.toString();
					String balance = bal.toString();
					String consumed = consume.toString();

					leaveBean.setEmpId((String) row.get("empId"));
					leaveBean.setLeaveName((String) row.get("leaveName"));
					leaveBean.setShortName((String) row.get("shortName"));
					leaveBean.setAllowedLeave(allowedLeave);
					leaveBean.setBalance(balance);
					leaveBean.setConsumed(consumed);
					resultList.add(leaveBean);

				}
			}

			resultBean.setLeaveList(resultList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	// save function
	@Override
	public boolean saveLeaveData(LeaveRequestResultBean saveBean) throws Exception {
		// TODO Auto-generated method stub

		LeaveRequestBean LeaveRequBean = new LeaveRequestBean();
		Calendar now = Calendar.getInstance();

		// get current TimeZone using getTimeZone method of Calendar class
		TimeZone timeZone = now.getTimeZone();

		// display current TimeZone using getDisplayName() method of TimeZone class
		System.out.println("Current TimeZone is : " + timeZone.getDisplayName());

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZone.getID()));
		Date currentDate = calendar.getTime();
		System.out.println(currentDate);

		boolean isSucess = false;
		int request_id = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.maxQuery, Integer.class);
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String empId = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.SELECT_EMP_ID, String.class,
				teampUser.getUserId());
		LeaveRequestBean dataBean = saveBean.getLeaveObj();
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		String fDate = dataBean.getFromDate();

		Date date = formatter.parse(fDate);
		java.sql.Timestamp fromDate = new Timestamp(date.getTime());
		System.out.println(fromDate);
		String tDate = dataBean.getToDate();

		Date date1 = formatter.parse(tDate);
		java.sql.Timestamp toDate = new Timestamp(date1.getTime());
		java.sql.Timestamp toDate1 = new Timestamp(date1.getTime());
		System.out.println(toDate);
		String appOn = dataBean.getAppliedOn();

		Date date2 = formatter.parse(appOn);
		java.sql.Timestamp appliedOn = new Timestamp(date.getTime());
		String noofdays = dataBean.getNoOfDays();
		double noofDays = Double.parseDouble(noofdays);

		boolean isHoliday = dataBean.getisHoliday();
		int holidayCountHos = 0;
		boolean isExist = true;
		String subquery = "";
		int holidayCountCol = 0;
		double excludeVal = 0;
		double leaveDays = 0;
		int i = 0;
		String leaveTypedump = null;
		int dabb = 0;
		List<LeaveRequestLeaveBean> saveList1 = saveBean.getLeaveList();

		if (saveList1 != null) {
			Iterator<LeaveRequestLeaveBean> iterator1 = saveList1.iterator();

			while (iterator1.hasNext()) {
				LeaveRequestLeaveBean leavedata1 = iterator1.next();

				leaveTypedump = leavedata1.getShortName();
			}
			if (leaveTypedump.equalsIgnoreCase("CL")) {
				int chidkkdds = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.checkcLTYPE, Integer.class, empId);

				if (chidkkdds > 0) {
					throw new CustomException("Leave Type Already Exist For this Employee");
				} else {
					int countnum = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.check_number, Integer.class,
							empId);

					if (countnum > 0) {

						subquery = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.Important_check, String.class,
								empId);

						String[] parts = subquery.split("-");
						String part1 = parts[0]; // 004
						String part2 = parts[1];
						String part3 = parts[2];

						String[] dummparts = tDate.split("/");
						String part11 = dummparts[0];

						int cell123 = (Integer.parseInt(part11)) - (Integer.parseInt(part3));
						System.out.println(cell123);

						if (cell123 == 1 || cell123 == -1) {

							String noofdayss = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.no_oof_days_values,
									String.class, empId);

							if (noofdayss.equalsIgnoreCase("2.00") || noofdayss.equalsIgnoreCase("1.00")
									|| noofdayss.equalsIgnoreCase("3.00")) {
								isExist = true;
							} else {

								System.out.println(tDate);
								Date d = toDate;
								Date dateBefore = new Date(d.getTime() - 1 * 24 * 3600 * 1000);
								System.out.println(dateBefore);
								isExist = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.OVERLAP_DAYS_CHECK_EPOCH,
										Boolean.class, empId, date, dateBefore);
							}
						}
					} else {

						// isExist =
						// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.OVERLAP_DAYS_CHECK_EPOCH,
						// Boolean.class,empId, date,date1 );
					}
				}

			}
		}

		if (saveBean.getLeaveObj().getCplLeaveDays() <= 0) {
			int katLogdatefrom = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.OVERLAP_DAYS_CHECK_KAT_METHOD,
					Integer.class, fDate, empId, fDate, fDate, empId);

			if (katLogdatefrom >= 3) {
				isExist = false;
			} else {
				Double noOfdays = Double.parseDouble(noofdays);
				Double tot = noOfdays + katLogdatefrom;
				if (tot < 4) {
					isExist = true;
				} else {
					isExist = false;
				}
			}

			int katLogdateto = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.OVERLAP_DAYS_CHECK_KAT_METHOD,
					Integer.class, tDate, empId, tDate, tDate, empId);

			if (katLogdateto >= 3) {
				isExist = false;
			} else {
				Double noOfdays = Double.parseDouble(noofdays);
				Double tot = noOfdays + katLogdatefrom;
				if (tot < 4) {
					isExist = true;
				} else {
					isExist = false;
				}
			}
		}

		List<LeaveRequestLeaveBean> saveList3 = saveBean.getLeaveList();

		if (saveList3 != null) {
			Iterator<LeaveRequestLeaveBean> iterator1 = saveList3.iterator();

			while (iterator1.hasNext()) {
				LeaveRequestLeaveBean leavedata1 = iterator1.next();

				leaveTypedump = leavedata1.getShortName();

				if (leaveTypedump.equalsIgnoreCase("CL")) {
					int katLogdatefrom = jdbcTemplate.queryForObject(
							LeaveRequestQueryUtil.OVERLAP_DAYS_CHECK_KAT_METHOD_OTH, Integer.class, fDate, empId, fDate,
							fDate, empId);

					if (katLogdatefrom == 0) {
						isExist = true;
					} else {
						isExist = false;
					}
				}
			}
		}

		List<LeaveRequestLeaveBean> saveList2 = saveBean.getLeaveList();

		if (saveList2 != null) {
			Iterator<LeaveRequestLeaveBean> iterator1 = saveList2.iterator();

			while (iterator1.hasNext()) {
				LeaveRequestLeaveBean leavedata1 = iterator1.next();

				leaveTypedump = leavedata1.getShortName();

				if (!leaveTypedump.equalsIgnoreCase("CL")) {
					int katLogdatefrom = jdbcTemplate.queryForObject(
							LeaveRequestQueryUtil.OVERLAP_DAYS_CHECK_KAT_METHOD_CL, Integer.class, fDate, empId, fDate,
							fDate, empId);

					if (katLogdatefrom == 0) {
						isExist = true;
					} else {
						isExist = false;
					}
				}
			}
		}

		String plCheck = null;
		List<LeaveRequestLeaveBean> saveList = saveBean.getLeaveList();
		List<LeaveRequestHolidayBean> holidayList = saveBean.getHolidayList();

		List<Date> dates = new ArrayList<Date>();
		List<Date> holidayDatesList = new ArrayList<Date>();
		Calendar start = Calendar.getInstance();
		start.setTime(date);
		Calendar end = Calendar.getInstance();
		end.setTime(date1);

		int checkEmpDOJ = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.checkEmpDoj, Integer.class, date, empId);
		if (checkEmpDOJ > 0) {
			for (Date datecheck = start.getTime(); !start.after(end); start.add(Calendar.DATE,
					1), datecheck = start.getTime()) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(datecheck);
				dates.add(cal.getTime());
				Date checkHoliday = cal.getTime();
				String ds = formatter.format(checkHoliday);
				Date checkHolidayDate = formatter.parse(ds);
				int holidayHosCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck, Integer.class,
						checkHolidayDate);

			}

			if (saveList != null) {
				Iterator<LeaveRequestLeaveBean> leaveIterator = saveList.iterator();
				while (leaveIterator.hasNext()) {
					LeaveRequestLeaveBean plCheckBean = leaveIterator.next();
					if (plCheckBean.isSelctRow().equalsIgnoreCase("true")) {
						plCheck = plCheckBean.getShortName();

						if (plCheck.equalsIgnoreCase("ML")) {
							int chidkkdds = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.checkcLTYPE_ML,
									Integer.class, empId);

							if (chidkkdds > 0) {
								throw new CustomException("Leave Type Already Exist For this Employee");
							}
						}

						else if (plCheck.equalsIgnoreCase("SL")) {
							int jk = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.checkcLTYPE_SL, Integer.class,
									empId);

							if (jk > 0) {
								throw new CustomException("Leave Type Already Exist For this Employee");
							}
						}

					}
				}
			} else {
				plCheck = "CPL";
			}

			int leaveRequest = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.leaveRequestCheck, Integer.class,
					new Object[] { empId, date });
			int plRequest = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.plRequestCheck, Integer.class,
					new Object[] { empId, date });
			if (plCheck.equals("PL") && plRequest == 0 || leaveRequest == 0) {
				leaveDays = noofDays;
				for (int iCount = 0; iCount < dates.size(); iCount++) {
					Date lDate = dates.get(iCount);
					String ds = formatter.format(lDate);
					Date sqeDate = formatter.parse(ds);

				}

				if (holidayList != null && saveList == null) {

					if (noofDays > 0) {

						int sda = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.CHECK_SAMPLE_DAYS, Integer.class,
								empId);

						if (sda == 1) {
							dabb = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.SAMPLE_DAYS_COUNT, Integer.class,
									empId);
						} else {
							dabb = 4;
						}

						int dummy3 = dabb;

						String WorkingDaysCheck12 = "select count(*) from leave_request where to_date(?,'dd/mm/yyyy') <= (CURRENT_DATE - interval'"
								+ dummy3 + " days' )::date and employee_id = ?";

						int k1 = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.WorkingDaysCheck, Integer.class,
								tDate, empId);
						String leaveType = null;

						if (k1 == 0 || leaveType == null) {

							if (dataBean.getAlternativeEmp() != "") {
								i = jdbcTemplate.update(LeaveRequestQueryUtil.insertLeavereqWitAlternative, request_id,
										empId, leaveType, date, date1, noofDays, dataBean.getLeaveReason(),
										dataBean.getLeaveAddress(), dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
										isHoliday, dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
										dataBean.getPayType(), false, teampUser.getUserId());
								jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestActionAlternate, request_id,
										"Pending");

							} else {
								i = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
										request_id, empId, leaveType, date, date1, noofDays, dataBean.getLeaveReason(),
										dataBean.getLeaveAddress(), dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
										isHoliday, dataBean.getPayType(), false, teampUser.getUserId());
								jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction, request_id,
										"Pending");
							}

							int count = 0;
							List<LeaveRequestHolidayBean> selectList = new ArrayList<LeaveRequestHolidayBean>();
							for (LeaveRequestHolidayBean value : holidayList) {
								if (value.getSelect() == true) {
									count = count + 1;
									selectList.add(value);
								}
							}
							List<LeaveRequestHolidayBean> selectedList = new ArrayList<LeaveRequestHolidayBean>();
							double size = selectList.size();
							for (int b = 0; b < size; b++) {
								selectedList.add(selectList.get(b));
							}

							int k = 0;
							Iterator<LeaveRequestHolidayBean> iterator = selectedList.iterator();
							while (iterator.hasNext()) {
								LeaveRequestHolidayBean leavedata = iterator.next();
								int holidayId = leavedata.getHolidayId();
								if (leavedata.getSelect() == true) {
									Date lDate = holidayDatesList.get(k);
									String ds = formatter.format(lDate);
									Date sqeDate = formatter.parse(ds);
									jdbcTemplate.update(LeaveRequestQueryUtil.holidayRequestQueryWithLeave, request_id,
											true, sqeDate, holidayId);
									jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveByDay, request_id, empId,
											sqeDate);
								}
								k++;
							}

							for (int iCount = 0; iCount < dates.size(); iCount++) {
								Date lDate = dates.get(iCount);
								String ds = formatter.format(lDate);
								Date sqeDate = formatter.parse(ds);
								int holidayHosCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
										Integer.class, sqeDate);

							}

						} else {
							throw new CustomException("Requested Date Exceeded");
						}

					} else {
						throw new CustomException("Can't give Leave Request on Holiday Date");
					}
				} else if (saveList != null && holidayList == null) {

					Iterator<LeaveRequestLeaveBean> iterator = saveList.iterator();

					if (noofDays > 0) {
						while (iterator.hasNext()) {
							LeaveRequestLeaveBean leavedata = iterator.next();

							String select = leavedata.isSelctRow();

							if (select.equalsIgnoreCase("true")) {

								int sda = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.CHECK_SAMPLE_DAYS,
										Integer.class, empId);

								if (sda == 1) {
									dabb = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.SAMPLE_DAYS_COUNT,
											Integer.class, empId);
								} else {
									dabb = 4;
								}

								int dummy3 = dabb;

								String WorkingDaysCheck12 = "select count(*) from leave_request where to_date(?,'dd/mm/yyyy') <= (CURRENT_DATE - interval'"
										+ dummy3 + " days' )::date and employee_id = ?";

								int k = jdbcTemplate.queryForObject(WorkingDaysCheck12, Integer.class, tDate, empId);

								if (k == 0) {

									String leaveType = leavedata.getShortName();

									String branch = saveBean.getLeaveObj().getBranch();
									String company = saveBean.getLeaveObj().getCompany();
									String department = saveBean.getLeaveObj().getDepartment();
									String employee = saveBean.getLeaveObj().getEmpId();

									String getbranch = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.GET_BRANCH,
											String.class, branch);
									String getcompany = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.GET_COMPANY,
											String.class, company);
									String getdepartment = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.GET_DEPART,
											String.class, department);

									// int chkdubai =
									// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.CHECK_DUBAI,Integer.class,
									// getbranch, getcompany,getdepartment ,employee);

									// if(leavedata.getShortName().equals("ML") && chkdubai <= noofDays) {
									if (saveBean.getLeaveObj().getBranch().equals("DUBAI")
											&& leavedata.getShortName().equals("ML")) {
										if (noofDays <= 45) {

											if (dataBean.getAlternativeEmp() != "") {
												i = jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeavereqWitAlternative, request_id,
														empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
														request_id, "Pending");
											} else {
												i = jdbcTemplate.queryForObject(
														LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
														request_id, empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
														request_id, "Pending");
												int fileUpload = jdbcTemplate.update(
														LeaveRequestQueryUtil.INSERT_FILE_PATH,
														new Object[] { request_id, dataBean.getUploadRef(),
																teampUser.getUserId() });

											}

										}

										else {

											throw new CustomException("No of Days should not be greater than 45 days!");
										}
									}

									if (saveBean.getLeaveObj().getBranch().equals("DUBAI")
											&& leavedata.getShortName().equals("SL")) {

										if (noofDays <= 11) {

											if (dataBean.getAlternativeEmp() != "") {
												i = jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeavereqWitAlternative, request_id,
														empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
														request_id, "Pending");
											} else {
												i = jdbcTemplate.queryForObject(
														LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
														request_id, empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
														request_id, "Pending");
												int fileUpload = jdbcTemplate.update(
														LeaveRequestQueryUtil.INSERT_FILE_PATH,
														new Object[] { request_id, dataBean.getUploadRef(),
																teampUser.getUserId() });

											}

										}

										else {

											throw new CustomException("No of Days should not be greater than 11 days!");
										}
									}

									if (saveBean.getLeaveObj().getBranch().equals("DUBAI")
											&& leavedata.getShortName().equals("AL")) {

										String getDoj = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.GET_DOJ_DATE,
												String.class, employee);

										int dayscount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.DAYS_COUNT_SL,
												Integer.class, getDoj, empId);

										int chkdubaicountmax = jdbcTemplate.queryForObject(
												LeaveRequestQueryUtil.CHECK_DUBAI_MAX, Integer.class, getbranch,
												getcompany, getdepartment, employee);

										if (dayscount >= 365) {

											if (chkdubaicountmax >= noofDays) {

												if (dataBean.getAlternativeEmp() != "") {
													i = jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeavereqWitAlternative,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getAlternativeEmp(),
															dataBean.getDutyAgreed(), dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
															request_id, "Pending");
												} else {

													i = jdbcTemplate.queryForObject(
															LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
															request_id, "Pending");
													int fileUpload = jdbcTemplate.update(
															LeaveRequestQueryUtil.INSERT_FILE_PATH,
															new Object[] { request_id, dataBean.getUploadRef(),
																	teampUser.getUserId() });

												}
											} else {

												throw new CustomException(
														"NO of days should not be greater than Leave Balance!");
											}

										} else {

											throw new CustomException("You are not eligible for this Leave Type!");
										}

									}

									if (saveBean.getLeaveObj().getBranch().equals("DUBAI")
											&& leavedata.getShortName().equals("CL")) {

										if (dataBean.getAlternativeEmp() != "") {
											i = jdbcTemplate.update(LeaveRequestQueryUtil.insertLeavereqWitAlternative,
													request_id, empId, leaveType, date, date1, noofDays,
													dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
													dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
													dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
													dataBean.getPayType(), false, teampUser.getUserId());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
													request_id, "Pending");
										} else {
											i = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.insertLeaverequest,
													Integer.class, request_id, empId, leaveType, date, date1, noofDays,
													dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
													dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
													dataBean.getPayType(), false, teampUser.getUserId());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
													request_id, "Pending");
											int fileUpload = jdbcTemplate.update(LeaveRequestQueryUtil.INSERT_FILE_PATH,
													new Object[] { request_id, dataBean.getUploadRef(),
															teampUser.getUserId() });

										}

									}

									if (saveBean.getLeaveObj().getBranch().equals("DUBAI")
											&& leavedata.getShortName().equals("CPL")) {

										if (dataBean.getAlternativeEmp() != "") {
											i = jdbcTemplate.update(LeaveRequestQueryUtil.insertLeavereqWitAlternative,
													request_id, empId, leaveType, date, date1, noofDays,
													dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
													dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
													dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
													dataBean.getPayType(), false, teampUser.getUserId());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
													request_id, "Pending");
										} else {
											i = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.insertLeaverequest,
													Integer.class, request_id, empId, leaveType, date, date1, noofDays,
													dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
													dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
													dataBean.getPayType(), false, teampUser.getUserId());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
													request_id, "Pending");
											int fileUpload = jdbcTemplate.update(LeaveRequestQueryUtil.INSERT_FILE_PATH,
													new Object[] { request_id, dataBean.getUploadRef(),
															teampUser.getUserId() });

										}

									}

									if (saveBean.getLeaveObj().getBranch().equals("MUMBAI")
											&& leavedata.getShortName().equals("SL")) {
										if (noofDays <= 7) {

											if (dataBean.getAlternativeEmp() != "") {
												i = jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeavereqWitAlternative, request_id,
														empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
														request_id, "Pending");
											} else {
												i = jdbcTemplate.queryForObject(
														LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
														request_id, empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
														request_id, "Pending");
												int fileUpload = jdbcTemplate.update(
														LeaveRequestQueryUtil.INSERT_FILE_PATH,
														new Object[] { request_id, dataBean.getUploadRef(),
																teampUser.getUserId() });

											}

										}

										else {

											throw new CustomException("No of Days should not be greater than 7 days!");
										}
									}

									if (saveBean.getLeaveObj().getBranch().equals("MUMBAI")
											&& leavedata.getShortName().equals("AL")) {

										String getDoj = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.GET_DOJ_DATE,
												String.class, employee);

										int dayscount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.DAYS_COUNT_SL,
												Integer.class, getDoj, empId);
										int chkmumbaicountAL = jdbcTemplate.queryForObject(
												LeaveRequestQueryUtil.CHECK_DUBAI_MAX, Integer.class, getbranch,
												getcompany, getdepartment, employee);

										if (dayscount >= 365) {
											if (chkmumbaicountAL >= noofDays) {
												if (dataBean.getAlternativeEmp() != "") {
													i = jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeavereqWitAlternative,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getAlternativeEmp(),
															dataBean.getDutyAgreed(), dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
															request_id, "Pending");
												} else {
													i = jdbcTemplate.queryForObject(
															LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
															request_id, "Pending");
													int fileUpload = jdbcTemplate.update(
															LeaveRequestQueryUtil.INSERT_FILE_PATH,
															new Object[] { request_id, dataBean.getUploadRef(),
																	teampUser.getUserId() });

												}
											} else {

												throw new CustomException(
														"No of days should not be greater than Leave Balance!");
											}

										} else {

											throw new CustomException("You are not eligible for this Leave Type!");
										}

									}

									if (saveBean.getLeaveObj().getBranch().equals("MUMBAI")
											&& leavedata.getShortName().equals("ML")) {
										if (noofDays <= 180) {

											if (dataBean.getAlternativeEmp() != "") {
												i = jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeavereqWitAlternative, request_id,
														empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
														request_id, "Pending");
											} else {
												i = jdbcTemplate.queryForObject(
														LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
														request_id, empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
														request_id, "Pending");
												int fileUpload = jdbcTemplate.update(
														LeaveRequestQueryUtil.INSERT_FILE_PATH,
														new Object[] { request_id, dataBean.getUploadRef(),
																teampUser.getUserId() });

											}

										}

										else {

											throw new CustomException(
													"No of Days should not be greater than 180 days!");
										}
									}

									if (saveBean.getLeaveObj().getBranch().equals("MUMBAI")
											&& leavedata.getShortName().equals("CL")) {

										if (dataBean.getAlternativeEmp() != "") {
											i = jdbcTemplate.update(LeaveRequestQueryUtil.insertLeavereqWitAlternative,
													request_id, empId, leaveType, date, date1, noofDays,
													dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
													dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
													dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
													dataBean.getPayType(), false, teampUser.getUserId());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
													request_id, "Pending");
										} else {
											i = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.insertLeaverequest,
													Integer.class, request_id, empId, leaveType, date, date1, noofDays,
													dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
													dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
													dataBean.getPayType(), false, teampUser.getUserId());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
													request_id, "Pending");
											int fileUpload = jdbcTemplate.update(LeaveRequestQueryUtil.INSERT_FILE_PATH,
													new Object[] { request_id, dataBean.getUploadRef(),
															teampUser.getUserId() });

										}

									}

									if (saveBean.getLeaveObj().getBranch().equals("MUMBAI")
											&& leavedata.getShortName().equals("CPL")) {

										if (dataBean.getAlternativeEmp() != "") {
											i = jdbcTemplate.update(LeaveRequestQueryUtil.insertLeavereqWitAlternative,
													request_id, empId, leaveType, date, date1, noofDays,
													dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
													dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
													dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
													dataBean.getPayType(), false, teampUser.getUserId());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
													request_id, "Pending");
										} else {
											i = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.insertLeaverequest,
													Integer.class, request_id, empId, leaveType, date, date1, noofDays,
													dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
													dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
													dataBean.getPayType(), false, teampUser.getUserId());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
													request_id, "Pending");
											int fileUpload = jdbcTemplate.update(LeaveRequestQueryUtil.INSERT_FILE_PATH,
													new Object[] { request_id, dataBean.getUploadRef(),
															teampUser.getUserId() });

										}

									}

									if (saveBean.getLeaveObj().getBranch().equals("SINGAPORE")
											&& leavedata.getShortName().equals("ML")) {
										if (noofDays <= 112) {

											if (dataBean.getAlternativeEmp() != "") {
												i = jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeavereqWitAlternative, request_id,
														empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(),
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(
														LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
														request_id, "Pending");
											} else {
												i = jdbcTemplate.queryForObject(
														LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
														request_id, empId, leaveType, date, date1, noofDays,
														dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
														dataBean.getLeavePhone(), dataBean.getLeaveMobile(), isHoliday,
														dataBean.getPayType(), false, teampUser.getUserId());
												jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
														request_id, "Pending");
												int fileUpload = jdbcTemplate.update(
														LeaveRequestQueryUtil.INSERT_FILE_PATH,
														new Object[] { request_id, dataBean.getUploadRef(),
																teampUser.getUserId() });

											}

										}

										else {

											throw new CustomException(
													"No of Days should not be greater than 112 days!");
										}
									}

									if (saveBean.getLeaveObj().getBranch().equals("SINGAPORE")
											&& leavedata.getShortName().equals("SL")) {

										String getDoj = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.GET_DOJ_DATE,
												String.class, employee);

										int dayscount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.DAYS_COUNT_SL,
												Integer.class, getDoj, empId);

										// 3 MONTHS
										if (dayscount >= 91 && dayscount <= 121) {
											if (noofDays <= 5) {
												if (dataBean.getAlternativeEmp() != "") {
													i = jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeavereqWitAlternative,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getAlternativeEmp(),
															dataBean.getDutyAgreed(), dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
															request_id, "Pending");
												} else {
													i = jdbcTemplate.queryForObject(
															LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
															request_id, "Pending");
													int fileUpload = jdbcTemplate.update(
															LeaveRequestQueryUtil.INSERT_FILE_PATH,
															new Object[] { request_id, dataBean.getUploadRef(),
																	teampUser.getUserId() });

												}

											} else {

												throw new CustomException(
														"No of Days should not be greater than 5 days!");
											}
										}
										// 4 Months
										else if (dayscount >= 121 && dayscount <= 151) {
											if (noofDays <= 8) {
												if (dataBean.getAlternativeEmp() != "") {
													i = jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeavereqWitAlternative,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getAlternativeEmp(),
															dataBean.getDutyAgreed(), dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
															request_id, "Pending");
												} else {
													i = jdbcTemplate.queryForObject(
															LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
															request_id, "Pending");
													int fileUpload = jdbcTemplate.update(
															LeaveRequestQueryUtil.INSERT_FILE_PATH,
															new Object[] { request_id, dataBean.getUploadRef(),
																	teampUser.getUserId() });

												}

											} else {

												throw new CustomException(
														"No of Days should not be greater than 8 days!");
											}
										}
										// 5 Months
										else if (dayscount >= 152 && dayscount <= 181) {
											if (noofDays <= 11) {
												if (dataBean.getAlternativeEmp() != "") {
													i = jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeavereqWitAlternative,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getAlternativeEmp(),
															dataBean.getDutyAgreed(), dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
															request_id, "Pending");
												} else {
													i = jdbcTemplate.queryForObject(
															LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
															request_id, "Pending");
													int fileUpload = jdbcTemplate.update(
															LeaveRequestQueryUtil.INSERT_FILE_PATH,
															new Object[] { request_id, dataBean.getUploadRef(),
																	teampUser.getUserId() });

												}

											} else {

												throw new CustomException(
														"No of Days should not be greater than 11 days!");
											}
										}
										// 6 Months
										else if (dayscount >= 182) {
											if (noofDays <= 14) {
												if (dataBean.getAlternativeEmp() != "") {
													i = jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeavereqWitAlternative,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getAlternativeEmp(),
															dataBean.getDutyAgreed(), dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
															request_id, "Pending");
												} else {
													i = jdbcTemplate.queryForObject(
															LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
															request_id, "Pending");
													int fileUpload = jdbcTemplate.update(
															LeaveRequestQueryUtil.INSERT_FILE_PATH,
															new Object[] { request_id, dataBean.getUploadRef(),
																	teampUser.getUserId() });

												}

											} else {

												throw new CustomException(
														"No of Days should not be greater than 14 days!");
											}
										}

										else {

											throw new CustomException("You Are Not Eligible For this Leave");
										}

									}

									if (saveBean.getLeaveObj().getBranch().equals("SINGAPORE")
											&& leavedata.getShortName().equals("AL")) {

										String getDoj = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.GET_DOJ_DATE,
												String.class, employee);

										int dayscount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.DAYS_COUNT_SL,
												Integer.class, getDoj, empId);

										int chksingaporecountmax = jdbcTemplate.queryForObject(
												LeaveRequestQueryUtil.CHECK_DUBAI_MAX, Integer.class, getbranch,
												getcompany, getdepartment, employee);
										if (dayscount >= 365) {

											if (chksingaporecountmax >= noofDays) {
												if (dataBean.getAlternativeEmp() != "") {
													i = jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeavereqWitAlternative,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getAlternativeEmp(),
															dataBean.getDutyAgreed(), dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(
															LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
															request_id, "Pending");
												} else {
													i = jdbcTemplate.queryForObject(
															LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
															request_id, empId, leaveType, date, date1, noofDays,
															dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
															dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
															isHoliday, dataBean.getPayType(), false,
															teampUser.getUserId());
													jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
															request_id, "Pending");
													int fileUpload = jdbcTemplate.update(
															LeaveRequestQueryUtil.INSERT_FILE_PATH,
															new Object[] { request_id, dataBean.getUploadRef(),
																	teampUser.getUserId() });

												}
											} else {

												throw new CustomException(
														"No of days should not be greater than Leave Balance!");
											}

										} else {

											throw new CustomException("You are not eligible for this Leave Type!");
										}

									}

									for (int iCount = 0; iCount < dates.size(); iCount++) {
										Date lDate = dates.get(iCount);
										String ds = formatter.format(lDate);
										Date sqeDate = formatter.parse(ds);
										int holidayHosCount = jdbcTemplate.queryForObject(
												LeaveRequestQueryUtil.hospitalCheck, Integer.class, sqeDate);
										if (leaveType.equals("CL")) {

										} else {
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveByDay, request_id,
													empId, sqeDate);
										}

									}
								} else {
									throw new CustomException("Requested date Exceeded");
								}

							}
						}
					} else {
						throw new CustomException("Can't give Leave Request on Holiday Date");
					}
				}

				else if (holidayList != null && saveList != null) {
					if (noofDays > 0) {
						String clfrm = dataBean.getClFromDate();
						Date clFromDate = formatter.parse(clfrm);
						String clto = dataBean.getClToDate();
						Date clToDate = formatter.parse(clto);

						String cplfrm = dataBean.getCplFromDate();
						Date cplFromDate = formatter.parse(cplfrm);
						String cplto = dataBean.getCplToDate();
						Date cplToDate = formatter.parse(cplto);

						int sda = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.CHECK_SAMPLE_DAYS, Integer.class,
								empId);

						if (sda == 1) {
							dabb = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.SAMPLE_DAYS_COUNT, Integer.class,
									empId);
						} else {
							dabb = 4;
						}

						int dummy3 = dabb;

						String WorkingDaysCheck12 = "select count(*) from leave_request where to_date(?,'dd/mm/yyyy') <= (CURRENT_DATE - interval'"
								+ dummy3 + " days' )::date and employee_id = ?";

						int k2 = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.WorkingDaysCheck, Integer.class,
								cplto, empId);

						if (k2 == 0) {

							List<Date> clDatesList = new ArrayList<Date>();
							Calendar clStart = Calendar.getInstance();
							clStart.setTime(clFromDate);
							Calendar clEnd = Calendar.getInstance();
							clEnd.setTime(clToDate);
							for (Date clDate = clStart.getTime(); !clStart.after(clEnd); clStart.add(Calendar.DATE,
									1), clDate = clStart.getTime()) {
								Calendar cal = Calendar.getInstance();
								cal.setTime(clDate);
								clDatesList.add(cal.getTime());
							}

							List<Date> cplDatesList = new ArrayList<Date>();
							List<Date> holidayInCplDateList = new ArrayList<Date>();
							Calendar cplStart = Calendar.getInstance();
							cplStart.setTime(cplFromDate);
							Calendar cplEnd = Calendar.getInstance();
							cplEnd.setTime(cplToDate);
							for (Date cplDate = cplStart.getTime(); !cplStart.after(cplEnd); cplStart.add(Calendar.DATE,
									1), cplDate = cplStart.getTime()) {
								Calendar cal = Calendar.getInstance();
								cal.setTime(cplDate);
								cplDatesList.add(cal.getTime());
								Date checkHolidayInCpl = cal.getTime();
								String ds = formatter.format(checkHolidayInCpl);
								Date checkHolidayinCplDate = formatter.parse(ds);
								int holidayHosCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
										Integer.class, checkHolidayinCplDate);

							}

							if (saveList != null) {
								Iterator<LeaveRequestLeaveBean> iterator = saveList.iterator();

								while (iterator.hasNext()) {
									LeaveRequestLeaveBean leavedata = iterator.next();

									String select = leavedata.isSelctRow();

									if (select.equalsIgnoreCase("true")) {

										String leaveType = leavedata.getShortName();
										if (dataBean.getAlternativeEmp() != "") {
											i = jdbcTemplate.update(LeaveRequestQueryUtil.insertLeavereqWitAlternative,
													request_id, empId, leaveType, clFromDate, clToDate,
													dataBean.getClLeaveDays(), dataBean.getLeaveReason(),
													dataBean.getLeaveAddress(), dataBean.getLeavePhone(),
													dataBean.getLeaveMobile(), false, dataBean.getAlternativeEmp(),
													dataBean.getDutyAgreed(), dataBean.getPayType(), false,
													dataBean.getCreated_by());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
													request_id, "Pending");
										} else {
											i = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.insertLeaverequest,
													Integer.class, request_id, empId, leaveType, clFromDate, clToDate,
													dataBean.getClLeaveDays(), dataBean.getLeaveReason(),
													dataBean.getLeaveAddress(), dataBean.getLeavePhone(),
													dataBean.getLeaveMobile(), false, dataBean.getPayType(), false,
													teampUser.getUserId());
											jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction,
													request_id, "Pending");
										}

										for (int iCount = 0; iCount < clDatesList.size(); iCount++) {
											Date lDate = clDatesList.get(iCount);
											String ds = formatter.format(lDate);
											Date sqeDate = formatter.parse(ds);
											int holidayHosCount = jdbcTemplate.queryForObject(
													LeaveRequestQueryUtil.hospitalCheck, Integer.class, sqeDate);
											if (leaveType.equals("CL")) {
												// if (empCategory.equals("H")) {
												if (holidayHosCount == 0) {
													jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveByDay,
															request_id, empId, sqeDate);
												} else {
													int plRequestId = jdbcTemplate.queryForObject(
															LeaveRequestQueryUtil.maxQuery, Integer.class);
													if (dataBean.getAlternativeEmp() != "") {
														i = jdbcTemplate.update(
																LeaveRequestQueryUtil.insertLeavereqWitAlternative,
																plRequestId, empId, "PL", sqeDate, sqeDate, 1,
																dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
																dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
																false, dataBean.getAlternativeEmp(),
																dataBean.getDutyAgreed(), dataBean.getPayType(), false,
																dataBean.getCreated_by());
														jdbcTemplate.update(
																LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
																plRequestId, "Pending");
														jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveByDay,
																plRequestId, empId, sqeDate);
													} else {
														i = jdbcTemplate.queryForObject(
																LeaveRequestQueryUtil.insertLeaverequest, Integer.class,
																plRequestId, empId, "PL", sqeDate, sqeDate, 1,
																dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
																dataBean.getLeavePhone(), dataBean.getLeaveMobile(),
																false, dataBean.getPayType(), false,
																teampUser.getUserId());
														jdbcTemplate.update(
																LeaveRequestQueryUtil.insertLeaveRequestAction,
																plRequestId, "Pending");
														jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveByDay,
																plRequestId, empId, sqeDate);
													}
												}

											}

										}

									}
								}
							}

							if (holidayList != null) {
								String leaveType = null;

								int cplRequestId = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.maxQuery,
										Integer.class);
								if (dataBean.getAlternativeEmp() != "") {
									i = jdbcTemplate.update(LeaveRequestQueryUtil.insertLeavereqWitAlternative,
											cplRequestId, empId, leaveType, cplFromDate, cplToDate,
											dataBean.getCplLeaveDays(), dataBean.getLeaveReason(),
											dataBean.getLeaveAddress(), dataBean.getLeavePhone(),
											dataBean.getLeaveMobile(), isHoliday, dataBean.getAlternativeEmp(),
											dataBean.getDutyAgreed(), dataBean.getPayType(), false,
											dataBean.getCreated_by());
									jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestActionAlternate,
											cplRequestId, "Pending");
								} else {
									i = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.insertLeaverequest,
											Integer.class, cplRequestId, empId, leaveType, cplFromDate, cplToDate,
											dataBean.getCplLeaveDays(), dataBean.getLeaveReason(),
											dataBean.getLeaveAddress(), dataBean.getLeavePhone(),
											dataBean.getLeaveMobile(), isHoliday, dataBean.getPayType(), false,
											teampUser.getUserId());
									jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveRequestAction, cplRequestId,
											"Pending");
								}

								int count = 0;
								List<LeaveRequestHolidayBean> selectList = new ArrayList<LeaveRequestHolidayBean>();
								for (LeaveRequestHolidayBean value : holidayList) {
									if (value.getSelect() == true) {
										count = count + 1;
										selectList.add(value);
									}
								}
								List<LeaveRequestHolidayBean> selectedList = new ArrayList<LeaveRequestHolidayBean>();
								double size = selectList.size();
								for (int b = 0; b < size; b++) {
									selectedList.add(selectList.get(b));
								}

								int k = 0;
								Iterator<LeaveRequestHolidayBean> iterator = selectedList.iterator();
								while (iterator.hasNext()) {
									LeaveRequestHolidayBean leavedata = iterator.next();
									int holidayId = leavedata.getHolidayId();
									if (leavedata.getSelect() == true) {
										Date lDate = holidayInCplDateList.get(k);
										String ds = formatter.format(lDate);
										Date sqeDate = formatter.parse(ds);
										jdbcTemplate.update(LeaveRequestQueryUtil.holidayRequestQueryWithLeave,
												cplRequestId, true, sqeDate, holidayId);
										jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveByDay, cplRequestId, empId,
												sqeDate);
									}
									k++;
								}

								for (int iCount = 0; iCount < cplDatesList.size(); iCount++) {
									Date lDate = cplDatesList.get(iCount);
									String ds = formatter.format(lDate);
									Date sqeDate = formatter.parse(ds);
									int holidayHosCount = jdbcTemplate.queryForObject(
											LeaveRequestQueryUtil.hospitalCheck, Integer.class, sqeDate);

								}
							}
						} else {
							throw new CustomException("Requested Date Limit Exceeded");
						}
					} else {
						throw new CustomException("Can't give Leave Request on Holiday Date");
					}
				}
				for (String upload : saveBean.getLeaveObj().getSupportDoc()) {
					jdbcTemplate.update(LeaveRequestQueryUtil.INSERT_JR_FILE_UPLOAD, i, upload);
				}
			} else {
				throw new CustomException("Already you have requested Leave for this Date");
			}
		} else {
			throw new CustomException("You can't apply leave before your Joining Date");
		}

		if (i > 0) {
			isSucess = true;
		}

		return isSucess;

	}

	@Override
	public LeaveRequestResultBean getHolidayList(LeaveRequestBean leaveRequestBean) throws Exception {
		// TODO Auto-generated method stub
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int year1 = year - 1;
		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		List<LeaveRequestHolidayBean> resultList = new ArrayList<LeaveRequestHolidayBean>();
		List<LeaveRequestLeaveBean> holidayLeaveList = new ArrayList<LeaveRequestLeaveBean>();
		LeaveRequestLeaveBean holidayLeaveBean = new LeaveRequestLeaveBean();
		try {
			int balance = 0;
			String holidayLeave = "CPL";
			int availed = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.holidayRestrict, Integer.class,
					teampUser.getUserId());
			int holidayLeaveAvailable = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getHolidayAvailable,
					Integer.class, teampUser.getUserId());
			int holidayTotalLeaveAvailable = jdbcTemplate.queryForObject(
					LeaveRequestQueryUtil.getHolidayTotalLeaveAvailable, Integer.class, teampUser.getUserId());
			int holidayYearLimit = 20;
			int holidayLeaveBalance = holidayYearLimit - availed;
			// Added By Kathir
			int available = holidayTotalLeaveAvailable - holidayLeaveAvailable;

			if (holidayTotalLeaveAvailable <= holidayYearLimit) {
				balance = holidayTotalLeaveAvailable - available;
			} else {

				if (availed < 20)
					balance = holidayTotalLeaveAvailable - available;
				else
					balance = 0;

			}

			holidayLeaveBean.setLeaveName(holidayLeave);
			holidayLeaveBean.setAllowedLeave(String.valueOf(availed + holidayLeaveAvailable));
			holidayLeaveBean.setConsumed(String.valueOf(availed));

			if (balance > 0 && balance <= 20)
				holidayLeaveBean.setBalance(String.valueOf(balance));
			else
				holidayLeaveBean.setBalance(String.valueOf(holidayLeaveAvailable));

			holidayLeaveBean.setYearlyMaximum(String.valueOf(holidayLeaveBalance));
			holidayLeaveList.add(holidayLeaveBean);
			if (leaveRequestBean.getIsEdit().equals("false")) {
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getHolidayListQuery,
						new Object[] { teampUser.getUserId() });
				for (Map row : rows) {
					LeaveRequestHolidayBean hBean = new LeaveRequestHolidayBean();
					hBean.setHolidayId((int) row.get("holidayId"));
					hBean.setHolidayWorked((String) row.get("holidayWorked"));
					hBean.setComments((String) row.get("comments"));
					hBean.setReason((String) row.get("reason"));
					hBean.setHoursWorked((String) row.get("hoursWorked"));
					hBean.setLeaveId((Long) row.get("leaveId"));
					resultList.add(hBean);
				}
			} else {
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(
						LeaveRequestQueryUtil.getHolidayEditListQuery,
						new Object[] { teampUser.getUserId(), leaveRequestBean.getLeaveRequestId() });
				for (Map row : rows) {
					LeaveRequestHolidayBean hBean = new LeaveRequestHolidayBean();
					hBean.setHolidayId((int) row.get("holidayId"));
					hBean.setHolidayWorked((String) row.get("holidayWorked"));
					hBean.setComments((String) row.get("comments"));
					hBean.setReason((String) row.get("reason"));
					hBean.setHoursWorked((String) row.get("hoursWorked"));
					hBean.setLeaveId((Long) row.get("leaveId"));
					resultList.add(hBean);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		resultBean.setHolidayList(resultList);
		resultBean.setLeaveList(holidayLeaveList);
		return resultBean;
	}

	@Override
	public LeaveRequestBean getEditList(int requestId) throws Exception {

		LeaveRequestBean resultBean = new LeaveRequestBean();

		List<LeaveRequestBean> internalList = new ArrayList<LeaveRequestBean>();
		List<LeaveRequestBean> fileList = new ArrayList<LeaveRequestBean>();
		List<LeaveRequestBean> approvalList = new ArrayList<LeaveRequestBean>();

		List<String> uploadedUrls = new ArrayList<String>();
		int i;
		try {
			resultBean = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.editQuery, new Object[] { requestId },
					new BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class));
			internalList = jdbcTemplate.query(LeaveRequestQueryUtil.editQueryforurl, new Object[] { requestId },
					new BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class));
		

			 approvalList = jdbcTemplate.query(LeaveRequestQueryUtil.GET_APPROVAL_LIST, new Object[] {requestId} ,
					 new BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class));
							
			
			fileList = jdbcTemplate.query(LeaveRequestQueryUtil.fileuploadinvoicelist, new Object[] { requestId },
					new BeanPropertyRowMapper<>(LeaveRequestBean.class));

			resultBean.setFileuploadlist(fileList);
			 resultBean.setApprovalList(approvalList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	// Update function
	@Override
	public boolean updateLeaveData(LeaveRequestResultBean updateBean) throws Exception {
		// TODO Auto-generated method stub
		boolean sucess = false;
		int i = 0;
		
	
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String empId = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.SELECT_EMP_ID, String.class,
				teampUser.getUserId());

		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();

		LeaveRequestBean dataBean = updateBean.getLeaveObj();
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		String fDate = dataBean.getFromDate();

		Date date = formatter.parse(fDate);
		java.sql.Timestamp fromDate = new Timestamp(date.getTime());
		String tDate = dataBean.getToDate();

		Date date1 = formatter.parse(tDate);
		java.sql.Timestamp toDate = new Timestamp(date.getTime());
		String appOn = dataBean.getAppliedOn();

		Date date2 = formatter.parse(appOn);
		java.sql.Timestamp appliedOn = new Timestamp(date.getTime());
		String noofdays = dataBean.getNoOfDays();
		double noofDays = Double.parseDouble(noofdays);

		int leave_id = dataBean.getLeaveRequestId();
		boolean isHoliday = dataBean.getisHoliday();
		List<LeaveRequestLeaveBean> saveList = updateBean.getLeaveList();
		List<LeaveRequestHolidayBean> holidayList = updateBean.getHolidayList();

		try {

			int holidayCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.checkHoliday, Integer.class, date,
					date1);
			if (holidayList != null) {
				Iterator<LeaveRequestHolidayBean> iterator = holidayList.iterator();
				if (holidayCount == 0) {
					String leaveType = null;
					if (dataBean.getAlternativeEmp() != "" && dataBean.getAlternativeEmp() != null) {
						i = jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveReqWitAlternative, empId, date, date1,
								noofDays, dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
								dataBean.getLeavePhone(), dataBean.getLeaveMobile(), dataBean.getMdUrl(), isHoliday,
								dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(), dataBean.getPayType(),
								dataBean.getModified_by(), dataBean.getModified_on(), leave_id);
						jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveReqActionWithAlt, leave_id);
					} else {
						i = jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveQuery, empId, date, date1, noofDays,
								dataBean.getLeaveReason(), dataBean.getLeaveAddress(), dataBean.getLeavePhone(),
								dataBean.getLeaveMobile(), null, isHoliday, dataBean.getPayType(),
								teampUser.getUserId(), leave_id);
						jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveReqAction, leave_id);
					}
					while (iterator.hasNext()) {

						LeaveRequestHolidayBean leavedata = iterator.next();

						String select = leavedata.getSelctRow();
						int holidayId = leavedata.getHolidayId();
						if (leavedata.getSelect() == true) {

							int j = jdbcTemplate.update(LeaveRequestQueryUtil.holidayRequestQuery,
									dataBean.getLeaveRequestId(), true, holidayId);
						}

					}
				} else {
					throw new CustomException("Cannot give Leave Request on Holiday Date");
				}
			}

			if (saveList != null) {
				Iterator<LeaveRequestLeaveBean> iterator = saveList.iterator();
				if (noofDays == 0.5 || noofDays == 1) {
					if (holidayCount == 0) {

						if (dataBean.getAlternativeEmp() != "" && dataBean.getAlternativeEmp() != null) {
							i = jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveReqWitAlternative, empId, date,
									date1, noofDays, dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
									dataBean.getLeavePhone(), dataBean.getLeaveMobile(), dataBean.getMdUrl(), isHoliday,
									dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(), dataBean.getPayType(),
									dataBean.getModified_by(), leave_id);
							jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveReqActionWithAlt, leave_id);
						} else {
							i = jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveQuery, empId, date, date1,
									noofDays, dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
									dataBean.getLeavePhone(), dataBean.getLeaveMobile(), null, isHoliday,
									dataBean.getPayType(), teampUser.getUserId(), leave_id);
							jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveReqAction, leave_id);
						}

					} else {
						throw new CustomException("Cannot give Leave Request on Holiday Date");
					}
				} else {

					if (dataBean.getAlternativeEmp() != "" && dataBean.getAlternativeEmp() != null) {
						i = jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveReqWitAlternative, empId, date, date1,
								noofDays, dataBean.getLeaveReason(), dataBean.getLeaveAddress(),
								dataBean.getLeavePhone(), dataBean.getLeaveMobile(), dataBean.getMdUrl(), isHoliday,
								dataBean.getAlternativeEmp(), dataBean.getDutyAgreed(), dataBean.getPayType(),
								dataBean.getModified_by(), leave_id);
						jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveReqActionWithAlt, leave_id);
					} else {
						i = jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveQuery, empId, date, date1, noofDays,
								dataBean.getLeaveReason(), dataBean.getLeaveAddress(), dataBean.getLeavePhone(),
								dataBean.getLeaveMobile(), null, isHoliday, dataBean.getPayType(),
								teampUser.getUserId(), leave_id);
						jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveReqAction, leave_id);
					}
				}

			}

			i = jdbcTemplate.update(LeaveRequestQueryUtil.DELETE_FILE_PATH, leave_id);

			int fileUpload = jdbcTemplate.update(LeaveRequestQueryUtil.INSERT_FILE_PATH,
					new Object[] { leave_id, dataBean.getUploadRef(), teampUser.getUserId() });

			/*
			 * if (i > 0) { jdbcTemplate.update(LeaveRequestQueryUtil.DELETE_JR_FILE_UPLOAD,
			 * leave_id); for (String upload : updateBean.getLeaveObj().getSupportDoc()) {
			 * jdbcTemplate.update(LeaveRequestQueryUtil.INSERT_JR_FILE_UPLOAD, leave_id,
			 * upload); }
			 */
	
			sucess = true;
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucess;
	}

	@Override
	public boolean deleteLeave(int leaveRequestId) throws Exception {
		// TODO Auto-generated method stub
		boolean isSucess = false;
		jdbcTemplate.update(LeaveRequestQueryUtil.DELETE_JR_FILE_UPLOAD, leaveRequestId);
		jdbcTemplate.update(LeaveRequestQueryUtil.deleteLeaveByDay, leaveRequestId);
		int j = jdbcTemplate.update(LeaveRequestQueryUtil.deleteleaveAction, leaveRequestId);
		int i = jdbcTemplate.update(LeaveRequestQueryUtil.deleteLeaveQuery, leaveRequestId);
		// List<LeaveRequestBean> holidayIdList =
		// jdbcTemplate.query(LeaveAppCancelQueryUtil.getHolidayId, new
		// BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class),
		// leaveRequestId);
		List<Map<String, Object>> holidayIdList = jdbcTemplate.queryForList(LeaveAppCancelQueryUtil.getHolidayId,
				leaveRequestId);

		for (Map row : holidayIdList) {
			if ((int) row.get("id") != 0) {
				jdbcTemplate.update(LeaveRequestQueryUtil.holidayRequestQuery, 0, false, (int) row.get("id"));
			}
		}

		if (i > 0) {
			isSucess = true;
		}

		return isSucess;
	}

	// @Override
	// public LeaveRequestResultBean getEmployeeList() throws Exception {
	// LeaveRequestResultBean leaveRequestResultBean = new
	// LeaveRequestResultBean();
	// List<LeaveRequestBean> employeeList = new ArrayList<LeaveRequestBean>();
	// try {
	// employeeList =
	// jdbcTemplate.query(LeaveRequestQueryUtil.get_Employee_List, new
	// BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class));
	// leaveRequestResultBean.setEmployeeList(employeeList);
	// leaveRequestResultBean.setSuccess(true);
	// return leaveRequestResultBean;
	//
	// } catch (DataAccessException e) {
	// LOGGER.error("Error in Employee List", e);
	// throw new CustomException(ErrorMessage.ERROR_LIST);
	// }
	// }

	@Override
	public LeaveRequestBean getEmployeeDetails() throws Exception {
		LeaveRequestBean empDetailList = new LeaveRequestBean();
		List<SelectivityBean> alternativeList = new ArrayList<SelectivityBean>();
		try {
			UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String empId = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.SELECT_EMP_ID, String.class,
					empUser.getUserId());

			empDetailList = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.employeeDetailsList,
					new BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class), empId);

			alternativeList = jdbcTemplate.query(LeaveRequestQueryUtil.getAlternativeList,
					new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class), empDetailList.getGradeId(),
					empId);
			try {
				empDetailList.setNoOfDaysCL(
						jdbcTemplate.queryForObject(LeaveRequestQueryUtil.LeaveTypeDetails, (String.class)));
			} catch (EmptyResultDataAccessException ex) {

			}
			try {
				empDetailList.setNoOfDaysCPL(
						jdbcTemplate.queryForObject(LeaveRequestQueryUtil.LeaveTypeDetailsCPL, (String.class)));
			} catch (EmptyResultDataAccessException ex) {

			}
			try {
				empDetailList.setNoOfDaysEL(
						jdbcTemplate.queryForObject(LeaveRequestQueryUtil.LeaveTypeDetailsEL, (String.class)));
			} catch (EmptyResultDataAccessException ex) {

			}
			try {
				empDetailList.setNoOfDaysML(
						jdbcTemplate.queryForObject(LeaveRequestQueryUtil.LeaveTypeDetailsML, (String.class)));
			} catch (EmptyResultDataAccessException ex) {

			}
			try {
				empDetailList.setNoOfDaysHPL(
						jdbcTemplate.queryForObject(LeaveRequestQueryUtil.LeaveTypeDetailsHPL, (String.class)));
			} catch (EmptyResultDataAccessException ex) {

			}
			empDetailList.setAlternativeList(alternativeList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeeDetails", e);
		}

		return empDetailList;
	}

	@Override
	public LeaveRequestResultBean getLeaveNotification() throws CustomException {
		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		List<LeaveRequestBean> leaveList = new ArrayList<LeaveRequestBean>();
		UserDetail loginUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			// leaveList =
			// jdbcTemplate.query(LeaveRequestQueryUtil.alternativeNotify, new
			// BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class),
			// loginUser.getUserId());
			// leaveList =
			// jdbcTemplate.query(LeaveRequestQueryUtil.reportingEmpNotify, new
			// BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class),
			// loginUser.getUserId());
			// leaveList =
			// jdbcTemplate.query(LeaveRequestQueryUtil.finalEmpNotify, new
			// BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class),
			// loginUser.getUserId());
			List<Map<String, Object>> alternateEmpRows = jdbcTemplate
					.queryForList(LeaveRequestQueryUtil.alternateEmpNotify, loginUser.getUserId());
			for (Map row : alternateEmpRows) {
				LeaveRequestBean alternateBean = new LeaveRequestBean();
				alternateBean.setEmpName((String) row.get("empName"));
				alternateBean.setNotifyStatus((int) row.get("notifyStatus"));
				alternateBean.setFromDate((String) row.get("fromDate"));
				alternateBean.setApprovalType("Alternative Employee");
				alternateBean.setCancelRequest((boolean) row.get("cancelRequest"));
				leaveList.add(alternateBean);
			}

			List<Map<String, Object>> reportingEmpRows = jdbcTemplate
					.queryForList(LeaveRequestQueryUtil.reportingEmpNotify, loginUser.getUserId());
			for (Map row1 : reportingEmpRows) {
				LeaveRequestBean reportingBean = new LeaveRequestBean();
				reportingBean.setEmpName((String) row1.get("empName"));
				reportingBean.setNotifyStatus((int) row1.get("notifyStatus"));
				reportingBean.setFromDate((String) row1.get("fromDate"));
				reportingBean.setApprovalType("Reporting Employee");
				reportingBean.setCancelRequest((boolean) row1.get("cancelRequest"));
				leaveList.add(reportingBean);
			}

			List<Map<String, Object>> finalEmpRows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.finalEmpNotify,
					loginUser.getUserId());
			for (Map row2 : finalEmpRows) {
				LeaveRequestBean finalBean = new LeaveRequestBean();
				finalBean.setEmpName((String) row2.get("empName"));
				finalBean.setNotifyStatus((int) row2.get("notifyStatus"));
				finalBean.setFromDate((String) row2.get("fromDate"));
				finalBean.setApprovalType("Final Level");
				leaveList.add(finalBean);
			}
			resultBean.setLeaveRequestList(leaveList);

			if (resultBean.getLeaveRequestList().size() > 0) {
				resultBean.setSuccess(true);
			} else {
				resultBean.setSuccess(false);
			}
		} catch (Exception e) {
			LOGGER.error("Error in getLeaveNotification", e);
		}

		return resultBean;
	}

	@Override
	public void cancelRequest(LeaveRequestBean leaveRequestBean) throws CustomException {
		try {
			if (leaveRequestBean.isWholeLeave() == true) {
				jdbcTemplate.update(LeaveRequestQueryUtil.cancelRequest, leaveRequestBean.getLeaveRequestId());
			} else {
				DateFormat formatter;
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date fromDate = formatter.parse(leaveRequestBean.getFromDate());
				Date toDate = formatter.parse(leaveRequestBean.getToDate());
				Date canFromDate = formatter.parse(leaveRequestBean.getCancelFromDate());
				Date canToDate = formatter.parse(leaveRequestBean.getCancelToDate());

				List<Date> dates = new ArrayList<Date>();
				Calendar start = Calendar.getInstance();
				start.setTime(canFromDate);
				Calendar end = Calendar.getInstance();
				end.setTime(canToDate);

				for (Date datecheck = start.getTime(); !start.after(end); start.add(Calendar.DATE,
						1), datecheck = start.getTime()) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(datecheck);
					dates.add(cal.getTime());
				}

				if (leaveRequestBean.getMdUrl().equals("B")) {
					Date actualFromDate = new Date(canToDate.getTime() + (1000 * 60 * 60 * 24));
					// if (leaveRequestBean.getCancelDays() > 1) {
					// } else {
					// actualFromDate = canToDate;
					// }

					for (int iCount = 0; iCount < dates.size(); iCount++) {
						Date lDate = dates.get(iCount);
						String ds = formatter.format(lDate);
						Date sqeDate = formatter.parse(ds);
						String query = LeaveRequestQueryUtil.deleteLeaveByDay + " and leave_date=?";
						jdbcTemplate.update(query, leaveRequestBean.getLeaveRequestId(), sqeDate);
					}
					int request_id = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.maxQuery, Integer.class);
					jdbcTemplate.update(LeaveRequestQueryUtil.updateRequestWhileCancel, actualFromDate, toDate,
							Integer.parseInt(leaveRequestBean.getNoOfDays()), leaveRequestBean.getLeaveRequestId());

					if (leaveRequestBean.getCancelDays() > 0) {
						List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveData,
								new Object[] { leaveRequestBean.getLeaveRequestId() });
						for (Map row : rows) {
							jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveRequest, request_id,
									row.get("employee_id"), row.get("leave_type"), canFromDate, canToDate,
									leaveRequestBean.getCancelDays(), row.get("reason"), row.get("leave_address"),
									row.get("leave_phone"), row.get("leave_mobile"), row.get("applied_on"),
									row.get("isholiday"), row.get("alternative_employee"),
									row.get("alternative_duty_agreed"), row.get("medical_document_url"),
									row.get("pay_type"), true);

							jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveAction, request_id,
									row.get("action_datetime"), row.get("action_by"), row.get("comments"),
									row.get("status"), row.get("description"), row.get("final_approval_status"),
									row.get("alternate_emp_approval_status"), row.get("approval_type"),
									row.get("alternate_emp_date"), row.get("report_emp_date"),
									row.get("final_emp_date"));

							for (int iCount = 0; iCount < dates.size(); iCount++) {
								Date lDate = dates.get(iCount);
								String ds = formatter.format(lDate);
								Date leaveDate = formatter.parse(ds);
								jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveByDay, request_id,
										row.get("employee_id"), leaveDate, row.get("applied_on"));
								if (leaveRequestBean.getLeaveType().equals("CPL")) {
									jdbcTemplate.update(LeaveRequestQueryUtil.holidayRequestUpdateLeaveDate, request_id,
											true, leaveRequestBean.getLeaveRequestId(), leaveDate);
								}
							}

						}
					}

					if (Integer.parseInt(leaveRequestBean.getNoOfDays()) == 0) {
						jdbcTemplate.update(LeaveRequestQueryUtil.deleteleaveAction,
								leaveRequestBean.getLeaveRequestId());
						jdbcTemplate.update(LeaveRequestQueryUtil.deleteLeaveQuery,
								leaveRequestBean.getLeaveRequestId());
					}

				} else if (leaveRequestBean.getMdUrl().equals("E")) {
					Date actualToDate = new Date(canFromDate.getTime() - (1000 * 60 * 60 * 24));
					// if (leaveRequestBean.getCancelDays() > 1) {
					// } else {
					// actualToDate = canFromDate;
					// }

					for (int iCount = 0; iCount < dates.size(); iCount++) {
						Date lDate = dates.get(iCount);
						String ds = formatter.format(lDate);
						Date sqeDate = formatter.parse(ds);
						String query = LeaveRequestQueryUtil.deleteLeaveByDay + " and leave_date=?";
						jdbcTemplate.update(query, leaveRequestBean.getLeaveRequestId(), sqeDate);
					}
					int request_id = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.maxQuery, Integer.class);
					jdbcTemplate.update(LeaveRequestQueryUtil.updateRequestWhileCancel, fromDate, actualToDate,
							Integer.parseInt(leaveRequestBean.getNoOfDays()), leaveRequestBean.getLeaveRequestId());

					if (leaveRequestBean.getCancelDays() > 0) {
						List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveData,
								new Object[] { leaveRequestBean.getLeaveRequestId() });
						for (Map row : rows) {

							jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveRequest, request_id,
									row.get("employee_id"), row.get("leave_type"), canFromDate, canToDate,
									leaveRequestBean.getCancelDays(), row.get("reason"), row.get("leave_address"),
									row.get("leave_phone"), row.get("leave_mobile"), row.get("applied_on"),
									row.get("isholiday"), row.get("alternative_employee"),
									row.get("alternative_duty_agreed"), row.get("medical_document_url"),
									row.get("pay_type"), true);

							jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveAction, request_id,
									row.get("action_datetime"), row.get("action_by"), row.get("comments"),
									row.get("status"), row.get("description"), row.get("final_approval_status"),
									row.get("alternate_emp_approval_status"), row.get("approval_type"),
									row.get("alternate_emp_date"), row.get("report_emp_date"),
									row.get("final_emp_date"));

							for (int iCount = 0; iCount < dates.size(); iCount++) {
								Date lDate = dates.get(iCount);
								String ds = formatter.format(lDate);
								Date leaveDate = formatter.parse(ds);
								jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveByDay, request_id,
										row.get("employee_id"), leaveDate, row.get("applied_on"));
								if (leaveRequestBean.getLeaveType().equals("CPL")) {
									jdbcTemplate.update(LeaveRequestQueryUtil.holidayRequestUpdateLeaveDate, request_id,
											true, leaveRequestBean.getLeaveRequestId(), leaveDate);
								}
							}

						}
					}

					if (Integer.parseInt(leaveRequestBean.getNoOfDays()) == 0) {
						jdbcTemplate.update(LeaveRequestQueryUtil.deleteleaveAction,
								leaveRequestBean.getLeaveRequestId());
						jdbcTemplate.update(LeaveRequestQueryUtil.deleteLeaveQuery,
								leaveRequestBean.getLeaveRequestId());
					}

				} else if (leaveRequestBean.getMdUrl().equals("M")) {
					Date actualFromDate = new Date(canToDate.getTime() + (1000 * 60 * 60 * 24));
					Date actualToDate = new Date(canFromDate.getTime() - (1000 * 60 * 60 * 24));

					List<Date> endDateList = new ArrayList<Date>();
					Calendar eStartDate = Calendar.getInstance();
					eStartDate.setTime(actualFromDate);
					Calendar eEndDate = Calendar.getInstance();
					eEndDate.setTime(toDate);

					for (Date eDatecheck = eStartDate.getTime(); !eStartDate.after(eEndDate); eStartDate
							.add(Calendar.DATE, 1), eDatecheck = eStartDate.getTime()) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(eDatecheck);
						endDateList.add(cal.getTime());
					}

					// List<Date> holidayCalList = new ArrayList<Date>();
					Calendar holidayStartDate = Calendar.getInstance();
					holidayStartDate.setTime(fromDate);
					Calendar holidayEndDate = Calendar.getInstance();
					holidayEndDate.setTime(actualToDate);

					int beginningDays = 0;
					for (Date holidayCheck = holidayStartDate.getTime(); !holidayStartDate
							.after(holidayEndDate); holidayStartDate.add(Calendar.DATE,
									1), holidayCheck = holidayStartDate.getTime()) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(holidayCheck);
						// holidayCalList.add(cal.getTime());
						beginningDays = beginningDays + 1;
					}

					String date1[] = leaveRequestBean.getCancelFromDate().split("/");
					LeaveRequestBean leaveCheck = new LeaveRequestBean();
					leaveCheck.setLeaveRequestId(leaveRequestBean.getLeaveRequestId());
					leaveCheck.setFromDate(leaveRequestBean.getFromDate());
					String setDate = (Integer.parseInt(date1[0]) - 1) + "/" + (date1[1]) + "/" + (date1[2]);
					leaveCheck.setToDate(setDate);
					leaveCheck.setLeaveType(leaveRequestBean.getLeaveType());
					leaveCheck.setNoOfDays(String.valueOf(beginningDays));
					LeaveRequestBean getVal = leaveExclude(leaveCheck);
					double getNoOfDays = Double.parseDouble(leaveRequestBean.getNoOfDays()) - getVal.getLeaveDays();
					jdbcTemplate.update(LeaveRequestQueryUtil.updateRequestWhileCancel, fromDate, actualToDate,
							getVal.getLeaveDays(), leaveRequestBean.getLeaveRequestId());

					List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveData,
							new Object[] { leaveRequestBean.getLeaveRequestId() });
					for (Map row : rows) {

						int request_id = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.maxQuery, Integer.class);
						jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveRequest, request_id,
								row.get("employee_id"), row.get("leave_type"), canFromDate, canToDate,
								leaveRequestBean.getCancelDays(), row.get("reason"), row.get("leave_address"),
								row.get("leave_phone"), row.get("leave_mobile"), row.get("applied_on"),
								row.get("isholiday"), row.get("alternative_employee"),
								row.get("alternative_duty_agreed"), row.get("medical_document_url"),
								row.get("pay_type"), true);

						jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveAction, request_id,
								row.get("action_datetime"), row.get("action_by"), row.get("comments"),
								row.get("status"), row.get("description"), row.get("final_approval_status"),
								row.get("alternate_emp_approval_status"), row.get("approval_type"),
								row.get("alternate_emp_date"), row.get("report_emp_date"), row.get("final_emp_date"));

						for (int iCount = 0; iCount < dates.size(); iCount++) {
							Date lDate = dates.get(iCount);
							String ds = formatter.format(lDate);
							Date leaveDate = formatter.parse(ds);
							String query = LeaveRequestQueryUtil.deleteLeaveByDay + " and leave_date=?";
							jdbcTemplate.update(query, leaveRequestBean.getLeaveRequestId(), leaveDate);
							jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveByDay, request_id,
									row.get("employee_id"), leaveDate, row.get("applied_on"));
							if (leaveRequestBean.getLeaveType().equals("CPL")) {
								jdbcTemplate.update(LeaveRequestQueryUtil.holidayRequestUpdateLeaveDate, request_id,
										true, leaveRequestBean.getLeaveRequestId(), leaveDate);
							}
						}

						if (getNoOfDays > 0) {
							int requestId = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.maxQuery, Integer.class);
							jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveRequest, requestId,
									row.get("employee_id"), row.get("leave_type"), actualFromDate, toDate, getNoOfDays,
									row.get("reason"), row.get("leave_address"), row.get("leave_phone"),
									row.get("leave_mobile"), row.get("applied_on"), row.get("isholiday"),
									row.get("alternative_employee"), row.get("alternative_duty_agreed"),
									row.get("medical_document_url"), row.get("pay_type"), false);

							jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveAction, requestId,
									row.get("action_datetime"), row.get("action_by"), row.get("comments"),
									row.get("status"), row.get("description"), row.get("final_approval_status"),
									row.get("alternate_emp_approval_status"), row.get("approval_type"),
									row.get("alternate_emp_date"), row.get("report_emp_date"),
									row.get("final_emp_date"));

							for (int iCount = 0; iCount < endDateList.size(); iCount++) {
								Date lDate = endDateList.get(iCount);
								String ds = formatter.format(lDate);
								Date leaveDate = formatter.parse(ds);
								String query = LeaveRequestQueryUtil.deleteLeaveByDay + " and leave_date=?";
								jdbcTemplate.update(query, leaveRequestBean.getLeaveRequestId(), leaveDate);
								jdbcTemplate.update(LeaveRequestQueryUtil.insertCancelLeaveByDay, requestId,
										row.get("employee_id"), leaveDate, row.get("applied_on"));
								if (leaveRequestBean.getLeaveType().equals("CPL")) {
									jdbcTemplate.update(LeaveRequestQueryUtil.holidayRequestUpdateLeaveDate, requestId,
											true, leaveRequestBean.getLeaveRequestId(), leaveDate);
								}
							}
						}

						if (getVal.getLeaveDays() == 0) {
							jdbcTemplate.update(LeaveRequestQueryUtil.deleteleaveAction,
									leaveRequestBean.getLeaveRequestId());
							jdbcTemplate.update(LeaveRequestQueryUtil.deleteLeaveQuery,
									leaveRequestBean.getLeaveRequestId());
						}

					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public LeaveRequestBean leaveExclude(LeaveRequestBean leaveRequestBean) throws Exception {
		LeaveRequestBean checkHolidayBean = new LeaveRequestBean();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String fDate = leaveRequestBean.getFromDate();
		Date date = formatter.parse(fDate);
		String tDate = leaveRequestBean.getToDate();
		Date date1 = formatter.parse(tDate);
		UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int holidayCountHos = 0;
		int holidayCountCol = 0;
		double excludeVal = 0;
		double leaveDays = 0;
		String noofdays = leaveRequestBean.getNoOfDays();
		double noofDays = Double.parseDouble(noofdays);
		boolean checkWorkingDay;

		List<Date> dates = new ArrayList<Date>();
		Calendar start = Calendar.getInstance();
		start.setTime(date);
		Calendar end = Calendar.getInstance();
		end.setTime(date1);

		for (Date datecheck = start.getTime(); !start.after(end); start.add(Calendar.DATE,
				1), datecheck = start.getTime()) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(datecheck);
			dates.add(cal.getTime());
		}

		try {
			leaveDays = noofDays;
			// String empCategory =
			// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.userCategory, String.class,
			// empUser.getUserId());
			if (leaveRequestBean.getLeaveType().equals("CL") || leaveRequestBean.getLeaveType().equals("CPL")) {
				for (int iCount = 0; iCount < dates.size(); iCount++) {
					Date lDate = dates.get(iCount);
					String ds = formatter.format(lDate);
					Date sqeDate = formatter.parse(ds);
					checkWorkingDay = false;
					// int weeklyOffCheck =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weeklyOffCount,
					// Integer.class, empUser.getUserId(), sqeDate);
					// int weekEndCheck =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weekEndCount,
					// Integer.class, empUser.getUserId(), sqeDate);
					/*
					 * if (empCategory.equals("H")) { if (weeklyOffCheck == 0 && weekEndCheck == 0)
					 * { holidayCountHos =
					 * jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
					 * Integer.class, sqeDate); } if (weeklyOffCheck > 0 || weekEndCheck > 0 ||
					 * holidayCountHos > 0) { excludeVal = weeklyOffCheck + weekEndCheck +
					 * holidayCountHos; leaveDays = leaveDays - excludeVal; } } else { if
					 * (weeklyOffCheck == 0 && weekEndCheck == 0) { holidayCountCol =
					 * jdbcTemplate.queryForObject(LeaveRequestQueryUtil.collegeCheck,
					 * Integer.class, sqeDate); } if (weeklyOffCheck > 0 || weekEndCheck > 0 ||
					 * holidayCountCol > 0) { excludeVal = weeklyOffCheck + weekEndCheck +
					 * holidayCountCol; leaveDays = leaveDays - excludeVal; } }
					 */
				}
			} else if (leaveRequestBean.getLeaveType().equals("PL")) {
				for (int iCount = 0; iCount < dates.size(); iCount++) {
					Date lDate = dates.get(iCount);
					String ds = formatter.format(lDate);
					Date sqeDate = formatter.parse(ds);
					checkWorkingDay = false;
					// int weeklyOffCheck =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weeklyOffCount,
					// Integer.class, empUser.getUserId(), sqeDate);
					// int weekEndCheck =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weekEndCount,
					// Integer.class, empUser.getUserId(), sqeDate);
					/*
					 * if (empCategory.equals("H")) { if (weeklyOffCheck == 0 && weekEndCheck == 0)
					 * { holidayCountHos =
					 * jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
					 * Integer.class, sqeDate); } if (weeklyOffCheck > 0 || weekEndCheck > 0 ||
					 * holidayCountHos > 0) { checkWorkingDay = true; } } else { if (weeklyOffCheck
					 * == 0 && weekEndCheck == 0) { holidayCountCol =
					 * jdbcTemplate.queryForObject(LeaveRequestQueryUtil.collegeCheck,
					 * Integer.class, sqeDate); } if (weeklyOffCheck > 0 || weekEndCheck > 0 ||
					 * holidayCountCol > 0) { checkWorkingDay = true; } }
					 */
					if (checkWorkingDay == false) {
						throw new CustomException(
								ds + " is not Holiday or Weekly Off. Please select only Holiday or Weekly Off Date");
					}
				}

			}
			checkHolidayBean.setPlLeaveDays(noofDays - leaveDays);
			checkHolidayBean.setLeaveDays(leaveDays);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return checkHolidayBean;
	}

	@Override
	public boolean checkHoliday(LeaveRequestBean leaveRequestBean) throws Exception {
		boolean checkRequestDate = false;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			// String empCategory =
			// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.userCategory, String.class,
			// empUser.getUserId());
			if (leaveRequestBean.getMdUrl().equals("CL")) {
				if (leaveRequestBean.getFromDate() != null) {
					String clFromDate = leaveRequestBean.getFromDate();
					Date sqeDate = formatter.parse(clFromDate);
					sqeDate.setDate(sqeDate.getDate() - 1);
					String holidayDate = sqeDate.getDate() + "/" + (sqeDate.getMonth() + 1) + "/"
							+ (1900 + sqeDate.getYear());

					// int holidayColCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.collegeCheck,
					// Integer.class, sqeDate);
					int holidayHosCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
							Integer.class, sqeDate);
					// int weeklyOffCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weeklyOffCount,
					// Integer.class, empUser.getUserId(), sqeDate);
					// int weekEndCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weekEndCount,
					// Integer.class, empUser.getUserId(), sqeDate);
					/*
					 * if (empCategory.equals("H")) { if (holidayHosCount > 0 || weeklyOffCount > 0
					 * || weekEndCount > 0) { throw new CustomException(holidayDate +
					 * " is a Holiday or Weekly Off"); } else { checkRequestDate = true; } } else {
					 * if (holidayColCount > 0 || weeklyOffCount > 0 || weekEndCount > 0) { throw
					 * new CustomException(holidayDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } }
					 */
				} else if (leaveRequestBean.getToDate() != null) {
					String clToDate = leaveRequestBean.getToDate();
					Date checkFutureDate = formatter.parse(clToDate);
					checkFutureDate.setDate(checkFutureDate.getDate() + 1);
					String holidayToDate = checkFutureDate.getDate() + "/" + (checkFutureDate.getMonth() + 1) + "/"
							+ (1900 + checkFutureDate.getYear());

					// int collegeHolidayToCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.collegeCheck,
					// Integer.class, checkFutureDate);
					int hospitalHolidayToCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
							Integer.class, checkFutureDate);
					// int checkWeeklyOffToCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weeklyOffCount,
					// Integer.class, empUser.getUserId(), checkFutureDate);
					// int checkWeekEndToCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weekEndCount,
					// Integer.class, empUser.getUserId(), checkFutureDate);
					/*
					 * if (empCategory.equals("H")) { if (hospitalHolidayToCount > 0 ||
					 * checkWeeklyOffToCount > 0 || checkWeekEndToCount > 0) { throw new
					 * CustomException(holidayToDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } } else { if (collegeHolidayToCount > 0 ||
					 * checkWeeklyOffToCount > 0 || checkWeekEndToCount > 0) { throw new
					 * CustomException(holidayToDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } }
					 */
				}
			} else if (leaveRequestBean.getMdUrl().equals("CPL")) {
				if (leaveRequestBean.getFromDate() != null) {
					String cplFromDate = leaveRequestBean.getFromDate();
					Date sqeDate = formatter.parse(cplFromDate);
					sqeDate.setDate(sqeDate.getDate() - 1);
					String holidayDate = sqeDate.getDate() + "/" + (sqeDate.getMonth() + 1) + "/"
							+ (1900 + sqeDate.getYear());

					// int holidayColCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.collegeCheck,
					// Integer.class, sqeDate);
					int holidayHosCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
							Integer.class, sqeDate);
					// int weeklyOffCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weeklyOffCount,
					// Integer.class, empUser.getUserId(), sqeDate);
					// int weekEndCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weekEndCount,
					// Integer.class, empUser.getUserId(), sqeDate);
					/*
					 * if (empCategory.equals("H")) { if (holidayHosCount > 0 || weeklyOffCount > 0
					 * || weekEndCount > 0) { throw new CustomException(holidayDate +
					 * " is a Holiday or Weekly Off"); } else { checkRequestDate = true; } } else {
					 * if (holidayColCount > 0 || weeklyOffCount > 0 || weekEndCount > 0) { throw
					 * new CustomException(holidayDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } }
					 */
				} else if (leaveRequestBean.getToDate() != null) {
					String cplToDate = leaveRequestBean.getToDate();
					Date checkFutureDate = formatter.parse(cplToDate);
					checkFutureDate.setDate(checkFutureDate.getDate() + 1);
					String holidayToDate = checkFutureDate.getDate() + "/" + (checkFutureDate.getMonth() + 1) + "/"
							+ (1900 + checkFutureDate.getYear());

					// int collegeHolidayToCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.collegeCheck,
					// Integer.class, checkFutureDate);
					int hospitalHolidayToCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
							Integer.class, checkFutureDate);
					// int checkWeeklyOffToCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weeklyOffCount,
					// Integer.class, empUser.getUserId(), checkFutureDate);
					// int checkWeekEndToCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weekEndCount,
					// Integer.class, empUser.getUserId(), checkFutureDate);
					/*
					 * if (empCategory.equals("H")) { if (hospitalHolidayToCount > 0 ||
					 * checkWeeklyOffToCount > 0 || checkWeekEndToCount > 0) { throw new
					 * CustomException(holidayToDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } } else { if (collegeHolidayToCount > 0 ||
					 * checkWeeklyOffToCount > 0 || checkWeekEndToCount > 0) { throw new
					 * CustomException(holidayToDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } }
					 */
				}
			} else if (leaveRequestBean.getMdUrl().equals("EL") || leaveRequestBean.getMdUrl().equals("ML")) {
				if (leaveRequestBean.getFromDate() != null) {
					String leaveFromDate = leaveRequestBean.getFromDate();
					Date checkPreviousDate = formatter.parse(leaveFromDate);
					checkPreviousDate.setDate(checkPreviousDate.getDate() - 1);
					String holidayFromDate = checkPreviousDate.getDate() + "/" + (checkPreviousDate.getMonth() + 1)
							+ "/" + (1900 + checkPreviousDate.getYear());

					// int collegeHolidayFromCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.collegeCheck,
					// Integer.class, checkPreviousDate);
					int hospitalHolidayFromCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
							Integer.class, checkPreviousDate);
					// int checkWeeklyOffFromCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weeklyOffCount,
					// Integer.class, empUser.getUserId(), checkPreviousDate);
					// int checkWeekEndFromCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weekEndCount,
					// Integer.class, empUser.getUserId(), checkPreviousDate);
					/*
					 * if (empCategory.equals("H")) { if (hospitalHolidayFromCount > 0 ||
					 * checkWeeklyOffFromCount > 0 || checkWeekEndFromCount > 0) { throw new
					 * CustomException(holidayFromDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } } else { if (collegeHolidayFromCount > 0 ||
					 * checkWeeklyOffFromCount > 0 || checkWeekEndFromCount > 0) { throw new
					 * CustomException(holidayFromDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } }
					 */
				} else if (leaveRequestBean.getToDate() != null) {
					String leaveToDate = leaveRequestBean.getToDate();
					Date checkFutureDate = formatter.parse(leaveToDate);
					checkFutureDate.setDate(checkFutureDate.getDate() + 1);
					String holidayToDate = checkFutureDate.getDate() + "/" + (checkFutureDate.getMonth() + 1) + "/"
							+ (1900 + checkFutureDate.getYear());

					// int collegeHolidayToCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.collegeCheck,
					// Integer.class, checkFutureDate);
					int hospitalHolidayToCount = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.hospitalCheck,
							Integer.class, checkFutureDate);
					// int checkWeeklyOffToCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weeklyOffCount,
					// Integer.class, empUser.getUserId(), checkFutureDate);
					// int checkWeekEndToCount =
					// jdbcTemplate.queryForObject(LeaveRequestQueryUtil.weekEndCount,
					// Integer.class, empUser.getUserId(), checkFutureDate);
					/*
					 * if (empCategory.equals("H")) { if (hospitalHolidayToCount > 0 ||
					 * checkWeeklyOffToCount > 0 || checkWeekEndToCount > 0) { throw new
					 * CustomException(holidayToDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } } else { if (collegeHolidayToCount > 0 ||
					 * checkWeeklyOffToCount > 0 || checkWeekEndToCount > 0) { throw new
					 * CustomException(holidayToDate + " is a Holiday or Weekly Off"); } else {
					 * checkRequestDate = true; } }
					 */
				}
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return checkRequestDate;
	}

	@Override
	public List<LeaveRequestBean> leaveDeductionList() throws Exception {
		List<LeaveRequestBean> getLeaveDeductionList = new ArrayList<LeaveRequestBean>();
		try {
			getLeaveDeductionList = jdbcTemplate.query(LeaveRequestQueryUtil.getLeaveDeductionList,
					new BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class));
		} catch (Exception e) {
			LOGGER.error("Error in getLeaveDeductionList", e);
		}
		return getLeaveDeductionList;
	}

	@Override
	public void saveLeaveDeduction(LeaveRequestBean leaveRequestBean) throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int curmonth = cal.get(cal.MONTH) + 1;
		int curmonthZero = cal.get(cal.MONTH);
		double clValue = 0;
		double leaveBalance = 0;
		String leaveType = "";
		try {

			UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (leaveRequestBean.getLeaveType().equalsIgnoreCase("CL")) {
				leaveType = "CL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					if (row.get("shortName").equals("CL")) {
						if (currentEmpDOJYear == year) {
							if (curmonth >= currentEmpDOJMonth) {
								double monthVal = curmonth - currentEmpDOJMonth;
								clValue = monthVal * 1.33;
								String newVal = String.valueOf(clValue);
								String[] arr = newVal.split("\\.");

								int[] clArr = new int[2];
								clArr[0] = Integer.parseInt(arr[1]);
								if (clArr[0] >= 80) {
									clValue = Math.round(clValue);
								}

								leaveBalance = clValue - Double.parseDouble(consumed.toString());
							}
						} else if (currentEmpDOJYear != year) {
							clValue = curmonth + 4;
							leaveBalance = clValue - Double.parseDouble(consumed.toString());
						}
					}

				}
			} else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("EL")) {
				leaveType = "EL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("EL")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			} else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("EOL")) {
				leaveType = "EOL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("EOL")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			}

			else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("ML")) {
				leaveType = "ML";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("ML")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			} else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("OTH")) {
				leaveType = "OTH";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("OTH")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			}

			else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("PL")) {
				leaveType = "PL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("PL")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			}

			else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("SPL")) {
				leaveType = "SPL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("SPL")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			}
			if (leaveBalance >= Integer.parseInt(leaveRequestBean.getNoOfDays())) {
				int request_id = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.maxQuery, Integer.class);
				jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveDeduction, request_id, leaveRequestBean.getEmpId(),
						leaveType, Integer.parseInt(leaveRequestBean.getNoOfDays()), leaveRequestBean.getLeaveReason());
				jdbcTemplate.update(LeaveRequestQueryUtil.insertLeaveDeductionAction, request_id, empUser.getUserId());
			} else {
				throw new CustomException(
						"This Employee's(" + leaveRequestBean.getEmpId() + ") CL leave balance is " + leaveBalance);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in saveLeaveDeduction", e.getMessage());
		}
	}

	// Edit Function
	@Override
	public LeaveRequestBean editLeaveDeduction(int leaveRequestId) throws Exception {
		LeaveRequestBean leaveDeductionBean = new LeaveRequestBean();
		try {
			leaveDeductionBean = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getEditLeaveDeduction,
					new BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class), leaveRequestId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in editApprovalSetting", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return leaveDeductionBean;
	}

	@Override
	public void updateLeaveDeduction(LeaveRequestBean leaveRequestBean) throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int curmonth = cal.get(cal.MONTH) + 1;
		int curmonthZero = cal.get(cal.MONTH);
		double clValue = 0;
		double leaveBalance = 0;
		String leaveType = "";
		try {

			UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (leaveRequestBean.getLeaveType().equalsIgnoreCase("CL")) {
				leaveType = "CL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					if (row.get("shortName").equals("CL")) {
						if (currentEmpDOJYear == year) {
							if (curmonth >= currentEmpDOJMonth) {
								double monthVal = curmonth - currentEmpDOJMonth;
								clValue = monthVal * 1.33;
								String newVal = String.valueOf(clValue);
								String[] arr = newVal.split("\\.");

								int[] clArr = new int[2];
								clArr[0] = Integer.parseInt(arr[1]);
								if (clArr[0] >= 80) {
									clValue = Math.round(clValue);
								}

								leaveBalance = clValue - Double.parseDouble(consumed.toString());
							}
						} else if (currentEmpDOJYear != year) {
							clValue = curmonthZero + 4;
							leaveBalance = clValue - Double.parseDouble(consumed.toString());
						}
					}
				}
			}

			else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("EL")) {
				leaveType = "EL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("EL")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			} else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("EOL")) {
				leaveType = "EOL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("EOL")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			}

			else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("ML")) {
				leaveType = "ML";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("ML")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			} else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("OTH")) {
				leaveType = "OTH";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("OTH")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			}

			else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("PL")) {
				leaveType = "PL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("PL")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			}

			else if (leaveRequestBean.getLeaveType().equalsIgnoreCase("SPL")) {
				leaveType = "SPL";
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery,
						new Object[] { leaveRequestBean.getEmpId(), leaveRequestBean.getEmpId() });
				for (Map row : rows) {
					int currentEmpDOJMonth = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJMonth,
							Integer.class, leaveRequestBean.getEmpId());
					int currentEmpDOJYear = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getLoginUserDOJYear,
							Integer.class, leaveRequestBean.getEmpId());
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					String consumed = consume.toString();
					BigDecimal balance = ((BigDecimal) row.get("balance"));
					String balanced = balance.toString();
					if (row.get("shortName").equals("SPL")) {
						leaveBalance = Double.parseDouble(balanced.toString());
					}
				}
			}

			String previousEmpId = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.getPreviousEmpId, String.class,
					leaveRequestBean.getLeaveRequestId());

			if (leaveRequestBean.getEmpId().equals(previousEmpId)) {
				jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveDeduction, leaveRequestBean.getEmpId(),
						Integer.parseInt(leaveRequestBean.getNoOfDays()), leaveRequestBean.getLeaveReason(),
						leaveRequestBean.getLeaveRequestId());
			} else {
				if (leaveBalance >= Integer.parseInt(leaveRequestBean.getNoOfDays())) {
					jdbcTemplate.update(LeaveRequestQueryUtil.updateLeaveDeduction, leaveRequestBean.getEmpId(),
							Integer.parseInt(leaveRequestBean.getNoOfDays()), leaveRequestBean.getLeaveReason(),
							leaveRequestBean.getLeaveRequestId());
				} else {
					throw new CustomException(
							"This Employee's(" + leaveRequestBean.getEmpId() + ") CL leave balance is " + leaveBalance);
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in updateLeaveDeduction", e.getMessage());
		}
	}

	// Delete Function
	@Override
	public void deleteLeaveDeduction(int leaveRequestId) throws Exception {
		try {
			jdbcTemplate.update(LeaveRequestQueryUtil.deleteLeaveQuery, leaveRequestId);

		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteLeaveDeduction", e);
		}
	}

	// Upload
	@Override
	public LeaveRequestResultBean uploadMLFile(MultipartFile[] files) {
		// TODO Auto-generated method stub
		LeaveRequestResultBean objJoiningReportResultBean = new LeaveRequestResultBean();
		List<String> fileNameList = new ArrayList<String>();
		if (files != null && files.length > 0) {
			File dir = new File(localPath);
			if (!dir.exists())
				dir.mkdirs();
			for (int i = 0; i < files.length; i++) {
				try {
					// byte[] bytes = files[i].getBytes();
					// File serverFile = new File(dir.getAbsolutePath() + File.separator + "LR" +
					// System.currentTimeMillis() + files[i].getOriginalFilename());
					// BufferedOutputStream stream = new BufferedOutputStream(new
					// FileOutputStream(serverFile));
					// stream.write(bytes);
					// stream.close();
					// String filePath = serverpath + File.separator +
					// files[i].getOriginalFilename();
					//
					// serverPath + File.separator + destinationFileName;

					String currentTimeStamp = "." + FilenameUtils.getExtension(files[i].getOriginalFilename());
					String destinationFileName = files[i].getOriginalFilename() + "_" + currentTimeStamp;
					File destinationFile = new File(localPath + destinationFileName);
					Files.write(files[i].getBytes(), destinationFile);
					String filePath = serverpath + File.separator + destinationFileName;

					fileNameList.add(filePath);
					objJoiningReportResultBean.setFileName(fileNameList);
					objJoiningReportResultBean.setSuccess(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return objJoiningReportResultBean;
	}

	// public synchronized static String
	// uploadFileHandlerWithOutRandom(MultipartFile file, String fileAbsolutePath,
	// String serverPath, String fileName) {
	//
	// String url = "";
	// try {
	// File dirCreatory = new File(fileAbsolutePath);
	// if (!dirCreatory.exists()) {
	// dirCreatory.mkdir();
	// }
	// if (file.getSize() > 0) {
	// String currentTimeStamp = "." +
	// FilenameUtils.getExtension(file.getOriginalFilename());
	// String destinationFileName = fileName + "_" + currentTimeStamp;
	// File destinationFile = new File(fileAbsolutePath + destinationFileName);
	// Files.write(file.getBytes(), destinationFile);
	// url = serverPath + File.separator + destinationFileName;
	// System.out.println("serverpath is" + serverPath);
	//
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return url;
	// }
	// }

	/*
	 * @Override public LeaveRequestResultBean uploadMLFile(MultipartFile file,
	 * String fileName) throws Exception { LeaveRequestResultBean
	 * leaveRequestResultBean = new LeaveRequestResultBean(); LeaveRequestBean
	 * leaveRequestBean = new LeaveRequestBean(); UserDetail empUser = (UserDetail)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
	 * filePath = ""; DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	 * Date date = new Date(); String todayDate = dateFormat.format(date); if
	 * (!file.isEmpty()) { if (file.getSize() > 0) { String destinationFileName =
	 * "ML_Doc_" + empUser.getUserId() + "_" + empUser.getUsername() + "_" +
	 * todayDate + "_" + date.getHours() + "_" + date.getMinutes() + "_" +
	 * date.getSeconds() + "." +
	 * FilenameUtils.getExtension(file.getOriginalFilename()); File destinationFile
	 * = new File(getFilePropertyUrl + destinationFileName);
	 * Files.write(file.getBytes(), destinationFile); filePath = getFileServerPath +
	 * File.separator + destinationFileName; }
	 * leaveRequestBean.setSupportDoc(filePath);
	 * leaveRequestResultBean.setLeaveObj(leaveRequestBean); } return
	 * leaveRequestResultBean; }
	 */

	@Override
	public LeaveRequestResultBean updateViewMLDoc(LeaveRequestBean leaveRequestBean) throws Exception {
		LeaveRequestResultBean leaveRequestResultBean = new LeaveRequestResultBean();
		try {
			jdbcTemplate.update(LeaveRequestQueryUtil.updateViewMLDoc, leaveRequestBean.getFinalSupportDoc(),
					leaveRequestBean.getLeaveRequestId());
			leaveRequestResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveRequestResultBean;
	}

	@Override
	public List<LeaveRequestBean> viewLeaveHistory(String empId) throws Exception {
		List<LeaveRequestBean> viewList = new ArrayList<LeaveRequestBean>();
		try {
			viewList = jdbcTemplate.query(LeaveRequestQueryUtil.viewLeaveHistory,
					new BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class), empId);
		} catch (Exception e) {
			LOGGER.error("Error in viewLeaveHistory", e);
		}
		return viewList;
	}

	@Override
	public LeaveRequestResultBean getLeaveListHistory(String empId) throws Exception {
		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		List<LeaveRequestLeaveBean> viewList = new ArrayList<LeaveRequestLeaveBean>();
		try {
			viewList = jdbcTemplate.query(LeaveRequestQueryUtil.getLeaveListQuery,
					new BeanPropertyRowMapper<LeaveRequestLeaveBean>(LeaveRequestLeaveBean.class), empId, empId);
		} catch (Exception e) {
			LOGGER.error("Error in viewLeaveHistory", e);
		}
		resultBean.setSuccess(true);
		resultBean.setLeaveList(viewList);
		return resultBean;
	}

	public void Leaverequestmail() {
		/*
		 * String to = toAddress;// change accordingly
		 * 
		 * String cc = ccaddress;// change accordingly
		 * 
		 * Calendar currentdate = Calendar.getInstance();
		 * 
		 * 
		 * // Sender's email ID needs to be mentioned String from = fromadress;// change
		 * accordingly final String username = "jai@paragondynamics.in";// change
		 * accordingly final String password = "Paragon@01";// change accordingly
		 * 
		 * // Assuming you are sending email through relay.jangosmtp.net String host =
		 * "smtp.sendgrid.net";
		 * 
		 * Properties props = new Properties(); props.put("mail.smtp.auth", "true");
		 * props.put("mail.smtp.starttls.enable", "true"); props.put("mail.smtp.host",
		 * host); props.put("mail.smtp.port", "587");
		 * 
		 * // Get the Session object. Session session = Session.getInstance(props, new
		 * javax.mail.Authenticator() { protected PasswordAuthentication
		 * getPasswordAuthentication() { return new PasswordAuthentication(username,
		 * password); } });
		 * 
		 * try {
		 * 
		 * // Create a default MimeMessage object. Message message = new
		 * MimeMessage(session);
		 * 
		 * // message.addRecipient(RecipientType.BCC, new InternetAddress("")); // for
		 * (int i = 0; i < cc.length; i++) { // if (!cc[i].isEmpty())
		 * message.addRecipient(Message.RecipientType.BCC, new InternetAddress(cc));
		 * 
		 * 
		 * // DateFormat format1 = new SimpleDateFormat("dd-MM-yyyy"); String
		 * currentDate = format1.format(currentdate.getTime());
		 * 
		 * // Set From: header field of the header. message.setFrom(new
		 * InternetAddress(from));
		 * 
		 * // Set To: header field of the header.
		 * message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		 * 
		 * // Set Subject: header field
		 * message.setSubject("KMC Pending LeaveDetails "+currentDate);
		 * 
		 * MimeBodyPart messagePart = new MimeBodyPart();
		 * 
		 * 
		 * //BodyPart messagePart = new MimeBodyPart(); Multipart multipart = new
		 * MimeMultipart("mixed"); List<LeaveRequestBean> viewList =
		 * jdbcTemplate.query(LeaveRequestQueryUtil.INSERT_UPLOAD_MAIL, new
		 * BeanPropertyRowMapper<LeaveRequestBean>(LeaveRequestBean.class)); String
		 * in="";
		 * 
		 * 
		 * in=in+"Dear Sir/Madam,"+"\n"+"\n"; StringBuffer sb = new StringBuffer();
		 * StringBuffer sb1 = new StringBuffer(); String path = "";
		 * 
		 * sb.append("<html><body>"); sb1.append("Dear Sir/Madam,"); // Table Structure
		 * Start sb1.append("<div><table>"); sb1.append("<tbody>"); sb1.append("<tr>");
		 * sb1.append("<td>"); sb1.append("<div style=\"padding-right:5px;\">");
		 * sb1.append("<table border = 2>"); sb1.append("<tr>");
		 * 
		 * sb1.append("<th>"); sb1.append("Employee Name"); sb1.append("</th>");
		 * sb1.append("<th>"); sb1.append("Leave Type"); sb1.append("</th>");
		 * sb1.append("<th>"); sb1.append("Applied On"); sb1.append("</th>");
		 * sb1.append("</tr>");
		 * 
		 * for (int i = 0; i < viewList.size(); i++) {
		 * 
		 * sb1.append("<tr>");
		 * 
		 * sb1.append("<td>"); sb1.append(viewList.get(i).getEmpName());
		 * sb1.append("</td>"); sb1.append("<td>");
		 * sb1.append(viewList.get(i).getLeaveType()); sb1.append("</td>");
		 * sb1.append("<td>"); sb1.append(viewList.get(i).getAppliedOn());
		 * sb1.append("</td>");
		 * 
		 * sb1.append("</tr>");
		 * 
		 * 
		 * } sb1.append("</div></td></tr></tbody></table></div>");
		 * sb1.append("Regards<br>"); sb1.append("IT Team");
		 * 
		 * in=in+"\n"+" "+"\n"; in=in+"Regards"; in=in+"IT Support Team";
		 * 
		 * messagePart.setContent( sb1.toString(), "text/html; charset=utf-8" );
		 * 
		 * //messagePart.setText(sb.toString()); multipart.addBodyPart(messagePart);
		 * 
		 * message.setContent(multipart);
		 * 
		 * // Send message Transport.send(message);
		 * System.out.println("LIVE Log Mail sent");
		 * 
		 * 
		 * } catch (MessagingException e) { throw new RuntimeException(e); }
		 */}

	@Override
	public void insertFiles(String requestId, String filename, String path) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(LeaveRequestQueryUtil.deletefileupload, new Object[] { requestId });

			jdbcTemplate.update(LeaveRequestQueryUtil.INSERT_FILES, new Object[] { requestId, filename, path });

		} catch (Exception se) {
			se.printStackTrace();
			throw se;
		}

	}

	@Override
	public LeaveRequestResultBean uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		LeaveRequestResultBean ResultBean = new LeaveRequestResultBean();

		String serverPath = "";

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss");
		String strDate = sdf.format(cal.getTime());
		if (!file.isEmpty()) {
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				byte[] bytes = file.getBytes();
				String workingDir = System.getProperty("user.dir");
				String fileName;
				String myName;

				myName = "upload" + strDate;
				String localPath = ConfigurationProps.exportFilesPath;
				String name = file.getOriginalFilename();
				int dot = name.lastIndexOf('.');
				String base = (dot == -1) ? name : name.substring(0, dot);
				String extension = (dot == -1) ? "" : name.substring(dot + 1);
				File dir = new File(localPath);

				Date date = new Date();

				base = base + "_" + date.getHours() + "_" + date.getMinutes() + "_" + date.getSeconds() + "."
						+ extension;
				File serverFile = new File(dir.getAbsolutePath() + File.separator + base);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				serverPath = "/filePath/" + base;
				ResultBean.setImgPath(serverPath);

				ResultBean.setSuccess(true);

			} catch (Exception e) {
				LOGGER.error("Error in uploadFile", e);
			}
		}
		return ResultBean;
	}

}