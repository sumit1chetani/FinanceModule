package com.dci.payroll.payroll.payrollgeneration;

public class PayrollGenerationQueryUtil {

	public static final String INSERT_ARREAR_PAY_COMPONENT = "insert into employee_pay_component_paid (employee_id,pay_component_id,month_year,amount,department_id) values (?,'ARR',?,?,?)";

	public static final String INSERT_ARREAR = "insert into employee_arrear_earnings (employee_id,pay_component_id,arrear_from_date,arrear_to_date,amount) values (?,'ARR',?,?,?)";

	public static final String FLAG_EMPLOYEE_ISSUE = "select emp_id,first_name from employee_master where department_id = ? and payroll_flag='t' and status='t'";

	public static final String CHECK_WITH_HOLD_EMPLOYEE = "select count(*) from payroll_withHold ph  where emp_id = ? and to_date(?,'MMyyyy') between to_date(concat(ph.from_month,ph.from_year)::text,'MMyyyy') and to_date(concat(ph.till_month,ph.till_year)::text,'MMyyyy')";

	public static final String CHECK_PAYROLL_FLAG = "select emp_id,first_name from employee_master where payroll_flag='t'";

	public static final String SELECT_Type_LIST = "select pay_component_id as id, pay_component_name as text from pay_component  where (pay_component_type  = 3 and pay_component_id not in('L01','L02','L03','PT','KVB','TDS','AD')) or (case when pay_component_type=2 then non_standard_deduction=true end) ";

	public static final String CHECK_SALARY_CREATED = "SELECT * FROM is_salary_created(?,?,?,?,?)";

	public static final String CHECK_SALARY_FIXED = "SELECT * FROM salary_not_fixed(?,?,?,?,?)";

	public static final String CREATE_SALARY = "SELECT * FROM create_salary(?,?,?,?,?)";

	public static final String SAL_LIST = "SELECT DISTINCT e.emp_id as employeeId, e.first_name || ' ' || e.middle_name || ' '|| e.surname as employeeName FROM Employees(?,?,?,?) e INNER JOIN employee_pay_component_paid ep ON e.emp_id = ep.employee_id AND month_year=?";

	public static final String DELETE_SAL_LIST = "DELETE FROM employee_pay_component_paid ep WHERE employee_id IN (SELECT e.emp_id FROM Employees(?,?,?,?) e INNER JOIN employee_pay_component_paid ep ON e.emp_id = ep.employee_id AND month_year=?) AND ep.month_year=?";

	public static final String SELECT_DEPARTMENT_LIST = "SELECT  distinct d.dept_code, d.dept_code as id, d.dept_name,d.dept_name as text  FROM department_master_new d INNER JOIN branch_department bd ON bd.department_id=d.dept_code AND bd.branch_id= ? WHERE d.dept_status='Y' order by d.dept_name ASC";

	public static final String SELECT_EMPLOYEE = "select distinct e.emp_id as id,concat(e.emp_id,'-',e.first_name || e.middle_name || e.surname) as text from employee_master e INNER JOIN branch_department bd ON bd.department_id=e.department_id AND bd.branch_id= ? where e.status = 'Y' and  e.payroll_flag!='t' and e.grade_id not in(4,6,7)";

	public static final String SELECT_DEPARTMENT_LIST1 = "select dept_code as id,dept_name as text from department_master";

	public static final String SELECT_BRANCH_LIST = "SELECT brnch_id ,  brnch_id as id, brnch_nam, brnch_nam as text FROM branch WHERE cmpny_id =?";

	public static final String SELECT_COMPANY_LIST = "select company_code , company_code as id,company_name,company_name as text from COMPANY_MASTER  company where company.company_code = ? ";

	public static final String SELECT_EMPLOYEE_LIST = "SELECT distinct emp_id as employeeId, e.branch_department_id,emp_id as id , (emp_id || '-' ||first_name || e.middle_name || e.surname) as employeeName ,  (emp_id || '-' ||first_name || e.middle_name || e.surname) as text from employee_master e  inner join department_master_new d on e.dept=d.dept_code  inner join branch b on e.branch_department_id=b.brnch_id where d.dept_code= ? and b.brnch_id= ?";

