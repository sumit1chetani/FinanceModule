package com.dci.tenant.finance.generalInvoice;

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
@RequestMapping(value = "app/generalinvoice")
public class GeneralInvoiceController {

	private final static Logger LOGGER = LoggerFactory.getLogger(GeneralInvoiceController.class);

	@Autowired
	GeneralInvoiceService objGeneralInvoiceService;

	@RequestMapping("/list")
	public @ResponseBody GeneralInvoiceResultBean getGeneralInvoiceList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws Exception {
		GeneralInvoiceResultBean objGeneralInvoiceResultBean = new GeneralInvoiceResultBean();
		objGeneralInvoiceResultBean.setlGeneralInvoiceList(objGeneralInvoiceService.getGeneralInvoiceList(limit, offset));
		objGeneralInvoiceResultBean.setSuccess(true);
		return objGeneralInvoiceResultBean;
	}

	@RequestMapping("/getCompanyList")
	public @ResponseBody List<GeneralInvoiceBean> getCompanyList() throws CustomException {
		List<GeneralInvoiceBean> lCompanyList = new ArrayList<>();
		try {
			lCompanyList = objGeneralInvoiceService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCompanyList;
	}

	@RequestMapping("/print")
	public ModelAndView printPaymentVoucher(@RequestParam("invoiceNo") String invoiceNo) throws Exception {
		ModelAndView obj = null;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		obj = new ModelAndView("print/printGeneralInvoice");

		GeneralInvoiceBean objCashBankPaymentBean = new GeneralInvoiceBean();

		objCashBankPaymentBean = objGeneralInvoiceService.printPaymentVoucher(invoiceNo);

		obj.addObject("paymentVoucherList", objCashBankPaymentBean);
		obj.addObject("userName", userName);

		return obj;
	}

	@RequestMapping("/getCustomerList")
	public @ResponseBody List<GeneralInvoiceBean> getCustomerList() throws CustomException {
		List<GeneralInvoiceBean> lCustomerList = new ArrayList<>();

		try {
			lCustomerList = objGeneralInvoiceService.getCustomerList();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCustomerList;
	}

	@RequestMapping("/getCustomertrue")
	public @ResponseBody List<GeneralInvoiceBean> getCustomertrue() throws CustomException {
		List<GeneralInvoiceBean> lCustomerList = new ArrayList<>();

		try {
			lCustomerList = objGeneralInvoiceService.getCustomertrue();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCustomerList;
	}

	@RequestMapping("/getCurrencyList")
	public @ResponseBody List<GeneralInvoiceBean> getCurrencyList() throws CustomException {
		List<GeneralInvoiceBean> lCurrencyList = new ArrayList<>();

		try {
			lCurrencyList = objGeneralInvoiceService.getCurrencyList();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCurrencyList;
	}

	@RequestMapping("/getExchangeRate")
	public @ResponseBody double getExchangeRate(@RequestParam("currencyCode") String CurrencyCode) throws CustomException {
		double dExchangeRate = 1.0;
		try {
			dExchangeRate = objGeneralInvoiceService.getExchangeRate(CurrencyCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return dExchangeRate;
	}

	@RequestMapping("/getAccountHeadList")
	public @ResponseBody List<GeneralInvoiceBean> getAccountHeadList() throws CustomException {
		List<GeneralInvoiceBean> lAccountHeadList = new ArrayList<>();

		try {
			lAccountHeadList = objGeneralInvoiceService.getAccountHeadList();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lAccountHeadList;
	}

	@RequestMapping("/getSalesOrderList")
	public @ResponseBody List<GeneralInvoiceBean> getSalesOrderList() throws CustomException {
		List<GeneralInvoiceBean> lsalesOrderList = new ArrayList<>();

		try {
			lsalesOrderList = objGeneralInvoiceService.getSalesOrderList();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lsalesOrderList;
	}

	@RequestMapping("/getGinList")
	public @ResponseBody List<GeneralInvoiceBean> getGinList() throws CustomException {
		List<GeneralInvoiceBean> ginList = new ArrayList<>();

		try {
			ginList = objGeneralInvoiceService.getGinList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return ginList;
	}

	@RequestMapping("/save")
	public @ResponseBody boolean saveGeneralInvoice(@RequestBody GeneralInvoiceBean objGeneralInvoiceBean) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = objGeneralInvoiceService.saveGeneralInvoice(objGeneralInvoiceBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteGeneralInvoice(@RequestBody String sInvoiceNo) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = objGeneralInvoiceService.deleteGeneralInvoice(sInvoiceNo);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/getInvoiceDetail")
	public @ResponseBody GeneralInvoiceBean getInvoiceDetail(@RequestParam("InvoiceNo") String sInvoiceNo) throws CustomException {
		GeneralInvoiceBean objGeneralInvoiceBean = new GeneralInvoiceBean();
		try {
			objGeneralInvoiceBean = objGeneralInvoiceService.getInvoiceDetail(sInvoiceNo);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objGeneralInvoiceBean;
	}

	@RequestMapping("/update")
	public @ResponseBody boolean updateGeneralInvoice(@RequestBody GeneralInvoiceBean objGeneralInvoiceBean) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = objGeneralInvoiceService.updateGeneralInvoice(objGeneralInvoiceBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/getItemList")
	public @ResponseBody List<GeneralInvoiceBean> getItemList() throws CustomException {
		List<GeneralInvoiceBean> lItemList = new ArrayList<>();
		try {
			lItemList = objGeneralInvoiceService.getItemList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lItemList;
	}

	@RequestMapping("/getSODetail")
	public @ResponseBody GeneralInvoiceBean getSODetail(@RequestParam("soNo") int soNo) throws CustomException {
		GeneralInvoiceBean objGeneralInvoiceBean = new GeneralInvoiceBean();
		try {
			objGeneralInvoiceBean = objGeneralInvoiceService.getSODetail(soNo);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objGeneralInvoiceBean;
	}

	@RequestMapping("/getGinDetailList")
	public @ResponseBody GeneralInvoiceBean getGinDetailList(@RequestParam("ginId") int ginId) throws CustomException {
		GeneralInvoiceBean objGeneralInvoiceBean = new GeneralInvoiceBean();
		try {
			objGeneralInvoiceBean = objGeneralInvoiceService.getGinDetailList(ginId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objGeneralInvoiceBean;
	}

	@RequestMapping("/exportGeneralInvoicePdf")
	public @ResponseBody GeneralInvoiceResultBean exportToGeneralInvoicePdf(@RequestParam("invoiceNo") String invoiceNo, HttpServletRequest request) throws Exception {
		GeneralInvoiceResultBean objGeneralInvoiceResultBean = new GeneralInvoiceResultBean();
		ServletContext context = request.getServletContext();
		objGeneralInvoiceResultBean.setSuccess(objGeneralInvoiceService.exportToGeneralInvoicePdf(invoiceNo, context));
		return objGeneralInvoiceResultBean;
	}
}