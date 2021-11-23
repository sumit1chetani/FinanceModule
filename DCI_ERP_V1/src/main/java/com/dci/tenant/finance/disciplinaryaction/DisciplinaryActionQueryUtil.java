package com.dci.tenant.finance.disciplinaryaction;

public class DisciplinaryActionQueryUtil {

	public static final String getDisciplinaryList = " select disciplinary_proceedings_sk,proceedings_date,proceedings,employee_id employeeId,supended_from,supended_to, "
			+ " supended_days,warning_issued,procedings_reason reason,approved_by,approved_on,d.status,e.emp_name as employeename "
			+ " from disciplinary_proceedings d  "
			+ " left join employee_master e on d.employee_id=e.emp_id ";


	public static String INSERT_DISCIPLINARYDATE = "INSERT INTO disciplinary_proceedings(proceedings_date,proceedings,employee_id,supended_from,supended_to,supended_days,warning_issued,procedings_reason,status,hospital_id,branch_id,department_id,designation_id,grade_id)   VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,? ) returning disciplinary_proceedings_sk";

	public static String sDeleteDisciplinaryData = "delete from disciplinary_proceedings where disciplinary_proceedings_sk=?";

	public static final String sGetDisciplinaryDataEditList = "select d.disciplinary_proceedings_sk,d.proceedings_date,d.proceedings,d.employee_id as employeeId,to_date(d.supended_from,'dd/mm/yyyy') as suspendFrom,to_date(d.supended_to,'dd/MM/yyyy') as suspendTo, d.supended_days  as suspendDays,d.procedings_reason as reason, d.warning_issued as issueWarning, d.status,d.hospital_id,d.branch_id as branchId,d.department_id as departmentId,d.designation_id as designationId,d.grade_id as   gradeId,  e.emp_name ,b.branch_name ,dept_name ,dsg.desgn_name,g.name ,d.hospital_Id as companyId  from disciplinary_proceedings d left join employee_master e on e.emp_id=d.employee_id left join branch_master b on b.branch_id::varchar=d.branch_id inner join department_master dm on dm.dept_code=d.department_id inner join designation_master dsg on dsg.desgn_code=d.designation_id inner join grade g on g.grade_id::varchar=d.grade_id left join company_master c on c.short_name=d.hospital_id where d.disciplinary_proceedings_sk=?";
	public static String sUpdateDisciplinaryData = "UPDATE disciplinary_proceedings  SET  employee_id=?,supended_from=?,  supended_to=?, supended_days=?,warning_issued=?,  procedings_reason=?, status=?,hospital_id=?,  branch_id=?, department_id=?,designation_id=?,  grade_id=?  WHERE disciplinary_proceedings_sk=? ";

	public static String getEmployeeList = " SELECT employee_id as employeeId, employee_id as id , employee_id || '-' ||emp_name as employeeName ,  emp_id || '-' ||emp_name as text FROM employee_master e,branch_department bd WHERE e.branch_department_id=bd.branch_department_id AND bd.department_id=? AND bd.branch_id=?";

}
