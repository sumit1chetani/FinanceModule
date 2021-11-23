package com.dci.tenant.master.city;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class CityServiceImpl implements CityService{
	@Autowired
	CityDao portDao;
	@Override
	public CityResultBean selectivity() throws Exception {
		
		return portDao.selectivity();
	}
	@Override
	public List<CityBean> getList() {
		
		return portDao.getList();
	}

	@Override
	public Object save(CityBean bean) throws CustomException {
		
		return portDao.save(bean);
	}

	@Override
	public CityBean edit(int rowid) throws Exception {
		
		return portDao.edit(rowid);
	}

	@Override
	public boolean update(CityBean update) throws Exception {
		
		return portDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return portDao.delete(rowid);
	}

	
}
