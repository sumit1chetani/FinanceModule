package com.dci.master.servicepartner;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CipherCrypto;
import com.dci.common.util.CommonExcelUtils;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")
public class ServicePartnerDAOImpl implements ServicePartnerDAO {
	private final static Logger LOGGER = Logger.getLogger(ServicePartnerDAOImpl.class);
	@Autowired
	DataSource dataSource;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public ServicePartnerResultBean getDropDownList() {
		// TODO Auto-generated method stub
		ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();
		List<SelectivityBean> counryList = new ArrayList<SelectivityBean>();
		List<SelectivityBean> branchList = new ArrayList<SelectivityBean>();
		List<SelectivityBean> cityList = new ArrayList<SelectivityBean>();
		List<SelectivityBean> regionList = new ArrayList<SelectivityBean>();
		List<SelectivityBean> defaultTypeList = new ArrayList<SelectivityBean>();
		List<SelectivityBean> gstnStateList = new ArrayList<SelectivityBean>();
		List<SelectivityBean> serviceList = new ArrayList<SelectivityBean>();
		List<SelectivityBean> classificationList = new ArrayList<SelectivityBean>();
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			counryList = jdbcTemplate.query(ServicePartnerQueryUtil.GETCOUNTRYLIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			branchList = jdbcTemplate.query(ServicePartnerQueryUtil.GETBRANCHLIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			cityList = jdbcTemplate.query(ServicePartnerQueryUtil.GETCITYLIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			regionList = jdbcTemplate.query(ServicePartnerQueryUtil.GETREGIONLIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			defaultTypeList = jdbcTemplate.query(ServicePartnerQueryUtil.GETDEFAULTTYPELIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			gstnStateList = jdbcTemplate.query(ServicePartnerQueryUtil.GETGSTNSTATELIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			//serviceList = jdbcTemplate.query(CustomerPartnerQueryUtil.Get_Employee_list,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			//classificationList=jdbcTemplate.query(CustomerPartnerQueryUtil.Get_PARTNER_CLASSIFICATION_list,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			//partnerClassificationList = jdbcTemplate.query(ServicePartnerQueryUtil.GETPARTNERCLASSIFICATINLIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));

			servicePartnerResultBean.setCounryList(counryList);
			servicePartnerResultBean.setBranchList(branchList);
			servicePartnerResultBean.setCityList(cityList);
			servicePartnerResultBean.setRegionList(regionList);
			servicePartnerResultBean.setDefaultTypeList(defaultTypeList);
			servicePartnerResultBean.setGstnStateList(gstnStateList);
			servicePartnerResultBean.setServiceList(serviceList);
			servicePartnerResultBean.setClassificationList(classificationList);
			//servicePartnerResultBean.setPartnerClassificationList(partnerClassificationList);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in Drop Down List", e);
		}
		return servicePartnerResultBean;
	}

	@Override
	public ServicePartnerResultBean getServicePartnerList(String name) {
		// TODO Auto-generated method stub
		ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();
		List<ServicePartnerBean> lServicePartnerBean = new ArrayList<ServicePartnerBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(name.equalsIgnoreCase("acccustomer")){//account customer
				lServicePartnerBean = jdbcTemplate.query(ServicePartnerQueryUtil.GETLIST,new BeanPropertyRowMapper<ServicePartnerBean>(	ServicePartnerBean.class));	
			}else{//master-->service customer
				lServicePartnerBean = jdbcTemplate.query(ServicePartnerQueryUtil.GETLIST1,new BeanPropertyRowMapper<ServicePartnerBean>(	ServicePartnerBean.class));
			}
			for(ServicePartnerBean lServicePartnerBean1:lServicePartnerBean) {
				
				
				int count = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.Get_emplyee_Id,new Object[] { lServicePartnerBean1.getServicePartnerName() }, Integer.class);
				
				 if(count>0) {
				 lServicePartnerBean1.setLoginId("Yes");
				 }
				 
			}

			
			servicePartnerResultBean
					.setlServicePartnerBean(lServicePartnerBean);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in Service Partner List", e);
		}
		return servicePartnerResultBean;
	}

	@Override
	public ServicePartnerResultBean saveServicePartner(ServicePartnerResultBean servicePartnerBean) {
		// TODO Auto-generated method stub
		ServicePartnerBean servicePartner = new ServicePartnerBean();
		ServicePartnerBean servicePartnerOldBean = new ServicePartnerBean();
		List<ServicePartnerKeyBean> servicePartnerTable = new ArrayList<ServicePartnerKeyBean>();

		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();
		servicePartner=servicePartnerBean.getServicePartner();
		servicePartnerTable=servicePartnerBean.getServicePartnerTable();
		 Boolean isSuccess=false;
		try {
			String activBit;
			String activBitCust;

			if(servicePartner.isActive())
			{
				activBit="1";
				activBitCust="Y";
			}
			else
			{
				activBit="0";
				activBitCust="N";

			}
		
			
			String accountheadtype = "C" + (CommonExcelUtils.getOnlyStrings(servicePartner.getServicePartnerName()));
			String acct_head_code = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.CHECK_CUSTOMER_ACCT_HEAD,
					new Object[] { accountheadtype,accountheadtype }, String.class);
			acct_head_code = accountheadtype + acct_head_code;
			System.out.println("acct_head_code=" + acct_head_code);
		int count =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNTSERVICEPARTNERCODE,Integer.class,servicePartner.getServicePartnerCode());
		
		int countGst =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNTGST,Integer.class,servicePartner.getgSTNNo().trim() );
		
		int countName =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNT_NAME,Integer.class,servicePartner.getServicePartnerName().trim());
		int email=0;
		if(!servicePartner.getEmailId().equalsIgnoreCase(null) && !servicePartner.getEmailId().equalsIgnoreCase("")){
		 email =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.email,Integer.class,servicePartner.getEmailId().trim());
		}

		System.out.println("GST=" + servicePartner.getgSTNNo().trim()+"Name"+servicePartner.getServicePartnerName().trim());
		
		
		
