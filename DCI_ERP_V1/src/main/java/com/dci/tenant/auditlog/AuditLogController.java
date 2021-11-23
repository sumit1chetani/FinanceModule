package com.dci.tenant.auditlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "app/auditlog")
public class AuditLogController {

	@Autowired
	private AuditLogService auditLogService;

	@RequestMapping(value = "/list")
	public AuditLogResultBean getAuditLogList(@RequestBody AuditLogBean auditLog) throws CustomException {
		AuditLogResultBean auditLogResultBean = new AuditLogResultBean();
		auditLogResultBean.setAuditLogBeanList(auditLogService.getAuditLogList(auditLog.getCreatedOn(), auditLog.getEmployeeId()));
		auditLogResultBean.setSuccess(true);
		return auditLogResultBean;
	}

	@RequestMapping(value = "/session/list")
	public AuditLogResultBean getSesLogList(@RequestBody SesLogBean auditLog) throws CustomException {
		AuditLogResultBean auditLogResultBean = new AuditLogResultBean();
		auditLogResultBean.setSesLogBeanList(auditLogService.getSesLogList(auditLog.getCreatedOn(), auditLog.getEmployeeId()));
		auditLogResultBean.setSuccess(true);
		return auditLogResultBean;
	}

	@RequestMapping(value = "/employeelist")
	public AuditLogResultBean getEmployeeList() throws Exception {
		AuditLogResultBean auditLogResultBean = new AuditLogResultBean();
		//auditLogResultBean.setEmployeeList(userMasterService.getUserList());
		auditLogResultBean.setSuccess(true);
		return auditLogResultBean;

	}
}
