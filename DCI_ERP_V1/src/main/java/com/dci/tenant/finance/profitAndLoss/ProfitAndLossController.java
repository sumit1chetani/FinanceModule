package com.dci.tenant.finance.profitAndLoss;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "app/profitloss")
public class ProfitAndLossController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProfitAndLossController.class);

	@Autowired
	ProfitAndLossService objProfitAndLossService;

	@RequestMapping("/generatePLReport")
	public @ResponseBody List<ProfitAndLossBean> generatePLReport(@RequestBody ProfitAndLossBean objProfitAndLossBean) throws CustomException {
		List<ProfitAndLossBean> lBalanceSheetList = new ArrayList<ProfitAndLossBean>();
		try {
			lBalanceSheetList = objProfitAndLossService.generatePLReport1(objProfitAndLossBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lBalanceSheetList;
	}

	@RequestMapping("/generatePLReportDtl")
	public @ResponseBody List<ProfitAndLossBean> generatePLReportDtl(@RequestBody ProfitAndLossBean objProfitAndLossBean) throws CustomException {
		List<ProfitAndLossBean> lBalanceSheetList = new ArrayList<ProfitAndLossBean>();
		try {
			lBalanceSheetList = objProfitAndLossService.generatePLReportDtl1(objProfitAndLossBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lBalanceSheetList;
	}

	@RequestMapping("/generatePLReportAHDtl")
	public @ResponseBody List<ProfitAndLossBean> generatePLReportAHDtl(@RequestBody ProfitAndLossBean objProfitAndLossBean) throws CustomException {
		List<ProfitAndLossBean> lProfitAndListAHList = new ArrayList<ProfitAndLossBean>();
		try {
			lProfitAndListAHList = objProfitAndLossService.generatePLReportAHDtl(objProfitAndLossBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lProfitAndListAHList;
	}

	@RequestMapping("/exportPLExcel")
	public @ResponseBody ProfitAndLossBean exportPLExcel(@RequestBody ProfitAndLossBean objProfitAndLossBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		ProfitAndLossBean objProfitAndLossTempBean = new ProfitAndLossBean();
		boolean isSucess = false;
		try {
			String filepath = request.getServletContext().getRealPath("tmpFiles");
			if (objProfitAndLossBean.getCompany().equalsIgnoreCase("ALL")) {
				isSucess = objProfitAndLossService.exportPLExcel(objProfitAndLossBean, filepath);
			} else {
				isSucess = objProfitAndLossService.exportPLExcel1(objProfitAndLossBean, filepath);

			}
			objProfitAndLossTempBean.setSuccess(isSucess);
			objProfitAndLossTempBean.setFilePath("tmpFiles/Income and Expenditure.xls");
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objProfitAndLossTempBean;
	}

	@RequestMapping("/getProfitLossTransactions")
	public @ResponseBody ProfitAndLossBean getProfitLossTransactions(@RequestParam("accountHeadCode") String accountHeadCode, @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		ProfitAndLossBean profiltlossbean = new ProfitAndLossBean();
		profiltlossbean = objProfitAndLossService.getProfitLossTransactions(accountHeadCode, fromDate, toDate);
		return profiltlossbean;

	}
}