		String cstbin = "0" ;
		String expbin = "0" ;
		String impbin = "0" ;
		String shipbin = "0" ;
		String consbin = "0" ;
		String linbin = "0" ;
		String airlinbin = "0" ;
		String fribin = "0" ;
		String cussbin = "0" ;
		String transbin = "0" ;
		String slotbin = "0" ;
		String leasebin = "0" ;
		String conmanubin = "0" ;
		String cfsbin = "0" ;
		String agebin = "0" ;
		String depobin = "0" ;
		String iatabin = "0" ;
		String vndrbin = "0" ;

		
		for(int k=0; k<servicePartnerBean.getServicePartnerTypeList().size();k++)
		{
			
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 1) {
				cstbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 2) {
				expbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 3) {
				impbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 4) {
				shipbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 5) {
				consbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 6) {
				linbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 7) {
				airlinbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 8) {
				fribin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 9) {
				cussbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 10) {
				transbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 11) {
				slotbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 12) {
				leasebin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 13) {
				conmanubin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 14) {
				cfsbin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 15) {
				agebin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 16) {
				depobin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 17) {
				iatabin="1";
			}
			if(servicePartnerBean.getServicePartnerTypeList().get(k) == 18) {
				vndrbin="1";
			}

		}
	
		if(count<1)
			{
			
			if(countGst<1){
				
				if(countName<1){
					if(email<1){

				
			String employeeId1 =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_MAX_EMPLOYEE_ID, String.class);
			
			String password1 = CipherCrypto.Encrypt("mbk");
			//jdbcTemplate.update(ServicePartnerQueryUtil.INSERT_EMPMASTER,employeeId1,servicePartner.getServicePartnerName(),servicePartner.getAddress(),servicePartner.getLandLineNo(),servicePartner.getEmailId(),password1,userDtl.getUserId());
			//jdbcTemplate.update(ServicePartnerQueryUtil.INSERT_USERMASTER,employeeId1,servicePartner.getServicePartnerName(),servicePartner.getAddress(),servicePartner.getLandLineNo(),servicePartner.getEmailId(),password1,userDtl.getUserId());
			Email email1 = new Email();
			StringBuffer st = new StringBuffer();
			StringBuffer sb = new StringBuffer();
			st.append("<html><head><style>td {border: 1px solid black;} .aBn{border:0px !important;}</style></head>Dear " + servicePartner.getServicePartnerName() + ",<br/><br/>" + "<body>");
			st.append("We are so excited to welcome you to MBK. Your online portal for all digital activities. <br/><br/> ");
			st.append("Please login with user name : " + employeeId1 + "<br/>Password : athena <br/><br/>");
			st.append("Please Click the below link to download the application ");
			st.append("https://play.google.com/store/apps/details?id=com.paragondynamics.athena&hl=en");
			st.append("Warm Regards,<br/>");
			
			st.append("</body></html>");
			
		
			
			String bodyHtml = st.toString();
			email1.setSubject("MBK Login Details");
			String toIds = servicePartner.getEmailId();
			String[] bcc = { "sachin.k@athena-logistics.com" };
			

			if(toIds!=null || !toIds.isEmpty()) {
				boolean isValid= isValid(toIds);
          	  if(isValid==true) {
          		  String path= "C:/Users/Administrator/Downloads/athena/AthenaAndroidMobile.docx";
				String[] to = separtormailIds(toIds);
				//String[] cc = separtormailIds(null);
				email1.setFromEmailAddress(null);
				email1.setCcEmailAddress(null);
				email1.setToEmailAddress(to);
				email1.setBccEmailAddress(bcc);
				email1.setBodyHtml(st.toString());

		/*	MailUtility.sendMail(email1, path);*/
          	  }
			}
			   System.out.println("tes");

			Integer serviceprtnerId=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.SAVESERVICEPARTNER(activBit,cstbin,expbin,impbin,shipbin,consbin,linbin,airlinbin,fribin,cussbin,transbin,slotbin,leasebin,conmanubin,cfsbin,agebin,depobin,iatabin,vndrbin),Integer.class,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),Integer.parseInt(servicePartner.getBranch()),servicePartner.getServicePartnerLedgerName(),servicePartner.getCreditDaysOffered(),servicePartner.getAddress(),Integer.parseInt(servicePartner.getCity()),servicePartner.getRegion(),servicePartner.getCountry(),servicePartner.getZipCode(),servicePartner.getPersonToContact(),servicePartner.getDesignation(),servicePartner.getEmailId(),servicePartner.getLandLineNo(),servicePartner.getMobileNo(),servicePartner.getSkypeId(),servicePartner.getWebSite(),servicePartner.getServicePartnerDescription(),servicePartner.getpANNo(),Integer.parseInt(servicePartner.getDefaultType()),servicePartner.getPartnerClassification(),servicePartner.getgSTNStateCode(),servicePartner.getExemptionUnder(),servicePartner.getSalesPerson(),servicePartner.getgSTNNo(),userDtl.getUserId(),userDtl.getUserId(),acct_head_code,servicePartner.getSundryStatus(),employeeId1,servicePartner.getCreditAmt(),servicePartner.getCreditDaysOffered());
			for(ServicePartnerKeyBean lServicePartnerBean:servicePartnerTable)
				
			{
				int keycount =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.KEYCOUNT,Integer.class);
				int key= keycount+1;
				jdbcTemplate.update(ServicePartnerQueryUtil.SAVEKEYDETAILSSERVICEPARTNER,key,lServicePartnerBean.getContactName(),lServicePartnerBean.getKeyDesignation(),lServicePartnerBean.getKeyEmail(),lServicePartnerBean.getKeyLandLineNo(),lServicePartnerBean.getKeyMobileNo(),lServicePartnerBean.getKeySkypeId(),lServicePartnerBean.getKeyCityId(),lServicePartnerBean.getRemarks());

			}
			for(int j=0; j<servicePartnerBean.getServicePartnerTypeList().size();j++)
			{
				jdbcTemplate.update(ServicePartnerQueryUtil.SAVEMAPDETAILSSERVICEPARTNER,serviceprtnerId,servicePartnerBean.getServicePartnerTypeList().get(j),true);

			}
			String password = CipherCrypto.Encrypt("mbk");
			//jdbcTemplate.update(ServicePartnerQueryUtil.INSERT_USERMASTER,employeeId1,servicePartner.getServicePartnerName(), password,
			//		userDtl.getUserId(),activBitCust);
			if(servicePartner.getSalesPerson()!="" ){
				isSuccess = savesalesTable(servicePartner);
			}
			
			int servicePartnerId = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.select_previous_id,Integer.class);
			servicePartner.setTableName("service_partner");
			servicePartner.setFormCode("F5086");
			userlogDao.userLogForInsert(servicePartner, servicePartnerId + "", userDtl.getUserId());
			servicePartnerResultBean.setSuccess(true);
			servicePartnerResultBean.setCode(employeeId1);
			
				
				}
				
			else
			{
				servicePartnerResultBean.setMessage("Email Id Already Exists");
					servicePartnerResultBean.setSuccess(false);

				}
				
				}
				else
				{
					servicePartnerResultBean.setMessage("Service Partner Name Already Exists");
						servicePartnerResultBean.setSuccess(false);

					}
			}
			else
			{
				servicePartnerResultBean.setMessage("GST Code Already Exists");
					servicePartnerResultBean.setSuccess(false);

				}

	}
			else
		{
			servicePartnerResultBean.setMessage("Service Partner Code Already Exists");
				servicePartnerResultBean.setSuccess(false);

			}
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			servicePartnerResultBean.setMessage("Unable to Save");
			servicePartnerResultBean.setSuccess(false);


		} catch (Exception e) {
			
			LOGGER.error("Error in Save Service Partner", e);
		}
		return servicePartnerResultBean;
	}
	public static String[] separtormailIds(String toAdd) throws Exception {

		String[] str = toAdd.split(",");
		return str;
	}
	

	@Override
	public ServicePartnerResultBean updateServicePartner(
			ServicePartnerResultBean servicePartnerBean) {
		
		// TODO Auto-generated method stub
		ServicePartnerBean servicePartnerOldBean = new ServicePartnerBean();

		ServicePartnerBean servicePartner = new ServicePartnerBean();
		List<ServicePartnerKeyBean> servicePartnerTable = new ArrayList<ServicePartnerKeyBean>();

		ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();
		servicePartner=servicePartnerBean.getServicePartner();
		servicePartnerTable=servicePartnerBean.getServicePartnerTable();
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 Boolean isSuccess=false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String activBit;
			String activBitCust;
			servicePartnerOldBean=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.EDITSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerBean>(ServicePartnerBean.class),servicePartner.getServicePartnerId());

			if(servicePartner.isActive())

			{
				activBit="1";
				activBitCust="Y";
			}
			else
			{
				activBit="0";
				activBitCust="N";


			}
			int count =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNTSERVICEPARTNERCODEUPDATE,Integer.class,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerId());
			String cstbin = "0" ;
			String expbin = "0" ;
			String impbin = "0" ;
			String shipbin = "0" ;
			String consbin = "0" ;
			String linbin = "0" ;
			String airlinbin = "0" ;
			String fribin = "0" ;
			String cussbin = "0" ;
			String transbin = "0" ;
			String slotbin = "0" ;
			String leasebin = "0" ;
			String conmanubin = "0" ;
			String cfsbin = "0" ;
			String agebin = "0" ;
			String depobin = "0" ;
			String iatabin = "0" ;
			String vndrbin = "0" ;

			
			for(int k=0; k<servicePartnerBean.getServicePartnerTypeList().size();k++)
			{
				
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 1) {
					cstbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 2) {
					expbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 3) {
					impbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 4) {
					shipbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 5) {
					consbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 6) {
					linbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 7) {
					airlinbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 8) {
					fribin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 9) {
					cussbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 10) {
					transbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 11) {
					slotbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 12) {
					leasebin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 13) {
					conmanubin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 14) {
					cfsbin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 15) {
					agebin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 16) {
					depobin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 17) {
					iatabin="1";
				}
				if(servicePartnerBean.getServicePartnerTypeList().get(k) == 18) {
					vndrbin="1";
				}

			}
			
			
			if(count<1)
			{
			jdbcTemplate.update(ServicePartnerQueryUtil.UPDATESERVICEPARTNER(activBit,cstbin,expbin,impbin,shipbin,consbin,linbin,airlinbin,fribin,cussbin,transbin,slotbin,leasebin,conmanubin,cfsbin,agebin,depobin,iatabin,vndrbin),servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),Integer.parseInt(servicePartner.getBranch()),servicePartner.getServicePartnerLedgerName(),servicePartner.getCreditDaysOffered(),servicePartner.getAddress(),Integer.parseInt(servicePartner.getCity()),servicePartner.getRegion(),servicePartner.getCountry(),servicePartner.getZipCode(),servicePartner.getPersonToContact(),servicePartner.getDesignation(),servicePartner.getEmailId(),servicePartner.getLandLineNo(),servicePartner.getMobileNo(),servicePartner.getSkypeId(),servicePartner.getWebSite(),servicePartner.getServicePartnerDescription(),servicePartner.getpANNo(),Integer.parseInt(servicePartner.getDefaultType()),servicePartner.getPartnerClassification(),servicePartner.getgSTNStateCode(),servicePartner.getExemptionUnder(),servicePartner.getSalesPerson(),servicePartner.getgSTNNo(),userDtl.getUserId(),servicePartner.getSundryStatus(), servicePartner.getCreditAmt(),servicePartner.getCreditDaysOffered(),servicePartner.getServicePartnerId());
			jdbcTemplate.update(ServicePartnerQueryUtil.DELETEKEYDETAILSSERVICEPARTNER,servicePartner.getServicePartnerId());

			for(ServicePartnerKeyBean lServicePartnerBean:servicePartnerTable)
			
			{
				int key =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.KEYCOUNT,Integer.class);
				jdbcTemplate.update(ServicePartnerQueryUtil.SAVEKEYDETAILSSERVICEPARTNER,key,lServicePartnerBean.getContactName(),lServicePartnerBean.getKeyDesignation(),lServicePartnerBean.getKeyEmail(),lServicePartnerBean.getKeyLandLineNo(),lServicePartnerBean.getKeyMobileNo(),lServicePartnerBean.getKeySkypeId(),lServicePartnerBean.getKeyCityId(),lServicePartnerBean.getRemarks());

			}
			jdbcTemplate.update(ServicePartnerQueryUtil.DELETEMAPDETAILSSERVICEPARTNER,servicePartner.getServicePartnerId());

			for(int j=0; j<servicePartnerBean.getServicePartnerTypeList().size();j++)
			{
				jdbcTemplate.update(ServicePartnerQueryUtil.SAVEMAPDETAILSSERVICEPARTNER,servicePartner.getServicePartnerId(),servicePartnerBean.getServicePartnerTypeList().get(j),true);

			}
     /*if(!servicePartner.getSalesPerson().isEmpty()){
				
				String oldSalePerson = null;
	              		
				
				try{
					servicePartnerOldBean=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.OLD_SERVICE_PERSON,new BeanPropertyRowMapper<ServicePartnerBean>(ServicePartnerBean.class),servicePartner.getServicePartnerId());
					oldSalePerson = servicePartnerOldBean.getOldSalePerson();
					
					if(!oldSalePerson.equalsIgnoreCase(servicePartner.getSalesPerson())){
						
						isSuccess = savesalesTable1(servicePartner);
						isSuccess = updatesalesTable(servicePartnerOldBean);
						jdbcTemplate.update(ServicePartnerQueryUtil.UPDATE_TO_DATE,oldSalePerson,servicePartner.getServicePartnerId());

						

					}
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			    if(oldSalePerson == null){
					
							int iPinDtl = jdbcTemplate.update(ServicePartnerQueryUtil.SAVE_SALES_TABLE,new Object[] {servicePartnerOldBean.getServicePartnerId(),servicePartner.getSalesPerson() });
				}
						
				}*/
			jdbcTemplate.update(ServicePartnerQueryUtil.UPDATE_USER_MASTER,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),
					userDtl.getUserId(),activBitCust,servicePartner.getServicePartnerCode());
			servicePartner.setTableName("service_partner");
			servicePartner.setFormCode("F5086");
			userlogDao.userLogForUpdate(servicePartnerOldBean,servicePartner,servicePartner.getServicePartnerId()+ "", userDtl.getUserId());

			servicePartnerResultBean.setSuccess(true);
			}
			else
			{
				servicePartnerResultBean.setMessage("Service Partner Code Already Exists");
				servicePartnerResultBean.setSuccess(false);
				
			}
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in update Service Partner", e);
			servicePartnerResultBean.setMessage("Unable to Update");
			servicePartnerResultBean.setSuccess(false);


		}
		return servicePartnerResultBean;
	}

	@Override
	public ServicePartnerResultBean editServicePartner(int servicePartnerId) {
		// TODO Auto-generated method stub
		ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			servicePartnerResultBean.setServicePartner(jdbcTemplate.queryForObject(ServicePartnerQueryUtil.EDITSERVICEPARTNERNEW,new BeanPropertyRowMapper<ServicePartnerBean>(ServicePartnerBean.class),servicePartnerId,servicePartnerId,servicePartnerId,servicePartnerId,servicePartnerId));
			
			servicePartnerResultBean.setServicePartnerTable(jdbcTemplate.query(ServicePartnerQueryUtil.EDITKEYSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerKeyBean>(ServicePartnerKeyBean.class),servicePartnerId));

			servicePartnerResultBean.setServicePartnerType(jdbcTemplate.query(ServicePartnerQueryUtil.EDITMAPSERVICEPARTNER,new BeanPropertyRowMapper<ServiceMapBean>(ServiceMapBean.class),servicePartnerId));
			
			servicePartnerResultBean.setSalesTable(jdbcTemplate.query(ServicePartnerQueryUtil.EDITSALES,new BeanPropertyRowMapper<ServicePartnerBean>(ServicePartnerBean.class),servicePartnerId));

			servicePartnerResultBean.setSuccess(true);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in Edit Service Partner", e);
		}
		return servicePartnerResultBean;
	}
	
	@Override
	public ServicePartnerResultBean viewServicePatrnerList(int servicePartnerId) {
		// TODO Auto-generated method stub
		ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			servicePartnerResultBean.setServicePartner(jdbcTemplate.queryForObject(ServicePartnerQueryUtil.VIEWSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerBean>(ServicePartnerBean.class),servicePartnerId));
			
			servicePartnerResultBean.setServicePartnerTable(jdbcTemplate.query(ServicePartnerQueryUtil.VIEWKEYSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerKeyBean>(ServicePartnerKeyBean.class),servicePartnerId));

			servicePartnerResultBean.setServicePartnerType(jdbcTemplate.query(ServicePartnerQueryUtil.VIEWMAPSERVICEPARTNER,new BeanPropertyRowMapper<ServiceMapBean>(ServiceMapBean.class),servicePartnerId));
			
			servicePartnerResultBean.setSalesTable(jdbcTemplate.query(ServicePartnerQueryUtil.VIEWSALES,new BeanPropertyRowMapper<ServicePartnerBean>(ServicePartnerBean.class),servicePartnerId));

			servicePartnerResultBean.setSuccess(true);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in View  Service Partner", e);
		}
		return servicePartnerResultBean;
	}
	
	public boolean savesalesTable(ServicePartnerBean servicePartner) {
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		  // code added for inter-company transaction
		  String sCompanyCode = "";
		  boolean isSuccess = false;
		  try {
		   
			int servicePartnerId = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.select_previous_id,Integer.class);


		    int iPinDtl = jdbcTemplate.update(ServicePartnerQueryUtil.SAVE_SALES_TABLE,new Object[] {servicePartnerId,servicePartner.getSalesPerson() });

		   

		  } catch (Exception e) {
		 /*  e.printStackTrace();*/
		   LOGGER.error("Error in Save Sales Table", e);
		  }
		  return true;
		 }
	
	public boolean savesalesTable1(ServicePartnerBean servicePartner) {
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		  // code added for inter-company transaction
		  String sCompanyCode = "";
		  boolean isSuccess = false;
		  try {
		   
			//int servicePartnerId = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.select_previous_id,Integer.class);


		    int iPinDtl = jdbcTemplate.update(ServicePartnerQueryUtil.SAVE_SALES_TABLE,new Object[] {servicePartner.getServicePartnerId(),servicePartner.getSalesPerson() });

		   

		  } catch (Exception e) {
		   /*e.printStackTrace();*/
		   LOGGER.error("Error in Save Sales Table1", e);
		  }
		  return true;
		 }
	@Override
	public ServicePartnerResultBean deleteServicePartner(int servicePartnerId) {
		// TODO Auto-generated method stub
		ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();
		try {
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			ServicePartnerBean servicePartner = new ServicePartnerBean();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			servicePartner=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.EDITSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerBean>(ServicePartnerBean.class),servicePartnerId);
			servicePartner.setTableName("service_partner");
			servicePartner.setFormCode("F5086");
			jdbcTemplate.update(ServicePartnerQueryUtil.DELETESERVICEPARTNER,
					servicePartnerId);
			jdbcTemplate.update(ServicePartnerQueryUtil.DELETE_sale_details,servicePartnerId);
			jdbcTemplate.update(ServicePartnerQueryUtil.DELETEUSERMASTER,
					servicePartnerId);
			jdbcTemplate.update(ServicePartnerQueryUtil.DELETEKEYDETAILSSERVICEPARTNER,servicePartnerId);

			
			
			
			jdbcTemplate.update(ServicePartnerQueryUtil.DELETEMAPDETAILSSERVICEPARTNER,servicePartnerId);
			 userlogDao.userLogForDelete(servicePartner, servicePartnerId + "", userDtl.getUserId());

			servicePartnerResultBean.setSuccess(true);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			   LOGGER.error("Error in Delete Service Partner", e);
		}
		return servicePartnerResultBean;
	}

	@Override
	public ServicePartnerResultBean createLogin(int rowid) {
		
		ServicePartnerResultBean ServicePartnerResultBean = new ServicePartnerResultBean();
		ServicePartnerBean servicePartner = new ServicePartnerBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String activBitCust;
		String activBit;
		try
		{
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            //Getting service Partner Details
			servicePartner=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.EDITSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerBean>(ServicePartnerBean.class),rowid);
			

			if(servicePartner.isActive())
			{
				activBit="1";
				activBitCust="Y";
			}
			else
			{
				activBit="0";
				activBitCust="N";

			}
			
			String employeeId1 =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_MAX_EMPLOYEE_ID, String.class);
			//password
			String password1 = CipherCrypto.Encrypt("athena");
			
			//insert into employeemaster
			//jdbcTemplate.update(ServicePartnerQueryUtil.INSERT_EMPMASTER,employeeId1,servicePartner.getServicePartnerName(),servicePartner.getAddress(),servicePartner.getLandLineNo(),servicePartner.getEmailId(),password1,userDtl.getUserId());
			
			
			//insert into customer User
		//	jdbcTemplate.update(ServicePartnerQueryUtil.INSERT_USERMASTER,employeeId1,servicePartner.getServicePartnerName(), password1,
			//	userDtl.getUserId(),activBitCust);
			
			ServicePartnerResultBean.setSuccess(true);
			List<String> lFilePathList = new ArrayList<String>();

			//email
			Email email1 = new Email();
			StringBuffer st = new StringBuffer();
			StringBuffer sb = new StringBuffer();
			st.append("<html><head><style>td {border: 1px solid black;} .aBn{border:0px !important;}</style></head>Dear " + servicePartner.getServicePartnerName() + ",<br/><br/>" + "<body>");
			st.append("We are so excited to welcome you to Athena. Your online portal for all digital activities. <br/><br/> ");
			st.append("Please login with user name : " + employeeId1 + "<br/>Password : athena <br/><br/>");
			st.append("Please Click the below link to download the application ");
			st.append("https://play.google.com/store/apps/details?id=com.paragondynamics.athena&hl=en");
			st.append("Warm Regards,<br/>");
			
			st.append("</body></html>");
			
		
			
			String bodyHtml = st.toString();
			email1.setSubject("mbk Login Details");
			String toIds = servicePartner.getEmailId();
			String[] bcc = { "sachin.k@athena-logistics.com" };
			

              if(toIds!=null && !toIds.isEmpty()) {
            	  System.out.println("inside mail");
            	  boolean isValid= isValid(toIds);
            	  if(isValid==true) {
            	  String path= "C:/Users/Administrator/Downloads/athena/AthenaAndroidMobile.docx";
            	  String[] to = separtormailIds(toIds);
				//String[] cc = separtormailIds(null);
				email1.setFromEmailAddress(null);
				email1.setCcEmailAddress(null);
				email1.setToEmailAddress(to);
				email1.setBccEmailAddress(bcc);
				email1.setBodyHtml(st.toString());
				 //lFilePathList.add(path);
			MailUtility.sendMail(email1, path);
			}
              }	
		}catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in Create Login", e);
		}
		return ServicePartnerResultBean;
	}
	
	public static boolean isValid(String email) 
	{ 
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
							"[a-zA-Z0-9_+&*-]+)*@" + 
							"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
							"A-Z]{2,7}$"; 
							
		Pattern pat = Pattern.compile(emailRegex); 
		if (pat.matcher(email).matches()) { 
		return true; 
		}else {
			return false;
		}
	} 
	
	@Override
	public ServicePartnerResultBean deleteKeyDetail(List<ServicePartnerKeyBean> lServicePartnerKeyBean) {
		// TODO Auto-generated method stub
		ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			for(ServicePartnerKeyBean servicePartnerKeyBean:lServicePartnerKeyBean)
			{
				jdbcTemplate.update(ServicePartnerQueryUtil.DELETEKEYSERVICEPARTNER,
						servicePartnerKeyBean.getServicePartnerKeyId());
				servicePartnerResultBean.setSuccess(true);
			}
			
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in Delete Key Details", e);
		}
		return servicePartnerResultBean;
	}

	@Override
	public ServicePartnerResultBean getServicePartnerDetailList() {
		// TODO Auto-generated method stub
		ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();
		List<ServiceMapBean> lServiceMapBean = new ArrayList<ServiceMapBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lServiceMapBean = jdbcTemplate.query(ServicePartnerQueryUtil.GETTYPELIST,new BeanPropertyRowMapper<ServiceMapBean>(
							ServiceMapBean.class));
			for(ServiceMapBean bean :lServiceMapBean) {
				if(bean.getTitle().equals("SHIPPER") || bean.getTitle().equals("CONSIGNEE")) {
					bean.setVisible(true);
				}
			}
			servicePartnerResultBean
					.setServicePartnerType(lServiceMapBean);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in Service Partner Detail List", e);
		}
		return servicePartnerResultBean;
	}


