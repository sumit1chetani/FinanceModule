package com.dci.tenant.finance.paymentReport;

import java.util.List;

public interface PaymentReportService {

	boolean exportPendingPmtExcel(String filepath, PaymentHistoryReportBean objPmtBean);

	boolean exportPaymentHistoryExcel(String filepath);

	PaymentReportResultBean getList();

	public List<PaymentHistoryReportBean> SearchList(PaymentHistoryReportBean bean);

	public PaymentHistoryReportBean pdfExportNew(PaymentHistoryReportBean prreport, String exportFilesPath);

}
