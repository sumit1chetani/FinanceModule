package com.dci.tenant.finance.journalvoucher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping(value = "app/journalVoucher")	
public class JournalVoucherController {

	private final static Logger LOGGER = LoggerFactory.getLogger(JournalVoucherController.class);

	@Autowired
	private JournalVoucherService objJournalService;

	@RequestMapping("/getlist")
	public @ResponseBody JournalVoucherResultBean getJournalVoucherList(@RequestBody JournalVoucherBean journalVoucherBean) throws CustomException {
		JournalVoucherResultBean objJournalVoucherResultBean = new JournalVoucherResultBean();
		try {
			objJournalVoucherResultBean.setlJournalVoucherBeanDTO(objJournalService.getJournalVoucherList(journalVoucherBean));
			objJournalVoucherResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objJournalVoucherResultBean;
	}
	
	//other than vendor and customer
	@RequestMapping("/getAllLedger")
	public @ResponseBody List<JournalVoucherDTO> getAllLedgerList()throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getLedgerList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}

	@RequestMapping("/getAccountHeadList")
	public @ResponseBody List<JournalVoucherDTO> getAccountHeadList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getAccountHeadList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}
	
	
	
	@RequestMapping("/getAccountNewHeadList")
	public @ResponseBody List<JournalVoucherDTO> getAccountHeadNewList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			 alAccountCodeList = objJournalService.getAccountHeadNewList();
			//alAccountCodeList = objJournalService.getAccountHeadList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}

	
	@RequestMapping("/getAccountNewPayHeadList")
	public @ResponseBody List<JournalVoucherDTO> getAccountHeadPayList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			//alAccountCodeList = objJournalService.getAccountHeadList();
			alAccountCodeList = objJournalService.getAccountHeadPayList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}
	
	@RequestMapping("/getSubAcctHeadList")
	public @ResponseBody List<JournalVoucherDTO> getSubAcctHeadList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getSubAcctHeadList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}
	
	//vendor
	@RequestMapping("/getvendorList")
	public @ResponseBody List<JournalVoucherDTO> getvendorList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getvendorList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}
	
	
	@RequestMapping("/getvendorotherList")
	public @ResponseBody List<JournalVoucherDTO> getcpotherList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getcpotherList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}
	
	
	
	
	
	// vendor/customer
	@RequestMapping("/getvendorothercuList")
	public @ResponseBody List<JournalVoucherDTO> getcpothercusList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getcpothercusList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}
	
	
	
