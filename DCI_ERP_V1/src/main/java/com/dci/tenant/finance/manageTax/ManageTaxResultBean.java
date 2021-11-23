package com.dci.tenant.finance.manageTax;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class ManageTaxResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private ManageTax manageTax = new ManageTax();

	private List<ManageTax> subTaxList;

	public List<ManageTax> getSubTaxList() {
		return subTaxList;
	}

	public void setSubTaxList(List<ManageTax> subTaxList) {
		this.subTaxList = subTaxList;
	}

	private List<ManageTax> taxList;

	public List<ManageTax> getTaxList() {
		return taxList;
	}

	public void setTaxList(List<ManageTax> taxList) {
		this.taxList = taxList;
	}

	private List<ManageTax> valueList;

	public List<ManageTax> getValueList() {
		return valueList;
	}

	public void setValueList(List<ManageTax> valueList) {
		this.valueList = valueList;
	}

	private List<ManageTax> typeList;

	public List<ManageTax> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<ManageTax> typeList) {
		this.typeList = typeList;
	}

	private List<SelectivityBean> acctList;

	public ManageTax getManageTax() {
		return manageTax;
	}

	public void setManageTax(ManageTax manageTax) {
		this.manageTax = manageTax;
	}

	public List<SelectivityBean> getAcctList() {
		return acctList;
	}

	public void setAcctList(List<SelectivityBean> acctList) {
		this.acctList = acctList;
	}

	private String accountCode;

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

}