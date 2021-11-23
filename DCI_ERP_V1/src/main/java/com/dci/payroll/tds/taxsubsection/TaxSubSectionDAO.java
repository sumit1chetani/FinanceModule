package com.dci.payroll.tds.taxsubsection;

import java.util.List;

public interface TaxSubSectionDAO {
	public List<TaxSubSectionBean> getTaxSubSectionList() throws Exception;

	public TaxSubSectionBean getTaxSubSectionById(String taxSubSectionCode) throws Exception;

	public boolean insertTaxSubSection(TaxSubSectionBean taxSubSectionBean) throws Exception;

	public boolean deleteTaxSubSection(String taxSubSectionCode) throws Exception;

	public List<TaxSubSectionBean> getTaxSectionList() throws Exception;

}