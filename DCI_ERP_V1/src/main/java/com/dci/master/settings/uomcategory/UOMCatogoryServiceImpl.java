package com.dci.master.settings.uomcategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UOMCatogoryServiceImpl implements UOMCatogoryService {

	@Autowired
	UOMCatogoryDAO manageUOMDAO;

	@Override
	public List<UOMCatogoryBean> getUOMCategoryList() throws Exception {
		// TODO Auto-generated method stub
		return manageUOMDAO.getUOMCategoryList();

	}

	@Override
	public boolean insertUOMCategory(UOMCatogoryBean manageUOM) throws Exception {
		return manageUOMDAO.insertUOMCategory(manageUOM);
	}

	@Override
	public void deleteUOMCategory(Integer UOMCategoryId) throws Exception {
		manageUOMDAO.deleteUOMCategory(UOMCategoryId);
		// TODO Auto-generated method stub

	}

	@Override
	public UOMCatogoryBean getAutoGenarateValues() {
		return manageUOMDAO.getAutoGenarateValues();
	}

	@Override
	public UOMCatogoryBean uomCategoryEditList(int uomId) throws Exception {
		// TODO Auto-generated method stub
		return manageUOMDAO.uomCategoryEditList(uomId);
	}

	@Override
	public boolean updateUOMCategory(UOMCatogoryBean objUomCatogoryBean) throws Exception {
		// TODO Auto-generated method stub
		return manageUOMDAO.updateUOMCategory(objUomCatogoryBean);
	}

	@Override
	public int checkCatgeoryName(String categoryName) throws Exception {
		return manageUOMDAO.checkCatgeoryName(categoryName);
	}

}
