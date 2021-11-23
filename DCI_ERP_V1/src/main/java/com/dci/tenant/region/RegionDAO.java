package com.dci.tenant.region;
import java.util.List;




public interface RegionDAO {
public List<RegionBean> getRegionList();
	
	public RegionBean insert(RegionBean region) throws Exception;
	public RegionBean getRegionEdit(String region_Code);

	public RegionBean update(RegionBean region) throws Exception;
	
	public RegionBean delete(String region_Code);
	

	

}
