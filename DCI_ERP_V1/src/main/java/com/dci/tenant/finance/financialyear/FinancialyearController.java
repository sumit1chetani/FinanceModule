package com.dci.tenant.finance.financialyear;

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
@RequestMapping(value = "app/financialyear")
public class FinancialyearController {

	private final static Logger LOGGER = LoggerFactory.getLogger(FinancialyearController.class);

	@Autowired
	private FinancialyearService financialyearService;

	// Populate Grid
	@RequestMapping("/list")
	public @ResponseBody FinancialyearResultBean OnDutyRequestList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		FinancialyearResultBean objfinancialyearResultBean = new FinancialyearResultBean();
		if (offset < 5000) {
			try {
				objfinancialyearResultBean.setLfinancialyearBean(financialyearService.getFinancialYearList(limit, offset));
				objfinancialyearResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objfinancialyearResultBean;
	}

	@RequestMapping("/save")
	public @ResponseBody FinancialyearResultBean saveFinancialYear(@RequestBody FinancialyearBean financialyearBean) throws CustomException {
		FinancialyearResultBean bean;
		try {
			bean = financialyearService.saveFinancialYear(financialyearBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return bean;
	}

	@RequestMapping("/getDataforEdit")
	public @ResponseBody FinancialyearBean getFinancialYearData(@RequestParam("finId") String finId) throws CustomException {
		FinancialyearBean bean = new FinancialyearBean();
		try {
			bean = financialyearService.getFinancialYearData(finId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return bean;
	}

	@RequestMapping("/update")
	public @ResponseBody boolean updateFinancialYear(@RequestBody FinancialyearBean financialyearBean) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = financialyearService.updateFinancialYear(financialyearBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteFinancialYear(@RequestParam("finId") String finId) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = financialyearService.deleteFinancialYear(finId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/validateFY")
	public @ResponseBody boolean validateFY(@RequestBody FinancialyearBean financialyearBean) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = financialyearService.validateFY(financialyearBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

}
