package com.dci.finance.leaverequest;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class LeaveRequestQueryUtil {

/*	public static final String getLeaveRequestQuery = "SELECT Leave_Request.Leave_Request_Id as leaveRequestId , case when middle_name!='' then concat(E.emp_id,' - ',E.first_name,' ',E.middle_name,' ',E.surname) else concat(E.emp_id,' - ',E.first_name,' ',E.surname) end as empName,Leave_Request.Employee_Id,to_char(Date_From,'DD/MM/YYYY')  as fromDate,to_char(Date_To,'DD/MM/YYYY') toDate,Number_Of_Days as noOfDays,Reason as leaveReason,Leave_Address  as leaveAddress,Leave_Phone as leavePhone,Leave_Mobile as leaveMobile,E.First_Name,(select employee_id||' - '||first_name||' '||surname from employee_master where Employee_id = Leave_Request.Alternative_Employee) as alternativeEmployeeName, "
			+ "			 Leave_Request_Action.Approval_Type as approvalType, Leave_Type.short_name as Leave_Type_Name,Leave_Request.Leave_Type as leaveType, "
			+ "			 Leave_Request.Half_From,Leave_Request.Half_To,Leave_Request.IsHoliday, Leave_request_Action.alternate_emp_approval_status as alternateEmpStatus, Leave_Request_Action.status as action, Leave_Request_Action.final_approval_status as finalEmpStatus, Leave_Request.cancel_request as cancelRequest, leave_deduct as leaveDeduct, Leave_Request.created_by as Created_by, created_on as Created_on, Leave_Request.modified_by as Modified_by, modified_on as Modified_on FROM Leave_Request INNER JOIN	employee_master E ON Leave_Request.Employee_Id = E.emp_id "
			+ "			 INNER JOIN	Leave_Type ON Leave_Type.Short_Name = Leave_Request.Leave_Type INNER JOIN	Leave_Request_Action ON Leave_Request.Leave_Request_Id=Leave_Request_Action.Leave_Request_Id WHERE  (e. emp_id=  ?) UNION SELECT Leave_Request.Leave_Request_Id, case when middle_name!='' then concat(E.emp_id,' - ',E.first_name,' ',E.middle_name,' ',E.surname) else concat(E.emp_id,' - ',E.first_name,' ',E.surname) end as empName,Leave_Request.Employee_Id,to_char(Date_From,'DD/MM/YYYY') as fromDate ,to_char(Date_To,'DD/MM/YYYY') as toDate, "
			+ "			 Number_Of_Days,Reason,Leave_Address,Leave_Phone,Leave_Mobile,E.First_Name,(select first_name from employee_master where Employee_id = Leave_Request.Alternative_Employee) as alternativeEmployeeName, Leave_Request_Action.Approval_Type as approvalType, 'Holiday Leave' AS Leave_Type_Name,CASE WHEN Leave_Type is null then 'CPL' else Leave_Type end as leaveType,Leave_Request.Half_From,Leave_Request.Half_To,Leave_Request.IsHoliday, Leave_request_Action.alternate_emp_approval_status, Leave_Request_Action.status, Leave_request_Action.final_approval_status, Leave_Request.cancel_request as cancelRequest, leave_deduct as leaveDeduct, Leave_Request.created_by as Created_by, created_on as Created_on, Leave_Request.modified_by as Modified_by, modified_on as Modified_on FROM Leave_Request "
			+ "			 INNER JOIN	employee_master E ON Leave_Request.Employee_Id = E.emp_id INNER JOIN	Leave_Request_Action ON Leave_Request.Leave_Request_Id=Leave_Request_Action.Leave_Request_Id WHERE Leave_Request.Leave_Type IS NULL and (e. emp_id= ?) AND Leave_Request.Employee_Id LIKE  ? order by fromDate desc, toDate desc;";
	
	*/
	


public static final String getLeaveRequestQuery ="\n" + 
		"\n" + 
		"select Leave_Request_Id as leaveRequestId,Employee_Id,leave_type as leaveType,to_char(date_from,'dd/mm/yyyy') as fromDate,to_char(date_to,'dd/mm/yyyy') as toDate,number_of_days as noOfDays, \n" + 
		"		reason as leaveReason,leave_address as leaveAddress,leave_mobile as  leaveMobile,applied_on as appliedOn,coalesce(l.status,0) as status,e.user_name as empName,approved_by,ek.user_name as approvedBy from leave_request l \n" + 
		"		left join user_master e on e.user_id=l.created_by\n" + 
		"		left join user_master ek on ek.user_id=l.approved_by where l.created_by=?"; 


public static final String getLeaveRequestQuery1 ="\n" + 
		"select Leave_Request_Id as leaveRequestId,Employee_Id,leave_type as leaveType,to_char(date_from,'dd/mm/yyyy') as fromDate,to_char(date_to,'dd/mm/yyyy') as toDate,number_of_days as noOfDays, \n" + 
		"		reason as leaveReason,leave_address as leaveAddress,leave_mobile as  leaveMobile,applied_on as appliedOn,coalesce(l.status,0) as status,e.user_name as empName,approved_by,ek.user_name as approvedBy from leave_request l \n" + 
		"		left join user_master e on e.user_id=l.created_by\n" + 
		"		left join user_master ek on ek.user_id=l.approved_by";
	
	 public static final String OVERLAP_DAYS_CHECK_EPOCH = "select  is_valid_leave_request(?,?,?)";
	 
	 
	 public static final String Important_check = "select date_to from leave_request where employee_id =? and date_to is not null order by leave_request_id desc limit 1";
	 
	 public static final String no_oof_days_values = "select number_of_days from leave_request where employee_id =? and leave_type='CL' order by leave_request_id desc limit 1";
	 
	 
	 public static final String checkForCL = "select date_to from leave_request where employee_id =?  and leave_type='CL' order by leave_request_id desc limit 1";
	 
	 
	 public static final String check_number = "select count(*) from leave_request where employee_id =?";
	 
	 
	 
	 public static final String checkcLTYPE = "select count(*) from leave_request where employee_id =? and leave_type='CL' and coalesce(status,0) =0";
	 public static final String checkcLTYPE_ML = "select count(*) from leave_request where employee_id =? and leave_type='ML' and coalesce(status,0) =0";
	 public static final String checkcLTYPE_SL = "select count(*) from leave_request where employee_id =? and leave_type='SL' and coalesce(status,0) =0";

	 
	 public static final String CL_check = "select date_to from leave_request where employee_id =? order by leave_request_id desc limit 1";
	
	
	// public static final String insertLeavereqWitAlternative =
	// "insert into leave_request(leave_request_id,employee_id,leave_type,date_from,date_to,number_of_days,reason,leave_address,leave_phone,leave_mobile,applied_on,half_from,half_to,medical_document_url,isholiday,alternative_employee,alternative_duty_agreed,cancel_request) values(?,?,?,?,?,?,?,?,?,?,now(),?,?,?,?,?,?,false)";
	//
	// public static final String insertLeaverequest =
	// "insert into leave_request(leave_request_id,employee_id,leave_type,date_from,date_to,number_of_days,reason,leave_address,leave_phone,leave_mobile,applied_on,half_from,half_to,medical_document_url,isholiday,cancel_request) values(?,?,?,?,?,?,?,?,?,?,now(),?,?,?,?,false)";

	public static final String insertLeavereqWitAlternative = "insert into leave_request(leave_request_id,employee_id,leave_type,date_from,date_to,number_of_days,reason,leave_address,leave_phone,leave_mobile,applied_on,isholiday,alternative_employee,alternative_duty_agreed,pay_type,cancel_request,half_from,half_to,leave_deduct,created_by,created_on) values(?,?,?,?,?,?,?,?,?,?,now(),?,?,?,?,?,1,2,false,?,now())";

	public static final String insertLeaverequest = "insert into leave_request(leave_request_id,employee_id,leave_type,date_from,date_to,number_of_days,reason,leave_address,leave_phone,leave_mobile,applied_on,isholiday,pay_type,cancel_request,half_from,half_to,leave_deduct,created_by,created_on) values(?,?,?,?,?,?,?,?,?,?,now(),?,?,?,1,2,false,?,now()) returning leave_request_id";
	
	public static final String LeaveTypeDetails = "select days_limit as noOfDaysCL from leave_type_limit where leave_type_id='CL' ";
	
	public static final String LeaveTypeDetailsCPL = "select days_limit as noOfDaysCPL from leave_type_limit where leave_type_id='CPL' ";
	
	public static final String LeaveTypeDetailsEL = "select days_limit as noOfDaysEL from leave_type_limit where leave_type_id='Others' ";
	
	public static final String LeaveTypeDetailsML = "select days_limit as noOfDaysML from leave_type_limit where leave_type_id='ML' ";
	

	public static final String LeaveTypeDetailsHPL = "select days_limit as noOfDaysHPL from leave_type_limit where leave_type_id='HPL' ";
	
	
	public static final String INSERT_JR_FILE_UPLOAD = "INSERT INTO leave_request_url( leave_request_id, url)  VALUES (?, ?) ";
	
	
	
	public static final String DELETE_JR_FILE_UPLOAD = "delete from leave_request_url where leave_request_id= ? ";
	
	// public static final String getHolidayListQuery =
	// "SELECT Holiday_Work_Request.HolidayWork_Request_Id,Holiday_Work_Request.Holiday_Worked,to_char(Holiday_Work_Request.Holiday_Worked, 'DD/MM/YYYY') AS holidayWorked, "
	// +
	// "		Holiday_Work_Request.Hours_Worked,Holiday_Work_Request.Reason,Holiday_Work_Request.Comment as comments, "
	// + "		Holiday_Work_Request.IsCompensated, " +
	// "		Holiday_Work_Request.Requested_By, " +
	// "		Holiday_Work_Request.Request_Date, Holiday_Work_Request.Approved_By, Holiday_Work_Request.Status, Holiday_Work_Request.Approved_Date, "
	// +
	// "      Holiday_Work_Request.Leave_Request_ID, Holiday_Work_Request.Approval_Status "
	// + "		FROM Holiday_Work_Request INNER JOIN " +
	// "		Employee ON Holiday_Work_Request.Requested_By=Employee.Employee_Id " +
	// "		WHERE Holiday_Work_Request.Status=1 AND Holiday_Work_Request.Approval_Status <>1 "
	// +
	// "		AND Holiday_Work_Request.Requested_By= ? AND  (Holiday_Work_Request.Leave_Request_ID NOT IN "
	// + "		(SELECT     Leave_Request_Id " +
	// "		FROM          Leave_Request_Action where Status=1 or Status=0))";

	public static final String getHolidayListQuery ="SELECT Holiday_Work_Request.HolidayWork_Request_Id as holidayId,Holiday_Work_Request.Holiday_Worked,to_char(Holiday_Work_Request.Holiday_Worked, 'DD/MM/YYYY')  AS holidayWorked,  cast(Holiday_Work_Request.Hours_Worked as text) as hoursWorked,Holiday_Work_Request.Reason,Holiday_Work_Request.Comment as comments,  Holiday_Work_Request.IsCompensated,  Holiday_Work_Request.Requested_By,   Holiday_Work_Request.Request_Date, Holiday_Work_Request.Approved_By, Holiday_Work_Request.Status,  Holiday_Work_Request.Approved_Date, "
			+ "Holiday_Work_Request.Leave_Request_ID as leaveId, Holiday_Work_Request.Approval_Status  FROM Holiday_Work_Request INNER JOIN employee_master ON Holiday_Work_Request.Requested_By=employee_master.emp_id WHERE Holiday_Work_Request.Status=1 AND Holiday_Work_Request.Approval_Status <>1 			AND Holiday_Work_Request.Requested_By= ? AND  (Holiday_Work_Request.Leave_Request_ID NOT IN 	  (SELECT     Leave_Request_Id 	 		FROM          Leave_Request_Action where alternate_emp_approval_status<>2 and Status<>2 and final_approval_status<>2)) "
			+ "and now() between Holiday_Work_Request.holiday_worked and Holiday_Work_Request.holiday_worked+interval '1 year' order by "
			+ " Holiday_Work_Request.holiday_worked asc";
	public static final String getHolidayEditListQuery = "SELECT Holiday_Work_Request.HolidayWork_Request_Id as holidayId,Holiday_Work_Request.Holiday_Worked,to_char(Holiday_Work_Request.Holiday_Worked, 'DD/MM/YYYY') " + " AS holidayWorked,  cast(Holiday_Work_Request.Hours_Worked as text) as hoursWorked,Holiday_Work_Request.Reason,Holiday_Work_Request.Comment as comments,  Holiday_Work_Request.IsCompensated, " + " " + "Holiday_Work_Request.Requested_By,   Holiday_Work_Request.Request_Date, Holiday_Work_Request.Approved_By, Holiday_Work_Request.Status, " + " Holiday_Work_Request.Approved_Date, "
			+ "			       Holiday_Work_Request.Leave_Request_ID as leaveId, Holiday_Work_Request.Approval_Status " + "			FROM Holiday_Work_Request INNER JOIN employee_master Employee ON Holiday_Work_Request.Requested_By=Employee.emp_id " + "			WHERE Holiday_Work_Request.Status=1 AND Holiday_Work_Request.Approval_Status <>1 " + "AND Holiday_Work_Request.Requested_By= ? And Holiday_Work_Request.leave_request_id=?  order by Holiday_Work_Request.Holiday_Worked asc";

	public static final String editQuery = "SELECT leave_request_id  as leaveRequestId, employee_id as empId, leave_type as leaveType,to_char(date_from ,'DD/MM/YYYY') as fromDate, to_char(date_to ,'DD/MM/YYYY') as toDate ,reason as leaveReason,leave_address as leaveAddress ,leave_phone as leavePhone ,leave_mobile as leaveMobile ,to_char(applied_on ,'DD/MM/YYYY') as appliedOn, " + " CAST(number_of_days AS Text) as noOfDays,half_from as halfFrom,half_to as halfTo,medical_document_url as supportDoc,isholiday as isHoliday, alternative_employee as alternativeEmp, alternative_duty_agreed as dutyAgreed, pay_type as payType, final_support_document_url as finalSupportDoc FROM LEAVE_REQUEST where leave_request_id=  ?";

	public static final String editQueryforurl = "select url as mdUrl from leave_request_url where leave_request_id=?";
	
	public static final String updateLeaveReqWitAlternative = "update leave_request set   employee_id= ? ,date_from =?, date_to= ?,number_of_days =?,reason =?,leave_address =?,leave_phone= ?,leave_mobile= ?, " + " medical_document_url = ?,isholiday = ?, alternative_employee = ?, alternative_duty_agreed=?, pay_type=?,Modified_by=?,Modified_on=Now() where leave_request_id=  ?";

	public static final String updateLeaveQuery = "update leave_request set   employee_id= ? ,date_from =?, date_to= ?,number_of_days =?,reason =?,leave_address =?,leave_phone= ?,leave_mobile= ?, " + " medical_document_url = ?,isholiday = ?, alternative_employee = null, alternative_duty_agreed='', pay_type=?,Modified_by=?,Modified_on=Now() where leave_request_id=  ? ";

	public static final String updateLeaveReqActionWithAlt = "update leave_request_action set approval_type=1 where leave_request_id=?";

	public static final String updateLeaveReqAction = "update leave_request_action set approval_type=2 where leave_request_id=?";

	public static final String deleteleaveAction = "delete from leave_request_action where leave_request_id= ?";
	public static final String deleteLeaveQuery = " delete from leave_request  where leave_request_id=  ?";

	public static final String maxQuery = "SELECT CASE WHEN MAX(leave_request_id) IS NULL THEN '1' ELSE MAX(leave_request_id)+1 END FROM leave_request";

	// public static final String getLeaveListQuery =
	// "SELECT   MTable.Employee_Id empId,  MTable.EmployeeName empName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave, "
	// + "CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2)) " +
	// "IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed, "
	// + "CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2)) " +
	// "IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) "
	// + "ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance " +
	// "FROM         (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year, "
	// + "Employee.First_Name AS EmployeeName, Employee.Employee_Id " +
	// "FROM          Employee INNER JOIN " +
	// "Employee_Leave_Type ON Employee.Employee_Id = Employee_Leave_Type.Employee_Id INNER JOIN "
	// +
	// "	Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name "
	// + " " +
	// "WHERE      (Employee.Employee_Id =  ? )  And(Leave_Type.IsMaternityLeave= ?) and "
	// + "	 "
	// +
	// "	(Employee_Leave_Type.Year = extract ( year from now()))) AS MTable LEFT OUTER JOIN "
	// +
	// "(SELECT     SUM(Leave_Request.Number_Of_Days) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name "
	// + "	FROM          Leave_Request INNER JOIN " +
	// "Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN "
	// + "Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name " +
	// "WHERE      (Leave_Request.Employee_Id = ? )And(Leave_Type.IsMaternityLeave= ?) AND (Leave_Request_Action.Action = ?)and "
	// + "EXTRACT(YEAR FROM Date_To)= extract ( year from now()) "
	// +
	// "GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name";

/*	public static final String getLeaveListQuery = "SELECT  MTable.Employee_Id empId,  MTable.EmployeeName empName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave,   CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2))   "
			+ "IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed,   CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance	   "
			+ "FROM    (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year,   case when Employee.middle_name!='' then concat(Employee.first_name,' ',Employee.middle_name,' ',Employee.surname) else concat(Employee.first_name,' ',Employee.surname) end as EmployeeName, Employee.Employee_Id   FROM    Employee INNER JOIN   Employee_Leave_Type ON Employee.Employee_Id = Employee_Leave_Type.Employee_Id INNER JOIN   Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name      WHERE      (Employee.Employee_Id =  ? ) And (Employee_Leave_Type.Year = extract ( year from now())) and leave_Type.status=true and leave_type.gender=0) AS MTable LEFT OUTER JOIN   (SELECT     SUM(case when Leave_Request.pay_type ='F' then Leave_Request.Number_Of_Days * 2  else Leave_Request.Number_Of_Days end) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name   	"
			+ "FROM    Leave_Request INNER JOIN   Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN   Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name   WHERE      (Leave_Request.Employee_Id = ? ) AND Leave_Request_Action.status <> 2 AND Leave_Request_Action.final_approval_status <> 2 and Leave_Request_Action.alternate_emp_approval_status <> 2 and   EXTRACT(YEAR FROM applied_on)= extract ( year from now()) "
			+ "GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name where MTable.Yearly_Max > 0 order by MTable.Short_Name asc";
*/
	public static final String getLeaveListQuery = "SELECT   MTable.Emp_Id empId,MTable.EmployeeName empName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave,   CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2)) "
			+ "			IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed,   CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance "
			+ "			FROM    (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year,   case when employee_master.middle_name!='' then concat(employee_master.first_name,' ',employee_master.middle_name,' ',employee_master.surname) else concat(employee_master.first_name,' ',employee_master.surname) end as EmployeeName, employee_master.emp_id   FROM    employee_master INNER JOIN   Employee_Leave_Type ON employee_master.emp_id = Employee_Leave_Type.Employee_Id INNER JOIN   Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name      WHERE      (employee_master.emp_id = ?) And (Employee_Leave_Type.Year = extract ( year from now())) and leave_Type.status=true and leave_type.gender=0) AS MTable LEFT OUTER JOIN   (SELECT     SUM(case when Leave_Request.pay_type ='F' then Leave_Request.Number_Of_Days * 2  else Leave_Request.Number_Of_Days end) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name "
			+ "			FROM    Leave_Request INNER JOIN   Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN   Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name   WHERE      (Leave_Request.Employee_Id = ? ) AND Leave_Request_Action.status <> 2 AND Leave_Request_Action.final_approval_status <> 2 and Leave_Request_Action.alternate_emp_approval_status <> 2 and   EXTRACT(YEAR FROM applied_on)= extract ( year from now()) "
			+ "			GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name where MTable.Yearly_Max > 0 order by MTable.Short_Name asc";
	
/*	public static final String getLeaveMaleListQuery = "SELECT  MTable.Employee_Id empId,  MTable.EmployeeName empName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave,   CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2))   "
			+ "IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed,   CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance	   "
			+ "FROM    (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year,   case when Employee.middle_name!='' then concat(Employee.first_name,' ',Employee.middle_name,' ',Employee.surname) else concat(Employee.first_name,' ',Employee.surname) end as EmployeeName, Employee.Employee_Id   FROM    Employee INNER JOIN   Employee_Leave_Type ON Employee.Employee_Id = Employee_Leave_Type.Employee_Id INNER JOIN   Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name      WHERE      (Employee.Employee_Id =  ? ) And (Employee_Leave_Type.Year = extract ( year from now())) and leave_Type.status=true and leave_type.gender=1) AS MTable LEFT OUTER JOIN   (SELECT     SUM(case when Leave_Request.pay_type ='F' then Leave_Request.Number_Of_Days * 2 else Leave_Request.Number_Of_Days end) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name   	"
			+ "FROM    Leave_Request INNER JOIN   Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN   Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name   WHERE      (Leave_Request.Employee_Id = ? ) AND (Leave_Request_Action.status <> 2) AND Leave_Request_Action.final_approval_status <> 2 and Leave_Request_Action.alternate_emp_approval_status <> 2 and   EXTRACT(YEAR FROM applied_on)= extract ( year from now()) "
			+ "GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name where MTable.Yearly_Max > 0 order by MTable.Short_Name asc";
*/
	public static final String getLeaveMaleListQuery = "SELECT   MTable.Emp_Id empId, MTable.EmployeeName empName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave,   CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2)) "
			+ "IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed,   CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance "
			+ "FROM    (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year,   case when employee_master.middle_name!='' then concat(employee_master.first_name,' ',employee_master.middle_name,' ',employee_master.surname) else concat(employee_master.first_name,' ',employee_master.surname) end as EmployeeName,employee_master.emp_id   FROM    employee_master INNER JOIN   Employee_Leave_Type ON employee_master.emp_id = Employee_Leave_Type.Employee_Id INNER JOIN   Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name      WHERE      (employee_master.emp_id =  ?) And (Employee_Leave_Type.Year = extract ( year from now())) and leave_Type.status=true and leave_type.gender=1) AS MTable LEFT OUTER JOIN   (SELECT     SUM(case when Leave_Request.pay_type ='F' then Leave_Request.Number_Of_Days * 2 else Leave_Request.Number_Of_Days end) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name "
			+ "FROM    Leave_Request INNER JOIN   Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN   Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name   WHERE      (Leave_Request.Employee_Id = ? ) AND (Leave_Request_Action.status <> 2) AND Leave_Request_Action.final_approval_status <> 2 and Leave_Request_Action.alternate_emp_approval_status <> 2 and   EXTRACT(YEAR FROM applied_on)= extract ( year from now()) "
			+ "GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name where MTable.Yearly_Max > 0 order by MTable.Short_Name asc";
/*	
	public static final String getLeaveFemaleListQuery = "SELECT  MTable.Employee_Id empId,  MTable.EmployeeName empName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave,   CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2))   "
			+ "IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed,   CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance	   "
			+ "FROM    (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year,   case when Employee.middle_name!='' then concat(Employee.first_name,' ',Employee.middle_name,' ',Employee.surname) else concat(Employee.first_name,' ',Employee.surname) end as EmployeeName, Employee.Employee_Id   FROM    Employee INNER JOIN   Employee_Leave_Type ON Employee.Employee_Id = Employee_Leave_Type.Employee_Id INNER JOIN   Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name      WHERE      (Employee.Employee_Id =  ? ) And (Employee_Leave_Type.Year = extract ( year from now())) and leave_Type.status=true and leave_type.gender=2) AS MTable LEFT OUTER JOIN   (SELECT     SUM(case when Leave_Request.pay_type ='F' then Leave_Request.Number_Of_Days * 2 else Leave_Request.Number_Of_Days end) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name   	"
			+ "FROM    Leave_Request INNER JOIN   Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN   Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name   WHERE      (Leave_Request.Employee_Id = ? ) AND (Leave_Request_Action.status <> 2) AND Leave_Request_Action.final_approval_status <> 2 and Leave_Request_Action.alternate_emp_approval_status <> 2 and   EXTRACT(YEAR FROM applied_on)= extract ( year from now()) "
			+ "GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name where MTable.Yearly_Max > 0  order by MTable.Short_Name asc";

	*/
	
	public static final String getLeaveFemaleListQuery =  "SELECT   MTable.Emp_Id empId, MTable.EmployeeName empName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave,   CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2)) "
	 + "IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed,   CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance "
	 + "FROM    (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year,   case when employee_master.middle_name!='' then concat(employee_master.first_name,' ',employee_master.middle_name,' ',employee_master.surname) else concat(employee_master.first_name,' ',employee_master.surname) end as EmployeeName,employee_master.emp_id   FROM    employee_master INNER JOIN   Employee_Leave_Type ON employee_master.emp_id = Employee_Leave_Type.Employee_Id INNER JOIN   Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name      WHERE      (employee_master.emp_id =  ?) And (Employee_Leave_Type.Year = extract ( year from now())) and leave_Type.status=true and leave_type.gender=2) AS MTable LEFT OUTER JOIN   (SELECT     SUM(case when Leave_Request.pay_type ='F' then Leave_Request.Number_Of_Days * 2 else Leave_Request.Number_Of_Days end) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name "
	 + "FROM    Leave_Request INNER JOIN   Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN   Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name   WHERE      (Leave_Request.Employee_Id = ? ) AND (Leave_Request_Action.status <> 2) AND Leave_Request_Action.final_approval_status <> 2 and Leave_Request_Action.alternate_emp_approval_status <> 2 and   EXTRACT(YEAR FROM applied_on)= extract ( year from now()) "
	 + "GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name where MTable.Yearly_Max > 0 order by MTable.Short_Name asc";
	
	
	
	
	public static final String WorkingDaysCheck = "select count(*) from leave_request where to_date(?,'dd/mm/yyyy') <= (CURRENT_DATE - interval ? ) and employee_id = ?";
	
	
	
	public static final String SAMPLE_DAYS_COUNT = "select no_of_days from employee_days_limit where employee_id=?";
	
	
	
	
	public static final String CHECK_SAMPLE_DAYS = "select count(no_of_days) from employee_days_limit where employee_id=?";
	
	
	
	public static final String OVERLAP_DAYS_CHECK_KAT_METHOD = "select count(*) - (select count(*) from leave_by_day where leave_date = to_date(?,'dd/mm/yyyy') and employee_id=?) as count from leave_by_day where leave_date between to_date(?,'dd/mm/yyyy') - interval '3' day and to_date(?,'dd/mm/yyyy') + interval '3' day and employee_id=?";



	public static final String OVERLAP_DAYS_CHECK_KAT_METHOD_CL = "select count(*) - (select count(*) from leave_by_day where leave_date = to_date(?,'dd/mm/yyyy') and employee_id=?) as count from leave_by_day l, leave_request lr where lr.leave_request_id = l.leave_request_id and l.leave_date between to_date(?,'dd/mm/yyyy') - interval '1' day and to_date(?,'dd/mm/yyyy') + interval '1' day and l.employee_id=? and lr.leave_type = 'CL'";



	public static final String OVERLAP_DAYS_CHECK_KAT_METHOD_OTH = "select count(*) - (select count(*) from leave_by_day where leave_date = to_date(?,'dd/mm/yyyy') and employee_id=?) as count from leave_by_day l, leave_request lr where lr.leave_request_id = l.leave_request_id and l.leave_date between to_date(?,'dd/mm/yyyy') - interval '1' day and to_date(?,'dd/mm/yyyy') + interval '1' day and l.employee_id=? and lr.leave_type  in ('CL')";

	public static final String SELECT_EMP_ID = "select user_ref_id_emp from user_master where user_id=?";

	public static final String GET_BRANCH = "select branch_code from branch_master where branch_name=? ";

	public static final String GET_COMPANY = "select company_code from company_master where company_name=?";

	public static final String GET_DEPART = "select dept_code from department_master where dept_name=? ";

	public static final String CHECK_DUBAI = "select yearly_max from employee_leave_type where  short_name='ML' and branch_id=?and company_id=? and depart_id=? and employee_id=? ";

	public static final String GET_DOJ_DATE = "select to_char(dt_of_join,'dd/mm/yyyy') from employee_master where emp_id=?";

	public static final String CHECK_DUBAI_MAX =" select yearly_max from employee_leave_type where  short_name='AL' and branch_id=?and company_id=? and depart_id=? and employee_id=? ";

	public static final String SELECT_COUNT = "select count(*) from letter_request where letter_request_type = ? and emp_id = ? and request_date = now() ";

	

	// public static final String getHolidayListQuery =
	// "SELECT Holiday_Work_Request.HolidayWork_Request_Id,Holiday_Work_Request.Holiday_Worked,to_char(Holiday_Work_Request.Holiday_Worked, 'DD/MM/YYYY') AS holidayWorked, "
	// + "	  " +
	// "	 		Holiday_Work_Request.Hours_Worked,Holiday_Work_Request.Reason,Holiday_Work_Request.Comment as comments, "
	// + "	  		Holiday_Work_Request.IsCompensated, " +
	// "	 		Holiday_Work_Request.Requested_By, " +
	// "	 		Holiday_Work_Request.Request_Date, Holiday_Work_Request.Approved_By, Holiday_Work_Request.Status, Holiday_Work_Request.Approved_Date, "
	// + "	  "
	// +
	// "	       Holiday_Work_Request.Leave_Request_ID as leaveId, Holiday_Work_Request.Approval_Status "
	// + "	  		FROM Holiday_Work_Request INNER JOIN " +
	// "	 		Employee ON Holiday_Work_Request.Requested_By=Employee.Employee_Id "
	// +
	// "	 		WHERE Holiday_Work_Request.Status=1 AND Holiday_Work_Request.Approval_Status <>1 "
	// + "	  " +
	// "	 		AND Holiday_Work_Request.Requested_By= 'T005' AND  (Holiday_Work_Request.Leave_Request_ID NOT IN "
	// + "	  		(SELECT     Leave_Request_Id " +
	// "	 		FROM          Leave_Request_Action where Status=1 or Status=0))";

	public static String holidayRequestQueryWithLeave = "update Holiday_Work_Request set Leave_Request_ID=? , iscompensated =?, leave_date=?  where holidaywork_request_id= ?";

	public static String holidayRequestQuery = "update Holiday_Work_Request set Leave_Request_ID=? , iscompensated =?  where holidaywork_request_id= ?";

	public static String get_Employee_List = "SELECT employee_id as empId, case when middle_name!='' then concat(first_name,' ',middle_name,' ',surname) else concat(first_name,' ',surname) end as empName FROM employee order by employee_id asc";

	public static String employeeDetailsList = " select e.emp_name as empName,e.emp_id as empId,c.company_name as company,d.dept_name as department,b.branch_name as branch,g.name as grade from employee_master e "
			+ " left join company_master c on c.company_code =e.company_code "
			+ " left join department_master d on d.dept_code =e.dept "
			+ " left join branch_master b on b.branch_code =e.branch_department_id "
			+ " left join manage_grade g on g.grade_id =e.grade_id where e.emp_id = ? ";

	public static String checkHoliday = "select count(*) from holiday where holiday_date =? and holiday_date =?";

	public static String gender = "select gender from employee_master where emp_id=?";

	//public static String getAlternativeList = "select employee_id as id, case when middle_name!='' then concat(employee_id,' - ',first_name,' ',middle_name,' ',surname) else concat(employee_id,' - ',first_name,' ',surname) end as text from employee e inner join grade g on e.grade_id=g.grade_id where g.duty_leave = true and g.grade_id=? and e.employee_id <> ? order by id";


	public static String getAlternativeList ="select emp_id as id, case when middle_name!='' then concat(emp_id,' - ',first_name,' ',middle_name,' ',surname) else concat(emp_id,' - ',first_name,' ',surname) end as text from employee_master e inner join manage_grade g on e.grade_id=g.grade_id where g.duty_leave = true and g.grade_id=? and e.emp_id <> ? order by id " ;
	
public static String insertLeaveRequestActionAlternate = "INSERT INTO leave_request_action(leave_request_id, action_datetime,action,alternate_emp_approval_status,status,final_approval_status,approval_type) VALUES (?, now(), ?, 0, 0, 0, 1)";

	public static String insertLeaveRequestAction = "INSERT INTO leave_request_action(leave_request_id, action_datetime,action,alternate_emp_approval_status,status,final_approval_status,approval_type) VALUES (?, now(), ?, 0, 0, 0, 2)";

	public static String getLoginUserDOJMonth = "select extract(month from dt_of_join) from employee_master where emp_id =?";

	public static String getLoginUserDOJYear = "select extract(year from dt_of_join) from employee_master where emp_id=?";

	public static String leaveRequestCheck = "select count(*) from leave_request lr inner join leave_request_action lra on lr.leave_request_id=lra.leave_request_id " + " where employee_id=? and ? between date_from and date_to and lra.alternate_emp_approval_status<>2 and lra.status<>2 and lra.final_approval_status<>2 and cancel_request <>true";

	public static String plRequestCheck = "select count(*) from leave_request lr inner join leave_request_action lra on lr.leave_request_id=lra.leave_request_id where employee_id=? and ? between date_from and date_to and lra.alternate_emp_approval_status<>2 and lra.status<>2 and lra.final_approval_status<>2 and lr.leave_type='PL'";

	public static String weeklyOffCheck = "select count(*) from employee_shift where employee_id=? and shift_id = 0 and shift_date between ? and ?";

	public static String weekEndCheck = "select count(*) from employee_shift where employee_id=? and shift_id = -1 and shift_date between ? and ?";

	public static String holidayCheck = "select count(*) from holiday where holiday_date between ? and ?";

	public static String alternateEmpNotify = "select (select case when middle_name!='' then concat(first_name,' ',middle_name,' ',surname) else concat(first_name,' ',surname) end as emp from employee where employee_id=lra.action_by) as empName,lra.alternate_emp_approval_status as notifyStatus,to_char(lr.applied_on,'dd/mm/yyyy') as fromDate, lr.cancel_request as cancelRequest from leave_request lr inner join leave_request_action lra on lr.leave_request_id=lra.leave_request_id where lr.employee_id=? and "
			+ " extract(month from applied_on)=extract(month from now()) and lra.approval_type=2 and (lra.alternate_emp_approval_status=1 or lra.alternate_emp_approval_status=2)";

	public static String reportingEmpNotify = "select (select case when middle_name!='' then concat(first_name,' ',middle_name,' ',surname) else concat(first_name,' ',surname) end as emp from employee where employee_id=lra.action_by) as empName,lra.status as notifyStatus,to_char(lr.applied_on,'dd/mm/yyyy') as fromDate, lr.cancel_request as cancelRequest from leave_request lr inner join leave_request_action lra on lr.leave_request_id=lra.leave_request_id where lr.employee_id=? and " + " extract(month from applied_on)=extract(month from now()) and lra.approval_type=3 and lra.final_approval_status=0 and (lra.status=1 or lra.status=2)";

	public static String finalEmpNotify = "select (select case when middle_name!='' then concat(first_name,' ',middle_name,' ',surname) else concat(first_name,' ',surname) end as emp from employee where employee_id=lra.action_by) as empName,lra.final_approval_status as notifyStatus,to_char(lr.applied_on,'dd/mm/yyyy') as fromDate from leave_request lr inner join leave_request_action lra on lr.leave_request_id=lra.leave_request_id where lr.employee_id=? and " + " lra.approval_type=3 and (lra.final_approval_status=1 or lra.final_approval_status=2) and (now() between applied_on and date_from) order by date_from asc";

	public static String holidayRestrict = "SELECT COALESCE((select sum(number_of_days) as holiday from leave_request lr inner join leave_request_action lra on lr.leave_request_id=lra.leave_request_id  where employee_id =? and lr.leave_type is null and extract(year from lr.applied_on)=extract(year from now()) and (alternate_emp_approval_status<>2 and lr.Status<>2 and final_approval_status<>2) group by lr.employee_id),0) AS holiday";

	public static String userCategory = "select category from employee where employee_id=?";

	public static String collegeCheck = "select count(*) from academic_holiday where ? between holiday_from and holiday_to";

	public static String cancelRequest = "update leave_request set cancel_request=true where leave_request_id=?";

	public static String hospitalCheck = "select count(*) from holiday where holiday_date=?";

	public static String weeklyOffCount = "select count(*) from employee_shift where employee_id=? and shift_id = 0 and shift_date = ?";

	public static String weekEndCount = "select count(*) from employee_shift where employee_id=? and shift_id = -1 and shift_date = ?";

	public static String insertLeaveByDay = "insert into leave_by_day(leave_request_id,employee_id,leave_date,number_of_days,applied_on) values(?,?,?,1,now())";

	public static String deleteLeaveByDay = "delete from leave_by_day where leave_request_id=?";

	public static String getHolidayAvailable = " SELECT count(*) FROM Holiday_Work_Request hwr INNER JOIN employee_master ON hwr.Requested_By=employee_master.emp_id WHERE hwr.Status=1 AND hwr.Approval_Status <>1  "
			+" AND hwr.Requested_By=? AND (hwr.Leave_Request_ID NOT IN (SELECT Leave_Request_Id FROM Leave_Request_Action where alternate_emp_approval_status<>2 and Status<>2 and final_approval_status<>2)) and now() between hwr.holiday_worked and hwr.holiday_worked+interval '1 year' ";

	// "select count(*) from holiday_work_request where requested_by=? and status=1 and leave_request_id=0 and now() between Holiday_Work_Request.holiday_worked and Holiday_Work_Request.holiday_worked +interval '1 year'";

	//public static String getHolidayTotalLeaveAvailable = "select count(*) from holiday_work_request where requested_by=? and status=1 and leave_request_id is not null";
	
	public static String getHolidayTotalLeaveAvailable = "select count(*) from holiday_work_request where requested_by=? and status=1 and (leave_request_id is not null or iscompensated =true or iscompensated is null ) ";

	public static String getMilliSeconds = "SELECT EXTRACT(EPOCH FROM to_date(?,'dd/mm/yyyy')) * 1000 as id";

	public static String updateRequestWhileCancel = "update leave_request set date_from=?, date_to=?, number_of_days=? where leave_request_id=?";

	public static String getLeaveData = "select lr.leave_request_id as requestId, employee_id, leave_type, date_from, date_to, number_of_days, reason, leave_address, leave_phone, leave_mobile, applied_on, isholiday, alternative_employee, " + " alternative_duty_agreed, cancel_request, lra.action_datetime, action_by, comments, status, description, final_approval_status, alternate_emp_approval_status, approval_type, alternate_emp_date, report_emp_date, final_emp_date, medical_document_url, pay_type " + " from leave_request lr inner join leave_request_action lra on lr.leave_request_id = lra.leave_request_id where lr.leave_request_id=?";

	public static String insertCancelLeaveRequest = "insert into leave_request(leave_request_id, employee_id,leave_type,date_from,date_to,number_of_days,reason,leave_address,leave_phone, leave_mobile, applied_on, isholiday, alternative_employee,alternative_duty_agreed,medical_document_url,pay_type,cancel_request,half_from,half_to,leave_deduct) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,2,false)";

	public static String insertCancelLeaveAction = "insert into leave_request_action(leave_request_id,action_datetime, action_by, comments, status, description, final_approval_status, alternate_emp_approval_status, approval_type, alternate_emp_date, report_emp_date, final_emp_date,action) values(?,?,?,?,?,?,?,?,?,?,?,?,'Pending')";

	public static String insertCancelLeaveByDay = "insert into leave_by_day(leave_request_id,employee_id,leave_date,number_of_days,applied_on) values(?,?,?,1,?)";

	public static String holidayRequestUpdateLeaveDate = "update Holiday_Work_Request set Leave_Request_ID=? , iscompensated =? where leave_request_id= ? and leave_date=?";

	public static String getSumCLCount = "select sum(number_of_days) from leave_request lr inner join leave_request_action lra on lra.leave_request_id=lr.leave_request_id where lr.leave_type='CL' and extract(year from lr.date_from)=extract(year from now()) and lra.status <> 2 AND lra.final_approval_status <> 2 and lra.alternate_emp_approval_status <> 2 and lr.employee_id=? group by leave_type='CL'";

	public static String getLeaveDeductionList = "select leave_request_id as leaveRequestId, to_char(applied_on,'dd/mm/yyyy') as appliedOn, leave_type as leaveType, e.employee_id as empId, case when e.middle_name!='' then concat(e.first_name,' ',e.middle_name,' ',e.surname) else concat(e.first_name,' ',e.surname) end as empName, (select d.department_name from department d where d.department_id=e.department_id) as department, reason as leaveReason, number_of_days as noOfDays from leave_request lr inner join employee e on lr.employee_id=e.employee_id where leave_deduct=true order by applied_on asc";

	public static String insertLeaveDeduction = "insert into leave_request(leave_request_id, employee_id, leave_type, number_of_days, reason, applied_on, half_from, half_to, isholiday, cancel_request, leave_deduct) values(?,?,?,?,?,now(),1,2,false,false,true)";

	public static String insertLeaveDeductionAction = "insert into leave_request_action(leave_request_id,action_datetime,action_by,action,status,final_approval_status,alternate_emp_approval_status,approval_type) values(?,now(),?,'Pending',3,3,3,4);";

	public static String getEditLeaveDeduction = "select leave_request_id as leaveRequestId, e.department_id as departmentId, lr.employee_id as empId, number_of_days as noOfDays,leave_type as leaveType, reason as leaveReason from leave_request lr inner join employee e on lr.employee_id=e.employee_id where leave_request_id=?";

	public static String getPreviousEmpId = "select employee_id from leave_request where leave_request_id=?";

	public static String updateLeaveDeduction = "update leave_request set employee_id=?, number_of_days=?, reason=? where leave_request_id=?";

	public static String checkEmpDoj = "select case when dt_of_join > ? then 0 else 1 end from employee_master where emp_id=? ";
	
	public static String updateViewMLDoc = "update leave_request set final_support_document_url=? where leave_request_id=?";
	
	public static String INSERT_UPLOAD_MAIL = "select case when e.middle_name!='' then concat(e.employee_id,' - ',e.first_name,' ',e.middle_name,' ',e.surname ) else concat(e.employee_id,' - ',e.first_name,' ',e.surname )end as empName ,lr.leave_type as leaveType ,lr.applied_on as appliedOn from leave_request lr , employee e, leave_request_action lra  where e.employee_id = lr.employee_id and lr.leave_request_id = lra.leave_request_id and lra.final_approval_status !=1 and lra.approval_type !=3 and applied_on  > now() - interval '3' day";
	
	public static String viewLeaveHistory = "SELECT lr.Leave_Request_Id as leaveRequestId ,lr.Employee_Id as empId,to_char(Date_From,'DD/MM/YYYY')  as fromDate,to_char(Date_To,'DD/MM/YYYY') toDate,Number_Of_Days as noOfDays,Reason as leaveReason,Leave_Address  as leaveAddress,Leave_Phone as leavePhone,Leave_Mobile as leaveMobile,E.First_Name as empName,(select employee_id||' - '||first_name||' '||surname from Employee where Employee_id = lr.Alternative_Employee) as alternativeEmployeeName, "
			+ " lra.Approval_Type as approvalType, (case when lr.Leave_Type is not null then lr.Leave_Type else 'CPL' end) as leaveType, "
			+ " lr.Half_From,lr.Half_To,lr.IsHoliday, lra.alternate_emp_approval_status as alternateEmpStatus, lra.status as action, lra.final_approval_status as finalEmpStatus, lr.cancel_request as cancelRequest, leave_deduct as leaveDeduct FROM Leave_Request lr INNER JOIN	Employee E ON lr.Employee_Id = E.Employee_Id "
			+ " INNER JOIN Leave_Request_Action lra ON lr.Leave_Request_Id=lra.Leave_Request_Id WHERE  lr. Employee_Id=  ? and extract(year from date_from) = extract(year from current_date) and lr.cancel_request=false order by Date_From desc, Date_To desc";

	public static String reporting_to="select reporting_to from employee_master where emp_id = ?";

	public static String DAYS_COUNT_SL="select now()::date - to_date(?,'dd/mm/yyyy')::date as days  from employee_master where emp_id=? ";

	public static String deletefileupload = " delete from leaverequest_files where cust_code = ?  ";

	public static String INSERT_FILES="insert into leaverequest_files(cust_code,file_name,file_path) values(?,?,?)";

	public static String fileuploadinvoicelist="select file_path as uploadRef from leaverequest_files where request_no  =?";



	public static final String GENERATE_VENDOR_CODE ="SELECT  case when (select max(upload_ref )from leave_request where upload_ref~*?)"
					+ " is null then '0001' ELSE   lpad(cast(cast((SUBSTRING((select max(upload_ref) from leave_request where upload_ref~*?),2))" 
						+ " as int)+1  as text),4,'0')  END";

	public static final String INSERT_FILE_PATH = "insert into leaverequest_files (request_no,file_path,created_by) values(?,?,?)";
	
	public static final String DELETE_FILE_PATH="delete from leaverequest_files where request_no=?";

	public static final String GET_APPROVAL_LIST = "\n" + 
			"\n" + 
			"select  l.created_by,e.user_name as employeeName , step_name as stepName , l.status adminStatus, to_char(created_on,'dd/mm/yyyy')  as approvedDate, remarks as comments  from leave_work_flow l\n" + 
			"left join user_master e on e.user_id=l.created_by\n" + 
			"where leave_id =?";
 }
