package com.dci.finance.leavedeclare;

public class LeaveDeclareQueryUtil {
	//public static final String listLeaveQuery = "select DISTINCT grade.grade_id as gradeid,name as gradename,company.company_id,company.company_name as companyName,grade_leave_type.year as year from grade,grade_leave_type,company where grade.grade_id=grade_leave_type.grade_id AND company.company_id=grade.company_id Order By grade_leave_type.year desc";

	public static final String listLeaveQuery ="select distinct branch_id as branchCode, b.branch_name as branch ,c.company_name as companyName,year as year from grade_leave_type g   left join branch_master b on b.branch_id=branch_id    left join company_master c  on c.company_code=c.company_code ";
	public static final String getGradeQuery = "select g.grade_id as gradeId ,g.grade_id as id,g.name as gradeName,g.name as text from grade g inner join company c on c.company_id=g.company_id where c.company_id=? order by name ASC";

	public static final String getYearQuery = "select yearPassed as id, yearPassed as text from (select c.y as yearPassed from generate_series(2016, 2050) as c(y)) date order by id asc";

	// public static final String getLeaveTypeQuery =
	// "select short_name as leaveType ,monthly_max as leavemonth ,yearly_max  as leaveyear from grade_leave_type where grade_id= ? and year= ?";

	//public static final String leaveType = " SELECT  GT.Grade_ID, LT.Short_Name as leaveType, GT.Year,  GT.Monthly_Max as leavemonth, GT.Yearly_Max  as leaveyear FROM         Leave_Type AS LT INNER JOIN   Grade_Leave_Type AS GT ON GT.Short_Name = LT.Short_Name WHERE     (GT.Grade_ID = ?) AND (GT.Year = ?) UNION SELECT NULL::INTEGER , Short_Name, 0 AS Year, 0 AS Monthly_Max, 0 AS Yearly_Max FROM     Leave_Type WHERE     (Short_Name NOT IN (SELECT     Short_Name FROM          Grade_Leave_Type  WHERE      (Grade_ID = ?) AND (Year = ?))) AND (Status = 'True')";


	public static final String leaveType  ="SELECT LT.branch as branch, GT.Grade_ID, LT.Short_Name as leaveType, GT.Year,  GT.Monthly_Max as leavemonth, GT.Yearly_Max  as leaveyear FROM         Leave_Type AS LT INNER JOIN   Grade_Leave_Type AS GT ON GT.Short_Name = LT.Short_Name WHERE  LT.branch=? and  (GT.Year = ?)  "
		 +"	UNION  "
			 +" SELECT branch,NULL::INTEGER , Short_Name, 0 AS Year, 0 AS Monthly_Max, 0 AS Yearly_Max FROM     Leave_Type WHERE     (Short_Name NOT IN (SELECT     Short_Name FROM          Grade_Leave_Type  WHERE   branch=? and    (Year =?))) AND (Status = 'True') ";
	
	public static final String updateLeaveDeclare = "update  grade_leave_type set monthly_max= ?,yearly_max= ?,company_code =? where   short_name= ? and year= ? and branch=?";

	public static final String insertleaveDeclare = " insert into grade_leave_type(short_name,branch,monthly_max,yearly_max,year,company_code,emp_id) values(?,?,?,?,?,?,?)";

	//public static final String checkLeaveDeclare = "select coalesce((select count(*) from grade_leave_type where short_name= ? and year=? and branch=?),0) as id";
	public static final String checkLeaveDeclare = "select coalesce((select count(*) from grade_leave_type where short_name= ? and year=? ),0) as id";

/*	public static final String leaveEditQuery = " select l.grade_id as gradeId,l.short_name  as leaveType,l.monthly_max as leavemonth,l.yearly_max as leaveyear ,l.year as year,g.company_id,company_name as companyName, g.name as gradeName from grade_leave_type l "
			+" inner join manage_grade g on l.grade_id=g.grade_id "
			+" left join company_master c on c.company_code=g.company_id "
			+"  where l.grade_id=? AND l.year=? ";
*/
	public static final String leaveEditQuery = "select distinct l.branch branch,l.grade_id as gradeId,l.short_name  as leaveType,l.monthly_max as leavemonth,l.yearly_max as leaveyear ,l.year as year,b.branch_name as branchCode,l.company_code as    companyId,company_name as companyName "
	+ "  from grade_leave_type l "
	+ "  left join branch_master b on  b.branch_id::char=l.branch "
	+ "  left join company_master c on  c.company_code=l.company_code "
	+ "  where  l.branch=? AND l.year=?";


	public static final String deleteQuery = " delete from grade_leave_type where grade_id= ? and year=?";

	public static final String leaveDeclareTypeDelete = "DELETE FROM Grade_Leave_Type WHERE Grade_ID = ? AND short_name = ?";

	public static final String insertData = "insert into employee_leave_type(branch_id,employee_id,short_name,monthly_max,yearly_max,year,company_id,depart_id) values (?,?,?,?,?,?,?,?)";

	//public static String employeeIdByGrade = "select employee_master.emp_id as empId from manage_grade inner join employee_master on employee_master.grade_id=manage_grade.grade_id where manage_grade.grade_id=? ";

	public static String employeeIdByGrade =  " select  branch_id as branch from branch_master  left join employee_master  on employee_master.branch_department_id=branch_id  where branch_id=? ";
	
	public static String deleteEmployeeLeaveType = "delete from employee_leave_type where employee_id=? and year=?";

	public static final String updateData = "update employee_leave_type set  monthly_max= ?,yearly_max= ?  where  short_name= ? and year= ?  and branch_id=?";
	
	public static final String CHECK_EMPLOYEE_BRANCH = "select emp_id,dept from employee_master where branch_department_id =?";
}