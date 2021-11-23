package com.dci.tenant.finance;

public class RebateFreightRefundDtlBean {
	private String select;
	private String rebateRefundDtlId;
	private String from;
	private String to;
	private String fromDate;
	private String toDate;
	private String value;
	private double percentage;
	private String currencyCode;
	private String currencyName;

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getRebateRefundDtlId() {
		return rebateRefundDtlId;
	}

	public void setRebateRefundDtlId(String rebateRefundDtlId) {
		this.rebateRefundDtlId = rebateRefundDtlId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
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

}
