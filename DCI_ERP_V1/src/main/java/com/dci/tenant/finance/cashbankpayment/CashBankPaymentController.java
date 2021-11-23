package com.dci.tenant.finance.cashbankpayment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.CustomException;
import com.dci.tenant.finance.cashbankreceipt.CashBankReceiptResultBean;
import com.dci.tenant.user.UserDetail;

@Controller
@RequestMapping(value = "app/cashbankPayment")
public class CashBankPaymentController {
	private final static Logger LOGGER = LoggerFactory.getLogger(CashBankPaymentController.class);

	@Autowired
	private CashBankPaymentService objCashBankPaymentService;

	@RequestMapping("/getBankAcctList")
	public @ResponseBody List<CashBankPaymentBean> getBankAcctList(@RequestParam("paymentType") String sPaymentType) {
		List<CashBankPaymentBean> lBankAcctList = null;

		lBankAcctList = objCashBankPaymentService.getBankAcctList(sPaymentType);

		return lBankAcctList;
	}

	@RequestMapping("/getBankAcctListcompany")
	public @ResponseBody List<CashBankPaymentBean> getBankAcctListcom(@RequestParam("companyName") String companyName) {
		List<CashBankPaymentBean> lBankAcctListcom = null;

		lBankAcctListcom = objCashBankPaymentService.getBankAcctListcom(companyName);

		return lBankAcctListcom;
	}

	@RequestMapping("/getBankAcctListcompanyNew")
	public @ResponseBody List<CashBankPaymentBean> getBankAcctListcompanyNew(@RequestParam("companyName") String companyName) {
		List<CashBankPaymentBean> lBankAcctListcom = null;

		lBankAcctListcom = objCashBankPaymentService.getBankAcctListcompanyNew(companyName);

		return lBankAcctListcom;
	}

	@RequestMapping("/getCashAcctListcompanyNew")
	public @ResponseBody List<CashBankPaymentBean> getCashAcctListcompanyNew(@RequestParam("companyName") String companyName) {
		List<CashBankPaymentBean> lBankAcctListcom = null;

		lBankAcctListcom = objCashBankPaymentService.getCashAcctListcompanyNew(companyName);

		return lBankAcctListcom;
	}

	@RequestMapping("/getsubacct")
	public @ResponseBody List<CashBankPaymentBean> getsubacct(@RequestParam("cbpdtlAccountHead") String cbpdtlAccountHead) {
		List<CashBankPaymentBean> lBankAcctListcom = null;

		lBankAcctListcom = objCashBankPaymentService.getsubacct(cbpdtlAccountHead);

		return lBankAcctListcom;
	}

	@RequestMapping("/getBankAcctListcompanycode")
	public @ResponseBody List<CashBankPaymentBean> getBankAcctListcompanycode(@RequestParam("companyCode") String companyCode) {
		List<CashBankPaymentBean> lBankAcctListcompany = null;

		lBankAcctListcompany = objCashBankPaymentService.getBankAcctListcompanycode(companyCode);

		return lBankAcctListcompany;
	}

	@RequestMapping("/subAccountCodeList")
	public @ResponseBody List<CashBankPaymentBean> subAccountCodeList() {
		List<CashBankPaymentBean> lBankAcctListcompany = null;

		lBankAcctListcompany = objCashBankPaymentService.subAccountCodeList();

		return lBankAcctListcompany;
	}

	@RequestMapping("/chequeList")
	public @ResponseBody List<CashBankPaymentBean> getChequeNoList(@RequestParam("accountName") String sAccountName) {
		List<CashBankPaymentBean> lChequeNumberList = null;

		lChequeNumberList = objCashBankPaymentService.getChequeNoList(sAccountName);

		return lChequeNumberList;
	}

	@RequestMapping("/chequeEditList")
	public @ResponseBody List<CashBankPaymentBean> getChequeNoEditList(@RequestBody CashBankPaymentBean bankPaymentBean) {
		List<CashBankPaymentBean> lChequeNumberList = null;

		lChequeNumberList = objCashBankPaymentService.getChequeNoEditList(bankPaymentBean);

		return lChequeNumberList;
	}

