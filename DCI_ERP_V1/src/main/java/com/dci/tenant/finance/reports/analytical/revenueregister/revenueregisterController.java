package com.dci.tenant.finance.reports.analytical.revenueregister;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
import com.dci.common.util.XmlDomParser;

@Controller
@RequestMapping(value = "{tenantid}/app/revenuereport")
public class revenueregisterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(revenueregisterController.class);

	@Autowired
	private revenueregisterService revenueRegisterservice;

	@Autowired
	ServletContext context;

	@RequestMapping("/getReport")
	public @ResponseBody revenueregisterResultBean getOpernBudgetHdrList(@RequestBody revenueregister objrevenueregister) throws CustomException {
		revenueregisterResultBean objrevenueregisterResultBean = new revenueregisterResultBean();
		try {

			objrevenueregisterResultBean.setLrevenueregisterlist((revenueRegisterservice.getRevenueReport(objrevenueregister)));
			objrevenueregisterResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objrevenueregisterResultBean;
	}

	@RequestMapping("/getReprtHeader")
	public @ResponseBody revenueregisterResultBean getReprtHeader() throws CustomException {
		revenueregisterResultBean objrevenueregisterResultBean = new revenueregisterResultBean();
		try {

		objrevenueregisterResultBean.setGetRevenueHeaderList((XmlDomParser.getReportHeader(context, "RevenueRegister.xml")));
			objrevenueregisterResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objrevenueregisterResultBean;
	}

	// excel
	@RequestMapping(value = "/generateExcel", method = RequestMethod.POST)
	public @ResponseBody revenueregisterResultBean exportExcel(@RequestBody revenueregisterResultBean objWholeData, HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
		revenueregisterResultBean objrevenueregisterResultBean = new revenueregisterResultBean();
		try {
			if(objWholeData.getLrevenueregisterlist().size() <1){
				objWholeData.setLrevenueregisterlist((revenueRegisterservice.getRevenueReport(objWholeData.getRevenueregisterBean())));
			}
			revenueRegisterservice.excellexport(objWholeData, ConfigurationProps.exportFilesPath, null);
			objrevenueregisterResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objrevenueregisterResultBean;
	}

	
	// Fetching vessel drop down
	@RequestMapping("/getpayer")
	public @ResponseBody List getpayer() throws CustomException {
		List getpayer = new ArrayList();
		try {
			getpayer = revenueRegisterservice.getpayer();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return getpayer;
	}
	
	
	@RequestMapping("/getCustomer")
	public @ResponseBody List getCustomer() throws CustomException {
		List getpayer = new ArrayList();
		try {
			getpayer = revenueRegisterservice.getCustomer();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return getpayer;
	}
	
	
	// Fetching portisocode drop down
	@RequestMapping("/getportisocode")
	public @ResponseBody List getPortISOCode() throws CustomException {
		List portlist = new ArrayList();
		try {
			portlist = revenueRegisterservice.getportIsoCode();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return portlist;
	}
	/*
	 * objsummarybean.setPolPodSummaryHeaderList(XmlDomParser.getReportHeader(
	 * context, "bookingSummary.xml"));
	 */
}