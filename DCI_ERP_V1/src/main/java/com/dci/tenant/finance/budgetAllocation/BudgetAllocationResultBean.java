package com.dci.tenant.finance.budgetAllocation;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class BudgetAllocationResultBean extends BasicResultBean implements Serializable {

	private List<BudgetAllocationBean> lBudgetAllocationBean;
	private List<BudgetAllocationBean> companyList;
	private List<BudgetAllocationBean> finYearList;
	private List<String> columnList;
	private BudgetAllocationBean budgetAllocationBean;
	private List<BudgetAllocationBean> tdsList;
	private List<BudgetAllocationBean> vendorList;

	public List<BudgetAllocationBean> getVendorList() {
		return vendorList;
	}

	public void setVendorList(List<BudgetAllocationBean> vendorList) {
		this.vendorList = vendorList;
	}

	public List<BudgetAllocationBean> getTdsList() {
		return tdsList;
	}

	public void setTdsList(List<BudgetAllocationBean> tdsList) {
		this.tdsList = tdsList;
	}

	public List<BudgetAllocationBean> getlBudgetAllocationBean() {
		return lBudgetAllocationBean;
	}

	public void setlBudgetAllocationBean(List<BudgetAllocationBean> lBudgetAllocationBean) {
		this.lBudgetAllocationBean = lBudgetAllocationBean;
	}

	public List<BudgetAllocationBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<BudgetAllocationBean> companyList) {
		this.companyList = companyList;
	}

	public List<BudgetAllocationBean> getFinYearList() {
		return finYearList;
	}

	public void setFinYearList(List<BudgetAllocationBean> finYearList) {
		this.finYearList = finYearList;
	}

	public BudgetAllocationBean getBudgetAllocationBean() {
		return budgetAllocationBean;
	}

	public void setBudgetAllocationBean(BudgetAllocationBean budgetAllocationBean) {
		this.budgetAllocationBean = budgetAllocationBean;
	}

	public List<String> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}

}
