package com.dci.tenant.finance.payableAgewise;

import java.util.List;

public interface PayableAgewiseDAO {

	public List<PayableAgewiseBean> getPayableAgewiseReport(String sDate);

	public List<PayableAgewiseBean> getPayableAgewiseReportDtl(PayableAgewiseBean objPayableAgewiseBean);

	public List<PayableAgewiseBean> getPayableAgewiseListForExcel(String sDate);

}
