package com.dci.tenant.finance.reports.schedule.loansandadvances;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

public interface LoansAndAdvancesDAO {
	List<SelectivityBean> getDepartmentList();

	List<SelectivityBean> getCustomerList();

	List<SelectivityBean> getSupplierList();

	LoansAndAdvancesResultBean getEmployeeList(String department) throws CustomException;

	List<LoansAndAdvancesBean> generateLAReport(LoansAndAdvancesBean objLoansAndAdvancesBean);
}
