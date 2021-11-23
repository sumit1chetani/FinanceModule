package com.dci.finance.storeToPurchase;

import java.util.List;

public class StoreToPurchaseResultBean {
	private StoreToPurchase headerData = new StoreToPurchase();// Save Main
																// Header
	private List<StoreToPurchaseSubBean> subData; // Save Sub Item Data

	private List<StoreToPurchase> employeeList;
	private List<StoreToPurchase> locationList;
	private List<StoreToPurchaseSubBean> itemList;
	private StoreToPurchaseSubBean itemData = new StoreToPurchaseSubBean();

	private List<StoreToPurchase> destLocationList;

	public List<StoreToPurchase> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<StoreToPurchase> employeeList) {
		this.employeeList = employeeList;
	}

	public List<StoreToPurchase> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<StoreToPurchase> locationList) {
		this.locationList = locationList;
	}

	public List<StoreToPurchaseSubBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<StoreToPurchaseSubBean> itemList) {
		this.itemList = itemList;
	}

	public StoreToPurchaseSubBean getItemData() {
		return itemData;
	}

	public void setItemData(StoreToPurchaseSubBean itemData) {
		this.itemData = itemData;
	}

	public StoreToPurchase getHeaderData() {
		return headerData;
	}

	public void setHeaderData(StoreToPurchase headerData) {
		this.headerData = headerData;
	}

	public List<StoreToPurchaseSubBean> getSubData() {
		return subData;
	}

	public void setSubData(List<StoreToPurchaseSubBean> subData) {
		this.subData = subData;
	}

	public List<StoreToPurchase> getDestLocationList() {
		return destLocationList;
	}

	public void setDestLocationList(List<StoreToPurchase> destLocationList) {
		this.destLocationList = destLocationList;
	}

}
