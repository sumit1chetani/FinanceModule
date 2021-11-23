package com.dci.tenant.finance.staffcircular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffCircularServiceImpl implements StaffCircularService {

	@Autowired
	StaffCircularDAO StaffCircularDAO;

	@Override
	public StaffCircularResultBean getNotification() {
		// TODO Auto-generated method stub
		return StaffCircularDAO.getNotification();
	}

	@Override
	public StaffCircularResultBean publishNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		return StaffCircularDAO.publishNotification(staffNotificationId);
	}

	@Override
	public StaffCircularResultBean saveNotification(StaffCircularBean StaffCircularBean) {
		// TODO Auto-generated method stub
		return StaffCircularDAO.saveNotification(StaffCircularBean);
	}

	@Override
	public StaffCircularResultBean updateNotification(StaffCircularBean StaffCircularBean) {
		// TODO Auto-generated method stub
		return StaffCircularDAO.updateNotification(StaffCircularBean);
	}

	@Override
	public StaffCircularResultBean editNotification(int staffCircularId) {
		// TODO Auto-generated method stub
		return StaffCircularDAO.editNotification(staffCircularId);
	}

	@Override
	public StaffCircularResultBean deleteNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		return StaffCircularDAO.deleteNotification(staffNotificationId);
	}

	@Override
	public StaffCircularResultBean saveAndPublishNotification(StaffCircularBean StaffCircularBean) {
		// TODO Auto-generated method stub
		return StaffCircularDAO.saveAndPublishNotification(StaffCircularBean);
	}

	@Override
	public StaffCircularResultBean getDepartmentList() {
		// TODO Auto-generated method stub
		return StaffCircularDAO.getDepartmentList();
	}

	@Override
	public StaffCircularResultBean getDesignationList() {
		// TODO Auto-generated method stub
		return StaffCircularDAO.getDesignationList();
	}

	@Override
	public StaffCircularResultBean getDivisionList() {
		// TODO Auto-generated method stub
		return StaffCircularDAO.getDivisionList();
	}

	@Override
	public StaffCircularResultBean getRepotingToList() {
		// TODO Auto-generated method stub
		return StaffCircularDAO.getRepotingToList();
	}

	@Override
	public StaffCircularResultBean getGradeList() {
		// TODO Auto-generated method stub
		return StaffCircularDAO.getGradeList();
	}

	@Override
	public StaffCircularResultBean UpdateAndPublishNotification(StaffCircularBean StaffCircularBean) {
		// TODO Auto-generated method stub
		return StaffCircularDAO.UpdateAndPublishNotification(StaffCircularBean);
	}
}
