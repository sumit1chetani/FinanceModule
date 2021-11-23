package com.dci.tenant.finance.paymentReport;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class PaymentHistoryReportBean extends BasicResultBean {
	private String voucherNo;
	private String voucherDate;
	private String acctHeadCode;
	private String accountName;
	private double bcAmountHdr;
	private double tcAmountHdr;

	private int paymentDtlId;
	private String purInvoiceNo;
	private String purInvoiceDate;
	private String supplier;
	private String supplierCode;
	private String supplierName;
	private String dueDate;
	private String currencyCode;
	private String currency;
	private String fromDate;
	private String toDate;
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	private double exchangeRate;
	private double bcAmountDtl;
	private double tcAmountDtl;

	private double invoiceBCAmt;
	private double paidAmountBC;
	private double bcBalanceAmt;

	private double invoiceTCAmt;
	private double paidAmountTC;
	private double tcBalanceAmt;

	private String filePath;

	private List<PaymentHistoryReportBean> pendingRptDtlList;

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(String voucherDate) {
		this.voucherDate = voucherDate;
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

	public double getBcAmountHdr() {
		return bcAmountHdr;
	}

	public void setBcAmountHdr(double bcAmountHdr) {
		this.bcAmountHdr = bcAmountHdr;
	}

	public double getTcAmountHdr() {
		return tcAmountHdr;
	}

	public void setTcAmountHdr(double tcAmountHdr) {
		this.tcAmountHdr = tcAmountHdr;
	}

	public int getPaymentDtlId() {
		return paymentDtlId;
	}

	public void setPaymentDtlId(int paymentDtlId) {
		this.paymentDtlId = paymentDtlId;
	}

	public String getPurInvoiceNo() {
		return purInvoiceNo;
	}

	public void setPurInvoiceNo(String purInvoiceNo) {
		this.purInvoiceNo = purInvoiceNo;
	}

	public String getPurInvoiceDate() {
		return purInvoiceDate;
	}

	public void setPurInvoiceDate(String purInvoiceDate) {
		this.purInvoiceDate = purInvoiceDate;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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

	public double getBcAmountDtl() {
		return bcAmountDtl;
	}

	public void setBcAmountDtl(double bcAmountDtl) {
		this.bcAmountDtl = bcAmountDtl;
	}

	public double getTcAmountDtl() {
		return tcAmountDtl;
	}

	public void setTcAmountDtl(double tcAmountDtl) {
		this.tcAmountDtl = tcAmountDtl;
	}

	public List<PaymentHistoryReportBean> getPendingRptDtlList() {
		return pendingRptDtlList;
	}

	public void setPendingRptDtlList(List<PaymentHistoryReportBean> pendingRptDtlList) {
		this.pendingRptDtlList = pendingRptDtlList;
	}

	public double getInvoiceBCAmt() {
		return invoiceBCAmt;
	}

	public void setInvoiceBCAmt(double invoiceBCAmt) {
		this.invoiceBCAmt = invoiceBCAmt;
	}

	public double getPaidAmountBC() {
		return paidAmountBC;
	}

	public void setPaidAmountBC(double paidAmountBC) {
		this.paidAmountBC = paidAmountBC;
	}

	public double getInvoiceTCAmt() {
		return invoiceTCAmt;
	}

	public void setInvoiceTCAmt(double invoiceTCAmt) {
		this.invoiceTCAmt = invoiceTCAmt;
	}

	public double getPaidAmountTC() {
		return paidAmountTC;
	}

	public void setPaidAmountTC(double paidAmountTC) {
		this.paidAmountTC = paidAmountTC;
	}

	public double getBcBalanceAmt() {
		return bcBalanceAmt;
	}

	public void setBcBalanceAmt(double bcBalanceAmt) {
		this.bcBalanceAmt = bcBalanceAmt;
	}

	public double getTcBalanceAmt() {
		return tcBalanceAmt;
	}

	public void setTcBalanceAmt(double tcBalanceAmt) {
		this.tcBalanceAmt = tcBalanceAmt;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
