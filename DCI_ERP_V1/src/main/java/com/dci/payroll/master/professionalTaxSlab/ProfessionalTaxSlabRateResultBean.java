package com.dci.payroll.master.professionalTaxSlab;

import java.util.List;

public class ProfessionalTaxSlabRateResultBean {

	private List<ProfessionalTaxSlabRateBean> list;

	private List<ProfessionalTaxSlabRateDetailBean> editList;

	private List<ProfessionalTaxSlabRateBean> editListDtl;

	public List<ProfessionalTaxSlabRateBean> getEditListDtl() {
		return editListDtl;
	}

	public void setEditListDtl(List<ProfessionalTaxSlabRateBean> editListDtl) {
		this.editListDtl = editListDtl;
	}

	public List<ProfessionalTaxSlabRateDetailBean> getEditList() {
		return editList;
	}

	public void setEditList(List<ProfessionalTaxSlabRateDetailBean> editList) {
		this.editList = editList;
	}

	public List<ProfessionalTaxSlabRateBean> getList() {
		return list;
	}

	public void setList(List<ProfessionalTaxSlabRateBean> list) {
		this.list = list;
	}

}
