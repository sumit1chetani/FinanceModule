package com.dci.payroll.tds.taxsection;

import java.util.List;

import com.dci.common.util.CustomException;


public interface TaxsectionDAO {
	List<TaxsectionBean> getTaxsectionList() throws Exception;

	public boolean insertTaxSection(TaxsectionBean taxsectionBean) throws CustomException;

	public TaxsectionBean getTaxSectionById(String taxsectioncode) throws CustomException;

	public boolean updateTaxSection(TaxsectionBean taxsectionBean) throws CustomException;

	public boolean deleteTaxSection(String taxsectioncode) throws CustomException;

}