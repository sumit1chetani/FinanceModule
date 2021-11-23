package com.dci.tenant.finance.staffnotification;

public interface StaffNotificationDAO {

	public StaffNotificationResultBean getNotification();

	public StaffNotificationResultBean getDepartmentList();

	public StaffNotificationResultBean getDesignationList();

	public StaffNotificationResultBean getDivisionList();

	public StaffNotificationResultBean getRepotingToList();

	public StaffNotificationResultBean getGradeList();

	public StaffNotificationResultBean publishNotification(int staffNotificationId);

	public StaffNotificationResultBean publish(int staffNotificationId);

	public StaffNotificationResultBean unpublish(int staffNotificationId);

	public StaffNotificationResultBean saveNotification(StaffNotificationBeanDetail staffNotificationBeanDetail);

	public StaffNotificationResultBean updateNotification(StaffNotificationBeanDetail staffNotificationBeanDetail);

	public StaffNotificationResultBean editNotification(int staffNotificationId);

	public StaffNotificationResultBean deleteNotification(int staffNotificationId);

	public StaffNotificationResultBean saveAndPublishNotification(StaffNotificationBeanDetail staffNotificationBeanDetail);

	public StaffNotificationResultBean UpdateAndPublishNotification(StaffNotificationBeanDetail staffNotificationBeanDetail);

}
