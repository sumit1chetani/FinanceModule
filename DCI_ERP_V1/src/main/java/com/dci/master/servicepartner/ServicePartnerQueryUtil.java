package com.dci.master.servicepartner;


public class ServicePartnerQueryUtil {

/*	public static final String GETLIST = "select srvc_prtnr_bin as servicePartnerId,br.brnch_cd as branchName,spt.dflt_typ_nam as defaultTypeName,cty.cty_nam as cityName,zp_cd_zp as zipCode,srvc_prtnr_cd as servicePartnerCode,concat(sp.acct_head_code,'-',sp.srvc_prtnr_nam) as servicePartnerName,sp.brnch_id branch,srvc_prtnr_ldgr_nam as servicePartnerLedgerName,crdt_dys_offrd as creditDaysOffered,sp.actv_bt as active,addrs1_add as address,sp.cty_id as city,rgn_cd as region,cntry_cd as country,prsn_to_cntct as personToContact,dsgntn designation,eml_id_eml as emailId,phn_no_phn as landLineNo,mbl_no_mob as mobileNo,skyp_id as skypeId,wbst_nam as website,srvc_prtnr_dscrptn as servicePartnerDescription,sp.pan_no as pANNo,sp.dflt_typ_id as defaultType,prtnr_clssfctn_id as partnerClassification,sp.gstn_stt_cd gSTNStateCode,exmptn_udr exemptionUnder,br.brnch_id,sp.gstn_no as gSTNNo, em.emp_name as salesPerson from service_partner sp inner join city cty on sp.cty_id=cty.cty_id inner join service_partner_type spt on spt.dflt_typ_id=sp.dflt_typ_id inner join branch br on br.brnch_id=sp.brnch_id left join employee_master em on em.emp_id = sp.sales_person where spt.dflt_typ_nam in ('CUSTOMER','SHIPPER') order by srvc_prtnr_bin desc";
*/	
	
	public static final String GETLIST = "select srvc_prtnr_ID AS id ,srvc_prtnr_bin as servicePartnerId,br.brnch_nam as branchName,spt.dflt_typ_nam as defaultTypeName, CASE WHEN  cstmr_bt='1' then 'Customer' ELSE CASE when  vndr_bt='1' then 'Vendor' ELSE CASE when dlvry_agnt_bt='1' THEN  'Agent'  END END END as cusvenagent ,cty.cty_nam as cityName,zp_cd_zp as zipCode,srvc_prtnr_cd as servicePartnerCode,concat(sp.acct_head_code,'-',sp.srvc_prtnr_nam) as servicePartnerName,sp.brnch_id branch,srvc_prtnr_nam as servicePartnerLedgerName,crdt_dys_offrd as creditDaysOffered,sp.actv_bt as active,addrs1_add as address,sp.cty_id as city,rgn_cd as region,cntry_cd as country, cm.cntry_nam as countryName, prsn_to_cntct as personToContact,dsgntn designation,eml_id_eml as emailId,phn_no_phn as landLineNo,mbl_no_mob as mobileNo,skyp_id as skypeId,wbst_nam as website,srvc_prtnr_dscrptn as servicePartnerDescription,sp.pan_no as pANNo,sp.dflt_typ_id as defaultType,prtnr_clssfctn_id as partnerClassification,sp.gstn_stt_cd gSTNStateCode,exmptn_udr exemptionUnder,br.brnch_id,sp.gstn_no as gSTNNo, em.emp_name as salesPerson from service_partner sp inner join city cty on sp.cty_id=cty.cty_id inner join service_partner_type spt on spt.dflt_typ_id=sp.dflt_typ_id inner join branch br on br.brnch_id=sp.brnch_id inner join country cm on sp.cntry_cd=cm.cntry_cd left join employee_master em on em.emp_id = sp.sales_person where spt.dflt_typ_nam in ('CUSTOMER','SHIPPER','CONSIGNEE','FRIEGHT FORWARDER')"
         +" order by  srvc_prtnr_ID desc ";
	public static final String GETLIST1 = "select srvc_prtnr_ID AS id , srvc_prtnr_bin as servicePartnerId,br.brnch_nam as branchName,spt.dflt_typ_nam as defaultTypeName,  CASE WHEN  cstmr_bt='1' then 'Customer' ELSE CASE when  vndr_bt='1' then 'Vendor' ELSE CASE when dlvry_agnt_bt='1' THEN  'Agent'  END END END as cusvenagent ,cty.cty_nam as cityName,zp_cd_zp as zipCode,srvc_prtnr_cd as servicePartnerCode,concat(sp.acct_head_code,'-',sp.srvc_prtnr_nam) as servicePartnerName,sp.brnch_id branch,srvc_prtnr_nam as servicePartnerLedgerName,crdt_dys_offrd as creditDaysOffered,sp.actv_bt as active,addrs1_add as address,sp.cty_id as city,rgn_cd as region,cm.cntry_cd as country,cm.cntry_nam as countryName,prsn_to_cntct as personToContact,dsgntn designation,eml_id_eml as emailId,phn_no_phn as landLineNo,mbl_no_mob as mobileNo,skyp_id as skypeId,wbst_nam as website,srvc_prtnr_dscrptn as servicePartnerDescription,sp.pan_no as pANNo,sp.dflt_typ_id as defaultType,prtnr_clssfctn_id as partnerClassification,sp.gstn_stt_cd gSTNStateCode,exmptn_udr exemptionUnder,br.brnch_id,sp.gstn_no as gSTNNo, em.emp_name as salesPerson from service_partner sp inner join city cty on sp.cty_id=cty.cty_id inner join service_partner_type spt on spt.dflt_typ_id=sp.dflt_typ_id inner join branch br on br.brnch_id=sp.brnch_id inner join country cm on sp.cntry_cd=cm.cntry_cd left join employee_master em on em.emp_id = sp.sales_person    " 
         +" order by  srvc_prtnr_ID desc ";
	
