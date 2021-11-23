package com.dci.payroll.tds.professionaltaxslab;

import java.math.BigDecimal;

public class ProfessionalTaxSlabBean {
	private Integer serialNumber;
	private String branchId;
	private BigDecimal rangeFrom;
	private BigDecimal rangeTo;
	private BigDecimal charge;
	private String branchName;
	private String companyName;
	private String id;
	private String text;
	private String companyId;
	private int departmentId;
	private String financialYear;
	private boolean isAuthorize;
	private double days;
	private String employeeId;
	private String employeeName;
	private String monthValue;
	private String monthYear;
	private String month;
	private String year;
	private double amount;
	private double nextslabAmount;
	private String errorMessage;
	private String typeId;
	private String dept;

	private boolean isValid; // Button Change While Adding and Updating

	public boolean getisValid() {
		return isValid;
	}

	public void setisValid(boolean isValid) {
		this.isValid = isValid;
	}

	private boolean isEdit; // Button Change While Adding and Updating

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisAuthorize(boolean isAuthorize) {
		this.isAuthorize = isAuthorize;
	}

	public boolean getisAuthorize() {
		return isAuthorize;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public BigDecimal getRangeFrom() {
		return rangeFrom;
	}

	public void setRangeFrom(BigDecimal rangeFrom) {
		this.rangeFrom = rangeFrom;
	}

	public BigDecimal getRangeTo() {
		return rangeTo;
	}

	public void setRangeTo(BigDecimal rangeTo) {
		this.rangeTo = rangeTo;
	}

	public BigDecimal getCharge() {
		return charge;
	}

	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getMonthValue() {
		return monthValue;
	}

	public void setMonthValue(String monthValue) {
		this.monthValue = monthValue;
	}

	public double getDays() {
		return days;
	}

	public void setDays(double days) {
		this.days = days;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getNextslabAmount() {
		return nextslabAmount;
	}

	public void setNextslabAmount(double nextslabAmount) {
		this.nextslabAmount = nextslabAmount;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
}