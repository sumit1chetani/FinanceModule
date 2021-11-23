package com.dci.payroll.payroll.payrollreport;

import java.util.List;

public class PayrollReportBean {
	private String employeeId;
	private String branchId;
	private String companyId;
	private Integer departmentId;
	private String payComponentId;
	private String monthYear;
	private String employeeName;
	private double amount;
	private double lopAmount;
	private double lopDays;
	private int payComponentType;
	private String epfno;
	private String uanno;
	private String accountCode;
	private String accountdebitCode;

	private List<String> listHeader;
	private Integer avail;
	private String dept;

	public Integer getAvail() {
		return avail;
	}

	public void setAvail(Integer avail) {
		this.avail = avail;
	}

	public List<String> getListHeader() {
		return listHeader;
	}

	public void setListHeader(List<String> listHeader) {
		this.listHeader = listHeader;
	}

	public String getAccountdebitCode() {
		return accountdebitCode;
	}

	public void setAccountdebitCode(String accountdebitCode) {
		this.accountdebitCode = accountdebitCode;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public double getLopDays() {
		return lopDays;
	}

	public void setLopDays(double lopDays) {
		this.lopDays = lopDays;
	}

	public String getEpfno() {
		return epfno;
	}

	public void setEpfno(String epfno) {
		this.epfno = epfno;
	}

	public String getUanno() {
		return uanno;
	}

	public void setUanno(String uanno) {
		this.uanno = uanno;
	}

	public double getLopAmount() {
		return lopAmount;
	}

	public void setLopAmount(double lopAmount) {
		this.lopAmount = lopAmount;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPayComponentId() {
		return payComponentId;
	}

	public void setPayComponentId(String payComponentId) {
		this.payComponentId = payComponentId;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPayComponentType() {
		return payComponentType;
	}

	public void setPayComponentType(int payComponentType) {
		this.payComponentType = payComponentType;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}