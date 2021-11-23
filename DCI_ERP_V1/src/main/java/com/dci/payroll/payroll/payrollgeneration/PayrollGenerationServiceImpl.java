package com.dci.payroll.payroll.payrollgeneration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.payroll.payroll.payslip.PaySlipBean;


@Service
public class PayrollGenerationServiceImpl implements PayrollGenerationService {
	@Autowired
	PayrollGenerationDAO payrollDAO;

	@Override
	public List<PayrollGenerationBean> checkSalaryFixed(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.checkSalaryFixed(companyId, branchId, dept, employeeId, monthYear);
	}

	@Override
	public List<PayrollGenerationBean> getDepartmentList(String branchId) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getDepartmentList(branchId);
	}

	@Override
	public List<PayrollGenerationBean> getEmployeeList(String branchId) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getEmployeeList(branchId);
	}

	@Override
	public List<PayrollGenerationBean> getTypeList() throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getTypeList();
	}

	@Override
	public PayrollGenerationResultBean getDepartmentList1() throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getDepartmentList1();
	}

	@Override
	public List<PayrollGenerationBean> getBranchList(String companyId) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getBranchList(companyId);
	}

	@Override
	public List<PayrollGenerationBean> getEmployeeList(String dept, String branchId) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getEmployeeList(dept, branchId);
	}

	@Override
	public List<PayrollGenerationBean> getEmployees() throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getEmployees();
	}

	@Override
	public List<PayrollGenerationBean> getMonthYearList() throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getMonthYearList();
	}

	@Override
	public List<PayrollGenerationBean> getPaySlipYearList() throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getPaySlipYearList();
	}

	@Override
	public List<PayrollGenerationBean> getCompanyList() throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getCompanyList();
	}

	@Override
	public PayrollGenerationBean generatePayroll(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.generatePayroll(companyId, branchId, dept, employeeId, monthYear);
	}

	@Override
	public List<PayrollGenerationBean> checkSalaryCreated(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.checkSalaryCreated(companyId, branchId, dept, employeeId, monthYear);
	}

	@Override
	public List<PayrollGenerationBean> getEmployeeSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getEmployeeSalaryList(companyId, branchId, dept, employeeId, monthYear);
	}

	@Override
	public boolean deleteSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.deleteSalaryList(companyId, branchId, dept, employeeId, monthYear);
	}

	@Override
	public List<Map<String, Object>> getPayrollList(String companyId, String branchId, Integer departmentId, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getPayrollList(companyId, branchId, departmentId, employeeId, monthYear);
	}

	@Override
	public List<PayrollGenerationBean> checkPayrollFlag() {
		// TODO Auto-generated method stub
		return payrollDAO.checkPayrollFlag();
	}

	@Override
	public PayrollGenerationResultBean checkFlag(Integer departmentId, String employeeId) {
		// TODO Auto-generated method stub
		return payrollDAO.checkFlag(departmentId, employeeId);
	}

	@Override
	public PayrollGenerationResultBean getFlagList(int departmentId, String monthYear, String employeeId) {
		// TODO Auto-generated method stub
		return payrollDAO.getFlagList(departmentId, monthYear, employeeId);
	}

	@Override
	public PayrollGenerationResultBean withHoldList(String employeeId, String monthYear) {
		// TODO Auto-generated method stub
		return payrollDAO.withHoldList(employeeId, monthYear);
	}

	@Override
	public PayrollGenerationResultBean getcheckFlag(String employeeId) {
		// TODO Auto-generated method stub
		return payrollDAO.getcheckFlag(employeeId);
	}

	@Override
	public PayrollGenerationResultBean getAlreadyGenerated(String employeeId, String startDate) {
		// TODO Auto-generated method stub
		return payrollDAO.getAlreadyGenerated(employeeId, startDate);
	}

	@Override
	public PayrollGenerationResultBean taxDeduction(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.taxDeduction(companyId, branchId, dept, employeeId, monthYear);
	}

	@Override
	public List<PayrollGenerationBean> getEmployeeSalarygeneratedList(String companyId, String branchId, Integer departmentId, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public PayrollGenerationResultBean payrolltojv(PaySlipBean
	 * PaySlipBean) { // TODO Auto-generated method stub return return
	 * payrollDAO.payrolltojv(PaySlipBean); }
	 */

	@Override
	public boolean payrolltojv(PaySlipBean PaySlipBean) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.payrolltojv(PaySlipBean);
	}
	/*
	 * @Override public boolean payrolltojv(PayrollGenerationResultBean PaySlipBean)
	 * throws Exception { // TODO Auto-generated method stub return
	 * payrollDAO.payrolltojv(PaySlipBean); }
	 */

	@Override
	public List<Map<String, Object>> getPayrollList(String companyId, String branchId, Integer departmentId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.getPayrollList(companyId, branchId, departmentId, monthYear);
	}

	/*
	 * @Override public PayrollGenerationResultBean getcheckFlag(String employeeId)
	 * { // TODO Auto-generated method stub return
	 * payrollDAO.getcheckFlag(employeeId); }
	 */

	@Override
	public List<PayrollGenerationBean> pendingSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return payrollDAO.pendingSalaryList(companyId, branchId, dept, employeeId, monthYear);
	}

}