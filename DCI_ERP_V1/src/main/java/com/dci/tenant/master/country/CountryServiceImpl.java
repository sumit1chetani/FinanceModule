package com.dci.tenant.master.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class CountryServiceImpl implements CountryService{
	@Autowired
	CountryDao portDao;
	@Override
	public CountryResultBean selectivity() throws Exception {
		
		return portDao.selectivity();
	}
	@Override
	public List<CountryBean> getList() {
		
		return portDao.getList();
	}

	@Override
	public Object save(CountryBean bean) throws CustomException {
		
		return portDao.save(bean);
	}

	@Override
	public CountryBean edit(int rowid) throws Exception {
		
		return portDao.edit(rowid);
	}

	@Override
	public boolean update(CountryBean update) throws Exception {
		
		return portDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return portDao.delete(rowid);
	}

	
}
