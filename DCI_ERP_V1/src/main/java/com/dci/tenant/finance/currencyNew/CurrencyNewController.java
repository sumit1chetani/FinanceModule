package com.dci.tenant.finance.currencyNew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "app/currencyNew")
public class CurrencyNewController {

	private final static Logger LOGGER = LoggerFactory.getLogger(CurrencyNewController.class);

	@Autowired
	private CurrencyNewService currencyNewService;

	@RequestMapping(value = "/list")
	public @ResponseBody CurrencyNewResultBean getCurrencyList() throws CustomException, InterruptedException {
		CurrencyNewResultBean objCurrencyResultBean = new CurrencyNewResultBean();

		try {
			objCurrencyResultBean.setlCurrencyBean(currencyNewService.getCurrencyList());
			objCurrencyResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCurrencyResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody CurrencyNewBean objCurrencyBean) throws CustomException {
		CurrencyNewResultBean objCurrencyResultBean = new CurrencyNewResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = currencyNewService.saveCurrencyData(objCurrencyBean);
			if (isSuccess)
				isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Save", e);
		}

		return isSuccess;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody CurrencyNewBean objCurrencyBean) {
		CurrencyNewResultBean currencyNewResultBean = new CurrencyNewResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = currencyNewService.updateCurrency(objCurrencyBean);
		} catch (CustomException e) {
			LOGGER.error("Error in Update", e);
		}
		return isSuccess;
	}

	@RequestMapping("/delete")
	public boolean deleteCurrency(@RequestBody String currencyCode) throws CustomException {
		boolean isDeleted = false;
		isDeleted = currencyNewService.deleteCurrency(currencyCode);
		return isDeleted;
	}

	@RequestMapping(value = "/edit")
	public CurrencyNewResultBean getCurrencyListOnEdit(@RequestBody String currencyCode) {
		CurrencyNewResultBean currencyNewResultBean = new CurrencyNewResultBean();
		try {
			CurrencyNewBean currency = currencyNewService.getCurrencyListOnEdit(currencyCode);
			currencyNewResultBean.setObjCurrencyBean(currency);

			currencyNewResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currencyNewResultBean;
	}

}
