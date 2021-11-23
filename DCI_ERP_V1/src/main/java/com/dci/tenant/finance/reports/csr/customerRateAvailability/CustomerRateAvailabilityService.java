package com.dci.tenant.finance.reports.csr.customerRateAvailability;

import java.util.List;
import java.util.Map;

public interface CustomerRateAvailabilityService {

	List<Map<String, Object>> getCustomerRateAvailReportData(CustomerRateAvailabilityBean objCRABean);

	void exportCRAExcel(List<Map<String, Object>> customerRateAvailReportData, CustomerRateAvailabilityBean craBeanObj, String exportFilesPath);

}
