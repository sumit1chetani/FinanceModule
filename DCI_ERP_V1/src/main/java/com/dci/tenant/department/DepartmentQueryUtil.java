package com.dci.tenant.department;



public class DepartmentQueryUtil {

	public static String sGetDepartmentValues = "select de.dept_code as deptCode,de.dept_name as deptName,emp.emp_name as deptHead,emp.emp_name as id, emp.emp_name as text, de.dept_status as isActive from DEPARTMENT_MASTER_new  de,employee_master emp where de.dept_head = emp.emp_id order by de.dept_code desc";

	public static String getDeptIdAutoIncrement = "SELECT CASE WHEN MAX(dept_code) IS NULL  THEN 'DP001' ELSE rpad(MAX(dept_code),2,'DP')|| lpad(cast(cast((SUBSTRING(MAX(dept_code),3)) as int)+1  as text),3,'0') END FROM department_master_new";

	public static String sInsertDeptDetails = "insert into department_master_new (dept_code, dept_name, dept_head, dept_status, dept_desc, created_by, created_dt )  values (?,?,?,?,?,?,current_timestamp)";

	public static String sDeleteDeptDetail = " delete from department_master_new where dept_code = ? ";

	public static String sUpdateDept = "update department_master_new set dept_name =?, dept_head =?, dept_status =? where dept_code = ?";

	public static String sEmployeeDropDown = "select emp_id as id,concat(emp_id,'-',emp_name) as text from employee_master order by emp_name asc";

	public static String sDepartmentDropDown = "select dept_name from DEPARTMENT_MASTER_new";

	public static String sEditDepartment = "select dept_name as deptName,dept_head as deptHead, dept_status as isActive from department_master_new where dept_code = ?";

	public static String sCheckDepartmentUpdate = "SELECT count(*) FROM DEPARTMENT_MASTER_new WHERE dept_code<>? and dept_name=?";

	public static String sCheckDepartmentAdd = "SELECT count(*) FROM DEPARTMENT_MASTER_new WHERE dept_name=?";

}