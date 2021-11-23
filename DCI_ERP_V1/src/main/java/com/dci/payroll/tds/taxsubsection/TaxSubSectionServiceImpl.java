package com.dci.payroll.tds.taxsubsection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxSubSectionServiceImpl implements TaxSubSectionService {
	@Autowired
	TaxSubSectionDAO taxsubsectionDAO;

	@Override
	public List<TaxSubSectionBean> getTaxSubSectionList() throws Exception {
		// TODO Auto-generated method stub
		return taxsubsectionDAO.getTaxSubSectionList();
	}

	@Override
	public TaxSubSectionBean getTaxSubSectionById(String taxSubSectionCode) throws Exception {
		// TODO Auto-generated method stub
		return taxsubsectionDAO.getTaxSubSectionById(taxSubSectionCode);
	}

	@Override
	public boolean insertTaxSubSection(TaxSubSectionBean taxSubSectionBean) throws Exception {
		// TODO Auto-generated method stub
		return taxsubsectionDAO.insertTaxSubSection(taxSubSectionBean);
	}

	@Override
	public boolean deleteTaxSubSection(String taxSubSectionCode) throws Exception {
		// TODO Auto-generated method stub
		return taxsubsectionDAO.deleteTaxSubSection(taxSubSectionCode);
	}

	@Override
	public List<TaxSubSectionBean> getTaxSectionList() throws Exception {
		// TODO Auto-generated method stub
		return taxsubsectionDAO.getTaxSectionList();
	}
}