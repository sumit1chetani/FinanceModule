package com.dci.tenant.finance.report.dailyVehicleReport;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class DailyVehicleReportResultBean extends BasicResultBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private List<SelectivityBean> truckList;
	
	private List<SelectivityBean> tripList;

	private List<SelectivityBean> truckByTrip;
	

	public List<SelectivityBean> getTruckList() {
		return truckList;
	}

	public void setTruckList(List<SelectivityBean> truckList) {
		this.truckList = truckList;
	}

	public List<SelectivityBean> getTripList() {
		return tripList;
	}

	public void setTripList(List<SelectivityBean> tripList) {
		this.tripList = tripList;
	}

	public List<SelectivityBean> getTruckByTrip() {
		return truckByTrip;
	}

	public void setTruckByTrip(List<SelectivityBean> truckByTrip) {
		this.truckByTrip = truckByTrip;
	}
	
	
	

}
