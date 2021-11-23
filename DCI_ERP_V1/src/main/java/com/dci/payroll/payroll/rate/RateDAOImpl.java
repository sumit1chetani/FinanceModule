package com.dci.payroll.payroll.rate;

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
public class RateDAOImpl implements RateDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(RateDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<RateBean> getRateList() throws Exception {
		List<RateBean> rateBeansList = new ArrayList<RateBean>();
		try {
			rateBeansList = jdbcTemplate.query(RateQueryUtil.SELECT_RATELIST, new BeanPropertyRowMapper<RateBean>(RateBean.class));
			return rateBeansList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in rateList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public RateBean getRateListById(int rateId) throws Exception {
		RateBean rateBean = new RateBean();
		try {
			rateBean = jdbcTemplate.queryForObject(RateQueryUtil.SELECT_RATE_BY_ID, new Object[] { rateId }, new BeanPropertyRowMapper<RateBean>(RateBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getSlabRateListById", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return rateBean;
	}

	@Override
	public boolean insertRate(RateBean rateBean) throws Exception {
		boolean isSuccess = false;
		String rateId = "";
		try {
			rateId = jdbcTemplate.queryForObject(RateQueryUtil.slabRateIdAutoGen, String.class);
			rateBean.setId(Integer.parseInt(rateId));
			Map<String, Object> rateMap = new HashMap<String, Object>();
			rateMap.put("id", rateBean.getId());
			rateMap.put("range_from", rateBean.getRangeFrom());
			rateMap.put("range_to", rateBean.getRangeTo());
			rateMap.put("unit_charge", rateBean.getUnitCharge());
			namedParameterJdbcTemplate.update(RateQueryUtil.INSERT_RATE, rateMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insert rate", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean updateRate(RateBean rateBean) throws Exception {
		boolean isSuccess = false;

		try {
			Map<String, Object> rateMap = new HashMap<String, Object>();
			rateMap.put("id", rateBean.getId());
			rateMap.put("range_from", rateBean.getRangeFrom());
			rateMap.put("range_to", rateBean.getRangeTo());
			rateMap.put("unit_charge", rateBean.getUnitCharge());
			namedParameterJdbcTemplate.update(RateQueryUtil.UPDATE_RATE, rateMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in update rate", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public boolean deleteRate(int taxRateId) throws Exception {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(RateQueryUtil.DELETE_RATE, taxRateId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteSlabRate", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

}
