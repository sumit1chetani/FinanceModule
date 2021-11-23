package com.dci.payroll.tds.otherheadentry;

public class OtherHeadEntryBean {
	private String otherIncomeHeadId;
	private String otherIncomeHeadName;
	private String employeeId;
	private String financialYearId;
	private double amount;
	private boolean isEdit; // Button Change While Adding and Updating

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getOtherIncomeHeadName() {
		return otherIncomeHeadName;
	}

	public void setOtherIncomeHeadName(String otherIncomeHeadName) {
		this.otherIncomeHeadName = otherIncomeHeadName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFinancialYearId() {
		return financialYearId;
	}

	public void setFinancialYearId(String financialYearId) {
		this.financialYearId = financialYearId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getOtherIncomeHeadId() {
		return otherIncomeHeadId;
	}

	public void setOtherIncomeHeadId(String otherIncomeHeadId) {
		this.otherIncomeHeadId = otherIncomeHeadId;
	}

}