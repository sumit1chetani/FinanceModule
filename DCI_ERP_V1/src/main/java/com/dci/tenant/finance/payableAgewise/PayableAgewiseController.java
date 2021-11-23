package com.dci.tenant.finance.payableAgewise;

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
@RequestMapping(value = "app/payableAgewise")
public class PayableAgewiseController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PayableAgewiseController.class);

	@Autowired
	private PayableAgewiseService objPayableAgewiseService;

	@RequestMapping(value = "/getPayableAgewiseReport", method = RequestMethod.POST)
	public @ResponseBody PayableAgewiseResultBean getPayableAgewiseReport(@RequestBody String sDate) {
		List<PayableAgewiseBean> lPayableAgewiseList = new ArrayList<PayableAgewiseBean>();
		PayableAgewiseResultBean objPayableAgewiseResultBean = new PayableAgewiseResultBean();
		try {
			try {
				lPayableAgewiseList = objPayableAgewiseService.getPayableAgewiseReport(sDate);
				objPayableAgewiseResultBean.setlPayableAgewiseList(lPayableAgewiseList);
				objPayableAgewiseResultBean.setSuccess(true);
			} catch (Exception e) {
				objPayableAgewiseResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objPayableAgewiseResultBean;
	}

	@RequestMapping(value = "/getPayableAgewiseReportDtl", method = RequestMethod.POST)
	public @ResponseBody PayableAgewiseResultBean getPayableAgewiseReportDtl(@RequestBody PayableAgewiseBean objPayableAgewiseBean) {
		List<PayableAgewiseBean> lPayableAgewiseDtlList = new ArrayList<PayableAgewiseBean>();
		PayableAgewiseResultBean objPayableAgewiseResultBean = new PayableAgewiseResultBean();
		try {
			try {
				lPayableAgewiseDtlList = objPayableAgewiseService.getPayableAgewiseReportDtl(objPayableAgewiseBean);
				objPayableAgewiseResultBean.setlPayableAgewiseList(lPayableAgewiseDtlList);
				objPayableAgewiseResultBean.setSuccess(true);
			} catch (Exception e) {
				objPayableAgewiseResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objPayableAgewiseResultBean;
	}

	@RequestMapping(value = "/exportPayableAgewiseExcel", method = RequestMethod.POST)
	public @ResponseBody PayableAgewiseBean exportPayableAgewiseExcel(@RequestBody String sDate, HttpServletRequest request, HttpServletResponse response) {

		PayableAgewiseBean objPayableAgewiseBean = new PayableAgewiseBean();
		boolean isSuccess = false;
		try {
			String filepath = request.getServletContext().getRealPath("tmpFiles");
			isSuccess = objPayableAgewiseService.exportPayableAgewiseExcel(ConfigurationProps.exportFilesPath, sDate);
			//objPayableAgewiseBean.setSuccess(isSuccess);
			 isSuccess = true;

			//objPayableAgewiseBean.setFilePath("tmpFiles/AccountPayable.xls");

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objPayableAgewiseBean;
	}

}
