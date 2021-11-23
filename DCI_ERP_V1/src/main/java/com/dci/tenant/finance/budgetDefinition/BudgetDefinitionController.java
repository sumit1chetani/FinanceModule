package com.dci.tenant.finance.budgetDefinition;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dci.tenant.finance.budgetType.BudgetTypeController;

@RestController
@RequestMapping(value = "app/budgetDefinition")
public class BudgetDefinitionController {
	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetTypeController.class);

	@Autowired
	private BudgetDefinitionService BudgetDefinitionService;

	@RequestMapping("/saveBudgetDefinitionList")
	public boolean saveBudgetDefinitionList(@RequestBody BudgetDefinition BudgetDefinition) {
		boolean isSuccess = false;
		try {

			isSuccess = BudgetDefinitionService.saveBudgetDefinition(BudgetDefinition);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	@RequestMapping("/updateBudgetDefinitionList")
	public BudgetDefinition updateBudgetDefinitionList(@RequestBody BudgetDefinition BudgetDefinition) {
		boolean isSuccess = false;
		try {

			isSuccess = BudgetDefinitionService.updateBudgetDefinition(BudgetDefinition);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return BudgetDefinition;
	}

	@RequestMapping("/approveBudgetDefinitionList")
	public BudgetDefinition approveBudgetDefinitionList(@RequestBody BudgetDefinition BudgetDefinition) {
		boolean isSuccess = false;
		try {

			isSuccess = BudgetDefinitionService.approveBudgetDefinition(BudgetDefinition);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return BudgetDefinition;
	}

	@RequestMapping("/getAllBudgetDefinitionList")
	public BudgetDefinitionResultBean getAllBudgetDefinitionList() {
		List<BudgetDefinition> allList = new ArrayList<>();
		BudgetDefinitionResultBean bean = new BudgetDefinitionResultBean();
		try {
			allList = BudgetDefinitionService.getBudgetDefinition();
			bean.setAllList(allList);
			bean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return bean;
	}

	@RequestMapping("/editBudgetDefinitionList")
	public BudgetDefinition editBudgetDefinitionList(@RequestParam("budgetDefinitionId") Integer budgetDefinitionId) {
		BudgetDefinition bean = new BudgetDefinition();
		try {

			bean = BudgetDefinitionService.editBudgetDefinition(budgetDefinitionId);
			bean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return bean;
	}

	@RequestMapping("/delete")
	public BudgetDefinitionResultBean delete(@RequestBody Integer budgetDefinitionId) {
		BudgetDefinitionResultBean bean = new BudgetDefinitionResultBean();

		try {
			bean.setSuccess(BudgetDefinitionService.delete(budgetDefinitionId));
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return bean;
	}

	@RequestMapping("/getBudgetType")
	public BudgetDefinitionResultBean getBudgetTypeList() {
		BudgetDefinitionResultBean bean = new BudgetDefinitionResultBean();

		try {
			bean.setBudgetTypeList(BudgetDefinitionService.getBudgetTypeList());
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return bean;
	}
}
