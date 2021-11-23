package com.dci.tenant.user;

public class UserMasterQueryUtil {

	// @formatter:off

	public static final String GETFORMUSERRIGHTS = "select usr.user_name as userName,prop.property_code as propCode from user_master usr  inner join company_user cu on cu.user_id = usr.user_id inner join user_rights_new urn on urn.company_user_id =cu.company_user_id inner join form_property prop on prop.form_property_id = urn.form_property_id where form_code =";

	public static final String GETCOMPANYUSERLIST = "select distinct company_code as id,company_NAME as text  from company_master";
			
			/*"select distinct cu.company_code as id, COALESCE(cu.IS_PRIMARY,0) as baseCompany,"
			+ "cm.company_NAME as text from company_user cu  join company_master cm "
			+ "on cm.company_code = cu.company_code "
			+ "join user_rights_new urn "
			+ "on urn.company_user_id = cu.company_user_id "
			+ "join form_property fp on fp.form_property_id  = urn.form_property_id where fp.form_code = ? and cu.user_id = ? order by cu.company_code  asc";*/

	
	
	public static final String GETCOMPANYUSERLIST1 = "select COMPANY_CODE as id,company_name as text from company_master";
	
	public static final String GETCOMPANYUSERLISTSTAFFMAST = "select distinct cu.company_code as id, COALESCE(cu.IS_PRIMARY,0) as baseCompany, "
			+ " cm.SHORT_NAME as text from "
			+ " staff_master sm join company_user cu "
			+ " on cu.company_code = sm.company_code "
			+ " join company_master cm "
			+ " on cm.company_code = cu.company_code " 
			+ " join user_rights_new urn "
			+ " on urn.company_user_id = cu.company_user_id " 
			+ " join form_property fp on fp.form_property_id  = urn.form_property_id where fp.form_code = ? and cu.user_id = ?";

	public static final String sCheckEmployeeCompny = "select count(company_code) as ct from employee_master where company_code = ? and EMP_ID = ?";


	public static final String FORM_CODE_LIST_FROM_USER_RIGHTS = "SELECT FORM_CODE FROM FORM_PROPERTY WHERE FORM_PROPERTY_ID IN(SELECT FORM_PROPERTY_ID "
											+ "FROM "
											+ "USER_RIGHTS_NEW "
											+ "WHERE COMPANY_USER_ID = ?)";


	public static final String GET_FORM_MASTER_PARENT_LIST_BASE = "SELECT FORM_CODE,FORM_NAME,"
			+ " DISPLAY_ORDER,"
			+ "IMAGE_ICON_URL,"
			+ " MODULE_CODE,"
			+ "FORM_CODE_PARENT,"
			+ "FORM_URL,"
			+ " IS_PARENT FROM FORM_MASTER_NEW where MODULE_CODE IN (?) and FORM_CODE "
			+ "in(SELECT distinct FORM_CODE_PARENT"
			+ " FROM FORM_MASTER_NEW fm inner join FORM_PROPERTY fp on fm.FORM_CODE=fp.FORM_CODE"
			+ " inner join USER_RIGHTS_NEW ur on ur.FORM_PROPERTY_ID=fp.FORM_PROPERTY_ID"
			+ " inner join company_user cu on cu.company_user_id=ur.company_user_id where cu.is_primary=1) and IS_ACTIVE='Y' ";

	public static final String FORM_PROPERTY_LIST_FROM_USER_RIGHTS_CUSTOMER = "SELECT FORM_PROPERTY_ID FROM FORM_PROPERTY WHERE FORM_CODE in('F5608','F5605','F5612')";


	public static String GET_FORM_CODE_URL = "SELECT "
			+ "form_code, "
			+ "form_list_page_url "
			+ "FROM form_master_new "
			+ "where "
			+ "form_code is not null "
			+ "and "
			+ "form_list_page_url is not null and IS_ACTIVE='Y'";
	
	public static String GET_FORM_NAMES = "SELECT  concat(form_code, concat(' - ',form_name)) as text,concat(form_code, concat(' - ',form_name)) as id  FROM form_master_new where form_code is not null ";


	public static String GET_ADD_FORM_CODE_URL = "SELECT "
			+ "form_code, "
			+ "form_add_page_url "
			+ "FROM form_master_new "
			+ "where "
			+ "form_code is not null "
			+ "and "
			+ "form_add_page_url is not null and IS_ACTIVE='Y'";


