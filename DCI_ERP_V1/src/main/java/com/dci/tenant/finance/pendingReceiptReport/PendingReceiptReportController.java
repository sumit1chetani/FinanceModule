package com.dci.tenant.finance.pendingReceiptReport;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "app/pendingReceiptReport")
public class PendingReceiptReportController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PendingReceiptReportController.class);

	@Autowired
	private PendingReceiptReportService pendingReceiptReportService;

	@RequestMapping("/list")
	public @ResponseBody PendingReceiptReportResultBean getList() {
		PendingReceiptReportResultBean objPaymentHistoryReportBean = new PendingReceiptReportResultBean();

		try {
			objPaymentHistoryReportBean = pendingReceiptReportService.getList();

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objPaymentHistoryReportBean;
	}

	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public @ResponseBody boolean sendMail(@RequestBody List<PendingReceiptReportBean> beans) throws CustomException, InterruptedException {
		boolean isSuccess = false;
		try {
			isSuccess = pendingReceiptReportService.sendMail(beans);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

}
