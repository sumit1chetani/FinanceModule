package com.dci.tenant.finance.pendingReceiptReport;

import java.util.List;

public interface PendingReceiptReportService {
	PendingReceiptReportResultBean getList() throws Exception;

	boolean sendMail(List<PendingReceiptReportBean> beans) throws Exception;
}
