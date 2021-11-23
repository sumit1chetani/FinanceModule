package com.dci.tenant.finance.paymentOrder;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "app/paymentOrder")
public class PaymentOrderController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PaymentOrderController.class);

	@Autowired
	public PaymentOrderService paymentOrderService;

	@RequestMapping(value = "/list")
	public @ResponseBody PaymentOrderResultBean getPaymentOrderList() {
		PaymentOrderResultBean paymentOrderResultBean = new PaymentOrderResultBean();
		try {
			paymentOrderResultBean.setPaymentOrderBeanslist(paymentOrderService.getPaymentOrderList());
		} catch (Exception e) {

		}

		return paymentOrderResultBean;
	}

	@RequestMapping(value = "/accountlist")
	public @ResponseBody PaymentOrderResultBean getCashBankList() {
		PaymentOrderResultBean paymentOrderResultBean = new PaymentOrderResultBean();
		try {
			paymentOrderResultBean.setCahbankList(paymentOrderService.getCashBankList());
		} catch (Exception e) {

		}

		return paymentOrderResultBean;
	}

	@RequestMapping(value = "/searchList")
	public @ResponseBody PaymentOrderResultBean searchList(@RequestBody String companyCode) {
		PaymentOrderResultBean paymentOrderResultBean = new PaymentOrderResultBean();
		try {
			paymentOrderResultBean.setPaymentOrderBeanslist(paymentOrderService.searchList(companyCode));
			paymentOrderResultBean.setSuccess(true);

		} catch (Exception e) {

		}

		return paymentOrderResultBean;
	}

	@RequestMapping(value = "/getChequeList")
	public @ResponseBody PaymentOrderResultBean getChequeList(@RequestBody String AccountCode) {
		PaymentOrderResultBean paymentOrderResultBean = new PaymentOrderResultBean();
		try {
			paymentOrderResultBean.setCahbankList(paymentOrderService.getChequeList(AccountCode));
		} catch (Exception e) {

		}

		return paymentOrderResultBean;
	}

	@RequestMapping(value = "/generatePayment")
	public @ResponseBody PaymentOrderResultBean generatePayment(@RequestBody ArrayList<PaymentOrderBean> paymentOrderList) {
		PaymentOrderResultBean paymentOrderResultBean = new PaymentOrderResultBean();
		try {
			paymentOrderResultBean.setCahbankList(paymentOrderService.generatePayment(paymentOrderList));
		} catch (Exception e) {

		}

		return paymentOrderResultBean;
	}

}
