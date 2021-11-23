package com.dci.payroll.tds.employeeTaxParameter;

public class EmployeeTaxParameterBean {
	private String employeeId;
	private String companyId;
	private String branchId;
	private String companyName;
	private Integer departmentId;
	private boolean livingInMetro;
	private boolean selfOccupiedHouse;
	private String gender;
	private Integer taxPayerTypeId;
	private String taxPayerTypeName;
	private Integer phType;
	private String branchName;
	private String departmentName;
	private String employeeName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isLivingInMetro() {
		return livingInMetro;
	}

	public void setLivingInMetro(boolean livingInMetro) {
		this.livingInMetro = livingInMetro;
	}

	public boolean isSelfOccupiedHouse() {
		return selfOccupiedHouse;
	}

	public void setSelfOccupiedHouse(boolean selfOccupiedHouse) {
		this.selfOccupiedHouse = selfOccupiedHouse;
	}

	public String getTaxPayerTypeName() {
		return taxPayerTypeName;
	}

	public void setTaxPayerTypeName(String taxPayerTypeName) {
		this.taxPayerTypeName = taxPayerTypeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Integer getTaxPayerTypeId() {
		return taxPayerTypeId;
	}

	public void setTaxPayerTypeId(Integer taxPayerTypeId) {
		this.taxPayerTypeId = taxPayerTypeId;
	}

	public Integer getPhType() {
		return phType;
	}

	public void setPhType(Integer phType) {
		this.phType = phType;
	}

}