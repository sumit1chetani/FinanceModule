package com.dci.tenant.finance.reports.csr;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "{tenantid}/app/csrreports")
public class CsrReportsController {
	private final static Logger LOGGER = LoggerFactory.getLogger(CsrReportsController.class);
	@Autowired
	private CsrReportsService csrReportsService;

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/ssfvol")
	public List getSsfVolList() throws Exception {
		try {
			List ssfVolList = csrReportsService.getSsfVol();
			return ssfVolList;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

	}

	@RequestMapping(value = "/ssfmoves")
	public List getSsfMoves() throws Exception {
		try {
			List ssfMovesList = csrReportsService.getSsfMoves();
			return ssfMovesList;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

	}

	@RequestMapping(value = "/toptennvomlo")
	public @ResponseBody List getTopTenNvoMlo(@RequestParam(value = "year") int year) throws Exception {
		try {
			List topTenNvoMloList = csrReportsService.getTopTenNvoMloList(year);
			return topTenNvoMloList;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
	}
	@RequestMapping(value = "/catABCShare")
	public List getCatABCShare() throws Exception {
		try {
			List avgList = csrReportsService.getCatABCShare();
			return avgList;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

	}
	@RequestMapping(value = "/volumes")
	public List getVolumes() throws Exception {
		try {
			List avgList = csrReportsService.getVolumes();
			return avgList;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

	}
	
	@RequestMapping(value = "/ialVol")
	public List getIalVol() throws Exception {
		try {
			List ialVolList = csrReportsService.getIalVol(null);
			return ialVolList;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

	}

	@RequestMapping(value = "/topFifteenCust")
	public List getTopFifteenCust(@RequestParam(value = "year") int year) throws Exception {
		try {
			List topFifteenCust = csrReportsService.getTopFifteenCust(year);
			return topFifteenCust;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
	}

	@RequestMapping(value = "/transasiaVolTrend")
	public List<Object> getTransasiaVolTrend(@RequestParam(value="companyId") String companyId) throws Exception {
		List<Object> transasiaVolTrendList = new ArrayList<Object>();
		try {
			transasiaVolTrendList = csrReportsService.getTransasiaVolList(companyId);
			return transasiaVolTrendList;
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return transasiaVolTrendList;
	}

	@RequestMapping(value = "/avgWeightPerteu")
	public List getAverageWeightPerTeu() throws Exception {
		try {
			List avgList = csrReportsService.getAvgWeiPerTeu();
			return avgList;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

	}
	@RequestMapping(value = "/avgWeightPerteuexcelexp")
	public CsrReportsResultBean getAvgWeightPerteuexcelexp() throws Exception {
		CsrReportsResultBean objCsrReports =new CsrReportsResultBean();
		try {
			objCsrReports = csrReportsService.getAvgWeightPerteuexcelexp();
			return objCsrReports;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

	}

	@RequestMapping(value = "/ssfShare")
	public List getSsfShareDtl() throws Exception {
		List<Object> ssfShareList = new ArrayList<Object>();
		try {
			ssfShareList = csrReportsService.getSsfShareList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return ssfShareList;
	}
	

	@RequestMapping(value = "/thirdpartyloadings")
	public List<ThirdPartyLoading> getThirdPartyLoadings() throws Exception {
		try {
			List<ThirdPartyLoading> thirdPartyLoadingList = csrReportsService.getThirdPartyLoadings();
			return thirdPartyLoadingList;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

	}
	
	@RequestMapping(value = "/thirdpartyexcelexp")
	public CsrReportsResultBean getThirdPartyExcel() throws Exception {
		CsrReportsResultBean objCsrReports =new CsrReportsResultBean();
		try {
			objCsrReports = csrReportsService.getThirdPartyExcel();
			return objCsrReports;
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

	}
	
	@RequestMapping(value="/getCompanyList")
	public List<SelectivityBean> getCompanyList(){
		List<SelectivityBean> companyList=new ArrayList<SelectivityBean>();
		try{
			companyList=csrReportsService.getCompanyList();
		}catch(Exception e){
			LOGGER.error("Error", e);
		}
		return companyList;
	}
}
