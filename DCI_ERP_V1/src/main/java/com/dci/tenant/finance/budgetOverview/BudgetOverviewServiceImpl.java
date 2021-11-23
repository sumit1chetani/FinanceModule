package com.dci.tenant.finance.budgetOverview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetOverviewServiceImpl implements BudgetOverviewService {
	@Autowired
	BudgetOverviewDAO budgetOverviewDAO;

	@Override
	public List<BudgetOverviewBean> getList(BudgetOverviewBean overviewBean) throws Exception {
		// TODO Auto-generated method stub
		return budgetOverviewDAO.getList(overviewBean);
	}

	@Override
	public List<BudgetOverviewBean> getFinancialYearList(String companyId) throws Exception {
		// TODO Auto-generated method stub
		return budgetOverviewDAO.getFinancialYearList(companyId);
	}

	@Override
	public List<BudgetOverviewBean> getDetailList(BudgetOverviewBean overviewBean) throws Exception {
		// TODO Auto-generated method stub
		return budgetOverviewDAO.getDetailList(overviewBean);
	}

}
