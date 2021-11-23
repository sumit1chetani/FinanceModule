package com.dci.tenant.finance.tax.taxpayment;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class TaxPaymentResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	List<TaxPaymentBean> taxPaymentBeanList;

	public List<TaxPaymentBean> getTaxPaymentBeanList() {
		return taxPaymentBeanList;
	}

	public void setTaxPaymentBeanList(List<TaxPaymentBean> taxPaymentBeanList) {
		this.taxPaymentBeanList = taxPaymentBeanList;
	}

}
