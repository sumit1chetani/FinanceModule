package com.dci.tenant.finance.closingaccounts;

import java.util.ArrayList;

public class ClosingAccounts {
	private String fromdate;
	private String todate;
	private String location;
	private String finacfromdate;
	private String finactodate;
	private String type;
	private String closingAccountCode;
	private String accCode;
	private String accName;
	private double debit;
	private double credit;
	private String parentcode;
	private double localdebit;
	private double localcredit;
	private double balance;
	private double localbalance;
	private double totalBalance;
	private double totallocalbalance;
	private String companyId;
	private boolean isEdit;
	private String companyCode;
	private String companyName;
	private Integer closingAccountId;

	public Integer getClosingAccountId() {
		return closingAccountId;
	}

	public void setClosingAccountId(Integer closingAccountId) {
		this.closingAccountId = closingAccountId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	private String journalNumber;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	private String jvNarration;
	// private String companyCode;

	private ArrayList<ClosingAccounts> rowCollection;

	// Holds the closingAcctCode
	// DB Field:

	public String getFromdate() {
		return fromdate;
	}

	public String getClosingAccountCode() {
		return closingAccountCode;
	}

	public void setClosingAccountCode(String closingAccountCode) {
		this.closingAccountCode = closingAccountCode;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFinacfromdate() {
		return finacfromdate;
	}

	public void setFinacfromdate(String finacfromdate) {
		this.finacfromdate = finacfromdate;
	}

	public String getFinactodate() {
		return finactodate;
	}

	public void setFinactodate(String finactodate) {
		this.finactodate = finactodate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}

	public double getLocaldebit() {
		return localdebit;
	}

	public void setLocaldebit(double localdebit) {
		this.localdebit = localdebit;
	}

	public double getLocalcredit() {
		return localcredit;
	}

	public void setLocalcredit(double localcredit) {
		this.localcredit = localcredit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getLocalbalance() {
		return localbalance;
	}

	public void setLocalbalance(double localbalance) {
		this.localbalance = localbalance;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public double getTotallocalbalance() {
		return totallocalbalance;
	}

	public void setTotallocalbalance(double totallocalbalance) {
		this.totallocalbalance = totallocalbalance;
	}

	public String getJournalNumber() {
		return journalNumber;
	}

	public void setJournalNumber(String journalNumber) {
		this.journalNumber = journalNumber;
	}

	public ArrayList<ClosingAccounts> getRowCollection() {
		return rowCollection;
	}

	public void setRowCollection(ArrayList<ClosingAccounts> rowCollection) {
		this.rowCollection = rowCollection;
	}

	public String getJvNarration() {
		return jvNarration;
	}

	public void setJvNarration(String jvNarration) {
		this.jvNarration = jvNarration;
	}

}