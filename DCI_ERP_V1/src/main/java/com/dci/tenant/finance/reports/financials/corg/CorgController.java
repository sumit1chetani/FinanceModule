package com.dci.tenant.finance.reports.financials.corg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/app/corg")
public class CorgController {
	
	@Autowired
	CorgService objCorgService;
	
	@RequestMapping(value = "/viewCorgReport", method = RequestMethod.POST)
	public @ResponseBody CorgResultBean viewCorgReport(@RequestBody CorgBean objCorgBean) {
		List<CorgBean> lCorgList = new ArrayList<CorgBean>();
		CorgResultBean objCorgResultBean = new CorgResultBean();
		try {
			try {
				lCorgList = objCorgService.viewCorgReport(objCorgBean);
				objCorgResultBean.setlCorgList(lCorgList);
				objCorgResultBean.setSuccess(true);
			} catch (Exception e) {
				objCorgResultBean.setSuccess(false);
				throw new CustomException();
			}

		} catch (Exception e) {
		}

		return objCorgResultBean;
	}

	@RequestMapping(value = "/viewCorgReportAsOnDate", method = RequestMethod.POST)
	public @ResponseBody CorgResultBean viewCorgReportAsOnDate(@RequestBody CorgBean objCorgBean) {
		List<CorgBean> lCorgList = new ArrayList<CorgBean>();
		CorgResultBean objCorgResultBean = new CorgResultBean();
		try {
			try {
				lCorgList = objCorgService.viewCorgReportAsOnDate(objCorgBean);
				objCorgResultBean.setlCorgList(lCorgList);
				objCorgResultBean.setSuccess(true);
			} catch (Exception e) {
				objCorgResultBean.setSuccess(false);
				throw new CustomException();
			}

		} catch (Exception e) {
		}

		return objCorgResultBean;
	}
	
	@RequestMapping(value = "/exportCorgReport", method = RequestMethod.POST)
	public @ResponseBody boolean exportCorgReport(@RequestBody CorgBean objCorgBean) {

		boolean isSuccess = false;
		try {
			isSuccess = objCorgService.exportCorgReport(ConfigurationProps.exportFilesPath, objCorgBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	@RequestMapping(value = "/getweekenddate", method = RequestMethod.POST)
	public @ResponseBody CorgResultBean getweekenddate(@RequestBody CorgBean objCorgBean) {

		CorgResultBean objCorgResultBean = new CorgResultBean();
		try {
			String sWeekEndDate =objCorgService.getweekenddate(objCorgBean);
			objCorgResultBean.setSuccess(true);
			objCorgResultBean.setWeekEndDate(sWeekEndDate);
		} catch (Exception e) {
			objCorgResultBean.setSuccess(false);
			e.printStackTrace();
		}
		return objCorgResultBean;
	}
	
	
	@RequestMapping(value = "/exportCorgReportAsOnDate", method = RequestMethod.POST)
	public @ResponseBody boolean exportCorgReportAsOnDate(@RequestBody CorgBean objCorgBean) {

		boolean isSuccess = false;
		try {
			isSuccess = objCorgService.exportCorgReportAsOnDate(ConfigurationProps.exportFilesPath, objCorgBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
