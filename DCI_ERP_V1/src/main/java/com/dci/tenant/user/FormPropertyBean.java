/**
 *
 */
package com.dci.tenant.user;

import java.io.Serializable;

/**
 * @author paragon
 *
 */
public class FormPropertyBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int formPropertyId;
	private String formCode;
	private String propertyCode;
	private boolean isEnabled;
	private boolean isAvailable;
	private String formName;
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

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	/**
	 * @return the formPropertyId
	 */
	public int getFormPropertyId() {
		return formPropertyId;
	}

	/**
	 * @param formPropertyId
	 *            the formPropertyId to set
	 */
	public void setFormPropertyId(int formPropertyId) {
		this.formPropertyId = formPropertyId;
	}

	/**
	 * @return the formCode
	 */
	public String getFormCode() {
		return formCode;
	}

	/**
	 * @param formCode
	 *            the formCode to set
	 */
	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	/**
	 * @return the propertyCode
	 */
	public String getPropertyCode() {
		return propertyCode;
	}

	/**
	 * @param propertyCode
	 *            the propertyCode to set
	 */
	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	/**
	 * @return the isEnabled
	 */
	public boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * @param isEnabled
	 *            the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable
	 *            the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
