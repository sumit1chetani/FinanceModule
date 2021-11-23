package com.dci.reports.quotationsummary;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.auditlog.UserLogDAO;


	
	
	@Repository
	@Transactional("tenantTransactionManager")

	public class QuotationsummaryDAOImpl implements QuotationsummaryDAO{
		@Autowired
		DataSource dataSource;
		
		@Autowired
		UserLogDAO userlogDao;
		
		
		@Override
		public List<QuotationsummaryBean> getDropDown() {

			List<QuotationsummaryBean> list = new ArrayList<QuotationsummaryBean>();

			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				list = jdbcTemplate.query(QuotationsummaryQueryUtil.GETCUSTOMERLIST,new BeanPropertyRowMapper<QuotationsummaryBean>(QuotationsummaryBean.class));

			} catch (Exception e) {
				e.printStackTrace();
			}

			return list;
		}
		
		
		@Override
		public List<QuotationsummaryBean> searchInvoiceDtl(QuotationsummaryBean objQuotationsummaryBean) throws Exception {
			List<QuotationsummaryBean> searchList = new ArrayList<>();
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				searchList = jdbcTemplate.query(QuotationsummaryQueryUtil.GET_SEARCH, new Object[] {objQuotationsummaryBean.getCustomer()},
						new BeanPropertyRowMapper<>(QuotationsummaryBean.class));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return searchList;
		}
		
		@Override
		public List<QuotationsummaryBean> getFeeList(QuotationsummaryBean feeBean) {
			List<QuotationsummaryBean> feeList=new ArrayList<QuotationsummaryBean>();
			try {
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

				feeList = jdbcTemplate.query(
						QuotationsummaryQueryUtil.list,
						new BeanPropertyRowMapper<QuotationsummaryBean>(
								QuotationsummaryBean.class));
			} catch (DataAccessException e) {
			}
			return feeList;
		}
		


}
