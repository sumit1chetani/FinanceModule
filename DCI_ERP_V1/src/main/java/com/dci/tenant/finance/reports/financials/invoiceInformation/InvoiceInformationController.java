package com.dci.tenant.finance.reports.financials.invoiceInformation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "{tenantid}/app/reports/invoiceInformation")
public class InvoiceInformationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(InvoiceInformationController.class);

	@Autowired
	InvoiceInformationService InvoiceInformationService;
	
	@RequestMapping(value = "/getValues")
	public @ResponseBody InvoiceInformationResultBean getValues(@RequestParam String value, @RequestParam String type) {
		InvoiceInformationResultBean InvoiceInformationResultBean = new InvoiceInformationResultBean();
		try {
			InvoiceInformationResultBean = InvoiceInformationService.getValues(value,type);
			InvoiceInformationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return InvoiceInformationResultBean;
	}
	
	@RequestMapping(value = "/getList")
	public @ResponseBody InvoiceInformationResultBean getList(@RequestBody InvoiceInformation invoiceInformation) {
		InvoiceInformationResultBean InvoiceInformationResultBean = new InvoiceInformationResultBean();
		try {
			InvoiceInformationResultBean = InvoiceInformationService.getList(invoiceInformation);
			InvoiceInformationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return InvoiceInformationResultBean;
	}
}