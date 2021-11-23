package com.dci.tenant.finance.purchaseInvoice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "app/purchaseinvoice")
public class PurchaseInvoiceController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PurchaseInvoiceController.class);

	@Autowired
	private PurchaseInvoiceService purchaseInvoiceService;

	@RequestMapping("/getSupplierList")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> getSupplierList() throws CustomException {
		List<PurchaseInvoiceHeaderBean> listVendormaster = new ArrayList<>();
		try {
			listVendormaster = purchaseInvoiceService.getSupplierList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return listVendormaster;
	}

	@RequestMapping("/getGrnList")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> getGrnList(@RequestParam("supplier") String supplier) throws CustomException {
		List<PurchaseInvoiceHeaderBean> purchaseNoList = new ArrayList<>();
		try {
			purchaseNoList = purchaseInvoiceService.getGrnList(supplier);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return purchaseNoList;
	}

	@RequestMapping("/getCompanyList")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> getCompanyList() throws CustomException {
		List<PurchaseInvoiceHeaderBean> purchaseNoList = new ArrayList<>();
		try {
			purchaseNoList = purchaseInvoiceService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return purchaseNoList;
	}

	@RequestMapping("/costcenterlist")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> getcostcenterlist() throws CustomException {
		List<PurchaseInvoiceHeaderBean> costList = new ArrayList<>();
		try {
			costList = purchaseInvoiceService.getcostcenterlist();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return costList;
	}

	@RequestMapping("/costcenterlist_1")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> getcostcenterlist1() throws CustomException {
		List<PurchaseInvoiceHeaderBean> costList = new ArrayList<>();
		try {
			costList = purchaseInvoiceService.getcostcenterlist1();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return costList;
	}

	@RequestMapping("/getcompanycost")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> getBankAcctListcompanycode(@RequestParam("company") String company) {
		List<PurchaseInvoiceHeaderBean> lBankAcctListcompany = null;

		lBankAcctListcompany = purchaseInvoiceService.getBankAcctListcompanycode(company);

		return lBankAcctListcompany;
	}

	@RequestMapping("/getgrnNo")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> grnNo(@RequestParam("grnNo") Integer grnNo) {
		List<PurchaseInvoiceHeaderBean> lBankAcctListcompany = null;

		lBankAcctListcompany = purchaseInvoiceService.grnNo(grnNo);

		return lBankAcctListcompany;
	}

	@RequestMapping("/budpo")
	public @ResponseBody PurchaseInvoiceHeaderBean budpo(@RequestParam("grnNo") Integer grnNo) {
		PurchaseInvoiceHeaderBean lBankAcctListcompany = new PurchaseInvoiceHeaderBean();

		lBankAcctListcompany = purchaseInvoiceService.budpo(grnNo);

		return lBankAcctListcompany;
	}

	@RequestMapping("/getgrnsupplier")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> getgrnsupplier(@RequestParam("supplier") String supplier) {
		List<PurchaseInvoiceHeaderBean> lBankAcctListcompany = null;

		lBankAcctListcompany = purchaseInvoiceService.getgrnsupplier(supplier);

		return lBankAcctListcompany;
	}

	@RequestMapping("/getChargeList")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> getChargeList() throws CustomException {
		List<PurchaseInvoiceHeaderBean> chargeList = new ArrayList<>();
		try {
			chargeList = purchaseInvoiceService.getChargeList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return chargeList;
	}

	@RequestMapping("/getItemList")
	public @ResponseBody List<PurchaseInvoiceHeaderBean> getItemList() throws CustomException {
		List<PurchaseInvoiceHeaderBean> lItemList = new ArrayList<>();
		try {
			lItemList = purchaseInvoiceService.getItemList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lItemList;
	}

	@RequestMapping("/list")
	public @ResponseBody PurchaseInvoiceResultBean getPurchaseInvoiceList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		PurchaseInvoiceResultBean objPurInvLstHdrResultBean = new PurchaseInvoiceResultBean();
		try {
			objPurInvLstHdrResultBean.setObjPuInvHdrLstBean(purchaseInvoiceService.getPurchaseInvoiceList());
			objPurInvLstHdrResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPurInvLstHdrResultBean;
	}

	@RequestMapping("/savePurInv")
	public @ResponseBody boolean savePurchaseInvoice(@RequestBody PurchaseInvoiceHeaderBean objPurchaseInvoiceBean) throws Exception {
		boolean isAdded = false;
		try {
			isAdded = purchaseInvoiceService.savePurchaseInvoice(objPurchaseInvoiceBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return isAdded;
	}

	@RequestMapping("/updatePurchaseInvoice")
	public @ResponseBody boolean updatePurchaseInvoice(@RequestBody PurchaseInvoiceHeaderBean objPurchaseInvoiceBean) throws Exception {
		boolean isupdated = false;
		try {
			isupdated = purchaseInvoiceService.updatePurchaseInvoice(objPurchaseInvoiceBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return isupdated;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deletePurchaseInvoice(@RequestBody String invoiceNO) throws Exception {
		boolean isDeleted = false;
		isDeleted = purchaseInvoiceService.deletePurchaseInvoice(invoiceNO);
		return isDeleted;
	}

	@RequestMapping("/getPurchaseInvoiceDetail")
	public @ResponseBody PurchaseInvoiceHeaderBean getPurchaseInvoiceDetail(@RequestParam("purchaseInvoiceNo") String sPurchaseInvoiceNo) throws CustomException {
		PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean = new PurchaseInvoiceHeaderBean();
		try {
			objPurchaseInvoiceListBean = purchaseInvoiceService.getPurchaseInvoiceDetail(sPurchaseInvoiceNo);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPurchaseInvoiceListBean;
	}

	@RequestMapping("/getGrnDetail")
	public @ResponseBody PurchaseInvoiceHeaderBean getGrnDetail(@RequestParam("grnNo") int igrnId) throws CustomException {
		PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean = new PurchaseInvoiceHeaderBean();
		try {
			objPurchaseInvoiceListBean = purchaseInvoiceService.getGrnDetail(igrnId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPurchaseInvoiceListBean;
	}

	@RequestMapping("/exportPurchaseInvoicePdf")
	public @ResponseBody PurchaseInvoiceResultBean exportToPurchaseInvoicePdf(@RequestParam("purchaseInvoiceNo") String puchaseInvoiceNo, HttpServletRequest request) throws Exception {
		PurchaseInvoiceResultBean objPurchaseInvoiceResultBean = new PurchaseInvoiceResultBean();
		ServletContext context = request.getServletContext();
		objPurchaseInvoiceResultBean.setSuccess(purchaseInvoiceService.exportToPurchaseInvoicePdf(puchaseInvoiceNo, context));
		return objPurchaseInvoiceResultBean;
	}

	@RequestMapping("/checkFreightCharges")
	public @ResponseBody PurchaseInvoiceHeaderBean checkFreightCharges(@RequestParam("grnNo") int igrnId) throws CustomException {
		PurchaseInvoiceHeaderBean headerBean = new PurchaseInvoiceHeaderBean();
		try {
			headerBean = purchaseInvoiceService.checkFreightCharges(igrnId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return headerBean;
	}

	@RequestMapping("/getEditcheckFreightCharges")
	public @ResponseBody PurchaseInvoiceHeaderBean getEditcheckFreightCharges(@RequestParam("grnNo") int igrnId) throws CustomException {
		PurchaseInvoiceHeaderBean headerBean = new PurchaseInvoiceHeaderBean();
		try {
			headerBean = purchaseInvoiceService.getEditcheckFreightCharges(igrnId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return headerBean;
	}

	@RequestMapping("/getExchangeRates")
	public @ResponseBody PurchaseInvoiceHeaderBean getExchangeRates(@RequestBody String currencyCode) {

		PurchaseInvoiceHeaderBean resultBean = new PurchaseInvoiceHeaderBean();
		try {
			resultBean = purchaseInvoiceService.getExchangeRates(currencyCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping("/getCurrencyCode")
	public @ResponseBody PurchaseInvoiceHeaderBean getCurrencyCode(@RequestBody String supplierCode) {

		PurchaseInvoiceHeaderBean resultBean = new PurchaseInvoiceHeaderBean();
		try {
			resultBean = purchaseInvoiceService.getCurrencyCode(supplierCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody PurchaseInvoiceResultBean uploadFile(MultipartFile file) throws CustomException {
		PurchaseInvoiceResultBean bookingRequest = new PurchaseInvoiceResultBean();
		String errorMessage = "";
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx") || fileName.endsWith("XLS") || fileName.endsWith("XLSX")) {
					errorMessage = purchaseInvoiceService.uploadFile(file);
					if (errorMessage.isEmpty()) {
						bookingRequest.setSuccess(true);
					} else {
						bookingRequest.setMessage(errorMessage);
						bookingRequest.setSuccess(false);
					}
				} else {
					bookingRequest.setSuccess(false);
					bookingRequest.setMessage("Not a valid file format");
					System.out.println("Not a valid file format");
				}

			} else {
				bookingRequest.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookingRequest;
	}

	@RequestMapping("/print")
	public ModelAndView printPurchaseInvoice(@RequestParam("puchaseInvoiceNo") String puchaseInvoiceNo) throws Exception {
		ModelAndView obj = null;
		obj = new ModelAndView("finance/transaction/print/printPurchaseInvoice");
		PurchaseInvoiceHeaderBean objBean = new PurchaseInvoiceHeaderBean();
		objBean = purchaseInvoiceService.getPurchaseInvoiceForView(puchaseInvoiceNo);

		obj.addObject("purchaseInvoiceList", objBean);

		return obj;
	}
}
