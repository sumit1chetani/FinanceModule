package com.dci.tenant.finance.staffcircular;


public interface StaffCircularService {
	public StaffCircularResultBean getNotification();

	public StaffCircularResultBean getDepartmentList();

	public StaffCircularResultBean getDesignationList();

	public StaffCircularResultBean getDivisionList();

	public StaffCircularResultBean getRepotingToList();

	public StaffCircularResultBean getGradeList();

	public StaffCircularResultBean UpdateAndPublishNotification(StaffCircularBean StaffCircularBean);

	public StaffCircularResultBean publishNotification(int staffNotificationId);

	public StaffCircularResultBean saveNotification(StaffCircularBean StaffCircularBean);

	public StaffCircularResultBean updateNotification(StaffCircularBean StaffCircularBean);

	public StaffCircularResultBean editNotification(int staffCircularId);

	public StaffCircularResultBean deleteNotification(int staffNotificationId);

	public StaffCircularResultBean saveAndPublishNotification(StaffCircularBean StaffCircularBean);

}