	@RequestMapping("/getExchangeRateWithCurrency")
	public @ResponseBody List<CashBankPaymentBean> getExchangeRateWithCurrency(@RequestParam("currencyCode") String sCurrencyCode) {
		List<CashBankPaymentBean> currExgRateList = null;
		currExgRateList = objCashBankPaymentService.getExchangeRateWithCurrency(sCurrencyCode);

		return currExgRateList;
	}

	@RequestMapping("/getPaidToList")
	public @ResponseBody List<CashBankPaymentBean> getPaidToList() {
		List<CashBankPaymentBean> lPaidToList = null;
		lPaidToList = objCashBankPaymentService.getPaidToList();

		return lPaidToList;
	}

	@RequestMapping("/getPmtOrderNoList")
	public @ResponseBody List<CashBankPaymentBean> getPaymentOrderNoList() {
		List<CashBankPaymentBean> lPmtOrdList = null;
		lPmtOrdList = objCashBankPaymentService.getPaymentOrderNoList();

		return lPmtOrdList;
	}

	@RequestMapping("/getVoyageList")
	public @ResponseBody List<CashBankPaymentBean> getVoyageList() {
		List<CashBankPaymentBean> voyageList = null;
		voyageList = objCashBankPaymentService.getVoyageList();

		return voyageList;
	}

	@RequestMapping("/getAttributeListWithAccountCode")
	public @ResponseBody List<CashBankPaymentBean> getAttributeListWithAccountCode(@RequestParam("accountCode") String accountCode) {
		List<CashBankPaymentBean> attributeList = null;
		attributeList = objCashBankPaymentService.getAttributeListWithAccountCode(accountCode);

		return attributeList;
	}

