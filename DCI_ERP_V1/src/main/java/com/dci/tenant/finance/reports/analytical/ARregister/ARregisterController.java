package com.dci.tenant.finance.reports.analytical.ARregister;

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
@RequestMapping(value = "{tenantid}/app/ARreport")
public class ARregisterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ARregisterController.class);

	@Autowired
	private ARregisterService ARservice;

	@Autowired
	ServletContext context;

	@RequestMapping("/getARReport")
	public @ResponseBody ARregisterResultBean getARReportList(@RequestBody ARregister objARregister) throws CustomException {
		ARregisterResultBean objARregisterResultBean = new ARregisterResultBean();
		try {

			objARregisterResultBean.setlARregisterlists((ARservice.getARReport(objARregister)));
			objARregisterResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objARregisterResultBean;
	}

	@RequestMapping("/getReprtHeader")
	public @ResponseBody ARregisterResultBean getReprtHeader() throws CustomException {
		ARregisterResultBean objrevenueregisterResultBean = new ARregisterResultBean();
		try {

		objrevenueregisterResultBean.setGetheaderList((XmlDomParser.getReportHeader(context, "ARregister.xml")));
			objrevenueregisterResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objrevenueregisterResultBean;
	}

	// excel
	@RequestMapping(value = "/generateExcel", method = RequestMethod.POST)
	public @ResponseBody ARregisterResultBean exportExcel(@RequestBody ARregisterResultBean objWholeData, HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
		ARregisterResultBean objrevenueregisterResultBean = new ARregisterResultBean();
		try {

			ARservice.excellexport(objWholeData, ConfigurationProps.exportFilesPath, null);
			objrevenueregisterResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objrevenueregisterResultBean;
	}
}