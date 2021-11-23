package com.dci.tenant.auditlog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserMasterDAO;

@Service
public class UserLogServiceImpl implements UserLogService {

	@Autowired
	UserLogDAO userLogDAO;

	@Autowired
	UserMasterDAO userMasterDAO;
//
//	@Override
//	public List<UserLog> getUserLogList(UserLog userLog) throws CustomException {
//		List<UserLog> lUserLog = userLogDAO.getUserLogList(userLog);
//		Map<String, String> formCodeNameMap = userMasterDAO.getFormCodeNameMap();
//		Map<String, String> empIdNameMap = userMasterDAO.getEmpIdNameMap();
//		for (UserLog userLogItem : lUserLog) {
//			userLogItem.setEmployeeName(empIdNameMap.get(userLogItem.getEmployeeId()));
//			userLogItem.setFormName(formCodeNameMap.get(userLogItem.getFormCode()));
//		}
//		return lUserLog;
//	}

	
	
	@Override
	public List<UserLog> getUserLogList(UserLog userLog) throws CustomException {
		// TODO Auto-generated method stub
		return userLogDAO.getUserLogList(userLog);
	}
	
//	@Override
//	public List<UserLog> getFormCodeList() throws Exception {
//		UserLog obj=null;
//		List<String> alformlist = userLogDAO.getFormCodeList();
//		List<UserLog> FormList=new ArrayList<UserLog>();
//		//Map<String, String> formCodeNameMap = userMasterDAO.getFormCodeNameMap();
//		for (String val : alformlist) {
//			if(!val.equals("")){
//				//if(formCodeNameMap.get(val) != null){
//					obj=new UserLog();
//					obj.setFormCode(val);
//					obj.setId(val);
//				//	obj.setText(formCodeNameMap.get(val));
//					FormList.add(obj);	
//				//}
//			}
//		}
//		return FormList;
//	}
	
	
	@Override
	public List<UserLog> getFormCodeList() throws Exception {
		return userLogDAO.getFormCodeList();
	}
	
	@Override
	public List<EmployeeMasterBean> getEmployeeList() throws CustomException {
		return userLogDAO.getEmployeeList();
	}
	
	
	//User IP Log List
	
		@Override
		public List<UserLog> getUserIPLogList(UserLog userLog) throws CustomException {
			return userLogDAO.getUserIPLogList(userLog);
		}

	@Override
	public List<UserLog> getTableNameList() throws Exception {
		return userLogDAO.getTableNameList();
	}

	@Override
	public UserLog userLogForInsert(Object newObject, String primaryId, String createdBy) {
		return userLogDAO.userLogForInsert(newObject, primaryId, createdBy);
	}

	@Override
	public UserLog userLogForUpdate(Object oldObject, Object newObject, String primaryId, String createdBy) {
		return userLogDAO.userLogForUpdate(oldObject, newObject, primaryId, createdBy);
	}

	@Override
	public UserLog userLogForDelete(Object oldObject, String primaryId, String createdBy) {
		return userLogDAO.userLogForDelete(oldObject, primaryId, createdBy);
	}
}
