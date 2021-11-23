package com.dci.tenant.truck.location;



import java.util.List;

import com.dci.common.util.CustomException;

public interface LocationService {
	
	
	LocationResultBean getCountryList() throws CustomException;
	
	public LocationResultBean getPort() throws CustomException;
	
	List<LocationBean> getList() throws CustomException;

	public boolean deleteLocation(int locationId) throws Exception;

	public  LocationBean getLocationById(int locationId) throws Exception;
	
	public LocationBean updateLocation(LocationBean vehicle) throws Exception;
	
	public LocationBean insertLocation(LocationBean location);


	
}

