package com.dci.master.unit;

import java.util.List;

import com.dci.common.util.CustomException;


public interface UnitDao {
	public UnitResultBean selectivity() throws Exception;
	public List<UnitBean> getList();

	Object save(UnitBean bean) throws CustomException;

	public UnitBean edit(int rowid) throws Exception;

	public boolean update(UnitBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}

