package com.dci.tenant.finance.currencyNew;

import java.util.List;

import com.dci.common.util.CustomException;

public interface CurrencyNewDAO {
	public List<CurrencyNewBean> getCurrencyList() throws CustomException;

	public CurrencyNewBean getCurrencyListOnEdit(String currencyCode) throws CustomException;

	public boolean deleteCurrency(String currencyCode) throws CustomException;

	public boolean updateCurrency(CurrencyNewBean currency) throws CustomException;

	public boolean saveCurrencyData(CurrencyNewBean objCurrencyBean);

}
