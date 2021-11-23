package com.dci.tenant.finance.paymentReport;

import java.util.List;

public interface PaymentReportDAO {
	PaymentReportResultBean getList();

	public List<PaymentHistoryReportBean> SearchList(PaymentHistoryReportBean bean);

}
