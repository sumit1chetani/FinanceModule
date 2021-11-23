package com.dci.tenant.finance.budgetDefinition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dci.common.model.SelectivityBean;

@Component
public class BudgetDefinitionServiceImpl implements BudgetDefinitionService {

	@Autowired
	BudgetDefinitionDao BudgetDefinitionDao;

	@Override
	public boolean saveBudgetDefinition(BudgetDefinition BudgetDefinition) {
		// TODO Auto-generated method stub
		return BudgetDefinitionDao.saveBudgetDefinition(BudgetDefinition);
	}

	@Override
	public List<BudgetDefinition> getBudgetDefinition() {
		// TODO Auto-generated method stub
		return BudgetDefinitionDao.getBudgetDefinition();
	}

	@Override
	public boolean updateBudgetDefinition(BudgetDefinition BudgetDefinition) {
		// TODO Auto-generated method stub
		return BudgetDefinitionDao.updateBudgetDefinition(BudgetDefinition);
	}

	@Override
	public BudgetDefinition editBudgetDefinition(Integer budgetDefinitionId) {
		// TODO Auto-generated method stub
		return BudgetDefinitionDao.editBudgetDefinition(budgetDefinitionId);
	}

	@Override
	public boolean delete(Integer budgetDefinitionId) {
		// TODO Auto-generated method stub
		return BudgetDefinitionDao.delete(budgetDefinitionId);
	}

	@Override
	public List<SelectivityBean> getBudgetTypeList() {
		// TODO Auto-generated method stub
		return BudgetDefinitionDao.getBudgetTypeList();
	}

	@Override
	public boolean approveBudgetDefinition(BudgetDefinition BudgetDefinition) {
		// TODO Auto-generated method stub
		return BudgetDefinitionDao.approveBudgetDefinition(BudgetDefinition);
	}
}
