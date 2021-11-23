package com.dci.tenant.finance.reports.csr.customerRateAvailability;

import java.util.List;
import java.util.Map;

import com.dci.common.util.BasicResultBean;

public class CustomerRateAvailabilityResultBean extends BasicResultBean {
	private List<Map<String, Object>> lCustomerRateAvailabilityList;

	public List<Map<String, Object>> getlCustomerRateAvailabilityList() {
		return lCustomerRateAvailabilityList;
	}

	public void setlCustomerRateAvailabilityList(List<Map<String, Object>> lCustomerRateAvailabilityList) {
		this.lCustomerRateAvailabilityList = lCustomerRateAvailabilityList;
	}

	
	
	
}
