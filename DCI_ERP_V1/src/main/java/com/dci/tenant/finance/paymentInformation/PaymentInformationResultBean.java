package com.dci.tenant.finance.paymentInformation;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class PaymentInformationResultBean extends BasicResultBean implements Serializable {
	private List<PaymentInformationBean> informationBeanslist;
	private List<PaymentInformationDetailBean> informationDtlBeanslist;
	private List<PaymentInformationBean> lPaymentInformationList;
	private List<PaymentInformationBean> lQuotationBean;

	private List<PaymentInformationBean> searchList;

	public List<PaymentInformationBean> getlPaymentInformationList() {
		return lPaymentInformationList;
	}

	public void setlPaymentInformationList(List<PaymentInformationBean> lPaymentInformationList) {
		this.lPaymentInformationList = lPaymentInformationList;
	}

	public List<PaymentInformationBean> getlQuotationBean() {
		return lQuotationBean;
	}

	public void setlQuotationBean(List<PaymentInformationBean> lQuotationBean) {
		this.lQuotationBean = lQuotationBean;
	}

	public List<PaymentInformationBean> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<PaymentInformationBean> searchList) {
		this.searchList = searchList;
	}

	public List<PaymentInformationBean> getInformationBeanslist() {
		return informationBeanslist;
	}

	public void setInformationBeanslist(List<PaymentInformationBean> informationBeanslist) {
		this.informationBeanslist = informationBeanslist;
	}

	public List<PaymentInformationDetailBean> getInformationDtlBeanslist() {
		return informationDtlBeanslist;
	}

	public void setInformationDtlBeanslist(List<PaymentInformationDetailBean> informationDtlBeanslist) {
		this.informationDtlBeanslist = informationDtlBeanslist;
	}
}
