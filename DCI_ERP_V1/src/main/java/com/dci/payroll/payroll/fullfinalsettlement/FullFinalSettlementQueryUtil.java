package com.dci.payroll.payroll.fullfinalsettlement;

public class FullFinalSettlementQueryUtil {
/*	public static final String seclectFinalSettlement = "SELECT fs.settlement_date,fs.employee_id, e.first_name || ' ' || e.middle_name || ' '|| e.surname as employeeName,d.department_name as departmentName ,b.branch_name as branchName, c.company_name as companyName from full_final_settlement fs LEFT OUTER JOIN employee e ON fs.employee_id=	e.employee_id LEFT OUTER JOIN department d ON e.department_id=	d.department_id LEFT OUTER JOIN	branch b ON d.branch_id=b.branch_id LEFT OUTER JOIN company c ON b.company_id=c.company_id";

	public static final String FINAL_SETTLEMENT_LIST = "select employee_final_settlement_id,emp_id,created_date, created_by,status from employee_final_settlement where emp_id =?";

	public static final String FINAL_SETTLEMENT_DETAIL_LIST = "select employee_final_settlement_dtl_id, credit,debit, description, employee_final_settlement_id from employee_final_settlement_dtl where employee_final_settlement_id=?";

	public static final String INSERT_FINAL_SETTLEMENT = "INSERT INTO employee_final_settlement(employee_id,created_date, created_by,status) VALUES (:employee_id,to_date(:created_date,'DD/MM/YYYY'),:created_by,:status)";

	public static final String GET_FINAL_SETTLEMENT_HDR_ID = "select employee_final_settlement_id from employee_final_settlement where employee_id=?";

	public static final String DELETE_SETTLEMENT_DETAIL_ID = "delete from employee_final_settlement_dtl where employee_final_settlement_id=?";

	public static final String INSERT_FINAL_DETAIL_SETTLEMENT = "INSERT INTO employee_final_settlement_dtl(credit,debit, description,employee_final_settlement_id) VALUES (:credit,:debit,:description,:employee_final_settlement_id)";

	public static final String UPDATE_FINAL_SETTLEMENT = "UPDATE employee_final_settlement SET approved_date=:approved_date, approved_by=:approved_by,status=:status WHERE employee_id=:employee_id";

}*/
	
	public static final String seclectFinalSettlement = "SELECT fs.settlement_date,fs.emp_id, e.first_name || ' ' || e.middle_name || ' '|| e.surname as employeeName,d.department_name as departmentName ,b.branch_name as branchName, c.company_name as companyName from full_final_settlement fs LEFT OUTER JOIN employee e ON fs.emp_id=	e.emp_id LEFT OUTER JOIN department d ON e.department_id=	d.department_id LEFT OUTER JOIN	branch b ON d.branch_id=b.branch_id LEFT OUTER JOIN company c ON b.company_id=c.company_id";

	public static final String FINAL_SETTLEMENT_LIST = "select employee_final_settlement_id,emp_id,created_date, created_by,status from employee_final_settlement where emp_id=?";

	public static final String FINAL_SETTLEMENT_DETAIL_LIST = "select employee_final_settlement_dtl_id, credit,debit, description, employee_final_settlement_id from employee_final_settlement_dtl where employee_final_settlement_id=?";

	public static final String INSERT_FINAL_SETTLEMENT = "INSERT INTO employee_final_settlement(emp_id,created_date, created_by,status) VALUES (:emp_id,to_date(:created_date,'DD/MM/YYYY'),:created_by,:status)";

	public static final String GET_FINAL_SETTLEMENT_HDR_ID = "select employee_final_settlement_id from employee_final_settlement where emp_id=?";

	public static final String DELETE_SETTLEMENT_DETAIL_ID = "delete from employee_final_settlement_dtl where employee_final_settlement_id=?";

	public static final String INSERT_FINAL_DETAIL_SETTLEMENT = "INSERT INTO employee_final_settlement_dtl(credit,debit, description,employee_final_settlement_id) VALUES (:credit,:debit,:description,:employee_final_settlement_id)";

	public static final String UPDATE_FINAL_SETTLEMENT = "UPDATE employee_final_settlement SET approved_date=:approved_date, approved_by=:approved_by,status=:status WHERE emp_id=:emp_id";
}