package com.dci.master.currency;

import java.util.List;

public interface CurrencyDAO {

	public CurrencyBean getCurrency(String currencyCode) throws Exception;
	
	public CurrencyBean getCurrency1(Integer currencyCode) throws Exception;

	List<CurrencyBean> getCurrencyList(int limit, int offset) throws Exception;

	public CurrencyResultBean addcurrency(CurrencyBean objCurrencyBean) throws Exception;

	public boolean deleteCurrency(Integer currencyCode) throws Exception;

	public boolean updateCurrency(CurrencyBean objCurrencyBean) throws Exception;

	public CurrencyResultBean getExchangeRate(int currencyId);

}
