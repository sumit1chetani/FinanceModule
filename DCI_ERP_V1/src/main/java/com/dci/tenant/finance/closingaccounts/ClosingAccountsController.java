/*package com.mailapp.hospital.accounts.closingaccounts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mailapp.master.user.UserDetail;

@RestController
@RequestMapping(value = "hospital/accounts/closingAccounts")
public class ClosingAccountsController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClosingAccountsController.class);

	@Autowired
	private ClosingAccountsService objClosingAccountsService;

	@RequestMapping("/list")
	public @ResponseBody ClosingAccountsResultBean getClosingList() {
		ClosingAccountsResultBean objResultBean = new ClosingAccountsResultBean();
		try {
			objResultBean.setlClosingAccounts(objClosingAccountsService.getClosingAcctList());
			objResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objResultBean;
	}

	@RequestMapping(value = "/getaccount")
	public ClosingAccountsResultBean getaccount(@RequestBody ClosingAccounts bean) {

		ClosingAccountsResultBean objBankReconcilationResultBean = new ClosingAccountsResultBean();
		try {
			objBankReconcilationResultBean.setlClosingAccounts(objClosingAccountsService.getAccountList(bean));
			objBankReconcilationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankReconcilationResultBean;
	}

	@RequestMapping(value = "/addAccountList")
	public ClosingAccountsResultBean addAccountList(@RequestBody ClosingAccounts bean) {

		ClosingAccountsResultBean objBankReconcilationResultBean = new ClosingAccountsResultBean();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			String companyCode = userDetails.getCompanyCode();
			objBankReconcilationResultBean.setSuccess(objClosingAccountsService.addAccountList(bean, userId, companyCode));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankReconcilationResultBean;
	}

}*/

package com.dci.tenant.finance.closingaccounts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "hospital/accounts/closingAccounts")
public class ClosingAccountsController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClosingAccountsController.class);

	// private static final ClosingAccountsController objClosingAccountsService
	// = null;

	@Autowired
	ClosingAccountsService objClosingAccountsService;

	/*
	 * @RequestMapping(value= "/save", method = RequestMethod.POST) public
	 * ClosingAccountsResultBean save(@RequestBody ClosingAccounts
	 * objClosingAccountsBean) throws CustomException {
	 * 
	 * ClosingAccountsResultBean objClosingAccountsResultBean = new
	 * ClosingAccountsResultBean(); Object isSuccess; try {
	 * 
	 * objClosingAccountsResultBean =
	 * objClosingAccountsService.save(objClosingAccountsBean);
	 * 
	 * } catch (Exception e) { LOGGER.error("error on closing account" + e);
	 * throw new CustomException(); }
	 * 
	 * return objClosingAccountsResultBean;
	 * 
	 * }
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public boolean save(@RequestBody ClosingAccounts objClosingAccountsBean) {

		boolean isSuccess = false;
		try {

			isSuccess = objClosingAccountsService.insertManageCostCenter(objClosingAccountsBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody ClosingAccountsResultBean edit(@RequestBody Integer closingAccountId) throws Exception {
		ClosingAccountsResultBean closingAccountsResultBean = new ClosingAccountsResultBean();
		try {
			closingAccountsResultBean.setClosingaccounts(objClosingAccountsService.edit(closingAccountId));
			System.out.println("ClosingAccount:" + closingAccountId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return closingAccountsResultBean;

	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody Integer closingAccountId) {
		boolean isSuccess = false;
		try {
			objClosingAccountsService.delete(closingAccountId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping("/list")
	public @ResponseBody ClosingAccountsResultBean getList() throws CustomException {

		ClosingAccountsResultBean objClosingAccountsResultBean = new ClosingAccountsResultBean();

		try {

			objClosingAccountsResultBean.setList(objClosingAccountsService.getList());
			objClosingAccountsResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return objClosingAccountsResultBean;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody boolean update(@RequestBody ClosingAccounts objClosingAccountsBean) throws Exception {
		boolean isSuccess = false;
		try {
			isSuccess = objClosingAccountsService.update(objClosingAccountsBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

}
