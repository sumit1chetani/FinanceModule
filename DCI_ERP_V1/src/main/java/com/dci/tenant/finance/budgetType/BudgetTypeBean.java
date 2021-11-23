package com.dci.tenant.finance.budgetType;

import java.util.ArrayList;

public class BudgetTypeBean {

	private int budget_type_id;
	private String budget_type;
	private Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	private String expenses;
	private String id;
	private String text;
	private ArrayList<String> expCodes;

	public ArrayList<String> getExpCodes() {
		return expCodes;
	}

	public void setExpCodes(ArrayList<String> expCodes) {
		this.expCodes = expCodes;
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

	public int getBudget_type_id() {
		return budget_type_id;
	}

	public void setBudget_type_id(int budget_type_id) {
		this.budget_type_id = budget_type_id;
	}

	public String getBudget_type() {
		return budget_type;
	}

	public void setBudget_type(String budget_type) {
		this.budget_type = budget_type;
	}

	public String getExpenses() {
		return expenses;
	}

	public void setExpenses(String expenses) {
		this.expenses = expenses;
	}

}
