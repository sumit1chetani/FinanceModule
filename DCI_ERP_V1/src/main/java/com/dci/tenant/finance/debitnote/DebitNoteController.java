package com.dci.tenant.finance.debitnote;

import java.util.ArrayList;
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

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;

@Controller
@RequestMapping(value = "app/debitnote")
public class DebitNoteController {

	private final static Logger LOGGER = LoggerFactory.getLogger(DebitNoteController.class);

	@Autowired
	private DebitNoteService debitNoteService;

	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public @ResponseBody DebitNoteResultBean getDebitNoteList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		DebitNoteResultBean objDebitNoteResultBean = new DebitNoteResultBean();

		if (offset < 5000) {
			try {
				objDebitNoteResultBean.setlDebitNoteBean(debitNoteService.getDebitNoteList(limit, offset));
				objDebitNoteResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objDebitNoteResultBean;
	}

	@RequestMapping("/debitCodelist")
	public @ResponseBody List<SelectivityBean> getDebitNoteList() throws CustomException, InterruptedException {
		List<SelectivityBean> list = new ArrayList<>();

		try {
			list = debitNoteService.getDebitNoteCodeList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return list;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteDebitNote(@RequestBody String debitNoteNo) throws Exception {
		boolean isDeleted = false;
		isDeleted = debitNoteService.deleteDebitNote(debitNoteNo);
		return isDeleted;
	}

	@RequestMapping("/save")
	public @ResponseBody boolean saveDebitNoteData(@RequestBody DebitNoteBean objDebitNoteBean) throws CustomException {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		try {
			isSuccess = debitNoteService.saveDebitNoteData(objDebitNoteBean, userId, companyCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	@RequestMapping("/getDebitNoteForEdit")
	public @ResponseBody DebitNoteBean getDebitNoteForEdit(@RequestParam("debitCode") String debitCode) throws CustomException {
		DebitNoteBean debitNoteBean = new DebitNoteBean();
		try {
			debitNoteBean = debitNoteService.getDebitNoteForEdit(debitCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return debitNoteBean;
	}

	@RequestMapping("/update")
	public @ResponseBody boolean updateDebitAcct(@RequestBody DebitNoteBean objDebitNoteBean) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		boolean isSuccess = false;
		try {
			isSuccess = debitNoteService.updateDebitAcct(objDebitNoteBean, userId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/reverseDebit")
	public @ResponseBody DebitNoteResultBean reverseDebit(@RequestParam("debitCode") String debitCode, @RequestParam("createdDate") String createdDate) {
		DebitNoteResultBean objDebitNoteResultBean = new DebitNoteResultBean();
		try {
			objDebitNoteResultBean.setMessage(debitNoteService.reversePayment(debitCode, createdDate));
			objDebitNoteResultBean.setSuccess(true);

		} catch (Exception e) {
			objDebitNoteResultBean.setSuccess(false);
			LOGGER.error("Error", e);
		}
		return objDebitNoteResultBean;
	}
}
