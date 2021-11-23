package com.dci.payroll.payroll.payslip;

public class PaySlipQueryUtil {

/*	public static final String mail = "select email,department_id from employee where employee_id = ?";

	public static final String mail1 = "select email from employee where employee_id = ?";

	// public static final String SELECT_PAYSLIP = "SELECT
	// coalesce(el.lop_days,0)
	// lopDays,coalesce(round(el.lop_amount,0),0) lopAmount, e.employee_id,case
	// when
	// e.pay_component_id = 'AD' then concat(e.pay_component_id, '-', e.ad_code)
	// else e.pay_component_id end as pay_component_id
	// ,e.month_year,coalesce(round(e.amount),0) amount, bd.department_id,
	// bd.branch_id, e.employee_name,e.pay_component_type FROM
	// pay_slip(?,?,?,?,?)
	// as e left join employee_worked as el on el.employee_id=e.employee_id and
	// e.month_year=el.month_year inner join employee_master ee on ee.emp_id =
	// e.employee_id inner join branch_department bd on bd.branch_department_id
	// =
	// ee.branch_department_id";

	//public static final String SELECT_PAYSLIP = "SELECT coalesce(el.days,0) lopDays, e.employee_id,case when e.pay_component_id = 'AD' then concat(e.pay_component_id, '-', e.ad_code) else e.pay_component_id end as payComponentId ,'' month_year,coalesce(round(e.amount),0) amount, bd.department_id, bd.branch_id, e.employee_name,e.pay_component_type FROM pay_slip(?,?,?,?,?) as e left join employee_lop as el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id";

	
public static final String SELECT_PAYSLIP = 
			
			""
					+ "SELECT coalesce(el.days,0) lopDays, e.employee_id,case when e.pay_component_id = 'AD' then concat(e.pay_component_id) else e.pay_component_id end as payComponentId ,e.month_year,coalesce(round(e.amount),0) amount, ee.dept, ee.branch_department_id, e.employee_name,e.pay_component_type                             FROM "
					+ "      pay_slip(?,?,?,?,?) as e left join employee_lop as el on el.emp_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id where amount != 0 ";
	
	 * public static final String SELECT_PAYSLIP =
	 * "SELECT coalesce(el.lop_days,0) lopDays,coalesce(round(el.lop_amount,0),0) lopAmount, e.employee_id,e.pay_component_id,e.month_year,round(e.amount) amount, bd.department_id, bd.branch_id, "
	 * + "e.employee_name,e.pay_component_type FROM pay_slip(?,?,?,?,?) as e " +
	 * "left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year "
	 * + "inner join employee_master ee on ee.emp_id = e.employee_id " +
	 * "inner join branch_department bd on bd.branch_department_id = ee.branch_department_id"
	 * ;
	 

	public static final String SELECT_PAYSLIP1 = "SELECT coalesce(el.lop_days,0) lopDays,coalesce(30 - el.lop_days,30) salDays,ee.epf_no epfno,ee.uan_no uanno,coalesce(round(el.lop_amount,0),0) lopAmount, e.employee_id,e.pay_component_id,e.month_year,round(e.amount) amount, bd.department_id, bd.branch_id,e.employee_name,e.pay_component_type FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id";

	public static final String BASIC = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'BASIC'";

	public static final String DA = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'DA'";

	public static final String HRA = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'HRA'";

	public static final String CONVE = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'CONVE'";

	public static final String CONS = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'CONS'";

	public static final String SPL = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'SPL'";

	public static final String OTEAR = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'OTEAR'";

	public static final String GROSS = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'GROSS'";

	public static final String MEDIC = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'MEDIC'";

	public static final String PFSEL = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'PFSEL'";

	public static final String OTDED = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'OTDED'";

	public static final String LOPD = "select sum(round(t.lopDays)) amount from ( SELECT coalesce(el.lop_days,0) lopDays FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id group by el.lop_days,e.employee_id ) t";

	public static final String LOPA = "select sum(round(t.lopAmount)) amount from ( SELECT coalesce(round(el.lop_amount,0),0) lopAmount FROM pay_slip1(?,?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id group by el.lop_amount,e.employee_id ) t";

	public static final String NET = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'NET'";

	public static final String WF = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'WF'";

	public static final String PT = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'PT'";

	public static final String TDS = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'TDS'";

	public static final String Tele = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'Tele'";

	public static final String US = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'US'";

	public static final String AD = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'AD'";

	public static final String TR1 = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'TR1'";

	public static final String OTD = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'OTD'";

	public static final String epfno = "SELECT sum(round(amount)) amount,ee.epf_no FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id group by ee.epf_no";

	public static final String TA = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'TA'";
	public static final String OT = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'OT'";
	public static final String TS_05 = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'TS_05'";
	public static final String EPF = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'EPF'";
	public static final String ESI = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'ESI'";
	public static final String EDLI = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'EDLI'";
	public static final String EPS = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'EPS'";
	public static final String ADMC = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'ADMC'";
	public static final String TRANS = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'Trans'";
	public static final String PTS = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'PTS'";

	public static final String get_EmployeeDetail_List = "SELECT  MTable.Employee_Id employeeId,  MTable.EmployeeName employeeName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave,   CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2))   "
			+ "IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed,   CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance	   "
			+ "FROM    (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year,   Employee.First_Name AS EmployeeName, Employee.emp_id   FROM    Employee INNER JOIN   Employee_Leave_Type ON Employee.emp_id = Employee_Leave_Type.Employee_Id INNER JOIN   Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name      WHERE      (Employee.emp_id =  ? ) And (Employee_Leave_Type.Year = extract ( year from now())) and leave_Type.status=true and leave_type.gender=0) AS MTable LEFT OUTER JOIN   (SELECT     SUM(Leave_Request.Number_Of_Days) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name   	"
			+ "FROM    Leave_Request INNER JOIN   Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN   Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name   WHERE      (Leave_Request.Employee_Id = ? ) AND (Leave_Request_Action.status = 1) and   EXTRACT(YEAR FROM Date_To)= extract ( year from now()) " + "GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name where MTable.Yearly_Max > 0";

	
	 * public static final String SELECT_PAYSLIP_NEW =
	 * "SELECT coalesce(el.days,0) lopDays, e.employee_id,case when e.pay_component_id = 'AD' then concat(e.pay_component_id) else e.pay_component_id end as payComponentId ,e.month_year, bd.department_id, bd.branch_id, e.pay_component_id FROM employee_pay_component_paid e "
	 * + "left join employee_lop as el on el.employee_id=e.employee_id " +
	 * "and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id "
	 * + "where e.month_year=? and e.department_id=?";
	 */

	
	public static final String mail = "select email_id,dept from employee_master where emp_id = ?";

