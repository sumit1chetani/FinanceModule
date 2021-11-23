package com.dci.tenant.finance.reports.csr.customerRateAvailability;

import java.util.List;
import java.util.Map;

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
@RequestMapping(value = "{tenantid}/app/customerRateAvailability")
public class CustomerRateAvailabilityController {
	private final static Logger LOGGER = LoggerFactory.getLogger(CustomerRateAvailabilityController.class);

	@Autowired
	CustomerRateAvailabilityService customerRateAvailabilityService;
	
	@RequestMapping(value = "/getCustomerRateAvailReportData", method = RequestMethod.POST)
	public @ResponseBody CustomerRateAvailabilityResultBean getCustomerRateAvailReportData(@RequestBody CustomerRateAvailabilityBean objCRABean) {
		CustomerRateAvailabilityResultBean objResultBean = new CustomerRateAvailabilityResultBean();
		try {
			try {
				List<Map<String, Object>> lCRAList = customerRateAvailabilityService.getCustomerRateAvailReportData(objCRABean);
				objResultBean.setlCustomerRateAvailabilityList(lCRAList);
				objResultBean.setSuccess(true);
			} catch (Exception e) {
				objResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objResultBean;
	}
	
	@RequestMapping(value = "/exportCRAExcel", method = RequestMethod.POST)
	public @ResponseBody CustomerRateAvailabilityResultBean exportCRAExcel(@RequestBody CustomerRateAvailabilityBean objCRABean, HttpServletRequest request,
			HttpServletResponse response) {
		CustomerRateAvailabilityResultBean resultBean = new CustomerRateAvailabilityResultBean();
		boolean isSuccess = false;
		try {			
			CustomerRateAvailabilityBean craBeanObj = new CustomerRateAvailabilityBean();
			//isSuccess = customerRateAvailabilityService.exportCRAExcel(ConfigurationProps.exportFilesPath, objCRABean);
			customerRateAvailabilityService.exportCRAExcel(customerRateAvailabilityService.getCustomerRateAvailReportData(objCRABean),
					craBeanObj, ConfigurationProps.exportFilesPath);
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}
	
}
