package com.dci.payroll.master.professionalTaxSlab;

import java.util.List;

public interface ProfessionalTaxSlabRateDao {

	ProfessionalTaxSlabRateBean insertTax(ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean);

	ProfessionalTaxSlabRateBean updateTax(ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean);

	ProfessionalTaxSlabRateBean deleteTax(int slabHdrId);

	List<ProfessionalTaxSlabRateBean> getList();

	ProfessionalTaxSlabRateResultBean getListEdit(int slabHdrId);

	public boolean validateFromToDate(ProfessionalTaxSlabRateBean objBean) throws Exception;

}
