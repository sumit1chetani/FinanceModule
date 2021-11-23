package com.dci.payroll.tds.professionaltaxslab;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dci.common.util.BasicResultBean;


public class ProfessionalTaxSlabResultBean extends BasicResultBean implements Serializable {

	private List<ProfessionalTaxSlabBean> professionalTaxSlabList;

	private List<Map<String, Object>> professionalTaxList;

	private PtListDTO professionaltxList;

	private List<ProfessionalTaxSlabBean> financialYearList;

	private ProfessionalTaxSlabBean professionalTaxSlabBean = null;

	public List<ProfessionalTaxSlabBean> getProfessionalTaxSlabList() {
		return professionalTaxSlabList;
	}

	public void setProfessionalTaxSlabList(List<ProfessionalTaxSlabBean> professionalTaxSlabList) {
		this.professionalTaxSlabList = professionalTaxSlabList;
	}

	public ProfessionalTaxSlabBean getProfessionalTaxSlabBean() {
		return professionalTaxSlabBean;
	}

	public void setProfessionalTaxSlabBean(ProfessionalTaxSlabBean professionalTaxSlabBean) {
		this.professionalTaxSlabBean = professionalTaxSlabBean;
	}

	public List<ProfessionalTaxSlabBean> getFinancialYearList() {
		return financialYearList;
	}

	public void setFinancialYearList(List<ProfessionalTaxSlabBean> financialYearList) {
		this.financialYearList = financialYearList;
	}

	public List<Map<String, Object>> getProfessionalTaxList() {
		return professionalTaxList;
	}

	public void setProfessionalTaxList(List<Map<String, Object>> professionalTaxList) {
		this.professionalTaxList = professionalTaxList;
	}

	public PtListDTO getProfessionaltxList() {
		return professionaltxList;
	}

	public void setProfessionaltxList(PtListDTO ptListDTO) {
		this.professionaltxList = ptListDTO;
	}

}