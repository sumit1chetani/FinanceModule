package com.dci.master.countrynew;

import java.util.List;

public interface CountryNewService {

	List<CountryNewBean> getCountryList() throws Exception;

	void insertCountry(CountryNewBean country) throws Exception;

	CountryNewResultBean getcurrencylist() throws Exception;

	void updateCountry(CountryNewBean country) throws Exception;

	void deleteCountry(String currencyCode) throws Exception;

	CountryNewBean getCountryByCode(String currencyCode) throws Exception;

}
