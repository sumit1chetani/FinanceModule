package com.dci.tenant.finance.budgetType;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class BudgetTypeResultBean extends BasicResultBean implements Serializable {

	private List<BudgetTypeBean> lBudgetTypeBean;
	private BudgetTypeBean budgetTypeBean;
	private List<BudgetTypeBean> lExpenseAccountsList;

	public List<BudgetTypeBean> getlExpenseAccountsList() {
		return lExpenseAccountsList;
	}

	public void setlExpenseAccountsList(List<BudgetTypeBean> lExpenseAccountsList) {
		this.lExpenseAccountsList = lExpenseAccountsList;
	}

	public List<BudgetTypeBean> getlBudgetTypeBean() {
		return lBudgetTypeBean;
	}

	public void setlBudgetTypeBean(List<BudgetTypeBean> lBudgetTypeBean) {
		this.lBudgetTypeBean = lBudgetTypeBean;
	}

	public BudgetTypeBean getBudgetTypeBean() {
		return budgetTypeBean;
	}

	public void setBudgetTypeBean(BudgetTypeBean budgetTypeBean) {
		this.budgetTypeBean = budgetTypeBean;
	}

}
