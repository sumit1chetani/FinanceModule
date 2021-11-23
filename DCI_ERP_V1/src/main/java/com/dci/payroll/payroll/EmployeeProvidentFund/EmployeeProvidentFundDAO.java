package com.dci.payroll.payroll.EmployeeProvidentFund;

import java.util.List;

import com.dci.common.util.CustomException;


public interface EmployeeProvidentFundDAO {

	public EmployeeProvidentFundResultBean getEPFList(EmployeeProvidentFundBean employeeProvidentFundBean) throws CustomException;

	public List<EmployeeProvidentFundBean> getEPFXLList(EmployeeProvidentFundBean employeeProvidentFundBean) throws CustomException;

}
