package com.dci.payroll.tds.employeeTaxParameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payroll/tds/employeeTaxParameter")
public class EmployeeTaxParameterController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeTaxParameterController.class);

	@Autowired
	EmployeeTaxParameterService employeeTaxParameterService;

	@RequestMapping(value = "/list")
	public EmployeeTaxParameterResultBean getemployeeTaxParameterList(@RequestBody EmployeeTaxParameterBean empTaxParamBean) {
		EmployeeTaxParameterResultBean resultBean = new EmployeeTaxParameterResultBean();
		try {
			resultBean.setEmployeeTaxParameterList(employeeTaxParameterService.getEmployeeTaxParameterList(empTaxParamBean.getCompanyId(), empTaxParamBean.getBranchId(), empTaxParamBean.getDepartmentId(), empTaxParamBean.getEmployeeId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/edit")
	public EmployeeTaxParameterResultBean getEmpTaxParamByEmpId(@RequestBody String employeeId) {
		EmployeeTaxParameterResultBean empTaxParamResultBean = new EmployeeTaxParameterResultBean();
		try {
			empTaxParamResultBean.setEmployeeTaxParameter(employeeTaxParameterService.getEmpTaxParambyEmpId(employeeId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empTaxParamResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody EmployeeTaxParameterBean empTaxParamBean) {
		EmployeeTaxParameterResultBean empTaxParamResultBean = new EmployeeTaxParameterResultBean();

		boolean isSuccess = false;
		try {
			isSuccess = employeeTaxParameterService.insertEmpTaxParam(empTaxParamBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody EmployeeTaxParameterBean empTaxParamBean) {
		EmployeeTaxParameterResultBean empTaxParamResultBean = new EmployeeTaxParameterResultBean();

		boolean isSuccess = false;
		try {
			empTaxParamResultBean.setEmployeeTaxParameter(employeeTaxParameterService.getEmpTaxParambyEmpId(empTaxParamBean.getEmployeeId()));
			if (empTaxParamResultBean.getEmployeeTaxParameter() == null) {
				isSuccess = employeeTaxParameterService.insertEmpTaxParam(empTaxParamBean);
			} else {
				isSuccess = employeeTaxParameterService.updateEmpTaxParam(empTaxParamBean);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody String employeeId) {
		boolean isDeleted = false;
		try {
			isDeleted = employeeTaxParameterService.deleteEmpTaxParam(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}
}