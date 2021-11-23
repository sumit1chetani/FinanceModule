package com.dci.master.servicepartnerNew;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CipherCrypto;
import com.dci.common.util.CommonExcelUtils;
import com.dci.common.util.ConfigurationProps;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;
import com.dci.tenant.user.UserDetail;



@Repository
@Transactional("tenantTransactionManager")
public class ServicePartnerNewDAOImpl implements ServicePartnerNewDAO {
	private final static Logger LOGGER = Logger.getLogger(ServicePartnerNewDAOImpl.class);
	@Autowired
	DataSource dataSource;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	@Override
	public ServicePartnerNewResultBean getDropDownList() {
		// TODO Auto-generated method stub
		ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();
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

			counryList = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETCOUNTRYLIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			branchList = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETBRANCHLIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			cityList = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETCITYLIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			regionList = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETREGIONLIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			defaultTypeList = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETDEFAULTTYPELIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			gstnStateList = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETGSTNSTATELIST,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
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
	public ServicePartnerNewResultBean getServicePartnerList(String name) {
		// TODO Auto-generated method stub
		ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();
		List<ServicePartnerNewBean> lServicePartnerBean = new ArrayList<ServicePartnerNewBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(name.equalsIgnoreCase("acccustomer")){//account customer
				lServicePartnerBean = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETLIST,new BeanPropertyRowMapper<ServicePartnerNewBean>(	ServicePartnerNewBean.class));	
			}else{//master-->service customer
				lServicePartnerBean = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETLIST1,new BeanPropertyRowMapper<ServicePartnerNewBean>(	ServicePartnerNewBean.class));
			}
			for(ServicePartnerNewBean lServicePartnerBean1:lServicePartnerBean) {
				
				
				int count = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.Get_emplyee_Id,new Object[] { lServicePartnerBean1.getServicePartnerName() }, Integer.class);
				
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
	public ServicePartnerNewResultBean saveServicePartner(ServicePartnerNewResultBean servicePartnerBean) {
		// TODO Auto-generated method stub
		ServicePartnerNewBean servicePartner = new ServicePartnerNewBean();
		ServicePartnerNewBean servicePartnerOldBean = new ServicePartnerNewBean();
		List<ServicePartnerNewKeyBean> servicePartnerTable = new ArrayList<ServicePartnerNewKeyBean>();

		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();
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
		
			
			String accountheadtype = "V" + (CommonExcelUtils.getOnlyStrings(servicePartner.getServicePartnerName()));
			String acct_head_code = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.CHECK_CUSTOMER_ACCT_HEAD,
					new Object[] { accountheadtype,accountheadtype }, String.class);
			acct_head_code = accountheadtype + acct_head_code;
			System.out.println("acct_head_code=" + acct_head_code);
		int count =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.COUNTSERVICEPARTNERCODE,Integer.class,servicePartner.getServicePartnerCode());
	//	int countGst =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNTGST,Integer.class,servicePartner.getgSTNNo().trim() );
		
		//int countName =jdbcTemplate.queryForObject(ServicePartnerQueryUtil.COUNT_NAME,Integer.class,servicePartner.getServicePartnerName().trim());
		int email =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.email,Integer.class,servicePartner.getEmailId().trim());

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
			if(email<1)
			{

			String employeeId1 =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_MAX_EMPLOYEE_ID, String.class);
			
			String password1 = CipherCrypto.Encrypt("mbk");
			//jdbcTemplate.update(ServicePartnerNewQueryUtil.INSERT_EMPMASTER,employeeId1,servicePartner.getServicePartnerName(),servicePartner.getAddress(),servicePartner.getLandLineNo(),servicePartner.getEmailId(),password1,userDtl.getUserId());
			//jdbcTemplate.update(ServicePartnerQueryUtil.INSERT_USERMASTER,employeeId1,servicePartner.getServicePartnerName(),servicePartner.getAddress(),servicePartner.getLandLineNo(),servicePartner.getEmailId(),password1,userDtl.getUserId());
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
			email1.setSubject("Athena Login Details");
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
			
			Integer serviceprtnerId=jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.SAVESERVICEPARTNER(activBit,cstbin,expbin,impbin,shipbin,consbin,linbin,airlinbin,fribin,cussbin,transbin,slotbin,leasebin,conmanubin,cfsbin,agebin,depobin,iatabin,vndrbin),Integer.class,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),Integer.parseInt(servicePartner.getBranch()),servicePartner.getServicePartnerLedgerName(),servicePartner.getCreditDaysOffered(),servicePartner.getAddress(),Integer.parseInt(servicePartner.getCity()),servicePartner.getRegion(),servicePartner.getCountry(),servicePartner.getZipCode(),servicePartner.getPersonToContact(),servicePartner.getDesignation(),servicePartner.getEmailId(),servicePartner.getLandLineNo(),servicePartner.getMobileNo(),servicePartner.getSkypeId(),servicePartner.getWebSite(),servicePartner.getServicePartnerDescription(),servicePartner.getpANNo(),Integer.parseInt(servicePartner.getDefaultType()),servicePartner.getPartnerClassification(),servicePartner.getgSTNStateCode(),servicePartner.getExemptionUnder(),servicePartner.getSalesPerson(),servicePartner.getgSTNNo(),userDtl.getUserId(),userDtl.getUserId(),acct_head_code,servicePartner.getSundryStatus(),employeeId1);
			for(ServicePartnerNewKeyBean lServicePartnerBean:servicePartnerTable)
				
			{
				int keycount =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.KEYCOUNT,Integer.class);
				int key= keycount+1;
				jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVEKEYDETAILSSERVICEPARTNER,key,lServicePartnerBean.getContactName(),lServicePartnerBean.getKeyDesignation(),lServicePartnerBean.getKeyEmail(),lServicePartnerBean.getKeyLandLineNo(),lServicePartnerBean.getKeyMobileNo(),lServicePartnerBean.getKeySkypeId(),lServicePartnerBean.getKeyCityId(),lServicePartnerBean.getRemarks());

			}
			for(int j=0; j<servicePartnerBean.getServicePartnerTypeList().size();j++)
			{
				jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVEMAPDETAILSSERVICEPARTNER,serviceprtnerId,servicePartnerBean.getServicePartnerTypeList().get(j),true);

			}
			for(ServicePartnerNewBean lServicePartnerBean:servicePartnerBean.getServicePartnerCharge())
			{
				/*if(lServicePartnerBean.getCommodity().equals("All")) {
					String str=	jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.commodity_all,String.class);

				}*/
				int cout =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.MAX_COUNT,Integer.class);

				jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVECHARGESERVICEPARTNER,serviceprtnerId,lServicePartnerBean.getCharge(),lServicePartnerBean.getUnit(),lServicePartnerBean.getCntrType(),lServicePartnerBean.getCurrency(),lServicePartnerBean.getPol(),lServicePartnerBean.getPod(),lServicePartnerBean.getAmt(),lServicePartnerBean.getDate(),lServicePartnerBean.getCommodity(),cout);
				int fileUpload = jdbcTemplate.update(ServicePartnerNewQueryUtil.INSERT_FILE_PATH,new Object[] { serviceprtnerId,lServicePartnerBean.getUploadRef(),userDtl.getUserId(),cout });
