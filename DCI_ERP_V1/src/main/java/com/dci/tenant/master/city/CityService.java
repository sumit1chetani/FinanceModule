package com.dci.tenant.master.city;

import java.util.List;

import com.dci.common.util.CustomException;





public interface CityService {
	public CityResultBean selectivity() throws Exception;

	public List<CityBean> getList();

	Object save(CityBean bean) throws CustomException;

	public CityBean edit(int rowid) throws Exception;

	public boolean update(CityBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}
