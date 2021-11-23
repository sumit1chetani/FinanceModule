package com.dci.tenant.auditlog;

import java.util.List;

import com.dci.common.util.CustomException;

public interface UserLogService {

	List<UserLog> getUserLogList(UserLog userLog) throws CustomException;
	
	List<UserLog> getUserIPLogList(UserLog userLog) throws CustomException;
	
	public List<EmployeeMasterBean> getEmployeeList() throws CustomException;


	public List<UserLog> getFormCodeList() throws Exception;

	public List<UserLog> getTableNameList() throws Exception;

	public UserLog userLogForInsert(Object newObject, String primaryId, String createdBy);

	public UserLog userLogForUpdate(Object oldObject, Object newObject, String primaryId, String createdBy);

	public UserLog userLogForDelete(Object oldObject, String primaryId, String createdBy);

}
