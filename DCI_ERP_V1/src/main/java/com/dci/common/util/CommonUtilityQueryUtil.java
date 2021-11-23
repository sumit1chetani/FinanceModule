package com.dci.common.util;

import org.springframework.jdbc.core.PreparedStatementCreator;

import com.dci.common.model.CommonUtilityBean;


public class CommonUtilityQueryUtil {
	
	
	public static String get_surcharge = "select sur_code as id, concat(sur_short_name,'-',sur_name)  as text from surcharge_master  where loc_chr_id='Y'";
	
	public static String get_surcharge1 = "select acct_head_code as id,CONCAT(acct_head_code,'-',acct_head_name) as text  from account_head_master  where acct_head_code like '5%'";
	public static String GET_PORT_LIST_PORT = "SELECT distinct portcode as id,portcode||' - '||portname as text,portname FROM PORT_MASTER where isactive = 'Y' and  porttype = 'Port' order by portcode";

	 
		public static String get_stuff ="select stuff_type as id,concat (stuff_type, '-', description) as text from stuffing_type";
	    
		public static String get_agentvendor = "select vendor_code as id,concat(vendor_shrt_name,'-',vendor_name) as text from vendor_master where agent='Y'      ";
	public static String gate_out="select go_no as id,go_no as text from gate_out_hdr"; 
	
	public static String get_container="select container_id as id,container_number as text from  container";

	public static String get_voyage = "select vesselid as id,voyageno as text  from tb_voyage ";

	public static String get_vessel = "select vesselcode as id , vesselname as text from tb_vessels";

    public static String get_agent = "select srvc_prtnr_bin as id,concat(srvc_prtnr_cd,'-',srvc_prtnr_nam) as text from vendor_master_new order by srvc_prtnr_cd";

	public static String get_Customer = "select  acct_head_code as id,srvc_prtnr_cd ||' - '||srvc_prtnr_nam as text from service_partner  where sundry_type like '%1008%' order by srvc_prtnr_nam";

	public static String get_Supplier = "select ACCT_HEAD_CODE  as id, (ACCT_HEAD_CODE ||  ' - ' || VENDOR_NAME) as text from vendor_master where vendor_active='Y'";

	public static String get_SHIPMENT=" select const_code as id ,const_code as text  from sys_const  where const_grp='QT' order by const_code";
	
	public static String get_con="select container_type as id ,container_type as text  from m_container_type   order by container_type";
	
	public static String GET_CON_SIZE="select distinct container_length as id ,container_length as  text from m_container_type order by container_length";
	
	public static String get_charge="select sur_code as id ,sur_name as text  from surcharge_master WHERE sur_no LIKE '400%'";

			
			//"select sur_code as id ,sur_name as text from surcharge_master";
	
	//public static String get_currency="select currency_code as id,concat(currency_code,' - ',currency_name) as text  from currency_master"; 
	public static String get_currency="select crrncy_id as id,concat(crrncy_cd,' - ',crrncy_nam) as text  from currency"; 

	public static String get_cust="select srvc_prtnr_bin as id,concat(srvc_prtnr_cd,' - ',srvc_prtnr_nam) as text  from service_partner  where actv_bt  ='1' order by  srvc_prtnr_nam asc";
	
	public static String get_cust_short_Name="select cust_short_name as id,concat(cust_short_name,' - ',cust_name) as text  from customer_master where active ='T'";
	
/*	public static String get_cust_acct_head="select acct_head_code as id,concat(acct_head_code,' - ',cust_name) as text  from customer_master where active ='T'";
*/
	public static String get_cust_acct_head="select acct_head_code as id,concat(acct_head_code,' - ',cust_name) as text  from customer_master ";
	
	public static String get_vendor_acct_head="select acct_head_code as id,concat(acct_head_code,' - ',vendor_name) as text  from vendor_master ";
	
	public static String serviceIdandName = " SELECT sector_code,sector_name,sec_company_code " + " FROM sector_master order by sector_name";

	public static String GET_PORT_LIST = " select prt_icd_id::text as id,concat(prt_icd_cd,'-',prt_icd_nam) as text from port_icd where actv_bt ='1' order by prt_icd_nam asc";
	
//	public static String GET_PORT_LIST = "select  concat(port,'-',s.port_seq) as id,concat(port,'-',s.port_seq) as text from tb_sof_1 s inner join port_master pm on  s.port=pm.portcode where pm.isactive = 'Y' order by s.port_seq";
	
//	public static String GET_POL_LIST = "select  concat(port,'-',s.port_seq) as id,concat(port,'-',s.port_seq) as text from tb_sof_1 s inner join port_master pm on  s.port=pm.portcode where pm.isactive = 'Y' order by s.port_seq";
	
	public static String GET_POL_LIST = " SELECT distinct prt_icd_id as id,prt_icd_cd||' - '||prt_icd_nam as text FROM PORT_icd where actv_bt = '1' ";

	public static String GET_TERMINAL_LIST = "SELECT distinct terminal_code as id,concat(terminal_name,'-',terminal_code)as text FROM terminal_master where is_active = 'Y' order by terminal_code";

//	public static String GET_CNTR_TYPE_LIST = "select distinct const_code as id,const_code||' - '||const_desc as text from sys_const where const_grp ='CT' order by const_code ";
	
	public static String GET_CNTR_TYPE_LIST="select container_type as id ,container_type as text  from m_container_type   order by container_type";

	public static String LEASE_AGGREMENT_TYPE_LIST = "select distinct const_code as id,const_desc as text from sys_const  where const_grp ='LA' order by const_code ";

	public static String sGetPhcContainerList = "select CONTAINER_TYPE from phc_container_type order by CONTAINER_TYPE";
	
	public static String getSlot = " select mlo_code as id,mlo_short_name as text from mlo_master where slot_type='Y' order by mlo_short_name ";
	
	public static String getSubSlot = " select cust_code as id,cust_short_name as text from customer_master where is_sub_slot='Y' order by cust_short_name ";

	public static String sGetAccountHeadList = "SELECT ACCT_HEAD_NAME, ACCT_HEAD_CODE, ACCT_CURRENCY, coalesce(cast(ACCT_EXCHANGE_RATE as double precision),0) EXCHANGE_RATE from ACCOUNT_HEAD_MASTER ORDER BY ACCT_HEAD_NAME ASC";

	public static String sGetAccountHeadListdata = "select distinct chrg_hd_nam ACCT_HEAD_NAME, chrg_hd_id::varchar ACCT_HEAD_CODE, chrg_hd_cd ACCT_CURRENCY , chrg_hd_grp_id::numeric  EXCHANGE_RATE from charge_head ORDER BY ACCT_HEAD_NAME ASC";
	
	/*
	 * public static final String sGetSubAccountList =
	 * "select ACCT_HEAD_CODE as id , ACCT_HEAD_CODE ||  ' - ' || Payer_name as text from payer_master where Payer_name is not null  union "
	 * +"	 select ACCT_HEAD_CODE as id, ACCT_HEAD_CODE ||  ' - R' || srvc_prtnr_cd as text from VENDOR_MASTER_new where srvc_prtnr_nam  is not null "
	 * +"	 union SELECT ACCT_HEAD_CODE as id,ACCT_HEAD_CODE ||  ' - ' || CUST_NAME as text from customer_master where CUST_CODE is not null and active = 'Y'"
	 * ;
	 */
	
	//public static final String sGetSubAccountList = "select srvc_prtnr_bin as id,concat(srvc_prtnr_cd,'-',srvc_prtnr_nam) as text from service_partner  where cstmr_bt='1' order by srvc_prtnr_cd";
		
	public static final String sGetSubAccountList = "select subAccountCode, subAccountCode||'-'|| subAccountName as subAccountName from (  select supplier_acct_code subAccountCode, entity_name subAccountName from entity where is_vendor='t' AND  (supplier_acct_code!=NULL OR supplier_acct_code!='')) AS subacc where subAccountCode IS  Not null ORDER BY subaccountname asc";

	public static final String CUSTOMER_LIST_ACCT_CODE = "SELECT ACCT_HEAD_CODE as id,ACCT_HEAD_CODE ||  ' - ' || CUST_NAME as text from customer_master where CUST_CODE is not null and active = 'Y'";
 
