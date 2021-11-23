package com.dci.hrms.report.employeeEarlyStart;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.finance.leaverequest.LeaveRequestQueryUtil;
import com.dci.hrms.hr.leave.leaveSummary.LeaveSummaryQueryUtil;
import com.dci.tenant.user.UserDetail;



@Repository
public class EmployeeEarlyStartDAOImpl implements EmployeeEarlyStartDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeEarlyStartDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public EmployeeEarlyStartResultBean getHospitalList(String formCode) throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		EmployeeEarlyStartResultBean employeeEarlyStartResultBean = new EmployeeEarlyStartResultBean();
		List<EmployeeEarlyStartResultBean> hospitalList = new ArrayList<>();
		try {
			hospitalList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.getHospitalList, new BeanPropertyRowMapper<>(EmployeeEarlyStartResultBean.class), formCode, userDetail.getUserId());
			employeeEarlyStartResultBean.setHospitalList(hospitalList);
			employeeEarlyStartResultBean.setSuccess(true);
			return employeeEarlyStartResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Hospital List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	/* Employee Early Start */
	@Override
	public List<EmployeeEarlyStartBean> getEarlyStartList(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException {
		List<EmployeeEarlyStartBean> EarlyList = new ArrayList<>();
		int dayRadio = employeeEarlyStartBean.getDaysRadio();
		DateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
		Date singleEarlyDate = null;
		Date multiEarlyFromDate = null;
		Date multiEarlyToDate = null;
		try {
			if (dayRadio == 1) {
				String date = employeeEarlyStartBean.getDate();
				singleEarlyDate = formatterDate.parse(date);
				EarlyList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.get_EmployeeEarlyStartSingle_List, new BeanPropertyRowMapper<>(EmployeeEarlyStartBean.class), singleEarlyDate, employeeEarlyStartBean.getBranchId());
			} else {
				String fromdate = employeeEarlyStartBean.getFromDate();
				multiEarlyFromDate = formatterDate.parse(fromdate);
				String todate = employeeEarlyStartBean.getToDate();
				multiEarlyToDate = formatterDate.parse(todate);
				EarlyList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.get_EmployeeEarlyStartMultiple_List, new BeanPropertyRowMapper<>(EmployeeEarlyStartBean.class), multiEarlyFromDate, multiEarlyToDate, employeeEarlyStartBean.getBranchId());
			}
			return EarlyList;
		} catch (Exception e) {
			LOGGER.error("Error in get_EmployeeEarlyStart_List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	/* Employee Late */
	@Override
	public List<EmployeeEarlyStartBean> getEarlyLateList(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException {
		List<EmployeeEarlyStartBean> lateList = new ArrayList<>();
		int dayRadio = employeeEarlyStartBean.getDaysRadio();
		DateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
		Date singleLateDate = null;
		Date multiLateFromDate = null;
		Date multiLateToDate = null;
		try {
			if (dayRadio == 1) {
				String date = employeeEarlyStartBean.getDate();
				singleLateDate = formatterDate.parse(date);
				lateList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.get_EmployeeLateStartSingle_List, new BeanPropertyRowMapper<>(EmployeeEarlyStartBean.class), singleLateDate, employeeEarlyStartBean.getBranchId());
			} else {
				String fromdate = employeeEarlyStartBean.getFromDate();
				multiLateFromDate = formatterDate.parse(fromdate);
				String todate = employeeEarlyStartBean.getToDate();
				multiLateToDate = formatterDate.parse(todate);
				lateList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.get_EmployeeLateStartMultiple_List, new BeanPropertyRowMapper<>(EmployeeEarlyStartBean.class), multiLateFromDate, multiLateToDate, employeeEarlyStartBean.getBranchId());
			}
			return lateList;
		} catch (Exception e) {
			LOGGER.error("Error in get_EmployeeLate_List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	/* Habitual Late */

	@Override
	public List<EmployeeEarlyStartBean> getHabitualLate(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException {
		List<EmployeeEarlyStartBean> habitualLateList = new ArrayList<>();
		DateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String fromdate = employeeEarlyStartBean.getFromDate();
			Date habitLateFromDate = formatterDate.parse(fromdate);
			String todate = employeeEarlyStartBean.getToDate();
			Date habitLateToDate = formatterDate.parse(todate);
			habitualLateList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.get_HabitualLate_List, new BeanPropertyRowMapper<>(EmployeeEarlyStartBean.class), employeeEarlyStartBean.getBranchId(), habitLateFromDate, habitLateToDate);
			return habitualLateList;
		} catch (Exception e) {
			LOGGER.error("Error in get_HabitualLate_List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeEarlyStartResultBean getEmployeeList(String branchI) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		EmployeeEarlyStartResultBean employeeEarlyStartResultBean = new EmployeeEarlyStartResultBean();
		List<EmployeeEarlyStartResultBean> employeeList = new ArrayList<>();
		try {
			employeeList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.getEmployeeList, new BeanPropertyRowMapper<>(EmployeeEarlyStartResultBean.class), branchI);
			employeeEarlyStartResultBean.setEmployeeList(employeeList);
			employeeEarlyStartResultBean.setSuccess(true);
			return employeeEarlyStartResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	/* Employee Leave Summary */

	@Override
	public EmployeeEarlyStartResultBean getEmployeeListDiv(String divisionId) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		EmployeeEarlyStartResultBean employeeEarlyStartResultBean = new EmployeeEarlyStartResultBean();
		List<EmployeeEarlyStartResultBean> employeeList = new ArrayList<>();
		try {
			employeeList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.getEmployeeListDiv, new BeanPropertyRowMapper<>(EmployeeEarlyStartResultBean.class), divisionId);
			employeeEarlyStartResultBean.setEmployeeList(employeeList);
			employeeEarlyStartResultBean.setSuccess(true);
			return employeeEarlyStartResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeEarlyStartResultBean getDivisionList(String companyId) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		EmployeeEarlyStartResultBean employeeEarlyStartResultBean = new EmployeeEarlyStartResultBean();
		List<EmployeeEarlyStartResultBean> employeeList = new ArrayList<>();
		try {
			employeeList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.getDivisionList, new BeanPropertyRowMapper<>(EmployeeEarlyStartResultBean.class), companyId);
			employeeEarlyStartResultBean.setDivisionList(employeeList);
			employeeEarlyStartResultBean.setSuccess(true);
			return employeeEarlyStartResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Employee List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<EmployeeEarlyStartBean> getEmpDetailList(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException {
		List<EmployeeEarlyStartBean> empdetailList = new ArrayList<>();
		try {
			empdetailList = jdbcTemplate.query(EmployeeEarlyStartQueryUtil.get_EmployeeDetail_List, new BeanPropertyRowMapper<>(EmployeeEarlyStartBean.class), employeeEarlyStartBean.getEmployeeId(), employeeEarlyStartBean.getEmployeeId());
			return empdetailList;
		} catch (Exception e) {
			LOGGER.error("Error in get_HabitualLate_List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public EmployeeEarlyStartResultBean getLeaveList(String empId) throws CustomException {

		EmployeeEarlyStartResultBean resultBean = new EmployeeEarlyStartResultBean();
		List<EmployeeEarlyStartBean> resultList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveListQuery, new Object[] { empId, empId });
			for (Map row : rows) {
				EmployeeEarlyStartBean leaveTypeBean = new EmployeeEarlyStartBean();
				BigDecimal consume = ((BigDecimal) row.get("consumed"));
				BigDecimal bal = ((BigDecimal) row.get("balance"));
				BigDecimal allowed = ((BigDecimal) row.get("allowedLeave"));
				String allowedLeave = allowed.toString();
				String balance = bal.toString();
				String consumed = consume.toString();

				leaveTypeBean.setEmployeeId((String) row.get("empId"));
				leaveTypeBean.setLeaveName((String) row.get("leaveName"));
				leaveTypeBean.setShortName((String) row.get("shortName"));
				leaveTypeBean.setAllowedLeave(allowedLeave);
				leaveTypeBean.setBalance(balance);
				leaveTypeBean.setConsumed(consumed);
				resultList.add(leaveTypeBean);

			}

			String gen = jdbcTemplate.queryForObject(LeaveRequestQueryUtil.gender, String.class, empId);
			if (gen.equals("M")) {
				List<Map<String, Object>> rows1 = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveMaleListQuery, new Object[] { empId, empId });
				for (Map row : rows1) {
					EmployeeEarlyStartBean leaveTypeBean = new EmployeeEarlyStartBean();
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					BigDecimal bal = ((BigDecimal) row.get("balance"));
					BigDecimal allowed = ((BigDecimal) row.get("allowedLeave"));
					String allowedLeave = allowed.toString();
					String balance = bal.toString();
					String consumed = consume.toString();

					leaveTypeBean.setEmployeeId((String) row.get("empId"));
					leaveTypeBean.setLeaveName((String) row.get("leaveName"));
					leaveTypeBean.setShortName((String) row.get("shortName"));
					leaveTypeBean.setAllowedLeave(allowedLeave);
					leaveTypeBean.setBalance(balance);
					leaveTypeBean.setConsumed(consumed);
					resultList.add(leaveTypeBean);

				}
			} else {
				List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(LeaveRequestQueryUtil.getLeaveFemaleListQuery, new Object[] { empId, empId });
				for (Map row : rows2) {
					EmployeeEarlyStartBean leaveTypeBean = new EmployeeEarlyStartBean();
					BigDecimal consume = ((BigDecimal) row.get("consumed"));
					BigDecimal bal = ((BigDecimal) row.get("balance"));
					BigDecimal allowed = ((BigDecimal) row.get("allowedLeave"));
					String allowedLeave = allowed.toString();
					String balance = bal.toString();
					String consumed = consume.toString();

					leaveTypeBean.setEmployeeId((String) row.get("empId"));
					leaveTypeBean.setLeaveName((String) row.get("leaveName"));
					leaveTypeBean.setShortName((String) row.get("shortName"));
					leaveTypeBean.setAllowedLeave(allowedLeave);
					leaveTypeBean.setBalance(balance);
					leaveTypeBean.setConsumed(consumed);
					resultList.add(leaveTypeBean);

				}
			}

			resultBean.setLeaveTypeList(resultList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@Override
	public List<EmployeeEarlyStartBean> getLeaveDetails(String leaveType, String empId) throws CustomException {
		List<EmployeeEarlyStartBean> summaryList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(EmployeeEarlyStartQueryUtil.get_leave_summary, new Object[] { leaveType, empId });
			for (Map row : rows) {
				EmployeeEarlyStartBean leaveSummary = new EmployeeEarlyStartBean();
				leaveSummary.setLeaveCode((String) row.get("leaveCode"));
				leaveSummary.setDateFrom((String) row.get("dateFrom"));
				leaveSummary.setDateTo((String) row.get("dateTo"));
				leaveSummary.setLeaveDays(Double.parseDouble(row.get("noOfDays").toString()));
				leaveSummary.setAppliedOn((String) row.get("appliedOn"));
				if ((int) row.get("status") == 0) {
					leaveSummary.setStatus("Pending");
				} else if ((int) row.get("status") == 1) {
					leaveSummary.setStatus("Approved");
				} else {
					leaveSummary.setStatus("Cancelled");
				}

				if ((String) row.get("approvedBy") != null && (String) row.get("approvedBy") != "") {
					String approvedBy = jdbcTemplate.queryForObject(LeaveSummaryQueryUtil.getApprovedBy, String.class, (String) row.get("approvedBy"));
					leaveSummary.setApprovedBy(approvedBy);
				} else {
					leaveSummary.setApprovedBy(null);
				}
				summaryList.add(leaveSummary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return summaryList;
	}

}
