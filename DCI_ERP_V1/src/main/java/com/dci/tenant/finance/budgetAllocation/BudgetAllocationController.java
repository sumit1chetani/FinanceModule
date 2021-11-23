package com.dci.tenant.finance.budgetAllocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dci.tenant.user.UserDetail;

@RestController
@RequestMapping(value = "app/budget")
public class BudgetAllocationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetAllocationController.class);

	@Autowired
	private BudgetAllocationService budgetAllocationService;

	BudgetAllocationResultBean resultBean = new BudgetAllocationResultBean();

	@RequestMapping("/getDropDownList")
	public BudgetAllocationResultBean getDropDownList() {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			resultBean.setCompanyList(budgetAllocationService.getCompanyList(userDetails.getUserId()));
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/getFinYear")
	public BudgetAllocationResultBean getFinYear(@RequestParam("company") String company) {
		try {
			resultBean.setFinYearList(budgetAllocationService.getFinancialYearList(company));
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/getFinYearbudget")
	public BudgetAllocationResultBean getFinYearbudget() {
		try {
			resultBean.setFinYearList(budgetAllocationService.getFinYearbudget());
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/getTdsType")
	public BudgetAllocationResultBean getTdsType() {
		try {
			resultBean.setTdsList(budgetAllocationService.getTdsType());
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/getVendorList")
	public BudgetAllocationResultBean getVendorList() {
		try {
			resultBean.setVendorList(budgetAllocationService.getVendorList());
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/getaccontnameTds")
	public BudgetAllocationResultBean getaccontnameTds() {
		try {
			resultBean.setTdsList(budgetAllocationService.getaccontnameTds());
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/save")
	public BudgetAllocationResultBean save(@RequestBody BudgetAllocationBean allocationBean) {
		try {
			resultBean.setSuccess(budgetAllocationService.save(allocationBean));
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/update")
	public BudgetAllocationResultBean update(@RequestBody BudgetAllocationBean allocationBean) {
		try {
			resultBean.setSuccess(budgetAllocationService.update(allocationBean));
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/delete")
	public BudgetAllocationResultBean delete(@RequestBody String budgetId) {
		try {
			resultBean.setSuccess(budgetAllocationService.delete(budgetId));
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/allocationList")
	public BudgetAllocationResultBean allocationList() {
		try {
			resultBean.setlBudgetAllocationBean(budgetAllocationService.allocationList());
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/getAllocationEdit")
	public BudgetAllocationResultBean allocationEdit(@RequestParam("allocationId") String allocationId) {
		try {
			resultBean.setBudgetAllocationBean(budgetAllocationService.allocationEdit(allocationId));
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/approve")
	public BudgetAllocationResultBean approve(@RequestBody BudgetAllocationBean allocationBean) {
		try {
			resultBean.setSuccess(budgetAllocationService.approve(allocationBean));
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/getAvailablity")
	public BudgetAllocationResultBean getAvailablity(@RequestBody BudgetAllocationBean allocationBean) {
		try {
			resultBean.setSuccess(budgetAllocationService.getAvailablity(allocationBean));
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/getDynamicColumns")
	public BudgetAllocationResultBean getDynamicColumns(@RequestParam("type") String type) {
		try {
			resultBean.setColumnList(budgetAllocationService.getDynamicColumns(type));
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

}
