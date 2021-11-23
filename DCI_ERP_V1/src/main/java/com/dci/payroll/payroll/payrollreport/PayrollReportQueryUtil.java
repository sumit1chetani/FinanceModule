package com.dci.payroll.payroll.payrollreport;

public class PayrollReportQueryUtil {

/*	public static final String PAYROLL_HEADER = "SELECT distinct pay_component_id as headeNames  FROM emp_monthly_pay_component(?,?,?,?) S,employee E ,employee_worked el WHERE S.employee_id=E.employee_id and el.employee_id = S.employee_id  and E.status = 'true' ";

	public static final String PAYROLL_LIST = "SELECT coalesce(el.lop_days,0) lopDays,S.avail as avail, coalesce(round(el.lop_amount,0),0) lopAmount,S.employee_id,first_name||' '|| E.middle_name ||' '||E.surname employeeName, to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,pay_component_id,coalesce(round(amount),0) amount,E.epf_no epfno,E.uan_no uanno FROM emp_monthly_pay_component(?,?,?,?) S,employee E ,employee_worked el WHERE S.employee_id=E.employee_id and el.employee_id = S.employee_id  and E.status = 'true' ORDER BY E.employee_id";

	public static final String MONTHLY_PAYROLL_LIST = "SELECT employee_id,first_name||' '|| middle_name ||' '||surname employeeName,month_year,pay_component_id,round(amount) amount FROM (" + "SELECT to_char(to_date(month_year, 'MMYYYY'), 'Mon YYYY') month_year, pay_component_id, amount" + " FROM emp_all_pay_component(?) ORDER BY to_date(month_year, 'MMYYYY')) S,employee E WHERE employee_id=? and E.status = 'true'";*/


//	public static final String PAYROLL_LIST = "SELECT coalesce(el.lop_days,0) lopDays, coalesce(round(el.lop_amount,0),0) lopAmount,S.emp_id,first_name||' '|| E.middle_name ||' '||E.surname employeeName, to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,pay_component_id,coalesce(round(amount),0) amount,E.epf_no epfno,E.uan_no uanno FROM emp_monthly_pay_component(?,?,?,?) S,employee_master E ,employee_worked el WHERE S.emp_id=E.emp_id and el.emp_id = S.emp_id  and E.status = 'Y' ORDER BY E.emp_id";
	public static final String PAYROLL_LIST =""
			+ "SELECT coalesce(el.lop_days,0) lopDays, coalesce(round(el.lop_amount,0),0) lopAmount,S.employee_id,e.emp_name employeeName, to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,pay_component_id,coalesce(round(amount),0) amount,E.epf_no epfno,E.uan_no uanno FROM emp_monthly_pay_component(?,?,?,?) S left join employee_master E  on S.employee_id=E.emp_id "
			+ "left join employee_worked el on   el.employee_id = S.employee_id  and E.status = 'Y' ORDER BY E.emp_id";
			
			
	public static final String MONTHLY_PAYROLL_LIST = "SELECT emp_id employeeId,first_name||' '|| middle_name ||' '||surname employeeName,month_year,pay_component_id,round(amount) amount FROM (" + "SELECT to_char(to_date(month_year, 'MMYYYY'), 'Mon YYYY') month_year, pay_component_id, coalesce(amount,0) as amount" + " FROM emp_all_pay_component(?) ORDER BY to_date(month_year, 'MMYYYY')) S,employee_master E WHERE emp_id=? and E.status = 'Y'";
}