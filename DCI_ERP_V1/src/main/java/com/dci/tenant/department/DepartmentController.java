package com.dci.tenant.department;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller

@RequestMapping(value = "{tenantid}/app/department")
public class DepartmentController {

	private final static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	// Save Method

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean addDepartment(@RequestBody DepartmentBean objDepartmentBean) throws CustomException {
		boolean isSuccess = false;
		DepartmentResultBean objDepartmentResultBean = new DepartmentResultBean();
		try {

			isSuccess = departmentService.addDepartment(objDepartmentBean);
			System.out.println("Result" + isSuccess);
			objDepartmentResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/edit")
	public @ResponseBody DepartmentBean editdepartmentValues(@RequestBody String deptCode) throws CustomException {
		DepartmentBean deptList = new DepartmentBean();
		try {
			deptList = departmentService.getdepartmentValues(deptCode);
			deptList.setIsEdit(true);
		} catch (Exception e) {
			deptList.setIsEdit(false);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return deptList;
	}

	// Employee Drop Down

	@RequestMapping("/getEmployee")
	public @ResponseBody DepartmentResultBean getEmployee() throws CustomException {
		DepartmentResultBean objBean = null;
		try {
			objBean = departmentService.getEmployee();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objBean;
	}

	@RequestMapping("/getDepartment")
	public @ResponseBody List getDepartment() throws CustomException {
		List sDepartment = new ArrayList();
		try {
			sDepartment = departmentService.getDepartment();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sDepartment;
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody boolean deleteDepartment(@RequestParam("deptCode") String dCode) throws CustomException {
		boolean isDeleted = false;
		try {
			isDeleted = departmentService.deleteDepartment(dCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isDeleted;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateDepartment(@RequestBody DepartmentBean objDepartmentBean) throws CustomException {
		boolean isSuccess = false;
		DepartmentResultBean objDepartmentResultBean = new DepartmentResultBean();
		try {

			isSuccess = departmentService.updateDepartment(objDepartmentBean);
			objDepartmentResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	// Getting List

	@RequestMapping("/list")
	public @ResponseBody DepartmentResultBean getDepartmentList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		DepartmentResultBean objDepartmentResultBean = new DepartmentResultBean();

		if (offset < 5000) {
			try {
				objDepartmentResultBean.setlDepartmentBean(departmentService.getDepartmentList(limit, offset));
				objDepartmentResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objDepartmentResultBean;
	}
}
