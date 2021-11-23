package com.dci.finance.DayBook;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.tenant.finance.trialBalance.TrialBalanceBean;
import com.dci.tenant.user.UserDetail;

@Controller
@RequestMapping(value = "app/dayBook")
public class DayBookController {

	private final static Logger LOGGER = LoggerFactory.getLogger(DayBookController.class);

	@Autowired
	DayBookService objGeneralLedgerService;

	@Autowired
	DayBookDao objGeneralLedgerDao;

	@RequestMapping(value = "/getGeneralLedgerReport", method = RequestMethod.POST)
	public @ResponseBody DayBookResultBean getGeneralLedgerReport(@RequestBody DayBookBean objGeneralLedgerBean) {
		List<DayBookBean> lGeneralLedgerList = new ArrayList<>();
		DayBookBean closeOpen = null;
		DayBookResultBean objGeneralLedgerResultBean = new DayBookResultBean();
		try {
			try {
				lGeneralLedgerList = objGeneralLedgerService.getGeneralLedgerReport(objGeneralLedgerBean);
				closeOpen = objGeneralLedgerService.getOpeningBalanceValue(objGeneralLedgerBean);
				objGeneralLedgerResultBean.setlGeneralLedgerList(lGeneralLedgerList);
				objGeneralLedgerResultBean.setAmt(closeOpen);
				objGeneralLedgerResultBean.setSuccess(true);
			} catch (Exception e) {
				objGeneralLedgerResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objGeneralLedgerResultBean;
	}

	@RequestMapping(value = "/getGroupHeadList")
	public @ResponseBody List<SelectivityBean> getSubGroupList() throws CustomException {
		List<SelectivityBean> lGroupList = new ArrayList<>();

		try {
			lGroupList = objGeneralLedgerService.getGroupHeadList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lGroupList;
	}

	@RequestMapping(value = "/mainaccountList")
	public @ResponseBody List<SelectivityBean> mainaccountList() throws CustomException {
		List<SelectivityBean> mainlist = new ArrayList<>();

		try {
			mainlist = objGeneralLedgerService.mainaccountList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return mainlist;
	}

	@RequestMapping(value = "/getsubLedgerReport", method = RequestMethod.POST)
	public @ResponseBody DayBookResultBean getsubLedgerReport(@RequestBody DayBookBean objGeneralLedgerBean) {
		List<DayBookBean> lGeneralLedgerList = new ArrayList<>();
		DayBookResultBean objGeneralLedgerResultBean = new DayBookResultBean();
		try {
			try {
				lGeneralLedgerList = objGeneralLedgerService.getSubLedgerReport_only(objGeneralLedgerBean);
				objGeneralLedgerResultBean.setlGeneralLedgerList(lGeneralLedgerList);
				objGeneralLedgerResultBean.setSuccess(true);
			} catch (Exception e) {
				objGeneralLedgerResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objGeneralLedgerResultBean;
	}

	@RequestMapping(value = "/getGeneralLedgerAHLevel", method = RequestMethod.POST)
	public @ResponseBody DayBookResultBean getGeneralLedgerAHLevel(@RequestBody DayBookBean objGeneralLedgerBean) {
		List<DayBookBean> lGeneralLedgerAHList = new ArrayList<>();
		DayBookResultBean objGeneralLedgerResultBean = new DayBookResultBean();
		try {
			try {
				lGeneralLedgerAHList = objGeneralLedgerService.getGeneralLedgerAHLevel(objGeneralLedgerBean);
				objGeneralLedgerResultBean.setlGeneralLedgerAHList(lGeneralLedgerAHList);
				objGeneralLedgerResultBean.setSuccess(true);
			} catch (Exception e) {
				objGeneralLedgerResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objGeneralLedgerResultBean;
	}

	@RequestMapping(value = "/getGLTransactionLevel", method = RequestMethod.POST)
	public @ResponseBody DayBookResultBean getGLTransactionLevel(@RequestBody DayBookBean objGeneralLedgerBean) {
		List<DayBookBean> lGeneralLedgerTransactionList = new ArrayList<>();
		DayBookResultBean objGeneralLedgerResultBean = new DayBookResultBean();
		try {
			try {
				lGeneralLedgerTransactionList = objGeneralLedgerService.getGLTransactionLevel(objGeneralLedgerBean);
				objGeneralLedgerResultBean.setlGeneralLedgerTransactionList(lGeneralLedgerTransactionList);
				objGeneralLedgerResultBean.setSuccess(true);
			} catch (Exception e) {
				objGeneralLedgerResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objGeneralLedgerResultBean;
	}

	/*// account head
	@RequestMapping(value = "/exportGeneralLedgerExcel", method = RequestMethod.POST)
	public @ResponseBody boolean exportGeneralLedgerExcel(@RequestBody DayBookBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			//String sFilePath = request.getServletContext().getRealPath(ConfigurationProps.exportFilesPath);
			String sFilePath = request.getServletContext().getRealPath("tempdoc");
			//String filePath = request.getServletContext().getRealPath("/assets/docs/Sample_Employee_Salary_Upload_FileNew.xls");

			isSuccess = objGeneralLedgerService.exportGeneralLedgerExcel(sFilePath, objGeneralLedgerBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}
	
	*/
	
	
	
	@RequestMapping(value = "/exportGeneralLedgerExcel", method = RequestMethod.POST)
		public @ResponseBody boolean exportGeneralLedgerExcel(@RequestBody DayBookBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");
			isSuccess = objGeneralLedgerService.exportGeneralLedgerExcel(ConfigurationProps.exportFilesPath, objGeneralLedgerBean);

			//isSuccess=true;
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	// export excel
	@RequestMapping(value = "/exportGeneralLedgerExcelOP", method = RequestMethod.POST)
	public @ResponseBody boolean exportGeneralLedgerExcelOP(@RequestBody DayBookBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			isSuccess = objGeneralLedgerService.exportGeneralLedgerExcelOP(sFilePath, objGeneralLedgerBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	@RequestMapping(value = "/exportTransactionLevelExcel", method = RequestMethod.POST)
	public @ResponseBody boolean exportTransactionLevelExcel(@RequestBody DayBookBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {

			isSuccess = objGeneralLedgerService.exportTransactionLevelExcel(ConfigurationProps.exportFilesPath, objGeneralLedgerBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	@RequestMapping(value = "/exportSubLedgerExcel", method = RequestMethod.POST)
	public @ResponseBody DayBookResultBean exportSubLedgerExcel(@RequestBody DayBookBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) {
		DayBookResultBean objGeneralLedger = new DayBookResultBean();
		try {
			objGeneralLedger = objGeneralLedgerService.exportSubLedgerExcel(ConfigurationProps.exportFilesPath, objGeneralLedgerBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objGeneralLedger;
	}

	@RequestMapping("/getsubgroupList")
	public @ResponseBody List<SelectivityBean> getCustomerList(@RequestParam("subgroup") List<String> subgroup) throws CustomException {
		List<SelectivityBean> ListBean = new ArrayList<>();
		try {
			ListBean = objGeneralLedgerService.getsub(subgroup);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return ListBean;
	}

	@RequestMapping("/getmaingroupList")
	public @ResponseBody List<SelectivityBean> getmaingroupList(@RequestParam("maingroup") String maingroup) throws CustomException {
		List<SelectivityBean> ListBean = new ArrayList<>();
		try {
			ListBean = objGeneralLedgerService.getmain(maingroup);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return ListBean;
	}

	@RequestMapping(value = "/getGeneralLedgerALLLevel", method = RequestMethod.POST)
	public @ResponseBody DayBookResultBean getGeneralLedgerALLLevel(@RequestBody DayBookBean objGeneralLedgerBean) {
		List<DayBookBean> lGeneralLedgerAHList = new ArrayList<>();
		DayBookResultBean objGeneralLedgerResultBean = new DayBookResultBean();
		try {
			try {
				lGeneralLedgerAHList = objGeneralLedgerService.getGeneralLedgerAHLevel(objGeneralLedgerBean);

				for (int i = 0; i < lGeneralLedgerAHList.size(); i++) {
					List<DayBookBean> lGeneralLedgerTransactionList = new ArrayList<>();
					DayBookBean bean = lGeneralLedgerAHList.get(i);
					objGeneralLedgerBean.setAccountHeadCode(bean.getAccountHeadCode());
					lGeneralLedgerTransactionList = objGeneralLedgerService.getGLTransactionLevel(objGeneralLedgerBean);
					lGeneralLedgerAHList.get(i).setlGeneralLedgerTransactionList(lGeneralLedgerTransactionList);
				}
				objGeneralLedgerResultBean.setlGeneralLedgerAHList(lGeneralLedgerAHList);
				objGeneralLedgerResultBean.setSuccess(true);

			} catch (Exception e) {
				objGeneralLedgerResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objGeneralLedgerResultBean;
	}

	// accountbased
	@RequestMapping(value = "/getAccountbasedtransaction", method = RequestMethod.POST)
	public @ResponseBody DayBookResultBean getAccountbasedtransaction(@RequestBody DayBookBean objGeneralLedgerBean) {
		List<DayBookBean> lGeneralLedgerAHList = new ArrayList<>();
		DayBookResultBean objGeneralLedgerResultBean = new DayBookResultBean();
		try {
			try {
				lGeneralLedgerAHList = objGeneralLedgerService.getGeneralTransaction(objGeneralLedgerBean);

				for (int i = 0; i < lGeneralLedgerAHList.size(); i++) {
					List<DayBookBean> lGeneralLedgerTransactionList = new ArrayList<>();
					DayBookBean bean = lGeneralLedgerAHList.get(i);
					objGeneralLedgerBean.setAccountHeadCode(bean.getAccountHeadCode());
					lGeneralLedgerTransactionList = objGeneralLedgerService.getGLTransactionLevel(objGeneralLedgerBean);
					lGeneralLedgerAHList.get(i).setlGeneralLedgerTransactionList(lGeneralLedgerTransactionList);
				}
				objGeneralLedgerResultBean.setlGeneralLedgerAHList(lGeneralLedgerAHList);
				objGeneralLedgerResultBean.setSuccess(true);

			} catch (Exception e) {
				objGeneralLedgerResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objGeneralLedgerResultBean;
	}

	@RequestMapping(value = "/print", method = RequestMethod.POST)
	public ModelAndView printJournalVoucher(@RequestBody DayBookBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DayBookBean closeOpen = null;
		DayBookResultBean objGeneralLedgerResultBean = new DayBookResultBean();
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		boolean isSuccess = false;
		DayBookBean objGeneralLedgerOPBean = new DayBookBean();
		List<DayBookBean> lGeneralLedgerList = new ArrayList<>();

		DayBookBean address = new DayBookBean();

		if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "") {
			objGeneralLedgerOPBean = objGeneralLedgerDao.getOpeningBalanceValue(objGeneralLedgerBean);
			lGeneralLedgerList = objGeneralLedgerDao.getSubLedgerReport(objGeneralLedgerBean);
			address = objGeneralLedgerDao.getAddress(objGeneralLedgerBean);

			// second
		} else {
			objGeneralLedgerOPBean = objGeneralLedgerDao.getOpeningBalanceValue(objGeneralLedgerBean);
			lGeneralLedgerList = objGeneralLedgerDao.getSubLedgerReport(objGeneralLedgerBean);
		}

		obj = new ModelAndView("finance/transaction/print/printGeneralLedger");

		// isSuccess =
		// objGeneralLedgerService.exportGeneralLedgerExcelOP(ConfigurationProps.exportFilesPath,objGeneralLedgerBean);

		// objGeneralLedgerBean =
		// objGeneralLedgerService.getJournalVoucherforPrint(companyCode);
		obj.addObject("list", address);
		obj.addObject("vesselSaillingList", objGeneralLedgerBean);
		obj.addObject("lGeneralLedgerList", lGeneralLedgerList);
		obj.addObject("objGeneralLedgerOPBean", objGeneralLedgerOPBean);

		return obj;
	}

	
	
	
	
	@RequestMapping(value = "/ExportPDF", method = RequestMethod.POST)
	public @ResponseBody DayBookBean ExportPDFBulk(@RequestBody DayBookBean DetentionTariffBean)
			throws Exception {

		DetentionTariffBean = objGeneralLedgerService.pdfExportNew(DetentionTariffBean, ConfigurationProps.exportFilesPath);

		return DetentionTariffBean;
	}

	
	
}