	public static final String mail1 = "select email_id  from employee_master where emp_id = ?";

	// public static final String SELECT_PAYSLIP = "SELECT coalesce(el.lop_days,0)
	// lopDays,coalesce(round(el.lop_amount,0),0) lopAmount, e.employee_id,case when
	// e.pay_component_id = 'AD' then concat(e.pay_component_id, '-', e.ad_code)
	// else e.pay_component_id end as pay_component_id
	// ,e.month_year,coalesce(round(e.amount),0) amount, bd.department_id,
	// bd.branch_id, e.employee_name,e.pay_component_type FROM pay_slip(?,?,?,?,?)
	// as e left join employee_worked as el on el.employee_id=e.employee_id and
	// e.month_year=el.month_year inner join employee ee on ee.employee_id =
	// e.employee_id inner join branch_department bd on bd.branch_department_id =
	// ee.branch_department_id";

//	public static final String SELECT_PAYSLIP = "SELECT coalesce(el.days,0) lopDays, e.employee_id,case when e.pay_component_id = 'AD' then concat(e.pay_component_id, '-', e.ad_code) else e.pay_component_id end as payComponentId ,e.month_year,coalesce(round(e.amount),0) amount, bd.department_id, bd.branch_id, e.employee_name,e.pay_component_type FROM pay_slip(?,?,?,?,?) as e left join employee_lop as el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee ee on ee.employee_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id";
	public static final String SELECT_PAYSLIP = 
			
