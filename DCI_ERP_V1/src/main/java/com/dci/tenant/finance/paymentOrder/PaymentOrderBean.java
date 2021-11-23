package com.dci.tenant.finance.paymentOrder;

import com.dci.tenant.finance.paymentInformation.PaymentInformationBean;

public class PaymentOrderBean {

	private String paymentOrderDate;
	private String paymentOrderNo;
	private String voucherNumber;
	private String chequeDate;
	private double poTcamt;
	private boolean select;
	private PaymentInformationBean invoiceDtlBean;
	private int chequeId;
	private double poBcamt;
	private String companyCode;
	private String bankAccountType;
	private String currency;
	private String chequeNo;
	private double cashPayTcAmt;
	private double cashPayBcAmt;
	private double cashPayExRate;
	private String cashPaycurrency;
	private String acctHead;
	private String id;
	private String text;
	private double exRate;
	private String entityName;
	private String supplier;
	private String invoiceref;

	public String getInvoiceref() {
		return invoiceref;
	}

	public void setInvoiceref(String invoiceref) {
		this.invoiceref = invoiceref;
	}

	public String getPaymentOrderDate() {
		return paymentOrderDate;
	}

	public void setPaymentOrderDate(String paymentOrderDate) {
		this.paymentOrderDate = paymentOrderDate;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getExRate() {
		return exRate;
	}

	public void setExRate(double exRate) {
		this.exRate = exRate;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAcctHead() {
		return acctHead;
	}

	public void setAcctHead(String acctHead) {
		this.acctHead = acctHead;
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

	public double getCashPayTcAmt() {
		return cashPayTcAmt;
	}

	public void setCashPayTcAmt(double cashPayTcAmt) {
		this.cashPayTcAmt = cashPayTcAmt;
	}

	public double getCashPayBcAmt() {
		return cashPayBcAmt;
	}

	public void setCashPayBcAmt(double cashPayBcAmt) {
		this.cashPayBcAmt = cashPayBcAmt;
	}

	public double getCashPayExRate() {
		return cashPayExRate;
	}

	public void setCashPayExRate(double cashPayExRate) {
		this.cashPayExRate = cashPayExRate;
	}

	public String getCashPaycurrency() {
		return cashPaycurrency;
	}

	public void setCashPaycurrency(String cashPaycurrency) {
		this.cashPaycurrency = cashPaycurrency;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getBankAccountType() {
		return bankAccountType;
	}

	public void setBankAccountType(String bankAccountType) {
		this.bankAccountType = bankAccountType;
	}

	public String getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public String getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	public int getChequeId() {
		return chequeId;
	}

	public void setChequeId(int chequeId) {
		this.chequeId = chequeId;
	}

	public PaymentInformationBean getInvoiceDtlBean() {
		return invoiceDtlBean;
	}

	public void setInvoiceDtlBean(PaymentInformationBean invoiceDtlBean) {
		this.invoiceDtlBean = invoiceDtlBean;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

}
