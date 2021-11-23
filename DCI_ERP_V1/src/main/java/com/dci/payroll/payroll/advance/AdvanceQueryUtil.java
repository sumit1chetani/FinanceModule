package com.dci.payroll.payroll.advance;

public class AdvanceQueryUtil {

	public static final String SELECT_EMPLOYEE = "select emp_id as id,concat(emp_id,'-',first_name || middle_name || surname) as text from employee_master where status = 'Y' and payroll_flag!='t' order by text";

	public static final String SELECT_EMPLOYEE_DETAIL = "select e.emp_id as employeeCode,d.designation_name as designation,e.doj as joinDate  from employee_master e inner join designation d on d.designation_id = e.designation_id where e.employee_id = ?";

	public static final String no_of_years = "SELECT DATE_PART('year', to_date(?,'yyyy-MM-dd')::date) - DATE_PART('year', to_date(?,'yyyy-MM-dd')::date)";

	public static final String SELECT_DESIGNATION = "select designation_id as id, designation_name as text from designation where status ='Y'";

	public static final String SELECT_EMPLOYEE_basonDES = "select emp_id as id,concat(emp_id,'-',first_name || middle_name || surname) as text from employee_master where status = 'Y' and designation_id = ?";

	public static String check_max = "select CASE WHEN max(adv_code) is null then '0' else max(adv_code) end from (select substr(adv_code, 4) adv_code from emp_advance ) temp ";

	public static String insert_advance = "insert into emp_advance (adv_code,emp_id,description,amount,disbursement_date,open_blnc,installmts_paid,recovery_type,installment_amount,deduct_from_mnth,ttl_installmts,created_by,created_date) values (?,?,?,?,to_date(?,'dd-MM-yyyy'),?,?,?,?,to_date(?,'mmyyyy'),?,?,now())";

	public static String Advance_List = "select ea.adv_code advanceCode,ea.emp_id employeeCode,concat(e.first_name || e.middle_name || e.surname) employeeName, ea.amount amount, ea.recovery_type recoverytype, ea.installment_amount installmentAmount, ea.deduct_from_mnth deductFrom, ea.ttl_installmts numberOfInstallments from emp_advance ea inner join employee_master e on  ea.emp_id = e.emp_id";

	public static String Advance_List_byCode = "select adv_code advanceCode,emp_id employee, description description, amount amount,to_char(disbursement_date,'dd/MM/yyyy') disbursementDate, open_blnc openingBalance,installmts_paid installmentPaid, recovery_type recoverytype, installment_amount installmentAmount, deduct_from_mnth deductFrom, ttl_installmts numberOfInstallments from emp_advance where adv_code = ?";

	public static String Advance_List_byCode_blnceamount = "select adv_code advanceCode,emp_id employee, description description,emad.amount amount,to_char(disbursement_date,'dd/MM/yyyy') disbursementDate,emad.open_blnc openingBalance,emad.installmts_paid installmentPaid,emad.recovery_type recoverytype, emad.installment_amount installmentAmount,emad.deduct_from_mnth deductFrom, emad.ttl_installmts numberOfInstallments,  (emad.amount- sum(epcp.amount)) as balanceAmountReturn from emp_advance emad left join (select * from employee_pay_component_paid  where employee_pay_component_paid.pay_component_id='AD' )  epcp on  emad.emp_id=epcp.employee_id where adv_code=?  and   emad.emp_id=? group by adv_code,employee_id ";

	public static String Advance_Update = "update emp_advance set emp_id = ?,description = ?,amount = ?,disbursement_date =to_date(?,'dd-MM-yyyy'),open_blnc = ?,recovery_type = ?,installment_amount = ?,deduct_from_mnth = to_date(?,'mmyyyy'),ttl_installmts = ?, modified_by = ?, modified_date = now(), installmts_paid = ?  where adv_code = ?";

	public static String Advance_Delete = "delete from emp_advance where adv_code = ?";

