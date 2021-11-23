package com.dci.tenant.finance.profitandlossnew;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.common.util.XmlDomParser;
import com.dci.tenant.finance.trialBalance.TrialBalanceBean;

@Controller
@RequestMapping(value = "app/profitlossnew")
public class ProfitandLossControllerNew {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProfitandLossControllerNew.class);

	@Autowired
	ServletContext context;

	@Autowired
	ProfitAndLossServiceNew objProfitAndLossService;

	@RequestMapping("/getCompanyList")
	public @ResponseBody List<SelectivityBean> getCompanyList() throws CustomException {
		List<SelectivityBean> lCompanyList = new ArrayList<>();
		try {
			lCompanyList = objProfitAndLossService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCompanyList;
	}

	@RequestMapping("/generatePLReport")
	public @ResponseBody List<ProfitAndLossBean> generatePLReport(@RequestBody ProfitAndLossBean objProfitAndLossBean) throws CustomException {
		List<ProfitAndLossBean> lBalanceSheetList = new ArrayList<>();
		try {
			lBalanceSheetList = objProfitAndLossService.generatePLReport(objProfitAndLossBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lBalanceSheetList;
	}

	@RequestMapping("/generatePLReportNewVer")
	public @ResponseBody ProfitLossResultBeanNew generatePLReportNew(@RequestBody ProfitAndLossBean objProfitAndLossBean) throws CustomException {
		ProfitLossResultBeanNew objProfitLossResultBean = new ProfitLossResultBeanNew();
		try {
			objProfitLossResultBean = objProfitAndLossService.generatePLReportNew(objProfitAndLossBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objProfitLossResultBean;
	}

	@RequestMapping("/generatePLReportNewHor")
	public @ResponseBody ProfitLossResultBeanNew generatePLReportNewHor(@RequestBody ProfitAndLossBean objProfitAndLossBean) throws CustomException {
		ProfitLossResultBeanNew objProfitLossResultBean = new ProfitLossResultBeanNew();
		try {
			objProfitLossResultBean = objProfitAndLossService.generatePLReportNewHor(objProfitAndLossBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objProfitLossResultBean;
	}

	@RequestMapping("/generatePLReportDtl")
	public @ResponseBody List<ProfitAndLossBean> generatePLReportDtl(@RequestBody ProfitAndLossBean objProfitAndLossBean) throws CustomException {
		List<ProfitAndLossBean> lBalanceSheetList = new ArrayList<>();
		try {
			lBalanceSheetList = objProfitAndLossService.generatePLReportDtl(objProfitAndLossBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lBalanceSheetList;
	}

	@RequestMapping("/generatePLReportAHDtl")
	public @ResponseBody List<ProfitAndLossBean> generatePLReportAHDtl(@RequestBody ProfitAndLossBean objProfitAndLossBean) throws CustomException {
		List<ProfitAndLossBean> lBalanceSheetList = new ArrayList<>();
		try {
			lBalanceSheetList = objProfitAndLossService.generatePLReportAHDtl(objProfitAndLossBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lBalanceSheetList;
	}

	@RequestMapping("/exportPLExcel")
	public @ResponseBody ProfitAndLossBean exportPLExcel(@RequestBody ProfitAndLossBean objProfitAndLossBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		ProfitAndLossBean objBalanceSheetBeanTemp = new ProfitAndLossBean();

		boolean isSuccess = false;
		try {

			String filepath = request.getServletContext().getRealPath("tmpFiles");

			isSuccess = objProfitAndLossService.exportPLExcel(ConfigurationProps.exportFilesPath, objProfitAndLossBean);
			// }
			objBalanceSheetBeanTemp.setSuccess(isSuccess);
			objBalanceSheetBeanTemp.setFilePath("tmpFiles/Income and Expenditure.xls");
			// isSuccess =
			// objProfitAndLossService.exportPLExcel(ConfigurationProps.exportFilesPath,
			// objProfitAndLossBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objBalanceSheetBeanTemp;
	}

	@RequestMapping("/exportPLExcelHor")
	public @ResponseBody boolean exportPLExcelHor(@RequestBody ProfitAndLossBean objProfitAndLossBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = objProfitAndLossService.exportPLExcelHor(ConfigurationProps.exportFilesPath, objProfitAndLossBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	/*
	 * @RequestMapping(value = "/printstaffLedgerReport") public @ResponseBody
	 * ModelAndView printstaffLedgerReport(@RequestBody StaffLedgerBean
	 * objStaffLedgerBean) { ModelAndView obj = null; obj = new
	 * ModelAndView("reports/finance/print/printStaffLedger"); List<StaffLedgerBean>
	 * lStaffLedgerList = new ArrayList<StaffLedgerBean>(); StaffLedgerResultBean
	 * objStaffLedgerResultBean = new StaffLedgerResultBean(); try {
	 * 
	 * objStaffLedgerResultBean =
	 * objStaffLedgerService.getStaffLedgerReportPrint(objStaffLedgerBean);
	 * 
	 * obj.addObject("staffLedgerList",
	 * objStaffLedgerResultBean.getObjStaffLedger());
	 * 
	 * } catch (Exception e) { objStaffLedgerResultBean.setSuccess(false);
	 * LOGGER.error("Error", e); }
	 * 
	 * return obj; }
	 */
	@RequestMapping("/print")
	public @ResponseBody ModelAndView printPandL(@RequestBody ProfitAndLossBean objProfitAndLossBean) throws CustomException {
		ModelAndView obj = null;
		obj = new ModelAndView("reports/finance/print/printPL");
		ProfitLossResultBeanNew objProfitLossResultBean = new ProfitLossResultBeanNew();
		try {
			objProfitLossResultBean = objProfitAndLossService.generatePLReportNew(objProfitAndLossBean);
			obj.addObject("adminExpenses", objProfitLossResultBean.getlAdminExpense());
			obj.addObject("otherExpenses", objProfitLossResultBean.getlOtherExpense());
			obj.addObject("salesRevenue", objProfitLossResultBean.getlSalesRevenue());
			obj.addObject("otherIncome", objProfitLossResultBean.getlOtherIncome());
			obj.addObject("plList", objProfitLossResultBean);

			System.out.println(objProfitLossResultBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return obj;
	}

	@RequestMapping("/getReprtHeader")
	public @ResponseBody ProfitLossResultBeanNew getReprtHeader() throws CustomException {
		ProfitLossResultBeanNew objrevenueregisterResultBean = new ProfitLossResultBeanNew();
		try {

			objrevenueregisterResultBean.setGetJobOrderReportHeaderList((XmlDomParser.getReportHeader(context, "ProfitandLossJobOrder.xml")));
			objrevenueregisterResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objrevenueregisterResultBean;
	}

	/*
	 * @RequestMapping("/getReport") public @ResponseBody ProfitLossResultBeanNew
	 * getReportList(@RequestBody ProfitandLossJobOrderReport
	 * profitandLossJobOrderReport) throws CustomException { ProfitLossResultBeanNew
	 * profitLossResultBean = new ProfitLossResultBeanNew(); try {
	 * 
	 * profitLossResultBean.setLjobOrderReportlist((objProfitAndLossService.
	 * geJobOrderReport(profitandLossJobOrderReport)));
	 * profitLossResultBean.setSuccess(true);
	 * 
	 * } catch (Exception e) { LOGGER.error("Error", e); } return
	 * profitLossResultBean; }
	 */

	@RequestMapping("/getCompanyDetails")
	public @ResponseBody ProfitLossResultBeanNew getCompanyDetailsById(@RequestBody String companyCode) throws CustomException {
		ProfitLossResultBeanNew profitLossResultBean = new ProfitLossResultBeanNew();
		try {

			ProfitAndLossBean res = objProfitAndLossService.getCompanyDetails(companyCode);
			if (res != null) {
				profitLossResultBean.setCompanyDetails(res);
			}
			profitLossResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return profitLossResultBean;
	}

	/*
	 * @RequestMapping("/exportExcel") public @ResponseBody ProfitLossResultBeanNew
	 * exportAsExcel(@RequestBody JobOrderReportResultBean objWholeData,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * CustomException { ProfitLossResultBeanNew profitLossResultBean = new
	 * ProfitLossResultBeanNew(); try { profitLossResultBean =
	 * objProfitAndLossService.exportAsExcel(ConfigurationProps.exportFilesPath,
	 * objWholeData); profitLossResultBean.setSuccess(true);
	 * 
	 * } catch (Exception e) { LOGGER.error("Error", e); } return
	 * profitLossResultBean; }
	 */

	
	@RequestMapping(value = "/ExportPDF", method = RequestMethod.POST)
	public @ResponseBody ProfitAndLossBean ExportPDFBulk(@RequestBody ProfitAndLossBean profitreport)
			throws Exception {

		profitreport = objProfitAndLossService.pdfExportNew(profitreport, ConfigurationProps.exportFilesPath);

		return profitreport;
	}
	
}
