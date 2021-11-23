package com.dci.inventory.stocktransfer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "hospital/inventory/stocktransfer")
public class StockTransferController {
	@Autowired
	StockTransferService sStockTransferService;

	@RequestMapping(value = "/getDropdownData")
	public StockTransferResultBean getDropdown() {

		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			stockTransferResultBean.setoStockTransferBean(sStockTransferService.getDropdown());
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/getList")
	public StockTransferResultBean getListPage() {

		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			stockTransferResultBean.setlStockTransferBean(sStockTransferService.getListPage());
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/getItem")
	public @ResponseBody List<StockTransferBean> getItem(@RequestParam("companyId") String companyId) throws CustomException {
		List<StockTransferBean> itemlist = new ArrayList<>();
		try {
			itemlist = sStockTransferService.getItem(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemlist;
	}

	@RequestMapping(value = "/delete")
	public StockTransferResultBean deleteStock(@RequestBody int id) {

		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			sStockTransferService.deleteStock(id);
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/editData")
	public StockTransferResultBean getEditData(@RequestBody int id) {

		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			stockTransferResultBean.setlStockTransferBean(sStockTransferService.getEditData(id));
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/RequisitionItem")
	public StockTransferResultBean getItemrequisition(@RequestBody String id) {

		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			stockTransferResultBean.setlStockTransferBean(sStockTransferService.getItemrequisition(id));
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/RequisitionItem1")
	public StockTransferResultBean getItemrequisition1(@RequestBody String id) {

		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			stockTransferResultBean.setlStockTransferBean(sStockTransferService.getItemrequisition1(id));
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/getBatchNoDetails")
	public StockTransferResultBean getBatchNoDetails(@RequestParam("sourceLoc") int sourceLoc, @RequestParam("itemCode") int itemId) {
		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			stockTransferResultBean.setlStockTransferBatchBean(sStockTransferService.getBatchNoDetails(itemId, sourceLoc));
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/getDtlList")
	public StockTransferResultBean getDtlList(@RequestParam("itemCode") int itemId, @RequestParam("destLoc") int destLoc, @RequestParam("companyId") String companyId) {
		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			stockTransferResultBean.setlStockTransferBean(sStockTransferService.getDtlList(itemId, destLoc, companyId));
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/save")
	public StockTransferResultBean save(@RequestBody StockTransferBean bean) {

		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			sStockTransferService.InsertStockHdr(bean);
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/save1")
	public StockTransferResultBean save1(@RequestBody StockTransferBean bean) {

		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			sStockTransferService.InsertStockHdr1(bean);
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/update")
	public StockTransferResultBean updateStockHdr(@RequestBody StockTransferBean bean) {

		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			sStockTransferService.updateStockHdr(bean);
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping("/print")
	public ModelAndView printGeneralInvoice(@RequestParam("id") int invoiceNo) throws Exception {
		ModelAndView obj = null;
		obj = new ModelAndView("/inventory/stockMovement/stockMovementPrint");
		// String payerForIndiaBankDetails =
		// sStockTransferService.checkPayerForIndiaBankDetails(invoiceNo);
		StockTransferBean objGeneralInvoiceBean = new StockTransferBean();
		objGeneralInvoiceBean = sStockTransferService.getGeneralInvoiceForView(invoiceNo);

		obj.addObject("generalInvoiceList", objGeneralInvoiceBean);
		// obj.addObject("payerIndia", payerForIndiaBankDetails);

		return obj;
	}

	@RequestMapping("/uploadExefile")
	public @ResponseBody StockTransferResultBean uploadExeFile(MultipartFile file) throws CustomException {
		StockTransferResultBean StockTransferResultBean = new StockTransferResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					StockTransferResultBean = (sStockTransferService.uploadExeFile(file));

				} else {
					StockTransferResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				StockTransferResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StockTransferResultBean;
	}

	@RequestMapping(value = "/IssueTypeList")
	public @ResponseBody List<SelectivityBean> IssueTypeList() throws CustomException {
		List<SelectivityBean> issueTypeList = new ArrayList<>();
		try {
			issueTypeList = sStockTransferService.issueTypeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return issueTypeList;
	}

	@RequestMapping(value = "/ItemList")
	public @ResponseBody List<StockTransferBean> ItemList(@RequestParam("destId") int destId, @RequestParam("companyId") String companyId) throws CustomException {
		List<StockTransferBean> issueTypeList = new ArrayList<>();
		try {
			issueTypeList = sStockTransferService.ItemList(destId, companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return issueTypeList;
	}

	@RequestMapping(value = "/getQtyFromStock")
	public @ResponseBody StockTransferBean getQtyFromStock(@RequestParam("itemCode") int itemCode, @RequestParam("destId") int destId, @RequestParam("companyId") String companyId) throws CustomException {
		StockTransferBean issueTypeList = new StockTransferBean();
		try {
			String requisitionDetailId = "";
			issueTypeList = sStockTransferService.getQtyFromStock(itemCode, destId, companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return issueTypeList;
	}

	// @RequestMapping(value = "/saveKitchenBase")
	// public StockTransferResultBean saveKitchenBase(@RequestBody
	// StockTransferBean bean) {

	@RequestMapping(value = "/saveKitchenBase")
	public StockTransferResultBean saveKitchenBase(@RequestBody StockTransferBean bean) {
		StockTransferResultBean stockTransferResultBean = new StockTransferResultBean();
		try {
			sStockTransferService.InsertStockHdrKitchen(bean);
			stockTransferResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockTransferResultBean;
	}

	@RequestMapping(value = "/getRequisitionListCompanyBased")
	public @ResponseBody List<StockTransferBean> getRequisitionListCompanyBased(@RequestParam("companyId") String companyId) throws CustomException {
		List<StockTransferBean> requestList = new ArrayList<StockTransferBean>();
		try {
			requestList = sStockTransferService.getRequisitionListCompanyBased(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestList;
	}
}
