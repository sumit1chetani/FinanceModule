package com.dci.tenant.finance.paymentReport;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class PaymentReportResultBean extends BasicResultBean {
	private List<PaymentHistoryReportBean> lpaymentreport = new ArrayList<PaymentHistoryReportBean>();

	public List<PaymentHistoryReportBean> getLpaymentreport() {
		return lpaymentreport;
	}

	public void setLpaymentreport(List<PaymentHistoryReportBean> lpaymentreport) {
		this.lpaymentreport = lpaymentreport;
	}

}