	public static String Advance_AddList_DeptEmp = "select ea.adv_code advanceCode,ea.emp_id employeeCode,concat(ea.emp_id,'-',e.first_name || e.middle_name || e.surname) employeeName, ea.amount amount, ea.ttl_installmts numberOfInstallments, installmts_paid installmentPaid,sum(installmts_paid + 1) currentInstallment, ea.installment_amount installmentAmount, ea.installment_amount insAmt, ea.recovery_type recoverytype, e.branch_department_id departmentId, to_char(ea.deduct_from_mnth,'mmyyyy') monthYear from emp_advance ea inner join employee_master e on  ea.emp_id = e.emp_id inner join branch_department bd on e.branch_department_id = bd.branch_department_id where  bd.branch_id='BR001' and ea.deduct_from_mnth <= to_date(?,'mmyyyy') and bd.department_id = ? and e.employee_id = ? group by advanceCode,employeeName,departmentId order by advanceCode ";

	public static String Advance_AddList_Dept = "select ea.adv_code advanceCode,ea.emp_id employeeCode,concat(ea.emp_id,'-',e.first_name || e.middle_name || e.surname) employeeName, ea.amount amount, ea.ttl_installmts numberOfInstallments, installmts_paid installmentPaid,sum(installmts_paid + 1) currentInstallment, ea.installment_amount installmentAmount,  ea.installment_amount insAmt, ea.recovery_type recoverytype, e.branch_department_id departmentId, to_char(ea.deduct_from_mnth,'mmyyyy') monthYear from emp_advance ea inner join employee_master e on  ea.emp_id = e.emp_id inner join branch_department bd on e.branch_department_id = bd.branch_department_id where  bd.branch_id='BR001' and ea.deduct_from_mnth <= to_date(?,'mmyyyy') and bd.department_id= ? group by advanceCode,employeeName,departmentId ";

	public static String Advance_AddList = "select ea.adv_code advanceCode,ea.emp_id employeeCode,concat(ea.emp_id,'-',e.first_name || e.middle_name || e.surname) employeeName, ea.amount amount, ea.ttl_installmts numberOfInstallments, installmts_paid installmentPaid,sum(installmts_paid + 1) currentInstallment, ea.installment_amount installmentAmount,  ea.installment_amount insAmt,ea.recovery_type recoverytypess, e.branch_department_id departmentId, to_char(ea.deduct_from_mnth,'mmyyyy') monthYear from emp_advance ea inner join employee_master e on  ea.emp_id = e.emp_id inner join branch_department bd on e.branch_department_id = bd.branch_department_id where  bd.branch_id='BR001' and ea.deduct_from_mnth <= to_date(?,'mmyyyy') group by advanceCode,employeeName,departmentId  ";

	public static String Advance_amount_deduct = " insert into emp_advance_deduct (adv_code,emp_id,month_year,installmnt_amount,narration) values (?,?,to_date(?,'mmyyyy'),?,?) ";

	public static String Advance_ins_count = " select installmts_paid from emp_advance  where adv_code = ? ";

	public static String Advance_add_installment = " update emp_advance set installmts_paid  = ? where adv_code = ? ";

	public static String Advance_add_emp_component = "insert into employee_pay_component_paid (employee_id,pay_component_id,month_year,amount,department_id) values (?,?,?,?,?)";

	public static String Advance_AddList_DeptEmp_del = "select ea.adv_code advanceCode,ea.emp_id employeeCode,concat(ea.emp_id,'-',e.first_name || e.middle_name || e.surname) employeeName, ea.amount amount, ea.ttl_installmts numberOfInstallments, installmts_paid installmentPaid,sum(installmts_paid + 1) currentInstallment, ea.installment_amount installmentAmount, ea.recovery_type recoverytype from emp_advance ea inner join employee_master e on  ea.emp_id = e.emp_id inner join branch_department bd on e.branch_department_id = bd.branch_department_id inner join emp_advance_deduct ead on ead.adv_code = ea.adv_code where  bd.branch_id='BR001' and ea.deduct_from_mnth >= to_date(?,'mmyyyy') and bd.department_id = ? and e.employee_id = ? group by advanceCode,employeeName  ";

	public static String Advance_AddList_Dept_del = "select ea.adv_code advanceCode,ea.emp_id employeeCode,concat(ea.emp_id,'-',e.first_name || e.middle_name || e.surname) employeeName, ea.amount amount, ea.ttl_installmts numberOfInstallments, installmts_paid installmentPaid,sum(installmts_paid + 1) currentInstallment, ea.installment_amount installmentAmount, ea.recovery_type recoverytype from emp_advance ea inner join employee_master e on  ea.emp_id = e.emp_id inner join branch_department bd on e.branch_department_id = bd.branch_department_id inner join emp_advance_deduct ead on ead.adv_code = ea.adv_code where  bd.branch_id='BR001' and ea.deduct_from_mnth >= to_date(?,'mmyyyy') and bd.department_id= ? group by advanceCode,employeeName ";

