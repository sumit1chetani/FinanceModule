package com.dci.tenant.truck.location;

import java.util.List;

import com.dci.common.util.CustomException;
public interface LocationDAO {
	
	LocationResultBean getCountryList() throws CustomException;
	
	public LocationResultBean getPort() throws CustomException;


	List<LocationBean> getList()  throws CustomException ;
	
	public LocationBean updateLocation(LocationBean location) throws Exception;

	public  LocationBean insertLocation(LocationBean location);

	public  LocationBean getLocationById(int locationId) throws Exception;
	
	public boolean deleteLocation(int locationId) throws Exception;

	
	
}

