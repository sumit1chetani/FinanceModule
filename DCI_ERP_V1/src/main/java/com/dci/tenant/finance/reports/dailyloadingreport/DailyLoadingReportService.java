package com.dci.tenant.finance.reports.dailyloadingreport;


public interface DailyLoadingReportService {


	DailyLoadingReportBean exportDailyLoadinReportExcel(String exportFilesPath, DailyLoadingReportBean dailyloadingReportBean);

	DailyLoadingReportResultBean getDropDown();
	
	DailyLoadingReportResultBean getViewReport(DailyLoadingReportBean dailyloadingReportBean);

	String getDeptCode();




}
