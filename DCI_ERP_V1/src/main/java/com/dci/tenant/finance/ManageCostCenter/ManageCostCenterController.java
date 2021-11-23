package com.dci.tenant.finance.ManageCostCenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "hospital/accounts/manageCostCenter")
public class ManageCostCenterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ManageCostCenterController.class);

	@Autowired
	private ManageCostCenterService manageCostCenterService;

	@RequestMapping(value = "/list")
	public ManageCostCenterResultBean getList() {
		ManageCostCenterResultBean manageCostCenterResultBean = new ManageCostCenterResultBean();
		try {

			manageCostCenterResultBean.setManageCostCenterList(manageCostCenterService.getList());
			manageCostCenterResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return manageCostCenterResultBean;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public boolean save(@RequestBody ManageCostCenterBean manageCostCenterBean) {

		boolean isSuccess = false;
		try {

			isSuccess = manageCostCenterService.insertManageCostCenter(manageCostCenterBean);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/delete")
	public boolean deleteManageCostCenter(@RequestBody Integer costCenterId) {
		boolean isSuccess = false;
		try {
			manageCostCenterService.deleteManageCostCenter(costCenterId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/edit")
	public ManageCostCenterResultBean editManageCostCenter(@RequestBody Integer costCenterId) throws Exception {
		ManageCostCenterResultBean manageCostCenterResultBean = new ManageCostCenterResultBean();
		try {
			manageCostCenterResultBean.setManageCostCenterBean(manageCostCenterService.editManageCostCenter(costCenterId));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return manageCostCenterResultBean;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody ManageCostCenterBean manageCostCenterBean) {

		boolean isSuccess = false;
		try {
			isSuccess = manageCostCenterService.updateManageCostCenter(manageCostCenterBean);

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
