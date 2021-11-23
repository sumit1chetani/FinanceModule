package com.dci.tenant.finance.creditnote;

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

import com.dci.common.util.CustomException;
import com.dci.tenant.finance.journalvoucher.JournalVoucherResultBean;
import com.dci.tenant.user.UserDetail;

/**
 * This class Dispatches the user's action according to the Controller he/she
 * wants to perform for example the action may be get,add,update,delete and so
 * on.
 * 
 * @author raghavan
 * @version 1.0
 * @revision 12-June-2015; Created
 */

@RestController
@RequestMapping(value = "app/creditNote")
public class CreditNoteController {

	private final static Logger LOGGER = LoggerFactory.getLogger(CreditNoteController.class);

	@Autowired
	private CreditNoteService objCreditNoteService;

	@SuppressWarnings("unchecked")
	@RequestMapping("/getAcctHeadCombo")
	public @ResponseBody List<CreditNoteBean> getAcctHeadComboList() {
		List<CreditNoteBean> lAcctHeadList = null;
		lAcctHeadList = objCreditNoteService.getAcctHeadComboList();

		return lAcctHeadList;
	}

	@RequestMapping("/getInvoiceNo")
	public @ResponseBody List<CreditNoteBean> getInvoiceNo(@RequestParam("acctHeadCode") String sAcctHeadCode) {
		List<CreditNoteBean> lInvoiceNoList = null;
		lInvoiceNoList = objCreditNoteService.getInvoiceNoList(sAcctHeadCode);

		return lInvoiceNoList;
	}
                
	@RequestMapping("/cnlist")
	public @ResponseBody CreditNoteResultBean getCreditNoteHeaderList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		CreditNoteResultBean objCreditNoteResultBean = new CreditNoteResultBean();
		try {

			objCreditNoteResultBean.setlCreditNoteBean(objCreditNoteService.getCreditNoteList(limit, offset));
			objCreditNoteResultBean.setReverseList(objCreditNoteService.reverseList());

			objCreditNoteResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objCreditNoteResultBean;
	}

	@RequestMapping("/save")
	public @ResponseBody boolean saveCRData(@RequestBody CreditNoteBean objCreditNoteBean) throws CustomException {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		boolean isSuccess = false;
		try {
			isSuccess = objCreditNoteService.saveCRData(objCreditNoteBean, userId, companyCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/approveCreditNote")
	public @ResponseBody String approveCreditNoteData(@RequestParam("creditnoteCodes") String creditnoteCode, @RequestParam("creditnoteStatus") String creditNoteStatus) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		boolean isSuccess = false;
		String response = "";
		try {
			isSuccess = objCreditNoteService.approveCreditNoteData(creditnoteCode, creditNoteStatus, userId);
			if (isSuccess) {
				response = "true";
			} else {
				response = "false";
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return response;
	}

	@RequestMapping("/getCreditNoteForEdit")
	public @ResponseBody CreditNoteBean getCreditNoteForEdit(@RequestParam("creditCode") String creditCode) throws CustomException {
		CreditNoteBean creditNoteBean = new CreditNoteBean();
		try {
			creditNoteBean = objCreditNoteService.getCreditNoteForEdit(creditCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return creditNoteBean;
	}

	@RequestMapping("/update")
	public @ResponseBody boolean updateCRData(@RequestBody CreditNoteBean objCreditNoteBean) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		boolean isSuccess = false;
		try {
			isSuccess = objCreditNoteService.updateCRData(objCreditNoteBean, userId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteCreditNote(@RequestBody String creditCode) throws Exception {
		boolean isDeleted = false;
		isDeleted = objCreditNoteService.deleteCreditNote(creditCode);
		return isDeleted;
	}

	@RequestMapping("/reverseCN")
	public @ResponseBody JournalVoucherResultBean reverseJV(@RequestParam("creditNoteNo") String creditNoteNo, @RequestParam("createdDate") String createdDate) throws Exception {
		JournalVoucherResultBean objCashBankPaymentResultBean = new JournalVoucherResultBean();
		try {
			objCashBankPaymentResultBean.setMessage(objCreditNoteService.reversePayment(creditNoteNo, createdDate));
			objCashBankPaymentResultBean.setSuccess(true);

		} catch (Exception e) {
			objCashBankPaymentResultBean.setSuccess(false);
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}
}
