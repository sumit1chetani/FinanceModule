package com.dci.tenant.truck.commodity;

import java.util.List;

public interface CommodityService {
	
public List<CommodityBean> getCommodityList();
	
	public CommodityBean insert(CommodityBean commodity) throws Exception;

	public boolean delete(String commodityCode);
	
	public CommodityBean getCommodityEdit(String commodityCode);

	public CommodityBean update(CommodityBean commodity) throws Exception;
	
	public List<CommodityBean> getDropDown();

}
