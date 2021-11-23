package com.dci.finance.GeneralLedger;

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
import com.dci.finance.DayBook.DayBookBean;
import com.dci.tenant.user.UserDetail;

@Controller
@RequestMapping(value = "app/generalLedger")
public class GeneralLedgerController {

	private final static Logger LOGGER = LoggerFactory.getLogger(GeneralLedgerController.class);

	@Autowired
	GeneralLedgerService objGeneralLedgerService;

	@Autowired
	GeneralLedgerDao objGeneralLedgerDao;

	@RequestMapping(value = "/getGeneralLedgerReport", method = RequestMethod.POST)
	public @ResponseBody GeneralLedgerResultBean getGeneralLedgerReport(@RequestBody GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<GeneralLedgerBean>();
		GeneralLedgerBean closeOpen = null;
		GeneralLedgerResultBean objGeneralLedgerResultBean = new GeneralLedgerResultBean();
		try {
			try {
				lGeneralLedgerList = objGeneralLedgerService.getGeneralLedgerReport(objGeneralLedgerBean);
				closeOpen = objGeneralLedgerService.getOpeningBalanceValue(objGeneralLedgerBean);
				System.out.println("my open = "+closeOpen.getOpeningBalance());
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
		List<SelectivityBean> lGroupList = new ArrayList<SelectivityBean>();

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
		List<SelectivityBean> mainlist = new ArrayList<SelectivityBean>();

		try {
			mainlist = objGeneralLedgerService.mainaccountList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return mainlist;
	}

	@RequestMapping(value = "/getsubLedgerReport", method = RequestMethod.POST)
	public @ResponseBody GeneralLedgerResultBean getsubLedgerReport(@RequestBody GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<GeneralLedgerBean>();
		GeneralLedgerResultBean objGeneralLedgerResultBean = new GeneralLedgerResultBean();
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
	public @ResponseBody GeneralLedgerResultBean getGeneralLedgerAHLevel(@RequestBody GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerAHList = new ArrayList<GeneralLedgerBean>();
		List<GeneralLedgerBean> lGeneralLedgerAHListAcc = new ArrayList<GeneralLedgerBean>();

		GeneralLedgerResultBean objGeneralLedgerResultBean = new GeneralLedgerResultBean();
		try {
			try {
				lGeneralLedgerAHList = objGeneralLedgerService.getGeneralLedgerAHLevel(objGeneralLedgerBean);
				lGeneralLedgerAHListAcc = objGeneralLedgerService.getGeneralLedgerAHLevelAcct(objGeneralLedgerBean);

				objGeneralLedgerResultBean.setlGeneralLedgerAHList(lGeneralLedgerAHList);
				objGeneralLedgerResultBean.setlGeneralLedgerAHListAcc(lGeneralLedgerAHListAcc);
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
	public @ResponseBody GeneralLedgerResultBean getGLTransactionLevel(@RequestBody GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerTransactionList = new ArrayList<GeneralLedgerBean>();
		GeneralLedgerResultBean objGeneralLedgerResultBean = new GeneralLedgerResultBean();
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

	// account head
	@RequestMapping(value = "/exportGeneralLedgerExcel", method = RequestMethod.POST)
	public @ResponseBody boolean exportGeneralLedgerExcel(@RequestBody GeneralLedgerBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			isSuccess = objGeneralLedgerService.exportGeneralLedgerExcel(ConfigurationProps.exportFilesPath, objGeneralLedgerBean);
		
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	// export excel
	@RequestMapping(value = "/exportGeneralLedgerExcelOP", method = RequestMethod.POST)
	public @ResponseBody boolean exportGeneralLedgerExcelOP(@RequestBody GeneralLedgerBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) {

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
	public @ResponseBody boolean exportTransactionLevelExcel(@RequestBody GeneralLedgerBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {

			isSuccess = objGeneralLedgerService.exportTransactionLevelExcel(ConfigurationProps.exportFilesPath, objGeneralLedgerBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	@RequestMapping(value = "/exportSubLedgerExcel", method = RequestMethod.POST)
	public @ResponseBody GeneralLedgerResultBean exportSubLedgerExcel(@RequestBody GeneralLedgerBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) {
		GeneralLedgerResultBean objGeneralLedger = new GeneralLedgerResultBean();
		try {
			objGeneralLedger = objGeneralLedgerService.exportSubLedgerExcel(ConfigurationProps.exportFilesPath, objGeneralLedgerBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objGeneralLedger;
	}

	@RequestMapping("/getsubgroupList")
	public @ResponseBody List<SelectivityBean> getCustomerList(@RequestParam("subgroup") List<String> subgroup) throws CustomException {
		List<SelectivityBean> ListBean = new ArrayList<SelectivityBean>();
		try {
			ListBean = objGeneralLedgerService.getsub(subgroup);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return ListBean;
	}

	@RequestMapping("/getmaingroupList")
	public @ResponseBody List<SelectivityBean> getmaingroupList(@RequestParam("maingroup") String maingroup) throws CustomException {
		List<SelectivityBean> ListBean = new ArrayList<SelectivityBean>();
		try {
			ListBean = objGeneralLedgerService.getmain(maingroup);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return ListBean;
	}

	@RequestMapping(value = "/getGeneralLedgerALLLevel", method = RequestMethod.POST)
	public @ResponseBody GeneralLedgerResultBean getGeneralLedgerALLLevel(@RequestBody GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerAHList = new ArrayList<GeneralLedgerBean>();
		GeneralLedgerResultBean objGeneralLedgerResultBean = new GeneralLedgerResultBean();
		try {
			try {
				lGeneralLedgerAHList = objGeneralLedgerService.getGeneralLedgerAHLevel(objGeneralLedgerBean);

				for (int i = 0; i < lGeneralLedgerAHList.size(); i++) {
					List<GeneralLedgerBean> lGeneralLedgerTransactionList = new ArrayList<GeneralLedgerBean>();
					GeneralLedgerBean bean = lGeneralLedgerAHList.get(i);
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
	public @ResponseBody GeneralLedgerResultBean getAccountbasedtransaction(@RequestBody GeneralLedgerBean objGeneralLedgerBean) {
		List<GeneralLedgerBean> lGeneralLedgerAHList = new ArrayList<GeneralLedgerBean>();
		GeneralLedgerResultBean objGeneralLedgerResultBean = new GeneralLedgerResultBean();
		try {
			try {
				lGeneralLedgerAHList = objGeneralLedgerService.getGeneralTransaction(objGeneralLedgerBean);

				for (int i = 0; i < lGeneralLedgerAHList.size(); i++) {
					List<GeneralLedgerBean> lGeneralLedgerTransactionList = new ArrayList<GeneralLedgerBean>();
					GeneralLedgerBean bean = lGeneralLedgerAHList.get(i);
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
	public ModelAndView printJournalVoucher(@RequestBody GeneralLedgerBean objGeneralLedgerBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GeneralLedgerBean closeOpen = null;
		GeneralLedgerResultBean objGeneralLedgerResultBean = new GeneralLedgerResultBean();
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		boolean isSuccess = false;
		GeneralLedgerBean objGeneralLedgerOPBean = new GeneralLedgerBean();
		List<GeneralLedgerBean> lGeneralLedgerList = new ArrayList<GeneralLedgerBean>();

		GeneralLedgerBean address = new GeneralLedgerBean();

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
	public @ResponseBody GeneralLedgerBean ExportPDFBulk(@RequestBody GeneralLedgerBean glreport)
			throws Exception {

		glreport = objGeneralLedgerService.pdfExportNew(glreport, ConfigurationProps.exportFilesPath);

		return glreport;
	} 
	

}