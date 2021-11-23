package com.dci.master.currency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
	@Autowired
	CurrencyDAO objCurrencyDAO;

	@Override
	public List<CurrencyBean> getCurrencyList(int limit, int offset) throws Exception {
		// TODO Auto-generated method stub
		return objCurrencyDAO.getCurrencyList(limit, offset);

	}

	@Override
	public CurrencyResultBean addcurrency(CurrencyBean objCurrencyBean) throws Exception {
		return objCurrencyDAO.addcurrency(objCurrencyBean);
	}

	@Override
	public boolean deleteCurrency(Integer currencyCode) throws Exception {
		return objCurrencyDAO.deleteCurrency(currencyCode);

	}

	@Override
	public boolean updateCurrency(CurrencyBean objCurrencyBean) throws Exception {
		return objCurrencyDAO.updateCurrency(objCurrencyBean);
	}

	@Override
	public CurrencyResultBean getExchangeRate(int currencyId) {
		// TODO Auto-generated method stub
		return objCurrencyDAO.getExchangeRate(currencyId);
	}

	/*
	 * @Autowired CurrencyDAO objCurrencyDAO;
	 * 
	 * @Override public List<CurrencyBean> getConsigneeList(int limit, int
	 * offset) throws Exception { // TODO Auto-generated method stub return
	 * objCurrencyDAO.getConsigneeList(limit, offset);
	 * 
	 * }
	 * 
	 * @Override public boolean addCurrency(CurrencyBean objCurrencyBean) throws
	 * Exception { return objCurrencyDAO.addconsignee(objCurrencyBean); }
	 * 
	 * 
	 * @Override public boolean updateCurrency(CurrencyBean objCurrencyBean)
	 * throws Exception { return objCurrencyDAO.updateCurrency(objCurrencyBean);
	 * }
	 */
}
