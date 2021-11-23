package com.dci.tenant.finance.manageTax;

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

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;

@Repository
public class ManageTaxDAOImpl implements ManageTaxDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ManageTaxDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ManageTax> getTaxList() throws CustomException {
		List<ManageTax> manageTax = new ArrayList<ManageTax>();
		try {
			manageTax = jdbcTemplate.query(ManageTaxQueryUtil.SELECT_TAX_LIST, new BeanPropertyRowMapper<ManageTax>(ManageTax.class));
			return manageTax;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageTaxResultBean getValueList() throws CustomException {
		ManageTaxResultBean objmanageTaxResultBean = new ManageTaxResultBean();
		List<ManageTax> valueList = new ArrayList<ManageTax>();

		try {
			valueList = jdbcTemplate.query(ManageTaxQueryUtil.SELECT_VALUE_LIST, new BeanPropertyRowMapper<ManageTax>(ManageTax.class));

			objmanageTaxResultBean.setValueList(valueList);
			objmanageTaxResultBean.setSuccess(true);

			return objmanageTaxResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getMethodList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageTaxResultBean getTypeList() throws CustomException {
		ManageTaxResultBean objmanageTaxResultBean = new ManageTaxResultBean();
		List<ManageTax> typeList = new ArrayList<ManageTax>();

		try {
			typeList = jdbcTemplate.query(ManageTaxQueryUtil.SELECT_TYPE_LIST, new BeanPropertyRowMapper<ManageTax>(ManageTax.class));

			objmanageTaxResultBean.setTypeList(typeList);

			objmanageTaxResultBean.setSuccess(true);

			return objmanageTaxResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTypeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageTaxResultBean getSubTaxList() throws CustomException {
		ManageTaxResultBean objmanageTaxResultBean = new ManageTaxResultBean();
		List<ManageTax> subTaxList = new ArrayList<ManageTax>();

		try {
			subTaxList = jdbcTemplate.query(ManageTaxQueryUtil.SELECT_SUBTAX_LIST, new BeanPropertyRowMapper<ManageTax>(ManageTax.class));

			objmanageTaxResultBean.setSubTaxList(subTaxList);

			objmanageTaxResultBean.setSuccess(true);

			return objmanageTaxResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTypeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageTaxResultBean insertManageTax(ManageTax manageTax) throws CustomException {
		ManageTaxResultBean objBean = new ManageTaxResultBean();
		boolean isSuccess = false;
		double taxAmount = 0;
		double taxAmount1 = 0;

		int taxId = 0;
		Integer subTaxId1 = manageTax.getSubTaxId();
		try {

			Map<String, Object> manageTaxMap = new HashMap<String, Object>();
			Integer method = manageTax.getTaxMethodId();
			taxAmount = manageTax.getTaxMethodAmount();
			if (method == 9) {
				manageTaxMap.put("taxPercentage", taxAmount);
				manageTaxMap.put("taxFixedAmount", taxAmount1);
			} else {
				manageTaxMap.put("taxPercentage", taxAmount1);
				manageTaxMap.put("taxFixedAmount", taxAmount);
			}
			manageTaxMap.put("taxId", manageTax.getTaxId());
			manageTaxMap.put("code", manageTax.getCode());
			manageTaxMap.put("taxName", manageTax.getTaxName());
			manageTaxMap.put("taxMethodId", manageTax.getTaxMethodId());

			manageTaxMap.put("taxTypeId", manageTax.getTaxTypeId());
			manageTaxMap.put("taxAccount", manageTax.getTaxAccount());
			manageTaxMap.put("isActive", manageTax.isIsactive());

			int j = jdbcTemplate.queryForObject(ManageTaxQueryUtil.CHECK_COUNT_TAX_code, new Object[] { manageTax.getCode().toLowerCase() }, Integer.class);
			int i = jdbcTemplate.queryForObject(ManageTaxQueryUtil.CHECK_COUNT_TAX_name, new Object[] { manageTax.getTaxName().toLowerCase() }, Integer.class);

			if (i == 0 && j == 0) {

				taxId = namedParameterJdbcTemplate.queryForObject(ManageTaxQueryUtil.INSERT_TAX, manageTaxMap,Integer.class);
				isSuccess = true;
				objBean.setSuccess(true);
			} else if (i == 0 && j == 1) {
				objBean.setErrors("Tax Code Already Exists");
				objBean.setSuccess(false);
			} else if (i == 1 && j == 0) {
				objBean.setErrors("Tax Name Already Exists");
				objBean.setSuccess(false);
			} else if (i == 1 && j == 1) {
				objBean.setErrors("Tax Name and Tax Code Already Exists");
				objBean.setSuccess(false);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getManageSubTax", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		if (isSuccess) {
			HashMap<String, Object> manageTaxMap = new HashMap<String, Object>();
			manageTaxMap.put("taxId", taxId);
			manageTaxMap.put("subTaxId", manageTax.getSubTaxId());
			namedParameterJdbcTemplate.update(ManageTaxQueryUtil.INSERT_TAX_SUBTAX, manageTaxMap);

		}
		return objBean;
	}

	@Override
	public boolean deleteTax(Integer taxId) throws CustomException {
		boolean isSuccess = false;
		try {

			int i = jdbcTemplate.update(ManageTaxQueryUtil.DELETE_TAX_SUB, taxId);
			if (i != 0)
				isSuccess = true;
			jdbcTemplate.update(ManageTaxQueryUtil.DELETE_TAX, taxId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in delete", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}

		return isSuccess;

	}

	@Override
	public ManageTax editManageTax(Integer taxId) throws CustomException {
		ManageTax objManageTax = new ManageTax();
		try {

			objManageTax = jdbcTemplate.queryForObject(ManageTaxQueryUtil.SELECT_EDIT_LIST, new Object[] { taxId }, new BeanPropertyRowMapper<ManageTax>(ManageTax.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in editDetails", e);
		}
		return objManageTax;
	}

	@Override
	public boolean updateManageTax(ManageTax manageTax) throws CustomException {
		boolean isSuccess = false;
		double taxAmount = 0;
		double taxAmount1 = 0;
		Integer taxId1 = manageTax.getTaxId();
		Integer subTaxId1 = manageTax.getSubTaxId();
		try {

			Map<String, Object> manageTaxMap = new HashMap<String, Object>();
			Integer method = manageTax.getTaxMethodId();
			taxAmount = manageTax.getTaxMethodAmount();
			if (method == 9) {
				manageTaxMap.put("taxPercentage", taxAmount);
				manageTaxMap.put("taxFixedAmount", taxAmount1);
			} else {
				manageTaxMap.put("taxPercentage", taxAmount1);
				manageTaxMap.put("taxFixedAmount", taxAmount);
			}
			manageTaxMap.put("taxId", manageTax.getTaxId());
			manageTaxMap.put("code", manageTax.getCode());
			manageTaxMap.put("taxName", manageTax.getTaxName());
			manageTaxMap.put("taxMethodId", manageTax.getTaxMethodId());

			manageTaxMap.put("taxTypeId", manageTax.getTaxTypeId());
			manageTaxMap.put("taxAccount", manageTax.getTaxAccount());
			manageTaxMap.put("isActive", manageTax.isIsactive());

			int i = namedParameterJdbcTemplate.update(ManageTaxQueryUtil.UPDATE_TAX, manageTaxMap);
			if (i > 0)
				isSuccess = true;

			if (isSuccess) {
				HashMap<String, Object> manageSubTaxMap = new HashMap<String, Object>();
				manageSubTaxMap.put("taxId", taxId1);
				manageSubTaxMap.put("subTaxId", manageTax.getSubTaxId());
				namedParameterJdbcTemplate.update(ManageTaxQueryUtil.DELETE_TAX_SUBTAX, manageSubTaxMap);
				int idtl = namedParameterJdbcTemplate.update(ManageTaxQueryUtil.INSERT_TAX_SUBTAX, manageSubTaxMap);
				if (idtl > 0)
					isSuccess = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getManageSubTax", e);
		}

		return isSuccess;
	}

	@Override
	public ManageTaxResultBean getAcctList(String subGrp) {
		ManageTaxResultBean objmanageTaxResultBean = new ManageTaxResultBean();
		List<SelectivityBean> accountList = new ArrayList<SelectivityBean>();
		try {
			accountList = jdbcTemplate.query(ManageTaxQueryUtil.ACCT_HEAD_COMBO, new Object[] { subGrp }, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			objmanageTaxResultBean.setAcctList(accountList);
			objmanageTaxResultBean.setSuccess(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTypeList", e);
		}
		return objmanageTaxResultBean;
	}

	@Override
	public String checkAccount(int taxTypeId, String formCode) {
		String acctCode = "";
		try {
			if (formCode.equalsIgnoreCase("tax"))
				acctCode = jdbcTemplate.queryForObject(ManageTaxQueryUtil.TAX_ACCT_HEAD, new Object[] { taxTypeId }, String.class);
			else
				acctCode = jdbcTemplate.queryForObject(ManageTaxQueryUtil.SUB_TAX_ACCT_HEAD, new Object[] { taxTypeId }, String.class);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTypeList", e);
		}
		return acctCode;
	}

	@Override
	public ManageTax getChildTaxDetails(int subTaxId) {
		ManageTax manageTax = new ManageTax();
		try {
			manageTax = jdbcTemplate.queryForObject(ManageTaxQueryUtil.SELECT_CHILD_TAX_DETAILS, new Object[] { subTaxId }, new BeanPropertyRowMapper<ManageTax>(ManageTax.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getList", e);
		}

		return manageTax;
	}

}