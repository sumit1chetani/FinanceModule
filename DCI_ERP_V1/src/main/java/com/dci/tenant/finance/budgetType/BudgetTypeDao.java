package com.dci.tenant.finance.budgetType;

import java.util.List;

public interface BudgetTypeDao {

	List<BudgetTypeBean> getExpenseAccountsList(String userId);

	boolean save(BudgetTypeBean allocationBean);

	List<BudgetTypeBean> budgetTypeList();

	BudgetTypeBean budgetTypeEdit(String allocationId);

	boolean update(BudgetTypeBean allocationBean);

	boolean delete(String budgetId);

}
