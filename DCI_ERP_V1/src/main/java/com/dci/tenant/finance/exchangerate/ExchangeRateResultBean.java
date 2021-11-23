package com.dci.tenant.finance.exchangerate;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ExchangeRateResultBean extends BasicResultBean {
	private List listExchangeRateBean;

	private List<ExchangeRateBean> lExchangeRateBean;

	private List currencyList;

	public List getListExchangeRateBean() {
		return listExchangeRateBean;
	}

	public void setListExchangeRateBean(List listExchangeRateBean) {
		this.listExchangeRateBean = listExchangeRateBean;
	}

	public List<ExchangeRateBean> getlExchangeRateBean() {
		return lExchangeRateBean;
	}

	public void setlExchangeRateBean(List<ExchangeRateBean> lExchangeRateBean) {
		this.lExchangeRateBean = lExchangeRateBean;
	}

	public List getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List currencyList) {
		this.currencyList = currencyList;
	}

}
