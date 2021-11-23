package com.dci.tenant.finance.reports.auditTrial.quotation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.ConfigurationProps;

@RestController
@RequestMapping(value = "{tenantid}/report/auditTrial/quotation")
public class QuotationAuditTrialController {

	@Autowired
	QuotationAuditTrialService quotationAuditTrialService;

	private final static Logger LOGGER = LoggerFactory.getLogger(QuotationAuditTrialController.class);

	@RequestMapping("/employeeList")
	public QuotationAuditTrialResultBean getEmployeeList() {
		QuotationAuditTrialResultBean quotationAuditTrialResultBean = new QuotationAuditTrialResultBean();
		try {
			quotationAuditTrialResultBean.setEmployeeList(quotationAuditTrialService.getEmployeeList());
			quotationAuditTrialResultBean.setSuccess(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in lEmployeeList", e);
		}
		return quotationAuditTrialResultBean;
	}

	@RequestMapping("/quotationList")
	public QuotationAuditTrialResultBean quotationList(@RequestBody QuotationAuditTrialBean bean) {
		QuotationAuditTrialResultBean resultBean = new QuotationAuditTrialResultBean();
		try {
			resultBean.setQuotationList(quotationAuditTrialService.getQuotationList(bean));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping("/viewExcel")
	public QuotationAuditTrialResultBean viewExcel(@RequestBody QuotationAuditTrialBean bean, HttpServletRequest request) {
		QuotationAuditTrialResultBean resultBean = new QuotationAuditTrialResultBean();
		try {
			List<QuotationAuditTrialBean> quotationList = quotationAuditTrialService.getQuotationList(bean);
			String filePath = request.getServletContext().getRealPath("/assets/docs");
			quotationAuditTrialService.excelExport(quotationList, filePath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	

	@RequestMapping("/jvTariffList")
	public QuotationAuditTrialResultBean jvTariffList(@RequestBody QuotationAuditTrialBean bean) {
		QuotationAuditTrialResultBean resultBean = new QuotationAuditTrialResultBean();
		try {
			resultBean.setQuotationList(quotationAuditTrialService.jvTariffList(bean));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping("/jVviewExcel")
	public QuotationAuditTrialResultBean jVviewExcel(@RequestBody QuotationAuditTrialBean bean, HttpServletRequest request) {
		QuotationAuditTrialResultBean resultBean = new QuotationAuditTrialResultBean();
		try {
			List<QuotationAuditTrialBean> quotationList = quotationAuditTrialService.jvTariffList(bean);
			String filePath = request.getServletContext().getRealPath("/assets/excelDocument");
			quotationAuditTrialService.JvexcelExport(quotationList, ConfigurationProps.exportFilesPath,bean.getFilename());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	
	@RequestMapping("/purQuotList")
	public QuotationAuditTrialResultBean purQuotList(@RequestBody QuotationAuditTrialBean bean) {
		QuotationAuditTrialResultBean resultBean = new QuotationAuditTrialResultBean();
		try {
			resultBean.setQuotationList(quotationAuditTrialService.purQuotList(bean));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping("/purQuotviewExcel")
	public QuotationAuditTrialResultBean purQuotviewExcel(@RequestBody QuotationAuditTrialBean bean, HttpServletRequest request) {
		QuotationAuditTrialResultBean resultBean = new QuotationAuditTrialResultBean();
		try {
			List<QuotationAuditTrialBean> quotationList = quotationAuditTrialService.purQuotList(bean);
			String filePath = request.getServletContext().getRealPath("/assets/excelDocument");
			quotationAuditTrialService.purQuotviewExcel(quotationList, ConfigurationProps.exportFilesPath,bean.getFilename());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

}
