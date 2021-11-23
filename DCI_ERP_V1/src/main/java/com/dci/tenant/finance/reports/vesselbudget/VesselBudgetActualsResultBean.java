package com.dci.tenant.finance.reports.vesselbudget;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class VesselBudgetActualsResultBean extends BasicResultBean implements Serializable {

	List<VesselBudgetActualsBean> budgetActualsBeanList;

	public List<VesselBudgetActualsBean> getBudgetActualsBeanList() {
		return budgetActualsBeanList;
	}

	public void setBudgetActualsBeanList(List<VesselBudgetActualsBean> budgetActualsBeanList) {
		this.budgetActualsBeanList = budgetActualsBeanList;
	}

}
