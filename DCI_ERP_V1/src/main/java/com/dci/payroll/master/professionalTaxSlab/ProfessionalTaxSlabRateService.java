package com.dci.payroll.master.professionalTaxSlab;

import java.util.List;

public interface ProfessionalTaxSlabRateService {

	ProfessionalTaxSlabRateBean insertTax(ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean);

	ProfessionalTaxSlabRateBean updateTax(ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean);

	ProfessionalTaxSlabRateBean deleteTax(int slabHdrId);

	List<ProfessionalTaxSlabRateBean> getList();

	ProfessionalTaxSlabRateResultBean getListEdit(int slabHdrId);

	public boolean validateFromToDate(ProfessionalTaxSlabRateBean objBean) throws Exception;

	// ProfessionalTaxSlabRateResultBean
	// insertTax(ArrayList<ProfessionalTaxSlabRateBean>
	// objProfessionalTaxSlabRateBean);

}
