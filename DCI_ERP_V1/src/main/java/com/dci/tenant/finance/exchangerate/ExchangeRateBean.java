package com.dci.tenant.finance.exchangerate;

public class ExchangeRateBean {
	private String exchangeRateCode;
	private String currencyCode;
	private String bookCurrency;
	private String exchangeRateValue;
	private String exchangeRateDate;
	private String sourceDate;
	private String copyDate;

	private String id;
	private String text;

	public String getExchangeRateCode() {
		return exchangeRateCode;
	}

	public void setExchangeRateCode(String exchangeRateCode) {
		this.exchangeRateCode = exchangeRateCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getBookCurrency() {
		return bookCurrency;
	}

	public void setBookCurrency(String bookCurrency) {
		this.bookCurrency = bookCurrency;
	}

	public String getExchangeRateValue() {
		return exchangeRateValue;
	}

	public void setExchangeRateValue(String exchangeRateValue) {
		this.exchangeRateValue = exchangeRateValue;
	}

	public String getExchangeRateDate() {
		return exchangeRateDate;
	}

	public void setExchangeRateDate(String exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}

	public String getSourceDate() {
		return sourceDate;
	}

	public void setSourceDate(String sourceDate) {
		this.sourceDate = sourceDate;
	}

	public String getCopyDate() {
		return copyDate;
	}

	public void setCopyDate(String copyDate) {
		this.copyDate = copyDate;
	}

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

}
