package com.dci.payroll.payroll.payrollgeneration;

import java.util.List;
import java.util.Map;

import com.dci.common.util.CustomException;
import com.dci.payroll.payroll.payslip.PaySlipBean;


public interface PayrollGenerationDAO {
	public List<PayrollGenerationBean> checkSalaryCreated(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException;

	public List<PayrollGenerationBean> checkSalaryFixed(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException;

	public PayrollGenerationBean generatePayroll(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException;

	public List<PayrollGenerationBean> getEmployeeSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException;

	public List<PayrollGenerationBean> getDepartmentList(String branchId) throws CustomException;

	public List<PayrollGenerationBean> getEmployeeList(String branchId) throws CustomException;

	public List<PayrollGenerationBean> getTypeList() throws CustomException;

	public PayrollGenerationResultBean getDepartmentList1() throws CustomException;

	public List<PayrollGenerationBean> getBranchList(String companyId) throws CustomException;

	public List<PayrollGenerationBean> getEmployeeList(String dept, String branchId) throws CustomException;

	public List<PayrollGenerationBean> getEmployees() throws CustomException;

	public List<PayrollGenerationBean> getMonthYearList() throws CustomException;

	public List<PayrollGenerationBean> getPaySlipYearList() throws CustomException;

	public List<PayrollGenerationBean> getCompanyList() throws CustomException;

	public PayrollGenerationResultBean getcheckFlag(String employeeId);

	public boolean deleteSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException;

	public List<Map<String, Object>> getPayrollList(String companyId, String branchId, Integer departmentId, String employeeId, String monthYear) throws CustomException;

	public List<PayrollGenerationBean> checkPayrollFlag();

	public PayrollGenerationResultBean checkFlag(Integer departmentId, String employeeId);

	public PayrollGenerationResultBean getFlagList(int departmentId, String monthYear, String employeeId);

	public PayrollGenerationResultBean withHoldList(String employeeId, String monthYear);

	public PayrollGenerationResultBean getAlreadyGenerated(String employeeId, String startDate);

	public PayrollGenerationResultBean taxDeduction(String companyId, String branchId, String dept, String employeeId, String monthYear);

	// PayrollGenerationResultBean payrolltojv(PaySlipBean PaySlipBean);

	public boolean payrolltojv(PaySlipBean PaySlipBean) throws Exception;

	// public boolean payrolltojv(PayrollGenerationResultBean PaySlipBean) throws
	// Exception;

	List<Map<String, Object>> getPayrollList(String companyId, String branchId, Integer departmentId, String monthYear) throws Exception;

	List<PayrollGenerationBean> pendingSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception;

}