package com.dci.tenant.finance.chqreconcilation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChqReconcilationServiceImpl implements ChqReconcilationService {
	@Autowired
	ChqReconcilationDAO objCashBankBookDAO;

	@Override
	public List<ChqReconcilationBook> getBankBookList() {
		return objCashBankBookDAO.getBankBookList();
	}

	@Override
	public List<ChqReconcilationBook> getBankandBookStatement(String sFromDate, String sToDate, String sBankAccountCode, String compid) {
		return objCashBankBookDAO.getBankandBookStatement(sFromDate, sToDate, sBankAccountCode, compid);
	}

	@Override
	public List<ChqReconcilationBook> getReconcileStatement(String sFromDate, String sToDate, String sBankAccountCode, String compid) {
		return objCashBankBookDAO.getReconcileStatement(sFromDate, sToDate, sBankAccountCode, compid);
	}

	@Override
	public boolean saveReconcilation(ChqReconcilationBook bean, String companyCode) {
		return objCashBankBookDAO.saveReconcilation(bean, companyCode);
	}

}