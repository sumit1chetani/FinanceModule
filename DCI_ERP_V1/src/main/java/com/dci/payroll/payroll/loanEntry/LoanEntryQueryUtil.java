package com.dci.payroll.payroll.loanEntry;

public class LoanEntryQueryUtil {

	public static String loanIdAutoGen = "SELECT CASE WHEN MAX(loan_id) IS NULL THEN '1' ELSE MAX(loan_id)+1 END FROM loan";

	public static String SELECT_LOANENTRY = "SELECT e.emp_id,e.emp_name employeeName,    c.company_code,c.company_name,    bd.branch_code,bd.branch_name,    l.loan_id,l.loan_type_id,l.amount,l.number_of_instalments,to_char(to_date(deduct_from, 'MMYYYY'), 'Mon YYYY') deduct_from,l.deduction_amount,l.status,    lt.interest_rate,lt.flat_or_diminishing,lt.loan_type_name FROM loan l,loan_type lt,employee_master e     INNER JOIN branch bd ON e.branch_department_id=bd.brnch_id       INNER JOIN company_master c ON c.company_code=bd.company_code      WHERE l.loan_type_id=lt.loan_type_id AND e.emp_id=l.emp_id AND  l.status=?"; 


	public static final String CHECK_LOAN_EXISTS = "SELECT l.*,lt.interest_rate,lt.flat_or_diminishing FROM loan l,loan_type lt WHERE (l.loan_type_id=lt.loan_type_id AND l.loan_type_id=? AND l.employee_id=?) AND (l.status=1 OR l.status=2)";

	public static final String INSERT_LOANENTRY = "INSERT INTO loan(loan_id,employee_id,loan_type_id,amount,number_of_instalments,deduct_from,deduction_amount,status) VALUES (:loanId,:employeeId,:loanTypeId,:amount,:numberOfInstalments,:deductFrom,:deductionAmount,:status)";

	public static String SELECT_LOANENTRYBYID = "SELECT e.employee_id,e.first_name ||' ' ||e.middle_name ||' '||e.surname employeeName," + " l.loan_id,l.loan_type_id,l.amount,l.number_of_instalments,deduct_from,to_char(to_date(deduct_from, 'MMYYYY'), 'Mon YYYY') deduct_from_display,l.deduction_amount,l.status," + " lt.interest_rate,lt.flat_or_diminishing,lt.loan_type_name" + " FROM loan l,loan_type lt,employee e" + " WHERE l.loan_type_id=lt.loan_type_id AND e.employee_id=l.employee_id AND" + " l.loan_id=?";

	public static String SELECT_LOANENTRY_BYSTATUS_EMPID = "SELECT e.emp_id as employeeId ,e.emp_name as  employeeName,c.company_code,c.company_name,b.brnch_id,b.brnch_nam,d.dept_code,d.dept_name,l.loan_id,l.loan_type_id,l.amount,l.number_of_instalments,to_char(to_date(deduct_from, 'MMYYYY'), 'Mon YYYY') deduct_from,l.deduction_amount,l.status,lt.interest_rate,lt.flat_or_diminishing,lt.loan_type_name FROM loan l,loan_type lt,employee_master e INNER JOIN branch b ON b.brnch_id =e.branch_department_id INNER JOIN company_master c ON c.company_code=b.company_code INNER JOIN department_master d ON d.dept_code=e.dept  WHERE l.loan_type_id=lt.loan_type_id AND e.emp_id=l.emp_id AND l.status= ? AND l.emp_id=(select user_ref_id_emp from user_master where user_id= ?)";

	public static String getemployeeId = "select first_name as employee_name from employee_master where emp_id=?";

	public static String UPDATE_LOANENTRY = "UPDATE loan SET loan_type_id=:loanTypeId,amount=:amount,number_of_instalments=:numberOfInstalments,deduct_from=:deductFrom,deduction_amount=:deductionAmount,status=:status WHERE loan_id=:loanId";

	public static String UPDATE_APPROVAL_LOANENTRY = "UPDATE loan SET approved_on=to_date(:approved_on,'dd/mm/yyyy'),approved_by=:approved_by,status=:status WHERE loan_id=:loan_id";

	public static String DELETE_LOANENTRY = "Delete from loan where loan_id=?";

}
