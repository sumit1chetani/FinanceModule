package com.dci.tenant.finance.paymentInformation;

import java.util.List;

public class PaymentInformationBean {
	private String fromDate;
	private String toDate;
	private String paymentOrderNo;
	private double poTcamt;
	private String status;
	private boolean select;
	private double poBcamt;
	private String supplierName;
	private String approvedDate;
	private String paymentOrderDate;
	private String supplier;
	private String companyCode;

	// for pending Payment Information List
	private String accountHeadCode;
	private String piFromDate;
	private String piToDate;
	private String totalBC;
	private String totalTC;

	private String dueDate;
	private String partyInvoiceNo;
	// private partyInvoiceNo;
	private String partyInvoiceDate;
	private String invoiceNo;
	private String invoiceDate;
	private String currency;
	private Double bcAmount;
	private Double tcAmount;
	private double exchangeRate;
	private Double pendingAmount;
	private Double paidAmount;
	private double payAmount;
	private double payTCAmount;
	private double totalPayAmount;
	private double totalPayTCAmount;

	private String sPayAmount;
	private String sPayTCAmount;

	private int currencyFraction;
	private String approvedByName;
	private String createdByName;
	private String paidTCAmount;

	public String getPaidTCAmount() {
		return paidTCAmount;
	}

	public void setPaidTCAmount(String paidTCAmount) {
		this.paidTCAmount = paidTCAmount;
	}

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public String getPiFromDate() {
		return piFromDate;
	}

	public void setPiFromDate(String piFromDate) {
		this.piFromDate = piFromDate;
	}

	public String getPiToDate() {
		return piToDate;
	}

	public void setPiToDate(String piToDate) {
		this.piToDate = piToDate;
	}

	public String getTotalBC() {
		return totalBC;
	}

	public void setTotalBC(String totalBC) {
		this.totalBC = totalBC;
	}

	public String getTotalTC() {
		return totalTC;
	}

	public void setTotalTC(String totalTC) {
		this.totalTC = totalTC;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getBcAmount() {
		return bcAmount;
	}

	public void setBcAmount(Double bcAmount) {
		this.bcAmount = bcAmount;
	}

	public Double getTcAmount() {
		return tcAmount;
	}

	public void setTcAmount(Double tcAmount) {
		this.tcAmount = tcAmount;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Double getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(Double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public double getPayTCAmount() {
		return payTCAmount;
	}

	public void setPayTCAmount(double payTCAmount) {
		this.payTCAmount = payTCAmount;
	}

	public double getTotalPayAmount() {
		return totalPayAmount;
	}

	public void setTotalPayAmount(double totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}

	public double getTotalPayTCAmount() {
		return totalPayTCAmount;
	}

	public void setTotalPayTCAmount(double totalPayTCAmount) {
		this.totalPayTCAmount = totalPayTCAmount;
	}

	public String getsPayAmount() {
		return sPayAmount;
	}

	public void setsPayAmount(String sPayAmount) {
		this.sPayAmount = sPayAmount;
	}

	public String getsPayTCAmount() {
		return sPayTCAmount;
	}

	public void setsPayTCAmount(String sPayTCAmount) {
		this.sPayTCAmount = sPayTCAmount;
	}

	public int getCurrencyFraction() {
		return currencyFraction;
	}

	public void setCurrencyFraction(int currencyFraction) {
		this.currencyFraction = currencyFraction;
	}

	public String getApprovedByName() {
		return approvedByName;
	}

	public void setApprovedByName(String approvedByName) {
		this.approvedByName = approvedByName;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	private List<PaymentInformationDetailBean> detailBeans;

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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public List<PaymentInformationDetailBean> getDetailBeans() {
		return detailBeans;
	}

	public void setDetailBeans(List<PaymentInformationDetailBean> detailBeans) {
		this.detailBeans = detailBeans;
	}

	public String getPaymentOrderNo() {
		return paymentOrderNo;
	}

	public void setPaymentOrderNo(String paymentOrderNo) {
		this.paymentOrderNo = paymentOrderNo;
	}

	public double getPoTcamt() {
		return poTcamt;
	}

	public void setPoTcamt(double poTcamt) {
		this.poTcamt = poTcamt;
	}

	public double getPoBcamt() {
		return poBcamt;
	}

	public void setPoBcamt(double poBcamt) {
		this.poBcamt = poBcamt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getPaymentOrderDate() {
		return paymentOrderDate;
	}

	public void setPaymentOrderDate(String paymentOrderDate) {
		this.paymentOrderDate = paymentOrderDate;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}
}