	public static final String sGetSubAccountList_GL = "select srvc_prtnr_bin as id,srvc_prtnr_nam as text from service_partner where not null_or_empty(sundry_type)";
	
	public static String sGetAttributeList = "select ACCOUNT_CODE as accountCode,ATTRIBUTE_NAME as attributeName from ACCOUNT_ATTRIBUTE_MAPPING where ACCOUNT_CODE=? ";
			//+ " select ACCOUNT_CODE as accountCode,ATTRIBUTE_NAME as attributeName,is_mandatory as isMandatory from ACCOUNT_ATTRIBUTE_MAPPING where ACCOUNT_CODE=? ";

	public static String GET_EMPLOYEE_LIST = "select EMP_ID as id, EMP_NAME as text from EMPLOYEE_MASTER";

	public static String getPortISO_portList = " select   STRING_AGG(chr(39)||port_code ||chr(39),  ',' ORDER BY port_code) As id,port_iso_code as text from port_master where  PORT_STATUS = 'Y'  GROUP BY port_iso_code ORDER BY port_iso_code " ;

	public static String GET_DEPARTMENT_LIST = "select DEPT_CODE as id,DEPT_NAME as text from DEPARTMENT_MASTER_new";

	public static String GET_AGENT_LIST = "select srvc_prtnr_bin as id,srvc_prtnr_cd ||  ' - ' ||srvc_prtnr_nam as text from vendor_master_new inner join vendor_master_new_map vmm on vmm.vendor_master_new_id =srvc_prtnr_bin  WHERE vendor_master_new_type_id in ('1')";

	public static String GET_AGENT_LIST_FOR_AGENT_LOGIN = "select ACCT_HEAD_CODE as id,VENDOR_NAME as text from vendor_master WHERE ACCT_HEAD_CODE='VSIM0006' ";

	public static String GET_COUNTRY_LIST = "select country_code as id,country_name as text from country_master";

	public static String GET_DESIGNATION_LIST = "select DESGN_CODE as id,DESGN_NAME as text from DESIGNATION_MASTER_new";

	//public static String GET_CUSTOMER_LIST = "select cust_code as id,cust_name as text from customer_master  where active ='T' order by cust_name";
	public static String GET_CUSTOMER_LIST = "select srvc_prtnr_bin as id,concat(srvc_prtnr_cd,'-',srvc_prtnr_nam) as text from service_partner  where actv_bt ='1' order by srvc_prtnr_nam";

	public static String GET_EXCHANGE_RATE = "select value from (select VALUE from (select VALUE,EXDATE from EXCHANGE_RATE where currency=? ORDER BY EXDATE DESC) AS T1 limit 1)  t1 \n" + 
			"			UNION ALL (select '1.0' from DUAL  WHERE NOT EXISTS (select VALUE from EXCHANGE_RATE where currency=? ))";

	public static String GET_VOYAGE_LIST = "SELECT VOYAGEno id,VOYAGEno as text FROM tb_voyage order by VOYAGEno  ";
	
	public static String GET_VOYAGE_LIST_BY_VSL = "SELECT VOYAGEno id,VOYAGEno as text FROM tb_voyage where vesselid =? order by VOYAGEno";
	public static String GET_VOYAGE_LIST_BY_VSL_1 = "SELECT  id,VOYAGEno as text FROM tb_voyage where vesselid =? order by VOYAGEno";

	
	public static String GET_VOYAGE_BY_AGENT_VSL(String userPortStr) {
		String port="select distinct voyageno as id ,voyageno as text from tb_voyage join tb_sof_1 on voyageno=voyageid where vesselid = ? and port in ("+userPortStr+") order by voyageno desc";
		return port;
	}
	//public static String GET_PORT_LIST_BY_VOYAGE = "select concat(port,'-',s.port_seq) as id,concat(port,'-',s.port_seq) as text from tb_sof_1 s  left join port_master pm  on  s.port=pm.portcode where voyageid= ? order by  s.port_seq";
	public static String GET_PORT_LIST_BY_VOYAGE = " select concat(prt_icd_cd,'-',s.port_seq) as id,concat(prt_icd_cd,'-',prt_icd_nam) as text from tb_sof_1 s\n" + 
			" left join port_icd pm  on  s.port=pm.prt_icd_id::varchar   where voyageid=? order by  s.port_seq ";

	
	public static String GET_PORT_LIST_BY_VOYAGE1 = "select prt_icd_id as id,concat(prt_icd_cd,'-',prt_icd_nam) as text from tb_sof_1 vp inner join  port_icd pm on vp.port=pm.prt_icd_id::text where voyageid= ? order by port_seq::int ";

	public static final String GET_PORT_LIST_BY_VOY_WO_SEQ= "select distinct port_seq::integer,concat(port) as id,concat(port) as text from tb_sof_1   where  voyageid= ? "; 
			
	public static String GET_TRIP_LIST ="select mode_id as id, mode_name as text from job_transport order by mode_name";

	public static String GET_VESSEL_LIST = " select Vesselcode id,(Vesselcode || '-' || vesselname) as text from tb_vessels order by  Vesselcode ASC ";
	
	public static String GET_QUOTE_LIST = " select qttn_bin as id,qttn_no_tcd as text from sea_quotation where status ='Approved' ";
	
	
	public static String GET_LEASING_PARTY_LIST = "select distinct d.leasing_party,e.vendor_name as id,e.vendor_name as text from container_onhiredtl a "
													+ "inner join "
													+ "container_onhirehdr b on b.onhire_refno = a.onhire_refno " 
													+ "inner join "
													+ "onhire_releasehdr c on c.rel_refno = b.rel_refno "
													+ "inner join "
													+ "container_lease_agreement d on d.agreement_refno = c.agreement_ref_no "
													+ "inner join "
													+ "vendor_master e on e.vendor_code= d.leasing_party";

	public static String GET_SECTOR_LIST = " select sector_code id,sector_name as text from SECTOR_MASTER order by sector_name ";

	public static String GET_SUPPLIER_LIST = " select supplier_acct_code as id, entity_name as text FROM entity where is_vendor='t'and  (supplier_acct_code!=NULL OR supplier_acct_code!='') order by entity_name asc";
	// " select b.VENDOR_CODE id,b.VENDOR_NAME as text from vendor_master b,Currency_master c " + " where c.currency_code = b.VENDOR_CURR_CODE and vendor_active='Y' ORDER BY b.VENDOR_NAME ";
	public static String GET_COMPANY_LIST = "  select CU.COMPANY_CODE as id,CM.SHORT_NAME as text,IS_PRIMARY as baseCompany "
			+ " from COMPANY_USER CU left join COMPANY_MASTER CM on CM.COMPANY_CODE = CU.COMPANY_CODE " + " WHERE USER_ID=? ";

	//public static String GET_OWNERS_COMPANY = "select company_code from owners_company";
	public static String GET_OWNERS_COMPANY = "select company_code from company_master";
	public static String COMPANY_MASTER="select company_code from company_master";

	public static String sGetAccountSgList = " select ACCT_HEAD_CODE as id,ACCT_HEAD_NAME as text from ACCOUNT_HEAD_MASTER where SUBGROUP_ACCT_CODE =? ";

	public static String GET_SUBACCOUNT_TRADE_DEBTORS = "select ACCT_HEAD_CODE as id, (ACCT_HEAD_CODE ||  ' - ' || PAYER_NAME) as text from payer_master where PAYER_CODE is not null  and payer_active='Y'";


	public static String GET_SUBACCOUNT_TRADE_CREDITORS = " select ACCT_HEAD_CODE as id , ACCT_HEAD_CODE ||  ' - ' || Payer_name as text from payer_master where Payer_name is not null  and payer_active='Y'  union select ACCT_HEAD_CODE id, (ACCT_HEAD_CODE ||  ' - ' ||  srvc_prtnr_nam) as text from vendor_master_new where actv_bt='1' ";

	public static String GET_STAFF_LIST_OLD = "select emp_id as id,emp_name as text from employee_master  where emp_id is not null order by emp_name";

	public static String GET_SUBACCOUNT_TRADE_DEBTORS_CUSTOMER_ONLY = "	select cust_code as id,cust_code ||  ' - ' || cust_name as text from customer_master "
     +"   union all "
+" 	select vendor_code as id , vendor_code || '-' || vendor_name as text from  vendor_master  where agent='Y'";

