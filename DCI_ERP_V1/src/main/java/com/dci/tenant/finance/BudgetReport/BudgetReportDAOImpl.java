package com.dci.tenant.finance.BudgetReport;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BudgetReportDAOImpl implements BudgetReportDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetReportDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public List<BudgetReportBean> searchportDtl(BudgetReportBean objPendingapprovalBean) throws Exception {
		List<BudgetReportBean> searchList = new ArrayList<>();
		String whereCond = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if (objPendingapprovalBean.getCompanyName() != null && !objPendingapprovalBean.getCompanyName().isEmpty()) {
				whereCond = whereCond + " and company='" + objPendingapprovalBean.getCompanyName() + "'";
			}

			if (objPendingapprovalBean.getFinanceyear() != null && !objPendingapprovalBean.getFinanceyear().isEmpty()) {
				whereCond = whereCond + " and financial_year='" + objPendingapprovalBean.getFinanceyear() + "'";
			}

			searchList = jdbcTemplate.query(BudgetReportQueryUtil.list + whereCond + "", new BeanPropertyRowMapper<BudgetReportBean>(BudgetReportBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchList;
	}

}
