package com.dci.finance.itemproperties;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ItemPropertiesResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ItemPropertiesBean> itemPropertiesBeanList;

	private List propertyList;

	private List typeList;

	private ItemPropertiesBean itemPropertiesBean = new ItemPropertiesBean();

	public List<ItemPropertiesBean> getItemPropertiesBeanList() {
		return itemPropertiesBeanList;
	}

	public void setItemPropertiesBeanList(List<ItemPropertiesBean> itemPropertiesBeanList) {
		this.itemPropertiesBeanList = itemPropertiesBeanList;
	}

	public List getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List propertyList) {
		this.propertyList = propertyList;
	}

	public List getTypeList() {
		return typeList;
	}

	public void setTypeList(List typeList) {
		this.typeList = typeList;
	}

	public ItemPropertiesBean getItemPropertiesBean() {
		return itemPropertiesBean;
	}

	public void setItemPropertiesBean(ItemPropertiesBean itemPropertiesBean) {
		this.itemPropertiesBean = itemPropertiesBean;
	}

}
