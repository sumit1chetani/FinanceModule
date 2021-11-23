package com.dci.tenant.marketing.quotation;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional("tenantTransactionManager")

public class QuotationDAOImpl implements QuotationDAO {
	DateFormat formatter = null;
    Date convertedDate = null;
	
    @Autowired
	DataSource dataSource;

	@Override
	public List<QuotationBean> QuotationList() {

		List<QuotationBean> list = new ArrayList<QuotationBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(QuotationQueryUtil.list,new BeanPropertyRowMapper<QuotationBean>(QuotationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	//Insert function
	@Override
	public QuotationBean insert(QuotationBean quotation) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isSuccess = false;
		QuotationBean quotationBean = new QuotationBean();
		
		String sequNo="";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	 

			   sequNo= jdbcTemplate.queryForObject(QuotationQueryUtil.Last_seq_no,String.class);
//			   nextSequNo = Integer.parseInt(sequNo);
//			   if (nextSequNo==1) {
//					  nextSequNo = Integer.parseInt(sequNo);
//				  
//			 } else{
//				 nextSequNo = Integer.parseInt(sequNo) +1;
//			 }
				 
			 
			 
			
				  
//				 
////			 a="QUO" + sequNo+1; 
//			 if (nextSequNo <=9) {
//			    	a="QU"+ "000"+nextSequNo;
//						
//					}else if(nextSequNo <=99){
//						
//						a="QU"+"00"+nextSequNo;
//						
//					}  else if(nextSequNo <=999){
//						
//						a="QU"+"0"+nextSequNo;
//					}
//					else {
//						a="QU"+nextSequNo;
//					}
//			
			int i =jdbcTemplate.update(QuotationQueryUtil.INSERT,sequNo,quotation.getQuotation_date(),
					quotation.getServicetype(),quotation.getValidtill(),
					quotation.getExecutive(), quotation.getAgent(),quotation.getAgreeparty(),quotation.getPack_type(),quotation.getBusiness(),quotation.isFreight(),quotation.isOog(),
					quotation.isOdo(),quotation.isHazardous(),
					quotation.getLine(),quotation.getLcid(),quotation.getPol(),quotation.getPod(),
					quotation.getDicd(),quotation.getPot1(),quotation.getPot2(),quotation.getPot3(),quotation.getPot4());
			 if(i>0) {
	            	isSuccess = true;
	            	quotationBean.setSuccess(isSuccess);
	            }
		 
		}catch (DataAccessException e) {
			
			e.printStackTrace();
			isSuccess = false;
			quotationBean.setSuccess(isSuccess);
			quotationBean.setMessage("Error in save :" + e.getMessage());
		}
		return quotationBean;
	}  
	
	
	@Override
	public boolean delete(String quotation_no) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 

		try {
			jdbcTemplate.update(QuotationQueryUtil.delete, quotation_no);

			
			isDeleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			
		}
		return isDeleted;
	}
	

	@Override
	public QuotationBean update(QuotationBean update) throws Exception {
		// TODO Auto-generated method stub
		Boolean isSuccess = false;
		QuotationBean quotationBean = new QuotationBean();
		try {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			int i = jdbcTemplate.update(QuotationQueryUtil.Update,update.getQuotation_date(),
					update.getServicetype(),update.getValidtill(),
					update.getExecutive(), update.getAgent(),update.getAgreeparty(),update.getPack_type(),update.getBusiness(),update.isFreight(),update.isOog(),
					update.isOdo(),update.isHazardous(),
					update.getLine(),update.getLcid(),update.getPol(),update.getPod(),
					update.getDicd(),update.getPot1(),update.getPot2(),update.getPot3(),update.getPot4(),update.getQuotation_no());
			 if(i>0) {
	            	isSuccess = true;
	            	quotationBean.setSuccess(isSuccess);
	            }
		}catch (DataAccessException e) {
			
			e.printStackTrace();
			isSuccess = false;
			quotationBean.setSuccess(isSuccess);
			quotationBean.setMessage("Error in save :" + e.getMessage());
		}
		return quotationBean;
	} 
	
	@Override
	public QuotationBean getEdit(String quotation_no)  {
		// TODO Auto-generated method stub
		QuotationBean quotationbean =new QuotationBean();
		try {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			quotationbean = jdbcTemplate.queryForObject(QuotationQueryUtil.GET_Quotation,
					new Object[] { quotation_no },
					new BeanPropertyRowMapper<QuotationBean>(QuotationBean.class));
		
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		return quotationbean;
	}
	
	
	
	
	
	

	@Override
	public List<QuotationBean> getDropDown() {
		List<QuotationBean> list = new ArrayList<QuotationBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(QuotationQueryUtil.getPortList,new BeanPropertyRowMapper<QuotationBean>(QuotationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<QuotationBean> dropDown() {
		List<QuotationBean> list = new ArrayList<QuotationBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(QuotationQueryUtil.getlineList,new BeanPropertyRowMapper<QuotationBean>(QuotationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	@Override
	public List<QuotationBean> AgentList() {
		List<QuotationBean> list = new ArrayList<QuotationBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(QuotationQueryUtil.getAgentList,new BeanPropertyRowMapper<QuotationBean>(QuotationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<QuotationBean> PartyList() {
		List<QuotationBean> list = new ArrayList<QuotationBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(QuotationQueryUtil.getPartyList,new BeanPropertyRowMapper<QuotationBean>(QuotationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public List<QuotationBean> ExecutiveList() {
		List<QuotationBean> list = new ArrayList<QuotationBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(QuotationQueryUtil.getExeList,new BeanPropertyRowMapper<QuotationBean>(QuotationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	
	
	

}
