package com.dci.master.userAdminMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;



//
@Service
public class UserAdminMasterServiceImpl implements
		UserAdminMasterService {
	@Autowired
	UserAdminMasterDAO employeeMasterDAO;

	@Override
	public List<UserAdminMasterBean> getEmployeeList(int limit, int offset,
			UserAdminMasterBean bean) throws Exception {

		return employeeMasterDAO.getEmployeeList(limit, offset, bean);
	}

	@Override
	public UserAdminMasterResultBean getEmployeeById(String empId)
			throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getEmployeeById(empId);
	}

	@Override
	public UserAdminMasterResultBean insertEmployee(
			UserAdminMasterBean objEmployee) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.insertEmployee(objEmployee);
	}

	@Override
	public boolean updateEmployee(UserAdminMasterBean objEmployeeMasterBean)
			throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.updateEmployee(objEmployeeMasterBean);
	}

	@Override
	public boolean deleteEmployee(String empId) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.deleteEmployee(empId);
	}

	@Override
	public UserAdminMasterResultBean getCompanyList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getCompanyList();
	}

	@Override
	public UserAdminMasterResultBean getBranchList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getBranchList();
	}

	// department

	@Override
	public UserAdminMasterResultBean getDepartmentList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getDepartmentList();
	}

	@Override
	public UserAdminMasterResultBean getDesignationList() throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getDesignationList();
	}

	@Override
	public UserAdminMasterResultBean viewEmployeeById(String empId)
			throws CustomException {
		// TODO Auto-generated method stub
		return employeeMasterDAO.viewEmployeeById(empId);
	}

	@Override
	public List getBranch(String companyCode) {
		// TODO Auto-generated method stub
		return employeeMasterDAO.getBranch(companyCode);
	}

	@Override
	public void insertFiles1(String employeeId,String filename, String path) {
		employeeMasterDAO.insertFiles1(employeeId,filename,path);
		
	}
}
