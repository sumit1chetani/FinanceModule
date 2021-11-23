package com.dci.tenant.finance.BudgetReport;

import java.util.List;

public interface BudgetReportDAO {

	public List<BudgetReportBean> searchportDtl(BudgetReportBean objPendingapprovalBean) throws Exception;
}
