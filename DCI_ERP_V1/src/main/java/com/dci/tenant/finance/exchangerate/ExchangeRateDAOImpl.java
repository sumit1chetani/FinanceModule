package com.dci.tenant.finance.exchangerate;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRateDAOImpl implements ExchangeRateDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExchangeRateDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ExchangeRateBean> getExchangeRateList(int limit, int offset) {
		List<ExchangeRateBean> lExchangeRateBean = new ArrayList<ExchangeRateBean>();
		try {

			lExchangeRateBean = jdbcTemplate.query(ExchangeRateQueryUtil.GET_EXCHANGE_RATE_LIST, new BeanPropertyRowMapper<ExchangeRateBean>(ExchangeRateBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lExchangeRateBean;
	}

	@Override
	public ExchangeRateResultBean getCurrencyList() {
		ExchangeRateResultBean resultBean = new ExchangeRateResultBean();
		List<ExchangeRateBean> lCurrencyList = new ArrayList<ExchangeRateBean>();
		try {
			lCurrencyList = jdbcTemplate.query(ExchangeRateQueryUtil.GET_CURRENCY_LIST, new BeanPropertyRowMapper<ExchangeRateBean>(ExchangeRateBean.class));
			resultBean.setCurrencyList(lCurrencyList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in Get Currency List", e1);
			resultBean.setMessage("failure");
		}

		return resultBean;
	}

	@Override
	public ExchangeRateResultBean getBookCurrencyList() {
		ExchangeRateResultBean resultBean = new ExchangeRateResultBean();
		List<ExchangeRateBean> lCurrencyList = new ArrayList<ExchangeRateBean>();
		try {
			lCurrencyList = jdbcTemplate.query(ExchangeRateQueryUtil.GET_BOOK_CURRENCY_LIST, new Object[] { true }, new BeanPropertyRowMapper<ExchangeRateBean>(ExchangeRateBean.class));
			resultBean.setCurrencyList(lCurrencyList);
			resultBean.setMessage("success");
		} catch (Exception e1) {
			LOGGER.error("Error in Get Book Currency List", e1);
			resultBean.setMessage("failure");
		}

		return resultBean;
	}

	@Override
	public boolean saveExchangeRateData(ExchangeRateBean objExchangeRateBean, String userId) {
		boolean isSuccess = false;
		String exRateCode = "";
		try {
			exRateCode = generateExchangeRateNo();

			int iExgSave = jdbcTemplate.update(ExchangeRateQueryUtil.SAVE_EXCHANGE_RATE, new Object[] { objExchangeRateBean.getExchangeRateDate(), objExchangeRateBean.getCurrencyCode(), objExchangeRateBean.getBookCurrency(), objExchangeRateBean.getExchangeRateValue(), exRateCode, userId });
			if (iExgSave > 0) {
				isSuccess = true;
			}

		} catch (DataAccessException ae) {
			LOGGER.error("Error in Insert", ae);
		}
		return isSuccess;
	}

	private String generateExchangeRateNo() {
		String exRateCode = "";
		try {
			String erDefaultCode = "ER00001", erPrefixCode = "ER";
			exRateCode = jdbcTemplate.queryForObject(ExchangeRateQueryUtil.GET_EXCHANGE_RATE_CODE, new Object[] { erDefaultCode, erPrefixCode }, String.class);

		} catch (DataAccessException e) {
			LOGGER.error("Error in generate Exchange Rate No", e);
		}

		return exRateCode;
	}

	@Override
	public ExchangeRateBean getExchangeRateEditList(String exchangeRateCode) {

		ExchangeRateBean objExchangeRateBean = new ExchangeRateBean();
		try {
			objExchangeRateBean = jdbcTemplate.queryForObject(ExchangeRateQueryUtil.GET_EXCHANGE_RATE_LIST_ON_EDIT, new Object[] { exchangeRateCode }, new BeanPropertyRowMapper<ExchangeRateBean>(ExchangeRateBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in get Exchange Rate List", e);
		}
		return objExchangeRateBean;
	}

	@Override
	public boolean updateExchangeRateData(ExchangeRateBean objExchangeRateBean, String userId) {
		boolean isSuccess = false;
		String exRateCode = "";
		try {

			int iExgSave = jdbcTemplate.update(ExchangeRateQueryUtil.UPDATE_EXCHANGE_RATE_DATA, new Object[] { objExchangeRateBean.getExchangeRateDate(), objExchangeRateBean.getCurrencyCode(), objExchangeRateBean.getBookCurrency(), objExchangeRateBean.getExchangeRateValue(), userId, objExchangeRateBean.getExchangeRateCode() });
			if (iExgSave > 0) {
				isSuccess = true;
			}

		} catch (DataAccessException ae) {
			LOGGER.error("Error in Insert", ae);
		}
		return isSuccess;
	}

	@Override
	public boolean copyExchangeRate(ExchangeRateBean objExchangeRateBean, String userId) {
		boolean issucces = false;
		int value = 0;
		String exRateCode = "";
		try {
			List<ExchangeRateBean> lExchangeRateBean = jdbcTemplate.query(ExchangeRateQueryUtil.GET_EXCHANGE_RATE_WITH_SOURCE, new Object[] { objExchangeRateBean.getSourceDate() }, new BeanPropertyRowMapper<ExchangeRateBean>(ExchangeRateBean.class));
			for (ExchangeRateBean objERBean : lExchangeRateBean) {
				exRateCode = generateExchangeRateNo();
				value = jdbcTemplate.update(ExchangeRateQueryUtil.SAVE_EXCHANGE_RATE, new Object[] { objExchangeRateBean.getCopyDate(), objERBean.getCurrencyCode(), objERBean.getBookCurrency(), objERBean.getExchangeRateValue(), exRateCode, userId });
				if (value > 0)
					issucces = true;

			}

		} catch (Exception ae) {
			LOGGER.error("Error in Copy Exchange Rate", ae);
		}

		return issucces;
	}

	@Override
	public boolean deleteExchangeRate(String erCode) {

		boolean issucces = false;
		int value = 0;
		try {
			value = jdbcTemplate.update(ExchangeRateQueryUtil.sDeleteExchangeRate, new Object[] { erCode });

			if (value != 0) {
				issucces = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete", e);
		}
		return issucces;
	}

}
