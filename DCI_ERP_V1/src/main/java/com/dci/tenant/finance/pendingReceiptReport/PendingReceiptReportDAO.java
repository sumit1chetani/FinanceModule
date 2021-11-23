package com.dci.tenant.finance.pendingReceiptReport;

public interface PendingReceiptReportDAO {
	PendingReceiptReportResultBean getList() throws Exception;

	PendingReceiptReportBean getCustomerDetails(String customerCode) throws Exception;
}
