package com.dci.tenant.master.containersize;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class ContainerSizeServiceImpl implements ContainerSizeService{
	@Autowired
	ContainerSizeDao portDao;
	@Override
	public ContainerSizeResultBean selectivity() throws Exception {
		
		return portDao.selectivity();
	}
	@Override
	public List<ContainerSizeBean> getList() {
		
		return portDao.getList();
	}

	@Override
	public Object save(ContainerSizeBean bean) throws CustomException {
		
		return portDao.save(bean);
	}

	@Override
	public ContainerSizeBean edit(int rowid) throws Exception {
		
		return portDao.edit(rowid);
	}

	@Override
	public boolean update(ContainerSizeBean update) throws Exception {
		
		return portDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return portDao.delete(rowid);
	}

	
}
