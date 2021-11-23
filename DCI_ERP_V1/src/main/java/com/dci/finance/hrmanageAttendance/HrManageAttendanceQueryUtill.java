package com.dci.finance.hrmanageAttendance;

public class HrManageAttendanceQueryUtill {

	public static final String SELECT_Employee_LIST = "select emp_id employeeId,emp_name firstName from employee_master where dept=?";

	public static final String SELECT_DEPARTMENT_LIST = "select department_id as id,department_name as text from department dt";

	public static final String SELECT_EMPLOYEENAME_LIST = "select employee_id as id,first_name as text from employee emp";

	public static final String INSERT_Employee_ATTENDANCE = "insert into attendance(employee_id,department_id,attendance_date,attendance,onduty,remarks,created_by) values(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?)";

	public static final String COUNT_Employee_ATTENDANCE = "select count(*) from employee_attendance where employee_id~*? and attendance_date=? and batch_timing_id=?";

	public static final String SELECT_academic_LIST = "select academic_year_id as id,academic_year_code as text from academic_year where active = true";

	public static final String UPDATE_MANAGE_ATTENDANCE_Employee = "update attendance set modified_by =?,attendance =?,onduty=?,remarks=? where attendance_id=?";

	public static final String DELETE_ATTENDANCE = "delete FROM attendance WHERE attendance_id=?";

	public static final String SELECT_Employee_LIST1 = " SELECT se.section_name as sectionName,r.retailer_name  as retailerName,s.profile_url as profileUrl,r.retailer_id as retailerId , r.base_img_url as baseImgUrl ,to_char(s.dob,'dd/mm/yyyy') as dob,CASE WHEN s.gender = 'M' THEN 'Male' ELSE 'Female' END as gender,bs.semester_class as className,s.employee_id employeeId,s.first_name EmployeeName,scd.status FROM Employee s inner join Employee_course_detail scd on scd.employee_id=s.employee_id inner join section se on se.section_id = s.section_id inner join batch_semester bs on bs.batch_semester_id = se.batch_semester_id inner join retailer r on r.retailer_id = s.retailer_id where  s.employee_id = ?";

	/*
	 * public static final String SELECT_ACADEMIC_LIST =
	 * "select academic_year_id as id,academic_year_code as text from academic_year where retailer_id=? and active = true"
	 * ;
	 */

	public static final String SELECT_ACADEMIC_LIST = "select sc_academic_year_id as id,academic_year_code as text from sc_academic_year where retailer_id=? and isactive = 't'";

	public static String SELECT_ATTENDANCE_EDIT = " select distinct a.department_id,d.dept_name as departmentName,a.attendance_date attendanceDate from attendance a  "
			 + " inner join department_master d on d.dept_code = a.department_id where a.department_id =? and a.attendance_date= to_date(?,'yyyy-mm-dd') ";

	public static String SELECT_ATTENDANCELIST_EDIT =  " select a.employee_id employeeId,e.first_name firstName,d.dept_name departmentName,a.attendance_date attendanceDate, "
			 + " 	coalesce(attendance,false) attendance,coalesce(onduty,false) onduty,a.remarks remarks,a.attendance_id as attendanceId,a.department_id from attendance a "
			 + " inner join employee_master e on e.emp_id = a.employee_id inner join department_master d on d.dept_code= e.dept where a.department_id =? "
				 + "  and a.attendance_date= to_date(?,'yyyy-mm-dd') ";


	public static String SELECT_ATTENDANCE_LIST =" select d.dept_name as departmentName,a.attendance_date as attendanceDate,a.department_id as departmentId from attendance a "
			+ " inner join department_master d on d.dept_code=a.department_id group by d.dept_code , attendance_date,a.department_id ";

	public static String UPDATE_MANAGE_ATTENDANCE = "UPDATE manage_attendance SET course_id=?,academic_year_id=?, section_id=?, batch_id=?,curr_date=to_date(?,'dd/mm/yyyy') WHERE attendance_id=?";

	public static String SELECT_COUNT = "SELECT count(*) FROM Employee_course_detail scd left join Employee_attendance sa on scd.employee_id=sa.employee_id where scd.section_id=? and sa.attendance_date=to_date(?,'dd/mm/yyyy') and batch_timing_id=?";

	public static String SELECT_Employee_LIST_WITH_ATTEN = "SELECT distinct scd.employee_id employeeId,sa.Employee_attendance_id attendanceDetailId,s.first_name EmployeeName,case when sa.mng_status='t' then 'true' else 'false' end mngStatus,sa.remarks,s.section_id,scd.status FROM Employee_attendance sa inner join Employee_course_detail scd on scd.employee_id=sa.employee_id inner join Employee s on s.employee_id=scd.employee_id where scd.status in ('I','F','C') and scd.section_id=? and sa.attendance_date=to_date(?,'dd/mm/yyyy') and batch_timing_id=?";
}
