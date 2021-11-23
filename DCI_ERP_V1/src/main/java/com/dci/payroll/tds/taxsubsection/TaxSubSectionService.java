package com.dci.payroll.tds.taxsubsection;

import java.util.List;

public interface TaxSubSectionService {
	List<TaxSubSectionBean> getTaxSubSectionList() throws Exception;

	TaxSubSectionBean getTaxSubSectionById(String taxSubSectionCode) throws Exception;

	boolean insertTaxSubSection(TaxSubSectionBean taxSubSectionBean) throws Exception;

	boolean deleteTaxSubSection(String taxSubSectionCode) throws Exception;

	List<TaxSubSectionBean> getTaxSectionList() throws Exception;

}