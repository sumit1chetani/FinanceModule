package com.dci.master.commoditynew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommoditynewServiceImpl implements CommoditynewService {
	
	@Autowired
	CommoditynewDao commodityDao;

	@Override
	public List<CommoditynewBean> getCommodityList() {
		// TODO Auto-generated method stub
		return commodityDao.getCommodityList();
	}

	@Override
	public CommoditynewBean insert(CommoditynewBean commodity) throws Exception {
		// TODO Auto-generated method stub
		return commodityDao.insert(commodity);
	}



	@Override
	public CommoditynewBean getCommodityEdit(String commodityCode) {
		// TODO Auto-generated method stub
		return commodityDao.getCommodityEdit(commodityCode);
	}

	@Override
	public CommoditynewBean update(CommoditynewBean commodity) throws Exception {
		// TODO Auto-generated method stub
		return commodityDao.update(commodity);
	}

	@Override
	public boolean delete(String commodityCode) {
		// TODO Auto-generated method stub
		return commodityDao.delete(commodityCode);
	}

	@Override
	public List<CommoditynewBean> getDropDown() {
		// TODO Auto-generated method stub
		return commodityDao.getDropDown();
	}

}
