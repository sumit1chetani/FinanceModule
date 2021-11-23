package com.dci.tenant.finance.reports.auditTrial.SingleInvoice;

import java.util.List;

public interface SingleInvoiceAuditTrialDAO {

	public List<SingleInvoiceAuditTrialBean> getSingleInvoiceList(SingleInvoiceAuditTrialBean invoiceAuditTrialBean);
	
	public List<SingleInvoiceAuditTrialBean> getEmployeeList();

}
