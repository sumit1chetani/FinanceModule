package com.dci.tenant.finance.report.dailyVehicleReport;


public interface DailyVehicleReportService {

	DailyVehicleReportResultBean getTruckList();
	
	DailyVehicleReportResultBean getTruckByTrip(Integer tripId);

	DailyVehicleReportBean exportDailyVehivleReportExcel(String exportFilesPath, DailyVehicleReportBean dailyVehicleReport);


}
