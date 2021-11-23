package com.dci.master.settings.UOM;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ManageUOMResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 4010574705388000318L;

	private ManageUOM manageUOM = new ManageUOM();

	private List<ManageUOM> manageUOMList;

	private List uomCategoryList;

	public List<ManageUOM> getManageUOMList() {
		return manageUOMList;
	}

	public void setManageUOMList(List<ManageUOM> manageUOMList) {
		this.manageUOMList = manageUOMList;
	}

	public ManageUOM getManageUOM() {
		return manageUOM;
	}

	public void setManageUOM(ManageUOM manageUOM) {
		this.manageUOM = manageUOM;
	}

	public List getUomCategoryList() {
		return uomCategoryList;
	}

	public void setUomCategoryList(List uomCategoryList) {
		this.uomCategoryList = uomCategoryList;
	}

}
