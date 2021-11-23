package com.dci.payroll.payroll.withHold;

public class WithHoldQueryUtil {

	public static final String SELECT_EMPLOYEE = "select emp_id as id,concat(emp_id||' '||'-'||' '||first_name || middle_name || surname) as text from employee_master where status = 'Y' and designation_id!=38 and payroll_flag!='t' and emp_id not in (select emp_id from payroll_withhold where till_month is null and till_year  is  null ) order by emp_id";

	public static final String insert_WitHold = " insert into payroll_withHold(pr_wh_code,emp_id,with_hold_date,from_month,from_year,till_month,till_year,created_by,created_date )values (?,?,to_date(?,'dd-MM-yyyy'),?,?,?,?,?,now())";
	// delete
	public static final String WithHold_Delete = "delete from payroll_withHold where pr_wh_code=?";

	/*
	 * public static String withHoldList =
	 * "select wh.pr_wh_code withHoldCode,e.employee_id as employee, concat(e.first_name || e.middle_name || e.surname) employeeName,"
	 * +
	 * "to_char(wh.with_hold_date,'dd/mm/yyyy') as withholdDate ,to_char(to_timestamp (wh.from_month::text, 'MM'), 'TMMON')||'-'||wh.from_year   withholdFrom,"
	 * +
	 * "to_char(to_timestamp (wh.till_month::text, 'MM'), 'TMMON')||'-'||wh.till_year  withholdTo,"
	 * +
	 * "case when( wh.till_month< extract(month FROM now()) or wh.till_year < extract(year FROM now()))"
	 * + " then false else true   end as check ," +
	 * "  case when (wh.till_month< extract(month FROM now()) or wh.till_year < extract(year FROM now())) "
	 * + " then 'Completed' else 'Pending'   end as status" +
	 * "  from payroll_withHold wh inner join employee e on  wh.emp_id = e.employee_id "
	 * + "   order by wh.created_date desc,wh.modified_date desc";
	 */
	public static String withHoldList = " select wh.pr_wh_code withHoldCode,e.emp_id as employee,concat(e.first_name || e.middle_name || e.surname) employeeName,"
			+ "to_char(wh.with_hold_date,'dd/mm/yyyy') as withholdDate ,to_date(concat(wh.from_month,wh.from_year)::text,'MMyyyy')withholdFrom,	case when  COALESCE(wh.till_year, '') = '' or  COALESCE(wh.till_month , '') = '' then null else to_date(concat(till_month,till_year)::text,'MMyyyy')  end as withholdTo ,  case when( cast(case when COALESCE(wh.till_month, '') = '' then null else wh.till_month end as Integer) < extract(month FROM now()) )  and cast( case when COALESCE(wh.till_year, '') = '' then null else wh.till_year end as Integer)  <= extract(year FROM now()) then false else true   end as check, case when( cast(case when COALESCE(wh.till_month, '') = '' then null else wh.till_month end as Integer) < extract(month FROM now()) )  and cast( case when COALESCE(wh.till_year, '') = '' then null else wh.till_year end as Integer)  <= extract(year FROM now()) then 'Completed' else 'Pending'   end as status  from payroll_withHold wh inner join employee_master e on  wh.emp_id = e.emp_id "
			+ "order by wh.created_date desc,wh.modified_date desc";

	public static String edit_WithHold = "select pr_wh_code withHoldCode,  concat(e.first_name || e.middle_name || e.surname) employee, to_char(with_hold_date,'dd/MM/yyyy') withholdDate, from_month fromMonth,from_year fromYear,till_month tillMonth,till_year tillYear from payroll_withHold inner join employee_master e on e.emp_id=payroll_withHold.emp_id  where  payroll_withHold.pr_wh_code =?";

	public static String check_max = "select CASE WHEN max(pr_wh_code) is null then '0' else max(pr_wh_code) end from (select substr(pr_wh_code, 4) pr_wh_code from payroll_withHold ) temp ";

	// update

	public static String update_WitHold = " update payroll_withHold set with_hold_date=to_date(?,'dd-MM-yyyy'),from_month=?,from_year=?,till_month=?,till_year=?,modified_by=?,modified_date = now() where pr_wh_code=? ";