	//public static final String GET_MAX_EMPLOYEE_ID = "SELECT CASE WHEN (select MAX(emp_id) from employee_master where emp_id like '%C%') IS NULL  THEN 'C0001' ELSE rpad(MAX('C'),1,'C') || lpad(cast(cast((select SUBSTRING(MAX(emp_id),2) from employee_master where emp_id like '%C%') as int)+1  as text),4,'0') END FROM employee_master";
	public static final String GET_MAX_EMPLOYEE_ID = "SELECT CASE WHEN (select MAX(SRVC_PRTNR_ID) from SERVICE_PARTNER where SRVC_PRTNR_ID like '%C%') IS NULL THEN 'C0001' ELSE rpad(MAX('C'),1,'C') || lpad(cast(cast((select SUBSTRING(MAX(SRVC_PRTNR_ID),2) from SERVICE_PARTNER where SRVC_PRTNR_ID like '%C%') as int)+1 as text),4,'0') END FROM SERVICE_PARTNER";
	
	public static final String SAVESERVICEPARTNER(String activBit,String cstbin,String expbin,String impbin,String shipbin,String consbin,String linbin,String airlinbin,String fribin,String cussbin,String transbin,String slotbin,String leasebin,String conmanubin,String cfsbin,String agebin,String depobin,String iatabin,String vndrbin )
	{
		String str= "insert into service_partner(srvc_prtnr_bin,srvc_prtnr_cd,srvc_prtnr_nam,brnch_id,srvc_prtnr_ldgr_nam,crdt_dys_offrd,actv_bt,addrs1_add,cty_id,rgn_cd,cntry_cd,zp_cd_zp,prsn_to_cntct,dsgntn,eml_id_eml,phn_no_phn,mbl_no_mob,skyp_id,wbst_nam,srvc_prtnr_dscrptn,pan_no,dflt_typ_id,prtnr_clssfctn_id,gstn_stt_cd,exmptn_udr,sales_person,gstn_no,crtd_by,crtd_dt,mdfd_by,mdfd_dt,acct_head_code,cstmr_bt,exprtr_bt,imprtr_bt,shppr_bt,cnsgn_bt,lnrs_bt,ar_lnr_bt,frght_frwdr_bt,cha_bt,trnsprtr_bt,slt_oprtr_bt,lsng_cmpny_bt,cntnr_mnfctr_bt,cfs_bt,dlvry_agnt_bt,dpt_bt,iata_agnt_bt,vndr_bt,sundry_type,SRVC_PRTNR_ID,credit_amt,credit_days)values((select coalesce(max(srvc_prtnr_bin),0)+1 from service_partner),?,?,?,?,?,(B'"+activBit+"')::bit(1),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,now(),?,(B'"+cstbin+"')::bit(1),(B'"+expbin+"')::bit(1),(B'"+impbin+"')::bit(1),(B'"+shipbin+"')::bit(1),(B'"+consbin+"')::bit(1),(B'"+linbin+"')::bit(1),(B'"+airlinbin+"')::bit(1),(B'"+fribin+"')::bit(1),(B'"+cussbin+"')::bit(1),(B'"+transbin+"')::bit(1),(B'"+slotbin+"')::bit(1),(B'"+leasebin+"')::bit(1),(B'"+conmanubin+"')::bit(1),(B'"+cfsbin+"')::bit(1),(B'"+agebin+"')::bit(1),(B'"+depobin+"')::bit(1),(B'"+iatabin+"')::bit(1),(B'"+vndrbin+"')::bit(1),?,?,?,?)returning srvc_prtnr_bin";
	     return str;
	}
	public static final String INSERT_EMPMASTER ="INSERT INTO employee_master(emp_id, emp_name,  dt_of_birth,  address, contact_no, email_id, password,  status, sa_right, created_by, created_dt,designation, dept)VALUES (?, ?, now(), ?, ?, ?,  ?, 'Y', 'Y', ?, now(), 'DS024', 'DP018')";

