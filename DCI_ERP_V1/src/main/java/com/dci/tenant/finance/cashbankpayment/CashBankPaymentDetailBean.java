package com.dci.tenant.finance.cashbankpayment;

import java.util.List;

import com.dci.tenant.finance.paymentInformation.PaymentInformationBean;

public class CashBankPaymentDetailBean {

	private int cashBankPmtDtlId;
	private String cbVoucherNo;
	private String cbpdtlAccountHead;
	private String cbpdtlPmtOrderNo;
	private String cbpdtlCurrencyCode;
	private double cbpdtlExgRate;
	private double cbpDtlBcAmount;
	private double cbpDtlTcAmount;
	private String cbpdtlSubgroupCode;
	private String cbdtlsubAccountCode;
	public String currencyType;
	private String amountinWords;
    private String cbpdtlpaymentHead;
	
	
	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	private int slNo;

	private boolean select;
	private List<PaymentInformationBean> cbInvoiceDtl;

	// Account Attributes implementation

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
	private String currency;
	private boolean currencyFlag;
	private String invoiceNo;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isCurrencyFlag() {
		return currencyFlag;
	}

	public void setCurrencyFlag(boolean currencyFlag) {
		this.currencyFlag = currencyFlag;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getCashBankPmtDtlIdcash() {
		return cashBankPmtDtlIdcash;
	}

	public List<PaymentInformationBean> getCbInvoiceDtl() {
		return cbInvoiceDtl;
	}

	public void setCbInvoiceDtl(List<PaymentInformationBean> cbInvoiceDtl) {
		this.cbInvoiceDtl = cbInvoiceDtl;
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

	public int getBudgetDefnId() {
		return budgetDefnId;
	}

	public void setBudgetDefnId(int budgetDefnId) {
		this.budgetDefnId = budgetDefnId;
	}

	public void setCashBankPmtDtlIdcash(int cashBankPmtDtlIdcash) {
		this.cashBankPmtDtlIdcash = cashBankPmtDtlIdcash;
	}

	public double getTotalCashAmount() {
		return totalCashAmount;
	}

	public void setTotalCashAmount(double totalCashAmount) {
		this.totalCashAmount = totalCashAmount;
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

	public String getAcctHeadCode() {
		return acctHeadCode;
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

	private List<CashBankPaymentInvoiceDetailBean> invoicePaymentList;
	private List<CashBankPaymentInvoiceDetailBean> pendingInvoiceDtls;
	private List<CashBankPaymentBean> invoicealloc;

	public int getCashBankPmtDtlId() {
		return cashBankPmtDtlId;
	}

	public String getDtlnarration() {
		return dtlnarration;
	}

	public void setDtlnarration(String dtlnarration) {
		this.dtlnarration = dtlnarration;
	}

	private String dtlnarration;

	public List<CashBankPaymentBean> getInvoicealloc() {
		return invoicealloc;
	}

	public void setInvoicealloc(List<CashBankPaymentBean> invoicealloc) {
		this.invoicealloc = invoicealloc;
	}

	public void setCashBankPmtDtlId(int cashBankPmtDtlId) {
		this.cashBankPmtDtlId = cashBankPmtDtlId;
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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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

	public List<CashBankPaymentInvoiceDetailBean> getPendingInvoiceDtls() {
		return pendingInvoiceDtls;
	}

	public void setPendingInvoiceDtls(List<CashBankPaymentInvoiceDetailBean> pendingInvoiceDtls) {
		this.pendingInvoiceDtls = pendingInvoiceDtls;
	}

	public List<CashBankPaymentInvoiceDetailBean> getInvoicePaymentList() {
		return invoicePaymentList;
	}

	public void setInvoicePaymentList(List<CashBankPaymentInvoiceDetailBean> invoicePaymentList) {
		this.invoicePaymentList = invoicePaymentList;
	}

	public Integer getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(Integer costCenter) {
		this.costCenter = costCenter;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public String getAmountinWords() {
		return amountinWords;
	}

	public void setAmountinWords(String amountinWords) {
		this.amountinWords = amountinWords;
	}

	public String getCbpdtlpaymentHead() {
		return cbpdtlpaymentHead;
	}

	public void setCbpdtlpaymentHead(String cbpdtlpaymentHead) {
		this.cbpdtlpaymentHead = cbpdtlpaymentHead;
	}
	
	

}
