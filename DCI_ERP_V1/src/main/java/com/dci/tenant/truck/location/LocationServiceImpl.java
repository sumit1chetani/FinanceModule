package com.dci.tenant.truck.location;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;
@Service
public class LocationServiceImpl implements LocationService{
	@Autowired
		LocationDAO locationDAO;
		@Override
		public List<LocationBean> getList() throws CustomException {
			return locationDAO.getList();
		}
	
		@Override
		public LocationBean insertLocation(LocationBean location){
			return locationDAO.insertLocation(location);
		}

		@Override
		public LocationBean updateLocation(LocationBean location) throws Exception{
			return locationDAO.updateLocation(location);
		}

		

		@Override
		public boolean deleteLocation(int locationId) throws Exception{
			return locationDAO.deleteLocation(locationId);
		}

		@Override
		public  LocationBean getLocationById(int locationId) throws Exception{
			return locationDAO.getLocationById(locationId);
		}

		@Override
		public LocationResultBean getCountryList() throws CustomException {
			
			return locationDAO.getCountryList();

		}
			

		@Override
		public LocationResultBean getPort() throws CustomException {
			return locationDAO.getPort();
		}

}

