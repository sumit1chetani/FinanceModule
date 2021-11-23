package com.dci.tenant.finance.cashbankpayment;

import java.util.List;

public class CashBankPaymentBean {
	private String cbVoucherNo;
	private String cashbankPmtDate;
	private String cbpmtDate;
	private String employeeCode;
private String cbpdtlpaymentHead;
	private String departmentCode;
	private String countryCode;
	private String customerCode;
	private String supplierCode;
	private String designationCode;
	private String patientCode;
private String preparedby;
	public String currencyType;
	
	private String amountinWords;
private String cbVoucherNo1;
	
	private String approvenote;
	public String getAmountinWords() {
		return amountinWords;
	}

	public void setAmountinWords(String amountinWords) {
		this.amountinWords = amountinWords;
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

	public String getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	public String getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public List<CashBankPaymentBean> getInvoicealloc() {
		return invoicealloc;
	}

	public void setInvoicealloc(List<CashBankPaymentBean> invoicealloc) {
		this.invoicealloc = invoicealloc;
	}

	private String pmtType;
	private List<CashBankPaymentBean> invoicealloc;
	private String dtlnarration;
	private String companyName;
	private String chequeNoValue;

	public String getDtlnarration() {
		return dtlnarration;
	}

	public void setDtlnarration(String dtlnarration) {
		this.dtlnarration = dtlnarration;
	}

	private String acctHeadCode;
	private String accountName;
	private String currencyCode;
	private double exchangeRate;
	private double fromCurrency;
	private int chequeNoId;
	private double toCurrency;
	private String chequeNo;
	private String chequeDate;
	private String chequeDt;
	private double currencyFraction;
	private String voyageId;
	private String voyageCode;
	private String vesselCode;
	private String vesselName;
	private String sectorId;
	private String sectorName;
	private double bcAmountHdr;
	private double tcAmountHdr;
	private String paidTo;
	private String narration;
	private String attributeName;
	private String pmtOrderNo;
	private String pmtOrderDate;
	private String pmtOrderAmount;
	private String pmtOrderName;
	private String invoiceNo;
	private String invoices;

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	private double bcAmountDtl;
	private double tcAmountDtl;
	private double amount;
	private String acctCurrency;
	private String compLocationName;
	private String companyAddress;
	private String companyPhoneNo;
	private String companyEmail;
	private String subAccountName;
	private String company1;
	private String acctheadName;

	private double countamt;
	private double rupessAmt;
	private double denomAmt;
	private double totalCashAmount;
	private Integer budgetDefnId;

	private String costName;

	private String budgetDefnName;

	private double budgetAmt;
	private double budgetUtilizedAmt;

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

	public String getBudgetDefnName() {
		return budgetDefnName;
	}

	public void setBudgetDefnName(String budgetDefnName) {
		this.budgetDefnName = budgetDefnName;
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public Integer getBudgetDefnId() {
		return budgetDefnId;
	}

	public void setBudgetDefnId(Integer budgetDefnId) {
		this.budgetDefnId = budgetDefnId;
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

	public String getAcctheadName() {
		return acctheadName;
	}

	public void setAcctheadName(String acctheadName) {
		this.acctheadName = acctheadName;
	}

	public String getCompany1() {
		return company1;
	}

	public void setCompany1(String company1) {
		this.company1 = company1;
	}

	private String scbpDtlTcAmount;
	private String scbpDtlBcAmount;

	private String costCenter;
	private String bankcode;
	private String companyCode;
	private String cashdenomination;
	private int chqBookId;

	public int getChqBookId() {
		return chqBookId;
	}

	public void setChqBookId(int chqBookId) {
		this.chqBookId = chqBookId;
	}

	public String getCashdenomination() {
		return cashdenomination;
	}

	public void setCashdenomination(String cashdenomination) {
		this.cashdenomination = cashdenomination;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getScbpDtlBcAmount() {
		return scbpDtlBcAmount;
	}

	public void setScbpDtlBcAmount(String scbpDtlBcAmount) {
		this.scbpDtlBcAmount = scbpDtlBcAmount;
	}

	public String getScbpDtlTcAmount() {
		return scbpDtlTcAmount;
	}

	public void setScbpDtlTcAmount(String scbpDtlTcAmount) {
		this.scbpDtlTcAmount = scbpDtlTcAmount;
	}

	private boolean select = false;
	private String reverseCb;
	private int chequeStatus;

	public String getAcctCurrency() {
		return acctCurrency;
	}

	public void setAcctCurrency(String acctCurrency) {
		this.acctCurrency = acctCurrency;
	}

	public String getCompLocationName() {
		return compLocationName;
	}

	public void setCompLocationName(String compLocationName) {
		this.compLocationName = compLocationName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyPhoneNo() {
		return companyPhoneNo;
	}

	public void setCompanyPhoneNo(String companyPhoneNo) {
		this.companyPhoneNo = companyPhoneNo;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	private List<CashBankPaymentDetailBean> cbptables;
	private List<CashBankPaymentDetailBean> deletedCBPmtDtlsRow;

	private List<CashBankPaymentDetailBean> deletedCBPmtDtlsRowcash;

	private List<CashBankPaymentBean> lBankList;
	private String id;
	private String text;
	private List<CashBankPaymentDetailBean> cbptablescash;

	public List<CashBankPaymentDetailBean> getDeletedCBPmtDtlsRowcash() {
		return deletedCBPmtDtlsRowcash;
	}

	public void setDeletedCBPmtDtlsRowcash(List<CashBankPaymentDetailBean> deletedCBPmtDtlsRowcash) {
		this.deletedCBPmtDtlsRowcash = deletedCBPmtDtlsRowcash;
	}

	public List<CashBankPaymentDetailBean> getCbptablescash() {
		return cbptablescash;
	}

	public void setCbptablescash(List<CashBankPaymentDetailBean> cbptablescash) {
		this.cbptablescash = cbptablescash;
	}

	public String getInvoices() {
		return invoices;
	}

	public void setInvoices(String invoices) {
		this.invoices = invoices;
	}

	public String getCbVoucherNo() {
		return cbVoucherNo;
	}

	public void setCbVoucherNo(String cbVoucherNo) {
		this.cbVoucherNo = cbVoucherNo;
	}

	public String getCashbankPmtDate() {
		return cashbankPmtDate;
	}

	public void setCashbankPmtDate(String cashbankPmtDate) {
		this.cashbankPmtDate = cashbankPmtDate;
	}

	public String getCbpmtDate() {
		return cbpmtDate;
	}

	public void setCbpmtDate(String cbpmtDate) {
		this.cbpmtDate = cbpmtDate;
	}

	public String getPmtType() {
		return pmtType;
	}

	public void setPmtType(String pmtType) {
		this.pmtType = pmtType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public double getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(double fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public double getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(double toCurrency) {
		this.toCurrency = toCurrency;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getChequeDt() {
		return chequeDt;
	}

	public void setChequeDt(String chequeDt) {
		this.chequeDt = chequeDt;
	}

	public double getCurrencyFraction() {
		return currencyFraction;
	}

	public void setCurrencyFraction(double currencyFraction) {
		this.currencyFraction = currencyFraction;
	}

	public String getVoyageId() {
		return voyageId;
	}

	public void setVoyageId(String voyageId) {
		this.voyageId = voyageId;
	}

	public String getVoyageCode() {
		return voyageCode;
	}

	public void setVoyageCode(String voyageCode) {
		this.voyageCode = voyageCode;
	}

	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
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

	public String getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getPmtOrderNo() {
		return pmtOrderNo;
	}

	public void setPmtOrderNo(String pmtOrderNo) {
		this.pmtOrderNo = pmtOrderNo;
	}

	public String getPmtOrderDate() {
		return pmtOrderDate;
	}

	public void setPmtOrderDate(String pmtOrderDate) {
		this.pmtOrderDate = pmtOrderDate;
	}

	public String getPmtOrderAmount() {
		return pmtOrderAmount;
	}

	public void setPmtOrderAmount(String pmtOrderAmount) {
		this.pmtOrderAmount = pmtOrderAmount;
	}

	public String getPmtOrderName() {
		return pmtOrderName;
	}

	public void setPmtOrderName(String pmtOrderName) {
		this.pmtOrderName = pmtOrderName;
	}

	public List<CashBankPaymentDetailBean> getCbptables() {
		return cbptables;
	}

	public void setCbptables(List<CashBankPaymentDetailBean> cbptables) {
		this.cbptables = cbptables;
	}

	public List<CashBankPaymentBean> getlBankList() {
		return lBankList;
	}

	public void setlBankList(List<CashBankPaymentBean> lBankList) {
		this.lBankList = lBankList;
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

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public String getReverseCb() {
		return reverseCb;
	}

	public void setReverseCb(String reverseCb) {
		this.reverseCb = reverseCb;
	}

	public List<CashBankPaymentDetailBean> getDeletedCBPmtDtlsRow() {
		return deletedCBPmtDtlsRow;
	}

	public void setDeletedCBPmtDtlsRow(List<CashBankPaymentDetailBean> deletedCBPmtDtlsRow) {
		this.deletedCBPmtDtlsRow = deletedCBPmtDtlsRow;
	}

	public String getSubAccountName() {
		return subAccountName;
	}

	public void setSubAccountName(String subAccountName) {
		this.subAccountName = subAccountName;
	}

	public int getChequeStatus() {
		return chequeStatus;
	}

	public void setChequeStatus(int chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

	public String getChequeNoValue() {
		return chequeNoValue;
	}

	public void setChequeNoValue(String chequeNoValue) {
		this.chequeNoValue = chequeNoValue;
	}

	public int getChequeNoId() {
		return chequeNoId;
	}

	public void setChequeNoId(int chequeNoId) {
		this.chequeNoId = chequeNoId;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getCbVoucherNo1() {
		return cbVoucherNo1;
	}

	public void setCbVoucherNo1(String cbVoucherNo1) {
		this.cbVoucherNo1 = cbVoucherNo1;
	}

	public String getCbpdtlpaymentHead() {
		return cbpdtlpaymentHead;
	}

	public void setCbpdtlpaymentHead(String cbpdtlpaymentHead) {
		this.cbpdtlpaymentHead = cbpdtlpaymentHead;
	}

	public String getPreparedby() {
		return preparedby;
	}

	public void setPreparedby(String preparedby) {
		this.preparedby = preparedby;
	}

	public String getApprovenote() {
		return approvenote;
	}

	public void setApprovenote(String approvenote) {
		this.approvenote = approvenote;
	}

	
	
	
	
}
