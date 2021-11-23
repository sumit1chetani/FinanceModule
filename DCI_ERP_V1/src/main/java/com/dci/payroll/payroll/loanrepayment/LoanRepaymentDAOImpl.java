package com.dci.payroll.payroll.loanrepayment;

import java.util.ArrayList;
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
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;


@Repository
public class LoanRepaymentDAOImpl implements LoanRepaymentDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoanRepaymentDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<LoanRepaymentBean> getDeductedList(String monthYear) throws CustomException {
		List<LoanRepaymentBean> loanDeductedList = new ArrayList<LoanRepaymentBean>();
		try {
			loanDeductedList = jdbcTemplate.query(LoanRepaymentQueryUtil.SELECT_DEDUCTED_LIST, new BeanPropertyRowMapper<LoanRepaymentBean>(LoanRepaymentBean.class), monthYear);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getDeductedList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return loanDeductedList;
	}

	@Override
	public List<LoanRepaymentBean> getTobeDeductedList(String monthYear) throws CustomException {
		List<LoanRepaymentBean> loanTobeDeductedList = new ArrayList<LoanRepaymentBean>();
		try {
			loanTobeDeductedList = jdbcTemplate.query(LoanRepaymentQueryUtil.SELECT_TO_DEDUCTED_LIST, new BeanPropertyRowMapper<LoanRepaymentBean>(LoanRepaymentBean.class), monthYear, monthYear, monthYear);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTobeDeductedList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return loanTobeDeductedList;
	}

	@Override
	public List<LoanRepaymentBean> getLoanReport(String department) throws CustomException {
		List<LoanRepaymentBean> loanTobeDeductedList = new ArrayList<LoanRepaymentBean>();
		try {
			loanTobeDeductedList = jdbcTemplate.query(LoanRepaymentQueryUtil.SELECT_LOAN_REPORT, new BeanPropertyRowMapper<LoanRepaymentBean>(LoanRepaymentBean.class), department);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTobeDeductedList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return loanTobeDeductedList;
	}

	@Override
	public List<LoanRepaymentBean> checkLoanRepaymentList(String loanId, String monthYear) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertLoanRepayment(ArrayList<LoanRepaymentBean> loanRepaymentBean) throws CustomException {
		boolean isSuccess = false;
		List<LoanRepaymentBean> loanRepaymentList = new ArrayList<LoanRepaymentBean>();
		List<LoanRepaymentBean> empPayCompPaidList = new ArrayList<LoanRepaymentBean>();
		try {
			Map<String, Object> loanRepaymentMap = null;
			for (LoanRepaymentBean loanRepayment : loanRepaymentBean) {
				loanRepaymentMap = new HashMap<String, Object>();
				loanRepaymentMap.put("loanId", loanRepayment.getLoanId());
				loanRepaymentMap.put("loanTypeId", loanRepayment.getLoanTypeId());
				loanRepaymentMap.put("employeeId", loanRepayment.getEmployeeId());
				loanRepaymentMap.put("monthYear", loanRepayment.getMonthYear());
				loanRepaymentMap.put("amount", loanRepayment.getDeductionAmount());
				loanRepaymentMap.put("current_emi_no", loanRepayment.getCurrentEmiNo());
				loanRepaymentMap.put("total_emi", loanRepayment.getTotalEmi());
				loanRepaymentList = jdbcTemplate.query(LoanRepaymentQueryUtil.CHECK_REPAYMENT_EXISTS, new BeanPropertyRowMapper<LoanRepaymentBean>(LoanRepaymentBean.class), loanRepayment.getLoanId(), loanRepayment.getMonthYear());
				empPayCompPaidList = jdbcTemplate.query(LoanRepaymentQueryUtil.CHECK_EMP_PAYCOM_PAID_EXISTS, new BeanPropertyRowMapper<LoanRepaymentBean>(LoanRepaymentBean.class), loanRepayment.getEmployeeId(), loanRepayment.getMonthYear(), loanRepayment.getLoanTypeId());
				if (loanRepaymentList.size() == 0) {
					namedParameterJdbcTemplate.update(LoanRepaymentQueryUtil.INSERT_LOAN_REPAYMENT, loanRepaymentMap);
				} else {
					namedParameterJdbcTemplate.update(LoanRepaymentQueryUtil.UPDATE_LOAN_REPAYMENT, loanRepaymentMap);
				}
				if (empPayCompPaidList.size() == 0) {
					namedParameterJdbcTemplate.update(LoanRepaymentQueryUtil.INSERT_EMP_PAYCOM_PAID, loanRepaymentMap);
				} else {
					namedParameterJdbcTemplate.update(LoanRepaymentQueryUtil.UPDATE_EMP_PAYCOM_PAID, loanRepaymentMap);
				}
			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertLoanRepayment", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

}