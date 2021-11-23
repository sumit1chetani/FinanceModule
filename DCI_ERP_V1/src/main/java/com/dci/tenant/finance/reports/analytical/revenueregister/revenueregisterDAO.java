package com.dci.tenant.finance.reports.analytical.revenueregister;

import java.sql.SQLException;
import java.util.List;

public interface revenueregisterDAO {

	public List<revenueregister> geRevenueRegisterList(revenueregister objrevenueregister) throws SQLException;

	List<revenueregister> getportIsoCode();


	public List<revenueregister> getpayer();
	
	public List<revenueregister> getCustomer();
	
}
