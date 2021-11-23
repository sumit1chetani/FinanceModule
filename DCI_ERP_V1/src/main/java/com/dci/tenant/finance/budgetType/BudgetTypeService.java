package com.dci.tenant.finance.budgetType;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BudgetTypeService {

	boolean save(BudgetTypeBean allocationBean);

	List<BudgetTypeBean> budgetTypeList();

	BudgetTypeBean budgetTypeEdit(String allocationId);

	boolean update(BudgetTypeBean allocationBean);

	boolean delete(String budgetId);

	List<BudgetTypeBean> getExpenseAccountsList(String userId);

}
