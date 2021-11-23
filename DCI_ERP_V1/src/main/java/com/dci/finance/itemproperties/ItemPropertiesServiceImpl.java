package com.dci.finance.itemproperties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPropertiesServiceImpl implements ItemPropertiesService {

	@Autowired
	ItemPropertiesDAO itemPropertiesDAO;

	@Override
	public boolean deleteItemProperties(String itemPropertiesId) throws Exception {
		return itemPropertiesDAO.deleteItemProperties(itemPropertiesId);
	}

	@Override
	public List<ItemPropertiesBean> getItemPropertiesList() throws Exception {
		return itemPropertiesDAO.getItemPropertiesList();
	}

	@Override
	public boolean addItemProperties(ItemPropertiesBean objItemPropertiesBean) throws Exception {
		return itemPropertiesDAO.addItemProperties(objItemPropertiesBean);
	}

	@Override
	public ItemPropertiesResultBean getDefaultValueList() throws Exception {
		return itemPropertiesDAO.getDefaultValueList();
	}

	@Override
	public ItemPropertiesBean getEditList(int itemPropertiesId) throws Exception {
		return itemPropertiesDAO.getEditList(itemPropertiesId);
	}

	@Override
	public boolean updateItemProperties(ItemPropertiesBean objItemPropertiesBean) throws Exception {
		return itemPropertiesDAO.updateItemProperties(objItemPropertiesBean);
	}

}
