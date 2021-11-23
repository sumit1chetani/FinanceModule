package com.dci.tenant.finance.payableAgewise;

import java.util.List;

import com.dci.common.util.BasicResultBean;

@SuppressWarnings("serial")
public class PayableAgewiseBean extends BasicResultBean {

	private String supplierCode;
	private String supplierName;
	private double below15days;
	private double days30;
	private double days45;
	private double days90;
	private double days180;
	private double above180days;

	// detail list
	private String invoiceNo;
	private String invoiceDate;
	private double invoiceAmount;
	private double paidAmount;
	private double balanceAmount;

	private String apDate;
	private List<PayableAgewiseBean> lPayableAgewiseDtlList;
	private String filePath;

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public double getBelow15days() {
		return below15days;
	}

	public void setBelow15days(double below15days) {
		this.below15days = below15days;
	}

	public double getDays30() {
		return days30;
	}

	public void setDays30(double days30) {
		this.days30 = days30;
	}

	public double getDays45() {
		return days45;
	}

	public void setDays45(double days45) {
		this.days45 = days45;
	}

	public double getDays90() {
		return days90;
	}

	public void setDays90(double days90) {
		this.days90 = days90;
	}

	public double getDays180() {
		return days180;
	}

	public void setDays180(double days180) {
		this.days180 = days180;
	}

	public double getAbove180days() {
		return above180days;
	}

	public void setAbove180days(double above180days) {
		this.above180days = above180days;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getApDate() {
		return apDate;
	}

	public void setApDate(String apDate) {
		this.apDate = apDate;
	}

	public List<PayableAgewiseBean> getlPayableAgewiseDtlList() {
		return lPayableAgewiseDtlList;
	}

	public void setlPayableAgewiseDtlList(List<PayableAgewiseBean> lPayableAgewiseDtlList) {
		this.lPayableAgewiseDtlList = lPayableAgewiseDtlList;
	}

}
