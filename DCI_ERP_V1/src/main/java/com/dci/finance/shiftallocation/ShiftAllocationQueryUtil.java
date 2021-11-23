package  com.dci.finance.shiftallocation;

public class ShiftAllocationQueryUtil {

	public static final String SELECT_EMPLOYEE_LIST = "SELECT emp_id as employeeId, emp_id as id , first_name  as empName ,  first_name as text FROM employee_master e,branch_department bd  WHERE e.branch_department_id=bd.branch_id::int AND e.status = 'Y' AND bd.department_id=? AND bd.branch_id=?  order by first_name asc ";
	//public static final String GetShiftAllocationList = " select employee_shift_scheme.emp_id as employeeId,employee_shift_scheme.scheme_id as schemeId,ss.scheme_name as schemeName, TO_CHAR(employee_shift_scheme.valid_from,'dd/mm/yyyy')as validFrom,  TO_CHAR(employee_shift_scheme.valid_to,'dd/mm/yyyy')  as validTo, e.first_name||e.middle_name||e.surname as empName, e.emp_id as employeeId,c.company_name as companyName,   c.company_code as companyId, b.branch_id as branchId, b.branch_name as branchName,e.first_name as employeeName, bd.department_id as departmentId,d.dept_name as departmentName, des.desgn_name as designationName from employee_shift_scheme  inner join employee_master e on e.emp_id=employee_shift_scheme.emp_id  left join branch_department bd on e.branch_department_id = bd.branch_department_id left join branch_master b on b.branch_id::char = bd.branch_id   left join department_master d on d.dept_code = e.dept left join company_master c on c.company_name = b.branch_name  left join designation_master des on des.desgn_code = e.designation_id::char left join shift_scheme ss on ss.scheme_id = employee_shift_scheme.scheme_id where employee_shift_scheme.is_reversed='false' and c.company_code= ?";
	public static final String GetShiftAllocationList = " select employee_shift_scheme.emp_id as employeeId,employee_shift_scheme.scheme_id as schemeId,ss.scheme_name as schemeName, TO_CHAR(employee_shift_scheme.valid_from,'dd/mm/yyyy')as validFrom,  TO_CHAR(employee_shift_scheme.valid_to,'dd/mm/yyyy')  as validTo, e.first_name||e.middle_name||e.surname as empName, e.emp_id as employeeId,c.company_name as companyName,   c.company_code as companyId, b.branch_id as branchId, b.branch_name as branchName,e.first_name as employeeName, bd.department_id as departmentId,d.dept_name as departmentName, des.desgn_name as designationName from employee_shift_scheme  inner join employee_master e on e.emp_id=employee_shift_scheme.emp_id  left join branch_department bd on e.branch_department_id = bd.branch_department_id left join branch_master b on b.branch_id::char = bd.branch_id   left join department_master d on d.dept_code = e.dept left join company_master c on c.company_name = b.branch_name  left join designation_master des on des.desgn_code = e.designation_id::char left join shift_scheme ss on ss.scheme_id = employee_shift_scheme.scheme_id where employee_shift_scheme.is_reversed='false' ";

	public static final String SELECT_SHIFT_LIST = "select shift_id as shiftId,shift_name as shiftName from shift";

	public static final String sAddShiftAllocation = "INSERT INTO employee_shift_scheme(emp_id, scheme_id, valid_from, valid_to,is_reversed) VALUES (?, ?, ?, ?, ?)";

	public static String SELECT_BRANCH_LIST = "select branch_id as branchId,branch_id as id,branch_name as branchName,branch_name as text from branch_master where company_code=?";

	public static String SELECT_SCHEME_LIST = " select scheme_id as id, scheme_name as text from shift_scheme where (valid_from, valid_to) OVERLAPS ( ?::DATE -interval '1'day, ?::DATE +interval '1'day) and company_id = ? ";

	public static String SELECT_DEPARTMENT_LIST = "select bd.department_id as departId, dept_name as departName,bd.department_id as id,dept_name as text from department_master inner join branch_department bd on bd.department_id=department_master.dept_code where bd.branch_id=? and dept_status='Y' order by dept_name asc";
	public static final String sGetShiftAllocationEditList = " select es.emp_id as employeeNo,es.scheme_id as schemeId, ss.scheme_name as schemeName,TO_CHAR(es.valid_from,'dd/mm/yyyy') as validityFrom, TO_CHAR(ss.valid_to,'dd/mm/yyyy') as validTo, TO_CHAR(es.valid_to,'dd/mm/yyyy') as validityTo,  b.company_code as companyId, b.branch_id as branchId,b.branch_name as branchName,  e.first_name as employeeName,  d.dept_code as departmentId,d.dept_Name as departmentName  from employee_shift_scheme es left join employee_master e on e.emp_id = es.emp_id  left join branch_department bd on e.branch_department_id = bd.branch_department_id  left join branch_master b on b.branch_id::char = bd.branch_id  left join shift_scheme ss on ss.scheme_id =es.scheme_id left join department_master d on d.dept_code = e.department_id::char  where es.emp_id=? and es.scheme_id=? and es.valid_from = to_date(?,'dd/mm/yyyy') and es.valid_to = to_date(?,'dd/mm/yyyy')";
	public static final String deleteEmpShift = "delete from employee_shift where employee_id = ? and shift_date >= to_date(?,'dd/mm/yyyy') and shift_date <= to_date(?,'dd/mm/yyyy') ";

	public static String sDeleteShiftAllocation = "delete from employee_shift_scheme where scheme_id=? and emp_id=? and valid_from=to_date(?,'dd/mm/yyyy') and valid_to=to_date(?,'dd/mm/yyyy') and is_reversed='false'";

	public static final String SELECT_DATE_LIST = "select TO_CHAR(valid_from,'dd/mm/yyyy') as validityFrom,TO_CHAR(valid_to,'dd/mm/yyyy') as validityTo from shift_scheme where scheme_name=?";

	public static final String sAddShiftAllocationDetail = "INSERT INTO employee_shift(employee_id, shift_id, shift_date, weekly_off, week_end) VALUES (?, ?, ?, ?, ?)";

	public static final String SELECT_SHIFT = " select shift_id shiftId from shifts_in_scheme where scheme_name=? and week_day=? ";

	public static final String sUpdateShiftAllocation = "update employee_shift_scheme set valid_to=? where emp_id=? and scheme_id=? and valid_from =? ";

	public static final String sUpdateDeleteShiftAllocationDetail = "delete from employee_shift where employee_id=? and shift_date=?";

	public static final String SELECT_SHIFT_NAME = " select scheme_name from shift_scheme where scheme_id=?";

	public static final String checkSchemeName = "select scheme_name from  shifts_in_scheme where scheme_name =?";

	public static String getDateCount = "select count(*) from employee_shift_scheme where (valid_from, valid_to) OVERLAPS ( ?::DATE -interval '1'day, ?::DATE +interval '1'day) and emp_id=?";

	public static final String INSERT_IMPORT_SHIFT_UPLOAD = " INSERT INTO employee_shift_scheme(emp_id, scheme_id, valid_from, valid_to,is_reversed) VALUES (?, ?, ?, ?, ?)";

	public static final String checkEmpJoinDate = "select case when dt_of_join<=? then true else false end from employee_master where emp_id=?";

	public static final String getEmpJoinDate = "select to_char(dt_of_join,'dd/mm/yyyy') as doj from employee_master where emp_id=?";

	public static final String GET_SCHEME_ID = "select scheme_id from shift_scheme where lower(scheme_name) = lower(?)";

}
