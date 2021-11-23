package com.dci.tenant.finance.bankcompany;

import java.util.List;

import com.dci.master.attributes.AttributeBean;

public class BankcompanyBean {

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
	private String companyName;
	private String accountName;
	private boolean edit;
	private String acctHeadStatus;
	private String branch;
	private String bankacctname;
	private String companyCode;
	private String bankCode;
	private String acctdesc;
	private String bankshort;
	private String cashbankPayment;
	private String paymentType;

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCashbankPayment() {
		return cashbankPayment;
	}

	public void setCashbankPayment(String cashbankPayment) {
		this.cashbankPayment = cashbankPayment;
	}

	public String getBankshort() {
		return bankshort;
	}

	public void setBankshort(String bankshort) {
		this.bankshort = bankshort;
	}

	public String getAcctdesc() {
		return acctdesc;
	}

	public void setAcctdesc(String acctdesc) {
		this.acctdesc = acctdesc;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	private List<AttributeBean> lAttributeList;
	private List<String> lAttributes;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBankacctname() {
		return bankacctname;
	}

	public void setBankacctname(String bankacctname) {
		this.bankacctname = bankacctname;
	}

	public String getAcctHeadStatus() {
		return acctHeadStatus;
	}

	public void setAcctHeadStatus(String acctHeadStatus) {
		this.acctHeadStatus = acctHeadStatus;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGrpHeadName() {
		return grpHeadName;
	}

	public void setGrpHeadName(String grpHeadName) {
		this.grpHeadName = grpHeadName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroupHeadCode() {
		return groupHeadCode;
	}

	public void setGroupHeadCode(String groupHeadCode) {
		this.groupHeadCode = groupHeadCode;
	}

	public String getSubGroupAccountName() {
		return subGroupAccountName;
	}

	public void setSubGroupAccountName(String subGroupAccountName) {
		this.subGroupAccountName = subGroupAccountName;
	}

	public String getGrpHd() {
		return grpHd;
	}

	public void setGrpHd(String grpHd) {
		this.grpHd = grpHd;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setIsActive(String string) {
		// TODO Auto-generated method stub

	}

}
