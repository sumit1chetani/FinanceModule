package com.dci.payroll.tds.tds;

public class TdsBean {
	private String payComponentId;
	private String monthYear;
	private boolean declared;
	private boolean actual;
	private String financialYear;
	private String employeeId;
	private int rangeFrom;
	private int rangeTo;
	private double rateInPercentage;
	private double declaredAmount;
	private double limited;
	private String taxSubSectionCode;
	private String otherIncomeHeadId;
	private String otherIncomeHeadName;
	private double amount;
	private int count;

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

	public int getRangeFrom() {
		return rangeFrom;
	}

	public void setRangeFrom(int rangeFrom) {
		this.rangeFrom = rangeFrom;
	}

	public int getRangeTo() {
		return rangeTo;
	}

	public void setRangeTo(int rangeTo) {
		this.rangeTo = rangeTo;
	}

	public double getRateInPercentage() {
		return rateInPercentage;
	}

	public void setRateInPercentage(double rateInPercentage) {
		this.rateInPercentage = rateInPercentage;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public double getDeclaredAmount() {
		return declaredAmount;
	}

	public void setDeclaredAmount(double declaredAmount) {
		this.declaredAmount = declaredAmount;
	}

	public double getLimited() {
		return limited;
	}

	public void setLimited(double limited) {
		this.limited = limited;
	}

	public String getTaxSubSectionCode() {
		return taxSubSectionCode;
	}

	public void setTaxSubSectionCode(String taxSubSectionCode) {
		this.taxSubSectionCode = taxSubSectionCode;
	}

	public String getOtherIncomeHeadId() {
		return otherIncomeHeadId;
	}

	public void setOtherIncomeHeadId(String otherIncomeHeadId) {
		this.otherIncomeHeadId = otherIncomeHeadId;
	}

	public String getOtherIncomeHeadName() {
		return otherIncomeHeadName;
	}

	public void setOtherIncomeHeadName(String otherIncomeHeadName) {
		this.otherIncomeHeadName = otherIncomeHeadName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isActual() {
		return actual;
	}

	public void setActual(boolean actual) {
		this.actual = actual;
	}

	public boolean isDeclared() {
		return declared;
	}

	public void setDeclared(boolean declared) {
		this.declared = declared;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}