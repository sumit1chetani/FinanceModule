package com.dci.tenant.finance.staffnotification;

public class StaffNotificationQueryUtil {

	public static final String GET_DEPARTMENT_LIST = "select dept_code as id,dept_name as text from department_master";

	public static final String GET_DESIGNATION_LIST = "select desgn_code as id,desgn_name as text from designation_master";

	public static final String GET_DIVISION_LIST = "select desgn_code as id,desgn_name as text from designation_master";

	public static final String GET_REPORTINGTO_LIST = "select *,(select first_name from employee_master where emp_id=id)as text from(select distinct reporting_to as id from employee_master where reporting_to is not null) as t1";

	public static final String GET_GRADE_LIST = "select grade_id as id,name as text from grade";

	// public static final String SAVE_NOTIFICATION =
	// "insert into sc_staff_notification(content,from_date,to_date,created_by,created_date,status)values(?,?,?,?,now(),'Pending') returning sc_staff_notification_id ";

	public static final String SAVE_NOTIFICATION = "insert into sc_staff_notification(content,created_by,created_date,status)values(?,?,now(),'Pending') returning sc_staff_notification_id ";

	public static final String SAVE_NOTIFICATION1 = "insert into sc_staff_notification_detail(department_id,sc_staff_notification_id)values(?,?)";

	public static final String SAVE_NOTIFICATION2 = "insert into sc_staff_notification_detail(division_id,sc_staff_notification_id)values(?,?)";

	public static final String SAVE_NOTIFICATION3 = "insert into sc_staff_notification_detail(designation_id,sc_staff_notification_id)values(?,?)";

	public static final String SAVE_NOTIFICATION4 = "insert into sc_staff_notification_detail(grade_id,sc_staff_notification_id)values(?,?)";

	public static final String UPDATE_NOTIFICATION = "update sc_staff_notification set content=?,modified_by=?,modified_date=now() where sc_staff_notification_id=? ";

	public static final String DELETE_NOTIFICATION = "delete from sc_staff_notification_detail where sc_staff_notification_id=?";

	public static final String GET_LIST = "select s.sc_staff_notification_id as staffNotificationDetailId,s.content as notificationContent,s.created_by as createdBy,created_date as createdDate,s.status as status, "
     + " e.emp_name as credtedBy "
     + " from sc_staff_notification s "
     + " left join employee_master e on s.created_by=e.emp_id ";

	public static final String EDIT_DETAIL = "select  sc_staff_notification_id as staffNotificationId, content as notificationContent,created_by as createdBy from sc_staff_notification where sc_staff_notification_id=?";

	public static final String EDIT_DETAIL2 = "select sc_staff_notification_detail as staffNotificationDetailId,designation_id as designation from sc_staff_notification_detail where sc_staff_notification_id=? and designation_id is not null";

	public static final String EDIT_DETAIL1 = "select sc_staff_notification_detail as staffNotificationDetailId,department_id as department from sc_staff_notification_detail where sc_staff_notification_id=? and  department_id is not null";

	public static final String EDIT_DETAIL3 = "select sc_staff_notification_detail as staffNotificationDetailId,division_id as division from sc_staff_notification_detail where sc_staff_notification_id=? and  division_id is not null";

	public static final String EDIT_DETAIL4 = "select sc_staff_notification_detail as staffNotificationDetailId,grade_id as grade from sc_staff_notification_detail where sc_staff_notification_id=? and  grade_id is not null";

	public static final String EDIT_DETAIL5 = "select sc_staff_notification_detail as staffNotificationDetailId,reporting_to as reporting from sc_staff_notification_detail where sc_staff_notification_id=? and reporting_to<>''";

	public static final String GET_EMPLOYEE_REPORT_LIST = "select phone as phoneNo from employee";

	public static final String GET_DETAIL_LIST = "";

	public static final String UPDATE_STATUS = "update sc_staff_notification set status='Send' where sc_staff_notification_id=?";

	public static final String DELETE_NOTIFICATION1 = "delete from sc_staff_notification where sc_staff_notification_id=?";

	public static final String SAVE_SMS_LOG = "insert into sc_sms_log(form_name,recipient,user_id,date_time,message,status)values('Staff Notification',?,?,now(),?,'Success')";

	public static final String UPDATE = "update sc_staff_notification set flag=? where sc_staff_notification_id=? ";

	public static final String UPDATE_unPublish = "update sc_staff_notification set flag=? where sc_staff_notification_id=? ";

}
