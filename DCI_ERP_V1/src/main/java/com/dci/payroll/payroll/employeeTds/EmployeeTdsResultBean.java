package com.dci.payroll.payroll.employeeTds;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class EmployeeTdsResultBean extends BasicResultBean implements Serializable {
	private List<EmployeeTdsBean> emptdsList;
	private EmployeeTdsBean eTdsBean = null;

	public List<EmployeeTdsBean> getEmptdsList() {
		return emptdsList;
	}

	public void setEmptdsList(List<EmployeeTdsBean> emptdsList) {
		this.emptdsList = emptdsList;
	}

	public EmployeeTdsBean geteTdsBean() {
		return eTdsBean;
	}

	public void seteTdsBean(EmployeeTdsBean eTdsBean) {
		this.eTdsBean = eTdsBean;
	}

}