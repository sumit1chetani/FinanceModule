package com.dci.master.settings.UOM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageUOMServiceImpl implements ManageUOMService {

	@Autowired
	ManageUOMDAO manageUOMDAO;

	@Override
	public boolean insertManageUOM(ManageUOM manageUOM) throws Exception {
		return manageUOMDAO.insertManageUOM(manageUOM);
	}

	@Override
	public ManageUOM getManageUOMById(Integer manageUOMId) throws Exception {
		// TODO Auto-generated method stub
		ManageUOM manageUOM = manageUOMDAO.getManageUOMById(manageUOMId);
		return manageUOM;
	}

	@Override
	public boolean updateManageUOM(ManageUOM manageUOM) throws Exception {
		// TODO Auto-generated method stub
		return manageUOMDAO.updateManageUOM(manageUOM);
	}

	@Override
	public void deleteManageUOM(Integer manageUOMId) throws Exception {
		manageUOMDAO.deleteManageUOM(manageUOMId);
		// TODO Auto-generated method stub

	}

	@Override
	public List<ManageUOM> getManageUOMList() throws Exception {
		// TODO Auto-generated method stub
		return manageUOMDAO.getManageUOMList();

	}

	@Override
	public ManageUOMResultBean getUOMCategoryList() throws Exception {
		// TODO Auto-generated method stub
		return manageUOMDAO.getUOMCategoryList();
	}

	@Override
	public int checkBaseUOM(ManageUOM manageUOM) throws Exception {
		return manageUOMDAO.checkBaseUOM(manageUOM);
	}

	@Override
	public ManageUOMResultBean getUOMCategList() throws Exception {
		return manageUOMDAO.getUOMCategList();
	}

	@Override
	public int checkUOMName(String uomName) throws Exception {
		// TODO Auto-generated method stub
		return manageUOMDAO.checkUOMName(uomName);
	}

}
