package com.dci.tenant.region;
import java.util.List;





public interface RegionService {

	public List<RegionBean> getRegionList();
	
	public RegionBean insert(RegionBean region) throws Exception;
public RegionBean update(RegionBean region) throws Exception;
	
	public RegionBean delete(String region_Code);
	
	public RegionBean getRegionEdit(String region_Code);

	

	
	}

	


