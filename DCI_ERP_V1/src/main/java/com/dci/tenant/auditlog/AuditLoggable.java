package com.dci.tenant.auditlog;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AuditLoggable {

	String fieldName() default "";;

	String displayName() default "";

	String primaryId() default "";

	String tableName() default "";

	String employeeId() default "";

	String isAuditLog() default "";

	String isUserLog() default "";
	
	String formCode() default "";

}