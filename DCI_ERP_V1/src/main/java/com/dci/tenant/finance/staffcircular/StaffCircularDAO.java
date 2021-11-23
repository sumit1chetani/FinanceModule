package com.dci.tenant.finance.staffcircular;


public interface StaffCircularDAO {

	public StaffCircularResultBean getNotification();

	public StaffCircularResultBean getDepartmentList();

	public StaffCircularResultBean getDesignationList();

	public StaffCircularResultBean getDivisionList();

	public StaffCircularResultBean getRepotingToList();

	public StaffCircularResultBean getGradeList();

	public StaffCircularResultBean publishNotification(int staffNotificationId);

	public StaffCircularResultBean saveNotification(StaffCircularBean staffNotificationBeanDetail);

	public StaffCircularResultBean updateNotification(StaffCircularBean staffNotificationBeanDetail);

	public StaffCircularResultBean editNotification(int staffCircularId);

	public StaffCircularResultBean deleteNotification(int staffNotificationId);

	public StaffCircularResultBean saveAndPublishNotification(StaffCircularBean staffNotificationBeanDetail);

	public StaffCircularResultBean UpdateAndPublishNotification(StaffCircularBean staffNotificationBeanDetail);

}
