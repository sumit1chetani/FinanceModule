package com.dci.finance.GeneralLedger;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class GeneralLedgerBean {

	private String companyCode;
	private String companyName;
	private String fromDate;
	private String toDate;
	private String groupCode;
	private String subGroupCode;
	private String subGroupName;
	private String subGroupAddress;
	private String subGroupAddress1;
	private String subGroupAddress2;
	private String subGroupAddres3;
	private String subGroupAddress4;
	String subAccountId;
	String acctHeadId;
	String subAccountFilterId;
	String subGroupId;
	String acctHeadId1;
	private String subGroupGST;
   private String acctcode;
	private String address;

	private String costCenter;
	private String costCentername;
	private String budget;
	private boolean success;

	public String getSubGroupId() {
		return subGroupId;
	}

	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
	}

	public String getSubAccountId() {
		return subAccountId;
	}

	public void setSubAccountId(String subAccountId) {
		this.subAccountId = subAccountId;
	}

	public String getAcctHeadId() {
		return acctHeadId;
	}

	public void setAcctHeadId(String acctHeadId) {
		this.acctHeadId = acctHeadId;
	}

	public String getSubAccountFilterId() {
		return subAccountFilterId;
	}

	public void setSubAccountFilterId(String subAccountFilterId) {
		this.subAccountFilterId = subAccountFilterId;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getCostCentername() {
		return costCentername;
	}

	public void setCostCentername(String costCentername) {
		this.costCentername = costCentername;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getSubGroupAddress1() {
		return subGroupAddress1;
	}

	public void setSubGroupAddress1(String subGroupAddress1) {
		this.subGroupAddress1 = subGroupAddress1;
	}

	public String getSubGroupAddress2() {
		return subGroupAddress2;
	}

	public void setSubGroupAddress2(String subGroupAddress2) {
		this.subGroupAddress2 = subGroupAddress2;
	}

	public String getSubGroupAddres3() {
		return subGroupAddres3;
	}

	public void setSubGroupAddres3(String subGroupAddres3) {
		this.subGroupAddres3 = subGroupAddres3;
	}

	public String getSubGroupAddress4() {
		return subGroupAddress4;
	}

	public void setSubGroupAddress4(String subGroupAddress4) {
		this.subGroupAddress4 = subGroupAddress4;
	}

	public String getSubGroupAddress() {
		return subGroupAddress;
	}

	public void setSubGroupAddress(String subGroupAddress) {
		this.subGroupAddress = subGroupAddress;
	}

	public String getSubGroupGST() {
		return subGroupGST;
	}

	public void setSubGroupGST(String subGroupGST) {
		this.subGroupGST = subGroupGST;
	}

	private String gstNo;

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private double bcDebit;
	private double bcCredit;
	private int slNo;

	public double getDebitamount() {
		return debitamount;
	}

	public void setDebitamount(double debitamount) {
		this.debitamount = debitamount;
	}

	public double getCreditamount() {
		return creditamount;
	}

	public void setCreditamount(double creditamount) {
		this.creditamount = creditamount;
	}

	public double getNewcreditamount() {
		return newcreditamount;
	}

	public void setNewcreditamount(double newcreditamount) {
		this.newcreditamount = newcreditamount;
	}

	private double debitamount;
	private double creditamount;
	private double newcreditamount;
	private List<String> lpayer;

	private String filterAccountHeadCode;
	private String transactionType;

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	private String accountHeadCode;
	private String accountHeadName;
	private String voyageCode;
	private String vesselCode;
	private double tcDebit;
	private double tcCredit;
	private String ledgerDate;
	private String transactionNo;
	private String transactionDate;
	private Date transactionDateFormat;
	private String currency;
	private double exchangeRate;
	private double currentBalance;
	private double currentTCBalance;

	private double newdebitamount;

	public double getNewdebitamount() {
		return newdebitamount;
	}

	public void setNewdebitamount(double newdebitamount) {
		this.newdebitamount = newdebitamount;
	}

	private String subAccountCode;
	private String subAccountName;
	private String mainAccountCode;
	private String referenceNo;
	private String narration;
	private String partyInvoiceNo;
	private String createdBy;
	private String sectorCode;

	private List<GeneralLedgerBean> lTransactionList;
	private List<GeneralLedgerBean> lGlList;
	private List<GeneralLedgerBean> lGeneralLedgerAHLevelList;
	private List<GeneralLedgerBean> lGeneralLedgerTransactionList;
	private ArrayList objCompanyCodes;

	public List<GeneralLedgerBean> lGeneralLedgerList;
	public List<GeneralLedgerBean> detaillist;

	public List<GeneralLedgerBean> getDetaillist() {
		return detaillist;
	}

	public void setDetaillist(List<GeneralLedgerBean> detaillist) {
		this.detaillist = detaillist;
	}

	public List<GeneralLedgerBean> getlGeneralLedgerList() {
		return lGeneralLedgerList;
	}

	public void setlGeneralLedgerList(List<GeneralLedgerBean> lGeneralLedgerList) {
		this.lGeneralLedgerList = lGeneralLedgerList;
	}

	private double totalBCDebit;
	private double totalBCCredit;
	private double openingBalance;

	private double closingBalance;

	private double openingBalanceTC;
	private double closingBalanceTC;

	private String allocationStatus;
	private String allocatedTo;

	private String voucherNo;
	private String ledgerSeq;

	private Integer ledgerNo;
	private String pol;
	private String pod;

	private String allocatedTo2;
	private String dueDate;

	// private String id;
	private String text;

	/*
	 * public String getId() { return id; }
	 * 
	 * public void setId(String id) { this.id = id; }
	 */

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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

	public String getSubGroupCode() {
		return subGroupCode;
	}

	public void setSubGroupCode(String subGroupCode) {
		this.subGroupCode = subGroupCode;
	}

	public String getSubGroupName() {
		return subGroupName;
	}

	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}

	public double getBcDebit() {
		return bcDebit;
	}

	public void setBcDebit(double bcDebit) {
		this.bcDebit = bcDebit;
	}

	public double getBcCredit() {
		return bcCredit;
	}

	public void setBcCredit(double bcCredit) {
		this.bcCredit = bcCredit;
	}

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public double getTcDebit() {
		return tcDebit;
	}

	public void setTcDebit(double tcDebit) {
		this.tcDebit = tcDebit;
	}

	public double getTcCredit() {
		return tcCredit;
	}

	public void setTcCredit(double tcCredit) {
		this.tcCredit = tcCredit;
	}

	public String getLedgerDate() {
		return ledgerDate;
	}

	public void setLedgerDate(String ledgerDate) {
		this.ledgerDate = ledgerDate;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getSubAccountCode() {
		return subAccountCode;
	}

	public void setSubAccountCode(String subAccountCode) {
		this.subAccountCode = subAccountCode;
	}

	public String getSubAccountName() {
		return subAccountName;
	}

	public void setSubAccountName(String subAccountName) {
		this.subAccountName = subAccountName;
	}

	public List<GeneralLedgerBean> getlTransactionList() {
		return lTransactionList;
	}

	public void setlTransactionList(List<GeneralLedgerBean> lTransactionList) {
		this.lTransactionList = lTransactionList;
	}

	public List<GeneralLedgerBean> getlGeneralLedgerAHLevelList() {
		return lGeneralLedgerAHLevelList;
	}

	public void setlGeneralLedgerAHLevelList(List<GeneralLedgerBean> lGeneralLedgerAHLevelList) {
		this.lGeneralLedgerAHLevelList = lGeneralLedgerAHLevelList;
	}

	public String getFilterAccountHeadCode() {
		return filterAccountHeadCode;
	}

	public void setFilterAccountHeadCode(String filterAccountHeadCode) {
		this.filterAccountHeadCode = filterAccountHeadCode;
	}

	public String getMainAccountCode() {
		return mainAccountCode;
	}

	public void setMainAccountCode(String mainAccountCode) {
		this.mainAccountCode = mainAccountCode;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getPartyInvoiceNo() {
		return partyInvoiceNo;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public void setPartyInvoiceNo(String partyInvoiceNo) {
		this.partyInvoiceNo = partyInvoiceNo;
	}

	public ArrayList getObjCompanyCodes() {
		return objCompanyCodes;
	}

	public void setObjCompanyCodes(ArrayList objCompanyCodes) {
		this.objCompanyCodes = objCompanyCodes;
	}

	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public String getVoyageCode() {
		return voyageCode;
	}

	public void setVoyageCode(String voyageCode) {
		this.voyageCode = voyageCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getCurrentTCBalance() {
		return currentTCBalance;
	}

	public void setCurrentTCBalance(double currentTCBalance) {
		this.currentTCBalance = currentTCBalance;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public double getTotalBCDebit() {
		return totalBCDebit;
	}

	public void setTotalBCDebit(double totalBCDebit) {
		this.totalBCDebit = totalBCDebit;
	}

	public double getTotalBCCredit() {
		return totalBCCredit;
	}

	public void setTotalBCCredit(double totalBCCredit) {
		this.totalBCCredit = totalBCCredit;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public String getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public String getAllocatedTo() {
		return allocatedTo;
	}

	public void setAllocatedTo(String allocatedTo) {
		this.allocatedTo = allocatedTo;
	}

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}

	public Date getTransactionDateFormat() {
		return transactionDateFormat;
	}

	public void setTransactionDateFormat(Date transactionDateFormat) {
		this.transactionDateFormat = transactionDateFormat;
	}

	public List<GeneralLedgerBean> getlGlList() {
		return lGlList;
	}

	public void setlGlList(List<GeneralLedgerBean> lGlList) {
		this.lGlList = lGlList;
	}

	public Integer getLedgerNo() {
		return ledgerNo;
	}

	public void setLedgerNo(Integer ledgerNo) {
		this.ledgerNo = ledgerNo;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getLedgerSeq() {
		return ledgerSeq;
	}

	public void setLedgerSeq(String ledgerSeq) {
		this.ledgerSeq = ledgerSeq;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public List<String> getLpayer() {
		return lpayer;
	}

	public void setLpayer(List<String> lpayer) {
		this.lpayer = lpayer;
	}

	public String getAllocatedTo2() {
		return allocatedTo2;
	}

	public void setAllocatedTo2(String allocatedTo2) {
		this.allocatedTo2 = allocatedTo2;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public double getOpeningBalanceTC() {
		return openingBalanceTC;
	}

	public void setOpeningBalanceTC(double openingBalanceTC) {
		this.openingBalanceTC = openingBalanceTC;
	}

	public double getClosingBalanceTC() {
		return closingBalanceTC;
	}

	public void setClosingBalanceTC(double closingBalanceTC) {
		this.closingBalanceTC = closingBalanceTC;
	}

	public List<GeneralLedgerBean> getlGeneralLedgerTransactionList() {
		return lGeneralLedgerTransactionList;
	}

	public void setlGeneralLedgerTransactionList(List<GeneralLedgerBean> lGeneralLedgerTransactionList) {
		this.lGeneralLedgerTransactionList = lGeneralLedgerTransactionList;
	}

	private String subGroupName1;

	public String getSubGroupName1() {
		return subGroupName1;
	}

	public void setSubGroupName1(String subGroupName1) {
		this.subGroupName1 = subGroupName1;
	}

	public String getAcctcode() {
		return acctcode;
	}

	public void setAcctcode(String acctcode) {
		this.acctcode = acctcode;
	}

	public String getAcctHeadId1() {
		return acctHeadId1;
	}

	public void setAcctHeadId1(String acctHeadId1) {
		this.acctHeadId1 = acctHeadId1;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	
	
	/*
	 * public List<String> getLpayer() { return lpayer; }
	 * 
	 * public void setLpayer(List<String> lpayer) { this.lpayer = lpayer; }
	 */

}