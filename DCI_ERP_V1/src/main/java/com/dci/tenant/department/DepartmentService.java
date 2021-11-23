package com.dci.tenant.department;



import java.util.List;

public interface DepartmentService {

	List<DepartmentBean> getDepartmentList(int limit, int offset) throws Exception;

	public DepartmentResultBean getEmployee();

	public boolean addDepartment(DepartmentBean objDepartmentBean) throws Exception;

	public boolean updateDepartment(DepartmentBean objDepartmentBean) throws Exception;

	public boolean deleteDepartment(String dCode) throws Exception;

	public DepartmentBean getdepartmentValues(String deptCode) throws Exception;

	public List getDepartment();

}
