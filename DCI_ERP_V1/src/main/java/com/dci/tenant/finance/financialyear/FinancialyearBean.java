package com.dci.tenant.finance.financialyear;

public class FinancialyearBean {

	private String fyFrom;
	private String fyTo;
	private String iscurrent;
	private String fyId;
	private String fyShortId;
	private String companyCode;
	private boolean active;
	private String companyName;

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

	public String getFyFrom() {
		return fyFrom;
	}

	public void setFyFrom(String fyFrom) {
		this.fyFrom = fyFrom;
	}

	public String getFyTo() {
		return fyTo;
	}

	public void setFyTo(String fyTo) {
		this.fyTo = fyTo;
	}

	public String getIscurrent() {
		return iscurrent;
	}

	public void setIscurrent(String iscurrent) {
		this.iscurrent = iscurrent;
	}

	public String getFyId() {
		return fyId;
	}

	public void setFyId(String fyId) {
		this.fyId = fyId;
	}

	public String getFyShortId() {
		return fyShortId;
	}

	public void setFyShortId(String fyShortId) {
		this.fyShortId = fyShortId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
