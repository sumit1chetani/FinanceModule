package com.dci.tenant.finance.reports.schedule.inventry;

import java.util.List;

public class InventryBean {
	private String fromDate;
	private String toDate;
	private String truckId;
	private String fuelDate;
	private String fuelType;
	private String truck;
	private String units;
	
	public String getFuelDate() {
		return fuelDate;
	}

	public void setFuelDate(String fuelDate) {
		this.fuelDate = fuelDate;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTruck() {
		return truck;
	}

	public void setTruck(String truck) {
		this.truck = truck;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getTruckId() {
		return truckId;
	}

	public void setTruckId(String truckId) {
		this.truckId = truckId;
	}

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

	private List InventryList;

	public List getInventryList() {
		return InventryList;
	}

	public void setInventryList(List inventryList) {
		InventryList = inventryList;
	}

}
