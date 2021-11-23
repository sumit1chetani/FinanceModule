package com.dci.common.util;

public class GeneralLedgerProcedureBean {

	private String accountHeadCode;
	private String subGroupCode;
	private String transactionNo;
	private String currencyCode;
	private double exchangeRate;
	private double bcAmount;
	private double tcAmount;
	private String ledgerDate;
	private String companyCode;
	private String subAccountCode;

	private String narration;
	private String partyInvoiceNo;
	private String partyInvoiceDate;
	private String refNo;

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public String getSubGroupCode() {
		return subGroupCode;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public double getBcAmount() {
		return bcAmount;
	}

	public double getTcAmount() {
		return tcAmount;
	}

	public String getLedgerDate() {
		return ledgerDate;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public void setSubGroupCode(String subGroupCode) {
		this.subGroupCode = subGroupCode;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public void setBcAmount(double bcAmount) {
		this.bcAmount = bcAmount;
	}

	public void setTcAmount(double tcAmount) {
		this.tcAmount = tcAmount;
	}

	public void setLedgerDate(String ledgerDate) {
		this.ledgerDate = ledgerDate;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getSubAccountCode() {
		return subAccountCode;
	}

	public void setSubAccountCode(String subAccountCode) {
		this.subAccountCode = subAccountCode;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getPartyInvoiceNo() {
		return partyInvoiceNo;
	}

	public void setPartyInvoiceNo(String partyInvoiceNo) {
		this.partyInvoiceNo = partyInvoiceNo;
	}

	public String getPartyInvoiceDate() {
		return partyInvoiceDate;
	}

	public void setPartyInvoiceDate(String partyInvoiceDate) {
		this.partyInvoiceDate = partyInvoiceDate;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

}
