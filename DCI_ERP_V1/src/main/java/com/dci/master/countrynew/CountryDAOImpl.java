package com.dci.master.countrynew;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;

import ch.qos.logback.classic.Logger;

@Repository
public class CountryDAOImpl implements CountryNewDAO {
	private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(CountryDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<CountryNewBean> getCountryList() throws Exception {
		List<CountryNewBean> countryList = new ArrayList<CountryNewBean>();

		try {
			countryList = jdbcTemplate.query(CountryNewQueryUtil.COUNTRY_LIST, new BeanPropertyRowMapper<CountryNewBean>(CountryNewBean.class));
			return countryList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Country List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public void insertCountry(CountryNewBean country) throws Exception {
		try {

			int rowCountCode = jdbcTemplate.queryForObject(CountryNewQueryUtil.getCheckCountryCodeCount, Integer.class ,country.getCountryCode() );
			int rowCountName = jdbcTemplate.queryForObject(CountryNewQueryUtil.getCheckCountryNameCount, Integer.class, country.getCountryName() );

			if (rowCountCode > 0) {
				throw new CustomException(ErrorMessage.CODE_ALREADY_EXISTS);
			} else if (rowCountName > 0) {
				throw new CustomException(ErrorMessage.NAME_ALREADY_EXISTS);
			} else {
				jdbcTemplate.update(CountryNewQueryUtil.INSERT_COUNTRY, country.getCountryCode().toUpperCase(), country.getCountryName().toUpperCase(), country.getCurrencyCode());
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in insert Country", e.getMessage());
		}
	}

	@Override
	public CountryNewResultBean getcurrencylist() throws Exception {
		CountryNewResultBean resultBean = new CountryNewResultBean();
		List<CountryNewBean> resultList = new ArrayList<CountryNewBean>();
		try {
			resultList = jdbcTemplate.query(CountryNewQueryUtil.getCurrencyList, new BeanPropertyRowMapper<CountryNewBean>(CountryNewBean.class));
			resultBean.setCurrencyList(resultList);
			resultBean.setSuccess(true);
			return resultBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in get Currency List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public void updateCountry(CountryNewBean country) throws Exception {
		try {
			String countryName = jdbcTemplate.queryForObject(CountryNewQueryUtil.GET_COUNTRY_NAME, String.class, country.getCountryCode());

			if (country.getCountryName().equals(countryName)) {
				jdbcTemplate.update(CountryNewQueryUtil.UPDATE_COUNTRY, country.getCountryName().toUpperCase(), country.getCurrencyCode(), country.getCountryCode());
			} else {

				int rowCountName = jdbcTemplate.queryForObject(CountryNewQueryUtil.getCheckCountryNameCount, Integer.class, country.getCountryName() );

				if (rowCountName > 0) {
					throw new CustomException(ErrorMessage.NAME_ALREADY_EXISTS);
				} else {
					jdbcTemplate.update(CountryNewQueryUtil.UPDATE_COUNTRY, country.getCountryName().toUpperCase(), country.getCurrencyCode(), country.getCountryCode());
				}

			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in update Country", e);
		}
	}

	@Override
	public void deleteCountry(String currencyCode) throws Exception {
		try {
			jdbcTemplate.update(CountryNewQueryUtil.DELETE_COUNTRY, currencyCode);
		} catch (DataAccessException e) {
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
	}

	@Override
	public CountryNewBean getCountryByCode(String currencyCode) throws Exception {
		CountryNewBean country = null;
		try {
			country = jdbcTemplate.queryForObject(CountryNewQueryUtil.SELECT_COUNTRY_BY_CODE, new BeanPropertyRowMapper<CountryNewBean>(CountryNewBean.class), currencyCode);
		} catch (DataAccessException e) {
			LOGGER.error("Error in get Country By Code", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return country;
	}
}