	public static final String INSERT_USERMASTER = "INSERT INTO user_master(user_id,user_name,user_password,user_ref_id_emp,active_inactive,user_ref_flag)values(?,?,?,?,?,'C')";

	public static final String UPDATESERVICEPARTNER(String activBit,String cstbin,String expbin,String impbin,String shipbin,String consbin,String linbin,String airlinbin,String fribin,String cussbin,String transbin,String slotbin,String leasebin,String conmanubin,String cfsbin,String agebin,String depobin,String iatabin,String vndrbin)
	{
		String str= "update service_partner set srvc_prtnr_cd =?,srvc_prtnr_nam=?,brnch_id=?,srvc_prtnr_ldgr_nam=?,crdt_dys_offrd=?,actv_bt=(B'"+activBit+"')::bit(1),addrs1_add=?,cty_id=?,rgn_cd=?,cntry_cd=?,zp_cd_zp=?,prsn_to_cntct=?,dsgntn=?,eml_id_eml=?,phn_no_phn=?,mbl_no_mob=?,skyp_id=?,wbst_nam=?,srvc_prtnr_dscrptn=?,pan_no=?,dflt_typ_id=?,prtnr_clssfctn_id=?,gstn_stt_cd=?,exmptn_udr=?,sales_person=?,gstn_no=?,mdfd_by=?,mdfd_dt=now(),cstmr_bt=(B'"+cstbin+"')::bit(1),exprtr_bt=(B'"+expbin+"')::bit(1),imprtr_bt=(B'"+impbin+"')::bit(1),shppr_bt=(B'"+shipbin+"')::bit(1),cnsgn_bt=(B'"+consbin+"')::bit(1),lnrs_bt=(B'"+linbin+"')::bit(1),ar_lnr_bt=(B'"+airlinbin+"')::bit(1),frght_frwdr_bt=(B'"+fribin+"')::bit(1),cha_bt=(B'"+cussbin+"')::bit(1),trnsprtr_bt=(B'"+transbin+"')::bit(1),slt_oprtr_bt=(B'"+slotbin+"')::bit(1),lsng_cmpny_bt=(B'"+leasebin+"')::bit(1),cntnr_mnfctr_bt=(B'"+conmanubin+"')::bit(1),cfs_bt=(B'"+cfsbin+"')::bit(1),dlvry_agnt_bt=(B'"+agebin+"')::bit(1),dpt_bt=(B'"+depobin+"')::bit(1),iata_agnt_bt=(B'"+iatabin+"')::bit(1),vndr_bt=(B'"+vndrbin+"')::bit(1),sundry_type = ?,credit_amt=?,credit_days=?  where srvc_prtnr_bin=? ";
	     return str;

	}

	public static final String EDITSERVICEPARTNER = "select credit_days creditDaysOffered,coalesce(credit_amt,0.0) creditAmt,srvc_prtnr_bin as servicePartnerId,srvc_prtnr_cd as servicePartnerCode,srvc_prtnr_nam as servicePartnerName,brnch_id branch,srvc_prtnr_ldgr_nam as servicePartnerLedgerName,zp_cd_zp as zipCode,crdt_dys_offrd as creditDaysOffered,case when actv_bt is null then false  when  actv_bt ='1' then true when actv_bt='0' then false  end  as active,addrs1_add as address,cty_id as city,rgn_cd as region,cntry_cd as country,prsn_to_cntct as personToContact,dsgntn designation,\n" + "eml_id_eml as emailId,phn_no_phn as landLineNo,mbl_no_mob as mobileNo,skyp_id as skypeId,wbst_nam as website,srvc_prtnr_dscrptn as servicePartnerDescription,pan_no as pANNo,dflt_typ_id as defaultType,prtnr_clssfctn_id as partnerClassification,gstn_stt_cd gSTNStateCode,exmptn_udr exemptionUnder,sales_person as salesPerson,gstn_no as gSTNNo,crtd_by as createdBy,to_char(crtd_dt,'dd/mm/yyyy') as createdDate,mdfd_by as modifedBy,to_char(mdfd_dt,'dd/mm/yyyy') as modifiedDate, sundry_type as sundryStatus  from service_partner where srvc_prtnr_bin= ?";

