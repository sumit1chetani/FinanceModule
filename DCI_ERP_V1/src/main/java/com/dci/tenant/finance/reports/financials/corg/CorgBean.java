package com.dci.tenant.finance.reports.financials.corg;

public class CorgBean {

	private String companyCode;
	private String fromDate;
	private String toDate;
	private String year;
	private String week;
	
	// code added for getting the report results
	
	private double totalAmount;
	private double CO30;
	private double CO30Per;
	private double CO30to45;
	private double CO30to45Per;
	private double CO45to60;
	private double CO45to60Per;
	private double CO60Plus;
	private double CO60PlusPer;
	
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getCO30() {
		return CO30;
	}
	public void setCO30(double cO30) {
		CO30 = cO30;
	}
	public double getCO30Per() {
		return CO30Per;
	}
	public void setCO30Per(double cO30Per) {
		CO30Per = cO30Per;
	}
	public double getCO30to45() {
		return CO30to45;
	}
	public void setCO30to45(double cO30to45) {
		CO30to45 = cO30to45;
	}
	public double getCO30to45Per() {
		return CO30to45Per;
	}
	public void setCO30to45Per(double cO30to45Per) {
		CO30to45Per = cO30to45Per;
	}
	public double getCO45to60() {
		return CO45to60;
	}
	public void setCO45to60(double cO45to60) {
		CO45to60 = cO45to60;
	}
	public double getCO45to60Per() {
		return CO45to60Per;
	}
	public void setCO45to60Per(double cO45to60Per) {
		CO45to60Per = cO45to60Per;
	}
	public double getCO60Plus() {
		return CO60Plus;
	}
	public void setCO60Plus(double cO60Plus) {
		CO60Plus = cO60Plus;
	}
	public double getCO60PlusPer() {
		return CO60PlusPer;
	}
	public void setCO60PlusPer(double cO60PlusPer) {
		CO60PlusPer = cO60PlusPer;
	}
	
	
	
		
}
