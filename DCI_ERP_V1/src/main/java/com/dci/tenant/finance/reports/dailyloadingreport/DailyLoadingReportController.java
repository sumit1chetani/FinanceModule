package com.dci.tenant.finance.reports.dailyloadingreport;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.common.util.XmlDomParser;

@RestController
@RequestMapping(value="{tenantid}/app/dailyloadingreport")
public class DailyLoadingReportController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DailyLoadingReportController.class);
	
	@Autowired
	ServletContext context;
	
	@Autowired
	private DailyLoadingReportService dailyloadingreportService;
	

	@RequestMapping("/dropDown")
	public @ResponseBody DailyLoadingReportResultBean getDropDown() throws CustomException {
		
		DailyLoadingReportResultBean dailyLoadingReportResultBean = new DailyLoadingReportResultBean();
		try {

			dailyLoadingReportResultBean = dailyloadingreportService.getDropDown();
		} catch (Exception e) {
			throw new CustomException();
		}
		return dailyLoadingReportResultBean;
	}

	
	@RequestMapping(value = "/excelExport", method = RequestMethod.POST)
	public @ResponseBody DailyLoadingReportBean exportDailyLoadinReportExcel(@RequestBody DailyLoadingReportBean dailyloadingReportBean, HttpServletRequest request,
			
			HttpServletResponse response) {

		DailyLoadingReportBean  dailyLoadingBean = new DailyLoadingReportBean();
		
		try {
			dailyLoadingBean = dailyloadingreportService.exportDailyLoadinReportExcel(ConfigurationProps.exportFilesPath, dailyloadingReportBean);
			dailyLoadingBean.setSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dailyLoadingBean;
	}
	
	
	
	@RequestMapping("/viewReport")
	public @ResponseBody DailyLoadingReportResultBean getViewReport(@RequestBody DailyLoadingReportBean dailyloadingReportBean) throws CustomException {
		
		DailyLoadingReportResultBean dailyLoadingReportResultBean = new DailyLoadingReportResultBean();
		try {

			dailyLoadingReportResultBean = dailyloadingreportService.getViewReport(dailyloadingReportBean);
		} catch (Exception e) {
			throw new CustomException();
		}
		return dailyLoadingReportResultBean;
	}

	
	
	@RequestMapping("/getReprtHeader")
	public @ResponseBody DailyLoadingReportResultBean getReprtHeader() throws CustomException {
		DailyLoadingReportResultBean dailyLoadingReportResultBean = new DailyLoadingReportResultBean();
		try {
			
			String deptCode = dailyloadingreportService.getDeptCode();

			//Condition for Operation Dept
			if(deptCode.equalsIgnoreCase("DP011"))
			{
				
				dailyLoadingReportResultBean.setHeaderList((XmlDomParser.getReportHeader(context, "DailyLoadingReportHeaderForOperationDept.xml")));
				dailyLoadingReportResultBean.setSuccess(true);
			}
			else{
				
				dailyLoadingReportResultBean.setHeaderList((XmlDomParser.getReportHeader(context, "DailyLoadingReportHeader.xml")));
				dailyLoadingReportResultBean.setSuccess(true);
			}


		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return dailyLoadingReportResultBean;
	}
	

	

	
}
