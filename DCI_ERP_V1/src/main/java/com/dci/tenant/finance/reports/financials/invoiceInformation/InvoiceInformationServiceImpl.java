package com.dci.tenant.finance.reports.financials.invoiceInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceInformationServiceImpl implements InvoiceInformationService {

	@Autowired
	InvoiceInformationDAO InvoiceInformationDAO;
	
	@Override
	public InvoiceInformationResultBean getValues(String value,String type) throws Exception {
		// TODO Auto-generated method stub return manageSubTaxDAO.getTypeList();
		return InvoiceInformationDAO.getValues(value,type);
	}
	
	@Override
	public InvoiceInformationResultBean getList(InvoiceInformation invoiceInformation) throws Exception {
		// TODO Auto-generated method stub return manageSubTaxDAO.getTypeList();
		return InvoiceInformationDAO.getList(invoiceInformation);
	}
}