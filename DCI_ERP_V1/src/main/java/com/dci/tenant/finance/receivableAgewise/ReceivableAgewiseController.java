package com.dci.tenant.finance.receivableAgewise;

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

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "app/receivableAgewise")
public class ReceivableAgewiseController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ReceivableAgewiseController.class);

	@Autowired
	private ReceivableAgewiseService objReceivableAgewiseService;

	@RequestMapping(value = "/getReceivableAgewiseReport", method = RequestMethod.POST)
	public @ResponseBody ReceivableAgewiseResultBean getPayableAgewiseReport(@RequestBody String sDate) {
		List<ReceivableAgewiseBean> lReceivableAgewiseList = new ArrayList<ReceivableAgewiseBean>();
		ReceivableAgewiseResultBean objReceivableAgewiseResultBean = new ReceivableAgewiseResultBean();
		try {
			try {
				lReceivableAgewiseList = objReceivableAgewiseService.getReceivableAgewiseReport(sDate);
				objReceivableAgewiseResultBean.setlReceivableAgewiseList(lReceivableAgewiseList);
				objReceivableAgewiseResultBean.setSuccess(true);
			} catch (Exception e) {
				objReceivableAgewiseResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objReceivableAgewiseResultBean;
	}

	@RequestMapping(value = "/getReceivableAgewiseReportDtl", method = RequestMethod.POST)
	public @ResponseBody ReceivableAgewiseResultBean getPayableAgewiseReportDtl(@RequestBody ReceivableAgewiseBean objReceivableAgewiseBean) {
		List<ReceivableAgewiseBean> lReceivableAgewiseDtlList = new ArrayList<ReceivableAgewiseBean>();
		ReceivableAgewiseResultBean objReceivableAgewiseResultBean = new ReceivableAgewiseResultBean();
		try {
			try {
				lReceivableAgewiseDtlList = objReceivableAgewiseService.getReceivableAgewiseReportDtl(objReceivableAgewiseBean);
				objReceivableAgewiseResultBean.setlReceivableAgewiseList(lReceivableAgewiseDtlList);
				objReceivableAgewiseResultBean.setSuccess(true);
			} catch (Exception e) {
				objReceivableAgewiseResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objReceivableAgewiseResultBean;
	}

	@RequestMapping(value = "/exportReceivableAgewiseExcel", method = RequestMethod.POST)
	public @ResponseBody ReceivableAgewiseBean exportPayableAgewiseExcel(@RequestBody String sDate, HttpServletRequest request, HttpServletResponse response) {

		ReceivableAgewiseBean objReceivableAgewiseBean = new ReceivableAgewiseBean();
		boolean isSuccess = false;
		try {
			String filepath = request.getServletContext().getRealPath("tmpFiles");
			isSuccess = objReceivableAgewiseService.exportReceivableAgewiseExcel(ConfigurationProps.exportFilesPath, sDate);
			//objReceivableAgewiseBean.setSuccess(isSuccess);
			 isSuccess = true;

			//objReceivableAgewiseBean.setFilePath("tmpFiles/AccountReceivable.xls");

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objReceivableAgewiseBean;
	}

}
