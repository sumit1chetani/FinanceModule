package com.dci.tenant.finance.PurchaseCreditNote;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.UserRightsProperties;
import com.dci.tenant.auditlog.AuditLoggable;

//@AuditLoggable(tableName = "purchase_creditnote_hdr", formCode = "F0312")
public class PurchaseCreditNoteBean extends UserRightsProperties {

	private String company_id_dtl;
	private String creditNoteNo;
	private String creditNoteCode;
	private String creditNoteDate;
	private String validCreditNoteDate;
	private String displaySignName;
	private String acctName;
	private String acctHeadCode;
	private String accountName;
	private String currencyCode;
	private Double exgRate;
	private Double exchangeRate;
	private String currFrom;
	private String currTo;
	private String mloName;
	private String approvedSign;
	private String invoiceNo;
	private String invoiceNumber;
	private String invoiceDate;
	private String approveStatus;
	private String location;
	private Double creditAmount;
	private Double creditAmountUSD;
	private String company;
	private String narration;
	private String companyCode;
	private String vesselName;
	private String voyage;
	private String vessel;
	private String voyageId;
	private String bcamountWords;
	private String tcamountWords;
	private String invCreatedUser;
	private String partyno;
	private String supplierCode;
	private String draftMode;
	private String description1;

	public String getDescription1() {
		return description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getDraftMode() {
		return draftMode;
	}

	public void setDraftMode(String draftMode) {
		this.draftMode = draftMode;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public void setCreditAmountUSD(Double creditAmountUSD) {
		this.creditAmountUSD = creditAmountUSD;
	}

	public String getPartyno() {
		return partyno;
	}

	public void setPartyno(String partyno) {
		this.partyno = partyno;
	}

	private String companyCurrency;
	private String rejectedRemarks;
	private Double totaltc;
	private Double totalbc;
	private Double totalBCAmount;
	private Double totalTCAmount;
	private String status;
	private Double bcAmount;
	private Double tcAmount;
	private ArrayList<PuchaseCreditNoteDetailBean> credittables;
	private List<PurchaseCreditNoteBean> acctHeadList;
	private List<PurchaseCreditNoteBean> invoiceList;
	private String refNo;

	private String id;
	private String text;
	private String jvNo;
	private String pcnDate;

	public String getBcamountWords() {
		return bcamountWords;
	}

	public void setBcamountWords(String bcamountWords) {
		this.bcamountWords = bcamountWords;
	}

	public String getTcamountWords() {
		return tcamountWords;
	}

	public String getCompany_id_dtl() {
		return company_id_dtl;
	}

	public void setCompany_id_dtl(String company_id_dtl) {
		this.company_id_dtl = company_id_dtl;
	}

	public void setTcamountWords(String tcamountWords) {
		this.tcamountWords = tcamountWords;
	}

	public String getRejectedRemarks() {
		return rejectedRemarks;
	}

	public void setRejectedRemarks(String rejectedRemarks) {
		this.rejectedRemarks = rejectedRemarks;
	}

	public List<PurchaseCreditNoteBean> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<PurchaseCreditNoteBean> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public List<PurchaseCreditNoteBean> getAcctHeadList() {
		return acctHeadList;
	}

	public void setAcctHeadList(List<PurchaseCreditNoteBean> acctHeadList) {
		this.acctHeadList = acctHeadList;
	}

	public String getCreditNoteCode() {
		return creditNoteCode;
	}

	public void setCreditNoteCode(String creditNoteCode) {
		this.creditNoteCode = creditNoteCode;
	}

	@AuditLoggable(fieldName = "pur_creditnote_date", displayName = "Credit Note Date")
	public String getCreditNoteDate() {
		return creditNoteDate;
	}

	public void setCreditNoteDate(String creditNoteDate) {
		this.creditNoteDate = creditNoteDate;
	}

	public String getValidCreditNoteDate() {
		return validCreditNoteDate;
	}

	public void setValidCreditNoteDate(String validCreditNoteDate) {
		this.validCreditNoteDate = validCreditNoteDate;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
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

	@AuditLoggable(fieldName = "pur_creditnote_currency", displayName = "Currency")
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@AuditLoggable(fieldName = "PUR_CREDITNOTE_RATE", displayName = "Exchange Rate")
	public Double getExgRate() {
		return exgRate;
	}

	public void setExgRate(Double exgRate) {
		this.exgRate = exgRate;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@AuditLoggable(fieldName = "PUR_CREDITNOTE_PURCHASE_NO", displayName = "Invoice Number")
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getCurrFrom() {
		return currFrom;
	}

	public void setCurrFrom(String currFrom) {
		this.currFrom = currFrom;
	}

	public String getCurrTo() {
		return currTo;
	}

	public void setCurrTo(String currTo) {
		this.currTo = currTo;
	}

	public String getMloName() {
		return mloName;
	}

	public void setMloName(String mloName) {
		this.mloName = mloName;
	}

	@AuditLoggable(fieldName = "PUR_CREDITNOTE_PURCHASE_NO", displayName = "Invoice Number")
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@AuditLoggable(fieldName = "PUR_CREDITNOTE_PURCHASE_NO", displayName = "Invoice Date")
	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompany() {
		return company;
	}

	@AuditLoggable(fieldName = "PUR_CREDITNOTE_NARRATION", displayName = "Narration")
	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@AuditLoggable(fieldName = "pur_company_code", displayName = "Company")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public ArrayList<PuchaseCreditNoteDetailBean> getCredittables() {
		return credittables;
	}

	public void setCredittables(ArrayList<PuchaseCreditNoteDetailBean> credittables) {
		this.credittables = credittables;
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

	public String getApprovedSign() {
		return approvedSign;
	}

	public void setApprovedSign(String approvedSign) {
		this.approvedSign = approvedSign;
	}

	public Double getTotaltc() {
		return totaltc;
	}

	public void setTotaltc(Double totaltc) {
		this.totaltc = totaltc;
	}

	public Double getTotalbc() {
		return totalbc;
	}

	public void setTotalbc(Double totalbc) {
		this.totalbc = totalbc;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public Double getCreditAmountUSD() {
		return creditAmountUSD;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getVoyage() {
		return voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDisplaySignName() {
		return displaySignName;
	}

	public void setDisplaySignName(String displaySignName) {
		this.displaySignName = displaySignName;
	}

	public Double getTotalBCAmount() {
		return totalBCAmount;
	}

	public void setTotalBCAmount(Double totalBCAmount) {
		this.totalBCAmount = totalBCAmount;
	}

	public Double getTotalTCAmount() {
		return totalTCAmount;
	}

	public void setTotalTCAmount(Double totalTCAmount) {
		this.totalTCAmount = totalTCAmount;
	}

	public String getCompanyCurrency() {
		return companyCurrency;
	}

	public void setCompanyCurrency(String companyCurrency) {
		this.companyCurrency = companyCurrency;
	}

	@AuditLoggable(fieldName = "PUR_CN_REF_NO", displayName = "Credit Note Number")
	public String getCreditNoteNo() {
		return creditNoteNo;
	}

	public void setCreditNoteNo(String creditNoteNo) {
		this.creditNoteNo = creditNoteNo;
	}

	public String getVessel() {
		return vessel;
	}

	public void setVessel(String vessel) {
		this.vessel = vessel;
	}

	@AuditLoggable(fieldName = "PUR_CN_VOYAGE", displayName = "Voyage")
	public String getVoyageId() {
		return voyageId;
	}

	public void setVoyageId(String voyageId) {
		this.voyageId = voyageId;
	}

	public String getInvCreatedUser() {
		return invCreatedUser;
	}

	public void setInvCreatedUser(String invCreatedUser) {
		this.invCreatedUser = invCreatedUser;
	}

	public Double getBcAmount() {
		return bcAmount;
	}

	public void setBcAmount(Double bcAmount) {
		this.bcAmount = bcAmount;
	}

	public Double getTcAmount() {
		return tcAmount;
	}

	public void setTcAmount(Double tcAmount) {
		this.tcAmount = tcAmount;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getJvNo() {
		return jvNo;
	}

	public void setJvNo(String jvNo) {
		this.jvNo = jvNo;
	}

	public String getPcnDate() {
		return pcnDate;
	}

	public void setPcnDate(String pcnDate) {
		this.pcnDate = pcnDate;
	}

}