	public static String GET_STAFF_LIST = "select ACCT_CODE as id,name as text from STAFF_MASTER where status='Y' order by ACCT_CODE";


	
	public static String GET_SUBACCOUNT_TRADE_DEBTORS_PAYERs_ONLY ="select acct_head_code as id ,acct_head_code ||  ' - ' ||srvc_prtnr_nam as text  from service_partner sp";
	
/*	public static String GET_SUBACCOUNT_TRADE_DEBTORS_PAYER_ONLY =  "select cust_code as id,cust_code ||  ' - ' || cust_name as text from customer_master "
   +"      union all "
  +"	select vendor_code as id , vendor_code || '-' || vendor_name as text from  vendor_master  where agent='Y' " ;
	
	*/
	
	
	public static String GET_SUBACCOUNT_TRADE_DEBTORS_PAYER_ONLY ="select acct_head_code as id,acct_head_code ||  ' - ' || cust_name as text from customer_master "
   +" union all "
	+"select acct_head_code as id , acct_head_code || '-' || vendor_name as text from  vendor_master  where agent='Y' " ;
	
		
	public static String GET_PAYER_BASED_ON_AGENT =" select ACCT_HEAD_CODE as id ,ACCT_HEAD_CODE ||  ' - ' || cust_name_NAME as text from customer_master where mlo_country_id= "
			+ " (select vendor_country_id from vendor_master  where acct_head_code  in (select acct_head_code from vendor_agent_mapping where emp_id=?))";

	public static String GET_VESSEL_SERVICE = "SELECT VESSEL_ID as vesselCode,SECTOR_ID as sectorCode FROM VOYAGE WHERE VOYAGE_ID=?";
	
	public static String GET_TRUCK_SERVICE = "select tm.truck_id as id, tm.license_plate as text from truck_master tm inner join truck_trailer_mapping ttm on ttm.truck_id = tm.truck_id inner join plan_trip pt on pt.truck_trailer_mapping_id = ttm.truck_trailer_mapping_id where pt.plan_trip_id = ?";

	public static String GET__DEFAULT_EXCHANGE_RATE = "select currency_default from currency where crrncy_cd = ? ";
		//	+ "select currency_default from currency_master where currency_code  =? ";

	//public static String GET_ASSET_LIST=" select ASSET_NO as id,ASSET_NAME as text from ASSET_MASTER_NEW ";
	
	public static String GET_ASSET_LIST=" select ASSET_NO as id,ASSET_NAME as text from ASSET_MASTER_NEW ";

	public static String GET_JV_PARTNER_LIST="select ACCT_HEAD_CODE as id,ACCT_HEAD_CODE ||'-'||VENDOR_NAME as text from VENDOR_MASTER WHERE VENDOR_TYPE ='Y'";

	public static String AGENT_ACCOUNT_ACCESS="SELECT acct_head_code accountHeadCode,acct_head_name accountHeadName,acct_currency currency,acct_exchange_rate exchangeRate "
			+ " from ACCOUNT_HEAD_MASTER where acct_head_code in('10080001', '10040001','20000001','20020002','20020006') ORDER BY  acct_head_code asc" ;

	public static String GET_SUPPLIER_CURRENCY ="select 'INR'::text currencyCode,'N'  as isAgent from vendor_master_new where  ACCT_HEAD_CODE=?";
			
		/*	"select VENDOR_CURR_CODE currencyCode,CASE WHEN vendor_type like '%A%' THEN 'Y' ELSE 'N' END as isAgent from vendor_master "
			+ "where  ACCT_HEAD_CODE=?";
*/
	/**
	 * Check Code/Name - return count 0/1
	 */
	public static final String CHECK_CURRENCY_CODE_EXISTS = "select count(CURRENCY_CODE) from CURRENCY_MASTER WHERE CURRENCY_CODE=? ";

	public static final String CHECK_CURRENCY_NAME_EXISTS = "select count(CURRENCY_NAME) from CURRENCY_MASTER WHERE CURRENCY_NAME=? ";

	public static final String CHECK_ACCOUNT_HEAD_NAME_EXISTS = "select count(ACCT_HEAD_NAME) from account_Head_master where acct_head_name=?";

	public static final String CHECK_SUB_GROUP_ACCT_NAME_EXISTS = "SELECT COUNT(SUB_GROUP_ACCT_NAME) FROM SUB_GROUP_ACCT_MASTER WHERE SUB_GROUP_ACCT_NAME=?";

	public static final String CHECK_CUSTOMER_NAME_EXISTS = "SELECT COUNT(cust_name) FROM customer_master WHERE cust_name=? ";

	public static final String CHECK_CASHBANK_NAME_EXISTS = "SELECT COUNT(BANK_NAME) FROM CASH_BANK_HDR WHERE BANK_NAME=?";

	public static final String CHECK_CONSIGNEE_NAME_EXISTS = "select COUNT(CONSIGNEE_NAME) from consignee where CONSIGNEE_NAME=?";

	public static final String CHECK_LEAD_NAME_EXISTS = "SELECT count(LEAD_NAME) FROM lead_master WHERE LEAD_NAME=?";

	public static final String GET_COST_CENTRE_LIST = "select cost_code as id,cost_centre_name as text from cost_centre order by cost_centre_name ASC ";

	public static final String GET_ACCOUNTHEAD_PREV_BALANCE = "select COALESCE(sum(COALESCE(debit,0))-sum(COALESCE(credit,0)),0) as accountPrevBalance from GENERAL_LEDGER where ACCOUNT_HEAD=?";

	public static final String GET_SURVEYOR_LIST = "select MANAGE_ID AS id, M_NAME AS text from MANAGE_SURVEYOR ORDER BY M_NAME ASC";

	public static final String GET_COMPANY_LOCATION_LIST = "select company_code AS id, location AS text from company_master order by location ASC";

	public static final String getCompanyLocationListForBunker = " select company_code AS id, location AS text from company_master where company_code in ('C0001','C0003','C0021') order by location ASC ";

	public static final String GET_EXCHANGE_RATE_WITH_CURR = "select currency_conver_from AS fromCurrency,currency_conver_to AS toCurrency,currency_default AS exchangeRate from currency where crrncy_cd=?";
	
	public static final String GET_EXCHANGE_RATE_BY_SAILING_DATE ="select round(value::NUMERIC,3) as exchangeRate, currency_conver_from fromCurrency,"
	+ "currency_conver_to toCurrency from vbusiness_associate v, CURRENCY_MASTER c,exchange_rate_table e"
	+ " where  c.CURRENCY_CODE = v.CURRENCY and c.CURRENCY_CODE=e.CURRENCY and c.CURRENCY_CODE=? AND EX_DATE=TO_DATE(?,'DD/MM/YYYY') limit 1";
	
	public static final String GET_EXCHANGE_RATE_BY_MAX_DATE ="select round(value::NUMERIC,3) as exchangeRate, currency_conver_from fromCurrency, "
			+ "currency_conver_to toCurrency from vbusiness_associate v, CURRENCY_MASTER c,exchange_rate_table e "
			+ "where  c.CURRENCY_CODE = v.CURRENCY and c.CURRENCY_CODE=e.CURRENCY and c.CURRENCY_CODE=? "
			+ "and EX_DATE = (select max(EX_DATE) from vbusiness_associate v, CURRENCY_MASTER c,exchange_rate_table e "
			+ "where  c.CURRENCY_CODE = v.CURRENCY and c.CURRENCY_CODE=e.CURRENCY and c.CURRENCY_CODE=?) limit 1";
	
	
	public static final String GET_SERVICE_ON_VESSEL="select vm.Vessel_code as id,(vm.Vessel_code || '-' || vessel_name) as text from vessel_service_master  vsm INNER JOIN vessel_master vm on vsm.vessel_Code=vm.vessel_Code Where sector_Code= ?  order by  vessel_name ";
	

	public static final String SELECT_DEF_TABLE_LIST = "SELECT def_table_id as id, value as text FROM def_table WHERE is_active=true and form_field_id = ?";
	
	public static String GET_EMP_LOCATION="select company_code from employee_master where emp_id=?";
	
	//public static final String GET_SUPPLIER_LIST_WITH_ACCOUNTCODE=" select acct_head_code as id, acct_head_code ||'-'|| vendor_name as text from vendor_master order by vendor_name ";
	
