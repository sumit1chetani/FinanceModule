package com.dci.tenant.finance.reports.customeranalysis;



import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CustomerAnalysisResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<CustomerAnalysisBean> customerAnalysisReportList;

	public List<CustomerAnalysisBean> getCustomerAnalysisReportList() {
		return customerAnalysisReportList;
	}

	public void setCustomerAnalysisReportList(List<CustomerAnalysisBean> customerAnalysisReportList) {
		this.customerAnalysisReportList = customerAnalysisReportList;
	}

	
}
