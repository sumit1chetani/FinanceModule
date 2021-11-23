package com.dci.payroll.tds.taxsection;

import java.util.List;

public interface TaxsectionService {

	List<TaxsectionBean> getTaxsectionList() throws Exception;

	boolean insertTaxSection(TaxsectionBean taxsectionBean) throws Exception;

	TaxsectionBean getTaxSectionById(String taxsectioncode) throws Exception;

	boolean updateTaxSection(TaxsectionBean taxsectionBean) throws Exception;

	boolean deleteTaxSection(String taxsectioncode) throws Exception;
}