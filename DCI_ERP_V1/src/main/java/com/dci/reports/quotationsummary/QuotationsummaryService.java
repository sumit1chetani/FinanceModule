package com.dci.reports.quotationsummary;

import java.util.List;

public interface QuotationsummaryService {
	
	public List<QuotationsummaryBean> getDropDown();
	
	public List<QuotationsummaryBean>  searchInvoiceDtl(QuotationsummaryBean objQuotationsummaryBean) throws Exception;

	List<QuotationsummaryBean> getFeeList(QuotationsummaryBean objQuotationsummaryBean);
	
	void excellExport (QuotationsummaryResultBean objQuotationsummaryResultBean, QuotationsummaryBean objQuotationsummaryBean,String pdfFile);
	
}
