package com.dci.payroll.payroll.employeepaycomponent;

public class EmployeePayComponentQueryUtil {

	/*
	 * public static final String selectEmpComponentList =
	 * "with t1 as (select employeeid,max(fromdate) as fromdate from emp_pay_component2() group by employeeid)select pay.fromDate ,payComponentId ,Amount ,e.employee_id ||'-'|| e.first_name ||' '|| e.middle_name||' '|| e.surname as employeeName , d.department_id, d.department_name ,c.company_id,c.company_name, b.branch_id branchId,b.branch_name ,e.employee_id from emp_pay_component2() pay inner join t1 on pay.employeeid = t1.employeeid and pay.fromdate = t1.fromdate inner join employee e on e.employee_id=pay.employeeId INNER JOIN branch_department bd ON e.branch_department_id=bd.branch_department_id  INNER JOIN branch b ON bd.branch_id=b.branch_id  INNER JOIN company c ON c.company_id=b.company_id inner join department d on d.department_id=e.department_id where  e.employee_id = ? order by pay.fromdate,pay.employeeid"
	 * ;
	 */

	public static final String selectEmpComponentList =  "with t1 as (select distinct  employeeid from emp_pay_component2() "
			+ "			 group by employeeid)select pay.fromDate,payComponentId , "
			+ "			Amount ,e.emp_name as employeeName "
			+ "			 , d.dept_code departmentCode, d.dept_name departmentName,c.company_code companyCode, "
			+ "			c.company_name companyName, b.brnch_id branchId,b.brnch_nam branchName, "
			+ "			e.emp_id employeeId from emp_pay_component2() pay "
			+ "			inner join t1 on pay.employeeid = t1.employeeid inner "
			+ "			join employee_master e on e.emp_id=pay.employeeId "
			+ "			INNER JOIN branch b ON b.brnch_id::integer =e.branch_department_id "
			+ "			 INNER JOIN company_master c ON c.company_code=b.company_code inner join "
			+ "			department_master_new d on d.dept_code=e.dept where e.emp_id = ? order by pay.fromdate desc";
			
			

	public static final String selectEmpComponentList1 = "with t1 as (select employeeid,fromdate as fromdate from emp_pay_component2() group by employeeid,fromdate)select pay.fromDate ,payComponentId ,Amount ,e.emp_id ||'-'|| e.first_name ||' '|| e.middle_name||' '|| e.surname as employeeName , d.dept_code, d.dept_name ,c.company_code,c.company_name, b.brnch_id branchId,b.brnch_nam ,e.emp_id from emp_pay_component2() pay inner join t1 on pay.employeeid = t1.employeeid and pay.fromdate = t1.fromdate inner join employee_master e on e.emp_id=pay.employeeId   INNER JOIN branch b ON b.brnch_id::integer=e.branch_department_id  INNER JOIN company_master c ON c.company_code=b.cmpny_id inner join department_master_new d on d.dept_code=e.department_id where  e.payroll_flag!='t' order by pay.fromdate,pay.employeeid";
		//	+ "with t1 as (select employeeid,fromdate as fromdate from emp_pay_component2() group by employeeid,fromdate)select pay.fromDate ,payComponentId ,Amount ,e.employee_id ||'-'|| e.first_name ||' '|| e.middle_name||' '|| e.surname as employeeName , d.department_id, d.department_name ,c.company_id,c.company_name, b.branch_id branchId,b.branch_name ,e.employee_id from emp_pay_component2() pay inner join t1 on pay.employeeid = t1.employeeid and pay.fromdate = t1.fromdate inner join employee e on e.employee_id=pay.employeeId INNER JOIN branch_department bd ON e.branch_department_id=bd.branch_department_id  INNER JOIN branch b ON bd.branch_id=b.branch_id  INNER JOIN company c ON c.company_id=b.company_id inner join department d on d.department_id=e.department_id where e.designation_id!=38 and e.payroll_flag!='t' order by pay.fromdate,pay.employeeid";

