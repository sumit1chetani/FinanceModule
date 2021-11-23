package com.dci.tenant.finance.TDSForm;

public class TDSFormBean {

	private boolean edit;
	private String acctdesc;
	private String tdsname;
	private String tdscode;
	private String tdsType;
	private String tdsDesc;
	private String tdsauto;
	private String acctHeadStatus;

	public String getAcctHeadStatus() {
		return acctHeadStatus;
	}

	public void setAcctHeadStatus(String acctHeadStatus) {
		this.acctHeadStatus = acctHeadStatus;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getAcctdesc() {
		return acctdesc;
	}

	public void setAcctdesc(String acctdesc) {
		this.acctdesc = acctdesc;
	}

	public String getTdsname() {
		return tdsname;
	}

	public void setTdsname(String tdsname) {
		this.tdsname = tdsname;
	}

	public String getTdscode() {
		return tdscode;
	}

	public void setTdscode(String tdscode) {
		this.tdscode = tdscode;
	}

	public String getTdsType() {
		return tdsType;
	}

	public void setTdsType(String tdsType) {
		this.tdsType = tdsType;
	}

	public String getTdsDesc() {
		return tdsDesc;
	}

	public void setTdsDesc(String tdsDesc) {
		this.tdsDesc = tdsDesc;
	}

	public String getTdsauto() {
		return tdsauto;
	}

	public void setTdsauto(String tdsauto) {
		this.tdsauto = tdsauto;
	}

}
