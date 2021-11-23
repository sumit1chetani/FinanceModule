package com.dci.tenant.finance.reports.analytical.revenueregister;

import java.sql.SQLException;
import java.util.List;

import com.dci.common.util.CustomException;

public interface revenueregisterService {

	void excellexport(revenueregisterResultBean objWholeData, String filepath, String fileNme);

	List<revenueregister> getRevenueReport(revenueregister objrevenueregister) throws CustomException, SQLException;
	List<revenueregister> getportIsoCode();

	List<revenueregister> getpayer();
	
	List<revenueregister> getCustomer();

}
