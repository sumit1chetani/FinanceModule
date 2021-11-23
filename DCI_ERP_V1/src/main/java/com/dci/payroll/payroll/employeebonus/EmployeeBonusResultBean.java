package com.dci.payroll.payroll.employeebonus;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class EmployeeBonusResultBean extends BasicResultBean implements Serializable {
	private List<EmployeeBonusBean> employeeBonusList = null;
	private List<EmployeeBonusBean> employeeBonusSummaryList = null;
	private EmployeeBonusBean employeeBonusBean = null;

	public List<EmployeeBonusBean> getEmployeeBonusList() {
		return employeeBonusList;
	}

	public void setEmployeeBonusList(List<EmployeeBonusBean> employeeBonusList) {
		this.employeeBonusList = employeeBonusList;
	}

	public EmployeeBonusBean getEmployeeBonusBean() {
		return employeeBonusBean;
	}

	public void setEmployeeBonusBean(EmployeeBonusBean employeeBonusBean) {
		this.employeeBonusBean = employeeBonusBean;
	}

	public List<EmployeeBonusBean> getEmployeeBonusSummaryList() {
		return employeeBonusSummaryList;
	}

	public void setEmployeeBonusSummaryList(List<EmployeeBonusBean> employeeBonusSummaryList) {
		this.employeeBonusSummaryList = employeeBonusSummaryList;
	}
}