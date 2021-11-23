package com.dci.tenant.truck.general.chargetype;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargetypeServiceImpl implements ChargetypeService{
	
	
	@Autowired
	ChargetypeDao changetypeDao;

	@Override
	public List<ChargetypeBean> getList() {
		
		return changetypeDao.getList();
	}

	@Override
	public Object save(ChargetypeBean bean) {
		
		return changetypeDao.save(bean);
	}

	@Override
	public ChargetypeBean edit(int rowid) throws Exception {
		
		return changetypeDao.edit(rowid);
	}

	@Override
	public boolean update(ChargetypeBean update) throws Exception {
		
		return changetypeDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return changetypeDao.delete(rowid);
	}
	

	
	
	
	
	
	
}

