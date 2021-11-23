package com.dci.tenant.finance.reports.charterhirestatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "{tenantid}/app/charterhirestatement")
public class CharterHireStatementController {
	private final static Logger LOGGER = LoggerFactory.getLogger(CharterHireStatementController.class);

	@Autowired
	CharterHireStatementService charterHireStatementService;

	@RequestMapping("/getCharterHireReport")
	public @ResponseBody CharterHireStatementResultBean getCharterHireStmtReportData(@RequestBody CharterHireStatementBean objCharterHireStatementBean)
			throws CustomException {
		CharterHireStatementResultBean charterHireBean = new CharterHireStatementResultBean();
		try {
			charterHireBean.setlCharterHireStatementBean(charterHireStatementService.getCharterHireStmtReportData(objCharterHireStatementBean));
			charterHireBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return charterHireBean;
	}

	@RequestMapping(value = "/print")
	public ModelAndView printCharterHireStatement(@RequestBody CharterHireStatementBean objCharterHireStatementBean) throws Exception {
		ModelAndView obj = null;
		try {
			obj = new ModelAndView("finance/reports/printCharterHireStmtReport");

			obj.addObject("charterReportList", objCharterHireStatementBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return obj;
	}

	@RequestMapping("/printsoa")
	public ModelAndView printCharterHireSoa(@RequestBody CharterHireStatementBean objCharterHireStatementBean) throws Exception {
		ModelAndView obj = null;
		try {
			obj = new ModelAndView("finance/reports/printCharterHireSOA");

			obj.addObject("charterReportList", objCharterHireStatementBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return obj;
	}
}
