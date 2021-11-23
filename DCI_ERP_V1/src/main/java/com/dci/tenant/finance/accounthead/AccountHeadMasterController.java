package com.dci.tenant.finance.accounthead;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

/*import com.feedertech.core.util.CustomException;*/

@Controller
@RequestMapping(value = "app/accounthead")
public class AccountHeadMasterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(AccountHeadMasterController.class);

	@Autowired
	private AccountHeadMasterService accountHeadMasterService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean addAcctHead(@RequestBody AccountHeadMasterBean objAccountHeadMasterBean) throws CustomException {
		String userId = "E001";
		boolean isSuccess = false;
		AccountHeadMasterResultBean objAccountHeadMasterResultBean = new AccountHeadMasterResultBean();
		try {
			isSuccess = accountHeadMasterService.addAcctHeadMaster(objAccountHeadMasterBean, userId);
			objAccountHeadMasterResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/edit")
	public @ResponseBody AccountHeadMasterBean editAccountHeadValues(@RequestParam("accountCode") String accountCode) throws CustomException {
		AccountHeadMasterBean objAccountHeadMasterBean = new AccountHeadMasterBean();
		try {
			objAccountHeadMasterBean = accountHeadMasterService.getAccountHeadValues(accountCode);
			objAccountHeadMasterBean.setEdit(true);
		} catch (Exception e) {
			objAccountHeadMasterBean.setEdit(false);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objAccountHeadMasterBean;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateAcctHead(@RequestBody AccountHeadMasterBean objAccountHeadMasterBean) throws CustomException {
		boolean isSuccess = false;
		AccountHeadMasterResultBean objAccountHeadMasterResultBean = new AccountHeadMasterResultBean();
		try {
			isSuccess = accountHeadMasterService.updateAcctHeadMaster(objAccountHeadMasterBean);
			objAccountHeadMasterResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/list")
	public @ResponseBody AccountHeadMasterResultBean getAcctHeadList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		AccountHeadMasterResultBean objAccountHeadMasterResultBean = new AccountHeadMasterResultBean();
		try {
			objAccountHeadMasterResultBean.setlAccountHeadMasterBeanBean(accountHeadMasterService.getAcctHeadMasterList(limit, offset));
			objAccountHeadMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objAccountHeadMasterResultBean;
	}

	@RequestMapping(value = "/searchlist", method = RequestMethod.POST)
	public @ResponseBody AccountHeadMasterResultBean searchportDtl(@RequestBody AccountHeadMasterBean objBudgetReportBean) throws Exception {
		AccountHeadMasterResultBean objPendingapprovalResultBean = new AccountHeadMasterResultBean();
		objPendingapprovalResultBean.setSearchList(accountHeadMasterService.searchportDtl(objBudgetReportBean));
		objPendingapprovalResultBean.setSuccess(true);
		return objPendingapprovalResultBean;
	}

	@RequestMapping(value = "/ExportExcel", method = RequestMethod.POST)
	public @ResponseBody AccountHeadMasterResultBean getExcelReportExportList(@RequestBody AccountHeadMasterBean objPendingapprovalBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		AccountHeadMasterResultBean objPendingapprovalResultBean = new AccountHeadMasterResultBean();
		List<AccountHeadMasterBean> lQuotationBean = new ArrayList<>();

		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			System.out.println("List Of  fee excel");
			// quotationResultBean.setlQuotationBean(ObjPendingapprovalService.getList(objPendingapprovalBean));
			// objPendingapprovalResultBean.setlAccountHeadMasterBeanBean(accountHeadMasterService.getAcctHeadMasterList(limit,
			// offset));
			objPendingapprovalResultBean.setSearchList(accountHeadMasterService.searchportDtl(objPendingapprovalBean));

			accountHeadMasterService.excellExport(objPendingapprovalResultBean, objPendingapprovalBean, ConfigurationProps.exportFilesPath);

			objPendingapprovalResultBean.setSuccess(true);
		} catch (Exception e) {
			System.out.println(e);

		}
		return objPendingapprovalResultBean;
	}

	@RequestMapping("/getSubGroup")
	public @ResponseBody AccountHeadMasterResultBean getSubGroupHeads() throws CustomException {
		AccountHeadMasterResultBean sGroupHead = null;
		try {
			sGroupHead = accountHeadMasterService.getSubGroupHead();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sGroupHead;
	}

	@RequestMapping("/getCurrencyList")
	public @ResponseBody AccountHeadMasterResultBean getCurrencyList() throws CustomException {
		AccountHeadMasterResultBean sGroupHead = null;
		try {
			sGroupHead = accountHeadMasterService.getCurrencyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sGroupHead;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteSubGroupAcct(@RequestBody String subGrpAcctCode) throws Exception {
		boolean isDeleted = false;
		isDeleted = accountHeadMasterService.deleteAcctHeadMaster(subGrpAcctCode);
		return isDeleted;
	}

	@RequestMapping("/getAttributeList")
	public @ResponseBody AccountHeadMasterBean getAttributeList() throws Exception {
		AccountHeadMasterBean objAccountHeadMasterBean = new AccountHeadMasterBean();
		objAccountHeadMasterBean.setlAttributeList(accountHeadMasterService.getAttributeList());
		return objAccountHeadMasterBean;
	}

	@RequestMapping("/getSubgroupAttributeMapping")
	public @ResponseBody List<String> getSubgroupAttributeMapping(@RequestBody String subGrpAcctCode) throws Exception {
		AccountHeadMasterBean objAccountHeadMasterBean = new AccountHeadMasterBean();
		List<String> lAttributeList = accountHeadMasterService.getSGAttributeList(subGrpAcctCode);
		return lAttributeList;
	}

	@RequestMapping("/validate")
	public @ResponseBody AccountHeadMasterResultBean getvalidate(@RequestBody AccountHeadMasterBean objAccountHeadMasterBean) throws CustomException {
		AccountHeadMasterResultBean sGroupHead = null;
		try {
			String accountHeadName = objAccountHeadMasterBean.getAccountHeadName();
			boolean edit = objAccountHeadMasterBean.isEdit();
			String accountHeadCode = objAccountHeadMasterBean.getAccountHeadCode();

			sGroupHead = accountHeadMasterService.getvalidate(accountHeadName, edit, accountHeadCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sGroupHead;
	}

}
