package com.dci.payroll.payroll.employeeTds;

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
import com.dci.payroll.payroll.employeelop.EmployeeLopController;


@RestController
@RequestMapping(value = "payroll/payroll/employeetds")
public class EmployeeTdsController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeLopController.class);

	@Autowired
	private EmployeeTdsService employeeTdsService;

	@RequestMapping(value = "/list")
	public EmployeeTdsResultBean getemployeeTdsList(@RequestBody EmployeeTdsBean empLopBean) {
		EmployeeTdsResultBean employeTdsResultBean = new EmployeeTdsResultBean();
		try {
			employeTdsResultBean.setEmptdsList(employeeTdsService.getEmployeeTdsList(empLopBean.getCompanyId(), empLopBean.getBranchId(), empLopBean.getDept(), empLopBean.getMonthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeTdsResultBean;
	}

	@RequestMapping(value = "/save")
	public EmployeeTdsBean save(@RequestBody ArrayList<EmployeeTdsBean> empLOPBean) {

		EmployeeTdsResultBean empLopResultBean = new EmployeeTdsResultBean();
		EmployeeTdsBean result = new EmployeeTdsBean();

		boolean isSuccess = false;
		try {
			result = employeeTdsService.insertEmployeeTdsList(empLOPBean);
		} catch (CustomException e) {
			empLopResultBean.setSuccess(false);
			empLopResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody EmployeeTdsResultBean uploadFile(MultipartFile file) throws CustomException {
		EmployeeTdsResultBean employeeTdsResultBean = new EmployeeTdsResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					employeeTdsResultBean.seteTdsBean(employeeTdsService.uploadFile(file));
					employeeTdsResultBean.setSuccess(true);
				} else {
					employeeTdsResultBean.setSuccess(false);
				}

			} else {
				employeeTdsResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeTdsResultBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody EmployeeTdsResultBean exportExcelAverage(@RequestBody EmployeeTdsBean taxSlabBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		EmployeeTdsResultBean tdsResultBean = new EmployeeTdsResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc/Employee_Tds_File.xls");
			employeeTdsService.exportExcel(taxSlabBean, ConfigurationProps.exportFilesPath);
			tdsResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return tdsResultBean;

	}

}