package com.dci.payroll.payroll.electricalcharges;

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
import com.dci.payroll.payroll.employeelop.EmployeeLopController;


@RestController
@RequestMapping(value = "payroll/payroll/electricalCharges")
public class ElectricalChargesController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeLopController.class);

	@Autowired
	private ElectricalChargesService chargesService;

	@RequestMapping(value = "/list")
	public ElectricalChargesResultBean getemployeeEBList(@RequestBody ElectricalChargesBean electricalChargesBean) {
		ElectricalChargesResultBean chargesResultBean = new ElectricalChargesResultBean();
		try {
			chargesResultBean.setElectricalChargesList(chargesService.getemployeeEBList(electricalChargesBean.getCompanyId(), electricalChargesBean.getBranchId(), electricalChargesBean.getDepartmentId(), electricalChargesBean.getMonthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chargesResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody ArrayList<ElectricalChargesBean> chargesBeans) {

		ElectricalChargesResultBean chargesResultBean = new ElectricalChargesResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = chargesService.insertEmployeeEbList(chargesBeans);
		} catch (CustomException e) {
			chargesResultBean.setSuccess(false);
			chargesResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping(value = "/savePayComponent")
	public boolean savePayComponent(@RequestBody ArrayList<ElectricalChargesBean> chargesBeans) {

		ElectricalChargesResultBean chargesResultBean = new ElectricalChargesResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = chargesService.updatePayComponentList(chargesBeans);
		} catch (CustomException e) {
			chargesResultBean.setSuccess(false);
			chargesResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping(value = "/getChargeValue")
	public ElectricalChargesResultBean save(@RequestBody Integer units) {
		ElectricalChargesResultBean chargesResultBean = new ElectricalChargesResultBean();
		try {
			chargesResultBean.setChargesBean(chargesService.getChargeValue(units));
		} catch (CustomException e) {
			chargesResultBean.setSuccess(false);
			chargesResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chargesResultBean;

	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody ElectricalChargesResultBean uploadFile(MultipartFile file) throws CustomException {
		ElectricalChargesResultBean chargesResultBean = new ElectricalChargesResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					chargesResultBean.setChargesBean(chargesService.uploadFile(file));
					chargesResultBean.setSuccess(true);
				} else {
					chargesResultBean.setSuccess(false);
				}

			} else {
				chargesResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chargesResultBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody ElectricalChargesResultBean exportExcelAverage(@RequestBody ElectricalChargesBean chargesBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		ElectricalChargesResultBean chargesResultBean = new ElectricalChargesResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc/Employee_EB_Charge_File.xls");
			chargesService.exportExcel(chargesBean, filePath);
			chargesResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return chargesResultBean;

	}
}
