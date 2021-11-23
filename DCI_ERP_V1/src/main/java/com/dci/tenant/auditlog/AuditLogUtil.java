/**
 *
 */
package com.dci.tenant.auditlog;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.dci.tenant.user.UserDetail;

/**
 * @author paragon
 *
 */
@Component
public class AuditLogUtil {

	@Autowired
	AuditLogDAO auditLogDAO;

	public static final String AUDIT_ACTION_INSERT = "ADD";

	public static final String AUDIT_ACTION_UPDATE = "UPDATE";

	public static final String AUDIT_ACTION_DELETE = "DELETE";

	public static List<AuditLogBean> auditLogForUpdate(Object oldObject, Object newObject, UserLog userLog, String parentId) throws Exception {
		String ipAddress="";
		try{
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ipAddress=userDetails.getUserIpAddress();
		}catch(Exception e){
			e.printStackTrace();
		}
		List<AuditLogBean> auditLogList = new ArrayList<AuditLogBean>();
		Method[] methods = oldObject.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
				if (method.isAnnotationPresent(AuditLoggable.class)) {
					String isAuditLoggable = method.getAnnotation(AuditLoggable.class).isAuditLog();
					if (isAuditLoggable == null || (isAuditLoggable != null && isAuditLoggable.isEmpty())
							|| (isAuditLoggable != null && isAuditLoggable.equals("true"))) {
						Method compareMethod = newObject.getClass().getMethod(method.getName());
						Object baseResult = method.invoke(oldObject);
						Object compareResult = compareMethod.invoke(newObject);
						if (!new EqualsBuilder().append(baseResult, compareResult).isEquals()) {
							AuditLogBean auditLog = new AuditLogBean();
							auditLog.setEmployeeId(userLog.getEmployeeId());
							auditLog.setFormCode(userLog.getFormCode());
							auditLog.setAction(AuditLogUtil.AUDIT_ACTION_UPDATE);
							auditLog.setFieldName(method.getAnnotation(AuditLoggable.class).fieldName());
							auditLog.setDisplayName(method.getAnnotation(AuditLoggable.class).displayName());
							auditLog.setPrimaryId(userLog.getPrimaryDataId());
							auditLog.setFieldName(method.getAnnotation(AuditLoggable.class).fieldName());
							auditLog.setTableName(userLog.getTableName());
							auditLog.setParentId(parentId);
							auditLog.setIpAddrs(ipAddress);
							auditLog.setUserLogId(userLog.getUserLogId());
							if (baseResult != null) {
								auditLog.setOldValue(baseResult.toString());
							}
							if (compareResult != null) {
								auditLog.setNewValue(compareResult.toString());
							}
							auditLogList.add(auditLog);
						}
					}
				}
			}
		}
		return auditLogList;
	}

	public static List<AuditLogBean> auditLogForInsert(Object newObject, UserLog userLog, String parentId) throws Exception {
		String ipAddress="";
		try{
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ipAddress=userDetails.getUserIpAddress();
		}catch(Exception e){
			e.printStackTrace();
		}
		List<AuditLogBean> auditLogList = new ArrayList<AuditLogBean>();
		Method[] methods = newObject.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
				if (method.isAnnotationPresent(AuditLoggable.class)) {
					String isAuditLoggable = method.getAnnotation(AuditLoggable.class).isAuditLog();
					if (isAuditLoggable == null || (isAuditLoggable != null && isAuditLoggable.isEmpty())
							|| (isAuditLoggable != null && isAuditLoggable.equals("true"))) {
						Object value = method.invoke(newObject);
						AuditLogBean auditLog = new AuditLogBean();
						auditLog.setEmployeeId(userLog.getEmployeeId());
						auditLog.setFormCode(userLog.getFormCode());
						auditLog.setAction(AuditLogUtil.AUDIT_ACTION_INSERT);
						auditLog.setFieldName(method.getAnnotation(AuditLoggable.class).fieldName());
						auditLog.setDisplayName(method.getAnnotation(AuditLoggable.class).displayName());
						auditLog.setPrimaryId(userLog.getPrimaryDataId());
						auditLog.setTableName(userLog.getTableName());
						auditLog.setParentId(parentId);
						auditLog.setUserLogId(userLog.getUserLogId());
						auditLog.setIpAddrs(ipAddress);
						if (value != null) {
							auditLog.setNewValue(value.toString());
						}
						auditLogList.add(auditLog);
					}
				}
			}
		}
		return auditLogList;
	}

	public static List<AuditLogBean> auditLogForDelete(Object newObject, UserLog userLog, String parentId) throws Exception {
		String ipAddress="";
		try{
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ipAddress=userDetails.getUserIpAddress();
		}catch(Exception e){
			e.printStackTrace();
		}
		SecurityContextHolder.getContext().getAuthentication();
		List<AuditLogBean> auditLogList = new ArrayList<AuditLogBean>();
		Method[] methods = newObject.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
				if (method.isAnnotationPresent(AuditLoggable.class)) {
					String isAuditLoggable = method.getAnnotation(AuditLoggable.class).isAuditLog();
					if (isAuditLoggable == null || (isAuditLoggable != null && isAuditLoggable.isEmpty())
							|| (isAuditLoggable != null && isAuditLoggable.equals("true"))) {
						Object value = method.invoke(newObject);
						AuditLogBean auditLog = new AuditLogBean();
						auditLog.setEmployeeId(userLog.getEmployeeId());
						auditLog.setFormCode(userLog.getFormCode());
						auditLog.setAction(AuditLogUtil.AUDIT_ACTION_DELETE);
						auditLog.setFieldName(method.getAnnotation(AuditLoggable.class).fieldName());
						auditLog.setDisplayName(method.getAnnotation(AuditLoggable.class).displayName());
						auditLog.setPrimaryId(userLog.getPrimaryDataId());
						auditLog.setTableName(userLog.getTableName());
						auditLog.setParentId(parentId);
						auditLog.setIpAddrs(ipAddress);
						auditLog.setUserLogId(userLog.getUserLogId());
						if (value != null) {
							auditLog.setOldValue(value.toString());
						}
						auditLogList.add(auditLog);
					}
				}
			}
		}
		return auditLogList;
	}
}