	public static String Withhold_ReportList = "with t as (select wh.pr_wh_code withHoldCode, wh.emp_id employee,concat(e.first_name || e.middle_name || e.surname) employeeName,wh.with_hold_date withholdDate, to_date(concat(wh.from_month,wh.from_year)::text,'MMyyyy') withholdFrom, (select case when COALESCE(wh.till_year, '') = '' and COALESCE(wh.till_month , '') = '' then null else to_date(concat(till_month,till_year)::text,'MMyyyy') end ) as withholdTo,(select case when length(from_month::text) = 1 then to_date(concat('0',wh.from_month,'/',wh.from_year),'MM/YYYY') else to_date(concat(wh.from_month,'/',wh.from_year),'MM/YYYY') end as text from payroll_withhold where from_month is not null and wh.pr_wh_code=payroll_withhold.pr_wh_code) as frmDate, (select case when COALESCE(wh.till_year, '') = '' and COALESCE(wh.till_month , '') = '' then null else to_date(concat(till_month,till_year)::text,'MMyyyy') end as text from payroll_withhold where wh.pr_wh_code=payroll_withhold.pr_wh_code) as tlDate from payroll_withhold wh inner join employee_master e on wh.emp_id = e.emp_id order by wh.from_month )select * from t where to_date(?,'mmyyyy') between frmDate and tlDate union  select * from t where tlDate is null and frmDate= to_date(?,'mmyyyy')";

	public static String SELECT_Year = "select distinct year as id ,year as text from calender_year order by id desc ";

	public static String dateList = "select wh.pr_wh_code withHoldCode,e.emp_id as employee, concat(e.first_name || e.middle_name || e.surname) employeeName, to_char(wh.with_hold_date,'dd/mm/yyyy') as withholdDate ,to_date(concat(wh.from_month,wh.from_year)::text,'MMyyyy') withholdFrom,to_date(concat(till_month,till_year)::text,'MMyyyy') withholdTo from payroll_withHold wh inner join employee_master e on  wh.emp_id = e.emp_id order by modified_date desc,created_date desc";

	/*
	 * public static String Withhold_ReportList_Pending =
	 * "with t as (select wh.pr_wh_code withHoldCode, wh.emp_id employee,concat(e.first_name || e.middle_name || e.surname) employeeName,wh.with_hold_date withholdDate,  to_char(to_timestamp (wh.from_month::text, 'MM'), 'TMMON')||'-'||wh.from_year withholdFrom,to_char(to_timestamp (wh.till_month::text, 'MM'), 'TMMON')||'-'||wh.till_year withholdTo,(select case when length(from_month::text) = 1 then to_date(concat('0',wh.from_month,'/',wh.from_year),'MM/YYYY')  else to_date(concat(wh.from_month,'/',wh.from_year),'MM/YYYY') end as text from payroll_withhold  where from_month is not null and wh.pr_wh_code=payroll_withhold.pr_wh_code) as frmDate,  (select case when length(till_month::text) = 1 then to_date(concat('0',wh.till_month,'/',wh.till_year),'MM/YYYY')  else to_date(concat(wh.till_month,'/',wh.till_year),'MM/YYYY') end as text from payroll_withhold  where till_month is not null and wh.pr_wh_code=payroll_withhold.pr_wh_code) as tlDate from payroll_withhold wh  inner join employee e on  wh.emp_id = e.employee_id  where (wh.till_month>= extract(month FROM now()) and  wh.till_year >= extract(year FROM now()))  or till_month is null order by wh.from_month  ),"
	 * 
	 * +
	 * " c as (select wh.pr_wh_code withHoldCode, wh.emp_id employee,concat(e.first_name || e.middle_name || e.surname) employeeName,wh.with_hold_date withholdDate,to_char(to_timestamp (wh.from_month::text, 'MM'), 'TMMON')||'-'||wh.from_year withholdFrom,to_char(to_timestamp (wh.till_month::text, 'MM'), 'TMMON')||'-'||wh.till_year withholdTo, (select case when length(from_month::text) = 1 then to_date(concat('0',wh.from_month,'/',wh.from_year),'MM/YYYY')  else to_date(concat(wh.from_month,'/',wh.from_year),'MM/YYYY') end as text from payroll_withhold  where till_month is not null and wh.pr_wh_code=payroll_withhold.pr_wh_code) as frmDate,(select case when length(till_month::text) = 1 then to_date(concat('0',wh.till_month,'/',wh.till_year),'MM/YYYY')  else to_date(concat(wh.till_month,'/',wh.till_year),'MM/YYYY') end as text from payroll_withhold  where till_month is not null and wh.pr_wh_code=payroll_withhold.pr_wh_code) as tlDate from payroll_withhold wh  inner join employee e on  wh.emp_id = e.employee_id  where (wh.till_month>= extract(month FROM now()) and  wh.till_year >= extract(year FROM now())) and   till_month is  not null order by wh.from_month )  select * from t where  to_date(?,'mmyyyy') between frmDate and tlDate  union  select * from t where  to_date(?,'mmyyyy') between frmDate and tlDate  union  select * from t where tlDate is null and frmDate= to_date(?,'mmyyyy')"
	 * ;
	 */

