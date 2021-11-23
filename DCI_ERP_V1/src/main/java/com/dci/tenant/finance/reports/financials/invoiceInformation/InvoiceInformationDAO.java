package com.dci.tenant.finance.reports.financials.invoiceInformation;

import com.dci.common.util.CustomException;


public interface InvoiceInformationDAO {
	
	public InvoiceInformationResultBean getValues(String value,String type) throws CustomException;
	
	public InvoiceInformationResultBean getList(InvoiceInformation invoiceInformation) throws CustomException;
	
}