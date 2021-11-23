package com.dci.payroll.master.professionalTaxSlab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payroll/master/professionalTax")

public class ProfessionalTaxSlabRateController {

	@Autowired
	ProfessionalTaxSlabRateService objProfessionalTaxSlabRateService;

	@RequestMapping(value = "/save")
	public ProfessionalTaxSlabRateBean insertTax(@RequestBody ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean) {
		ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateResultBean = new ProfessionalTaxSlabRateBean();

		try {
			objProfessionalTaxSlabRateResultBean = objProfessionalTaxSlabRateService.insertTax(objProfessionalTaxSlabRateBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objProfessionalTaxSlabRateResultBean;

	}

	@RequestMapping(value = "/gridList")
	public ProfessionalTaxSlabRateResultBean getList() {
		ProfessionalTaxSlabRateResultBean objProfessionalTaxSlabRateResultBean = new ProfessionalTaxSlabRateResultBean();

		try {

			objProfessionalTaxSlabRateResultBean.setList(objProfessionalTaxSlabRateService.getList());
		} catch (Exception e) {

		}
		return objProfessionalTaxSlabRateResultBean;
	}

	@RequestMapping(value = "/edit")
	public ProfessionalTaxSlabRateResultBean getListEdit(@RequestParam("slabHdrId") int slabHdrId) {
		ProfessionalTaxSlabRateResultBean objProfessionalTaxSlabRateResultBean = new ProfessionalTaxSlabRateResultBean();

		try {

			objProfessionalTaxSlabRateResultBean = objProfessionalTaxSlabRateService.getListEdit(slabHdrId);
		} catch (Exception e) {

		}
		return objProfessionalTaxSlabRateResultBean;
	}

	@RequestMapping(value = "/update")
	public ProfessionalTaxSlabRateBean updateTax(@RequestBody ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateBean) {
		ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateResultBean = new ProfessionalTaxSlabRateBean();

		try {
			objProfessionalTaxSlabRateResultBean = objProfessionalTaxSlabRateService.updateTax(objProfessionalTaxSlabRateBean);
			objProfessionalTaxSlabRateResultBean.setUpdated(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objProfessionalTaxSlabRateResultBean;

	}

	@RequestMapping(value = "/delete")
	public ProfessionalTaxSlabRateBean deleteTax(@RequestParam("slabHdrId") int slabHdrId) {
		ProfessionalTaxSlabRateBean objProfessionalTaxSlabRateResultBean = new ProfessionalTaxSlabRateBean();

		try {
			objProfessionalTaxSlabRateResultBean = objProfessionalTaxSlabRateService.deleteTax(slabHdrId);
			objProfessionalTaxSlabRateResultBean.setDeleted(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objProfessionalTaxSlabRateResultBean;

	}

	@RequestMapping(value = "/validate")
	public boolean ProfessionalTaxSlabRateBean(@RequestBody ProfessionalTaxSlabRateBean objBean) {
		boolean isSuccess = false;
		try {
			isSuccess = objProfessionalTaxSlabRateService.validateFromToDate(objBean);
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}

}