	public static String MENU_MASTER = "SELECT MENU_ID, "
									+"  MENU_NAME, "
									+"  MENU_URL, "
									+"  MENU_PARENT_ID "
									+"FROM MENU_MASTER "
									+"ORDER BY MENU_PARENT_ID, "
									+"  MENU_SEQUENCE";


	public static String GET_COMPANY_ID_LIST = "SELECT COMPANY_CODE "
											+ "FROM "
											+ "COMPANY_USER "
											+ "WHERE USER_ID = ?";

	public static String GET_COMPANY_USER_ID = "SELECT COMPANY_USER_ID "
											+ "FROM "
											+ "COMPANY_USER "
											+ "WHERE  COMPANY_CODE = ? "
											+ "AND USER_ID = ? ";

	public static String INSERT_COMPANY_USER_ID = "INSERT INTO COMPANY_USER "
											+ "(USER_ID,COMPANY_CODE,IS_PRIMARY) "
											+ "VALUES (?,?,?) returning company_user_id";


	public static String GET_DESIGNATION_LIST = "SELECT DESGN_CODE ,"
			+ "DESGN_NAME,"
			+ " DESGN_DESC AS DESGN_DESC,  DESGN_CODE as id, (DESGN_NAME || '-' || DESGN_DESC) as text"
			+ " FROM"
			+ " DESIGNATION_MASTER WHERE DESGN_STATUS = 'Y'"
			+ " ORDER BY DESGN_NAME";

	public static String GET_COMPANY_LIST = "SELECT COMPANY_CODE ,"
			+ "LOCATION, COMPANY_CODE as id,case when is_operation='Y' then location ||' : '||SHORT_NAME ||'(OP)' else location ||' : '||SHORT_NAME end as text, LOCATION,"
			+ "COMPANY_NAME "
			+ "FROM "
			+ "COMPANY_MASTER "
			+ "ORDER BY LOCATION";

	public static String GET_COMPANY_BEAN = "SELECT COMPANY_CODE ,"
			+ "LOCATION, COMPANY_CODE as id, LOCATION as text,"
			+ "COMPANY_NAME "
			+ "FROM "
			+ "COMPANY_MASTER "
			+ "WHERE COMPANY_CODE = ?";

	public static String GET_USER_ITEM = "SELECT emp_id as user_id, "
											+ "emp_name as  user_name "
											+ "FROM "
											+ "employee_master "
											+ "WHERE emp_id = ?  ";

	public static String GET_USRLST_BY_COMPCODE = "SELECT emp_id as user_id, "
			+ "emp_id as id,"
			+ "(emp_id || '-' || emp_name) as  user_name,"
			+ "(emp_id || '-' || emp_name) as  text "
			+ "FROM "
			+ "employee_master "
			+ "WHERE "
			+ "DT_OF_LEAVE is null "
			+ "and "
			+ "status='Y' "
			+ "and "
			+ "company_code=? "
			+ "order by emp_name";

	public static String GET_USER_LIST = "SELECT emp_id as user_id, emp_id as id, (emp_id || '-' || emp_name) as text,emp_name as user_name FROM employee_master WHERE emp_id like '%E%' OR  emp_id like '%A%' and DT_OF_LEAVE is null and status='Y' order by emp_id asc";

	public static String GET_MODULE_MASTER_LIST ="SELECT MODULE_CODE, "
											+"  MODULE_NAME, MODULE_CODE AS id, MODULE_NAME as text, "
											+"  DISPLAY_ORDER, "
											+"  IMAGE_ICON_URL "
											+"FROM MODULE_MASTER WHERE MODULE_CODE != 'M0000'";

	public static String GET_FORM_MASTER_LIST_ALL = " SELECT "
			+"  FORM_CODE, "
			+"  FORM_NAME, "
			+"  DISPLAY_ORDER, "
			+"  IMAGE_ICON_URL, "
			+"  MODULE_CODE, "
			+"  FORM_CODE_PARENT, "
			+"  FORM_URL, "
			+"  IS_PARENT "
			+"FROM FORM_MASTER_NEW where IS_ACTIVE='Y' "
			+"ORDER BY DISPLAY_ORDER,FORM_CODE  asc";