	//new Edit Query
	
	public static final String EDITSERVICEPARTNERNEW = "with prty as (select credit_days creditDaysOffered,coalesce(credit_amt,0.0) creditAmt,srvc_prtnr_bin as servicePartnerId,srvc_prtnr_cd as servicePartnerCode,srvc_prtnr_nam as servicePartnerName,brnch_id branch,srvc_prtnr_ldgr_nam as servicePartnerLedgerName,zp_cd_zp as zipCode,crdt_dys_offrd as creditDaysOffered,case when actv_bt is null then false when actv_bt ='1' then true when actv_bt='0' then false end as active,addrs1_add as address,cty_id as city,rgn_cd as region,cntry_cd as country,prsn_to_cntct as personToContact,dsgntn designation,eml_id_eml as emailId,phn_no_phn as landLineNo,mbl_no_mob as mobileNo,skyp_id as skypeId,wbst_nam as website,srvc_prtnr_dscrptn as servicePartnerDescription,pan_no as pANNo,dflt_typ_id as defaultType,prtnr_clssfctn_id as partnerClassification,gstn_stt_cd gSTNStateCode,exmptn_udr exemptionUnder,sales_person as salesPerson,gstn_no as gSTNNo,crtd_by as createdBy,to_char(crtd_dt,'dd/mm/yyyy') as createdDate,mdfd_by as modifedBy,to_char(mdfd_dt,'dd/mm/yyyy') as modifiedDate, sundry_type as sundryStatus,(select count(prty_bin) from sea_sales_invoice where prty_bin=?) as seaSalesPrty,(select count(prty_bin) from air_sales_invoice where prty_bin=?) as airSalesPrty,(select count(prty_bin) from sea_purchase_invoice where prty_bin=?) as seaPrchsPrty,(select count(prty_bin) from air_purchase_invoice where prty_bin=?) as airPrchsPrty from service_partner where srvc_prtnr_bin= ?) select prty.*,(seaSalesPrty+airSalesPrty+seaPrchsPrty+airPrchsPrty) as prtyCount from prty";

	
	public static final String VIEWSERVICEPARTNER = "select credit_days creditDaysOffered,coalesce(credit_amt,0.0) creditAmt,srvc_prtnr_bin as servicePartnerId,srvc_prtnr_cd as servicePartnerCode,srvc_prtnr_nam as servicePartnerName,br.brnch_id branch,concat(brnch_cd,'-',brnch_nam) as branchName,srvc_prtnr_ldgr_nam as servicePartnerLedgerName,zp_cd_zp as zipCode,crdt_dys_offrd as creditDaysOffered,case when sp.actv_bt is null then false  when  sp.actv_bt ='1' then true when sp.actv_bt='0' then false  end  as active,addrs1_add as address,c.cty_id as city,c.cty_nam as cityName,rgn_cd as region,cntry_cd as country,prsn_to_cntct as personToContact,dsgntn designation,  eml_id_eml as emailId,phn_no_phn as landLineNo,mbl_no_mob as mobileNo,skyp_id as skypeId,wbst_nam as website,srvc_prtnr_dscrptn as servicePartnerDescription,sp.pan_no as pANNo,spt.dflt_typ_id as defaultType,spt.dflt_typ_nam as defaultTypeName,prtnr_clssfctn_id as partnerClassification,case when prtnr_clssfctn_id= 57 then 'TAXABLE'    when  prtnr_clssfctn_id= 58 then 'NON-TAXABLE'  when prtnr_clssfctn_id= 81 then 'EXEMPTED' end     as type1,sp.gstn_stt_cd gSTNStateCode,concat(s.gstn_stt_cd,'-',s.stt_nam) as stateName,exmptn_udr exemptionUnder,sales_person as salesPerson,emp_id as id,concat(emp_id,'-',emp_name) as salesPerson1,sp.gstn_no as gSTNNo,sp.crtd_by as createdBy,to_char(sp.crtd_dt,'dd/mm/yyyy') as createdDate,sp.mdfd_by as modifedBy,to_char(sp.mdfd_dt,'dd/mm/yyyy') as modifiedDate, sundry_type as sundryStatus,case when sundry_type= '20000003' then 'Creditors - Local'    when  sundry_type= '20010003' then 'Creditors - Overseas'  when  sundry_type= '10010004' then 'Debtors - Local'  when  sundry_type= '10080002' then 'Debtors - Overseas'  end     as sundryStatus1  from service_partner sp  left join branch br on br.brnch_id=sp.brnch_id left join city c on c.cty_id=sp.cty_id left join  service_partner_type spt on spt.dflt_typ_id=sp.dflt_typ_id left join state s on sp.gstn_stt_cd = s.gstn_stt_cd::int  left join employee_master em on em.emp_id= sp.sales_person where srvc_prtnr_bin= ?";

	
	public static final String DELETESERVICEPARTNER = "delete from service_partner where srvc_prtnr_bin =?";

