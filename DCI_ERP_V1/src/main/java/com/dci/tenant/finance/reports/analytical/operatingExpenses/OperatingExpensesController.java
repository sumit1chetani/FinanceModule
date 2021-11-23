package com.dci.tenant.finance.reports.analytical.operatingExpenses;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;

@RestController
@RequestMapping(value = "{tenantid}/analytical/operatingExpenses")
public class OperatingExpensesController {

	@Autowired
	OperatingExpensesService operatingExpensesService;

	private final static Logger LOGGER = LoggerFactory.getLogger(OperatingExpensesController.class);

	@RequestMapping(value = "/getDropDownList")
	public OperatingExpensesResultBean getDropDownList(@RequestBody OperatingExpensesBean expensesBean) {
		OperatingExpensesResultBean expensesResultBean = new OperatingExpensesResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			expensesBean.setUserId(userDetails.getUserId());
			expensesBean.setCompanyCode(userDetails.getCompanyCode());
			expensesResultBean.setVesselList(operatingExpensesService.getVesselList(expensesBean));
			expensesResultBean.setVoyageList(operatingExpensesService.setVoyageList(expensesBean));
			expensesResultBean.setCompanyList(operatingExpensesService.getCompanyList(expensesBean));
			expensesResultBean.setAccountHeadList(operatingExpensesService.getAccoundHeadList(expensesBean));

		} catch (Exception e) {
			LOGGER.error("Error in getDropDownList", e);
		}
		return expensesResultBean;
	}

	@RequestMapping(value = "/getMainReport")
	public OperatingExpensesResultBean getMainReport(@RequestBody OperatingExpensesBean expensesBean) {
		OperatingExpensesResultBean expensesResultBean = new OperatingExpensesResultBean();
		try {
			expensesResultBean.setMainReport(operatingExpensesService.getMainReport(expensesBean));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getMainReport", e);
		}
		return expensesResultBean;
	}

	@RequestMapping(value = "/getSubReport")
	public OperatingExpensesResultBean getSubReport(@RequestBody OperatingExpensesBean expensesBean) {
		OperatingExpensesResultBean expensesResultBean = new OperatingExpensesResultBean();
		try {
			expensesResultBean.setSubReport(operatingExpensesService.getSubReport(expensesBean));
			expensesResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error in getSubReport", e);
		}
		return expensesResultBean;
	}
	
	@RequestMapping(value = "/add")
	public @ResponseBody List<SelectivityBean> getLocationList() throws CustomException {
		List<SelectivityBean> locationList = new ArrayList<SelectivityBean>();

		try {
			locationList = operatingExpensesService.getLocationList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return locationList;
	}
	
	@RequestMapping(value = "/add1")
	public @ResponseBody List<SelectivityBean> getLocationList(@RequestParam ("company") String brnch) throws CustomException {
		List<SelectivityBean> locationList = new ArrayList<SelectivityBean>();

		try {
			locationList = operatingExpensesService.getLocationList1(brnch);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return locationList;
	}
/*	public OperatingExpensesResultBean addBooking() {
		OperatingExpensesResultBean rb = new OperatingExpensesResultBean();
		try {
			
			rb.setLocationList(operatingExpensesService.getLocationList());
		
			rb.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}*/

	@RequestMapping(value = "/exportExcel",method = RequestMethod.POST)
	public OperatingExpensesResultBean exportExcel(@RequestBody OperatingExpensesBean expensesBean, HttpServletRequest request,HttpServletResponse response) {
		OperatingExpensesResultBean result = new OperatingExpensesResultBean();
		try {
			//String filePath = request.getServletContext().getRealPath("/assets/excelDocument");
			result.setSuccess(operatingExpensesService.exportExcel(ConfigurationProps.exportFilesPath, expensesBean));
		} catch (Exception e) {
			LOGGER.error("Error in exportExcel", e);
		}
		return result;
	}
	
	@RequestMapping(value = "/getGroupHeadList")
	public @ResponseBody List<SelectivityBean> getSubGroupList() throws CustomException {
		List<SelectivityBean> lGroupList = new ArrayList<SelectivityBean>();

		try {
			lGroupList = operatingExpensesService.getGroupHeadList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lGroupList;
	}

}
