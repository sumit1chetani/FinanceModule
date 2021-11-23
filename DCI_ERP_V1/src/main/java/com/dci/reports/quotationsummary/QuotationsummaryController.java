package com.dci.reports.quotationsummary;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

	
	
	@RestController
	@RequestMapping(value = "{tenantid}/app/quotationsummary")
	public class QuotationsummaryController {
		private final static Logger LOGGER = LoggerFactory.getLogger(QuotationsummaryController.class);
		
		@Autowired
		private QuotationsummaryService quotationsummaryService;

		
		@GetMapping(value = "/customerlist")
		public List<QuotationsummaryBean> getDropDown() {
			
			List<QuotationsummaryBean> List = new ArrayList<>();
			
			List=quotationsummaryService.getDropDown();

			return List;
	}
		
		
		@RequestMapping(value = "/searchquotationDtl", method = RequestMethod.POST)
		public @ResponseBody QuotationsummaryResultBean searchInvoiceDtl(@RequestBody QuotationsummaryBean objQuotationsummaryBean) throws Exception {
			QuotationsummaryResultBean objQuotationsummaryResultBean = new QuotationsummaryResultBean();
			objQuotationsummaryResultBean.setSearchList(quotationsummaryService.searchInvoiceDtl(objQuotationsummaryBean));
			objQuotationsummaryResultBean.setSuccess(true);
			return objQuotationsummaryResultBean;
		}
		
		
		@RequestMapping(value = "/ExportExcel", method = RequestMethod.POST)
		public @ResponseBody QuotationsummaryResultBean getExcelReportExportList(
				@RequestBody QuotationsummaryBean objQuotationsummaryBean, HttpServletRequest request,
				HttpServletResponse response) throws CustomException {
			QuotationsummaryResultBean objQuotationsummaryResultBean = new QuotationsummaryResultBean();

			try {
			
				System.out.println("List Of  fee excel");
				objQuotationsummaryResultBean.setSearchList(quotationsummaryService.searchInvoiceDtl(objQuotationsummaryBean));
				quotationsummaryService.excellExport(objQuotationsummaryResultBean, objQuotationsummaryBean,
						ConfigurationProps.exportFilesPath);

				objQuotationsummaryResultBean.setSuccess(true);
			} catch (Exception e) {
				System.out.println(e);

			}
			return objQuotationsummaryResultBean;
		}
		
		

}
