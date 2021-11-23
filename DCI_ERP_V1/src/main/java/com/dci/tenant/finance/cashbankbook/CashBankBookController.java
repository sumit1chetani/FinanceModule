package com.dci.tenant.finance.cashbankbook;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.finance.GeneralLedger.GeneralLedgerBean;
import com.dci.finance.GeneralLedger.GeneralLedgerResultBean;


@RestController
@RequestMapping(value = "hospital/accounts/cashBankBook")
public class CashBankBookController {

	private final static Logger LOGGER = LoggerFactory.getLogger(CashBankBookController.class);

	@Autowired
	private CashBankBookService objCashBankBookService;

	@RequestMapping(value = "/getData")
	public CashBankBookResultBean getBankBookList(@RequestBody CashBankBook objGeneralLedgerBean) {

		CashBankBookResultBean objCashBankBookResultBean = new CashBankBookResultBean();
		try {
			objCashBankBookResultBean.setlCashBankBook(objCashBankBookService.getBankBookList(objGeneralLedgerBean));
			objCashBankBookResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objCashBankBookResultBean;
	}

	@RequestMapping(value = "/getSubData")
	public CashBankBookResultBean getBankBookAccountList(@RequestBody String parentAcctCode) {

		CashBankBookResultBean objCashBankBookResultBean = new CashBankBookResultBean();
		String[] codes = {};
		try {
			codes = parentAcctCode.split(",");
			objCashBankBookResultBean.setlCashBankBook(objCashBankBookService.getBankBookAccountList(codes[1], codes[0]));
			objCashBankBookResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objCashBankBookResultBean;
	}

	@RequestMapping(value = "/getGeneralLedgerReport", method = RequestMethod.POST)
	public @ResponseBody CashBankBookResultBean getGeneralLedgerReport(@RequestBody CashBankBook objGeneralLedgerBean) {
		List<CashBankBook> lGeneralLedgerList = new ArrayList<>();
		CashBankBookResultBean closeOpen = null;
		CashBankBookResultBean objGeneralLedgerResultBean = new CashBankBookResultBean();
		try {
			try {
				objGeneralLedgerResultBean.setlCashBankBook(objCashBankBookService.getGeneralLedgerReport(objGeneralLedgerBean));
				// objGeneralLedgerResultBean.setSublCashBankBook(objCashBankBookService.getOpeningBalanceValue(objGeneralLedgerBean));
				objGeneralLedgerResultBean.setSuccess(true);
			} catch (Exception e) {
				objGeneralLedgerResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objGeneralLedgerResultBean;
	}
	
	


}