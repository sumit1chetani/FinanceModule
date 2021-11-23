package com.dci.payroll.payroll.withHold;

import java.util.List;

public interface WithHoldDAO {

	List<WithHoldBean> getEmployeeList() throws Exception;

	// year list

	List<WithHoldBean> getYearList() throws Exception;

	boolean addWithHold(WithHoldBean withHold) throws Exception;

	List<WithHoldBean> getWithHoldList() throws Exception;

	// edit

	List<WithHoldBean> editwithHold(String withHoldCode) throws Exception;

	// employee check

	List<WithHoldBean> employeeCheck(String employee) throws Exception;

	// delete

	boolean deleteWithHold(String withHoldCode) throws Exception;

	// update
	boolean updateWithHold(WithHoldBean withHold) throws Exception;

	// withhold report
	List<WithHoldBean> getWithholdReport(WithHoldBean withhold) throws Exception;

}
