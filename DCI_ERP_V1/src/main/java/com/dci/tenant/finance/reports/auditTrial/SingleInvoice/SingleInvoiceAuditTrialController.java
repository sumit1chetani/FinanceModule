package com.dci.tenant.finance.reports.auditTrial.SingleInvoice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.tenant.finance.reports.auditTrial.quotation.QuotationAuditTrialController;

@RestController
@RequestMapping(value = "{tenantid}/report/auditTrial/singleInvoice")
public class SingleInvoiceAuditTrialController {

	@Autowired
	SingleInvoiceAuditTrialService singleInvoiceAuditTrialService;

	private final static Logger LOGGER = LoggerFactory.getLogger(QuotationAuditTrialController.class);

	@RequestMapping("/employeeList")
	public SingleInvoiceAuditTrialResultBean getEmployeeList() {
		SingleInvoiceAuditTrialResultBean resultBean = new SingleInvoiceAuditTrialResultBean();
		try {
			resultBean.setCustomerList(singleInvoiceAuditTrialService.getEmployeeList());

		} catch (DataAccessException e) {
			LOGGER.error("Error in lEmployeeList", e);
		}
		return resultBean;
	}
	
	@RequestMapping("/invoiceList")
	public SingleInvoiceAuditTrialResultBean quotationList(@RequestBody SingleInvoiceAuditTrialBean bean) {
		SingleInvoiceAuditTrialResultBean resultBean = new SingleInvoiceAuditTrialResultBean();
		try {
			resultBean.setSingleInvoiceList((singleInvoiceAuditTrialService.getSingleInvoiceList(bean)));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping("/viewExcel")
	public SingleInvoiceAuditTrialResultBean viewExcel(@RequestBody SingleInvoiceAuditTrialBean bean, HttpServletRequest request) {
		SingleInvoiceAuditTrialResultBean resultBean = new SingleInvoiceAuditTrialResultBean();
		try {
			List<SingleInvoiceAuditTrialBean> singleInvoiceList = singleInvoiceAuditTrialService.getSingleInvoiceList(bean);
			String filePath = request.getServletContext().getRealPath("/assets/docs"); /*excelDocument*/
			singleInvoiceAuditTrialService.excelExport(singleInvoiceList, filePath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

}
