package com.dci.tenant.company;

public class CompanyDetailsQueryUtil {
	
	public static String SELEECT_COMPANY_CODE = "SELECT CASE WHEN MAX(COMPANY_CODE) IS NULL  THEN 'C0001' ELSE rpad(MAX(COMPANY_CODE),1,'C')|| lpad(cast(cast((SUBSTRING(MAX(COMPANY_CODE),4)) as int)+1  as text),4,'0') END FROM COMPANY_MASTER";

	public static String sAddCompanydetails = "INSERT INTO COMPANY_MASTER (COMPANY_NAME,SHORT_NAME,LOCATION,COMPANY_CODE,ADDRESS,PH_NO,FAX_NO,EMAIL,PERSON_INCHARGE,RELATIONSHIP,INTER_COMP_GROUP,CREATED_BY,CREATED_DATE,CURRENCY,IS_OPERATION )VALUES(:companyname,:shortName,:location,:companyCode,:address,:phoneno,:faxno,:email,:personincharge,:relationship,:intercompgroup,:userid,current_timestamp,:currencyCode,:isOperation)";

	public static String sViewCompanyDetails = "SELECT COMPANY_CODE companycode,COMPANY_NAME companyname, LOCATION as location,ADDRESS address,PH_NO phoneno,FAX_NO faxno,EMAIL email,PERSON_INCHARGE personincharge,RELATIONSHIP relationship,INTER_COMP_GROUP intercompgroup  from COMPANY_MASTER order by COMPANY_CODE DESC";

	public static String sEditCompanyDetails = "SELECT COMPANY_CODE companycode, SHORT_NAME shortName, COMPANY_NAME companyname, LOCATION as location,ADDRESS address,PH_NO phoneno,FAX_NO faxno,EMAIL email,PERSON_INCHARGE personincharge,RELATIONSHIP relationship,INTER_COMP_GROUP intercompgroup,CURRENCY currencyCode,IS_OPERATION isOperation FROM COMPANY_MASTER where COMPANY_CODE =?";

	public static String sDeleteCompanyDetail = "DELETE FROM COMPANY_MASTER WHERE COMPANY_CODE = ?";

	public static String sUpdateCompanyDetail = "UPDATE COMPANY_MASTER SET  COMPANY_NAME=:companyname,SHORT_NAME=:shortName,LOCATION=:location,ADDRESS=:address,PH_NO=:phoneno,FAX_NO=:faxno,EMAIL=:email,PERSON_INCHARGE=:personincharge,RELATIONSHIP=:relationship,INTER_COMP_GROUP=:intercompgroup,MODIFIED_BY=:userid,MODIFIED_DATE=current_timestamp, CURRENCY=:currencyCode,IS_OPERATION =:isOperation  WHERE COMPANY_CODE=:companycode";

	public static String sCheckCompanyName = "SELECT count(*) FROM COMPANY_MASTER WHERE COMPANY_NAME =? ";

	public static String sCheckUpdateCompanyName = "SELECT count(*) FROM COMPANY_MASTER WHERE COMPANY_CODE <>? and COMPANY_NAME =? ";

	public static String sCompandLoc = "SELECT company_name companyname,location as location from company_master";

	public static String sGetCurrencyList = "  select currency_code as id,currency_code||'-'||currency_name as text from currency_master   order by currency_name";
  

}
