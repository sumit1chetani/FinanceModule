package com.dci.tenant.truck.commodityclassification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommodityClassificationServiceImpl implements CommodityClassificationService {
	
	@Autowired
	CommodityClassificationDao commodityDao;


	@Override
	public List<CommodityClassificationBean> getCommodityList() {
		// TODO Auto-generated method stub
		return commodityDao.getCommodityList();
	}

	@Override
	public CommodityClassificationBean insert(CommodityClassificationBean commodityclassification) throws Exception {
		// TODO Auto-generated method stub
		return commodityDao.insert(commodityclassification);
	}

	@Override
	public boolean delete(String classificationCode) {
		// TODO Auto-generated method stub
		return commodityDao.delete(classificationCode);
	}

	@Override
	public CommodityClassificationBean getCommodityEdit(String classificationCode) {
		// TODO Auto-generated method stub
		return commodityDao.getCommodityEdit(classificationCode);
	}

	@Override
	public CommodityClassificationBean update(CommodityClassificationBean commodityclassification) throws Exception {
		// TODO Auto-generated method stub
		return commodityDao.update(commodityclassification);
	}

}
