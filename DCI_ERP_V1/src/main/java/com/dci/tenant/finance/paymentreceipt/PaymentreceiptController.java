package com.dci.tenant.finance.paymentreceipt;

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
@RequestMapping(value = "app/paymentreceipt")
public class PaymentreceiptController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PaymentreceiptController.class);

	@Autowired
	private PaymentreceiptService paymentreceiptService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean addAcctHead(@RequestBody PaymentreceiptMasterBean objAccountHeadMasterBean) throws CustomException {
		String userId = "E0001";
		boolean isSuccess = false;
		PaymentreceiptResultBean objAccountHeadMasterResultBean = new PaymentreceiptResultBean();
		try {
			isSuccess = paymentreceiptService.addAcctHeadMaster(objAccountHeadMasterBean, userId);
			objAccountHeadMasterResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/edit")
	public @ResponseBody PaymentreceiptMasterBean editAccountHeadValues(@RequestParam("accountCode") String accountCode) throws CustomException {
		PaymentreceiptMasterBean objAccountHeadMasterBean = new PaymentreceiptMasterBean();
		try {
			objAccountHeadMasterBean = paymentreceiptService.getAccountHeadValues(accountCode);
			objAccountHeadMasterBean.setEdit(true);
		} catch (Exception e) {
			objAccountHeadMasterBean.setEdit(false);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objAccountHeadMasterBean;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateAcctHead(@RequestBody PaymentreceiptMasterBean objAccountHeadMasterBean) throws CustomException {
		boolean isSuccess = false;
		PaymentreceiptResultBean objAccountHeadMasterResultBean = new PaymentreceiptResultBean();
		try {
			isSuccess = paymentreceiptService.updateAcctHeadMaster(objAccountHeadMasterBean);
			objAccountHeadMasterResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/list")
	public @ResponseBody PaymentreceiptResultBean getAcctHeadList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		PaymentreceiptResultBean objAccountHeadMasterResultBean = new PaymentreceiptResultBean();
		try {
			objAccountHeadMasterResultBean.setlAccountHeadMasterBeanBean(paymentreceiptService.getAcctHeadMasterList(limit, offset));
			objAccountHeadMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objAccountHeadMasterResultBean;
	}

	@RequestMapping(value = "/searchlist", method = RequestMethod.POST)
	public @ResponseBody PaymentreceiptResultBean searchportDtl(@RequestBody PaymentreceiptMasterBean objBudgetReportBean) throws Exception {
		PaymentreceiptResultBean objPendingapprovalResultBean = new PaymentreceiptResultBean();
		objPendingapprovalResultBean.setSearchList(paymentreceiptService.searchportDtl(objBudgetReportBean));
		objPendingapprovalResultBean.setSuccess(true);
		return objPendingapprovalResultBean;
	}

	@RequestMapping(value = "/ExportExcel", method = RequestMethod.POST)
	public @ResponseBody PaymentreceiptResultBean getExcelReportExportList(@RequestBody PaymentreceiptMasterBean objPendingapprovalBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		PaymentreceiptResultBean objPendingapprovalResultBean = new PaymentreceiptResultBean();
		List<PaymentreceiptMasterBean> lQuotationBean = new ArrayList<>();

		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			System.out.println("List Of  fee excel");
			// quotationResultBean.setlQuotationBean(ObjPendingapprovalService.getList(objPendingapprovalBean));
			// objPendingapprovalResultBean.setlAccountHeadMasterBeanBean(accountHeadMasterService.getAcctHeadMasterList(limit,
			// offset));
			objPendingapprovalResultBean.setSearchList(paymentreceiptService.searchportDtl(objPendingapprovalBean));

			paymentreceiptService.excellExport(objPendingapprovalResultBean, objPendingapprovalBean, ConfigurationProps.exportFilesPath);

			objPendingapprovalResultBean.setSuccess(true);
		} catch (Exception e) {
			System.out.println(e);

		}
		return objPendingapprovalResultBean;
	}

	@RequestMapping("/getSubGroup")
	public @ResponseBody PaymentreceiptResultBean getSubGroupHeads() throws CustomException {
		PaymentreceiptResultBean sGroupHead = null;
		try {
			sGroupHead = paymentreceiptService.getSubGroupHead();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sGroupHead;
	}

	@RequestMapping("/getCurrencyList")
	public @ResponseBody PaymentreceiptResultBean getCurrencyList() throws CustomException {
		PaymentreceiptResultBean sGroupHead = null;
		try {
			sGroupHead = paymentreceiptService.getCurrencyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sGroupHead;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteSubGroupAcct(@RequestBody String subGrpAcctCode) throws Exception {
		boolean isDeleted = false;
		isDeleted = paymentreceiptService.deleteAcctHeadMaster(subGrpAcctCode);
		return isDeleted;
	}

	@RequestMapping("/getAttributeList")
	public @ResponseBody PaymentreceiptMasterBean getAttributeList() throws Exception {
		PaymentreceiptMasterBean objAccountHeadMasterBean = new PaymentreceiptMasterBean();
		objAccountHeadMasterBean.setlAttributeList(paymentreceiptService.getAttributeList());
		return objAccountHeadMasterBean;
	}

	@RequestMapping("/getSubgroupAttributeMapping")
	public @ResponseBody List<String> getSubgroupAttributeMapping(@RequestBody String subGrpAcctCode) throws Exception {
		PaymentreceiptMasterBean objAccountHeadMasterBean = new PaymentreceiptMasterBean();
		List<String> lAttributeList = paymentreceiptService.getSGAttributeList(subGrpAcctCode);
		return lAttributeList;
	}

	@RequestMapping("/validate")
	public @ResponseBody PaymentreceiptResultBean getvalidate(@RequestBody PaymentreceiptMasterBean objAccountHeadMasterBean) throws CustomException {
		PaymentreceiptResultBean sGroupHead = null;
		try {
			String accountHeadName = objAccountHeadMasterBean.getSubGroupAccountCode();
			boolean edit = objAccountHeadMasterBean.isEdit();
			String accountHeadCode = objAccountHeadMasterBean.getAccountHeadCode();

			sGroupHead = paymentreceiptService.getvalidate(accountHeadName, edit, accountHeadCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sGroupHead;
	}

}
