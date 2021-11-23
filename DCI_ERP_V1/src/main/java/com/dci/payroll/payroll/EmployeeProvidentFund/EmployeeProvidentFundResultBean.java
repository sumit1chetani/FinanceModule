package com.dci.payroll.payroll.EmployeeProvidentFund;

import java.util.List;

public class EmployeeProvidentFundResultBean {
	private List<EmployeeProvidentFundBean> employeeProvidentFundBeanList;
	private List<EmployeeProvidentFundBean> employeeProvidentFundList;
	private List<EmployeeProvidentFundBean> emplsample;

	private List<EmployeeProvidentFundBean> basiclist;

	private boolean isSuccess;

	public List<EmployeeProvidentFundBean> getEmployeeProvidentFundBeanList() {
		return employeeProvidentFundBeanList;
	}

	public void setEmployeeProvidentFundBeanList(List<EmployeeProvidentFundBean> employeeProvidentFundBeanList) {
		this.employeeProvidentFundBeanList = employeeProvidentFundBeanList;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public List<EmployeeProvidentFundBean> getEmployeeProvidentFundList() {
		return employeeProvidentFundList;
	}

	public void setEmployeeProvidentFundList(List<EmployeeProvidentFundBean> employeeProvidentFundList) {
		this.employeeProvidentFundList = employeeProvidentFundList;
	}

	public List<EmployeeProvidentFundBean> getEmplsample() {
		return emplsample;
	}

	public void setEmplsample(List<EmployeeProvidentFundBean> emplsample) {
		this.emplsample = emplsample;
	}

	public List<EmployeeProvidentFundBean> getBasiclist() {
		return basiclist;
	}

	public void setBasiclist(List<EmployeeProvidentFundBean> basiclist) {
		this.basiclist = basiclist;
	}

}
