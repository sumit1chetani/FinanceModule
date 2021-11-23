package com.dci.tenant.finance.bankcompany;

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
@RequestMapping(value = "app/bankcompany")
public class BankcompanyController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BankcompanyController.class);

	@Autowired
	private BankcompanyService ObjBankcompanyService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean addAcctHead(@RequestBody BankcompanyBean objBankcompanyBean) throws CustomException {
		String userId = "E001";
		boolean isSuccess = false;
		BankCompanyResultBean objBankCompanyResultBean = new BankCompanyResultBean();
		try {
			isSuccess = ObjBankcompanyService.addAcctHeadMastercom(objBankcompanyBean, userId);
			objBankCompanyResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/list")
	public @ResponseBody BankCompanyResultBean getAcctHeadList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		BankCompanyResultBean objBankCompanyResultBean = new BankCompanyResultBean();
		try {
			objBankCompanyResultBean.setlAccountHeadMasterBeanBean(ObjBankcompanyService.getAcctHeadMasterList(limit, offset));
			objBankCompanyResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objBankCompanyResultBean;
	}

	@RequestMapping("/edit")
	public @ResponseBody BankcompanyBean editBankcompanyValues(@RequestBody String bankCode) throws CustomException {
		BankcompanyBean objBankcompanyBean = new BankcompanyBean();
		try {
			objBankcompanyBean = ObjBankcompanyService.getBankcompanyValues(bankCode);
			// .seti
		} catch (Exception e) {
			// .setIsEdit(false);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objBankcompanyBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteDepartment(@RequestParam("bankCode") String bankCode) throws CustomException {
		boolean isDeleted = false;
		try {
			isDeleted = ObjBankcompanyService.deleteVendor(bankCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isDeleted;
	}

	/*
	 * @RequestMapping("/delete") public boolean deleteCurrency(@RequestBody
	 * String bankCode) throws CustomException { boolean isDeleted = false;
	 * isDeleted = ObjBankcompanyService.deleteCurrency(bankCode); return
	 * isDeleted; }
	 */

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateAcctHead(@RequestBody BankcompanyBean objBankcompanyBean) throws CustomException {
		boolean isSuccess = false;
		BankCompanyResultBean objBankCompanyResultBean = new BankCompanyResultBean();
		try {
			isSuccess = ObjBankcompanyService.updateAcctHeadMaster(objBankcompanyBean);
			objBankCompanyResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}
}
