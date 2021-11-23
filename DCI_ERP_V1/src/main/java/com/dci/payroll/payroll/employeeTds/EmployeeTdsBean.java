package com.dci.payroll.payroll.employeeTds;

public class EmployeeTdsBean {
	private String companyId;
	private String branchId;
	private Integer departmentId;
	private String employeeId;
	private String employeeName;
	private String errorMessage;
	private String successMessage;
	private String departmentName;
	private String branchName;
	private String monthYearValue;
	private String companyName;
	private String monthYear;
	private String month;
	private String year;
	private String monthValue;
	private double actualTds;
	private double estimatedTds;
	private boolean success;
	private String dept;

	private boolean isValid; // Button Change While Adding and Updating

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean getisValid() {
		return isValid;
	}

	public void setisValid(boolean isValid) {
		this.isValid = isValid;
	}

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

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getEstimatedTds() {
		return estimatedTds;
	}

	public void setEstimatedTds(double estimatedTds) {
		this.estimatedTds = estimatedTds;
	}

	public double getActualTds() {
		return actualTds;
	}

	public void setActualTds(double actualTds) {
		this.actualTds = actualTds;
	}

	public String getMonthYearValue() {
		return monthYearValue;
	}

	public void setMonthYearValue(String monthYearValue) {
		this.monthYearValue = monthYearValue;
	}

	public String getMonthValue() {
		return monthValue;
	}

	public void setMonthValue(String monthValue) {
		this.monthValue = monthValue;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}