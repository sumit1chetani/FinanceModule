package com.dci.master.employeeAdminMaster;

public class EmployeeMasterPhysicalBean {
	private String isActiveSight = "N";
	private String isActiveDumb = "N";
	private String isActiveHearing = "N";
	private String isActiveHand = "N";
	private String isActiveFeet = "N";
	private String isActiveWithGlass = "N";
	private double rightSidePower;
	private double leftSidePower;
	private double height;
	private double weight;
	private String otherDisablity;
	private String empId;

	public String getOtherDisablity() {
		return otherDisablity;
	}

	public void setOtherDisablity(String otherDisablity) {
		this.otherDisablity = otherDisablity;
	}

	public String getIsActiveSight() {
		return isActiveSight;
	}

	public void setIsActiveSight(String isActiveSight) {
		this.isActiveSight = isActiveSight;
	}

	public String getIsActiveDumb() {
		return isActiveDumb;
	}

	public void setIsActiveDumb(String isActiveDumb) {
		this.isActiveDumb = isActiveDumb;
	}

	public String getIsActiveHearing() {
		return isActiveHearing;
	}

	public void setIsActiveHearing(String isActiveHearing) {
		this.isActiveHearing = isActiveHearing;
	}

	public String getIsActiveHand() {
		return isActiveHand;
	}

	public void setIsActiveHand(String isActiveHand) {
		this.isActiveHand = isActiveHand;
	}

	public String getIsActiveFeet() {
		return isActiveFeet;
	}

	public void setIsActiveFeet(String isActiveFeet) {
		this.isActiveFeet = isActiveFeet;
	}

	public String getIsActiveWithGlass() {
		return isActiveWithGlass;
	}

	public void setIsActiveWithGlass(String isActiveWithGlass) {
		this.isActiveWithGlass = isActiveWithGlass;
	}

	/*********** End of Physical *******/

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public double getLeftSidePower() {
		return leftSidePower;
	}

	public void setLeftSidePower(double leftSidePower) {
		this.leftSidePower = leftSidePower;
	}

	public double getRightSidePower() {
		return rightSidePower;
	}

	public void setRightSidePower(double rightSidePower) {
		this.rightSidePower = rightSidePower;
	}

}
