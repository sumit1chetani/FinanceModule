package com.dci.master.CompanyGroup;

public class CompanyGroupQueryUtil {
	
	public static final String INSERT_SQL = "INSERT INTO COMPANY_GROUP_MASTER (COMPANY_GROUP_NAME)VALUES(?)";
	public static String SELECT_GROUP_NAME = "select COMPANY_GROUP_NAME from COMPANY_GROUP_MASTER where COMPANY_GROUP_ID=?";
	public static String sAddCompanyGroupdetails = " INSERT INTO COMPANY_GROUP_MASTER (COMPANY_GROUP_NAME)VALUES(?) returning COMPANY_GROUP_ID";
	public static String sUpdateCompanyGroupDetail = "UPDATE COMPANY_GROUP_MASTER SET  COMPANY_GROUP_NAME=? WHERE COMPANY_GROUP_ID =?";
	public static String sDeleteCompanyGroupDetail = "DELETE  FROM COMPANY_GROUP_MASTER WHERE COMPANY_GROUP_ID = ?";
	public static String sViewCompanyGroupTableList = "SELECT COMPANY_GROUP_ID,COMPANY_GROUP_ID as id,COMPANY_GROUP_NAME,COMPANY_GROUP_NAME as text from COMPANY_GROUP_MASTER where  COMPANY_GROUP_ID not in (6) order by COMPANY_GROUP_ID DESC ";
	public static String selectGroupidForGroupname = "SELECT COMPANY_GROUP_ID from COMPANY_GROUP_MASTER WHERE COMPANY_GROUP_NAME = ?";
	public static String selectCompanyCodefromDetailTable = "SELECT cdm.COMPANY_CODE,cdm.company_code  as id,cm.SHORT_NAME as shortName,cm.short_name as text from COMPANY_GROUP_DETAIL_MASTER cdm join company_master cm  on cm.company_code = cdm.company_code  where COMPANY_GROUP_ID = ?";
	public static String sAddCompanyGroupDetailTable = "INSERT INTO COMPANY_GROUP_DETAIL_MASTER (COMPANY_GROUP_ID,COMPANY_CODE)VALUES(?,?)";
	public static String deleteCompanyGroupDetailTable = "DELETE  FROM COMPANY_GROUP_DETAIL_MASTER WHERE COMPANY_GROUP_ID = ?";
	public static String sCheckCompanyGroupName = "SELECT count(*) FROM COMPANY_GROUP_MASTER WHERE COMPANY_GROUP_NAME = ?";
	public static String sViewCompanyDetails = " SELECT COMPANY_CODE companycode,COMPANY_NAME companyname  from COMPANY_MASTER order by COMPANY_CODE DESC";
	// multi delete
	public static String sDeleteCompanyDetail = "DELETE  FROM COMPANY_MASTER WHERE COMPANY_CODE = ?";
	
	public static String sViewCompanyGroupTableList_NEW = "SELECT distinct CGM.COMPANY_GROUP_ID,CGM.COMPANY_GROUP_ID as id,COMPANY_GROUP_NAME,COMPANY_GROUP_NAME as text from COMPANY_GROUP_MASTER CGM "
			  +" LEFT JOIN COMPANY_GROUP_DETAIL_MASTER dtlms on dtlms.COMPANY_GROUP_ID=CGM.COMPANY_GROUP_ID "
			  +" LEFT JOIN company_user cu on cu.company_code = dtlms.company_code "
			  +" join user_rights_new urn "
			  +" on urn.company_user_id = cu.company_user_id "
			  +" join form_property fp on fp.form_property_id  = urn.form_property_id where fp.form_code  in ('F0021','F0290','F0020') and cu.user_id = ? and cu.company_code not in ('C0003','C0017') ";


	public static String sGetCompanyFromGroup =  " SELECT distinct cdm.COMPANY_CODE,cdm.company_code  as id,cm.SHORT_NAME as shortName,cm.short_name as text from COMPANY_GROUP_DETAIL_MASTER cdm "
			+" join company_master cm  on cm.company_code = cdm.company_code"
 +" join company_user cu  on cu.company_code = cdm.company_code "
+" join user_rights_new urn on urn.company_user_id = cu.company_user_id "
+" join form_property fp on fp.form_property_id  = urn.form_property_id where fp.form_code in ('F0021','F0290','F0020') and cu.user_id = ? and cu.company_code not in ('C0003','C0017')"

+"   and  COMPANY_GROUP_ID = ?";
	

	public static String sCompanyDropDown = "select company_code as id, company_name as text,location as company from company_master where company_code='C0001'";


}