	public static final String GET_SUPPLIER_LIST_WITH_ACCOUNTCODE=" select srvc_prtnr_bin as id,concat(srvc_prtnr_cd,'-',srvc_prtnr_nam) as text from service_partner order by srvc_prtnr_cd asc ";
	
	public static final String getCustomer = "select cust_short_name as id,cust_short_name|| '-' || cust_name as text from customer_master where active = 'Y' order by  cust_name";

	public static String GET_SUR_PORT="select sur_name id,port as text,sur_id surchareId from surchare_port_rel";
	
	public static final String GET_SERVICE_LOCATION_NAME="select btrim(company_wise) as company	from VOYAGE where VOYAGE_ID= ? ";

	public static final String GET_COMPANY_WISE_SECTOR="select distinct sm.sec_company_code as id,short_name as text from company_master cm inner join sector_master sm on cm.company_code=sm.sec_company_code "
						 + " where cm.is_operation='Y' order by sm.sec_company_code"; 
	
	
	public static String getonlySupplier_creditors = "select ACCT_HEAD_CODE  as id, (ACCT_HEAD_CODE ||  ' - ' || srvc_prtnr_nam) as text from vendor_master_new where  actv_bt ='1'    ";
	public static String getonlySupplier_deptors = "select ACCT_HEAD_CODE  as id, (ACCT_HEAD_CODE ||  ' - ' || srvc_prtnr_nam) as text from service_partner where  actv_bt ='1'    ";

	public static String  getonlyTDSSupplier	= "select CUST_CODE  as id, (CUST_CODE ||  ' - ' || CUST_NAME) as text from CUSTOMER_MASTER";	

	public static String getonlyPayer = "select ACCT_HEAD_CODE as id, (ACCT_HEAD_CODE ||  ' - ' || PAYER_NAME) as text from payer_master where PAYER_CODE is not null  and payer_active='Y' ";
	
	public static String  vessel_list = "select vessel_code as id,vessel_code ||'-'|| vessel_name as text from vessel_master";
	
	public static String  staff_list = "select acct_code as id,acct_code ||'-'|| name as text from staff_master ";
	
	public static String jv_payer = "select ACCT_HEAD_CODE as id, (ACCT_HEAD_CODE ||  ' - ' || PAYER_NAME) as text from payer_master where PAYER_CODE is not null  and payer_active='Y' union select ACCT_HEAD_CODE id, (ACCT_HEAD_CODE ||  ' - ' || VENDOR_NAME) as text from vendor_master where vendor_active='Y'";
	
	public static String  TRIP_LIST = "select plan_trip_id as id, trip_no as text from plan_trip order by trip_no";
	
	public static String LOCATION="select location_code id,location_name as text from location order by location_code";
	
	public static String CHARGE_LIST="select chargetype_id id,chargetypecode||'-'||chargetypename as text from chargetype where is_active='t' order by chargetypecode";
	
	public static String GET_CURRENCY="select currency_code as id,currency_name as text from currency_master where currency_status  ='Y' order by currency_name";
	
	//inventory
	
	public static final String INSERT_STOCK_DATA_STOCK_IN = "INSERT INTO stock_transfer(stock_transfer_number, purchase_requisition_id, stock_transfer_date,  transport_type,service_name,person_name, " + "delivery_method,status,entity_id, stock_transfer_type, reason, source_location, destination_location,received_by,purchase_quote_id,consignment_in_id,stock_indent_id,company_id,vendor_id,stock_out_id) " + "VALUES (?, ?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?) returning stock_transfer_id";

	public static final String INSERT_STOCK_DATA = "INSERT INTO stock_transfer(stock_transfer_number, purchase_requisition_id, stock_transfer_date,  transport_type,service_name,person_name, " + "delivery_method,status,entity_id, stock_transfer_type, reason, source_location, destination_location,received_by,purchase_quote_id,consignment_in_id,stock_indent_id,company_id,vendor_id) " + "VALUES (?, ?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?) returning stock_transfer_id";

	public static final String UPDATE_STOCK_DATA = "UPDATE stock_transfer SET stock_transfer_number=?,purchase_requisition_id=?, stock_transfer_date=to_date(?,'dd/mm/yyyy'), transport_type=?, service_name=?,person_name=?, " + "delivery_method=?,status=?,entity_id=?, stock_transfer_type=?, reason=?, source_location=?, destination_location=?,received_by=?,purchase_quote_id=?,consignment_in_id=?,stock_indent_id=?,company_id=?,vendor_id=? WHERE stock_transfer_id=?";

	public static final String INSERT_STOCK_DETAIL_ASSET_DATA = "INSERT INTO stock_transfer_detail (purchase_requisition_detail_id, item_id, quantity, stock_transfer_id,pending_qty) values(?,?,?,?,?) returning stock_transfer_detail_id";
	
	public static final String INSERT_STOCK_DETAIL_DATA = "INSERT INTO stock_transfer_detail (purchase_requisition_detail_id, item_id, quantity, stock_transfer_id, pending_qty,amount) values(?,?,?,?,?,?) ";
	
	public static final String INSERT_STOCK_DETAIL_ASSET = "INSERT INTO stock_transfer_asset_detail (stock_transfer_detail_id, asset_detail_id) values(?,?)";
	
	public static final String INSERT_STOCK_DETAIL_DATA_CONSIGNMENT_OUT = "INSERT INTO stock_transfer_detail (purchase_requisition_detail_id, item_id, quantity, stock_transfer_id, pending_qty,amount) values(?,?,?,?,?,?) returning stock_transfer_detail_id";
	
	public static final String sGetTransferDetailId = "select stock_transfer_detail_id from stock_transfer_detail where stock_transfer_id = ?";
	
	public static final String DELETE_STOCK_BATCH_DETAIL = "delete from stock_transfer_batch_detail where stock_transfer_detail_id = ? ";
	
	public static final String UPDATE_STOCK_DETAIL_DATA1 = "UPDATE stock_transfer_detail SET purchase_requisition_detail_id=?, item_id=?, quantity=?,amount=?, stock_transfer_id=?,pending_qty=? WHERE stock_transfer_detail_id=?";
	
	public static final String INSERT_STOCK_BATCH_DETAIL_DATA = "insert into stock_transfer_batch_detail(stock_transfer_detail_id,item_id,batch_no,batch_qty,expiry_date,manufacturer,mrp_price,transfer_qty,pending_qty, receive_qty) values(?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?)";
	
	public static final String INSERT_STOCK_DETAIL__RETURN_DATA = "INSERT INTO stock_transfer_detail (item_id, quantity, stock_transfer_id, pending_qty,amount) values(?,?,?,?,?) returning stock_transfer_detail_id ";
	
	public static final String INSERT_STOCK_CONSIGNMENT_IN_DETAIL_DATA = "INSERT INTO stock_transfer_detail (purchase_requisition_detail_id, item_id, quantity, stock_transfer_id, pending_qty,amount,batch_number,batch_pending_quantity,vendor_qty) values(?,?,?,?,?,?,?,?,?)";
	
	public static final String delete_STOCK_DETAIL_ASSET = "delete from stock_transfer_asset_detail where stock_transfer_detail_id =?";
	
	public static final String DELET_STOCK_DETAIL_DATA = "DELETE FROM stock_transfer_detail where item_id=? and stock_transfer_detail_id=?";
	
	public static final String UPDATE_STOCK_DETAIL_DATA = "UPDATE stock_transfer_detail SET purchase_requisition_detail_id=?, item_id=?, quantity=?, stock_transfer_id=? WHERE stock_transfer_detail_id=?";
	
	public static final String UPDATE_CONSIGNMENT_IN_DETAIL_DATA = "UPDATE stock_transfer_detail SET purchase_requisition_detail_id=?, item_id=?, quantity=?, stock_transfer_id=? ,batch_number=?,batch_pending_quantity=?,vendor_qty=? WHERE stock_transfer_detail_id=?";
	
	public static final String UPDATE_STOCK_DETAIL_STOCK_IN_DATA = "UPDATE stock_transfer_detail SET purchase_requisition_detail_id=?, item_id=?, quantity=?,  amount=?, stock_transfer_id=? WHERE stock_transfer_detail_id=?";
	
	public static final String DELETE_STOCK_DETAIL = "DELETE FROM stock_transfer_detail WHERE stock_transfer_id = ?";
	
