package com.dci.tenant.finance.BudgetReport;

import java.util.List;

public interface BudgetReportService {

	public List<BudgetReportBean> searchportDtl(BudgetReportBean objPendingapprovalBean) throws Exception;

	void excellExport(BudgetReportResultBean ObjPendingapprovalResultBean, BudgetReportBean objPendingapprovalBean, String pdfFile);
}
