package com.dci.tenant.finance.permissionReq;

public class PermissionRequestBean {
	private String id;

	private String permissiondate;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String hoursfrom;
	private String hoursto;
	private String permissionrequestid;
	private boolean success;
	private String employeeno;
	private String status;
	private String requestdate;
	private String requestby;
	private String employeename;
	private String userId;
	private String empName;
	private String shiftName;
	private String shiftDate;
	private String startTime;
	private String endTime;
	private String userName;
	private String empId;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getShiftDate() {
		return shiftDate;
	}

	public void setShiftDate(String shiftDate) {
		this.shiftDate = shiftDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getRequestby() {
		return requestby;
	}

	public void setRequestby(String requestby) {
		this.requestby = requestby;
	}

	public String getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}

	public String getEmployeeno() {
		return employeeno;
	}

	public void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private String reason;
	private boolean isEdit;
	private String requesteddate;

	public String getPermissionrequestid() {
		return permissionrequestid;
	}

	public void setPermissionrequestid(String permissionrequestid) {
		this.permissionrequestid = permissionrequestid;
	}

	public String getRequesteddate() {
		return requesteddate;
	}

	public void setRequesteddate(String requesteddate) {
		this.requesteddate = requesteddate;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getPermissiondate() {
		return permissiondate;
	}

	public void setPermissiondate(String permissiondate) {
		this.permissiondate = permissiondate;
	}

	public String getHoursfrom() {
		return hoursfrom;
	}

	public void setHoursfrom(String hoursfrom) {
		this.hoursfrom = hoursfrom;
	}

	public String getHoursto() {
		return hoursto;
	}

	public void setHoursto(String hoursto) {
		this.hoursto = hoursto;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
