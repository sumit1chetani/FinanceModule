package com.dci.tenant.auditlog;

public class UserLogQueryUtil{

	public static String SELECT_UserIPLog(String wherCondition){
		return "select USER_ID employeeId,CREATED_DT logdate ,IP_ADDRS ipAddres,ACTION actionType from USER_IP_LOGS"+wherCondition;
	}
	
	
	public static final String SELECT_USER_LOG_FORM_CODE = "select form_code as id, concat(form_code,' - ',form_name) as text  from form_master_new order by id asc ";

	
	public static final String SELECT_EMPLOYEE_LIST = "select emp_id as id, concat(emp_id,' - ',emp_name) as text  from employee_master order by id asc ";

	
	public static final String INSERT_USER_LOG = "INSERT INTO user_log_master(employee_id, log_date, primary_data_id, form_code,table_name, action_type, log_description,userip) VALUES(:employeeId,now(),:primaryDataId,:formCode,:tableName,:actionType,:logDesc,:userip)";

	
	public static final String getUserLogList(String fromDate, String toDate, String employeeNo, String formCode,String actionType) {
		String SELECT_AUDITLOG_LIST = "SELECT al.employee_id ||'-'||e.emp_name as employeeName, al.action_type actionType,al.primary_data_id as primaryDataId, f.form_name formName, to_char(al.log_date,'DD/MM/YYYY hh:MI:ss') logDate, al.log_description logDescription,al.user_log_master_id userLogId, userip as userIpAddress FROM user_log_master  al " + "inner join employee_master e on e.emp_id = al.employee_id inner join form_master_new f on f.form_code = al.form_code";
		if ((fromDate != null && !fromDate.isEmpty()) || (toDate != null && !toDate.isEmpty()) 
			|| (employeeNo != null && !employeeNo.isEmpty()) || (formCode != null && !formCode.isEmpty()) || (actionType != null && !actionType.isEmpty())) {
			SELECT_AUDITLOG_LIST += " WHERE ";
		}
		boolean isWhere = true;
		if (fromDate != null && !fromDate.isEmpty()) {
			isWhere = false;
			if (toDate != null && !toDate.isEmpty()) {
				SELECT_AUDITLOG_LIST += " log_date::date between to_date('" + fromDate + "','dd/MM/yyyy')";
				SELECT_AUDITLOG_LIST += " and to_date('" + toDate + "','dd/MM/yyyy')";
			}else{
				toDate = fromDate;
				SELECT_AUDITLOG_LIST += " log_date::date between to_date('" + fromDate + "','dd/MM/yyyy')";
				SELECT_AUDITLOG_LIST += " and to_date('" + toDate + "','dd/MM/yyyy')";
			}
		}
		if (employeeNo != null && !employeeNo.isEmpty()) {
			if (!isWhere) {
				SELECT_AUDITLOG_LIST += " and al.employee_id = '" + employeeNo + "'";
			}else{
				SELECT_AUDITLOG_LIST += " al.employee_id = '" + employeeNo + "'";	
				isWhere = false;
			}
		}
		if (formCode != null && !formCode.isEmpty()) {
			if (!isWhere) {
				SELECT_AUDITLOG_LIST += " and al.form_code='" + formCode + "'";
			}else{
				SELECT_AUDITLOG_LIST += "  al.form_code='" + formCode + "'";
				isWhere = false;
			}
		}
		if(actionType != null && !actionType.isEmpty()){
			if (!isWhere) {
				SELECT_AUDITLOG_LIST += " and al.action_type='"+actionType+"'";
			}else{
				SELECT_AUDITLOG_LIST += "  al.action_type='"+actionType+"'";
				isWhere = false;
			}
		}
		
		SELECT_AUDITLOG_LIST += " order by log_date desc";
		return SELECT_AUDITLOG_LIST;
	}


}
