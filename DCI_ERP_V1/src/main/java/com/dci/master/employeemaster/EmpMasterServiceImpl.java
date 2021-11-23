package com.dci.master.employeemaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
 
@Service
public class EmpMasterServiceImpl implements EmpMasterService{
	
	
	@Autowired
	EmpMasterDAO masterDAO;
	@Override
	public List<EmpMasterBean> MasterList() {
		
		return masterDAO.MasterList();
	}
	
	@Override
	public EmpMasterBean insert(EmpMasterBean master) throws Exception {
		// TODO Auto-generated method stub
		return masterDAO.insert(master);
	}
	
	@Override
	public boolean deleteMaster(String emp_id) {
		return masterDAO.deleteMaster(emp_id);
	}

	@Override
	public EmpMasterBean getEdit(String emp_id) {
		return masterDAO.getEdit(emp_id);
	}

	@Override
	public EmpMasterBean update(EmpMasterBean master) throws Exception {
		// TODO Auto-generated method stub
		return masterDAO.update(master);
	}
	
	@Override
	public List<EmpMasterBean> getDropDown() {
		
		return masterDAO.getDropDown();
	}
	
	@Override
	public List<EmpMasterBean> dropdown() {
		
		return masterDAO.dropdown();
	}
	
	@Override
	public List<EmpMasterBean> drop() {
		
		return masterDAO.drop();
	}
	@Override
	public List<EmpMasterBean> port() {
		
		return masterDAO.port();
	}
	@Override
	public List<EmpMasterBean> agent() {
		
		return masterDAO.agent();
	}

	@Override
	public EmpMasterBean updateUserPassword(EmpMasterBean objEmpmasterBean) throws CustomException {
		// TODO Auto-generated method stub
		return masterDAO.updateUserPassword(objEmpmasterBean);
	}

	@Override
	public EmpMasterBean getempmasterValues(String emp_id) throws Exception {
		// TODO Auto-generated method stub
		return masterDAO.getempmasterValues(emp_id);
	}

	@Override
	public boolean updateUserProfile(EmpMasterBean objEmpmasterBean) throws CustomException {
		// TODO Auto-generated method stub
		return masterDAO.updateUserProfile(objEmpmasterBean);
	}
	
	

}
