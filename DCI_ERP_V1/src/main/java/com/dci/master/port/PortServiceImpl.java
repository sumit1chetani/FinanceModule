package com.dci.master.port;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class PortServiceImpl implements PortService{
	@Autowired
	PortDao portDao;
	@Override
	public PortResultBean selectivity() throws Exception {
		
		return portDao.selectivity();
	}
	@Override
	public List<PortBean> getList() {
		
		return portDao.getList();
	}

	@Override
	public Object save(PortBean bean) throws CustomException {
		
		return portDao.save(bean);
	}

	@Override
	public PortBean edit(int rowid) throws Exception {
		
		return portDao.edit(rowid);
	}

	@Override
	public boolean update(PortBean update) throws Exception {
		
		return portDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return portDao.delete(rowid);
	}

	
}
