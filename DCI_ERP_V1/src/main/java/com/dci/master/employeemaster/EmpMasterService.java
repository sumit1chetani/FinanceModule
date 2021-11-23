package com.dci.master.employeemaster;
import java.util.List;

import com.dci.common.util.CustomException;

public interface EmpMasterService {
	
	public List<EmpMasterBean> MasterList();
	public EmpMasterBean insert(EmpMasterBean master) throws Exception;
public boolean deleteMaster(String emp_id);
	
	public EmpMasterBean getEdit(String emp_id);

	public EmpMasterBean update(EmpMasterBean master) throws Exception;

	public List<EmpMasterBean> getDropDown();
	public List<EmpMasterBean> dropdown();
	public List<EmpMasterBean> drop();
	public List<EmpMasterBean> port();
	public List<EmpMasterBean> agent();
	
	public EmpMasterBean updateUserPassword(EmpMasterBean objEmpmasterBean) throws CustomException;

	public EmpMasterBean getempmasterValues(String emp_id) throws Exception;
	
	boolean updateUserProfile(EmpMasterBean objEmpmasterBean) throws CustomException;






}
