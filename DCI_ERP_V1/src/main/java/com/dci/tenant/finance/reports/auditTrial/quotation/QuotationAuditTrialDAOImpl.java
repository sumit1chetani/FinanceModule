package com.dci.tenant.finance.reports.auditTrial.quotation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;

@Repository
@Transactional("tenantTransactionManager")
public class QuotationAuditTrialDAOImpl implements QuotationAuditTrialDAO {

	@Resource
	 private DataSource dataSource;


	@Override
	public List<SelectivityBean> getEmployeeList() {
		List<SelectivityBean> employeeList = new ArrayList<SelectivityBean>();
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			employeeList = jdbcTemplate.query(QuotationAuditTrialQueryUtil.SELECT_EMPLOYEE_LIST, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public List<QuotationAuditTrialBean> getQuotationList(QuotationAuditTrialBean quotationBean) throws Exception {
		List<QuotationAuditTrialBean> quotationList = new ArrayList<QuotationAuditTrialBean>();
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			if(quotationBean.getMode().equals("1")){
				quotationList = jdbcTemplate.query(QuotationAuditTrialQueryUtil.SELECT_QUOTATION_LIST_BY_CUST_SEA(quotationBean),
						new BeanPropertyRowMapper<QuotationAuditTrialBean>(QuotationAuditTrialBean.class));
			}else if(quotationBean.getMode().equals("2")){
				quotationList = jdbcTemplate.query(QuotationAuditTrialQueryUtil.SELECT_QUOTATION_LIST_BY_CUST_AIR(quotationBean),
						new BeanPropertyRowMapper<QuotationAuditTrialBean>(QuotationAuditTrialBean.class));
			}
/*System.out.println(QuotationAuditTrialQueryUtil.SELECT_QUOTATION_LIST_BY_CUST(quotationBean));
			quotationList = jdbcTemplate.query(QuotationAuditTrialQueryUtil.SELECT_QUOTATION_LIST_BY_CUST(quotationBean),
					new BeanPropertyRowMapper<QuotationAuditTrialBean>(QuotationAuditTrialBean.class));*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		return quotationList;
	}

	@Override
	public List<QuotationAuditTrialBean> jvTariffList(QuotationAuditTrialBean bean) {
		List<QuotationAuditTrialBean> quotationList = new ArrayList<QuotationAuditTrialBean>();
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
System.out.println(QuotationAuditTrialQueryUtil.SELECT_JVTARIFF_LIST_BY_CUST(bean));
			quotationList = jdbcTemplate.query(QuotationAuditTrialQueryUtil.SELECT_JVTARIFF_LIST_BY_CUST(bean),
					new BeanPropertyRowMapper<QuotationAuditTrialBean>(QuotationAuditTrialBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return quotationList;
	}

	@Override
	public List<QuotationAuditTrialBean> getPurQuotList(QuotationAuditTrialBean bean) {
		List<QuotationAuditTrialBean> quotationList = new ArrayList<QuotationAuditTrialBean>();
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
System.out.println(QuotationAuditTrialQueryUtil.SELECT_PURCHASEQUOT_LIST_BY_CUST(bean));
			quotationList = jdbcTemplate.query(QuotationAuditTrialQueryUtil.SELECT_PURCHASEQUOT_LIST_BY_CUST(bean),
					new BeanPropertyRowMapper<QuotationAuditTrialBean>(QuotationAuditTrialBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return quotationList;
	}
}
