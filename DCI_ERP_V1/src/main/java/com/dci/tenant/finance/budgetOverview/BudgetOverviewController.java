package com.dci.tenant.finance.budgetOverview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hospital/accounts/budgetOverview")
public class BudgetOverviewController {
	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetOverviewController.class);

	@Autowired
	private BudgetOverviewService budgetOverviewService;

	@RequestMapping(value = "/list")
	public BudgetOverviewResultBean getBankBookList(@RequestBody BudgetOverviewBean overviewBean) {

		BudgetOverviewResultBean budgetOverviewResultBean = new BudgetOverviewResultBean();
		try {
			budgetOverviewResultBean.setlBudgetOverview(budgetOverviewService.getList(overviewBean));
			budgetOverviewResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return budgetOverviewResultBean;
	}

	@RequestMapping(value = "/getDetailList")
	public BudgetOverviewResultBean getDetailList(@RequestBody BudgetOverviewBean overviewBean) {

		BudgetOverviewResultBean budgetOverviewResultBean = new BudgetOverviewResultBean();
		try {
			budgetOverviewResultBean.setLdetailList(budgetOverviewService.getDetailList(overviewBean));
			budgetOverviewResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return budgetOverviewResultBean;
	}

	@RequestMapping(value = "/getFinancialYear")
	public BudgetOverviewResultBean getFinancialYearList(@RequestBody String companyId) {

		BudgetOverviewResultBean budgetOverviewResultBean = new BudgetOverviewResultBean();
		try {
			budgetOverviewResultBean.setlFinanceYear(budgetOverviewService.getFinancialYearList(companyId));
			budgetOverviewResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return budgetOverviewResultBean;
	}

}
