package com.dci.truck.truckdrivermapping;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.SelectivityBean;


public class TruckDriverMappingResultBean {

	private List<TruckDriverMappingBean> List = new ArrayList<TruckDriverMappingBean>();
	private TruckDriverMappingBean TruckDriverMapping = new TruckDriverMappingBean();

	public TruckDriverMappingBean getTruckDriverMapping() {
		return TruckDriverMapping;
	}

	public void setTruckDriverMapping(TruckDriverMappingBean TruckDriverMapping) {
		this.TruckDriverMapping = TruckDriverMapping;
	}

	public List<TruckDriverMappingBean> getList() {
		return List;
	}

	public void setList(List<TruckDriverMappingBean> List) {
		this.List = List;
	}
	private List<SelectivityBean> currencyList;
	private List<SelectivityBean> containerList;
	private List<SelectivityBean> locationList;
	public List<SelectivityBean> getTruckList() {
		return truckList;
	}

	public void setTruckList(List<SelectivityBean> truckList) {
		this.truckList = truckList;
	}
	private List<SelectivityBean> truckList;
	private List<SelectivityBean> driverList;

	public List<SelectivityBean> getDriverList() {
		return driverList;
	}

	public void setDriverList(List<SelectivityBean> driverList) {
		this.driverList = driverList;
	}
	List<SelectivityBean> resultList;

	public List<SelectivityBean> getResultList() {
		return resultList;
	}

	public void setResultList(List<SelectivityBean> resultList) {
		this.resultList = resultList;
	}

	public List<SelectivityBean> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<SelectivityBean> locationList) {
		this.locationList = locationList;
	}

	public List<SelectivityBean> getPortList() {
		return portList;
	}

	public List<SelectivityBean> getContainerList() {
		return containerList;
	}

	public void setContainerList(List<SelectivityBean> containerList) {
		this.containerList = containerList;
	}

	public void setPortList(List<SelectivityBean> portList) {
		this.portList = portList;
	}
	private List<SelectivityBean> portList;


	public List<SelectivityBean> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<SelectivityBean> currencyList) {
		this.currencyList = currencyList;
	}
}

	