//kyc	
	@Override
	public boolean saveCustomerCommDetail(CustomerMasterCommDetail2 customerMasterCommDetail, String userId)throws Exception {
		boolean issucces = false;
		int value = 0;
		Date nextFollowUpDate = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String getmloCommId = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_MLOCOMMID, String.class);
		//getmloCommId = "SPC" + getmloCommId;
		// Date meetCallDate =
		// convertStringToDate(customerMasterCommDetail.getMeetCallDate());
		try {
			Object[] params = new Object[] { getmloCommId,
					customerMasterCommDetail.getCustomId(),
					//customerMasterCommDetail.getSrvcprtnrCd(),
					customerMasterCommDetail.getSubject(),
					customerMasterCommDetail.getAssignedTo(),
					customerMasterCommDetail.getBookingCntctPrsn(),
					customerMasterCommDetail.getPricingCntctPrsn(),
					customerMasterCommDetail.getOperationsCntctPrsn(),
					customerMasterCommDetail.getFinanceCntctPrsn(),
					customerMasterCommDetail.getBookingCntctPrsnEmail(),
					customerMasterCommDetail.getPricingCntctPrsnEmail(),
					customerMasterCommDetail.getOperationsCntctPrsnEmail(),
					customerMasterCommDetail.getFinanceCntctPrsnEmail(),
					customerMasterCommDetail.getTeleNumber(),
					customerMasterCommDetail.getFaxNum(), userId };

			value = jdbcTemplate
					.update(ServicePartnerQueryUtil.INSERT_CUSTOMER_COMM_DETAIL,
							params);
			System.out.println(value);
			issucces = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in Save Customer Communication Detail", e);
		//	throw new CustomException(CommonMsgUtil.ERROR_UPDATE);
		}

		return issucces;
	}
	

