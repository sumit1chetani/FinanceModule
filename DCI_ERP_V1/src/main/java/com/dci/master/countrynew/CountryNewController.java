package com.dci.master.countrynew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping("hrms/master/country")
public class CountryNewController {

	@Autowired
	private CountryNewService countryNewService;

	@RequestMapping(value = "/list")
	public CountryNewResultBean getCountryList() {
		CountryNewResultBean countryNewResultBean = new CountryNewResultBean();
		try {

			countryNewResultBean.setCountryList(countryNewService.getCountryList());
			countryNewResultBean.setSuccess(true);
		} catch (CustomException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) { // TODO Auto-generated catch
			e.printStackTrace();
		}

		return countryNewResultBean;
	}

	@RequestMapping(value = "/save")
	public CountryNewResultBean save(@RequestBody CountryNewBean country) {
		CountryNewResultBean countryNewResultBean = new CountryNewResultBean();
		try {
			countryNewService.insertCountry(country);
			countryNewResultBean.setSuccess(true);
		} catch (CustomException e) {
			countryNewResultBean.setSuccess(false);
			countryNewResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryNewResultBean;
	}

	@RequestMapping(value = "/update")
	public CountryNewResultBean update(@RequestBody CountryNewBean country) {
		CountryNewResultBean countryNewResultBean = new CountryNewResultBean();
		try {
			countryNewService.updateCountry(country);
			countryNewResultBean.setSuccess(true);
		} catch (CustomException e) {
			countryNewResultBean.setSuccess(false);
			countryNewResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryNewResultBean;
	}

	@RequestMapping(value = "/currencylist")
	public CountryNewResultBean getcurrencylist() {
		CountryNewResultBean resultBean = new CountryNewResultBean();
		try {
			resultBean = countryNewService.getcurrencylist();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping(value = "/delete")
	public CountryNewResultBean delete(@RequestBody String currencyCode) {
		CountryNewResultBean countryNewResultBean = new CountryNewResultBean();
		try {
			countryNewService.deleteCountry(currencyCode);
			countryNewResultBean.setSuccess(true);
		} catch (CustomException e) {
			countryNewResultBean.setSuccess(false);
			countryNewResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryNewResultBean;
	}

	@RequestMapping(value = "/edit")
	public CountryNewResultBean getCountryByCode(@RequestBody String currencyCode) {
		CountryNewResultBean countryNewResultBean = new CountryNewResultBean();
		try {
			CountryNewBean country = countryNewService.getCountryByCode(currencyCode);
			countryNewResultBean.setCountry(country);
			countryNewResultBean.setSuccess(true);
		} catch (CustomException e) {
			countryNewResultBean.setSuccess(false);
			countryNewResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryNewResultBean;
	}

}
