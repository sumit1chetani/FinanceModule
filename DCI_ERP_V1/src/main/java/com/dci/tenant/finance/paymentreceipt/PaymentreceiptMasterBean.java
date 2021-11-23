package com.dci.tenant.finance.paymentreceipt;

import java.util.List;

import com.dci.master.attributes.AttributeBean;

public class PaymentreceiptMasterBean {

	private String subGroupAccountCode;
	private String accountHeadName;
	private String accountHeadCode;
	private String description;
	private String grpHeadName;
	private String type;
	private String groupHeadCode;
	private String subGroupAccountName;
	private String grpHd;
	private String currencyCode;
	private String currencyName;
	private String acctHeadStatus;
	private String isreceipt;
	private String ispayment;

	// private boolean isEdit;
	private boolean edit;

	private List<AttributeBean> lAttributeList;
	private List<String> lAttributes;

	private String subname;

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getGrpHd() {
		return grpHd;
	}

	public void setGrpHd(String grpHd) {
		this.grpHd = grpHd;
	}

	public String getGroupHeadCode() {
		return groupHeadCode;
	}

	public void setGroupHeadCode(String groupHeadCode) {
		this.groupHeadCode = groupHeadCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGrpHeadName() {
		return grpHeadName;
	}

	public void setGrpHeadName(String grpHeadName) {
		this.grpHeadName = grpHeadName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getAcctHeadStatus() {
		return acctHeadStatus;
	}

	public void setAcctHeadStatus(String acctHeadStatus) {
		this.acctHeadStatus = acctHeadStatus;
	}

	public List<AttributeBean> getlAttributeList() {
		return lAttributeList;
	}

	public void setlAttributeList(List<AttributeBean> lAttributeList) {
		this.lAttributeList = lAttributeList;
	}

	public List<String> getlAttributes() {
		return lAttributes;
	}

	public void setlAttributes(List<String> lAttributes) {
		this.lAttributes = lAttributes;
	}

	public String getSubGroupAccountCode() {
		return subGroupAccountCode;
	}

	public void setSubGroupAccountCode(String subGroupAccountCode) {
		this.subGroupAccountCode = subGroupAccountCode;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public String getAccountHeadCode() {
		return accountHeadCode;
	}

	public void setAccountHeadCode(String accountHeadCode) {
		this.accountHeadCode = accountHeadCode;
	}

	public String getSubGroupAccountName() {
		return subGroupAccountName;
	}

	public void setSubGroupAccountName(String subGroupAccountName) {
		this.subGroupAccountName = subGroupAccountName;
	}

	public String getIsreceipt() {
		return isreceipt;
	}

	public void setIsreceipt(String isreceipt) {
		this.isreceipt = isreceipt;
	}

	public String getIspayment() {
		return ispayment;
	}

	public void setIspayment(String ispayment) {
		this.ispayment = ispayment;
	}

	
}
