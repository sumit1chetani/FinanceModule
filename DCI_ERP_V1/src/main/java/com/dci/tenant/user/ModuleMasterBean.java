/**
 *
 */
package com.dci.tenant.user;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paragon
 *
 */
public class ModuleMasterBean {

	private String moduleCode;
	private String moduleName;
	private String imageIconUrl;
	private int displayOrder;
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

	private List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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

	public List<FormMasterBean> getlFormMasterBean() {
		return lFormMasterBean;
	}

	public void setlFormMasterBean(List<FormMasterBean> lFormMasterBean) {
		this.lFormMasterBean = lFormMasterBean;
	}

}
