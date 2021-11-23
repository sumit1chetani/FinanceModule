package com.dci.tenant.finance.cashbankreceipt;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;

public class CashBankReceiptListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1792021411622471778L;
	private List<CashBankReceiptListBean> invoicePaymentList;

	public List<CashBankReceiptListBean> getInvoicePaymentList() {
		return invoicePaymentList;
	}

	public void setInvoicePaymentList(List<CashBankReceiptListBean> invoicePaymentList) {
		this.invoicePaymentList = invoicePaymentList;
	}
    private String receipt ;

	private String dtlnarration;

	private int cbPmtInvDtlId;
	private int cashBankPmtDtlId;

	private String employeeCode;
	private String departmentCode;
	private String countryCode;
	private String customerCode;
	private String supplierCode;
	private Integer designationCode;
	private String companyCode;
	private Integer patientCode;
	private String purInvoiceNo;
	private String acctHeadCode;
	private String subAccountName;
	private String accountHeadName;

	private String scbpDtlTcAmount;
	private String scbpDtlBcAmount;
    private String receiptfrom;
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
	private String pInvoiceNo;
	private String toDate;
	private String accountHeadCode;
	private String approvedByName;
	private String approvedDate;
	private double bcAmount;
	private String createdByName;
	private double currencyFraction;
	private String detailBeans;
	private String dueDate;
	private String invoiceDate;
	private double paidAmount;

	private String employeeName;
	private String studentName;
	private String amountinWords;
	public String currencyType;
	private String voucherNo1;
	private String preparedby;
	
	private String approvenote;
	public String getVoucherNo1() {
		return voucherNo1;
	}

	public void setVoucherNo1(String voucherNo1) {
		this.voucherNo1 = voucherNo1;
	}

	public String getAmountinWords() {
		return amountinWords;
	}

	public void setAmountinWords(String amountinWords) {
		this.amountinWords = amountinWords;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

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

	private boolean select;
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

	private double tcAmount;
	private String totalBC;
	private double totalPayAmount;
	private double totalPayTCAmount;
	private String totalTC;
	private String invoiceNo;
	private double receivedAmount;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	private String fromDate;
	private String cbReceiptNo;
	private String accountId;
	private String accountName;
	private String acctCurrency;
	private String referenceNo;
	private double exchangeRate;
	private String paymentMode;
	private String bankAcc;
	private String cashAcc;
	private String voucherNo;
	private boolean show;
	private boolean hide;
	private double bcAmountHdr;
	private double tcAmountHdr;
	private String currency;
	private String narration;
	private String receivedFrom;
	private String cbReceiptDate;
	private String chequeDate;
	private String chequeNO;
	private String approvedBy;
	private String companyName;
	private String compLocationName;
	private String invoices;
	private double totalTcAmount;
	private double totalBcAmount;
	private String subaccountname;

	private String companyAddress;
	private String companyPhoneNo;
	private String companyEmail;
	private String shortDetail;
	private String acctName;
	private String costCenter;
	

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getShortDetail() {
		return shortDetail;
	}

	public void setShortDetail(String shortDetail) {
		this.shortDetail = shortDetail;
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

	private List<CashBankReceiptDetailBean> invoicealloc;

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

	public List<CashBankReceiptDetailBean> getInvoicealloc() {
		return invoicealloc;
	}

	public void setInvoicealloc(List<CashBankReceiptDetailBean> invoicealloc) {
		this.invoicealloc = invoicealloc;
	}

	private List<CashBankReceiptDetailBean> cshBankDetail;
	private List<SelectivityBean> lCashBankAccountList;

	private String id;
	private String text;

	public String getCbReceiptNo() {
		return cbReceiptNo;
	}

	public void setCbReceiptNo(String cbReceiptNo) {
		this.cbReceiptNo = cbReceiptNo;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAcctCurrency() {
		return acctCurrency;
	}

	public void setAcctCurrency(String acctCurrency) {
		this.acctCurrency = acctCurrency;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getBankAcc() {
		return bankAcc;
	}

	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}

	public String getCashAcc() {
		return cashAcc;
	}

	public void setCashAcc(String cashAcc) {
		this.cashAcc = cashAcc;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getReceivedFrom() {
		return receivedFrom;
	}

	public void setReceivedFrom(String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}

	public String getCbReceiptDate() {
		return cbReceiptDate;
	}

	public void setCbReceiptDate(String cbReceiptDate) {
		this.cbReceiptDate = cbReceiptDate;
	}

	public String getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getChequeNO() {
		return chequeNO;
	}

	public void setChequeNO(String chequeNO) {
		this.chequeNO = chequeNO;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
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

	public String getCompLocationName() {
		return compLocationName;
	}

	public void setCompLocationName(String compLocationName) {
		this.compLocationName = compLocationName;
	}

	public List<CashBankReceiptDetailBean> getCshBankDetail() {
		return cshBankDetail;
	}

	public void setCshBankDetail(List<CashBankReceiptDetailBean> cshBankDetail) {
		this.cshBankDetail = cshBankDetail;
	}

	public List<SelectivityBean> getlCashBankAccountList() {
		return lCashBankAccountList;
	}

	public void setlCashBankAccountList(List<SelectivityBean> lCashBankAccountList) {
		this.lCashBankAccountList = lCashBankAccountList;
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

	public String getInvoices() {
		return invoices;
	}

	public void setInvoices(String invoices) {
		this.invoices = invoices;
	}

	public double getTotalTcAmount() {
		return totalTcAmount;
	}

	public void setTotalTcAmount(double totalTcAmount) {
		this.totalTcAmount = totalTcAmount;
	}

	public double getTotalBcAmount() {
		return totalBcAmount;
	}

	public void setTotalBcAmount(double totalBcAmount) {
		this.totalBcAmount = totalBcAmount;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getSubaccountname() {
		return subaccountname;
	}

	public void setSubaccountname(String subaccountname) {
		this.subaccountname = subaccountname;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getReceiptfrom() {
		return receiptfrom;
	}

	public void setReceiptfrom(String receiptfrom) {
		this.receiptfrom = receiptfrom;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
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
