package com.dci.tenant.truck.general.chargecomponent;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class ChargecomponentServiceImpl implements ChargecomponentSerivce{
	
	@Autowired
	ChargecomponentDao chargecomponentDao;

	@Override
	public List<ChargecomponentBean> getList() {
		
		return chargecomponentDao.getList();
	}

	@Override
	public Object save(ChargecomponentBean bean) throws CustomException {
		
		return chargecomponentDao.save(bean);
	}

	@Override
	public ChargecomponentBean edit(int rowid) throws Exception {
		
		return chargecomponentDao.edit(rowid);
	}

	@Override
	public boolean update(ChargecomponentBean update) throws Exception {
		
		return chargecomponentDao.update(update);
	}

	@Override
	public boolean delete(int rowid) throws Exception {
		
		return chargecomponentDao.delete(rowid);
	}

	@Override
	public ChargecomponentResultBean selectivity() throws Exception {
		
		return chargecomponentDao.selectivity();
	}
	
	
	
	

}

