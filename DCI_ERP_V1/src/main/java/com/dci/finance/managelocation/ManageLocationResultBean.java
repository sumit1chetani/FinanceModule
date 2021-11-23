package com.dci.finance.managelocation;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ManageLocationResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ManageLocationBean> manageLocationList;
	private List<ManageLocationBean> parentlocationList;
	private List<ManageLocationBean> stateList;
	private List<ManageLocationBean> countryList;
	private List<ManageLocationBean> locationtypeList;
	private List<ManageLocationBean> inchargeList;
	private List<ManageLocationBean> cityList;
	private List<ManageLocationBean> parentAddressList;
	
	private List<ManageLocationBean> locationtypeListNew;

	private ManageLocationBean manageLocationBean = new ManageLocationBean();

	private List<ManageLocationBean> editList;

	public List<ManageLocationBean> getManageLocationList() {
		return manageLocationList;
	}

	public void setManageLocationList(List<ManageLocationBean> manageLocationList) {
		this.manageLocationList = manageLocationList;
	}

	public ManageLocationBean getManageLocationBean() {
		return manageLocationBean;
	}

	public void setManageLocationBean(ManageLocationBean manageLocationBean) {
		this.manageLocationBean = manageLocationBean;
	}

	public List<ManageLocationBean> getparentlocationList() {
		return parentlocationList;
	}

	public void setparentlocationList(List<ManageLocationBean> parentlocationList) {
		this.parentlocationList = parentlocationList;
	}

	public List<ManageLocationBean> getStateList() {
		return stateList;
	}

	public void setStateList(List<ManageLocationBean> stateList) {
		this.stateList = stateList;
	}

	public List<ManageLocationBean> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<ManageLocationBean> countryList) {
		this.countryList = countryList;
	}

	public List<ManageLocationBean> getCityList() {
		return cityList;
	}

	public void setCityList(List<ManageLocationBean> cityList) {
		this.cityList = cityList;
	}

	public List<ManageLocationBean> getlocationtypeList() {
		return locationtypeList;
	}

	public void setlocationtypeList(List<ManageLocationBean> locationtypeList) {
		this.locationtypeList = locationtypeList;
	}

	public List<ManageLocationBean> getinchargeList() {
		return inchargeList;
	}

	public void setinchargeList(List<ManageLocationBean> inchargeList) {
		this.inchargeList = inchargeList;
	}

	public List<ManageLocationBean> getEditList() {
		return editList;
	}

	public void setEditList(List<ManageLocationBean> editList) {
		this.editList = editList;
	}

	public List<ManageLocationBean> getParentAddressList() {
		return parentAddressList;
	}

	public void setParentAddressList(List<ManageLocationBean> parentAddressList) {
		this.parentAddressList = parentAddressList;
	}

	public List<ManageLocationBean> getLocationtypeListNew() {
		return locationtypeListNew;
	}

	public void setLocationtypeListNew(List<ManageLocationBean> locationtypeListNew) {
		this.locationtypeListNew = locationtypeListNew;
	}

	
}
