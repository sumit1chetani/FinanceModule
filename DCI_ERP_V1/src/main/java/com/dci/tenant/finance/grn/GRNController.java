package com.dci.tenant.finance.grn;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.CustomException;
import com.dci.tenant.common.CommonUtilityService;

@Controller
@RequestMapping(value = "app/grn")
public class GRNController {

	private final static Logger LOGGER = LoggerFactory.getLogger(GRNController.class);

	@Autowired
	private GRNService grnService;

	@Autowired
	private CommonUtilityService commonUtilityService;

	@RequestMapping("/list")
	public @ResponseBody GRNResultBean getGRNMasterList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("formName") String formName) throws CustomException, InterruptedException {
		GRNResultBean objGRNResultBean = new GRNResultBean();
		try {
			objGRNResultBean.setlGRNBean(grnService.getGRNMasterList(limit, offset, formName));
			objGRNResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objGRNResultBean;
	}

	@RequestMapping("/qcList")
	public @ResponseBody GRNResultBean getGRNQcMasterList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("formName") String formName) throws CustomException, InterruptedException {
		GRNResultBean objGRNResultBean = new GRNResultBean();
		try {
			objGRNResultBean.setlGRNBean(grnService.getGRNMasterList(limit, offset, formName));
			objGRNResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objGRNResultBean;
	}

	@RequestMapping("/getPreviousBatch")
	public @ResponseBody GRNPurchaseOrderBean getGrnOldBatchValue(@RequestBody GRNPurchaseOrderBean grnBean) throws CustomException, InterruptedException {
		GRNPurchaseOrderBean objGRNResultBean = new GRNPurchaseOrderBean();
		try {
			objGRNResultBean = grnService.getGrnOldBatchValue(grnBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objGRNResultBean;
	}

	@RequestMapping("/getLocationList")
	public @ResponseBody GRNResultBean getLocationList() throws CustomException {
		GRNResultBean sLocation = new GRNResultBean();
		try {
			sLocation.setlLocationLst(commonUtilityService.getParentLocationList());
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sLocation;
	}

	@RequestMapping("/getVendorList")
	public @ResponseBody GRNResultBean getVendorList() throws CustomException {
		GRNResultBean sVendor = null;
		try {
			sVendor = grnService.getVendorList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}

	@RequestMapping("/getPOList")
	public @ResponseBody GRNResultBean getPOList() throws CustomException {
		GRNResultBean sVendor = null;
		try {
			sVendor = grnService.getPOList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}

	@RequestMapping("/getPOEditList")
	public @ResponseBody GRNResultBean getPOEditList() throws CustomException {
		GRNResultBean sVendor = null;
		try {
			sVendor = grnService.getPOEditList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}

	@RequestMapping("/getPODtlList")
	public @ResponseBody GRNResultBean getPODtlList(@RequestParam("poId") int poId) throws CustomException {
		GRNResultBean sVendor = null;
		try {
			sVendor = grnService.getPODtlList(poId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}

	@RequestMapping(value = "/saveGRN", method = RequestMethod.POST)
	public @ResponseBody boolean saveGrn(@RequestBody GRNBean bean) throws Exception {
		boolean isSuccess = false;
		GRNResultBean objGRNResultBean = new GRNResultBean();
		try {
			isSuccess = grnService.saveGrn(bean);
			objGRNResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping("/grnAutoIncrementNo")
	public @ResponseBody GRNResultBean grnAutoIncrementNo() throws CustomException {
		GRNResultBean objGRNResultBean = new GRNResultBean();
		String code = null;
		try {
			code = grnService.grnAutoIncrementNo();
			objGRNResultBean.setCode(code);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objGRNResultBean;
	}

	@RequestMapping("/getRequisition")
	public @ResponseBody GRNResultBean getRequisition(@RequestParam("poId") int poId) throws CustomException {
		GRNResultBean sVendor = null;
		try {
			sVendor = grnService.getRequisition(poId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}

	@RequestMapping("/getVendorAddress")
	public @ResponseBody GRNResultBean getVendorAddress(@RequestParam("vendorId") int vendorId) throws CustomException {
		GRNResultBean sVendor = null;
		try {
			sVendor = grnService.getVendorAddress(vendorId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}

	@RequestMapping("/getGrnEditData")
	public @ResponseBody GRNResultBean getGrnEditData(@RequestParam("grnCode") String grnCode) throws CustomException {
		GRNResultBean editData = null;
		try {
			editData = grnService.getGrnEditData(grnCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return editData;
	}

	@RequestMapping(value = "/updateGRN", method = RequestMethod.POST)
	public @ResponseBody boolean updateGRN(@RequestBody GRNBean bean) throws Exception {
		boolean isSuccess = false;
		GRNResultBean objGRNResultBean = new GRNResultBean();
		try {
			isSuccess = grnService.updateGRN(bean);
			objGRNResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteGRN(@RequestBody String grnNo) throws Exception {
		boolean isDeleted = false;
		isDeleted = grnService.deleteGRN(grnNo);
		return isDeleted;
	}

	@RequestMapping("/getDeliverySchedule")
	public @ResponseBody GRNResultBean getDeliverySchedule(@RequestParam("poDtlId") int poDtlId) throws CustomException {
		GRNResultBean sVendor = null;
		try {
			sVendor = grnService.getDeliverySchedule(poDtlId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}

	@RequestMapping(value = "/updateQC", method = RequestMethod.POST)
	public @ResponseBody boolean updateGRNwithQC(@RequestBody GRNBean bean) throws Exception {
		boolean isSuccess = false;
		GRNResultBean objGRNResultBean = new GRNResultBean();
		try {
			isSuccess = grnService.updateGRNwithQC(bean);
			objGRNResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping("/getItemAttributes")
	public @ResponseBody GRNResultBean getItemAttributes(@RequestParam("itemId") int itemId) throws CustomException {
		GRNResultBean bean = new GRNResultBean();
		try {
			bean.setItemAttributes(grnService.getItemAttributes(itemId));
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}

	@RequestMapping("/printGRN")
	public ModelAndView printGRN(@RequestParam("grnCode") String grnCode) throws CustomException {
		ModelAndView obj = null;
		obj = new ModelAndView("print/grnReportPdf");
		GRNResultBean editData = new GRNResultBean();
		List<GRNPurchaseOrderBean> sampleList = new ArrayList<>();
		try {
			editData = grnService.getGrnEditData(grnCode);
			obj.addObject("GRNDetails", editData.getEditBeanData());
			obj.addObject("GRNTables", editData.getEditBeanData().getGrnTables());

			obj.addObject("GRNSrcDetails", grnService.getBatchList(grnCode));

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return obj;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody GRNResultBean exportExcel(HttpServletRequest request, HttpServletRequest response) throws CustomException {
		GRNResultBean grnResultBean = new GRNResultBean();

		try {
			// String filePath =
			// request.getServletContext().getRealPath("/tempdoc/GRN_File.xls");
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			grnService.exportExcel(sFilePath);
			grnResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return grnResultBean;

	}

	@RequestMapping("/getPOListbasedonCompany")
	public @ResponseBody GRNResultBean getPOListbasedonCompany(@RequestParam("companyId") String companyId, @RequestParam("vendorId") Integer vendorId) throws CustomException {
		GRNResultBean sVendor = null;
		try {
			sVendor = grnService.getPOListbasedonCompany(companyId, vendorId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}

	@RequestMapping("/grnPrint")
	public ModelAndView grnPrint(@RequestParam("grnId") String grnCode) throws Exception {
		ModelAndView obj = null;
		obj = new ModelAndView("/finance/inventory/ggrn/ggrnPrint");

		GRNResultBean printdata = null;
		try {
			printdata = grnService.getGrnPrintData(grnCode);
			obj.addObject("printdata", printdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@RequestMapping(value = "/exportExcel1", method = RequestMethod.POST)
	public @ResponseBody boolean exportExcel(@RequestBody GRNBean PurchaseOrder, HttpServletRequest request, HttpServletResponse response) {
		List<GRNBean> rsList = new ArrayList<>();

		boolean isSuccess = false;
		try {
			rsList = grnService.getGRNExportMasterList();
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			isSuccess = grnService.exportExcelnew(sFilePath, rsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

}
