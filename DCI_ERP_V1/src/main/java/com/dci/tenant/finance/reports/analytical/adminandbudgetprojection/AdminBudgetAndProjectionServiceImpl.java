package com.dci.tenant.finance.reports.analytical.adminandbudgetprojection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AdminBudgetAndProjectionServiceImpl implements AdminBudgetAndProjectionService {

	@Autowired
	AdminBudgetAndProjectionDAO adminBudgetAndProjectionDAO;

	@Override
	public AdminBudgetAndProjectionResultBean getPrevYearLoadingContainerTuesList() {
		return adminBudgetAndProjectionDAO.getPrevYearLoadingContainerTuesList();
	}

	@Override
	public AdminBudgetAndProjectionResultBean getAccountHeadPreviousBalance(String accountCode) {
		return adminBudgetAndProjectionDAO.getAccountHeadPreviousBalance(accountCode);
	}

	@Override
	public boolean generateAdminBudgetData(AdminBudgetAndProjectionBean objaAdminBudgetAndProjectionBean) {
		return adminBudgetAndProjectionDAO.generateAdminBudgetData(objaAdminBudgetAndProjectionBean);
	}

	@Override
	public List<AdminBudgetAndProjectionBean> getAdminBudgetHdrList(int limit, int offset) {
		return adminBudgetAndProjectionDAO.getAdminBudgetHdrList(limit, offset);
	}
}
