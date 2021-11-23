package com.dci.tenant.userList;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("tenantTransactionManager")


public class ListDaoImpl implements ListDao {
	
	@Autowired
	DataSource dataSource;
	
	
	public List<ListBean> getList(ListBean invoicelist) throws Exception {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<ListBean> listbean = new ArrayList<ListBean>();
		try{
			if (invoicelist.getInvoiceType() == 1){
			
			listbean = jdbcTemplate.query(ListQueryUtil.Bank_Receipt,new Object[] {invoicelist.getInvoiceNo()}, new BeanPropertyRowMapper<ListBean>(ListBean.class));
			}
			else if(invoicelist.getInvoiceType() == 2){
//	        	Integer slsId= jdbcTemplate.queryForObject(SeaSalesInvoiceQueryUtil.GET_SLS_ID, new Object[] {invoiceDraft.getInvoiceNo()},Integer.class);

				listbean = jdbcTemplate.query(ListQueryUtil.Bank_Payment,new Object[] {invoicelist.getInvoiceNo()}, new BeanPropertyRowMapper<ListBean>(ListBean.class));
			}
			else  if (invoicelist.getInvoiceType()== 3)
			{
				listbean = jdbcTemplate.query(ListQueryUtil.Tds,new Object[] {invoicelist.getInvoiceNo()}, new BeanPropertyRowMapper<ListBean>(ListBean.class));
	
			}
				
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listbean;
	}
	
	
	
}
