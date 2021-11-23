package com.dci.tenant.finance.cashbankpayment;

public class CashBankPaymentInvoiceDetailBean {

	private int cbPmtInvDtlId;
	private int cashBankPmtDtlId;
	private Double bcInvAmt;
	private Double tcInvAmt;
	private String currency;

	public String getDtlnarration() {
		return dtlnarration;
	}

	public void setDtlnarration(String dtlnarration) {
		this.dtlnarration = dtlnarration;
	}

	private String dtlnarration;

	private Double exchangeRate;
	private Double bcPaidAmt;
	private Double tcPaidAmt;
	private Double bcBalanceAmt;
	private Double tcBalanceAmt;
	private String pInvoiceNo;
	private String fromDate;
	private String toDate;
	private boolean select = false;
	private String accountHeadCode;
	private String approvedByName;
	private String approvedDate;
	private double bcAmount;
	private String companyCode;
	private String createdByName;
	private double currencyFraction;
	private String detailBeans;
	private String dueDate;
	private String invoiceDate;
	private String invoiceNo;
	private double paidAmount;
	private String paidBCAmount;
	private String paidTCAmount;
	private String partyInvoiceDate;
	private String partyInvoiceNo;
	private String payAmount;
	private double payTCAmount;
	private String paymentOrderDate;
	private String paymentOrderNo;
	private double pendingAmount;
	private String piFromDate;
	private String piToDate;
	private double poBcamt;
	private double poTcamt;
	private String sPayAmount;
	private String sPayTCAmount;
	private String status;
	private String supplier;
	private String supplierName;
	private double tcAmount;
	private String totalBC;
	private double totalPayAmount;
	private double totalPayTCAmount;
	private String totalTC;

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public String getApprovedByName() {
		return approvedByName;
	}

	public void setApprovedByName(String approvedByName) {
		this.approvedByName = approvedByName;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public double getBcAmount() {
		return bcAmount;
	}

	public void setBcAmount(double bcAmount) {
		this.bcAmount = bcAmount;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public double getCurrencyFraction() {
		return currencyFraction;
	}

	public void setCurrencyFraction(double currencyFraction) {
		this.currencyFraction = currencyFraction;
	}

	public String getDetailBeans() {
		return detailBeans;
	}

	public void setDetailBeans(String detailBeans) {
		this.detailBeans = detailBeans;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaidBCAmount() {
		return paidBCAmount;
	}

	public void setPaidBCAmount(String paidBCAmount) {
		this.paidBCAmount = paidBCAmount;
	}

	public String getPaidTCAmount() {
		return paidTCAmount;
	}

	public void setPaidTCAmount(String paidTCAmount) {
		this.paidTCAmount = paidTCAmount;
	}

	public String getPartyInvoiceDate() {
		return partyInvoiceDate;
	}

	public void setPartyInvoiceDate(String partyInvoiceDate) {
		this.partyInvoiceDate = partyInvoiceDate;
	}

	public String getPartyInvoiceNo() {
		return partyInvoiceNo;
	}

	public void setPartyInvoiceNo(String partyInvoiceNo) {
		this.partyInvoiceNo = partyInvoiceNo;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public double getPayTCAmount() {
		return payTCAmount;
	}

	public void setPayTCAmount(double payTCAmount) {
		this.payTCAmount = payTCAmount;
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

	public double getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
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

	public double getPoBcamt() {
		return poBcamt;
	}

	public void setPoBcamt(double poBcamt) {
		this.poBcamt = poBcamt;
	}

	public double getPoTcamt() {
		return poTcamt;
	}

	public void setPoTcamt(double poTcamt) {
		this.poTcamt = poTcamt;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public double getTcAmount() {
		return tcAmount;
	}

	public void setTcAmount(double tcAmount) {
		this.tcAmount = tcAmount;
	}

	public String getTotalBC() {
		return totalBC;
	}

	public void setTotalBC(String totalBC) {
		this.totalBC = totalBC;
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

	public String getTotalTC() {
		return totalTC;
	}

	public void setTotalTC(String totalTC) {
		this.totalTC = totalTC;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public int getCbPmtInvDtlId() {
		return cbPmtInvDtlId;
	}

	public void setCbPmtInvDtlId(int cbPmtInvDtlId) {
		this.cbPmtInvDtlId = cbPmtInvDtlId;
	}

	public int getCashBankPmtDtlId() {
		return cashBankPmtDtlId;
	}

	public void setCashBankPmtDtlId(int cashBankPmtDtlId) {
		this.cashBankPmtDtlId = cashBankPmtDtlId;
	}

	public String getpInvoiceNo() {
		return pInvoiceNo;
	}

	public void setpInvoiceNo(String pInvoiceNo) {
		this.pInvoiceNo = pInvoiceNo;
	}

	public Double getBcInvAmt() {
		return bcInvAmt;
	}

	public void setBcInvAmt(Double bcInvAmt) {
		this.bcInvAmt = bcInvAmt;
	}

	public Double getTcInvAmt() {
		return tcInvAmt;
	}

	public void setTcInvAmt(Double tcInvAmt) {
		this.tcInvAmt = tcInvAmt;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Double getBcPaidAmt() {
		return bcPaidAmt;
	}

	public void setBcPaidAmt(Double bcPaidAmt) {
		this.bcPaidAmt = bcPaidAmt;
	}

	public Double getTcPaidAmt() {
		return tcPaidAmt;
	}

	public void setTcPaidAmt(Double tcPaidAmt) {
		this.tcPaidAmt = tcPaidAmt;
	}

	public Double getBcBalanceAmt() {
		return bcBalanceAmt;
	}

	public void setBcBalanceAmt(Double bcBalanceAmt) {
		this.bcBalanceAmt = bcBalanceAmt;
	}

	public Double getTcBalanceAmt() {
		return tcBalanceAmt;
	}

	public void setTcBalanceAmt(Double tcBalanceAmt) {
		this.tcBalanceAmt = tcBalanceAmt;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

}
