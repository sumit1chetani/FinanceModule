package com.dci.payroll.payroll.employeelop;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class EmployeeLopResultBean extends BasicResultBean implements Serializable {
	private List<EmployeeLopBean> empLopList;
	private EmployeeLopBean empLopBean = null;

	public List<EmployeeLopBean> getEmpLopList() {
		return empLopList;
	}

	public void setEmpLopList(List<EmployeeLopBean> empLopList) {
		this.empLopList = empLopList;
	}

	public EmployeeLopBean getEmpLopBean() {
		return empLopBean;
	}

	public void setEmpLopBean(EmployeeLopBean empLopBean) {
		this.empLopBean = empLopBean;
	}
}