package com.dci.tenant.finance.currencyNew;

import java.util.List;

import com.dci.common.util.CustomException;

public interface CurrencyNewService {

	List<CurrencyNewBean> getCurrencyList() throws CustomException;

	public boolean updateCurrency(CurrencyNewBean currency) throws CustomException;

	public boolean deleteCurrency(String currencyCode) throws CustomException;

	public CurrencyNewBean getCurrencyListOnEdit(String currencyCode) throws CustomException;

	boolean saveCurrencyData(CurrencyNewBean objCurrencyBean);

}
