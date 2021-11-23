package com.dci.payroll.tds.taxsubsection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payroll/tds/taxsubsection")
public class TaxSubSectionController {
	private final static Logger LOGGER = LoggerFactory.getLogger(TaxSubSectionController.class);
	@Autowired
	TaxSubSectionService taxSubSectionService;

	@RequestMapping(value = "/list")
	public TaxSubSectionResultBean getTaxSubSectionList() {
		TaxSubSectionResultBean taxSubSectionResultBean = new TaxSubSectionResultBean();
		try {
			taxSubSectionResultBean.setTaxSubSectionList(taxSubSectionService.getTaxSubSectionList());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return taxSubSectionResultBean;
	}

	@RequestMapping(value = "/edit")
	public TaxSubSectionResultBean getTaxSubSectionbyCode(@RequestBody String taxSubSectionCode) {
		TaxSubSectionResultBean taxSubSectionResultBean = new TaxSubSectionResultBean();
		try {
			taxSubSectionResultBean.setTaxSubSection(taxSubSectionService.getTaxSubSectionById(taxSubSectionCode));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return taxSubSectionResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody TaxSubSectionBean taxSubSectionBean) {
		boolean isSuccess = false;
		try {
			isSuccess = taxSubSectionService.insertTaxSubSection(taxSubSectionBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody String taxSubSectionCode) {
		boolean isDeleted = false;
		try {
			isDeleted = taxSubSectionService.deleteTaxSubSection(taxSubSectionCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@RequestMapping(value = "/taxsectionlist")
	public TaxSubSectionResultBean getTaxSectionList() {
		TaxSubSectionResultBean taxSubSectionResultBean = new TaxSubSectionResultBean();
		try {
			taxSubSectionResultBean.setTaxSectionList(taxSubSectionService.getTaxSectionList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taxSubSectionResultBean;
	}
}