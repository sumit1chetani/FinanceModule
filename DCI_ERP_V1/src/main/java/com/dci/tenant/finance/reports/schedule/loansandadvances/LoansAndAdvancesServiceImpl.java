package com.dci.tenant.finance.reports.schedule.loansandadvances;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

@Service
public class LoansAndAdvancesServiceImpl implements LoansAndAdvancesService {
	@Autowired
	LoansAndAdvancesDAO objLoansAndAdvancesDAO;

	@Override
	public List<SelectivityBean> getDepartmentList() {
		return objLoansAndAdvancesDAO.getDepartmentList();
	}

	@Override
	public List<SelectivityBean> getCustomerList() {
		return objLoansAndAdvancesDAO.getCustomerList();
	}

	@Override
	public List<SelectivityBean> getSupplierList() {
		return objLoansAndAdvancesDAO.getSupplierList();
	}

	@Override
	public LoansAndAdvancesResultBean getEmployeeList(String department) throws CustomException {
		return objLoansAndAdvancesDAO.getEmployeeList(department);
	}

	@Override
	public List<LoansAndAdvancesBean> generateLAReport(LoansAndAdvancesBean objLoansAndAdvancesBean) {
		return objLoansAndAdvancesDAO.generateLAReport(objLoansAndAdvancesBean);
	}

}
