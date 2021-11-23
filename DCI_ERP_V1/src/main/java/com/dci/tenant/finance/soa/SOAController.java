package com.dci.tenant.finance.soa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.payroll.payroll.advance.Advance;
import com.dci.payroll.payroll.advance.AdvanceResultBean;
import com.dci.tenant.finance.trialBalance.TrialBalanceBean;
import com.dci.tenant.finance.trialBalance.TrialBalanceResultBean;

@Controller
@RequestMapping(value = "app/soaReport")
public class SOAController {
	private final static Logger LOGGER = LoggerFactory.getLogger(SOAController.class);

	@Autowired
	private SOAService soaService;

	@RequestMapping(value = "/soaCustomerRprtList", method = RequestMethod.POST)
	public @ResponseBody
	SOAResultBean getSoaCustomerRprtList(@RequestBody SOABean soabean) throws CustomException, InterruptedException {
		SOAResultBean objSOAResultBean = new SOAResultBean();
		try {
			objSOAResultBean.setListCustomerSoa(soaService.getSoaCustomerRprtList(soabean));
			objSOAResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objSOAResultBean;
	}

	@RequestMapping(value ="/soaCustomerRprtSubList",method = RequestMethod.POST)
	public @ResponseBody
	SOAResultBean soaCustomerRprtSubList(@RequestBody SOABean soabean) throws CustomException, InterruptedException {
		SOAResultBean objSOAResultBean = new SOAResultBean();
		try {
			objSOAResultBean.setSubListCustomerSoa(soaService.soaCustomerRprtSubList(soabean));
			objSOAResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objSOAResultBean;
	}

	@RequestMapping(value ="/debtorBalance",method = RequestMethod.POST)
	public @ResponseBody
	double debtorBalance(@RequestBody SOABean soabean) throws CustomException, InterruptedException {
		double balance = 0;
		try {
			balance = soaService.debtorBalance(soabean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return balance;
	}

	@RequestMapping(value = "/exportExcel",method = RequestMethod.POST)
	public @ResponseBody
	SOAResultBean exportExcel(@RequestBody SOABean soabean, HttpServletRequest request, HttpServletResponse response) {
		
		SOAResultBean objSOAResultBean = new SOAResultBean();
		boolean isSuccess = false;
		try {
			String filepath = request.getServletContext().getRealPath("tmpFiles");
			isSuccess = soaService.exportExcel(ConfigurationProps.exportFilesPath,  soabean);
			objSOAResultBean.setSuccess(isSuccess);
			objSOAResultBean.setFilePath("filePath/StatementOfAccounts.xls");

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objSOAResultBean;
	}
}
