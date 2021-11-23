package com.dci.tenant.finance.staffnotification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "{tenantid}/app/hr/staffnotification")

public class StaffNotificationController {

	@Autowired
	StaffNotificationService staffNotificationService;

	@RequestMapping(value = "/getstaffnotification")
	public StaffNotificationResultBean getStaffNotificationList() {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.getNotification();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/savestaffnotification")
	public StaffNotificationResultBean saveNotification(@RequestBody StaffNotificationBeanDetail staffNotificationBeanDetail) {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.saveNotification(staffNotificationBeanDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/publishandsavestaffnotification")
	public StaffNotificationResultBean publishAndSaveStaffNotificationList(@RequestBody StaffNotificationBeanDetail staffNotificationBeanDetail) {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.saveAndPublishNotification(staffNotificationBeanDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/updateandpublishstaffnotification")
	public StaffNotificationResultBean updateAndSaveStaffNotificationList(@RequestBody StaffNotificationBeanDetail staffNotificationBeanDetail) {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.UpdateAndPublishNotification(staffNotificationBeanDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/updatestaffnotification")
	public StaffNotificationResultBean updateStaffNotificationList(@RequestBody StaffNotificationBeanDetail staffNotificationBeanDetail) {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.updateNotification(staffNotificationBeanDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/editstaffnotification")
	public StaffNotificationResultBean editStaffNotificationList(@RequestBody int staffNotificationId) {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.editNotification(staffNotificationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/deletestaffnotification")
	public StaffNotificationResultBean deleteStaffNotificationList(@RequestParam("staffNotificationId") int staffNotificationId) {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.deleteNotification(staffNotificationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/publishstaffnotification")
	public StaffNotificationResultBean publishStaffNotificationList(@RequestParam("staffNotificationId") int staffNotificationId) {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.publishNotification(staffNotificationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/publish")
	public StaffNotificationResultBean publishStaff(@RequestParam("staffNotificationId") int staffNotificationId) {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.publish(staffNotificationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/unpublish")
	public StaffNotificationResultBean unpublishStaff(@RequestParam("staffNotificationId") int staffNotificationId) {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.unpublish(staffNotificationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/departmentlist")
	public StaffNotificationResultBean departmentlist() {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.getDepartmentList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/divisionlist")
	public StaffNotificationResultBean divisionlist() {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.getDivisionList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/designationlist")
	public StaffNotificationResultBean designationlist() {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.getDesignationList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/gradelist")
	public StaffNotificationResultBean gradelist() {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.getGradeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}

	@RequestMapping(value = "/reportingTolist")
	public StaffNotificationResultBean reportingTolist() {
		StaffNotificationResultBean StaffNotificationResultBean = new StaffNotificationResultBean();
		try {
			StaffNotificationResultBean = staffNotificationService.getRepotingToList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffNotificationResultBean;

	}
}
