package com.dci.payroll.tds.taxsection;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class TaxsectionResultBean extends BasicResultBean implements Serializable {

	private List<TaxsectionBean> taxsectionList;

	private TaxsectionBean taxsection = new TaxsectionBean();

	public List<TaxsectionBean> getTaxsectionList() {
		return taxsectionList;
	}

	public void setTaxsectionList(List<TaxsectionBean> taxsectionList) {
		this.taxsectionList = taxsectionList;
	}

	public TaxsectionBean getTaxsection() {
		return taxsection;
	}

	public void setTaxsection(TaxsectionBean taxsection) {
		this.taxsection = taxsection;
	}
}
