package com.dci.finance.hrmanageAttendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dci.tenant.user.UserDetail;




@RestController
@RequestMapping(value = "{tenantid}/app/hr/hrmanageattendance")

public class HrManageAttendanceController {

	@Autowired
	private HrManageAttendanceService HrManageAttendanceService;

	/*@Autowired
	CmsCommonUtilityService hrmsCommonUtilityService;
*/
	@RequestMapping(value = "/getAcademicYear")
	public HrManageAttendanceResultBean getAcademicYearList() {
		HrManageAttendanceResultBean manageAttendanceResultBean = new HrManageAttendanceResultBean();

		try {
			manageAttendanceResultBean = HrManageAttendanceService.getAcademicYearList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

	@RequestMapping(value = "/getHrManageAttendance")
	public HrManageAttendanceResultBean getManageAttendance() {
		HrManageAttendanceResultBean manageAttendanceResultBean = new HrManageAttendanceResultBean();

		try {
			manageAttendanceResultBean = HrManageAttendanceService.getHrManageAttendance();
			manageAttendanceResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

	@RequestMapping(value = "/getDepartmentName")
	public HrManageAttendanceResultBean getDepartmentName() {
		HrManageAttendanceResultBean manageAttendanceResultBean = new HrManageAttendanceResultBean();

		try {
			manageAttendanceResultBean = HrManageAttendanceService.getDepartmentName();
			manageAttendanceResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

	@RequestMapping(value = "/getFirstName")
	public HrManageAttendanceResultBean getFirstName() {
		HrManageAttendanceResultBean manageAttendanceResultBean = new HrManageAttendanceResultBean();

		try {
			manageAttendanceResultBean = HrManageAttendanceService.getFirstName();
			manageAttendanceResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

	@RequestMapping(value = "/getEmployeeList1")
	public HrManageAttendanceResultBean getEmployeeList1(@RequestBody HrManageAttendanceBean objBean) {
		HrManageAttendanceResultBean manageAttendanceResultBean = new HrManageAttendanceResultBean();

		try {
			manageAttendanceResultBean = HrManageAttendanceService.getEmployeeList1(objBean);
			manageAttendanceResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

	@RequestMapping(value = "/getEmployeeList")
	public HrManageAttendanceResultBean getEmployeeList(@RequestBody HrManageAttendanceBean departmentId) {
		HrManageAttendanceResultBean manageAttendanceResultBean = new HrManageAttendanceResultBean();

		try {
			manageAttendanceResultBean.setEmployeeList(HrManageAttendanceService.getEmployeeList(departmentId.getDepartmentId()));
			manageAttendanceResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

	@RequestMapping(value = "/edit")
	public HrManageAttendanceBean editManageAttendance(@RequestParam("departmentId") String departmentId, @RequestParam("attendanceDate") String attendanceDate) {
		HrManageAttendanceBean manageAttendanceResultBean = new HrManageAttendanceBean();

		try {
			manageAttendanceResultBean = HrManageAttendanceService.editHrManageAttendance(departmentId, attendanceDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

	@RequestMapping(value = "/saveHrManageAttendance")
	public HrManageAttendanceResultBean saveHrManageAttendance(@RequestBody HrManageAttendanceBean objBean) {
		HrManageAttendanceResultBean manageAttendanceResultBean = new HrManageAttendanceResultBean();

		try {

			manageAttendanceResultBean = HrManageAttendanceService.saveHrManageAttendance(objBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

	@RequestMapping(value = "/updateHrManageAttendance")
	public HrManageAttendanceResultBean updateManageAttendance(@RequestBody HrManageAttendanceBean objBean) {
		HrManageAttendanceResultBean manageAttendanceResultBean = new HrManageAttendanceResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			objBean.setCreatedBy(userDetails.getUserId());
			manageAttendanceResultBean = HrManageAttendanceService.updateHrManageAttendance(objBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

	@RequestMapping(value = "/deleteHrManageattendance")
	public HrManageAttendanceResultBean deleteManageAttendance(@RequestParam("attendanceId") int attendanceId) {
		HrManageAttendanceResultBean manageAttendanceResultBean = new HrManageAttendanceResultBean();
		try {
			manageAttendanceResultBean = HrManageAttendanceService.deleteHrManageAttendance(attendanceId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageAttendanceResultBean;
	}

}
