package com.dci.payroll.tds.taxsection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/tds/taxsection")
public class TaxsectionController {
	private final static Logger LOGGER = LoggerFactory.getLogger(TaxsectionController.class);
	@Autowired
	TaxsectionService taxsectionService;

	@RequestMapping(value = "/list")
	public TaxsectionResultBean getTaxsectionList() {
		TaxsectionResultBean taxsectionResultBean = new TaxsectionResultBean();
		try {
			taxsectionResultBean.setTaxsectionList(taxsectionService.getTaxsectionList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return taxsectionResultBean;

	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody TaxsectionBean taxsectionBean) {
		TaxsectionResultBean taxsectionResultBean = new TaxsectionResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = taxsectionService.insertTaxSection(taxsectionBean);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/edit")
	public TaxsectionBean getTaxSectionById(@RequestBody String taxsectioncode) {
		try {
			return taxsectionService.getTaxSectionById(taxsectioncode);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody TaxsectionBean taxsectionBean) {
		TaxsectionResultBean taxsectionResultBean = new TaxsectionResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = taxsectionService.updateTaxSection(taxsectionBean);
		} catch (CustomException e) {
			taxsectionResultBean.setSuccess(false);
			taxsectionResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody String taxsectioncode) {
		boolean isDeleted = false;
		try {
			isDeleted = taxsectionService.deleteTaxSection(taxsectioncode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}
}