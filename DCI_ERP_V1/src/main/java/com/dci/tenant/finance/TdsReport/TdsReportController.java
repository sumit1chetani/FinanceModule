package com.dci.tenant.finance.TdsReport;

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
import com.dci.common.util.CustomException;
import com.dci.finance.DayBook.DayBookBean;

@RestController
@RequestMapping(value = "app/tdsreport")
public class TdsReportController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TdsReportController.class);

	@Autowired
	private TdsReportService ObjTdsReportService;

	@RequestMapping(value = "/searchlist", method = RequestMethod.POST)
	public @ResponseBody TdsReportResultBean searchportDtl(@RequestBody TdsReportBean objBudgetReportBean) throws Exception {
		TdsReportResultBean objPendingapprovalResultBean = new TdsReportResultBean();
		objPendingapprovalResultBean.setSearchList(ObjTdsReportService.searchportDtl(objBudgetReportBean));
		objPendingapprovalResultBean.setSuccess(true);
		return objPendingapprovalResultBean;
	}

	@RequestMapping(value = "/ExportExcel", method = RequestMethod.POST)
	public @ResponseBody TdsReportResultBean getExcelReportExportList(@RequestBody TdsReportBean objPendingapprovalBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		TdsReportResultBean objPendingapprovalResultBean = new TdsReportResultBean();
		List<TdsReportBean> lQuotationBean = new ArrayList<>();
		boolean isSuccess = false;

		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			System.out.println("List Of  fee excel");
			// quotationResultBean.setlQuotationBean(ObjPendingapprovalService.getList(objPendingapprovalBean));
			objPendingapprovalResultBean.setSearchList(ObjTdsReportService.searchportDtl(objPendingapprovalBean));

			isSuccess=ObjTdsReportService.excellExport(objPendingapprovalResultBean, objPendingapprovalBean, ConfigurationProps.exportFilesPath);
			objPendingapprovalResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			System.out.println(e);

		}
		return objPendingapprovalResultBean;
	}
	
	
	@RequestMapping(value = "/ExportPDF", method = RequestMethod.POST)
	public @ResponseBody TdsReportBean ExportPDFBulk(@RequestBody TdsReportBean DetentionTariffBean)
			throws Exception {

		DetentionTariffBean = ObjTdsReportService.pdfExportNew(DetentionTariffBean, ConfigurationProps.exportFilesPath);

		return DetentionTariffBean;
	}

	
	
	
	
	
}
