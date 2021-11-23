package com.dci.finance.managelocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.tenant.common.CommonUtilityService;
import com.dci.tenant.user.UserDetail;

@RestController
@RequestMapping("/his/inventory/settings/managelocation")
public class ManageLocationController {

	@Autowired
	private ManageLocationService manageLocationService;

	@Autowired
	private CommonUtilityService cusCommonUtilityService;

	@RequestMapping(value = "/list")
	public ManageLocationResultBean getManageLocationList() {
		ManageLocationResultBean manageLocationResultBean = new ManageLocationResultBean();
		try {
			manageLocationResultBean.setManageLocationList(manageLocationService.getManageLocationList());
			manageLocationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return manageLocationResultBean;
	}

	@RequestMapping(value = "/save")
	public ManageLocationResultBean saveAutValue(@RequestBody ManageLocationBean manageLocationBean) {
		ManageLocationResultBean manageLocationResultBean = new ManageLocationResultBean();
		try {
			manageLocationService.saveManageLocationList(manageLocationBean);
			manageLocationResultBean.setSuccess(true);
		} catch (CustomException e) {
			manageLocationResultBean.setSuccess(false);
			manageLocationResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manageLocationResultBean;
	}

	@RequestMapping(value = "/edit")
	public ManageLocationResultBean editAutValue(@RequestBody int locNo) {

		try {
			return manageLocationService.getEditList(locNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteAutValue(@RequestBody String locationId) throws Exception {
		boolean isDeleted = false;
		isDeleted = manageLocationService.getDeleteList(locationId);
		return isDeleted;
	}

	@RequestMapping("/multiDelete")
	public @ResponseBody ManageLocationResultBean multiDeleteValue(@RequestBody List<ManageLocationBean> lManageLocationBean) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		ManageLocationResultBean resultBean = new ManageLocationResultBean();

		try {
			resultBean.setMessage(manageLocationService.multiDeleteValue(userId, lManageLocationBean));
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException();
		}
		return resultBean;
	}

	@RequestMapping(value = "/update")
	public ManageLocationResultBean updateAutValue(@RequestBody ManageLocationBean manageLocationBean) {
		ManageLocationResultBean manageLocationResultBean = new ManageLocationResultBean();
		try {
			manageLocationService.updateManageLocationList(manageLocationBean);
			manageLocationResultBean.setSuccess(true);
		} catch (CustomException e) {
			manageLocationResultBean.setSuccess(false);
			manageLocationResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manageLocationResultBean;
	}

	@RequestMapping(value = "/locationtypelist")
	public ManageLocationResultBean getlocationtypeList() {

		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		try {
			resultBean = manageLocationService.getlocationtypeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;

	}

	@RequestMapping(value = "/parentlocationlist")
	public ManageLocationResultBean getparentlocationList() {

		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		try {
			resultBean = manageLocationService.getparentlocationList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;

	}

	@RequestMapping(value = "/statelist")
	public ManageLocationResultBean getstateList(@RequestBody String cityId) {
		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		try {
			resultBean = manageLocationService.getstatelist(cityId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping(value = "/countrylist")
	public ManageLocationResultBean getcountryList(@RequestBody String cityId) {
		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		try {
			resultBean = manageLocationService.getcountrylist(cityId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping(value = "/inchargelist")
	public ManageLocationResultBean getinchargeList() {
		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		try {
			resultBean = manageLocationService.getinchargeList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping(value = "/citylist")
	public ManageLocationResultBean getcityList() {
		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		try {
			resultBean = manageLocationService.getcitylist();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping(value = "/parentAddress")
	public ManageLocationResultBean getParentAddress(@RequestBody int pid) {
		ManageLocationResultBean resultBean = new ManageLocationResultBean();
		try {
			resultBean = manageLocationService.getParentAddress(pid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;
	}

	@RequestMapping("/checkLocationName")
	public @ResponseBody int checkLocationName(@RequestParam("manageName") String manageName) throws CustomException {
		int storeName = 0;

		try {
			storeName = manageLocationService.checkLocationName(manageName);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return storeName;
	}
}
