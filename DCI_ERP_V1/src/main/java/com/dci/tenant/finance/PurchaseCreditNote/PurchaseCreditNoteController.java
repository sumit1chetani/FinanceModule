package com.dci.tenant.finance.PurchaseCreditNote;

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
@RequestMapping(value = "app/purchasecreditnote")
public class PurchaseCreditNoteController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PurchaseCreditNoteController.class);

	@Autowired
	private PurchaseCreditNoteService objCreditNoteService;

	@SuppressWarnings("unchecked")
	@RequestMapping("/getAcctHeadCombo")
	public @ResponseBody List<PurchaseCreditNoteBean> getAcctHeadComboList() {
		List<PurchaseCreditNoteBean> lAcctHeadList = null;
		lAcctHeadList = objCreditNoteService.getAcctHeadComboList();

		return lAcctHeadList;
	}

	@RequestMapping("/getInvoiceNo")
	public @ResponseBody List<PurchaseCreditNoteBean> getInvoiceNo(@RequestParam("acctHeadCode") String sAcctHeadCode) {
		List<PurchaseCreditNoteBean> lInvoiceNoList = null;
		lInvoiceNoList = objCreditNoteService.getInvoiceNoList(sAcctHeadCode);

		return lInvoiceNoList;
	}

	@RequestMapping("/getSupplierCurExg")
	public @ResponseBody List<PurchaseCreditNoteBean> getSupplierCurExg(@RequestParam("acctHeadCode") String sAcctHeadCode) {
		List<PurchaseCreditNoteBean> lInvoiceNoList = null;
		lInvoiceNoList = objCreditNoteService.getSupplierCurExg(sAcctHeadCode);

		return lInvoiceNoList;
	}

	@RequestMapping("/cnlist")
	public @ResponseBody PurchaseCreditNoteResultBean getCreditNoteHeaderList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("formCode") String formCode) throws CustomException {
		PurchaseCreditNoteResultBean objCreditNoteResultBean = new PurchaseCreditNoteResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			String userId = userDetails.getUserId();
			String companyCode = userDetails.getCompanyCode();
			// System.out.println("companyCode" + companyCode);

			objCreditNoteResultBean.setlCreditNoteBean(objCreditNoteService.getCreditNoteList(limit, offset, formCode, userId));
			// objCreditNoteResultBean.setReverseList(objCreditNoteService.reverseList());
			objCreditNoteResultBean.setSuccess(true);
			objCreditNoteResultBean.setCompanyCode(companyCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		// System.out.println(new Date());
		return objCreditNoteResultBean;
	}

	@RequestMapping("/save")
	public PurchaseCreditNoteResultBean saveCRData(@RequestBody PurchaseCreditNoteBean objCreditNoteBean) throws CustomException {
		PurchaseCreditNoteResultBean objCreditNoteResultBean = new PurchaseCreditNoteResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			objCreditNoteResultBean.setlCreditNoteBean(objCreditNoteService.saveCRData(objCreditNoteBean, userId));
			objCreditNoteResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objCreditNoteResultBean;
	}

	@RequestMapping("/logindetail")
	public @ResponseBody UserDetail getLoginDetails() throws CustomException {
		UserDetail objDetail = new UserDetail();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			objDetail.setUserId(userDetails.getUserId());
			objDetail.setUsername(userDetails.getUsername());

			System.out.println("login details" + objDetail.getUserId());
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objDetail;
	}

	@RequestMapping("/approveCreditNote")
	public @ResponseBody boolean approveCreditNoteData(@RequestBody String creditnoteCode) throws CustomException {
		PurchaseCreditNoteResultBean objCreditNoteResultBean = new PurchaseCreditNoteResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		boolean isSuccess = false;
		String response = "";
		try {
			isSuccess = objCreditNoteService.approveCreditNoteData(creditnoteCode, userId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/approveCreditNoteSign")
	public @ResponseBody boolean approveCreditNoteSign(@RequestBody PurchaseCreditNoteBean creditNode) throws CustomException {
		PurchaseCreditNoteResultBean objCreditNoteResultBean = new PurchaseCreditNoteResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		boolean isSuccess = false;
		String response = "";
		try {
			// System.out.println(sClob);
			isSuccess = objCreditNoteService.approveCreditNoteSign(creditNode, userId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/getCreditNoteForEdit")
	public @ResponseBody PurchaseCreditNoteBean getCreditNoteForEdit(@RequestParam("creditCode") String creditCode) throws CustomException {
		PurchaseCreditNoteBean debitNoteBean = new PurchaseCreditNoteBean();
		try {
			debitNoteBean = objCreditNoteService.getCreditNoteForEdit(creditCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return debitNoteBean;
	}

	@RequestMapping("/getCreditNoteForView")
	public @ResponseBody PurchaseCreditNoteBean getCreditNoteForView(@RequestParam("creditCode") String creditCode) throws CustomException {
		PurchaseCreditNoteBean debitNoteBean = new PurchaseCreditNoteBean();
		try {
			debitNoteBean = objCreditNoteService.getCreditNoteForView(creditCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return debitNoteBean;
	}

	@RequestMapping("/update")
	public @ResponseBody boolean updateCRData(@RequestBody PurchaseCreditNoteBean objCreditNoteBean) throws CustomException {
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

	@RequestMapping("/print")
	public ModelAndView printCreditNote(@RequestParam("creditCode") String creditCode) throws Exception {
		ModelAndView obj = null;
		obj = new ModelAndView("finance/transaction/printPurchaseCreditNote");

		PurchaseCreditNoteBean purchaseCreditNoteBean = new PurchaseCreditNoteBean();
		PurchaseCreditNoteBean voyageVesselBean = new PurchaseCreditNoteBean();

		purchaseCreditNoteBean = objCreditNoteService.getCreditNoteForView(creditCode);
		// Invoice invoiceResultBean = new Invoice();
		// invoiceResultBean =
		// objCreditNoteService.printInvoice(purchaseCreditNoteBean.getCreditNoteCode(),
		// purchaseCreditNoteBean.getCompanyCode());
		// voyageVesselBean =
		// objCreditNoteService.getVesselVoyageDetail(purchaseCreditNoteBean.getInvoiceNo());
		// obj.addObject("creditNodeList", purchaseCreditNoteBean);
		// obj.addObject("companyList", invoiceResultBean);
		// obj.addObject("invoiceDeail", voyageVesselBean);

		return obj;
	}

	// Getting vessel and voyagename

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteCreditNote(@RequestBody String creditCode) throws Exception {
		boolean isDeleted = false;
		isDeleted = objCreditNoteService.deleteCreditNote(creditCode);
		return isDeleted;
	}

	@RequestMapping("/reversePCN")
	public @ResponseBody PurchaseCreditNoteResultBean reversePCN(@RequestBody PurchaseCreditNoteBean purchaseCreditNoteBean) throws Exception {
		PurchaseCreditNoteResultBean objCashBankReceiptResultBean = new PurchaseCreditNoteResultBean();
		boolean isSuccess = false;
		String sErrorMessage = "";
		try {
			sErrorMessage = objCreditNoteService.reversePCN(purchaseCreditNoteBean);
			if (sErrorMessage.equals("S")) {
				isSuccess = true;
				objCashBankReceiptResultBean.setsErrorMessage("Reversed successfully");
			} else {
				isSuccess = false;
				objCashBankReceiptResultBean.setsErrorMessage("PCN already reversed");
			}
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

}