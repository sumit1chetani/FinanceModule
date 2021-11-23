package com.dci.tenant.finance.currencyNew;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CurrencyNewResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CurrencyNew> currencyList;
	private List<CurrencyNewBean> lCurrencyBean;

	private CurrencyNew currency = new CurrencyNew();
	private CurrencyNewBean objCurrencyBean = new CurrencyNewBean();

	public List<CurrencyNew> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<CurrencyNew> currencyList) {
		this.currencyList = currencyList;
	}

	public CurrencyNew getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyNew currency) {
		this.currency = currency;
	}

	public List<CurrencyNewBean> getlCurrencyBean() {
		return lCurrencyBean;
	}

	public void setlCurrencyBean(List<CurrencyNewBean> lCurrencyBean) {
		this.lCurrencyBean = lCurrencyBean;
	}

	public CurrencyNewBean getObjCurrencyBean() {
		return objCurrencyBean;
	}

	public void setObjCurrencyBean(CurrencyNewBean objCurrencyBean) {
		this.objCurrencyBean = objCurrencyBean;
	}

}