	public static String GET_FORM_MASTER_LIST_ALL_AGENT = " SELECT "
			+"  FORM_CODE, "
			+"  FORM_NAME, "
			+"  DISPLAY_ORDER, "
			+"  IMAGE_ICON_URL, "
			+"  MODULE_CODE, "
			+"  FORM_CODE_PARENT, "
			+"  FORM_URL, "
			+"  IS_PARENT "
			+"FROM FORM_MASTER_NEW  where IS_ACTIVE='Y' "
			+"ORDER BY DISPLAY_ORDER,FORM_CODE  asc";

	public static String GET_FORM_MASTER_LIST = " SELECT "
			+"  FORM_CODE, "
			+"  FORM_NAME, "
			+"  DISPLAY_ORDER, "
			+"  IMAGE_ICON_URL, "
			+"  MODULE_CODE, "
			+"  FORM_CODE_PARENT, "
			+"  FORM_URL, "
			+"  IS_PARENT "
			+" FROM FORM_MASTER_NEW "
			+" WHERE MODULE_CODE IN ('M0000',?) and IS_ACTIVE='Y' "
			+" ORDER BY FORM_CODE ASC";


	public static String GET_FORM_MASTER_PARENT_LIST = " SELECT "
			+"  FORM_CODE, "
			+"  FORM_NAME, "
			+"  DISPLAY_ORDER, "
			+"  IMAGE_ICON_URL, "
			+"  MODULE_CODE, "
			+"  FORM_CODE_PARENT, "
			+"  FORM_URL, "
			+"  IS_PARENT "
			+" FROM FORM_MASTER_NEW "
			+" WHERE MODULE_CODE IN (?) "
			+" AND IS_PARENT = ? and IS_ACTIVE='Y' "
			+" ORDER BY FORM_CODE ASC";

	public static String GET_FORM_MASTER_CHILD_LIST = " SELECT "
			+"  FORM_CODE, "
			+"  FORM_NAME, "
			+"  DISPLAY_ORDER, "
			+"  IMAGE_ICON_URL, "
			+"  MODULE_CODE, "
			+"  FORM_CODE_PARENT, "
			+"  FORM_URL, "
			+"  IS_PARENT "
			+" FROM FORM_MASTER_NEW "
			+" WHERE MODULE_CODE = ? "
			+" AND FORM_CODE_PARENT = ?"
			+" AND IS_PARENT = ? and IS_ACTIVE='Y' "
			+" ORDER BY DISPLAY_ORDER ASC";


	public static String INSERT_COMPANY_TO_COMPANY = "INSERT INTO USER_RIGHTS_NEW "
													+"("
													+" COMPANY_USER_ID, "
													+" FORM_PROPERTY_ID "
													+") "
													+"SELECT ?, "
													+"FORM_PROPERTY_ID "
													+"FROM "
													+"USER_RIGHTS_NEW "
													+"WHERE "
													+"COMPANY_USER_ID = ?";

	public static String GET_PROPERTY_MASTER_LIST ="SELECT PROPERTY_CODE, "
												+ "PROPERTY_NAME "
												+ "FROM "
												+ "PROPERTY_MASTER "
												+ "ORDER BY DISPLAY_ORDER ASC";


	public static String GET_FORM_PROPERTY_LIST ="SELECT FORM_PROPERTY_ID,"
			+ "fp.FORM_CODE, "
			+ "fp.PROPERTY_CODE "
			+ "FROM "
			+ "FORM_PROPERTY fp "
			+ "inner join form_master_new f on f.form_Code = fp.form_code and IS_ACTIVE='Y' "
			+ "WHERE fp.FORM_CODE = ? "
			+ "ORDER BY PROPERTY_CODE ASC";

	public static String GET_FORM_PROPERTY_LIST_DESG ="SELECT fp.form_property_id, "
			+"  fp.form_code, "
			+"  fp.property_code, "
			+"  ( "
			+"  CASE NVL(dr.form_property_id,0) "
			+"    WHEN 0 "
			+"    THEN 'false' "
			+"    ELSE 'true' "
			+"  END) AS enabled "
			+"FROM form_property fp "
			+"LEFT JOIN "
			+"  (SELECT form_property_id FROM designation_rights WHERE desgn_code=:desgnCode "
			+"  ) dr "
			+"ON fp.form_property_id=dr.form_property_id "
			+"WHERE fp.FORM_CODE   IN (:formCodeSet) "
			+"ORDER BY fp.FORM_CODE";

