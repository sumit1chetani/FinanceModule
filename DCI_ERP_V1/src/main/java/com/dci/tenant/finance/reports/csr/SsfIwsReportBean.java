package com.dci.tenant.finance.reports.csr;

public class SsfIwsReportBean {
	private String slotAc;
	private String total;
	private String year;
	private String sfpl;
	private String iws;

	public String getSlotAc() {
		return slotAc;
	}

	public void setSlotAc(String slotAc) {
		this.slotAc = slotAc;
	}


	public String getSsf() {
		return sfpl;
	}

	public void setSsf(String sfpl) {
		this.sfpl = sfpl;
	}

	public String getIws() {
		return iws;
	}

	public void setIws(String iws) {
		this.iws = iws;
	}
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