	public static final String DELETE_STOCK_HEADER = "DELETE FROM stock_transfer WHERE stock_transfer_id = ?";
	
	public static final String STOCK_NUMBER_AUTO_GEN = "SELECT CASE WHEN MAX(stock_transfer_number) IS NULL  THEN ? ELSE rpad(MAX(stock_transfer_number),3,?)|| " + " lpad(cast(cast((SUBSTRING(MAX(stock_transfer_number),4)) as int)+1  as text),4,'0') END as stock_number FROM stock_transfer" + " where stock_transfer_number like ? ";
	
	public static final String GET_ITEM_LOC_AVAILABILITY = "select count(*) stockQty from inventory  WHERE location_id=? and item_id=?";
	
	public static final String GET_STOCK_AVAILABILITY = "select coalesce(quantity_available,0) stockQty from inventory  WHERE location_id=? and item_id=? ";
	
	public static final String GET_RECEIVED_LIST = "select stock_received_id receivedId,stock_received_number receivedNo,rcvd.stock_transfer_id transferId,stock_transfer_number transferNo,to_char(stock_transfer_date,'dd/mm/yyyy') transferDate,s.location_name sourceLocName,d.location_name destLocName,to_char(stock_received_date,'dd/mm/yyyy') receivedDate,rcvd.received_by receivedByCode,first_name receivedByName from stock_transfer_received rcvd left join stock_transfer st on rcvd.stock_transfer_id = st.stock_transfer_id left join employee_master e on e.emp_id =rcvd.received_by left join store_location s on s.location_id=source_location left join store_location d on  d.location_id=destination_location where stock_received_number like ? order by stock_received_id desc";
	
	public static final String get_Transfer_Receive_id = "select stock_transfer_id from stock_transfer where stock_transfer_number =?";
	
	public static final String get_Transfer_Status = "select status from stock_transfer where stock_transfer_id = ?";

	public static final String get_Transfer_Delivery_Method = "select delivery_method from stock_transfer where stock_transfer_id = ?";
	
	public static final String GET_STOCK_NUMBER = "SELECT CASE WHEN MAX(stock_received_number) IS NULL  THEN ? ELSE rpad(MAX(stock_received_number),3,?)||  lpad(cast(cast((SUBSTRING(MAX(stock_received_number),4)) as int)+1  as text),4,'0') END as receivedNo  FROM stock_transfer_received where stock_received_number like ?";
	
	public static final String get_transfer_object = "select source_location as sourceLocId ,destination_location  as destLocId from stock_transfer where stock_transfer_number =?";

	public static final String get_Transfer_item_list = "select item_id as itemId , stock_transfer_detail_id  as stockTransferDetailId , quantity as receivedQty from stock_transfer_detail where stock_transfer_id =?";

	public static final String get_Batch_Transfer_Batch_list = "select item_id as itemId , transfer_qty as receivedQty,transfer_qty as  batchQty,transfer_qty as receiveQty, batch_no as batchNo, stock_transfer_batch_detail_id stockTransferBatchDetailId  from stock_transfer_batch_detail where stock_transfer_detail_id=?";
	
	public static final String SAVE_TRANS_RECIVED = "INSERT INTO stock_transfer_received( stock_received_number, stock_transfer_id, stock_received_date, received_by, received_note,company_id) VALUES (?, ?, to_date(?,'dd/mm/yyyy'), ?, ?,?) returning stock_received_id";
	
	public static final String Check_Transfer_Receive_No = "select count(*) from stock_transfer where stock_transfer_number=?";

	public static final String check_Transfer_inReceice = "select count(*) from stock_transfer where stock_transfer_number=? and stock_transfer_id  in (select stock_transfer_id from  stock_transfer_received) ";
	
	public static final String UPDATE_TRANSFER_BATCH_DTL = "update stock_transfer_batch_detail set receive_qty =?  where stock_transfer_batch_detail_id =?";

	public static final String UPDATE_TRANSFER_STATUS = "update stock_transfer set status =? where stock_transfer_id =? ";	

	public static final String SAVE_TRANS_RECIVED_DTL = "INSERT INTO stock_transfer_received_detail(stock_received_id, item_id, transfer_qty, received_qty, pending_qty) VALUES (?, ?, ?, ?, ?) returning stock_received_detail_id";

	public static final String SAVE_TRANS_RECIVED_BATCH_DTL = "INSERT INTO stock_transfer_received_batch_detail(stock_received_detail_id, item_id, batch_no,batch_qty, expiry_date, mrp_price,pending_qty,receive_qty) VALUES (?, ?, ?, ?, ?,?,?,?) returning stock_transfer_received_batch_detail_id";

	public static final String UPDATE_TRANSFER_DTL = "update stock_transfer_detail set pending_qty =? where stock_transfer_id =? and item_id =?";
	
	public static final String GET_ITEM_TYPE = "select item_type from item where item_id=?";
	
	public static final String HEADER_TRANSFER_RECEIVE_VIEW = "select stock_received_number receivedNo,coalesce(company_name,'') companyName,to_char(stock_received_date,'DD/MM/YYYY') receivedDate,str.received_by receivedByName,received_note receivedNote,stock_transfer_number transferNo,coalesce(requested_by,'') requestedBy,to_char(stock_transfer_date,'DD/MM/YYYY')transferDate, coalesce(s.location_id,0) sourceLocId,coalesce(s.location_name,'') sourceLocName,coalesce(d.location_id,0) destLocId,coalesce(d.location_name,'') destLocName from stock_transfer_received str inner join stock_transfer st on str.stock_transfer_id = st.stock_transfer_id left join company_master c on str.company_id = c.company_code left join store_location s on s.location_id=source_location left join store_location d on  d.location_id=destination_location left join  purchase_requisition pr on pr.purchase_requisition_id = st.purchase_requisition_id  where stock_received_id =?";

	public static final String DETAIL_TRANSFER_RECEIVE_VIEW = "select ga.batch_no as isBatchNoExist,strd.stock_received_detail_id, strd.item_id itemId,item.item_id as id,concat(item.item_code,' - ',item.item_name) as text,item_code as itemCode,item_name as itemName,coalesce(transfer_qty,0) as transferQty,coalesce(received_qty,0) receivedQty,coalesce(pending_qty,0) pendingQty from stock_transfer_received_detail strd inner join item on item.item_id=strd.item_id left join item_grn_attribute ga on ga.item_id = item.item_id where strd.stock_received_id =?";

	public static final String SELECT_TRANSFER_RECEIVE_VIEW_BATCH = "select strbd.stock_transfer_received_batch_detail_id,strbd.item_id,strbd.batch_no,coalesce(strbd.receive_qty,0) receiveQty , i.item_name ,to_char(strbd.expiry_date,'DD/MM/YYYY') as expiry_date, coalesce(strbd.mrp_price,0) mrpPrice from stock_transfer_received_batch_detail as strbd inner join item i on i.item_id=strbd.item_id where strbd.stock_received_detail_id=?";


	public static final String GET_TRANSFER_NO = "select stock_transfer_id transferId,stock_transfer_id as id,stock_transfer_number transferNo,stock_transfer_number as text,coalesce(requested_by,'') requestedBy,to_char(stock_transfer_date,'DD/MM/YYYY')transferDate,coalesce(s.location_id,0) sourceLocId ,coalesce(s.location_name,'') sourceLocName,coalesce(d.location_id,0) destLocId,coalesce(d.location_name,'') destLocName from stock_transfer st left join store_location s on s.location_id=source_location left join store_location d on  d.location_id=destination_location left join purchase_requisition pr on pr.purchase_requisition_id = st.purchase_requisition_id where stock_transfer_type =? and (lower(status) in (?,?) or status is null) order by stock_transfer_number desc";
	
	public static final String GET_TRANSFER_ITEM = "select item.item_id itemId,item.item_id as id,concat(item.item_code,' - ',item.item_name) as text,item_code as itemCode,item_name as itemName,coalesce(quantity,0) as transferQty, " + " coalesce(pending_qty,0) pendingQty,ga.batch_no as isBatchNoExist " + " from stock_transfer_detail left join item on item.item_id=stock_transfer_detail .item_id " + "left join item_grn_attribute ga on ga.item_id = item.item_id " + " where stock_transfer_id=? and stock_transfer_detail.pending_qty > 0";
	
