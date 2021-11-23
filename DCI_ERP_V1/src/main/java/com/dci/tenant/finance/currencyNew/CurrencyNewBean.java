package com.dci.tenant.finance.currencyNew;

public class CurrencyNewBean {
	private String currencyCode;
	private String currencyName;
	private String currencyDefault;
	private Integer currencyFraction;

	private String isActive;
	private String bookCurrency;
	private String symbol;

	private Integer fromCurrency;
	private Integer toCurrency;

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

	public String getCurrencyDefault() {
		return currencyDefault;
	}

	public void setCurrencyDefault(String currencyDefault) {
		this.currencyDefault = currencyDefault;
	}

	public Integer getCurrencyFraction() {
		return currencyFraction;
	}

	public void setCurrencyFraction(Integer currencyFraction) {
		this.currencyFraction = currencyFraction;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getBookCurrency() {
		return bookCurrency;
	}

	public void setBookCurrency(String bookCurrency) {
		this.bookCurrency = bookCurrency;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(Integer fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public Integer getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(Integer toCurrency) {
		this.toCurrency = toCurrency;
	}

}
