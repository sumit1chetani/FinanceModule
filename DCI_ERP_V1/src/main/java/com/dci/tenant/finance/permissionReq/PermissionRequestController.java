package com.dci.tenant.finance.permissionReq;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping(value = "{tenantid}app/permissionrequest")
public class PermissionRequestController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PermissionRequestController.class);

	@Autowired
	private PermissionRequestService permissionRequestService;

	// PermissionRequest Add
	@RequestMapping(value = "/add")
	public @ResponseBody boolean addPermissionRequest(@RequestBody PermissionRequestBean objPermissionRequestBean) throws CustomException, JsonParseException, JsonMappingException, IOException { // =
		boolean isAdded = false; // false;
		PermissionRequestResultBean objPermissionRequestResultBean = new PermissionRequestResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			isAdded = permissionRequestService.addPermissionRequest(objPermissionRequestBean, userId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isAdded;
	}

	@RequestMapping(value = "/getEmployeeDetails")
	public @ResponseBody PermissionRequestResultBean getEmployeeDetails(@RequestBody PermissionRequestBean permissionRequestBean) {
		PermissionRequestResultBean permissionRequestResultBean = new PermissionRequestResultBean();
		try {

			permissionRequestResultBean = permissionRequestService.getEmployeeDetails(permissionRequestBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return permissionRequestResultBean;
	}

	// Populate Grid
	@RequestMapping("/list")
	public @ResponseBody PermissionRequestResultBean PermissionRequestList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		PermissionRequestResultBean objPermissionRequestResultBean = new PermissionRequestResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		if (offset < 5000) {
			try {
				objPermissionRequestResultBean.setLpermissionRequestBean(permissionRequestService.getPermissionRequestList(limit, offset, userId, userName));

				objPermissionRequestResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objPermissionRequestResultBean;
	}

	// Asset Edit
	@RequestMapping(value = "/edit")
	public @ResponseBody PermissionRequestBean editPermissionRequest(@RequestBody String permissionrequestid) throws Exception {
		try {
			return permissionRequestService.editPermissionRequest(permissionrequestid);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
	}

	// Asset Update
	@RequestMapping(value = "/update")
	public @ResponseBody boolean updatePermissionRequest(@RequestBody PermissionRequestBean objPermissionRequestBean) throws CustomException {
		boolean isSuccess = false;
		PermissionRequestResultBean objPermissionRequestResultBean = new PermissionRequestResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		String userName = userDetails.getUsername();
		try {
			isSuccess = permissionRequestService.updatePermissionRequest(objPermissionRequestBean);
			if (isSuccess) {
				int offset = 0;
				int limit = 0;
				objPermissionRequestResultBean.setLpermissionRequestBean(permissionRequestService.getPermissionRequestList(limit, offset, userId, userName));
				objPermissionRequestResultBean.setSuccess(true);
			}
		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}
		return isSuccess;
	}

	// Asset Delete
	@RequestMapping("/delete")
	public @ResponseBody boolean deletePermissionRequest(@RequestBody String permissionrequestid) throws Exception {
		boolean isDeleted = false;
		isDeleted = permissionRequestService.deletePermissionRequest(permissionrequestid);
		return isDeleted;
	}

}
