package com.dci.tenant.marketing.quotation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class QuotationServiceImpl implements QuotationService  {
	@Autowired
	QuotationDAO quotationDao;
	
	@Override
	public List<QuotationBean> QuotationList() {
		
		return quotationDao.QuotationList();
	}
	
	@Override
	public QuotationBean insert(QuotationBean quotation) throws Exception {
		// TODO Auto-generated method stub
		return quotationDao.insert(quotation);
	}
	@Override
	public boolean delete(String quotation_no) {
		// TODO Auto-generated method stub
		return quotationDao.delete(quotation_no);
	}
	@Override
	public QuotationBean update(QuotationBean update) throws Exception {
		// TODO Auto-generated method stub
		return quotationDao.update(update);
	}
	@Override
	public QuotationBean getEdit(String quotation_no)  {
		// TODO Auto-generated method stub
		return quotationDao.getEdit(quotation_no);
	}
	public List<QuotationBean> getDropDown() {
		// TODO Auto-generated method stub
		return quotationDao.getDropDown();
	}
	
	public List<QuotationBean> dropDown() {
		// TODO Auto-generated method stub
		return quotationDao.dropDown();
	}
	
	public List<QuotationBean> AgentList() {
		// TODO Auto-generated method stub
		return quotationDao.AgentList();
	}
	
	public List<QuotationBean> PartyList() {
		// TODO Auto-generated method stub
		return quotationDao.PartyList();
	}
	
	public List<QuotationBean> ExecutiveList() {
		// TODO Auto-generated method stub
		return quotationDao.ExecutiveList();
	}

	
	


}
