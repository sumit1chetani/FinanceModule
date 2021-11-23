package com.dci.tenant.finance.chqPresentation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "app/chqPresentation")
public class ChqPresentationController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ChqPresentationController.class);

	@Autowired
	private ChqPresentationService chqPresentationService;

	@RequestMapping("/list")
	public @ResponseBody ChqPresentationResultBean getPresentationList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		ChqPresentationResultBean objChqPresentationBean = new ChqPresentationResultBean();
		try {

			objChqPresentationBean.setSwapMasterList(chqPresentationService.getPresentationHdrList(limit, offset));
			objChqPresentationBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objChqPresentationBean;
	}

	@RequestMapping("/save")
	public @ResponseBody boolean savePresentation(@RequestBody ChqPresentationBean chqPresentationBean) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = chqPresentationService.savePresentation(chqPresentationBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/realisationList")
	public @ResponseBody ChqPresentationResultBean getRealisationList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		ChqPresentationResultBean objChqPresentationBean = new ChqPresentationResultBean();
		try {

			objChqPresentationBean.setSwapMasterList(chqPresentationService.getRealisationList(limit, offset));
			objChqPresentationBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objChqPresentationBean;
	}

	@RequestMapping("/getPresentationList")
	public @ResponseBody ChqPresentationResultBean getPresentationList() throws CustomException {
		ChqPresentationResultBean commonUtilityResultBean = new ChqPresentationResultBean();
		try {
			commonUtilityResultBean.setlCommonUtilityBean(chqPresentationService.getPresentationList());
			commonUtilityResultBean.setSuccess(true);

			// commonUtilityResultBean = chqPresentationService.getPresentationList();

		} catch (Exception e) {

		}
		return commonUtilityResultBean;
	}

	@RequestMapping("/getchequelist")
	public @ResponseBody ChqPresentationResultBean getchequelist() throws CustomException {
		ChqPresentationResultBean commonUtilityResultBean = new ChqPresentationResultBean();

		try {
			commonUtilityResultBean.setlCommonUtilityBean(chqPresentationService.getchequelist());
			commonUtilityResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return commonUtilityResultBean;
	}

	@RequestMapping("/getPresentationListEdit")
	public @ResponseBody List<ChqPresentationBean> getPresentationListEdit() throws CustomException {
		List<ChqPresentationBean> alChqPresentationBean = new ArrayList<>();
		try {

			alChqPresentationBean = chqPresentationService.getPresentationListEdit();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return alChqPresentationBean;
	}

	@RequestMapping("/saveRealisation")
	public @ResponseBody boolean saveRealisation(@RequestBody ChqPresentationBean chqPresentationBean) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = chqPresentationService.saveRealisation(chqPresentationBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/getDataforEdit")
	public @ResponseBody ChqPresentationBean getCreditNoteForEdit(@RequestParam("prCode") String prCode) throws CustomException {
		ChqPresentationBean chqPresentationBean = new ChqPresentationBean();
		try {
			chqPresentationBean = chqPresentationService.getCreditNoteForEdit(prCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return chqPresentationBean;
	}

	@RequestMapping("/update")
	public @ResponseBody boolean updatePresentation(@RequestBody ChqPresentationBean chqPresentationBean) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = chqPresentationService.updatePresentation(chqPresentationBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deletePresentation(@RequestBody String prCode) throws Exception {
		boolean isDeleted = false;
		isDeleted = chqPresentationService.deletePresentation(prCode);
		return isDeleted;
	}

	@RequestMapping("/chqStatusRprtList")
	public @ResponseBody ChqPresentationResultBean getChqStatusRprtList(@RequestParam("customer") String customer, @RequestParam("company") String company) throws CustomException {
		ChqPresentationResultBean objChqPresentationBean = new ChqPresentationResultBean();
		try {

			objChqPresentationBean.setChqStatusRprtList(chqPresentationService.getChqStatusRprtList(customer, company));
			objChqPresentationBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objChqPresentationBean;
	}

	/*
	 * @RequestMapping("/getCustomerList") public @ResponseBody
	 * List<GeneralInvoiceBean> getCustomerList() throws CustomException {
	 * List<GeneralInvoiceBean> lCustomerList = new ArrayList<>();
	 * 
	 * try { lCustomerList = chqPresentationService.getCustomerList();
	 * 
	 * } catch (Exception e) { LOGGER.error("Error", e); throw new
	 * CustomException(); }
	 * 
	 * return lCustomerList; }
	 */

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody ChqPresentationResultBean exportExcel(@RequestParam("customer") String customer, @RequestParam("company") String company, HttpServletRequest request, HttpServletResponse response) {
		ChqPresentationResultBean objChqPresentationResultBean = new ChqPresentationResultBean();
		boolean isSuccess = false;
		try {
			String filepath = request.getServletContext().getRealPath("tmpFiles");
			isSuccess = chqPresentationService.exportExcel(ConfigurationProps.exportFilesPath, customer, company);
			objChqPresentationResultBean.setSuccess(isSuccess);
			objChqPresentationResultBean.setFilePath("filePath/ChequeStatus.xls");

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return objChqPresentationResultBean;
	}
}
