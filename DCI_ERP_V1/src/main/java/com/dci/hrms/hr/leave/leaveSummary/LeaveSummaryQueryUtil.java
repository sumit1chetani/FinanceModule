package com.dci.hrms.hr.leave.leaveSummary;

public class LeaveSummaryQueryUtil {

	public static String getLeaveSummaryDetails = "SELECT  Leave_Request.Leave_Type as leaveCode, to_char(Leave_Request.Date_From,'DD/MM/YYYY') AS dateFrom, to_char(Leave_Request.Date_To,'DD/MM/YYYY') AS dateTo, Leave_Request.Number_Of_Days as noOfDays, "
			+ "to_char(Leave_Request.Applied_On,'DD/MM/YYYY') AS appliedOn, Leave_Request_Action.action_by as approvedBy, Leave_Request_Action.status as status FROM    Leave_Request INNER JOIN "
			+ "Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id WHERE Leave_Request.Leave_Type=? AND Leave_Request.Employee_Id=?";
	
	public static String getApprovedBy = "select first_name from employee where employee_id=?";

}
