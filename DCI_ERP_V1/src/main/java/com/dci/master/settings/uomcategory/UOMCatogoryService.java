package com.dci.master.settings.uomcategory;

import java.util.List;

public interface UOMCatogoryService {

	public List<UOMCatogoryBean> getUOMCategoryList() throws Exception;

	public boolean insertUOMCategory(UOMCatogoryBean manageUOM) throws Exception;

	public void deleteUOMCategory(Integer UOMCategoryId) throws Exception;

	public UOMCatogoryBean getAutoGenarateValues();

	public UOMCatogoryBean uomCategoryEditList(int uomId) throws Exception;

	public boolean updateUOMCategory(UOMCatogoryBean objUomCatogoryBean) throws Exception;

	public int checkCatgeoryName(String categoryName) throws Exception;

}
