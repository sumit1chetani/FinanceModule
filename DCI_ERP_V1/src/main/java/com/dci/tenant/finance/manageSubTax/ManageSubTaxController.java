package com.dci.tenant.finance.manageSubTax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "hospital/accounts/manageSubTax")
public class ManageSubTaxController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageSubTaxController.class);

	@Autowired
	private ManageSubTaxService manageSubTaxService;

	@RequestMapping(value = "/list")
	public ManageSubTaxResultBean getList() {
		ManageSubTaxResultBean manageSubTaxResultBean = new ManageSubTaxResultBean();
		try {

			manageSubTaxResultBean.setSubTaxList(manageSubTaxService.getSubTaxList());
			manageSubTaxResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return manageSubTaxResultBean;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public boolean save(@RequestBody ManageSubTax manageSubTax) {
		ManageSubTaxResultBean manageSubTaxResultBean = new ManageSubTaxResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = manageSubTaxService.insertManageSubTax(manageSubTax);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/methodList")
	public ManageSubTaxResultBean getMethodList() {
		ManageSubTaxResultBean manageSubTaxResultBean = new ManageSubTaxResultBean();
		try {
			manageSubTaxResultBean = manageSubTaxService.getValueList();
			manageSubTaxResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageSubTaxResultBean;
	}

	@RequestMapping(value = "/typeList")
	public ManageSubTaxResultBean getTypeList() {
		ManageSubTaxResultBean manageSubTaxResultBean = new ManageSubTaxResultBean();
		try {
			manageSubTaxResultBean = manageSubTaxService.getTypeList();
			manageSubTaxResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageSubTaxResultBean;
	}

	@RequestMapping(value = "/delete")
	public ManageSubTaxResultBean deleteSubTax(@RequestBody Integer subTaxId) {
		ManageSubTaxResultBean manageSubTaxResultBean = new ManageSubTaxResultBean();
		try {
			manageSubTaxService.deleteSubTax(subTaxId);
			manageSubTaxResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageSubTaxResultBean;
	}

	@RequestMapping(value = "/edit")
	public ManageSubTax editManageSubTax(@RequestParam("subTaxId") Integer subTaxId) throws Exception {
		try {
			return manageSubTaxService.editManageSubTax(subTaxId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody ManageSubTax manageSubTax) {
		ManageSubTaxResultBean manageSubTaxResultBean = new ManageSubTaxResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = manageSubTaxService.updateManageSubTax(manageSubTax);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

}