@Override
public ServicePartnerResultBean getCustomCommDetail(String srvcprtnrcd) {
	ServicePartnerResultBean customMaster = new ServicePartnerResultBean();
	int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };
	Object[] params = new Object[] { srvcprtnrcd };
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	List<CustomerMasterCommDetail2> customerMasterCommDetails = jdbcTemplate
			.query(ServicePartnerQueryUtil.SELECT_CUSTOMER_COMM_DETAIL,
					  new BeanPropertyRowMapper<>(
							CustomerMasterCommDetail2.class),srvcprtnrcd);
	customMaster.setCustomerMasterCommDetails(customerMasterCommDetails);
	// customMaster.setLeadMasterCommDetails(leadMasterCommDetails);
	return customMaster;
}
@Override
public boolean updateCustomerCommDetail(CustomerMasterCommDetail2 customerMasterCommDetail, String userId)
		throws Exception {

	boolean issucess = false;
	int value = 0;
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	/*
	 * Date meetCallDate =
	 * convertStringToDate(customerMasterCommDetail.getMeetCallDate()); Date
	 * nextFollowUpDate = null; if
	 * (customerMasterCommDetail.getNextFollowUpDate() != null &&
	 * customerMasterCommDetail.getNextFollowUpDate().length() > 0)
	 * nextFollowUpDate =
	 * convertStringToDate(customerMasterCommDetail.getNextFollowUpDate());
	 */
	try {
		Object[] params = new Object[] {
				customerMasterCommDetail.getSubject(),
				customerMasterCommDetail.getAssignedTo(),
				customerMasterCommDetail.getBookingCntctPrsn(),
				customerMasterCommDetail.getPricingCntctPrsn(),
				customerMasterCommDetail.getOperationsCntctPrsn(),
				customerMasterCommDetail.getFinanceCntctPrsn(),
				customerMasterCommDetail.getBookingCntctPrsnEmail(),
				customerMasterCommDetail.getPricingCntctPrsnEmail(),
				customerMasterCommDetail.getOperationsCntctPrsnEmail(),
				customerMasterCommDetail.getFinanceCntctPrsnEmail(),
				customerMasterCommDetail.getTeleNumber(),
				customerMasterCommDetail.getFaxNum(), userId,
				customerMasterCommDetail.getCustomCommId(),
				customerMasterCommDetail.getCustomId() };
		value = jdbcTemplate
				.update(ServicePartnerQueryUtil.UPDATE_CUSTOMER_COMM_DETAIL,
						params);
		System.out.println(value);
		issucess = true;
	} catch (DataAccessException e) {
		LOGGER.error("Error in Update Customer Communication Detail", e);
		//throw new CustomException(CommonMsgUtil.ERROR_UPDATE);
	} catch (Exception e) {
		/*e.printStackTrace();*/
		LOGGER.error("Error in Update Customer Communication Detail", e);
		//throw new CustomException(CommonMsgUtil.ERROR_UPDATE);
	}

	return issucess;
}
@Override
public boolean deleteCustomerComm(String customCommId, String customId)
		throws Exception {
	boolean issucces = false;
	int value = 0;
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	try {
		value = jdbcTemplate.update(
				ServicePartnerQueryUtil.DELETE_CUSTOMER_COMM_DETAIL,
				customCommId, customId);
		issucces = true;
		// LOGGER.info("Lead Delete", value);
	} catch (DataAccessException e) {
		LOGGER.error("Error in Delette Customer Communication Detail", e);
		//throw new CustomException(CommonMsgUtil.ERROR_DELETE);
	}
	return issucces;
}