			""
					+ "SELECT coalesce(el.days,0) lopDays, e.employee_id,concat(to_char(to_timestamp (substring(e.month_year,1,2)::varchar, 'MM'), 'TMMonth'),'-', substring(e.month_year,3,4) ) as monthYear, (select concat(company_name ,'<br>',address ) from  company_master where company_code = ee.company_code limit 1) as cmpyadd,(select pay_component_name from pay_component where  pay_component_id= e.pay_component_id) as paycomponentname,(select company_name as company from  company_master where company_code = ee.company_code limit 1),case when e.pay_component_id = 'AD' then concat(e.pay_component_id) else e.pay_component_id end as payComponentId ,e.month_year,coalesce(round(e.amount),0) amount, (select paybankname from employee_paybank where employee_id = ee.emp_id ) as paybankname, ee.dept, ee.branch_department_id, e.employee_name,e.pay_component_type ,ee.epf_no as epfno,ee.uan_no as uanno, (select   desgn_name from designation_master  where  desgn_code ::text = ee.designation ) as desgination ,ee.bankacct_no as bankno, to_char(ee.dt_of_join,'dd/mm/yyyy') as doj ,ee.esic_code as esicode           FROM "
					+ "      pay_slip(?,?,?,?,?) as e left join employee_lop as el on el.emp_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id where amount != 0 ";
			
			
			///"SELECT coalesce(el.days,0) lopDays, e.employee_id,case when e.pay_component_id = 'AD' then concat(e.pay_component_id, '-', e.ad_code) else e.pay_component_id end as payComponentId ,e.month_year,coalesce(round(e.amount),0) amount, bd.department_id, bd.branch_id, e.employee_name,e.pay_component_type FROM pay_slip(?,?,?,?,?) as e left join employee_lop as el on el.emp_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id";
	/*
	 * public static final String SELECT_PAYSLIP =
	 * "SELECT coalesce(el.lop_days,0) lopDays,coalesce(round(el.lop_amount,0),0) lopAmount, e.employee_id,e.pay_component_id,e.month_year,round(e.amount) amount, bd.department_id, bd.branch_id, "
	 * + "e.employee_name,e.pay_component_type FROM pay_slip(?,?,?,?,?) as e " +
	 * "left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year "
	 * + "inner join employee ee on ee.employee_id = e.employee_id " +
	 * "inner join branch_department bd on bd.branch_department_id = ee.branch_department_id"
	 * ;
	 */

	public static final String SELECT_PAYSLIP1 = "SELECT coalesce(el.lop_days,0) lopDays,coalesce(30 - el.lop_days,30) salDays,ee.epf_no epfno,ee.uan_no uanno,coalesce(round(el.lop_amount,0),0) lopAmount, e.employee_id,e.pay_component_id,e.month_year,round(e.amount) amount,ee.dept, bd.brnch_id,e.employee_name,e.pay_component_type   FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id";

	public static final String BASIC = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'BASIC'";

	public static final String DA = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'DA'";

	public static final String HRA = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'HRA'";

	public static final String CONVE = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'CONVE'";

	public static final String CONS = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'CONS'";

	public static final String SPL = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'SPL'";

	public static final String OTEAR = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'OTEAR'";

	public static final String GROSS = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'GROSS'";

	public static final String MEDIC = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'MEDIC'";

	public static final String PFSEL = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'PFSEL'";

	public static final String OTDED = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'OTDED'";

	public static final String LOPD = "select coalesce(sum(round(t.lopDays)),0) amount from ( SELECT coalesce(el.lop_days,0) lopDays FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id group by el.lop_days,e.employee_id ) t";

	public static final String LOPA = "select coalesce(sum(round(t.lopAmount)),0) amount from ( SELECT coalesce(round(el.lop_amount,0),0) lopAmount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id group by el.lop_amount,e.employee_id ) t";

	public static final String NET = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'NET'";

