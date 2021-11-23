package com.dci.payroll.tds.slabrate;

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
public class SlabRateDAOImpl implements SlabRateDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(SlabRateDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<SlabRateBean> getSlabRateList() throws Exception {
		List<SlabRateBean> slabRateList = new ArrayList<SlabRateBean>();
		try {
			slabRateList = jdbcTemplate.query(SlabRateQueryUtil.slabrateSelect, new BeanPropertyRowMapper<SlabRateBean>(SlabRateBean.class));
			return slabRateList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in slabRateList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<SlabRateBean> getTaxPayerTypeList() throws Exception {
		List<SlabRateBean> payerTypeList = new ArrayList<SlabRateBean>();
		try {
			payerTypeList = jdbcTemplate.query(SlabRateQueryUtil.SELECT_PAYERTYPE, new BeanPropertyRowMapper<SlabRateBean>(SlabRateBean.class));
			return payerTypeList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxPayerTypeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public SlabRateBean getSlabRateListById(int taxRateId) throws Exception {
		SlabRateBean slabRateEntries = new SlabRateBean();
		try {
			slabRateEntries = jdbcTemplate.queryForObject(SlabRateQueryUtil.slabRateById, new Object[] { taxRateId }, new BeanPropertyRowMapper<SlabRateBean>(SlabRateBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getSlabRateListById", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return slabRateEntries;
	}

	@Override
	public boolean updateSlabRate(SlabRateBean slabRateBean) throws Exception {
		boolean isSuccess = false;

		try {

			Map<String, Object> slabRateMap = new HashMap<String, Object>();
			slabRateMap.put("tax_rate_id", slabRateBean.getTaxRateId());
			slabRateMap.put("tax_payer_type_id", slabRateBean.getTaxPayerTypeId());
			slabRateMap.put("range_from", slabRateBean.getRangeFrom());
			slabRateMap.put("range_to", slabRateBean.getRangeTo());
			slabRateMap.put("rate_in_percentage", slabRateBean.getRateInPercentage());
			slabRateMap.put("financial_year", slabRateBean.getFinancialYear());
			namedParameterJdbcTemplate.update(SlabRateQueryUtil.UPDATE_SLABRATE, slabRateMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in updateSlabRate", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean deleteSlabRate(int taxRateId) throws Exception {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(SlabRateQueryUtil.DELETE_SLABRATE, taxRateId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteSlabRate", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean insertSlabRate(SlabRateBean slabRateBean) throws Exception {
		boolean isSuccess = false;
		String slabRateId = "";
		try {
			slabRateId = jdbcTemplate.queryForObject(SlabRateQueryUtil.slabRateIdAutoGen, String.class);
			slabRateBean.setTaxRateId(Integer.parseInt(slabRateId));

			Map<String, Object> slabRateMap = new HashMap<String, Object>();
			slabRateMap.put("tax_rate_id", slabRateBean.getTaxRateId());
			slabRateMap.put("tax_payer_type_id", slabRateBean.getTaxPayerTypeId());
			slabRateMap.put("range_from", slabRateBean.getRangeFrom());
			slabRateMap.put("range_to", slabRateBean.getRangeTo());
			slabRateMap.put("rate_in_percentage", slabRateBean.getRateInPercentage());
			slabRateMap.put("financial_year", slabRateBean.getFinancialYear());
			namedParameterJdbcTemplate.update(SlabRateQueryUtil.INSERT_SLABRATE, slabRateMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertSlabRate", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

}