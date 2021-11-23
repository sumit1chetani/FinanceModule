package com.dci.finance.permissionApproval;

public class PermissionApprovalCancellationQueryUtil {

	public static final String reporting_to = "select reporting_to from employee where employee_id = ?";

	public static String sViewPermissionRequest = "select permission_request_id permissionrequestid,employee.first_name requestedby,permission_date permissiondate,requested_date requesteddate,reason reason,from_time fromtime,to_time totime,permission_request.status status,remarks remarks from permission_request inner join employee_master employee on employee.emp_id=permission_request.requested_by where employee.reporting_to=? order by requested_date desc";

	public static String sViewRecentRequst = "select permission_request_id permissionrequestid,requested_by requestedby,permission_date permissiondate,requested_date requesteddate,reason reason,from_time fromtime,to_time totime,status status,remarks remarks from permission_request where status='0' ORDER BY requested_date DESC LIMIT 3";

	public static String sEditPermissionRequestApproval = "SELECT permission_request_id permissionrequestid,permission_date permissiondate,requested_by requestedby,requested_date requesteddate,from_time hoursfrom,to_time hoursto,reason reason, remarks remarks,permission_request.status status FROM permission_request inner join employee_master  employee on employee.emp_id=permission_request.requested_by where employee.reporting_to=? and permission_request_id =?";

	public static String sUpdatePermissionRequestApproval = "UPDATE permission_request SET  remarks=:remarks,status=:status,approved_by=:reporting,approved_date=now() WHERE permission_request_id=:id";

}
