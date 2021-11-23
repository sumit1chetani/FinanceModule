package com.dci.tenant.finance.reports.auditTrial.quotation;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface QuotationAuditTrialService {

	public List<SelectivityBean> getEmployeeList();

	public List<QuotationAuditTrialBean> getQuotationList(QuotationAuditTrialBean quotationBean) throws Exception;

	public void excelExport(List<QuotationAuditTrialBean> quotationList, String path) throws Exception;

	public List<QuotationAuditTrialBean> jvTariffList(QuotationAuditTrialBean bean);

	public void JvexcelExport(List<QuotationAuditTrialBean> quotationList, String filePath,String filename);

	public List<QuotationAuditTrialBean> purQuotList(QuotationAuditTrialBean bean);

	public void purQuotviewExcel(List<QuotationAuditTrialBean> quotationList, String exportFilesPath, String filename);

}
