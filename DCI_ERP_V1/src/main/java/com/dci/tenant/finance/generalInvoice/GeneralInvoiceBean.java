package com.dci.tenant.finance.generalInvoice;

import java.io.Serializable;
import java.util.List;

public class GeneralInvoiceBean implements Serializable {

	public String invoiceNo;
	public String invoiceDate;
	public String company;
	public int salesOrderNo;
	private int ginId;
	public int tax;

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	private int customerPaymentTerms;
	public String customer;
	private int taxAccountId;
	private String currency;
	private String compGst;

	public String getCustgst() {
		return custgst;
	}

	public void setCustgst(String custgst) {
		this.custgst = custgst;
	}

	private String custgst;

	public String getCompGst() {
		return compGst;
	}

	public void setCompGst(String compGst) {
		this.compGst = compGst;
	}

	private double exchangeRate;
	public String manualInvoiceNo;
	public String dueDate;
	public String remarks;
	public String costCenter;
	private String salesOrderCode;
	private String ginCode;

	public double amount;
	public double tcamount;
	public double productTotal;
	public double chargeTotal;
	public double grantamount;
	private double productTotalWithoutTax;

	private String receivedStatus;

	private List<GeneralInvoiceDetailBean> invoiceDetail;
	private List<GeneralInvoiceProductDetailBean> invoiceProdDetail;
	public List<GeneralInvoiceBean> salesOrderList;

	public String id;
	public String text;

	private String companyName;

	private String accountName;

	private String subGroupName;

	private String customerName;

	private String accountHeadCode;
	private String cityName;

	private String custAddress;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public String getCustomerName() {
		return customerName;

	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getSubGroupName() {
		return subGroupName;
	}

	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalesOrderNo() {
		return salesOrderNo;
	}

	public void setSalesOrderNo(int salesOrderNo) {
		this.salesOrderNo = salesOrderNo;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getManualInvoiceNo() {
		return manualInvoiceNo;
	}

	public void setManualInvoiceNo(String manualInvoiceNo) {
		this.manualInvoiceNo = manualInvoiceNo;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(double productTotal) {
		this.productTotal = productTotal;
	}

	public double getChargeTotal() {
		return chargeTotal;
	}

	public void setChargeTotal(double chargeTotal) {
		this.chargeTotal = chargeTotal;
	}

	public double getGrantamount() {
		return grantamount;
	}

	public void setGrantamount(double grantamount) {
		this.grantamount = grantamount;
	}

	public List<GeneralInvoiceDetailBean> getInvoiceDetail() {
		return invoiceDetail;
	}

	public void setInvoiceDetail(List<GeneralInvoiceDetailBean> invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}

	public List<GeneralInvoiceProductDetailBean> getInvoiceProdDetail() {
		return invoiceProdDetail;
	}

	public void setInvoiceProdDetail(List<GeneralInvoiceProductDetailBean> invoiceProdDetail) {
		this.invoiceProdDetail = invoiceProdDetail;
	}

	public List<GeneralInvoiceBean> getSalesOrderList() {
		return salesOrderList;
	}

	public void setSalesOrderList(List<GeneralInvoiceBean> salesOrderList) {
		this.salesOrderList = salesOrderList;
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

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getTcamount() {
		return tcamount;
	}

	public void setTcamount(double tcamount) {
		this.tcamount = tcamount;
	}

	public String getSalesOrderCode() {
		return salesOrderCode;
	}

	public void setSalesOrderCode(String salesOrderCode) {
		this.salesOrderCode = salesOrderCode;
	}

	public String getReceivedStatus() {
		return receivedStatus;
	}

	public void setReceivedStatus(String receivedStatus) {
		this.receivedStatus = receivedStatus;
	}

	public double getProductTotalWithoutTax() {
		return productTotalWithoutTax;
	}

	public void setProductTotalWithoutTax(double productTotalWithoutTax) {
		this.productTotalWithoutTax = productTotalWithoutTax;
	}

	public int getGinId() {
		return ginId;
	}

	public void setGinId(int ginId) {
		this.ginId = ginId;
	}

	public String getGinCode() {
		return ginCode;
	}

	public void setGinCode(String ginCode) {
		this.ginCode = ginCode;
	}

	/**
	 * @return the taxAccountId
	 */
	public int getTaxAccountId() {
		return taxAccountId;
	}

	/**
	 * @param taxAccountId
	 *            the taxAccountId to set
	 */
	public void setTaxAccountId(int taxAccountId) {
		this.taxAccountId = taxAccountId;
	}

	/**
	 * @return the customerPaymentTerms
	 */
	public int getCustomerPaymentTerms() {
		return customerPaymentTerms;
	}

	/**
	 * @param customerPaymentTerms
	 *            the customerPaymentTerms to set
	 */
	public void setCustomerPaymentTerms(int customerPaymentTerms) {
		this.customerPaymentTerms = customerPaymentTerms;
	}

}