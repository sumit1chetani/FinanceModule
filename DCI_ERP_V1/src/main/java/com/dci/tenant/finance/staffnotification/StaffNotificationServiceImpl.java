package com.dci.tenant.finance.staffnotification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffNotificationServiceImpl implements StaffNotificationService {

	@Autowired
	StaffNotificationDAO staffNotificationDAO;

	@Override
	public StaffNotificationResultBean getNotification() {
		// TODO Auto-generated method stub
		return staffNotificationDAO.getNotification();
	}

	@Override
	public StaffNotificationResultBean publishNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		return staffNotificationDAO.publishNotification(staffNotificationId);
	}

	@Override
	public StaffNotificationResultBean publish(int staffNotificationId) {
		// TODO Auto-generated method stub
		return staffNotificationDAO.publish(staffNotificationId);
	}

	@Override
	public StaffNotificationResultBean saveNotification(StaffNotificationBeanDetail staffNotificationBeanDetail) {
		// TODO Auto-generated method stub
		return staffNotificationDAO.saveNotification(staffNotificationBeanDetail);
	}

	@Override
	public StaffNotificationResultBean updateNotification(StaffNotificationBeanDetail staffNotificationBeanDetail) {
		// TODO Auto-generated method stub
		return staffNotificationDAO.updateNotification(staffNotificationBeanDetail);
	}

	@Override
	public StaffNotificationResultBean editNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		return staffNotificationDAO.editNotification(staffNotificationId);
	}

	@Override
	public StaffNotificationResultBean deleteNotification(int staffNotificationId) {
		// TODO Auto-generated method stub
		return staffNotificationDAO.deleteNotification(staffNotificationId);
	}

	@Override
	public StaffNotificationResultBean saveAndPublishNotification(StaffNotificationBeanDetail staffNotificationBeanDetail) {
		// TODO Auto-generated method stub
		return staffNotificationDAO.saveAndPublishNotification(staffNotificationBeanDetail);
	}

	@Override
	public StaffNotificationResultBean getDepartmentList() {
		// TODO Auto-generated method stub
		return staffNotificationDAO.getDepartmentList();
	}

	@Override
	public StaffNotificationResultBean getDesignationList() {
		// TODO Auto-generated method stub
		return staffNotificationDAO.getDesignationList();
	}

	@Override
	public StaffNotificationResultBean getDivisionList() {
		// TODO Auto-generated method stub
		return staffNotificationDAO.getDivisionList();
	}

	@Override
	public StaffNotificationResultBean getRepotingToList() {
		// TODO Auto-generated method stub
		return staffNotificationDAO.getRepotingToList();
	}

	@Override
	public StaffNotificationResultBean getGradeList() {
		// TODO Auto-generated method stub
		return staffNotificationDAO.getGradeList();
	}

	@Override
	public StaffNotificationResultBean UpdateAndPublishNotification(StaffNotificationBeanDetail staffNotificationBeanDetail) {
		// TODO Auto-generated method stub
		return staffNotificationDAO.UpdateAndPublishNotification(staffNotificationBeanDetail);
	}

	@Override
	public StaffNotificationResultBean unpublish(int staffNotificationId) {
		// TODO Auto-generated method stub
		return staffNotificationDAO.unpublish(staffNotificationId);
	}

}
