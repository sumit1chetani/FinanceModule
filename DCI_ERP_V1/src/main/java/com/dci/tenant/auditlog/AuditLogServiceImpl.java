package com.dci.tenant.auditlog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class AuditLogServiceImpl implements AuditLogService {
	@Autowired
	AuditLogDAO auditLogDAO;

	//@Autowired
	//UserMasterDAO userMasterDAO;

	@Override
	public List<AuditLogBean> getAuditLogList(String date, String employeeNo) throws CustomException {
		// TODO Auto-generated method stub
		List<AuditLogBean> lAuditLogList = auditLogDAO.getAuditLogList(date, employeeNo);
		//Map<String, String> formCodeNameMap = userMasterDAO.getFormCodeNameMap();
		//Map<String, String> empIdNameMap = userMasterDAO.getEmpIdNameMap();
		for (AuditLogBean auditLogItem : lAuditLogList) {
			//auditLogItem.setEmployeeName(empIdNameMap.get(auditLogItem.getEmployeeId()));
			//auditLogItem.setFormName(formCodeNameMap.get(auditLogItem.getFormCode()));
		}

		return lAuditLogList;
	}

	@Override
	public List<SesLogBean> getSesLogList(String date, String employeeNo) throws CustomException {
		// TODO Auto-generated method stub
		List<SesLogBean> lSesLogList = auditLogDAO.getSesLogList(date, employeeNo);
		//Map<String, String> empIdNameMap = userMasterDAO.getEmpIdNameMap();
		for (SesLogBean sesLogItem : lSesLogList) {
			//sesLogItem.setEmployeeName(empIdNameMap.get(sesLogItem.getEmployeeId()));
		}

		return lSesLogList;
	}

	@Override
	public void insertSessionLog(String userId, String ipAddress, String action) {
		SesLogBean sesLogBean = new SesLogBean();
		sesLogBean.setEmployeeId(userId);
		sesLogBean.setAction(action);
		sesLogBean.setIpAddress(ipAddress);
		sesLogBean.setCreatedOn(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS").format(new Date()));
		auditLogDAO.insertSessionLog(sesLogBean);
	}

	@Override
	public void auditLogForInsert(Object newObject, UserLog userLog, String parentId) {
		auditLogDAO.auditLogForInsert(newObject, userLog, parentId);
	}

	@Override
	public void auditLogForUpdate(Object oldObject, Object newObject, UserLog userLog, String parentId) {
		auditLogDAO.auditLogForUpdate(oldObject, newObject, userLog, parentId);
	}

	@Override
	public void auditLogForDelete(Object newObject, UserLog userLog, String parentId) {
		auditLogDAO.auditLogForDelete(newObject, userLog, parentId);
	}
}
