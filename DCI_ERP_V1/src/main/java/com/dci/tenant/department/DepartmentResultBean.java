package com.dci.tenant.department;



import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class DepartmentResultBean extends BasicResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<DepartmentBean> lDepartmentBean;

	public List<DepartmentBean> getlDepartmentBean() {
		return lDepartmentBean;
	}

	public void setlDepartmentBean(List<DepartmentBean> lDepartmentBean) {
		this.lDepartmentBean = lDepartmentBean;
	}

	public List getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List employeeList) {
		this.employeeList = employeeList;
	}

	private List employeeList;

}

