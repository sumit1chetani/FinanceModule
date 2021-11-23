package com.dci.payroll.payroll.employeebonus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBonusServiceImpl implements EmployeeBonusService {
	@Autowired
	EmployeeBonusDAO employeeBonusDAO;

	@Override
	public List<EmployeeBonusBean> getEmployeeBonusList(String companyId, String branchId, String dept, String financialYear) throws Exception {
		return employeeBonusDAO.getEmployeeBonusList(companyId, branchId, dept, financialYear);
	}

	@Override
	public boolean insertEmployeeBonusBean(ArrayList<EmployeeBonusBean> employeeBonusBean) throws Exception {
		// TODO Auto-generated method stub
		return employeeBonusDAO.insertEmployeeBonusBean(employeeBonusBean);
	}

	@Override
	public List<EmployeeBonusBean> getEmployeeBonusSummary(Integer bonusId) throws Exception {
		// TODO Auto-generated method stub
		return employeeBonusDAO.getEmployeeBonusSummary(bonusId);
	}

	@Override
	public EmployeeBonusBean getPaidDetailById(Integer bonusId) throws Exception {
		// TODO Auto-generated method stub
		return employeeBonusDAO.getPaidDetailById(bonusId);
	}

	@Override
	public EmployeeBonusBean getPaidDetailByDate(Integer bonusId, String paindOn) throws Exception {
		// TODO Auto-generated method stub
		return employeeBonusDAO.getPaidDetailByDate(bonusId, paindOn);
	}

	@Override
	public boolean updteEmployeeBonusPaid(EmployeeBonusBean employeeBonusBean) throws Exception {
		// TODO Auto-generated method stub
		return employeeBonusDAO.updteEmployeeBonusPaid(employeeBonusBean);
	}

}