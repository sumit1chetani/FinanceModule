package com.dci.tenant.designation;



public class DesignationQueryUtil {

	public static String sGetDesignationValues = "select desgn_code as desgnCode, desgn_name as desgnName, desgn_status as isActive from designation_master_new order by desgn_code desc";

	public static String getDesgnIdAutoIncrement = "SELECT CASE WHEN MAX(desgn_code) IS NULL  THEN 'DS001' ELSE rpad(MAX(desgn_code),2,'DS')|| lpad(cast(cast((SUBSTRING(MAX(desgn_code),3)) as int)+1  as text),3,'0') END FROM designation_master_new";

	public static String sInsertDesgnDetails = "insert into designation_master_new (desgn_code, desgn_name, desgn_status, desgn_desc, created_by, created_dt )  values (?,?,?,?,?,current_timestamp)";

	public static String sDeleteDesgnDetail = " delete from designation_master_new where desgn_code = ? ";

	public static String sUpdateDesgn = "update designation_master_new set desgn_name =?, desgn_status =? where desgn_code = ?";

	public static String sDesignationDropDown = "select desgn_name from designation_master_new order by DESGN_NAME asc";

	public static String sEditDesignation = "select desgn_name as desgnName, desgn_status as isActive from designation_master_new where desgn_code = ?";

	public static String sCheckDesignationAdd = "SELECT count(*) FROM designation_master_new WHERE desgn_name=?";

	public static String sCheckDesignationUpdate = "SELECT count(*) FROM designation_master_new WHERE desgn_code<>? and desgn_name=?";
}
