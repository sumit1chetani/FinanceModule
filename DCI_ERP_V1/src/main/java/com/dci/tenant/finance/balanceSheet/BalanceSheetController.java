package com.dci.tenant.finance.balanceSheet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.finance.GeneralLedger.GeneralLedgerBean;

@Controller
@RequestMapping(value = "app/balanceSheet")
public class BalanceSheetController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BalanceSheetController.class);

	@Autowired
	BalanceSheetService objBalanceSheetService;

	@RequestMapping("/getCompanyList")
	public @ResponseBody List<SelectivityBean> getCompanyList() throws CustomException {
		List<SelectivityBean> lCompanyList = new ArrayList<>();
		try {
			lCompanyList = objBalanceSheetService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCompanyList;
	}

	@RequestMapping("/generateBalanceSheetReport")
	public @ResponseBody BalanceSheetBean generateBalanceSheetReport(@RequestBody BalanceSheetBean objBalanceSheetBean) throws CustomException {
		BalanceSheetBean rbean = new BalanceSheetBean();

		List<BalanceSheetBean> lGroupHeadLevelListAsset = new ArrayList<>();
		List<BalanceSheetBean> lGroupHeadLevelListLiabilities = new ArrayList<>();
		try {
			lGroupHeadLevelListAsset = objBalanceSheetService.getBalanceSheetListAsset(objBalanceSheetBean);
			lGroupHeadLevelListLiabilities = objBalanceSheetService.getBalanceSheetListLiabilities(objBalanceSheetBean);
			double amt = 0, amt1 = 0;

			for (int i = 0; i < lGroupHeadLevelListAsset.size(); i++) {
				List<BalanceSheetBean> lSubGroupLevelList = new ArrayList<>();
				if (lGroupHeadLevelListAsset.get(i).getGroupHeadCode().equalsIgnoreCase("A")) {
					objBalanceSheetBean.setGroupHeadCode("100%");

					lSubGroupLevelList = objBalanceSheetService.generateBalanceSheetReportDtl(objBalanceSheetBean);

					for (int j = 0; j < lSubGroupLevelList.size(); j++) {
						List<BalanceSheetBean> lAccountHeadLevelList = new ArrayList<>();

						objBalanceSheetBean.setGroupHeadCode(lSubGroupLevelList.get(j).getGroupHeadCode());

						lAccountHeadLevelList = objBalanceSheetService.generateBalanceSheetReportAHDtl(objBalanceSheetBean);
						for (BalanceSheetBean bean : lAccountHeadLevelList) {
							amt = amt + bean.getBalance();
						}
						lSubGroupLevelList.get(j).setlAccountHeadLevelList(lAccountHeadLevelList);

					}

					lGroupHeadLevelListAsset.get(i).setlSubGroupLevelList(lSubGroupLevelList);
				}
			}

			for (int i = 0; i < lGroupHeadLevelListLiabilities.size(); i++) {
				List<BalanceSheetBean> lSubGroupLevelList = new ArrayList<>();
				if (lGroupHeadLevelListLiabilities.get(i).getGroupHeadCode().equalsIgnoreCase("L")) {
					objBalanceSheetBean.setGroupHeadCode("200%");

					lSubGroupLevelList = objBalanceSheetService.generateBalanceSheetReportDtl(objBalanceSheetBean);

					for (int j = 0; j < lSubGroupLevelList.size(); j++) {
						List<BalanceSheetBean> lAccountHeadLevelList = new ArrayList<>();

						objBalanceSheetBean.setGroupHeadCode(lSubGroupLevelList.get(j).getGroupHeadCode());

						lAccountHeadLevelList = objBalanceSheetService.generateBalanceSheetReportAHDtl(objBalanceSheetBean);

						for (BalanceSheetBean bean1 : lAccountHeadLevelList) {
							amt1 = amt1 + bean1.getBalance();
						}
						lSubGroupLevelList.get(j).setlAccountHeadLevelList(lAccountHeadLevelList);

					}

					lGroupHeadLevelListLiabilities.get(i).setlSubGroupLevelList(lSubGroupLevelList);
				}
			}
			BalanceSheetBean objjBalanceSheetBean = objBalanceSheetService.getBalanceSheetListAssetCurrentPeriod(objBalanceSheetBean);
			rbean.setCurrentPeriodEarning(objjBalanceSheetBean.getCurrentPeriodEarning());
			rbean.setlGroupHeadLevelList(lGroupHeadLevelListAsset);
			rbean.setlGroupHeadLevelLiabilitiesList(lGroupHeadLevelListLiabilities);
			rbean.setTotalAsset(amt);
			rbean.setTotalLiablities(amt1);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return rbean;
	}

	@RequestMapping("/generateBalanceSheetReportDtl")
	public @ResponseBody List<BalanceSheetBean> generateBalanceSheetReportDtl(@RequestBody BalanceSheetBean objBalanceSheetBean) throws CustomException {
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		try {
			lBalanceSheetList = objBalanceSheetService.generateBalanceSheetReportDtl(objBalanceSheetBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lBalanceSheetList;
	}

	@RequestMapping("/generateBalanceSheetReportAHDtl")
	public @ResponseBody List<BalanceSheetBean> generateBalanceSheetReportAHDtl(@RequestBody BalanceSheetBean objBalanceSheetBean) throws CustomException {
		List<BalanceSheetBean> lBalanceSheetList = new ArrayList<>();
		try {
			lBalanceSheetList = objBalanceSheetService.generateBalanceSheetReportAHDtl(objBalanceSheetBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lBalanceSheetList;
	}

	@RequestMapping("/excelBSExport")
	public @ResponseBody BalanceSheetBean excelBSExport(@RequestBody BalanceSheetBean objBalanceSheetBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		BalanceSheetBean objBalanceSheetBeanTemp = new BalanceSheetBean();
		boolean isSucess = false;
		try {
			String filepath = request.getServletContext().getRealPath("tmpFiles");
			if (objBalanceSheetBean.getCompany().equalsIgnoreCase("ALL")) {
				isSucess = objBalanceSheetService.excelBSExport(objBalanceSheetBean, ConfigurationProps.exportFilesPath);
			} else {
				isSucess = objBalanceSheetService.excelBSExport1(objBalanceSheetBean, ConfigurationProps.exportFilesPath);
			}
			objBalanceSheetBeanTemp.setSuccess(isSucess);
			objBalanceSheetBeanTemp.setFilePath("filePath/BalanceSheet.xls");
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objBalanceSheetBeanTemp;
	}
	

	@RequestMapping(value = "/ExportPDF", method = RequestMethod.POST)
	public @ResponseBody BalanceSheetBean ExportPDFBulk(@RequestBody BalanceSheetBean bsreport)
			throws Exception {

		bsreport = objBalanceSheetService.pdfExportNew(bsreport, ConfigurationProps.exportFilesPath);

		return bsreport;
	}
}
