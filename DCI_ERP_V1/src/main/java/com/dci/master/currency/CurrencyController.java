package com.dci.master.currency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/app/currency")
public class CurrencyController {

	private final static Logger LOGGER = LoggerFactory.getLogger(CurrencyController.class);
	@Autowired
	private CurrencyService currencyService;

	// Getting List

	@RequestMapping("/list")
	// @PreAuthorize("hasRole('F0012_L')")
	public @ResponseBody CurrencyResultBean getCurrencyList(@RequestParam("limit") int limit, @RequestParam("offset") int offset)
			throws CustomException, InterruptedException {
		CurrencyResultBean objCurrencyResultBean = new CurrencyResultBean();

		if (offset < 5000) {
			try {
				objCurrencyResultBean.setlCurrencyBean(currencyService.getCurrencyList(limit, offset));
				objCurrencyResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objCurrencyResultBean;
	}
	
//	@RequestMapping("/getExchangeRate")
//	// @PreAuthorize("hasRole('F0012_L')")
//	public @ResponseBody CurrencyResultBean getExchangeRate(@RequestParam("currencyId") int currencyId)
//			throws CustomException, InterruptedException {
//		CurrencyResultBean objCurrencyResultBean = new CurrencyResultBean();
//
//		
//			try {
//				objCurrencyResultBean=currencyService.getExchangeRate(currencyId);
//				objCurrencyResultBean.setSuccess(true);
//			} catch (Exception e) {
//				LOGGER.error("Error", e);
//				throw new CustomException();
//			}
//		return objCurrencyResultBean;
//	}
//	
	
	@RequestMapping("/getExchangeRate")
	public @ResponseBody CurrencyResultBean getExchangeRate(@RequestParam Integer currencyId) throws CustomException {
		CurrencyResultBean objCurrencyResultBean = new CurrencyResultBean();
		try {
			objCurrencyResultBean=currencyService.getExchangeRate(currencyId);
		} catch (Exception e) {
			throw new CustomException();
		}

		return objCurrencyResultBean;
	}
	// Save Method

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody CurrencyResultBean addCostCentre(@RequestBody CurrencyBean objCurrencyBean) throws CustomException {
		CurrencyResultBean objCurrencyResultBean = new CurrencyResultBean();
		try {

			objCurrencyResultBean = currencyService.addcurrency(objCurrencyBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return objCurrencyResultBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteConfignee(@RequestBody Integer currencyCode) throws Exception {
		boolean isDeleted = false;
		isDeleted = currencyService.deleteCurrency(currencyCode);
		return isDeleted;
	}

	/*
	 * // delete
	 * 
	 * @RequestMapping(value = "/delete") public @ResponseBody boolean
	 * deleteConfignee(@RequestParam("currencyCode") String currencyCode) throws
	 * CustomException { boolean isDeleted = false; try { isDeleted =
	 * currencyService.deleteCurrency(currencyCode); } catch (Exception e) {
	 * LOGGER.error("Error", e); throw new CustomException(); }
	 * 
	 * return isDeleted; }
	 */

	// update

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateCurrency(@RequestBody CurrencyBean objCurrencyBean) throws CustomException {
		boolean isSuccess = false;
		CurrencyResultBean objCurrencyResultBean = new CurrencyResultBean();
		try {

			isSuccess = currencyService.updateCurrency(objCurrencyBean);
			objCurrencyResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}
	
	

}
