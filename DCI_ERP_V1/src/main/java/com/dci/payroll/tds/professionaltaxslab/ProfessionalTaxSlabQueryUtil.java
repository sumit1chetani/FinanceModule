package com.dci.payroll.tds.professionaltaxslab;

public class ProfessionalTaxSlabQueryUtil {
	public static final String SELECT_PTSLAB_LIST = "select pts.*,b.branch_name,b.company_id,c.company_name from professional_tax_slab pts LEFT OUTER JOIN branch b ON pts.branch_id=b.branch_id LEFT OUTER JOIN company c ON b.company_id=c.company_id";

	public static final String INSERT_PTSLAB = "INSERT INTO professional_tax_slab" + " (branch_id,range_from,range_to,charge,financial_year)" + " VALUES (:branch_id,:range_from,:range_to,:charge,:financial_year)";

	public static final String SELET_EMPLOYEE_PTSLB = "with M1 as (   select DATE( substr(?,1,4) || '-04-01') + (interval '1' month * generate_series(0,11))  monthyear ), M as (select row_number() OVER (ORDER BY monthyear) AS sl, monthyear from M1), N as (   select emp_id , sl, to_char(monthyear,'MMYYYY') monthyear ,to_char(monthyear,'Mon') monthValue from employees(?,?,?,?) E cross join M   where monthyear <=  (select max( to_date('01'||month_year, 'ddmmyyyy'))  from employee_pay_component_paid ) ) select N.emp_id as employeeId, E.first_name as employeeName, N.monthyear, N.monthValue, coalesce(S.amount,0) amount from N left outer join (select * from employee_pay_component_paid where pay_component_id = ?) S         on N.emp_id = S.employee_id and N.monthyear = S.month_year        left outer join Employee_master E on N.emp_id = E.emp_id order by employee_id, sl";
			
			/*"with M1 as " + "(   select DATE( substr(?,1,4) || '-04-01') + (interval '1' month * generate_series(0,11))  monthyear ), " + "M as (select row_number() OVER (ORDER BY monthyear) AS sl, monthyear from M1), " + "N as " + "( " + "  select employee_id, sl, to_char(monthyear,'MMYYYY') monthyear ,to_char(monthyear,'Mon') monthValue from employees(?,?,?,?) E cross join M " + "  where monthyear <=  (select max( to_date('01'||month_year, 'ddmmyyyy'))  from employee_pay_component_paid ) " + ") "
			+ "select N.employee_id, E.first_name as employeeName, N.monthyear, N.monthValue, coalesce(S.amount,0) amount " + "from N left outer join (select * from employee_pay_component_paid where pay_component_id = ?) S " + "                         on N.employee_id = S.employee_id and N.monthyear = S.month_year " + "       left outer join Employee E on N.employee_id = E.employee_id " + "order by employee_id, sl";*/

	public static String SELECT_PTSLABENTRYBYID = "select PTS.branch_id ,PTS.range_from ,PTS.range_to ,PTS.charge ,b.branch_name , PTS.financial_year from professional_tax_slab PTS INNER JOIN branch b on b.branch_id=PTS.branch_id where PTS.branch_id=? and PTS.financial_year=? and PTS.range_from=?";

	public static String UPDATE_PTSLAB = "UPDATE professional_tax_slab SET range_from=:range_from, range_to=:range_to, charge=:charge where branch_id=:branch_id and financial_year=:financial_year and range_from=:range_from";

	public static String DELETE_PTSLAB = "Delete from professional_tax_slab where branch_id=? and financial_year=? and range_from=?";

	public static String SELECT_PTSLAB_BY_DATE_AND_ID = "select * from employee_pay_component_paid  where employee_id=? and pay_component_id=? and month_year=?";

	public static final String SELECT_FINANCIAL_YEAR_LIST = "select financial_year_id financialYear,financial_year_id as text,financial_year_id as id from financial_year  where company_code=? and is_current=?";

	public static final String INSERT_SALARY = "INSERT INTO employee_pay_component_paid (employee_id, pay_component_id,amount,month_year) " + " VALUES (?,?,?,to_char(to_date(?, 'Mon YYYY'),'mmyyyy')) ";

	public static final String SELECT_FINANCIAL_YEAR_BYID = "select financial_year_id financialYear,financial_year_id as text,company_id,company_id as id from financial_year";

	public static String SELECT_PTSLAB_BY_ID = "select * from employee_pay_component_paid  where employee_id=? and pay_component_id=? and month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String UPDATE_SALARY = "UPDATE  employee_pay_component_paid SET amount=? where employee_id=? and pay_component_id=? and month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static final String DELETE_SALARY = "Delete from employee_pay_component_paid where employee_id=? and pay_component_id=? and month_year=to_char(to_date(?, 'Mon YYYY'),'mmyyyy')";

	public static String SELECT_PTSLAB = "select * from employee_pay_component_paid  where employee_id=? and pay_component_id=? and month_year=?";

	public static final String INSERT_PT_SALARY = "INSERT INTO employee_pay_component_paid (employee_id, pay_component_id,amount,month_year) " + " VALUES (?,?,?,?) ";

	public static final String UPDATE_PT_SALARY = "UPDATE  employee_pay_component_paid SET amount=? where employee_id=? and pay_component_id=? and month_year=?";

	public static final String DELETE_PT_SALARY = "Delete from employee_pay_component_paid where employee_id=? and pay_component_id=? and month_year=?";

}