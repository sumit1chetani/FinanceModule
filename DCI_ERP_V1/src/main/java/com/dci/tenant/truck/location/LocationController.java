package com.dci.tenant.truck.location;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
@RestController
@RequestMapping("{tenantid}/locationmaster")
public class LocationController {

		private final static Logger LOGGER = LoggerFactory.getLogger(LocationController.class);

		
		@Autowired
		private LocationService locationService;

		@RequestMapping(value = "/list")
		public LocationResultBean getList() throws CustomException {
			LocationResultBean vehicleResultBean = new LocationResultBean();
			try {

				vehicleResultBean.setList(locationService.getList());

			} catch (CustomException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return vehicleResultBean;
		}
		
		
		@RequestMapping(value = "/countryList")
		public LocationResultBean getCountryList() throws CustomException {
			LocationResultBean vehicleResultBean = new LocationResultBean();
			try {

				vehicleResultBean = locationService.getCountryList();

			} catch (CustomException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return vehicleResultBean;
		}
		
		
	// Location Drop down
		
		@RequestMapping("/getPort")
		public @ResponseBody LocationResultBean getPort() throws CustomException {
			LocationResultBean objBean = null;
			try {
				objBean = locationService.getPort();
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
			return objBean;
		}
		
	
		@RequestMapping(value = "/save")
		public @ResponseBody LocationBean  save(@RequestBody LocationBean location) throws CustomException  {
			
			LocationBean locationBean = new LocationBean();			
			try {
				locationBean=locationService.insertLocation(location);
			} catch (Exception e) {
				LOGGER.error("error on location add " + e);
				throw new CustomException();
				
			}
			return locationBean;
		}
		@RequestMapping(value = "/update")
		public @ResponseBody LocationBean updateLocation(@RequestBody LocationBean location) throws CustomException {
			
			LocationBean locationBean = new LocationBean();			

			
			try {
				locationBean =locationService.updateLocation(location);
			} 
			catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
			return locationBean;
		}
	
		@RequestMapping("/delete")
		public @ResponseBody boolean delete(@RequestBody int locationId) throws Exception {
			boolean isDeleted = false;
			isDeleted = locationService.deleteLocation(locationId);
;
			return isDeleted;
		}

	
		@RequestMapping("/edit")
		public @ResponseBody LocationBean  getLocationById(@RequestBody int locationId) throws CustomException{
			LocationBean vehicle = new LocationBean();		
			try {
				vehicle = locationService.getLocationById(locationId);			
				} catch (Exception e) {
				
				LOGGER.error("Error", e);
				throw new CustomException();
			}
			return vehicle;
		}
	
	

	}


