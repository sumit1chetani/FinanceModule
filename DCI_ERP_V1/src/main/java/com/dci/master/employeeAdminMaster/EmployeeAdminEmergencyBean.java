package com.dci.master.employeeAdminMaster;

import java.util.List;

public class EmployeeAdminEmergencyBean {
	private String empId;
	private Integer emergencyId;
	private String emergencyName;
	private String emergRelationship;
	private String emergEmail;
	private List<EmployeeAdminEmergencyBean> phoneNoMultiple;
	private List<EmployeeAdminEmergencyBean> mobileNoMultiple;
	private String emergPlace;
	private String emergencyOccu;
	private String emerAddress;
	private String emergencyPincode;
	private String emergPhone;
	private String emergMobile;
	private boolean select = false;
	private int emplEmerId;

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isSelect() {
		return select;
	}

	public String getEmergPhone() {
		return emergPhone;
	}

	public void setEmergPhone(String emergPhone) {
		this.emergPhone = emergPhone;
	}

	public String getEmergMobile() {
		return emergMobile;
	}

	public void setEmergMobile(String emergMobile) {
		this.emergMobile = emergMobile;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergRelationship() {
		return emergRelationship;
	}

	public void setEmergRelationship(String emergRelationship) {
		this.emergRelationship = emergRelationship;
	}

	public String getEmergEmail() {
		return emergEmail;
	}

	public void setEmergEmail(String emergEmail) {
		this.emergEmail = emergEmail;
	}

	public List<EmployeeAdminEmergencyBean> getPhoneNoMultiple() {
		return phoneNoMultiple;
	}

	public void setPhoneNoMultiple(List<EmployeeAdminEmergencyBean> phoneNoMultiple) {
		this.phoneNoMultiple = phoneNoMultiple;
	}

	public List<EmployeeAdminEmergencyBean> getMobileNoMultiple() {
		return mobileNoMultiple;
	}

	public void setMobileNoMultiple(List<EmployeeAdminEmergencyBean> mobileNoMultiple) {
		this.mobileNoMultiple = mobileNoMultiple;
	}

	public String getEmergPlace() {
		return emergPlace;
	}

	public void setEmergPlace(String emergPlace) {
		this.emergPlace = emergPlace;
	}

	public String getEmergencyOccu() {
		return emergencyOccu;
	}

	public void setEmergencyOccu(String emergencyOccu) {
		this.emergencyOccu = emergencyOccu;
	}

	public String getEmerAddress() {
		return emerAddress;
	}

	public void setEmerAddress(String emerAddress) {
		this.emerAddress = emerAddress;
	}

	public String getEmergencyPincode() {
		return emergencyPincode;
	}

	public void setEmergencyPincode(String emergencyPincode) {
		this.emergencyPincode = emergencyPincode;
	}

	public Integer getEmergencyId() {
		return emergencyId;
	}

	public void setEmergencyId(Integer emergencyId) {
		this.emergencyId = emergencyId;
	}

	public int getEmplEmerId() {
		return emplEmerId;
	}

	public void setEmplEmerId(int emplEmerId) {
		this.emplEmerId = emplEmerId;
	}

}
