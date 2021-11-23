package com.dci.master.countrynew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryNewServiceImpl implements CountryNewService {

	@Autowired
	private CountryNewDAO countryNewDAO;

	@Override
	public List<CountryNewBean> getCountryList() throws Exception {
		return countryNewDAO.getCountryList();
	}

	@Override
	public void insertCountry(CountryNewBean country) throws Exception {
		countryNewDAO.insertCountry(country);
	}

	@Override
	public CountryNewResultBean getcurrencylist() throws Exception {
		return countryNewDAO.getcurrencylist();
	}

	@Override
	public void updateCountry(CountryNewBean country) throws Exception {
		countryNewDAO.updateCountry(country);
	}

	@Override
	public void deleteCountry(String currencyCode) throws Exception {
		countryNewDAO.deleteCountry(currencyCode);

	}

	@Override
	public CountryNewBean getCountryByCode(String currencyCode) throws Exception {
		return countryNewDAO.getCountryByCode(currencyCode);
	}

}
