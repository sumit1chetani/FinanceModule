package com.dci.master.currency;

import java.util.List;

public interface CurrencyService {

	List<CurrencyBean> getCurrencyList(int limit, int offset) throws Exception;

	public CurrencyResultBean addcurrency(CurrencyBean objCurrencyBean) throws Exception;

	public boolean deleteCurrency(Integer currencyCode) throws Exception;

	public boolean updateCurrency(CurrencyBean objCurrencyBean) throws Exception;

	CurrencyResultBean getExchangeRate(int currencyId);

	/*
	 * public boolean addCurrency(CurrencyBean objCurrencyBean) throws
	 * Exception;
	 * 
	 * 
	 * 
	 * public boolean updateCurrency(CurrencyBean objCurrencyBean) throws
	 * Exception;
	 */
}
