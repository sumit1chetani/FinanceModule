package com.dci.tenant.finance.manageTax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageTaxServiceImpl implements ManageTaxService {
	@Autowired
	ManageTaxDAO manageTaxDAO;

	@Override
	public List<ManageTax> getTaxList() throws Exception {
		return manageTaxDAO.getTaxList();
	}

	@Override
	public ManageTaxResultBean getValueList() throws Exception {
		// TODO Auto-generated method stub
		return manageTaxDAO.getValueList();

	}

	@Override
	public ManageTaxResultBean getTypeList() throws Exception {
		// TODO Auto-generated method stub return manageSubTaxDAO.getTypeList();
		return manageTaxDAO.getTypeList();
	}

	@Override
	public ManageTaxResultBean getSubTaxList() throws Exception {
		// TODO Auto-generated method stub return manageSubTaxDAO.getTypeList();
		return manageTaxDAO.getSubTaxList();
	}

	@Override
	public ManageTaxResultBean insertManageTax(ManageTax manageTax) throws Exception {
		// TODO Auto-generated method stub
		return manageTaxDAO.insertManageTax(manageTax);
	}

	@Override
	public boolean deleteTax(Integer taxId) throws Exception {
		return manageTaxDAO.deleteTax(taxId);

	}

	@Override
	public ManageTax editManageTax(Integer taxId) throws Exception {
		// TODO Auto-generated method stub
		return manageTaxDAO.editManageTax(taxId);
	}

	@Override
	public boolean updateManageTax(ManageTax manageTax) throws Exception {
		// TODO Auto-generated method stub
		return manageTaxDAO.updateManageTax(manageTax);
	}

	@Override
	public ManageTaxResultBean getAcctList(String subGrp) {
		// TODO Auto-generated method stub
		return manageTaxDAO.getAcctList(subGrp);
	}

	@Override
	public String checkAccount(int taxTypeId, String formCode) {
		return manageTaxDAO.checkAccount(taxTypeId, formCode);
	}

	@Override
	public ManageTax getChildTaxDetails(int subTaxId) {
		return manageTaxDAO.getChildTaxDetails(subTaxId);
	}
}