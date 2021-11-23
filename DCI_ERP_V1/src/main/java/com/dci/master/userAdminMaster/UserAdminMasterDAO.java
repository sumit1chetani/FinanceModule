package com.dci.master.userAdminMaster;

import java.io.IOException;
import java.util.List;

import com.dci.common.util.CustomException;





public interface UserAdminMasterDAO {
	
	public UserAdminMasterResultBean getCompanyList()
			throws CustomException;

	public UserAdminMasterResultBean getBranchList() throws CustomException;

	// // department

	public UserAdminMasterResultBean getDepartmentList()
			throws CustomException;

	public UserAdminMasterResultBean getDesignationList()
			throws CustomException;

	public UserAdminMasterResultBean getEmployeeById(String empId)
			throws CustomException;

	public UserAdminMasterResultBean viewEmployeeById(String empId)
			throws CustomException;

	public List<UserAdminMasterBean> getEmployeeList(int limit, int offset,
			UserAdminMasterBean bean) throws CustomException;

	public UserAdminMasterResultBean insertEmployee(
			UserAdminMasterBean objEmployee) throws CustomException,
			IOException;

	public boolean updateEmployee(UserAdminMasterBean objEmployeeMasterBean)
			throws CustomException;

	public boolean deleteEmployee(String empId) throws CustomException;

	public List getBranch(String companyCode);
	
	public void insertFiles1(String employeeId,String  filename,String  path) ;

}
