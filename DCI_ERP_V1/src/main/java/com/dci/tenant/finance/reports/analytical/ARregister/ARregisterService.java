package com.dci.tenant.finance.reports.analytical.ARregister;

import java.util.List;

import com.dci.common.util.CustomException;

public interface ARregisterService {

	List<ARregister> getARReport(ARregister objarRegister) throws CustomException;

	void excellexport(ARregisterResultBean objWholeData, String filepath, String fileNme);

}
