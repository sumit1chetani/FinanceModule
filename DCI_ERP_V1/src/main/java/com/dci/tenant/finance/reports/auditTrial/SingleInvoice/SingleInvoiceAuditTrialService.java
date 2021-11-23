package com.dci.tenant.finance.reports.auditTrial.SingleInvoice;

import java.util.List;

public interface SingleInvoiceAuditTrialService {

	public List<SingleInvoiceAuditTrialBean> getSingleInvoiceList(SingleInvoiceAuditTrialBean invoiceAuditTrialBean);

	public void excelExport(List<SingleInvoiceAuditTrialBean> singleInvoiceList, String path);
	
	public List<SingleInvoiceAuditTrialBean> getEmployeeList();

}
