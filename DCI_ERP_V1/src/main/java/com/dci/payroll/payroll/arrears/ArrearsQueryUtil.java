package com.dci.payroll.payroll.arrears;

public class ArrearsQueryUtil {

	public static final String GET_ARREARS_SALARY_LIST = "SELECT  E.employee_id, to_char(to_date(?, 'MMYYYY'), 'MMYYYY') monthValue, case when E.middle_name!='' " + "then E.first_name||' '||E.middle_name||' '||E.surname else E.first_name||' '||E.surname end AS employee_name, " + "to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year, " + "CASE WHEN amount IS NULL THEN 0 ELSE amount END AS amount " + "FROM employees(?,?,?,null) E LEFT OUTER JOIN employee_arrears_salary ec ON E.employee_id = ec.employee_id AND ec.month_year=?";

	public static final String SELECT_ARREARSLIST_ID_MONYR = "SELECT * FROM employee_arrears_salary WHERE employee_id=? AND month_year=?";

	public static final String INSERT_ARREARSLIST = "INSERT INTO employee_arrears_salary (employee_id,month_year,amount,created_by) VALUES (:employeeId,to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),:amount,:createdby)";

	public static final String UPDATE_ARREARSLIST = "UPDATE employee_arrears_salary SET amount=:amount,modified_by=:modifiedby WHERE employee_id=:employeeId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy')";

	public static final String DELETE_ARREARSLIST = "delete from  employee_arrears_salary  WHERE employee_id=:employeeId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy')";

	public static final String CHECK_EMP_PAYCOM_PAID_EXISTS = "SELECT * FROM employee_pay_component_paid WHERE employee_id=? AND month_year=? AND pay_component_id=?";

	public static final String INSERT_EMP_PAYCOM_PAID = "INSERT INTO employee_pay_component_paid(employee_id,pay_component_id,month_year,amount,department_id) VALUES(:employee_id,:pay_component_id,:month_year,:amount,:department_id)";

	public static final String UPDATE_EMP_PAYCOM_PAID = "UPDATE employee_pay_component_paid SET employee_id=:employee_id,pay_component_id=:pay_component_id,month_year=:month_year,amount=:amount WHERE employee_id=:employee_id AND month_year=:month_year AND pay_component_id=:pay_component_id";

	public static final String DELETE_EMP_PAYCOM = "delete from  employee_pay_component_paid  WHERE employee_id=:employee_id AND month_year=:month_year AND pay_component_id=:pay_component_id";

	public static final String DELETE_EBLIST = "delete from  employee_arrears_salary  WHERE employee_id=:employeeId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy')";

	public static final String SELECT_EBXLLIST_ID_MONYR = "SELECT * FROM employee_arrears_salary WHERE employee_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";
}
