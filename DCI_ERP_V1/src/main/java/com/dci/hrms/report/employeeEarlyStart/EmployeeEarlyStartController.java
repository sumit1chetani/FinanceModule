package com.dci.hrms.report.employeeEarlyStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "hrms/report/employeeEarlyReport")
public class EmployeeEarlyStartController {

	@Autowired
	public EmployeeEarlyStartService employeeEarlyStartService;

	@RequestMapping(value = "/hospitalList")
	public @ResponseBody EmployeeEarlyStartResultBean getHospitalList(@RequestBody String formCode) {
		EmployeeEarlyStartResultBean hospitalList = new EmployeeEarlyStartResultBean();
		try {
			hospitalList = employeeEarlyStartService.getHospitalList(formCode);
			hospitalList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospitalList;
	}

	@RequestMapping(value = "/getEarlyStartList")
	public EmployeeEarlyStartResultBean getEarlyStartList(@RequestBody EmployeeEarlyStartBean employeeEarlyStartBean) {
		EmployeeEarlyStartResultBean employeeEarlyStartList = new EmployeeEarlyStartResultBean();
		try {
			employeeEarlyStartList.setEarlyStartList(employeeEarlyStartService.getEarlyStartList(employeeEarlyStartBean));
			employeeEarlyStartList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeEarlyStartList;
	}

	@RequestMapping(value = "/getEarlyLateList")
	public EmployeeEarlyStartResultBean getEarlyLateList(@RequestBody EmployeeEarlyStartBean employeeEarlyStartBean) {
		EmployeeEarlyStartResultBean employeeEarlyLateList = new EmployeeEarlyStartResultBean();
		try {
			employeeEarlyLateList.setLateList(employeeEarlyStartService.getEarlyLateList(employeeEarlyStartBean));
			employeeEarlyLateList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeEarlyLateList;
	}

	@RequestMapping(value = "/getHabitualLateList")
	public EmployeeEarlyStartResultBean getHabitualLate(@RequestBody EmployeeEarlyStartBean employeeEarlyStartBean) {
		EmployeeEarlyStartResultBean employeeEarlyLateList = new EmployeeEarlyStartResultBean();
		try {
			employeeEarlyLateList.setHabitualLateList(employeeEarlyStartService.getHabitualLate(employeeEarlyStartBean));
			employeeEarlyLateList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeEarlyLateList;
	}

	@RequestMapping(value = "/getEmployeeList")
	public EmployeeEarlyStartResultBean getEmployeeList(@RequestBody String branchId) {
		EmployeeEarlyStartResultBean employeeList = new EmployeeEarlyStartResultBean();
		try {
			employeeList = employeeEarlyStartService.getEmployeeList(branchId);
			employeeList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@RequestMapping(value = "/getDivisionList")
	public EmployeeEarlyStartResultBean getDivisionList(@RequestBody String companyId) {
		EmployeeEarlyStartResultBean employeeList = new EmployeeEarlyStartResultBean();
		try {
			employeeList = employeeEarlyStartService.getDivisionList(companyId);
			employeeList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@RequestMapping(value = "/getEmployeeListDiv")
	public EmployeeEarlyStartResultBean getEmployeeListDiv(@RequestBody String divisionId) {
		EmployeeEarlyStartResultBean employeeList = new EmployeeEarlyStartResultBean();
		try {
			employeeList = employeeEarlyStartService.getEmployeeListDiv(divisionId);
			employeeList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@RequestMapping(value = "/getEmpDetailList")
	public EmployeeEarlyStartResultBean getEmpDetailList(@RequestBody EmployeeEarlyStartBean employeeEarlyStartBean) {
		EmployeeEarlyStartResultBean employeeEarlyStartList = new EmployeeEarlyStartResultBean();
		try {
			employeeEarlyStartList.setEmpDetailList(employeeEarlyStartService.getEmpDetailList(employeeEarlyStartBean));
			employeeEarlyStartList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeEarlyStartList;
	}

	@RequestMapping(value = "/getLeaveType")
	public EmployeeEarlyStartResultBean getLeaveList(@RequestBody String empId) throws Exception {
		EmployeeEarlyStartResultBean resultBean = new EmployeeEarlyStartResultBean();
		try {
			resultBean = employeeEarlyStartService.getLeaveList(empId);
			resultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/leaveDetails")
	public EmployeeEarlyStartResultBean getLeaveDetails(@RequestParam("leaveType") String LeaveType, @RequestParam("empId") String empId) {
		EmployeeEarlyStartResultBean leaveDetailBean = new EmployeeEarlyStartResultBean();
		try {
			leaveDetailBean.setLeaveDetails(employeeEarlyStartService.getLeaveDetails(LeaveType, empId));
			leaveDetailBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return leaveDetailBean;
	}

}
