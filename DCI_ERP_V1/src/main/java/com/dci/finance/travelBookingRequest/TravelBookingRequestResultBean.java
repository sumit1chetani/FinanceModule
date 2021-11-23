package com.dci.finance.travelBookingRequest;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class TravelBookingRequestResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<TravelBookingRequest> travelBookingList;

	private List<TravelBookingRequest> requestForList;

	private TravelBookingRequest travelBookingRequest = new TravelBookingRequest();

	public List<TravelBookingRequest> getTravelBookingList() {
		return travelBookingList;
	}

	public void setTravelBookingList(List<TravelBookingRequest> travelBookingList) {
		this.travelBookingList = travelBookingList;
	}

	public List<TravelBookingRequest> getRequestForList() {
		return requestForList;
	}

	public void setRequestForList(List<TravelBookingRequest> requestForList) {
		this.requestForList = requestForList;
	}

	public TravelBookingRequest getTravelBookingRequest() {
		return travelBookingRequest;
	}

	public void setTravelBookingRequest(TravelBookingRequest travelBookingRequest) {
		this.travelBookingRequest = travelBookingRequest;
	}

}
