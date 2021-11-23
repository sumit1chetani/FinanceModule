package com.dci.tenant.finance.exchangerate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;

@RestController
@RequestMapping(value = "app/exchangerate")
public class ExchangeRateController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExchangeRateController.class);

	@Autowired
	private ExchangeRateService exchangeRateService;

	@RequestMapping("/list")
	public @ResponseBody ExchangeRateResultBean getExchangeRateList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		ExchangeRateResultBean objExchangeRateResultBean = new ExchangeRateResultBean();
		try {
			objExchangeRateResultBean.setlExchangeRateBean(exchangeRateService.getExchangeRateList(limit, offset));
			objExchangeRateResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objExchangeRateResultBean;
	}

	@RequestMapping("/getCurrencyList")
	public @ResponseBody ExchangeRateResultBean getCurrencyList() throws CustomException {
		ExchangeRateResultBean objBean = null;
		try {
			objBean = exchangeRateService.getCurrencyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objBean;
	}

	@RequestMapping("/getBookCurrencyList")
	public @ResponseBody ExchangeRateResultBean getBookCurrencyList() throws CustomException {
		ExchangeRateResultBean objBean = null;
		try {
			objBean = exchangeRateService.getBookCurrencyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objBean;
	}

	@RequestMapping("/save")
	public @ResponseBody boolean saveExchangeRateData(@RequestBody ExchangeRateBean objExchangeRateBean) throws CustomException {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		ExchangeRateResultBean objExchangeRateResultBean = new ExchangeRateResultBean();
		try {

			isSuccess = exchangeRateService.saveExchangeRateData(objExchangeRateBean, userId);
			objExchangeRateResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/update")
	public @ResponseBody boolean updateExchangeRateData(@RequestBody ExchangeRateBean objExchangeRateBean) throws CustomException {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		ExchangeRateResultBean objExchangeRateResultBean = new ExchangeRateResultBean();
		try {

			isSuccess = exchangeRateService.updateExchangeRateData(objExchangeRateBean, userId);
			objExchangeRateResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/getExchangeRateListOnEdit")
	public @ResponseBody ExchangeRateBean getExchangeRateEditList(@RequestBody String exchangeRateCode) throws Exception {
		ExchangeRateBean objRateBean = new ExchangeRateBean();
		objRateBean = exchangeRateService.getExchangeRateEditList(exchangeRateCode);

		return objRateBean;
	}

	@RequestMapping("/copyExgRate")
	public @ResponseBody boolean copyExchangeRate(@RequestBody ExchangeRateBean objExchangeRateBean) throws CustomException {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		ExchangeRateResultBean objExchangeRateResultBean = new ExchangeRateResultBean();
		try {

			isSuccess = exchangeRateService.copyExchangeRate(objExchangeRateBean, userId);
			objExchangeRateResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/deleteRow")
	public @ResponseBody boolean deleteExchangeRate(@RequestBody String erCode) throws Exception {
		boolean isDeleted = false;
		isDeleted = exchangeRateService.deleteExchangeRate(erCode);
		return isDeleted;
	}
}
