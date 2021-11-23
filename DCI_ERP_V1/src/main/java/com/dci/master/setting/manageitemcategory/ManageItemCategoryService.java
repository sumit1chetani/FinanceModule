package com.dci.master.setting.manageitemcategory;

import java.util.List;

public interface ManageItemCategoryService {

	public List<ManageItemCategoryBean> getItemCategoryList() throws Exception;

	public boolean deleteItemCategory(int itemCategoryId) throws Exception;

	public ManageItemCategoryResultBean getCategoryList() throws Exception;

	public ManageItemCategoryResultBean getPurchaseList() throws Exception;

	public ManageItemCategoryResultBean getSalesList() throws Exception;

	public ManageItemCategoryResultBean getParentCategoryList() throws Exception;

	public ManageItemCategoryResultBean getIncomeAccountList() throws Exception;

	public ManageItemCategoryResultBean getExpenseAccountList() throws Exception;

	public boolean addItemCategory(ManageItemCategoryPropertyBean objItemCategoryBean) throws Exception;

	public ManageItemCategoryBean getItemCategoryEditList(int itemCategoryId) throws Exception;

	public ManageItemCategoryResultBean getPropertyList() throws Exception;

	public List<ItemPropertiesBean> getItemPropertiesDetail(int propertyTypeId) throws Exception;

	public boolean updateItemCategory(ManageItemCategoryPropertyBean objItemCategoryBean) throws Exception;

	public int checkCatgeoryName(String categoryName) throws Exception;

	public ManageItemCategoryResultBean getGrnAttributeList(String parentCategoryId) throws Exception;

}
