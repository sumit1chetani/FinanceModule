package com.dci.tenant.master.containersize;

import java.util.List;

import com.dci.common.util.CustomException;





public interface ContainerSizeService {
	public ContainerSizeResultBean selectivity() throws Exception;

	public List<ContainerSizeBean> getList();

	Object save(ContainerSizeBean bean) throws CustomException;

	public ContainerSizeBean edit(int rowid) throws Exception;

	public boolean update(ContainerSizeBean update) throws Exception;

	public boolean delete(int rowid) throws Exception;
}
