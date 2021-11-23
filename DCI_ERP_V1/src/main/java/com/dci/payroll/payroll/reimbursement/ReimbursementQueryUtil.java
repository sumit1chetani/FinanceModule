package com.dci.payroll.payroll.reimbursement;

public class ReimbursementQueryUtil {
	public static String INSERT_REIMBURSEMENT = "INSERT INTO employee_reimbursement_request" + " (reimbursement_id,employee_id,reimbursement_type_id,payment_mode,currency_code,amount,description,requested_by,requested_date,status,attachment)" + " VALUES (:reimbursement_id,:employee_id,:reimbursement_type_id,:payment_mode,:currency_code,:amount,:description,:requested_by,to_date(:requested_date,'dd/mm/yyyy'),:status,:attachment)";

	public static String reimbursementIdAutoGen = "SELECT CASE WHEN MAX(reimbursement_id) IS NULL THEN '1' ELSE MAX(reimbursement_id)+1 END FROM employee_reimbursement_request";

	public static String LIST_REIMBURSEMENT = "select er.reimbursement_id ,er.employee_id employeeId, e.first_name||' '||e.middle_name||' '||e.surname employeeName, rt.reimbusement_name, er.reimbursement_type_id ,er.payment_mode ,er.currency_code ,er.amount amount, er.description description , er.status status , er.attachment fileName from employee_reimbursement_request as er inner join employee as e on  er.employee_id= e.employee_id inner join reimbursement_type as rt on rt.reimbursement_type_id=er.reimbursement_type_id where er.status=?";

	public static String LIST_REIMBURSEMENT_BYSTATUS = "select er.reimbursement_id ,er.employee_id employeeId,e.first_name||' '||e.middle_name||' '||e.surname employeeName, rt.reimbusement_name, er.reimbursement_type_id ,er.payment_mode ,er.currency_code ,er.amount amount, er.description description , er.status status, er.attachment fileName  from employee_reimbursement_request as er inner join employee as e on  er.employee_id= e.employee_id inner join reimbursement_type as rt on rt.reimbursement_type_id=er.reimbursement_type_id where er.status=? and er.employee_id=?";

	public static String SELECT_REIMBURSEMENT_ID = "SELECT er.employee_id,er.reimbursement_id,er.reimbursement_type_id,er.payment_mode,er.currency_code,er.amount,er.description, er.status,er.attachment," + "rt.reimbusement_name, e.first_name||' '||e.middle_name||' '||e.surname employeeName, d.department_id,d.department_name, b.branch_id,b.branch_name,c.company_id,c.company_name,cu.currency_name" + " FROM employee_reimbursement_request er" + " INNER JOIN employee e ON e.employee_id = er.employee_id"
			+ " INNER JOIN branch_department bd ON e.branch_department_id=bd.branch_department_id" + " INNER JOIN branch b ON bd.branch_id=b.branch_id" + " INNER JOIN company c ON c.company_id=b.company_id" + " INNER JOIN department d ON d.department_id = bd.department_id" + " INNER JOIN reimbursement_type rt ON er.reimbursement_type_id=rt.reimbursement_type_id" + " INNER JOIN currency  cu ON er.currency_code = cu.currency_code WHERE er.reimbursement_id=?";

	public static String UPDATE_REIMBURSEMENT = "UPDATE employee_reimbursement_request SET  reimbursement_type_id=:reimbursement_type_id,payment_mode=:payment_mode, currency_code=:currency_code, amount=:amount, description=:description ,attachment=:attachment WHERE reimbursement_id=:reimbursement_id";

	public static String UPDATE_APPORVAL_REIMBURSEMENT = "UPDATE employee_reimbursement_request SET approved_by=:approved_by, approved_date=to_date(:approved_date,'DD/MM/YYYY'), status=:status, description=:description WHERE reimbursement_id=:reimbursement_id";

	public static String DELETE_REIMBURSEMENT = "Delete from employee_reimbursement_request where reimbursement_id=?";

	public static String SELECT_CURRENCYLIST = "select currency_code , currency_code as id,currency_name,currency_name as text from currency";

	public static String SELECT_REIMBURSEMENTTYPELIST = "select reimbursement_type_id,reimbursement_type_id as id, reimbusement_name ,reimbusement_name as text from reimbursement_type";

}
