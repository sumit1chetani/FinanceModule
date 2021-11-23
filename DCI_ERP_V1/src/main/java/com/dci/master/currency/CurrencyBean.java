package com.dci.master.currency;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "currency", formCode = "F0009")
public class CurrencyBean {
	private Integer currencyId;
	private String currencyCode;
	private String currencyName;
	private double currencyDefault;
	private double currencyFraction;
	private String isStstus;
	private boolean isActive;
	private boolean book;
	private String bookCurrency;
	private double fromc;
	private double toc;
	private String isroundSts;
	private boolean isRound;
	private String symbol;
	private String description;
	private String category;
	private Double fromCurrency;
	private Double toCurrency;
	private Double defaultCurrency;
	
	

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	@AuditLoggable(fieldName = "crrncy_cd", displayName = "Currency Code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@AuditLoggable(fieldName = "crrncy_nam", displayName = "Currency Name")
	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	@AuditLoggable(fieldName = "CURRENCY_DEFAULT", displayName = "Currency Default")
	public double getCurrencyDefault() {
		return currencyDefault;
	}

	public void setCurrencyDefault(double currencyDefault) {
		this.currencyDefault = currencyDefault;
	}

	@AuditLoggable(fieldName = "CURRENCY_FRACTION", displayName = "Currency Fraction")
	public double getCurrencyFraction() {
		return currencyFraction;
	}

	public void setCurrencyFraction(double currencyFraction) {
		this.currencyFraction = currencyFraction;
	}
	
	
	public boolean getIsBook() {
		return book;
	}

	public void setIsBook(boolean book) {
		this.book = book;
	}

	
	public String getIsroundSts() {
		return isroundSts;
	}

	public void setIsroundSts(String isroundSts) {
		this.isroundSts = isroundSts;
	}

	public boolean getIsRound() {
		return isRound;
	}

	public void setIsRound(boolean isRound) {
		this.isRound = isRound;
	}

	/*public void setActive(boolean isActive) {
		this.isActive = isActive;
	}*/

	public String getIsStstus() {
		return isStstus;
	}

	public void setIsStstus(String isStstus) {
		this.isStstus = isStstus;
	}
	
	@AuditLoggable(fieldName = "actv_bt", displayName = "Active")
	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@AuditLoggable(fieldName = "crrncy_symbl_nam", displayName = "Crrncy Symbol")
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@AuditLoggable(fieldName = "crrncy_ctgry", displayName = "Crrncy sub category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@AuditLoggable(fieldName = "BOOK_CURRENCY", displayName = "bookCurrency")

	public String getBookCurrency() {
		return bookCurrency;
	}

	public void setBookCurrency(String bookCurrency) {
		this.bookCurrency = bookCurrency;
	}

	@AuditLoggable(fieldName = "CURRENCY_CONVER_FROM", displayName = "Currency Rate To Base Currency (From)")
	public double getFromc() {
		return fromc;
	}

	public void setFromc(double fromc) {
		this.fromc = fromc;
	}

	@AuditLoggable(fieldName = "CURRENCY_CONVER_TO", displayName = "Currency Rate To Base Currency (To)")
	public double getToc() {
		return toc;
	}

	public void setToc(double toc) {
		this.toc = toc;
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