if(lServicePartnerBean.getCommodity1()!=null && lServicePartnerBean.getCommodity1().size()>0) {
				for(ServicePartnerNewBean str:lServicePartnerBean.getCommodity1()) {
	//for(int i=0; i<lServicePartnerBean.getCommodity1().size();i++) {
	jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVECHARGE_commodity,cout,str.getId());

}
			}
			}
			String password = CipherCrypto.Encrypt("mbk");
			//jdbcTemplate.update(ServicePartnerNewQueryUtil.INSERT_USERMASTER,employeeId1,servicePartner.getServicePartnerName(), password,
			//		userDtl.getUserId(),activBitCust);
			if(servicePartner.getSalesPerson()!="" ){
				isSuccess = savesalesTable(servicePartner);
			}
			
			int servicePartnerId = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.select_previous_id,Integer.class);
			servicePartner.setTableName("vendor_master_new");
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
			servicePartnerResultBean.setMessage("Service Partner Code Already Exists");
				servicePartnerResultBean.setSuccess(false);

			}
		
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			servicePartnerResultBean.setMessage("Unable to Save");
			servicePartnerResultBean.setSuccess(false);


		} catch (Exception e) {
			
			LOGGER.error("Error in Save Service Partner", e);
			e.printStackTrace();
		}
		return servicePartnerResultBean;
	}
	public static String[] separtormailIds(String toAdd) throws Exception {

		String[] str = toAdd.split(",");
		return str;
	}
	

	@Override
	public ServicePartnerNewResultBean updateServicePartner(
			ServicePartnerNewResultBean servicePartnerBean) {
		
		// TODO Auto-generated method stub
		ServicePartnerNewBean servicePartnerOldBean = new ServicePartnerNewBean();

		ServicePartnerNewBean servicePartner = new ServicePartnerNewBean();
		List<ServicePartnerNewKeyBean> servicePartnerTable = new ArrayList<ServicePartnerNewKeyBean>();

		ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();
		servicePartner=servicePartnerBean.getServicePartner();
		servicePartnerTable=servicePartnerBean.getServicePartnerTable();
		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 Boolean isSuccess=false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String activBit;
			String activBitCust;
			servicePartnerOldBean=jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.EDITSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerNewBean>(ServicePartnerNewBean.class),servicePartner.getServicePartnerId());

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
			int count =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.COUNTSERVICEPARTNERCODEUPDATE,Integer.class,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerId());
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
			jdbcTemplate.update(ServicePartnerNewQueryUtil.UPDATESERVICEPARTNER(activBit,cstbin,expbin,impbin,shipbin,consbin,linbin,airlinbin,fribin,cussbin,transbin,slotbin,leasebin,conmanubin,cfsbin,agebin,depobin,iatabin,vndrbin),servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),Integer.parseInt(servicePartner.getBranch()),servicePartner.getServicePartnerLedgerName(),servicePartner.getCreditDaysOffered(),servicePartner.getAddress(),Integer.parseInt(servicePartner.getCity()),servicePartner.getRegion(),servicePartner.getCountry(),servicePartner.getZipCode(),servicePartner.getPersonToContact(),servicePartner.getDesignation(),servicePartner.getEmailId(),servicePartner.getLandLineNo(),servicePartner.getMobileNo(),servicePartner.getSkypeId(),servicePartner.getWebSite(),servicePartner.getServicePartnerDescription(),servicePartner.getpANNo(),Integer.parseInt(servicePartner.getDefaultType()),servicePartner.getPartnerClassification(),servicePartner.getgSTNStateCode(),servicePartner.getExemptionUnder(),servicePartner.getSalesPerson(),servicePartner.getgSTNNo(),userDtl.getUserId(),servicePartner.getSundryStatus(), servicePartner.getServicePartnerId());
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETEKEYDETAILSSERVICEPARTNER,servicePartner.getServicePartnerId());

			for(ServicePartnerNewKeyBean lServicePartnerBean:servicePartnerTable)
			
			{
				int key =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.KEYCOUNT,Integer.class);
				jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVEKEYDETAILSSERVICEPARTNER,key,lServicePartnerBean.getContactName(),lServicePartnerBean.getKeyDesignation(),lServicePartnerBean.getKeyEmail(),lServicePartnerBean.getKeyLandLineNo(),lServicePartnerBean.getKeyMobileNo(),lServicePartnerBean.getKeySkypeId(),lServicePartnerBean.getKeyCityId(),lServicePartnerBean.getRemarks());

			}
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETEMAPDETAILSSERVICEPARTNER,servicePartner.getServicePartnerId());

			for(int j=0; j<servicePartnerBean.getServicePartnerTypeList().size();j++)
			{
				jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVEMAPDETAILSSERVICEPARTNER,servicePartner.getServicePartnerId(),servicePartnerBean.getServicePartnerTypeList().get(j),true);

			}
			String commo="";
			int cnt=jdbcTemplate.queryForObject("select count(*) from vendor_master_new_charge where srvc_prtnr_bin='"+servicePartner.getServicePartnerId()+"' ::bigint",new Object [] {},Integer.class);
			if(cnt>0) {
				 commo =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.commo_id,new Object [] {servicePartner.getServicePartnerId()},String.class);
				commo=commo.replace(",", "','");
			}
			System.out.println("delete from commo_charges where  comm_id in ('"+commo+"')");

			//jdbcTemplate.update("delete from commo_charges where  comm_id in ('"+commo+"')");
			jdbcTemplate.update("delete from commo_charges where  comm_id in ('"+commo+"')",
					new Object[] { });
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETEChargeSERVICEPARTNER,servicePartner.getServicePartnerId());
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETEChargefile,servicePartner.getServicePartnerId());


			for(ServicePartnerNewBean lServicePartnerBean:servicePartnerBean.getServicePartnerCharge())
			{
				int cout =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.MAX_COUNT,Integer.class);

				jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVECHARGESERVICEPARTNER,servicePartner.getServicePartnerId(),lServicePartnerBean.getCharge(),lServicePartnerBean.getUnit(),lServicePartnerBean.getCntrType(),lServicePartnerBean.getCurrency(),lServicePartnerBean.getPol(),lServicePartnerBean.getPod(),lServicePartnerBean.getAmt(),lServicePartnerBean.getDate(),lServicePartnerBean.getCommodity(),cout);
				int fileUpload = jdbcTemplate.update(ServicePartnerNewQueryUtil.INSERT_FILE_PATH,new Object[] { servicePartner.getServicePartnerId(),lServicePartnerBean.getUploadRef(),userDtl.getUserId(),cout });
				if(lServicePartnerBean.getCommodity1()!=null && lServicePartnerBean.getCommodity1().size()>0) {

				for(ServicePartnerNewBean str:lServicePartnerBean.getCommodity1()) {
	//for(int i=0; i<lServicePartnerBean.getCommodity1().size();i++) {
	jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVECHARGE_commodity,cout,str.getId());

}}
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
			jdbcTemplate.update(ServicePartnerNewQueryUtil.UPDATE_USER_MASTER,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),
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
	public ServicePartnerNewResultBean editServicePartner(int servicePartnerId) {
		// TODO Auto-generated method stub
		ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			servicePartnerResultBean.setServicePartner(jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.EDITSERVICEPARTNERNEW,new BeanPropertyRowMapper<ServicePartnerNewBean>(ServicePartnerNewBean.class),servicePartnerId,servicePartnerId,servicePartnerId,servicePartnerId,servicePartnerId));
			
			servicePartnerResultBean.setServicePartnerTable(jdbcTemplate.query(ServicePartnerNewQueryUtil.EDITKEYSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerNewKeyBean>(ServicePartnerNewKeyBean.class),servicePartnerId));

			servicePartnerResultBean.setServicePartnerType(jdbcTemplate.query(ServicePartnerNewQueryUtil.EDITMAPSERVICEPARTNER,new BeanPropertyRowMapper<ServiceNewMapBean>(ServiceNewMapBean.class),servicePartnerId));
			servicePartnerResultBean.setServicePartnerCharge(jdbcTemplate.query(ServicePartnerNewQueryUtil.EDITChargeSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerNewBean>(ServicePartnerNewBean.class),servicePartnerId));
