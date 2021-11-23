package com.dci.payroll.payroll.payrollgeneration;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.payroll.payroll.payrollreport.PayrollReportBean;
import com.dci.payroll.payroll.payrollreport.PayrollReportService;
import com.dci.payroll.payroll.payslip.PaySlipBean;
import com.dci.tenant.user.UserDetail;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping(value = "payroll/payroll/payrollgeneration")
public class PayrollGenerationController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PayrollGenerationController.class);
	@Autowired
	private PayrollGenerationService payrollGenerateService;

	@Autowired
	private PayrollReportService payrollReportService;

	@RequestMapping(value = "/generate")
	public PayrollGenerationResultBean generatePayroll(@RequestBody PaySlipBean resultBean) {
		PayrollGenerationResultBean payrollResultBean = new PayrollGenerationResultBean();
		PayrollGenerationResultBean payrollResultBean2 = new PayrollGenerationResultBean();
		PayrollGenerationBean beanbean = new PayrollGenerationBean();
		try {

			payrollResultBean.setSalaryCreated(false);
			payrollResultBean.setSalaryExists(false);
			payrollResultBean.setWithHoldList(false);
			// List<PayrollGenerationBean> checkPayrollFlag =
			// payrollGenerateService.checkPayrollFlag();

			// PayrollGenerationResultBean checkCountFlag =
			// payrollGenerateService.checkFlag(resultBean.getDepartmentId(),
			// resultBean.getEmployeeId());

			List<PayrollGenerationBean> checksalaryCreatedList = payrollGenerateService.checkSalaryCreated(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getEmployeeId(), resultBean.getMonthYear());
			// Salary Created or not
			if (checksalaryCreatedList.size() == 0) {
				// Salary generated
				payrollResultBean.setSalaryExists(true);
				payrollResultBean.setSalaryList(payrollGenerateService.getEmployeeSalaryList(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getEmployeeId(), resultBean.getMonthYear()));
			} else {
				// exist payroll created list - payroll generation........
				payrollResultBean.setSalaryExists(true);
				payrollResultBean.setSalaryList(payrollGenerateService.getEmployeeSalaryList(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getEmployeeId(), resultBean.getMonthYear()));

				List<PayrollGenerationBean> salaryNotFixedList = payrollGenerateService.checkSalaryFixed(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getEmployeeId(), resultBean.getMonthYear());
				List<PayrollGenerationBean> salaryNotFixedList1 = payrollGenerateService.pendingSalaryList(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getEmployeeId(), resultBean.getMonthYear());

				// if (salaryNotFixedList.size() == 0) {
				if (salaryNotFixedList1.size() != 0) {
					for (int i = 0; i < salaryNotFixedList1.size(); i++) {
						beanbean = payrollGenerateService.generatePayroll(resultBean.getCompanyId(), resultBean.getBranchId(), salaryNotFixedList1.get(i).getDept(), salaryNotFixedList1.get(i).getEmployeeId(), resultBean.getMonthYear());
						// deduct professional TAx
						String monthYearTest = resultBean.getMonthYear();
						String demo = monthYearTest.substring(0, 2);
						if (demo.equals("03")) {
							payrollResultBean2 = payrollGenerateService.taxDeduction(resultBean.getCompanyId(), resultBean.getBranchId(), salaryNotFixedList1.get(i).getDept(), salaryNotFixedList1.get(i).getEmployeeId(), resultBean.getMonthYear());
							// Check Pay component Created
						} else if (demo.equals("09")) {
							payrollResultBean2 = payrollGenerateService.taxDeduction(resultBean.getCompanyId(), resultBean.getBranchId(), salaryNotFixedList1.get(i).getDept(), salaryNotFixedList1.get(i).getEmployeeId(), resultBean.getMonthYear());
							// Check Pay component Created
						}

						payrollResultBean = payrollGenerateService.withHoldList(salaryNotFixedList1.get(i).getEmployeeId(), resultBean.getMonthYear());

						// payrollResultBean =
						// payrollGenerateService.getcheckFlag(resultBean.getEmployeeId());
						// payrollResultBean.setSalaryCreated(true);
					}
				} else {
					payrollResultBean.setPayrollList(payrollGenerateService.checkSalaryFixed(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getEmployeeId(), resultBean.getMonthYear()));
					payrollResultBean.setSalaryNotCreatedOthers(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollResultBean;
	}

	@RequestMapping(value = "/getFlagList")
	public PayrollGenerationResultBean getFlagList(@RequestParam("departmentId") int departmentId, @RequestParam("monthYear") String monthYear, @RequestParam("employeeId") String employeeId) {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean = payrollGenerateService.getFlagList(departmentId, monthYear, employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;

	}

	@RequestMapping(value = "/checkAlreadyGenerated")
	public PayrollGenerationResultBean getAlreadyGenerated(@RequestParam("employeeId") String employeeId, @RequestParam("startDate") String startDate) {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean = payrollGenerateService.getAlreadyGenerated(employeeId, startDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;

	}

	@RequestMapping(value = "/salarylist")
	public PayrollGenerationResultBean checkSalaryCreated(@RequestBody PayrollGenerationBean resultBean) {
		PayrollGenerationResultBean payrollResultBean = new PayrollGenerationResultBean();
		try {
			payrollResultBean.setPayrollList(payrollGenerateService.getEmployeeSalaryList(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getEmployeeId(), resultBean.getMonthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollResultBean;
	}

	@RequestMapping(value = "/payrolllistbyid")
	public PayrollGenerationResultBean getPayRollListById(@RequestBody PayrollReportBean resultBean) {
		PayrollGenerationResultBean payrollResultBean = new PayrollGenerationResultBean();
		try {
			payrollResultBean.setPayRollListByEmpId(payrollGenerateService.getPayrollList(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDepartmentId(), resultBean.getEmployeeId(), resultBean.getMonthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollResultBean;
	}

	@RequestMapping(value = "degenerate")
	public PayrollGenerationResultBean payrollDegenerate(@RequestBody PayrollGenerationBean resultBean) {
		PayrollGenerationResultBean payrollResultBean = new PayrollGenerationResultBean();
		try {
			boolean isdeleted = false;
			payrollResultBean.setSalaryCreated(false);
			isdeleted = payrollGenerateService.deleteSalaryList(resultBean.getCompanyId(), resultBean.getBranchId(), resultBean.getDept(), resultBean.getEmployeeId(), resultBean.getMonthYear());
			payrollResultBean.setSuccess(isdeleted);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollResultBean;
	}

	// Function to get Login User details

	@RequestMapping(value = "/getUserDetail")
	public PayrollGenerationBean getLoginUserDetails() throws CustomException, JsonParseException, JsonMappingException, IOException {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PayrollGenerationBean generationBean = new PayrollGenerationBean();
		try {
			generationBean.setBranchId(user.getBranchId());
			generationBean.setCompanyId(user.getCompanyCode());
			generationBean.setBranchName(user.getBranchName());
			generationBean.setCompanyName(user.getCompanyName());
			generationBean.setLoginUserEmpId(user.getUserId());
			//generationBean.setDesignationId(user.getDesignationId());
			generationBean.setDepartmentName(user.getDesignationName());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return generationBean;

	}

	@RequestMapping(value = "/getDepartmentList")
	public  @ResponseBody PayrollGenerationResultBean getDepartmentList(@RequestBody String branchId) {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean.setDepartmentList(payrollGenerateService.getDepartmentList(branchId));
			objPayrollGenerationResultBean.setEmployeeList(payrollGenerateService.getEmployeeList(branchId));
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/getTypeList")
	public PayrollGenerationResultBean getTypeList() {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean.setTypeList(payrollGenerateService.getTypeList());
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/DepartmentList")
	public PayrollGenerationResultBean getDepartmentList1() {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean = payrollGenerateService.getDepartmentList1();
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/getCompanyList")
	public PayrollGenerationResultBean getCompanyList() {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean.setCompanyList(payrollGenerateService.getCompanyList());
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/getEmployeeList")
	public PayrollGenerationResultBean getEmployeeList(@RequestBody PayrollReportBean resultBean) {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean.setEmployeeList(payrollGenerateService.getEmployeeList(resultBean.getDept(), resultBean.getBranchId()));
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/getEmployees")
	public PayrollGenerationResultBean getEmployees() {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean.setEmployeeList(payrollGenerateService.getEmployees());
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/getBranchList")
	public @ResponseBody PayrollGenerationResultBean getBranchList(@RequestBody String companyId) {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean.setBranchList(payrollGenerateService.getBranchList(companyId));
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/getMonthYearList")
	public PayrollGenerationResultBean getMonthYearList() {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean.setMonthYearList(payrollGenerateService.getMonthYearList());
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	@RequestMapping(value = "/getPaySlipYearList")
	public PayrollGenerationResultBean getPaySlipYearList() {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			objPayrollGenerationResultBean.setPaySlipYearList(payrollGenerateService.getPaySlipYearList());
			objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}

	/*
	 * @RequestMapping(value = "/checkFlag") public PayrollGenerationResultBean
	 * getcheckFlag(@RequestParam("employeeId") String employeeId) {
	 * PayrollGenerationResultBean resultBean = new PayrollGenerationResultBean();
	 * try {
	 * 
	 * resultBean = payrollGenerateService.getcheckFlag(employeeId);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return resultBean;
	 * 
	 * }
	 */
	@RequestMapping(value = "/payrolltojv")
	public @ResponseBody PayrollGenerationResultBean saveLeaveData(@RequestBody PaySlipBean resultBean) throws Exception {

		// public PayrollGenerationResultBean payrolltojv(@RequestBody PaySlipBean
		// resultBean) {
		// LeaveRequestBean leaveRequestBean = new LeaveRequestBean();

		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		// payrollResultBean payrollResultBean = new
		try {
			boolean sucess = false;
			// payrollGenerateService.payrolltojv(resultBean);
			// payrollGenerateService.payrolltojv(resultBean);

			sucess = payrollGenerateService.payrolltojv(resultBean);
			objPayrollGenerationResultBean.setSuccess(sucess);

			// sucess = payrollGenerateService.saveLeaveData(saveBean);
			// leaveResultBean.setSuccess(sucess);
			// objPayrollGenerationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPayrollGenerationResultBean;
	}
}