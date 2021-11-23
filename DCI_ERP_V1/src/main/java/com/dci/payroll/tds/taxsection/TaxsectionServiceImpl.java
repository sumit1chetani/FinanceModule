package com.dci.payroll.tds.taxsection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxsectionServiceImpl implements TaxsectionService {
	@Autowired
	TaxsectionDAO taxsectionDAO;

	@Override
	public List<TaxsectionBean> getTaxsectionList() throws Exception {
		// TODO Auto-generated method stub
		return taxsectionDAO.getTaxsectionList();
	}

	@Override
	public boolean insertTaxSection(TaxsectionBean taxsectionBean) throws Exception {
		// TODO Auto-generated method stub
		return taxsectionDAO.insertTaxSection(taxsectionBean);
	}

	@Override
	public TaxsectionBean getTaxSectionById(String taxsectioncode) throws Exception {
		// TODO Auto-generated method stub
		return taxsectionDAO.getTaxSectionById(taxsectioncode);
	}

	@Override
	public boolean updateTaxSection(TaxsectionBean taxsectionBean) throws Exception {
		// TODO Auto-generated method stub
		return taxsectionDAO.updateTaxSection(taxsectionBean);
	}

	@Override
	public boolean deleteTaxSection(String taxsectioncode) throws Exception {
		// TODO Auto-generated method stub
		return taxsectionDAO.deleteTaxSection(taxsectioncode);
	}

}