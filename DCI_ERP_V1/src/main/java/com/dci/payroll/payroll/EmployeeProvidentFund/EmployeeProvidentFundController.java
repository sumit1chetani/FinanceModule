package com.dci.payroll.payroll.EmployeeProvidentFund;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.payroll.tds.professionaltaxslab.ProfessionalTaxSlabController;


@RestController
@RequestMapping(value = "payroll/payroll/epf")
public class EmployeeProvidentFundController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ProfessionalTaxSlabController.class);

	@Autowired
	EmployeeProvidentFundService employeeProvidentFundService;

	@RequestMapping(value = "/list")
	public EmployeeProvidentFundResultBean getEPFList(@RequestBody EmployeeProvidentFundBean bean) {
		EmployeeProvidentFundResultBean employeeProvidentFundResultBean = new EmployeeProvidentFundResultBean();
		try {
			employeeProvidentFundResultBean = employeeProvidentFundService.getEPFList(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeProvidentFundResultBean;
	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody EmployeeProvidentFundResultBean exportExcelAverage(@RequestBody EmployeeProvidentFundBean ePFEmployeeProvidentFundBean, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		EmployeeProvidentFundResultBean providentFundResultBean = new EmployeeProvidentFundResultBean();

		try {

			String filePath = request.getServletContext().getRealPath("/tempdoc/Employee_Epf_File.xls");
			employeeProvidentFundService.exportExcel(ePFEmployeeProvidentFundBean,  ConfigurationProps.exportFilesPath);
			providentFundResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return providentFundResultBean;

	}

}