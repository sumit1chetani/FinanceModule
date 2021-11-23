package com.dci.tenant.finance.reports.financials.invoiceInformation;

import java.util.List;

import com.dci.common.util.BasicResultBean;

@SuppressWarnings("serial")
public class InvoiceInformationResultBean extends BasicResultBean {
	
	
	private List<CreditOrDebitBean> creditOrDebitList;
	private List<InvoiceOrGeneralBean> invoiceOrGeneralList;
	private List<VoucherOrJournalBean> voucherOrJournalList;
	private Integer result;
	private String resultType;
	private List<CreditOrDebitBean> creditList;
	private List<CreditOrDebitBean> debitList;
	private List<InvoiceOrGeneralBean> invoiceList;
	private List<InvoiceOrGeneralBean> generalInvoiceList;
	private List<VoucherOrJournalBean> journalList;
	private List<InvoiceOrOrderBean> purchaseInvoiceList;
	private List<InvoiceOrOrderBean> paymentOrderList;
	private List<PaymentOrReceipt> paymentList;
	private List<PaymentOrReceipt> receiptList;
	
	public List<CreditOrDebitBean> getCreditOrDebitList() {
		return creditOrDebitList;
	}
	public void setCreditOrDebitList(List<CreditOrDebitBean> creditOrDebitList) {
		this.creditOrDebitList = creditOrDebitList;
	}
	public List<InvoiceOrGeneralBean> getInvoiceOrGeneralList() {
		return invoiceOrGeneralList;
	}
	public void setInvoiceOrGeneralList(List<InvoiceOrGeneralBean> invoiceOrGeneralList) {
		this.invoiceOrGeneralList = invoiceOrGeneralList;
	}
	public List<VoucherOrJournalBean> getVoucherOrJournalList() {
		return voucherOrJournalList;
	}
	public void setVoucherOrJournalList(List<VoucherOrJournalBean> voucherOrJournalList) {
		this.voucherOrJournalList = voucherOrJournalList;
	}
	
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public List<CreditOrDebitBean> getCreditList() {
		return creditList;
	}
	public void setCreditList(List<CreditOrDebitBean> creditList) {
		this.creditList = creditList;
	}
	public List<CreditOrDebitBean> getDebitList() {
		return debitList;
	}
	public void setDebitList(List<CreditOrDebitBean> debitList) {
		this.debitList = debitList;
	}
	public List<InvoiceOrGeneralBean> getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(List<InvoiceOrGeneralBean> invoiceList) {
		this.invoiceList = invoiceList;
	}
	public List<InvoiceOrGeneralBean> getGeneralInvoiceList() {
		return generalInvoiceList;
	}
	public void setGeneralInvoiceList(List<InvoiceOrGeneralBean> generalInvoiceList) {
		this.generalInvoiceList = generalInvoiceList;
	}
	public List<VoucherOrJournalBean> getJournalList() {
		return journalList;
	}
	public void setJournalList(List<VoucherOrJournalBean> journalList) {
		this.journalList = journalList;
	}
	public List<InvoiceOrOrderBean> getPurchaseInvoiceList() {
		return purchaseInvoiceList;
	}
	public void setPurchaseInvoiceList(List<InvoiceOrOrderBean> purchaseInvoiceList) {
		this.purchaseInvoiceList = purchaseInvoiceList;
	}
	public List<InvoiceOrOrderBean> getPaymentOrderList() {
		return paymentOrderList;
	}
	public void setPaymentOrderList(List<InvoiceOrOrderBean> paymentOrderList) {
		this.paymentOrderList = paymentOrderList;
	}
	public List<PaymentOrReceipt> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<PaymentOrReceipt> paymentList) {
		this.paymentList = paymentList;
	}
	public List<PaymentOrReceipt> getReceiptList() {
		return receiptList;
	}
	public void setReceiptList(List<PaymentOrReceipt> receiptList) {
		this.receiptList = receiptList;
	}
	
	
}