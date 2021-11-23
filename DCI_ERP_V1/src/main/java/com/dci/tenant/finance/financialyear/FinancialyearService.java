package com.dci.tenant.finance.financialyear;

import java.util.List;

public interface FinancialyearService {

	public List<FinancialyearBean> getFinancialYearList(int limit, int offset) throws Exception;

	public FinancialyearResultBean saveFinancialYear(FinancialyearBean financialyearBean);

	public FinancialyearBean getFinancialYearData(String finId);

	public boolean updateFinancialYear(FinancialyearBean financialyearBean);

	public boolean deleteFinancialYear(String finId);

	public boolean validateFY(FinancialyearBean financialyearBean);

}
