package com.dci.tenant.finance.reports.sailings;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class SailingsReportResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<SailingsReportBean> sailingsReportList;

	public List<SailingsReportBean> getSailingsReportList() {
		return sailingsReportList;
	}

	public void setSailingsReportList(List<SailingsReportBean> sailingsReportList) {
		this.sailingsReportList = sailingsReportList;
	}

}
