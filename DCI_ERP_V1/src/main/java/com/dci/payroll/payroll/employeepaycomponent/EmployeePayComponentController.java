package com.dci.payroll.payroll.employeepaycomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.payroll.payroll.employeelop.EmployeeLopBean;
import com.dci.payroll.payroll.employeelop.EmployeeLopResultBean;



@RestController
@RequestMapping(value = "payroll/payroll/employeepaycom")
public class EmployeePayComponentController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeePayComponentController.class);

	@Autowired
	EmployeePayComponentService empPayComService;

	@RequestMapping(value = "/list")
	public @ResponseBody EmployeePayComponentResultBean getEmpPayComList(@RequestParam("employeeId") String employeeId) {

		EmployeePayComponentResultBean resultBean = new EmployeePayComponentResultBean();
		try {

			resultBean.setEmployeeComponentList(empPayComService.getEmployeePayComponentList(employeeId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/list1")
	public @ResponseBody EmployeePayComponentResultBean getEmpPayComList1() {

		EmployeePayComponentResultBean resultBean = new EmployeePayComponentResultBean();
		try {

			resultBean.setEmployeeComponentList(empPayComService.getEmployeePayComponentList1());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/list2")
	public @ResponseBody EmployeePayComponentResultBean getEmpPayComList2(@RequestParam("departmentId") String departmentId) {

		EmployeePayComponentResultBean resultBean = new EmployeePayComponentResultBean();
		try {

			resultBean.setEmployeeComponentList(empPayComService.getEmployeePayComponentList2(departmentId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/list3")
	public @ResponseBody EmployeePayComponentResultBean getEmpPayComList3(@RequestParam("employeeId") String employeeId) {

		EmployeePayComponentResultBean resultBean = new EmployeePayComponentResultBean();
		try {

			resultBean.setEmployeeComponentList(empPayComService.getEmployeePayComponentList3(employeeId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/getEmployeeMaxDate")
	public @ResponseBody EmployeePayComponentBean getEmployeeMaxDate(@RequestParam("employeeId") String employeeId) {
		EmployeePayComponentBean payComponentBean = new EmployeePayComponentBean();
		try {

			payComponentBean = empPayComService.getEmployeeMaxDate(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payComponentBean;
	}

	@RequestMapping(value = "/edit")
	public EmployeePayComponentResultBean getListByIdDate(@RequestBody EmployeePayComponentBean employeePayBean) {

		EmployeePayComponentResultBean resultBean = new EmployeePayComponentResultBean();
		try {
			// private static String fromDate = null;
			resultBean.setEmpPayComList(empPayComService.getListByIdDate(employeePayBean.getEmployeeId(), employeePayBean.getFromdate()));
			return resultBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody ArrayList<EmployeePayComponentBean> empPayComBean) {

		EmployeePayComponentResultBean empPayComResultBean = new EmployeePayComponentResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = empPayComService.insertEmployeePayComponent(empPayComBean);
		} catch (CustomException e) {
			empPayComResultBean.setSuccess(false);
			empPayComResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping(value = "/checkArrearDate")
	public EmployeePayComponentResultBean checkArrearDate(@RequestParam("arrearsStartDate") String arrearDate, @RequestParam("employeeId") String employeeId) {

		EmployeePayComponentResultBean resultBean = new EmployeePayComponentResultBean();
		try {

			resultBean = empPayComService.checkArrearDate(arrearDate, employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody ArrayList<EmployeePayComponentBean> empPayComBean) {
		EmployeePayComponentResultBean empPayComResultBean = new EmployeePayComponentResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = empPayComService.updateEmployeePayComponent(empPayComBean);
		} catch (CustomException e) {
			empPayComResultBean.setSuccess(false);
			empPayComResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody EmployeePayComponentBean employeePayBean) {
		boolean isDeleted = false;
		try {
			isDeleted = empPayComService.deleteEmployeePayComponenet(employeePayBean.getEmployeeId(), employeePayBean.getFromdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

	@RequestMapping("/uploadfile")
	public @ResponseBody EmployeePayComponentResultBean uploadFile(MultipartFile file) throws CustomException {
		EmployeePayComponentResultBean employeePayComponentBean = new EmployeePayComponentResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					employeePayComponentBean.setEmpPayComBean(empPayComService.uploadFile(file));
					employeePayComponentBean.setSuccess(true);
				} else {
					employeePayComponentBean.setSuccess(false);
				}

			} else {
				employeePayComponentBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeePayComponentBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody EmployeeLopResultBean exportExcelAverage(@RequestBody EmployeeLopBean lopBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		EmployeeLopResultBean employeeLopResultBean = new EmployeeLopResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc/Employee_LOP_File.xls");
			employeeLopResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return employeeLopResultBean;

	}

	@RequestMapping(value = "/exportSampleExcel")
	public @ResponseBody EmployeePayComponentResultBean exportSampleExcel(@RequestBody EmployeePayComponentBean employeePayComponentBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		EmployeePayComponentResultBean payComponentResultBean = new EmployeePayComponentResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/assets/docs/Sample_Employee_Salary_Upload_FileNew.xls");
			empPayComService.exportSampleExcel(employeePayComponentBean,  filePath);

			payComponentResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return payComponentResultBean;

	}

	@RequestMapping(value = "/payrollExport")
	public EmployeePayComponentResultBean getpayrollExport(@RequestBody List<Map<String, Object>> employeeComponentList) {
		EmployeePayComponentResultBean resultbean = new EmployeePayComponentResultBean();
		try {
			resultbean.setPayrollExport(empPayComService.getpayExport(employeeComponentList));
			resultbean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultbean;
	}
}