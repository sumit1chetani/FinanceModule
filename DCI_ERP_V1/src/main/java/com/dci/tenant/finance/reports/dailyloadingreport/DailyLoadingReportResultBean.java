package com.dci.tenant.finance.reports.dailyloadingreport;


import java.util.List;

import com.dci.common.model.ReportHeaderBean;
import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class DailyLoadingReportResultBean extends BasicResultBean {
	
	
	private List<SelectivityBean> monthList;
	
	private List<SelectivityBean> yearList;
	
	private List<DailyLoadingReportBean> dailyLoadingReportList;
	
	private List<ReportHeaderBean> headerList;
	
	public List<DailyLoadingReportBean> getDailyLoadingReportList() {
		return dailyLoadingReportList;
	}
	public void setDailyLoadingReportList(
			List<DailyLoadingReportBean> dailyLoadingReportList) {
		this.dailyLoadingReportList = dailyLoadingReportList;
	}
	public List<SelectivityBean> getMonthList() {
		return monthList;
	}
	public void setMonthList(List<SelectivityBean> monthList) {
		this.monthList = monthList;
	}
	public List<SelectivityBean> getYearList() {
		return yearList;
	}
	public void setYearList(List<SelectivityBean> yearList) {
		this.yearList = yearList;
	}
	public List<ReportHeaderBean> getHeaderList() {
		return headerList;
	}
	public void setHeaderList(List<ReportHeaderBean> headerList) {
		this.headerList = headerList;
	}
	



	
	
}
