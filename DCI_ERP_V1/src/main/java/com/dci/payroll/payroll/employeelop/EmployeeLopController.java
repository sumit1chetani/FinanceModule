package com.dci.payroll.payroll.employeelop;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/employeelop")
public class EmployeeLopController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeLopController.class);

	@Autowired
	private EmployeeLopService empLopService;

	@RequestMapping(value = "/list")
	public EmployeeLopResultBean getemployeeLopList(@RequestBody EmployeeLopBean empLopBean) {
		EmployeeLopResultBean empLopResultBean = new EmployeeLopResultBean();
		try {
			empLopResultBean.setEmpLopList(empLopService.getEmployeeLopList(empLopBean.getCompanyId(), empLopBean.getBranchId(), empLopBean.getDept(), empLopBean.getMonthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empLopResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody ArrayList<EmployeeLopBean> empLOPBean) {

		EmployeeLopResultBean empLopResultBean = new EmployeeLopResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = empLopService.insertEmployeeLopList(empLOPBean);
		} catch (CustomException e) {
			empLopResultBean.setSuccess(false);
			empLopResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody EmployeeLopResultBean uploadFile(MultipartFile file) throws CustomException {
		EmployeeLopResultBean employeeLopResultBean = new EmployeeLopResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					employeeLopResultBean.setEmpLopBean(empLopService.uploadFile(file));
					employeeLopResultBean.setSuccess(true);
				} else {
					employeeLopResultBean.setSuccess(false);
				}

			} else {
				employeeLopResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeLopResultBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody EmployeeLopResultBean exportExcelAverage(@RequestBody EmployeeLopBean lopBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		EmployeeLopResultBean employeeLopResultBean = new EmployeeLopResultBean();

		try {
			String filePath = request.getServletContext().getRealPath(ConfigurationProps.exportFilesPath);
			empLopService.exportExcel(lopBean, filePath);
			employeeLopResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return employeeLopResultBean;

	}
}