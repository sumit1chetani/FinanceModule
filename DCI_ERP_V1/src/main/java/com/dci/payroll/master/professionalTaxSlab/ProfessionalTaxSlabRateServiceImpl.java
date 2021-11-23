package com.dci.payroll.master.professionalTaxSlab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProfessionalTaxSlabRateServiceImpl implements ProfessionalTaxSlabRateService {

	@Autowired
	ProfessionalTaxSlabRateDao objProfessionalTaxSlabRateDao;

	/*
	 * @Override public ProfessionalTaxSlabRateResultBean
	 * insertTax(ArrayList<ProfessionalTaxSlabRateBean>
	 * objProfessionalTaxSlabRateBean) { // TODO Auto-generated method stub
	 * return
	 * objProfessionalTaxSlabRateDao.insertTax(objProfessionalTaxSlabRateBean);
	 * }
	 */

	@Override
	public ProfessionalTaxSlabRateBean insertTax(ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean) {
		// TODO Auto-generated method stub
		return objProfessionalTaxSlabRateDao.insertTax(objProfessionalTaxSlabRateBean);
	}

	@Override
	public ProfessionalTaxSlabRateBean updateTax(ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean) {
		// TODO Auto-generated method stub
		return objProfessionalTaxSlabRateDao.updateTax(objProfessionalTaxSlabRateBean);
	}

	@Override
	public ProfessionalTaxSlabRateBean deleteTax(int slabHdrId) {
		// TODO Auto-generated method stub
		return objProfessionalTaxSlabRateDao.deleteTax(slabHdrId);
	}

	@Override
	public List<ProfessionalTaxSlabRateBean> getList() {
		// TODO Auto-generated method stub
		return objProfessionalTaxSlabRateDao.getList();
	}

	@Override
	public ProfessionalTaxSlabRateResultBean getListEdit(int slabHdrId) {
		// TODO Auto-generated method stub
		return objProfessionalTaxSlabRateDao.getListEdit(slabHdrId);
	}

	@Override
	public boolean validateFromToDate(ProfessionalTaxSlabRateBean objBean) throws Exception {
		return objProfessionalTaxSlabRateDao.validateFromToDate(objBean);
	}

}
