package com.dci.finance.leaveApproval;

public class LeaveAppCancelQueryUtil {

	public static final String reporting_to = "select distinct emp_id as empId from employee_master where reporting_to = ?";
/*	public static final String leaveListQuery = "SELECT     LQA.Leave_Request_Id as leaveRequestId, LQA.Action as action ,LQA.Status as status,LQA.Comments as comments, E.emp_id as empId, "
			+ "E.emp_name as firstName, LT.Short_Name as leaveType, to_char(LQ.Date_From,'DD/MM/YYYY') as dateFrom, "
			+ "to_char( LQ.Date_To ,'DD/MM/YYYY') as dateTo, LQ.Number_Of_Days as nofDays, LQ.Reason as reason, "
			+ "      LQ.Applied_On as appliendOn, LQ.Half_From as halfFrom, LQ.Half_To as halfTo, LQ.Medical_Document_URL as mdUrl, LQ.IsHoliday as isHoliday "
			+ "           FROM         Leave_Request_Action AS LQA "
			+ "           INNER JOIN   Leave_Request AS LQ ON LQ.Leave_Request_Id = LQA.Leave_Request_Id "
			+ "            INNER JOIN  Employee_master AS E ON LQ.emp_id = E.emp_id "
			+ "            LEFT OUTER JOIN     Leave_Type AS LT ON LT.Short_Name = LQ.Leave_Type "
			+ "           Where E.Reporting_To= ? ORDER BY E.Employee_Id";
	*/
	
/*	public static final String leaveListQuery ="select leave_request_id as leaveRequestId,l.emp_id as empId,leave_type,date_from as dateFrom,date_to as dateTo,number_of_days as nofDays,reason as reason, "
	+ "			           leave_address,leave_phone,leave_mobile,half_from as halfFrom,half_to as halfTo,applied_on as appliedOn,isholiday as isHoliday,e.emp_name as firstName,coalesce(l.status,0) as status"
	+ "			            from Leave_Request l "
	+ "			           left join employee_master e on e.emp_id=l.emp_id where e.emp_id=?";
	*/
	public static final String leaveListQuery ="select leave_request_id as leaveRequestId,l.employee_id as empId,leave_type,to_char(date_from,'dd/mm/yyyy') as dateFrom,to_char(date_to,'dd/mm/yyyy') as dateTo,number_of_days as nofDays,reason as reason, "
			+ "	leave_address,leave_phone,leave_mobile,half_from as halfFrom,half_to as halfTo,to_char(applied_on,'dd/mm/yyyy') as appliedOn,isholiday as isHoliday,e.emp_name as firstName,coalesce(l.status,0) as status  "
				+ "	from Leave_Request l  "
				+ "	 left join employee_master e on e.emp_id=l.employee_id where e.emp_id=? ";
	
/*	public static final String editListQuery = "SELECT  LQA.action,LQA.Leave_Request_Id , E.Employee_Id as empId, E.First_Name as firstName, LT.Short_Name as leaveType, to_char( LQ.Date_From ,'DD/MM/YYYY') as dateFrom,  to_char(LQ.Date_To,'DD/MM/YYYY') as dateTo , LQ.Reason as reason, " + "      to_char(LQ.Applied_On ,'DD/MM/YYYY') as appliedOn, LQ.Half_From as halfFrom, LQ.Half_To as halfTo, LQA.status as status, LQA.description as descrip " + "      FROM         Leave_Request_Action AS LQA INNER JOIN " + "      Leave_Request AS LQ ON LQ.Leave_Request_Id = LQA.Leave_Request_Id INNER JOIN "
			+ "      Employee AS E ON LQ.Employee_Id = E.Employee_Id LEFT OUTER JOIN " + "      Leave_Type AS LT ON LT.Short_Name = LQ.Leave_Type " + "      Where E.Reporting_To= ? and  LQA.leave_request_id= ?";

	*/
/*	public static final String editListQuery =" select leave_request_id as leaveRequestId,l.emp_id as empId,leave_type,to_char(date_from,'dd/mm/yyyy') as dateFrom,to_char(date_to,'dd/mm/yyyy') as dateTo,number_of_days as nofDays,reason as reason, "
                   + " leave_address,leave_phone,leave_mobile,half_from as halfFrom,half_to as halfTo,applied_on as appliedOn,isholiday as isHoliday,e.emp_name as firstName,coalesce(l.status,0) as status "
                   + "  from Leave_Request l "
                   + "   left join employee_master e on e.emp_id=l.emp_id where e.emp_id=? and  leave_request_id=? ";
	*/
	public static final String updateLeaveReportQuery = "UPDATE Leave_Request_Action SET Action_datetime= ?,Action_by= ?,Comments= ?,Status= ?,description= ?, approval_type=3, report_emp_date=now()  WHERE Leave_Request_Id =?";

	public static final String editListQuery ="select leave_request_id as leaveRequestId,l.employee_id as empId,leave_type,to_char(date_from,'dd/mm/yyyy') as dateFrom,to_char(date_to,'dd/mm/yyyy') as dateTo,number_of_days as nofDays,reason as reason,  leave_address,leave_phone,leave_mobile,half_from as halfFrom,half_to as halfTo,to_char(applied_on,'dd/mm/yyyy') as appliedOn,isholiday as isHoliday,e.emp_name as firstName,coalesce(l.status,0) as status  from Leave_Request l    left join employee_master e on e.emp_id=l.employee_id where  leave_request_id=? ";

