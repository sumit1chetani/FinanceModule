package com.dci.tenant.master.country;

import java.util.List;

import com.dci.common.util.CustomException;


public interface CountryDao {
	public CountryResultBean selectivity() throws Exception;
	public List<CountryBean> getList();

	Object save(CountryBean bean) throws CustomException;

	public CountryBean edit(int rowid) throws Exception;

	public boolean update(CountryBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}

