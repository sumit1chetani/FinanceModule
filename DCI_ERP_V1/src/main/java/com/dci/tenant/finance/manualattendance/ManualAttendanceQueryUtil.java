package com.dci.tenant.finance.manualattendance;

public class ManualAttendanceQueryUtil {
	public static final String SELECT_ATTENDANCE_LIST ="select a.attendance_id attendanceId,a.employee_id employeeId,a.shift_id shiftId,a.attendance_date attendanceDate, to_char(a.in_time,'hh24:mi') inTime, "
			  +"  to_char(a.out_time,'hh24:mi') outTime,a.department_id,e.emp_name as employeeName,s.shift_name as ShiftName,d.dept_name departmentCode,b.branch_name as branchName "
			  +"   from attendance a "
			   +"  left join employee_master e on e.emp_id=a.employee_id "
			  +"  left join shift s on s.shift_id=a.shift_id "
			   +"  left join department_master d on d.dept_code=a.department_id "
			  +"   left join branch b on b.branch_code=a.branch "
			   +"  left join company_master c on c.company_code=a.company_code "
			   + "where c.company_code=? order by attendance_Id ASC  ";
	public static String SELECT_DEPARTMENT_LIST = "select bd.department_id as departId, department_name as departName,bd.department_id as id, department_name as text from department inner join branch_department bd on bd.department_id=department.department_id where bd.branch_id=? order by department_name ASC";

	public static String SELECT_EMPLOYEE_LIST = " select DISTINCT ON ( es.employee_id , e.first_name , coalesce(es.shift_id,0) ," + " s.start_time , s.end_time ) es.employee_id employeeId, e.first_name employeeName, coalesce(es.shift_id,0) shiftId, " + " s.start_time shiftInTime, " + " s.end_time shiftOutTime  from employee_shift es " + " left join employee e on e.employee_id = es.employee_id " + " inner join shift s on s.shift_id = es.shift_id  where es.shift_id=? " + " order by e.first_name ASC ";

	public static String SELECT_EMPLOYEE_LIST_MULTIPLE = "select distinct es.employee_id as id,e.first_name as text,s.start_time as shiftInTime, s.end_time as shiftOutTime from employee_shift es inner join employee e on e.employee_id=es.employee_id inner join shift s on s.shift_id=es.shift_id inner join branch_department bd on e.branch_department_id=bd.branch_department_id where e.status=true  and bd.department_id= ? and bd.branch_id=? and es.shift_id= ? and shift_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ";

	public static String SELECT_EMPLOYEE_LIST_SINGLE = "select distinct es.employee_id as id,e.first_name as text,s.start_time as shiftInTime, s.end_time as shiftOutTime from employee_shift es inner join employee e on e.employee_id=es.employee_id inner join shift s on s.shift_id=es.shift_id inner join branch_department bd on e.branch_department_id=bd.branch_department_id where e.status=true  and bd.department_id= ? and bd.branch_id=? and es.shift_id= ? and shift_date = to_date(?,'dd/mm/yyyy')";

	public static String SELECT_SHIFTDETAILS = "select start_time as shiftInTime,end_time as shiftOutTime from shift where shift_id= ?";

	public static String SELECT_SHIFTTIMING_LIST = "select start_time shiftInTime from shift where shift_id=?";

	public static String SELECT_SHIFT_LIST = " select shift_id shiftId,shift_id id,shift_name shiftName,shift_name as text, start_time shiftInTime, end_time shiftOutTime from shift where company_id = ?  order by shift_name ASC ";

	public static String INSERT_ATTENDANCE = "INSERT INTO attendance( shift_id, attendance_date, in_time, out_time, created_date, mode,branch,company_code, department_id,employee_id) VALUES(?, to_date(?,'dd/mm/yyyy'), ?::time, ?::time, now(), ?,?,?,?,?)";
	public static String INSERT_ATTENDANCE1 = "INSERT INTO attendance( shift_id, attendance_date, in_time, out_time, created_date, mode,branch, department_id,modified_date) VALUES(?, to_date(?,'dd/mm/yyyy'), ?::time, ?::time, now(), ?, ?,?,to_date(?,'dd/mm/yyyy'))";

	public static String UPDATE_ATTENDENCE = " UPDATE attendance SET shift_id=:shiftId, attendance_date=to_date(:attendanceDate,'dd/mm/yyyy'), " + " in_time=:inTime::time, out_time=:outTime::time, created_date=to_date(:modifiedDate,'dd/mm/yyyy'), modified_by=:logInUser WHERE attendance_id=:attendanceId ";

	public static String DELETE_ATTENDANCE = " delete from attendance where attendance_id = ?";

