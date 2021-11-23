package com.dci.tenant.finance.reports.dailyloadingreport;

import java.util.List;



public interface DailyLoadingReportDAO {


	List<DailyLoadingReportBean> exportDailyLoadinReport(DailyLoadingReportBean dailyloadingReportBean);

	DailyLoadingReportResultBean getDropDown();
	
	DailyLoadingReportResultBean getViewReport(DailyLoadingReportBean dailyloadingReportBean);

	String getDeptCode();

	
	
	




}
