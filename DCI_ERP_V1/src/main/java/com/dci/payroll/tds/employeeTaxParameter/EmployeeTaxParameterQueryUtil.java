package com.dci.payroll.tds.employeeTaxParameter;

public class EmployeeTaxParameterQueryUtil {

	public static final String SelectAll = "SELECT etp.employee_id,e.department_id,gender,etp.is_living_in_metro livingInMetro,etp.is_self_occupied_house selfOccupiedHouse,etp.ph_type,tp.tax_payer_type_name FROM Employees(?,?,?,?) e,employee_tax_parameters etp LEFT OUTER JOIN tax_payer_type tp ON etp.tax_payer_type_id=tp.tax_payer_type_id WHERE e.employee_id=etp.employee_id";
	public static final String EMPTAXPARAM_BY_EMPID = "SELECT etp.employee_id,gender,etp.is_living_in_metro livingInMetro,etp.is_self_occupied_house selfOccupiedHouse,etp.ph_type,tp.tax_payer_type_name,tp.tax_payer_type_id,d.department_id,d.department_name, b.branch_id,b.branch_name,c.company_id,c.company_name,e.first_name||' '||e.middle_name||' '||e.surname employeeName FROM employee_tax_parameters etp INNER JOIN employee e ON e.employee_id=etp.employee_id AND etp.employee_id=? INNER JOIN branch_department bd ON bd.branch_department_id=e.branch_department_id INNER JOIN branch b ON bd.branch_id=b.branch_id INNER JOIN company c ON c.company_id=b.company_id INNER JOIN department d ON d.department_id = bd.department_id INNER JOIN tax_payer_type tp ON tp.tax_payer_type_id = etp.tax_payer_type_id";
	public static final String INSERT_EMPTAX_PARAM = "INSERT INTO employee_tax_parameters(employee_id,is_living_in_metro,is_self_occupied_house,tax_payer_type_id,ph_type) VALUES(:employee_id,:is_living_in_metro,:is_self_occupied_house,:tax_payer_type_id,:ph_type)";
	public static final String UPDATE_EMPTAX_PARAM = "UPDATE employee_tax_parameters SET employee_id=:employee_id,is_living_in_metro=:is_living_in_metro,is_self_occupied_house=:is_self_occupied_house,tax_payer_type_id=:tax_payer_type_id,ph_type=:ph_type WHERE employee_id=:employee_id";
	public static final String DELETE_EMPTAX_PARAM = "DELETE FROM employee_tax_parameters WHERE employee_id=?";
}
