package com.dci.payroll.payroll.loanrepayment;

public class LoanRepaymentQueryUtil {

	/*public static final String SELECT_TO_DEDUCTED_LIST = "" + "with l as " + "( " + "   select loan_id,loan_type_id, employee_id, number_of_instalments, deduct_from, deduction_amount from loan where status = 2 " + "), " + "oldloan as " + "( " + "    select lr.loan_id,l.loan_type_id, employee_id, ?::varchar(6) month_year , lr.amount deduction_amount, lr.current_emi_no + 1 current_emi_no, lr.total_emi " + "    from loan_repayment lr, l " + "    where current_emi_no = (select max(current_emi_no) from loan_repayment "
			+ "                            where loan_id = lr.loan_id and current_emi_no < total_emi) " + "          and lr.loan_id = l.loan_id " + "), " + "newloan as " + "( " + "   select loan_id,loan_type_id, employee_id, ?::varchar(6),  deduction_amount, 1, number_of_instalments " + "   from loan where deduct_from = ? " + "), " + "d as (select * from oldloan union select * from newloan ) "
			+ "select d.loan_id,d.loan_type_id,to_char(to_date(d.month_year, 'MMYYYY'), 'Mon YYYY') month_year,d.current_emi_no,d.deduction_amount,d.total_emi,d.employee_id, e.first_name||' '||e.middle_name||' '||e.surname employeeName,lt.loan_type_name from d, employee e,loan_type lt " + "where d.employee_id = e.employee_id AND d.loan_type_id=lt.loan_type_id";

	public static final String SELECT_LOAN_REPORT = "select l.employee_id employeeId,e.first_name employeeName,concat(l.loan_type_id,'-',lt.loan_type_name) loantypeName, l.deduct_from deductFrom, l.number_of_instalments installment,l.amount loanAmount,l.deduction_amount deductAmount from loan l inner join loan_type lt on l.loan_type_id = lt.loan_type_id inner join employee e on l.employee_id = e.employee_id inner join department d on  e.department_id = d.department_id where e.department_id = ? ::int";

	public static final String SELECT_DEDUCTED_LIST = "SELECT LR.loan_id, L.loan_type_id, LT.loan_type_name, L.employee_id, E.first_name||' '||E.middle_name||' '||E.surname employeeName, LR.amount deductionAmount,to_char(to_date(month_year, 'MMYYYY'), 'Mon YYYY') month_year" + " FROM loan_repayment LR, Loan L, employee E, Loan_type LT" + " WHERE LR.loan_id = L.loan_id AND L.employee_id = E.employee_id  AND L.loan_type_id = LT.loan_type_id" + " AND to_date(month_year,'mmyyyy')  =  to_date(?,'mmyyyy')";

	public static final String CHECK_REPAYMENT_EXISTS = "SELECT * FROM loan_repayment WHERE loan_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String INSERT_LOAN_REPAYMENT = "INSERT INTO loan_repayment(loan_id,month_year,amount,current_emi_no,total_emi) VALUES(:loanId,to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),:amount,:current_emi_no,:total_emi)";

	public static final String UPDATE_LOAN_REPAYMENT = "UPDATE loan_repayment SET loan_id=:loanId,month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),amount=:amount WHERE loan_id=:loanId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy')";

	public static final String INSERT_EMP_PAYCOM_PAID = "INSERT INTO employee_pay_component_paid(employee_id,pay_component_id,month_year,amount) VALUES(:employeeId,:loanTypeId,to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),:amount)";

	public static final String UPDATE_EMP_PAYCOM_PAID = "UPDATE employee_pay_component_paid SET employee_id=:employeeId,pay_component_id=:loanTypeId,month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),amount=:amount WHERE employee_id=:employeeId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy') AND pay_component_id=:loanTypeId";

	public static final String CHECK_EMP_PAYCOM_PAID_EXISTS = "SELECT * FROM employee_pay_component_paid WHERE employee_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy') AND pay_component_id=?";*/

