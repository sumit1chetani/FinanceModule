package com.dci.tenant.finance.budgetDefinition;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class BudgetDefinitionResultBean extends BasicResultBean implements Serializable {

	private List<BudgetDefinition> allList;
	private List<SelectivityBean> budgetTypeList;

	public List<SelectivityBean> getBudgetTypeList() {
		return budgetTypeList;
	}

	public void setBudgetTypeList(List<SelectivityBean> budgetTypeList) {
		this.budgetTypeList = budgetTypeList;
	}

	public List<BudgetDefinition> getAllList() {
		return allList;
	}

	public void setAllList(List<BudgetDefinition> allList) {
		this.allList = allList;
	}

}
