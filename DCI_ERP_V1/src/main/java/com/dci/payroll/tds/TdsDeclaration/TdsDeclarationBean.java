package com.dci.payroll.tds.TdsDeclaration;

public class TdsDeclarationBean {

	private int sk;
	private String employeeId;
	private String financialYearId;
	private String taxSectionCode;
	private String taxSubSectionCode;
	private String taxSubSectionDescription;
	private boolean declared;
	private boolean actual;
	private double limited;
	private double actualAmount;
	private String fileName;
	private double amount;
	private double declaredAmount;
	private String monthYear;
	private String companyId;
	private String employeeName;
	private String monthYearDisplay;
	private String filepathUrl;
	private String month;
	private String year;

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

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	private String branchId;
	private int departmentId;
	private int status;

	public int getSk() {
		return sk;
	}

	public void setSk(int sk) {
		this.sk = sk;
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

	public String getTaxSectionCode() {
		return taxSectionCode;
	}

	public void setTaxSectionCode(String taxSectionCode) {
		this.taxSectionCode = taxSectionCode;
	}

	public String getTaxSubSectionCode() {
		return taxSubSectionCode;
	}

	public void setTaxSubSectionCode(String taxSubSectionCode) {
		this.taxSubSectionCode = taxSubSectionCode;
	}

	public double getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(double actualAmount) {
		this.actualAmount = actualAmount;
	}

	public double getDeclaredAmount() {
		return declaredAmount;
	}

	public void setDeclaredAmount(double declaredAmount) {
		this.declaredAmount = declaredAmount;
	}

	public String getTaxSubSectionDescription() {
		return taxSubSectionDescription;
	}

	public void setTaxSubSectionDescription(String taxSubSectionDescription) {
		this.taxSubSectionDescription = taxSubSectionDescription;
	}

	public double getLimited() {
		return limited;
	}

	public void setLimited(double limited) {
		this.limited = limited;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMonthYearDisplay() {
		return monthYearDisplay;
	}

	public void setMonthYearDisplay(String monthYearDisplay) {
		this.monthYearDisplay = monthYearDisplay;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilepathUrl() {
		return filepathUrl;
	}

	public void setFilepathUrl(String filepathUrl) {
		this.filepathUrl = filepathUrl;
	}

	public boolean isDeclared() {
		return declared;
	}

	public void setDeclared(boolean declared) {
		this.declared = declared;
	}

	public boolean isActual() {
		return actual;
	}

	public void setActual(boolean actual) {
		this.actual = actual;
	}

}
