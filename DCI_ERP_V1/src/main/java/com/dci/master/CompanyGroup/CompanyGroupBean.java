package com.dci.master.CompanyGroup;

import java.util.ArrayList;




public class CompanyGroupBean {
	private String companycode;
	private String companyname;

	private boolean success;
	private boolean edit;
	private String shortName;

	private String groupname;
private int groupid;
	private String id;
	private String text;
	private ArrayList companyList;
	private ArrayList usrSelectedList;

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}



	public ArrayList getCompanyList() {
		return companyList;
	}

	public void setCompanyList(ArrayList companyList) {
		this.companyList = companyList;
	}

	public ArrayList getUsrSelectedList() {
		return usrSelectedList;
	}

	public void setUsrSelectedList(ArrayList usrSelectedList) {
		this.usrSelectedList = usrSelectedList;
	}



	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
