package com.dci.tenant.department;


import java.util.List;

public interface DepartmentDAO {

	List<DepartmentBean> getDepartmentList(int limit, int offset) throws Exception;

	public DepartmentResultBean getEmployee();

	public boolean addDepartment(DepartmentBean objDepartmentBean) throws Exception;

	public boolean updateDepartment(DepartmentBean objDepartmentBean) throws Exception;

	public boolean deleteDepartment(String dCode) throws Exception;

	public List getDepartment();

	public DepartmentBean getdepartmentValues(String deptCode) throws Exception;

}					