package com.dci.tenant.finance.manualattendance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping(value = "{tenantid}/app/hr/attendance")

public class ManualAttendanceController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ManualAttendanceController.class);

	@Autowired
	private ManualAttendanceService manualAttendanceService;

	@RequestMapping(value = "/getDepartmentList")
	public ManualAttendanceResultBean getDepartmentList(@RequestBody String branchId) {
		ManualAttendanceResultBean manualAttendanceResultBean = new ManualAttendanceResultBean();
		try {
			manualAttendanceResultBean = manualAttendanceService.getDepartmentList(branchId);
			manualAttendanceResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manualAttendanceResultBean;
	}

	@RequestMapping(value = "/getShiftList")
	public ManualAttendanceResultBean getShiftList() {
		ManualAttendanceResultBean manualAttendanceResultBean = new ManualAttendanceResultBean();
		try {
			manualAttendanceResultBean = manualAttendanceService.getShiftList();
			manualAttendanceResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manualAttendanceResultBean;
	}

	@RequestMapping("/getEmpList")
	public ManualAttendanceResultBean getEmployeeList(@RequestBody ManualAttendance manualattend) throws CustomException {
		ManualAttendanceResultBean manualAttendanceResultBean = new ManualAttendanceResultBean();
		List employeeList = new ArrayList();
		try {
			manualAttendanceResultBean = manualAttendanceService.getEmployeeList(manualattend);

			if (manualAttendanceResultBean.getEmployeeList().size() > 0) {
				manualAttendanceResultBean.setSuccess(true);
			} else {
				manualAttendanceResultBean.setSuccess(false);
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return manualAttendanceResultBean;
	}

	@RequestMapping("/shiftTimeingValue")
	public @ResponseBody List getShiftTimingList(String shiftId) throws CustomException {
		List shiftTimingList = new ArrayList();
		try {
			shiftTimingList = manualAttendanceService.getShiftTimingList(shiftId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return shiftTimingList;
	}

	@RequestMapping("/list")
	public @ResponseBody ManualAttendanceResultBean getAttendanceList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		ManualAttendanceResultBean objManualAttendanceResultBean = new ManualAttendanceResultBean();
		if (offset < 5000) {
			try {
				objManualAttendanceResultBean.setAttendanceDataList(manualAttendanceService.getAttendanceList(limit, offset));
				objManualAttendanceResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objManualAttendanceResultBean;
	}

	@RequestMapping(value = "/save")
	public ManualAttendance save(@RequestBody ManualAttendance objAttendance) {

		ManualAttendance attendance = new ManualAttendance();
		try {

			attendance = manualAttendanceService.insertAttendance(objAttendance);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return attendance;

	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody Integer attendanceId) {
		boolean isDeleted = false;
		try {
			isDeleted = manualAttendanceService.deleteAttendance(attendanceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

	@RequestMapping(value = "/edit")
	public ManualAttendance getAttendanceById(@RequestBody Integer attendanceId) {

		try {
			return manualAttendanceService.getAttendanceById(attendanceId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	// Update ER
	@RequestMapping(value = "/update")
	public boolean updateAttendance(@RequestBody ManualAttendance objManualAttendance) throws CustomException {
		boolean isSuccess = false;
		ManualAttendanceResultBean objManualAttendanceResultBean = new ManualAttendanceResultBean();
		try {

			isSuccess = manualAttendanceService.updateAttendance(objManualAttendance);
			objManualAttendanceResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping(value = "/getUserDetail")
	public ManualAttendance getLoginUserDetails() throws CustomException, JsonParseException, JsonMappingException, IOException {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ManualAttendance manualAttendance = new ManualAttendance();
		try {

			manualAttendance.setLogInUser(user.getUserFullName());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return manualAttendance;

	}

	@RequestMapping(value = "/getMyAttendanceDetails")
	public ManualAttendanceResultBean getMyAttendanceDetails() {
		ManualAttendanceResultBean manualAttendanceResultBean = new ManualAttendanceResultBean();
		try {
			manualAttendanceResultBean = manualAttendanceService.getMyAttendanceDetails();
			manualAttendanceResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manualAttendanceResultBean;
	}

	@RequestMapping(value = "/saveMyAttendance")
	public boolean saveMyAttendance(@RequestBody ManualAttendance objAttendance) {
		ManualAttendanceResultBean manualAttendanceResultBean = new ManualAttendanceResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = manualAttendanceService.saveMyAttendance(objAttendance);

		} catch (CustomException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

}
