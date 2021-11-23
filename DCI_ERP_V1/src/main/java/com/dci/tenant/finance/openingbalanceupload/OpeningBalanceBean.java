package com.dci.tenant.finance.openingbalanceupload;

public class OpeningBalanceBean {
	private String invoiceNo;
	private String invoiceDate;
	private Double tcAmount;
	private Double bcAmount;
	private String tcAmount1;
	private String bcAmount1;
	private Double debit;
	private Double credit;

	public Double getDebit() {
		return debit;
	}

	public void setDebit(Double debit) {
		this.debit = debit;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public String getTcAmount1() {
		return tcAmount1;
	}

	public void setTcAmount1(String tcAmount1) {
		this.tcAmount1 = tcAmount1;
	}

	public String getBcAmount1() {
		return bcAmount1;
	}

	public void setBcAmount1(String bcAmount1) {
		this.bcAmount1 = bcAmount1;
	}

	private Double exchangeRate;
	private String currency;
	private String oldCutomerCode;
	private String customerCode;
	private String customerName;
	private String companyCode;
	private String companyName;
	private String mloCode;
	private String customer;
	private Integer company;
	private String companyId;
	private Integer transactionid;
	private String accountHead;
	private String subAccount;
	private String accountHeadName;
	private String finYear;
	private String createdby;
	private String createdDate;
	private String fromdate;
	private String todate;

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public String getSubAccount() {
		return subAccount;
	}

	public void setSubAccount(String subAccount) {
		this.subAccount = subAccount;
	}

	public Integer getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(Integer transactionid) {
		this.transactionid = transactionid;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	private String sundryStatus;

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public Double getTcAmount() {
		return tcAmount;
	}

	public void setTcAmount(Double tcAmount) {
		this.tcAmount = tcAmount;
	}

	public Double getBcAmount() {
		return bcAmount;
	}

	public void setBcAmount(Double bcAmount) {
		this.bcAmount = bcAmount;
	}

	public String getOldCutomerCode() {
		return oldCutomerCode;
	}

	public void setOldCutomerCode(String oldCutomerCode) {
		this.oldCutomerCode = oldCutomerCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMloCode() {
		return mloCode;
	}

	public void setMloCode(String mloCode) {
		this.mloCode = mloCode;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Integer getCompany() {
		return company;
	}

	public void setCompany(Integer company) {
		this.company = company;
	}

	public String getSundryStatus() {
		return sundryStatus;
	}

	public void setSundryStatus(String sundryStatus) {
		this.sundryStatus = sundryStatus;
	}

}
