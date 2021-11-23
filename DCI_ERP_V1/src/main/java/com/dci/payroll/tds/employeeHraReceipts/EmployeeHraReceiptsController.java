package com.dci.payroll.tds.employeeHraReceipts;

import java.io.IOException;

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


@RestController
@RequestMapping(value = "payroll/tds/employeeHraReceipts")
public class EmployeeHraReceiptsController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeHraReceiptsController.class);

	@Autowired
	EmployeeHraReceiptsService employeeHraReceiptsService;

	@RequestMapping(value = "/list")
	public EmployeeHraReceiptsResultBean getemployeeHraReceiptsList() {
		EmployeeHraReceiptsResultBean resultBean = new EmployeeHraReceiptsResultBean();
		try {
			resultBean.setEmployeeHraReceiptsList(employeeHraReceiptsService.getEmployeeHraReceiptsList());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultBean;

	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody EmployeeHraReceiptsBean employeeHraReceiptsBean) {
		EmployeeHraReceiptsResultBean resultBean = new EmployeeHraReceiptsResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = employeeHraReceiptsService.insertEmployeeeHraReceipt(employeeHraReceiptsBean);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/edit")
	public EmployeeHraReceiptsBean getTaxSectionById(@RequestBody EmployeeHraReceiptsBean employeeHraReceiptsBean) {
		try {
			return employeeHraReceiptsService.getEmployeeHraReceipt(employeeHraReceiptsBean.getEmployeeId(), employeeHraReceiptsBean.getMonthYear());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody EmployeeHraReceiptsBean employeeHraReceiptsBean) {
		EmployeeHraReceiptsResultBean resultBean = new EmployeeHraReceiptsResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeHraReceiptsService.updateEmployeeeHraReceipt(employeeHraReceiptsBean);

		} catch (CustomException e) {
			resultBean.setSuccess(false);
			resultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/approveupdate")
	public boolean approveupdate(@RequestBody EmployeeHraReceiptsBean employeeHraReceiptsBean) {
		EmployeeHraReceiptsResultBean resultBean = new EmployeeHraReceiptsResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeHraReceiptsService.approveupdate(employeeHraReceiptsBean);

		} catch (CustomException e) {
			resultBean.setSuccess(false);
			resultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody EmployeeHraReceiptsBean employeeHraReceiptsBean) {
		boolean isDeleted = false;
		try {
			isDeleted = employeeHraReceiptsService.deleteEmployeeeHraReceipt(employeeHraReceiptsBean.getEmployeeId(), employeeHraReceiptsBean.getMonthYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

	@RequestMapping(value = "/uploadDocfile")
	public @ResponseBody EmployeeHraReceiptsResultBean uploadDocFile(MultipartFile file, @RequestParam("fileName") String fileName) throws IOException {

		EmployeeHraReceiptsResultBean employeeHraReceiptsResultBean = new EmployeeHraReceiptsResultBean();
		try {
			employeeHraReceiptsResultBean = employeeHraReceiptsService.uploadDocFile(file, fileName);
			employeeHraReceiptsResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeHraReceiptsResultBean;

	}

}