package com.dci.tenant.finance.paymentInformation;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "app/paymentInformation")
public class PaymentInformationController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PaymentInformationController.class);

	@Autowired
	public PaymentInformationService informationService;

	@RequestMapping(value = "/list")
	public @ResponseBody PaymentInformationResultBean getPaymentInforDtlist(@RequestBody PaymentInformationBean informationBean) {
		PaymentInformationResultBean paymentInformationDetailBean = new PaymentInformationResultBean();
		try {
			paymentInformationDetailBean.setInformationDtlBeanslist(informationService.getPaymentInforDtlist(informationBean));
		} catch (Exception e) {

		}

		return paymentInformationDetailBean;
	}

	@RequestMapping(value = "/getlist")
	public PaymentInformationResultBean getlist() {
		PaymentInformationResultBean paymentInformationDetailBean = new PaymentInformationResultBean();
		try {
			paymentInformationDetailBean.setInformationBeanslist(informationService.getlist());
		} catch (Exception e) {

		}

		return paymentInformationDetailBean;
	}

	@RequestMapping(value = "/getlistDraft")
	public PaymentInformationResultBean getlistDraft() {
		PaymentInformationResultBean paymentInformationDetailBean = new PaymentInformationResultBean();
		try {
			paymentInformationDetailBean.setInformationBeanslist(informationService.getlistDraft());
		} catch (Exception e) {

		}

		return paymentInformationDetailBean;
	}

	@RequestMapping(value = "/save")
	public boolean saveData(@RequestBody PaymentInformationBean informationBean) {
		boolean isSuccess = true;
		try {
			isSuccess = informationService.saveData(informationBean);
		} catch (Exception e) {

		}
		return isSuccess;

	}

	@RequestMapping(value = "/update")
	public boolean updateData(@RequestBody PaymentInformationBean informationBean) {
		boolean isSuccess = true;
		try {
			isSuccess = informationService.updateData(informationBean);
		} catch (Exception e) {

		}
		return isSuccess;

	}

	@RequestMapping(value = "/edit")
	public @ResponseBody PaymentInformationBean editData(@RequestBody PaymentInformationBean informationBean) {
		PaymentInformationBean paymentInformationBean = new PaymentInformationBean();
		boolean isSuccess = true;
		try {
			paymentInformationBean = informationService.editData(informationBean);
		} catch (Exception e) {

		}
		return paymentInformationBean;

	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteData(@RequestBody String paymentInformationNo) throws Exception {
		boolean isDeleted = false;
		try {
			isDeleted = informationService.deleteData(paymentInformationNo);
		} catch (Exception e) {

		}
		return isDeleted;
	}

	@RequestMapping("/updateApprove")
	public @ResponseBody boolean approvedata(@RequestBody ArrayList<PaymentInformationBean> informationBean) throws Exception {
		boolean isDeleted = false;
		try {
			isDeleted = informationService.approvedata(informationBean);
		} catch (Exception e) {

		}
		return isDeleted;
	}

	@RequestMapping(value = "/ExportExcel", method = RequestMethod.POST)
	public @ResponseBody PaymentInformationResultBean getExcelReportExportList(@RequestBody PaymentInformationBean objPendingapprovalBean, HttpServletRequest request, HttpServletResponse response) throws CustomException {
		PaymentInformationResultBean PaymentInformationResultBean = new PaymentInformationResultBean();
		List<PaymentInformationBean> lQuotationBean = new ArrayList<>();

		try {

			System.out.println("List Of  fee excel");
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			// quotationResultBean.setlQuotationBean(ObjPendingapprovalService.getList(objPendingapprovalBean));
			// PaymentInformationResultBean.setSearchList(informationService.searchportDtl(objPendingapprovalBean));
			PaymentInformationResultBean.setInformationBeanslist(informationService.getlist());

			informationService.excellExport(PaymentInformationResultBean, objPendingapprovalBean, sFilePath);

			PaymentInformationResultBean.setSuccess(true);
		} catch (Exception e) {
			System.out.println(e);

		}
		return PaymentInformationResultBean;
	}

	@RequestMapping("/showPendingReceiptInformationList")
	public @ResponseBody PaymentInformationResultBean showPendingReceiptInformationList(@RequestBody PaymentInformationBean objPaymentInformationBean) throws CustomException, InterruptedException {
		PaymentInformationResultBean objPaymentInformationResultBean = new PaymentInformationResultBean();
		try {
			objPaymentInformationResultBean.setlPaymentInformationList(informationService.showPendingReceiptInformationList(objPaymentInformationBean));
			objPaymentInformationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPaymentInformationResultBean;
	}

	@RequestMapping("/showPendingPaymentInformationList")
	public @ResponseBody PaymentInformationResultBean showPendingPaymentInformationList(@RequestBody PaymentInformationBean objPaymentInformationBean) throws CustomException, InterruptedException {
		PaymentInformationResultBean objPaymentInformationResultBean = new PaymentInformationResultBean();
		try {
			objPaymentInformationResultBean.setlPaymentInformationList(informationService.showPendingPaymentInformationList(objPaymentInformationBean));
			objPaymentInformationResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objPaymentInformationResultBean;
	}

}
