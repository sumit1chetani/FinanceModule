package com.dci.tenant.finance.manageSubTax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ManageSubTaxDAOImpl implements ManageSubTaxDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ManageSubTaxDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ManageSubTax> getSubTaxList() throws CustomException {
		List<ManageSubTax> manageSubTax = new ArrayList<ManageSubTax>();
		try {
			manageSubTax = jdbcTemplate.query(ManageSubTaxQueryUtil.SELECT_SUB_TAX_LIST, new BeanPropertyRowMapper<ManageSubTax>(ManageSubTax.class));
			return manageSubTax;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertManageSubTax(ManageSubTax manageSubTax) throws CustomException {
		boolean isSuccess = false;
		double taxAmount = 0;
		double taxAmount1 = 0;
		int i = 1;

		try {
			Map<String, Object> manageSubTaxMap = new HashMap<String, Object>();
			Integer method = manageSubTax.getSubTaxMethodId();
			taxAmount = manageSubTax.getSubTaxMethodAmount();
			if (method == 9) {

				manageSubTaxMap.put("subTaxPercentage", taxAmount);
				manageSubTaxMap.put("subTaxFixedAmount", taxAmount1);
			} else {
				manageSubTaxMap.put("subTaxPercentage", taxAmount1);
				manageSubTaxMap.put("subTaxFixedAmount", taxAmount);
			}
			manageSubTaxMap.put("subTaxCode", manageSubTax.getSubTaxCode());
			manageSubTaxMap.put("subTaxName", manageSubTax.getSubTaxName());
			manageSubTaxMap.put("subTaxMethodId", manageSubTax.getSubTaxMethodId());

			manageSubTaxMap.put("subTaxTypeId", manageSubTax.getSubTaxTypeId());
			manageSubTaxMap.put("subTaxAccount", manageSubTax.getSubTaxAccount());
			manageSubTaxMap.put("isActive", manageSubTax.isIsactive());
			i = jdbcTemplate.queryForObject(ManageSubTaxQueryUtil.CHECK_COUNT_SUB_TAX, Integer.class, manageSubTax.getSubTaxName() );
			if (i == 0) {

				namedParameterJdbcTemplate.update(ManageSubTaxQueryUtil.INSERT_SUB_TAX, manageSubTaxMap);
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getManageSubTax", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public ManageSubTaxResultBean getValueList() throws CustomException {
		ManageSubTaxResultBean objmanageSubTaxResultBean = new ManageSubTaxResultBean();
		List<ManageSubTax> valueList = new ArrayList<ManageSubTax>();

		try {
			valueList = jdbcTemplate.query(ManageSubTaxQueryUtil.SELECT_VALUE_LIST, new BeanPropertyRowMapper<ManageSubTax>(ManageSubTax.class));

			objmanageSubTaxResultBean.setValueList(valueList);
			objmanageSubTaxResultBean.setSuccess(true);

			return objmanageSubTaxResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getMethodList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageSubTaxResultBean getTypeList() throws CustomException {
		ManageSubTaxResultBean objmanageSubTaxResultBean = new ManageSubTaxResultBean();
		List<ManageSubTax> typeList = new ArrayList<ManageSubTax>();

		try {
			typeList = jdbcTemplate.query(ManageSubTaxQueryUtil.SELECT_TYPE_LIST, new BeanPropertyRowMapper<ManageSubTax>(ManageSubTax.class));

			objmanageSubTaxResultBean.setTypeList(typeList);

			objmanageSubTaxResultBean.setSuccess(true);

			return objmanageSubTaxResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTypeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public void deleteSubTax(Integer subTaxId) throws CustomException {
		try {
			jdbcTemplate.update(ManageSubTaxQueryUtil.DELETE_SUB_TAX, subTaxId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in delete", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}

	}

	@Override
	public ManageSubTax editManageSubTax(Integer subTaxId) throws CustomException {
		double percentage = 0;
		double amount = 0;
		ManageSubTax objManageSubTax = new ManageSubTax();
		try {
			Map row = jdbcTemplate.queryForMap(ManageSubTaxQueryUtil.SELECT_EDIT_LIST, subTaxId);
			objManageSubTax.setSubTaxId((Integer) row.get("subTaxId"));
			objManageSubTax.setSubTaxCode((String) row.get("subTaxCode"));
			objManageSubTax.setSubTaxName((String) row.get("subTaxName"));
			objManageSubTax.setSubTaxMethodId((Integer) row.get("subTaxMethodId"));
			objManageSubTax.setSubTaxTypeId((Integer) row.get("subTaxTypeId"));
			objManageSubTax.setIsactive((boolean) row.get("isActive"));
			objManageSubTax.setSubTaxAccount((String) row.get("subTaxAccount"));
			percentage = (double) row.get("subTaxPercentage");
			amount = (double) row.get("subTaxFixedAmount");
			if (percentage == 0) {
				objManageSubTax.setSubTaxMethodAmount(amount);

			} else {
				objManageSubTax.setSubTaxMethodAmount(percentage);
			}
			objManageSubTax.setEdit(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in editDetails", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}
		return objManageSubTax;
	}

	@Override
	public boolean updateManageSubTax(ManageSubTax manageSubTax) throws CustomException {
		boolean isSuccess = false;
		double taxAmount = 0;
		double taxAmount1 = 0;

		try {

			Map<String, Object> manageSubTaxMap = new HashMap<String, Object>();
			Integer method = manageSubTax.getSubTaxMethodId();
			taxAmount = manageSubTax.getSubTaxMethodAmount();
			if (method == 9) {

				manageSubTaxMap.put("subTaxPercentage", taxAmount);
				manageSubTaxMap.put("subTaxFixedAmount", taxAmount1);
			} else {
				manageSubTaxMap.put("subTaxPercentage", taxAmount1);
				manageSubTaxMap.put("subTaxFixedAmount", taxAmount);
			}
			manageSubTaxMap.put("subTaxId", manageSubTax.getSubTaxId());
			manageSubTaxMap.put("subTaxCode", manageSubTax.getSubTaxCode());
			manageSubTaxMap.put("subTaxName", manageSubTax.getSubTaxName());
			manageSubTaxMap.put("subTaxMethodId", manageSubTax.getSubTaxMethodId());

			manageSubTaxMap.put("subTaxTypeId", manageSubTax.getSubTaxTypeId());
			manageSubTaxMap.put("subTaxAccount", manageSubTax.getSubTaxAccount());
			manageSubTaxMap.put("isActive", manageSubTax.isIsactive());

			namedParameterJdbcTemplate.update(ManageSubTaxQueryUtil.UPDATE_SUB_TAX, manageSubTaxMap);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getManageSubTax", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

}