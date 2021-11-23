package com.dci.tenant.finance.reports.corgBySector;

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
@RequestMapping("{tenantid}/app/CorgBySector")
public class CorgBySectorController {
	private final static Logger LOGGER = LoggerFactory.getLogger(CorgBySectorController.class);
	@Autowired
	private CorgBySectorService CorgBySectorService;

	@RequestMapping("/list")
	public @ResponseBody CorgBySectorResultBean getContainerList(@RequestBody CorgBySector objrevenueregister ) throws Exception {
		CorgBySectorResultBean objCorgBySectorResultBean = new CorgBySectorResultBean();
		try {
			objCorgBySectorResultBean = CorgBySectorService.getCorgBySectorList(objrevenueregister);
			objCorgBySectorResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objCorgBySectorResultBean;
	}

	@RequestMapping("/corgList")
	public @ResponseBody CorgBySectorResultBean getcorgList(@RequestBody CorgBySector objrevenueregister ) throws Exception {
		CorgBySectorResultBean objCorgBySectorResultBean = new CorgBySectorResultBean();
		try {
			objCorgBySectorResultBean = CorgBySectorService.getcorgList(objrevenueregister);
			objCorgBySectorResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objCorgBySectorResultBean;
	}
	
	// excel
	@RequestMapping(value = "/generateExcel", method = RequestMethod.POST)
	public @ResponseBody CorgBySectorResultBean exportExcel(@RequestBody CorgBySector objrevenueregister, HttpServletRequest request,
			HttpServletResponse response) throws CustomException,Exception {
		CorgBySectorResultBean reportBuilderResultBean = new CorgBySectorResultBean();
		try {
			CorgBySectorService.excellexport(objrevenueregister, ConfigurationProps.exportFilesPath, null);
			reportBuilderResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportBuilderResultBean;
	}


}