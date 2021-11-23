package com.dci.tenant.finance.report.tripPandL;


public interface TripPandLService {

	TripPandLResultBean getTruckList();
	
	TripPandLResultBean getList(TripPandLBean bean);
	
	TripPandLBean exportDailyVehivleReportExcel(String exportFilesPath, TripPandLBean dailyVehicleReport);


}
