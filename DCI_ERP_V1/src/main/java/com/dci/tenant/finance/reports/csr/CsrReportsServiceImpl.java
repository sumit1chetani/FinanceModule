package com.dci.tenant.finance.reports.csr;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;

import jxl.write.WriteException;

@Service
public class CsrReportsServiceImpl implements CsrReportsService {
	@Autowired
	CsrReportsDAO csrReportsDAO;

	@SuppressWarnings("rawtypes")
	@Override
	public List getSsfVol() {
		List list = csrReportsDAO.getSsfVol();
		return list;
	}

	@Override
	public List<SsfVolReportBean> getSsfMoves() {
		List list = csrReportsDAO.getSsfMoves();
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getTopTenNvoMloList(int year) {
		List topTenList = csrReportsDAO.getTopTenNvoMloList(year);
		return topTenList;
	}

	@Override
	public List getIalVol(String companyId) {
		List list = csrReportsDAO.getIalVol(companyId);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getTopFifteenCust(int year) {
		List topFifteenCustList = csrReportsDAO.getTopFifteenCust(year);
		return topFifteenCustList;
	}

	@Override
	public List<Object> getTransasiaVolList(String companyId) {
		List<Object> transasiaVolTrendList = csrReportsDAO.getTransasiaVolList(companyId);
		return transasiaVolTrendList;
	}

	@Override
	public List<AverageWeightPerTeu> getAvgWeiPerTeu() {
		List<AverageWeightPerTeu> avgWeightPerTeuList = csrReportsDAO.getAvgWeiPerTeu();
		return avgWeightPerTeuList;
	}

	@Override
	public List<Object> getSsfShareList() {
		List<Object> ssfShareList = csrReportsDAO.getSsfShareList();
		return ssfShareList;
	}

	@Override
	public List getThirdPartyLoadings() {
		List thirdPartyLoadingList = csrReportsDAO.getThirdPartyLoadings();
		return thirdPartyLoadingList;
	}

	@Override
	public List getCatABCShare() {
		// TODO Auto-generated method stub
		return csrReportsDAO.getCatABCShare();
	}

	@Override
	public List getVolumes() {
		// TODO Auto-generated method stub
		return csrReportsDAO.getVolumes();
	}

	@Override
	public CsrReportsResultBean getThirdPartyExcel() {
		// TODO Auto-generated method stub
		return csrReportsDAO.getThirdPartyExcel();
	}

	@Override
	public CsrReportsResultBean getAvgWeightPerteuexcelexp() throws IOException, WriteException {
		// TODO Auto-generated method stub
		return csrReportsDAO.getAvgWeightPerteuexcelexp();
	}

	@Override
	public List<SelectivityBean> getCompanyList() {
		// TODO Auto-generated method stub
		return csrReportsDAO.getCompanyList();
	}
}
