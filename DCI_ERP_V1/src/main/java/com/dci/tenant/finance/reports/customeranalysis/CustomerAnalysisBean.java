package com.dci.tenant.finance.reports.customeranalysis;


public class CustomerAnalysisBean {
	
	private String companyCode ;
	private String fromDate;
	private String toDate;	
	private String customer;
	private String teus2016;
	private String teus2015;
	private String rev2016;
	private String rev2015;
	private String rev_per_teus2016;
	private String rev_per_teus2015;
	private String week;
	private String weekNo;	
	private String year;
	private String month;
	private String monthName;
	private String companyName;
	private String sectorName;
	private String vessel;
	private String voyage;
	private String mlos;
	private String top;
	private boolean previousYear;
	private String filename;
	
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
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getTeus2016() {
		return teus2016;
	}
	public void setTeus2016(String teus2016) {
		this.teus2016 = teus2016;
	}
	public String getTeus2015() {
		return teus2015;
	}
	public void setTeus2015(String teus2015) {
		this.teus2015 = teus2015;
	}
	public String getRev2016() {
		return rev2016;
	}
	public void setRev2016(String rev2016) {
		this.rev2016 = rev2016;
	}
	public String getRev2015() {
		return rev2015;
	}
	public void setRev2015(String rev2015) {
		this.rev2015 = rev2015;
	}
	public String getRev_per_teus2016() {
		return rev_per_teus2016;
	}
	public void setRev_per_teus2016(String rev_per_teus2016) {
		this.rev_per_teus2016 = rev_per_teus2016;
	}
	public String getRev_per_teus2015() {
		return rev_per_teus2015;
	}
	public void setRev_per_teus2015(String rev_per_teus2015) {
		this.rev_per_teus2015 = rev_per_teus2015;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getWeekNo() {
		return weekNo;
	}
	public void setWeekNo(String weekNo) {
		this.weekNo = weekNo;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getVessel() {
		return vessel;
	}
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	public String getVoyage() {
		return voyage;
	}
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public boolean isPreviousYear() {
		return previousYear;
	}
	public void setPreviousYear(boolean previousYear) {
		this.previousYear = previousYear;
	}
	public String getMlos() {
		return mlos;
	}
	public void setMlos(String mlos) {
		this.mlos = mlos;
	}
	private String id;

	private String text;

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
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
