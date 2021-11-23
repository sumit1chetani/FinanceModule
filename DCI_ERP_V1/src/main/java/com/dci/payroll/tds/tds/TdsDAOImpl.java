package com.dci.payroll.tds.tds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;


@Repository
public class TdsDAOImpl implements TdsDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(TdsDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public List<TdsBean> getSlabList(String employeeId, String financialYear) throws Exception {
		List<TdsBean> tdsTaxList = new ArrayList<TdsBean>();
		try {
			tdsTaxList = jdbcTemplate.query(TdsQueryUtil.SELECT_TAX_LIST, new BeanPropertyRowMapper<TdsBean>(TdsBean.class), employeeId, financialYear);
			return tdsTaxList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getSlabList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<Map<String, Object>> getPayList(String employeeId, String financialYear) throws Exception {
		List<Map<String, Object>> tdsPayList;
		try {
			tdsPayList = jdbcTemplate.queryForList(TdsQueryUtil.SELECT_PAY_LIST, new Object[] { employeeId, financialYear });
		} catch (DataAccessException e) {
			LOGGER.error("Error in getListByEmployeeIdFY", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return tdsPayList;
	}

	@Override
	public List<Map<String, Object>> getSubSectionList(String employeeId, String financialYear, boolean declared, boolean actuval) throws Exception {
		List<Map<String, Object>> tdsSubSectionList = null;
		try {
			if (declared == true) {
				tdsSubSectionList = jdbcTemplate.queryForList(TdsQueryUtil.SELECT_SUB_SECTION_LIST, new Object[] { employeeId, financialYear, employeeId });
			} else {
				if (actuval == true) {
					tdsSubSectionList = jdbcTemplate.queryForList(TdsQueryUtil.SELECT_SUB_SECTION_LIST_ACTUAL, new Object[] { employeeId, financialYear, employeeId });
				}
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSubSectionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return tdsSubSectionList;
	}

	@Override
	public List<Map<String, Object>> getOtherIncomeList(String employeeId, String financialYear) throws Exception {
		List<Map<String, Object>> tdsOtherIncomeList = null;
		try {
			tdsOtherIncomeList = jdbcTemplate.queryForList(TdsQueryUtil.SELECT_OTHER_INCOME_LIST, new Object[] { employeeId, financialYear });
		} catch (DataAccessException e) {
			LOGGER.error("Error in getOtherIncomeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return tdsOtherIncomeList;
	}

	@Override
	public TdsBean getmothBean(String employeeId, String financialYear) throws Exception {
		TdsBean bean = new TdsBean();
		try {
			bean = jdbcTemplate.queryForObject(TdsQueryUtil.SELECT_MONTH_COUNT, new Object[] { financialYear }, new BeanPropertyRowMapper<TdsBean>(TdsBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getSlabRateListById", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return bean;
	}

}