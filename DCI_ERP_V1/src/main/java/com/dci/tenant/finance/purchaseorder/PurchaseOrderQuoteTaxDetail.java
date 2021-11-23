package com.dci.tenant.finance.purchaseorder;

import java.util.ArrayList;

public class PurchaseOrderQuoteTaxDetail {

	private String discountType;
	private Double dicountPercentage;
	private Double discountAmount;
	private String taxType;
	private String taxCode;
	private Double taxPercentage;
	private Double taxAmount;
	private String ltaxIds;

	private double taxCGST;
	private double taxSGST;
	private double taxIGST;
	private Double taxCGSTinPercent;
	private Double taxSGSTinPercent;
	private Double taxIGSTinPercent;

	public Double getTaxCGSTinPercent() {
		return taxCGSTinPercent;
	}

	public void setTaxCGSTinPercent(Double taxCGSTinPercent) {
		this.taxCGSTinPercent = taxCGSTinPercent;
	}

	public Double getTaxSGSTinPercent() {
		return taxSGSTinPercent;
	}

	public void setTaxSGSTinPercent(Double taxSGSTinPercent) {
		this.taxSGSTinPercent = taxSGSTinPercent;
	}

	public Double getTaxIGSTinPercent() {
		return taxIGSTinPercent;
	}

	public void setTaxIGSTinPercent(Double taxIGSTinPercent) {
		this.taxIGSTinPercent = taxIGSTinPercent;
	}

	public double getTaxCGST() {
		return taxCGST;
	}

	public void setTaxCGST(double taxCGST) {
		this.taxCGST = taxCGST;
	}

	public double getTaxSGST() {
		return taxSGST;
	}

	public void setTaxSGST(double taxSGST) {
		this.taxSGST = taxSGST;
	}

	public double getTaxIGST() {
		return taxIGST;
	}

	public void setTaxIGST(double taxIGST) {
		this.taxIGST = taxIGST;
	}

	private ArrayList<String> taxIdslist = new ArrayList<String>();

	private boolean select = false;

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Double getDicountPercentage() {
		return dicountPercentage;
	}

	public void setDicountPercentage(Double dicountPercentage) {
		this.dicountPercentage = dicountPercentage;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public Double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(Double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public String getLtaxIds() {
		return ltaxIds;
	}

	public void setLtaxIds(String ltaxIds) {
		this.ltaxIds = ltaxIds;
	}

	public ArrayList<String> getTaxIdslist() {
		return taxIdslist;
	}

	public void setTaxIdslist(ArrayList<String> taxIdslist) {
		this.taxIdslist = taxIdslist;
	}

}
