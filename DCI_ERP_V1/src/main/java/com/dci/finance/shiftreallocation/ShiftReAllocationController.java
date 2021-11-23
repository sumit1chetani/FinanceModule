package com.dci.finance.shiftreallocation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "{tenantid}/app/hr/shiftreallocation")

public class ShiftReAllocationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ShiftReAllocationController.class);

	@Autowired
	private ShiftReAllocationService shiftReAllocationService;

	@RequestMapping(value = "/list")
	public ShiftReAllocationResultBean getShiftReAllocationList() {
		ShiftReAllocationResultBean shiftReAllocationBean = new ShiftReAllocationResultBean();
		try {

			shiftReAllocationBean.setShiftReAllocationList(shiftReAllocationService.getShiftReAllocationList());
			shiftReAllocationBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return shiftReAllocationBean;
	}

	@RequestMapping(value = "/getDesignationList")
	public ShiftReAllocationResultBean getDesignationList(@RequestBody String empId) {
		ShiftReAllocationResultBean objshiftReAllocationResultBean = new ShiftReAllocationResultBean();
		try {
			objshiftReAllocationResultBean = shiftReAllocationService.getDesignationList(empId);
			objshiftReAllocationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objshiftReAllocationResultBean;
	}

	@RequestMapping(value = "/getShiftNameList")
	public ShiftReAllocationResultBean getShiftNameList() {
		ShiftReAllocationResultBean objshiftReAllocationResultBean = new ShiftReAllocationResultBean();
		try {
			objshiftReAllocationResultBean = shiftReAllocationService.getShiftNameList();
			objshiftReAllocationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objshiftReAllocationResultBean;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody ShiftReAllocationResultBean addShiftReAllocation(@RequestBody ShiftReAllocationBean objShiftReAllocationBean) throws CustomException {
		boolean isSuccess = false;
		ShiftReAllocationResultBean objShiftReAllocationResultBean = new ShiftReAllocationResultBean();
		try {

			isSuccess = shiftReAllocationService.addShiftReAllocation(objShiftReAllocationBean);
			objShiftReAllocationResultBean.setSuccess(isSuccess);

		} catch (CustomException e) {
			objShiftReAllocationResultBean.setSuccess(false);
			objShiftReAllocationResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
		}

		return objShiftReAllocationResultBean;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ShiftReAllocationResultBean updateShiftReAllocation(@RequestBody ShiftReAllocationBean objShiftReAllocationBean) throws CustomException {
		boolean isSuccess = false;
		ShiftReAllocationResultBean objShiftReAllocationResultBean = new ShiftReAllocationResultBean();
		try {

			isSuccess = shiftReAllocationService.updateShiftReAllocation(objShiftReAllocationBean);
			objShiftReAllocationResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return objShiftReAllocationResultBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteShiftReAllocation(@RequestParam("shiftCode") String shiftCode, @RequestParam("employeeId") String employeeId) throws Exception {
		boolean isDeleted = false;
		isDeleted = shiftReAllocationService.deleteShiftReAllocation(shiftCode, employeeId);
		return isDeleted;
	}

	@RequestMapping("/getShiftReAllocationEditList")
	public @ResponseBody ShiftReAllocationBean getShiftReAllocationEditList(@RequestParam("employeeId") String employeeId, @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) throws Exception {
		ShiftReAllocationBean objShiftReAllocationBean = new ShiftReAllocationBean();
		objShiftReAllocationBean = shiftReAllocationService.getShiftReAllocationEditList(employeeId, fromDate, toDate);
		return objShiftReAllocationBean;
	}

	@RequestMapping(value = "/getShiftList")
	public ShiftReAllocationResultBean getShiftList() {
		ShiftReAllocationResultBean shiftReAllocationResultBean = new ShiftReAllocationResultBean();
		try {
			shiftReAllocationResultBean = shiftReAllocationService.getShiftList();
			shiftReAllocationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shiftReAllocationResultBean;
	}
	
	@RequestMapping(value="/branchList")
	public List<ShiftReAllocationBean> getDropdown() {
		System.out.println("Get all Country...");

		List<ShiftReAllocationBean> portformlist = new ArrayList<>();

		portformlist = shiftReAllocationService.getDropdown();

		return portformlist;
	}
      
	

	@RequestMapping(value="/companyList")
	public List<ShiftReAllocationBean> companyList() {
		System.out.println("Get all Country...");

		List<ShiftReAllocationBean> portformlist = new ArrayList<>();

		portformlist = shiftReAllocationService.companyList();

		return portformlist;
	}
      
	
	
	@RequestMapping(value="/shiftNameList")
	public List<ShiftReAllocationBean> shiftNameList() {
		System.out.println("Get all Country...");

		List<ShiftReAllocationBean> portformlist = new ArrayList<>();

		portformlist = shiftReAllocationService.shiftNameList();

		return portformlist;
	}
}