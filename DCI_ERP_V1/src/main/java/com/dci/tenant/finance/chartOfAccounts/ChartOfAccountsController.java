package com.dci.tenant.finance.chartOfAccounts;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;


@Controller
@RequestMapping(value = "{tenantid}/app/chartofaccounts")
public class ChartOfAccountsController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ChartOfAccountsController.class);

	@Autowired
	private ChartOfAccountsService objChartOfAccountsService;

	@RequestMapping("/getGroupHead")
	public @ResponseBody ChartOfAccountsResultBean getGroupHeadList() throws CustomException {
		ChartOfAccountsResultBean objChartOfAccountsResultBean = new ChartOfAccountsResultBean();
		try {

			objChartOfAccountsResultBean.setlChartOfAccountsBean(objChartOfAccountsService.getGroupHeadList());
			objChartOfAccountsResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		System.out.println(new Date());
		return objChartOfAccountsResultBean;
	}

	@RequestMapping("getSubGroupHeadList")
	public @ResponseBody ChartOfAccountsResultBean getSubGroupHeadList(@RequestParam("groupHeadCode") String groupHeadCode) throws CustomException {
		ChartOfAccountsResultBean objChartOfAccountsResultBean = new ChartOfAccountsResultBean();
		try {

			objChartOfAccountsResultBean.setlChartOfAccountsBean(objChartOfAccountsService.getSubGroupHeadList(groupHeadCode));
			objChartOfAccountsResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objChartOfAccountsResultBean;
	}

	@RequestMapping("getAccountHeadList")
	public @ResponseBody ChartOfAccountsResultBean getAccountHeadList(@RequestParam("subGroupAcctCode") String subGroupAcctCode)
			throws CustomException {
		ChartOfAccountsResultBean objChartOfAccountsResultBean = new ChartOfAccountsResultBean();
		try {

			objChartOfAccountsResultBean.setlChartOfAccountsBean(objChartOfAccountsService.getAccountHeadList(subGroupAcctCode));
			objChartOfAccountsResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objChartOfAccountsResultBean;
	}

	@RequestMapping("exportExcel")
	public @ResponseBody boolean exportExcel(HttpServletRequest request, HttpServletResponse response) throws CustomException {

		boolean isSuccess = false;
		try {
			isSuccess = objChartOfAccountsService.exportExcel(ConfigurationProps.exportFilesPath);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

}
