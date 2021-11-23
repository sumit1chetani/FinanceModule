package com.dci.tenant.user;

public class CompanyDetailsBean {

	private String companyCode;
	private String companyName;
	private String companyLocation;
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

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyname) {
		this.companyName = companyname;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companycode) {
		this.companyCode = companycode;
	}

}
