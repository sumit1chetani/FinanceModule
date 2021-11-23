package com.dci.master.countrynew;

import java.io.Serializable;

public class CountryNewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String countryCode;
	private String countryName;
	private String currencyCode;
	private String currencyName;
	private String cost_center_code;
	private String cost_center_name;
	
	
	

	public String getCost_center_code() {
		return cost_center_code;
	}

	public void setCost_center_code(String cost_center_code) {
		this.cost_center_code = cost_center_code;
	}

	public String getCost_center_name() {
		return cost_center_name;
	}

	public void setCost_center_name(String cost_center_name) {
		this.cost_center_name = cost_center_name;
	}

	private String id;
	private String text;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

}