	public static final String GET_TRANSFER_BATCH_DETAIL = "select stbd.stock_transfer_batch_detail_id stockTransferBatchDetailId, stbd.item_id,i.item_name ,stbd.batch_no as batchNo,coalesce(stbd.receive_qty,0) as batchQty,coalesce(stbd.transfer_qty,0) as transferQty,to_char(stbd.expiry_date,'DD/MM/YYYY') as expiryDate ,coalesce(stbd.mrp_price,0)  as mrpPrice from stock_transfer as st " + "inner join  stock_transfer_detail as std on std.stock_transfer_id= st.stock_transfer_id " + "inner join item as i on i.item_id=std.item_id "
			+ "inner join stock_transfer_batch_detail as stbd on stbd.stock_transfer_detail_id=std.stock_transfer_detail_id " + "where st.stock_transfer_id=? and stbd.item_id=? and stbd.receive_qty > 0 ";

	public static final String CHECK_BATCH_DETAIL_ID = "select count(*) from stock_transfer_batch_detail where stock_transfer_detail_id=?";
	//inventory-ends
	public static final String GET_ENTITY_LIST = "select entity_id as id, entity_name as text FROM entity where is_vendor='t' order by entity_name asc";

	public static String GET_BATCH_DETAILS = "select item.item_name,stock_transfer_batch_detail.item_id,batch_qty as batchQty,batch_no batchNo from stock_transfer_batch_detail " + "inner join item on item.item_id= stock_transfer_batch_detail.item_id " + "where stock_transfer_detail_id=?";

	public static final String GET_TOTAL_TRANSFER_BATCHQTY = "select sum(coalesce(stock_transfer_batch_detail.transfer_qty ,0)) batchQty from stock_transfer_batch_detail " + "  inner join  stock_transfer_detail as std on std.stock_transfer_detail_id = stock_transfer_batch_detail.stock_transfer_detail_id " + "   inner join  stock_transfer as st on st.stock_transfer_id = std.stock_transfer_id " + "  where stock_transfer_batch_detail.batch_no=? " + "and stock_transfer_batch_detail.item_id=? and std.batch_no_id=? and st.status !='Pending' and "
			+ " (st.stock_transfer_number like 'CON%' or st.stock_transfer_number like 'CNO%') " + "group by stock_transfer_batch_detail.batch_no,stock_transfer_batch_detail.item_id,std.batch_no_id";

	public static final String INSERT_ADDRESS = "insert into address (city_id, street, created_by, created_date) values(?,?,?,current_date) returning address_id ";
	
	public static final String UPDATE_ADDRESS = "update address set city_id=?, street=?, modified_by=?, modified_date=current_date where address_id=?";

	public static final String MODE ="select mode_id as id,mode_name as text from job_transport";

	public static final String JOBORDERNO = "select jb_bin as id , jb_no_tcd as text from air_job union select jb_bin as id, jb_no_tcd as text from  sea_job";
	public static final String vendorlist   ="select vendor_code as id, concat(vendor_code,'-', vendor_name) as text from vendor_master ";
	
	public static final String	get_Vendor="select vendor_code as id, concat(vendor_code,'-', vendor_name) as text from vendor_master";
	
	public static final String Accounthead ="select acct_head_code as id , concat(acct_head_code,'-',acct_head_name) as text from account_head_master order by acct_head_name asc";	
	public static String GET_customer_category_LIST = "select distinct const_code as id,const_desc as text from sys_const where const_grp ='CC' order by const_code ";

	public static String  GET_VENDOR_LIST ="select distinct vendor_shrt_name as  id ,concat(vendor_shrt_name,' - ',vendor_name) as text from vendor_master  order by vendor_shrt_name asc";

	public static String  GET_Stuff_LIST = "select stuff_type as id,stuff_type as text From stuffing_type order by stuff_type";
	
	public static String payer_list="  select payer_code as id,payer_code||' - '||payer_name as text from payer_master where payer_active  ='Y' order by payer_name asc";

  	
	public static String get_Port_By_Emp="SELECT distinct prt_icd_id as id,prt_icd_cd||' - '||prt_icd_nam as text,prt_icd_nam FROM port_icd where  actv_bt = '1' order by prt_icd_nam";

	public static final String sGetCargoArrivalVoyageList = "SELECT  voyageno  AS id,  voyageno AS text, COALESCE(NULLIF(service,''),'')  AS sectorId  FROM  tb_voyage  WHERE vesselid=? "
			+ "AND voyageno is not null  ORDER BY voyageno";
	
	
	public static final String sGetCargoArrivalVoyageListSin = "SELECT  voyage_id AS id,  voyage_id AS text, sector_id AS sectorId  FROM  voyage  WHERE "
			+ "vessel_id=?  AND voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where (from_port_id in ('PSA') or to_port_id in  ('PSA')))  ORDER BY voyage_id ";
	
	public static final String sGetCargoArrivalVoyageListMY = "SELECT  voyage_id AS id,  voyage_id AS text, sector_id AS sectorId  FROM  voyage  WHERE "
			+ "vessel_id=?  AND voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where (from_port_id in ('MYPKL','MYPKG') or to_port_id in  ('MYPKL','MYPKG')) )  ORDER BY voyage_id ";

	public static final String commodity_list = "  select commodity_code as id,commodity_code||' - '||commodity as text from commodity  order by commodity";


	
	public static String GET_COMPANY_CURRENCY = "select CURRENCY from COMPANY_MASTER WHERE COMPANY_CODE=?";


	public static String get_Port_By_Agent(String userPortStr) {
		String port="SELECT distinct prt_icd_cd as id,prt_icd_cd||' - '||prt_icd_nam as text,prt_icd_nam FROM port_icd where actv_bt = '1' and prt_icd_cd in ("+userPortStr+")  order by prt_icd_nam";
		return port;
	}
	
	public static String surChargeList="select sur_code as id,sur_name as text from surcharge_master where related_to= ? order by text asc";

	
	public static final String sGetAccountHeadListCN = "SELECT ACCT_HEAD_NAME, ACCT_HEAD_CODE, ACCT_CURRENCY, coalesce(cast(ACCT_EXCHANGE_RATE as double precision),0) EXCHANGE_RATE from ACCOUNT_HEAD_MASTER  where ACCT_HEAD_CODE not in('10090022','10090023','10090024','10090025','10090027','10090028') ORDER BY ACCT_HEAD_NAME ASC";


	public static String getCustomerListFilter(com.dci.tenant.common.CommonUtilityBean objCommonUtilityBean) {
		String query= "";
		query =" select * from ( " + 
				"select cust_code as id,replace(cust_name,'\"','') as text from customer_master  where active ='T' " + 
				"union  " + 
				"select cust_code as id,replace(cust_name,'\"','') as text from customer_master  where cust_code in "
				+ " (" +objCommonUtilityBean.getCondition() +") " + 
				")t " + 
				" order by id";
		System.out.println("query :"+query);
		return query;
	}
	
	public static final String GET_PORTWITHSEQBYVOYAGE="select  concat(port,'-',s.port_seq) as id,concat(port,'-',s.port_seq) as text from tb_sof_1 s inner join port_master pm on  s.port=pm.portcode where voyageid= ? and pm.isactive = 'Y' order by s.port_seq";

	public static final String GET_PORT_SEQ = "select port as id,concat(port,'-',s.port_seq) as text from tb_sof_1 s inner join port_master pm on  s.port=pm.portcode where pm.isactive = 'Y' order by s.port_seq";

	public static String gat_Quotation_specialList= "select id as id, special_name as text from quotation_category";

	public static final String AccountheadTDS ="select acct_head_code as id , acct_head_name as text from account_head_master where acct_head_name like 'TDS%' and acct_head_code like '2012%' order by acct_head_name asc";

	public static final String GET_sales_LIST = "select emp_id as id,concat(emp_id,'-',emp_name) as text from employee_master where dept ='DP005' order by id";

	public static final String GET_customer_category_LIST_new =" select  customer_type_code as id,customer_type_name as text from customer_type order by customer_type_code ";

	public static final String GET_PORT_LIST_WITHOUT_TERMINAL = "SELECT distinct portcode as id,portcode||' - '||portname as text,portname FROM PORT_MASTER where isactive = 'Y' and porttype = 'Port' order by portname";