	//public static String sGetAttendanceEditList = "select d.dept_name as departmentCode, a.attendance_id attendanceId, a.employee_id employeeId, a.shift_id shiftId, s.shift_name as shiftName, s.start_time shiftInTime, s.end_time shiftOutTime, TO_CHAR(attendance_date, 'dd/mm/yyyy') as attendanceDate,    a.in_time inTime, a.out_time outTime, a.department_id departmentId, d.dept_name departmentCode, (select b.branch_id from branch_master b inner join branch_department bd on bd.branch_department_id = e.branch_department_id where b.branch_id::varchar=bd.branch_id) as branchId,(select b.branch_name from branch_master b inner join branch_department bd on bd.branch_department_id = e.branch_department_id where b.branch_id::varchar=bd.branch_id) as branchName,(select b.company_code from branch_master b inner join branch_department bd on bd.branch_department_id = e.branch_department_id where b.branch_id::varchar=bd.branch_id) as hospitalName from attendance a left join department_master d on d.dept_code = a.department_id    left join shift s on s.shift_id = a.shift_id inner join employee_master e on e.emp_id = a.employee_id where attendance_id = ?";
	public static String sGetAttendanceEditList ="select a.attendance_id attendanceId,a.employee_id employeeId, a.shift_id shiftId, a.in_time shiftInTime, a.out_time shiftOutTime, "
	+ "a.branch,a.company_code,e.first_name as employeeName,s.shift_name as shiftName,d.dept_name as Initiated,c.company_name as hospitalName from attendance a "
	+ "left join employee_master e on emp_id=a.employee_id "
	+ "left join shift s on s.shift_id=a.shift_id "
	+ "left join department_master d on d.dept_code=a.department_id "
	+ "left join company_master c on c.company_code=a.company_code where attendance_id =?";
	
	public static String SELECT_INTIME_DETAILS = " select c.company_name hospitalName, b.branch_name branchName, a.attendance_date, a.in_time inTime, a.out_time outTime, " + " a.employee_id employeeId, e.first_name employeeName, " + " a.department_id departmentId, d.department_name departmentCode, " + " a.shift_id shiftId, s.shift_name shiftName from attendance a " + " left join employee e on e.employee_id = a.employee_id " + " left join department d on d.department_id = a.department_id " + " left join shift s on s.shift_id = a.shift_id "
			+ " inner join branch_department bd on e.branch_department_id = bd.branch_department_id " + " inner join branch b on b.branch_id = bd.branch_id " + " inner join company c on c.company_id = b.company_id " + " where a.employee_id = ? AND a.attendance_date = ? ";

	public static String INSERT_MY_ATTENDANCE = " INSERT INTO attendance(attendance_date, in_time, department_id, shift_id, employee_id, mode, created_date, created_by) VALUES(?,?::time,?,?,?,?,?,?) ";

	public static String UPDATE_MY_OUT_ATTENDANCE = " update attendance set out_time = ?::time where employee_id=? and attendance_date=?";

	public static String SELECT_MY_ATTENDANCE_DETAILS = "select c.company_name hospitalName, b.branch_name branchName, d.department_id departmentId, (select (select shift_id from shift s where s.shift_id = es.shift_id) as shiftId from employee_shift es where es.employee_id=a.employee_id and es.shift_date=?), (select (select shift_name from shift s where s.shift_id = es.shift_id) as shiftName from employee_shift es where es.employee_id=a.employee_id and es.shift_date=?), "
			+ " (select (select to_char(start_time,'hh24:mi') from shift s where s.shift_id = es.shift_id) as inTime from employee_shift es where es.employee_id=a.employee_id and es.shift_date=?), " + " (select (select to_char(end_time,'hh24:mi') from shift s where s.shift_id = es.shift_id) as outTime from employee_shift es where es.employee_id=a.employee_id and es.shift_date=?), "
			+ " d.department_name departmentCode, e.first_name employeeName, a.employee_id employeeId from employee_shift_scheme a inner join employee e on e.employee_id = a.employee_id  inner join branch_department bd on e.branch_department_id = bd.branch_department_id " + " inner join department d on d.department_id = bd .department_id inner join branch b on b.branch_id = bd.branch_id    inner join company c on c.company_id = b.company_id where a.employee_id = ?";

	public static String CHECK_MY_ATTENDANCE_DETAILS = "select to_char(in_time,'hh24:mi')as checkIn, to_char(out_time,'hh24:mi')as checkOut from attendance where attendance_date=to_date(?,'dd/mm/yyyy')";
	public static String CHECK_MY_ATTENDANCE_DETAILS1 = "select to_timestamp(in_time,'hh24:mi')as checkIn, to_timestamp(out_time,'hh24:mi')as checkOut from attendance where attendance_date=to_date(?,'dd/mm/yyyy')";

	public static String GET_Joining_Date = "select to_char(doj,'dd/mm/yyyy') as doj from employee where employee_id=?";

}
