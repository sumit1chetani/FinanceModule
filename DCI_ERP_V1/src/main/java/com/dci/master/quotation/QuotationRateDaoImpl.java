package com.dci.master.quotation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.reports.quotationsummary.QuotationsummaryResultBean;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;
import com.dci.tenant.user.UserDetail;



@Repository
@Transactional("tenantTransactionManager")
public class QuotationRateDaoImpl implements QuotationRateDao {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(QuotationRateDaoImpl.class);

	@Autowired
	DataSource dataSource;
	
	@Autowired
	AuditLogDAO auditLogDao;
	
	@Autowired
	UserLogDAO userlogDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public QuotationRateResultBean getShipment() {

		QuotationRateResultBean bean = new QuotationRateResultBean();
		List<QuotationRateBean> supplierList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> customerList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> currencyList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> portList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> chargeList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> contypeList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> get_voyage = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> get_vessel = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> get_agent = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> get_container = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> gate_out = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> agentList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> surchargelist = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> stufflist = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> conSizeList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> polList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> portseqList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> custShortName = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> custAcctHead = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> vendorAcctHead = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> contractType = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> companyList = new ArrayList<QuotationRateBean>();

		
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			/*supplierList = jdbcTemplate.query(CommonUtilityQueryUtil.get_SHIPMENT,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			*/

			currencyList = jdbcTemplate.query(CommonUtilityQueryUtil.get_currency,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
		/*	portList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PORT_LIST,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			*/
			/*if (!"Y".equalsIgnoreCase(userDetails.getIsVendor())) {
			polList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_POL_LIST, new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			}else {
				polList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_POL_LIST+" and prt_icd_id in ("+userDetails.getUserPortStr()+")   ",
						new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			}*/
			
			/*chargeList = jdbcTemplate.query(CommonUtilityQueryUtil.get_charge,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			
			contypeList = jdbcTemplate.query(CommonUtilityQueryUtil.get_con,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			conSizeList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_CON_SIZE,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			*/
			/*customerList= jdbcTemplate.query(CommonUtilityQueryUtil.get_cust,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			custShortName= jdbcTemplate.query(CommonUtilityQueryUtil.get_cust_short_Name,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			custAcctHead= jdbcTemplate.query(CommonUtilityQueryUtil.get_cust_acct_head,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			vendorAcctHead= jdbcTemplate.query(CommonUtilityQueryUtil.get_vendor_acct_head,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			contractType = jdbcTemplate.query(CommonUtilityQueryUtil.get_contract,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));*/
			
			

			/*get_voyage= jdbcTemplate.query(CommonUtilityQueryUtil.get_voyage,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
		    
			get_vessel= jdbcTemplate.query(CommonUtilityQueryUtil.get_vessel,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			get_agent= jdbcTemplate.query(CommonUtilityQueryUtil.get_agent,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			
			get_container= jdbcTemplate.query(CommonUtilityQueryUtil.get_container,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));*/
			
		/*	if (!"Y".equalsIgnoreCase(userDetails.getIsVendor())) {
			gate_out= jdbcTemplate.query(CommonUtilityQueryUtil.gate_out,new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			}else {
				gate_out= jdbcTemplate.query(CommonUtilityQueryUtil.gate_out+" where depot in ("+userDetails.getUserPortStr()+")",new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			}
			agentList= jdbcTemplate.query(CommonUtilityQueryUtil.get_agentvendor,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));*/
			companyList= jdbcTemplate.query(CommonUtilityQueryUtil.get_comList,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
		/*	surchargelist= jdbcTemplate.query(CommonUtilityQueryUtil.get_surcharge,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			stufflist=  jdbcTemplate.query(CommonUtilityQueryUtil.get_stuff,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));*/
			
			

			 // bean.setPolList(polList);
			 // bean.setContainerSizeList(conSizeList);			
	          //bean.setGetshipmentlist(supplierList);
	          bean.setGetcurrencylist(currencyList);
	          //bean.setGetportlist(portList);
	         // bean.setGetchargetypelist(chargeList);
	        //  bean.setGetcontypelist(contypeList);
	          bean.setGetcustomerlist(customerList);
	         // bean.setCustAcctHead(custAcctHead);
	        //  bean.setVendorAcctHead(vendorAcctHead);
	   
	         /* bean.setVoyageList(get_voyage);
	          bean.setVesselList(get_vessel);
              bean.setAgentList(get_agent);	
              bean.setGetcontainer(get_container);
              bean.setGateOutList(gate_out);*/
              //bean.setMaxGateOutNo(maxGateOutNo);
             // bean.setMaxGateInNo(maxGateInNo);
            /*  bean.setGetagencylist(agentList);
      		  bean.setGetsurchargelist(surchargelist);
      		  bean.setGetstufflist(stufflist);
      		  bean.setCustShortName(custShortName);
      		  bean.setContractType(contractType);*/
      		  bean.setCompList(companyList);

		
		
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get customerList", e);
		}
		return bean;
	
	}

	
	@Override
	public QuotationRateResultBean getShipmentTariff(String isVendor,String userPortStr) {

		QuotationRateResultBean bean = new QuotationRateResultBean();
		List<QuotationRateBean> supplierList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> customerList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> currencyList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> portList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> chargeList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> contypeList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> get_voyage = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> get_vessel = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> get_agent = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> get_container = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> gate_out = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> agentList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> surchargelist = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> stufflist = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> conSizeList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> polList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> portseqList = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> custShortName = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> custAcctHead = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> vendorAcctHead = new ArrayList<QuotationRateBean>();
		
		try {
			//UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			supplierList = jdbcTemplate.query(CommonUtilityQueryUtil.get_SHIPMENT,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			

			currencyList = jdbcTemplate.query(CommonUtilityQueryUtil.get_currency,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			portList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_PORT_LIST,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			if (!"Y".equalsIgnoreCase(isVendor)) {
			polList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_POL_LIST+"  order by portname ", new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			}else {
				polList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_POL_LIST+" and portcode in ("+userPortStr+")  order by portname ",
						new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			}
			
			chargeList = jdbcTemplate.query(CommonUtilityQueryUtil.get_charge,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			
			contypeList = jdbcTemplate.query(CommonUtilityQueryUtil.get_con,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			conSizeList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_CON_SIZE,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			
			customerList= jdbcTemplate.query(CommonUtilityQueryUtil.get_cust,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			custShortName= jdbcTemplate.query(CommonUtilityQueryUtil.get_cust_short_Name,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			custAcctHead= jdbcTemplate.query(CommonUtilityQueryUtil.get_cust_acct_head,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			vendorAcctHead= jdbcTemplate.query(CommonUtilityQueryUtil.get_vendor_acct_head,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			

			

			get_voyage= jdbcTemplate.query(CommonUtilityQueryUtil.get_voyage,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
		    
			get_vessel= jdbcTemplate.query(CommonUtilityQueryUtil.get_vessel,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			get_agent= jdbcTemplate.query(CommonUtilityQueryUtil.get_agent,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			
			get_container= jdbcTemplate.query(CommonUtilityQueryUtil.get_container,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			if (!"Y".equalsIgnoreCase(isVendor)) {
			gate_out= jdbcTemplate.query(CommonUtilityQueryUtil.gate_out,new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			}else {
				gate_out= jdbcTemplate.query(CommonUtilityQueryUtil.gate_out+" where depot in ("+userPortStr+")",new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			}
			agentList= jdbcTemplate.query(CommonUtilityQueryUtil.get_agentvendor,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			surchargelist= jdbcTemplate.query(CommonUtilityQueryUtil.get_surcharge,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			stufflist=  jdbcTemplate.query(CommonUtilityQueryUtil.get_stuff,
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
		/*	String maxGateOutNo = jdbcTemplate.queryForObject(gateOutQueryUtil.GENERATE_GATE_OUT_CODE, String.class);
			
			String maxGateInNo = jdbcTemplate.queryForObject(gateOutQueryUtil.GENERATE_GATE_IN_CODE, String.class);*/

			  bean.setPolList(polList);
			  bean.setContainerSizeList(conSizeList);			
	          bean.setGetshipmentlist(supplierList);
	          bean.setGetcurrencylist(currencyList);
	          bean.setGetportlist(portList);
	          bean.setGetchargetypelist(chargeList);
	          bean.setGetcontypelist(contypeList);
	          bean.setGetcustomerlist(customerList);
	          bean.setCustAcctHead(custAcctHead);
	          bean.setVendorAcctHead(vendorAcctHead);
	   
	          bean.setVoyageList(get_voyage);
	          bean.setVesselList(get_vessel);
              bean.setAgentList(get_agent);	
              bean.setGetcontainer(get_container);
              bean.setGateOutList(gate_out);
             // bean.setMaxGateOutNo(maxGateOutNo);
            //  bean.setMaxGateInNo(maxGateInNo);
              bean.setGetagencylist(agentList);
      		  bean.setGetsurchargelist(surchargelist);
      		  bean.setGetstufflist(stufflist);
      		  bean.setCustShortName(custShortName);
		
		
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get customerList", e);
		}
		return bean;
	
	}
	@Override
	public QuotationRateResultBean list() {
		QuotationRateResultBean bean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<QuotationRateBean> lQuotationBean = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> notDraftList = new ArrayList<QuotationRateBean>();
		/*UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String userId = userDetails.getUserId();*/
		try {	
			
			lQuotationBean = jdbcTemplate.query(
						QuotationRateQueryUtil.GET_Quotation_List, new Object[] {},
						new BeanPropertyRowMapper<QuotationRateBean>(
								QuotationRateBean.class));
			
			notDraftList = jdbcTemplate.query(
					QuotationRateQueryUtil.GET_Quotation_List_Approval, new Object[] {},
					new BeanPropertyRowMapper<QuotationRateBean>(
							QuotationRateBean.class));
				
			bean.setlQuotationBean(lQuotationBean);
			bean.setNotDraftList(notDraftList);
				bean.setSuccess(true);
		
			
		} catch (Exception e) {
			LOGGER.error("Error in list", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;
	}
	
	
	@Override
	public QuotationRateResultBean ratelist() {
		QuotationRateResultBean bean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//List<QuotationRateBean> lQuotationBean = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> notDraftList = new ArrayList<QuotationRateBean>();
		/*UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String userId = userDetails.getUserId();*/
		try {	
			
			
			notDraftList = jdbcTemplate.query(
					QuotationRateQueryUtil.GET_Tariff_RateList, new Object[] {},
					new BeanPropertyRowMapper<QuotationRateBean>(
							QuotationRateBean.class));
				
			//bean.setlQuotationBean(lQuotationBean);
			bean.setNotDraftList(notDraftList);
				bean.setSuccess(true);
		
			
		} catch (Exception e) {
			LOGGER.error("Error in list", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;
	}
	
	
	@Override
	public	 List<QuotationRateBean>  listFilter(QuotationRateBean bean1) {
		QuotationRateResultBean bean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	///	List<BookingBean> list = new ArrayList<BookingBean>();
		List<QuotationRateBean> lQuotationBean = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> notDraftList = new ArrayList<QuotationRateBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String userId = userDetails.getUserId();
		try {	
	
			String query=QuotationRateQueryUtil.GET_Quotation_List1;
			String where="";
			String whereCon="";
			if(bean1.getCustomer()!=null && bean1.getCustomer()!="")
			{
				where+=" and agre_party_id='"+bean1.getCustomer()+"'";
				
			}
			if(bean1.getPol()!=null && bean1.getPol()!="")
			{
				where+=" and pol_id='"+bean1.getPol()+"'";
				
			}
			if(bean1.getPod()!=null && bean1.getPod()!="")
			{
				where+=" and pod_id='"+bean1.getPod()+"'";
				
			}
			
			if(bean1.getValidFrom()!=null && bean1.getValidFrom()!="")
			{
				where+=" and quotation_date >=to_date('"+bean1.getValidFrom()+"','dd/mm/yyy')";
				
			}
			
			if(bean1.getValidTo()!=null && bean1.getValidTo()!="")
			{
				where+=" and valid_till <= to_date('"+bean1.getValidTo()+"','dd/mm/yyy')";
				
			}
			
			if(bean1.getCustcategory()!=null && bean1.getCustcategory()!="")
			{
				where+=" and qh.cust_category='"+bean1.getCustcategory()+"'";
				
			}
			
			if(bean1.getStatus()!=null && bean1.getStatus()!="" && !"All".equalsIgnoreCase(bean1.getStatus()))
			{
				where+=" and upper(qh.status)=upper('"+bean1.getStatus()+"')";
			}
			
			
			
			whereCon = where;
			if("Y".equalsIgnoreCase(userDetails.getIsVendor())) {
				where+=" and pol_id in ("+userDetails.getUserPortStr()+")";
			}
				
			where+=" group by qh.quotation_no,pm.portname ,pm1.portname,cm.cust_name ,user_name order by approved_dt desc  NULLS LAST )";
			
			whereCon+=" and qh.created_by = '"+ userDetails.getUserId() +"' group by qh.quotation_no,pm.portname ,pm1.portname,cm.cust_name ,user_name order by approved_dt desc  NULLS LAST )";
			
			String queryFinal="with a as ( ( "+query+where +" union " + "( "+ query + whereCon +") select * from a order by approved_dt desc NULLS LAST";
			
			System.out.println("quo---"+queryFinal);
			lQuotationBean = jdbcTemplate.query(queryFinal,new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
			
			
			
			notDraftList = jdbcTemplate.query(
					QuotationRateQueryUtil.GET_Quotation_List_Approval, new Object[] {},
					new BeanPropertyRowMapper<QuotationRateBean>(
							QuotationRateBean.class));
				
		     bean.setlQuotationBean(lQuotationBean);
			bean.setNotDraftList(notDraftList);
				bean.setSuccess(true);
		
			
		} catch (Exception e) {
			LOGGER.error("Error in list", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return lQuotationBean;
	}
	
	
	@Override
	public Integer getApprovalStatus(String quotationNo) {
		Integer count = 0;
		try {
			
			count = jdbcTemplate.queryForObject(QuotationRateQueryUtil.COUNT_OF_INVOICE,new Object[] { quotationNo }, Integer.class);
		
		} catch (Exception e) {
			LOGGER.error("Error in list", e);

		}
		return count;
	}
	
	
	@Override
	public QuotationRateResultBean listFilterApproval(QuotationRateBean bean1) {
		QuotationRateResultBean bean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<QuotationRateBean> lQuotationBean = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> notDraftList = new ArrayList<QuotationRateBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String userId = userDetails.getUserId();
		try {	
	
			notDraftList = jdbcTemplate.query(
					QuotationRateQueryUtil.GET_Quotation_List_Approval_filter, new Object[] {bean1.getStatus()},
					new BeanPropertyRowMapper<QuotationRateBean>(
							QuotationRateBean.class));
				
		
			bean.setNotDraftList(notDraftList);
				bean.setSuccess(true);
		
			
		} catch (Exception e) {
			LOGGER.error("Error in list", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;
	}
	
	
	
	
	@Override
	public QuotationRateResultBean getCustomerDetail(String quotHdId) {
		QuotationRateResultBean bean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		QuotationRateBean bean1 = new QuotationRateBean();
		
		try {
			
			bean1 = jdbcTemplate.queryForObject(QuotationRateQueryUtil.GET_CUSTOMER_ADD,new Object[] { quotHdId },
					new BeanPropertyRowMapper<QuotationRateBean>(
							QuotationRateBean.class));

			 bean.setSeaQuotationBean(bean1);
			 bean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in edit", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;
	
}

	@Override
	public QuotationRateResultBean edit(String quotHdId) {
		QuotationRateResultBean bean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		QuotationRateBean bean1 = new QuotationRateBean();
		List<QuotationRateBean> lQuotationBean = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> lQuotationFreeDaysBean = new ArrayList<QuotationRateBean>();
		
		try {
			bean1 = jdbcTemplate.queryForObject(QuotationRateQueryUtil.EDIT_HDR,new Object[] { quotHdId },
					new BeanPropertyRowMapper<QuotationRateBean>(
							QuotationRateBean.class));

			 lQuotationBean = jdbcTemplate.query(
					QuotationRateQueryUtil.EDIT_DTL,
					new Object[] { quotHdId },
					new BeanPropertyRowMapper<QuotationRateBean>(
							QuotationRateBean.class));
			 
			 lQuotationFreeDaysBean = jdbcTemplate.query(
						QuotationRateQueryUtil.EDIT_FREEDAYS_DTL,
						new Object[] { quotHdId },
						new BeanPropertyRowMapper<QuotationRateBean>(
								QuotationRateBean.class));
			
			 bean.setSeaQuotationBean(bean1);
			 bean.setlQuotationBean(lQuotationBean);
			 bean.setQuotationFreeDaysDtl(lQuotationFreeDaysBean);
			 bean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in edit", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;
	
}
	
	
	@Override
	public QuotationRateResultBean view(Integer quotHdId) {/*
		QuotationResultBean bean = new QuotationResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<SeaQuotationBean> lQuotationBean = new ArrayList<SeaQuotationBean>();
		List<TruckconBean> lBean = new ArrayList<TruckconBean>();
		List<SeaQuotationBean>  filefile = new ArrayList<SeaQuotationBean>();
		List<SeaQuotationBean> fileList = new ArrayList<SeaQuotationBean>();
		try {
			lQuotationBean = jdbcTemplate.query(
					QuotationQueryUtil.GET_SEA_QUOTATION_View,
					new Object[] { quotHdId },
					new BeanPropertyRowMapper<SeaQuotationBean>(
							SeaQuotationBean.class));

			List<SeaQuotationDtlPair> lQuotationPortPair = jdbcTemplate.query(
					QuotationQueryUtil.GET_SEA_QUOTATION_Dtl_View,
					new Object[] { quotHdId },
					new BeanPropertyRowMapper<SeaQuotationDtlPair>(
							SeaQuotationDtlPair.class));
			lBean = jdbcTemplate.query(AirQuotationQueryUtil.list2,
					new BeanPropertyRowMapper<TruckconBean>(
							TruckconBean.class),lQuotationBean.get(0).getQuotationNo());
			String dummy = jdbcTemplate.queryForObject(QuotationQueryUtil.dummy,String.class,quotHdId);
			filefile = jdbcTemplate.query(QuotationQueryUtil.FILE_LIST,new BeanPropertyRowMapper<SeaQuotationBean>(SeaQuotationBean.class),dummy);
            fileList = jdbcTemplate.query(QuotationQueryUtil.FILE_LIST,new BeanPropertyRowMapper<SeaQuotationBean>(SeaQuotationBean.class),lQuotationBean.get(0).getQuotationNo());
            
//            String[] name = fileList.split("/");
//			String filepath = name[0] + "/" + name[1] +"/"+name[2] +"/" +name[3] +"/" +name[4] +"/" +name[5] +"/"+name[6];      
//			String filename = name[6];
			
            bean.setFileList(fileList);
            bean.setFilePath(filefile);
            bean.setFile(filefile);
			bean.setFilel(filefile);
			bean.setlQuotationBean(lQuotationBean);
			lQuotationBean.get(0).setQuotationDtl(lQuotationPortPair);
			bean.setlBean(lBean);
			bean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in view", e);
			bean.setSuccess(false);
			bean.setMessage("Error :" + e.getMessage());

		}
		return bean;
	*/return null;}

	

	@Override
	public QuotationRateResultBean save(QuotationRateBean bean) {
		QuotationRateResultBean rbean = new QuotationRateResultBean();
		List<QuotationRateBean> lQuotationFreeDaysBean = new ArrayList<QuotationRateBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String userId = userDetails.getUserId();
		 String quotationNo="";
		try {
			int hdrcnt=0;
			int dtlcnt=0;
			
			 quotationNo=jdbcTemplate.queryForObject(QuotationRateQueryUtil.GENERATE_QUOTATION_NO, String.class);
			 
			 String value ="Insert";
			 InsertErrorLog(quotationNo, value);
			 
			jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_HDR,new Object[] {quotationNo,bean.getCustomer(),bean.getPol(),bean.getPod(),bean.getQuotationDate(),bean.getValidTill(),bean.getStatus(),userId,"C0001",bean.getOrigin(),bean.getCustomerType(),bean.getFreight(),bean.getCurrencyName(),"COC",bean.getCustcategory(),bean.getFreeDays(),bean.getAddress(),bean.getOtCharge(),bean.getAllowOtherPort(),bean.getSoc(),bean.getSpecial(),bean.getCargoType(),bean.getDetentionTariffType(),bean.getRrnumber()});
			 
			 
			
				 int i=0;
				 for(QuotationRateBean obj : bean.getQuotationDtl()){
					 i++;
		
				 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_DTL,new Object[] {quotationNo,obj.getConType(),obj.getChargeType(),obj.getQuotedRate(),obj.getNoOfBox(),obj.getTariff(),i,obj.isHazardous(),obj.isEmpty(),obj.isOog(),obj.getFreeDays(),obj.getLocalCurrency()});
	            	UserLog userLog = userlogDao.userLogForInsert(obj, quotationNo, userDetails.getUserId());

				 }
				 
				 for(QuotationRateBean obj : bean.getQuotationFreeDaysDtl()){
 		
				 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_FREE_DAYS_DTL,new Object[] {quotationNo,obj.getConType(),obj.getPolFreeDays(),obj.getPodFreeDays()} );

				 }
				 
					//String customer=jdbcTemplate.queryForObject(BookingQueryUtil.GET_Cust,String.class,bean.getCustomer());;

					rbean.setQuotNo(quotationNo);
					//rbean.setCustomer(customer);
					
	            	UserLog userLog = userlogDao.userLogForInsert(bean, quotationNo, userDetails.getUserId());
	            	
	            	String empName="",emailids1="";
	            	List<Map<String, Object>> rows = jdbcTemplate.queryForList(QuotationRateQueryUtil.getQuotUserDtl(quotationNo));
	    			for (Map row2 : rows) {
	    				empName = (String) row2.get("emp_name");
	    				emailids1 =  (String) row2.get("email_id");
	    			}
	    			rbean.setEmailid(emailids1);
	    			
					List<QuotationRateBean> chargeList = new ArrayList<QuotationRateBean>();
					chargeList = jdbcTemplate.query(QuotationRateQueryUtil.GET_OF_CHARGE_TO_MAIL,
							new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class), quotationNo);

					rbean.setChargeList(chargeList);
	    			
					
					lQuotationFreeDaysBean = jdbcTemplate.query(
							QuotationRateQueryUtil.EDIT_FREEDAYS_DTL,
							new Object[] { quotationNo },
							new BeanPropertyRowMapper<QuotationRateBean>(
									QuotationRateBean.class));
					
					rbean.setQuotationFreeDaysDtl(lQuotationFreeDaysBean);
	    			
			 rbean.setSuccess(true);
		   updateErrorLog(quotationNo, "Saved");

			
			
		} catch (Exception e) {
			LOGGER.error("Error in save", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
			updateErrorLog(quotationNo, e.toString());

		}
		return rbean;
	}

	@Override
	public QuotationRateResultBean delete(String quotationHdId) {
		QuotationRateResultBean rbean = new QuotationRateResultBean()	;
		QuotationRateResultBean oldbean = edit(quotationHdId);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			
			Integer chk = jdbcTemplate.queryForObject(QuotationRateQueryUtil.check_booking,new Object[] { quotationHdId }, Integer.class);
			
			if(chk==0) {
				jdbcTemplate.update(QuotationRateQueryUtil.Delete_Quotation_Free_days_Dtl,new Object[] 
						{ quotationHdId});

			jdbcTemplate.update(QuotationRateQueryUtil.Delete_Quotation_Dtl,
					new Object[] { quotationHdId });
			jdbcTemplate.update(QuotationRateQueryUtil.Delete_Quotation_Hdr,
					new Object[] { quotationHdId });
			
			UserLog userLog = userlogDao.userLogForDelete(oldbean, quotationHdId, userDetails.getUserId());

			
			rbean.setMessage("Quotation Deleted Successfully");
			rbean.setSuccess(true);
			
			}else {
				rbean.setSuccess(false);
				rbean.setMessage("Quotation refered to Booking");
				
			}
			
			// rbean.setCode(quotationHdId);
			/*userlogDao.userLogForDelete(beanlog, quotationHdId + "",
					userDetails.getUserId());
		*/
		
	
		} catch (Exception e) {
			LOGGER.error("Error in delete", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
	return rbean;
	}

	@Override
	public QuotationRateResultBean approve(QuotationRateBean bean) {
		QuotationRateResultBean rbean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			
			
			jdbcTemplate.update(QuotationRateQueryUtil.APPROVE_QUOTATION,
					new Object[] { userId,"Approved",bean.getApproveRemarks(),bean.getQuotationNo() });

			//////expiring the previous the quotes//////////
			jdbcTemplate.update(QuotationRateQueryUtil.EXPIRE_QUOTATION,
					new Object[] { userId,"EXPIRED",bean.getQuotationNo()+" - approved",bean.getQuotationNo(),bean.getQuotationNo() });
			rbean.setCode(bean.getQuotationNo());
			rbean.setMessage("Quotation Approved Successfully");
			rbean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in approve", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	}
	
	
	@Override
	public QuotationRateResultBean mobapprove(QuotationRateBean bean) {
		QuotationRateResultBean rbean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
		/*	UserDetail userDetails = (UserDetail) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();*/
			String userId = bean.getUserid();
			
			
			jdbcTemplate.update(QuotationRateQueryUtil.APPROVE_QUOTATION,
					new Object[] { userId,"Approved",bean.getApproveRemarks(),bean.getQuotationNo() });

			//////expiring the previous the quotes//////////
			jdbcTemplate.update(QuotationRateQueryUtil.EXPIRE_QUOTATION,
					new Object[] { userId,"EXPIRED",bean.getQuotationNo()+" - approved",bean.getQuotationNo(),bean.getQuotationNo() });
			rbean.setCode(bean.getQuotationNo());
			rbean.setMessage("Quotation Approved Successfully");
			rbean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in approve", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	}
	
	@Override
	public QuotationRateResultBean reject(String quotation) {
		QuotationRateResultBean rbean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			jdbcTemplate.update(QuotationRateQueryUtil.APPROVE_QUOTATION,
					new Object[] { userId,"Rejected",quotation });

			rbean.setCode(quotation);
			rbean.setMessage("Quotation Approved Successfully");
			rbean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in approve", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	}
	
	@Override
	public QuotationRateResultBean reject(QuotationRateBean bean) {
		QuotationRateResultBean rbean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			jdbcTemplate.update(QuotationRateQueryUtil.APPROVE_QUOTATION,
					new Object[] { userId,"Rejected",bean.getRejectRemarks(),bean.getQuotationNo() });

			rbean.setCode(bean.getQuotationNo());
			rbean.setMessage("Quotation Rejcted Successfully");
			 sendMailThread(userDetails,bean);

			rbean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in Reject", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	}
	
	@Override
	public QuotationRateResultBean mobreject(QuotationRateBean bean) {
		QuotationRateResultBean rbean = new QuotationRateResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			/*UserDetail userDetails = (UserDetail) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();*/
			String userId = bean.getUserid();
			jdbcTemplate.update(QuotationRateQueryUtil.APPROVE_QUOTATION,
					new Object[] { userId,"Rejected",bean.getRejectRemarks(),bean.getQuotationNo() });

			rbean.setCode(bean.getQuotationNo());
			rbean.setMessage("Quotation Rejcted Successfully");
			 //sendMailThread(userDetails,bean);

			rbean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in Reject", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	}
	
	private void sendMailThread(final UserDetail userDetails, final QuotationRateBean bean) {
		System.out.println("Thread");
		new Thread(new Runnable() {
			 @Override
			public void run() {
           	try {
           		rejectMail(bean, userDetails);
           		}catch(Exception e){
					e.printStackTrace();
				}
        		
            }
       }).start();
	}
	
	private void rejectMail(QuotationRateBean bean, UserDetail userDetails) {
		try {
			String empName="",emailids1="";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(QuotationRateQueryUtil.getQuotUserDtl(bean.getQuotationNo()));
			for (Map row2 : rows) {
				empName = (String) row2.get("emp_name");
				emailids1 =  (String) row2.get("email_id");
			}
		 
			final Email emailq = new Email();
			String from=userDetails.getEmail();

			if (from == null || "".equals(from)) {
				from = "softwareadmin@fscontainer.com";
			}

			if (emailids1 != null) {
				emailids1 +=","+userDetails.getEmail();
				String[] to1 = getStringSplit(emailids1);
				emailq.setFromEmailAddress(from);
				emailq.setToEmailAddress(to1);
				StringBuffer sbq = new StringBuffer();
				sbq.append("<html><body>");
				sbq.append("<div>Dear " + CommonUtil.returnEmptyForNull(empName) + ",</div>Good day<br><br>");
				sbq.append("<div style=\"width:100%\">Quotation is Rejected  " + "<b>"
						+ CommonUtil.returnEmptyForNull(bean.getQuotationNo()) + "</b></div>");
				
				sbq.append("<div style=\"width:100%\">Reason For Rejection  " + "<b>"
						+ CommonUtil.returnEmptyForNull(bean.getRejectRemarks()) + "</b></div>");
				sbq.append("</body></html>");
				
				sbq.append("<p style=\"width:100%;padding:0px 0 0 0;font-size: 10.0pt;color:#000;\">Best Regards</p>");
				sbq.append("<p style=\"wdth:50%;padding:0px 0 0 0;color:#000;\">" + CommonUtil.returnEmptyForNull(userDetails.getUsername()) + "</p>");
				
				emailq.setBodyHtml(sbq.toString());
				emailq.setSubject("Quotation is Rejected " + bean.getQuotationNo()  );

				try {
						new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									MailUtility.sendMail(emailq, "");
								} catch (Exception e) {

									e.printStackTrace();
								}
							}
						}).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] getStringSplit(String text) {
		String[] str = text.split(",");
		return str;
	}
	
	@Override
	public QuotationRateResultBean downloadfile(String quotationNo) {
		String filePath = "";
		
		QuotationRateResultBean seaquotation =new QuotationRateResultBean();
		
		List<QuotationRateBean> urlList = new ArrayList<QuotationRateBean>();

		
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 	

			urlList = jdbcTemplate.query(QuotationRateQueryUtil.GET_FILES, new Object[] { quotationNo }, new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));

			seaquotation.setFileList(urlList);
			

		} catch (Exception ae) {
			LOGGER.error("Error in dwld file", ae);
		}
		return seaquotation;
	}

	public String generateQuotationNo(Integer branchId, String IE) {

		String quotation = "";
		String quotationBranch = "";
		String dateYear = "";
		int count = 0;
		int count1 = 0;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					QuotationRateQueryUtil.getQuotBranch, branchId, IE);
			for (Map row : rows) {
				quotationBranch = (String) row.get("quotBranch");
			}

			List<Map<String, Object>> rows1 = jdbcTemplate
					.queryForList(QuotationRateQueryUtil
							.getQuotCount(quotationBranch));
			for (Map row2 : rows1) {
				count = (int) row2.get("count");
				count1 = count + 1;
			}

			List<Map<String, Object>> rows4 = jdbcTemplate
					.queryForList(QuotationRateQueryUtil.DateandYear);
			for (Map row5 : rows4) {
				dateYear = (String) row5.get("dateYear");
			}

			if (count <=9) {
				count1 = count + 1;
				quotation=quotationBranch+"/"+dateYear+"/"+"000"+count1;
				
			}else if(count <=99){
				count1 = count + 1;
				quotation=quotationBranch+"/"+dateYear+"/"+"00"+count1;
				
			}  else if(count <=999){
				count1 = count + 1;
				quotation=quotationBranch+"/"+dateYear+"/"+"0"+count1;
			}
			else {
				count1 = count + 1;
				quotation=quotationBranch+"/"+dateYear+"/"+count1;
			}
			
			//quotation = quotationBranch + "/" + dateYear + "/" + count1;

			int id = checkQuoExists(quotation);

			if (id > 0) {
				generateQuotationNo(branchId, IE);
			}

		} catch (Exception e) {
			LOGGER.error("Error in generate code", e);
		}
		return quotation;
	}

	public String generateQuotationNoUpdate(Integer branchId, String IE,
			BigInteger QID) {

		String quotation = "";
		String quotationBranch = "";
		String dateYear = "";
		int count = 0;
		int count1 = 0;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					QuotationRateQueryUtil.getQuotBranch, branchId, IE);
			for (Map row : rows) {
				quotationBranch = (String) row.get("quotBranch");
			}

			List<Map<String, Object>> rows1 = jdbcTemplate
					.queryForList(QuotationRateQueryUtil.getQuotCountUpdate(
							quotationBranch, QID));
			for (Map row2 : rows1) {
				count = (int) row2.get("count");
				count1 = count + 1;
			}

			List<Map<String, Object>> rows4 = jdbcTemplate
					.queryForList(QuotationRateQueryUtil.DateandYear);
			for (Map row5 : rows4) {
				dateYear = (String) row5.get("dateYear");
			}

			if (count <=9) {
				count1 = count + 1;
				quotation=quotationBranch+"/"+dateYear+"/"+"000"+count1;
				
			}else if(count <=99){
				count1 = count + 1;
				quotation=quotationBranch+"/"+dateYear+"/"+"00"+count1;
				
			}  else if(count <=999){
				count1 = count + 1;
				quotation=quotationBranch+"/"+dateYear+"/"+"0"+count1;
			}
			else {
				count1 = count + 1;
				quotation=quotationBranch+"/"+dateYear+"/"+count1;
			}
			
		//	quotation = quotationBranch + "/" + dateYear + "/" + count1;

			int id = checkQuoExists(quotation);

			if (id > 0) {
				generateQuotationNo(branchId, IE);
			}

		} catch (Exception e) {
			LOGGER.error("Error in generate no", e);
		}
		return quotation;
	}

	public int checkQuoExists(String quotation) {
		int id = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			id = jdbcTemplate.queryForObject(
					QuotationRateQueryUtil.CHECK_QUOTATION_EXISTS,
					new Object[] { quotation }, Integer.class);

		} catch (Exception e) {
			LOGGER.error("Error in generate no", e);
		}
		return id;
	}

	@Override
	public List<CommonUtilityBean> getiataList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.PORT_LIST, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getCurrencyList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.GET_CURRENCY, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getServicePartner() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.Get_Service_Partner, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getServicePartnerType() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.Get_Service_Partner_Type,
					new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getBranch() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.GET_Branch, new Object[] {userDetails.getUserId()},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public void insertFiles(String quotationNumber, String filename, String path) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(QuotationRateQueryUtil.INSERT_FILES,
					new Object[] { quotationNumber, filename, path });

		} catch (Exception se) {
			se.printStackTrace();
			throw se;
		}

	}

	@Override
	public List<CommonUtilityBean> getEmployeeList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.Get_Employee_list, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getChargeHeads() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.Get_Charge_Head_list,
					new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<CommonUtilityBean> getTerms() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.Get_Terms, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public QuotationRateResultBean update(QuotationRateBean bean) {
		

		QuotationRateResultBean rbean = new QuotationRateResultBean();
		QuotationRateResultBean oldbean = edit(bean.getQuotationNo());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String userId = userDetails.getUserId();
		try {
			int hdrcnt=0;
			int dtlcnt=0;
			String quotationNo="";
			 quotationNo=jdbcTemplate.queryForObject(QuotationRateQueryUtil.GENERATE_QUOTATION_NO, String.class);
			 
			 
			jdbcTemplate.update(QuotationRateQueryUtil.UPDATE_QUOTATION_HDR,new Object[] {bean.getCustomer(),bean.getPol(),bean.getPod(),bean.getQuotationDate(),bean.getValidTill(),userId,"C0001",bean.getOrigin(),bean.getFreight(),bean.getCurrencyName(),"COC",bean.getCustcategory(),bean.getFreeDays(),bean.getStatus(),bean.getAddress(),bean.getOtCharge(),bean.getAllowOtherPort(),bean.getSoc(),bean.getSpecial(),bean.getCargoType(),bean.getDetentionTariffType(),bean.getQuotationNo()});
			 
        	UserLog userLog = userlogDao.userLogForUpdate(oldbean, bean, bean.getQuotationNo(), userDetails.getUserId());

			jdbcTemplate.update(QuotationRateQueryUtil.Delete_Quotation_Dtl,new Object[] { bean.getQuotationNo() });
			
			UserLog userLogs = userlogDao.userLogForDelete(oldbean, bean.getQuotationNo(), userDetails.getUserId());

			
				 int i=0;
				 for(QuotationRateBean obj : bean.getQuotationDtl()){
					 i++;
		
				 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_DTL,new Object[] {bean.getQuotationNo(),obj.getConType(),obj.getChargeType(),obj.getQuotedRate(),obj.getNoOfBox(),obj.getTariff(),i,obj.isHazardous(),obj.isEmpty(),obj.isOog(),obj.getFreeDays(),obj.getLocalCurrency()});
	            	UserLog userLogss = userlogDao.userLogForInsert(obj, quotationNo, userDetails.getUserId());

				 }
				 
					jdbcTemplate.update(QuotationRateQueryUtil.Delete_Quotation_Free_days_Dtl,new Object[] { bean.getQuotationNo() });
					for(QuotationRateBean obj : bean.getQuotationFreeDaysDtl()){
				 		
						 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_FREE_DAYS_DTL,new Object[] {bean.getQuotationNo(),obj.getConType(),obj.getPolFreeDays(),obj.getPodFreeDays()} );

						 }
					
			rbean.setSuccess(true);
			
			
		} catch (Exception e) {
			LOGGER.error("Error in update", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
}

	@Override
	public List<CommonUtilityBean> getUnitList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.Get_Unit, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public QuotationRateBean print(Integer quotationHdId) {/*
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		SeaQuotationBean objGeneralInvoiceBean = null;
		SeaQuotationBean bean = new SeaQuotationBean();
		List<SeaQuotationDtlPair> lGIDetList = new ArrayList<SeaQuotationDtlPair>();
		try {
			objGeneralInvoiceBean = new SeaQuotationBean();
			
			String name = jdbcTemplate.queryForObject(JobOrderAirQueryUtil.name,String.class, userId);
			objGeneralInvoiceBean = jdbcTemplate.queryForObject(
					QuotationQueryUtil.Get_Hdr_Sea_Quotation,
					new Object[] { quotationHdId },
					new BeanPropertyRowMapper<SeaQuotationBean>(
							SeaQuotationBean.class));

			lGIDetList = jdbcTemplate.query(
					QuotationQueryUtil.Get_Dtl_Sea_Quotation,
					new Object[] { quotationHdId },
					new BeanPropertyRowMapper<SeaQuotationDtlPair>(
							SeaQuotationDtlPair.class));

			
			 * List<Map<String, Object>> rows =
			 * jdbcTemplate.queryForList(CustomerInvoiceQueryUtil
			 * .GET_GENERAL_INVOICE_DTL_TOTAL, new Object[] { invoiceNo }); for
			 * (Map row : rows) {
			 * objGeneralInvoiceBean.setTotalBCamount(((BigDecimal)
			 * row.get("BC_AMOUNT")).doubleValue());
			 * objGeneralInvoiceBean.setTotalTCamount(((BigDecimal)
			 * row.get("TC_AMOUNT")).doubleValue()); }
			 

			// String currencyName =
			// jdbcTemplate.queryForObject(QuotationQueryUtil.GET_CURRENCY_NAME,
			// new Object[] { objGeneralInvoiceBean.getCurrency()
			// },String.class);

			objGeneralInvoiceBean.setQuotationDtl(lGIDetList);
			objGeneralInvoiceBean.setName(name);

		} catch (DataAccessException e) {
			LOGGER.error("Error in view data GI:::", e);
		}
		return objGeneralInvoiceBean;
	*/ return null;
	}

	@Override
	public QuotationRateResultBean saveasDraft(QuotationRateBean bean) {
		return null;/*
		QuotationResultBean rbean = new QuotationResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			String IE = "";
			if (bean.getService() == 1) {
				IE = "E";
			} else {
				IE = "I";
			}
			String quotation = generateQuotationNo(bean.getBranch(), IE);
			String attention = bean.getAttention();
			String carrier = bean.getCarrier();
			String remarks = bean.getRemarks();
			String QuotationDate = bean.getQuotationDate();
			String salesPerson = bean.getSalesPerson();
			String termConditions = bean.getTermConditions();
			String ValidityDate = bean.getValidityDate();
			Integer Aod = bean.getAod();
			Integer Aol = bean.getAol();
			Integer branch = bean.getBranch();
			Integer consignee = bean.getConsignee();
			Integer curr = bean.getCurrency();
			Integer customer = bean.getCustomer();
			Integer destination = bean.getDestination();
			Integer mode = bean.getMode();
			Integer nominatedBy = bean.getNominatedBy();
			Integer origin = bean.getOrigin();
			Integer salesType = bean.getSalesType();
			Integer service = bean.getService();
			Integer shipper = bean.getShipper();
			Integer term = bean.getTerm();
			Integer vendor = bean.getVendor();
			String vessel = bean.getVessel();
			String dimension = bean.getDimensionName();
			String termsConditions = bean.getTermConditions();
			Long qutHdId = null;
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList(QuotationQueryUtil.QUOTATION_DRAFT_HD_ID);
			for (Map row : rows) {
				qutHdId = (Long) row.get("QHdId");
			}

			List<SeaQuotationDtlPair> quotationportpair = bean
					.getQuotationDtl();

			Integer quoteHdId = jdbcTemplate.queryForObject(
					QuotationQueryUtil.INSERT_QUOTATION_DRAFT,
					new Object[] { quotation, attention, carrier, remarks,
							QuotationDate, salesPerson, termConditions,
							ValidityDate, Aod, Aol, branch, consignee, curr,
							customer, destination, nominatedBy, origin,
							salesType, service, shipper, term, vendor,
							bean.getCommodity(), qutHdId, userId, userId,
							vessel }, Integer.class);
			for (int pp = 0; pp <= quotationportpair.size() - 1; pp++) {
				Long qutDtlId = null;
				List<Map<String, Object>> rows1 = jdbcTemplate
						.queryForList(QuotationQueryUtil.QUOTATION_DRAFT_DTL_ID);
				for (Map row : rows1) {
					qutDtlId = (Long) row.get("QDtlId");
				}

				Integer quoteDtlId = jdbcTemplate
						.queryForObject(
								QuotationQueryUtil.INSERT_QUOTATION_DTL_DRAFT,
								new Object[] {
										quoteHdId,
										quotationportpair.get(pp).getChargeHeads(),
										quotationportpair.get(pp).getUnit(),
										quotationportpair.get(pp).getQty(),
										quotationportpair.get(pp).getRate(),
										quotationportpair.get(pp).getCurrency(),
										quotationportpair.get(pp).getPaymentMethod(),
										quotationportpair.get(pp).getTransactionType(),
										quotationportpair.get(pp).getBuySell().longValue(),
										quotationportpair.get(pp).getNote(),qutDtlId }, Integer.class);
			}
			rbean.setCode(quotation);
			rbean.setMessage("Quotation Saved as Draft Successfully");
			rbean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in draft", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	*/}

/*	@Override
	public QuotationRateResultBean approve(QuotationRateBean bean) {
		QuotationResultBean rbean = new QuotationResultBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {

			jdbcTemplate.update(
					QuotationQueryUtil.Delete_Sea_Quotation_tmp_Dtl,
					new Object[] { bean.getQuotationId() });
			jdbcTemplate.update(QuotationQueryUtil.Delete_Sea_Quotation_tmp,
					new Object[] { bean.getQuotationId() });

			UserDetail userDetails = (UserDetail) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			String IE = "";
			if (bean.getService() == 1) {
				IE = "E";
			} else {
				IE = "I";
			}
			String quotation = generateQuotationNo(bean.getBranch(), IE);
			String attention = bean.getAttention();
			String carrier = bean.getCarrier();
			String remarks = bean.getRemarks();
			String QuotationDate = bean.getQuotationDate();
			String salesPerson = bean.getSalesPerson();
			String termConditions = bean.getTermConditions();
			String ValidityDate = bean.getValidityDate();
			Integer Aod = bean.getAod();
			Integer Aol = bean.getAol();
			Integer branch = bean.getBranch();
			Integer consignee = bean.getConsignee();
			Integer curr = bean.getCurrency();
			Integer customer = bean.getCustomer();
			Integer destination = bean.getDestination();
			Integer mode = bean.getMode();
			Integer nominatedBy = bean.getNominatedBy();
			Integer origin = bean.getOrigin();
			Integer salesType = bean.getSalesType();
			Integer service = bean.getService();
			Integer shipper = bean.getShipper();
			Integer term = bean.getTerm();
			Integer vendor = bean.getVendor();
			String vessel = bean.getVessel();
			String dimension = bean.getDimensionName();
			String termsConditions = bean.getTermConditions();
			Long qutHdId = null;
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList(QuotationQueryUtil.QUOTATION_HD_ID);
			for (Map row : rows) {
				qutHdId = (Long) row.get("QHdId");
			}

			List<SeaQuotationDtlPair> quotationportpair = bean
					.getQuotationDtl();

			Integer quoteHdId = jdbcTemplate.queryForObject(
					QuotationQueryUtil.INSERT_QUOTATION,
					new Object[] { quotation, attention, carrier, remarks,
							QuotationDate, salesPerson, termConditions,
							ValidityDate, Aod, Aol, branch, consignee, curr,
							customer, destination, nominatedBy, origin,
							bean.getCommodity(), qutHdId, userId, userId,
							vessel,dimension}, Integer.class);
			for (int pp = 0; pp <= quotationportpair.size() - 1; pp++) {
				Long qutDtlId = null;
				List<Map<String, Object>> rows1 = jdbcTemplate
						.queryForList(QuotationQueryUtil.QUOTATION_DTL_ID);
				for (Map row : rows1) {
					qutDtlId = (Long) row.get("QDtlId");
				}

				Integer quoteDtlId = jdbcTemplate
						.queryForObject(
								QuotationQueryUtil.INSERT_QUOTATION_DTL,
								new Object[] {
										quoteHdId,
										quotationportpair.get(pp)
												.getChargeHeads(),
										quotationportpair.get(pp).getUnit(),
										quotationportpair.get(pp).getQty(),
										quotationportpair.get(pp).getRate(),
										quotationportpair.get(pp).getCurrency(),
										quotationportpair.get(pp)
												.getPaymentMethod(),
										quotationportpair.get(pp)
												.getTransactionType(),
										quotationportpair.get(pp).getBuySell()
												.longValue(),
										quotationportpair.get(pp).getNote(),
										qutDtlId }, Integer.class);
			}
			rbean.setCode(quotation);
			rbean.setMessage("Quotation Saved Successfully");
			rbean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			rbean.setMessage("Error :" + e.getMessage());
			rbean.setSuccess(false);
		}
		return rbean;
	
		return null;}
*/
	@Override
	public List<CommonUtilityBean> getuomList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(
					QuotationRateQueryUtil.Get_Uom_List, new Object[] {},
					new BeanPropertyRowMapper<CommonUtilityBean>(
							CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}

	@Override
	public List<String> getFileNameList(Integer quotationHdId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> nameList = new ArrayList<String>();
		try {
			nameList = jdbcTemplate.queryForList(
					QuotationRateQueryUtil.Get_File_Name_List,
					new Object[] { quotationHdId }, (String.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return nameList;
	}

	@Override
	public void updateFiles(String quotationNo, List<String> check,
			String filepath, List<String> filepaths) {
		List<String> quotationNumberList = Arrays.asList(quotationNo.split("\\s*,\\s*"));

		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(QuotationRateQueryUtil.delete_FILES,
					new Object[] { quotationNumberList.get(0) });

			for (String listName : check) {
				jdbcTemplate.update(QuotationRateQueryUtil.INSERT_FILES, new Object[] {
						quotationNumberList.get(0), listName, filepath });

			}
			for (String listName1 : filepaths) {
				jdbcTemplate.update(QuotationRateQueryUtil.INSERT_FILES, new Object[] {
						quotationNumberList.get(0), listName1, filepath });

			}

		} catch (Exception se) {
			LOGGER.error("Error", se);
			throw se;
		}
	}

	@Override
	public QuotationRateResultBean getServicePartnerDropdownList() {/*
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		QuotationResultBean bean = new QuotationResultBean();
		try {
			String qry=AirQuotationQueryUtil.Get_Service_Partner;
			lCommonUtilityBean = jdbcTemplate.query(qry+" where cstmr_bt='1' order by srvc_prtnr_cd",new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			bean.setCustomerList(lCommonUtilityBean);
			lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
			lCommonUtilityBean = jdbcTemplate.query(qry+" where  cnsgn_bt='1' order by srvc_prtnr_cd",new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			bean.setConsigneeList(lCommonUtilityBean);
			lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
			lCommonUtilityBean = jdbcTemplate.query(qry+" where shppr_bt='1' order by srvc_prtnr_cd",new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			bean.setShipperList(lCommonUtilityBean);
			lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
			lCommonUtilityBean = jdbcTemplate.query(qry+" order by srvc_prtnr_cd",new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			bean.setNominatedList(lCommonUtilityBean);
			lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
			lCommonUtilityBean = jdbcTemplate.query(qry+" where vndr_bt='1' order by srvc_prtnr_cd",new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			bean.setVendorList(lCommonUtilityBean);
			lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
			lCommonUtilityBean = jdbcTemplate.query(qry+" order by srvc_prtnr_cd",new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			bean.setServiceParnrList(lCommonUtilityBean);

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
	*/	return null;
	}
	
	@Override
	public QuotationRateResultBean getServicePartnerDropdownListid(String id) {/*
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		QuotationResultBean bean = new QuotationResultBean();
		try {
			if(id.equalsIgnoreCase("1")){//buy
				String qry=AirQuotationQueryUtil.Get_Service_Partner;				
				lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
				lCommonUtilityBean = jdbcTemplate.query(qry+" where sundry_type in ('20010002','20010003') order by srvc_prtnr_cd",new Object[]{},
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				bean.setServiceParnrList(lCommonUtilityBean);
			}else{//sell
				String qry=AirQuotationQueryUtil.Get_Service_Partner;	
				lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
				lCommonUtilityBean = jdbcTemplate.query(qry+" where sundry_type in ('10080002','10080003') order by srvc_prtnr_cd",new Object[]{},
						new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
				bean.setServiceParnrList(lCommonUtilityBean);
			}
			

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
	*/	return null;
	}

	@Override
	public List<CommonUtilityBean> getcommodity() {
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		try {
			lCommonUtilityBean = jdbcTemplate.query(QuotationRateQueryUtil.getcommodity, new Object[] {},new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return lCommonUtilityBean;
	}
	
	@Override
	public boolean uploaddelete(String quotationNo) {
		boolean uploaddelete = false;
		
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 	
			jdbcTemplate.update(QuotationRateQueryUtil.delete_FILES, new Object[] { quotationNo});
			uploaddelete = true;
			
		}catch(Exception e){
			
		}
		return uploaddelete;
	}
	
	@Override
	public boolean deletefiles(String fileName) {
		boolean filedelete = false;
		try{
		 String qry1 ="";
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 	
		 qry1=" where file_name  like ('%"+fileName+"%')";
		 
		 String queryBuilder = QuotationRateQueryUtil.delete_FILENAME + qry1;
		 
			jdbcTemplate.update(queryBuilder);

		
		/*try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 	
			
			jdbcTemplate.update(AirQuotationQueryUtil.delete_FILENAME, new Object[] { fileName});
			filedelete = true;*/
			
		} catch(Exception e){
			LOGGER.error("Error", e);
			
		}
		return filedelete;
	}
	
	

@Override
	public QuotationRateResultBean getCustomerList() {
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
		QuotationRateResultBean bean = new QuotationRateResultBean();
		try {/*
			String qry=AirQuotationQueryUtil.Get_Customer;
			lCommonUtilityBean = jdbcTemplate.query(qry+" order by srvc_prtnr_cd",new Object[]{},
					new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
			bean.setCustomerList(lCommonUtilityBean);
			

		*/} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
		}
		return bean;
	}

@Override
public QuotationRateResultBean getCustomerListCompany(String company) {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	List<CommonUtilityBean> lCommonUtilityBean = new ArrayList<CommonUtilityBean>();
//	QuotationResultBean bean = new QuotationResultBean();
	
	QuotationRateResultBean bean = new QuotationRateResultBean();
	
	try {/*
		
		
		lCommonUtilityBean = jdbcTemplate.query(AirQuotationQueryUtil.Get_Customer_company,new Object[]{company,company},
				new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class));
		
		bean.setCustomerList(lCommonUtilityBean);
		

	*/} catch (DataAccessException e) {
		LOGGER.error("Error in addCodeStandard", e);
	}
	return bean;

		}


	@Override
	public List<QuotationRateBean> getChargeList(String pol, String pod, String chargeType, String conType,String hazardous, String oog) {

		List<QuotationRateBean> listBean = new ArrayList<QuotationRateBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String query = "select case when hdr.is_slab='t' then (select rateday from local_charges_slab where l_no =hdr.l_no "
					+ " and l_no_dtl=dtl.l_no_dtl limit 1) when hdr.is_slab='f' then amount else 0 end as tariff "
					+ " from local_charges_hdr hdr inner join local_charges_dtl dtl on dtl.l_no=hdr.l_no"
					+ "  where (port=? or port=?) and dtl.surcharge=? and dtl.container_type=? and  dtl.is_hazardous::boolean =?::boolean and dtl.is_oog::boolean=?::boolean and dtl.charge_type= 'Export' order by hdr.created_date desc limit 1";

			listBean = jdbcTemplate.query(query, new Object[] { pol, pod, chargeType, conType,hazardous,oog },
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listBean;
	}

@Override
public List<QuotationRateBean> getdefaultchargeList(String pol,String crnyName) {
	
	List<QuotationRateBean> listBean = new ArrayList<QuotationRateBean>(); 
	
	try{
		String query=" with a as ( " + 
				" select l_no from local_charges_hdr where port =? and now()::date between from_date and to_date order by created_date  desc limit 1 )   " + 
				" ,tm as (   " + 
				" select container_type conType , amount"+//round( get_ex_rate ('"+crnyName+"',now()::date)*round(amount/get_ex_rate (currency,now()::date),2),2) as    " + 
				"				 quotedRate,b.surcharge chargeType,currency localCurrency,   " + 
				"				 case when a.is_slab='t' then (select rateday from local_charges_slab where l_no =a.l_no     " + 
				"				  and l_no_dtl=b.l_no_dtl limit 1) when a.is_slab='f' then amount else 0 end as tariff ,is_hazardous as hazardous,is_oog  as oog   " + 
				"				   from local_charges_dtl b join local_charges_hdr a using(l_no) where  a.l_no=(select * from a)    " + 
				"				 and  (charge_type ='Export' or charge_type ='' or charge_type is null )    " + 
				"				 ),    " + 
				"				 tp as (   " + 
				" select distinct 'SC0001' as chargeType,conType ,localCurrency, hazardous, oog from tm cross join (select 'SC0001')aa where  conType is not null and conType !=''    " + 
				"				 )      " + 
				"				  select * from tm union select conType,0.0 as quotedRate ,chargeType,localCurrency,0, hazardous , oog from tp order by quotedRate ";
				
				
				/*" with tm as (select container_type conType ,round( get_ex_rate ('"+crnyName+"',now()::date)*round(amount/get_ex_rate (currency,now()::date),2),2) as\n" + 
				" quotedRate,surcharge chargeType,currency localCurrency from local_charges_dtl where  (charge_type ='Export' or charge_type is null or charge_type ='')\n" + 
				"  and l_no in(select l_no from local_charges_hdr where port = ? and now()::date between from_date and to_date order by created_date  desc limit 1)), \n" + 
				"				tp as (select distinct 'SC0001' as chargeType,conType ,localCurrency from tm cross join (select 'SC0001')aa where\n" + 
				"				 conType is not null and conType !='' ) \n" + 
				"				 select * from tm union select conType,0.0 as quotedRate ,chargeType,localCurrency from tp order by quotedRate";	*/	
		
		
		listBean = jdbcTemplate.query(query, new Object[] {pol},new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}		
	
	return listBean;
}


@Override
public List<SelectivityBean> getCustomereditDropdown(String quoteNo) {
	List<SelectivityBean> list = new ArrayList<SelectivityBean>();

	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		list = jdbcTemplate.query(QuotationRateQueryUtil.GET_CUSTOMER_EDIT,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class),quoteNo);

	} catch (Exception e) {
		e.printStackTrace();
	}

	return list;
}




@Override
public QuotationsummaryResultBean checkQuoteExists(String pol, String pod, String customer,String special,String cargoType) {
	QuotationsummaryResultBean bean = new QuotationsummaryResultBean();

	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		 int count= jdbcTemplate.queryForObject(QuotationRateQueryUtil.Check_Quot_Exists,int.class,pol,pod,customer,special,cargoType);

			if(count == 0){
				bean.setSuccess(true);
			}
			else{
				bean.setSuccess(false);
				bean.setMessage("Valid quotation is available for the same port pair, do you want to add more container type?");
			}
	} catch (Exception e) {
		e.printStackTrace();
	}

	return bean;
}

@Override
public QuotationRateResultBean saveNewQuotation(QuotationRateBean bean) {
	QuotationRateResultBean rbean = new QuotationRateResultBean();
	List<QuotationRateBean> lQuotationFreeDaysBean = new ArrayList<QuotationRateBean>();

	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 String userId = userDetails.getUserId();
	try {
		int hdrcnt=0;
		int dtlcnt=0;
		String quotationNo="";
		
		List<QuotationRateBean>	prevQuotNos = jdbcTemplate.query(QuotationRateQueryUtil.GET_PREV_QUOT_NO,
				new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class),bean.getPol(),bean.getPod(),bean.getCustomer(),bean.getSpecial(),bean.getCargoType());
		
		for(QuotationRateBean rateBean : prevQuotNos){
			jdbcTemplate.update(QuotationRateQueryUtil.INACTIVE_QUOTATION,
					new Object[] {   rateBean.getQuotationNo() });
		}
			quotationNo=jdbcTemplate.queryForObject(QuotationRateQueryUtil.GENERATE_QUOTATION_NO, String.class);

		jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_HDR,new Object[] {quotationNo,bean.getCustomer(),bean.getPol(),bean.getPod(),bean.getQuotationDate(),bean.getValidTill(),bean.getStatus(),userId,"C0001",bean.getOrigin(),bean.getCustomerType(),bean.getFreight(),bean.getCurrencyName(),"COC",bean.getCustcategory(),bean.getFreeDays(),bean.getAddress(),bean.getOtCharge(),bean.getAllowOtherPort(),bean.getSoc(),bean.getSpecial(),bean.getCargoType(),bean.getDetentionTariffType()});
		 
		 
		
			 int i=0;
			 for(QuotationRateBean obj : bean.getQuotationDtl()){
				 i++;
	
			 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_DTL,new Object[] {quotationNo,obj.getConType(),obj.getChargeType(),obj.getQuotedRate(),obj.getNoOfBox(),obj.getTariff(),i,obj.isHazardous(),obj.isEmpty(),obj.isOog(),obj.getFreeDays(),obj.getLocalCurrency()});
            	UserLog userLog = userlogDao.userLogForInsert(obj, quotationNo, userDetails.getUserId());

			 }
			 for(QuotationRateBean obj : bean.getQuotationFreeDaysDtl()){
			 		
				 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_FREE_DAYS_DTL,new Object[] {quotationNo,obj.getConType(),obj.getPolFreeDays(),obj.getPodFreeDays()} );

				 }
			//	String customer=jdbcTemplate.queryForObject(BookingQueryUtil.GET_Cust,String.class,bean.getCustomer());;
				
				rbean.setQuotNo(quotationNo);
				//rbean.setCustomer(customer);
				
				
			
				
            	UserLog userLog = userlogDao.userLogForInsert(bean, quotationNo, userDetails.getUserId());
            	
            	String empName="",emailids1="";
            	List<Map<String, Object>> rows = jdbcTemplate.queryForList(QuotationRateQueryUtil.getQuotUserDtl(quotationNo));
    			for (Map row2 : rows) {
    				empName = (String) row2.get("user_name");
    				emailids1 =  (String) row2.get("user_id");
    			}
    			rbean.setEmailid(emailids1);
    			
				List<QuotationRateBean> chargeList = new ArrayList<QuotationRateBean>();
				chargeList = jdbcTemplate.query(QuotationRateQueryUtil.GET_OF_CHARGE_TO_MAIL,
						new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class), quotationNo);

				rbean.setChargeList(chargeList);
    			
				lQuotationFreeDaysBean = jdbcTemplate.query(
						QuotationRateQueryUtil.EDIT_FREEDAYS_DTL,
						new Object[] { quotationNo },
						new BeanPropertyRowMapper<QuotationRateBean>(
								QuotationRateBean.class));
				
				rbean.setQuotationFreeDaysDtl(lQuotationFreeDaysBean);
    			
		 rbean.setSuccess(true);
	   updateErrorLog(quotationNo, "Saved");
 		
		
	} catch (Exception e) {
		LOGGER.error("Error in save", e);
		rbean.setMessage("Error :" + e.getMessage());
		rbean.setSuccess(false);
	}
	return rbean;
}

@Override
public QuotationRateResultBean saveQuotationDtl(QuotationRateBean bean) {
	QuotationRateResultBean rbean = new QuotationRateResultBean();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 String userId = userDetails.getUserId();
		List<QuotationRateBean> lQuotationBean = new ArrayList<QuotationRateBean>();
		List<QuotationRateBean> lQuotationFreeDaysBean = new ArrayList<QuotationRateBean>();

	try {
		int hdrcnt=0;
		int dtlcnt=0;
 		
		String quotNo = jdbcTemplate.queryForObject(QuotationRateQueryUtil.GET_PREV_QUOT_NO, String.class,bean.getPol(),bean.getPod(),bean.getCustomer());
		
		 lQuotationBean = jdbcTemplate.query(
					QuotationRateQueryUtil.EDIT_DTL,
					new Object[] { quotNo },
					new BeanPropertyRowMapper<QuotationRateBean>(
							QuotationRateBean.class));
		  int contRepCount=0;
		 for(QuotationRateBean obj1 :lQuotationBean	){
			 for(QuotationRateBean obj2 : bean.getQuotationDtl()){
				 if(obj2.getConType().equalsIgnoreCase(obj1.getConType())){
					 contRepCount++; 
				 }
				 
			 }
			 
		 }
		 
		 lQuotationFreeDaysBean = jdbcTemplate.query(
					QuotationRateQueryUtil.EDIT_FREEDAYS_DTL,
					new Object[] { quotNo },
					new BeanPropertyRowMapper<QuotationRateBean>(
							QuotationRateBean.class));
		 
		 for(QuotationRateBean obj1 :lQuotationFreeDaysBean	){
			 for(QuotationRateBean obj2 : bean.getQuotationFreeDaysDtl()){
				 if(obj2.getConType().equalsIgnoreCase(obj1.getConType())){
					 contRepCount++; 
				 }
				 
			 }
			 
		 }
		 
			 int i=0;
			 if(contRepCount == 0){
			 for(QuotationRateBean obj : bean.getQuotationDtl()){
				 i++;
	
			 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_DTL,new Object[] {quotNo,obj.getConType(),obj.getChargeType(),obj.getQuotedRate(),obj.getNoOfBox(),obj.getTariff(),i,obj.isHazardous(),obj.isEmpty(),obj.isOog(),obj.getFreeDays(),obj.getLocalCurrency()});
            	UserLog userLog = userlogDao.userLogForInsert(obj, quotNo, userDetails.getUserId());

				 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_FREE_DAYS_DTL,new Object[] {quotNo,obj.getConType(),obj.getPolFreeDays(),obj.getPodFreeDays()} );

			 }
				 
				jdbcTemplate.update(QuotationRateQueryUtil.UPDATE_STATUS_AS_UNAPPROVE,new Object[] {quotNo});
	
            	UserLog userLog = userlogDao.userLogForInsert(bean, quotNo, userDetails.getUserId());
            	
             
			 
    			
    			
		 rbean.setSuccess(true);
			 }
			 else{
				 rbean.setMessage("Same Cont Type not allowed! To know the available container types check the quotation "+quotNo);
					rbean.setSuccess(false);
			 }
		
	} catch (Exception e) {
		LOGGER.error("Error in save", e);
		rbean.setMessage("Error :" + e.getMessage());
		rbean.setSuccess(false);
	}
	return rbean;
}

@Override
public QuotationRateBean print(String quotationNo) {
	QuotationRateBean bean = new QuotationRateBean();
	Integer count =0;
	try{/*
		
		
			bean = jdbcTemplate.queryForObject(InvoiceQueryUtil.GET_INV_HDR_Cust,
					new Object[] { quotationNo },
					new BeanPropertyRowMapper<QuotationRateBean>(QuotationRateBean.class));
				
		
	*/}catch(Exception e){
		e.printStackTrace();
	}
	return bean;
}

@Override
public QuotationRateResultBean getspecial() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public QuotationRateResultBean getcargotype() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void updateErrorLog(String moduleID, String value) {

	try {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
 int i = jdbcTemplate.update(QuotationRateQueryUtil.Update_mail_log,userDetails.getUserId(),value,moduleID);

	}catch(Exception e){
		e.printStackTrace();
	}
	
}

public void InsertErrorLog(String moduleID, String value) {

	try {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
 int i = jdbcTemplate.update(QuotationRateQueryUtil.Insert_mail_log,moduleID,userDetails.getUserId(),value);

	}catch(Exception e){
		e.printStackTrace();
	}
	
}

@Override
public QuotationRateResultBean saveRateCharges(QuotationRateBean bean) {
	

	QuotationRateResultBean rbean = new QuotationRateResultBean();
	//QuotationRateResultBean oldbean = edit(bean.getQuotationNo());
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	//UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	// String userId = userDetails.getUserId();
	try {
//		int hdrcnt=0;
//		int dtlcnt=0;
		//String quotationNo="";
		// quotationNo=jdbcTemplate.queryForObject(QuotationRateQueryUtil.GENERATE_QUOTATION_NO, String.class);
		 
		 
		//jdbcTemplate.update(QuotationRateQueryUtil.UPDATE_QUOTATION_HDR,new Object[] {bean.getCustomer(),bean.getPol(),bean.getPod(),bean.getQuotationDate(),bean.getValidTill(),userId,"C0001",bean.getOrigin(),bean.getFreight(),bean.getCurrencyName(),"COC",bean.getCustcategory(),bean.getFreeDays(),bean.getStatus(),bean.getAddress(),bean.getOtCharge(),bean.getAllowOtherPort(),bean.getSoc(),bean.getSpecial(),bean.getCargoType(),bean.getDetentionTariffType(),bean.getQuotationNo()});
		 
    	//UserLog userLog = userlogDao.userLogForUpdate(oldbean, bean, bean.getQuotationNo(), userDetails.getUserId());

		jdbcTemplate.update(QuotationRateQueryUtil.Delete_Quotation_Dtl,new Object[] { bean.getQuotationNo() });
		
		//UserLog userLogs = userlogDao.userLogForDelete(oldbean, bean.getQuotationNo(), userDetails.getUserId());

		
			 int i=0;
			 for(QuotationRateBean obj : bean.getQuotationDtl()){
				 i++;
	
			 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_DTL,new Object[] {bean.getQuotationNo(),obj.getConType(),obj.getChargeType(),obj.getQuotedRate(),obj.getNoOfBox(),obj.getTariff(),i,obj.isHazardous(),obj.isEmpty(),obj.isOog(),obj.getFreeDays(),obj.getLocalCurrency()});
            	//UserLog userLogss = userlogDao.userLogForInsert(obj, quotationNo, userDetails.getUserId());

			 }
			 
			/*
			 * jdbcTemplate.update(QuotationRateQueryUtil.Delete_Quotation_Free_days_Dtl,new
			 * Object[] { bean.getQuotationNo() }); for(QuotationRateBean obj :
			 * bean.getQuotationFreeDaysDtl()){
			 * 
			 * jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_FREE_DAYS_DTL,new
			 * Object[] {bean.getQuotationNo(),obj.getConType(),obj.getPolFreeDays(),obj.
			 * getPodFreeDays()} );
			 * 
			 * }
			 */
				
		rbean.setSuccess(true);
		
		
	} catch (Exception e) {
		LOGGER.error("Error in update", e);
		rbean.setMessage("Error :" + e.getMessage());
		rbean.setSuccess(false);
	}
	return rbean;
}

@Override
public QuotationRateResultBean savereview(QuotationRateBean bean) {
	QuotationRateResultBean rbean = new QuotationRateResultBean();
	List<QuotationRateBean> lQuotationFreeDaysBean = new ArrayList<QuotationRateBean>();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 String userId = userDetails.getUserId();
	 String quotationNo="";
	try {
		
		int hdrcnt=0;
		int dtlcnt=0;  
		 int i = 0;
			 for(QuotationRateBean obj : bean.getQuotationDtl()){
		i++;
			 jdbcTemplate.update(QuotationRateQueryUtil.SAVE_QUOTATION_DTL_log,new Object[] {bean.getQuotationNo(),obj.getConType(),obj.getChargeType(),obj.getQuotedRate(),obj.getNoOfBox(),obj.getTariff(),i,obj.isHazardous(),obj.isEmpty(),obj.isOog(),obj.getFreeDays(),obj.getLocalCurrency(),userId} );
			 jdbcTemplate.update(QuotationRateQueryUtil.UPDATE_QUOTATION_FREE_DAYS_DTL,new Object[] {obj.getQuotedRate1(), bean.getQuotationNo(),obj.getConType()} );

			 
			 }
			 
    			
		 rbean.setSuccess(true);
	   updateErrorLog(quotationNo, "Saved");

		
		
	} catch (Exception e) {
		LOGGER.error("Error in save", e);
		rbean.setMessage("Error :" + e.getMessage());
		rbean.setSuccess(false);
		updateErrorLog(quotationNo, e.toString());

	}
	return rbean;
}

@Override
public QuotationRateBean getmrgRate(String mlo, String pod, String pol, String conType) {
	QuotationRateBean bean = new QuotationRateBean();
	try {
		int count =jdbcTemplate.queryForObject(QuotationRateQueryUtil.GET_MRG_DTL_COUNT,Integer.class,mlo,pod,pol,conType );
		if(count >0) {
			double rate = jdbcTemplate.queryForObject(QuotationRateQueryUtil.GET_MRG_DTL_RATE,Double.class,mlo,pod,pol,conType );
			bean.setQuotedRatemrg(rate);
		}
		
	}catch(Exception e) {
		System.out.println("Error in getmrgRate:");
		e.printStackTrace();
	}
	return bean;
	
}
@Override
public QuotationRateBean gettariffRate(String mlo, String pod, String pol, String conType) {
	QuotationRateBean bean = new QuotationRateBean();
	try {
		int count =jdbcTemplate.queryForObject(QuotationRateQueryUtil.GET_MRG_DTL_COUNT,Integer.class,mlo,pod,pol,conType );
		if(count >0) {
			double rate = jdbcTemplate.queryForObject(QuotationRateQueryUtil.GET_MRG_DTL_RATE,Double.class,mlo,pod,pol,conType );
			bean.setQuotedRatemrg(rate);
			int count1 =jdbcTemplate.queryForObject(QuotationRateQueryUtil.GET_TARIFF_DTL_COUNT,Integer.class,mlo,pod,pol,conType );
			if(count1 >0) {
				double rate1 = jdbcTemplate.queryForObject(QuotationRateQueryUtil.GET_TARIFF_DTL_RATE,Double.class,mlo,pod,pol,conType );
				bean.setQuotedRateTariff(rate1);
				
			}
		}
		
	}catch(Exception e) {
		System.out.println("Error in getmrgRate:");
		e.printStackTrace();
	}
	return bean;
	
}
	
}