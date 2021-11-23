package com.dci.finance.closingPeriod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
import com.dci.tenant.finance.closingaccounts.ClosingAccountsController;

@Controller
@RequestMapping(value = "hospital/accounts/closingPeriod")

public class ClosingPeriodController {

	private static Logger LOGGER = LoggerFactory.getLogger(ClosingAccountsController.class);

	@Autowired
	ClosingPeriodService objClosingAccountsService;

	@RequestMapping(value = "/list")
	public @ResponseBody ClosingPeriodresultBean getClosingList() throws CustomException {

		ClosingPeriodresultBean objClosingPeriodresultBean = null;

		try {
			objClosingPeriodresultBean = new ClosingPeriodresultBean();
			objClosingPeriodresultBean.setlClosingAccount(objClosingAccountsService.getClosingList());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException();
		}

		return objClosingPeriodresultBean;

	}

	@RequestMapping(value = "/delete")
	public @ResponseBody boolean delete(@RequestParam String closingAccountCode) throws CustomException {
		boolean isDeleted = false;
		try {
			isDeleted = objClosingAccountsService.delete(closingAccountCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isDeleted;
	}

	@RequestMapping("/save")
	public @ResponseBody boolean save(@RequestBody ClosingPeriodBean objClosingPeriodBean) throws CustomException {
		boolean isSuccess = false;

		try {

			isSuccess = objClosingAccountsService.save(objClosingPeriodBean);

		} catch (Exception e) {
			LOGGER.error("error", e);
			throw new CustomException();
		}
		return isSuccess;

	}

	@RequestMapping("/chkDate")
	public @ResponseBody boolean chkDate(@RequestParam String cbReceiptDate) throws CustomException {
		boolean isSuccess = false;

		try {

			isSuccess = objClosingAccountsService.chkDate(cbReceiptDate);

		} catch (Exception e) {
			LOGGER.error("error", e);
			throw new CustomException();
		}
		return isSuccess;

	}

}
