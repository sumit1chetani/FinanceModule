package com.dci.finance.permissionApproval;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;


@Controller
@RequestMapping(value = "{tenantid}app/permissionrequestapproval")
public class PermissionApprovalCancellationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(PermissionApprovalCancellationController.class);

	@Autowired
	private PermissionApprovalCancellationService permissionapprovalcancellationService;

	// Populate Grid
	@RequestMapping("/list")
	public @ResponseBody PermissionApprovalCancellationResultBean PermissionRequestApprovalList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		PermissionApprovalCancellationResultBean objPermissionApprovalCancellationResultBean = new PermissionApprovalCancellationResultBean();
		if (offset < 5000) {
			try {
				objPermissionApprovalCancellationResultBean.setlPermissionApprovalCancellationBean(permissionapprovalcancellationService.getPermissionRequestApprovalList(limit, offset));
				objPermissionApprovalCancellationResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objPermissionApprovalCancellationResultBean;
	}

	// Populate Grid
	@RequestMapping("/getrecentlist")
	public @ResponseBody PermissionApprovalCancellationResultBean getRecentRequestList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		PermissionApprovalCancellationResultBean objPermissionApprovalCancellationResultBean = new PermissionApprovalCancellationResultBean();
		if (offset < 5000) {
			try {
				objPermissionApprovalCancellationResultBean.setlPermissionApprovalCancellationBean(permissionapprovalcancellationService.getRecentRequestList(limit, offset));
				objPermissionApprovalCancellationResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objPermissionApprovalCancellationResultBean;
	}

	// Asset Edit
	@RequestMapping(value = "/edit")
	public @ResponseBody PermissionApprovalCancellationBean editPermissionRequestApproval(@RequestBody String id) throws Exception {
		try {
			return permissionapprovalcancellationService.editPermissionRequestApproval(id);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
	}

	// Asset Update
	@RequestMapping(value = "/update")
	public @ResponseBody boolean updatePermissionRequestApproval(@RequestBody PermissionApprovalCancellationBean objPermissionApprovalCancellationBean) throws CustomException {
		boolean isSuccess = false;
		PermissionApprovalCancellationResultBean objPermissionApprovalCancellationResultBean = new PermissionApprovalCancellationResultBean();
		try {
			isSuccess = permissionapprovalcancellationService.updatePermissionRequestApproval(objPermissionApprovalCancellationBean);
			if (isSuccess) {
				int offset = 0;
				int limit = 0;
				objPermissionApprovalCancellationResultBean.setlPermissionApprovalCancellationBean(permissionapprovalcancellationService.getPermissionRequestApprovalList(limit, offset));
				objPermissionApprovalCancellationResultBean.setSuccess(true);
			}
		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}
		return isSuccess;
	}
}
