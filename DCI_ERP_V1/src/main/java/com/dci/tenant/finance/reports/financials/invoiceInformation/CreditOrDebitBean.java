package com.dci.tenant.finance.reports.financials.invoiceInformation;


public class CreditOrDebitBean {
	
	private String invoiceNo;
	private String invoiceDate;
	private String creditNoteNo;
	private String debitNoteNo;
	private String companyName;
	private String payerName;
	private String voyage;
	private String vessel;
	private double amount;
	
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
	public String getCreditNoteNo() {
		return creditNoteNo;
	}
	public void setCreditNoteNo(String creditNoteNo) {
		this.creditNoteNo = creditNoteNo;
	}
	public String getDebitNoteNo() {
		return debitNoteNo;
	}
	public void setDebitNoteNo(String debitNoteNo) {
		this.debitNoteNo = debitNoteNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getVoyage() {
		return voyage;
	}
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	public String getVessel() {
		return vessel;
	}
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
}