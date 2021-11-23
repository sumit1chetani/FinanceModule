package com.dci.tenant.finance.reports.schedule.loansandadvances;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/app/laonsadvances")
public class LoansAndAdvancesController {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoansAndAdvancesController.class);

	@Autowired
	LoansAndAdvancesService objLoansAndAdvancesService;

	@RequestMapping("/getDepartmentList")
	public @ResponseBody
	List<SelectivityBean> getDepartmentList() throws CustomException {
		List<SelectivityBean> lDepartmentList = new ArrayList<SelectivityBean>();
		try {
			lDepartmentList = objLoansAndAdvancesService.getDepartmentList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lDepartmentList;
	}

	@RequestMapping("/getCustomerList")
	public @ResponseBody
	List<SelectivityBean> getCustomerList() throws CustomException {
		List<SelectivityBean> lCustomerList = new ArrayList<SelectivityBean>();
		try {
			lCustomerList = objLoansAndAdvancesService.getCustomerList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCustomerList;
	}

	@RequestMapping("/getSupplierList")
	public @ResponseBody
	List<SelectivityBean> getSupplierList() throws CustomException {
		List<SelectivityBean> lSupplierList = new ArrayList<SelectivityBean>();
		try {
			lSupplierList = objLoansAndAdvancesService.getSupplierList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSupplierList;
	}

	@RequestMapping("/getEmployeeList")
	public @ResponseBody
	LoansAndAdvancesResultBean getEmployeeList(@RequestParam("department") String department) throws CustomException {
		LoansAndAdvancesResultBean loansAndAdvancesResultBean = null;
		try {
			loansAndAdvancesResultBean = objLoansAndAdvancesService.getEmployeeList(department);
			loansAndAdvancesResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return loansAndAdvancesResultBean;
	}

	@RequestMapping("/generateLoanAdvanceReport")
	public @ResponseBody
	List<LoansAndAdvancesBean> generateLAReport(@RequestBody LoansAndAdvancesBean objLoansAndAdvancesBean) throws CustomException {
		List<LoansAndAdvancesBean> lLoanAdvanceList = new ArrayList<LoansAndAdvancesBean>();
		try {
			lLoanAdvanceList = objLoansAndAdvancesService.generateLAReport(objLoansAndAdvancesBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lLoanAdvanceList;
	}
}
