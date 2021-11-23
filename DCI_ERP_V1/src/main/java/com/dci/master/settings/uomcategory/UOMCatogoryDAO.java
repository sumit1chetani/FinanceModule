package com.dci.master.settings.uomcategory;

import java.util.List;

import com.dci.common.util.CustomException;


public interface UOMCatogoryDAO {

	public List<UOMCatogoryBean> getUOMCategoryList() throws CustomException;

	public boolean insertUOMCategory(UOMCatogoryBean manageUOM) throws CustomException;

	public void deleteUOMCategory(Integer UOMCategoryId) throws CustomException;

	public UOMCatogoryBean getAutoGenarateValues();

	public UOMCatogoryBean uomCategoryEditList(int uomId) throws Exception;

	public boolean updateUOMCategory(UOMCatogoryBean objUomCatogoryBean) throws Exception;

	public int checkCatgeoryName(String categoryName) throws Exception;

}
