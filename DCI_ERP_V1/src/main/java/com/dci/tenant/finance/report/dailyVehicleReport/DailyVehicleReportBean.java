package com.dci.tenant.finance.report.dailyVehicleReport;

import java.util.ArrayList;

public class DailyVehicleReportBean {

	
	private String filePath;
	private boolean success;
	private String fromDate;
	private String toDate;
	private String customer;
	private String location;
	private String timeStart;
	private String timeEnd;
	private String status;
	private String hour;
	private String tripNo;
	private String odometerStart;
	private String odometerEnd;
	private String distanceTravelled;
	private String distanceTravelledHour;
	private String TotalDistance;
	private String TotalTravelHours;
	private String TotalNonDrivingHour;
	private String ExactReasonDelay;
	private Integer truckId;
	private String truckName;
	private String idleHour;
	private boolean data;
	private Integer tripId;
	
	public boolean isData() {
		return data;
	}
	public void setData(boolean data) {
		this.data = data;
	}
	private ArrayList truckIdList = new ArrayList();

	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getTripNo() {
		return tripNo;
	}
	public void setTripNo(String tripNo) {
		this.tripNo = tripNo;
	}
	public String getOdometerStart() {
		return odometerStart;
	}
	public void setOdometerStart(String odometerStart) {
		this.odometerStart = odometerStart;
	}
	public String getOdometerEnd() {
		return odometerEnd;
	}
	public void setOdometerEnd(String odometerEnd) {
		this.odometerEnd = odometerEnd;
	}
	public String getDistanceTravelled() {
		return distanceTravelled;
	}
	public void setDistanceTravelled(String distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}
	public String getDistanceTravelledHour() {
		return distanceTravelledHour;
	}
	public void setDistanceTravelledHour(String distanceTravelledHour) {
		this.distanceTravelledHour = distanceTravelledHour;
	}
	public String getTotalDistance() {
		return TotalDistance;
	}
	public void setTotalDistance(String totalDistance) {
		TotalDistance = totalDistance;
	}
	public String getTotalTravelHours() {
		return TotalTravelHours;
	}
	public void setTotalTravelHours(String totalTravelHours) {
		TotalTravelHours = totalTravelHours;
	}
	public String getTotalNonDrivingHour() {
		return TotalNonDrivingHour;
	}
	public void setTotalNonDrivingHour(String totalNonDrivingHour) {
		TotalNonDrivingHour = totalNonDrivingHour;
	}
	public String getExactReasonDelay() {
		return ExactReasonDelay;
	}
	public void setExactReasonDelay(String exactReasonDelay) {
		ExactReasonDelay = exactReasonDelay;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public Integer getTruckId() {
		return truckId;
	}
	public void setTruckId(Integer truckId) {
		this.truckId = truckId;
	}
	public String getTruckName() {
		return truckName;
	}
	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
	public ArrayList getTruckIdList() {
		return truckIdList;
	}
	public void setTruckIdList(ArrayList truckIdList) {
		this.truckIdList = truckIdList;
	}
	public String getIdleHour() {
		return idleHour;
	}
	public void setIdleHour(String idleHour) {
		this.idleHour = idleHour;
	}
	public Integer getTripId() {
		return tripId;
	}
	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}
	
	

	
}