System.out.println(ServicePartnerNewQueryUtil.EDITChargeSERVICEPARTNER);
			servicePartnerResultBean.setSalesTable(jdbcTemplate.query(ServicePartnerNewQueryUtil.EDITSALES,new BeanPropertyRowMapper<ServicePartnerNewBean>(ServicePartnerNewBean.class),servicePartnerId));
			if(servicePartnerResultBean.getServicePartnerCharge().size()>0) {			
			for(ServicePartnerNewBean bean: servicePartnerResultBean.getServicePartnerCharge()) {
			bean.setUploadRef(jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.fileuploadinvoicelist, new Object[] { bean.getBin() },
					String.class));
			}
			}
			servicePartnerResultBean.setSuccess(true);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			LOGGER.error("Error in Edit Service Partner", e);
		}
		return servicePartnerResultBean;
	}
	
	@Override
	public ServicePartnerNewResultBean viewServicePatrnerList(int servicePartnerId) {
		// TODO Auto-generated method stub
		ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			servicePartnerResultBean.setServicePartner(jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.VIEWSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerNewBean>(ServicePartnerNewBean.class),servicePartnerId));
			
			servicePartnerResultBean.setServicePartnerTable(jdbcTemplate.query(ServicePartnerNewQueryUtil.VIEWKEYSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerNewKeyBean>(ServicePartnerNewKeyBean.class),servicePartnerId));

			servicePartnerResultBean.setServicePartnerType(jdbcTemplate.query(ServicePartnerNewQueryUtil.VIEWMAPSERVICEPARTNER,new BeanPropertyRowMapper<ServiceNewMapBean>(ServiceNewMapBean.class),servicePartnerId));
			servicePartnerResultBean.setServicePartnerCharge(jdbcTemplate.query(ServicePartnerNewQueryUtil.ViewChargeSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerNewBean>(ServicePartnerNewBean.class),servicePartnerId));

			for(ServicePartnerNewBean bn:servicePartnerResultBean.getServicePartnerCharge()) {
			String[] str=bn.getCommodity().split(",");
			String com="";
		int i=0;
			for(String s: str) {
				if(com.equals(null) || com.equals("")) {
					com="'"+s+"'";
				}else {	
					com=com+","+"'"+s+"'";
				}
			}
			
			bn.setCommodity(jdbcTemplate.queryForObject("select String_agg(commodity,',') from commodity where commodity_code  in ("+com+") ",String.class));
			
			}
			servicePartnerResultBean.setSalesTable(jdbcTemplate.query(ServicePartnerNewQueryUtil.VIEWSALES,new BeanPropertyRowMapper<ServicePartnerNewBean>(ServicePartnerNewBean.class),servicePartnerId));
			for(ServicePartnerNewBean bean: servicePartnerResultBean.getServicePartnerCharge())
				bean.setUploadRef(jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.fileuploadinvoicelist, new Object[] { bean.getBin() },
						String.class));
			servicePartnerResultBean.setSuccess(true);
		} catch (Exception e) {
		e.printStackTrace();
			LOGGER.error("Error in View  Service Partner", e);
		}
		return servicePartnerResultBean;
	}
	
	public boolean savesalesTable(ServicePartnerNewBean servicePartner) {
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		  // code added for inter-company transaction
		  String sCompanyCode = "";
		  boolean isSuccess = false;
		  try {
		   
			int servicePartnerId = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.select_previous_id,Integer.class);


		    int iPinDtl = jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVE_SALES_TABLE,new Object[] {servicePartnerId,servicePartner.getSalesPerson() });

		   

		  } catch (Exception e) {
		 /*  e.printStackTrace();*/
		   LOGGER.error("Error in Save Sales Table", e);
		  }
		  return true;
		 }
	
	public boolean savesalesTable1(ServicePartnerNewBean servicePartner) {
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		  // code added for inter-company transaction
		  String sCompanyCode = "";
		  boolean isSuccess = false;
		  try {
		   
			//int servicePartnerId = jdbcTemplate.queryForObject(ServicePartnerQueryUtil.select_previous_id,Integer.class);


		    int iPinDtl = jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVE_SALES_TABLE,new Object[] {servicePartner.getServicePartnerId(),servicePartner.getSalesPerson() });

		   

		  } catch (Exception e) {
		   /*e.printStackTrace();*/
		   LOGGER.error("Error in Save Sales Table1", e);
		  }
		  return true;
		 }
	@Override
	public ServicePartnerNewResultBean deleteServicePartner(int servicePartnerId) {
		// TODO Auto-generated method stub
		ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();
		try {
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			ServicePartnerNewBean servicePartner = new ServicePartnerNewBean();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			servicePartner=jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.EDITSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerNewBean>(ServicePartnerNewBean.class),servicePartnerId);
			servicePartner.setTableName("service_partner");
			servicePartner.setFormCode("F5086");
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETEChargeSERVICEPARTNER,servicePartnerId);
			String commo="";
			int cnt=jdbcTemplate.queryForObject("select count(*) from vendor_master_new_charge where srvc_prtnr_bin='"+servicePartner.getServicePartnerId()+"' ::bigint",new Object [] {},Integer.class);
			if(cnt>0) {
				 commo =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.commo_id,new Object [] {servicePartner.getServicePartnerId()},String.class);
				commo=commo.replace(",", "','");
			}
			jdbcTemplate.update("delete from commo_charges where  comm_id in ('"+commo+"')",
					new Object[] { });
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETESERVICEPARTNER,
					servicePartnerId);
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETE_sale_details,servicePartnerId);
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETEUSERMASTER,
					servicePartnerId);
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETEKEYDETAILSSERVICEPARTNER,servicePartnerId);


			
			
			jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETEMAPDETAILSSERVICEPARTNER,servicePartnerId);
			 userlogDao.userLogForDelete(servicePartner, servicePartnerId + "", userDtl.getUserId());

			servicePartnerResultBean.setSuccess(true);
		} catch (Exception e) {
			/*e.printStackTrace();*/
			servicePartnerResultBean.setSuccess(false);

			   LOGGER.error("Error in Delete Service Partner", e);
		}
		return servicePartnerResultBean;
	}

	@Override
	public ServicePartnerNewResultBean createLogin(int rowid) {
		
		ServicePartnerNewResultBean ServicePartnerResultBean = new ServicePartnerNewResultBean();
		ServicePartnerNewBean servicePartner = new ServicePartnerNewBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String activBitCust;
		String activBit;
		try
		{
			UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            //Getting service Partner Details
			servicePartner=jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.EDITSERVICEPARTNER,new BeanPropertyRowMapper<ServicePartnerNewBean>(ServicePartnerNewBean.class),rowid);
			

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
			
			String employeeId1 =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_MAX_EMPLOYEE_ID, String.class);
			//password
			String password1 = CipherCrypto.Encrypt("athena");
			
			//insert into employeemaster
			//jdbcTemplate.update(ServicePartnerNewQueryUtil.INSERT_EMPMASTER,employeeId1,servicePartner.getServicePartnerName(),servicePartner.getAddress(),servicePartner.getLandLineNo(),servicePartner.getEmailId(),password1,userDtl.getUserId());
			
			
			//insert into customer User
		//	jdbcTemplate.update(ServicePartnerNewQueryUtil.INSERT_USERMASTER,employeeId1,servicePartner.getServicePartnerName(), password1,
			//		userDtl.getUserId(),activBitCust);
			
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
	public ServicePartnerNewResultBean deleteKeyDetail(List<ServicePartnerNewKeyBean> lServicePartnerKeyBean) {
		// TODO Auto-generated method stub
		ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			for(ServicePartnerNewKeyBean servicePartnerKeyBean:lServicePartnerKeyBean)
			{
				jdbcTemplate.update(ServicePartnerNewQueryUtil.DELETEKEYSERVICEPARTNER,
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
	public ServicePartnerNewResultBean getServicePartnerDetailList() {
		// TODO Auto-generated method stub
		ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();
		List<ServiceNewMapBean> lServiceMapBean = new ArrayList<ServiceNewMapBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lServiceMapBean = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETTYPELIST,new BeanPropertyRowMapper<ServiceNewMapBean>(
							ServiceNewMapBean.class));
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
	public boolean saveCustomerCommDetail(CustomerMasterNewCommDetail2 customerMasterCommDetail, String userId)throws Exception {
		boolean issucces = false;
		int value = 0;
		Date nextFollowUpDate = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String getmloCommId = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_MLOCOMMID, String.class);
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
					.update(ServicePartnerNewQueryUtil.INSERT_CUSTOMER_COMM_DETAIL,
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
public ServicePartnerNewResultBean getCustomCommDetail(String srvcprtnrcd) {
	ServicePartnerNewResultBean customMaster = new ServicePartnerNewResultBean();
	int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };
	Object[] params = new Object[] { srvcprtnrcd };
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	List<CustomerMasterNewCommDetail2> customerMasterCommDetails = jdbcTemplate
			.query(ServicePartnerNewQueryUtil.SELECT_CUSTOMER_COMM_DETAIL,
					  new BeanPropertyRowMapper<>(
							CustomerMasterNewCommDetail2.class),srvcprtnrcd);
	customMaster.setCustomerMasterCommDetails(customerMasterCommDetails);
	// customMaster.setLeadMasterCommDetails(leadMasterCommDetails);
	return customMaster;
}
@Override
public boolean updateCustomerCommDetail(CustomerMasterNewCommDetail2 customerMasterCommDetail, String userId)
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
				.update(ServicePartnerNewQueryUtil.UPDATE_CUSTOMER_COMM_DETAIL,
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
				ServicePartnerNewQueryUtil.DELETE_CUSTOMER_COMM_DETAIL,
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
public ServicePartnerNewResultBean getCountryList(int cityId) {
	ServicePartnerNewResultBean ResultBean = new ServicePartnerNewResultBean();
	
	//List<SelectivityBean> countryList = new ArrayList<SelectivityBean>();
	//List<SelectivityBean> regionList = new ArrayList<SelectivityBean>();
	
	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int stateId = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_STATE_ID,int.class,cityId);
		
		String country = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.COUNTRYLIST,String.class, stateId);
		String region = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.RegionLIST,String.class, country);
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
public List<ServicePartnerNewBean> getServicePartnerListnew() {
	// TODO Auto-generated method stub
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();
	List<ServicePartnerNewBean> lServicePartnerBean = new ArrayList<ServicePartnerNewBean>();
	String name = "mascustomer";

	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		if(name.equalsIgnoreCase("acccustomer")){//account customer
			lServicePartnerBean = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETLIST,new BeanPropertyRowMapper<ServicePartnerNewBean>(	ServicePartnerNewBean.class));	
		}else{//master-->service customer
			lServicePartnerBean = jdbcTemplate.query(ServicePartnerNewQueryUtil.GETLIST1,new BeanPropertyRowMapper<ServicePartnerNewBean>(	ServicePartnerNewBean.class));
		}
		for(ServicePartnerNewBean lServicePartnerBean1:lServicePartnerBean) {
			
			
			int count = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.Get_emplyee_Id,new Object[] { lServicePartnerBean1.getServicePartnerName() }, Integer.class);
			
			 if(count>0) {
			 lServicePartnerBean1.setLoginId("Yes");
			 }
			 
		}

		
/*		servicePartnerResultBean
				.setlServicePartnerBean(lServicePartnerBean);
*/	} catch (Exception e) {
		/*e.printStackTrace();*/
		LOGGER.error("Error in Service Partner List", e);
	}
	return lServicePartnerBean;
}

