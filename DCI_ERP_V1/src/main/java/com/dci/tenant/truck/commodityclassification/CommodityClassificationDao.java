package com.dci.tenant.truck.commodityclassification;

import java.util.List;



public interface CommodityClassificationDao {
	
	public List<CommodityClassificationBean> getCommodityList();

	public CommodityClassificationBean insert(CommodityClassificationBean commodityclassification) throws Exception;

	public boolean delete(String classificationCode);

	public CommodityClassificationBean getCommodityEdit(String classificationCode);

	public CommodityClassificationBean update(CommodityClassificationBean commodityclassification) throws Exception;


}
