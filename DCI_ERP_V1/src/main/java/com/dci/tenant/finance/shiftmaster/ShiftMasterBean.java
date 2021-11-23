package com.dci.tenant.finance.shiftmaster;

public class ShiftMasterBean {

	private int shiftId;
	private String shiftName;
	private String shiftCode;
	private String description;
	private String effectFromDate;
	private String startTime;
	private String endTime;
	private String breakStartTime;
	private String breakEndTime;
	private String thresholdTime;
	private String nightShift = "N";
	private String lateAfter;
	private String earlyExit;
	private String noOfTimeAllowed;
	private String halfDay;
	private String fullDay;

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

	public String getShiftCode() {
		return shiftCode;
	}

	public void setShiftCode(String shiftCode) {
		this.shiftCode = shiftCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEffectFromDate() {
		return effectFromDate;
	}

	public void setEffectFromDate(String effectFromDate) {
		this.effectFromDate = effectFromDate;
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

	public String getBreakStartTime() {
		return breakStartTime;
	}

	public void setBreakStartTime(String breakStartTime) {
		this.breakStartTime = breakStartTime;
	}

	public String getBreakEndTime() {
		return breakEndTime;
	}

	public void setBreakEndTime(String breakEndTime) {
		this.breakEndTime = breakEndTime;
	}

	public String getLateAfter() {
		return lateAfter;
	}

	public void setLateAfter(String lateAfter) {
		this.lateAfter = lateAfter;
	}

	public String getEarlyExit() {
		return earlyExit;
	}

	public void setEarlyExit(String earlyExit) {
		this.earlyExit = earlyExit;
	}

	public String getNoOfTimeAllowed() {
		return noOfTimeAllowed;
	}

	public void setNoOfTimeAllowed(String noOfTimeAllowed) {
		this.noOfTimeAllowed = noOfTimeAllowed;
	}

	public String getHalfDay() {
		return halfDay;
	}

	public void setHalfDay(String halfDay) {
		this.halfDay = halfDay;
	}

	public String getFullDay() {
		return fullDay;
	}

	public void setFullDay(String fullDay) {
		this.fullDay = fullDay;
	}

	public String getThresholdTime() {
		return thresholdTime;
	}

	public void setThresholdTime(String thresholdTime) {
		this.thresholdTime = thresholdTime;
	}

	public String getNightShift() {
		return nightShift;
	}

	public void setNightShift(String nightShift) {
		this.nightShift = nightShift;
	}

}
