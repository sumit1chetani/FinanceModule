package com.dci.tenant.finance.trialBalance;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.finance.GeneralLedger.GeneralLedgerBean;

@RestController
@RequestMapping(value = "app/trialBalance")
public class TrialBalanceController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TrialBalanceController.class);

	@Autowired
	private TrialBalanceService trialBalanceService;

	@RequestMapping(value = "/getCompanyList")
	public @ResponseBody List<SelectivityBean> getCompanyList() throws CustomException {
		List<SelectivityBean> lcompanyList = new ArrayList<>();

		try {
			lcompanyList = trialBalanceService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lcompanyList;
	}

	@RequestMapping(value = "/getSubGroupList")
	public @ResponseBody List<SelectivityBean> getSubGroupList() throws CustomException {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();

		try {
			lSubGroupList = trialBalanceService.getSubGroupList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubGroupList;
	}

	@RequestMapping(value = "/getAccountHeadList")
	public @ResponseBody List<SelectivityBean> getAccountHeadList(@RequestParam("subGroupCode") String subGroupCode) throws CustomException {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();

		try {
			lSubGroupList = trialBalanceService.getAccountHeadList(subGroupCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubGroupList;
	}

	
	@RequestMapping(value = "/getSubAccountList")
	public @ResponseBody List<SelectivityBean> getSubAccountList() throws CustomException {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();

		try {
			lSubGroupList = trialBalanceService.getSubAccountList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubGroupList;
	}
	
	
	
	@RequestMapping(value = "/getAccountList")
	public @ResponseBody List<SelectivityBean> getAccountList() throws CustomException {
		List<SelectivityBean> lSubGroupList = new ArrayList<>();

		try {
			lSubGroupList = trialBalanceService.getAccountList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lSubGroupList;
	}

	@RequestMapping(value = "/getTrialBalanceReport", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceResultBean getTrialBalanceReport(@RequestBody TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSGLevelList = new ArrayList<>();
		TrialBalanceResultBean objTrialBalanceResultBean = new TrialBalanceResultBean();
		try {
			try {

				lTrialBalanceSGLevelList = trialBalanceService.getTrialBalanceSGList1(trialBalanceBean);
				objTrialBalanceResultBean.setlTrialBalanceSGLevelList(lTrialBalanceSGLevelList);
				objTrialBalanceResultBean.setSuccess(true);
			} catch (Exception e) {
				objTrialBalanceResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objTrialBalanceResultBean;
	}

	
	
	
	
	
	/*@RequestMapping(value = "/getTrialBalanceReportgroup", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceResultBean getTrialBalanceReportgroup(@RequestBody TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSGLevelListnew = new ArrayList<>();
		TrialBalanceResultBean objTrialBalanceResultBean = new TrialBalanceResultBean();
		try {
			try {

				lTrialBalanceSGLevelListnew = trialBalanceService.getTrialBalanceSGList2(trialBalanceBean);
				objTrialBalanceResultBean.setlTrialBalanceSGLevelListnew(lTrialBalanceSGLevelListnew);

				objTrialBalanceResultBean.setSuccess(true);
			} catch (Exception e) {
				objTrialBalanceResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objTrialBalanceResultBean;
	}*/
	
	
	@RequestMapping(value = "/getTrialBalanceReportRPSplitup", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceResultBean getTrialBalanceReportRPSplitup(@RequestBody TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceSGLevelList = new ArrayList<>();
		TrialBalanceResultBean objTrialBalanceResultBean = new TrialBalanceResultBean();
		try {
			try {
				lTrialBalanceSGLevelList = trialBalanceService.getTrialBalanceSGListRPSplitup(trialBalanceBean);
				objTrialBalanceResultBean.setlTrialBalanceSGLevelList(lTrialBalanceSGLevelList);
				objTrialBalanceResultBean.setSuccess(true);
			} catch (Exception e) {
				objTrialBalanceResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objTrialBalanceResultBean;
	}

	@RequestMapping(value = "/getTrialBalanceAHLevel", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceResultBean getTrialBalanceAHLevel(@RequestBody TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceAHLevelList = new ArrayList<>();
		TrialBalanceResultBean objTrialBalanceResultBean = new TrialBalanceResultBean();
		try {
			try {
				lTrialBalanceAHLevelList = trialBalanceService.getTrialBalanceAHLevel1(trialBalanceBean);
				objTrialBalanceResultBean.setlTrialBalanceAHLevelList(lTrialBalanceAHLevelList);
				objTrialBalanceResultBean.setSuccess(true);
			} catch (Exception e) {
				objTrialBalanceResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objTrialBalanceResultBean;
	}

	@RequestMapping(value = "/getTrialBalanceAHLevelRPonly", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceResultBean getTrialBalanceAHLevelRPonly(@RequestBody TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceAHLevelList = new ArrayList<>();
		TrialBalanceResultBean objTrialBalanceResultBean = new TrialBalanceResultBean();
		try {
			try {
				lTrialBalanceAHLevelList = trialBalanceService.getTrialBalanceAHLevelRPonly(trialBalanceBean);
				objTrialBalanceResultBean.setlTrialBalanceAHLevelList(lTrialBalanceAHLevelList);
				objTrialBalanceResultBean.setSuccess(true);
			} catch (Exception e) {
				objTrialBalanceResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objTrialBalanceResultBean;
	}

	@RequestMapping(value = "/getTrialBalanceAHLevelExcludeRp", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceResultBean getTrialBalanceAHLevelExcludeRp(@RequestBody TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceAHLevelList = new ArrayList<>();
		TrialBalanceResultBean objTrialBalanceResultBean = new TrialBalanceResultBean();
		try {
			try {
				lTrialBalanceAHLevelList = trialBalanceService.getTrialBalanceAHLevelExcludeRp(trialBalanceBean);
				objTrialBalanceResultBean.setlTrialBalanceAHLevelList(lTrialBalanceAHLevelList);
				objTrialBalanceResultBean.setSuccess(true);
			} catch (Exception e) {
				objTrialBalanceResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objTrialBalanceResultBean;
	}

	@RequestMapping(value = "/getTrialBalanceSALevel", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceResultBean getTrialBalanceSALevel(@RequestBody TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceTransactionLevelList = new ArrayList<>();
		TrialBalanceResultBean objTrialBalanceResultBean = new TrialBalanceResultBean();
		try {
			try {
				lTrialBalanceTransactionLevelList = trialBalanceService.getTrialBalanceSALevel1(trialBalanceBean);
				objTrialBalanceResultBean.setlTrialBalanceTransactionLevelList(lTrialBalanceTransactionLevelList);
				objTrialBalanceResultBean.setSuccess(true);
			} catch (Exception e) {
				objTrialBalanceResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objTrialBalanceResultBean;
	}

	@RequestMapping(value = "/getTrialBalanceSALevelRPonly", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceResultBean getTrialBalanceSALevelRPonly(@RequestBody TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceTransactionLevelList = new ArrayList<>();
		TrialBalanceResultBean objTrialBalanceResultBean = new TrialBalanceResultBean();
		try {
			try {
				lTrialBalanceTransactionLevelList = trialBalanceService.getTrialBalanceSALevelRPonly(trialBalanceBean);
				objTrialBalanceResultBean.setlTrialBalanceTransactionLevelList(lTrialBalanceTransactionLevelList);
				objTrialBalanceResultBean.setSuccess(true);
			} catch (Exception e) {
				objTrialBalanceResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objTrialBalanceResultBean;
	}

	@RequestMapping(value = "/getTrialBalanceSALevelExcludeRP", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceResultBean getTrialBalanceSALevelExcludeRP(@RequestBody TrialBalanceBean trialBalanceBean) {
		List<TrialBalanceBean> lTrialBalanceTransactionLevelList = new ArrayList<>();
		TrialBalanceResultBean objTrialBalanceResultBean = new TrialBalanceResultBean();
		try {
			try {
				lTrialBalanceTransactionLevelList = trialBalanceService.getTrialBalanceSALevelExcludeRP(trialBalanceBean);
				objTrialBalanceResultBean.setlTrialBalanceTransactionLevelList(lTrialBalanceTransactionLevelList);
				objTrialBalanceResultBean.setSuccess(true);
			} catch (Exception e) {
				objTrialBalanceResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objTrialBalanceResultBean;
	}

	@RequestMapping(value = "/exportTBExcel", method = RequestMethod.POST)
	public @ResponseBody boolean exportTBExcel(@RequestBody TrialBalanceBean trialBalanceBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");
			if (trialBalanceBean.getCompanyCode().equalsIgnoreCase("ALL")) {
				isSuccess = trialBalanceService.exportTBExcel(ConfigurationProps.exportFilesPath, trialBalanceBean);
			} else {
				isSuccess = trialBalanceService.exportTBExcel1(ConfigurationProps.exportFilesPath, trialBalanceBean);
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	@RequestMapping(value = "/exportTBExcelFormatNew", method = RequestMethod.POST)
	public @ResponseBody boolean exportTBExcelFormatNew(@RequestBody TrialBalanceBean trialBalanceBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {

			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			isSuccess = trialBalanceService.exportTBExcelFormatNew(sFilePath, trialBalanceBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	@RequestMapping(value = "/exportTBExcelSplitRP", method = RequestMethod.POST)
	public @ResponseBody boolean exportTBExcelSplitRP(@RequestBody TrialBalanceBean trialBalanceBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			isSuccess = trialBalanceService.exportTBExcelSplitRP(sFilePath, trialBalanceBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}

	@RequestMapping(value = "/exportTBExcelWithPlain", method = RequestMethod.POST)
	public @ResponseBody boolean exportTBExcelWithPlain(@RequestBody TrialBalanceBean trialBalanceBean, HttpServletRequest request, HttpServletResponse response) {

		boolean isSuccess = false;
		try {
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			isSuccess = trialBalanceService.exportTBExcelWithPlain(sFilePath, trialBalanceBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}
	

	@RequestMapping(value = "/ExportPDF", method = RequestMethod.POST)
	public @ResponseBody TrialBalanceBean ExportPDFBulk(@RequestBody TrialBalanceBean tbreport)
			throws Exception {

		tbreport = trialBalanceService.pdfExportNew(tbreport, ConfigurationProps.exportFilesPath);

		return tbreport;
	}

	

}