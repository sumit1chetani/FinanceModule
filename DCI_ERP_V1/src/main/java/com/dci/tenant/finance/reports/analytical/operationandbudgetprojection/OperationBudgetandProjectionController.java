package com.dci.tenant.finance.reports.analytical.operationandbudgetprojection;

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
@RequestMapping(value = "{tenantid}/app/operationbudgetandprojection")
public class OperationBudgetandProjectionController {

	private final static Logger LOGGER = LoggerFactory.getLogger(OperationBudgetandProjectionController.class);

	@Autowired
	private OperationBudgetandProjectionService operationBudgetService;

	@RequestMapping("/budgetlist")
	public @ResponseBody OperationBudgetandProjectionResultBean getOpernBudgetHdrList(@RequestParam("limit") int limit,
			@RequestParam("offset") int offset) throws CustomException {
		OperationBudgetandProjectionResultBean objOprnBudgetResultBean = new OperationBudgetandProjectionResultBean();
		try {

			objOprnBudgetResultBean.setlOperationBudgetandProjectionBean(operationBudgetService.getOpernBudgetHdrList(limit, offset));
			objOprnBudgetResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objOprnBudgetResultBean;
	}

	@RequestMapping("/vessel")
	public @ResponseBody OperationBudgetandProjectionResultBean getVessel() throws CustomException {
		OperationBudgetandProjectionResultBean objBean = new OperationBudgetandProjectionResultBean();

		try {
			objBean = operationBudgetService.getvessel();
			objBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objBean;
	}

	@RequestMapping("/voyage")
	public @ResponseBody OperationBudgetandProjectionResultBean getvoyage(@RequestBody String vesselCode) throws CustomException {
		OperationBudgetandProjectionResultBean objBean = new OperationBudgetandProjectionResultBean();

		try {
			objBean = operationBudgetService.getvoyage(vesselCode);
			objBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objBean;
	}

	@RequestMapping("/sector")
	public @ResponseBody OperationBudgetandProjectionResultBean getSector(@RequestBody String voyageId) throws CustomException {
		OperationBudgetandProjectionResultBean objBean = new OperationBudgetandProjectionResultBean();

		try {
			objBean = operationBudgetService.getSectorList();

			objBean.getOperationBudget().setSectorCode(operationBudgetService.getSectorCode(voyageId).getOperationBudget().getSectorCode());
			objBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objBean;
	}

	@RequestMapping("/save")
	public @ResponseBody OperationBudgetandProjectionResultBean insert(@RequestBody OperationBudgetandProjectionBean operationBudget)
			throws CustomException {
		OperationBudgetandProjectionResultBean objBean = new OperationBudgetandProjectionResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = operationBudgetService.insertOperationbudjet(operationBudget);
			objBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objBean;
	}
}