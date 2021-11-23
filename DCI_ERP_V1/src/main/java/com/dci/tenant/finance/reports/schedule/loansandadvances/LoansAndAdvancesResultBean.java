package com.dci.tenant.finance.reports.schedule.loansandadvances;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class LoansAndAdvancesResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	List<LoansAndAdvancesBean> employeeList;

	public List<LoansAndAdvancesBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<LoansAndAdvancesBean> employeeList) {
		this.employeeList = employeeList;
	}

}
