package com.dci.payroll.payroll.withHold;

import java.io.IOException;
import java.util.List;

import com.dci.common.util.CustomException;


public interface WithHoldService {

	List<WithHoldBean> getEmployeeList() throws Exception;

	List<WithHoldBean> getYearList() throws Exception;

	boolean addWithHold(WithHoldBean withHold) throws Exception;

	List<WithHoldBean> getWithHoldList() throws Exception;

	List<WithHoldBean> editwithHold(String withHoldCode) throws Exception;

	// employee check
	List<WithHoldBean> employeeCheck(String employee) throws Exception;

	// delete
	boolean deleteWithHold(String withHoldCode) throws Exception;

	// update
	boolean updateWithHold(WithHoldBean withHold) throws Exception;

	// withold report
	List<WithHoldBean> getWithholdReport(WithHoldBean withhold) throws Exception;

	// excel export

	public void exportExcel(WithHoldBean withhold, String filePath) throws CustomException, IOException, Exception;

}