	public static String GET_FORM_PROPERTY_LIST_COMPUSER ="SELECT fp.form_property_id, "
			+"  fp.form_code, "
			+"  fp.property_code, "
			+"  ( "
			+"  CASE NVL(ur.form_property_id,0) "
			+"    WHEN 0 "
			+"    THEN 'false' "
			+"    ELSE 'true' "
			+"  END) AS enabled "
			+"FROM form_property fp "
			+"LEFT JOIN "
			+"  (SELECT form_property_id FROM user_rights_new WHERE company_user_id=:companyUserId "
			+"  ) ur "
			+"ON fp.form_property_id=ur.form_property_id "
			+"WHERE fp.FORM_CODE   IN (:formCodeSet) "
			+"ORDER BY fp.FORM_CODE";

	public static String DELETE_FORM_PROPERTY_LIST_COMPUSER ="DELETE FROM "
											+ "USER_RIGHTS_NEW "
											+ "WHERE "
											+ "FORM_PROPERTY_ID IN  (:formPropertyId)"
											+ "AND "
											+ "COMPANY_USER_ID = :companyUserId";

	public static String DELETE_FORM_PROPERTY_LIST_USER = "DELETE "
											+"FROM USER_RIGHTS_NEW "
											+"WHERE COMPANY_USER_ID IN "
											+"  (SELECT COMPANY_USER_ID FROM COMPANY_USER WHERE USER_ID = ? "
											+"  )";

	public static String DELETE_FORM_PROPERTY_LIST_DESGN ="DELETE FROM "
											+ "DESIGNATION_RIGHTS "
											+ "WHERE "
											+ "FORM_PROPERTY_ID IN (:formPropertyId) "
											+ "AND "
											+ "DESGN_CODE = :desgnCode";


	public static String INSERT_FORM_PROPERTY_LIST ="INSERT INTO "
											+ "USER_RIGHTS_NEW "
											+ "(FORM_PROPERTY_ID,COMPANY_USER_ID) "
											+ "VALUES "
											+ "(?,?)";

	public static String INSERT_FORM_PROPERTY_LIST_DESGN_N_COMPUSER ="INSERT INTO "
											+ "USER_RIGHTS_NEW "
											+ "(FORM_PROPERTY_ID,COMPANY_USER_ID) "
											+ "SELECT FORM_PROPERTY_ID, ? FROM DESIGNATION_RIGHTS "
											+ "WHERE DESGN_CODE = ?";

	public static String INSERT_FORM_PROPERTY_LIST_DESGN ="INSERT INTO "
											+ "DESIGNATION_RIGHTS "
											+ "(FORM_PROPERTY_ID,DESGN_CODE) "
											+ "VALUES "
											+ "(?,?)";

	public static String FORM_CODE_SET_FROM_USER_RIGHTS ="SELECT DISTINCT FORM_CODE "
											+"FROM FORM_PROPERTY "
											+"WHERE FORM_PROPERTY_ID IN "
											+"(SELECT FORM_PROPERTY_ID FROM USER_RIGHTS_NEW WHERE COMPANY_USER_ID = ?)";

	public static String FORM_PROPERTY_LIST_FROM_USER_RIGHTS = "SELECT FORM_PROPERTY_ID "
											+ "FROM "
											+ "USER_RIGHTS_NEW "
											+ "WHERE COMPANY_USER_ID = ?";


	public static String FORM_PROPERTY_LIST_FROM_DESGN_RIGHTS = "SELECT FORM_PROPERTY_ID "
											+ "FROM "
											+ "DESIGNATION_RIGHTS "
											+ "WHERE DESGN_CODE = ?";

	public static String GET_USER = "SELECT um.user_id, "
			+ " case when em.vendor_name = 'V0007' then em.first_name else um.user_name end as user_name, um.user_name as user_name2,  "
			+ " um.user_password,  um.user_ref_flag,   em.EMAIL_ID,  coalesce(em.PROFILE_IMG, 'a0.jpg') as PROFILE_IMG,   em.company_code,   dpm.DEPT_NAME,  dm.DESGN_NAME,   em.port,em.vendor,em.vendor_name "
			+ "FROM user_master um  left join employee_master em on em.emp_id=um.user_id "
			+ "left JOIN DEPARTMENT_MASTER_new dpm "
										+"ON dpm.DEPT_CODE = em.DEPT "
										+"left JOIN DESIGNATION_MASTER_new dm "
										+"ON dm.DESGN_CODE = em.DESIGNATION "
										+"left JOIN COMPANY_MASTER cm "
										+"ON cm.company_code  = em.company_code "
										+"WHERE UPPER(user_id) = ? "
										+"AND em.DT_OF_LEAVE    IS NULL "
										+"AND em.status ='Y' "
										+"LIMIT           1 ";

