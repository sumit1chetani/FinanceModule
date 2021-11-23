package com.dci.master.userAdminMaster;

import java.util.List;

public class UserAdminMasterAddressBean {

	private String presentAddress;
	private String presentPlace;
	private String presentDistrict;
	private String presentPin;
	private String presentPhone;
	private String presentMobile;
	private String isActiveOldAddress = "N";
	private String empId;
	private String permAddress;
	private String permPlace;
	private String permDistrict;
	private String permPin;
	private String permPhone;
	private String permMobile;
	private String permState;
	private String isActiveAddress = "N";

	private List<UserAdminMasterPhoneNoDetailBean> presentAddressMultiple;

	public String getPermState() {
		return permState;
	}

	public void setPermState(String permState) {
		this.permState = permState;
	}

	public String getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}

	public String getPermPlace() {
		return permPlace;
	}

	public void setPermPlace(String permPlace) {
		this.permPlace = permPlace;
	}

	public String getPermDistrict() {
		return permDistrict;
	}

	public void setPermDistrict(String permDistrict) {
		this.permDistrict = permDistrict;
	}

	public String getPermPin() {
		return permPin;
	}

	public void setPermPin(String permPin) {
		this.permPin = permPin;
	}

	public String getPermPhone() {
		return permPhone;
	}

	public void setPermPhone(String permPhone) {
		this.permPhone = permPhone;
	}

	public String getPermMobile() {
		return permMobile;
	}

	public void setPermMobile(String permMobile) {
		this.permMobile = permMobile;
	}

	public String getIsActiveAddress() {
		return isActiveAddress;
	}

	public void setIsActiveAddress(String isActiveAddress) {
		this.isActiveAddress = isActiveAddress;
	}

	public List<UserAdminMasterPhoneNoDetailBean> getPresentAddressMultiple() {
		return presentAddressMultiple;
	}

	public void setPresentAddressMultiple(List<UserAdminMasterPhoneNoDetailBean> presentAddressMultiple) {
		this.presentAddressMultiple = presentAddressMultiple;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	public String getPresentPhone() {
		return presentPhone;
	}

	public void setPresentPhone(String presentPhone) {
		this.presentPhone = presentPhone;
	}

	public String getPresentMobile() {
		return presentMobile;
	}

	public void setPresentMobile(String presentMobile) {
		this.presentMobile = presentMobile;
	}

	public String getIsActiveOldAddress() {
		return isActiveOldAddress;
	}

	public void setIsActiveOldAddress(String isActiveOldAddress) {
		this.isActiveOldAddress = isActiveOldAddress;
	}
}
