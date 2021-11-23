package com.dci.tenant.finance.report.tripPandL;

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

@RequestMapping(value = "{tenantid}/app/tripPandL")
public class TripPandLController {
	
	@Autowired
	private TripPandLService DailyVehicleReportService;
	
	@RequestMapping("/trucklist")
	public @ResponseBody TripPandLResultBean getTruckList() throws CustomException {
		
		TripPandLResultBean DailyVehicleReportResultBean = new TripPandLResultBean();
		try {
			DailyVehicleReportResultBean = DailyVehicleReportService.getTruckList();
		} catch (Exception e) {
			throw new CustomException();
		}
		return DailyVehicleReportResultBean;
	}
	
	@RequestMapping("/list")
	public @ResponseBody TripPandLResultBean List(@RequestBody TripPandLBean bean) throws CustomException {
		
		TripPandLResultBean DailyVehicleReportResultBean = new TripPandLResultBean();
		try {
			DailyVehicleReportResultBean = DailyVehicleReportService.getList(bean);
		} catch (Exception e) {
			throw new CustomException();
		}
		return DailyVehicleReportResultBean;
	}

	
	
	@RequestMapping(value = "/excelExport", method = RequestMethod.POST)
	public @ResponseBody TripPandLBean exportDailyLoadinReportExcel(@RequestBody TripPandLBean dailyVehicleReport, HttpServletRequest request,
			
			HttpServletResponse response) {

		TripPandLBean  dailyVehicleReporttBean = new TripPandLBean();
		
		try {
			dailyVehicleReporttBean = DailyVehicleReportService.exportDailyVehivleReportExcel(ConfigurationProps.exportFilesPath, dailyVehicleReport);
			dailyVehicleReporttBean.setSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dailyVehicleReporttBean;
	}

	
	
	
}
