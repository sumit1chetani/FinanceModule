package com.dci.tenant.finance.reports.csr;

import java.io.IOException;
import java.util.List;

import com.dci.common.model.SelectivityBean;

import jxl.write.WriteException;

public interface CsrReportsService {

	public List getSsfVol();

	public List<SsfVolReportBean> getSsfMoves();

	public List getTopTenNvoMloList(int year);

	public List getIalVol(String companyId);

	public List getTopFifteenCust(int year);

	public List<Object> getTransasiaVolList(String companyId);

	public List<AverageWeightPerTeu> getAvgWeiPerTeu();

	public List<Object> getSsfShareList();
	
	public List getThirdPartyLoadings();

	public List getCatABCShare();

	public List getVolumes();

	public CsrReportsResultBean getThirdPartyExcel();

	public CsrReportsResultBean getAvgWeightPerteuexcelexp() throws IOException, WriteException;
	
	public List<SelectivityBean> getCompanyList();
}
