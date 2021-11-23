package com.dci.tenant.finance.reports.analytical.adminandbudgetprojection;

import java.util.List;

public interface AdminBudgetAndProjectionDAO {

	AdminBudgetAndProjectionResultBean getPrevYearLoadingContainerTuesList();

	AdminBudgetAndProjectionResultBean getAccountHeadPreviousBalance(String accountCode);

	boolean generateAdminBudgetData(AdminBudgetAndProjectionBean objaAdminBudgetAndProjectionBean);

	List<AdminBudgetAndProjectionBean> getAdminBudgetHdrList(int limit, int offset);

}
