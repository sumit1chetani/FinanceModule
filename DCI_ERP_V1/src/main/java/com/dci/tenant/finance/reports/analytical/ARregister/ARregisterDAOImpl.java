package com.dci.tenant.finance.reports.analytical.ARregister;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("tenantTransactionManager")

public class ARregisterDAOImpl implements ARregisterDAO {

	String whereCond = "";

	private final static Logger LOGGER = LoggerFactory.getLogger(ARregisterDAOImpl.class);

	@Resource
	 private DataSource dataSource;

	@Override
	public List<ARregister> getARregister(ARregister objarRegister) {

		List<ARregister> revenueBean = new ArrayList<ARregister>();
		try {
			  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			try {
				whereCond = search(objarRegister);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			revenueBean = jdbcTemplate.query(ARregisterQueryUtil.AR_REPORT + whereCond, new BeanPropertyRowMapper<ARregister>(ARregister.class));
			System.out.println("print the query ++++++++++++++++++++" + ARregisterQueryUtil.AR_REPORT + whereCond);
			return revenueBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);

		}
		return revenueBean;
	}

	public String search(ARregister objarRegister) throws SQLException {

		String whereCond = "";
		System.out.println("objarRegister.getServicename()++++++++++++++++++++++++++++++=" + objarRegister.getSectorId());
		
		if (objarRegister.getCompany() != null && !objarRegister.getCompany().isEmpty()) {
			whereCond += " and  V.COMPANY_ID ='" + objarRegister.getCompany() + "'";
		}

		if (objarRegister.getFromDate() != null && !objarRegister.getFromDate().isEmpty()) {
			whereCond += " and v.sailing_dt >= to_date('" + objarRegister.getFromDate() + "','dd/mm/yyyy')";
		}
		if (objarRegister.getToDate() != null && !objarRegister.getToDate().isEmpty()) {
			whereCond += " and v.sailing_dt <= to_date('" + objarRegister.getToDate() + "','dd/mm/yyyy')";
		}

		return whereCond;
	}

}