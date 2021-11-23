package com.dci.tenant.employeemaster;

public class EmpmasterQueryUtil {

	public static String sGetEmpmasterValues = "select e.emp_id as empId, e.emp_name as empName, to_char(e.dt_of_join,'MM/dd/yyyy') AS doj,e.password as pswd, e.address as contactAddr, e.brth_identy as biMark, c.location as company,c.location as id,c.location as text, e.blood_group as bldGrp, ds.desgn_name as dsgn, ds.desgn_name as id,ds.desgn_name as text,de.dept_name as dept,de.dept_name as id, de.dept_name as text, e.basic_pay as bPay, e.payment_mode as moPay, e.bankacct_no as acNo,e.contact_no as contactNo, e.email_id as emailId, e.passport_no as passNo, e.place_issue as placeIssue, e.address as contactAddr,e.status as isActive, case when e.sa_right='Y' then 'YES' else 'NO' end as agent,string_agg(port,',') port, e.access_status as accessRights, to_char(e.dt_of_leave,'MM/dd/yyyy') AS leaveDate,to_char(e.confirmation_dt,'MM/dd/yyyy') as confDate, to_char(e.dt_of_birth,'MM/dd/yyyy') as dob, to_char(e.dt_probation_from,'MM/dd/yyyy') as ppf, to_char(e.dt_probation_to,'MM/dd/yyyy') AS ppt from employee_master e,COMPANY_MASTER c, DESIGNATION_MASTER ds, DEPARTMENT_MASTER de where e.COMPANY_CODE=c.COMPANY_CODE and e.DESIGNATION = ds.DESGN_CODE and e.DEPT = de.DEPT_CODE group by empId,c.location,ds.desgn_name,de.dept_name order by e.emp_id desc";

	public static String sCompanyDropDown = "select company_code as id,location as text, company_name company from company_master";

	public static String sDepartmentDropDown = "select dept_code as id,dept_name as text from department_master";

	public static String sDesignationDropDown = "select desgn_code as id,desgn_name as text from designation_master";

	public static String sEmployeeDropDown = "select emp_name from employee_master";

	public static String getEmpIdAutoIncrement = "SELECT CASE WHEN MAX(emp_id) IS NULL  THEN 'E001' ELSE rpad(MAX(emp_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(emp_id),2)) as int)+1  as text),3,'0') END FROM employee_master";

