package com.dci.finance.itemproperties;

import java.util.List;

public interface ItemPropertiesService {

	boolean deleteItemProperties(String itemPropertiesId) throws Exception;

	List<ItemPropertiesBean> getItemPropertiesList() throws Exception;

	boolean addItemProperties(ItemPropertiesBean objItemPropertiesBean) throws Exception;

	ItemPropertiesResultBean getDefaultValueList() throws Exception;

	public ItemPropertiesBean getEditList(int itemPropertiesId) throws Exception;

	public boolean updateItemProperties(ItemPropertiesBean objItemPropertiesBean) throws Exception;

}
