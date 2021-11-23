package com.dci.tenant.finance.manageTax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "hospital/accounts/manageTax")
public class ManageTaxController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageTaxController.class);

	@Autowired
	private ManageTaxService manageTaxService;

	@RequestMapping(value = "/list")
	public ManageTaxResultBean getList() {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		try {

			manageTaxResultBean.setTaxList(manageTaxService.getTaxList());
			manageTaxResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return manageTaxResultBean;

	}

	@RequestMapping(value = "/subTaxList")
	public ManageTaxResultBean getSubTaxList() {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		try {
			manageTaxResultBean = manageTaxService.getSubTaxList();
			manageTaxResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageTaxResultBean;
	}

	@RequestMapping(value = "/methodList")
	public ManageTaxResultBean getMethodList() {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		try {
			manageTaxResultBean = manageTaxService.getValueList();
			manageTaxResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageTaxResultBean;
	}

	@RequestMapping(value = "/acctList")
	public ManageTaxResultBean getAcctList(@RequestParam("subGrp") String subGrp) {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		try {
			manageTaxResultBean = manageTaxService.getAcctList(subGrp);
			manageTaxResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageTaxResultBean;
	}

	@RequestMapping(value = "/typeList")
	public ManageTaxResultBean getTypeList() {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		try {
			manageTaxResultBean = manageTaxService.getTypeList();
			manageTaxResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageTaxResultBean;
	}

	@RequestMapping(value = "/save")
	public ManageTaxResultBean save(@RequestBody ManageTax manageTax) {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		boolean isSuccess = false;
		try {

			manageTaxResultBean = manageTaxService.insertManageTax(manageTax);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return manageTaxResultBean;

	}

	@RequestMapping(value = "/delete")
	public ManageTaxResultBean deleteTax(@RequestBody Integer taxId) {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		try {
			manageTaxResultBean.setSuccess(manageTaxService.deleteTax(taxId));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageTaxResultBean;
	}

	@RequestMapping(value = "/edit")
	public ManageTax editManageTax(@RequestBody Integer taxId) throws Exception {
		try {
			return manageTaxService.editManageTax(taxId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody ManageTax manageTax) {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = manageTaxService.updateManageTax(manageTax);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/checkAccount")
	public ManageTaxResultBean checkAccount(@RequestParam("taxTypeId") int taxTypeId, @RequestParam("formCode") String formCode) {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		try {
			manageTaxResultBean.setAccountCode(manageTaxService.checkAccount(taxTypeId, formCode));
			manageTaxResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageTaxResultBean;
	}

	@RequestMapping(value = "/getChildTaxDetails")
	public ManageTaxResultBean getChildTaxDetails(@RequestParam("subTaxId") int subTaxId) {
		ManageTaxResultBean manageTaxResultBean = new ManageTaxResultBean();
		try {
			manageTaxResultBean.setManageTax(manageTaxService.getChildTaxDetails(subTaxId));
			manageTaxResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageTaxResultBean;

	}
}