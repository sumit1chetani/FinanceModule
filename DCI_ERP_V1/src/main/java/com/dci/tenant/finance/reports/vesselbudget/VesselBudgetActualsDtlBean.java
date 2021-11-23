package com.dci.tenant.finance.reports.vesselbudget;

public class VesselBudgetActualsDtlBean {
	private String terms;
	private double allocatedAmount;
	private double invoiceLpoAmount;
	private double openingAmount;
	private double totalSpendAmount;
	private double pctAmount;
	private double balanceAmount;
	private String budgetCode;
	private String budgetDesc;
	private String departmentName;

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public double getAllocatedAmount() {
		return allocatedAmount;
	}

	public void setAllocatedAmount(double allocatedAmount) {
		this.allocatedAmount = allocatedAmount;
	}

	public double getInvoiceLpoAmount() {
		return invoiceLpoAmount;
	}

	public void setInvoiceLpoAmount(double invoiceLpoAmount) {
		this.invoiceLpoAmount = invoiceLpoAmount;
	}

	public double getOpeningAmount() {
		return openingAmount;
	}

	public void setOpeningAmount(double openingAmount) {
		this.openingAmount = openingAmount;
	}

	public double getTotalSpendAmount() {
		return totalSpendAmount;
	}

	public void setTotalSpendAmount(double totalSpendAmount) {
		this.totalSpendAmount = totalSpendAmount;
	}

	public double getPctAmount() {
		return pctAmount;
	}

	public void setPctAmount(double pctAmount) {
		this.pctAmount = pctAmount;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getBudgetCode() {
		return budgetCode;
	}

	public void setBudgetCode(String budgetCode) {
		this.budgetCode = budgetCode;
	}

	public String getBudgetDesc() {
		return budgetDesc;
	}

	public void setBudgetDesc(String budgetDesc) {
		this.budgetDesc = budgetDesc;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
