package com.dci.tenant.finance.reports.financials.corg;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CorgResultBean extends BasicResultBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CorgBean> lCorgList;
	private String weekEndDate;

	public List<CorgBean> getlCorgList() {
		return lCorgList;
	}

	public void setlCorgList(List<CorgBean> lCorgList) {
		this.lCorgList = lCorgList;
	}

	public String getWeekEndDate() {
		return weekEndDate;
	}

	public void setWeekEndDate(String weekEndDate) {
		this.weekEndDate = weekEndDate;
	}
	
	
}
