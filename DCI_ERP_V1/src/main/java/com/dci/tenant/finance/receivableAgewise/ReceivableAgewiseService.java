package com.dci.tenant.finance.receivableAgewise;

import java.util.List;

public interface ReceivableAgewiseService {

	public List<ReceivableAgewiseBean> getReceivableAgewiseReport(String sDate);

	public List<ReceivableAgewiseBean> getReceivableAgewiseReportDtl(ReceivableAgewiseBean objReceivableAgewiseBean);

	public boolean exportReceivableAgewiseExcel(String filepath, String sDate);

}
