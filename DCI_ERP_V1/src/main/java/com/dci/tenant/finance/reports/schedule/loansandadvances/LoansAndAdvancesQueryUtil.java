package com.dci.tenant.finance.reports.schedule.loansandadvances;

public class LoansAndAdvancesQueryUtil {
	public static String GET_DEPARTMENT_LIST = "select DEPT_CODE as id,DEPT_NAME as text from DEPARTMENT_MASTER";

	public static String GET_CUSTOMER_LIST = " select MLO_CODE as id,MLO_NAME as text from mlo_master ";

	public static String GET_EMPLOYEE_LIST = " select distinct e.EMP_ID as id,e.EMP_NAME as text from EMPLOYEE_MASTER e where e.DEPT=? order by e.EMP_NAME ";

	public static String GET_LA_REPORT = " select s.loan_availed, s.loan, s.emp_id, e.emp_name as employeeName, TO_CHAR(s.pay_from_date,'dd/MM/yyyy') as payFromDate, TO_CHAR(s.pay_to_date,'dd/MM/yyyy') as payToDate, "
			+ " TO_CHAR(s.loan_from_date,'dd/MM/yyyy') as loanFromDate, TO_CHAR(s.loan_to_date,'dd/MM/yyyy') as loanToDate, (s.loan_availed-s.loan) as balance "
			+ " from SALARY_PROCESS s inner join EMPLOYEE_MASTER e on s.emp_id=e.emp_id where e.emp_id=? ";

	public static String GET_SUPPLIER_LIST = " select VENDOR_CODE as id,VENDOR_NAME as text from vendor_master ";

	public static String GET_LA_CUSTOMER_REPORT = "select gl.debit as debit, gl.credit as credit, gl.balance as balance, gl.sub_account_code, m.mlo_name as customer from general_ledger gl "
			+ " inner join mlo_master m on gl.sub_account_code = m.acct_head_code where m.mlo_code=? ";

	public static String GET_LA_ADVANCE_REPORT = "SELECT VIEW_ADVANCE.EMP_NAME as employeeName, VIEW_ADVANCE.LOAN, VIEW_ADVANCE.ADVANCE FROM   VIEW_ADVANCE";

	public static String GET_LA_SUPPLIER_REPORT = " select gl.debit as debit, gl.credit as credit, gl.balance as balance, gl.sub_account_code, v.vendor_name as supplier from general_ledger gl inner join vendor_master v on gl.sub_account_code = v.vendor_code where gl.sub_account_code=?  and sub_group_code=? ";

}