	public static final String SELECT_TO_DEDUCTED_LIST = ""
			+ "with l as (    select loan_id,loan_type_id, emp_id, number_of_instalments, deduct_from, deduction_amount,status from loan where status = 2 ), oldloan as (     select lr.loan_id,l.loan_type_id,l.status, emp_id, ?::varchar(6) month_year , lr.amount deduction_amount, lr.current_emi_no + 1 current_emi_no, lr.total_emi     from loan_repayment lr, l     where current_emi_no = (select max(current_emi_no) from loan_repayment "
			+ "			                           where loan_id = lr.loan_id and current_emi_no < total_emi)           and lr.loan_id = l.loan_id ), newloan as (    select loan_id,loan_type_id,status, emp_id, ?::varchar(6),  deduction_amount, 1, number_of_instalments    from loan where deduct_from = ? ), d as (select * from oldloan union select * from newloan ) "
			+ "		 select d.loan_id,d.loan_type_id,d.status,to_char(to_date(d.month_year, 'MMYYYY'), 'Mon YYYY') month_year,d.current_emi_no,d.deduction_amount,d.total_emi,d.emp_id, e.emp_name  employeeName,lt.loan_type_name from d, employee_master e,loan_type lt where d.emp_id = e.emp_id AND d.loan_type_id=lt.loan_type_id  and d.status=2";
	public static final String SELECT_LOAN_REPORT = "select l.emp_id employeeId,e.emp_name employeeName,concat(l.loan_type_id,'-',lt.loan_type_name) loantypeName, l.deduct_from deductFrom, l.number_of_instalments installment,l.amount loanAmount,l.deduction_amount deductAmount from loan l inner join loan_type lt on l.loan_type_id = lt.loan_type_id inner join employee_master e on l.emp_id = e.emp_id inner join department_master d on    e.dept = d.dept_code where e.dept = ? ";

	public static final String SELECT_DEDUCTED_LIST = "SELECT LR.loan_id, L.loan_type_id, LT.loan_type_name, L.emp_id, E.emp_name employeeName, LR.amount deductionAmount,to_char(to_date(month_year, 'MMYYYY'), 'Mon YYYY') month_year" + " FROM loan_repayment LR, Loan L, employee_master E, Loan_type LT" + " WHERE LR.loan_id = L.loan_id AND L.emp_id = E.emp_id  AND L.loan_type_id = LT.loan_type_id" + " AND to_date(month_year,'mmyyyy')  =  to_date(?,'mmyyyy')";

	public static final String CHECK_REPAYMENT_EXISTS = "SELECT * FROM loan_repayment WHERE loan_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String INSERT_LOAN_REPAYMENT = "INSERT INTO loan_repayment(loan_id,month_year,amount,current_emi_no,total_emi) VALUES(:loanId,to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),:amount,:current_emi_no,:total_emi)";

	public static final String UPDATE_LOAN_REPAYMENT = "UPDATE loan_repayment SET loan_id=:loanId,month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),amount=:amount WHERE loan_id=:loanId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy')";

	public static final String INSERT_EMP_PAYCOM_PAID = "INSERT INTO employee_pay_component_paid(employee_id,pay_component_id,month_year,amount) VALUES(:empId,:loanTypeId,to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),:amount)";

	public static final String UPDATE_EMP_PAYCOM_PAID = "UPDATE employee_pay_component_paid SET employee_id=:empId,pay_component_id=:loanTypeId,month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy'),amount=:amount WHERE emp_id=:empId AND month_year=to_char(to_date(:monthYear, 'Mon YYYY'),'mmyyyy') AND pay_component_id=:loanTypeId";

	public static final String CHECK_EMP_PAYCOM_PAID_EXISTS = "SELECT * FROM employee_pay_component_paid WHERE employee_id=? AND month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy') AND pay_component_id=?";
}


