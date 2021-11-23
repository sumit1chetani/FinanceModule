package com.dci.tenant.finance.reports.auditTrial.SingleInvoice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("tenantTransactionManager")
public class SingleInvoiceAuditTrialDAOImpl implements SingleInvoiceAuditTrialDAO {

	@Resource
	 private DataSource dataSource;

	@Override
	public List<SingleInvoiceAuditTrialBean> getSingleInvoiceList(SingleInvoiceAuditTrialBean invoiceAuditTrialBean) {
		List<SingleInvoiceAuditTrialBean> singleInvoicList = new ArrayList<SingleInvoiceAuditTrialBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			singleInvoicList = jdbcTemplate.query(SingleInvoiceAuditTrialQueryUtil.SELECT_SINGLE_INVOICE_LIST(invoiceAuditTrialBean),
					new BeanPropertyRowMapper<SingleInvoiceAuditTrialBean>(SingleInvoiceAuditTrialBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singleInvoicList;
	}

	@Override
	public List<SingleInvoiceAuditTrialBean> getEmployeeList() {
		List<SingleInvoiceAuditTrialBean> employeeList = new ArrayList<SingleInvoiceAuditTrialBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try{
			employeeList = jdbcTemplate.query(SingleInvoiceAuditTrialQueryUtil.SELECT_EMPLOYEE_LIST,new BeanPropertyRowMapper<SingleInvoiceAuditTrialBean>(SingleInvoiceAuditTrialBean.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return employeeList;
	}

}
