package com.dci.tenant.finance.chqreconcilation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.tenant.user.UserDetail;

@RestController
@RequestMapping(value = "hospital/accounts/chequeReconcilation")
public class ChqReconcilationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ChqReconcilationController.class);

	@Autowired
	private ChqReconcilationService objBankReconcilationService;

	@RequestMapping(value = "/getDropdown")
	public ChqReconcilationResultBean getBankBookList(@RequestBody String type) {

		ChqReconcilationResultBean objBankReconcilationResultBean = new ChqReconcilationResultBean();
		try {
			objBankReconcilationResultBean.setlBankReconcilationBook(objBankReconcilationService.getBankBookList());
			objBankReconcilationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankReconcilationResultBean;
	}

	@RequestMapping(value = "/getBankandBookStatement")
	public ChqReconcilationResultBean getBankandBookStatement(@RequestBody ChqReconcilationBook bean) {

		ChqReconcilationResultBean objBankReconcilationResultBean = new ChqReconcilationResultBean();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			String companyCode = userDetails.getCompanyCode();
			objBankReconcilationResultBean.setlBankReconcilationBook(objBankReconcilationService.getBankandBookStatement(bean.getFromdate(), bean.getTodate(), bean.getBankAccount(), companyCode));
			objBankReconcilationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankReconcilationResultBean;
	}

	@RequestMapping(value = "/getReconcileStatement")
	public ChqReconcilationResultBean getReconcileStatement(@RequestBody ChqReconcilationBook bean) {

		ChqReconcilationResultBean objBankReconcilationResultBean = new ChqReconcilationResultBean();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			String companyCode = userDetails.getCompanyCode();
			objBankReconcilationResultBean.setlBankReconcilationBook(objBankReconcilationService.getReconcileStatement(bean.getFromdate(), bean.getTodate(), bean.getBankAccount(), companyCode));
			objBankReconcilationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankReconcilationResultBean;
	}

	@RequestMapping(value = "/save")
	public ChqReconcilationResultBean saveReconcilation(@RequestBody ChqReconcilationBook bean) {

		ChqReconcilationResultBean objBankReconcilationResultBean = new ChqReconcilationResultBean();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userId = userDetails.getUserId();
			String companyCode = userDetails.getCompanyCode();
			objBankReconcilationResultBean.setSuccess(objBankReconcilationService.saveReconcilation(bean, companyCode));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankReconcilationResultBean;
	}

}