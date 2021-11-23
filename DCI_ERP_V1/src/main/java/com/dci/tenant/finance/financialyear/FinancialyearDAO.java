package com.dci.tenant.finance.financialyear;

import java.util.List;

import com.dci.common.util.CustomException;

public interface FinancialyearDAO {

	public List<FinancialyearBean> getFinancialYearList(int limit, int offset) throws CustomException;

	public FinancialyearResultBean saveFinancialYear(FinancialyearBean financialyearBean);

	public FinancialyearBean getFinancialYearData(String finId);

	public boolean updateFinancialYear(FinancialyearBean financialyearBean);

	public boolean deleteFinancialYear(String finId);

	public boolean validateFY(FinancialyearBean financialyearBean);

}
