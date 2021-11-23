/**
 *
 */
package com.dci.tenant.user;

import java.io.Serializable;

/**
 * @author paragon
 *
 */
public class PropertyMasterBean implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String propertyCode;
	private String propertyName;
	private String isEnabled;
	private String formCode;

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
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName
	 *            the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return the isEnabled
	 */
	public String getIsEnabled() {
		return isEnabled;
	}

	/**
	 * @param isEnabled
	 *            the isEnabled to set
	 */
	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

}