	@RequestMapping("/cbplist")
	public @ResponseBody CashBankPaymentResultBean getCashBankPaymentHdrList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			objCashBankPaymentResultBean.setlCashbankpaymentBean(objCashBankPaymentService.getCashBankPaymentHdrList(limit, offset));
			objCashBankPaymentResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/save")
	public @ResponseBody CashBankPaymentResultBean saveCashBankPayment(@RequestBody CashBankPaymentBean objCashBankPaymentBean) {
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		try { System.out.println("==== v====" +objCashBankPaymentBean.getCbVoucherNo());
			objCashBankPaymentResultBean.setlCashbankpaymentBean(objCashBankPaymentService.saveCashBankPmtData(objCashBankPaymentBean, userId, companyCode));
			objCashBankPaymentResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/getPaymentVoucherDetailforEdit")
	public @ResponseBody CashBankPaymentBean getPaymentVoucherDetailforEdit(@RequestParam("voucherNo") String sVoucherNo) {
		CashBankPaymentBean objCashBankPaymentBean = new CashBankPaymentBean();
		try {
			objCashBankPaymentBean = objCashBankPaymentService.getPaymentVoucherDetailforEdit(sVoucherNo);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentBean;
	}

	@RequestMapping("/getPendingInvoiceDetails")
	public @ResponseBody CashBankPaymentDetailBean getPendingInvoiceDetails(@RequestParam("supplierCode") String supplierCode) {
		CashBankPaymentDetailBean objCashBankPaymentBean = new CashBankPaymentDetailBean();
		try {
			objCashBankPaymentBean = objCashBankPaymentService.getPendingInvoiceDetails(supplierCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentBean;
	}

	@RequestMapping("/update")
	public @ResponseBody CashBankPaymentResultBean updateCashBankPayment(@RequestBody CashBankPaymentBean objCashBankPaymentBean) {
		boolean isSucess = false;
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			isSucess = objCashBankPaymentService.updateCashBankPayment(objCashBankPaymentBean);
			objCashBankPaymentResultBean.setSuccess(isSucess);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteCashBankPayment(@RequestBody String voucherNo) {
		boolean isSucess = false;
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			isSucess = objCashBankPaymentService.deleteCashBankPayment(voucherNo);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSucess;
	}

	@RequestMapping("/getPendingPaymentRptInvoiceDetails")
	public @ResponseBody CashBankPaymentResultBean getPendingPaymentRptInvoiceDetails(@RequestParam("supplierCode") String supplierCode) {
		CashBankPaymentResultBean objCashBankPaymentBean = new CashBankPaymentResultBean();
		try {
			objCashBankPaymentBean = objCashBankPaymentService.getPendingPaymentRptInvoiceDetails(supplierCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentBean;
	}

	@RequestMapping("/pendingPayment1stLevelList")
	public @ResponseBody CashBankPaymentResultBean pendingPayment1stLevelList() throws CustomException {
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();

		try {
			objCashBankPaymentResultBean.setlPendingPaymentReportBean(objCashBankPaymentService.pendingPayment1stLevelList());
			objCashBankPaymentResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/getPendingPaymentReportDtl")
	public @ResponseBody CashBankPaymentResultBean getPendingPaymentReportDtlList(@RequestBody String voucherNo) throws CustomException {
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			objCashBankPaymentResultBean.setlPendingPaymentReportDtlBean(objCashBankPaymentService.getPendingPaymentReportDtlList(voucherNo));
			objCashBankPaymentResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/getPendingPaymentReportInvoiceDtl")
	public @ResponseBody CashBankPaymentResultBean getPendingPaymentReportInvoiceDtl(@RequestBody int pmtDtlId) throws CustomException {
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			objCashBankPaymentResultBean.setlPendingPaymentReportInvoiceDtlBean(objCashBankPaymentService.getPendingPaymentReportInvoiceDtl(pmtDtlId));
			objCashBankPaymentResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/paymentHistory1stLevelList")
	public @ResponseBody CashBankPaymentResultBean getPaymentHistory1stLevelList() throws CustomException {
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();

		try {
			objCashBankPaymentResultBean.setlPaymentHistoryReportBean(objCashBankPaymentService.getPaymentHistory1stLevelList());
			objCashBankPaymentResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/getPaymentHistoryReportDtl")
	public @ResponseBody CashBankPaymentResultBean getPaymentHistoryReportDtlList(@RequestBody String invoiceNo) throws CustomException {
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			objCashBankPaymentResultBean.setlPaymentHistoryReportDtlBean(objCashBankPaymentService.getPaymentHistoryReportDtlList(invoiceNo));
			objCashBankPaymentResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/getPaymentHistoryInvoiceDtl")
	public @ResponseBody CashBankPaymentResultBean getPaymentHistoryInvoiceDtlList(@RequestBody int pmtDtlId) throws CustomException {
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			objCashBankPaymentResultBean.setlPaymentHistoryReportInvoiceDtlBean(objCashBankPaymentService.getPaymentHistoryInvoiceDtlList(pmtDtlId));
			objCashBankPaymentResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/reversePayment")
	public @ResponseBody CashBankPaymentResultBean reversePayment(@RequestParam("voucherNo") String voucherNo, @RequestParam("createdDate") String createdDate) {
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			objCashBankPaymentResultBean.setMessage(objCashBankPaymentService.reversePayment(voucherNo, createdDate));
			objCashBankPaymentResultBean.setSuccess(true);

		} catch (Exception e) {
			objCashBankPaymentResultBean.setSuccess(false);
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/validateBudget")
	public @ResponseBody CashBankPaymentResultBean validateBudget(@RequestBody CashBankPaymentBean objCashBankPaymentBean) {
		String msg = "";
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			msg = objCashBankPaymentService.validateBudget(objCashBankPaymentBean);

			if (!"".equalsIgnoreCase(msg)) {
				objCashBankPaymentResultBean.setErrorMsg(msg);
				objCashBankPaymentResultBean.setSuccess(false);
			} else {
				objCashBankPaymentResultBean.setSuccess(true);
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/print")
	public ModelAndView printPaymentVoucher(@RequestParam("cbVoucherNo") String voucherNo) throws Exception {
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		obj = new ModelAndView("finance/transaction/print/printCBPaymentVoucher");
System.out.println("test");
		CashBankPaymentBean objCashBankPaymentBean = new CashBankPaymentBean();

		objCashBankPaymentBean = objCashBankPaymentService.printPaymentVoucher(voucherNo);

		obj.addObject("paymentVoucherList", objCashBankPaymentBean);
		obj.addObject("userName", userName);

		return obj;
	}

	@RequestMapping("/printoff")
	public ModelAndView printPaymentVoucheroff(@RequestParam("cbVoucherNo") String voucherNo) throws Exception {
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		obj = new ModelAndView("print/printCBPaymentVoucheroff");

		CashBankPaymentBean objCashBankPaymentBean = new CashBankPaymentBean();

		objCashBankPaymentBean = objCashBankPaymentService.printPaymentVoucher(voucherNo);

		obj.addObject("paymentVoucherList", objCashBankPaymentBean);
		obj.addObject("userName", userName);

		return obj;
	}

	@RequestMapping("/budgetdefnvalidation")
	public @ResponseBody CashBankPaymentResultBean budgetdefnvalidation(@RequestBody CashBankPaymentBean objCashBankPaymentBean) {
		String msg = "";
		CashBankPaymentResultBean objCashBankPaymentResultBean = new CashBankPaymentResultBean();
		try {
			objCashBankPaymentResultBean = objCashBankPaymentService.budgetdefnvalidation(objCashBankPaymentBean);

			// if (!"".equalsIgnoreCase(msg)) {
			// objCashBankPaymentResultBean.setErrorMsg(msg);
			// objCashBankPaymentResultBean.setSuccess(false);
			// } else {
			// objCashBankPaymentResultBean.setSuccess(true);
			// }

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

	@RequestMapping("/getBudgetValue")
	public @ResponseBody CashBankPaymentBean getBudgetValue(@RequestParam("costCenter") String costCenter, @RequestParam("budgetDefId") Integer budgetDefId) {
		CashBankPaymentBean lBankAcctList = new CashBankPaymentBean();

		lBankAcctList = objCashBankPaymentService.getBudgetValue(costCenter, budgetDefId);

		return lBankAcctList;
	}
	
	
	
	@RequestMapping("/GetvoucherNo")
	public @ResponseBody CashBankPaymentResultBean getReceiptNo(@RequestParam("pmtype") String pmtype, @RequestParam("cashbankPmtDate") String cashbankPmtDate , @RequestParam("accountName") String accountName) throws CustomException {
		CashBankPaymentResultBean objCashBankReceiptListBean= null;	
		try {
			objCashBankReceiptListBean = objCashBankPaymentService.getReceiptNo(pmtype,cashbankPmtDate,accountName);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objCashBankReceiptListBean;
	}
	
	
	@RequestMapping("/paymentList")
	public @ResponseBody List<CashBankPaymentBean> subPaymentList() {
		List<CashBankPaymentBean> lBankAcctListcompany = null;

		lBankAcctListcompany = objCashBankPaymentService.subPaymentList();

		return lBankAcctListcompany;
	}

	@RequestMapping("/receiptList")
	public @ResponseBody List<CashBankPaymentBean> receiptList() {
		List<CashBankPaymentBean> lBankAcctListcompany = null;

		lBankAcctListcompany = objCashBankPaymentService.receiptList();

		return lBankAcctListcompany;
	}
	
	
	
	@RequestMapping("/paymentreceiptList")
	public @ResponseBody List<CashBankPaymentBean> subPaymentreceiptList() {
		List<CashBankPaymentBean> lBankAcctListcompany = null;

		lBankAcctListcompany = objCashBankPaymentService.subPaymentreceiptList();

		return lBankAcctListcompany;
	}


	
}
