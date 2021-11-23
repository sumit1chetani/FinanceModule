package com.dci.payroll.payroll.loantype;

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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.payroll.payroll.earningdeductionmaster.EarningDeductionMasterBean;
import com.dci.payroll.payroll.earningdeductionmaster.EarningDeductionMasterQueryUtil;
import com.dci.tenant.user.UserDetail;


@Repository
public class LoanTypeDAOImpl implements LoanTypeDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoanTypeDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<LoanType> getLoanTypeList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<LoanType> loanTypeList = new ArrayList<>();
		try {
			loanTypeList = jdbcTemplate.query(LoanTypeQueryUtill.SELECT_LOANTYPE_LIST, new BeanPropertyRowMapper<>(LoanType.class), userDetail.getCompanyCode());

		} catch (DataAccessException e) {
			LOGGER.error("Error in LoanType", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return loanTypeList;
	}

	@Override
	public List<LoanType> getActiveLoanTypeList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<LoanType> loanTypeList = new ArrayList<>();
		try {
			loanTypeList = jdbcTemplate.query(LoanTypeQueryUtill.SELECT_ACTIVELOANTYPE_LIST, new BeanPropertyRowMapper<>(LoanType.class), userDetail.getCompanyCode());

		} catch (DataAccessException e) {
			LOGGER.error("Error in LoanType", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return loanTypeList;
	}

	@Override
	public List<LoanType> getLoanTypeListById(String loanTypeId) throws CustomException {
		List<LoanType> loanTypeList = new ArrayList<>();
		try {
			loanTypeList = jdbcTemplate.query(LoanTypeQueryUtill.SELECT_LOANTYPE_BY_ID, new BeanPropertyRowMapper<>(LoanType.class), loanTypeId);

		} catch (DataAccessException e) {
			LOGGER.error("Error in LoanType", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return loanTypeList;
	}

	@Override
	public boolean insertLoanType(LoanType loanTypeBean) throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean isSuccess = false;
		List<LoanType> loanTypeList = new ArrayList<>();
		List<EarningDeductionMasterBean> earningDeductionMasterList = new ArrayList<>();
		try {
			// Map to INSERT Loan Type
			Map<String, Object> loanTypeMap = null;
			loanTypeMap = new HashMap<>();
			loanTypeMap.put("loanTypeId", loanTypeBean.getLoanTypeId());
			loanTypeMap.put("loanTypeName", loanTypeBean.getLoanTypeName());
			loanTypeMap.put("interestRate", loanTypeBean.getInterestRate());
			loanTypeMap.put("flatId", loanTypeBean.getFlatId());
			loanTypeMap.put("status", loanTypeBean.isStatus());
			loanTypeMap.put("companyId", userDetail.getCompanyCode());

			// Map to INSERT Pay Component
			Map<String, Object> earningDeductionMap = new HashMap<>();
			earningDeductionMap.put("pay_component_id", loanTypeBean.getLoanTypeId());
			earningDeductionMap.put("pay_component_name", loanTypeBean.getLoanTypeName());
			earningDeductionMap.put("is_permanant", true);
			earningDeductionMap.put("is_allowance", false);
			earningDeductionMap.put("value_type", 1);
			earningDeductionMap.put("value", loanTypeBean.getInterestRate());
			earningDeductionMap.put("percentage_applied_on", null);
			earningDeductionMap.put("status", loanTypeBean.isStatus());
			earningDeductionMap.put("pay_component_type", 3);
			earningDeductionMap.put("display_order", 20);
			earningDeductionMap.put("jv_mapping", false);

			loanTypeList = jdbcTemplate.query(LoanTypeQueryUtill.SELECT_LOANTYPE_BY_ID, new BeanPropertyRowMapper<>(LoanType.class), loanTypeBean.getLoanTypeId());
			earningDeductionMasterList = jdbcTemplate.query(EarningDeductionMasterQueryUtil.SELECT_EARNINGDEDUCTIONBYID, new BeanPropertyRowMapper<>(EarningDeductionMasterBean.class), loanTypeBean.getLoanTypeId());
			if (earningDeductionMasterList.size() == 0 && loanTypeList.size() == 0) {
				namedParameterJdbcTemplate.update(LoanTypeQueryUtill.INSERT_LOAN_TYPE, loanTypeMap);
				namedParameterJdbcTemplate.update(LoanTypeQueryUtill.INSERT_EARNINGDEDUCTION1, earningDeductionMap);
				isSuccess = true;
			} else if (loanTypeList.size() > 0 && earningDeductionMasterList.size() == 0) {
				namedParameterJdbcTemplate.update(LoanTypeQueryUtill.INSERT_EARNINGDEDUCTION1, earningDeductionMap);
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in insertLoanType", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean updateLoanType(LoanType loanTypeBean) throws CustomException {
		boolean isSuccess = false;
		List<LoanType> loanTypeList = new ArrayList<>();
		List<EarningDeductionMasterBean> earningDeductionMasterList = new ArrayList<>();
		try {
			// Map to UPDATE Loan Type
			Map<String, Object> loanTypeMap = null;
			loanTypeMap = new HashMap<>();
			loanTypeMap.put("loanTypeId", loanTypeBean.getLoanTypeId());
			loanTypeMap.put("loanTypeName", loanTypeBean.getLoanTypeName());
			loanTypeMap.put("interestRate", loanTypeBean.getInterestRate());
			loanTypeMap.put("flatOrDiminishing", loanTypeBean.getFlatOrDiminishing());
			loanTypeMap.put("status", loanTypeBean.isStatus());

			// Map to UPDATE Pay Component
			Map<String, Object> earningDeductionMap = new HashMap<>();
			earningDeductionMap.put("pay_component_id", loanTypeBean.getLoanTypeId());
			earningDeductionMap.put("pay_component_name", loanTypeBean.getLoanTypeName());
			earningDeductionMap.put("is_permanant", true);
			earningDeductionMap.put("is_allowance", false);
			earningDeductionMap.put("value_type", 1);
			earningDeductionMap.put("value", loanTypeBean.getInterestRate());
			earningDeductionMap.put("percentage_applied_on", null);
			earningDeductionMap.put("status", loanTypeBean.isStatus());
			earningDeductionMap.put("pay_component_type", 3);
			earningDeductionMap.put("display_order", 20);
			earningDeductionMap.put("jv_mapping", false);

			loanTypeList = jdbcTemplate.query(LoanTypeQueryUtill.SELECT_LOANTYPE_BY_ID, new BeanPropertyRowMapper<>(LoanType.class), loanTypeBean.getLoanTypeId());
			earningDeductionMasterList = jdbcTemplate.query(EarningDeductionMasterQueryUtil.SELECT_EARNINGDEDUCTIONBYID, new BeanPropertyRowMapper<>(EarningDeductionMasterBean.class), loanTypeBean.getLoanTypeId());
			if (earningDeductionMasterList.size() > 0 && loanTypeList.size() > 0) {
				namedParameterJdbcTemplate.update(LoanTypeQueryUtill.UPDATE_LOAN_TYPE, loanTypeMap);
				namedParameterJdbcTemplate.update(LoanTypeQueryUtill.UPDATE_EARNINGDEDUCTION1, earningDeductionMap);
				isSuccess = true;
			} else if (loanTypeList.size() > 0 && earningDeductionMasterList.size() == 0) {
				namedParameterJdbcTemplate.update(LoanTypeQueryUtill.UPDATE_LOAN_TYPE, loanTypeMap);
				namedParameterJdbcTemplate.update(LoanTypeQueryUtill.INSERT_EARNINGDEDUCTION1, earningDeductionMap);
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in updateLoanType", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public LoanType deleteLoanType(String loanTypeId) throws CustomException {
		LoanType loanTypeBean = new LoanType();
		try {
			jdbcTemplate.update(LoanTypeQueryUtill.DELETE_LOAN_TYPE, loanTypeId);
			jdbcTemplate.update(EarningDeductionMasterQueryUtil.DELETE_EARNINGDEDUCTION, loanTypeId);
			loanTypeBean.setSuccess(true);
		} catch (DataAccessException e) {

			loanTypeBean.setSuccess(false);
			String errorMessage = e.getMessage();
			loanTypeBean.setErrormessage(errorMessage);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return loanTypeBean;
	}

}
