package com.dci.hrms.hr.leave.leaveSummary;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class LeaveSummaryResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<LeaveSummaryBean> summaryDetails;

	public List<LeaveSummaryBean> getSummaryDetails() {
		return summaryDetails;
	}

	public void setSummaryDetails(List<LeaveSummaryBean> summaryDetails) {
		this.summaryDetails = summaryDetails;
	}

}
