package com.dci.tenant.finance.profitandlossnew;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ProfitAndLossBean extends BasicResultBean {

	private String groupHeadCode;
	private String groupHeadName;
	private String sgcode;
	private double creditAmount;
private String costCenter;

	public String getSgcode() {
		return sgcode;
	}

	public void setSgcode(String sgcode) {
		this.sgcode = sgcode;
	}

	private double debitAmount;
	private double amount;
	private double total1;
	private double total2;

	public double getTotal2() {
		return total2;
	}

	public void setTotal2(double total2) {
		this.total2 = total2;
	}

	public double getTotal1() {
		return total1;
	}

	public void setTotal1(double total1) {
		this.total1 = total1;
	}

	private boolean ntFlag;
	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isNtFlag() {
		return ntFlag;
	}

	public void setNtFlag(boolean ntFlag) {
		this.ntFlag = ntFlag;
	}

	public double getNtprofit() {
		return ntprofit;
	}

	public void setNtprofit(double ntprofit) {
		this.ntprofit = ntprofit;
	}

	private double amountAdmin;
	private double amountExp;
	private double ntloss;
	private double ntprofit;

	public double getNtloss() {
		return ntloss;
	}

	public void setNtloss(double ntloss) {
		this.ntloss = ntloss;
	}

	private String fromDate;
	private String toDate;
	private String company;

	private List<ProfitAndLossBean> lGroupHeadLevelList;
	private List<ProfitAndLossBean> lSubGroupLevelList;
	private List<ProfitAndLossBean> lAccountHeadLevelList;

	// code added for new format

	private double groupAmount;
	private String accountHeadCode;
	private String accountHeadName;
	private String accountHeadNameExp;

	private String accountHeadNameAdmin;

	private String subGroupCode;
	private String companyName;
	private String compAddress;

	private String accountHead;

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

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

	public double getGroupAmount() {
		return groupAmount;
	}

	public void setGroupAmount(double groupAmount) {
		this.groupAmount = groupAmount;
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

	public String getSubGroupCode() {
		return subGroupCode;
	}

	public void setSubGroupCode(String subGroupCode) {
		this.subGroupCode = subGroupCode;
	}

	public String getAccountHeadNameAdmin() {
		return accountHeadNameAdmin;
	}

	public void setAccountHeadNameAdmin(String accountHeadNameAdmin) {
		this.accountHeadNameAdmin = accountHeadNameAdmin;
	}

	public double getAmountAdmin() {
		return amountAdmin;
	}

	public void setAmountAdmin(double amountAdmin) {
		this.amountAdmin = amountAdmin;
	}

	public String getAccountHeadNameExp() {
		return accountHeadNameExp;
	}

	public void setAccountHeadNameExp(String accountHeadNameExp) {
		this.accountHeadNameExp = accountHeadNameExp;
	}

	public double getAmountExp() {
		return amountExp;
	}

	public void setAmountExp(double amountExp) {
		this.amountExp = amountExp;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompAddress() {
		return compAddress;
	}

	public void setCompAddress(String compAddress) {
		this.compAddress = compAddress;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	
	

}
