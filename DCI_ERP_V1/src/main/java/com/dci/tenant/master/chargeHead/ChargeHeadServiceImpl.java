package com.dci.tenant.master.chargeHead;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class ChargeHeadServiceImpl implements ChargeHeadService{
	@Autowired
	ChargeHeadDao chargeDao;
	@Override
	public ChargeHeadResultBean selectivity() throws Exception {
		
		return chargeDao.selectivity();
	}
	@Override
	public List<ChargeHeadBean> getList() {
		
		return chargeDao.getList();
	}

	@Override
	public Object save(ChargeHeadBean bean) throws CustomException {
		
		return chargeDao.save(bean);
	}

	@Override
	public ChargeHeadBean edit(int rowid) throws Exception {
		
		return chargeDao.edit(rowid);
	}
	
	@Override
	public ChargeHeadBean view(int rowid) throws Exception {
		
		return chargeDao.view(rowid);
	}

	@Override
	public boolean update(ChargeHeadBean update) throws Exception {
		
		return chargeDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return chargeDao.delete(rowid);
	}

	
}
