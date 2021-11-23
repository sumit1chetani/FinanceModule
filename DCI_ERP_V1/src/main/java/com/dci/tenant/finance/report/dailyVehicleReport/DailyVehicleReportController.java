package com.dci.tenant.finance.report.dailyVehicleReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

@Controller

@RequestMapping(value = "{tenantid}/app/dailyVehicle")
public class DailyVehicleReportController {
	
	@Autowired
	private DailyVehicleReportService DailyVehicleReportService;
	
	@RequestMapping("/dropDown")
	public @ResponseBody DailyVehicleReportResultBean getTruckList() throws CustomException {
		
		DailyVehicleReportResultBean DailyVehicleReportResultBean = new DailyVehicleReportResultBean();
		try {
			DailyVehicleReportResultBean = DailyVehicleReportService.getTruckList();
		} catch (Exception e) {
			throw new CustomException();
		}
		return DailyVehicleReportResultBean;
	}
	
	
	@RequestMapping("/truckByTrip")
	public @ResponseBody DailyVehicleReportResultBean getTruckByTrip(@RequestBody Integer tripId) throws CustomException {
		
		DailyVehicleReportResultBean DailyVehicleReportResultBean = new DailyVehicleReportResultBean();
		try {
			DailyVehicleReportResultBean = DailyVehicleReportService.getTruckByTrip(tripId);
		} catch (Exception e) {
			throw new CustomException();
		}
		return DailyVehicleReportResultBean;
	}

	
	
	@RequestMapping(value = "/excelExport", method = RequestMethod.POST)
	public @ResponseBody DailyVehicleReportBean exportDailyLoadinReportExcel(@RequestBody DailyVehicleReportBean dailyVehicleReport, HttpServletRequest request,
			
			HttpServletResponse response) {

		DailyVehicleReportBean  dailyVehicleReporttBean = new DailyVehicleReportBean();
		
		try {
			dailyVehicleReporttBean = DailyVehicleReportService.exportDailyVehivleReportExcel(ConfigurationProps.exportFilesPath, dailyVehicleReport);
			dailyVehicleReporttBean.setSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dailyVehicleReporttBean;
	}

	
	
	
}
