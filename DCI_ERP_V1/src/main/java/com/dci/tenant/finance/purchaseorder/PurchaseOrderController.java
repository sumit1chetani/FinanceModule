package com.dci.tenant.finance.purchaseorder;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.tenant.common.CommonUtilityService;
import com.dci.tenant.finance.consignmentRequest.ConsignmentRequestSubBean;
import com.dci.tenant.user.UserDetail;

@RestController
@RequestMapping("app/purchaseOrder")
public class PurchaseOrderController {

	@Autowired
	PurchaseOrderService purchaseOrderService;

	@Autowired
	CommonUtilityService commonUtilityService;

	@RequestMapping("/purchaseList")
	public PurchaseOrderResultBean getPurchaseList(@RequestParam("purchaseType") int purchaseType, @RequestParam("formCode") String formCode) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrderResultBean objPurchaseMasterResultBean = new PurchaseOrderResultBean();
		objPurchaseMasterResultBean.setPurchaseOrders(purchaseOrderService.getPurchaseOrderList(purchaseType));
		objPurchaseMasterResultBean.setSuccess(true);
		return objPurchaseMasterResultBean;
	}

	@RequestMapping("/totalPurchaseList")
	public PurchaseOrderResultBean getTotalPurchaseList() throws Exception {
		PurchaseOrderResultBean objPurchaseMasterResultBean = new PurchaseOrderResultBean();
		objPurchaseMasterResultBean.setPurchaseOrders(purchaseOrderService.getTotalPurchaseOrderList());
		objPurchaseMasterResultBean.setSuccess(true);
		return objPurchaseMasterResultBean;
	}

	@RequestMapping("/getListOfDropdowns")
	public PurchaseOrderResultBean getListOfDropdowns() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrderResultBean objPurchaseOrderResultBean = new PurchaseOrderResultBean();
		objPurchaseOrderResultBean.setPurchaseFrom(purchaseOrderService.getPurchaseOrderDefList(PurchaseConstants.PURCHASEFROM_FORMID));
		objPurchaseOrderResultBean.setPurchaseTo(purchaseOrderService.getPurchaseOrderDefList(PurchaseConstants.PURCHASETO_FORMID));
		objPurchaseOrderResultBean.setPurchaseStatus(purchaseOrderService.getPurchaseOrderDefList(PurchaseConstants.PURCHASESTATUS_FORMID));
		objPurchaseOrderResultBean.setLocationList(purchaseOrderService.getLocationNames());
		objPurchaseOrderResultBean.setVendorList(purchaseOrderService.getVendorNames());
		objPurchaseOrderResultBean.setPurchaseReqDropDownList(purchaseOrderService.getPurchaseReqDropDown());
		objPurchaseOrderResultBean.setPurchaseOrderDropDownList(purchaseOrderService.getPurchaseOrderDropDown());
		objPurchaseOrderResultBean.setPurchaseInvoiceDropDownList(purchaseOrderService.getPurchaseInvoiceDropDown());
		objPurchaseOrderResultBean.setMaterialIssueDropDownList(purchaseOrderService.getMaterialIssueDropDown());
		objPurchaseOrderResultBean.setPurchaseOrderStatusDropDownList(purchaseOrderService.getPurchaseOrderStatusDropDown());
		objPurchaseOrderResultBean.setGrnStatusDropDownList(purchaseOrderService.getGRNStatusDropDown());
		objPurchaseOrderResultBean.setCompanyList(purchaseOrderService.getCompanyNames(userDetails.getUserId()));
		objPurchaseOrderResultBean.setCommonUtilityBeans(commonUtilityService.getParentLocationList());

		objPurchaseOrderResultBean.setConTransferNoList(purchaseOrderService.getConsignmentTransferNumbers());
		objPurchaseOrderResultBean.setTermsAndConditions(PurchaseConstants.TERMS_CONDITIONS.toString());
		objPurchaseOrderResultBean.setSuccess(true);
		return objPurchaseOrderResultBean;
	}

	@RequestMapping("/getListOfDropdowns1")
	public PurchaseOrderResultBean getListOfDropdowns1() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrderResultBean objPurchaseOrderResultBean = new PurchaseOrderResultBean();
		objPurchaseOrderResultBean.setPurchaseFrom(purchaseOrderService.getPurchaseOrderDefList1(PurchaseConstants.PURCHASEFROM_FORMID));
		objPurchaseOrderResultBean.setPurchaseTo(purchaseOrderService.getPurchaseOrderDefList1(PurchaseConstants.PURCHASETO_FORMID));
		objPurchaseOrderResultBean.setPurchaseStatus(purchaseOrderService.getPurchaseOrderDefList(PurchaseConstants.PURCHASESTATUS_FORMID));
		objPurchaseOrderResultBean.setLocationList(purchaseOrderService.getLocationNames());
		objPurchaseOrderResultBean.setVendorList(purchaseOrderService.getVendorNames());
		objPurchaseOrderResultBean.setCompanyList(purchaseOrderService.getCompanyNames(userDetails.getUserId()));
	//	objPurchaseOrderResultBean.setCommonUtilityBeans(commonUtilityService.getParentLocationList());
		objPurchaseOrderResultBean.setConTransferNoList(purchaseOrderService.getConsignmentTransferNumbers());
		objPurchaseOrderResultBean.setTermsAndConditions(PurchaseConstants.TERMS_CONDITIONS.toString());
		objPurchaseOrderResultBean.setSuccess(true);
		return objPurchaseOrderResultBean;
	}

	@RequestMapping("/getListOfDropdownsEdit")
	public PurchaseOrderResultBean getListOfDropdownsEdit() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrderResultBean objPurchaseOrderResultBean = new PurchaseOrderResultBean();
		objPurchaseOrderResultBean.setPurchaseFrom(purchaseOrderService.getPurchaseOrderDefList(PurchaseConstants.PURCHASEFROM_FORMID));
		objPurchaseOrderResultBean.setPurchaseTo(purchaseOrderService.getPurchaseOrderDefList(PurchaseConstants.PURCHASETO_FORMID));
		objPurchaseOrderResultBean.setPurchaseStatus(purchaseOrderService.getPurchaseOrderDefList(PurchaseConstants.PURCHASESTATUS_FORMID));
		objPurchaseOrderResultBean.setLocationList(purchaseOrderService.getLocationNames());
		objPurchaseOrderResultBean.setVendorList(purchaseOrderService.getVendorNames());
		objPurchaseOrderResultBean.setCompanyList(purchaseOrderService.getCompanyNames(userDetails.getUserId()));
	//	objPurchaseOrderResultBean.setCommonUtilityBeans(commonUtilityService.getParentLocationList());
		objPurchaseOrderResultBean.setConTransferNoList(purchaseOrderService.getConsignmentTransferNumbersEdit());
		objPurchaseOrderResultBean.setTermsAndConditions(PurchaseConstants.TERMS_CONDITIONS.toString());
		objPurchaseOrderResultBean.setSuccess(true);
		return objPurchaseOrderResultBean;
	}

	@RequestMapping("/savePurchaseOrder")
	public BasicResultBean savePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BasicResultBean result = new BasicResultBean();
		result = purchaseOrderService.savePurchaseOrder(purchaseOrder, userDetails.getUserId());
		// if (r {
		// result.setMessage("Inserted Sucessfully");
		// if(result.isSuccess())
		// result.setSuccess(true);
		// result.setType("sucess");
		// }
		return result;
	}

	@RequestMapping("/deletePurchaseOrder")
	public boolean deletePurchaseOrder(@RequestParam("purchaseOrderId") int purchaseOrderId) throws Exception {
		boolean isDelete = purchaseOrderService.deletePurchaseOrder(purchaseOrderId);
		return isDelete;
	}

	@RequestMapping("/editPurchaseOrder")
	public PurchaseOrder editPurchaseOrder(@RequestParam("purchaseOrderId") int purchaseOrderId) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.getPurchaseOrder(purchaseOrderId);
		purchaseOrder.setUserId(userDetails.getUserId());
		purchaseOrder.setUserName(userDetails.getUserFullName());
		return purchaseOrder;
	}

	@RequestMapping("/getItemIndividual")
	public PurchaseOrder getItemIndividual(@RequestParam("requisitionId") String requisitionNo, @RequestParam("itemId") int itemId, @RequestParam("qty") double quantity) throws Exception {
		// UserDetail userDetails = (UserDetail)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.getitemList(requisitionNo, itemId, quantity);
		// purchaseOrder.setUserId(userDetails.getUserId());
		// purchaseOrder.setUserName(userDetails.getUserFullName());
		return purchaseOrder;
	}

	@RequestMapping("/updatePurchaseOrder")
	public BasicResultBean updatePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.updatePurchaseOrder(purchaseOrder, userDetails.getUserId());
		if (isSaved) {
			result.setMessage("Inserted Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return result;
	}

	@RequestMapping("/deletePurchaseOrderDetail")
	public boolean deletePurchaseOrderDetail(@RequestParam("purchaseOrderDetailId") int purchaseOrderDetailId) throws Exception {
		boolean isDelete = purchaseOrderService.deletePurchaseOrderDetail(purchaseOrderDetailId);
		return isDelete;
	}

	@RequestMapping("/getApprovedPurchasedDetail")
	public List<PurchaseQuoteDetail> getApprovedPurchaseQuote(@RequestParam("purchaseDateFrom") String purchaseDateFrom, @RequestParam("purchaseDateTo") String purchaseDateTo, @RequestParam("status") int status, @RequestParam("entityId") String entityId, @RequestParam("quoteStatus") int quoteStatus, @RequestParam("purchaseType") int purchaseType) throws Exception {
		List<PurchaseQuoteDetail> purchaseQuoteDetail = new ArrayList<>();
		purchaseQuoteDetail = purchaseOrderService.getApprovedPurchaseQuote(purchaseDateFrom, purchaseDateTo, status, entityId, quoteStatus, purchaseType);
		return purchaseQuoteDetail;
	}

	@RequestMapping("/getApprovedPurchasedDetail1")
	public List<PurchaseQuoteDetail> getApprovedPurchaseQuote1(@RequestParam("status") int status, @RequestParam("entityId") String entityId, @RequestParam("purchaseType") int purchaseType, @RequestParam("poNumber") String poNumber) throws Exception {
		List<PurchaseQuoteDetail> purchaseQuoteDetail = new ArrayList<>();
		purchaseQuoteDetail = purchaseOrderService.getApprovedPurchaseQuote1(status, entityId, purchaseType, poNumber);
		return purchaseQuoteDetail;
	}

	@RequestMapping("/getApprovedPurchasedDetailRateContract")
	public List<PurchaseQuoteDetail> getApprovedPurchasedDetailRateContract(@RequestParam("purchaseDateFrom") String purchaseDateFrom, @RequestParam("purchaseDateTo") String purchaseDateTo, @RequestParam("status") int status, @RequestParam("entityId") int entityId, @RequestParam("quoteStatus") int quoteStatus, @RequestParam("purchaseType") int purchaseType) throws Exception {
		List<PurchaseQuoteDetail> purchaseQuoteDetail = new ArrayList<>();
		purchaseQuoteDetail = purchaseOrderService.getApprovedPurchasedDetailRateContract(purchaseDateFrom, purchaseDateTo, status, entityId, quoteStatus, purchaseType);
		return purchaseQuoteDetail;
	}

	@RequestMapping("/getDetailStatus")
	public PurchaseOrderResultBean getDetailStatus() throws Exception {
		PurchaseOrderResultBean objPurchaseOrderResultBean = new PurchaseOrderResultBean();
		objPurchaseOrderResultBean.setPurchaseStatus(purchaseOrderService.getPurchaseOrderDefList(PurchaseConstants.DETAIL_PURCHASESTATUS_FORMID));
		objPurchaseOrderResultBean.setSuccess(true);
		return objPurchaseOrderResultBean;
	}

	@RequestMapping("/updatePurchaseOrderStatus")
	public PurchaseOrderResultBean updatePurchaseOrderStatus(@RequestParam("statusId") int statusId, @RequestParam("costCenter") int costCenter, @RequestParam("purchaseOrderId") int purchaseOrderId, @RequestParam(value = "remarks", required = false) String remarks, @RequestParam("budget") int budget) throws Exception {
		PurchaseOrderResultBean objPurchaseOrderResultBean = new PurchaseOrderResultBean();
		if (remarks == null) {
			objPurchaseOrderResultBean.setSuccess(purchaseOrderService.updatePurchaseOrderStatus(statusId, costCenter, purchaseOrderId, budget));
			objPurchaseOrderResultBean.setSuccess(true);
		} else {
			objPurchaseOrderResultBean.setSuccess(purchaseOrderService.updatePurchaseOrderCancelStatus(statusId, costCenter, purchaseOrderId, remarks, budget));
			objPurchaseOrderResultBean.setSuccess(true);

		}

		return objPurchaseOrderResultBean;
	}

	@RequestMapping("/updatePurchaseOrderCancelStatus")
	public PurchaseOrderResultBean updatePurchaseOrderCancelStatus(@RequestParam("statusId") int statusId, @RequestParam("costCenter") int costCenter, @RequestParam("purchaseOrderId") int purchaseOrderId, @RequestParam(value = "remarks", required = false) String remarks, @RequestParam("budget") int budget) throws Exception {
		PurchaseOrderResultBean objPurchaseOrderResultBean = new PurchaseOrderResultBean();
		if (remarks == null) {
			objPurchaseOrderResultBean.setSuccess(purchaseOrderService.updatePurchaseOrderWithoutRemarkStatus(costCenter, statusId, purchaseOrderId, budget));
		} else {
			objPurchaseOrderResultBean.setSuccess(purchaseOrderService.updatePurchaseOrderCancelRemarksStatus(statusId, purchaseOrderId, remarks));
		}

		return objPurchaseOrderResultBean;
	}

	@RequestMapping("/saveRateContract")
	public BasicResultBean saveRateContract(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.saveRateContract(purchaseOrder, userDetails.getUserId());
		if (isSaved) {
			result.setMessage("Inserted Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return result;
	}

	@RequestMapping("/editPurchaseOrderDelivery")
	public PurchaseOrder editPurchaseOrderDelivery(@RequestParam("purchaseOrderId") int purchaseOrderId) throws Exception {

		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.getDeliveryPurchaseOrder(purchaseOrderId);
		return purchaseOrder;
	}

	@RequestMapping("/updatePurchaseOrderDelivery")
	public BasicResultBean updatePurchaseOrderDelivery(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.updateDeliveryPurchaseOrder(purchaseOrder, userDetails.getUserId());
		if (isSaved) {
			result.setMessage("Updated Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return result;
	}

	@RequestMapping("/updatePurchaseOrderDeliverySchedule")
	public BasicResultBean updatePurchaseOrderDeliverySchedule(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.updatePurchaseOrderDeliverySchedule(purchaseOrder, userDetails.getUserId());
		if (isSaved) {
			result.setMessage("Updated Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return result;
	}

	@RequestMapping("/getPurchaseAmendmentList")
	public PurchaseOrderResultBean getPurchaseAmendmentList() throws Exception {
		PurchaseOrderResultBean objPurchaseMasterResultBean = new PurchaseOrderResultBean();
		objPurchaseMasterResultBean.setPurchaseOrders(purchaseOrderService.getPurchaseOrderAmendmentList());
		objPurchaseMasterResultBean.setSuccess(true);
		return objPurchaseMasterResultBean;
	}

	@RequestMapping("/editPurchaseOrderAmendment")
	public PurchaseOrder editPurchaseOrderAmendment(@RequestParam("purchaseOrderId") int purchaseOrderId) throws Exception {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.getPurchaseOrderAmendment(purchaseOrderId);
		return purchaseOrder;
	}

	@RequestMapping("/updatePurchaseOrderAmendment")
	public BasicResultBean updatePurchaseOrderAmendment(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.updateDeliveryPurchaseOrderAmendment(purchaseOrder, userDetails.getUserId());
		if (isSaved) {
			result.setMessage("Updated Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return result;
	}

	/*
	 * @RequestMapping("/CheckPOAmendmentNo") public BasicResultBean
	 * CheckPOAmendmentNo(@RequestBody PurchaseOrder purchaseOrder) throws Exception
	 * { UserDetail userDetails = (UserDetail)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * BasicResultBean result = new BasicResultBean(); boolean isSaved =
	 * purchaseOrderService.CheckPOAmendmentNo(purchaseOrder,
	 * userDetails.getUserId()); if (isSaved) {
	 * result.setMessage("Updated Sucessfully"); result.setSuccess(true);
	 * result.setType("sucess"); } return result; }
	 */

	@RequestMapping("/getApprovedPurchasedStockDetail")
	public List<PurchaseQuoteDetail> getApprovedPurchaseStockQuote(@RequestParam("purchaseDateFrom") String purchaseDateFrom, @RequestParam("purchaseDateTo") String purchaseDateTo, @RequestParam("status") int status, @RequestParam("entityId") int entityId, @RequestParam("quoteStatus") int quoteStatus, @RequestParam("stockTransferId") int stockTransferId) throws Exception {
		List<PurchaseQuoteDetail> purchaseQuoteDetail = new ArrayList<>();
		purchaseQuoteDetail = purchaseOrderService.getApprovedPurchaseConsignmentTransferNumbers(purchaseDateFrom, purchaseDateTo, status, entityId, quoteStatus, stockTransferId);
		return purchaseQuoteDetail;
	}

	@RequestMapping("/getApprovedConsignmentStockDetail")
	public List<PurchaseQuoteDetail> getApprovedConsignmentStockDetail(@RequestParam("stockTransferId") String stockTransferId, @RequestParam("purchaseType") int purchaseType) throws Exception {
		List<PurchaseQuoteDetail> purchaseQuoteDetail = new ArrayList<>();
		purchaseQuoteDetail = purchaseOrderService.getApprovedConsignmentStockDetail(stockTransferId);
		return purchaseQuoteDetail;
	}

	@RequestMapping("/saveConsignmentOrder")
	public BasicResultBean saveConsignmentOrder(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.saveConsignmentOrder(purchaseOrder, userDetails.getUserId());
		if (isSaved) {
			result.setMessage("Inserted Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return result;
	}

	@RequestMapping("/updateConsignmentOrder")
	public BasicResultBean updateConsignmentOrder(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.updateConsignmentOrder(purchaseOrder, userDetails.getUserId());
		if (isSaved) {
			result.setMessage("Updated Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return result;
	}

	@RequestMapping("/cancelPurchaseList")
	public PurchaseOrderResultBean getCancelPurchaseList() throws Exception {
		PurchaseOrderResultBean objPurchaseMasterResultBean = new PurchaseOrderResultBean();
		objPurchaseMasterResultBean.setPurchaseOrders(purchaseOrderService.getTotalPurchaseOrderCancelList());
		objPurchaseMasterResultBean.setSuccess(true);
		return objPurchaseMasterResultBean;
	}

	@RequestMapping("/filteredPurchaseOrderList")
	public PurchaseOrderResultBean getFilteredPurchaseOrderList(@RequestBody PurchaseFilter purchaseFilter) throws Exception {
		PurchaseOrderResultBean objPurchaseMasterResultBean = new PurchaseOrderResultBean();
		objPurchaseMasterResultBean.setPurchaseOrders(purchaseOrderService.getFilteredPurchaseOrderList(purchaseFilter));
		objPurchaseMasterResultBean.setSuccess(true);
		return objPurchaseMasterResultBean;
	}

	@RequestMapping("/filterDropDownList")
	public PurchaseOrderResultBean getfilterDropDownList() throws Exception {
		PurchaseOrderResultBean objPurchaseMasterResultBean = new PurchaseOrderResultBean();
		objPurchaseMasterResultBean.setItemList(purchaseOrderService.getItemList());
		objPurchaseMasterResultBean.setVendorList(purchaseOrderService.getVendorNames());
		objPurchaseMasterResultBean.setPurchaseStatus(purchaseOrderService.getPurchaseOrderDefList(PurchaseConstants.PURCHASESTATUS_FORMID));
		objPurchaseMasterResultBean.setSuccess(true);
		return objPurchaseMasterResultBean;
	}

	@RequestMapping("/purchaseSplitList")
	public PurchaseOrderResultBean getpurchaseSplitList() throws Exception {
		PurchaseOrderResultBean objPurchaseMasterResultBean = new PurchaseOrderResultBean();
		objPurchaseMasterResultBean.setPurchaseOrders(purchaseOrderService.getPurchaseOrderSplitList());
		objPurchaseMasterResultBean.setSuccess(true);
		return objPurchaseMasterResultBean;
	}

	@RequestMapping(value = "/exportPurchaseOrderPdf")
	public PurchaseOrderResultBean exportToExaminationLabReportPDF(@RequestParam("purchaseOrderId") int purchaseOrderId, HttpServletRequest request) throws Exception {
		PurchaseOrderResultBean objInvestigateReportBean = new PurchaseOrderResultBean();
		ServletContext context = request.getServletContext();
		objInvestigateReportBean.setSuccess(purchaseOrderService.exportPurchaseOrderPDF(purchaseOrderId, context));
		return objInvestigateReportBean;
	}

	@RequestMapping("/purchaseMergeList")
	public PurchaseOrderResultBean getpurchaseMergeList() throws Exception {
		PurchaseOrderResultBean objPurchaseMasterResultBean = new PurchaseOrderResultBean();
		objPurchaseMasterResultBean.setPurchaseOrders(purchaseOrderService.getPurchaseOrderForMerge());
		objPurchaseMasterResultBean.setSuccess(true);
		return objPurchaseMasterResultBean;
	}

	@RequestMapping("/updatemergePurchaseOrder")
	public BasicResultBean updatemergePurchaseOrder(@RequestParam("cancelpurchaseOrderId") int cancelpurchaseOrderId, @RequestParam("mergepurchaseOrderId") int mergepurchaseOrderId) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.updatePurchaseOrderMergeStatus(cancelpurchaseOrderId, mergepurchaseOrderId, userDetails.getUserId());
		if (isSaved) {
			result.setMessage("Updated Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return result;
	}

	@RequestMapping("/updatePurchaseRecommend")
	public PurchaseOrderResultBean updatePurchaseRecommend(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		PurchaseOrderResultBean objPurchaseOrderResultBean = new PurchaseOrderResultBean();
		objPurchaseOrderResultBean.setSuccess(purchaseOrderService.updatePurchaseRecommend(purchaseOrder));
		return objPurchaseOrderResultBean;
	}

	@RequestMapping("/getNotScheduledItemList")
	public PurchaseOrderResultBean getNotScheduledItemList(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		PurchaseOrderResultBean objPurchaseOrderResultBean = new PurchaseOrderResultBean();
		objPurchaseOrderResultBean.setPurchaseOrders(purchaseOrderService.getNotScheduledItemList(purchaseOrder));
		objPurchaseOrderResultBean.setSuccess(true);
		return objPurchaseOrderResultBean;
	}

	@RequestMapping("/saveSplitPurchaseOrder")
	public PurchaseOrderResultBean saveSplitPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrderResultBean objPurchaseOrderResultBean = new PurchaseOrderResultBean();
		objPurchaseOrderResultBean.setSuccess(purchaseOrderService.saveSplitPurchaseOrder(purchaseOrder, userDetails.getUserId()));
		return objPurchaseOrderResultBean;
	}

	// /deletepqdetail

	@RequestMapping("/deletepqdetail")
	public boolean deletepqdetail(@RequestParam("purchaseOrderDetailId") Integer purchaseOrderDetailId) throws Exception {
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.deletepqdetail(purchaseOrderDetailId);
		if (isSaved) {
			result.setMessage("Deleted Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return isSaved;

	}

	@RequestMapping("/deletepqdetail1")
	public boolean deletepqdetail1(@RequestParam("purchaseOrderDetailId") Integer purchaseOrderDetailId) throws Exception {
		BasicResultBean result = new BasicResultBean();
		boolean isSaved = purchaseOrderService.deletepqdetail1(purchaseOrderDetailId);
		if (isSaved) {
			result.setMessage("Deleted Sucessfully");
			result.setSuccess(true);
			result.setType("sucess");
		}
		return isSaved;

	}

	@RequestMapping("/getVendordetails")
	public PurchaseOrder getVendordetails(@RequestParam("vendorId") String vendorId) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.getVendordetails(vendorId);
		// purchaseOrder.setUserId(userDetails.getUserId());
		// purchaseOrder.setUserName(userDetails.getUserFullName());
		return purchaseOrder;
	}

	// /currencyList

	@RequestMapping("/currencyList")
	public List<SelectivityBean> currencyList() throws Exception {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		List<SelectivityBean> currencyList = new ArrayList<>();
		currencyList = purchaseOrderService.getCurrency();
		// purchaseOrder.setUserId(userDetails.getUserId());
		// purchaseOrder.setUserName(userDetails.getUserFullName());
		return currencyList;
	}

	// /BudgetTypeList

	@RequestMapping("/BudgetTypeList")
	public List<SelectivityBean> BudgetTypeList(@RequestParam("potype") String poType) throws Exception {
		List<SelectivityBean> BudgetTypeList = new ArrayList<>();
		BudgetTypeList = purchaseOrderService.BudgetTypeList(poType);
		// purchaseOrder.setUserId(userDetails.getUserId());
		// purchaseOrder.setUserName(userDetails.getUserFullName());
		return BudgetTypeList;
	}

	/*
	 * @RequestMapping("/printPurchaseOrder") public ModelAndView
	 * printPurchaseOrder(@RequestParam("purchaseOrderId") String purchaseOrderID)
	 * throws Exception { ModelAndView obj = null; obj = new
	 * ModelAndView("finance/transaction/print/printGeneralInvoiceBoth");
	 * PrintPurchaseOrderBean objPurchaseOrderHeaderBean = new
	 * PrintPurchaseOrderBean(); PrintPurchaseOrderDetailBean
	 * objPurchaseOrderDetailBean = new PrintPurchaseOrderDetailBean();
	 * 
	 * objPurchaseOrderHeaderBean =
	 * purchaseOrderService.printPurchaseOrderHeader(purchaseOrderID);
	 * objPurchaseOrderDetailBean =
	 * purchaseOrderService.printPurchaseOrderDetail(purchaseOrderID);
	 * 
	 * obj.addObject("setEditData", objPurchaseOrderDetailBean);
	 * 
	 * obj.addObject("generalInvoiceList", objPurchaseOrderHeaderBean);
	 * 
	 * return obj; }
	 */

	@RequestMapping("/printPurchaseOrderPDF")
	public ModelAndView printGeneralInvoice(@RequestParam("purchaseOrderId") Integer purchaseOrderNo) throws Exception {
		ModelAndView obj = null;
		//obj = new ModelAndView("/hospital/purchase/purchaseOrder/purchaseOrderPrint");
		obj = new ModelAndView("/sea/orderdci/orderdciPrint");

		// String payerForIndiaBankDetails =
		// sStockTransferService.checkPayerForIndiaBankDetails(invoiceNo);
		PrintPurchaseOrderBean objGeneralInvoiceBean = new PrintPurchaseOrderBean();
		objGeneralInvoiceBean = purchaseOrderService.printPurchaseOrder(purchaseOrderNo);

		obj.addObject("generalInvoiceList", objGeneralInvoiceBean);
		// obj.addObject("payerIndia", payerForIndiaBankDetails);

		return obj;
	}

	@RequestMapping("/getPOSequenceNumber")
	public BasicResultBean getPOSequenceNumber(@RequestParam("POType") String POType) throws Exception {
		BasicResultBean bean = new BasicResultBean();

		String posequence = purchaseOrderService.getPOSequenceNumber(POType);
		bean.setMessage(posequence);
		bean.setSuccess(true);
		return bean;

	}

	@RequestMapping("/getPOSequenceNumberbasedonCompany")
	public BasicResultBean getPOSeqCompanybased(@RequestParam("POType") String POType, @RequestParam("companyId") String companyId) throws Exception {
		BasicResultBean bean = new BasicResultBean();

		String posequence = purchaseOrderService.getPOSeqCompanybased(POType, companyId);
		bean.setMessage(posequence);
		bean.setSuccess(true);
		return bean;

	}

	@RequestMapping("/updatePendingqty")
	public PurchaseOrder updatePendingqty(@RequestParam("requisitionId") String requisitionNo, @RequestParam("itemId") int itemId, @RequestParam("poId") int poId) throws Exception {
		// UserDetail userDetails = (UserDetail)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.updatePendingqty(requisitionNo, itemId, poId);
		// purchaseOrder.setUserId(userDetails.getUserId());
		// purchaseOrder.setUserName(userDetails.getUserFullName());
		return purchaseOrder;
	}

	@RequestMapping("/getqtyValidation")
	public PurchaseOrder getqtyValidation(@RequestParam("requisitionId") int requisitionNo, @RequestParam("itemId") int itemId, @RequestParam("poId") int poId) throws Exception {
		// UserDetail userDetails = (UserDetail)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.getqtyValidation(requisitionNo, itemId, poId);
		// purchaseOrder.setUserId(userDetails.getUserId());
		// purchaseOrder.setUserName(userDetails.getUserFullName());
		return purchaseOrder;
	}

	@RequestMapping("/costcenterList")
	public List<ConsignmentRequestSubBean> costcenterList(@RequestParam("companyId") String companyId) throws Exception {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		// List<SelectivityBean> currencyList = new ArrayList<>();
		List<ConsignmentRequestSubBean> costList = new ArrayList<>();

		costList = purchaseOrderService.costcenterList(companyId);
		// purchaseOrder.setUserId(userDetails.getUserId());
		// purchaseOrder.setUserName(userDetails.getUserFullName());
		return costList;

	}

	@RequestMapping("/editPurchaseOrderLog")
	public PurchaseOrder editPurchaseOrderLog(@RequestParam("purchaseOrderNumber") String purchaseOrderNumber) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.getPurchaseOrderLog(purchaseOrderNumber);
		purchaseOrder.setUserId(userDetails.getUserId());
		purchaseOrder.setUserName(userDetails.getUserFullName());
		return purchaseOrder;
	}

	@RequestMapping("/getAvailableQTY")
	public PurchaseOrder getAvailableQTY(@RequestParam("requisitionId") int requisitionNo, @RequestParam("itemId") int itemId) throws Exception {
		// UserDetail userDetails = (UserDetail)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.getAvailableQTY(requisitionNo, itemId);
		// purchaseOrder.setUserId(userDetails.getUserId());
		// purchaseOrder.setUserName(userDetails.getUserFullName());
		return purchaseOrder;
	}

	@RequestMapping("/getqtycheckFromPO")
	public PurchaseOrder getqtycheckFromPO(@RequestParam("requisitionId") int requisitionNo, @RequestParam("itemId") int itemId, @RequestParam("poId") int poId) throws Exception {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = purchaseOrderService.getqtycheckFromPO(requisitionNo, itemId, poId);

		return purchaseOrder;
	}

	@RequestMapping("/geYearlytBudgetAmount")
	public PurchaseOrder geYearlytBudgetAmount(@RequestBody PurchaseOrder purchaseOrder) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PurchaseOrder result = new PurchaseOrder();
		result = purchaseOrderService.geYearlytBudgetAmount(purchaseOrder, userDetails.getUserId());

		return result;
	}

	@RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
	public @ResponseBody boolean exportExcel(@RequestBody PurchaseOrder PurchaseOrder, HttpServletRequest request, HttpServletResponse response) {
		List<PurchaseOrder> rsList = new ArrayList<>();
	//	InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();

		boolean isSuccess = false;
		try {
			rsList = purchaseOrderService.getPurchaseOrderExportList(PurchaseOrder.getPurchaseType());
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			isSuccess = purchaseOrderService.exportExcel(ConfigurationProps.exportFilesPath, rsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
