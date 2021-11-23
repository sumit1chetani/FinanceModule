package com.dci.tenant.finance.payableAgewise;

import java.util.List;

public interface PayableAgewiseService {

	public List<PayableAgewiseBean> getPayableAgewiseReport(String sDate);

	public List<PayableAgewiseBean> getPayableAgewiseReportDtl(PayableAgewiseBean objPayableAgewiseBean);

	public boolean exportPayableAgewiseExcel(String filepath, String sDate);

}
