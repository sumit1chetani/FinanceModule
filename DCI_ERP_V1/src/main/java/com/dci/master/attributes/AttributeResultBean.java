package com.dci.master.attributes;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class AttributeResultBean extends BasicResultBean {

	private static final long serialVersionUID = 1L;
	private List<AttributeBean> lAttributeList;

	public List<AttributeBean> getlAttributeList() {
		return lAttributeList;
	}

	public void setlAttributeList(List<AttributeBean> lAttributeList) {
		this.lAttributeList = lAttributeList;
	}

}
