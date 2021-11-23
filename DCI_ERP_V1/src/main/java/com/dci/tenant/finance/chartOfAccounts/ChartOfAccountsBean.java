package com.dci.tenant.finance.chartOfAccounts;

import java.util.List;

public class ChartOfAccountsBean {

	private int groupHeadId;
	private String groupHeadCode;
	private String groupHeadName;
	private String subGroupAcctCode;
	private String subGroupAcctName;
	private String accountHeadCode;
	private String accountHeadName;
	private String filePath;
	private List<ChartOfAccountsBean> lGrpList;
	private List<ChartOfAccountsBean> lSubGrpList;
	private List<ChartOfAccountsBean> lAccountHeadList;

	public int getGroupHeadId() {
		return groupHeadId;
	}

	public String getGroupHeadCode() {
		return groupHeadCode;
	}

	public String getGroupHeadName() {
		return groupHeadName;
	}

	public void setGroupHeadId(int groupHeadId) {
		this.groupHeadId = groupHeadId;
	}

	public void setGroupHeadCode(String groupHeadCode) {
		this.groupHeadCode = groupHeadCode;
	}

	public void setGroupHeadName(String groupHeadName) {
		this.groupHeadName = groupHeadName;
	}

	public String getSubGroupAcctName() {
		return subGroupAcctName;
	}

	public void setSubGroupAcctName(String subGroupAcctName) {
		this.subGroupAcctName = subGroupAcctName;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public List<ChartOfAccountsBean> getlGrpList() {
		return lGrpList;
	}

	public List<ChartOfAccountsBean> getlSubGrpList() {
		return lSubGrpList;
	}

	public void setlGrpList(List<ChartOfAccountsBean> lGrpList) {
		this.lGrpList = lGrpList;
	}

	public void setlSubGrpList(List<ChartOfAccountsBean> lSubGrpList) {
		this.lSubGrpList = lSubGrpList;
	}

	public String getSubGroupAcctCode() {
		return subGroupAcctCode;
	}

	public void setSubGroupAcctCode(String subGroupAcctCode) {
		this.subGroupAcctCode = subGroupAcctCode;
	}

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public List<ChartOfAccountsBean> getlAccountHeadList() {
		return lAccountHeadList;
	}

	public void setlAccountHeadList(List<ChartOfAccountsBean> lAccountHeadList) {
		this.lAccountHeadList = lAccountHeadList;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
