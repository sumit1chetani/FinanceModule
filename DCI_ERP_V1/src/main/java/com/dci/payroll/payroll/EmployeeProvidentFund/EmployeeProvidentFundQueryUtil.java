package com.dci.payroll.payroll.EmployeeProvidentFund;

public class EmployeeProvidentFundQueryUtil {

	public static final String count = "select count(*) from employee_pay_component_paid where pay_component_id = 'BASIC' and employee_id = ? and month_year = ?";

	public static final String basic = "select amount from employee_pay_component_paid where pay_component_id = 'BASIC' and employee_id = ? and month_year = ?";

	public static final String SELECT_EPF_LIST = "select  distinct pf.employee_id, employee_name,  e.uan_no epf_no, salary, epf_wages, eps_wages, epf_self, epf_employer, pf.edli edli, pf.admc admc, pf.eps eps, case when salary >= 15000 then 551 else  (salary * 3.67/100) end epf  from calculate_epf(?,?,?,?) pf left outer join employee_master e on pf.employee_id = e.emp_id";

	public static final String SELECT_EPF_DETAIL_LIST = "select epf_no, employee_name, epf_wages, eps_wages, epf_self epf_due, epf_self epf_remitted," + " round(epf_employer * 0.0833,0) eps_due, round(epf_employer * 0.0833,0) eps_remitted," + " epf_employer - round(epf_wages * 0.0833,0) eps_diff_due, epf_employer - round(epf_wages * 0.0833,0) eps_diff_remitted," + " 0 NCp_Days, 0 Refund, 0	Arrear_EPF_Wages, 0	Arrear_EPF_EE_Share, 0 Arrear_EPF_ER_Share, 0 Arrear_EPS_Share,"
			+ "'' Father_Husband’s_Name, '' Relationship, '' DOB, '' Gender, '' DOJ_EPF, '' OJ_EPS, '' DOE_EPF, '' DOE_EPS, '' Reason" + " from calculate_epf(?,?,?,?) pf left outer join employee_master e on pf.employee_id = e.emp_id";
}
