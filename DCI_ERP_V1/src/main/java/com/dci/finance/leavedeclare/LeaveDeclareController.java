package com.dci.finance.leavedeclare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "{tenantid}/finance/leave")
public class LeaveDeclareController {
	private final static Logger LOGGER = LoggerFactory.getLogger(LeaveDeclareController.class);
	@Autowired
	LeaveDeclareService leaveDeclareService;

	@RequestMapping(value = "/leavelist")
	public LeaveDeclareResultBean getLeaveList() {
		// System.out.println("controlllllerrrrrr");
		// System.out.println("controlllllerrrrrr");
		LeaveDeclareResultBean leaveResult = new LeaveDeclareResultBean();
		try {
			leaveResult.setLeaveDeclareList(leaveDeclareService.getLeaveList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return leaveResult;
	}

	@RequestMapping(value = "gradeList")
	public LeaveDeclareResultBean getgradeList(@RequestBody String companyId) {
		System.out.println("gradeLIsttttt");
		LeaveDeclareResultBean resultBean = new LeaveDeclareResultBean();
		try {

			resultBean = leaveDeclareService.getGradeList(companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;

	}

	@RequestMapping(value = "year")
	public LeaveDeclareResultBean getYearList() {
		// System.out.println("yearrrrr");
		LeaveDeclareResultBean resultBean = new LeaveDeclareResultBean();
		try {

			resultBean = leaveDeclareService.getYearList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;

	}

	@RequestMapping(value = "getType")
	public @ResponseBody LeaveDeclareResultBean getLeaveType(  @RequestParam("branchId") String branchId ,@RequestParam("yearId") int yearId) {
		System.out.println("leaveRYppeeee");
		LeaveDeclareResultBean resultBean = new LeaveDeclareResultBean();

		try {

			resultBean = leaveDeclareService.getLeaveType( branchId,yearId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;

	}

	@RequestMapping(value = "add")
	public boolean saveHoliday(@RequestBody LeaveDeclareResultBean leaveBean) {
		LeaveDeclareResultBean leavebean = new LeaveDeclareResultBean();
		try {
			leaveDeclareService.saveLeaveDetails(leaveBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}

	@RequestMapping(value = "getEditList")
	public @ResponseBody LeaveDeclareResultBean getEditList(@RequestParam("branch") String branch, @RequestParam("year") int year) throws Exception {
		System.out.println("gettEditListtt");

		LeaveDeclareResultBean resultBean = new LeaveDeclareResultBean();
		resultBean = leaveDeclareService.getEditList(branch, year);

		return resultBean;

	}

	@RequestMapping(value = "delete")
	public @ResponseBody boolean deleteLeave(@RequestParam("gradeId") int gradeId, @RequestParam("year") int year) throws Exception {

		boolean isSucess = false;
		isSucess = leaveDeclareService.deleteLeave(gradeId, year);

		return isSucess;

	}

}
