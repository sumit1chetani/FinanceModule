package com.dci.tenant.finance.chqPresentation;

import java.util.List;

public class ChqPresentationBean {

	private String prCode;
	private String customerCode;
	private String customerName;
	private String chqNo;
	private String chqDate;
	private double chqAmnt;
	private String presentDate;
	private String status;
	private String realisedDate;
	private String companyCode;
	private String companyName;
	private String drwnBank;
	private String depositBank;
	private String chqRcvdDate;
	private String id;
	private String text;
	private String isPresented;
	private String isRealised;
	private List<ChqPresentationBean> customerList;
	private List<ChqPresentationBean> comapnyList;

	public String getIsPresented() {
		return isPresented;
	}

	public void setIsPresented(String isPresented) {
		this.isPresented = isPresented;
	}

	public String getIsRealised() {
		return isRealised;
	}

	public void setIsRealised(String isRealised) {
		this.isRealised = isRealised;
	}

	public List<ChqPresentationBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<ChqPresentationBean> customerList) {
		this.customerList = customerList;
	}

	public List<ChqPresentationBean> getComapnyList() {
		return comapnyList;
	}

	public void setComapnyList(List<ChqPresentationBean> comapnyList) {
		this.comapnyList = comapnyList;
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

	public String getDrwnBank() {
		return drwnBank;
	}

	public void setDrwnBank(String drwnBank) {
		this.drwnBank = drwnBank;
	}

	public String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	public String getChqRcvdDate() {
		return chqRcvdDate;
	}

	public void setChqRcvdDate(String chqRcvdDate) {
		this.chqRcvdDate = chqRcvdDate;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPrCode() {
		return prCode;
	}

	public void setPrCode(String prCode) {
		this.prCode = prCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getChqNo() {
		return chqNo;
	}

	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}

	public String getChqDate() {
		return chqDate;
	}

	public void setChqDate(String chqDate) {
		this.chqDate = chqDate;
	}

	public double getChqAmnt() {
		return chqAmnt;
	}

	public void setChqAmnt(double chqAmnt) {
		this.chqAmnt = chqAmnt;
	}

	public String getPresentDate() {
		return presentDate;
	}

	public void setPresentDate(String presentDate) {
		this.presentDate = presentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRealisedDate() {
		return realisedDate;
	}

	public void setRealisedDate(String realisedDate) {
		this.realisedDate = realisedDate;
	}

}