@Override
public ServicePartnerResultBean getCountryList(int cityId) {
	ServicePartnerResultBean ResultBean = new ServicePartnerResultBean();
	
	//List<SelectivityBean> countryList = new ArrayList<SelectivityBean>();
	//List<SelectivityBean> regionList = new ArrayList<SelectivityBean>();
	
	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int stateId = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_STATE_ID,int.class,cityId);
		
		String country = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNTRYLIST,String.class, stateId);
		String region = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.RegionLIST,String.class, country);
		//region=jdbcTemplate.query(ServicePartnerQueryUtil.RegionLIST,new Object[] { stateId },new BeanPropertyRowMapper(SelectivityBean.class));
		//ResultBean.setCountryList(countryList);
		//ResultBean.setRegionList(regionList);
		ResultBean.setCountry(country);
		ResultBean.setRegion(region);
		
		
	} catch (Exception e) {
		/*e.printStackTrace();*/
		LOGGER.error("Error in Country List", e);
	}
	return ResultBean;
}

@Override
public ServicePartnerResultBean saveImportDetailsnewdata(ServicePartnerResultBean agentMasterBean) {

	ServicePartnerResultBean bean = new ServicePartnerResultBean();
	
	try {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		for(ServicePartnerBean agentDetail: agentMasterBean.getlServicePartnerBean()) {
			bean=saveServicePartnernew(agentDetail);
		}
	
		
	} catch (Exception ae) {
		LOGGER.error("Error in saveImportDetails", ae);
	}
	return bean;
}

