package com.dci.tenant.finance.profitAndLoss;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ProfitAndLossBean extends BasicResultBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String groupHeadCode;
	private String groupHeadName;
	private double creditAmount;
	private double debitAmount;

	private String fromDate;
	private String toDate;
	private String company;

	private String filePath;
	private String transactionNo;
	private String accountCode;
	private String narration;
	private double bcCredit;
	private double bcDebit;
	private double tcCredit;
	private double tcDebit;

	public String getC0008_creditAmount() {
		return C0008_creditAmount;
	}

	public void setC0008_creditAmount(String c0008_creditAmount) {
		C0008_creditAmount = c0008_creditAmount;
	}

	public String getC0008_debitAmount() {
		return C0008_debitAmount;
	}

	public void setC0008_debitAmount(String c0008_debitAmount) {
		C0008_debitAmount = c0008_debitAmount;
	}

	public String getC0009_creditAmount() {
		return C0009_creditAmount;
	}

	public void setC0009_creditAmount(String c0009_creditAmount) {
		C0009_creditAmount = c0009_creditAmount;
	}

	public String getC0009_debitAmount() {
		return C0009_debitAmount;
	}

	public void setC0009_debitAmount(String c0009_debitAmount) {
		C0009_debitAmount = c0009_debitAmount;
	}

	public String getC0010_creditAmount() {
		return C0010_creditAmount;
	}

	public void setC0010_creditAmount(String c0010_creditAmount) {
		C0010_creditAmount = c0010_creditAmount;
	}

	public String getC0010_debitAmount() {
		return C0010_debitAmount;
	}

	public void setC0010_debitAmount(String c0010_debitAmount) {
		C0010_debitAmount = c0010_debitAmount;
	}

	public String getC0011_creditAmount() {
		return C0011_creditAmount;
	}

	public void setC0011_creditAmount(String c0011_creditAmount) {
		C0011_creditAmount = c0011_creditAmount;
	}

	public String getC0011_debitAmount() {
		return C0011_debitAmount;
	}

	public void setC0011_debitAmount(String c0011_debitAmount) {
		C0011_debitAmount = c0011_debitAmount;
	}

	public String getC0012_creditAmount() {
		return C0012_creditAmount;
	}

	public void setC0012_creditAmount(String c0012_creditAmount) {
		C0012_creditAmount = c0012_creditAmount;
	}

	public String getC0012_debitAmount() {
		return C0012_debitAmount;
	}

	public void setC0012_debitAmount(String c0012_debitAmount) {
		C0012_debitAmount = c0012_debitAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String C0008_creditAmount;
	private String C0008_debitAmount;
	private String C0009_creditAmount;
	private String C0009_debitAmount;
	private String C0010_creditAmount;
	private String C0010_debitAmount;
	private String C0011_creditAmount;
	private String C0011_debitAmount;
	private String C0012_creditAmount;
	private String C0012_debitAmount;

	private List<ProfitAndLossBean> lGroupHeadLevelList;

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public double getBcCredit() {
		return bcCredit;
	}

	public void setBcCredit(double bcCredit) {
		this.bcCredit = bcCredit;
	}

	public double getBcDebit() {
		return bcDebit;
	}

	public void setBcDebit(double bcDebit) {
		this.bcDebit = bcDebit;
	}

	public double getTcCredit() {
		return tcCredit;
	}

	public void setTcCredit(double tcCredit) {
		this.tcCredit = tcCredit;
	}

	public double getTcDebit() {
		return tcDebit;
	}

	public void setTcDebit(double tcDebit) {
		this.tcDebit = tcDebit;
	}

	private List<ProfitAndLossBean> lSubGroupLevelList;
	private List<ProfitAndLossBean> lAccountHeadLevelList;
	private List<ProfitAndLossBean> lProfitLossTransaction;

	public String getGroupHeadCode() {
		return groupHeadCode;
	}

	public void setGroupHeadCode(String groupHeadCode) {
		this.groupHeadCode = groupHeadCode;
	}

	public String getGroupHeadName() {
		return groupHeadName;
	}

	public void setGroupHeadName(String groupHeadName) {
		this.groupHeadName = groupHeadName;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<ProfitAndLossBean> getlGroupHeadLevelList() {
		return lGroupHeadLevelList;
	}

	public void setlGroupHeadLevelList(List<ProfitAndLossBean> lGroupHeadLevelList) {
		this.lGroupHeadLevelList = lGroupHeadLevelList;
	}

	public List<ProfitAndLossBean> getlSubGroupLevelList() {
		return lSubGroupLevelList;
	}

	public void setlSubGroupLevelList(List<ProfitAndLossBean> lSubGroupLevelList) {
		this.lSubGroupLevelList = lSubGroupLevelList;
	}

	public List<ProfitAndLossBean> getlAccountHeadLevelList() {
		return lAccountHeadLevelList;
	}

	public void setlAccountHeadLevelList(List<ProfitAndLossBean> lAccountHeadLevelList) {
		this.lAccountHeadLevelList = lAccountHeadLevelList;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<ProfitAndLossBean> getlProfitLossTransaction() {
		return lProfitLossTransaction;
	}

	public void setlProfitLossTransaction(List<ProfitAndLossBean> lProfitLossTransaction) {
		this.lProfitLossTransaction = lProfitLossTransaction;
	}

}
