package com.dci.tenant.region;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service

public class RegionServiceImpl implements RegionService{
	@Autowired
	RegionDAO regionDao;
	
	@Override
	public List<RegionBean> getRegionList() {
		
		return regionDao.getRegionList();
	}
	
	@Override
	public RegionBean insert(RegionBean region) throws Exception {
		// TODO Auto-generated method stub
		return regionDao.insert(region);
	}
	
	@Override
	public RegionBean update(RegionBean region) throws Exception {
		// TODO Auto-generated method stub
		return regionDao.update(region);
	}
	
	@Override
	public RegionBean delete( String region_Code) {
		// TODO Auto-generated method stub
	return regionDao.delete(region_Code);
	}

	@Override
	public RegionBean getRegionEdit(String region_Code) {
		// TODO Auto-generated method stub
		return regionDao.getRegionEdit(region_Code);
	}

	

	

}
	


