package com.dci.master.settings.uomcategory;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class UOMCatogoryResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 4010574705388000318L;

	private UOMCatogoryBean manageUOM = new UOMCatogoryBean();

	private List<UOMCatogoryBean> UOMCategoryList;

	public UOMCatogoryBean getManageUOM() {
		return manageUOM;
	}

	public void setManageUOM(UOMCatogoryBean manageUOM) {
		this.manageUOM = manageUOM;
	}

	public List<UOMCatogoryBean> getUOMCategoryList() {
		return UOMCategoryList;
	}

	public void setUOMCategoryList(List<UOMCatogoryBean> uOMCategoryList) {
		UOMCategoryList = uOMCategoryList;
	}

}
