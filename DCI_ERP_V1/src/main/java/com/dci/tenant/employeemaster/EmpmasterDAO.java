package com.dci.tenant.employeemaster;

import java.util.List;

import com.dci.common.util.CustomException;

public interface EmpmasterDAO {

	List<EmpmasterBean> getEmpmasterList(int limit, int offset) throws Exception;

	public EmpmasterResultBean getCompany();

	public EmpmasterResultBean getCompanyLocation();

	public EmpmasterResultBean getDepartment();

	public EmpmasterResultBean getDesignation();

	public boolean addEmpmaster(EmpmasterBean objEmpmasterBean) throws Exception;

	public boolean deleteEmpmaster(String empId) throws Exception;

	public boolean updateEmpmaster(EmpmasterBean objEmpmasterBean) throws Exception;

	public EmpmasterBean getempmasterValues(String empId) throws Exception;

	public List getEmployee();
	

	/**
	 * @param objEmpmasterBean
	 * @return
	 * @throws CustomException
	 */
	boolean updateUserProfile(EmpmasterBean objEmpmasterBean) throws CustomException;

	public EmpmasterResultBean updateUserPassword(EmpmasterBean objEmpmasterBean) throws CustomException;
	
	
}
