package com.dci.tenant.finance.reports.csr.customerRateAvailability;

import java.util.List;
import java.util.Map;

public interface CustomerRateAvailabilityDAO {

	List<Map<String, Object>> getCustomerRateAvailReportData(CustomerRateAvailabilityBean objCRABean);

}
