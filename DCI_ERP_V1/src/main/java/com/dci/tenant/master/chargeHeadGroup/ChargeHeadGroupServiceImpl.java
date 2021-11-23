package com.dci.tenant.master.chargeHeadGroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class ChargeHeadGroupServiceImpl implements ChargeHeadGroupService{
	@Autowired
	ChargeHeadGroupDao iataDao;
	
	@Override
	public List<ChargeHeadGroupBean> getList() {
		
		return iataDao.getList();
	}

	@Override
	public Object save(ChargeHeadGroupBean bean) throws CustomException {
		
		return iataDao.save(bean);
	}

	@Override
	public ChargeHeadGroupBean edit(int rowid) throws Exception {
		
		return iataDao.edit(rowid);
	}

	@Override
	public boolean update(ChargeHeadGroupBean update) throws Exception {
		
		return iataDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return iataDao.delete(rowid);
	}

	
}
