package com.dci.tenant.user.resetPassword;

public class ResetPasswordQueryUtil {
	public static String sResetPassword = " update employee_master set password=? where emp_id=? ";
	
	public static String EmpResetPassword = " update user_master set user_password=? where user_id=? ";


	public static String sGetUserId = " select count(emp_id) from employee_master where emp_id=? ";

	public static String UPDATE_USERS_PASSWORD_LOGS="update password_log set reset_password =?, modified_date=now() where user_id =?";

	public static String sGetUserCountLog = " select count(user_id) from password_log where user_id=? ";

	public static String INSERT_USERS_PASSWORD_LOGS= " insert into password_log (user_id,reset_password,created_date) values ( ?,?,now()) ";
}
