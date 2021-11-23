package com.dci.tenant.finance.reports.analytical.ARregister;

public class ARregisterQueryUtil {

	/*public static final String AR_REPORT =
			
		"	select V.INVOICE_NO grp_invoice_no,"
		+"	V.INVOICE_DT grp_invoice_dt "
		+" ,V.VOYAGE voyage,"
		+"	v.pol pol,"
		+"	V.POD pod,"
		+"	V.SAILING_DT sailingDt,"
		+	" V.COMPANY_ID ,"
	    + "	V.PAYER,M.PAYER_SHORT_NAME payershortname,"
	    +  " M.PAYER_COUNTRY_ID,cm.COUNTRY country, "
		+"	vye.SECTOR_ID servicename,"
		+"	cm.COMPANY_NAME company,"
		+"	coalesce(now() - V.INVOICE_DT) AS  aging,"
		+"	 V.BALANCE_USD balance_usd,"
		+"	 V.BALANCE balance,"
		+"	 MLO_CITY mloCity"
		+"	 from  VW_AR_REGISTER V"
		+"	 left outer join PAYER_MASTER M on PAYER = ACCT_HEAD_CODE join VOYAGE vye on V.VOYAGE = vye.VOYAGE_ID "
		+"	 join COMPANY_MASTER cm on V.COMPANY_ID = cm.COMPANY_CODE  where V.INVOICE_NO is not null" ;
*/
	/*"select V.INVOICE_NO grp_invoice_no,V.INVOICE_DT grp_invoice_dt ,V.VOYAGE voyage,v.pol pol,V.POD pod,V.SAILING_DT sailingDt,"
			+ " V.COMPANY_ID ,V.CUSTOMER  mloname , vye.SECTOR_ID servicename,cm.COMPANY_NAME companyName, trunc(SYSDATE - V.INVOICE_DT) AS  aging,"
			+ " V.BALANCE_USD balance_usd,V.BALANCE balance, MLO_NAME payer, MLO_CITY mloCity, COUNTRY_NAME country,m.MLO_SHORT_NAME customerShortName  from  VW_AR_REGISTER V"
			+ " left outer join MLO_MASTER M on CUSTOMER = ACCT_HEAD_CODE join VOYAGE vye on V.VOYAGE = vye.VOYAGE_ID  left outer join COUNTRY_MASTER on "
			+ " COUNTRY_ID = MLO_COUNTRY_ID" + " join COMPANY_MASTER cm on V.COMPANY_ID = cm.COMPANY_CODE " + " where V.INVOICE_NO is not null ";*/
	public static final String AR_REPORT="select V.INVOICE_NO grp_invoice_no,V.INVOICE_DT grp_invoice_dt ,V.VOYAGE voyage,V.pol as pol,v.pod as pod, v.sailing_dt,V.COMPANY_ID ,v.customer as payer,M.mlo_SHORT_NAME payershortname,M.mlo_COUNTRY_ID,cm.COUNTRY country, cm.COMPANY_NAME company,coalesce(now() - V.INVOICE_DT) AS  aging, V.BALANCE_USD balance_usd, V.BALANCE balance, MLO_CITY mloCity from  VW_AR_REGISTER V left outer join mlo_master M on customer = ACCT_HEAD_CODE join COMPANY_MASTER cm on V.COMPANY_ID = cm.COMPANY_CODE where V.INVOICE_NO is not null ";
 






}