	public static String GET_USER_CUSTOMER = "SELECT um.user_id, um.user_name,   um.user_password,  um.user_ref_flag FROM user_master um WHERE UPPER(user_id) = ? AND  active_inactive ='Y' LIMIT  1";

	public static String GET_USER_PERMISSION = "SELECT "
											+ "FORM_CODE, "
											+ "PROPERTY_CODE "
											+ "FROM "
											+ "FORM_PROPERTY "
											+ "WHERE FORM_PROPERTY_ID IN ("
											+ "SELECT FORM_PROPERTY_ID "
											+ "FROM "
											+ "USER_RIGHTS_NEW "
											+ "WHERE COMPANY_USER_ID = ?)";


	public static String GET_USER_PERMISSION_AGENT = "SELECT fm.FORM_CODE, PROPERTY_CODE FROM FORM_MASTER_NEW fm inner join FORM_PROPERTY fp on fp.FORM_CODE= fm.form_code   WHERE fm.FORM_CODE in('F5608','F5605','F5612') and IS_ACTIVE='Y'";

	/*public static void main(String[] args) {
			System.out.println(GET_USER);
	}*/
	
	public static String INSERT_USER_LOGIN_IP ="INSERT INTO USER_IP_LOGS (USER_ID,IP_ADDRS,CREATED_DT,ACTION) VALUES ( ?,?,?,?)";
	
	public static String  GET_EMP_NAME="select distinct company_master.short_name,user_id emp_id,emp_name,company_master.location companyrights,s.location,view_user_rights.company_code "+
 " from view_user_rights,company_master, company_master s where company_master.company_code=view_user_rights.company_code and "
 + "s.company_code=view_user_rights.empcompanycode  "+
 " ";
	
	public static String  GET_EMP_MODULE="select distinct module_master.module_code,module_master.module_name from form_master_new,module_master where form_code in ("+
			" select form_code from view_user_rights  where user_id=? and company_code=?) and module_master.module_code=form_master_new.module_code"+
			" order  by module_master.module_code ";
	
	public static String GET_EMP_RIGHTS="select * from view_user_rights  where user_id=? and module_code=? and company_code=?";

	public static String getcount="select count(*) from employee_master where emp_id=?";

	public static String update_COMPANY_USER_ID = "update company_user set mode = ? where user_id = ? and company_code=? returning company_user_id";

	public static final String count = "select count(*) from employee_master where emp_id=? ";

	public static final String email = "select email_id from employee_master where emp_id=? ";

	public static final String password = "select password from employee_master where emp_id=? ";

	public static final String userName = "select first_name from employee_master where emp_id=? ";
	
	public static final String emp_list = "select emp_id as userId,emp_name as username,email_id as email,password as password  from employee_master";

	public static final String PMT_INV_DTL ="select count(*) from cb_payment_invoice_dtl where invoice=? ";
	
	public static final String RECEIPT_DTL ="select count(*) from cb_receipt_invoice_dtl where invoice=? ";

	public static final String SeaSalesInvoiceList="select sls_invc_no_tcd as id,sls_invc_no_tcd as text from sea_sales_invoice order by sls_invc_no_tcd asc";
	
	public static final String AirSalesInvoiceList="select sls_invc_no_tcd as id,sls_invc_no_tcd as text from air_sales_invoice order by sls_invc_no_tcd asc";
	
    public static final String SeaPurchaseInvoiceList="select prchs_invc_no_tcd as id,prchs_invc_no_tcd as text from sea_purchase_invoice order by prchs_invc_no_tcd";
	
	public static final String AirPurchaseInvoiceList="select prchs_invc_no_tcd as id,prchs_invc_no_tcd as text from air_purchase_invoice order by prchs_invc_no_tcd";

	public static final String INSERT_COMPANY_USER_IDnew =  "INSERT INTO COMPANY_USER "
			+ "( COMPANY_CODE,USER_ID,IS_PRIMARY,mode) "
			+ "VALUES (?,?,?,?) returning company_user_id";

}
