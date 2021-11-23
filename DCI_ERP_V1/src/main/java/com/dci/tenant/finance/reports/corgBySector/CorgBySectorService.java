package com.dci.tenant.finance.reports.corgBySector;



public interface CorgBySectorService {
	public CorgBySectorResultBean getCorgBySectorList(CorgBySector objrevenueregister) throws Exception;

	public CorgBySectorResultBean getcorgList(CorgBySector objrevenueregister) throws Exception;

	public void excellexport(CorgBySector objrevenueregister, String filepath, String fileNme) throws Exception;


}