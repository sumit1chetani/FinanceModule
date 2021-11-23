package com.dci.tenant.finance.manageSubTax;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ManageSubTaxResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private ManageSubTax manageSubTax = new ManageSubTax();

	private List<ManageSubTax> subTaxList;

	public List<ManageSubTax> getSubTaxList() {
		return subTaxList;
	}

	public void setSubTaxList(List<ManageSubTax> subTaxList) {
		this.subTaxList = subTaxList;
	}

	private List<ManageSubTax> valueList;

	public List<ManageSubTax> getValueList() {
		return valueList;
	}

	public void setValueList(List<ManageSubTax> valueList) {
		this.valueList = valueList;
	}

	private List<ManageSubTax> typeList;

	public List<ManageSubTax> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<ManageSubTax> typeList) {
		this.typeList = typeList;
	}

	/*
	 * private List<ManageTaxes> manageTaxesList;
	 * 
	 * public List<ManageTaxes> getManageTaxesList() { return manageTaxesList; }
	 * 
	 * public void setManageTaxesList(List<ManageTaxes> manageTaxesList) {
	 * this.manageTaxesList = manageTaxesList; }
	 * 
	 * public ManageTaxes getManageTaxes() { return manageTaxes; }
	 * 
	 * public void setManageTaxes(ManageTaxes manageTaxes) { this.manageTaxes =
	 * manageTaxes; }
	 */

}