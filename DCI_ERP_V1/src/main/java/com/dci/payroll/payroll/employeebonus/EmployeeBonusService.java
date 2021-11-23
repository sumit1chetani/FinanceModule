package com.dci.payroll.payroll.employeebonus;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeBonusService {
	public List<EmployeeBonusBean> getEmployeeBonusList(String companyId, String branchId, String dept, String financialYear) throws Exception;

	List<EmployeeBonusBean> getEmployeeBonusSummary(Integer bonusId) throws Exception;

	public boolean insertEmployeeBonusBean(ArrayList<EmployeeBonusBean> employeeBonusBean) throws Exception;

	EmployeeBonusBean getPaidDetailById(Integer bonusId) throws Exception;

	EmployeeBonusBean getPaidDetailByDate(Integer bonusId, String paidOn) throws Exception;

	boolean updteEmployeeBonusPaid(EmployeeBonusBean employeeBonusBean) throws Exception;

}