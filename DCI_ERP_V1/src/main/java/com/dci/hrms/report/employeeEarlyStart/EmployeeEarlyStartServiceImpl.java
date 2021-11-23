package com.dci.hrms.report.employeeEarlyStart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;


@Service
public class EmployeeEarlyStartServiceImpl implements EmployeeEarlyStartService {

	@Autowired
	public EmployeeEarlyStartDAO employeeEarlyStartDAO;

	@Override
	public EmployeeEarlyStartResultBean getHospitalList(String formCode) throws CustomException {
		return employeeEarlyStartDAO.getHospitalList(formCode);
	}

	@Override
	public List<EmployeeEarlyStartBean> getEarlyStartList(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException {
		return employeeEarlyStartDAO.getEarlyStartList(employeeEarlyStartBean);
	}

	@Override
	public List<EmployeeEarlyStartBean> getEarlyLateList(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException {
		return employeeEarlyStartDAO.getEarlyLateList(employeeEarlyStartBean);
	}

	@Override
	public List<EmployeeEarlyStartBean> getHabitualLate(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException {
		return employeeEarlyStartDAO.getHabitualLate(employeeEarlyStartBean);
	}

	@Override
	public EmployeeEarlyStartResultBean getEmployeeList(String branchId) throws CustomException {
		return employeeEarlyStartDAO.getEmployeeList(branchId);
	}

	@Override
	public EmployeeEarlyStartResultBean getEmployeeListDiv(String divisionId) throws CustomException {
		// TODO Auto-generated method stub
		return employeeEarlyStartDAO.getEmployeeListDiv(divisionId);
	}

	@Override
	public EmployeeEarlyStartResultBean getDivisionList(String companyId) throws CustomException {
		// TODO Auto-generated method stub
		return employeeEarlyStartDAO.getDivisionList(companyId);
	}

	@Override
	public List<EmployeeEarlyStartBean> getEmpDetailList(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException {
		return employeeEarlyStartDAO.getEmpDetailList(employeeEarlyStartBean);
	}

	@Override
	public EmployeeEarlyStartResultBean getLeaveList(String empId) throws CustomException {
		return employeeEarlyStartDAO.getLeaveList(empId);
	}

	@Override
	public List<EmployeeEarlyStartBean> getLeaveDetails(String leaveType, String empId) throws CustomException {
		return employeeEarlyStartDAO.getLeaveDetails(leaveType, empId);
	}

}
