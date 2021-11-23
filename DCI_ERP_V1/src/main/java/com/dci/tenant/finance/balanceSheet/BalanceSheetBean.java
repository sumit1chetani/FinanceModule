package com.dci.tenant.finance.balanceSheet;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class BalanceSheetBean extends BasicResultBean {

	private static final long serialVersionUID = 1L;
	private String company;
	private String fromDate;
	private String groupHeadCode;
	private String groupHeadName;
	private String groupHeadType;
	private double amount;
	private double balance;
	private String C0008_amount;
	private String C0009_amount;
	private String C0010_amount;
	private double currentPeriodEarning;
	private double totalLiablities;
	private double totalAsset;
	private String costCenter;

	public double getTotalLiablities() {
		return totalLiablities;
	}

	public void setTotalLiablities(double totalLiablities) {
		this.totalLiablities = totalLiablities;
	}

	public double getTotalAsset() {
		return totalAsset;
	}

	public void setTotalAsset(double totalAsset) {
		this.totalAsset = totalAsset;
	}

	public double getCurrentPeriodEarning() {
		return currentPeriodEarning;
	}

	public void setCurrentPeriodEarning(double currentPeriodEarning) {
		this.currentPeriodEarning = currentPeriodEarning;
	}

	public String getC0008_amount() {
		return C0008_amount;
	}

	public void setC0008_amount(String c0008_amount) {
		C0008_amount = c0008_amount;
	}

	public String getC0009_amount() {
		return C0009_amount;
	}

	public void setC0009_amount(String c0009_amount) {
		C0009_amount = c0009_amount;
	}

	public String getC0010_amount() {
		return C0010_amount;
	}

	public void setC0010_amount(String c0010_amount) {
		C0010_amount = c0010_amount;
	}

	public String getC0011_amount() {
		return C0011_amount;
	}

	public void setC0011_amount(String c0011_amount) {
		C0011_amount = c0011_amount;
	}

	public String getC0012_amount() {
		return C0012_amount;
	}

	public void setC0012_amount(String c0012_amount) {
		C0012_amount = c0012_amount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String C0011_amount;
	private String C0012_amount;
	private String filePath;
	private List<BalanceSheetBean> lGroupHeadLevelList;
	private List<BalanceSheetBean> lSubGroupLevelList;
	private List<BalanceSheetBean> lAccountHeadLevelList;

	private List<BalanceSheetBean> lGroupHeadLevelLiabilitiesList;
	private List<BalanceSheetBean> lSubGroupLevelLiabilitiesList;
	private List<BalanceSheetBean> lAccountHeadLevelLiabilitiesList;

	public List<BalanceSheetBean> getlGroupHeadLevelLiabilitiesList() {
		return lGroupHeadLevelLiabilitiesList;
	}

	public void setlGroupHeadLevelLiabilitiesList(List<BalanceSheetBean> lGroupHeadLevelLiabilitiesList) {
		this.lGroupHeadLevelLiabilitiesList = lGroupHeadLevelLiabilitiesList;
	}

	public List<BalanceSheetBean> getlSubGroupLevelLiabilitiesList() {
		return lSubGroupLevelLiabilitiesList;
	}

	public void setlSubGroupLevelLiabilitiesList(List<BalanceSheetBean> lSubGroupLevelLiabilitiesList) {
		this.lSubGroupLevelLiabilitiesList = lSubGroupLevelLiabilitiesList;
	}

	public List<BalanceSheetBean> getlAccountHeadLevelLiabilitiesList() {
		return lAccountHeadLevelLiabilitiesList;
	}

	public void setlAccountHeadLevelLiabilitiesList(List<BalanceSheetBean> lAccountHeadLevelLiabilitiesList) {
		this.lAccountHeadLevelLiabilitiesList = lAccountHeadLevelLiabilitiesList;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
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

	public String getGroupHeadType() {
		return groupHeadType;
	}

	public void setGroupHeadType(String groupHeadType) {
		this.groupHeadType = groupHeadType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<BalanceSheetBean> getlGroupHeadLevelList() {
		return lGroupHeadLevelList;
	}

	public void setlGroupHeadLevelList(List<BalanceSheetBean> lGroupHeadLevelList) {
		this.lGroupHeadLevelList = lGroupHeadLevelList;
	}

	public List<BalanceSheetBean> getlSubGroupLevelList() {
		return lSubGroupLevelList;
	}

	public void setlSubGroupLevelList(List<BalanceSheetBean> lSubGroupLevelList) {
		this.lSubGroupLevelList = lSubGroupLevelList;
	}

	public List<BalanceSheetBean> getlAccountHeadLevelList() {
		return lAccountHeadLevelList;
	}

	public void setlAccountHeadLevelList(List<BalanceSheetBean> lAccountHeadLevelList) {
		this.lAccountHeadLevelList = lAccountHeadLevelList;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	
	

}
