package com.dci.tenant.finance.budgetOverview;

import java.util.List;

public interface BudgetOverviewDAO {
	List<BudgetOverviewBean> getList(BudgetOverviewBean overviewBean) throws Exception;

	List<BudgetOverviewBean> getFinancialYearList(String companyId) throws Exception;

	List<BudgetOverviewBean> getDetailList(BudgetOverviewBean overviewBean) throws Exception;
}
