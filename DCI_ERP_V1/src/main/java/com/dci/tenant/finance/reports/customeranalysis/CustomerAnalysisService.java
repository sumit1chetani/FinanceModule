package com.dci.tenant.finance.reports.customeranalysis;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

public interface CustomerAnalysisService {
	List<SelectivityBean> getCompanyList();

	CustomerAnalysisBean getWeek(String week,String year) throws CustomException;

	List<CustomerAnalysisBean> getCustomerAnalysisReport(CustomerAnalysisBean customerAnalysisBean);
	
	List<CustomerAnalysisBean> getMLO();
	
	public void rateAgainstExcel(CustomerAnalysisBean customerAnalysisBean,String path);
	
	public void rateJvAgainstExcel(CustomerAnalysisBean customerAnalysisBean,String path);
}