	public static final String WF = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'WF'";

	public static final String PT = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'PT'";

	public static final String TDS = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'TDS'";

	public static final String Tele = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'Tele'";

	public static final String US = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'US'";

	public static final String AD = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'AD'";

	public static final String TR1 = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'TR1'";

	public static final String OTD = "SELECT coalesce(sum(round(amount)),0)  amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'OTD'";

	public static final String epfno = "SELECT coalesce(sum(round(amount)),0)  amount,ee.epf_no FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id group by ee.epf_no";

	
	
	
//	public static final String get_EmployeeDetail_List = "SELECT  MTable.Employee_Id employeeId,  MTable.EmployeeName employeeName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave,   CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2))   "
//			+ "IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed,   CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance	   "
//			+ "FROM    (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year,   Employee.First_Name AS EmployeeName, Employee.Employee_Id   FROM    Employee INNER JOIN   Employee_Leave_Type ON Employee.Employee_Id = Employee_Leave_Type.Employee_Id INNER JOIN   Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name      WHERE      (Employee.Employee_Id =  ? ) And (Employee_Leave_Type.Year = extract ( year from now())) and leave_Type.status=true and leave_type.gender=0) AS MTable LEFT OUTER JOIN   (SELECT     SUM(Leave_Request.Number_Of_Days) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name   	"
//			+ "FROM    Leave_Request INNER JOIN   Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN   Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name   WHERE      (Leave_Request.Employee_Id = ? ) AND (Leave_Request_Action.status = 1) and   EXTRACT(YEAR FROM Date_To)= extract ( year from now()) " + "GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name where MTable.Yearly_Max > 0";
//	
	public static final String get_EmployeeDetail_List = "SELECT  MTable.Emp_Id employeeId,  MTable.EmployeeName employeeName, MTable.Year, MTable.Short_Name as shortName, MTable.leave_type_name AS leaveName ,CAST(MTable.Yearly_Max AS decimal(10,2)) AS AllowedLeave,   CASE WHEN CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NULL THEN 0 ELSE  CAST(TransTable.Number_Of_Days AS decimal(10,2)) END AS Consumed,   CASE WHEN  CAST(TransTable.Number_Of_Days AS decimal(10,2))   IS NOT NULL THEN (CAST(MTable.Yearly_Max -TransTable.Number_Of_Days AS decimal(10,2))) ELSE CAST((MTable.Yearly_Max - 0)AS decimal(10,2))  END AS Balance	   FROM    (SELECT     Employee_Leave_Type.Yearly_Max, Employee_Leave_Type.Short_Name, Leave_Type.leave_type_Name, Employee_Leave_Type.Year,   Employee_master.emp_Name AS EmployeeName, Employee_master.Emp_Id   FROM    Employee_master INNER JOIN   Employee_Leave_Type ON Employee_master.Emp_id = Employee_Leave_Type.Employee_Id INNER JOIN   Leave_Type ON Employee_Leave_Type.Short_Name = Leave_Type.Short_Name      WHERE      (Employee_master.Emp_Id =   ? ) And (Employee_Leave_Type.Year = extract ( year from now())) and leave_Type.status=true and leave_type.gender=0) AS MTable LEFT OUTER JOIN   (SELECT     SUM(Leave_Request.Number_Of_Days) AS Number_Of_Days, Leave_Type.Short_Name, Leave_Type.leave_type_Name   	FROM    Leave_Request INNER JOIN   Leave_Request_Action ON Leave_Request.Leave_Request_Id = Leave_Request_Action.Leave_Request_Id INNER JOIN   Leave_Type ON Leave_Request.Leave_Type = Leave_Type.Short_Name   WHERE      (Leave_Request.Employee_Id =  ? ) AND (Leave_Request_Action.status = 1) and   EXTRACT(YEAR FROM Date_To)= extract ( year from now()) GROUP BY Leave_Type.Short_Name, Leave_Type.leave_type_name) AS TransTable ON TransTable.Short_Name = MTable.Short_Name where MTable.Yearly_Max > 0 ";