public ServicePartnerResultBean saveServicePartnernew(ServicePartnerBean servicePartner) {
	// TODO Auto-generated method stub
	//ServicePartnerBean servicePartner = new ServicePartnerBean();
	ServicePartnerBean servicePartnerOldBean = new ServicePartnerBean();
	List<ServicePartnerKeyBean> servicePartnerTable = new ArrayList<ServicePartnerKeyBean>();
	UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	ServicePartnerResultBean agentDetail = new  ServicePartnerResultBean();
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();
	//servicePartner=agentDetail.getServicePartner();
	//servicePartnerTable=agentDetail.getServicePartnerTable();
	 Boolean isSuccess=false;

	try {
		String activBit;
		String activBitCust;

		if(servicePartner.isActive())
		{
			activBit="1";
			activBitCust="Y";
		}
		else
		{
			activBit="0";
			activBitCust="N";

		}
	
		
		String accountheadtype = "C" + (CommonExcelUtils.getOnlyStrings(servicePartner.getServicePartnerName() == null ? "" : servicePartner.getServicePartnerName()));
		String acct_head_code = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.CHECK_CUSTOMER_ACCT_HEAD,
				new Object[] { accountheadtype,accountheadtype }, String.class);
		acct_head_code = accountheadtype + acct_head_code;
		System.out.println("acct_head_code=" + acct_head_code);
	int count =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNTSERVICEPARTNERCODE,Integer.class,servicePartner.getServicePartnerCode());
	String cstbin = "0" ;
	String expbin = "0" ;
	String impbin = "0" ;
	String shipbin = "0" ;
	String consbin = "0" ;
	String linbin = "0" ;
	String airlinbin = "0" ;
	String fribin = "0" ;
	String cussbin = "0" ;
	String transbin = "0" ;
	String slotbin = "0" ;
	String leasebin = "0" ;
	String conmanubin = "0" ;
	String cfsbin = "0" ;
	String agebin = "0" ;
	String depobin = "0" ;
	String iatabin = "0" ;
	String vndrbin = "0" ;

	
	
	


	
	if(count<1)
		{
		String employeeId1 =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_MAX_EMPLOYEE_ID, String.class);
		
				
		   System.out.println("tes");
		   
		   //String bran =servicePartner.getBranch().trim();
			 //String cty = servicePartner.getCity().trim();
		     String  sundry = servicePartner.getSundryStatus().trim();
