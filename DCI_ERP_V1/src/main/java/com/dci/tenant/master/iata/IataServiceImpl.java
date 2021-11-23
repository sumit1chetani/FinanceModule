package com.dci.tenant.master.iata;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class IataServiceImpl implements IataService{
	@Autowired
	IataDao iataDao;
	@Override
	public IataResultBean selectivity() throws Exception {
		
		return iataDao.selectivity();
	}
	@Override
	public List<IataBean> getList() {
		
		return iataDao.getList();
	}

	@Override
	public Object save(IataBean bean) throws CustomException {
		
		return iataDao.save(bean);
	}

	@Override
	public IataBean edit(int rowid) throws Exception {
		
		return iataDao.edit(rowid);
	}

	@Override
	public boolean update(IataBean update) throws Exception {
		
		return iataDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return iataDao.delete(rowid);
	}

	
}
