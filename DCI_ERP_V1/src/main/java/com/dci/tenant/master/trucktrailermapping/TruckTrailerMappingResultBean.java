package com.dci.tenant.master.trucktrailermapping;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.SelectivityBean;
public class TruckTrailerMappingResultBean {
	private List<TruckTrailerMappingBean> ltripDate=new ArrayList<TruckTrailerMappingBean>();

	public List<TruckTrailerMappingBean> getLtripDate() {
		return ltripDate;
	}

	public void setLtripDate(List<TruckTrailerMappingBean> ltripDate) {
		this.ltripDate = ltripDate;
	}
	private List<TruckTrailerMappingBean> List = new ArrayList<TruckTrailerMappingBean>();
	private TruckTrailerMappingBean TruckTrailerMapping = new TruckTrailerMappingBean();

	public TruckTrailerMappingBean getTruckTrailerMapping() {
		return TruckTrailerMapping;
	}

	public void setTruckTrailerMapping(TruckTrailerMappingBean TruckTrailerMapping) {
		this.TruckTrailerMapping = TruckTrailerMapping;
	}

	public List<TruckTrailerMappingBean> getList() {
		return List;
	}

	public void setList(List<TruckTrailerMappingBean> List) {
		this.List = List;
	}
	private List<SelectivityBean> currencyList;
	private List<SelectivityBean> containerList;
	private List<SelectivityBean> locationList;
	private List<TruckTrailerMappingBean> dateList;

	public List<TruckTrailerMappingBean> getDateList() {
		return dateList;
	}

	public void setDateList(List<TruckTrailerMappingBean> dateList) {
		this.dateList = dateList;
	}

	public List<SelectivityBean> getTruckList() {
		return truckList;
	}

	public void setTruckList(List<SelectivityBean> truckList) {
		this.truckList = truckList;
	}
	private List<SelectivityBean> truckList;
	private List<SelectivityBean> trailerList;

	public List<SelectivityBean> getTrailerList() {
		return trailerList;
	}

	public void setTrailerList(List<SelectivityBean> trailerList) {
		this.trailerList = trailerList;
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

	