package com.dci.tenant.finance.budgetType;

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
@RequestMapping(value = "app/budget/type")
public class BudgetTypeController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetTypeController.class);

	@Autowired
	private BudgetTypeService budgetTypeService;

	BudgetTypeResultBean resultBean = new BudgetTypeResultBean();

	@RequestMapping("/getDropDownList")
	public BudgetTypeResultBean getDropDownList() {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			resultBean.setlExpenseAccountsList(budgetTypeService.getExpenseAccountsList(userDetails.getUserId()));
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/save")
	public BudgetTypeResultBean save(@RequestBody BudgetTypeBean allocationBean) {
		try {
			resultBean.setSuccess(budgetTypeService.save(allocationBean));
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/update")
	public BudgetTypeResultBean update(@RequestBody BudgetTypeBean allocationBean) {
		try {
			resultBean.setSuccess(budgetTypeService.update(allocationBean));
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/delete")
	public BudgetTypeResultBean delete(@RequestBody String budgetId) {
		try {
			resultBean.setSuccess(budgetTypeService.delete(budgetId));
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/typeList")
	public BudgetTypeResultBean typeList() {
		try {
			resultBean.setlBudgetTypeBean(budgetTypeService.budgetTypeList());
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

	@RequestMapping("/getTypeEdit")
	public BudgetTypeResultBean budgetTypeEdit(@RequestParam("typeId") String typeId) {
		try {
			resultBean.setBudgetTypeBean(budgetTypeService.budgetTypeEdit(typeId));
			resultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return resultBean;
	}

}
