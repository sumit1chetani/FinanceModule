package com.dci.tenant.finance.subheadgroupaccount;

public class SubHeadGroupAccountBean {
	private String subGroupCode;
	private String subGroupName;
	private String grpHeadCode;

	/**
	 * @return the grpHeadCode
	 */
	public String getGrpHeadCode() {
		return grpHeadCode;
	}

	/**
	 * @param grpHeadCode
	 *            the grpHeadCode to set
	 */
	public void setGrpHeadCode(String grpHeadCode) {
		this.grpHeadCode = grpHeadCode;
	}

	private String subGroupDesc;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
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

	private String sgType;

	private boolean edit;

	/**
	 * @return the isEdit
	 */
	public boolean isEdit() {
		return edit;
	}

	/**
	 * @param isEdit
	 *            the isEdit to set
	 */
	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	public String getSubGroupCode() {
		return subGroupCode;
	}

	public void setSubGroupCode(String subGroupCode) {
		this.subGroupCode = subGroupCode;
	}

	/**
	 * @return the subGroupName
	 */
	public String getSubGroupName() {
		return subGroupName;
	}

	/**
	 * @param subGroupName
	 *            the subGroupName to set
	 */
	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}

	/**
	 * @return the subGroupDesc
	 */
	public String getSubGroupDesc() {
		return subGroupDesc;
	}

	/**
	 * @param subGroupDesc
	 *            the subGroupDesc to set
	 */
	public void setSubGroupDesc(String subGroupDesc) {
		this.subGroupDesc = subGroupDesc;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedDate
	 */
	public String getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getSgType() {
		return sgType;
	}

	public void setSgType(String sgType) {
		this.sgType = sgType;
	}

}
