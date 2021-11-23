package com.dci.payroll.payroll.Esi;

public class EsiQueryUtil {

	public static final String SELECT_ESI_LIST =  "SELECT  distinct E.emp_id as employeeId, employee_name as employeeName, esic_code, date_part('day', to_date('01'||?, 'ddmmyyyy')  + '1 month'::interval - '1 day'::interval) - COALESCE(lop,0) days," + " COALESCE(earnings,0) Wages FROM (select emp_id, first_name||' '||middle_name||' '||surname AS employee_name from  employees(?,?,?,null) ) E " + " LEFT OUTER JOIN  ( select employee_id,  sum(amount) earnings from employee_pay_component_paid p, pay_component pc where P.pay_component_id = pc.pay_component_id "
			+ " and  month_year = ? and pc.pay_component_type = 1 and pc.is_allowance = false group by p.employee_id) s ON E.emp_id = s.employee_id" + " LEFT OUTER JOIN employee_master ee on e.emp_id = ee.emp_id" + " LEFT OUTER JOIN (select emp_id, days lop from employee_lop where month_year = ?) D on E.emp_id = D.emp_id where COALESCE(earnings,0) < 15000";

	public static final String CHECK_ESILIST = "select * from employee_esi_paid  where employee_id=? and month_year=?";

	public static final String INSERT_ESI_PAID = "INSERT INTO employee_esi_paid" + "(employee_id,month_year,esi_salary,days_worked) " + "VALUES (:employee_id,:month_year,:esi_salary,:days_worked)";

	public static final String DELET_ESI_PAID = "DELETE FROM employee_esi_paid where employee_id=:employee_id and month_year=:month_year";
}
