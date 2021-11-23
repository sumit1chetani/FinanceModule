package com.dci.master.unit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class UnitServiceImpl implements UnitService{
	@Autowired
	UnitDao portDao;
	@Override
	public UnitResultBean selectivity() throws Exception {
		
		return portDao.selectivity();
	}
	@Override
	public List<UnitBean> getList() {
		
		return portDao.getList();
	}

	@Override
	public Object save(UnitBean bean) throws CustomException {
		
		return portDao.save(bean);
	}

	@Override
	public UnitBean edit(int rowid) throws Exception {
		
		return portDao.edit(rowid);
	}

	@Override
	public boolean update(UnitBean update) throws Exception {
		
		return portDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return portDao.delete(rowid);
	}

	
}
