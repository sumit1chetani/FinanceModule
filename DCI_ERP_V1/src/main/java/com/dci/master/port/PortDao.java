package com.dci.master.port;

import java.util.List;

import com.dci.common.util.CustomException;

public interface PortDao {
	public PortResultBean selectivity() throws Exception;
	public List<PortBean> getList();

	Object save(PortBean bean) throws CustomException;

	public PortBean edit(int rowid) throws Exception;

	public boolean update(PortBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}

