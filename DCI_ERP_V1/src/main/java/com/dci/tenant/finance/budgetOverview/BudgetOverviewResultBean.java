package com.dci.tenant.finance.budgetOverview;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class BudgetOverviewResultBean extends BasicResultBean implements Serializable {
	private List<BudgetOverviewBean> lBudgetOverview;
	private List<BudgetOverviewBean> lFinanceYear;
	private List<BudgetOverviewBean> ldetailList;

	public List<BudgetOverviewBean> getlBudgetOverview() {
		return lBudgetOverview;
	}

	public void setlBudgetOverview(List<BudgetOverviewBean> lBudgetOverview) {
		this.lBudgetOverview = lBudgetOverview;
	}

	public List<BudgetOverviewBean> getlFinanceYear() {
		return lFinanceYear;
	}

	public void setlFinanceYear(List<BudgetOverviewBean> lFinanceYear) {
		this.lFinanceYear = lFinanceYear;
	}

	public List<BudgetOverviewBean> getLdetailList() {
		return ldetailList;
	}

	public void setLdetailList(List<BudgetOverviewBean> ldetailList) {
		this.ldetailList = ldetailList;
	}
}