	public static final String SELECT_EMPLOYEES = "  SELECT emp_id as employeeId, emp_id as id , emp_id || '-' ||first_name as employeeName ,  (emp_id || '-' ||first_name || middle_name || surname) as text FROM employee_master e,branch_department bd  WHERE e.branch_department_id::character varying=bd.branch_id AND e.status= 'Y' and grade_id not in(4,6,7)";

	public static final String SELECT_PAYROLL_LIST_BY_EMPID = "SELECT S.employee_id, first_name||' '|| E.middle_name ||' '||E.surname employeeName,pay_component_id,round(amount) amount FROM emp_monthly_pay_component(?,?,?,?) S,employee_master E WHERE S.employee_id=E.emp_id AND E.emp_id=? ORDER BY E.emp_id";

	public static final String SELECT_PAYSLIPYEARLIST = "with T as(select  * from generate_series ((select  max(extract(year from to_date(month_year, 'mmyyyy'))) from  employee_pay_component_paid)::int -1, " + "extract(year from now())::int) payslip_year ) " + " " + "select T.payslip_year ,T.payslip_year as id , T.payslip_year as text " + "from T";

	public static final String SELECT_MONTHLIST = "select  to_char(now(),'mmyyyy') month_year,  to_char(now(),'Mon yyyy') month_value,  to_char(now(),'mmyyyy') id, to_char(now(),'Mon yyyy') as text  UNION  select to_char(now() - INTERVAL '1 month','mmyyyy') month_year,  to_char(now() - INTERVAL '1 month','Mon yyyy') month_value,to_char(now() - INTERVAL '1 month','mmyyyy') id, to_char(now() - INTERVAL '1 month','Mon yyyy') AS text UNION  select to_char(now() - INTERVAL '2 month','mmyyyy') month_year,  to_char(now() - INTERVAL '2 month','Mon yyyy') month_value,to_char(now() - INTERVAL '2 month','mmyyyy') id, to_char(now() - INTERVAL '2 month','Mon yyyy') AS text UNION  select to_char(now() - INTERVAL '3 month','mmyyyy') month_year,  to_char(now() - INTERVAL '3 month','Mon yyyy') month_value,to_char(now() - INTERVAL '3 month','mmyyyy') id, to_char(now() - INTERVAL '3 month','Mon yyyy') AS text UNION  select to_char(now() - INTERVAL '4 month','mmyyyy') month_year,  to_char(now() - INTERVAL '4 month','Mon yyyy') month_value,to_char(now() - INTERVAL '4 month','mmyyyy') id, to_char(now() - INTERVAL '4 month','Mon yyyy') AS text UNION  select to_char(now() - INTERVAL '5 month','mmyyyy') month_year,  to_char(now() - INTERVAL '5 month','Mon yyyy') month_value,to_char(now() - INTERVAL '5 month','mmyyyy') id, to_char(now() - INTERVAL '5 month','Mon yyyy') AS text order by id asc";

	/*
	 * public static final String SELECT_MONTHLIST =
	 * "select to_char(now(),'mmyyyy') month_year, to_char(now(),'Mon yyyy') month_value, to_char(now(),'mmyyyy') id,to_char(now(),'Mon yyyy') as text UNION select to_char(now() - INTERVAL '1 month','mmyyyy') month_year, to_char(now() - INTERVAL '1 month','Mon yyyy') month_value,to_char(now() - INTERVAL '6 month','mmyyyy') id, to_char(now() - INTERVAL '6 month','Mon yyyy') AS text"
	 * ;
	 */
	/*
	 * public static final String grossPay =
	 * "select sum(amount) as taxSlabAmount from employee_pay_component_paid epc inner join pay_component pac on pac.pay_component_id= epc.pay_component_id  where pay_component_type='1' and pac.status='t' and epc.employee_id = ? and to_date(?,'mm/yyyy') - INTERVAL '6 months' group by epc.employee_id"
	 * ;
	 */
	public static final String finalQuery = "select professional_tax as professionaltax from professional_slab_rate_tax_dtl where slab_hdr_id=?  and '" + '?' + "'  between range_from and range_to";

	public static final String INSERT_TAX = " insert into employee_pay_component_paid (employee_id,amount,pay_component_id,month_year) values (?,?,'PTS',?)";