	public static final String GET_BANKACCT_LIST ="select bank_code as id,bank_name as text from bank_account_master";

	public static final String GET_DEPOT_LIST = "select depot_code as id ,depot_code|| '-'||depot_name as text from depot_master" ;

	public static final String GET_PORT_LIST_BY_GETMTY =" select t.depot_id as id  ,t.depot_id as text ,t.container_id as customerType ,cms_codes_id,c.container_number as quotation,c.container_type as  customer"
			+" from t_container_status t  "
			+" inner join container c on c.container_id=t.container_id "
			+" WHERE container_status_id in (select max(container_status_id) from t_container_status group by container_id) "
			+"   and cms_codes_id in ('OHI','RVC','DHE') "
			+"   and t.depot_id  =? ";

	public static final String GET_bl_LIST = "select bl_no as id,bl_no as text from outward_bls where client_id=?";

	public static final String GET_PORT_DEPOT = " select portcode as id,concat(portcode,'-',portname)  as text  from port_master where   country_code  in ( select country_code from port_master where portcode in (select from_port_id from voyage_port where voyage_id =?) ) and isactive = 'Y' order by  portcode";

	
	public static final String GET_SALES_PERSON_LIST = "select distinct created_by as id , (select user_name from user_master where user_id = ratequotation_hdr.created_by limit 1 ) as text from ratequotation_hdr ";

	public static final String GET_PORTDEPOT_LIST = "SELECT distinct portcode as id,portcode||' - '||portname as text,portname FROM PORT_MASTER  "
     + " left join depot_master d on d.portiso_code=portcode "
 + "  where isactive = 'Y' "
 + "   order by portname";

	public static final String GET_PORT_COST_LIST  = " select * from port_dropdownlist()";

	public static final String GET_VENODR_CONDITION ="select acct_head_code as id,acct_head_code ||  ' - ' ||agent_name as text from agent_master where agent_active='Y'";
			//+ " where category in('Container Depot(CD)' ,'Inland Container Depot(ICD)' ,'Country Yard(CY)','Container Maintainenance Repair(CMR)')";

	public static final String GET_MODULE_LIST ="select module_code as id,(module_code || '-' || module_name) as text from module_master";

	public static final String GET_MODULEPARENT = "select distinct form_code_parent as id,form_code_parent as text from form_master_new where  module_code=?";
		
	public static final String GET_POL_LIST_NEW_PORT = " SELECT distinct portcode as id,portcode||' - '||portname as text,portname FROM PORT_MASTER where isactive = 'Y' and porttype = 'Port'";

	public static final String GET_POL_LIST_NEW_PORT1 = " SELECT distinct portcode as id,portcode||' - '||portname as text,portname FROM PORT_MASTER where isactive = 'Y' and porttype = 'Port'";

	public static final String GET_BL_LIST ="select bl_no as id ,bl_no as text from outward_bls";

	//public static final String GET_VENODR_DEPOT = "select vendor_code as id,vendor_shrt_name ||  ' - ' ||vendor_name as text from vendor_master where category in('Container Depot(CD)' ,'Inland Container Depot(ICD)' ,'Country Yard(CY)','Container Maintainenance Repair(CMR)')";

	public static final String GET_VENODR_DEPOT = "select * from depot_agent_list()";

	public static final String GET_PORTISO_CODE ="select * from cro_booking_list(?)";

	//public static final String GET_POL_BOOKING = "select pol from booking where booking_no =?";

	public static final String GET_POL_BOOKING = "select  * from cro_booking_pol_list(?)";
	//public static final String GET_PORT_ISO ="select portisocode from port_master where portcode =?";

	public static final String GET_PORT_ISO ="select * from cro_booking_portisocode_list(?)";
	//public static final String GET_FINAL_CODE = "select portcode as id, portcode as text from port_master where portisocode =?";
	
	public static final String GET_FINAL_CODE = "select * from cro_booking_depot_list(?)";
	

	public static String gat_cargotype = "select commodity_id as id ,commodity as text from commodity_description where active = 'Y' ORDER BY commodity_id asc ";
	
	public static String gat_serviceList = "select sector_code as id, concat(sector_code,'-',sector_name) as text from SECTOR_MASTER";

	public static String PORT_LIST = "select portcode as id , concat(portcode,'-',portname) as text from port_master order by portname asc ";
	
	public static String Depot_list_by_port ="select  depot_code as id, concat(depot_code,'-',depot_name) as text from depot_master where  is_active= 't' and portiso_code =? order by depot_code";
	
	public static String get_Depot_By_Agent(String userPortStr) {
		String port="select  depot_code as id, concat(depot_code,'-',depot_name) as text from depot_master where  is_active= 't' and portiso_code =? and depot_code in ("+userPortStr+") order by  depot_code";
				
		return port;
}
	
	public static String locationList_by_region ="select distinct  portcode as id, portcode as text  from port_master   where   region_code=?  and   porttype ='Port' and isactive ='Y' order by portcode asc";
	
	public static String movementStatus_List ="select containerstatus_code as id, concat(containerstatus_code,'-',containerstatus_description) as text from container_status order by containerstatus_code  ";
	
	public static String subcode_List_by_status ="select  distinct sub_code as id, concat(sub_code,'-',sub_code_desc) as text from container_status where sub_code is not null and containerstatus_code=?  order by sub_code   ";
	
	public static String Get_agent_list ="select agent_code as id , concat(agent_shrt_name,'-',agent_name) as text from  agent_master where agent_active='Y' order by agent_name ";
	//work flow querys
	
	public static String getEmpDetails="select reporting_to as empReportingPerson,designation as empDesignation,dept as empDepartment,branch_department_id as empBranch from employee_master where emp_id =?";

	public static String getWorkFlowCount="select count(*) from wf_mapping where system_module=? and branch=?";
	
	public static String getWorkFlowDetails="select step_order as stepOrder,step_name as stepName,approve_type as approveType,role_name_user as roleNameUser from wf_mapping wm inner join wf_steps ws on ws.wf_id=wm.wf_id where wm.system_module=? and branch=?";

	public static String get_charge_RRR = "select sur_code as id ,concat(sur_short_name,' - ',sur_name) as text  from surcharge_master where sur_short_name like 'R%'";

	public static String get_cust_ship="select * from get_ship_consig_list()";

	public static String GET_COUNTRY_LIST_PORT_MASTER = "select  distinct port_master.country_code as id,concat(port_master.country_code,' - ', country_master.country_name) as text  from port_master  inner join country_master on country_master.country_code = port_master.country_code  group by country_name ,port_master.country_code order by port_master.country_code asc " ;

	public static String sGetSubAccountList_GL_NEW="select acct_head_code as id,srvc_prtnr_nam as text from service_partner where not null_or_empty(sundry_type)";
	public static String get_contractType;

	

	public static final String GET_EMPTYREPO_LIST ="\n" + 
			"select emptyreq_code as id ,emptyreq_code as text from empty_request_hdr\n" + 
			"where emptyreq_code not in(select empty_code from booking where empty_code is not null)";

	public static final String GET_EMPTYREPOEDIT_LIST = "select emptyreq_code as id ,emptyreq_code as text from empty_request_hdr\n" + 
			"where emptyreq_code not in(select empty_code from booking where empty_code is not null)";

	public static final String GET_SHIPER_CONSIGNEE_LIST = "select * from get_ship_consig_list()";

	public static final String GET_USER_LIST = "select user_id id ,user_name as text from user_master order by user_name";

	public static final String GET_BL_CODE = "	select  bl_no as blNo, o.voyage_code as voyage,to_char(o.issue_date,'dd/mm/yyyy') as createdDate,o.client_id,c.cust_name as customer,\n" + 
			"			o.pol as pol,o.pod as pod,o.job_no,cs.booking_no,\n" + 
			"			(select to_char(eta,'dd/mm/yyyy hh24:mi') as eta \n" + 
			"			from voyage_port vp where vp.voyage_id=o.voyage_code and from_port_id=o.pol limit 1)\n" + 
			"			 from outward_bls o\n" + 
			"			left join customer_master c on c.cust_code=client_id\n" + 
			"			left join shipment_hdr cs on cs.job_no=o.job_no\n" + 
			"			left join booking b on b.booking_no=cs.booking_no\n" + 
			"			where  bl_no=?";

