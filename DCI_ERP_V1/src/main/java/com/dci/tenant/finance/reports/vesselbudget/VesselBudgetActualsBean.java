package com.dci.tenant.finance.reports.vesselbudget;

import java.util.List;

public class VesselBudgetActualsBean {
	private String vesselId;
	private String vesselCode;
	private String vesselName;
	private String fromDate;
	private String toDate;
	private String budgetCode;
	private String budgetDesc;
	private String departmentName;
	private String id;
	private String text;
	private double allocatedTotalAmount;
	private double allocatedAmount;
	private double invoiceLpoAmount;
	private double openingAmount;
	private double totalSpendAmount;
	private double pctAmount;
	private double balanceAmount;
	private String year;

	List<VesselBudgetActualsDtlBean> budgetActualsDtlBeanList;

	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
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

	public double getAllocatedTotalAmount() {
		return allocatedTotalAmount;
	}

	public void setAllocatedTotalAmount(double allocatedTotalAmount) {
		this.allocatedTotalAmount = allocatedTotalAmount;
	}

	public String getVesselId() {
		return vesselId;
	}

	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public List<VesselBudgetActualsDtlBean> getBudgetActualsDtlBeanList() {
		return budgetActualsDtlBeanList;
	}

	public void setBudgetActualsDtlBeanList(List<VesselBudgetActualsDtlBean> budgetActualsDtlBeanList) {
		this.budgetActualsDtlBeanList = budgetActualsDtlBeanList;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