	public static final String selectEmpComponentList2 = "with t1 as (select employeeid,fromdate as fromdate from emp_pay_component2() group by employeeid,fromdate)select pay.fromDate ,payComponentId ,Amount ,e.emp_id ||'-'|| e.first_name ||' '|| e.middle_name||' '|| e.surname as employeeName , d.dept_code, d.dept_name ,c.company_code,c.company_name, b.brnch_id branchId,b.brnch_nam ,e.emp_id from emp_pay_component2() pay inner join t1 on pay.employeeid = t1.employeeid and pay.fromdate = t1.fromdate inner join employee_master e on e.emp_id=pay.employeeId   INNER JOIN branch b ON b.brnch_id::integer=e.branch_department_id   INNER JOIN company_master c ON c.company_code=b.cmpny_id inner join department_master_new d on d.dept_code=e.department_id where  e.department_id= ? and e.payroll_flag!='t' order by pay.fromdate,pay.employeeid";
			//"with t1 as (select employeeid,fromdate as fromdate from emp_pay_component2() group by employeeid,fromdate)select pay.fromDate ,payComponentId ,Amount ,e.employee_id ||'-'|| e.first_name ||' '|| e.middle_name||' '|| e.surname as employeeName , d.department_id, d.department_name ,c.company_id,c.company_name, b.branch_id branchId,b.branch_name ,e.employee_id from emp_pay_component2() pay inner join t1 on pay.employeeid = t1.employeeid and pay.fromdate = t1.fromdate inner join employee e on e.employee_id=pay.employeeId INNER JOIN branch_department bd ON e.branch_department_id=bd.branch_department_id  INNER JOIN branch b ON bd.branch_id=b.branch_id  INNER JOIN company c ON c.company_id=b.company_id inner join department d on d.department_id=e.department_id where  e.department_id= ? ::int and e.designation_id!=38 and e.payroll_flag!='t' order by pay.fromdate,pay.employeeid";

	public static final String selectEmpComponentList3 = " select fromdate,pay_component_id,amount,e.first_name ||' '|| e.middle_name||' '|| e.surname as employeeName ,c.company_code,c.company_name,d.dept_code,d.dept_name,b.brnch_id,b.brnch_nam,e.emp_id from emp_pay_component (?) INNER JOIN employee_master as e on e.emp_id= ? INNER JOIN branch b on b.brnch_id=e.branch_department_id INNER JOIN company_master c ON c.company_code=b.company_code   INNER JOIN department_master_new d ON d.dept_code = e.dept order by 1";

