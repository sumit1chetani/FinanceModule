package com.dci.tenant.finance.generalInvoice;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class GeneralInvoiceResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<GeneralInvoiceBean> lGeneralInvoiceList;

	public List<GeneralInvoiceBean> getlGeneralInvoiceList() {
		return lGeneralInvoiceList;
	}

	public void setlGeneralInvoiceList(List<GeneralInvoiceBean> lGeneralInvoiceList) {
		this.lGeneralInvoiceList = lGeneralInvoiceList;
	}

}