	public static final String grossPay = "select sum(amount) as taxSlabAmount from employee_pay_component_paid epc inner join pay_component pac on pac.pay_component_id= epc.pay_component_id  where pay_component_type='1' and pac.status='t' and epc.employee_id = ? and to_date(month_year,'mm/yyyy') > (select to_date(?,'MMyyyy') - INTERVAL '6 months' as fromDate from employee_pay_component_paid where employee_id = ? group by fromDate)";
	/*
	 * public static final String grossPay =
	 * "SELECT (DATE_PART('year', now()::date) - DATE_PART('year', max(fromdate)::date)) * 12 +  (DATE_PART('month', now()::date) - DATE_PART('month', max(fromdate)::date)) from employee_pay_component where employee_id = ? "
	 * ;
	 */

	/*
	 * public static final String ABOVE_SIX_MONTH =
	 * "select sum(amount) as taxSlabAmount, max(fromdate) from employee_pay_component epc inner join pay_component pac on pac.pay_component_id= epc.pay_component_id  where pay_component_type='1' and pac.status='t' and epc.employee_id = ? group by epc.employee_id"
	 * ;
	 */
	public static String INSERT_JOURNAL_VOUCHER_HEADER = "INSERT INTO JOURNALVOUCHER_HDR(JOURNAL_NO, JOURNAL_DATE, JOURNAL_NARRATION,monthyear,department_id, JOURNAL_CREATED_BY, JOURNAL_CREATED_DT, JOURNAL_COMPANY_CODE) VALUES(?,now(), ?,?,?, ?, now(), ?) ";

	public static String check_number = "select count(*) from journalvoucher_hdr where monthyear =? ";

	public static final String Five_MONTH = "select sum(amount) as taxSlabAmount from employee_pay_component epc inner join pay_component pac on pac.pay_component_id= epc.pay_component_id where pay_component_type='1' and pac.status='t' and epc.employee_id = ? and fromdate < (SELECT MAX(fromdate) FROM employee_pay_component where employee_id = ?) group by epc.employee_id";

	public static final String ABOVE_SIX_MONTH = "select sum(amount) as taxSlabAmount from employee_pay_component_paid epc inner join pay_component pac on pac.pay_component_id= epc.pay_component_id where pay_component_type='1' and pac.status='t' and epc.employee_id = ? and fromdate = (SELECT MAX(fromdate) FROM employee_pay_component where employee_id = ?) group by epc.employee_id ";
	public static final String PAYROLL_LIST_FOR_JV_amount = "SELECT sum(coalesce(round(amount,0),0)) amount FROM emp_monthly_pay_component1(?,?,?,?,?) S,employee E ,employee_worked el WHERE S.employee_id=E.employee_id and el.employee_id = S.employee_id  and E.status = 'true'  group BY E.employee_id  ORDER BY E.employee_id";

	public static final String PAYROLL_LIST_FOR_JV = "SELECT distinct pay_component_id,coalesce(el.lop_days,0) lopDays, coalesce(round(el.lop_amount,0),0) lopAmount,	S.employee_id,first_name||' '|| E.middle_name ||' '||E.surname employeeName, to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,coalesce(round(amount,0),0) amount,E.epf_no epfno,E.uan_no uanno FROM emp_monthly_pay_component1(?,?,?,?,?) S,employee E ,employee_worked el WHERE S.employee_id=E.employee_id and el.employee_id = S.employee_id  and E.status = 'true' ";

	public static final String CHECK_EXIST_EMPLOYEE = "select count(*) sub_account_code from journalvoucher_dtl where  sub_account_code =? limit 1";

	public static final String pending_SAL_LIST = "SELECT distinct e.emp_id employeeId,e.dept dept FROM Employees(?,?,?,?) e left JOIN employee_pay_component ep ON e.emp_id = ep.employee_id where fromdate <= to_date(?,'MMYYYY') and (e.emp_id, ?) not in (select distinct employee_id, month_year from employee_pay_component_paid)";

	public static final String PAYROLL_LIST_FOR_JV_dept = "" + "SELECT coalesce(el.lop_days,0) lopDays, coalesce(round(el.lop_amount,0),0) lopAmount,	S.employee_id,first_name||' '|| E.middle_name ||' '||E.surname employeeName, to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,pay_component_id,coalesce(round(amount,0),0) amount,E.epf_no epfno,E.uan_no uanno FROM emp_monthly_pay_component(?,?,?,?) S,employee E ,employee_worked el WHERE S.employee_id=E.employee_id and el.employee_id = S.employee_id  and E.status = 'true' ORDER BY E.employee_id";

