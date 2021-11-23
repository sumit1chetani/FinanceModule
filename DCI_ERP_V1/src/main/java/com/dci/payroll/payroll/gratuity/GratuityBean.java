package com.dci.payroll.payroll.gratuity;

public class GratuityBean {
	private String employeeId;
	private String employeeName;
	private String departmentName;
	private String branchName;
	private String companyName;
	private double grossSalary;
	private double basicPay;
	private double currentSalary;
	private int yearOfService;
	private double gratuityAmount;
	private String periodFrom;
	private String periodTo;
	private String comments;
	private String createdBy;
	private String createdDate;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	public double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public int getYearOfService() {
		return yearOfService;
	}

	public void setYearOfService(int yearOfService) {
		this.yearOfService = yearOfService;
	}

	public double getGratuityAmount() {
		return gratuityAmount;
	}

	public void setGratuityAmount(double gratuityAmount) {
		this.gratuityAmount = gratuityAmount;
	}

	public String getPeriodFrom() {
		return periodFrom;
	}

	public void setPeriodFrom(String periodFrom) {
		this.periodFrom = periodFrom;
	}

	public String getPeriodTo() {
		return periodTo;
	}

	public void setPeriodTo(String periodTo) {
		this.periodTo = periodTo;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
