package com.dci.tenant.finance.staffcircular;

public class StaffCircularQueryUtil {
	public static final String GET_DEPARTMENT_LIST = "select dept_code as id,dept_name as text from department_master";

	public static final String GET_DESIGNATION_LIST = "select desgn_code as id,desgn_name as text from designation_master";

	public static final String GET_DIVISION_LIST = "select desgn_code as id,desgn_name as text from designation_master";

	public static final String GET_REPORTINGTO_LIST = "select *,(select first_name from employee where employee_id=id)as text from(select distinct reporting_to as id from employee where reporting_to is not null) as t1";

	public static final String GET_GRADE_LIST = "select grade_id as id,name as text from grade";

	public static final String SAVE_NOTIFICATION = "insert into sc_staff_circular(content,created_by,created_date,status,from_date,to_date,title)values(?,?,now(),'Pending',?,?,?) returning sc_staff_circular_id ";

	public static final String SAVE_NOTIFICATION1 = "insert into sc_staff_circular_detail(department_id,sc_staff_circular_id)values(?,?)";

	public static final String SAVE_NOTIFICATION2 = "insert into sc_staff_circular_detail(division_id,sc_staff_circular_id)values(?,?)";

	public static final String SAVE_NOTIFICATION3 = "insert into sc_staff_circular_detail(designation_id,sc_staff_circular_id)values(?,?)";

	public static final String SAVE_NOTIFICATION4 = "insert into sc_staff_circular_detail(grade_id,sc_staff_circular_id)values(?,?)";

	public static final String UPDATE_NOTIFICATION = "update sc_staff_circular set content=?,title = ?,modified_by=?,modified_date=now(),from_date=?,to_date=? where sc_staff_circular_id=? ";

	public static final String DELETE_NOTIFICATION = "delete from sc_staff_circular_detail where sc_staff_circular_id=?";

	//public static final String GET_LIST = "select  sm.sc_staff_circular_id as staffCircularId,title as title, content as notificationContent,sm.created_by as createdBy,to_char(sm.created_date,'dd/mm/yyyy')  as createdDate,sm.status as status,(select string_agg((select department_name from department where department_id=smd.department_id)::text,', ') from sc_staff_circular_detail smd where smd.sc_staff_circular_id in (select regexp_split_to_table(sm.sc_staff_circular_id::text,',','i')::int)) as departmentName,(select string_agg((select division_name from division where division_id=smd.division_id)::text,', ') from sc_staff_circular_detail smd where smd.sc_staff_circular_id in (select regexp_split_to_table(sm.sc_staff_circular_id::text,',','i')::int)) as divisionName,(select string_agg((select designation_name from designation where designation_id=smd.designation_id)::text,', ') from sc_staff_circular_detail smd where smd.sc_staff_circular_id in (select regexp_split_to_table(sm.sc_staff_circular_id::text,',','i')::int)) as designationName,(select string_agg((select name from grade where grade_id=smd.grade_id)::text,', ') from sc_staff_circular_detail smd where smd.sc_staff_circular_id in (select regexp_split_to_table(sm.sc_staff_circular_id::text,',','i')::int)) as gradeName,(select string_agg((select distinct reporting_to from employee where reporting_to=smd.reporting_to)::text,', ') from sc_staff_circular_detail smd where smd.sc_staff_circular_id in (select regexp_split_to_table(sm.sc_staff_circular_id::text,',','i')::int)) as reportingToName,sm.sc_staff_circular_id from sc_staff_circular sm left join sc_staff_circular_detail smdt on smdt.sc_staff_circular_id=sm.sc_staff_circular_id left join department d on d.department_id=smdt.department_id left join division st on st.division_id=smdt.division_id left join designation sb on sb.designation_id=smdt.designation_id left join grade sg on sg.grade_id=smdt.grade_id left join employee em on em.reporting_to =smdt.reporting_to group by sm.sc_staff_circular_id";

	public static final String GET_LIST = "select s.sc_staff_circular_id as staffCircularId ,s.content as publish,s.created_by as createdBy,s.created_date as createdDate,s.status as status, "
          + " s.from_date as fromDate,s.to_date as toDate,s.title as title from sc_staff_circular s ";
	
	public static final String EDIT_DETAIL = "select  sc_staff_circular_id as staffNotificationId, content as notificationContent, from_date as fromDate,to_date as toDate,created_by as createdBy,title as title from sc_staff_circular where sc_staff_circular_id=?";

	public static final String EDIT_DETAIL2 = "select sc_staff_circular_detail as staffNotificationDetailId,designation_id as designation from sc_staff_circular_detail where sc_staff_circular_id=? and designation_id is not null";

	public static final String EDIT_DETAIL1 = "select sc_staff_circular_detail as staffNotificationDetailId,department_id as department from sc_staff_circular_detail where sc_staff_circular_id=? and  department_id is not null";

	public static final String EDIT_DETAIL3 = "select sc_staff_circular_detail as staffNotificationDetailId,division_id as division from sc_staff_circular_detail where sc_staff_circular_id=? and  division_id is not null";

	public static final String EDIT_DETAIL4 = "select sc_staff_circular_detail as staffNotificationDetailId,grade_id as grade from sc_staff_circular_detail where sc_staff_circular_id=? and  grade_id is not null";

	public static final String EDIT_DETAIL5 = "select sc_staff_circular_detail as staffNotificationDetailId,reporting_to as reporting from sc_staff_circular_detail where sc_staff_circular_id=? and reporting_to<>''";

	public static final String GET_EMPLOYEE_REPORT_LIST = "select phone as phoneNo from employee";

	public static final String GET_DETAIL_LIST = "";

	public static final String UPDATE_STATUS = "update sc_staff_circular set status='Send' where sc_staff_circular_id=?";

	public static final String DELETE_NOTIFICATION1 = "delete from sc_staff_circular where sc_staff_circular_id=?";

	public static final String SAVE_SMS_LOG = "insert into sc_sms_log(form_name,recipient,user_id,date_time,message,status)values('Staff Notification',?,?,now(),?,'Success')";

}
