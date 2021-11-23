package com.dci.tenant.finance.report.tripPandL;

import java.util.List;


public interface TripPandLDAO {

	TripPandLResultBean getTruckList();
	
	TripPandLResultBean getList(TripPandLBean bean);
	
	List<TripPandLBean> exportDailyVehicleReport(TripPandLBean dailyVehicleReport,String truck);
	
	TripPandLBean getTruckName(TripPandLBean dailyVehicleReport,String truck);
	
	TripPandLBean getIdleHour(String timeStart,String timeEnd);


	
	


}
