package com.dci.tenant.finance.reports.financials.corg;

import java.util.List;

public interface CorgService {

	List<CorgBean> viewCorgReport(CorgBean objCorgBean);

	boolean exportCorgReport(String exportFilesPath, CorgBean objCorgBean);

	List<CorgBean> viewCorgReportAsOnDate(CorgBean objCorgBean);

	boolean exportCorgReportAsOnDate(String exportFilesPath, CorgBean objCorgBean);

	String getweekenddate(CorgBean objCorgBean);

}
