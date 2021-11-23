package com.dci.finance.shiftreallocation;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class ShiftReAllocationQueryUtil {

	public static final String SELECT_DESIGNATION_LIST = "select designation_id as designationId,designation_id id,designation_name as designationName,designation_name as text from designation";

	public static final String SELECT_DESIG_LIST = "select des.designation_id as id,des.designation_name as text from designation des inner join employee e on des.designation_id=e.designation_id where e.employee_id=? order by designation_name ASC";

	public static final String INSERT_SHIFT_REALLOCATION = " insert into employee_shift_reallocation(emp_id, valid_from, valid_to, shift_id) values(?, ?, ?, ?) ";

	/*
	 * " insert into employee_shift_scheme(employee_id, scheme_name, valid_from, valid_to, is_reversed, shift_id) values(?, ?, ?, ?, ?, ?) "
	 * ;
	 */

	public static final String GetShiftReAllocationList = " select employee_shift_reallocation.employee_id as employeeId, " + " TO_CHAR(employee_shift_reallocation.valid_from,'dd/mm/yyyy') as fromDate, " + " TO_CHAR(employee_shift_reallocation.valid_to,'dd/mm/yyyy') as toDate, " + " e.first_name||e.middle_name||e.surname as empName,e.employee_id as employeeId, " + " c.company_name as companyName,c.company_id as companyId,b.branch_id as branchId,b.branch_name as branchName, "
			+ " e.first_name as employeeName,bd.department_id as departmentId,d.department_name as departmentName, " + " des.designation_name as designationName, des.designation_id as designationId, employee_shift_reallocation.shift_id as shiftCode,sh.shift_name as shiftName " + " from employee_shift_reallocation " + " inner join employee e on e.employee_id=employee_shift_reallocation.employee_id " + " left join branch_department bd on e.branch_department_id = bd.branch_department_id " + " left join branch b on b.branch_id = bd.branch_id "
			+ " left join department d on d.department_id = e.department_id " + " left join company c on c.company_id = b.company_id " + " left join designation des on des.designation_id = e.designation_id " + " left join shift sh on sh.shift_id = employee_shift_reallocation.shift_id where c.company_id= ?";

	/*
	 * "select employee_shift_scheme.employee_id as employeeId,employee_shift_scheme.scheme_name as schemeName,TO_CHAR(employee_shift_scheme.valid_from,'dd/mm/yyyy')as validFrom,TO_CHAR(employee_shift_scheme.valid_to,'dd/mm/yyyy') as validTo,e.first_name||e.middle_name||e.surname as empName,e.employee_id as employeeId,c.company_name as companyName,c.company_id as companyId,b.branch_id as branchId,b.branch_name as branchName,e.first_name as employeeName,bd.department_id as departmentId,d.department_name as departmentName,des.designation_name as designationName,sh.shift_id as shiftId,sh.shift_name as shiftName from employee_shift_scheme inner join employee e on e.employee_id=employee_shift_scheme.employee_id left join branch_department bd on e.branch_department_id = bd.branch_department_id left join branch b on b.branch_id = bd.branch_id left join department d on d.department_id = e.department_id left join company c on c.company_id = b.company_id left join designation des on des.designation_id = e.designation_id left join shift sh on sh.shift_id = employee_shift_scheme.shift_id where employee_shift_scheme.is_reversed='true'"
	 * ;
	 */

	public static final String sDeleteShiftReAllocation = "delete from employee_shift where employee_id=? and shift_id=?";

	public static final String sGetReShiftAllocationEditList = " select es.employee_id as employeeId,TO_CHAR(es.valid_from,'dd/mm/yyyy') as fromDate, " + " TO_CHAR(es.valid_to,'dd/mm/yyyy') as toDate, es.shift_id shiftCode, s.shift_name shiftName , " + " b.branch_id as branchId, b.branch_name as branchName, e.first_name as employeeName, " + " d.department_id as departmentId,d.department_Name as departmentName, " + " des.designation_id as designationId, des.designation_name as designationName, "
			+ " c.company_name as companyName,c.company_id as companyId " + " from employee_shift_reallocation es " + " left join employee e on e.employee_id = es.employee_id " + " left join branch_department bd on e.branch_department_id = bd.branch_department_id " + " left join branch b on b.branch_id = bd.branch_id " + " left join department d on d.department_id = e.department_id " + " left join designation des on des.designation_id = e.designation_id " + " left join company c on c.company_id = b.company_id "
			+ " left join shift s on s.shift_id = es.shift_id " + " where es.employee_id= ? " + " and es.valid_from = to_date(?,'dd/mm/yyyy') " + " and es.valid_to = to_date(?,'dd/mm/yyyy') ";

	/*
	 * " select es.employee_id as employeeId,TO_CHAR(es.valid_from,'dd/mm/yyyy') as fromDate, "
	 * +
	 * " TO_CHAR(es.valid_to,'dd/mm/yyyy') as toDate, es.shift_id shiftCode, s.shift_name shiftName , "
	 * + " b.branch_id as branchId, b.branch_name as branchName, " +
	 * " e.first_name as employeeName,d.department_id as departmentId,d.department_Name as departmentName "
	 * + " from employee_shift_reallocation es " +
	 * " left join employee e on e.employee_id = es.employee_id " +
	 * " left join branch_department bd on e.branch_department_id = bd.branch_department_id "
	 * + " left join branch b on b.branch_id = bd.branch_id " +
	 * " left join department d on d.department_id = e.department_id " +
	 * " left join shift s on s.shift_id = es.shift_id " +
	 * " where es.employee_id= ? " +
	 * " and es.valid_from = to_date(?,'dd/mm/yyyy') " +
	 * " and es.valid_to = to_date(?,'dd/mm/yyyy') ";
	 */

	public static String SELECT_SHIFT_LIST = " select shift_id shiftCode,shift_name shiftName from shift s where s.company_id =? order by shift_name ASC ";

	public static final String sUpdateShiftReAllocation = " update employee_shift set  shift_id=?, weekly_off=?, week_end=? where shift_date=? and employee_id=?";

	public static final String updateShiftReAllocation = " update employee_shift_reallocation set shift_id=cast(? AS INTEGER), valid_to=? where employee_id=? and valid_from=? ";

	public static final String updateReAllocation = " update employee_shift set shift_id=cast(? AS INTEGER), weekly_off=?, week_end=? where employee_id=? and shift_date=? ";

	public static final String SELECT_Branch_LIST = "select branch_id as id ,branch_name as text from branch_master";

	public static final String SELECT_shiftNameList_LIST = " select shift_id as id,shift_name as text from shift ";

	public static String SELECT_SHIFT_NAME_LIST = "select shift_id as shiftCode,shift_id as id,shift_name as shiftName,shift_name as text from shift s where s.company_id =? ";

	public static String checkAllocation = "select count(*) from employee_shift_scheme where emp_id=? and (? between valid_from and valid_to) and (? between valid_from and valid_to)";

	public static String companyList="select company_code as id ,company_name as text from company_master\n" + 
			"";
}