	public static String Withhold_ReportList_Pending = "with t as (select wh.pr_wh_code withHoldCode, wh.emp_id employee,concat(e.first_name || e.middle_name || e.surname) employeeName,wh.with_hold_date withholdDate, to_date(concat(wh.from_month,wh.from_year)::text,'MMyyyy') withholdFrom,to_date(concat(till_month,till_year)::text,'MMyyyy') withholdTo,(select case when length(from_month::text) = 1 then to_date(concat('0',wh.from_month,'/',wh.from_year),'MM/YYYY') else to_date(concat(wh.from_month,'/',wh.from_year),'MM/YYYY') end as text from payroll_withhold where from_month !='' and wh.pr_wh_code=payroll_withhold.pr_wh_code) as frmDate, (select case when COALESCE(wh.till_year, '') = '' and COALESCE(wh.till_month , '') = '' then null else to_date(concat(till_month,till_year)::text,'MMyyyy') end as text from payroll_withhold where till_month !='' and wh.pr_wh_code=payroll_withhold.pr_wh_code) as tlDate from payroll_withhold wh inner join employee_master e on wh.emp_id = e.emp_id where case when COALESCE(wh.till_month, '') = '' then true else cast(wh.till_month as integer) >= extract(month FROM now()) end and case when COALESCE(wh.till_year, '') = '' then true else cast(wh.till_year as int) >= extract(year FROM now()) or till_month!='' end order by wh.from_month ) select * from t where to_date(?,'mmyyyy') between frmDate and tlDate union select * from t where tlDate is null and frmDate= to_date(?,'mmyyyy')";

	/*
	 * public static String Withhold_ReportList_Completed =
	 * "with t as (select wh.pr_wh_code withHoldCode, wh.emp_id employee,concat(e.first_name || e.middle_name || e.surname) employeeName, wh.with_hold_date withholdDate, to_char(to_timestamp (wh.from_month::text, 'MM'), 'TMMON')||'-'||wh.from_year withholdFrom,(select case when length(from_month::text) = 1 then to_date(concat('0',wh.from_month,'/',wh.from_year),'MM/YYYY')  else to_date(concat(wh.from_month,'/',wh.from_year),'MM/YYYY') end as text from payroll_withhold  where from_month is not null and wh.pr_wh_code=payroll_withhold.pr_wh_code) as frmDate,  (select case when length(till_month::text) = 1 then to_date(concat('0',wh.till_month,'/',wh.till_year),'MM/YYYY')  else to_date(concat(wh.till_month,'/',wh.till_year),'MM/YYYY') end as text from payroll_withhold  where till_month is not null and wh.pr_wh_code=payroll_withhold.pr_wh_code) as tlDate,to_char(to_timestamp (wh.till_month::text, 'MM'), 'TMMON')||'-'||wh.till_year withholdTo  from payroll_withhold wh  inner join employee e on  wh.emp_id = e.employee_id where  (wh.till_month< extract(month FROM now()) or wh.till_year < extract(year FROM now())))  select * from t where  to_date(?,'mmyyyy') between frmDate and tlDate"
	 * ;
	 */

	public static String Withhold_ReportList_Completed = "with t as (select wh.pr_wh_code withHoldCode, wh.emp_id employee,concat(e.first_name || e.middle_name || e.surname) employeeName,wh.with_hold_date withholdDate, to_date(concat(wh.from_month,wh.from_year)::text,'MMyyyy') withholdFrom,(select case when COALESCE(wh.till_year, '') = '' and COALESCE(wh.till_month , '') = '' then null else to_date(concat(till_month,till_year)::text,'MMyyyy') end ) as withholdTo, (select case when length(from_month::text) = 1 then to_date(concat('0',wh.from_month,'/',wh.from_year),'MM/YYYY') else to_date(concat(wh.from_month,'/',wh.from_year),'MM/YYYY') end as text from payroll_withhold where from_month !='' and wh.pr_wh_code=payroll_withhold.pr_wh_code) as frmDate, (select case when COALESCE(wh.till_year, '') = '' and COALESCE(wh.till_month , '') = '' then null else to_date(concat(till_month,till_year)::text,'MMyyyy') end as text from payroll_withhold where till_month !='' and wh.pr_wh_code=payroll_withhold.pr_wh_code) as tlDate from payroll_withhold wh inner join employee_master e on wh.emp_id = e.emp_id where case when COALESCE(wh.till_month, '') = '' then false else wh.till_month::int < extract(month FROM now()) end or case when COALESCE(wh.till_year, '') = '' then false else wh.till_year:: int < extract(year FROM now()) end ) select * from t where to_date(?,'mmyyyy') between frmDate and tlDate";

	public static String employee_check = "select till_month||'/'||till_year  withholdTo from payroll_withHold where emp_id=? and  (till_month:: int  >= extract(month FROM now()) and till_year :: int >= extract(year FROM now())) ";

}
