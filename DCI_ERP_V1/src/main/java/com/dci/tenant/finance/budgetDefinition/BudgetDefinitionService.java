package com.dci.tenant.finance.budgetDefinition;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;

@Service
public interface BudgetDefinitionService {

	public boolean saveBudgetDefinition(BudgetDefinition BudgetDefinition);

	public boolean updateBudgetDefinition(BudgetDefinition BudgetDefinition);

	public BudgetDefinition editBudgetDefinition(Integer budgetDefinitionId);

	public boolean delete(Integer budgetDefinitionId);

	public List<BudgetDefinition> getBudgetDefinition();

	public List<SelectivityBean> getBudgetTypeList();

	public boolean approveBudgetDefinition(BudgetDefinition BudgetDefinition);

}
