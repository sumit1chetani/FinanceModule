package com.dci.tenant.master.packageType;

import java.util.List;

import com.dci.common.util.CustomException;



public interface PackageTypeDao {
	public PackageTypeResultBean selectivity() throws Exception;
	public List<PackageTypeBean> getList();

	Object save(PackageTypeBean bean) throws CustomException;

	public PackageTypeBean edit(int rowid) throws Exception;

	public boolean update(PackageTypeBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}