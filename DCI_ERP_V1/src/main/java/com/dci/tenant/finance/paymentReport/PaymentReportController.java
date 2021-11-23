package com.dci.tenant.finance.paymentReport;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.ConfigurationProps;
import com.dci.finance.GeneralLedger.GeneralLedgerBean;

@RestController
@RequestMapping(value = "app/pendingPaymentRpt")
public class PaymentReportController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PaymentReportController.class);

	@Autowired
	private PaymentReportService objPaymentReportService;

	@RequestMapping("/exportPendingPaymentExcel")
	public @ResponseBody PaymentHistoryReportBean exportPendingPaymentExcel(@RequestBody PaymentHistoryReportBean objPmtBean, HttpServletRequest request, HttpServletResponse response) {
		PaymentHistoryReportBean objPaymentHistoryReportBean = new PaymentHistoryReportBean();
		boolean isSuccess = false;
		try {
			String filepath = request.getServletContext().getRealPath("tmpFiles");
			isSuccess = objPaymentReportService.exportPendingPmtExcel(ConfigurationProps.exportFilesPath, objPmtBean);
			objPaymentHistoryReportBean.setSuccess(isSuccess);
			objPaymentHistoryReportBean.setFilePath("filePath/PendingPaymentReport.xls");

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objPaymentHistoryReportBean;
	}

	@RequestMapping("/exportPaymentHistoryExcel")
	public @ResponseBody PaymentHistoryReportBean exportPaymentHistoryExcel(HttpServletRequest request, HttpServletResponse response) {
		PaymentHistoryReportBean objPaymentHistoryReportBean = new PaymentHistoryReportBean();
		boolean isSuccess = false;
		try {
			String filepath = request.getServletContext().getRealPath("tmpFiles");
			isSuccess = objPaymentReportService.exportPaymentHistoryExcel(ConfigurationProps.exportFilesPath);
			objPaymentHistoryReportBean.setSuccess(isSuccess);
			objPaymentHistoryReportBean.setFilePath("filePath/PaymentHistory.xls");

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objPaymentHistoryReportBean;
	}

	@RequestMapping("/SearchList")
	public @ResponseBody List<PaymentHistoryReportBean> SearchList(@RequestBody PaymentHistoryReportBean bean) {

		System.out.println("Get all list...");
		List<PaymentHistoryReportBean> list = new ArrayList<>();
		try {
			list = objPaymentReportService.SearchList(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@RequestMapping(value = "/getList")
	public PaymentReportResultBean getList() {
		PaymentReportResultBean ManageEnquiryResultBean = new PaymentReportResultBean();

		try {
			ManageEnquiryResultBean = objPaymentReportService.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ManageEnquiryResultBean;
	}
	
	@RequestMapping(value = "/ExportPDF", method = RequestMethod.POST)
	public @ResponseBody PaymentHistoryReportBean ExportPDFBulk(@RequestBody PaymentHistoryReportBean prreport)
			throws Exception {

		prreport = objPaymentReportService.pdfExportNew(prreport, ConfigurationProps.exportFilesPath);

		return prreport;
	}

	
	
}