@Override
public ServicePartnerNewResultBean uploadFile(MultipartFile file) {
	// TODO Auto-generated method stub
	ServicePartnerNewResultBean ResultBean = new ServicePartnerNewResultBean();

	String serverPath = "";

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss");
	String strDate = sdf.format(cal.getTime());
	if (!file.isEmpty()) {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			byte[] bytes = file.getBytes();
			String workingDir = System.getProperty("user.dir");
			String fileName;
			String myName;

			myName = "upload" + strDate;
			String localPath = ConfigurationProps.exportFilesPath;
			String name = file.getOriginalFilename();
			int dot = name.lastIndexOf('.');
			String base = (dot == -1) ? name : name.substring(0, dot);
			String extension = (dot == -1) ? "" : name.substring(dot + 1);
			File dir = new File(localPath);

			Date date = new Date();

			base = base + "_" + date.getHours() + "_" + date.getMinutes() + "_" + date.getSeconds() + "."
					+ extension;
			File serverFile = new File(dir.getAbsolutePath() + File.separator + base);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			serverPath = "/filePath/" + base;
			ResultBean.setImgPath(serverPath);

			ResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error in uploadFile", e);
		}
	}
	return ResultBean;
}




@Override
public ServicePartnerNewResultBean saveImportDetails(ServicePartnerNewResultBean agentMasterBean) {

	ServicePartnerNewResultBean bean = new ServicePartnerNewResultBean();
	
	try {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		for(ServicePartnerNewBean servicePartner: agentMasterBean.getlServicePartnerBean()) {
			bean = saveServicePartnernew(servicePartner);
		}
		//bean.setSuccess(true);
		
	} catch (Exception ae) {
		LOGGER.error("Error in saveImportDetails", ae);
	}
	return bean;
}


	
	


