package com.dci.tenant.finance.report.dailyVehicleReport;

import java.util.List;


public interface DailyVehicleReportDAO {

	DailyVehicleReportResultBean getTruckList();
	
	DailyVehicleReportResultBean getTruckByTrip(Integer tripId);
	
	List<DailyVehicleReportBean> exportDailyVehicleReport(DailyVehicleReportBean dailyVehicleReport,String truck);
	
	DailyVehicleReportBean getTruckName(DailyVehicleReportBean dailyVehicleReport,String truck);
	
	DailyVehicleReportBean getIdleHour(String timeStart,String timeEnd);


	
	


}
