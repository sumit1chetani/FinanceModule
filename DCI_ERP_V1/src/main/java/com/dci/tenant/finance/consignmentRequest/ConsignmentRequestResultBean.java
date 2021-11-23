package com.dci.tenant.finance.consignmentRequest;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.SelectivityBean;

public class ConsignmentRequestResultBean {
	private ConsignmentRequest headerData = new ConsignmentRequest();// Save
	private List<ConsignmentRequest> headerDataList = new ArrayList<ConsignmentRequest>(); // Main
	// Header
	private List<ConsignmentRequestSubBean> subData; // Save Sub Item Data

	private List<ConsignmentRequest> employeeList;
	private List<ConsignmentRequest> locationList;

	private List<ConsignmentRequest> destLocationList;
	private List<ConsignmentRequestSubBean> itemList;
	private List<ConsignmentRequestSubBean> costList;
	private List<SelectivityBean> requestTypeList;

	public List<SelectivityBean> getRequestTypeList() {
		return requestTypeList;
	}

	public void setRequestTypeList(List<SelectivityBean> requestTypeList) {
		this.requestTypeList = requestTypeList;
	}

	public List<ConsignmentRequest> getHeaderDataList() {
		return headerDataList;
	}

	public void setHeaderDataList(List<ConsignmentRequest> headerDataList) {
		this.headerDataList = headerDataList;
	}

	public List<ConsignmentRequestSubBean> getCostList() {
		return costList;
	}

	public void setCostList(List<ConsignmentRequestSubBean> costList) {
		this.costList = costList;
	}

	private ConsignmentRequestSubBean itemData = new ConsignmentRequestSubBean();

	private String userId;
	private String message;

	private boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<ConsignmentRequest> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<ConsignmentRequest> employeeList) {
		this.employeeList = employeeList;
	}

	public List<ConsignmentRequest> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<ConsignmentRequest> locationList) {
		this.locationList = locationList;
	}

	public List<ConsignmentRequestSubBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<ConsignmentRequestSubBean> itemList) {
		this.itemList = itemList;
	}

	public ConsignmentRequestSubBean getItemData() {
		return itemData;
	}

	public void setItemData(ConsignmentRequestSubBean itemData) {
		this.itemData = itemData;
	}

	public ConsignmentRequest getHeaderData() {
		return headerData;
	}

	public void setHeaderData(ConsignmentRequest headerData) {
		this.headerData = headerData;
	}

	public List<ConsignmentRequestSubBean> getSubData() {
		return subData;
	}

	public void setSubData(List<ConsignmentRequestSubBean> subData) {
		this.subData = subData;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<ConsignmentRequest> getDestLocationList() {
		return destLocationList;
	}

	public void setDestLocationList(List<ConsignmentRequest> destLocationList) {
		this.destLocationList = destLocationList;
	}

}
