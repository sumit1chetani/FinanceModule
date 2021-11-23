/**
 *
 */
package com.dci.tenant.auditlog;
/**
 *
 */

import java.lang.reflect.Method;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dci.tenant.user.UserDetail;

/**
 * @author paragon
 *
 */
public class UserLogUtil {
	public static final String AUDIT_ACTION_FREIGHT_INVOICE = "FREIGHT INVOICE";

	public static final String AUDIT_ACTION_INSERT = "ADD";

	public static final String AUDIT_ACTION_UPDATE = "UPDATE";

	public static final String AUDIT_ACTION_DELETE = "DELETE";

	public static UserLog userLogDescForUpdate(Object oldObject, Object newObject, String primaryId, String updatedBy) {
		String ipAddress="";
		try{
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ipAddress=userDetails.getUserIpAddress();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String logDescription = "";
		String newValue = "";
		String oldValue = "";
		String formCode = "";
		String tableName = "";
		UserLog userLog = new UserLog();
		Method[] methods = oldObject.getClass().getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
					if (method.isAnnotationPresent(AuditLoggable.class)) {
						String isUserLoggable = method.getAnnotation(AuditLoggable.class).isUserLog();
						if (isUserLoggable == null || (isUserLoggable != null && isUserLoggable.isEmpty())
								|| (isUserLoggable != null && isUserLoggable.equals("true"))) {
							Method compareMethod;

							compareMethod = newObject.getClass().getMethod(method.getName());
							Object baseResult = method.invoke(oldObject);
							Object compareResult = compareMethod.invoke(newObject);
							if (!new EqualsBuilder().append(baseResult, compareResult).isEquals()) {
								String name = method.getAnnotation(AuditLoggable.class).displayName();
								if (compareResult != null) {
									newValue = compareResult.toString();
								}
								if (baseResult != null) {
									oldValue = baseResult.toString();

								}
								logDescription += name + " Changed from '" + oldValue + "' to '" + newValue + "'. ";
							}

						}
					}
				}
			}

