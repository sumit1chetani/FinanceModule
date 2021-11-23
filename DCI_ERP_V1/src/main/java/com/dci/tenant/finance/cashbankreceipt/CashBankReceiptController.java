package com.dci.tenant.finance.cashbankreceipt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;

@RestController
@RequestMapping(value = "app/cashbankreceipt")
public class CashBankReceiptController {
	private final static Logger LOGGER = LoggerFactory.getLogger(CashBankReceiptController.class);

	@Autowired
	private CashBankReceiptService cashBankReceiptService;

	@RequestMapping("/getCompanyListWithUser")
	public @ResponseBody CashBankReceiptResultBean getCompanyListWithUser() throws CustomException {
		CashBankReceiptResultBean lCompanyWithUserList = new CashBankReceiptResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		try {
			lCompanyWithUserList = cashBankReceiptService.getCompanyListWithUser(userId, companyCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lCompanyWithUserList;
	}

	@RequestMapping("/getBankDrpDwn")
	public @ResponseBody CashBankReceiptResultBean getBankDrpDwn() throws CustomException {
		CashBankReceiptResultBean lgetBankList = new CashBankReceiptResultBean();
		try {
			lgetBankList = cashBankReceiptService.getBankDrpDwn();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lgetBankList;
	}

	@RequestMapping("/getCashDrpDwn")
	public @ResponseBody CashBankReceiptResultBean getCashDrpDwn() throws CustomException {
		CashBankReceiptResultBean lgetCashList = new CashBankReceiptResultBean();
		try {
			lgetCashList = cashBankReceiptService.getCashDrpDwn();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lgetCashList;
	}

	@RequestMapping("/getCurrencyAndExchangeRate")
	public @ResponseBody CashBankReceiptResultBean getCurrencyAndExchangeRate(@RequestBody String accountNo) throws CustomException {
		CashBankReceiptResultBean lgetCurrList = new CashBankReceiptResultBean();
		try {
			lgetCurrList = cashBankReceiptService.getCurrencyAndExchangeRate(accountNo);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lgetCurrList;
	}

	@RequestMapping("/getReceivedFromList")
	public @ResponseBody List<CashBankReceiptListBean> getReceivedFromList() {
		List<CashBankReceiptListBean> lReceivedFromList = null;
		lReceivedFromList = cashBankReceiptService.getReceivedFromList();

		return lReceivedFromList;
	}

	@RequestMapping("/cbrList")
	public @ResponseBody CashBankReceiptResultBean getCashBankReceiptHdrList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		CashBankReceiptResultBean objCashBankReceiptResultBean = new CashBankReceiptResultBean();
		try {

			objCashBankReceiptResultBean.setlCashbankReceiptListBean(cashBankReceiptService.getCashBankReceiptHdrList(limit, offset));
			objCashBankReceiptResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objCashBankReceiptResultBean;
	}

	@RequestMapping("/saveCashBankReceiptData")
	public @ResponseBody boolean saveCBRHeader(@RequestBody CashBankReceiptListBean objCashBankReceiptListBean) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		boolean isAdded = false;
		try {
			isAdded = cashBankReceiptService.addCashBankReceiptHdr(objCashBankReceiptListBean, userId, companyCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return isAdded;
	}

	@RequestMapping("/updateCashBankReceiptData")
	public @ResponseBody boolean updateCashBankReceiptData(@RequestBody CashBankReceiptListBean objCashBankReceiptListBean) throws Exception {
		boolean isUpdated = false;
		try {
			isUpdated = cashBankReceiptService.updateCashBankReceiptData(objCashBankReceiptListBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return isUpdated;
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody boolean deleteCBRcptData(@RequestBody String voucherNo) throws CustomException {

		boolean isSuccess = false;
		try {
			isSuccess = cashBankReceiptService.deleteCBReceiptData(voucherNo);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping(value = "/getReceiptVoucherDetailforEdit")
	public @ResponseBody CashBankReceiptListBean getReceiptVoucherDetailforEdit(@RequestParam("voucherNo") String voucherNo) throws CustomException {
		CashBankReceiptListBean objCashBankReceiptListBean = new CashBankReceiptListBean();
		try {
			objCashBankReceiptListBean = cashBankReceiptService.getReceiptVoucherDetailforEdit(voucherNo);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCashBankReceiptListBean;
	}

	@RequestMapping("/getPendingInvoiceDetails")
	public @ResponseBody CashBankReceiptDetailBean getPendingInvoiceDetails(@RequestParam("customerCode") String customerCode) {
		CashBankReceiptDetailBean objCashBankRcptBean = new CashBankReceiptDetailBean();
		try {
			objCashBankRcptBean = cashBankReceiptService.getPendingInvoiceDetails(customerCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objCashBankRcptBean;
	}

	@RequestMapping("/reverseReceipt")
	public @ResponseBody CashBankReceiptResultBean reverseReceipt(@RequestParam("receiptVoucherNo") String receiptVoucherNo, @RequestParam("createdDate") String createdDate) throws Exception {
		CashBankReceiptResultBean objCashBankReceiptResultBean = new CashBankReceiptResultBean();
		boolean isSuccess = false;
		String sErrorMessage = "";
		try {
			sErrorMessage = cashBankReceiptService.reverseReceipt(receiptVoucherNo, createdDate);
			isSuccess = true;
			objCashBankReceiptResultBean.setsErrorMessage(sErrorMessage);
			objCashBankReceiptResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			sErrorMessage = "Error.Please try again later!..";
			isSuccess = false;
			objCashBankReceiptResultBean.setsErrorMessage(sErrorMessage);
			objCashBankReceiptResultBean.setSuccess(isSuccess);
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return objCashBankReceiptResultBean;
	}

	@RequestMapping("/print")
	public ModelAndView printPaymentVoucher(@RequestParam("voucherNo") String voucherNo) throws Exception {
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		obj = new ModelAndView("finance/transaction/print/printCBReceiptVoucher");

		CashBankReceiptListBean objCashBankReceiptBean = new CashBankReceiptListBean();

		objCashBankReceiptBean = cashBankReceiptService.getReceiptVoucherforView(voucherNo);

		obj.addObject("receiptVoucherList", objCashBankReceiptBean);

		obj.addObject("userName", userName);

		return obj;
	}

	@RequestMapping("/printoff")
	public ModelAndView printPaymentVoucheroff(@RequestParam("voucherNo") String voucherNo) throws Exception {
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		obj = new ModelAndView("print/printCBReceiptVoucheroff");

		CashBankReceiptListBean objCashBankReceiptBean = new CashBankReceiptListBean();

		objCashBankReceiptBean = cashBankReceiptService.getReceiptVoucherforView(voucherNo);

		obj.addObject("receiptVoucherList", objCashBankReceiptBean);

		obj.addObject("userName", userName);

		return obj;
	}
	

	
	@RequestMapping("/payerReceipt")
	public ModelAndView PayerReceiptVoucher(@RequestParam("voucherNo") String voucherNo) throws Exception {
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		obj = new ModelAndView("finance/transaction/print/payerPrintCBReceiptVoucher");

		CashBankReceiptListBean objCashBankReceiptBean = new CashBankReceiptListBean();

		objCashBankReceiptBean = cashBankReceiptService.getReceiptVoucherforView1(voucherNo);

		obj.addObject("receiptVoucherList", objCashBankReceiptBean);

		obj.addObject("userName", userName);

		return obj;
	}	
	
	
	@RequestMapping("/GetvoucherNo")
	public @ResponseBody CashBankReceiptResultBean getReceiptNo(@RequestParam("pmtype") String pmtype, @RequestParam("cbReceiptDate") String cbReceiptDate) throws CustomException {
		CashBankReceiptResultBean objCashBankReceiptListBean= null;	
		try {
			objCashBankReceiptListBean = cashBankReceiptService.getReceiptNo(pmtype,cbReceiptDate);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objCashBankReceiptListBean;
	}


}