public ServicePartnerNewResultBean saveServicePartnernew(ServicePartnerNewBean servicePartner) {

// TODO Auto-generated method stub
//ServicePartnerNewBean servicePartner = new ServicePartnerNewBean();
ServicePartnerNewBean servicePartnerOldBean = new ServicePartnerNewBean();
List<ServicePartnerNewKeyBean> servicePartnerTable = new ArrayList<ServicePartnerNewKeyBean>();

UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();
//servicePartner=servicePartnerBean.getServicePartner();
//servicePartnerTable=servicePartnerBean.getServicePartnerTable();
 Boolean isSuccess=false;
 Boolean success =false;
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

	
	String accountheadtype = "V" + (CommonExcelUtils.getOnlyStrings(servicePartner.getServicePartnerName()));
	String acct_head_code = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.CHECK_CUSTOMER_ACCT_HEAD,
			new Object[] { accountheadtype,accountheadtype }, String.class);
	acct_head_code = accountheadtype + acct_head_code;
	System.out.println("acct_head_code=" + acct_head_code);
int count =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.COUNTSERVICEPARTNERCODE,Integer.class,servicePartner.getServicePartnerCode());


if(count<1)
	{
	String employeeId1 =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_MAX_EMPLOYEE_ID, String.class);
	
		
	
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
    String  sundry = servicePartner.getSundryStatus().trim();

	
	
	int stateId = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_STATE_ID,int.class,Integer.parseInt(servicePartner.getCity()));
	
	String country = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.COUNTRYLIST,String.class, stateId);
	String region = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.RegionLIST,String.class, country);
   // Integer  deftype = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_defult,Integer .class, defaut);
	//Integer GstSte = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.GET_gste, Integer.class, GstState);

  if (sundry.equalsIgnoreCase("Creditors - Local")){
	  sundry= "20000003";
  }else if(sundry.equalsIgnoreCase("Creditors - Overseas"))
  {
	  sundry= "20010003";

  }else if (sundry .equalsIgnoreCase("Debtors - Local")){
	  sundry= "10010004";

  }else{
	  sundry = "10080002";
  }
	  
  
