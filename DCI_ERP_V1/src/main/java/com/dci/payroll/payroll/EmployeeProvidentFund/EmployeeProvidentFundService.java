package com.dci.payroll.payroll.EmployeeProvidentFund;

import java.io.IOException;

import com.dci.common.util.CustomException;


public interface EmployeeProvidentFundService {

	public EmployeeProvidentFundResultBean getEPFList(EmployeeProvidentFundBean employeeProvidentFundBean) throws Exception;

	public void exportExcel(EmployeeProvidentFundBean employeeProvidentFundBean, String filePath) throws CustomException, IOException, Exception;
}
