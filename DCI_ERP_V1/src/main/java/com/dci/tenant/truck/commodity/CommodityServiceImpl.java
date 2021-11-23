package com.dci.tenant.truck.commodity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	CommodityDao commodityDao;

	@Override
	public List<CommodityBean> getCommodityList() {
		// TODO Auto-generated method stub
		return commodityDao.getCommodityList();
	}

	@Override
	public CommodityBean insert(CommodityBean commodity) throws Exception {
		// TODO Auto-generated method stub
		return commodityDao.insert(commodity);
	}



	@Override
	public CommodityBean getCommodityEdit(String commodityCode) {
		// TODO Auto-generated method stub
		return commodityDao.getCommodityEdit(commodityCode);
	}

	@Override
	public CommodityBean update(CommodityBean commodity) throws Exception {
		// TODO Auto-generated method stub
		return commodityDao.update(commodity);
	}

	@Override
	public boolean delete(String commodityCode) {
		// TODO Auto-generated method stub
		return commodityDao.delete(commodityCode);
	}

	@Override
	public List<CommodityBean> getDropDown() {
		// TODO Auto-generated method stub
		return commodityDao.getDropDown();
	}

}
