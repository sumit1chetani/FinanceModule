package com.dci.payroll.payroll.arrears;

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

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/arrears")
public class ArrearsController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ArrearsController.class);

	@Autowired
	private ArrearsService arrearsService;

	@RequestMapping(value = "/list")
	public ArrearsResultBean getemployeeArrearList(@RequestBody ArrearsBean arrearsBean) {
		System.out.println("Coming inside ArrearsController List");
		ArrearsResultBean arrearsResultBean = new ArrearsResultBean();
		try {
			arrearsResultBean.setArrearsBeanList(arrearsService.getemployeeArrearList(arrearsBean.getCompanyId(), arrearsBean.getBranchId(), arrearsBean.getDepartmentId(), arrearsBean.getMonthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrearsResultBean;
	}

	@RequestMapping(value = "/insert")
	public boolean insert(@RequestBody ArrayList<ArrearsBean> arrearsBean) {
		System.out.println("Coming inside ArrearsController add");
		ArrearsResultBean arrearsResultBean = new ArrearsResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = arrearsService.insert(arrearsBean);
		} catch (CustomException e) {
			arrearsResultBean.setSuccess(false);
			arrearsResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping(value = "/savePayComponent")
	public boolean savePayComponent(@RequestBody ArrayList<ArrearsBean> arrearsBean) {

		ArrearsResultBean arrearsResultBean = new ArrearsResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = arrearsService.updatePayComponentList(arrearsBean);
		} catch (CustomException e) {
			arrearsResultBean.setSuccess(false);
			arrearsResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody ArrearsResultBean uploadFile(MultipartFile file) throws CustomException {
		ArrearsResultBean arrearsResultBean = new ArrearsResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					arrearsResultBean.setArrearsBean(arrearsService.uploadFile(file));
					arrearsResultBean.setSuccess(true);
				} else {
					arrearsResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				arrearsResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrearsResultBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody ArrearsResultBean exportExcelAverage(@RequestBody ArrearsBean arrearsBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		ArrearsResultBean chargesResultBean = new ArrearsResultBean();

		try {
			System.out.println("report=");
			String filePath = request.getServletContext().getRealPath("/tempdoc/Employee_Arrear_Salary_File.xls");
			arrearsService.exportExcel(arrearsBean, filePath);
			chargesResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return chargesResultBean;

	}
}
