package com.dci.payroll.payroll.withHold;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.payroll.payroll.loanEntry.LoanEntryDAOImpl;
import com.dci.tenant.user.UserDetail;


@Repository
public class WithHoldDAOImpl implements WithHoldDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(LoanEntryDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Override
	public List<WithHoldBean> getEmployeeList() throws Exception {
		List<WithHoldBean> employeeList = new ArrayList<>();
		try {

			employeeList = jdbcTemplate.query(WithHoldQueryUtil.SELECT_EMPLOYEE, new BeanPropertyRowMapper<>(WithHoldBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in employeeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return employeeList;
	}

	// year list

	@Override
	public List<WithHoldBean> getYearList() throws Exception {
		List<WithHoldBean> yearList = new ArrayList<>();
		try {

			yearList = jdbcTemplate.query(WithHoldQueryUtil.SELECT_Year, new BeanPropertyRowMapper<>(WithHoldBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in employeeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return yearList;
	}

	// List
	@Override
	public List<WithHoldBean> getWithHoldList() throws Exception {
		List<WithHoldBean> withHoldList = new ArrayList<>();
		try {

			withHoldList = jdbcTemplate.query(WithHoldQueryUtil.withHoldList, new BeanPropertyRowMapper<>(WithHoldBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in employeeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return withHoldList;
	}

	// Save
	@Override
	public boolean addWithHold(WithHoldBean withHold) throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean isSuccess = false;

		try {

			String code = "";

			String maxId = jdbcTemplate.queryForObject(WithHoldQueryUtil.check_max, String.class);
			int max = Integer.parseInt(maxId);
			int nextId = max + 1;

			code = nextId + "";
			String prefix = "";
			if (code.length() == 1) {
				prefix = "WH000";
			} else if (code.length() == 2) {
				prefix = "WH00";
			} else if (code.length() == 3) {
				prefix = "WH0";
			} else {
				prefix = "WH";
			}
			code = prefix + code;
			if (withHold.getWithholdTo() == "") {
				withHold.setWithholdTo(null);

			}

			jdbcTemplate.update(WithHoldQueryUtil.insert_WitHold, code, withHold.getEmployee(), withHold.getWithholdDate(), withHold.getFromMonth(), withHold.getFromYear(), withHold.getTillMonth(), withHold.getTillYear(), userDetail.getUserId());
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in insert With Hold", e);
		}

		return isSuccess;

	}

	// update

	@Override
	public boolean updateWithHold(WithHoldBean withHold) throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean isSuccess = false;

		try {
			if (withHold.getWithholdTo() == "") {
				withHold.setWithholdTo(null);

			}

			jdbcTemplate.update(WithHoldQueryUtil.update_WitHold, withHold.getWithholdDate(), withHold.getFromMonth(), withHold.getFromYear(), withHold.getTillMonth(), withHold.getTillYear(), userDetail.getUserId(), withHold.getWithHoldCode());
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in insert With Hold", e);
		}

		return isSuccess;

	}

	// edit
	@Override
	public List<WithHoldBean> editwithHold(String withHoldCode) throws Exception {
		List<WithHoldBean> WithHoldList = new ArrayList<>();
		try {

			WithHoldList = jdbcTemplate.query(WithHoldQueryUtil.edit_WithHold, new BeanPropertyRowMapper<>(WithHoldBean.class), withHoldCode);

		} catch (DataAccessException e) {
			LOGGER.error("Error in withhold edit List", e);
		}
		return WithHoldList;
	}

	// withhold Report

	@Override
	public List<WithHoldBean> getWithholdReport(WithHoldBean withhold) throws Exception {
		List<WithHoldBean> withholdlist = new ArrayList<>();
		try {
			if (withhold.getStatus() != "") {
				if (withhold.getStatus().equalsIgnoreCase("pending")) {
					withholdlist = jdbcTemplate.query(WithHoldQueryUtil.Withhold_ReportList_Pending, new BeanPropertyRowMapper<>(WithHoldBean.class), withhold.getMonthYear(), withhold.getMonthYear());

				} else {
					withholdlist = jdbcTemplate.query(WithHoldQueryUtil.Withhold_ReportList_Completed, new BeanPropertyRowMapper<>(WithHoldBean.class), withhold.getMonthYear());
				}
			} else {
				withholdlist = jdbcTemplate.query(WithHoldQueryUtil.Withhold_ReportList, new BeanPropertyRowMapper<>(WithHoldBean.class), withhold.getMonthYear(), withhold.getMonthYear());

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getWithholdAddList", e);
		}
		return withholdlist;
	}

	// employee check

	@Override
	public List<WithHoldBean> employeeCheck(String employee) throws Exception {
		List<WithHoldBean> WithHoldList = new ArrayList<>();
		try {
			WithHoldList = jdbcTemplate.query(WithHoldQueryUtil.employee_check, new BeanPropertyRowMapper<>(WithHoldBean.class), employee);

		} catch (DataAccessException e) {
			LOGGER.error("Error in withhold edit List", e);
		}
		return WithHoldList;

	}

	// delete

	@Override
	public boolean deleteWithHold(String withHoldCode) throws Exception {
		boolean isSuccess = false;

		try {

			jdbcTemplate.update(WithHoldQueryUtil.WithHold_Delete, withHoldCode);
			isSuccess = true;

		} catch (DataAccessException e) {
			isSuccess = false;
			LOGGER.error("Error in insert Advance", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}

		return isSuccess;
	}

}
