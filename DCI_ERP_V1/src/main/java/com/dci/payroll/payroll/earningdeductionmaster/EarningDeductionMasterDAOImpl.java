package com.dci.payroll.payroll.earningdeductionmaster;

import java.math.BigDecimal;
import java.sql.Types;
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
public class EarningDeductionMasterDAOImpl implements EarningDeductionMasterDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(EarningDeductionMasterDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EarningDeductionMasterBean> getEarningDeductionMasterList() throws CustomException {
		List<EarningDeductionMasterBean> earningDeductionMasterList = new ArrayList<>();
		try {
			earningDeductionMasterList = jdbcTemplate.query(EarningDeductionMasterQueryUtil.earningDeductionMasterSelect, new BeanPropertyRowMapper<>(EarningDeductionMasterBean.class));
			return earningDeductionMasterList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in EarningDeductionMasterDAOImpl List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<EarningDeductionMasterBean> getPayComponentList() throws CustomException {
		List<EarningDeductionMasterBean> payComponentList = new ArrayList<>();
		try {
			payComponentList = jdbcTemplate.query(EarningDeductionMasterQueryUtil.selectPaycomponentId, new BeanPropertyRowMapper<>(EarningDeductionMasterBean.class));
			return payComponentList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in EarningDeductionMasterDAOImpl List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertEarningDeduction(EarningDeductionMasterBean earningDeductionMasterBean) throws CustomException {
		boolean isSuccess = false;
		int i = 1;
		try {
			Map<String, Object> earningDeductionMap = new HashMap<>();

			earningDeductionMap.put("pay_component_id", earningDeductionMasterBean.getPayComponentId());
			earningDeductionMap.put("pay_component_name", earningDeductionMasterBean.getPayComponentName());
			earningDeductionMap.put("is_permanant", earningDeductionMasterBean.isPermanant());
			earningDeductionMap.put("is_allowance", earningDeductionMasterBean.isAllowance());
			earningDeductionMap.put("value_type", earningDeductionMasterBean.getValueType());
			earningDeductionMap.put("value", earningDeductionMasterBean.getValue());
			earningDeductionMap.put("percentage_applied_on", earningDeductionMasterBean.getPercentageAppliedOn());
			earningDeductionMap.put("status", earningDeductionMasterBean.isStatus());
			earningDeductionMap.put("pay_component_type", earningDeductionMasterBean.getPayComponentType());
			earningDeductionMap.put("display_order", earningDeductionMasterBean.getDisplayOrder());
			earningDeductionMap.put("jv_mapping", earningDeductionMasterBean.isJvMapping());
			earningDeductionMap.put("account_head", earningDeductionMasterBean.getAccountHead());
			earningDeductionMap.put("debit_account_head", earningDeductionMasterBean.getDebitaccountHead());
			earningDeductionMap.put("nonStandardDeduction", earningDeductionMasterBean.getNonStandardDeduction());

			namedParameterJdbcTemplate.update(EarningDeductionMasterQueryUtil.INSERT_EARNINGDEDUCTION, earningDeductionMap);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in insert earning", e.getMessage());
			if (e.getMessage().indexOf("unique constraint") != 0) {
				throw new CustomException("earning name '" + earningDeductionMasterBean.getPayComponentId() + "' already exists.");
			}

		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public EarningDeductionMasterBean getEarningDeductionbyId(String payComponentId) throws CustomException {
		EarningDeductionMasterBean earningDeductionMasterBean = new EarningDeductionMasterBean();
		try {

			int[] types = new int[] { Types.INTEGER };
			Object[] params = new Object[] { payComponentId };
			Map row = jdbcTemplate.queryForMap(EarningDeductionMasterQueryUtil.SELECT_EARNINGDEDUCTIONBYID, params);

			if (row.get("pay_component_id") != null) {
				earningDeductionMasterBean.setPayComponentId((String) row.get("pay_component_id"));

			}
			if (row.get("pay_component_name") != null) {
				earningDeductionMasterBean.setPayComponentName((String) row.get("pay_component_name"));
			}
			if (row.get("is_permanant") != null) {
				earningDeductionMasterBean.setPermanant((boolean) row.get("is_permanant"));
			}
			if (row.get("is_allowance") != null) {
				earningDeductionMasterBean.setAllowance((boolean) row.get("is_allowance"));
			}
			if (row.get("value") != null) {
				earningDeductionMasterBean.setValue((BigDecimal) row.get("value"));
			}
			if (row.get("value_type") != null) {
				earningDeductionMasterBean.setValueType((int) row.get("value_type"));
			}

			if (row.get("percentage_applied_on") != null) {
				earningDeductionMasterBean.setPercentageAppliedOn((String) row.get("percentage_applied_on"));
			}
			if (row.get("status") != null) {
				earningDeductionMasterBean.setStatus((Boolean) row.get("status"));
			}
			if (row.get("formula") != null) {
				earningDeductionMasterBean.setFormula((String) row.get("formula"));
			}
			if (row.get("display_order") != null) {
				earningDeductionMasterBean.setDisplayOrder((int) row.get("display_order"));
			}
			if (row.get("pay_component_type") != null) {
				earningDeductionMasterBean.setPayComponentType((int) row.get("pay_component_type"));
			}
			if (row.get("jv_mapping") != null) {
				earningDeductionMasterBean.setJvMapping((boolean) row.get("jv_mapping"));
			}
			if (row.get("account_head") != null) {
				earningDeductionMasterBean.setAccountHead((String) row.get("account_head"));
			}

			if (row.get("debit_account_head") != null) {
				earningDeductionMasterBean.setDebitaccountHead((String) row.get("debit_account_head"));
			}
			if (row.get("non_standard_deduction") != null) {
				earningDeductionMasterBean.setNonStandardDeduction((boolean) row.get("non_standard_deduction"));
			}
			earningDeductionMasterBean.setisEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getLoanEntryId", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}

		// TODO Auto-generated method stub
		return earningDeductionMasterBean;
	}

	@Override
	public boolean updateEarningDeduction(EarningDeductionMasterBean earningDeductionMasterBean) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {
			Map<String, Object> earningDeductionMap = new HashMap<>();

			earningDeductionMap.put("pay_component_id", earningDeductionMasterBean.getPayComponentId());
			earningDeductionMap.put("pay_component_name", earningDeductionMasterBean.getPayComponentName());
			earningDeductionMap.put("is_permanant", earningDeductionMasterBean.isPermanant());
			earningDeductionMap.put("is_allowance", earningDeductionMasterBean.isAllowance());
			earningDeductionMap.put("value_type", earningDeductionMasterBean.getValueType());
			earningDeductionMap.put("value", earningDeductionMasterBean.getValue());
			earningDeductionMap.put("percentage_applied_on", earningDeductionMasterBean.getPercentageAppliedOn());
			earningDeductionMap.put("status", earningDeductionMasterBean.isStatus());
			earningDeductionMap.put("pay_component_type", earningDeductionMasterBean.getPayComponentType());
			earningDeductionMap.put("display_order", earningDeductionMasterBean.getDisplayOrder());
			earningDeductionMap.put("jv_mapping", earningDeductionMasterBean.isJvMapping());
			earningDeductionMap.put("account_head", earningDeductionMasterBean.getAccountHead());
			earningDeductionMap.put("debit_account_head", earningDeductionMasterBean.getDebitaccountHead());
			earningDeductionMap.put("nonStandardDeduction", earningDeductionMasterBean.getNonStandardDeduction());

			namedParameterJdbcTemplate.update(EarningDeductionMasterQueryUtil.UPDATE_EARNINGDEDUCTION, earningDeductionMap);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in update LoanEntry", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public EarningDeductionMasterBean deleteEarningDeduction(String payComponentId) throws CustomException {
		EarningDeductionMasterBean bean = new EarningDeductionMasterBean();
		boolean isSuccess = false;
		int val = 1;
		try {
			val = jdbcTemplate.update(EarningDeductionMasterQueryUtil.DELETE_EARNINGDEDUCTION, payComponentId);
			isSuccess = true;
			bean.setSuccess(true);
		} catch (DataAccessException e) {

			bean.setSuccess(false);
			String errorMessage = e.getMessage();
			bean.setErrormessage(errorMessage);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return bean;
	}
}