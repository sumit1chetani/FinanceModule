package com.dci.tenant.finance.cashbankreceipt;

public class CashBankReceiptInvoiceDetailBean {
	private int cbRcptInvDtlId;
	private int cashBankRcptDtlId;
	private Double bcInvAmt;
	private Double tcInvAmt;
	private String currency;
	private Double exchangeRate;
	private Double bcPaidAmt;
	private Double tcPaidAmt;
	private Double bcBalanceAmt;
	private Double tcBalanceAmt;
	private String gInvoiceNo;
	private String fromDate;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	private String dtlnarration;

	private int cbPmtInvDtlId;
	private int cashBankPmtDtlId;

	private String pInvoiceNo;

	public String getCbVoucherNo() {
		return cbVoucherNo;
	}

	public void setCbVoucherNo(String cbVoucherNo) {
		this.cbVoucherNo = cbVoucherNo;
	}

	public String getCbpdtlAccountHead() {
		return cbpdtlAccountHead;
	}

	public void setCbpdtlAccountHead(String cbpdtlAccountHead) {
		this.cbpdtlAccountHead = cbpdtlAccountHead;
	}

	public String getCbpdtlPmtOrderNo() {
		return cbpdtlPmtOrderNo;
	}

	public void setCbpdtlPmtOrderNo(String cbpdtlPmtOrderNo) {
		this.cbpdtlPmtOrderNo = cbpdtlPmtOrderNo;
	}

	public String getCbpdtlCurrencyCode() {
		return cbpdtlCurrencyCode;
	}

	public void setCbpdtlCurrencyCode(String cbpdtlCurrencyCode) {
		this.cbpdtlCurrencyCode = cbpdtlCurrencyCode;
	}

	public double getCbpdtlExgRate() {
		return cbpdtlExgRate;
	}

	public void setCbpdtlExgRate(double cbpdtlExgRate) {
		this.cbpdtlExgRate = cbpdtlExgRate;
	}

	public double getCbpDtlBcAmount() {
		return cbpDtlBcAmount;
	}

	public void setCbpDtlBcAmount(double cbpDtlBcAmount) {
		this.cbpDtlBcAmount = cbpDtlBcAmount;
	}

	public double getCbpDtlTcAmount() {
		return cbpDtlTcAmount;
	}

	public void setCbpDtlTcAmount(double cbpDtlTcAmount) {
		this.cbpDtlTcAmount = cbpDtlTcAmount;
	}

	public String getCbpdtlSubgroupCode() {
		return cbpdtlSubgroupCode;
	}

	public void setCbpdtlSubgroupCode(String cbpdtlSubgroupCode) {
		this.cbpdtlSubgroupCode = cbpdtlSubgroupCode;
	}

	public String getCbdtlsubAccountCode() {
		return cbdtlsubAccountCode;
	}

