package com.dci.tenant.finance.manualattendance;

import java.util.List;

public class ManualAttendance {

	private boolean dayOption = true;
	private String attendanceDate;
	private String inTime;
	private String outTime;
	private String errorMessage;
	private String hospitalName;
	private String branchName;
	private String departmentId;
	private String departmentCode;
	private int shiftId;
	private String shiftName;
	private String employeeName;
	private String employeeId;
	private boolean isEdit;
	private boolean success;
	private int attendanceId;
	private String mode;
	private String createdDate;
	private String[] selected;
	private String toDate;
	private String logInUser;
	private String modifiedDate;
	private String modifiedBy;
	private String shiftInTime;
	private String shiftOutTime;
	private String myInTime;
	private String myOutTime;
	private String id;
	private String text;
	private String checkIn;
	private String checkOut;
	private String option;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMyInTime() {
		return myInTime;
	}

	public void setMyInTime(String myInTime) {
		this.myInTime = myInTime;
	}

	public String getMyOutTime() {
		return myOutTime;
	}

	public void setMyOutTime(String myOutTime) {
		this.myOutTime = myOutTime;
	}

	public String getShiftInTime() {
		return shiftInTime;
	}

	public void setShiftInTime(String shiftInTime) {
		this.shiftInTime = shiftInTime;
	}

	public String getShiftOutTime() {
		return shiftOutTime;
	}

	public void setShiftOutTime(String shiftOutTime) {
		this.shiftOutTime = shiftOutTime;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	private List employeeListId;

	public List getEmployeeListId() {
		return employeeListId;
	}

	public void setEmployeeListId(List employeeListId) {
		this.employeeListId = employeeListId;
	}

	public String[] getSelected() {
		return selected;
	}

	public void setSelected(String[] selected) {
		this.selected = selected;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public boolean isDayOption() {
		return dayOption;
	}

	public void setDayOption(boolean dayOption) {
		this.dayOption = dayOption;
	}

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/*
	 * public String getEmployeeList() { return employeeList; }
	 * 
	 * public void setEmployeeList(String employeeList) { this.employeeList =
	 * employeeList; }
	 */

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public boolean getisEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getLogInUser() {
		return logInUser;
	}

	public void setLogInUser(String logInUser) {
		this.logInUser = logInUser;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
