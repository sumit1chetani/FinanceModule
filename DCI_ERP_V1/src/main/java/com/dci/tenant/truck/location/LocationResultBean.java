package com.dci.tenant.truck.location;


import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.SelectivityBean;
public class LocationResultBean {
	
	
	private List<LocationBean> List = new ArrayList<LocationBean>();
	
	
	private List<SelectivityBean> countryList;

	private List portList;

	
	public List<SelectivityBean> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<SelectivityBean> countryList) {
		this.countryList = countryList;
	}

	private LocationBean vehicle = new LocationBean();

	public LocationBean getvehicle() {
		return vehicle;
	}

	public void setvehicle(LocationBean vehicle) {
		this.vehicle = vehicle;
	}

	public List<LocationBean> getList() {
		return List;
	}

	public void setList(List<LocationBean> List) {
		this.List = List;
	}
	
	private List<SelectivityBean> manuList;

	public List<SelectivityBean> getManuList() {
		return manuList;
	}

	public void setManuList(List<SelectivityBean> manuList) {
		this.manuList = manuList;
	}

	public List getPortList() {
		return portList;
	}

	public void setPortList(List portList) {
		this.portList = portList;
	}


	
}

