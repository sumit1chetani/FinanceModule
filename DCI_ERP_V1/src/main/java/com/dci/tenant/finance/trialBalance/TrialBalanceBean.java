package com.dci.tenant.finance.trialBalance;

import java.util.List;

public class TrialBalanceBean {

	String companyCode;
	String fromDate;
	String toDate;
	String subGroupCode;
	String subGroupName;
	String acctHeadCode;
	String acctHeadName;
	String costCenter;
	
	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	double creditAmount;
	double debitAmount;
	double currentBalance;
	double openingBalance;
	String ledgerDate;
	String transactionNo;
	String filterCode;
	String relatedParty;
	// not used
	String groupCode;
	String groupName;
	String costcenter;

	String subGroupType;
	double balanceAmount;
	String subAccountCode;
	String filterSubAccountCode;
	String subAccountName;
	String subAccountId;
	String acctHeadId;
	String subAccountFilterId;

	private List<TrialBalanceBean> lTBTransactionList;
	private List<TrialBalanceBean> lTBAccountHeadLevelList;
	private List<TrialBalanceBean> lSATransactionLevelList;

	public String getSubAccountFilterId() {
		return subAccountFilterId;
	}

	public void setSubAccountFilterId(String subAccountFilterId) {
		this.subAccountFilterId = subAccountFilterId;
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

	// Export Excel With Plain
	private String sg;
	private String ah;
	private String sa;
	private String openingBalBC;
	private String totalBCDebit;
	private String totalBCCredit;
	private String closingBalBC;
	private String companyName;
	private String companyCodes;
	private double C0008_openingbalancebc;
	private double C0008_totalbcdebit;
	private double C0008_totalbccredit;
	private double C0008_closingbalancebc;

	private double C0009_openingbalancebc;
	private double C0009_totalbcdebit;
	private double C0009_totalbccredit;
	private double C0009_closingbalancebc;

	private double C0008_tcDebit;
	private double C0008_tcCredit;
	private double C0008_debitAmount;
	private double C0008_creditAmount;
	private double C0008_currentBalance;

	private double C0009_tcDebit;
	private double C0009_tcCredit;
	private double C0009_debitAmount;
	private double C0009_creditAmount;

	public String getC0009_currentBalance() {
		return C0009_currentBalance;
	}

	public void setC0009_currentBalance(String c0009_currentBalance) {
		C0009_currentBalance = c0009_currentBalance;
	}

	public String getC0010_tcDebit() {
		return C0010_tcDebit;
	}

	public void setC0010_tcDebit(String c0010_tcDebit) {
		C0010_tcDebit = c0010_tcDebit;
	}

	public String getC0010_tcCredit() {
		return C0010_tcCredit;
	}

	public void setC0010_tcCredit(String c0010_tcCredit) {
		C0010_tcCredit = c0010_tcCredit;
	}

	public String getC0010_debitAmount() {
		return C0010_debitAmount;
	}

	public void setC0010_debitAmount(String c0010_debitAmount) {
		C0010_debitAmount = c0010_debitAmount;
	}

	public String getC0010_creditAmount() {
		return C0010_creditAmount;
	}

	public void setC0010_creditAmount(String c0010_creditAmount) {
		C0010_creditAmount = c0010_creditAmount;
	}

	public String getC0010_currentBalance() {
		return C0010_currentBalance;
	}

	public void setC0010_currentBalance(String c0010_currentBalance) {
		C0010_currentBalance = c0010_currentBalance;
	}

	public String getC0011_tcDebit() {
		return C0011_tcDebit;
	}

	public void setC0011_tcDebit(String c0011_tcDebit) {
		C0011_tcDebit = c0011_tcDebit;
	}

	public String getC0011_tcCredit() {
		return C0011_tcCredit;
	}

	public void setC0011_tcCredit(String c0011_tcCredit) {
		C0011_tcCredit = c0011_tcCredit;
	}

	public String getC0011_debitAmount() {
		return C0011_debitAmount;
	}

	public void setC0011_debitAmount(String c0011_debitAmount) {
		C0011_debitAmount = c0011_debitAmount;
	}

	public String getC0011_creditAmount() {
		return C0011_creditAmount;
	}

	public void setC0011_creditAmount(String c0011_creditAmount) {
		C0011_creditAmount = c0011_creditAmount;
	}

	public String getC0011_currentBalance() {
		return C0011_currentBalance;
	}

	public void setC0011_currentBalance(String c0011_currentBalance) {
		C0011_currentBalance = c0011_currentBalance;
	}

	public String getC0012_tcDebit() {
		return C0012_tcDebit;
	}

	public void setC0012_tcDebit(String c0012_tcDebit) {
		C0012_tcDebit = c0012_tcDebit;
	}

	public String getC0012_tcCredit() {
		return C0012_tcCredit;
	}

	public void setC0012_tcCredit(String c0012_tcCredit) {
		C0012_tcCredit = c0012_tcCredit;
	}

	public String getC0012_debitAmount() {
		return C0012_debitAmount;
	}

	public void setC0012_debitAmount(String c0012_debitAmount) {
		C0012_debitAmount = c0012_debitAmount;
	}

	public String getC0012_creditAmount() {
		return C0012_creditAmount;
	}

	public void setC0012_creditAmount(String c0012_creditAmount) {
		C0012_creditAmount = c0012_creditAmount;
	}

	public String getC0012_currentBalance() {
		return C0012_currentBalance;
	}

	public void setC0012_currentBalance(String c0012_currentBalance) {
		C0012_currentBalance = c0012_currentBalance;
	}

	private String C0009_currentBalance;

	private String C0010_tcDebit;
	private String C0010_tcCredit;
	private String C0010_debitAmount;
	private String C0010_creditAmount;
	private String C0010_currentBalance;

	private String C0011_tcDebit;
	private String C0011_tcCredit;
	private String C0011_debitAmount;
	private String C0011_creditAmount;
	private String C0011_currentBalance;

	private String C0012_tcDebit;
	private String C0012_tcCredit;
	private String C0012_debitAmount;
	private String C0012_creditAmount;
	private String C0012_currentBalance;
	/**
	 * 
	 */
	private String dummy;

	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

	private double C0010_openingbalancebc;

	private double C0010_totalbcdebit;
	private double C0010_totalbccredit;
	private double C0010_closingbalancebc;

	public double getC0008_openingbalancebc() {
		return C0008_openingbalancebc;
	}

	public void setC0008_openingbalancebc(double c0008_openingbalancebc) {
		C0008_openingbalancebc = c0008_openingbalancebc;
	}

	public double getC0008_totalbcdebit() {
		return C0008_totalbcdebit;
	}

	public void setC0008_totalbcdebit(double c0008_totalbcdebit) {
		C0008_totalbcdebit = c0008_totalbcdebit;
	}

	public double getC0008_totalbccredit() {
		return C0008_totalbccredit;
	}

	public void setC0008_totalbccredit(double c0008_totalbccredit) {
		C0008_totalbccredit = c0008_totalbccredit;
	}

	public double getC0008_closingbalancebc() {
		return C0008_closingbalancebc;
	}

	public void setC0008_closingbalancebc(double c0008_closingbalancebc) {
		C0008_closingbalancebc = c0008_closingbalancebc;
	}

	public double getC0009_openingbalancebc() {
		return C0009_openingbalancebc;
	}

	public void setC0009_openingbalancebc(double c0009_openingbalancebc) {
		C0009_openingbalancebc = c0009_openingbalancebc;
	}

	public double getC0009_totalbcdebit() {
		return C0009_totalbcdebit;
	}

	public void setC0009_totalbcdebit(double c0009_totalbcdebit) {
		C0009_totalbcdebit = c0009_totalbcdebit;
	}

	public double getC0009_totalbccredit() {
		return C0009_totalbccredit;
	}

	public void setC0009_totalbccredit(double c0009_totalbccredit) {
		C0009_totalbccredit = c0009_totalbccredit;
	}

	public double getC0009_closingbalancebc() {
		return C0009_closingbalancebc;
	}

	public void setC0009_closingbalancebc(double c0009_closingbalancebc) {
		C0009_closingbalancebc = c0009_closingbalancebc;
	}

	public double getC0008_tcDebit() {
		return C0008_tcDebit;
	}

	public void setC0008_tcDebit(double c0008_tcDebit) {
		C0008_tcDebit = c0008_tcDebit;
	}

	public double getC0008_tcCredit() {
		return C0008_tcCredit;
	}

	public void setC0008_tcCredit(double c0008_tcCredit) {
		C0008_tcCredit = c0008_tcCredit;
	}

	public double getC0008_debitAmount() {
		return C0008_debitAmount;
	}

	public void setC0008_debitAmount(double c0008_debitAmount) {
		C0008_debitAmount = c0008_debitAmount;
	}

	public double getC0008_creditAmount() {
		return C0008_creditAmount;
	}

	public void setC0008_creditAmount(double c0008_creditAmount) {
		C0008_creditAmount = c0008_creditAmount;
	}

	public double getC0008_currentBalance() {
		return C0008_currentBalance;
	}

	public void setC0008_currentBalance(double c0008_currentBalance) {
		C0008_currentBalance = c0008_currentBalance;
	}

	public double getC0009_tcDebit() {
		return C0009_tcDebit;
	}

	public void setC0009_tcDebit(double c0009_tcDebit) {
		C0009_tcDebit = c0009_tcDebit;
	}

	public double getC0009_tcCredit() {
		return C0009_tcCredit;
	}

	public void setC0009_tcCredit(double c0009_tcCredit) {
		C0009_tcCredit = c0009_tcCredit;
	}

	public double getC0009_debitAmount() {
		return C0009_debitAmount;
	}

	public void setC0009_debitAmount(double c0009_debitAmount) {
		C0009_debitAmount = c0009_debitAmount;
	}

	public double getC0009_creditAmount() {
		return C0009_creditAmount;
	}

	public void setC0009_creditAmount(double c0009_creditAmount) {
		C0009_creditAmount = c0009_creditAmount;
	}

	public double getC0010_openingbalancebc() {
		return C0010_openingbalancebc;
	}

	public void setC0010_openingbalancebc(double c0010_openingbalancebc) {
		C0010_openingbalancebc = c0010_openingbalancebc;
	}

	public double getC0010_totalbcdebit() {
		return C0010_totalbcdebit;
	}

	public void setC0010_totalbcdebit(double c0010_totalbcdebit) {
		C0010_totalbcdebit = c0010_totalbcdebit;
	}

	public double getC0010_totalbccredit() {
		return C0010_totalbccredit;
	}

	public void setC0010_totalbccredit(double c0010_totalbccredit) {
		C0010_totalbccredit = c0010_totalbccredit;
	}

	public double getC0010_closingbalancebc() {
		return C0010_closingbalancebc;
	}

	public void setC0010_closingbalancebc(double c0010_closingbalancebc) {
		C0010_closingbalancebc = c0010_closingbalancebc;
	}

	public double getC0011_openingbalancebc() {
		return C0011_openingbalancebc;
	}

	public void setC0011_openingbalancebc(double c0011_openingbalancebc) {
		C0011_openingbalancebc = c0011_openingbalancebc;
	}

	public double getC0011_totalbcdebit() {
		return C0011_totalbcdebit;
	}

	public void setC0011_totalbcdebit(double c0011_totalbcdebit) {
		C0011_totalbcdebit = c0011_totalbcdebit;
	}

	public double getC0011_totalbccredit() {
		return C0011_totalbccredit;
	}

	public void setC0011_totalbccredit(double c0011_totalbccredit) {
		C0011_totalbccredit = c0011_totalbccredit;
	}

	public double getC0011_closingbalancebc() {
		return C0011_closingbalancebc;
	}

	public void setC0011_closingbalancebc(double c0011_closingbalancebc) {
		C0011_closingbalancebc = c0011_closingbalancebc;
	}

	public double getC0012_openingbalancebc() {
		return C0012_openingbalancebc;
	}

	public void setC0012_openingbalancebc(double c0012_openingbalancebc) {
		C0012_openingbalancebc = c0012_openingbalancebc;
	}

	public double getC0012_totalbcdebit() {
		return C0012_totalbcdebit;
	}

	public void setC0012_totalbcdebit(double c0012_totalbcdebit) {
		C0012_totalbcdebit = c0012_totalbcdebit;
	}

	public double getC0012_totalbccredit() {
		return C0012_totalbccredit;
	}

	public void setC0012_totalbccredit(double c0012_totalbccredit) {
		C0012_totalbccredit = c0012_totalbccredit;
	}

	public double getC0012_closingbalancebc() {
		return C0012_closingbalancebc;
	}

	public void setC0012_closingbalancebc(double c0012_closingbalancebc) {
		C0012_closingbalancebc = c0012_closingbalancebc;
	}

	private double C0011_openingbalancebc;
	private double C0011_totalbcdebit;
	private double C0011_totalbccredit;
	private double C0011_closingbalancebc;

	private double C0012_openingbalancebc;
	private double C0012_totalbcdebit;
	private double C0012_totalbccredit;
	private double C0012_closingbalancebc;
	private boolean success;

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

	public String getAcctHeadCode() {
		return acctHeadCode;
	}

	public void setAcctHeadCode(String acctHeadCode) {
		this.acctHeadCode = acctHeadCode;
	}

	public String getAcctHeadName() {
		return acctHeadName;
	}

	public void setAcctHeadName(String acctHeadName) {
		this.acctHeadName = acctHeadName;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
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

	public String getFilterCode() {
		return filterCode;
	}

	public void setFilterCode(String filterCode) {
		this.filterCode = filterCode;
	}

	public String getRelatedParty() {
		return relatedParty;
	}

	public void setRelatedParty(String relatedParty) {
		this.relatedParty = relatedParty;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSubGroupType() {
		return subGroupType;
	}

	public void setSubGroupType(String subGroupType) {
		this.subGroupType = subGroupType;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getSubAccountCode() {
		return subAccountCode;
	}

	public void setSubAccountCode(String subAccountCode) {
		this.subAccountCode = subAccountCode;
	}

	public String getFilterSubAccountCode() {
		return filterSubAccountCode;
	}

	public void setFilterSubAccountCode(String filterSubAccountCode) {
		this.filterSubAccountCode = filterSubAccountCode;
	}

	public String getSubAccountName() {
		return subAccountName;
	}

	public void setSubAccountName(String subAccountName) {
		this.subAccountName = subAccountName;
	}

	public List<TrialBalanceBean> getlTBTransactionList() {
		return lTBTransactionList;
	}

	public void setlTBTransactionList(List<TrialBalanceBean> lTBTransactionList) {
		this.lTBTransactionList = lTBTransactionList;
	}

	public List<TrialBalanceBean> getlTBAccountHeadLevelList() {
		return lTBAccountHeadLevelList;
	}

	public void setlTBAccountHeadLevelList(List<TrialBalanceBean> lTBAccountHeadLevelList) {
		this.lTBAccountHeadLevelList = lTBAccountHeadLevelList;
	}

	public List<TrialBalanceBean> getlSATransactionLevelList() {
		return lSATransactionLevelList;
	}

	public void setlSATransactionLevelList(List<TrialBalanceBean> lSATransactionLevelList) {
		this.lSATransactionLevelList = lSATransactionLevelList;
	}

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getAh() {
		return ah;
	}

	public void setAh(String ah) {
		this.ah = ah;
	}

	public String getSa() {
		return sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
	}

	public String getOpeningBalBC() {
		return openingBalBC;
	}

	public void setOpeningBalBC(String openingBalBC) {
		this.openingBalBC = openingBalBC;
	}

	public String getTotalBCDebit() {
		return totalBCDebit;
	}

	public void setTotalBCDebit(String totalBCDebit) {
		this.totalBCDebit = totalBCDebit;
	}

	public String getTotalBCCredit() {
		return totalBCCredit;
	}

	public void setTotalBCCredit(String totalBCCredit) {
		this.totalBCCredit = totalBCCredit;
	}

	public String getClosingBalBC() {
		return closingBalBC;
	}

	public void setClosingBalBC(String closingBalBC) {
		this.closingBalBC = closingBalBC;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCodes() {
		return companyCodes;
	}

	public void setCompanyCodes(String companyCodes) {
		this.companyCodes = companyCodes;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}

}