Integer serviceprtnerId=jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.SAVESERVICEPARTNERnewpar(activBit,cstbin,expbin,impbin,shipbin,consbin,linbin,airlinbin,fribin,cussbin,transbin,slotbin,leasebin,conmanubin,cfsbin,agebin,depobin,iatabin,vndrbin),Integer.class,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),Integer.parseInt(servicePartner.getBranch()),servicePartner.getServicePartnerLedgerName(),servicePartner.getCreditDaysOffered(),servicePartner.getAddress(),Integer.parseInt(servicePartner.getCity()),region,country,servicePartner.getZipCode(),servicePartner.getPersonToContact(),servicePartner.getDesignation(),servicePartner.getEmailId(),servicePartner.getLandLineNo(),servicePartner.getMobileNo(),servicePartner.getSkypeId(),servicePartner.getWebSite(),servicePartner.getServicePartnerDescription(),servicePartner.getpANNo(),Integer.parseInt(servicePartner.getDefaultType()),servicePartner.getPartnerClassification(),servicePartner.getgSTNStateCode(),servicePartner.getExemptionUnder(),servicePartner.getSalesPerson(),servicePartner.getgSTNNo(),userDtl.getUserId(),userDtl.getUserId(),acct_head_code,sundry,employeeId1);

	//Integer serviceprtnerId=jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.SAVESERVICEPARTNERnew1(activBit,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),servicePartner.getBranch(),servicePartner.getServicePartnerLedgerName(),servicePartner.getCreditDaysOffered(),servicePartner.isActive(),servicePartner.getAddress(),servicePartner.getCity(),servicePartner.getRegion(),servicePartner.getCountry(),servicePartner.getZipCode(),servicePartner.getPersonToContact(),servicePartner.getDesignation(),servicePartner.getEmailId(),servicePartner.getLandLineNo(),servicePartner.getMobileNo(),servicePartner.getSkypeId(),vndrbin),Integer.class,servicePartner.getServicePartnerCode(),servicePartner.getServicePartnerName(),Integer.parseInt(servicePartner.getBranch()),servicePartner.getServicePartnerLedgerName(),servicePartner.getCreditDaysOffered(),servicePartner.getAddress(),Integer.parseInt(servicePartner.getCity()),servicePartner.getRegion(),servicePartner.getCountry(),servicePartner.getZipCode(),servicePartner.getPersonToContact(),servicePartner.getDesignation(),servicePartner.getEmailId(),servicePartner.getLandLineNo(),servicePartner.getMobileNo(),servicePartner.getSkypeId(),servicePartner.getWebSite(),servicePartner.getServicePartnerDescription(),servicePartner.getpANNo(),Integer.parseInt(servicePartner.getDefaultType()),servicePartner.getPartnerClassification(),servicePartner.getgSTNStateCode(),servicePartner.getExemptionUnder(),servicePartner.getSalesPerson(),servicePartner.getgSTNNo(),userDtl.getUserId(),userDtl.getUserId(),acct_head_code,servicePartner.getSundryStatus(),employeeId1);

  for(ServicePartnerNewKeyBean lServicePartnerBean:servicePartnerTable)
		
	{
		int keycount =jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.KEYCOUNT,Integer.class);
		int key= keycount+1;
		jdbcTemplate.update(ServicePartnerNewQueryUtil.SAVEKEYDETAILSSERVICEPARTNER,key,lServicePartnerBean.getContactName(),lServicePartnerBean.getKeyDesignation(),lServicePartnerBean.getKeyEmail(),lServicePartnerBean.getKeyLandLineNo(),lServicePartnerBean.getKeyMobileNo(),lServicePartnerBean.getKeySkypeId(),lServicePartnerBean.getKeyCityId(),lServicePartnerBean.getRemarks());

	}
			String password = CipherCrypto.Encrypt("mbk");
	if(servicePartner.getSalesPerson()!="" ){
		isSuccess = savesalesTable(servicePartner);
	}
	
	int servicePartnerId = jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.select_previous_id,Integer.class);
	servicePartner.setTableName("vendor_master_new");
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
	e.printStackTrace();
}
return servicePartnerResultBean;

}


@Override
public ServicePartnerNewResultBean vendor(ServicePartnerNewResultBean agentMasterBean) {
	//Boolean boo=false;
	ServicePartnerNewResultBean bean = new ServicePartnerNewResultBean();
	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int count=jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.vendorname,new Object[]{ agentMasterBean.getMessage()},Integer.class);
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
public ServicePartnerNewResultBean email(ServicePartnerNewResultBean agentMasterBean) {
	ServicePartnerNewResultBean bean = new ServicePartnerNewResultBean();
	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int count=jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.email,new Object[]{ agentMasterBean.getMessage()},Integer.class);
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
public ServicePartnerNewResultBean con(ServicePartnerNewResultBean agentMasterBean) {
	ServicePartnerNewResultBean bean = new ServicePartnerNewResultBean();
	try {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int count=jdbcTemplate.queryForObject(ServicePartnerNewQueryUtil.COUNTSERVICEPARTNERCODE,new Object[]{ agentMasterBean.getMessage()},Integer.class);
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




























