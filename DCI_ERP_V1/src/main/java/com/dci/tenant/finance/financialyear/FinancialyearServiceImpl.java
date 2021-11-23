package com.dci.tenant.finance.financialyear;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialyearServiceImpl implements FinancialyearService {

	@Autowired
	FinancialyearDAO objfinancialyearDAO;

	@Override
	public List<FinancialyearBean> getFinancialYearList(int limit, int offset) throws Exception {

		return objfinancialyearDAO.getFinancialYearList(limit, offset);
	}

	@Override
	public FinancialyearResultBean saveFinancialYear(FinancialyearBean financialyearBean) {
		// TODO Auto-generated method stub
		return objfinancialyearDAO.saveFinancialYear(financialyearBean);
	}

	@Override
	public FinancialyearBean getFinancialYearData(String finId) {
		// TODO Auto-generated method stub
		return objfinancialyearDAO.getFinancialYearData(finId);
	}

	@Override
	public boolean updateFinancialYear(FinancialyearBean financialyearBean) {
		// TODO Auto-generated method stub
		return objfinancialyearDAO.updateFinancialYear(financialyearBean);
	}

	@Override
	public boolean deleteFinancialYear(String finId) {
		// TODO Auto-generated method stub
		return objfinancialyearDAO.deleteFinancialYear(finId);
	}

	@Override
	public boolean validateFY(FinancialyearBean financialyearBean) {
		// TODO Auto-generated method stub
		return objfinancialyearDAO.validateFY(financialyearBean);
	}

}
