package com.dci.tenant.finance.receivableAgewise;

import java.util.List;

public interface ReceivableAgewiseDao {

	public List<ReceivableAgewiseBean> getReceivableAgewiseReport(String sDate);

	public List<ReceivableAgewiseBean> getReceivableAgewiseReportDtl(ReceivableAgewiseBean objReceivableAgewiseBean);

	public List<ReceivableAgewiseBean> getReceivableAgewiseListForExcel(String sDate);

}
