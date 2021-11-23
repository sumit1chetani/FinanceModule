package com.dci.tenant.finance.paymentOrder;

public class PaymentOrderBankBean {
	private String id;
	private String text;
	private String acctHeadName;
	private String subgroupAcctCode;
	private String acctHeadCode;
	private String accountName;
	private String currencyCode;
	private String exchangeRate;

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

	public String getAcctHeadName() {
		return acctHeadName;
	}

	public void setAcctHeadName(String acctHeadName) {
		this.acctHeadName = acctHeadName;
	}

	public String getSubgroupAcctCode() {
		return subgroupAcctCode;
	}

	public void setSubgroupAcctCode(String subgroupAcctCode) {
		this.subgroupAcctCode = subgroupAcctCode;
	}

	public String getAcctHeadCode() {
		return acctHeadCode;
	}

	public void setAcctHeadCode(String acctHeadCode) {
		this.acctHeadCode = acctHeadCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

}