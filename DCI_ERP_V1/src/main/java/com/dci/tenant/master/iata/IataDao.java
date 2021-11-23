package com.dci.tenant.master.iata;

import java.util.List;

import com.dci.common.util.CustomException;


public interface IataDao {
	public IataResultBean selectivity() throws Exception;
	public List<IataBean> getList();

	Object save(IataBean bean) throws CustomException;

	public IataBean edit(int rowid) throws Exception;

	public boolean update(IataBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}

