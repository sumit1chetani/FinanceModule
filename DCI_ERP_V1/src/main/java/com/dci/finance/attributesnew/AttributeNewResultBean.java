package com.dci.finance.attributesnew;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class AttributeNewResultBean extends BasicResultBean {

	private static final long serialVersionUID = 1L;
	private List<AttributeNewBean> lAttributeList;

	private AttributeNewBean attributeEdit;

	public AttributeNewBean getAttributeEdit() {
		return attributeEdit;
	}

	public void setAttributeEdit(AttributeNewBean attributeEdit) {
		this.attributeEdit = attributeEdit;
	}

	public List<AttributeNewBean> getlAttributeList() {
		return lAttributeList;
	}

	public void setlAttributeList(List<AttributeNewBean> lAttributeList) {
		this.lAttributeList = lAttributeList;
	}

}
