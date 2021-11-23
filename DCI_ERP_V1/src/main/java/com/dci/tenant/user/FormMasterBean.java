/**
 *
 */
package com.dci.tenant.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author paragon
 *
 */
public class FormMasterBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String formCode;
	private boolean propertyRow;
	private String formName;
	private String formCodeParent;
	private String formUrl;
	private String moduleCode;
	private String imageIconUrl;
	private int displayOrder;
	private boolean isEnabled;
	private boolean isParentForm;
	private String isParent;
	private int childCount;
	private List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
	private List<FormPropertyBean> lFormPropertyBean = new ArrayList<FormPropertyBean>();
	private int menuLevel = 0;

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getImageIconUrl() {
		return imageIconUrl;
	}

	public void setImageIconUrl(String imageIconUrl) {
		this.imageIconUrl = imageIconUrl;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return the formCodeParent
	 */
	public String getFormCodeParent() {
		return formCodeParent;
	}

	/**
	 * @param formCodeParent
	 *            the formCodeParent to set
	 */
	public void setFormCodeParent(String formCodeParent) {
		this.formCodeParent = formCodeParent;
	}

	/**
	 * @return the formUrl
	 */
	public String getFormUrl() {
		return formUrl;
	}

	/**
	 * @param formUrl
	 *            the formUrl to set
	 */
	public void setFormUrl(String formUrl) {
		this.formUrl = formUrl;
	}

	/**
	 * @return the lFormMasterBean
	 */
	public List<FormMasterBean> getlFormMasterBean() {
		return lFormMasterBean;
	}

	/**
	 * @param lFormMasterBean
	 *            the lFormMasterBean to set
	 */
	public void setlFormMasterBean(List<FormMasterBean> lFormMasterBean) {
		this.lFormMasterBean = lFormMasterBean;
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
	 * @return the lFormPropertyBean
	 */
	public List<FormPropertyBean> getlFormPropertyBean() {
		return lFormPropertyBean;
	}

	/**
	 * @param lFormPropertyBean
	 *            the lFormPropertyBean to set
	 */
	public void setlFormPropertyBean(List<FormPropertyBean> lFormPropertyBean) {
		this.lFormPropertyBean = lFormPropertyBean;
	}

	public void setFormPropertyBean(FormPropertyBean formPropertyBean) {
		this.lFormPropertyBean.add(formPropertyBean);
	}

	public boolean isParentForm() {
		return isParentForm;
	}

	public void setParentForm(boolean isParentForm) {
		this.isParentForm = isParentForm;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
		if (isParent.equalsIgnoreCase("Y")) {
			this.isParentForm = true;
		}
	}

	public boolean isPropertyRow() {
		return propertyRow;
	}

	public void setPropertyRow(boolean propertyRow) {
		this.propertyRow = propertyRow;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}
}
