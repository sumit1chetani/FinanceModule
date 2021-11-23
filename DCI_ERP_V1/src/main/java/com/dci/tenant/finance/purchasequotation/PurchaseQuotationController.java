package com.dci.tenant.finance.purchasequotation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.DefTableBean;
import com.dci.master.settings.UOM.EntityBean;
import com.dci.tenant.common.CommonUtilityDAOImpl;
import com.dci.tenant.finance.storeToStore.StoreToStore;
import com.dci.tenant.user.UserDetail;

@RestController
@RequestMapping(value = "hospital/purchase/quotation")
public class PurchaseQuotationController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PurchaseQuotationController.class);

	@Autowired
	private IPurchaseQuotationService quotationService;

	/*@Autowired
	private CommonUtilityDAOImpl commonUtilityService;*/

	@RequestMapping(value = "/getAddDetails")
	public @ResponseBody PurchaseQuotationResultBean getAddDe() throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			/*List<DefTableBean> purchaseForList = commonUtilityService.getDefTableListnew(11);
			List<DefTableBean> purchaseTypeList = commonUtilityService.getDefTableListnew(12);
			List<DefTableBean> statusList = commonUtilityService.getDefTableListnew(13);
			List<EntityBean> vendorList = quotationService.getVendorList();
			List<DefTableBean> discountTypeList = commonUtilityService.getDefTableList1(28);*/
			List<StoreToStore> requisitionList = quotationService.getRequisitionList();
			List<DefTableBean> taxList = quotationService.getTaxList();
			/*quotationResultBean.setPurchaseForList(purchaseForList);
			quotationResultBean.setPurchaseTypeList(purchaseTypeList);
			quotationResultBean.setStatusList(statusList);
			quotationResultBean.setVendorList(vendorList);
			quotationResultBean.setDiscountTypeList(discountTypeList);*/
			quotationResultBean.setRequisitionList(requisitionList);
			quotationResultBean.setTaxList(taxList);

			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getRequsitionListbasedonCompany")
	public @ResponseBody PurchaseQuotationResultBean getRequsitionList(@RequestBody String companyId) throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			List<StoreToStore> requisitionList = quotationService.getRequisitionList(companyId);
			quotationResultBean.setRequisitionList(requisitionList);

			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getRequisitionList")
	public @ResponseBody PurchaseQuotationResultBean getRequisitionListByVendor(@RequestBody String vendorid) throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean.setRequisitionList(quotationService.getRequisitionListByVendor(vendorid));
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getQuotationList")
	public @ResponseBody PurchaseQuotationResultBean getQuotationList() throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean = quotationService.getPurchaseQuotationList();
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getItemList", method = RequestMethod.POST)
	public @ResponseBody PurchaseQuotationResultBean getItemList(@RequestBody PurchaseQuotation purchaseQuotation) throws Exception {

		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean = quotationService.getRequisitionItemList(purchaseQuotation);
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getItemListforWO", method = RequestMethod.POST)
	public @ResponseBody PurchaseQuotationResultBean getItemListforWO(@RequestBody PurchaseQuotation purchaseQuotation) throws Exception {

		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean = quotationService.getWOItemList(purchaseQuotation);
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getItem")
	public @ResponseBody PurchaseQuotationResultBean getItem(@RequestBody PurchaseQuotationDetail quotationDetail) throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			if (quotationDetail.getRequisitionId() != null)
				quotationResultBean = quotationService.getItem(quotationDetail.getRequisitionId(), quotationDetail.getItemId());
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error in getItem", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getVendorDetails")
	public @ResponseBody PurchaseQuotationResultBean getVendorDetails(@RequestParam("vendorId") String vendorId) throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean = quotationService.getVendorDetails(vendorId);
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getTaxDetails")
	public @ResponseBody PurchaseQuotationResultBean getTaxDetails(@RequestParam("taxId") int taxId) throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean = quotationService.getTaxDetails(taxId);
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/save")
	public @ResponseBody PurchaseQuotationResultBean saveQuotation(@RequestBody PurchaseQuotation purchaseQuotation) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetail user = (UserDetail) auth.getPrincipal();
		purchaseQuotation.setCreatedBy(user.getUserId());
		purchaseQuotation.setModifiedBy(user.getUserId());
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean = quotationService.insertPurchaseQuotation(purchaseQuotation);
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody PurchaseQuotationResultBean updatePurchaseQuotation(@RequestBody PurchaseQuotation purchaseQuotation) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetail user = (UserDetail) auth.getPrincipal();
		purchaseQuotation.setCreatedBy(user.getUserId());
		purchaseQuotation.setModifiedBy(user.getUserId());
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean = quotationService.updatePurchaseQuotation(purchaseQuotation);
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody PurchaseQuotationResultBean deleteQuotation(@RequestBody Integer quotationId) throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean = quotationService.deletePurchaseQuotation(quotationId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getPurchaseQuotationDataOnEdit")
	public @ResponseBody PurchaseQuotation getPurchaseQuoteDataOnEdit(@RequestParam("quotationId") Integer quotationId) throws Exception {
		PurchaseQuotation objPurchaseQuotation = new PurchaseQuotation();
		try {
			objPurchaseQuotation = quotationService.getPurchaseQuoteDataOnEdit(quotationId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPurchaseQuotation;
	}

	@RequestMapping(value = "/checkPurchaseQuotationNumber")
	public @ResponseBody PurchaseQuotationResultBean checkPurchaseQuotationNumber(@RequestBody PurchaseQuotationDetail purchaseQuotation) throws Exception {
		PurchaseQuotationResultBean objPurchaseQuotation = new PurchaseQuotationResultBean();
		try {
			objPurchaseQuotation = quotationService.checkPurchaseQuotationNumber(purchaseQuotation);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPurchaseQuotation;
	}

	@RequestMapping("/uploadEmployeeExcel")
	public @ResponseBody PurchaseQuotationResultBean uploadMemberExcel(MultipartFile file) throws Exception {
		PurchaseQuotationResultBean DwellTimeInvoice = new PurchaseQuotationResultBean();
		boolean isSuccess = false;
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					DwellTimeInvoice = quotationService.uploadFile(file);
					if (DwellTimeInvoice.isSuccess()) {
						DwellTimeInvoice.setSuccess(true);
						DwellTimeInvoice.setMessage("Verify Excel Data Before Upload");
					} else {
						DwellTimeInvoice.setSuccess(false);

					}
				}
			}
		} catch (Exception e) {
			DwellTimeInvoice.setSuccess(false);
			DwellTimeInvoice.setMessage(e.getMessage());
		}
		return DwellTimeInvoice;
	}

	@RequestMapping("/uploadEmployeeExcel1")
	public @ResponseBody PurchaseQuotationResultBean uploadMemberExcel1(MultipartFile file) throws Exception {
		PurchaseQuotationResultBean DwellTimeInvoice = new PurchaseQuotationResultBean();
		boolean isSuccess = false;
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					DwellTimeInvoice = quotationService.uploadFile1(file);
					if (DwellTimeInvoice.isSuccess()) {
						DwellTimeInvoice.setSuccess(true);
						DwellTimeInvoice.setMessage("Verify Excel Data Before Upload");
					} else {
						DwellTimeInvoice.setSuccess(false);

					}
				}
			}
		} catch (Exception e) {
			DwellTimeInvoice.setSuccess(false);
			DwellTimeInvoice.setMessage(e.getMessage());
		}
		return DwellTimeInvoice;
	}

	@RequestMapping("/uploadEmployeeExcel2")
	public @ResponseBody PurchaseQuotationResultBean uploadMemberExcel2(MultipartFile file) throws Exception {
		PurchaseQuotationResultBean DwellTimeInvoice = new PurchaseQuotationResultBean();
		boolean isSuccess = false;
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					DwellTimeInvoice = quotationService.uploadFile2(file);
					if (DwellTimeInvoice.isSuccess()) {
						DwellTimeInvoice.setSuccess(true);
						DwellTimeInvoice.setMessage("Verify Excel Data Before Upload");
					} else {
						DwellTimeInvoice.setSuccess(false);

					}
				}
			}
		} catch (Exception e) {
			DwellTimeInvoice.setSuccess(false);
			DwellTimeInvoice.setMessage(e.getMessage());
		}
		return DwellTimeInvoice;
	}

	@RequestMapping(value = "/getItemIndividual")
	public PurchaseQuotationResultBean getItem(@RequestParam("requisitionId") Integer requisitionId, @RequestParam("itemId") Integer itemId) throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			if (requisitionId != null)
				quotationResultBean = quotationService.getItem(requisitionId, itemId);
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getWOitemList")
	public PurchaseQuotationResultBean getWOitemList(@RequestParam("requisitionId") Integer requisitionId, @RequestParam("itemId") Integer itemId) throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			quotationResultBean = quotationService.getWOItem(requisitionId, itemId);
			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}

	@RequestMapping(value = "/getWorkOrderLists")
	public @ResponseBody PurchaseQuotationResultBean getWorkOrderList(@RequestBody String companyId) throws Exception {
		PurchaseQuotationResultBean quotationResultBean = new PurchaseQuotationResultBean();
		try {
			List<StoreToStore> requisitionList = quotationService.getWorkOrderList(companyId);
			quotationResultBean.setRequisitionList(requisitionList);

			quotationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return quotationResultBean;
	}
}
