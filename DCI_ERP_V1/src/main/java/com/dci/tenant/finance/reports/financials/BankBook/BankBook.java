package com.dci.tenant.finance.reports.financials.BankBook;

import java.util.ArrayList;

public class BankBook {
	private String accountCode;
	private String subGroutAcctCode;
	private String accountName;
	private Double credit;
	private Double debit;
	private String particulars;
	private String fromDate;
	private String toDate;
	private String text;
	private String ledgerDate;
	private String transactionNo;
	private Double currentBalance;
	private Double trnsCredit;
	private Double trnsDebit;
	private String companyCode;
	private ArrayList objCompanyCodes;
	// code added for additional details

	private String transactionDate;
	private Double bcDebit;
	private Double bcCredit;
	private Double tcDebit;
	private Double tcCredit;
	private String narration;
	private String mainAccountCode;
	private String mainAccountName;
	private String customer;
	private String chequeNo;
	private String acctheadname;
	
	private Double openingBalance;
	
	public String getAcctheadname() {
		return acctheadname;
	}

	public void setAcctheadname(String acctheadname) {
		this.acctheadname = acctheadname;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Double getDebit() {
		return debit;
	}

	public void setDebit(Double debit) {
		this.debit = debit;
	}

	public String getLedgerDate() {
		return ledgerDate;
	}

	public void setLedgerDate(String ledgerDate) {
		this.ledgerDate = ledgerDate;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getTrnsCredit() {
		return trnsCredit;
	}

	public void setTrnsCredit(Double trnsCredit) {
		this.trnsCredit = trnsCredit;
	}

	public Double getTrnsDebit() {
		return trnsDebit;
	}

	public void setTrnsDebit(Double trnsDebit) {
		this.trnsDebit = trnsDebit;
	}

	public String getSubGroutAcctCode() {
		return subGroutAcctCode;
	}

	public void setSubGroutAcctCode(String subGroutAcctCode) {
		this.subGroutAcctCode = subGroutAcctCode;
	}

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getBcDebit() {
		return bcDebit;
	}

	public void setBcDebit(Double bcDebit) {
		this.bcDebit = bcDebit;
	}

	public Double getBcCredit() {
		return bcCredit;
	}

	public void setBcCredit(Double bcCredit) {
		this.bcCredit = bcCredit;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getMainAccountCode() {
		return mainAccountCode;
	}

	public void setMainAccountCode(String mainAccountCode) {
		this.mainAccountCode = mainAccountCode;
	}

	public String getMainAccountName() {
		return mainAccountName;
	}

	public void setMainAccountName(String mainAccountName) {
		this.mainAccountName = mainAccountName;
	}

	public Double getTcDebit() {
		return tcDebit;
	}

	public void setTcDebit(Double tcDebit) {
		this.tcDebit = tcDebit;
	}

	public Double getTcCredit() {
		return tcCredit;
	}

	public void setTcCredit(Double tcCredit) {
		this.tcCredit = tcCredit;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public ArrayList getObjCompanyCodes() {
		return objCompanyCodes;
	}

	public void setObjCompanyCodes(ArrayList objCompanyCodes) {
		this.objCompanyCodes = objCompanyCodes;
	}

	
	
}