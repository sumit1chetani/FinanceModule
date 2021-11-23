package com.dci.tenant.finance.chqreconcilation;

import java.util.List;

public interface ChqReconcilationService {
	public List<ChqReconcilationBook> getBankBookList();

	public List<ChqReconcilationBook> getBankandBookStatement(String sFromDate, String sToDate, String sBankAccountCode, String compid);

	public List<ChqReconcilationBook> getReconcileStatement(String sFromDate, String sToDate, String sBankAccountCode, String compid);

	public boolean saveReconcilation(ChqReconcilationBook bean, String companyCode);
}