			if (newObject.getClass().isAnnotationPresent(AuditLoggableType.class)) {
				AuditLoggableType annotation = newObject.getClass().getAnnotation(AuditLoggableType.class);
				if (annotation.formCode() != null) {
					formCode = annotation.formCode();
				}

				if (annotation.tableName() != null) {
					tableName = annotation.tableName().toString();
				}
			}
			userLog.setEmployeeId(updatedBy);
			userLog.setFormCode(formCode);
			userLog.setActionType(UserLogUtil.AUDIT_ACTION_UPDATE);
			userLog.setPrimaryDataId(primaryId);
			userLog.setTableName(tableName);
			userLog.setIpAddres(ipAddress);
			userLog.setLogDescription(logDescription);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userLog;
	}

	public static UserLog userLogDescForInsert(Object newObject, String primaryId, String createdBy) throws Exception {
		UserLog userLog = new UserLog();
		try{
			String ipAddress="";
			try{
				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				ipAddress=userDetails.getUserIpAddress();
			}catch(Exception e){
				e.printStackTrace();
			}
			String logDescription = "";
			String formCode = "";
			String tableName = "";
			SecurityContextHolder.getContext().getAuthentication();
			Method[] methods = newObject.getClass().getMethods();
			
			for (Method method : methods) {
				if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
					if (method.isAnnotationPresent(AuditLoggable.class)) {
						String isUserLoggable = method.getAnnotation(AuditLoggable.class).isUserLog();
						if (isUserLoggable == null || (isUserLoggable != null && isUserLoggable.isEmpty())
								|| (isUserLoggable != null && isUserLoggable.equals("true"))) {
							Object value;
	
							value = method.invoke(newObject);
							String name = method.getAnnotation(AuditLoggable.class).displayName();
							String newValue = "";
							if (value != null) {
								newValue = value.toString();
							}
							logDescription += name + "='" + newValue + "'. ";
	
						}
					}
				}
			}
	
			if (newObject.getClass().isAnnotationPresent(AuditLoggableType.class)) {
				AuditLoggableType annotation = newObject.getClass().getAnnotation(AuditLoggableType.class);
				if (annotation.formCode() != null) {
					formCode = annotation.formCode();
				}
	
				if (annotation.tableName() != null) {
					tableName = annotation.tableName().toString();
				}
			}
	
			userLog.setEmployeeId(createdBy);
			userLog.setFormCode(formCode);
			userLog.setActionType(UserLogUtil.AUDIT_ACTION_INSERT);
			userLog.setPrimaryDataId(primaryId + "");
			userLog.setTableName(tableName);
			userLog.setIpAddres(ipAddress);
			userLog.setLogDescription(logDescription);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return userLog;
	}

	public static UserLog userLogDescForDelete(Object newObject, String primaryId, String createdBy) {
		String ipAddress="";
		try{
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ipAddress=userDetails.getUserIpAddress();
		}catch(Exception e){
			e.printStackTrace();
		}
		String logDescription = "";
		String formCode = "";
		String tableName = "";
		SecurityContextHolder.getContext().getAuthentication();
		UserLog userLog = new UserLog();
		Method[] methods = newObject.getClass().getMethods();
		try {
			for (Method method : methods) {
				if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
					if (method.isAnnotationPresent(AuditLoggable.class)) {
						String isUserLoggable = method.getAnnotation(AuditLoggable.class).isUserLog();
						if (isUserLoggable == null || (isUserLoggable != null && isUserLoggable.isEmpty())
								|| (isUserLoggable != null && isUserLoggable.equals("true"))) {
							Object value;

							value = method.invoke(newObject);
							String name = method.getAnnotation(AuditLoggable.class).displayName();
							String oldValue = "";
							if (value != null) {
								oldValue = value.toString();
							}
							logDescription += name + "='" + oldValue + "'. ";

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (newObject.getClass().isAnnotationPresent(AuditLoggableType.class)) {
			AuditLoggableType annotation = newObject.getClass().getAnnotation(AuditLoggableType.class);
			if (annotation.formCode() != null) {
				formCode = annotation.formCode();
			}

			if (annotation.tableName() != null) {
				tableName = annotation.tableName().toString();
			}
		}

		userLog.setEmployeeId(createdBy);
		userLog.setFormCode(formCode);
		userLog.setActionType(UserLogUtil.AUDIT_ACTION_DELETE);
		userLog.setPrimaryDataId(primaryId);
		userLog.setTableName(tableName);
		userLog.setIpAddres(ipAddress);
		userLog.setLogDescription(logDescription);
		

		return userLog;
	}


	public static UserLog userLogForFreightInvoice(Object newObject, String primaryId, String createdBy,
			String printType) throws Exception {
		UserLog userLog = new UserLog();
		try {
			String ipAddress = "";
			try {
				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication()
						.getPrincipal();
				ipAddress = userDetails.getUserIpAddress();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String logDescription = "";
			String formCode = "";
			String tableName = "";
			SecurityContextHolder.getContext().getAuthentication();
			Method[] methods = newObject.getClass().getMethods();

			for (Method method : methods) {
				if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
					if (method.isAnnotationPresent(AuditLoggable.class)) {
						String isUserLoggable = method.getAnnotation(AuditLoggable.class).isUserLog();
						if (isUserLoggable == null || (isUserLoggable != null && isUserLoggable.isEmpty())
								|| (isUserLoggable != null && isUserLoggable.equals("true"))) {
							Object value;

							value = method.invoke(newObject);
							String name = method.getAnnotation(AuditLoggable.class).displayName();
							String newValue = "";
							if (value != null) {
								newValue = value.toString();
							}
							logDescription += name + "='" + newValue + "'. ";

						}
					}
				}
			}

			if (newObject.getClass().isAnnotationPresent(AuditLoggableType.class)) {
				AuditLoggableType annotation = newObject.getClass().getAnnotation(AuditLoggableType.class);
				if (annotation.formCode() != null) {
					formCode = annotation.formCode();
				}

				if (annotation.tableName() != null) {
					tableName = annotation.tableName().toString();
				}
			}

			userLog.setEmployeeId(createdBy);
			userLog.setFormCode(formCode);
			if (printType.equals("FIN")) {
				userLog.setActionType(UserLogUtil.AUDIT_ACTION_FREIGHT_INVOICE);
			}

			userLog.setPrimaryDataId(primaryId + "");
			userLog.setTableName(tableName);
			userLog.setIpAddres(ipAddress);
			userLog.setLogDescription(logDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userLog;
	}
}
