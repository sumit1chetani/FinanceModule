package com.dci.tenant.finance.staffcircular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "{tenantid}/app/hr/staffcircular")

public class StaffCircularController {

	@Autowired
	StaffCircularService StaffCircularService;

	@RequestMapping(value = "/getstaffnotification")
	public StaffCircularResultBean getStaffNotificationList() {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.getNotification();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/savestaffnotification")
	public StaffCircularResultBean saveStaffNotificationList(@RequestBody StaffCircularBean StaffCircularBean) {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.saveNotification(StaffCircularBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/publishandsavestaffnotification")
	public StaffCircularResultBean publishAndSaveStaffNotificationList(@RequestBody StaffCircularBean StaffCircularBean) {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.saveAndPublishNotification(StaffCircularBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/updateandpublishstaffnotification")
	public StaffCircularResultBean updateAndSaveStaffNotificationList(@RequestBody StaffCircularBean StaffCircularBean) {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.UpdateAndPublishNotification(StaffCircularBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/updatestaffnotification")
	public StaffCircularResultBean updateStaffNotificationList(@RequestBody StaffCircularBean StaffCircularBean) {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.updateNotification(StaffCircularBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/editstaffnotification")
	public @ResponseBody StaffCircularResultBean editStaffNotificationList(@RequestBody Integer staffCircularId) {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.editNotification(staffCircularId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/deletestaffnotification")
	public StaffCircularResultBean deleteStaffNotificationList(@RequestParam("staffNotificationId") int staffNotificationId) {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.deleteNotification(staffNotificationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/publishstaffnotification")
	public StaffCircularResultBean publishStaffNotificationList(@RequestParam("staffNotificationId") int staffNotificationId) {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.publishNotification(staffNotificationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/departmentlist")
	public StaffCircularResultBean departmentlist() {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.getDepartmentList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/divisionlist")
	public StaffCircularResultBean divisionlist() {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.getDivisionList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/designationlist")
	public StaffCircularResultBean designationlist() {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.getDesignationList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/gradelist")
	public StaffCircularResultBean gradelist() {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.getGradeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}

	@RequestMapping(value = "/reportingTolist")
	public StaffCircularResultBean reportingTolist() {
		StaffCircularResultBean StaffCircularResultBean = new StaffCircularResultBean();
		try {
			StaffCircularResultBean = StaffCircularService.getRepotingToList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StaffCircularResultBean;

	}
}
