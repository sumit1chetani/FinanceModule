package com.dci.tenant.finance.reports.sailings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

@Service
public class SailingsReportServiceImpl implements SailingsReportService {

	@Autowired
	private SailingsReportDAO sailingReportDAO;

	@Override
	public List<SelectivityBean> getCompanyList() {
		return sailingReportDAO.getCompanyList();
	}

	@Override
	public List<SailingsReportBean> getSailingsReport(SailingsReportBean sailingsReportBean) {
		return sailingReportDAO.getSailingsReport(sailingsReportBean);
	}

	@Override
	public List<SailingsReportBean> getVoyageCompletionList(SailingsReportBean sailingsReportBean) {
		return sailingReportDAO.getVoyageCompletionList(sailingsReportBean);
	}

	@Override
	public SailingsReportBean getWeek(String week,String year) throws CustomException {
		return sailingReportDAO.getWeek(week,year);
	}

}
