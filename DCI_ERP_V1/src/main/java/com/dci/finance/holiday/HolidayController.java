package com.dci.finance.holiday;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "{tenantid}/app/hr/holiday")

public class HolidayController {
	private final static Logger LOGGER = LoggerFactory.getLogger(HolidayController.class);
	@Autowired
	HolidayService holidayService;

	@RequestMapping(value = "list")
	public HolidayResultBean getHolidayList() {
		System.out.println("controller");
		HolidayResultBean holidayResultBean = new HolidayResultBean();
		try {
			holidayResultBean.setHolidayList(holidayService.getHolidayList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return holidayResultBean;

	}

	@RequestMapping(value = "getTotalHolidaylist")
	public HolidayResultBean getTotalHolidaylist() {
		System.out.println("controller");
		HolidayResultBean holidayResultBean = new HolidayResultBean();
		try {
			holidayResultBean.setHolidayList(holidayService.getTotalHolidaylist());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return holidayResultBean;

	}

	@RequestMapping(value = "/getBranchList")
	public @ResponseBody HolidayResultBean getboardList() {
		HolidayResultBean manageCourseResultBean = new HolidayResultBean();
		try {
			List<SelectivityBean> disciplineList = holidayService.getboardList();
			manageCourseResultBean.setBranchList(disciplineList);
			manageCourseResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageCourseResultBean;
	}
	
	
	@RequestMapping(value = "/getGradeList")
	public @ResponseBody HolidayResultBean getgradeList() {
		HolidayResultBean manageCourseResultBean = new HolidayResultBean();
		try {
			List<SelectivityBean> gradeList = holidayService.getgradeList();
			manageCourseResultBean.setBranchList(gradeList);
			manageCourseResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageCourseResultBean;
	}
	
	
	@RequestMapping(value = "/getempdept")
	public @ResponseBody List<HolidayBean> getCustomerListByVoyage(@RequestParam("departmentId") String departmentId) throws CustomException {
		List<HolidayBean> lCustomerList = new ArrayList<HolidayBean>();

		try {
			lCustomerList = holidayService.getCustomerListByVoyage(departmentId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lCustomerList;
	}
	
	

	@RequestMapping(value = "add")
	public boolean saveHoliday(@RequestBody HolidayBean holidaybean) {
		HolidayResultBean resultBean = new HolidayResultBean();
		boolean sucess = false;
		try {
			holidayService.saveHoliday(holidaybean);
			sucess = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sucess;

	}

	@RequestMapping(value = "getholidayList")
	public @ResponseBody HolidayBean getHolidayEditList(@RequestBody Integer holidayId) throws Exception {

		HolidayBean holidayBean = new HolidayBean();
		holidayBean = holidayService.getHolidayEditList(holidayId);

		return holidayBean;

	}

	@RequestMapping(value = "update")
	public @ResponseBody boolean updateHoliday(@RequestBody HolidayBean holidaybean) throws Exception {

		boolean isSucess = false;
		isSucess = holidayService.updateHoliday(holidaybean);

		return isSucess;

	}

	@RequestMapping(value = "delete")
	public @ResponseBody boolean deleteHoliday(@RequestBody Integer holidayId) throws Exception {
		boolean isSucess = false;
		isSucess = holidayService.deleteHoliday(holidayId);

		return isSucess;

	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody HolidayResultBean uploadFile(MultipartFile file) throws CustomException {
		HolidayResultBean holidayResultBean = new HolidayResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					holidayResultBean.setSuccess(holidayService.uploadFile(file));

				} else {
					holidayResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				holidayResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return holidayResultBean;
	}
	@RequestMapping("/branchlist")
	public List<SelectivityBean> branchlist() {

		List<SelectivityBean> branchList = new ArrayList<>();

		branchList = holidayService.getbranchList();

		return branchList;
	}
}
