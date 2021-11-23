package com.dci.truck.staffMaster;

public class StaffQueryUtil {

	public static final String getemployeelist = " SELECT emp_id as id , CONCAT(emp_id, '-', emp_name) AS text FROM employee_master where emp_id not in ( select trms_emp_code from staff_vendor_mapping) ";

	public static final String save = " insert into  staff_vendor_mapping (iahs_emp_code,trms_emp_code) Values(?,?) ";

	public static final String DELETE_Staff = "delete from staff_vendor_mapping where iahs_emp_code =?";

	public static final String Staff_count = "select count(*) from staff_vendor_mapping where iahs_emp_code =?";

	public static String list="select iahs_emp_code as iahsempcode, CONCAT(em.emp_id, '-',emp_name) as trmsempcode "
                                +" from staff_vendor_mapping svm "
                                 +" left join  employee_master em on  em.emp_id=svm.trms_emp_code order by iahsempcode desc";

	

}