	public static final String PAYROLL_LIST_FOR_JV_amount_dept = " SELECT sum(coalesce(round(amount,0),0)) amount FROM emp_monthly_pay_component(?,?,?,?) S,employee E ,employee_worked el WHERE S.employee_id=E.employee_id and el.employee_id = S.employee_id  and E.status = 'true'";

	public static final String PAYROLL_LIST_FOR_JV_Month = "SELECT coalesce(el.lop_days,0) lopDays, coalesce(round(el.lop_amount,0),0) lopAmount,	S.employee_id,first_name||' '|| E.middle_name ||' '||E.surname employeeName, to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year,pay_component_id,coalesce(round(amount,0),0) amount,E.epf_no epfno,E.uan_no uanno FROM emp_monthly_pay_component(?,?,?) S,employee E ,employee_worked el WHERE S.employee_id=E.employee_id and el.employee_id = S.employee_id  and E.status = 'true' ORDER BY E.employee_id";;

	public static final String PAYROLL_LIST_FOR_JV_amount_month = "select sum(coalesce(round(amount,0),0)) amount FROM employee_pay_component_paid where month_year =? ";

	public static final String CONVERT_MONTH_YEAR = "select distinct  to_char(to_date(?, 'MMYYYY'), 'Mon YYYY') month_year from pay_slip(?,?,?,?,?)";

	public static final String UPDATE_DEPARTMENT = "update employee_pay_component_paid set department_id =? where employee_id=? ";

	public static final String ADMC = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='ADMC' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String ADMCMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='ADMC' and month_year=?  and  ee.primary_stream=?";

	public static final String BASIC = "select coalesce(sum(amount),0) as amount" + " " + "from employee_pay_component_paid  e left join employee_master ee on ee.emp_id = e.employee_id " + "where pay_component_id='BASIC' and month_year=? and e.department_id=? and  ee.primary_stream=?";

	public static final String BASICMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid  e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='BASIC' and month_year=? and  ee.primary_stream=?";

	public static final String HRA = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid  e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='HRA' and month_year=? and e.department_id=? and  ee.primary_stream=?";

	public static final String HRAMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='HRA' and month_year=?  and  ee.primary_stream=? ";

	public static final String PFSEL = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='PFSEL' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String PFSELMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id  where pay_component_id='PFSEL' and month_year=?  and  ee.primary_stream=?";

	public static final String MEDIC = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id  where pay_component_id='MEDIC' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String MEDICMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='MEDIC' and month_year=?  and  ee.primary_stream=? ";

	public static final String TOTDE = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='TOTDE' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String TOTDEMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='TOTDE' and month_year=?  and  ee.primary_stream=? ";

	public static final String EDLI = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='EDLI' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String EDLIMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='EDLI' and month_year=?  and  ee.primary_stream=? ";

	public static final String EPF = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='EPF' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String EPFMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='EPF' and month_year=?  and  ee.primary_stream=?";

	public static final String ESI = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='ESI' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String ESIMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='ESI' and month_year=?  and  ee.primary_stream=?";

	public static final String GROSS = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='GROSS' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String GROSSMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='GROSS' and month_year=?  and  ee.primary_stream=?";

	public static final String CONS = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id  where pay_component_id='CONS' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String CONSMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='CONS' and month_year=?  and  ee.primary_stream=?";

	public static final String WF = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='WF' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String WFMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id  where pay_component_id='WF' and month_year=?  and  ee.primary_stream=?";

	public static final String DA = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id  where pay_component_id='DA' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String DAMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id  where pay_component_id='DA' and month_year=?  and  ee.primary_stream=?";

	public static final String PTS = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='PTS' and month_year=? and e.department_id=?  and  ee.primary_stream=?";

	public static final String PTSMON = "select coalesce(sum(amount),0) as amount from employee_pay_component_paid e left join employee_master ee on ee.emp_id = e.employee_id where pay_component_id='PTS' and month_year=?  and  ee.primary_stream=?";

	public static final String GET_ACCOUNT_HEAD_FROM_ED = "select account_head from pay_component  where pay_component_id  = ? ";

	public static final String GET_DEBIT_ACCOUNT_HEAD_FROM_ED = "select debit_account_head from pay_component  where pay_component_id  = ? ";

}