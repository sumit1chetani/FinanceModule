package com.dci.tenant.auditlog;

import java.util.List;

import com.dci.common.util.CustomException;

public interface AuditLogDAO {

	public List<AuditLogBean> getAuditLogList(String date, String employeeNo) throws CustomException;

	public List<SesLogBean> getSesLogList(String date, String employeeNo) throws CustomException;

	public void auditLogForInsert(Object newObject, UserLog userLog, String parentId);

	public void auditLogForUpdate(Object oldObject, Object newObject, UserLog userLog, String parentId);

	public void auditLogForDelete(Object newObject, UserLog userLog, String parentId);

	public void insertAuditLog(List<AuditLogBean> auditLogBeanList);

	public void insertSessionLog(SesLogBean sesLogBean);
}
