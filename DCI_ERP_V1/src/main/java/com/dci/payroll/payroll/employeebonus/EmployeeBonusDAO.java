package com.dci.payroll.payroll.employeebonus;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CustomException;


public interface EmployeeBonusDAO {

	public List<EmployeeBonusBean> getEmployeeBonusList(String companyId, String branchId, String dept, String financialYear) throws CustomException;

	public boolean insertEmployeeBonusBean(ArrayList<EmployeeBonusBean> employeeBonusBean) throws CustomException;

	public EmployeeBonusBean getEmployeeBonusBean(String payComponentId) throws CustomException;

	public boolean updateEmployeeBonusBean(EmployeeBonusBean employeeBonusBean) throws CustomException;

	public List<EmployeeBonusBean> getEmployeeBonusSummary(Integer bonusId) throws CustomException;

	boolean updteEmployeeBonusPaid(EmployeeBonusBean employeeBonusBean) throws CustomException;

	EmployeeBonusBean getPaidDetailById(Integer bonusId) throws CustomException;

	EmployeeBonusBean getPaidDetailByDate(Integer bonusId, String paidOn) throws CustomException;

}