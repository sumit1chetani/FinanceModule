package com.dci.tenant.finance.reports.charterhirestatement;

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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("tenantTransactionManager")
public class CharterHireStatementDAOImpl implements CharterHireStatementDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(CharterHireStatementDAOImpl.class);

	@Resource
	 private DataSource dataSource;

	@Override
	public List<CharterHireStatementBean> getCharterHireStmtReportData(CharterHireStatementBean objCharterHireStatementBean) {
		List<CharterHireStatementBean> lCharterHireHdrStmtBean = new ArrayList<CharterHireStatementBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			lCharterHireHdrStmtBean = jdbcTemplate.query(CharterHireStatementQueryUtil.GET_CHARTER_HIRE_STMT_REPORT,
					new Object[] { objCharterHireStatementBean.getVesselCode(), objCharterHireStatementBean.getChFromDate(),
							objCharterHireStatementBean.getChToDate() }, new BeanPropertyRowMapper<CharterHireStatementBean>(
							CharterHireStatementBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in GET_CHARTER_HIRE_STMT_REPORT", e);
		}
		return lCharterHireHdrStmtBean;
	}
}
