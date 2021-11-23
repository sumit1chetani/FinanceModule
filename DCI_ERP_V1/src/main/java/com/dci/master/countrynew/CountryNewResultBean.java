package com.dci.master.countrynew;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CountryNewResultBean extends BasicResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CountryNewBean> countryList = new ArrayList<CountryNewBean>();

	private List<CountryNewBean> currencyList;

	private List<CountryNewBean> costcenterlist;

	public List<CountryNewBean> getCostcenterlist() {
		return costcenterlist;
	}

	public void setCostcenterlist(List<CountryNewBean> costcenterlist) {
		this.costcenterlist = costcenterlist;
	}

	private CountryNewBean country = new CountryNewBean();

	public List<CountryNewBean> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CountryNewBean> countryList) {
		this.countryList = countryList;
	}

	public CountryNewBean getCountry() {
		return country;
	}

	public void setCountry(CountryNewBean country) {
		this.country = country;
	}

	public List<CountryNewBean> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<CountryNewBean> currencyList) {
		this.currencyList = currencyList;
	}

}
