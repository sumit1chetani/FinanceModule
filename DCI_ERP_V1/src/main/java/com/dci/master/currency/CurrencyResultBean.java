package com.dci.master.currency;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CurrencyResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<CurrencyBean> lCurrencyBean;
	private Double fromCurrency;
	private Double toCurrency;
	private Double defaultCurrency;

	public List<CurrencyBean> getlCurrencyBean() {
		return lCurrencyBean;
	}

	public void setlCurrencyBean(List<CurrencyBean> lCurrencyBean) {
		this.lCurrencyBean = lCurrencyBean;
	}

	public Double getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(Double fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public Double getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(Double toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Double getDefaultCurrency() {
		return defaultCurrency;
	}

	public void setDefaultCurrency(Double defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}

	
}
