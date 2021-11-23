package com.dci.finance.managestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.tenant.common.CommonUtilityService;

@RestController
@RequestMapping("his/inventory/settings/managestores")
public class ManageStoresController {

	@Autowired
	private ManageStoresService manageStoresService;

	@Autowired
	private CommonUtilityService cusCommonUtilityService;

	@RequestMapping(value = "/list")
	public ManageStoresResultBean getManageStoresList() {
		ManageStoresResultBean manageStoresResultBean = new ManageStoresResultBean();
		try {
			manageStoresResultBean.setManageStoresList(manageStoresService.getManageStoresList());
			manageStoresResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return manageStoresResultBean;
	}

	@RequestMapping(value = "/save")
	public ManageStoresResultBean saveAutValue(@RequestBody ManageStoresBean manageStoresBean) {
		ManageStoresResultBean manageStoresResultBean = new ManageStoresResultBean();
		try {
			manageStoresService.saveManageStoresList(manageStoresBean);
			manageStoresResultBean.setSuccess(true);
		} catch (CustomException e) {
			manageStoresResultBean.setSuccess(false);
			manageStoresResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manageStoresResultBean;
	}

	@RequestMapping(value = "/edit")
	public ManageStoresResultBean editAutValue(@RequestBody int locNo) {

		try {
			return manageStoresService.getEditList(locNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteAutValue(@RequestBody String locationId) throws Exception {
		boolean isDeleted = false;
		isDeleted = manageStoresService.getDeleteList(locationId);
		return isDeleted;
	}

	@RequestMapping(value = "/update")
	public ManageStoresResultBean updateAutValue(@RequestBody ManageStoresBean manageStoresBean) {
		ManageStoresResultBean manageStoresResultBean = new ManageStoresResultBean();
		try {
			manageStoresService.updateManageStoresList(manageStoresBean);
			manageStoresResultBean.setSuccess(true);
		} catch (CustomException e) {
			manageStoresResultBean.setSuccess(false);
			manageStoresResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manageStoresResultBean;
	}

	@RequestMapping(value = "/parentlocationlist")
	public ManageStoresResultBean getparentlocationList() {

		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		try {
			resultBean = manageStoresService.getparentlocationList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;

	}

	@RequestMapping(value = "/locationtypelist")
	public ManageStoresResultBean getlocationtypeList() {

		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		try {
			resultBean = manageStoresService.getlocationtypeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;

	}

	@RequestMapping(value = "/statelist")
	public ManageStoresResultBean getstateList(@RequestBody String cityId) {
		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		try {
			resultBean = manageStoresService.getstatelist(cityId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping(value = "/countrylist")
	public ManageStoresResultBean getcountryList(@RequestBody String cityId) {
		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		try {
			resultBean = manageStoresService.getcountrylist(cityId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping(value = "/inchargelist")
	public ManageStoresResultBean getinchargeList() {
		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		try {
			resultBean = manageStoresService.getinchargeList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping(value = "/citylist")
	public ManageStoresResultBean getcityList() {
		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		try {
			resultBean = manageStoresService.getcitylist();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping(value = "/parentAddress")
	public ManageStoresResultBean getParentAddress(@RequestBody int pid) {
		ManageStoresResultBean resultBean = new ManageStoresResultBean();
		try {
			resultBean = manageStoresService.getParentAddress(pid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping("/checkStoreName")
	public @ResponseBody int checkStoreName(@RequestParam("manageName") String manageName) throws CustomException {
		int storeName = 0;

		try {
			storeName = manageStoresService.checkStoreName(manageName);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return storeName;
	}
}