	public static final String GET_DEPOTPOL_CODE = "select * from cro_booking_depotpol_list(?)";

	public static final String GET_COMPANYINSUREN_LIST = "select company_code as id ,company_name as text from company_master";

	public static final String GET_INSURENCE_TERSMS ="select terms_payment as id ,terms_payment as text from insurence_agree";

	public static final String GET_VENDOR_INSURE_LIST = "select vendor_code as id , concat(vendor_shrt_name,'-',vendor_name ) as text from vendor_master ";

	public static final String GET_SERVICE_LIST = "select vendor_code as id , concat(vendor_shrt_name,' - ', vendor_name) as text from vendor_master  where category in ('Main Line Operator','Feeder Operator') ";

	public static final String GET_VENDOR_INSUREBROKER_LIST ="select * from  vendor_insure_broker_list() ";
	
	public static final String update_GI_act_date = "update generalinvoice_hdr set actual_created_dt=now() where invoice_no =? ";	
	
	public static final String update_FreightInv_act_date = "update invoice_hdr set actual_created_dt=now() where invoice_no =? ";

	public static final String update_Payment_act_date = "update cashbank_pay_hdr set actual_created_dt=now() where voucher_no =? ";
	
	public static final String update_Receipt_act_date = "update cashbank_receipt_hdr set actual_created_dt=now() where voucher_no =? ";

	public static final String update_JV_act_date = "update journalvoucher_hdr set actual_created_dt=now() where journal_no =? ";

	public static final String update_PIN_act_date = "update purchase_invoice_hdr set actual_created_dt=now() where invoice_no =? ";
	
	public static final String update_PCN_act_date = "update purchase_creditnote_hdr set actual_created_dt=now() where invoice_no =? ";

	public static String GET_POL_LIST_NEW = " select prt_icd_id::text as id,concat(prt_icd_cd,'-',prt_icd_nam) as text from port_icd where actv_bt ='1' ";

	public static String get_contract="select contract_id as id ,contract_type as text  from contract_type   order by contract_type";

	public static String get_comList="select company_code as id ,company_name as text from company_master order by company_name asc";

	public static String get_customer_local="select acct_head_code as id,srvc_prtnr_nam as text from service_partner where sundry_type='10010004'";

	public static String get_customer_overseas="select acct_head_code as id,srvc_prtnr_nam as text from service_partner where sundry_type='10080002'";

	public static String get_Supplier_local="select acct_head_code as id,srvc_prtnr_nam as text from vendor_master_new where sundry_type='20000003'";
	public static final String GET_COMPANY_LIST_PURCHASE = "SELECT DISTINCT c.company_code as companyCode,company_name as text,c.company_code as id,company_name companyName FROM company_user cu INNER JOIN company_master c ON cu.company_code = c.company_code  ORDER BY company_name ASC";
	
	public static final String GET_SERVICE_OPERATORLIST = "select vendor_id as id ,CONCAT(srvc_prtnr_cd,'-',srvc_prtnr_nam) as text from vendor_master_new  ";
	
	
	public static final String GET_SERVICE_LIST1 = "select sector_code as id ,CONCAT(sector_code,'-',sector_name) as text from sector_master  ";
	public static final String carrierList="select srvc_prtnr_bin id,srvc_prtnr_nam as text from vendor_master_new v inner join vendor_master_new_map c on c.vendor_master_new_id=v.srvc_prtnr_bin where  vendor_master_new_type_id=3 ";

	
	public static final String transList="select srvc_prtnr_bin id,srvc_prtnr_nam as text from vendor_master_new v inner join vendor_master_new_map c on c.vendor_master_new_id=v.srvc_prtnr_bin where  vendor_master_new_type_id=4 ";

	public static final String GET_COMPANY_LIST_COMPANY = "select company_code as id ,company_name as text from company_master";
	
	public static String get_Supplier_overseas ="select acct_head_code as id,srvc_prtnr_nam as text from service_partner where sundry_type='20010003'";

	public static final String GET_COMPANY_LIST_WITH_USER = "select company_code as value, company_name as description from company_master where company_code=? ";

	public static String sGetSubAccountLists1 = "select * from debtors_list";

	public static String sGetAccountHeadListnew = "SELECT ACCT_HEAD_NAME as accountHeadName, ACCT_HEAD_CODE as accountHeadCode, ACCT_CURRENCY as currencyCode, COALESCE(ACCT_EXCHANGE_RATE,0) as exchangeRate from ACCOUNT_HEAD_MASTER ORDER BY ACCT_HEAD_NAME ASC";

	public static final String sGetSubAccountLists ="select subAccountCode, subAccountCode||'-'|| subAccountName as subAccountName from (  select supplier_acct_code subAccountCode, entity_name subAccountName from entity where is_vendor='t' AND  (supplier_acct_code!=NULL OR supplier_acct_code!='')) AS subacc where subAccountCode IS  Not null "
			+ "union "
			+ "	 "
			+ " 	select subAccountCode, subAccountCode||'-'|| subAccountName as subAccountName from (  select customer_acct_code subAccountCode, entity_name subAccountName from customer_entity where is_customer='t' AND  (customer_acct_code!=NULL OR customer_acct_code!='')) AS subacc where subAccountCode IS  Not null ORDER BY subaccountname asc";
			
			//"select subAccountCode, subAccountCode||'-'|| subAccountName as subAccountName from (  select supplier_acct_code subAccountCode,\n" + " entity_name subAccountName from entity where is_vendor='t' AND  (supplier_acct_code!=NULL OR supplier_acct_code!='')) AS subacc where subAccountCode IS\n" + "  Not null ORDER BY subaccountname asc";
	public static final String GET_SUB_GROUP_ACCT_LIST = "select SUB_GROUP_ACCT_CODE as id,SUB_GROUP_ACCT_NAME as text from SUB_GROUP_ACCT_MASTER ORDER BY SUB_GROUP_ACCT_NAME ASC";
	public static String budget_DefineList_cc = "select budget_definition_id as id ,project_name as text  from budget_definition where approve_status = 'Approved' and cost_center=?  and (project_name!=NULL OR project_name!='') order by project_name asc";

	public static final String sGetSubAccountListEmployee = "select subAccountCode, subAccountName from (select distinct entity_acct_code subAccountCode, entity_name subAccountName from entity where is_others=true) AS subacc where  subAccountCode!='' ORDER BY subaccountname asc";

	public static final String sGetSubAccountListVendor = "select subAccountCode, subAccountName from (select distinct supplier_acct_code subAccountCode, entity_name subAccountName from entity where is_vendor=true) AS subacc where subAccountCode!='' ORDER BY subaccountname asc";

	public static final String sGetSubAccountListCustomer = "select subAccountCode, subAccountName from (select distinct customer_acct_code subAccountCode, entity_name subAccountName from entity where is_customer=true) AS subacc where  subAccountCode!='' ORDER BY subaccountname asc";

	public static final String INSERT_STOCK_RECEIVE_ASSET = "INSERT INTO stock_transfer_recieved_asset_dtl(stock_received_detail_id, asset_detail_id)  VALUES ( ?, ?)";
	//public static String sGetAccountSgListNew = " select ACCT_HEAD_CODE as subaccountcode,ACCT_HEAD_NAME as subaccountname from ACCOUNT_HEAD_MASTER where ACCT_HEAD_CODE =? ";
	public static String sGetAccountSgListNew = "  with t as (select ACCT_HEAD_CODE as subaccountcode,ACCT_HEAD_NAME as subaccountname from ACCOUNT_HEAD_MASTER union  select supplier_acct_code as id,entity_name as text from entity  \r\n"
			+ "     union  select customer_acct_code as subaccountcode,entity_name as subaccountname from customer_entity) select subaccountcode,subaccountname from t where subaccountcode =? ";

	public static final String GET_PARENT_LOCATION = "WITH RECURSIVE q AS (SELECT location_id ,cast(location_name as varchar(255)) as path FROM location WHERE parent_location_id is null and is_active='t' UNION ALL SELECT ic.location_id,cast( q.path ||' / ' || cast(ic.location_name " + "as varchar(255)) as  varchar(255)) FROM location ic JOIN q ON  ic.parent_location_id =  q.location_id where ic.is_active='t') SELECT location_id as id,path as text  FROM q where location_id not in(?,?) ";

}
