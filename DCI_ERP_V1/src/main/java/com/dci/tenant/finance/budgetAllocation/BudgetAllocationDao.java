package com.dci.tenant.finance.budgetAllocation;

import java.util.List;

public interface BudgetAllocationDao {

	List<BudgetAllocationBean> getCompanyList(String userId);

	List<BudgetAllocationBean> getFinancialYearList(String company);

	boolean save(BudgetAllocationBean allocationBean);

	List<BudgetAllocationBean> allocationList();

	BudgetAllocationBean allocationEdit(String allocationId);

	boolean update(BudgetAllocationBean allocationBean);

	boolean approve(BudgetAllocationBean allocationBean);

	boolean getAvailablity(BudgetAllocationBean allocationBean);

	boolean delete(String budgetId);

	List<String> getDynamicColumns(String type);

	List<BudgetAllocationBean> getFinYearbudget();

	List<BudgetAllocationBean> getTdsType();

	List<BudgetAllocationBean> getVendorList();

	List<BudgetAllocationBean> getaccontnameTds();

}