	public static final String GETCOUNTRYLIST = "select cntry_cd as id,cntry_nam as text from country";

	public static final String UPDATE_USER_MASTER = "update user_master set user_id=?,user_name=?,user_ref_id_emp=?,active_inactive=? where user_id=?";

	public static final  String SAVEKEYDETAILSSERVICEPARTNER = "insert into service_partner_key_contacts(ky_cntcts_bin,ky_cntct_nm,ky_dsgntn,eml_id,phn_no,mbl_no,skyp_id,cty_id,rmrks,srvc_prtnr_bin) values(?,?,?,?,?,?,?,?,?,(select max(srvc_prtnr_bin) from service_partner))";

	public static final String SAVEMAPDETAILSSERVICEPARTNER = "insert into service_partner_map(service_partner_id,service_partner_type_id,visible)values(?,?,?)";

	public static final String DELETEKEYDETAILSSERVICEPARTNER = "delete from service_partner_key_contacts where srvc_prtnr_bin =?";

	public static final String DELETEMAPDETAILSSERVICEPARTNER = "delete from service_partner_map where service_partner_id =?";

	public static final String DELETEKEYSERVICEPARTNER = "delete from service_partner_key_contacts where ky_cntcts_bin =?";

	public static final String DELETE_sale_details = "delete from srv_partner_emp_log where srvc_prtnr_bin =?";

	public static final String GETTYPELIST = "select dflt_typ_id as id,dflt_typ_nam as title,false as visible from service_partner_type";

	public static final String EDITKEYSERVICEPARTNER = "select ky_cntct_nm as contactName,ky_dsgntn as keyDesignation,eml_id as keyEmail,phn_no as keyLandLineNo ,mbl_no as keyMobileNo,skyp_id as keySkypeId,cty_id  as keyCityId,rmrks as remarks,srvc_prtnr_bin as servicePartnerId,ky_cntcts_bin as servicePartnerKeyId from service_partner_key_contacts where srvc_prtnr_bin=?";

	public static final String VIEWKEYSERVICEPARTNER = "select ky_cntct_nm as contactName,ky_dsgntn as keyDesignation,eml_id as keyEmail,phn_no as keyLandLineNo ,mbl_no as keyMobileNo,skyp_id as keySkypeId,c.cty_id  as keyCityId,c.cty_nam as cityName,rmrks as remarks,srvc_prtnr_bin as servicePartnerId,ky_cntcts_bin as servicePartnerKeyId from service_partner_key_contacts spkc left join city c on c.cty_id=spkc.cty_id where srvc_prtnr_bin=?";

	public static final String EDITMAPSERVICEPARTNER = "with tt as(select dflt_typ_id as id,dflt_typ_nam as title from service_partner_type )select tt.id,tt.title,case when (select visible from service_partner_map  where service_partner_id= ? and tt.id =service_partner_type_id)=true then true else false end as visible from tt";

	public static final String VIEWMAPSERVICEPARTNER = "with tt as(select dflt_typ_id as id,dflt_typ_nam as title from service_partner_type )select tt.id,tt.title,case when (select visible from service_partner_map  where service_partner_id= ? and tt.id =service_partner_type_id)=true then true else false end as visible from tt";

	
	public static final String GETBRANCHLIST = "select brnch_id as id,concat(brnch_cd,'-',brnch_nam) as text from branch ";

