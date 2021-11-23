package com.dci.tenant.finance.reports.analytical.adminandbudgetprojection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/app/adminbudgetprojection")
public class AdminBudgetAndProjectionController {

	private final static Logger LOGGER = LoggerFactory.getLogger(AdminBudgetAndProjectionController.class);

	@Autowired
	AdminBudgetAndProjectionService adminBudgetAndProjectionService;

	@RequestMapping("/budgetlist")
	public @ResponseBody AdminBudgetAndProjectionResultBean getAdminBudgetHdrList(@RequestParam("limit") int limit, @RequestParam("offset") int offset)
			throws CustomException {
		AdminBudgetAndProjectionResultBean objAdminBudgetResultBean = new AdminBudgetAndProjectionResultBean();
		try {

			objAdminBudgetResultBean.setlAdminBudgetAndProjectionBean(adminBudgetAndProjectionService.getAdminBudgetHdrList(limit, offset));
			objAdminBudgetResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objAdminBudgetResultBean;
	}

	@RequestMapping("/getPrevYearLoadingContainerTues")
	public @ResponseBody AdminBudgetAndProjectionResultBean getPrevYearLoadingContainerTuesList() throws CustomException {
		AdminBudgetAndProjectionResultBean objResultBean = new AdminBudgetAndProjectionResultBean();
		try {

			objResultBean = adminBudgetAndProjectionService.getPrevYearLoadingContainerTuesList();

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objResultBean;
	}

	@RequestMapping("/getAccountHeadPreviousBalance")
	public @ResponseBody AdminBudgetAndProjectionResultBean getAccountHeadPreviousBalance(@RequestParam("accountHead") String accountCode)
			throws CustomException {
		AdminBudgetAndProjectionResultBean objResultBean = new AdminBudgetAndProjectionResultBean();
		try {
			objResultBean = adminBudgetAndProjectionService.getAccountHeadPreviousBalance(accountCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objResultBean;
	}

	@RequestMapping("/generateAdminBudget")
	public @ResponseBody boolean generateAdminBudgetData(@RequestBody AdminBudgetAndProjectionBean objaAdminBudgetAndProjectionBean)
			throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = adminBudgetAndProjectionService.generateAdminBudgetData(objaAdminBudgetAndProjectionBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

}
