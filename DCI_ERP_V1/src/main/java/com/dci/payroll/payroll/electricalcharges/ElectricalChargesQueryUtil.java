package com.dci.payroll.payroll.electricalcharges;

public class ElectricalChargesQueryUtil {
	public static final String ebList = "SELECT  E.employee_id, to_char(to_date(?, 'MMYYYY'), 'MMYYYY') monthValue, E.first_name||' '||E.middle_name||' '||E.surname AS employee_name,to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year, CASE WHEN units IS NULL THEN 0 ELSE  units END AS  units ,CASE WHEN charges IS NULL THEN 0 ELSE charges END AS charges   FROM employees(?,?,?,null) E "

	+ "LEFT OUTER JOIN employee_electical_charges ec ON E.employee_id = ec.employee_id AND ec.month_year=?";

	public static final String SELECT_EBLIST_ID_MONYR = "SELECT * FROM employee_electical_charges WHERE employee_id=? AND month_year=?";

	public static final String INSERT_EBLIST = "INSERT INTO employee_electical_charges (employee_id,month_year,units,charges) VALUES (:employeeId,to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),:units,:charges)";

	public static final String UPDATE_EBLIST = "UPDATE employee_electical_charges SET units=:units,charges=:charges WHERE employee_id=:employeeId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy')";

	public static final String GET_CHARGEVALUE = "select * from create_unitcharges(?)  as charges";

	public static final String CHECK_EMP_PAYCOM_PAID_EXISTS = "SELECT * FROM employee_pay_component_paid WHERE employee_id=? AND month_year=? AND pay_component_id=?";

	public static final String INSERT_EMP_PAYCOM_PAID = "INSERT INTO employee_pay_component_paid(employee_id,pay_component_id,month_year,amount) VALUES(:employee_id,:pay_component_id,:month_year,:amount)";

	public static final String UPDATE_EMP_PAYCOM_PAID = "UPDATE employee_pay_component_paid SET employee_id=:employee_id,pay_component_id=:pay_component_id,month_year=:month_year,amount=:amount WHERE employee_id=:employee_id AND month_year=:month_year AND pay_component_id=:pay_component_id";

	public static final String DELETE_EMP_PAYCOM = "delete from  employee_pay_component_paid  WHERE employee_id=:employee_id AND month_year=:month_year AND pay_component_id=:pay_component_id";

	public static final String DELETE_EBLIST = "delete from  employee_electical_charges  WHERE employee_id=:employeeId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy')";

	public static final String SELECT_EBXLLIST_ID_MONYR = "SELECT * FROM employee_electical_charges WHERE employee_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";
}
