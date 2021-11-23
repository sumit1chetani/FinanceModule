package com.dci.tenant.finance.budgetDefinition;

public class BudgetDefinition {

	private String company;
	private String companyName;
	private int budgetType;
	private String budgetTypeName;
	private String financial_year;
	private String financial_year_code;
	private String capexno;
	private String projectName;
	private Integer budgetDefinitionId;
	private String createdDate;
	private boolean isSuccess = false;
	private String flag;
	private double amount;
	private String costCenter;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(int budgetType) {
		this.budgetType = budgetType;
	}

	public String getBudgetTypeName() {
		return budgetTypeName;
	}

	public void setBudgetTypeName(String budgetTypeName) {
		this.budgetTypeName = budgetTypeName;
	}

	public String getFinancial_year() {
		return financial_year;
	}

	public void setFinancial_year(String financial_year) {
		this.financial_year = financial_year;
	}

	public String getFinancial_year_code() {
		return financial_year_code;
	}

	public void setFinancial_year_code(String financial_year_code) {
		this.financial_year_code = financial_year_code;
	}

	public String getCapexno() {
		return capexno;
	}

	public void setCapexno(String capexno) {
		this.capexno = capexno;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getBudgetDefinitionId() {
		return budgetDefinitionId;
	}

	public void setBudgetDefinitionId(Integer budgetDefinitionId) {
		this.budgetDefinitionId = budgetDefinitionId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