/*		     String sales = servicePartner.getSalesPerson().trim();
		     String defaut = servicePartner.getDefaultType().trim();
		      String GstState = servicePartner.getGststatecode().trim();
			Integer Branch =  jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_Branch, Integer.class, bran);
			  String salesper = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_sales, String.class, sales);
			  			Integer GstSte = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_gste, Integer.class, GstState);


*/		  // Integer city = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_City, Integer.class, cty);
			int stateId = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.GET_STATE_ID,int.class,Integer.parseInt(servicePartner.getCity()));
			String country = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNTRYLIST,String.class, stateId);
			String region = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.RegionLIST,String.class, country);
						
			
  
		 


		  if (sundry.equalsIgnoreCase("Creditors - Local")){
			  sundry= "20000003";
		  }else if(sundry.equalsIgnoreCase("Creditors - Overseas"))
		  {
			  sundry= "20010003";

		  }else if (sundry .equalsIgnoreCase("Debtors - Local")){
			  sundry= "10010004";

		  }else if (sundry .equalsIgnoreCase("Debtors - Overseas")){
			  sundry = "10080002";
		  }


		
			Integer serviceprtnerId=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.SAVESERVICEPARTNERnwpar(activBit,cstbin,expbin,impbin,shipbin,consbin,linbin,airlinbin,fribin,cussbin,transbin,slotbin,leasebin,conmanubin,cfsbin,agebin,depobin,iatabin,vndrbin),Integer.class,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),Integer.parseInt(servicePartner.getBranch()),servicePartner.getServicePartnerLedgerName(),servicePartner.getCreditDaysOffered(),servicePartner.getAddress(),Integer.parseInt(servicePartner.getCity()),region,country,servicePartner.getZipCode(),servicePartner.getPersonToContact(),servicePartner.getDesignation(),servicePartner.getEmailId(),servicePartner.getLandLineNo(),servicePartner.getMobileNo(),servicePartner.getSkypeId(),servicePartner.getWebSite(),servicePartner.getServicePartnerDescription(),servicePartner.getpANNo(),Integer.parseInt(servicePartner.getDefaultType()),servicePartner.getPartnerClassification(),servicePartner.getgSTNStateCode(),servicePartner.getExemptionUnder(),servicePartner.getSalesPerson(),servicePartner.getgSTNNo(),userDtl.getUserId(),userDtl.getUserId(),acct_head_code,sundry,employeeId1,servicePartner.getCreditAmt(),servicePartner.getCreditDaysOffered());

		  //Integer serviceprtnerId=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.SAVESERVICEPARTNERnew(activBit,cstbin,expbin,impbin,shipbin,consbin,linbin,airlinbin,fribin,cussbin,transbin,slotbin,leasebin,conmanubin,cfsbin,agebin,depobin,iatabin,vndrbin),Integer.class,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),Branch,servicePartner.getServicePartnerLedgerName(),servicePartner.getCreditDaysOffered(),servicePartner.getAddress(),city,region,country,servicePartner.getZipCode(),servicePartner.getPersonToContact(),servicePartner.getDesignation(),servicePartner.getEmailId(),servicePartner.getLandLineNo(),servicePartner.getMobileNo(),servicePartner.getSkypeId(),servicePartner.getWebSite(),servicePartner.getServicePartnerDescription(),servicePartner.getpANNo(),defaut,servicePartner.getPartnerClassification(),servicePartner.getgSTNStateCode(),servicePartner.getExemptionUnder(),salesper,servicePartner.getgSTNNo(),userDtl.getUserId(),userDtl.getUserId(),acct_head_code,sundry,employeeId1,servicePartner.getCreditAmt(),servicePartner.getCreditDaysOffered());
		for(ServicePartnerKeyBean lServicePartnerBean:servicePartnerTable)
			
		{
			int keycount =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.KEYCOUNT,Integer.class);
			int key= keycount+1;
			jdbcTemplate.update(ServicePartnerQueryUtil.SAVEKEYDETAILSSERVICEPARTNER,key,lServicePartnerBean.getContactName(),lServicePartnerBean.getKeyDesignation(),lServicePartnerBean.getKeyEmail(),lServicePartnerBean.getKeyLandLineNo(),lServicePartnerBean.getKeyMobileNo(),lServicePartnerBean.getKeySkypeId(),lServicePartnerBean.getKeyCityId(),lServicePartnerBean.getRemarks());

		}
		
		for(int j=0; j<servicePartner.getServicePartnerTypeList().size();j++)
		{
			jdbcTemplate.update(ServicePartnerQueryUtil.SAVEMAPDETAILSSERVICEPARTNER,serviceprtnerId,servicePartner.getServicePartnerTypeList().get(j),true);

		}

		
		//jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVEMAPDETAILSSERVICEPARTNER,serviceprtnerId,servicePartner.getServicepartnertype(),true);

		String password = CipherCrypto.Encrypt("mbk");
		if(servicePartner.getSalesPerson()!="" ){
			isSuccess = savesalesTable(servicePartner);
		}
		
		int servicePartnerId = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.select_previous_id,Integer.class);
		servicePartner.setTableName("service_partner");
		servicePartner.setFormCode("F5086");
		userlogDao.userLogForInsert(servicePartner, servicePartnerId + "", userDtl.getUserId());
		if(serviceprtnerId>0)
		servicePartnerResultBean.setSuccess1(true);

		servicePartnerResultBean.setCode(employeeId1);


}
		else
	{
		servicePartnerResultBean.setMessage("Service Partner Code Already Exists");
		servicePartnerResultBean.setSuccess1(false);


		}
	} catch (NumberFormatException ex) {
		ex.printStackTrace();
		servicePartnerResultBean.setMessage("Unable to Save");
		servicePartnerResultBean.setSuccess1(false);

	} catch (Exception e) {
		
		LOGGER.error("Error in Save Service Partner", e);
	}
	return servicePartnerResultBean;
}