	public void setCbdtlsubAccountCode(String cbdtlsubAccountCode) {
		this.cbdtlsubAccountCode = cbdtlsubAccountCode;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	private String employeeCode;
	private String departmentCode;
	private String countryCode;
	private String customerCode;
	private String supplierCode;
	private Integer designationCode;
	private Integer costCenter;
	private String companyCode;
	private Integer patientCode;
	private String purInvoiceNo;
	private String acctHeadCode;
	private String subAccountName;
	private String accountHeadName;

	private String scbpDtlTcAmount;
	private String scbpDtlBcAmount;

	private double countamt;
	private double rupessAmt;
	private double denomAmt;
	private double totalCashAmount;
	private int cashBankPmtDtlIdcash;

	private int budgetDefnId;

	private double budgetAmt;
	private double budgetUtilizedAmt;
	// Pending Invoice Details
	private boolean currencyFlag;
	private String cbVoucherNo;
	private String cbpdtlAccountHead;
	private String cbpdtlPmtOrderNo;
	private String cbpdtlCurrencyCode;
	private double cbpdtlExgRate;
	private double cbpDtlBcAmount;
	private double cbpDtlTcAmount;
	private String cbpdtlSubgroupCode;
	private String cbdtlsubAccountCode;

	private int slNo;

	public String getDtlnarration() {
		return dtlnarration;
	}

	public void setDtlnarration(String dtlnarration) {
		this.dtlnarration = dtlnarration;
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

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

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

	private String toDate;
	private boolean select = false;
	private String accountHeadCode;
	private String approvedByName;
	private String approvedDate;
	private double bcAmount;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public Integer getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(Integer designationCode) {
		this.designationCode = designationCode;
	}

	public Integer getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(Integer costCenter) {
		this.costCenter = costCenter;
	}

	public Integer getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(Integer patientCode) {
		this.patientCode = patientCode;
	}

	public String getPurInvoiceNo() {
		return purInvoiceNo;
	}

	public void setPurInvoiceNo(String purInvoiceNo) {
		this.purInvoiceNo = purInvoiceNo;
	}

	public String getAcctHeadCode() {
		return acctHeadCode;
	}

	public void setAcctHeadCode(String acctHeadCode) {
		this.acctHeadCode = acctHeadCode;
	}

	public String getSubAccountName() {
		return subAccountName;
	}

	public void setSubAccountName(String subAccountName) {
		this.subAccountName = subAccountName;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public String getScbpDtlTcAmount() {
		return scbpDtlTcAmount;
	}

	public void setScbpDtlTcAmount(String scbpDtlTcAmount) {
		this.scbpDtlTcAmount = scbpDtlTcAmount;
	}

	public String getScbpDtlBcAmount() {
		return scbpDtlBcAmount;
	}

	public void setScbpDtlBcAmount(String scbpDtlBcAmount) {
		this.scbpDtlBcAmount = scbpDtlBcAmount;
	}

	public double getCountamt() {
		return countamt;
	}

	public void setCountamt(double countamt) {
		this.countamt = countamt;
	}

	public double getRupessAmt() {
		return rupessAmt;
	}

	public void setRupessAmt(double rupessAmt) {
		this.rupessAmt = rupessAmt;
	}

	public double getDenomAmt() {
		return denomAmt;
	}

	public void setDenomAmt(double denomAmt) {
		this.denomAmt = denomAmt;
	}

	public double getTotalCashAmount() {
		return totalCashAmount;
	}

	public void setTotalCashAmount(double totalCashAmount) {
		this.totalCashAmount = totalCashAmount;
	}

	public int getCashBankPmtDtlIdcash() {
		return cashBankPmtDtlIdcash;
	}

	public void setCashBankPmtDtlIdcash(int cashBankPmtDtlIdcash) {
		this.cashBankPmtDtlIdcash = cashBankPmtDtlIdcash;
	}

	public int getBudgetDefnId() {
		return budgetDefnId;
	}

	public void setBudgetDefnId(int budgetDefnId) {
		this.budgetDefnId = budgetDefnId;
	}

	public double getBudgetAmt() {
		return budgetAmt;
	}

	public void setBudgetAmt(double budgetAmt) {
		this.budgetAmt = budgetAmt;
	}

	public double getBudgetUtilizedAmt() {
		return budgetUtilizedAmt;
	}

	public void setBudgetUtilizedAmt(double budgetUtilizedAmt) {
		this.budgetUtilizedAmt = budgetUtilizedAmt;
	}

	public boolean isCurrencyFlag() {
		return currencyFlag;
	}

	public void setCurrencyFlag(boolean currencyFlag) {
		this.currencyFlag = currencyFlag;
	}

	private String createdByName;
	private double currencyFraction;
	private String detailBeans;
	private String dueDate;
	private String invoiceDate;
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
	private String invoiceNo;
	private double receivedAmount;

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public double getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public int getCbRcptInvDtlId() {
		return cbRcptInvDtlId;
	}

	public void setCbRcptInvDtlId(int cbRcptInvDtlId) {
		this.cbRcptInvDtlId = cbRcptInvDtlId;
	}

	public int getCashBankRcptDtlId() {
		return cashBankRcptDtlId;
	}

	public void setCashBankRcptDtlId(int cashBankRcptDtlId) {
		this.cashBankRcptDtlId = cashBankRcptDtlId;
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

	public String getgInvoiceNo() {
		return gInvoiceNo;
	}

	public void setgInvoiceNo(String gInvoiceNo) {
		this.gInvoiceNo = gInvoiceNo;
	}

}
