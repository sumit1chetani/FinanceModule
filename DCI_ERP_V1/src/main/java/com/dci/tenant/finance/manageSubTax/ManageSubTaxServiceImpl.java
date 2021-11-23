package com.dci.tenant.finance.manageSubTax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageSubTaxServiceImpl implements ManageSubTaxService {
	@Autowired
	ManageSubTaxDAO manageSubTaxDAO;

	@Override
	public List<ManageSubTax> getSubTaxList() throws Exception {
		return manageSubTaxDAO.getSubTaxList();
	}

	@Override
	public boolean insertManageSubTax(ManageSubTax manageSubTax) throws Exception {
		// TODO Auto-generated method stub
		return manageSubTaxDAO.insertManageSubTax(manageSubTax);
	}

	@Override
	public ManageSubTaxResultBean getValueList() throws Exception {
		// TODO Auto-generated method stub
		return manageSubTaxDAO.getValueList();

	}

	@Override
	public ManageSubTaxResultBean getTypeList() throws Exception {
		return manageSubTaxDAO.getTypeList();
	}

	@Override
	public void deleteSubTax(Integer subTaxId) throws Exception {
		// TODO Auto-generated method stub
		manageSubTaxDAO.deleteSubTax(subTaxId);

	}

	@Override
	public ManageSubTax editManageSubTax(Integer subTaxId) throws Exception {
		// TODO Auto-generated method stub
		return manageSubTaxDAO.editManageSubTax(subTaxId);
	}

	@Override
	public boolean updateManageSubTax(ManageSubTax manageSubTax) throws Exception {
		// TODO Auto-generated method stub
		return manageSubTaxDAO.updateManageSubTax(manageSubTax);
	}

}