	public static String sAddEmpMaster = "INSERT INTO employee_master(emp_id,emp_name,dt_of_join,dt_of_birth,password,dt_probation_from,"
			+ "dt_probation_to,brth_identy, company_code,blood_group,designation,dept,basic_pay,"
			+ "payment_mode,bankacct_no,contact_no,email_id, passport_no, place_issue, address"
			+ ",access_status,status,sa_right,login_flag,port,created_by,created_dt, service_loc )"
			+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp,?)";

	public static String sDeleteEmpMaster = "DELETE  FROM employee_master WHERE emp_id=?";

	public static String SUpadateEmpmaster = "update employee_master set emp_name =?,dt_of_join =?,dt_of_birth =?,dt_probation_from =?,dt_probation_to =?,brth_identy =?, company_code =?,blood_group =?,designation =?,dept =?,basic_pay =?,payment_mode =?,bankacct_no =?,contact_no =?,email_id =?, passport_no =?, place_issue =?, address =?,status =?,access_status =?,sa_right =?, modified_by =?, confirmation_dt =?, dt_of_leave =?, login_flag =?, port =?, service_loc = ?,password= ? where emp_id = ?";

	public static String SUpadatePassword = "update employee_master set PASSWORD=? , MODIFIED_BY =?,MODIFIED_DT=NOW(),CH_PASSWORD_DT=NOW()  where emp_id = ?";

	public static String EmpResetPassword = " update user_master set user_password=? where user_id=? ";

	public static String SUpadateEmpmasterProfileImg = "update employee_master set profile_img = ? where emp_id = ?";

	public static String sEditempMaster = "select emp_id as empId, emp_name as empName,service_loc as serviceLoc ,"
			+ " to_char(dt_of_join,'dd/MM/yyyy') as doj,password as pswd,address as"
			+ " contactAddr,brth_identy as biMark,company_code as company,blood_group as"
			+ " bldGrp,designation as dsgn,dept as dept,basic_pay as bPay,payment_mode "
			+ "as moPay, bankacct_no as acNo,contact_no as contactNo, email_id as emailId, "
			+ "passport_no as passNo, place_issue as placeIssue,status as isActive, sa_right "
			+ " as agent, access_status as accessRights,to_char(dt_of_leave,'dd/MM/yyyy') "
			+ "AS leaveDate,to_char(confirmation_dt,'dd/MM/yyyy') as confDate, to_char(dt_of_birth,'dd/MM/yyyy') "
			+ "as dob, to_char(dt_probation_from,'dd/MM/yyyy') as ppf, to_char(dt_probation_to,'dd/MM/yyyy') AS ppt,"
			+ " port as port,  coalesce(PROFILE_IMG, 'a0.jpg') as profileImg from employee_master where emp_id =?";
	
	
	public static String sGetEmpmasterValuesaudit = "select e.emp_id as empId, e.emp_name as empName, to_char(e.dt_of_join,'MM/dd/yyyy') "
			+ "AS doj,e.password as pswd,"
			+ " e.address as contactAddr, e.brth_identy as biMark, c.location as company,c.location as id,c.location as text,"
			+ " e.blood_group as bldGrp, ds.desgn_name as dsgn, ds.desgn_name as id,ds.desgn_name as text,de.dept_name as dept,"
			+ "de.dept_name as id, de.dept_name as text, e.basic_pay as bPay, e.payment_mode as moPay, e.bankacct_no as acNo,"
			+ "e.contact_no as contactNo, e.email_id as emailId, e.passport_no as passNo, e.place_issue as placeIssue, e.address"
			+ " as contactAddr,e.status as isActive, e.sa_right as agent, e.access_status as accessRights,"
			+ " to_char(e.dt_of_leave,'MM/dd/yyyy') AS leaveDate,to_char(e.confirmation_dt,'MM/dd/yyyy')"
			+ "as confDate, to_char(e.dt_of_birth,'MM/dd/yyyy') as dob, to_char(e.dt_probation_from,'MM/dd/yyyy')"
			+ " as ppf, to_char(e.dt_probation_to,'MM/dd/yyyy') AS ppt from employee_master e,COMPANY_MASTER c,"
			+ " DESIGNATION_MASTER ds, DEPARTMENT_MASTER de where e.emp_id = ? and e.COMPANY_CODE=c.COMPANY_CODE "
			+ "and e.DESIGNATION = ds.DESGN_CODE and e.DEPT = de.DEPT_CODE order by e.emp_id desc" ;
	
	public static final String INSERT_USER_RIGHTS="insert into user_rights_new (company_user_id,form_property_id) "
			+ "select ?,form_property_id from user_rights_new where company_user_id in("
			+ "select company_user_id from company_user where user_id='E494' and company_code=? )";
	
	public static final String SELECT_DUMMY_AGENT_COMPANY_CODE="select company_code from company_user where user_id='E494'";

	
	public static String sCompanyLocationDropDown = "select company_code as id,location as text , location as serviceLoc  from company_master where upper(is_operation) = 'Y'";

	public static String sPortDropDown = "select port_code as id,port_code as text,port_code portCode from port_master";
	
	public static String UPDATE_USERS_PASSWORD_LOGS="update password_log set change_password =?, modified_date=now() where user_id =?";

	public static String INSERT_USERS_PASSWORD_LOGS= " insert into password_log (user_id,change_password,created_date) values ( ?,?,now()) ";

	public static String Delete_SQL_Password = "delete from password_log where user_id= ?";

}