	public static final String GETDEFAULTTYPELIST = "select dflt_typ_id as id,dflt_typ_nam as text from service_partner_type";

	public static final String GETCITYLIST = "select cty_id as id,cty_nam as text from city";

	public static final String GETREGIONLIST = "select rgn_cd as id,rgn_nam as text from region";


	public static final String GETGSTNSTATELIST = "select gstn_stt_cd as id,concat(gstn_stt_cd,'-',stt_nam) as text from state where gstn_stt_cd is not null";

	public static final String COUNT = "select max(srvc_prtnr_bin) from service_partner";

	public static final String KEYCOUNT = "select coalesce(max(ky_cntcts_bin),0)+1 from service_partner_key_contacts";
	
	public static final String EDITSALES="select srvc_prtnr_bin as servicePartnerId,(select emp_name from employee_master e where e.emp_id=sp.sales_person) as salesPerson,to_char(start_date,'dd/mm/yyyy') as createdDate,to_char(exp_date,'dd/mm/yyyy')as ToDate from srv_partner_emp_log sp where srvc_prtnr_bin = ? order by  exp_date ASC";

	public static final String VIEWSALES="select srvc_prtnr_bin as servicePartnerId,(select emp_name from employee_master e where e.emp_id=sp.sales_person) as salesPerson,to_char(start_date,'dd/mm/yyyy') as createdDate,to_char(exp_date,'dd/mm/yyyy')as ToDate from srv_partner_emp_log sp where srvc_prtnr_bin = ? order by  exp_date ASC";

	public static final String CHECK_CUSTOMER_ACCT_HEAD = "SELECT distinct CASE WHEN count(*)=0  THEN '0001' ELSE  lpad(cast(cast((SUBSTRING((select max(acct_head_code) from service_partner where acct_head_code~*?),5)) as int)+1  as text),4,'0') END FROM service_partner where acct_head_code~*?";

	public static final String Get_emplyee_Id = "select  count(emp_id)  from employee_master where emp_name =?";

	public static String select_previous_id="select max(srvc_prtnr_bin)  from service_partner";
	
	//salesperson
    public static String SAVE_SALES_TABLE="insert into srv_partner_emp_log values(?,?,now())";
	
	public static String OLD_SERVICE_PERSON ="select sales_person as oldSalePerson from  srv_partner_emp_log where srvc_prtnr_bin = ? order by start_date desc  limit 1";
	
	public static String UPDATE_TO_DATE ="update srv_partner_emp_log set exp_date= now() where sales_person = ? and srvc_prtnr_bin= ? ";
	
	
	//kyc
		public static final String INSERT_CUSTOMER_COMM_DETAIL = "insert into service_partner_kyc (MLO_COMM_ID ,srvc_prtnr_cd,MLO_SUBJECT,MLO_ASSIGNED_TO,mlo_booking_contact_person,mlo_pricing_contact_person,mlo_operation_contact_person,mlo_finance_contact_person,mlo_booking_email,mlo_pricing_email,mlo_operation_email,mlo_finance_email, mlo_contact_tel_num,mlo_contact_fax_num,CREATED_BY) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		public static String GET_MLOCOMMID = "SELECT distinct 'SPC'||CASE WHEN (select count(MLO_COMM_ID ) from service_partner_kyc where MLO_COMM_ID~*'SPC') =0  THEN '00001' ELSE  lpad(cast(cast((SUBSTRING((select max(MLO_COMM_ID) from service_partner_kyc where MLO_COMM_ID~*'SPC'),4)) as int)+1  as text),5,'0') END FROM (select 1) as t";

		public static final String SELECT_CUSTOMER_COMM_DETAIL = "select MLO_COMM_ID as customCommId,srvc_prtnr_cd as customId ,MLO_SUBJECT as subject,MLO_ASSIGNED_TO as assignedTo ,mlo_booking_contact_person as bookingCntctPrsn,mlo_pricing_contact_person as pricingCntctPrsn,mlo_operation_contact_person as operationsCntctPrsn ,mlo_finance_contact_person as financeCntctPrsn,mlo_booking_email as  bookingCntctPrsnEmail, mlo_pricing_email as pricingCntctPrsnEmail ,mlo_operation_email as operationsCntctPrsnEmail,mlo_finance_email as financeCntctPrsnEmail,mlo_contact_tel_num as teleNumber, mlo_contact_fax_num as faxNum from service_partner_kyc where srvc_prtnr_cd = ?";

