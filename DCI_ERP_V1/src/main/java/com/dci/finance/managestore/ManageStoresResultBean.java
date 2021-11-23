package com.dci.finance.managestore;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ManageStoresResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ManageStoresBean> manageStoresList;
	private List<ManageStoresBean> parentlocationList;
	private List<ManageStoresBean> stateList;
	private List<ManageStoresBean> countryList;
	private List<ManageStoresBean> locationtypeList;
	private List<ManageStoresBean> inchargeList;
	private List<ManageStoresBean> cityList;
	private List<ManageStoresBean> parentAddressList;
	private ManageStoresBean manageStoresBean = new ManageStoresBean();

	private List<ManageStoresBean> editList;

	public List<ManageStoresBean> getManageStoresList() {
		return manageStoresList;
	}

	public void setManageStoresList(List<ManageStoresBean> manageStoresList) {
		this.manageStoresList = manageStoresList;
	}

	public ManageStoresBean getManageStoresBean() {
		return manageStoresBean;
	}

	public void setManageStoresBean(ManageStoresBean manageStoresBean) {
		this.manageStoresBean = manageStoresBean;
	}

	public List<ManageStoresBean> getparentlocationList() {
		return parentlocationList;
	}

	public void setparentlocationList(List<ManageStoresBean> parentlocationList) {
		this.parentlocationList = parentlocationList;
	}

	public List<ManageStoresBean> getStateList() {
		return stateList;
	}

	public void setStateList(List<ManageStoresBean> stateList) {
		this.stateList = stateList;
	}

	public List<ManageStoresBean> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<ManageStoresBean> countryList) {
		this.countryList = countryList;
	}

	public List<ManageStoresBean> getCityList() {
		return cityList;
	}

	public void setCityList(List<ManageStoresBean> cityList) {
		this.cityList = cityList;
	}

	public List<ManageStoresBean> getlocationtypeList() {
		return locationtypeList;
	}

	public void setlocationtypeList(List<ManageStoresBean> locationtypeList) {
		this.locationtypeList = locationtypeList;
	}

	public List<ManageStoresBean> getinchargeList() {
		return inchargeList;
	}

	public void setinchargeList(List<ManageStoresBean> inchargeList) {
		this.inchargeList = inchargeList;
	}

	public List<ManageStoresBean> getEditList() {
		return editList;
	}

	public void setEditList(List<ManageStoresBean> editList) {
		this.editList = editList;
	}

	public List<ManageStoresBean> getParentAddressList() {
		return parentAddressList;
	}

	public void setParentAddressList(List<ManageStoresBean> parentAddressList) {
		this.parentAddressList = parentAddressList;
	}

}
