package com.dci.tenant.finance.debitnote;

import java.util.ArrayList;
import java.util.List;

public class DebitNoteBean {
	private int acctHeadCode;
	private String acctHeadName;
	private String acctName;
	private String strAcctHeadCode;
	private String invoiceNo;
	private String narration;
	private String dtlNarration;
	private String description;
	private double amount;
	private double amountUSD;
	private int totalAmount;
	private int totalAmounts;
	private String companyName;
	private String companyCode;
	private String company;
	private String currency;
	private String currencyCode;
	private String debitNoteNo;
	private String debitNoteDate;
	private String invoiceDate;
	private double exchangeRate;
	private String mloName;
	private String location;

	private String approvalStatus;
	private boolean isEdit;
	private String subAcctCode;
	private String subAcctName;
	private ArrayList<DebitNoteDetailBean> debittables;
	private List<DebitNoteBean> accountHeadList;

	private String id;
	private String text;

	public int getAcctHeadCode() {
		return acctHeadCode;
	}

	public void setAcctHeadCode(int acctHeadCode) {
		this.acctHeadCode = acctHeadCode;
	}

	public String getAcctHeadName() {
		return acctHeadName;
	}

	public void setAcctHeadName(String acctHeadName) {
		this.acctHeadName = acctHeadName;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getStrAcctHeadCode() {
		return strAcctHeadCode;
	}

	public void setStrAcctHeadCode(String strAcctHeadCode) {
		this.strAcctHeadCode = strAcctHeadCode;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getDtlNarration() {
		return dtlNarration;
	}

	public void setDtlNarration(String dtlNarration) {
		this.dtlNarration = dtlNarration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmountUSD() {
		return amountUSD;
	}

	public void setAmountUSD(double amountUSD) {
		this.amountUSD = amountUSD;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalAmounts() {
		return totalAmounts;
	}

	public void setTotalAmounts(int totalAmounts) {
		this.totalAmounts = totalAmounts;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getDebitNoteNo() {
		return debitNoteNo;
	}

	public void setDebitNoteNo(String debitNoteNo) {
		this.debitNoteNo = debitNoteNo;
	}

	public String getDebitNoteDate() {
		return debitNoteDate;
	}

	public void setDebitNoteDate(String debitNoteDate) {
		this.debitNoteDate = debitNoteDate;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getMloName() {
		return mloName;
	}

	public void setMloName(String mloName) {
		this.mloName = mloName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getSubAcctCode() {
		return subAcctCode;
	}

	public void setSubAcctCode(String subAcctCode) {
		this.subAcctCode = subAcctCode;
	}

	public String getSubAcctName() {
		return subAcctName;
	}

	public void setSubAcctName(String subAcctName) {
		this.subAcctName = subAcctName;
	}

	public ArrayList<DebitNoteDetailBean> getDebittables() {
		return debittables;
	}

	public void setDebittables(ArrayList<DebitNoteDetailBean> debittables) {
		this.debittables = debittables;
	}

	public List<DebitNoteBean> getAccountHeadList() {
		return accountHeadList;
	}

	public void setAccountHeadList(List<DebitNoteBean> accountHeadList) {
		this.accountHeadList = accountHeadList;
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
