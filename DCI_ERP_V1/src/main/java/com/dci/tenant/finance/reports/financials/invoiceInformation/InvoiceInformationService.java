package com.dci.tenant.finance.reports.financials.invoiceInformation;


public interface InvoiceInformationService {
	
	InvoiceInformationResultBean getValues(String value,String type) throws Exception;

	InvoiceInformationResultBean getList(InvoiceInformation invoiceInformation) throws Exception;
	
}