//college or costumer
	@RequestMapping("/getSubcollHeadList")
	public @ResponseBody List<JournalVoucherDTO> getSubcollHeadList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getSubcollHeadList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}

	//others
		@RequestMapping("/getSubotherHeadList")
		public @ResponseBody List<JournalVoucherDTO> getSubotherHeadList() throws CustomException {
			List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
			try {
				alAccountCodeList = objJournalService.getSubotherHeadList();
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
			return alAccountCodeList;
		}
	
	@RequestMapping("/getSubAcctHeadVendorList")
	public @ResponseBody List<JournalVoucherDTO> getSubAcctHeadVendorList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getSubAcctHeadVendorList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}

	@RequestMapping("/getCompanyList")
	public @ResponseBody List<JournalVoucherDTO> getCompanyList() throws CustomException {
		List<JournalVoucherDTO> alCompanyList = new ArrayList<>();
		try {
			alCompanyList = objJournalService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alCompanyList;
	}

	@RequestMapping("/getCurrencyList")
	public @ResponseBody List<JournalVoucherDTO> getCurrencyList() throws CustomException {
		List<JournalVoucherDTO> alCurrencyList = new ArrayList<>();
		try {
			alCurrencyList = objJournalService.getCurrencyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alCurrencyList;
	}
	
	//JVNumber
	@RequestMapping(value="/getjvNumber", produces="text/html")
	public @ResponseBody String getJournalVoucherNumber() throws CustomException {
		System.out.println("Journal voucher Number ============================== "+objJournalService.generateJournalVoucherNumber());		 
		return objJournalService.generateJournalVoucherNumber();
	}

	@RequestMapping(value = "/add")
	public @ResponseBody boolean addJournalVoucherInfo(@RequestBody JournalVoucherDTO objJournalVoucherData) throws CustomException, JsonParseException, JsonMappingException, IOException {
		boolean isAdded = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		try {
			isAdded = objJournalService.saveJournalVoucherData(objJournalVoucherData, userId, companyCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isAdded;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateJournalVoucherInfo(@RequestBody JournalVoucherDTO objJournalVoucherData) throws CustomException, JsonParseException, JsonMappingException, IOException {
		boolean isUpdated = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String companyCode = userDetails.getCompanyCode();
		try {
			isUpdated = objJournalService.updateJournalVoucherData(objJournalVoucherData, userId, companyCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isUpdated;
	}

	@RequestMapping("/deleteJournalVoucher")
	public @ResponseBody boolean deleteJournalVoucherInfo(@RequestBody String objJournalVoucherId) throws Exception {
		boolean isDeleted = false;
		isDeleted = objJournalService.deleteJournalVoucherInfo(objJournalVoucherId);
		return isDeleted;
	}

	@RequestMapping("/getJournalVoucherEditData")
	public @ResponseBody JournalVoucherDTO getJournalVoucherInfo(@RequestParam("jvNumber") String jvNumber) throws Exception {
		JournalVoucherDTO objJournalVoucherDTO = new JournalVoucherDTO();
		try {
			objJournalVoucherDTO = objJournalService.getJournalVoucherInfo(jvNumber);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objJournalVoucherDTO;
	}

	@RequestMapping("/print")
	public ModelAndView printJournalVoucher(@RequestParam("jvNumber") String jvNumber) throws Exception {
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		obj = new ModelAndView("finance/transaction/print/printJournalVoucher");

		JournalVoucherDTO objJournalVoucherBean = new JournalVoucherDTO();

		objJournalVoucherBean = objJournalService.getJournalVoucherforPrint(jvNumber);

		obj.addObject("journalVoucherList", objJournalVoucherBean);

		// obj.addObject("userName", objJournalVoucherBean.getCreatedBy());

		return obj;
	}

	// ///////// bank company mapping/////////

	@RequestMapping("/getAccountHeadMapList")
	public @ResponseBody List<JournalVoucherDTO> getAccountHeadMapList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getAccountHeadMapList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}

	@RequestMapping("/getAccountHeadCashMapList")
	public @ResponseBody List<JournalVoucherDTO> getAccountHeadCashMapList() throws CustomException {
		List<JournalVoucherDTO> alAccountCodeList = new ArrayList<>();
		try {
			alAccountCodeList = objJournalService.getAccountHeadCashMapList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alAccountCodeList;
	}

	@RequestMapping(value = "/getJvCode", method = RequestMethod.GET)
	public @ResponseBody JournalVoucherResultBean getQuotation(@RequestParam String jvcode) throws CustomException {

		JournalVoucherResultBean jvResultBean = new JournalVoucherResultBean();
		try {
			jvResultBean.setlJournalVoucherBean(objJournalService.getjournalNo(jvcode));
			jvResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return jvResultBean;

	}

	@RequestMapping("/getloggedcompany")
	public @ResponseBody boolean getloggedcompany(@RequestParam("closingDate") String closingDate, @RequestParam("formCode") String formCode) throws CustomException {
		boolean checkDate;

		try {
			checkDate = objJournalService.getloggedcompany(closingDate, formCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return checkDate;
	}

	@RequestMapping("/reverseJV")
	public @ResponseBody JournalVoucherResultBean reverseJV(@RequestParam("voucherNo") String voucherNo, @RequestParam("createdDate") String createdDate) throws Exception {
		JournalVoucherResultBean objCashBankPaymentResultBean = new JournalVoucherResultBean();
		try {
			objCashBankPaymentResultBean.setMessage(objJournalService.reversePayment(voucherNo, createdDate));
			objCashBankPaymentResultBean.setSuccess(true);

		} catch (Exception e) {
			objCashBankPaymentResultBean.setSuccess(false);
			LOGGER.error("Error", e);
		}
		return objCashBankPaymentResultBean;
	}

}
