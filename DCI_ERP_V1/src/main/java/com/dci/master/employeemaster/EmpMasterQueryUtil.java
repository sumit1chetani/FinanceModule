package com.dci.master.employeemaster;

public class EmpMasterQueryUtil {
	
public static final String list ="select emp_id as emp_id,probationfrom as probationfrom,contact_no as contact_no,probation_to as probation_to,emp_name as emp_name,email as email,dt_of_birth as dt_of_birth,dt_of_join as dt_of_join,dt_of_confirm as dt_of_confirm,dt_of_leave as dt_of_leave,birth_identity as birth_identity,is_agent as agent,"
		+ "is_active as active, passport_no as passport_no,department as department,company_code as company,place_issue as place_issue,designation as designation,blood_group as blood_group,address as address,basic_pay as basic_pay, mode_payment as mode_payment, port as port,emp_password as password,ag as agentName from employee_master";
	
	public static final String INSERT= "insert into employee_master (emp_id,probationfrom,contact_no,emp_name,probation_to,email,dt_of_birth,birth_identity,"
			+ "emp_password,passport_no,dt_of_join,company_code,place_issue,designation,blood_group,address,"
			+ "department,basic_pay,dt_of_confirm,mode_payment,dt_of_leave,is_agent,is_active,ag,port) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

public static final String delete="delete from employee_master where emp_id=?";
	
	public static final String GET_MASTER="select emp_id as emp_id,probationfrom as probationfrom,contact_no as contact_no,probation_to as probation_to,emp_name as emp_name,email as email,dt_of_birth as dt_of_birth,dt_of_join as dt_of_join,dt_of_confirm as dt_of_confirm,dt_of_leave as dt_of_leave,birth_identity as birth_identity,is_agent as agent,"
			+ "is_active as active, passport_no as passport_no, department as department,company_code as company,place_issue as place_issue,designation as designation,blood_group as blood_group,address as address,basic_pay as basic_pay, mode_payment as mode_payment, port as port,ag as agentName from employee_master where emp_id=?";
	
	public static final String UPDATE = "update employee_master set probationfrom=?,contact_no=?,emp_name=?,probation_to=?,email=?,"
			+ "dt_of_birth=?,birth_identity=?,passport_no=?,dt_of_join=?,company_code=?,"
			+ "place_issue=?,designation=?,blood_group=?,address=?,department=?,basic_pay=?,"
			+ "dt_of_confirm=?,mode_payment=?,dt_of_leave=?,is_agent=?,is_active=?,ag=?,port=? where emp_id=?";

	
	public static final String  Last_seq_no=" select 'AE' || lpad( (coalesce(max( substring(emp_id,4)::int),0)+1)::text,4,'0') from employee_master";

	public static final String  Deplist=" select distinct  department_code as id ,CONCAT(department_code , '-' ,department_name) as text  from department_master";

	public static final String  Deslist=" select distinct  designation_code as id ,CONCAT(designation_code , '-' ,designation_name) as text  from designation_master";

	public static final String  Cmplist=" select distinct company_code as id ,CONCAT(company_code , '-' ,company_name) as text  from company_master";

	public static final String Prtlist = "select distinct portcode as id, CONCAT(portcode, '-' ,portname) as text  from port_master ";

	public static final String  Agentlist= "select distinct vendor_code as id, CONCAT(vendor_code, '-' ,vendor_name) as text  from vendor_master";

	
	
	public static String getOldpswrd = "select password as pswd from employee_master where emp_id  = ?";

	public static String SUpdatePassword = "update employee_master set PASSWORD=? , MODIFIED_BY =?,MODIFIED_DT=NOW(),CH_PASSWORD_DT=NOW()  where emp_id = ?";

	public static String USERS_PASSWORD_LOGS="insert into password_log(user_id,user_password,created_date) values (?,?,now())";

	
	public static String UPDATE_USERS_PASSWORD_LOGS="update password_log set change_password =?, modified_date=now() where user_id =?";

}


