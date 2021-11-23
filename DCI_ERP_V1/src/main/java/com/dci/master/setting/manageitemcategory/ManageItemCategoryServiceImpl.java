package com.dci.master.setting.manageitemcategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageItemCategoryServiceImpl implements ManageItemCategoryService {

	@Autowired
	ManageItemCategoryDAO manageItemCategoryDAO;

	@Override
	public List<ManageItemCategoryBean> getItemCategoryList() throws Exception {
		return manageItemCategoryDAO.getItemCategoryList();
	}

	@Override
	public boolean deleteItemCategory(int itemCategoryId) throws Exception {
		return manageItemCategoryDAO.deleteItemCategory(itemCategoryId);
	}

	@Override
	public ManageItemCategoryResultBean getCategoryList() throws Exception {
		return manageItemCategoryDAO.getCategoryList();
	}

	@Override
	public ManageItemCategoryResultBean getPurchaseList() throws Exception {
		return manageItemCategoryDAO.getPurchaseList();
	}

	@Override
	public ManageItemCategoryResultBean getSalesList() throws Exception {
		return manageItemCategoryDAO.getSalesList();
	}

	@Override
	public ManageItemCategoryResultBean getParentCategoryList() throws Exception {
		return manageItemCategoryDAO.getParentCategoryList();
	}

	@Override
	public ManageItemCategoryResultBean getIncomeAccountList() throws Exception {
		return manageItemCategoryDAO.getIncomeAccountList();
	}

	@Override
	public ManageItemCategoryResultBean getExpenseAccountList() throws Exception {
		return manageItemCategoryDAO.getExpenseAccountList();
	}

	@Override
	public boolean addItemCategory(ManageItemCategoryPropertyBean objItemCategoryBean) throws Exception {
		return manageItemCategoryDAO.addItemCategory(objItemCategoryBean);
	}

	@Override
	public ManageItemCategoryBean getItemCategoryEditList(int itemCategoryId) throws Exception {
		return manageItemCategoryDAO.getItemCategoryEditList(itemCategoryId);
	}

	@Override
	public ManageItemCategoryResultBean getPropertyList() throws Exception {
		return manageItemCategoryDAO.getPropertyList();
	}

	@Override
	public List<ItemPropertiesBean> getItemPropertiesDetail(int propertyTypeId) throws Exception {
		return manageItemCategoryDAO.getItemPropertiesDetail(propertyTypeId);
	}

	@Override
	public boolean updateItemCategory(ManageItemCategoryPropertyBean objItemCategoryBean) throws Exception {
		return manageItemCategoryDAO.updateItemCategory(objItemCategoryBean);
	}

	@Override
	public int checkCatgeoryName(String categoryName) throws Exception {
		return manageItemCategoryDAO.checkCatgeoryName(categoryName);
	}

	@Override
	public ManageItemCategoryResultBean getGrnAttributeList(String parentCategoryId) throws Exception {
		return manageItemCategoryDAO.getGrnAttributeList(parentCategoryId);
	}

}