	public static final String sEmpPayCombyIdDate = "select e.first_name ||' '|| e.middle_name||' '|| e.surname  as employeeName ,c.company_code,c.company_name,d.dept_code,d.dept_name as departmentName,b.brnch_id,b.brnch_nam,e.emp_id as employeeId,to_char(epc.arrears_from_date,'dd/mm/yyyy') as arrearsStartDate,cast(case when epc.arrear_flag = 't' then true else 'false' END as Varchar(5) ) as arrears,  fromdate, pc.pay_component_id, pc.percentage_applied_on,  CASE WHEN pc.value IS NULL THEN 0.00 ELSE pc.value END AS value, pay_component_name, pay_component_type,   CASE WHEN amount IS NULL THEN 0.00 ELSE amount END AS amount from   (select display_order, pay_component_id,percentage_applied_on, value, pay_component_name, pay_component_type from pay_component where status=true) pc   left outer join ( select employee_id, fromdate, pay_component_id, amount,arrears_from_date,arrear_flag from employee_pay_component where employee_id = ? AND fromdate = to_date(?,'dd/mm/yyyy')) epc on pc.pay_component_id = epc.pay_component_id   INNER JOIN employee_master as e on e.emp_id= ?  INNER JOIN branch b ON b.brnch_id::integer = e.branch_department_id INNER JOIN company_master c ON c.company_code=b.company_code   INNER JOIN department_master_new d ON d.dept_code = e.dept ORDER BY pay_component_type ASC,display_order ";
			
			
		/*	"select e.first_name ||' '|| e.middle_name||' '|| e.surname  as employeeName ,c.company_id,c.company_name,d.department_id,d.department_name,b.branch_id,b.branch_name,e.employee_id,to_char(epc.arrears_from_date,'dd/mm/yyyy') as arrearsStartDate,cast(case when epc.arrear_flag = 't' then true else 'false' END as Varchar(5) ) as arrears,  fromdate, pc.pay_component_id, pc.percentage_applied_on,  CASE WHEN pc.value IS NULL THEN 0.00 ELSE pc.value END AS value, pay_component_name, pay_component_type, "
			+ "  CASE WHEN amount IS NULL THEN 0.00 ELSE amount END AS amount from " + "  (select display_order, pay_component_id,percentage_applied_on, value, pay_component_name, pay_component_type from pay_component where status=true) pc " + "  left outer join ( select employee_id, fromdate, pay_component_id, amount,arrears_from_date,arrear_flag from employee_pay_component " + "where employee_id = ? AND fromdate = to_date(?,'dd/mm/yyyy')) epc on pc.pay_component_id = epc.pay_component_id " + "  INNER JOIN employee as e on e.employee_id=? "
			+ "INNER JOIN branch_department bd ON e.branch_department_id=bd.branch_department_id " + "INNER JOIN branch b ON bd.branch_id=b.branch_id " + "INNER JOIN company c ON c.company_id=b.company_id " + "  INNER JOIN department d ON d.department_id = bd.department_id " + "ORDER BY pay_component_type ASC,display_order";*/

	public static final String insertEmpPayCom = "INSERT INTO employee_pay_component(employee_id, fromdate, pay_component_id, amount,arrears_from_date,arrear_flag) " + " VALUES (:employeeId,to_date(:fromDate,'DD/MM/YYYY'),:payComponentId,:amount,to_date(:arrearsStartDate,'DD/MM/YYYY'),:arrears) ";

	public static final String updateEmpPayCom = "UPDATE employee_pay_component SET amount=:amount , arrears_from_date=to_date(:arrearsStartDate,'dd/mm/yyyy'),arrear_flag=:arrears WHERE pay_component_id = :payComponentId AND fromdate=to_date(:fromDate,'DD/MM/YYYY') AND employee_id=:employeeId";

	public static final String deleteEmpPayCom = "DELETE from employee_pay_component where employee_id=? and fromdate=to_date(?,'DD/MM/YYYY')";

	public static final String deleteEmpPayComById = "DELETE from employee_pay_component where employee_id=? and fromdate=to_date(?,'DD/MM/YYYY') and pay_component_id=?";

	public static final String checkEmpPayCom = " select * from employee_pay_component where pay_component_id= ? and fromdate=to_date(?,'DD/MM/YYYY') and employee_id=?";

	public static final String getMaxFromDate = " SELECT to_char(MAX(fromdate),'DD/MM/YYYY') fromdate FROM employee_pay_component WHERE employee_id=?";

	public static final String getMaxFromDate1 = " SELECT to_char(MAX(fromdate),'DD-MM-YYYY') fromdate FROM employee_pay_component WHERE employee_id=?";

	public static final String CHECK_EMPLOYEE = "select  distinct emp_id from employee_master where emp_Id=?";

	public static final String getCurrentDate = "select to_char(now(),'dd-mm-yyyy') as todaydate";

	public static final String selectEmployeeList = "select distinct  emp_id as employeeId,first_name as employeeName from employees(?,?,?,?)";

	//public static final String selectComponentName = "select pay_component_id from pay_component where pay_component_type =1";
	public static final String selectComponentName = "select pay_component_name  as pay_component_id from pay_component";


}