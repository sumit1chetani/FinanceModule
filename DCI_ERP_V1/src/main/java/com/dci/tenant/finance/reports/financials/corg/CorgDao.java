package com.dci.tenant.finance.reports.financials.corg;

import java.util.List;

public interface CorgDao {

	List<CorgBean> viewCorgReport(CorgBean objCorgBean);

	List<CorgBean> viewCorgReportAsOnDate(CorgBean objCorgBean);

	String getweekenddate(CorgBean objCorgBean);


}
