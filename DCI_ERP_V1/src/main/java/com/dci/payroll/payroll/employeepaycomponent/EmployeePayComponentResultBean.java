


package com.dci.payroll.payroll.employeepaycomponent;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dci.common.util.BasicResultBean;


public class EmployeePayComponentResultBean extends BasicResultBean implements Serializable {
	private List<EmployeePayComponentBean> empPayComList;
	private List<Map<String, Object>> employeeComponentList;
	private EmployeePayComponentBean empPayComBean = null;
	private EmployeePayComponentResultBean payrollExport;
	private String filePath;
	private boolean arrearExist;

	public boolean isArrearExist() {
		return arrearExist;
	}

	public void setArrearExist(boolean arrearExist) {
		this.arrearExist = arrearExist;
	}

	public EmployeePayComponentResultBean getPayrollExport() {
		return payrollExport;
	}

	public void setPayrollExport(EmployeePayComponentResultBean payrollExport) {
		this.payrollExport = payrollExport;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public List<EmployeePayComponentBean> getEmpPayComList() {
		return empPayComList;
	}

	public void setEmpPayComList(List<EmployeePayComponentBean> empPayComList) {
		this.empPayComList = empPayComList;
	}

	public EmployeePayComponentBean getEmpPayComBean() {
		return empPayComBean;
	}

	public void setEmpPayComBean(EmployeePayComponentBean empPayComBean) {
		this.empPayComBean = empPayComBean;
	}

	public List<Map<String, Object>> getEmployeeComponentList() {
		return employeeComponentList;
	}

	public void setEmployeeComponentList(List<Map<String, Object>> employeeComponentList) {
		this.employeeComponentList = employeeComponentList;
	}

}