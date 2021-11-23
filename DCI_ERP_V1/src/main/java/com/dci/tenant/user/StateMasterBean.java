/**
 *
 */
package com.dci.tenant.user;

import java.io.Serializable;

/**
 * @author paragon
 *
 */
public class StateMasterBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String stateName;
	private String stateUrl;
	private String stateTitle;
	private String stateCtrl;
	private boolean isAbstract;
	private String ctrlUrl;
	private String tmplUrl;

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateUrl() {
		return stateUrl;
	}

	public void setStateUrl(String stateUrl) {
		this.stateUrl = stateUrl;
	}

	public String getStateTitle() {
		return stateTitle;
	}

	public void setStateTitle(String stateTitle) {
		this.stateTitle = stateTitle;
	}

	public String getStateCtrl() {
		return stateCtrl;
	}

	public void setStateCtrl(String stateCtrl) {
		this.stateCtrl = stateCtrl;
	}

	public String getCtrlUrl() {
		return ctrlUrl;
	}

	public void setCtrlUrl(String ctrlUrl) {
		this.ctrlUrl = ctrlUrl;
	}

	public String getTmplUrl() {
		return tmplUrl;
	}

	public void setTmplUrl(String tmplUrl) {
		this.tmplUrl = tmplUrl;
	}

	/**
	 * @return the isAbstract
	 */
	public boolean isAbstract() {
		return isAbstract;
	}

	/**
	 * @param isAbstract
	 *            the isAbstract to set
	 */
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
}