	public static final String updateLeaveQuery = "UPDATE Leave_Request_Action SET Action_datetime= ?,Action_by= ?,Comments= ?,Status= ?,description=?,action=? WHERE Leave_Request_Id =?";
	public static final String updateLeaveQueryleve = "UPDATE leave_request SET Status= ? ,approved_by=?  WHERE Leave_Request_Id =?";

	
	public static final String getHolidayId = "select holiday_work_request.leave_request_id from holiday_work_request where  Leave_Request_Id= ?";
	
	public static final String updateLeaveAlternateQuery = "UPDATE Leave_Request_Action SET Action_datetime= ?,Action_by= ?,Comments= ?,alternate_emp_approval_status= ?,description= ?, approval_type=2,alternate_emp_date=now()  WHERE Leave_Request_Id =?";

	public static final String updateLeaveRequest = "update leave_request set pay_type=? where leave_request_id=?";
	
	public static final String updateLeaveFinalQuery = "UPDATE Leave_Request_Action SET Action_datetime= ?,Action_by= ?,Comments= ?,final_approval_status= ?,description= ?,action= ?,final_emp_date=now() WHERE Leave_Request_Id =?";

	public static String get_frst_reporting_manager_approval_List="SELECT 1 as stepOrder,leave_request_id  as leaveRequestId,employee_id as empId, TO_CHAR(applied_on,'dd/mm/yyyy') as appliedOn,em.first_name as firstName,leave_type as leaveType, to_char(date_from,'dd/mm/yyyy') as dateFrom,to_char(date_to,'dd/mm/yyyy') as dateTo,number_of_days as nofDays,reason as reason,tr.status as status, (select concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) from user_master where user_id=created_by) as requestBy From leave_request tr left join user_master on user_master.user_id =tr.employee_id inner join employee_master em on em.emp_id=tr.employee_id "
			+ "where em.reporting_to=? ORDER BY applied_on DESC";
			

	public static String get_frst_approval_List="SELECT ? as stepOrder,leave_request_id as leaveRequestId, TO_CHAR(applied_on,'dd/mm/yyyy') as appliedOn, "
			+ "					employee_id as empId,leave_type,to_char(date_from,'dd/mm/yyyy') as dateFrom,to_char(date_to,'dd/mm/yyyy') 		 as dateTo,number_of_days as nofDays,reason as reason, "
			+ "			 (select employee_master.first_name from employee_master where emp_id=employee_id) as FirstName, "
			+ "			leave_type as requestType, coalesce(leave_request.status,0) as status , (select concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) from user_master where user_id=created_by) as requestBy "
			+ "			From leave_request left join user_master on user_master.user_id =leave_request.created_by";

	public static String workFlowCountInTravelTable="select count(*) from leave_work_flow where leave_id=? and step_id=?";

	public static String update_travel_workflow="update leave_work_flow set status=?,remarks=?,role_name_user=? where leave_id=? and step_id=?";

	public static String insert_travel_workflow="insert into leave_work_flow (leave_id,step_id,step_name,approve_type,role_name_user,status,remarks,created_by,created_on) values (?,?,?,?,?,?,?,?,now())";

	public static String get_reportingPersonCount="SELECT count(*) From leave_request tr left join user_master on user_master.user_id =tr.created_by inner join employee_master em on em.emp_id=tr.employee_id inner join leave_work_flow twf on twf.leave_id=tr.leave_request_id where em.reporting_to=? and twf.step_id=? and twf.status=1 ";

	public static String get_nxt_reporting_manager_approval_List="SELECT ? as stepOrder,leave_request_id as requestId, TO_CHAR(applied_on,'dd/mm/yyyy') as requestDate,em.first_name as firstName,leave_type as leaveType, coalesce(tr.status,0) as status,employee_id as empId,leave_type,to_char(date_from,'dd/mm/yyyy') as dateFrom,to_char(date_to,'dd/mm/yyyy') 		 as dateTo,number_of_days as nofDays,reason as reason, (select concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) from user_master where user_id=created_by) as requestBy From leave_request tr left join user_master on user_master.user_id =tr.created_by inner join employee_master em on em.emp_id=tr.employee_id inner join leave_work_flow twf on twf.leave_id=tr.leave_request_id where em.reporting_to=? and twf.step_id=? and twf.status=1 ORDER BY applied_on DESC";	
			
			
			
	public static String get_nxt_approval_List="SELECT ? as stepOrder,leave_request_id as leaveRequestId, TO_CHAR(applied_on,'dd/mm/yyyy') as appliedOn,em.first_name as firstName,leave_type as leaveType,leave_type,to_char(date_from,'dd/mm/yyyy') as dateFrom,to_char(date_to,'dd/mm/yyyy') 		 as dateTo,number_of_days as nofDays,reason as reason, \n" + 
			"employee_id as empId,\n" + 
			"coalesce(tr.status,0) as status, (select concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) from user_master where user_id=created_by) as requestBy From leave_request tr left join user_master on user_master.user_id =tr.created_by inner join employee_master em on em.emp_id=tr.employee_id inner join leave_work_flow twf on twf.leave_id=tr.leave_request_id where twf.step_id=?";
	public static final String SELECT_EMP_ID = "select user_ref_id_emp from user_master where user_id=?";


}
