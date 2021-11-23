package com.dci.tenant.finance.reports.financials.invoiceInformation;


public class InvoiceOrOrderBean {
	
	private String purchaseInvoiceNo;
	private String invoiceDate;
	private String supplier;
	private String company;
	private String purchaseOrderNo;
	private String paymentOrderNO;
	private String paymentOrderDate;
	private double amount;
	
	
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}
	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}
	
	public String getPaymentOrderNO() {
		return paymentOrderNO;
	}
	public void setPaymentOrderNO(String paymentOrderNO) {
		this.paymentOrderNO = paymentOrderNO;
	}
	public String getPurchaseInvoiceNo() {
		return purchaseInvoiceNo;
	}
	public void setPurchaseInvoiceNo(String purchaseInvoiceNo) {
		this.purchaseInvoiceNo = purchaseInvoiceNo;
	}
	public String getPaymentOrderDate() {
		return paymentOrderDate;
	}
	public void setPaymentOrderDate(String paymentOrderDate) {
		this.paymentOrderDate = paymentOrderDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}