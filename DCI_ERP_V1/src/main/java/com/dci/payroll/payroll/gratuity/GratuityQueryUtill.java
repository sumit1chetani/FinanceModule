package com.dci.payroll.payroll.gratuity;

public class GratuityQueryUtill {

	public static final String SELECT_GTATUITY_LIST = "SELECT g.*, e.first_name || ' ' || e.middle_name || ' '|| e.surname as employeeName, " + " d.department_name as departmentName ,b.branch_name as branchName, c.company_name as companyName" + " from	employee_gratuity g	left outer	join employee	e on g.employee_id=	e.employee_id " + " left	outer join	department d	on e.department_id=	d.department_id " + " left outer join	branch b	on d.branch_id=	b.branch_id " + " left	outer Join	company c on b.company_id=c.company_id";

	public static final String SELECT_GTATUITY_BY_ID = " select * from  employee_gratuity where employee_id=?";

	public static final String INSERT_GTATUITY = "INSERT INTO employee_gratuity(employee_id, gross_salary, basic_pay, current_salary, year_of_service, gratuity_amount, period_from, period_to, comments, created_by, created_date) " + " VALUES (:employeeId, :grossSalary, :basicPay, :currentSalary, :yearOfService, :gratuityAmount, :periodFrom, :periodTo, :comments, :createdBy, :createdDate ) ";

	public static final String UPDATE_GTATUITY = "UPDATE employee_gratuity SET employee_id = :employeeId, " + "gross_salary = :grossSalary, basic_pay = :basicPay, current_salary = :currentSalary, " + "year_of_service = :yearOfService, gratuity_amount = :gratuityAmount, " + "period_from = :periodFrom, period_to = :periodTo, comments = :comments, " + "created_by = :createdBy, created_date = :createdDate where  ";
}
