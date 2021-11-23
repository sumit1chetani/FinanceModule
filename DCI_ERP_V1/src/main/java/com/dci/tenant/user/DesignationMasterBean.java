/**
 *
 */
package com.dci.tenant.user;

/**
 * @author paragon
 *
 */
public class DesignationMasterBean {

	private String designationCode;
	private String designationName;
	private String designationDesc;
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

	public String getDesignationDesc() {
		return designationDesc;
	}

	public void setDesignationDesc(String designationDesc) {
		this.designationDesc = designationDesc;
	}

	/**
	 * @return the designationCode
	 */
	public String getDesignationCode() {
		return designationCode;
	}

	/**
	 * @param designationCode
	 *            the designationCode to set
	 */
	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	/**
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * @param designationName
	 *            the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

}
