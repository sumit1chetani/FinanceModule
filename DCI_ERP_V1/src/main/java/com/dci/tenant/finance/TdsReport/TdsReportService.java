package com.dci.tenant.finance.TdsReport;

import java.util.List;

public interface TdsReportService {

	public List<TdsReportBean> searchportDtl(TdsReportBean objPendingapprovalBean) throws Exception;

	boolean excellExport(TdsReportResultBean ObjPendingapprovalResultBean, TdsReportBean objPendingapprovalBean, String pdfFile);

	public TdsReportBean pdfExportNew(TdsReportBean detentionTariffBean, String exportFilesPath);
}
