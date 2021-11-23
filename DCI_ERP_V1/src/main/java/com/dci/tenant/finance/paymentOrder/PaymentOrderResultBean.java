package com.dci.tenant.finance.paymentOrder;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class PaymentOrderResultBean extends BasicResultBean implements Serializable {
	private List<PaymentOrderBean> paymentOrderBeanslist;

	private List<PaymentOrderBankBean> cahbankList;

	public List<PaymentOrderBean> getPaymentOrderBeanslist() {
		return paymentOrderBeanslist;
	}

	public void setPaymentOrderBeanslist(List<PaymentOrderBean> paymentOrderBeanslist) {
		this.paymentOrderBeanslist = paymentOrderBeanslist;
	}

	public List<PaymentOrderBankBean> getCahbankList() {
		return cahbankList;
	}

	public void setCahbankList(List<PaymentOrderBankBean> cahbankList) {
		this.cahbankList = cahbankList;
	}
}
