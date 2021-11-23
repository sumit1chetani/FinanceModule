package com.dci.tenant.marketing.quotation;

import java.util.List;




public interface QuotationService {

public List<QuotationBean> QuotationList();
	
	public QuotationBean insert(QuotationBean quotation) throws Exception;

public boolean delete(String quotation_no);
	
	public QuotationBean  getEdit(String quotation_no) ;

	public QuotationBean update(QuotationBean update) throws Exception;
	
	public List<QuotationBean> getDropDown();
	
	
public List<QuotationBean> dropDown();
public List<QuotationBean> AgentList();
public List<QuotationBean> PartyList();
public List<QuotationBean> ExecutiveList();


	


}