		public static final String UPDATE_CUSTOMER_COMM_DETAIL = "update service_partner_kyc set MLO_SUBJECT=?,MLO_ASSIGNED_TO=?,mlo_booking_contact_person=?,mlo_pricing_contact_person=?,mlo_operation_contact_person=?,mlo_finance_contact_person=?,mlo_booking_email=?,mlo_pricing_email=?,mlo_operation_email=?,mlo_finance_email=?,mlo_contact_tel_num=?,mlo_contact_fax_num=?,modified_by = ? where MLO_comm_id = ? and srvc_prtnr_cd = ?";

		public static final String DELETE_CUSTOMER_COMM_DETAIL = "delete from service_partner_kyc where MLO_COMM_ID = ? and srvc_prtnr_cd =?";

		public static final String DELETEUSERMASTER = "delete from user_master where user_id=(select srvc_prtnr_cd from  service_partner where srvc_prtnr_bin =?)";

		public static final String COUNTSERVICEPARTNERCODE = "select count(*) from service_partner where upper(srvc_prtnr_cd)=upper(?) ";
		
		public static final String COUNTGST = "select count(*) from service_partner where gstn_no is not null and gstn_no!='' and upper(srvc_prtnr_cd)=upper(?) ";
		
		public static final String COUNT_NAME = "select count(*) from service_partner  where upper(srvc_prtnr_nam)=upper(?) ";
		
		public static final String COUNTSERVICEPARTNERCODEUPDATE = "select count(*) from service_partner where upper(srvc_prtnr_cd)=upper(?) and srvc_prtnr_bin not in(?)";
		public static String GET_STATE_ID="select stt_id as stateId from city where cty_id=?";
		public static String COUNTRYLIST="select (select cntry_cd from country c where c.cntry_id=s.cntry_id) as text from state s where stt_id=?";
		public static String RegionLIST="select (select rgn_cd from region r where r.rgn_id=c.rgn_id) as text from country c where cntry_cd=?";
		public static String cust_name = "select count(*) from service_partner where upper(srvc_prtnr_nam)=upper(?) ";

		public static String GET_Branch = "select brnch_id as Branch from  branch where upper(trim(brnch_nam)) = upper(?) limit 1";
		public static String GET_City = "select  cty_id from city where upper(trim(cty_nam)) = upper(?) limit 1";
		public static String GET_sales ="select emp_id from employee_master where upper(trim(emp_name)) = upper(?) limit 1";
		public static String GET_defult = " select dflt_typ_id from service_partner_type where  upper(trim(dflt_typ_nam)) = upper(?) limit 1";
		public static String email = "select count(*) from service_partner where upper(trim(eml_id_eml))=upper(?) limit 1 ";
		public static String GET_gste = "select  gstn_stt_cd from state where upper(stt_nam) = upper(?) limit 1";
		
