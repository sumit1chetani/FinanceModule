package com.dci.master.commoditynew;

import java.util.List;



public interface CommoditynewDao {

	public List<CommoditynewBean> getCommodityList();

	public CommoditynewBean insert(CommoditynewBean commodity) throws Exception;

	public boolean delete(String commodityCode);

	public CommoditynewBean getCommodityEdit(String commodityCode);

	public CommoditynewBean update(CommoditynewBean commodity) throws Exception;
	
	public List<CommoditynewBean> getDropDown();
}
