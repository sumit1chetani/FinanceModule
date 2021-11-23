package com.dci.tenant.auditlog;

public class SesLogBean {
	private String sesLogId;
	private String employeeId;
	private String employeeName;
	private String action;
	private String ipAddress;
	private String createdOn;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSesLogId() {
		return sesLogId;
	}

	public void setSesLogId(String sesLogId) {
		this.sesLogId = sesLogId;
	}

}
