package com.dci.master.userAdminMaster;

import java.util.List;

import com.dci.common.util.CustomException;



//
public interface UserAdminMasterService {
	
	UserAdminMasterResultBean getCompanyList() throws Exception;

	UserAdminMasterResultBean getBranchList() throws Exception;

	UserAdminMasterResultBean getDepartmentList() throws Exception;

	UserAdminMasterResultBean getDesignationList() throws Exception;

	UserAdminMasterResultBean getEmployeeById(String empId)
			throws Exception;

	public List<UserAdminMasterBean> getEmployeeList(int limit, int offset,
			UserAdminMasterBean bean) throws Exception;

	UserAdminMasterResultBean insertEmployee(UserAdminMasterBean objEmp)
			throws Exception;

	boolean updateEmployee(UserAdminMasterBean objEmployeeMasterBean)
			throws Exception;

	boolean deleteEmployee(String empId) throws Exception;

	

	public UserAdminMasterResultBean viewEmployeeById(String empId)
			throws CustomException;

	List getBranch(String companyCode);
	
	
	public void insertFiles1(String employeeId,String  filename,String  path) ;


}
