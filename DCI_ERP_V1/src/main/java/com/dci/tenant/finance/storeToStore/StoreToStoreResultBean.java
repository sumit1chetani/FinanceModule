package com.dci.tenant.finance.storeToStore;

import java.util.List;

public class StoreToStoreResultBean {
	private StoreToStore headerData = new StoreToStore();// Save Main Header
	private List<StoreToStoreSubBean> subData; // Save Sub Item Data

	private List<StoreToStore> employeeList;
	private List<StoreToStore> locationList;

	private List<StoreToStore> qcItemList;

	private List<StoreToStore> destLocationList;
	private List<StoreToStoreSubBean> itemList;

	private StoreToStoreSubBean itemData = new StoreToStoreSubBean();

	private String userId;

	public List<StoreToStore> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<StoreToStore> employeeList) {
		this.employeeList = employeeList;
	}

	public List<StoreToStore> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<StoreToStore> locationList) {
		this.locationList = locationList;
	}

	public List<StoreToStoreSubBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<StoreToStoreSubBean> itemList) {
		this.itemList = itemList;
	}

	public StoreToStoreSubBean getItemData() {
		return itemData;
	}

	public void setItemData(StoreToStoreSubBean itemData) {
		this.itemData = itemData;
	}

	public StoreToStore getHeaderData() {
		return headerData;
	}

	public void setHeaderData(StoreToStore headerData) {
		this.headerData = headerData;
	}

	public List<StoreToStoreSubBean> getSubData() {
		return subData;
	}

	public void setSubData(List<StoreToStoreSubBean> subData) {
		this.subData = subData;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<StoreToStore> getDestLocationList() {
		return destLocationList;
	}

	public void setDestLocationList(List<StoreToStore> destLocationList) {
		this.destLocationList = destLocationList;
	}

	/**
	 * @return the qcItemList
	 */
	public List<StoreToStore> getQcItemList() {
		return qcItemList;
	}

	/**
	 * @param qcItemList the qcItemList to set
	 */
	public void setQcItemList(List<StoreToStore> qcItemList) {
		this.qcItemList = qcItemList;
	}

}
