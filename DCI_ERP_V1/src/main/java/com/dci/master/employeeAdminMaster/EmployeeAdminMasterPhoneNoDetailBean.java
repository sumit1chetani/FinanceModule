package com.dci.master.employeeAdminMaster;

import java.util.List;

//
public class EmployeeAdminMasterPhoneNoDetailBean {
	private List<EmployeeAdminMasterPhoneNoDetailBean> presentMobile;
	private List<EmployeeAdminMasterPhoneNoDetailBean> presentPhone;
	private String presentPhoneNo;
	private String presentMobileNo;
	private boolean select;
	private int slNo;
	private String presentAddress;
	private String presentPlace;
	private String presentDistrict;
	private String presentPin;
	private String presentState;
	private String isActiveOldAddress = "N";
	private int present_address_id;

	public int getPresent_address_id() {
		return present_address_id;
	}

	public void setPresent_address_id(int present_address_id) {
		this.present_address_id = present_address_id;
	}

	public String getPresentState() {
		return presentState;
	}

	public void setPresentState(String presentState) {
		this.presentState = presentState;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPresentPlace() {
		return presentPlace;
	}

	public void setPresentPlace(String presentPlace) {
		this.presentPlace = presentPlace;
	}

	public String getPresentDistrict() {
		return presentDistrict;
	}

	public void setPresentDistrict(String presentDistrict) {
		this.presentDistrict = presentDistrict;
	}

	public String getPresentPin() {
		return presentPin;
	}

	public void setPresentPin(String presentPin) {
		this.presentPin = presentPin;
	}

	public String getIsActiveOldAddress() {
		return isActiveOldAddress;
	}

	public void setIsActiveOldAddress(String isActiveOldAddress) {
		this.isActiveOldAddress = isActiveOldAddress;
	}

	public List<EmployeeAdminMasterPhoneNoDetailBean> getPresentMobile() {
		return presentMobile;
	}

	public void setPresentMobile(List<EmployeeAdminMasterPhoneNoDetailBean> presentMobile) {
		this.presentMobile = presentMobile;
	}

	public List<EmployeeAdminMasterPhoneNoDetailBean> getPresentPhone() {
		return presentPhone;
	}

	public void setPresentPhone(List<EmployeeAdminMasterPhoneNoDetailBean> presentPhone) {
		this.presentPhone = presentPhone;
	}

	public String getPresentPhoneNo() {
		return presentPhoneNo;
	}

	public void setPresentPhoneNo(String presentPhoneNo) {
		this.presentPhoneNo = presentPhoneNo;
	}

	public String getPresentMobileNo() {
		return presentMobileNo;
	}

	public void setPresentMobileNo(String presentMobileNo) {
		this.presentMobileNo = presentMobileNo;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

}
