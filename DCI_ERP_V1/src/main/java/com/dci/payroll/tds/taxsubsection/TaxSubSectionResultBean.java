package com.dci.payroll.tds.taxsubsection;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class TaxSubSectionResultBean extends BasicResultBean implements Serializable {
	private List<TaxSubSectionBean> taxSubSectionList = null;
	private List<TaxSubSectionBean> taxSectionList = null;
	private TaxSubSectionBean taxSubSection = new TaxSubSectionBean();

	public List<TaxSubSectionBean> getTaxSubSectionList() {
		return taxSubSectionList;
	}

	public void setTaxSubSectionList(List<TaxSubSectionBean> taxSubSectionList) {
		this.taxSubSectionList = taxSubSectionList;
	}

	public TaxSubSectionBean getTaxSubSection() {
		return taxSubSection;
	}

	public void setTaxSubSection(TaxSubSectionBean taxSubSection) {
		this.taxSubSection = taxSubSection;
	}

	public List<TaxSubSectionBean> getTaxSectionList() {
		return taxSectionList;
	}

	public void setTaxSectionList(List<TaxSubSectionBean> taxSectionList) {
		this.taxSectionList = taxSectionList;
	}
}
