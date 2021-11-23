package com.dci.tenant.finance.soa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SOADaoImpl implements SOADao {

	private final static Logger LOGGER = LoggerFactory.getLogger(SOADaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<SOABean> getSoaCustomerRprtList(SOABean soabean) {
		List<SOABean> lSOABean = null;
		try {
			if (soabean.getType().equalsIgnoreCase("customer")) {
				if(soabean.getFromDate()!=null && soabean.getToDate()!=null && soabean.getToDate()!="" && soabean.getFromDate()!="" ) 
					lSOABean = jdbcTemplate.query(SOAQueryUtil.SOA_CUSTOMER_HDR_LIST_date, new Object[] { soabean.getFromDate(), soabean.getToDate() }, new BeanPropertyRowMapper<SOABean>(SOABean.class));
					else {
						lSOABean = jdbcTemplate.query(SOAQueryUtil.SOA_CUSTOMER_HDR_LIST, new BeanPropertyRowMapper<SOABean>(SOABean.class));

					}		}
				
			else if (soabean.getType().equalsIgnoreCase("Supplier")){
				if(soabean.getFromDate()!=null && soabean.getToDate()!=null && soabean.getToDate()!="" && soabean.getFromDate()!="" ) {
					lSOABean = jdbcTemplate.query(SOAQueryUtil.SOA_SUPPLIER_HDR_LIST_date,  new Object[] { soabean.getFromDate(), soabean.getToDate() },new BeanPropertyRowMapper<SOABean>(SOABean.class));
				}
				else {
					lSOABean = jdbcTemplate.query(SOAQueryUtil.SOA_SUPPLIER_HDR_LIST, new BeanPropertyRowMapper<SOABean>(SOABean.class));
				}					
			}
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return lSOABean;
	}

	@Override
	public List<SOABean> soaCustomerRprtSubList(SOABean soabean) {
		List<SOABean> lSOABean = null;
		try {
			if(soabean.getFromDate()!=null && soabean.getToDate()!=null && soabean.getToDate()!="" && soabean.getFromDate()!="" ) 
				lSOABean = jdbcTemplate.query(SOAQueryUtil.SOA_CUSTOMER_DTL_LIST_date, new Object[] {soabean.getAcctCode() , soabean.getAcctCode(),soabean.getFromDate(),soabean.getToDate() }, new BeanPropertyRowMapper<SOABean>(SOABean.class));
			else
				lSOABean = jdbcTemplate.query(SOAQueryUtil.SOA_CUSTOMER_DTL_LIST, new Object[] {soabean.getAcctCode() , soabean.getAcctCode()}, new BeanPropertyRowMapper<SOABean>(SOABean.class));

				
				
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		System.out.println("testcxv"+soabean.getFromDate());

		return lSOABean;
	}

	@Override
	public double debtorBalance(SOABean soabean) {
		double balance = 0;
		try {
			if (soabean.getType().equalsIgnoreCase("customer")) {
				if(soabean.getFromDate()!=null && soabean.getToDate()!=null && soabean.getToDate()!="" && soabean.getFromDate()!="" ) {
					balance = jdbcTemplate.queryForObject(SOAQueryUtil.DEBTOR_OUTSTANDING_date, new Object[] { soabean.getFromDate(), soabean.getToDate() }, Double.class);
				}
				else {
				balance = jdbcTemplate.queryForObject(SOAQueryUtil.DEBTOR_OUTSTANDING, Double.class);
				}
			}
			else if(soabean.getType().equalsIgnoreCase("Supplier")) {
				if(soabean.getFromDate()!=null && soabean.getToDate()!=null && soabean.getToDate()!="" && soabean.getFromDate()!="" ) {
					balance = jdbcTemplate.queryForObject(SOAQueryUtil.CREDITOR_OUTSTANDING_date, new Object[] { soabean.getFromDate(), soabean.getToDate() }, Double.class);
				}
				else {
				balance = jdbcTemplate.queryForObject(SOAQueryUtil.CREDITOR_OUTSTANDING, Double.class);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return balance;
	}

}
