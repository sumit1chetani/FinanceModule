package com.dci.tenant.finance.reports.financials.BankBook;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "{tenantid}/finance/bank")
public class BankBookController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BankBookController.class);

	@Autowired
	private BankBookService objBankBookService;

	@RequestMapping(value = "/getMainGrid")
	public @ResponseBody BankBookResultBean getBankBookList(@RequestBody BankBook objBankBook) {
		BankBookResultBean objBankBookResultBean = new BankBookResultBean();
		try {
			objBankBookResultBean.setlBankBook(objBankBookService.getBankBookList(objBankBook));
			objBankBookResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankBookResultBean;
	}

	@RequestMapping(value = "/getSubGrid")
	public BankBookResultBean getBankBookAccountList(@RequestBody BankBook objBankBook) {

		BankBookResultBean objBankBookResultBean = new BankBookResultBean();
		try {
			objBankBookResultBean.setlBankBook(objBankBookService.getBankBookAccountList(objBankBook));
			objBankBookResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankBookResultBean;
	}

	/*@RequestMapping(value = "/getAccountList")
	public BankBookResultBean getAccountList() throws Exception {

		BankBookResultBean objCashBookResultBean = new BankBookResultBean();
		try {
			objCashBookResultBean.setLaccountList(objBankBookService.getAccountList());
			objCashBookResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objCashBookResultBean;
	}*/
	
	
	
	@RequestMapping(value = "/getAccountList")
	public @ResponseBody List<SelectivityBean> getAccountList() throws CustomException {
		List<SelectivityBean> lGroupList = new ArrayList<SelectivityBean>();

		try {
			lGroupList = objBankBookService.getAccountList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lGroupList;
	}

	@RequestMapping(value = "/exportBankBookExcel", method = RequestMethod.POST)
	public @ResponseBody boolean exportBankBookExcel(@RequestBody BankBook objBankBook, HttpServletRequest request,
			HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			//String sFilePath = request.getServletContext().getRealPath("assets/tempdoc");
			isSuccess = objBankBookService.exportBankBookExcel(ConfigurationProps.exportFilesPath, objBankBook);
			//isSuccess = objBankBookService.exportBankBookExcel(sFilePath, objBankBook);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}
}