	public static String Advance_AddList_del = "select ea.adv_code advanceCode,ea.emp_id employeeCode,concat(ea.emp_id,'-',e.first_name || e.middle_name || e.surname) employeeName, ea.amount amount, ea.ttl_installmts numberOfInstallments, installmts_paid installmentPaid,sum(installmts_paid + 1) currentInstallment, ea.installment_amount installmentAmount, ea.recovery_type recoverytypess from emp_advance ea inner join employee_master e on  ea.emp_id = e.emp_id inner join branch_department bd on e.branch_department_id = bd.branch_department_id inner join emp_advance_deduct ead on ead.adv_code = ea.adv_code where  bd.branch_id='BR001' and ea.deduct_from_mnth >= to_date(?,'mmyyyy') group by advanceCode,employeeName  ";

	public static String Advance_ReportList = " select ea.adv_code advanceCode,ea.emp_id employeeCode,concat(e.first_name || e.middle_name || e.surname) employeeName, ea.amount amount, ea.ttl_installmts numberOfInstallments, (ea.open_blnc - sum(installmnt_amount)) paidAmount, installmts_paid installmentPaid, (ea.open_blnc - sum(installmnt_amount)) balanceAmount, (ea.ttl_installmts - installmts_paid) balanceIns, ea.installment_amount installmentAmount, ead.narration narration from emp_advance ea inner join employee_master e on  ea.emp_id = e.emp_id left join  emp_advance_deduct ead on ea.adv_code = ead.adv_code where ead.month_year <= to_date(?,'mmyyyy')  group by advanceCode,employeeName, ead.narration  ";

	public static String Advance_add_emp_component_count = " select count(*)  from employee_pay_component_paid where employee_id = ? and month_year = ? and pay_component_id = ? ";

	public static String Advance_add_emp_component_AD = " select amount from employee_pay_component_paid where employee_id = ? and month_year = ? and pay_component_id = ? ";

	public static String Advance_add_emp_component_update = "update employee_pay_component_paid set amount = ?  where employee_id = ? and month_year = ? and pay_component_id = ?";

	public static final String insList = "select generate_series as id, generate_series as text from generate_series(0,?)";

	public static String NET_AMOUNT = "select amount from pay_slip1('C0008','BR001',?,?,?) where pay_component_id = 'NET'";

	public static String Advance_amount_deduct_check = "select count(*)  from emp_advance_deduct where emp_id = ? and month_year = to_date(?,'mmyyyy') ";

	public static String existADV_AMOUNT = "select sum(installmnt_amount) from  emp_advance_deduct where emp_id = ? and month_year = to_date(?,'mmyyyy')";

	public static String delete_Advance_amount_deduct = "delete from emp_advance_deduct where emp_id = ? and month_year = to_date(?,'mmyyyy')";

	public static String deleteAdvance_pay = "delete from employee_pay_component_paid where employee_id =? and month_year = ? and pay_component_id = ?";

	public static String Advance_tempList = "select ea.adv_code advanceCode,ea.installmts_paid installmentPaid,ea.emp_id employeeCode from emp_advance ea inner join emp_advance_deduct ead on ead.emp_id = ea.emp_id inner join emp_advance_deduct ead1 on ead1.adv_code = ea.adv_code where ead.emp_id = ? and ead.month_year = to_date(?,'mmyyyy')";

	public static String Advance_deduct_exist = "select count(*) from emp_advance_deduct where adv_code = ? and month_year = to_date(?,'mmyyyy')";

	public static String delete_Advance_deduct_exist = "delete from emp_advance_deduct where adv_code = ? and month_year = to_date(?,'mmyyyy')";

	public static String Advance_deduct_exist_emp = "select count(*) from emp_advance_deduct where emp_id = ? and month_year = to_date(?,'mmyyyy')";

	public static String GET_EMP_ID = "select emp_id from  emp_advance where adv_code =?";

	// public static String delete_Advance_deduct_exist_emp =
	// "delete from emp_advance_deduct where emp_id = ? and month_year =
	// to_date(?,'mmyyyy')";

	//// null_orEmpty (emad.amount- sum(null_or_empty(epcp.amount,0.0))) as
	//// balanceAmountReturn

}
