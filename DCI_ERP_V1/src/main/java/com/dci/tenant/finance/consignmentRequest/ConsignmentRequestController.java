package com.dci.tenant.finance.consignmentRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dci.common.util.BasicResultBean;
import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "app/hospital/purchase/consignmentRequest")
public class ConsignmentRequestController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ConsignmentRequestController.class);

	@Autowired
	private ConsignmentRequestService consignmentRequestService;

	@RequestMapping(value = "/list")
	public ConsignmentRequestResultBean getConsignmentRequestList() {
		ConsignmentRequestResultBean consignmentRequestResultBean = new ConsignmentRequestResultBean();
		try {

			consignmentRequestResultBean.setEmployeeList(consignmentRequestService.getConsignmentRequestList());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return consignmentRequestResultBean;

	}

	@RequestMapping(value = "/employeeList")
	public @ResponseBody ConsignmentRequestResultBean getEmployeeList() throws Exception {
		ConsignmentRequestResultBean consignmentRequestResultBean = new ConsignmentRequestResultBean();
		try {
			consignmentRequestResultBean = consignmentRequestService.getEmployeeList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return consignmentRequestResultBean;

	}

	@RequestMapping(value = "/itemList")
	public ConsignmentRequestResultBean getItemList(@RequestBody int itemId) {
		ConsignmentRequestResultBean consignmentRequetResultBean = new ConsignmentRequestResultBean();
		try {
			ConsignmentRequestSubBean consignmentRequetSubBean = consignmentRequestService.getItemList(itemId);
			consignmentRequetResultBean.setItemData(consignmentRequetSubBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consignmentRequetResultBean;
	}

	@RequestMapping(value = "/save")
	public @ResponseBody boolean save(@RequestBody ConsignmentRequestResultBean consignmentRequetResultBean) {

		boolean isSuccess = false;
		try {
			isSuccess = consignmentRequestService.insertConsignmentRequest(consignmentRequetResultBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping("/edit")
	public @ResponseBody ConsignmentRequestResultBean getConsignmentRequestById(@RequestBody int purchaseRequisitionId) throws Exception {
		ConsignmentRequestResultBean consignmentRequetResultBean = new ConsignmentRequestResultBean();
		consignmentRequetResultBean = consignmentRequestService.getConsignmentRequestById(purchaseRequisitionId);
		return consignmentRequetResultBean;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody ConsignmentRequestResultBean consignmentRequetResultBean) {
		boolean isSuccess = false;
		try {
			isSuccess = consignmentRequestService.updateConsignmentRequest(consignmentRequetResultBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int purchaseRequisitionId) throws Exception {
		boolean isDeleted = false;
		isDeleted = consignmentRequestService.deleteConsignmentRequest(purchaseRequisitionId);
		return isDeleted;
	}

	@RequestMapping("/issueStatus")
	public ConsignmentRequestResultBean issueStatus(@RequestParam("requisitionId") int reqId, @RequestParam("issueStatus") Integer issueStatus) {
		ConsignmentRequestResultBean consignmentRequetResultBean = new ConsignmentRequestResultBean();
		try {
			ConsignmentRequestSubBean consignmentRequetSubBean = consignmentRequestService.issueStatus(reqId, issueStatus);
			consignmentRequetResultBean.setItemData(consignmentRequetSubBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consignmentRequetResultBean;
	}

	@RequestMapping("/printMaterialRequestPDF")
	public ModelAndView printMaterialRequest(@RequestParam("materialReqId") Integer materialReqID) throws Exception {
		ModelAndView obj = null;
		obj = new ModelAndView("/sea/material/materialPrint");
		// String payerForIndiaBankDetails =
		// sStockTransferService.checkPayerForIndiaBankDetails(invoiceNo);
		ConsignmentRequestResultBean objGeneralInvoiceBean = new ConsignmentRequestResultBean();
		objGeneralInvoiceBean = consignmentRequestService.printMaterialRequest(materialReqID);

		obj.addObject("materialRequest", objGeneralInvoiceBean.getHeaderData());
		obj.addObject("materialRequestDetail", objGeneralInvoiceBean.getSubData());

		return obj;
	}

	@RequestMapping("/checkPRnumber")
	public BasicResultBean checkPRnumber(@RequestParam("prnumber") String prnumber) {
		BasicResultBean BasicResultBean = new BasicResultBean();

		try {
			BasicResultBean = consignmentRequestService.getPRnumberduplicate(prnumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BasicResultBean;

	}

	// checkPRnumberwithPR
	@RequestMapping("/checkPRnumberwithPR")
	public BasicResultBean checkPRnumberwithPR(@RequestParam("prnumber") String prnumber, @RequestParam("PRId") String PRid) {
		BasicResultBean BasicResultBean = new BasicResultBean();

		try {
			BasicResultBean = consignmentRequestService.getPRnumberduplicate(prnumber, PRid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BasicResultBean;

	}

	@RequestMapping("/uploadExefile")
	public @ResponseBody ConsignmentRequestResultBean uploadExeFile(MultipartFile file) throws CustomException {
		ConsignmentRequestResultBean consignmentRequestResultBean = new ConsignmentRequestResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					consignmentRequestResultBean = (consignmentRequestService.uploadExeFile(file));

				} else {
					consignmentRequestResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				consignmentRequestResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consignmentRequestResultBean;
	}

	@RequestMapping(value = "/updateApproveMR")
	public @ResponseBody boolean updateApproveMR(@RequestBody ConsignmentRequestResultBean consignmentRequetResultBean) {
		boolean isSuccess = false;
		try {
			isSuccess = consignmentRequestService.updateApproveMR(consignmentRequetResultBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}
}