		public static final String GET_Branch_cnt = "select count(*) from branch where upper(trim(brnch_nam))=upper(?) ";
		public static final String GET_City_cnt = "select count(*) from city  where upper(trim(cty_nam))=upper(?) ";
		public static final String GET_sales_cnt = "select count(*) from employee_master  where upper(trim(emp_name))=upper(?) ";
		public static final String GET_defult_cnt = "select count(*) from service_partner_type  where upper(trim(dflt_typ_nam))=upper(?) ";
		public static final String GET_customer_type = "select dflt_typ_id from service_partner_type where upper(trim(dflt_typ_nam))=upper(?) limit 1";
		public static final String GET_customer_cnt = "select count(*) from service_partner_type where upper(trim(dflt_typ_nam)) = upper(?)";

		
		public static final String SAVESERVICEPARTNERnew(String activBit,String cstbin,String expbin,String impbin,String shipbin,String consbin,String linbin,String airlinbin,String fribin,String cussbin,String transbin,String slotbin,String leasebin,String conmanubin,String cfsbin,String agebin,String depobin,String iatabin,String vndrbin )
		{
			String str= "insert into service_partner(srvc_prtnr_bin,srvc_prtnr_cd,srvc_prtnr_nam,brnch_id,srvc_prtnr_ldgr_nam,crdt_dys_offrd,actv_bt,addrs1_add,cty_id,rgn_cd,cntry_cd,zp_cd_zp,prsn_to_cntct,dsgntn,eml_id_eml,phn_no_phn,mbl_no_mob,skyp_id,wbst_nam,srvc_prtnr_dscrptn,pan_no,dflt_typ_id,prtnr_clssfctn_id,gstn_stt_cd,exmptn_udr,sales_person,gstn_no,crtd_by,crtd_dt,mdfd_by,mdfd_dt,acct_head_code,cstmr_bt,exprtr_bt,imprtr_bt,shppr_bt,cnsgn_bt,lnrs_bt,ar_lnr_bt,frght_frwdr_bt,cha_bt,trnsprtr_bt,slt_oprtr_bt,lsng_cmpny_bt,cntnr_mnfctr_bt,cfs_bt,dlvry_agnt_bt,dpt_bt,iata_agnt_bt,vndr_bt,sundry_type,SRVC_PRTNR_ID,credit_amt,credit_days)values((select coalesce(max(srvc_prtnr_bin),0)+1 from service_partner),?,?,?,?,?,(B'"+activBit+"')::bit(1),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,now(),?,(B'"+cstbin+"')::bit(1),(B'"+expbin+"')::bit(1),(B'"+impbin+"')::bit(1),(B'"+shipbin+"')::bit(1),(B'"+consbin+"')::bit(1),(B'"+linbin+"')::bit(1),(B'"+airlinbin+"')::bit(1),(B'"+fribin+"')::bit(1),(B'"+cussbin+"')::bit(1),(B'"+transbin+"')::bit(1),(B'"+slotbin+"')::bit(1),(B'"+leasebin+"')::bit(1),(B'"+conmanubin+"')::bit(1),(B'"+cfsbin+"')::bit(1),(B'"+agebin+"')::bit(1),(B'"+depobin+"')::bit(1),(B'"+iatabin+"')::bit(1),(B'"+vndrbin+"')::bit(1),?,?,?,?)returning srvc_prtnr_bin";
		     return str;
		}


		public static String SAVESERVICEPARTNERnwpar(String activBit, String cstbin, String expbin, String impbin,
				String shipbin, String consbin, String linbin, String airlinbin, String fribin, String cussbin,
				String transbin, String slotbin, String leasebin, String conmanubin, String cfsbin, String agebin,
				String depobin, String iatabin, String vndrbin) {
			// TODO Auto-generated method stub
			String str= "insert into service_partner(srvc_prtnr_bin,srvc_prtnr_cd,srvc_prtnr_nam,brnch_id,srvc_prtnr_ldgr_nam,crdt_dys_offrd,actv_bt,addrs1_add,cty_id,rgn_cd,cntry_cd,zp_cd_zp,prsn_to_cntct,dsgntn,eml_id_eml,phn_no_phn,mbl_no_mob,skyp_id,wbst_nam,srvc_prtnr_dscrptn,pan_no,dflt_typ_id,prtnr_clssfctn_id,gstn_stt_cd,exmptn_udr,sales_person,gstn_no,crtd_by,crtd_dt,mdfd_by,mdfd_dt,acct_head_code,cstmr_bt,exprtr_bt,imprtr_bt,shppr_bt,cnsgn_bt,lnrs_bt,ar_lnr_bt,frght_frwdr_bt,cha_bt,trnsprtr_bt,slt_oprtr_bt,lsng_cmpny_bt,cntnr_mnfctr_bt,cfs_bt,dlvry_agnt_bt,dpt_bt,iata_agnt_bt,vndr_bt,sundry_type,SRVC_PRTNR_ID,credit_amt,credit_days)values((select coalesce(max(srvc_prtnr_bin),0)+1 from service_partner),?,?,?,?,?,(B'"+activBit+"')::bit(1),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,now(),?,(B'"+cstbin+"')::bit(1),(B'"+expbin+"')::bit(1),(B'"+impbin+"')::bit(1),(B'"+shipbin+"')::bit(1),(B'"+consbin+"')::bit(1),(B'"+linbin+"')::bit(1),(B'"+airlinbin+"')::bit(1),(B'"+fribin+"')::bit(1),(B'"+cussbin+"')::bit(1),(B'"+transbin+"')::bit(1),(B'"+slotbin+"')::bit(1),(B'"+leasebin+"')::bit(1),(B'"+conmanubin+"')::bit(1),(B'"+cfsbin+"')::bit(1),(B'"+agebin+"')::bit(1),(B'"+depobin+"')::bit(1),(B'"+iatabin+"')::bit(1),(B'"+vndrbin+"')::bit(1),?,?,?,?)returning srvc_prtnr_bin";
		     return str;
		}


		
}
