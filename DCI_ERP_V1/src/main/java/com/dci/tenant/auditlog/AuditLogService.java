package com.dci.tenant.auditlog;

import java.util.List;

import com.dci.common.util.CustomException;

public interface AuditLogService {

	List<AuditLogBean> getAuditLogList(String date, String employeeNo) throws CustomException;

	public void auditLogForInsert(Object newObject, UserLog userLog, String parentId);

	public void auditLogForUpdate(Object oldObject, Object newObject, UserLog userLog, String parentId);

	public void auditLogForDelete(Object newObject, UserLog userLog, String parentId);

	List<SesLogBean> getSesLogList(String date, String employeeNo) throws CustomException;

	void insertSessionLog(String userId, String ipAddress, String action);
}
