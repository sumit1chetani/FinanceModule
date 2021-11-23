package com.dci.tenant.finance.TdsReport;

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
public class TdsReportDAOImpl implements TdsReportDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(TdsReportDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public List<TdsReportBean> searchportDtl(TdsReportBean objPendingapprovalBean) throws Exception {
		List<TdsReportBean> searchList = new ArrayList<>();
		String whereCond = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if (objPendingapprovalBean.getCompanyName() != null && !objPendingapprovalBean.getCompanyName().isEmpty()) {
				whereCond = whereCond + " and b.company_id='" + objPendingapprovalBean.getCompanyName() + "'";
			}

			if (objPendingapprovalBean.getFinanceyear() != null && !objPendingapprovalBean.getFinanceyear().isEmpty()) {
				whereCond = whereCond + " and account_code='" + objPendingapprovalBean.getFinanceyear() + "'";
			}

			if (objPendingapprovalBean.getVendor() != null && !objPendingapprovalBean.getVendor().isEmpty()) {
				whereCond = whereCond + " and sub_account_code='" + objPendingapprovalBean.getVendor() + "'";
			}
			searchList = jdbcTemplate.query(TdsReportQueryUtil.list + whereCond + "", new BeanPropertyRowMapper<>(TdsReportBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchList;
	}

}
