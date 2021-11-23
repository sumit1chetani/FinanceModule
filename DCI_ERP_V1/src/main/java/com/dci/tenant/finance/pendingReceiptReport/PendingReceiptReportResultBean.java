package com.dci.tenant.finance.pendingReceiptReport;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class PendingReceiptReportResultBean extends BasicResultBean {
	private List<PendingReceiptReportBean> reportBeanList;

	public List<PendingReceiptReportBean> getReportBeanList() {
		return reportBeanList;
	}

	public void setReportBeanList(List<PendingReceiptReportBean> reportBeanList) {
		this.reportBeanList = reportBeanList;
	}
}
