package com.dci.tenant.finance.reports.sailings;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

public interface SailingsReportDAO {
	List<SelectivityBean> getCompanyList();

	List<SailingsReportBean> getSailingsReport(SailingsReportBean sailingsReportBean);

	List<SailingsReportBean> getVoyageCompletionList(SailingsReportBean sailingsReportBean);

	SailingsReportBean getWeek(String week,String year) throws CustomException;
}
