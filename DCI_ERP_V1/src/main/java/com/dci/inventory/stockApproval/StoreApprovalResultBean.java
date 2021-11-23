package com.dci.inventory.stockApproval;

import java.util.List;

public class StoreApprovalResultBean {
	private StoreApproval headerData = new StoreApproval();// Save Main
															// Header
	private List<StoreApprovalSubBean> subData; // Save Sub Item Data

	private List<StoreApproval> employeeList;
	private List<StoreApproval> statusList;
	private List<StoreApproval> locationList;
	private List<StoreApprovalSubBean> itemList;
	private StoreApprovalSubBean itemData = new StoreApprovalSubBean();

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<StoreApproval> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<StoreApproval> employeeList) {
		this.employeeList = employeeList;
	}

	public List<StoreApproval> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<StoreApproval> locationList) {
		this.locationList = locationList;
	}

	public List<StoreApprovalSubBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<StoreApprovalSubBean> itemList) {
		this.itemList = itemList;
	}

	public StoreApprovalSubBean getItemData() {
		return itemData;
	}

	public void setItemData(StoreApprovalSubBean itemData) {
		this.itemData = itemData;
	}

	public StoreApproval getHeaderData() {
		return headerData;
	}

	public void setHeaderData(StoreApproval headerData) {
		this.headerData = headerData;
	}

	public List<StoreApprovalSubBean> getSubData() {
		return subData;
	}

	public void setSubData(List<StoreApprovalSubBean> subData) {
		this.subData = subData;
	}

	public List<StoreApproval> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<StoreApproval> statusList) {
		this.statusList = statusList;
	}

}
