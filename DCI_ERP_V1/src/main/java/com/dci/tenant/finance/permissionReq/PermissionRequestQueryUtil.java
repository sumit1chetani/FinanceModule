package com.dci.tenant.finance.permissionReq;

public class PermissionRequestQueryUtil {

	public static String sAddPermissionRequest = "INSERT INTO permission_request (requested_by,emp_name,requested_date,reason,approved_by,approved_date,permission_date,from_time,to_time,remarks,status)VALUES(:employeeno,:userName,now(),:reason,null,null,to_date(:permissiondate,'dd/mm/yyyy'),:hoursfrom::time,:hoursto::time,null,'0')";

	public static String sViewPermissionRequest = "select permission_request_id permissionrequestid,employee_master.first_name requestby,permission_date permissiondate,from_time hoursfrom,to_time hoursto,reason reason,permission_request.status status,requested_date requestdate from permission_request inner join employee_master on permission_request.requested_by=employee_master.emp_id where permission_request.requested_by=? order by requestdate  desc ";

	public static String sEditPermissionRequest = " SELECT requested_by employeeno,emp_name userName, permission_request_id permissionrequestid,permission_date permissiondate,from_time hoursfrom,to_time hoursto,reason reason FROM permission_request where permission_request_id =?";

	public static String sUpdatePermissionRequest = "UPDATE permission_request SET  permission_date=to_date(:permissiondate,'dd/mm/yyyy'),from_time=:hoursfrom::time,to_time=:hoursto::time,emp_name=:userName,reason=:reason WHERE permission_request_id=:permissionrequestid";

	public static String sDeletePermissionRequest = "DELETE  FROM permission_request WHERE permission_request_id = ?";

	public static String sChecPermission = "SELECT count(*) FROM permission_request WHERE permission_date =to_date(?,'dd/mm/yyyy')";

	public static String cChecHoliday = "select count(*)  from holiday where holiday_date =?";

	public static String sChecPermissionDate = "SELECT count(*) FROM permission_request WHERE permission_date =to_date(?,'dd/mm/yyyy') AND permission_request_id!=? AND  requested_by=?";

	//public static String getEmployeeShiftDetails = "select es.shift_date,e.first_name as empName, e.emp_id as empId,s.shift_id,s.shift_name,s.code,s.start_time,s.end_time " + " from employee_master e " + "inner join employee_shift es on e.emp_id = es.employee_id " + "inner join shift s on es.shift_id = s.shift_id " + "where e.emp_id =? and es.shift_date=to_date(?,'DD/MM/YYYY')";
	
	public static String getEmployeeShiftDetails = "select shift_id as id,shift_name as shiftName,start_time as startTime,end_time as endTime from shift where emp_id=? ";

	public static final String to_Email = "select e.email from employee_master e inner join employee_master e1 on e1.reporting_to = e.emp_id where e1.emp_id = ?";

	public static final String to_Email1 = "select count(e.email) from employee_master e inner join employee_master e1 on e1.reporting_to = e.emp_id where e1.emp_id = ?";

	public static final String name = "select first_name from employee_master where emp_id = ?";

	public static final String toName = "select e.first_name from employee_master e inner join employee_master e1 on e1.reporting_to = e.emp_id where e1.emp_id = ?";

	public static final String getTemplateContent = "select html_version from campaign_template where campaign_template_id = 4";

	public static final String getTemplateContentcheck = "select count(html_version) from campaign_template where campaign_template_id = 4";
}
