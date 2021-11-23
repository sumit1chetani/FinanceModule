package com.dci.payroll.tds.employeeHraReceipts;

public class EmployeeHraReceiptsQueryUtil {

	public static final String LIST_EMPLOYEEHRARECEIPTS = "select e.first_name||' '||e.middle_name||' '||e.surname employeeName,ehr.employee_id as  employeeId, ehr.month_year as monthYear, to_char(to_date(ehr.month_year, 'MMYYYY'), 'Mon YYYY') monthYearDisplay, ehr.rent_paid as rentPaid, ehr.file_name as fileName, ehr.hra_status as hraStatus from employee_hra_receipts ehr INNER JOIN employee e ON e.employee_id = ehr.employee_id";

	public static final String INSERT_EMPLOYEEHRARECEIPTS = "INSERT INTO employee_hra_receipts" + " (employee_id,month_year,rent_paid,hra_status,file_name)" + " VALUES (:employee_id,:month_year,:rent_paid,:hra_status,:file_name)";

	public static final String SELCT_EMPLOYEEHRARECEIPTS_BYID = "select e.first_name||' '||e.middle_name||' '||e.surname employeeName,ehr.employee_id,ehr.month_year,ehr.rent_paid,ehr.file_name,hra_status,bd.branch_id,b.branch_name,c.company_id,c.company_name,d.department_id,d.department_name from employee_hra_receipts ehr INNER JOIN employee e ON e.employee_id = ehr.employee_id INNER JOIN branch_department bd ON e.branch_department_id=bd.branch_department_id INNER JOIN branch b ON bd.branch_id=b.branch_id INNER JOIN company c ON c.company_id=b.company_id INNER JOIN department d ON d.department_id = bd.department_id where ehr.employee_id=? and ehr.month_year=?";

	public static final String DELETE_EMPLOYEEHRARECEIPTS = "Delete from employee_hra_receipts where employee_Id=? and month_year=?";

	public static final String UPDATE_EMPLOYEEHRARECEIPTS = "UPDATE employee_hra_receipts SET rent_paid=:rent_paid , file_name=:file_name where employee_id=:employee_id and month_year=:month_year";

	public static final String APPROVAL_UPDATE_EMPLOYEEHRARECEIPTS = "UPDATE employee_hra_receipts SET hra_status=:hra_status where employee_id=:employee_id and month_year=:month_year";

}