@Override
public ServicePartnerResultBean con(ServicePartnerResultBean agentmaster) {
	ServicePartnerResultBean bean = new ServicePartnerResultBean();
	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int count=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNTSERVICEPARTNERCODE,new Object[]{ agentmaster.getMessage()},Integer.class);
     if(count==0){
    	 bean.setMessage("true");

        }else {
        	bean.setMessage("false");
        }
		
	} catch (Exception ae) {
		LOGGER.error("Error in saveImportDetails", ae);
	}
	return bean;
}

@Override
public ServicePartnerResultBean cusName(ServicePartnerResultBean agentmaster) {
	ServicePartnerResultBean bean = new ServicePartnerResultBean();
	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int count=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.cust_name,new Object[]{ agentmaster.getMessage()},Integer.class);
     if(count==0){
    	 bean.setMessage("true");

        }else {
        	bean.setMessage("false");
        }
		
	} catch (Exception ae) {
		LOGGER.error("Error in saveImportDetails", ae);
	}
	return bean;
}

@Override
public ServicePartnerResultBean email(ServicePartnerResultBean agentmaster) {
	ServicePartnerResultBean bean = new ServicePartnerResultBean();
	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int count=jdbcTemplate.queryForObject(ServicePartnerQueryUtil.email,new Object[]{ agentmaster.getMessage()},Integer.class);
     if(count==0){
    	 bean.setMessage("true");

        }else {
        	bean.setMessage("false");
        }
		
	} catch (Exception ae) {
		LOGGER.error("Error in saveImportDetails", ae);
	}
	return bean;
}

}

