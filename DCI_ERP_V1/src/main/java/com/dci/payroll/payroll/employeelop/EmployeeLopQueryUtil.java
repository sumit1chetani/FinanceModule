package com.dci.payroll.payroll.employeelop;

public class EmployeeLopQueryUtil {

	public static final String sLopList = "SELECT distinct E.emp_id as employeeId, E.emp_name AS employee_name,to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,CASE WHEN days IS NULL THEN 0 ELSE days END AS days FROM employees(?,?,?,null) E  LEFT OUTER JOIN employee_lop el ON E.emp_id = el.emp_id AND el.month_year=? ";
			
			//"SELECT  E.employee_id, E.first_name||' '||E.middle_name||' '||E.surname AS employee_name,to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year, (select count(att) as lopDays from vw_get_attendance_details_new(?,E.employee_id) where att = 'LOP') AS days FROM employees(?,?,?,null) E LEFT OUTER JOIN employee_lop el ON E.employee_id = el.employee_id AND el.month_year=?";

	/*
	 * public static final String sLopList =
	 * "SELECT  E.employee_id, E.first_name||' '||E.middle_name||' '||E.surname AS employee_name,to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,"
	 * + "CASE WHEN days IS NULL THEN 0 ELSE days END AS days" +
	 * " FROM employees(?,?,?,null) E" +
	 * " LEFT OUTER JOIN employee_lop el ON E.employee_id = el.employee_id AND el.month_year=?"
	 * ;
	 */

	/*
	 * public static final String sLopList =
	 * " SELECT distinct E.employee_id, E.first_name||' '||E.middle_name||' '||E.surname AS employee_name,to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year, CASE WHEN days IS NULL THEN 0 ELSE days END AS days   FROM employee  E  inner join branch_department bd on  e.branch_department_id = bd.branch_department_id  inner join department d on bd.department_id = d.department_id  inner join branch b on bd.branch_id = b.branch_id and b.company_id = ?::text and b.branch_id =?::text LEFT OUTER JOIN employee_lop el ON E.employee_id = el.employee_id AND CAST(el.month_year=? AS varchar(10)) where e.department_id = ? and e.status='true' and e.designation_id !='38'"
	 * ;
	 */

	public static final String SELECT_LOPLIST_ID_MONYR = "SELECT * FROM employee_lop WHERE emp_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String INSERT_LOPLIST = "INSERT INTO employee_lop (emp_id,month_year,days) VALUES (:employeeId,to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),:days)";

	public static final String INSERT_EMPLOYEE_LOP_UPLOAD = "INSERT INTO employee_lop(emp_id,month_year,days) values(?, to_char(to_date(?, 'Mon YYYY'),'mmyyyy'), ?)";

	public static final String UPDATE_LOPLIST = "UPDATE employee_lop SET days=:days WHERE emp_id=:employeeId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy')";

	public static final String CHECK_EMPLOYEE = "select emp_id from employee_master where emp_id=?";

	public static final String SELECT_MONTHLIST = "select to_char(now(),'mmyyyy') month_year, to_char(now(),'Mon yyyy') month_value UNION select to_char(now() - INTERVAL '1 month','mmyyyy') month_year, to_char(now() - INTERVAL '1 month','Mon yyyy') month_value";

	public static final String CHECK_EMPLOYEE_IN_LOP = "select * from employee_lop WHERE emp_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String UPDATE_LOPLIST_XL = "UPDATE employee_lop SET days=? WHERE emp_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

}