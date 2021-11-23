package com.dci.tenant.finance.TdsReport;

import java.util.List;

public interface TdsReportDAO {

	public List<TdsReportBean> searchportDtl(TdsReportBean objPendingapprovalBean) throws Exception;

}
