package com.dci.tenant.finance.report.tripPandL;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class TripPandLResultBean extends BasicResultBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private List<SelectivityBean> truckList;
	
	private List<TripPandLBean> List;
	
	private List<TripPandLBean> List1;
	
	private TripPandLBean tripBean;
	
	public List<TripPandLBean> getList1() {
		return List1;
	}

	public void setList1(List<TripPandLBean> list1) {
		List1 = list1;
	}

	public TripPandLBean getTripBean() {
		return tripBean;
	}

	public void setTripBean(TripPandLBean tripBean) {
		this.tripBean = tripBean;
	}

	public List<TripPandLBean> getList() {
		return List;
	}

	public void setList(List<TripPandLBean> list) {
		List = list;
	}

	public List<SelectivityBean> getTruckList() {
		return truckList;
	}

	public void setTruckList(List<SelectivityBean> truckList) {
		this.truckList = truckList;
	}


}
