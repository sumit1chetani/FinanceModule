package com.dci.payroll.tds.slabrate;

public class SlabRateBean {
	private int taxRateId;
	private int taxPayerTypeId;
	private int rangeFrom;
	private int rangeTo;
	private double rateInPercentage;
	private String taxPayerTypeName;
	private String financialYear;
	private int id;
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTaxRateId() {
		return taxRateId;
	}

	public void setTaxRateId(int taxRateId) {
		this.taxRateId = taxRateId;
	}

	public int getTaxPayerTypeId() {
		return taxPayerTypeId;
	}

	public void setTaxPayerTypeId(int taxPayerTypeId) {
		this.taxPayerTypeId = taxPayerTypeId;
	}

	public int getRangeFrom() {
		return rangeFrom;
	}

	public void setRangeFrom(int rangeFrom) {
		this.rangeFrom = rangeFrom;
	}

	public int getRangeTo() {
		return rangeTo;
	}

	public void setRangeTo(int rangeTo) {
		this.rangeTo = rangeTo;
	}

	public double getRateInPercentage() {
		return rateInPercentage;
	}

	public void setRateInPercentage(double rateInPercentage) {
		this.rateInPercentage = rateInPercentage;
	}

	public String getTaxPayerTypeName() {
		return taxPayerTypeName;
	}

	public void setTaxPayerTypeName(String taxPayerTypeName) {
		this.taxPayerTypeName = taxPayerTypeName;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
}
