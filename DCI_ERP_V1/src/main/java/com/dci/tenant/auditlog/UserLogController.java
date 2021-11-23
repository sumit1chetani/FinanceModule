package com.dci.tenant.auditlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "{tenantid}/app/userlog")
public class UserLogController {

	@Autowired
	private UserLogService userLogService;

	//@Autowired
	//private UserMasterService userMasterService;

	@RequestMapping(value = "/list")
	public UserLogResultBean getUserLogList(@RequestBody UserLog userLog) throws CustomException {
		UserLogResultBean userLogResultBean = new UserLogResultBean();

		userLogResultBean.setUserLogList(userLogService.getUserLogList(userLog));
		userLogResultBean.setSuccess(true);

		return userLogResultBean;

	}

//	@RequestMapping(value = "/employeelist")
//	public UserLogResultBean getEmployeeList() throws CustomException {
//		UserLogResultBean auditLogResultBean = new UserLogResultBean();
//		try {
//			//auditLogResultBean.setEmployeeList(userMasterService.getUserList());
//			auditLogResultBean.setFormCodeList(userLogService.getFormCodeList());
//			auditLogResultBean.setTableNameList(userLogService.getTableNameList());
//			auditLogResultBean.setSuccess(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return auditLogResultBean;
//
//	}
	
	
	@RequestMapping(value = "/employeelist")
	public UserLogResultBean getEmployeeList() throws CustomException {
		UserLogResultBean auditLogResultBean = new UserLogResultBean();
		try {
			auditLogResultBean.setEmployeeList(userLogService.getEmployeeList());
			auditLogResultBean.setFormCodeList(userLogService.getFormCodeList());
			auditLogResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auditLogResultBean;

	}

	
	//User IP Log List
	
		@RequestMapping(value = "/userlist")
		public UserLogResultBean getUserIPLogList(@RequestBody UserLog userLog) throws CustomException {
			UserLogResultBean userLogResultBean = new UserLogResultBean();

			userLogResultBean.setUserIPLogList(userLogService.getUserIPLogList(userLog));
			userLogResultBean.setSuccess(true);

			return userLogResultBean;

		}
}