	public static final String GET_EMPLOYEE_DETAILS = ""
			+ "select emp_id as empId,emp_name as empName,desgn_name as desgn,'BANK' as paymode,dept_name as dept,branch_name as branch "
			+ ",paybankname as bankName,iban as ibanNo,payAcctNum as acctName,paybankBranch as bankBranch , eseqgn.seq_id as seqId from employee_master e "
			+ "join designation_master d on d.desgn_code=e.designation join department_master dep on dep.dept_code=e.dept "
			+ " join branch b on b.brnch_id=e.branch_department_id "
			+ " left join  employee_paybank epb on epb.employee_id=e.emp_id "
			+ " join employee_pay_component_paid_seq_gen eseqgn on eseqgn.employee_id=e.emp_id "
			+ "  where emp_id=?  limit 1";

	public static final String GET_EMPLOYEE_DETAILS_emp = "select emp_id as empId,emp_name as empName,desgn_name as desgn,'BANK' as paymode,dept_name as dept,brnch_nam as branch ,emp.month_year as monthyear,paybankname as bankName,iban as ibanNo,payAcctNum as acctName,paybankBranch as bankBranch , (select seq_id as seqId from employee_pay_component_paid_seq_gen where employee_id = emp_id  and monthyear = ? order by seq_id desc limit 1) from employee_master e join designation_master d on d.desgn_code=e.designation join department_master dep on dep. dept_code=e.dept  join employee_pay_component_paid emp on emp.employee_id=e.emp_id join branch b on b.brnch_id=e.branch_department_id left join  employee_paybank epb on epb.employee_id=e.emp_id where emp_id= ?  limit 1";
	
	public static final String SELECT_PAYSLIP_NEW = "SELECT distinct " + "e.pay_component_id as payComponentId ,coalesce(el.days,0) lopDays" + ",e.month_year, bd.department_id, bd.branch_id FROM " + "employee_pay_component_paid e left " + "join employee_lop as el on el.employee_id=e.employee_id " + "and e.month_year=el.month_year inner join" + " employee_master ee on ee.emp_id = e.employee_id " + "inner join branch_department bd" + " on bd.branch_id" + " = ee.branch_department_id::text  where e.month_year=? and e.department_id=?";

	public static final String SELECT_PAYSLIP_NEW_MONTH = "SELECT distinct e.pay_component_id as payComponentId ,coalesce(el.days,0) lopDays,e.month_year, bd.department_id, bd.branch_id FROM employee_pay_component_paid e left join employee_lop as el on el.employee_id=e.employee_id " + "and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_id = ee.branch_department_id::text where e.month_year=?";

	public static final String PI = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'PI'";

	public static final String HR = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'HR'";

	public static final String ARR = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'ARR'";

	public static final String SELECT_PAYSLIP_Check = "select * from payrolltojvyearcheck(?)";

	public static final String SELECT_PAYSLIP_Check_Dept = "select * from payrolltojvyeardeptcheck(?,?)";

	public static final String TA = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'TA'";

	public static final String OT = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'OT'";

	public static final String TS_05 = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'TS_05'";

	public static final String EPF = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'EPF'";

	public static final String ESI = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'ESI'";

	public static final String EDLI = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where  e.pay_component_id = 'EDLI'";

	public static final String EPS = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'EPS'";

	public static final String ADMC = "SELECT coalesce(sum(round(amount)),0) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch bd on bd.brnch_id = ee.branch_department_id where e.pay_component_id = 'ADMC'";

	public static final String TRANS = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'TRANS'";

	public static final String PTS = "SELECT sum(round(amount)) amount FROM pay_slip1(?,?,?,?,?) as e left join employee_worked as  el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee_master ee on ee.emp_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id where e.pay_component_id = 'PTS'";

	public static String leave = "SELECT S.avail as avail FROM emp_monthly_pay_component(?,?,?,?) S,employee E ,employee_worked el WHERE S.employee_id=E.employee_id and el.employee_id = S.employee_id  and E.status = 'true' ORDER BY E.employee_id";

}