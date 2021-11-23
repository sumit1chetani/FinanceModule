package com.dci.payroll.payroll.loanrepayment;

public class LoanRepaymentBean {
	private int loanId;
	private String monthYear;
	private double amount;
	private String loanTypeId;
	private String loanTypeName;
	private String employeeId;
	private String employeeName;
	private double deductionAmount;
	private String month;
	private String year;
	private Integer currentEmiNo;
	private Integer totalEmi;
	private boolean checkbox;
	private String loantypeName;
	private Integer installment;
	private double loanAmount;
	private double deductAmount;
	private String deductFrom;

	public double getDeductAmount() {
		return deductAmount;
	}

	public void setDeductAmount(double deductAmount) {
		this.deductAmount = deductAmount;
	}

	public String getDeductFrom() {
		return deductFrom;
	}

	public void setDeductFrom(String deductFrom) {
		this.deductFrom = deductFrom;
	}

	public String getLoantypeName() {
		return loantypeName;
	}

	public void setLoantypeName(String loantypeName) {
		this.loantypeName = loantypeName;
	}

	public Integer getInstallment() {
		return installment;
	}

	public void setInstallment(Integer installment) {
		this.installment = installment;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
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

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(String loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getLoanTypeName() {
		return loanTypeName;
	}

	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
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

	public double getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(double deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public Integer getCurrentEmiNo() {
		return currentEmiNo;
	}

	public void setCurrentEmiNo(Integer currentEmiNo) {
		this.currentEmiNo = currentEmiNo;
	}

	public Integer getTotalEmi() {
		return totalEmi;
	}

	public void setTotalEmi(Integer totalEmi) {
		this.totalEmi = totalEmi;
	}

	public boolean isCheckbox() {
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
}