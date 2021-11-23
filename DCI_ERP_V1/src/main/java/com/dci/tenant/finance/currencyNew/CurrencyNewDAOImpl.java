package com.dci.tenant.finance.currencyNew;

import java.util.ArrayList;
import java.util.List;

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
public class CurrencyNewDAOImpl implements CurrencyNewDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(CurrencyNewDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<CurrencyNewBean> getCurrencyList() throws CustomException {
		List<CurrencyNewBean> currencyList = new ArrayList<CurrencyNewBean>();
		try {
			currencyList = jdbcTemplate.query(CurrencyNewQueryUtil.SELECT_CURRENCY_LIST, new BeanPropertyRowMapper<CurrencyNewBean>(CurrencyNewBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in currencyList", e);
		}
		return currencyList;
	}

	@Override
	public CurrencyNewBean getCurrencyListOnEdit(String currencyCode) throws CustomException {
		CurrencyNewBean currency = null;
		try {
			currency = jdbcTemplate.queryForObject(CurrencyNewQueryUtil.GET_CURRENCY_LIST_ON_EDIT, new BeanPropertyRowMapper<CurrencyNewBean>(CurrencyNewBean.class), currencyCode);

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Currency List On Edit", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}
		return currency;
	}

	@Override
	public boolean saveCurrencyData(CurrencyNewBean objCurrencyBean) {
		boolean isSuccess = false;
		try {
			boolean isActive = objCurrencyBean.getIsActive().equalsIgnoreCase("Y") ? true : false;
			boolean isBookingCurrency = objCurrencyBean.getBookCurrency().equalsIgnoreCase("Y") ? true : false;

			int iCurrInsert = jdbcTemplate.update(CurrencyNewQueryUtil.saveCurrencyData, new Object[] { objCurrencyBean.getCurrencyCode(), objCurrencyBean.getCurrencyName(), objCurrencyBean.getSymbol(), objCurrencyBean.getFromCurrency(), objCurrencyBean.getToCurrency(), objCurrencyBean.getCurrencyDefault(), objCurrencyBean.getCurrencyFraction(), isActive, isBookingCurrency });
			if (iCurrInsert > 0)
				isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Insert Currency", e);
		}

		return isSuccess;
	}

	@Override
	public boolean updateCurrency(CurrencyNewBean objCurrencyBean) throws CustomException {
		boolean isSuccess = false;
		try {
			boolean isActive = objCurrencyBean.getIsActive().equalsIgnoreCase("Y") ? true : false;
			boolean isBookingCurrency = objCurrencyBean.getBookCurrency().equalsIgnoreCase("Y") ? true : false;

			int iCurrUpdate = jdbcTemplate.update(CurrencyNewQueryUtil.UPDATE_CURRENCY_DATA, new Object[] { objCurrencyBean.getCurrencyName(), objCurrencyBean.getSymbol(), objCurrencyBean.getFromCurrency(), objCurrencyBean.getToCurrency(), objCurrencyBean.getCurrencyDefault(), objCurrencyBean.getCurrencyFraction(), isActive, isBookingCurrency, objCurrencyBean.getCurrencyCode(), });
			if (iCurrUpdate > 0)
				isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Update Currency", e);
		}

		return isSuccess;
	}

	@Override
	public boolean deleteCurrency(String currencyCode) throws CustomException {
		boolean isDeleted = false;
		int iDel = 0;

		try {
			iDel = jdbcTemplate.update(CurrencyNewQueryUtil.DELETE_CURRENCY, currencyCode);
			if (iDel > 0)
				isDeleted = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in delete Currency", e);
		}
		return isDeleted;

	}

}
