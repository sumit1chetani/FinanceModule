package com.dci.tenant.finance.BudgetReport;

import java.util.List;

public class BudgetReportBean {

	private int budget_allocation_id;
	private String company;
	private String financeyear;
	private String expense_type;
	private double misc_expenses;
	private double salaries;
	private double communication;
	private double travel_entertainment;
	private double prof_fees;
	private double maintanance;
	private double asset_purchase;
	private double supplier_payment;
	private String companyName;
	private String subGrpName;
	private String status;
	private String id;
	private String text;
	private String subGrpCode;
	private double amount;
	private List expenseColumns;
	private String companyCode;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getFinanceyear() {
		return financeyear;
	}

	public void setFinanceyear(String financeyear) {
		this.financeyear = financeyear;
	}

	public int getBudget_allocation_id() {
		return budget_allocation_id;
	}

	public void setBudget_allocation_id(int budget_allocation_id) {
		this.budget_allocation_id = budget_allocation_id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getExpense_type() {
		return expense_type;
	}

	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}

	public double getMisc_expenses() {
		return misc_expenses;
	}

	public void setMisc_expenses(double misc_expenses) {
		this.misc_expenses = misc_expenses;
	}

	public double getSalaries() {
		return salaries;
	}

	public void setSalaries(double salaries) {
		this.salaries = salaries;
	}

	public double getCommunication() {
		return communication;
	}

	public void setCommunication(double communication) {
		this.communication = communication;
	}

	public double getTravel_entertainment() {
		return travel_entertainment;
	}

	public void setTravel_entertainment(double travel_entertainment) {
		this.travel_entertainment = travel_entertainment;
	}

	public double getProf_fees() {
		return prof_fees;
	}

	public void setProf_fees(double prof_fees) {
		this.prof_fees = prof_fees;
	}

	public double getMaintanance() {
		return maintanance;
	}

	public void setMaintanance(double maintanance) {
		this.maintanance = maintanance;
	}

	public double getAsset_purchase() {
		return asset_purchase;
	}

	public void setAsset_purchase(double asset_purchase) {
		this.asset_purchase = asset_purchase;
	}

	public double getSupplier_payment() {
		return supplier_payment;
	}

	public void setSupplier_payment(double supplier_payment) {
		this.supplier_payment = supplier_payment;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSubGrpName() {
		return subGrpName;
	}

	public void setSubGrpName(String subGrpName) {
		this.subGrpName = subGrpName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getSubGrpCode() {
		return subGrpCode;
	}

	public void setSubGrpCode(String subGrpCode) {
		this.subGrpCode = subGrpCode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List getExpenseColumns() {
		return expenseColumns;
	}

	public void setExpenseColumns(List expenseColumns) {
		this.expenseColumns = expenseColumns;
	}

}
