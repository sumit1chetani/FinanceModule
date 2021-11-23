package com.dci.payroll.tds.NscInterest;

import java.math.BigDecimal;
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
public class NscInterestDAOImpl implements NscInterestDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(NscInterestDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<NscInterestBean> getNscInterestList() throws CustomException {
		List<NscInterestBean> nscInterestList = new ArrayList<NscInterestBean>();
		try {
			nscInterestList = jdbcTemplate.query(NscInterestQueryUtill.SELECT_ALL, new BeanPropertyRowMapper<NscInterestBean>(NscInterestBean.class));
			return nscInterestList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in NscInterest", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public NscInterestBean getNscInterestById(String financialYear) throws CustomException {
		NscInterestBean nscInterest = new NscInterestBean();
		try {

			Map row = jdbcTemplate.queryForMap(NscInterestQueryUtill.SELECT_BY_ID, financialYear);

			if (row.get("rate_of_interest") != null) {
				nscInterest.setRateOfInterest((BigDecimal) row.get("rate_of_interest"));

			}
			if (row.get("financial_year") != null) {
				nscInterest.setFinancialYear((String) row.get("financial_year"));
			}

			nscInterest.setisEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getNscInterestEdit", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}
		return nscInterest;
	}

	@Override
	public boolean insertNscInterest(NscInterestBean nscInterest) throws CustomException {
		boolean isSuccess = false;
		try {
			Map<String, Object> nscInterestMap = new HashMap<String, Object>();
			nscInterestMap.put("financialYear", nscInterest.getFinancialYear());
			nscInterestMap.put("rateOfInterest", nscInterest.getRateOfInterest());
			namedParameterJdbcTemplate.update(NscInterestQueryUtill.INSERT, nscInterestMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getNscInterestAdd", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean updateNscInterest(NscInterestBean nscInterest) throws CustomException {
		boolean isSuccess = false;
		try {
			Map<String, Object> nscInterestMap = new HashMap<String, Object>();

			nscInterestMap.put("financialYear", nscInterest.getFinancialYear());
			nscInterestMap.put("rateOfInterest", nscInterest.getRateOfInterest());

			namedParameterJdbcTemplate.update(NscInterestQueryUtill.UPDATE, nscInterestMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in updateNscInterest", e);
			throw new CustomException(ErrorMessage.ERROR_UPDATE);
		}

		return isSuccess;
	}
}
