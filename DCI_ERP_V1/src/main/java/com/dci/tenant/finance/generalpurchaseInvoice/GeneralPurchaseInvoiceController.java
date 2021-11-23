package com.dci.tenant.finance.generalpurchaseInvoice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;

@Controller
@RequestMapping(value = "app/generalpurchaseinvoice")
public class GeneralPurchaseInvoiceController {

	private final static Logger LOGGER = LoggerFactory.getLogger(GeneralPurchaseInvoiceController.class);

	@Autowired
	private GeneralPurchaseInvoiceService generalPurchaseInvoiceService;

	@RequestMapping("/getSupplierList")
	public @ResponseBody List<GeneralPurchaseInvoiceHeaderBean> getSupplierList() throws CustomException {
		List<GeneralPurchaseInvoiceHeaderBean> listVendormaster = new ArrayList<>();
		try {
			listVendormaster = generalPurchaseInvoiceService.getSupplierList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return listVendormaster;
	}

	@RequestMapping("/getGrnList")
	public @ResponseBody List<GeneralPurchaseInvoiceHeaderBean> getGrnList() throws CustomException {
		List<GeneralPurchaseInvoiceHeaderBean> purchaseNoList = new ArrayList<>();
		try {
			purchaseNoList = generalPurchaseInvoiceService.getGrnList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return purchaseNoList;
	}

	///////////////////
	@RequestMapping("/getWoList")
	public @ResponseBody List<GeneralPurchaseInvoiceHeaderBean> getWoList() throws CustomException {
		List<GeneralPurchaseInvoiceHeaderBean> wonumberist = new ArrayList<>();
		try {
			wonumberist = generalPurchaseInvoiceService.getWoList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return wonumberist;
	}

	/*
	 * @RequestMapping("/getCostCenterList") public @ResponseBody
	 * List<GeneralPurchaseInvoiceHeaderBean> getCostCenterList(@RequestBody
	 * String company) throws CustomException {
	 * List<GeneralPurchaseInvoiceHeaderBean> wonumberist = new ArrayList<>();
	 * try { wonumberist =
	 * generalPurchaseInvoiceService.getCostCenterList(company); } catch
	 * (Exception e) { LOGGER.error("Error", e); throw new CustomException(); }
	 * 
	 * return wonumberist; }
	 */

	@RequestMapping("/getCostCenterList")
	public @ResponseBody List getCostCenterList(@RequestParam("companyCode") String companyCode) throws CustomException {
		List costList = new ArrayList();

		try {
			costList = generalPurchaseInvoiceService.getCostCenterList(companyCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return costList;
	}

	@RequestMapping("/getDtl")
	public @ResponseBody GeneralPurchaseInvoiceHeaderBean getDtl(@RequestParam("num") Integer num) throws CustomException {

		GeneralPurchaseInvoiceHeaderBean stockTransferResultBean = new GeneralPurchaseInvoiceHeaderBean();
		List<GeneralPurchaseInvoiceHeaderBean> itemList = new ArrayList<>();

		try {
			itemList = generalPurchaseInvoiceService.getDtl(num);
			stockTransferResultBean.setItemList(itemList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException();
		}
		return stockTransferResultBean;
	}

	/*
	 * public @ResponseBody List getdtl(@RequestParam("wonumber") String
	 * wonumber) throws CustomException { List costList = new ArrayList();
	 * 
	 * try { costList = generalPurchaseInvoiceService.getdtl(wonumber);
	 * 
	 * } catch (Exception e) { LOGGER.error("Error", e); throw new
	 * CustomException(); }
	 * 
	 * return costList; }
	 */

	@RequestMapping("/getCompanyList")
	public @ResponseBody List<GeneralPurchaseInvoiceHeaderBean> getCompanyList() throws CustomException {
		List<GeneralPurchaseInvoiceHeaderBean> purchaseNoList = new ArrayList<>();
		try {
			purchaseNoList = generalPurchaseInvoiceService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return purchaseNoList;
	}

	@RequestMapping("/getChargeList")
	public @ResponseBody List<GeneralPurchaseInvoiceHeaderBean> getChargeList() throws CustomException {
		List<GeneralPurchaseInvoiceHeaderBean> chargeList = new ArrayList<>();
		try {
			chargeList = generalPurchaseInvoiceService.getChargeList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return chargeList;
	}

	@RequestMapping("/getItemList")
	public @ResponseBody List<GeneralPurchaseInvoiceHeaderBean> getItemList() throws CustomException {
		List<GeneralPurchaseInvoiceHeaderBean> lItemList = new ArrayList<>();
		try {
			lItemList = generalPurchaseInvoiceService.getItemList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lItemList;
	}

	@RequestMapping("/list")
	public @ResponseBody GeneralPurchaseInvoiceResultBean getPurchaseInvoiceList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		GeneralPurchaseInvoiceResultBean objPurInvLstHdrResultBean = new GeneralPurchaseInvoiceResultBean();
		try {
			objPurInvLstHdrResultBean.setObjPuInvHdrLstBean(generalPurchaseInvoiceService.getPurchaseInvoiceList());
			objPurInvLstHdrResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPurInvLstHdrResultBean;
	}

	/*
	 * @RequestMapping("/savePurInv") public @ResponseBody boolean
	 * savePurchaseInvoice(@RequestBody GeneralPurchaseInvoiceHeaderBean
	 * objPurchaseInvoiceBean) throws Exception { boolean isAdded = false; try {
	 * isAdded =
	 * generalPurchaseInvoiceService.savePurchaseInvoice(objPurchaseInvoiceBean)
	 * ; } catch (Exception e) { LOGGER.error("Error", e); throw new
	 * CustomException();
	 * 
	 * } return isAdded; }
	 */
	@RequestMapping("/savePurInv")
	public @ResponseBody boolean savePurchaseInvoice(@RequestBody GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceBean) throws Exception {
		boolean isAdded = false;
		GeneralPurchaseInvoiceResultBean result = new GeneralPurchaseInvoiceResultBean();
		try {
			isAdded = generalPurchaseInvoiceService.savePurchaseInvoice(objPurchaseInvoiceBean);
			result.setSuccess(isAdded);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return isAdded;
	}

	@RequestMapping("/updatePurchaseInvoice")
	public @ResponseBody boolean updatePurchaseInvoice(@RequestBody GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceBean) throws Exception {
		boolean isupdated = false;
		try {
			isupdated = generalPurchaseInvoiceService.updatePurchaseInvoice(objPurchaseInvoiceBean);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return isupdated;
	}

	/*
	 * @RequestMapping("/save") public BudgetTypeResultBean save(@RequestBody
	 * BudgetTypeBean allocationBean) { try {
	 * resultBean.setSuccess(budgetTypeService.save(allocationBean)); } catch
	 * (Exception e) { LOGGER.error("Error", e); } return resultBean; }
	 */
	@RequestMapping("/delete")
	public @ResponseBody boolean deletePurchaseInvoice(@RequestBody String invoiceNO) throws Exception {
		boolean isDeleted = false;
		isDeleted = generalPurchaseInvoiceService.deletePurchaseInvoice(invoiceNO);
		return isDeleted;
	}

	@RequestMapping("/getPurchaseInvoiceDetail")
	public @ResponseBody GeneralPurchaseInvoiceHeaderBean getPurchaseInvoiceDetail(@RequestParam("purchaseInvoiceNo") String sPurchaseInvoiceNo) throws CustomException {
		GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceListBean = new GeneralPurchaseInvoiceHeaderBean();
		try {
			objPurchaseInvoiceListBean = generalPurchaseInvoiceService.getPurchaseInvoiceDetail(sPurchaseInvoiceNo);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPurchaseInvoiceListBean;
	}

	@RequestMapping("/getGrnDetail")
	public @ResponseBody GeneralPurchaseInvoiceHeaderBean getGrnDetail(@RequestParam("grnNo") int igrnId) throws CustomException {
		GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceListBean = new GeneralPurchaseInvoiceHeaderBean();
		try {
			objPurchaseInvoiceListBean = generalPurchaseInvoiceService.getGrnDetail(igrnId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPurchaseInvoiceListBean;
	}

	@RequestMapping("/exportPurchaseInvoicePdf")
	public @ResponseBody GeneralPurchaseInvoiceResultBean exportToPurchaseInvoicePdf(@RequestParam("purchaseInvoiceNo") String puchaseInvoiceNo, HttpServletRequest request) throws Exception {
		GeneralPurchaseInvoiceResultBean objPurchaseInvoiceResultBean = new GeneralPurchaseInvoiceResultBean();
		ServletContext context = request.getServletContext();
		objPurchaseInvoiceResultBean.setSuccess(generalPurchaseInvoiceService.exportToPurchaseInvoicePdf(puchaseInvoiceNo, context));
		return objPurchaseInvoiceResultBean;
	}

	@RequestMapping("/checkFreightCharges")
	public @ResponseBody GeneralPurchaseInvoiceHeaderBean checkFreightCharges(@RequestParam("grnNo") int igrnId) throws CustomException {
		GeneralPurchaseInvoiceHeaderBean headerBean = new GeneralPurchaseInvoiceHeaderBean();
		try {
			headerBean = generalPurchaseInvoiceService.checkFreightCharges(igrnId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return headerBean;
	}

	@RequestMapping("/getEditcheckFreightCharges")
	public @ResponseBody GeneralPurchaseInvoiceHeaderBean getEditcheckFreightCharges(@RequestParam("grnNo") int igrnId) throws CustomException {
		GeneralPurchaseInvoiceHeaderBean headerBean = new GeneralPurchaseInvoiceHeaderBean();
		try {
			headerBean = generalPurchaseInvoiceService.getEditcheckFreightCharges(igrnId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return headerBean;
	}

	@RequestMapping("/getExchangeRates")
	public @ResponseBody GeneralPurchaseInvoiceHeaderBean getExchangeRates(@RequestBody String currencyCode) {

		GeneralPurchaseInvoiceHeaderBean resultBean = new GeneralPurchaseInvoiceHeaderBean();
		try {
			resultBean = generalPurchaseInvoiceService.getExchangeRates(currencyCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping("/getCurrencyCode")
	public @ResponseBody GeneralPurchaseInvoiceHeaderBean getCurrencyCode(@RequestBody String supplierCode) {

		GeneralPurchaseInvoiceHeaderBean resultBean = new GeneralPurchaseInvoiceHeaderBean();
		try {
			resultBean = generalPurchaseInvoiceService.getCurrencyCode(supplierCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping("/print")
	public ModelAndView printPaymentVoucher(@RequestParam("cbVoucherNo") String voucherNo) throws Exception {
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		obj = new ModelAndView("print/printGeneralPurchaseInvoice");

		GeneralPurchaseInvoiceHeaderBean objCashBankPaymentBean = new GeneralPurchaseInvoiceHeaderBean();

		objCashBankPaymentBean = generalPurchaseInvoiceService.printPaymentVoucher(voucherNo);

		obj.addObject("paymentVoucherList", objCashBankPaymentBean);
		obj.addObject("userName", userName);

		return obj;
	}
	
	
}
