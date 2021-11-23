package com.dci.payroll.payroll.employeebonus;

public class EmployeeBonusQueryUtil {

	public static final String SELECT_EMPLOYEE_BONUS_LIST = "SELECT   DISTINCT T.bonus_id,E.emp_id as employeeId, E.first_name||' '||E.middle_name||' '||E.surname AS employee_name, ? financial_year," + "CASE WHEN declared_amount IS NULL THEN 0 ELSE declared_amount END AS declared_amount,CASE WHEN declared_amount IS NULL THEN 0 ELSE declared_amount END AS checkPayAmount," + "CASE WHEN T.paid_amount IS NULL THEN 0 ELSE T.paid_amount END AS paid_amount" + " FROM employees(?,?,?,null) E" + " LEFT OUTER JOIN" + " ("
			+ " SELECT B.bonus_id,employee_id,  declared_amount, P.paid_amount" + " FROM employee_bonus B" + " LEFT OUTER JOIN (select bonus_id, sum(EBP.paid_amount) paid_amount from employee_bonus_paid EBP group by bonus_id) P" + " ON B.bonus_id = P.bonus_id" + " WHERE financial_year = ?" + " ) T ON E.emp_id = T.employee_id";

	public static final String SELECT_EMP_BONUS_BY_ID = "SELECT * FROM employee_bonus WHERE employee_id=? AND financial_year=?";

	public static final String INSERT_EMPBONUS = "INSERT INTO employee_bonus(employee_id,financial_year,declared_amount) VALUES(:employeeId,:financialYear,:declaredAmount)";

	public static final String UPDATE_EMPBONUS = "UPDATE employee_bonus SET declared_amount=:declaredAmount WHERE employee_id=:employeeId AND financial_year=:financialYear";

	public static final String SELECT_EMP_BONUS_SUMMARY = "SELECT  ebp.bonus_id,ebp.paid_amount,to_char(ebp.paid_on,'DD-Mon-YYYY') paid_on,eb.declared_amount,e.employee_id,e.first_name||' '||e.middle_name||' '||e.surname AS employeeName FROM employee_bonus_paid ebp,employee_bonus eb,employee e WHERE ebp.bonus_id=eb.bonus_id AND e.employee_id=eb.employee_id AND ebp.bonus_id=?";

	public static final String UPDATE_BONUS_SUMMARY = "UPDATE employee_bonus_paid SET paid_amount=:paidAmount, paid_on=to_date(:paidOn,'DD/MM/YYYY') WHERE bonus_id=:bonusId AND paid_on=to_date(:paidOn,'DD/MM/YYYY')";

	public static final String INSERT_BONUS_SUMMARY = "INSERT INTO employee_bonus_paid(bonus_id,paid_amount,paid_on) VALUES(:bonus_id,:paid_amount,to_date(:paid_on,'DD/MM/YYYY'))";

	public static final String SELECT_EMP_SUMMARY_BY_ID = "SELECT ebp.bonus_id,ebp.paid_amount,paid_on,eb.declared_amount,e.employee_id,e.first_name||' '||e.middle_name||' '||e.surname AS employeeName" + " FROM employee_bonus_paid ebp,employee_bonus eb,employee e" + " WHERE ebp.bonus_id=eb.bonus_id AND e.employee_id=eb.employee_id AND ebp.bonus_id=? AND ebp.paid_on=to_date(?,'DD/MM/YYYY')";

	public static final String SELECT_EMP_BONUS_BY_BONUS_ID = "SELECT  T.bonus_id,E.employee_id, E.first_name||' '||E.middle_name||' '||E.surname AS employee_name, CASE WHEN declared_amount IS NULL THEN 0 ELSE declared_amount END AS declared_amount, CASE WHEN paid_amount IS NULL THEN 0 ELSE paid_amount END AS paid_amount FROM employee E INNER JOIN ( SELECT B.bonus_id, employee_id,  declared_amount, paid_amount FROM employee_bonus B LEFT OUTER JOIN (select bonus_id, sum(paid_amount) paid_amount from employee_bonus_paid group by bonus_id) P ON B.bonus_id = P.bonus_id WHERE B.bonus_id = ? ) T ON E.employee_id = T.employee_id";

	public static final String CHECK_EMPLOYEE_BONUS_PAID = "select to_char(MAX(paid_on),'DD/MM/YYYY') as paidOn from employee_bonus_paid where bonus_id=?";

}