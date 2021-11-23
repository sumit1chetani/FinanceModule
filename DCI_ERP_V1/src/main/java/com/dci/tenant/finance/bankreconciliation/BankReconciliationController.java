package com.dci.tenant.finance.bankreconciliation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "app/bankReconciliation")
public class BankReconciliationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BankReconciliationController.class);

	private static final HttpServletRequest HttpServletRequest = null;

	@Autowired
	BankReconciliationService objBankReconciliationService;

	@RequestMapping("/getBankList")
	public @ResponseBody List<SelectivityBean> getBankList() throws Exception {

		List<SelectivityBean> lBankList = new ArrayList<>();
		try {
			lBankList = objBankReconciliationService.getBankList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lBankList;
	}

	@RequestMapping("/uploadfile")
	public @ResponseBody BasicResultBean uploadFile(MultipartFile file, @RequestParam("bankCode") String sBankCode) throws CustomException {
		BasicResultBean objBasicResultBean = new BasicResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					String sMessage = objBankReconciliationService.uploadFile(file, sBankCode);
					if (sMessage == "" || sMessage.isEmpty()) {
						objBasicResultBean.setSuccess(true);
						objBasicResultBean.setMessage("Uploaded Sucessfully");
					} else {
						objBasicResultBean.setMessage(sMessage);
					}
				} else {
					objBasicResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				objBasicResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return objBasicResultBean;
	}

	@RequestMapping("/checkStatementAvailablity")
	public @ResponseBody BasicResultBean checkStatementAvailablity(@RequestParam("fromDate") String sFromDate, @RequestParam("toDate") String sToDate, @RequestParam("bankCode") String sBankCode) throws CustomException {
		BasicResultBean objBasicResultBean = new BasicResultBean();
		try {
			boolean isAvailble = objBankReconciliationService.getStatementAvaiablity(sFromDate, sToDate, sBankCode);
			objBasicResultBean.setSuccess(isAvailble);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBasicResultBean;
	}

	@RequestMapping("/getDifferenceList")
	public @ResponseBody BankReconciliationResultBean getDiffernceList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("fromDate") String sFromDate, @RequestParam("toDate") String sToDate, @RequestParam("bankCode") String sBankCode) throws CustomException {
		BankReconciliationResultBean objBankReconciliationResultBean = new BankReconciliationResultBean();
		try {
			// objBankReconciliationResultBean.setlDifferenceResultList(objBankReconciliationService.getDifferenecList(limit,
			// offset, sFromDate, sToDate, sBankCode));
			objBankReconciliationResultBean = objBankReconciliationService.getDifferenecList(limit, offset, sFromDate, sToDate, sBankCode);

			objBankReconciliationResultBean.setSuccess(true);
		} catch (Exception e) {
			objBankReconciliationResultBean.setSuccess(false);
			e.printStackTrace();
		}

		return objBankReconciliationResultBean;

	}

	@RequestMapping("/reconcileRecords")

	public @ResponseBody BasicResultBean reconcileRecords(@RequestBody List<BankReconciliationBean> reconcileRecords) throws CustomException, ParseException {
		BasicResultBean objBasicResultBean = new BasicResultBean();
		System.out.println("inside reconcile");
		String message = objBankReconciliationService.reconcileRecords(reconcileRecords);
		objBasicResultBean.setMessage(message);
		if (message.equals("true"))
			objBasicResultBean.setSuccess(true);
		else
			objBasicResultBean.setSuccess(false);
		return objBasicResultBean;
	}

	@RequestMapping("/excludedrecords")

	public @ResponseBody BasicResultBean excludedRecords(@RequestBody BankReconciliationBean reconcileRecords) throws CustomException, ParseException {
		BasicResultBean objBasicResultBean = new BasicResultBean();
		System.out.println("inside reconcile");
		String message = objBankReconciliationService.excludedRecords(reconcileRecords);
		objBasicResultBean.setMessage(message);
		// objBasicResultBean.setSuccess(true);
		return objBasicResultBean;
	}

	@RequestMapping("/savereconcileRecordsDraft")
	public @ResponseBody BasicResultBean reconcileRecordsDraft(@RequestBody List<BankReconciliationBean> reconcileRecords) throws CustomException, ParseException {
		BasicResultBean objBasicResultBean = new BasicResultBean();
		String message = objBankReconciliationService.reconcileRecordsDraft(reconcileRecords);
		objBasicResultBean.setMessage(message);
		// objBasicResultBean.setSuccess(true);
		return objBasicResultBean;
	}

	@RequestMapping("/getReconcileList")
	public @ResponseBody BankReconciliationResultBean getReconcileList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("fromDate") String sFromDate, @RequestParam("toDate") String sToDate, @RequestParam("bankCode") String sBankCode) throws CustomException {
		BankReconciliationResultBean objBankReconciliationResultBean = new BankReconciliationResultBean();
		try {
			objBankReconciliationResultBean.setlDifferenceResultList(objBankReconciliationService.getReconcileList(limit, offset, sFromDate, sToDate, sBankCode));
			objBankReconciliationResultBean.setSuccess(true);
		} catch (Exception e) {
			objBankReconciliationResultBean.setSuccess(false);
			e.printStackTrace();
		}

		return objBankReconciliationResultBean;

	}

	@RequestMapping("/generateExcel")
	public @ResponseBody String generateExcel(@RequestBody List<BankReconciliationBean> bean) {
		String filePath = "";
		try {

			filePath = objBankReconciliationService.generateExcel(bean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;

	}

	@RequestMapping("/getReconcileListDraft")
	public @ResponseBody BankReconciliationResultBean getReconcileListDraft(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("fromDate") String sFromDate, @RequestParam("toDate") String sToDate, @RequestParam("bankCode") String sBankCode) throws CustomException {
		BankReconciliationResultBean objBankReconciliationResultBean = new BankReconciliationResultBean();
		try {
			objBankReconciliationResultBean.setlDifferenceResultList(objBankReconciliationService.getReconcileListDraft(limit, offset, sFromDate, sToDate, sBankCode));
			objBankReconciliationResultBean.setSuccess(true);
		} catch (Exception e) {
			objBankReconciliationResultBean.setSuccess(false);
			e.printStackTrace();
		}

		return objBankReconciliationResultBean;

	}

	@RequestMapping("/getReconcileListDraft1")
	public @ResponseBody BankReconciliationBean getReconcileListDraft1(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("fromDate") String sFromDate, @RequestParam("toDate") String sToDate, @RequestParam("bankCode") String sBankCode) throws CustomException {
		BankReconciliationBean objBankReconciliationBean = new BankReconciliationBean();
		BankReconciliationResultBean objBankReconciliationResultBean = new BankReconciliationResultBean();

		try {
			objBankReconciliationBean = objBankReconciliationService.getReconcileListDraft1(limit, offset, sFromDate, sToDate, sBankCode);
			// objBankReconciliationBean. setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankReconciliationBean;
	}

	@RequestMapping("/getReconcileListNew")
	public @ResponseBody BankReconciliationBean getReconcileListNew(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("fromDate") String sFromDate, @RequestParam("bankcode") String bankcode, @RequestParam("toDate") String sToDate) throws CustomException {
		BankReconciliationBean objBankReconciliationBean = new BankReconciliationBean();
		BankReconciliationResultBean objBankReconciliationResultBean = new BankReconciliationResultBean();

		try {
			objBankReconciliationBean = objBankReconciliationService.getReconcileListNew(limit, offset, sFromDate, sToDate, bankcode);
			// objBankReconciliationBean. setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankReconciliationBean;
	}

	@RequestMapping("/getReconcileListDraft2")
	public @ResponseBody BankReconciliationBean getReconcileListDraft2(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("fromDate") String sFromDate, @RequestParam("toDate") String sToDate, @RequestParam("bankCode") String sBankCode) throws CustomException {
		BankReconciliationBean objBankReconciliationBean = new BankReconciliationBean();
		BankReconciliationResultBean objBankReconciliationResultBean = new BankReconciliationResultBean();

		try {
			objBankReconciliationBean = objBankReconciliationService.getReconcileListDraft2(limit, offset, sFromDate, sToDate, sBankCode);
			// objBankReconciliationBean. setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBankReconciliationBean;
	}

	// @Scheduled(cron = "0 */1 * * * *")
	@RequestMapping(value = "/mail")
	public void getmail1(@PathVariable("tenantid") String name, HttpServletRequest request) {
		BankReconciliationResultBean taxchargeResultBean = new BankReconciliationResultBean();
		try {
			request.setAttribute("tenantid", name);
			objBankReconciliationService.getmail(request);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * @RequestMapping("/approve") public @ResponseBody boolean
	 * approve(@RequestParam("bank_stmt_id") int bank_stmt_id,HttpServletRequest
	 * request, HttpServletResponse response)throws CustomException { boolean
	 * isSucess=false;
	 * 
	 * try { objBankReconciliationService.approve(bank_stmt_id); isSucess=true;
	 * } catch (Exception e) { LOGGER.error("Error", e); throw new
	 * CustomException(); } return isSucess; }
	 * 
	 * @RequestMapping("/reject") public @ResponseBody boolean
	 * reject(@RequestParam("bank_stmt_id") int bank_stmt_id,HttpServletRequest
	 * request, HttpServletResponse response)throws CustomException { boolean
	 * isSucess=false;
	 * 
	 * try { objBankReconciliationService.reject(bank_stmt_id); isSucess=true; }
	 * catch (Exception e) { LOGGER.error("Error", e); throw new
	 * CustomException(); } return isSucess; }
	 */
	@RequestMapping("/approve")
	public ModelAndView approve(@RequestParam("bank_stmt_id") int bank_stmt_id, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		ModelAndView objModelAndView = null;
		BankReconciliationBean objBean = new BankReconciliationBean();
		BankReconciliationBean objBean1 = new BankReconciliationBean();

		try {
			objBankReconciliationService.approve(bank_stmt_id);
			objModelAndView = new ModelAndView("/reports/bankReconciliationPrint");
			objBean = objBankReconciliationService.printBankmail(bank_stmt_id);
			// objBean1 =
			// objBankReconciliationService.insertprint(bank_stmt_id);

			objModelAndView.addObject("BankReconciliationbeanList", objBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objModelAndView;
	}

	@RequestMapping("/reject")
	public ModelAndView reject(@RequestParam("bank_stmt_id") int bank_stmt_id, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		ModelAndView objModelAndView = null;
		BankReconciliationBean objBean = new BankReconciliationBean();
		try {
			objBankReconciliationService.reject(bank_stmt_id);
			objModelAndView = new ModelAndView("/reports/bankReconciliationPrint");
			objBean = objBankReconciliationService.printBankmail(bank_stmt_id);
			objModelAndView.addObject("BankReconciliationbeanList", objBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objModelAndView;
	}

	@RequestMapping("/getDifferenceListForManual")
	public @ResponseBody BankReconciliationResultBean getunReconcileBookAndBankStatement(@RequestParam("fromDate") String sFromDate, @RequestParam("toDate") String sToDate, @RequestParam("bankCode") String sBankCode) throws CustomException {
		BankReconciliationResultBean objBankReconciliationResultBean = new BankReconciliationResultBean();
		try {
			objBankReconciliationResultBean = objBankReconciliationService.getunReconcileBookAndBankStatement(sFromDate, sToDate, sBankCode);
			objBankReconciliationResultBean.setSuccess(true);
		} catch (Exception e) {
			objBankReconciliationResultBean.setSuccess(false);
			e.printStackTrace();
		}

		return objBankReconciliationResultBean;

	}

	@RequestMapping(value = "/exportunReconciledBankRecord", method = RequestMethod.POST)
	public @ResponseBody boolean exportunReconciledBankRecord(@RequestParam("fromDate") String sFromDate, @RequestParam("toDate") String sToDate, @RequestParam("bankCode") String sBankCode, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			isSuccess = objBankReconciliationService.exportunReconciledBankRecord(ConfigurationProps.exportFilesPath, sFromDate, sToDate, sBankCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	@RequestMapping("/print")
	public ModelAndView print(@RequestParam("toDate") String toDate, @RequestParam("bankCode") String bankCode, @RequestParam("fromDate") String fromDate) throws Exception {
		ModelAndView obj = null;
		BankReconciliationBean bankReconciliationBean = new BankReconciliationBean();

		Date dt = new Date();

		/* SalesMeetingReportBean serchBean = new SalesMeetingReportBean(); */
		try {
			bankReconciliationBean = objBankReconciliationService.getReconcileListNew(1000, 100, fromDate, toDate, bankCode);

		} catch (Exception e) {

			LOGGER.error("Error", e);
			throw new CustomException();
		}
		obj = new ModelAndView("reports/printbankreco");
		obj.addObject("getReconcileRecords", bankReconciliationBean.getlDifferenceResultList1());
		obj.addObject("bankBalanceAsPerBook", bankReconciliationBean.getlDifferenceResultList1().get(0).getBalanceAsPerBook());
		obj.addObject("bankBalanceAsPerBank", bankReconciliationBean.getlDifferenceResultList1().get(0).getBalanceAsPerBank());

		return obj;
	}

	@RequestMapping(value = "/ExportExcel")
	public @ResponseBody BankReconciliationResultBean getExcelReportExportList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("fromDate") String sFromDate, @RequestParam("toDate") String sToDate, @RequestParam("bankCode") String sBankCode, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		boolean success = false;
		BankReconciliationResultBean rsBean = new BankReconciliationResultBean();
		try {
			String sFilePath = request.getServletContext().getRealPath("tmpFiles");
			rsBean.setlDifferenceResultList(objBankReconciliationService.getReconcileList(limit, offset, sFromDate, sToDate, sBankCode));

			success = objBankReconciliationService.excellExport(rsBean,sFromDate, sToDate, ConfigurationProps.exportFilesPath);
			if (success)
				rsBean.setSuccess(true);
			else
				rsBean.setSuccess(false);
		} catch (Exception e) {
			System.out.println(e);

		}
		return rsBean;
	} // ExportExcel

}
