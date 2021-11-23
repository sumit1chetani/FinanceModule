package com.dci.tenant.finance.paymentInformation;

public class PaymentInformationDetailBean {

	private String supplier;
	private int supplierId;
	private String partyInvoiceNo;
	private String partyInvoiceDt;
	private String InvoiceDate;
	private String invoiceNo;
	private String companyCode;
	private String paymentStatus;
	private int paymentOrderDetailId;
	private boolean select;
	private double totalPaidBcAmt;
	private double totatlPaidTcAmt;
	private String invoiceDt;
	private String dueDt;
	private String companyName;
	private String currencyCode;
	private double exchangeRate;
	private double invBcAmt;
	private double invTcAmt;
	private double payableTcAmt;
	private double payableBcAmt;
	private double payableAmt;
	private double tcBalanceAmt;
	private double bcBalanceAmt;

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getPartyInvoiceNo() {
		return partyInvoiceNo;
	}

	public void setPartyInvoiceNo(String partyInvoiceNo) {
		this.partyInvoiceNo = partyInvoiceNo;
	}

	public String getPartyInvoiceDt() {
		return partyInvoiceDt;
	}

	public void setPartyInvoiceDt(String partyInvoiceDt) {
		this.partyInvoiceDt = partyInvoiceDt;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDt() {
		return invoiceDt;
	}

	public void setInvoiceDt(String invoiceDt) {
		this.invoiceDt = invoiceDt;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getInvBcAmt() {
		return invBcAmt;
	}

	public void setInvBcAmt(double invBcAmt) {
		this.invBcAmt = invBcAmt;
	}

	public double getInvTcAmt() {
		return invTcAmt;
	}

	public void setInvTcAmt(double invTcAmt) {
		this.invTcAmt = invTcAmt;
	}

	public double getPayableTcAmt() {
		return payableTcAmt;
	}

	public void setPayableTcAmt(double payableTcAmt) {
		this.payableTcAmt = payableTcAmt;
	}

	public double getPayableBcAmt() {
		return payableBcAmt;
	}

	public void setPayableBcAmt(double payableBcAmt) {
		this.payableBcAmt = payableBcAmt;
	}

	public String getDueDt() {
		return dueDt;
	}

	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getInvoiceDate() {
		return InvoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		InvoiceDate = invoiceDate;
	}

	public int getPaymentOrderDetailId() {
		return paymentOrderDetailId;
	}

	public void setPaymentOrderDetailId(int paymentOrderDetailId) {
		this.paymentOrderDetailId = paymentOrderDetailId;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public double getTcBalanceAmt() {
		return tcBalanceAmt;
	}

	public void setTcBalanceAmt(double tcBalanceAmt) {
		this.tcBalanceAmt = tcBalanceAmt;
	}

	public double getBcBalanceAmt() {
		return bcBalanceAmt;
	}

	public void setBcBalanceAmt(double bcBalanceAmt) {
		this.bcBalanceAmt = bcBalanceAmt;
	}

	public double getTotalPaidBcAmt() {
		return totalPaidBcAmt;
	}

	public void setTotalPaidBcAmt(double totalPaidBcAmt) {
		this.totalPaidBcAmt = totalPaidBcAmt;
	}

	public double getTotatlPaidTcAmt() {
		return totatlPaidTcAmt;
	}

	public void setTotatlPaidTcAmt(double totatlPaidTcAmt) {
		this.totatlPaidTcAmt = totatlPaidTcAmt;
	}

	public double getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(double payableAmt) {
		this.payableAmt = payableAmt;
	}

}
