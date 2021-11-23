package com.dci.tenant.user;

import java.io.Serializable;
import java.util.List;

public class UserMasterBean implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String companyCode;
	private String moduleCode;
	private String formCode;
	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	private int baseCompany;
	private int companyUserId;
	private List<String> companyCodesMapped;
	private String id;
	private String text;
	private String filename;
	private Integer mode;

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

	public int getCompanyUserId() {
		return companyUserId;
	}

	public void setCompanyUserId(int companyUserId) {
		this.companyUserId = companyUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the companyCodesMapped
	 */
	public List<String> getCompanyCodesMapped() {
		return companyCodesMapped;
	}

	/**
	 * @param companyCodesMapped
	 *            the companyCodesMapped to set
	 */
	public void setCompanyCodesMapped(List<String> companyCodesMapped) {
		this.companyCodesMapped = companyCodesMapped;
	}

	/**
	 * @return the companyCode
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * @param companyCode
	 *            the companyCode to set
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * @return the moduleCode
	 */
	public String getModuleCode() {
		return moduleCode;
	}

	/**
	 * @param moduleCode
	 *            the moduleCode to set
	 */
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public int getBaseCompany() {
		return baseCompany;
	}

	public void setBaseCompany(int baseCompany) {
		this.baseCompany = baseCompany;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getMode() {
		return mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}
	

}
