package com.dci.tenant.finance.reports.analytical.revenueregister;

public class revenueregisterQueryUtil {

	public static final String GET_REVENUE_REGISTER_LISTs = " SELECT invoice_no,QUOTATION_NO,INVOICE_DT,sum(TC_AMOUNT) TC_AMOUNT ,"
			+ " sum(BC_AMOUNT) BC_AMOUNT, payer, MLO_code,sailing_dt, Month,voyage,pol,pod,fpod,SI_COMPANY_CODE, ACCTCODE ,created_by"
			+ " FROM  VW_REVENUE group by invoice_no,QUOTATION_NO,INVOICE_DT,payer, MLO_code,sailing_dt, Month, voyage,pol,pod,fpod,"
			+ " SI_COMPANY_CODE, ACCTCODE ,created_by";
	
	public static final String payerList  =	"select MLO_CODE as id,MLO_CODE||'-'||MLO_NAME  as text from MLO_MASTER ORDER BY MLO_NAME";
	
	public static final String customerList  =	"select srvc_prtnr_bin::text as id,srvc_prtnr_cd||'-'||srvc_prtnr_nam  as text from service_partner ORDER BY srvc_prtnr_nam";

	public static final String GET_REVENUE_REGISTER_LIST_AIR = "select rev.sls_invc_no_tcd as invoiceNo,rev.sls_invc_dt as invoiceDt,sp.srvc_prtnr_cd as customerCode,sp.srvc_prtnr_nam as mloName, cm.brnch_nam as companyName,rev.invc_amnt_nc as bc_amount, rev.ttl_amnt_tc as tc_amount,jb.jb_no_tcd as jobNO,em.emp_name as createdBy from air_sales_invoice rev "
			+ "			left join air_job jb on jb.jb_bin=rev.jb_bin "
			+ "			left join service_partner sp on sp.srvc_prtnr_bin=rev.prty_bin "
			+ "			left join branch cm on cm.brnch_id=rev.brnch_id "
			+ "			left join employee_master em on em.emp_id=rev.crtd_by";   
	
	public static final String GET_REVENUE_REGISTER_LIST_SEA =  "select rev.sls_invc_no_tcd as invoiceNo,rev.sls_invc_dt as invoiceDt,sp.srvc_prtnr_cd as customerCode,sp.srvc_prtnr_nam as mloName, cm.brnch_nam as companyName,rev.invc_amnt_nc as bc_amount, rev.ttl_amnt_tc as tc_amount,jb.jb_no_tcd as jobNO,em.emp_name as createdBy from "
			+ "sea_sales_invoice rev left join sea_job jb on jb.jb_bin=rev.jb_bin "
			+ "left join service_partner sp on sp.srvc_prtnr_bin=rev.prty_bin "
			+ "left join branch cm on cm.brnch_id=rev.brnch_id "
			+ "left join employee_master em on em.emp_id=rev.crtd_by"
			+ " union "
			+ "  select  dbn.debitnote_no as invoiceNo, dbn.debitnote_date as invoiceDt, spt.srvc_prtnr_cd  as customerCode,dbn.debitnote_account_head as mloName, brnch.brnch_nam as companyName,dbn.bc_amount as bc_amount,dbn.tc_amount as tc_amount, jb_bin_tcd as jobNO,emp.emp_name as createdBy ,dbn.company_code, customerid as srvc_prtnr_bin from debitnote_hdr dbn "
			+ " inner join service_partner spt on spt.srvc_prtnr_bin= dbn.customerid "
			+ "  inner join employee_master emp on emp.emp_id= dbn.created_by "
			+ " inner join branch brnch on brnch.company_code = dbn.company_code ";
		
	
	
	public static final String GET_REVENUE_REGISTER_LIST_SEA_AIR="select * from (select * from (select rev.sls_invc_no_tcd as invoiceNo,rev.sls_invc_dt as invoiceDt,sp.srvc_prtnr_cd as customerCode,sp.srvc_prtnr_nam as mloName, cm.brnch_nam as companyName,rev.invc_amnt_nc as bc_amount, rev.ttl_amnt_tc as tc_amount,jb.jb_no_tcd as jobNO,em.emp_name as createdBy,rev.company_code,sp.srvc_prtnr_bin "
			+ " from air_sales_invoice rev left join air_job jb on jb.jb_bin=rev.jb_bin left join service_partner sp on sp.srvc_prtnr_bin=rev.prty_bin left join branch cm on cm.brnch_id=rev.brnch_id "
			+ "left join employee_master em on em.emp_id=rev.crtd_by)air union (select rev.sls_invc_no_tcd as invoiceNo,rev.sls_invc_dt as invoiceDt,sp.srvc_prtnr_cd as customerCode,sp.srvc_prtnr_nam as mloName, cm.brnch_nam as companyName,rev.invc_amnt_nc as bc_amount, rev.ttl_amnt_tc as tc_amount,jb.jb_no_tcd as jobNO,em.emp_name as createdBy,rev.company_code,sp.srvc_prtnr_bin "
			+ " from sea_sales_invoice rev left join sea_job jb on jb.jb_bin=rev.jb_bin left join service_partner sp on sp.srvc_prtnr_bin=rev.prty_bin left join branch cm on cm.brnch_id=rev.brnch_id "
			+ "left join employee_master em on em.emp_id=rev.crtd_by)"
			+ " union "
			+ "  select  dbn.debitnote_no as invoiceNo, dbn.debitnote_date as invoiceDt, spt.srvc_prtnr_cd  as customerCode,dbn.debitnote_account_head as mloName, brnch.brnch_nam as companyName,dbn.bc_amount as bc_amount,dbn.tc_amount as tc_amount, jb_bin_tcd as jobNO,emp.emp_name as createdBy ,dbn.company_code, customerid as srvc_prtnr_bin from debitnote_hdr dbn "
			+ " inner join service_partner spt on spt.srvc_prtnr_bin= dbn.customerid "
			+ "  inner join employee_master emp on emp.emp_id= dbn.created_by "
			+ " inner join branch brnch on brnch.company_code = dbn.company_code "
			+ ")airsea";
  
 
      


 
  

 
 





			 

	
	public static final String getPortIsoCode = "select distinct port_iso_code portIsoCode from port_master";

}
/*
 * select V.INVOICE_NO grp_invoice_no,V.INVOICE_DT grp_invoice_dt ,V.VOYAGE_CODE
 * voyage,v.pol pol, a.AGING aging, V.POD pod,V.SAILING_DT
 * sailingDt,V.GI_COMPANY_CODE, V.MLO ,V.CUSTOMER mloname , vye.SECTOR_ID
 * servicename, V.BALANCE_USD balance_usd,V.BALANCE balance, MLO_NAME payer,
 * MLO_CITY mloCity, COUNTRY_NAME country from VW_AR_REGISTER V left outer join
 * MLO_MASTER M on CUSTOMER = MLO_CODE left outer join COUNTRY_MASTER on
 * COUNTRY_ID = MLO_COUNTRY_ID join VOYAGE vye on V.VOYAGE_CODE = vye.VOYAGE_ID
 * join AR_REG a on V.INVOICE_NO = a.GRP_INVOICE_NO; }
 */
