package com.dci.payroll.payroll.employeeTds;

public class EmployeeTdsQueryUtil {

	/*public static final String stdsList = "SELECT  E.employee_id, E.first_name||' '||E.middle_name||' '||E.surname AS employee_name,to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,to_char(to_date(?, 'MMYYYY'), 'MMYYYY') monthYearValue, CASE WHEN actual_tds IS NULL THEN 0 ELSE actual_tds END AS actual_tds,CASE WHEN estimated_tds IS NULL THEN 0 ELSE estimated_tds END AS estimated_tds FROM employees(?,?,?,null) E LEFT OUTER JOIN employee_tds el ON E.employee_id = el.employee_id AND el.month_year=?";

	public static final String CHECK_EMPLOYEE_IN_TDS_XL = "select * from employee_tds WHERE employee_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String INSERT_EMPLOYEE_IN_TDS = "INSERT INTO employee_tds(employee_id,month_year,estimated_tds,actual_tds) values(?, to_char(to_date(?, 'Mon YYYY'),'mmyyyy'), ?,?)";

	public static final String UPDATE_EMPLOYEE_TDS_XL = "UPDATE employee_tds set estimated_tds=?,actual_tds=? where employee_id=? and month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String DELETE_EMPLOYEE_IN_TDS_XL = "delete from  employee_tds where employee_id=? and month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String CHECK_EMPLOYEE_IN_TDS = "select * from employee_tds WHERE employee_id=? AND month_year=?";

	public static final String INSERT_EMPLOYEE_TDS_INSERT = "INSERT INTO employee_tds(employee_id,month_year,estimated_tds,actual_tds) values(?, ?, ?,?)";

	public static final String UPDATE_EMPLOYEE_TDS = "UPDATE employee_tds set estimated_tds=?,actual_tds=? where employee_id=? and month_year=?";

	public static final String DELETE_EMPLOYEE_IN_TDS = "delete from  employee_tds where employee_id=? and month_year=?";*/
	
	
	
	
	
	
	public static final String stdsList = "SELECT distinct E.emp_id as employeeId, E.emp_name AS employee_name,to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,to_char(to_date(?, 'MMYYYY'), 'MMYYYY') monthYearValue, CASE WHEN actual_tds IS NULL THEN 0 ELSE actual_tds END AS actual_tds,CASE WHEN estimated_tds IS NULL THEN 0 ELSE estimated_tds END AS estimated_tds FROM employees(?,?,?,null) E LEFT OUTER JOIN employee_tds el ON E.emp_id = el.employee_id AND el.month_year=? ";

	public static final String CHECK_EMPLOYEE_IN_TDS_XL = "select * from employee_tds WHERE employee_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String INSERT_EMPLOYEE_IN_TDS = "INSERT INTO employee_tds(employee_id,month_year,estimated_tds,actual_tds) values(?, to_char(to_date(?, 'Mon YYYY'),'mmyyyy'), ?,?)";

	public static final String UPDATE_EMPLOYEE_TDS_XL = "UPDATE employee_tds set estimated_tds=?,actual_tds=? where employee_id=? and month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String DELETE_EMPLOYEE_IN_TDS_XL = "delete from  employee_tds where employee_id=? and month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String CHECK_EMPLOYEE_IN_TDS = "select * from employee_tds WHERE employee_id=? AND month_year=?";

	public static final String INSERT_EMPLOYEE_TDS_INSERT = "INSERT INTO employee_tds(employee_id,month_year,estimated_tds,actual_tds) values(?, ?, ?,?)";

	public static final String UPDATE_EMPLOYEE_TDS = "UPDATE employee_tds set estimated_tds=?,actual_tds=? where employee_id=? and month_year=?";

	public static final String DELETE_EMPLOYEE_IN_TDS = "delete from  employee_tds where employee_id=? and month_year=?";

}