package com.dci.tenant.user;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class UserMasterResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserMasterBean userMasterBean;
	private List<PropertyMasterBean> lPropertyMasterBean;
	private List<FormMasterBean> lFormMasterBean;
	private List<ModuleMasterBean> lModuleMasterBean;
	private List<UserMasterBean> lUserMasterBean;
	private List<FormPropertyBean>  lFormPropertyBean;
	public List<FormPropertyBean> getlFormPropertyBean() {
		return lFormPropertyBean;
	}

	public void setlFormPropertyBean(List<FormPropertyBean> lFormPropertyBean) {
		this.lFormPropertyBean = lFormPropertyBean;
	}

	private FormPropertyBean lformPropertyBean;
	public FormPropertyBean getlformPropertyBean() {
		return lformPropertyBean;
	}

	public void setlformPropertyBean(FormPropertyBean lformPropertyBean) {
		this.lformPropertyBean = lformPropertyBean;
	}

	private List<CompanyDetailsBean> lCompanyDetailsBean;
	private List<DesignationMasterBean> lDesignationMasterBean;
	private List<UserDetail> getPassword;
	
	

	public List<UserDetail> getGetPassword() {
		return getPassword;
	}

	public void setGetPassword(List<UserDetail> getPassword) {
		this.getPassword = getPassword;
	}

	/**
	 * @return the lModuleMasterBean
	 */
	public List<ModuleMasterBean> getlModuleMasterBean() {
		return lModuleMasterBean;
	}

	/**
	 * @param lModuleMasterBean
	 *            the lModuleMasterBean to set
	 */
	public void setlModuleMasterBean(List<ModuleMasterBean> lModuleMasterBean) {
		this.lModuleMasterBean = lModuleMasterBean;
	}

	public List<UserMasterBean> getlUserMasterBean() {
		return lUserMasterBean;
	}

	public void setlUserMasterBean(List<UserMasterBean> lUserMasterBean) {
		this.lUserMasterBean = lUserMasterBean;
	}

	/**
	 * @return the lCompanyDetailsBean
	 */
	public List<CompanyDetailsBean> getlCompanyDetailsBean() {
		return lCompanyDetailsBean;
	}

	/**
	 * @param lCompanyDetailsBean
	 *            the lCompanyDetailsBean to set
	 */
	public void setlCompanyDetailsBean(List<CompanyDetailsBean> lCompanyDetailsBean) {
		this.lCompanyDetailsBean = lCompanyDetailsBean;
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
	 * @return the lDesignationMasterBean
	 */
	public List<DesignationMasterBean> getlDesignationMasterBean() {
		return lDesignationMasterBean;
	}

	/**
	 * @param lDesignationMasterBean
	 *            the lDesignationMasterBean to set
	 */
	public void setlDesignationMasterBean(List<DesignationMasterBean> lDesignationMasterBean) {
		this.lDesignationMasterBean = lDesignationMasterBean;
	}

	/**
	 * @return the lPropertyMasterBean
	 */
	public List<PropertyMasterBean> getlPropertyMasterBean() {
		return lPropertyMasterBean;
	}

	/**
	 * @param lPropertyMasterBean
	 *            the lPropertyMasterBean to set
	 */
	public void setlPropertyMasterBean(List<PropertyMasterBean> lPropertyMasterBean) {
		this.lPropertyMasterBean = lPropertyMasterBean;
	}

	/**
	 * @return the userMasterBean
	 */
	public UserMasterBean getUserMasterBean() {
		return userMasterBean;
	}

	/**
	 * @param userMasterBean
	 *            the userMasterBean to set
	 */
	public void setUserMasterBean(UserMasterBean userMasterBean) {
		this.userMasterBean = userMasterBean;
	}
}