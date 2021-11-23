package com.dci.tenant.finance.creditnote;

import java.util.ArrayList;
import java.util.List;

public class CreditNoteBean {

	private String creditNoteCode;
	private String creditNoteDate;

	private String acctName;
	private String acctHeadCode;
	private String accountName;
	private String currencyCode;
	private double exgRate;
	private double exchangeRate;
	private String currFrom;
	private String currTo;
	private String mloName;

	private String invoiceNo;
	private String invoiceNumber;
	private String invoiceDate;
	private String approveStatus;
	private String location;
	private double creditAmount;
	private double creditAmountUSD;
	private String company;
	private String narration;
	private String companyCode;
	private String entityName;
	private String cbpdtlpaymentreceipt;

	private ArrayList<CreditNoteDetailBean> credittables;

	private List<CreditNoteBean> acctHeadList;
	private List<CreditNoteBean> invoiceList;

	public List<CreditNoteBean> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<CreditNoteBean> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public List<CreditNoteBean> getAcctHeadList() {
		return acctHeadList;
	}

	public void setAcctHeadList(List<CreditNoteBean> acctHeadList) {
		this.acctHeadList = acctHeadList;
	}

	public String getCreditNoteCode() {
		return creditNoteCode;
	}

	public void setCreditNoteCode(String creditNoteCode) {
		this.creditNoteCode = creditNoteCode;
	}

	public String getCreditNoteDate() {
		return creditNoteDate;
	}

	public void setCreditNoteDate(String creditNoteDate) {
		this.creditNoteDate = creditNoteDate;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
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

	public double getExgRate() {
		return exgRate;
	}

	public void setExgRate(double exgRate) {
		this.exgRate = exgRate;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getCurrFrom() {
		return currFrom;
	}

	public void setCurrFrom(String currFrom) {
		this.currFrom = currFrom;
	}

	public String getCurrTo() {
		return currTo;
	}

	public void setCurrTo(String currTo) {
		this.currTo = currTo;
	}

	public String getMloName() {
		return mloName;
	}

	public void setMloName(String mloName) {
		this.mloName = mloName;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public double getCreditAmountUSD() {
		return creditAmountUSD;
	}

	public void setCreditAmountUSD(double creditAmountUSD) {
		this.creditAmountUSD = creditAmountUSD;
	}

	public String getCompany() {
		return company;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
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

	public ArrayList<CreditNoteDetailBean> getCredittables() {
		return credittables;
	}

	public void setCredittables(ArrayList<CreditNoteDetailBean> credittables) {
		this.credittables = credittables;
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

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getCbpdtlpaymentreceipt() {
		return cbpdtlpaymentreceipt;
	}

	public void setCbpdtlpaymentreceipt(String cbpdtlpaymentreceipt) {
		this.cbpdtlpaymentreceipt = cbpdtlpaymentreceipt;
	}

	
	
}
