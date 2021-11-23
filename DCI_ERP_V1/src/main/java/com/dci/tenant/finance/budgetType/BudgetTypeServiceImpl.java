package com.dci.tenant.finance.budgetType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetTypeServiceImpl implements BudgetTypeService {

	@Autowired
	BudgetTypeDao budgetAllocationDao;

	@Override
	public List<BudgetTypeBean> getExpenseAccountsList(String userId) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.getExpenseAccountsList(userId);
	}

	@Override
	public boolean save(BudgetTypeBean allocationBean) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.save(allocationBean);
	}

	@Override
	public List<BudgetTypeBean> budgetTypeList() {
		// TODO Auto-generated method stub
		return budgetAllocationDao.budgetTypeList();
	}

	@Override
	public BudgetTypeBean budgetTypeEdit(String allocationId) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.budgetTypeEdit(allocationId);
	}

	@Override
	public boolean update(BudgetTypeBean allocationBean) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.update(allocationBean);
	}

	@Override
	public boolean delete(String budgetId) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.delete(budgetId);
	}

}
