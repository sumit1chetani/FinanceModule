package com.dci.tenant.finance.currencyNew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class CurrencyNewServiceImpl implements CurrencyNewService {
	@Autowired
	CurrencyNewDAO currencyDAO;

	@Override
	public List<CurrencyNewBean> getCurrencyList() throws CustomException {
		return currencyDAO.getCurrencyList();
	}

	@Override
	public CurrencyNewBean getCurrencyListOnEdit(String currencyCode) throws CustomException {
		CurrencyNewBean currency = currencyDAO.getCurrencyListOnEdit(currencyCode);
		return currency;
	}

	@Override
	public boolean updateCurrency(CurrencyNewBean currency) throws CustomException {
		return currencyDAO.updateCurrency(currency);
	}

	@Override
	public boolean deleteCurrency(String currencyCode) throws CustomException {
		return currencyDAO.deleteCurrency(currencyCode);

	}

	@Override
	public boolean saveCurrencyData(CurrencyNewBean objCurrencyBean) {
		return currencyDAO.saveCurrencyData(objCurrencyBean);
	}

}
