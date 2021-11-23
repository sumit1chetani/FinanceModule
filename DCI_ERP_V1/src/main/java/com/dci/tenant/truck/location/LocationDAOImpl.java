package com.dci.tenant.truck.location;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")

public class LocationDAOImpl implements LocationDAO{
	
	private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(LocationDAOImpl.class);

	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	AuditLogDAO auditLogDao;
	@Resource
	DataSource dataSource;
	
	@Override
	public List<LocationBean> getList() throws CustomException {
		List<LocationBean> List = new ArrayList<LocationBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			List = jdbcTemplate.query(LocationQueryUtil.LOCATION_LIST, new BeanPropertyRowMapper<LocationBean>(LocationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			//throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		
		return List;

	}
	
	@Override
	public  LocationBean insertLocation(LocationBean location){
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		LocationBean locationBean = new LocationBean();
		
		String locationCode="";
		
		Integer value = null; 
		
		try {
			
			location.setTableName("location");
			location.setFormCode("F0248");
			
			locationCode = jdbcTemplate.queryForObject(LocationQueryUtil.LOCATION_CODE, String.class);
			

			 int count = jdbcTemplate.queryForObject(LocationQueryUtil.CHECK_LOC_NAME,new Object[] { location.getLocationName()},Integer.class);
			 
			 int count1 = jdbcTemplate.queryForObject(LocationQueryUtil.CHECK_LOC_SHORT_NAME, new Object[] { location.getShortName()},Integer.class);

			 
			if (count == 0){
				
				if (count1 == 0){
				
				value = jdbcTemplate.update(LocationQueryUtil.INSERT, locationCode, location.getLocationName(),location.getShortName(),location.getLandMark(),location.getType(),location.getLatitude(),location.getLongitude(),location.getDescription(),userDetails.getUserId(),location.getCountryId());
				

				int locationId = jdbcTemplate.queryForObject(LocationQueryUtil.SELECT_PREVIOUS_ID,Integer.class);
					
			    userlogDao.userLogForInsert(location, locationId + "", userDetails.getUserId());
			    
			    locationBean.setSuccess(true);
			    
			    }
				else
				{
					locationBean.setShortNameErrorMessage(true);

				}
			}
			else
			{
				locationBean.setLocationErrorMessage(true);

			}
			
			//value=jdbcTemplate.update(LocationQueryUtil.INSERT, locationCode,location.getLocationName(),location.getShortName(),location.getLandMark(),location.getType(),location.getLatitude(),location.getLongitude(),location.getDescription(),userDetails.getUserId());
				 
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in insert Location", e.getMessage());
		}
		return locationBean;
	}


	@Override
	public LocationBean updateLocation(LocationBean location) throws Exception{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Integer value = null; 
		
		LocationBean locationBean = new LocationBean();
		
		LocationBean oldlocationBean = getLocationById(location.getLocationId());
		
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			
			
			
			locationBean = jdbcTemplate.queryForObject(LocationQueryUtil.EDIT_LOCATION,new Object[]{location.getLocationId()}, new BeanPropertyRowMapper<LocationBean>(LocationBean.class) );

			 int count = jdbcTemplate.queryForObject(LocationQueryUtil.CHECK_LOC_NAME,new Object[] { location.getLocationName()},Integer.class);
			 
			 int count1 = jdbcTemplate.queryForObject(LocationQueryUtil.CHECK_LOC_SHORT_NAME, new Object[] { location.getShortName()},Integer.class);

			
			Object[] params = new Object[]  {location.getLocationName(),location.getShortName(),location.getLandMark(),location.getType(),location.getLatitude(),location.getLongitude(),location.getDescription(),location.getCountryId(),userDetails.getUserId(),location.getLocationId() };
			Object[] params1 = new Object[] {location.getLocationName(),location.getShortName(),location.getLandMark(),location.getType(),location.getLatitude(),location.getLongitude(),location.getDescription(),location.getCountryId(),userDetails.getUserId(),location.getLocationId() };
			Object[] params2 = new Object[] {location.getLocationName(),location.getLandMark(),location.getType(),location.getLatitude(),location.getLongitude(),location.getDescription(),location.getCountryId(),userDetails.getUserId(),location.getLocationId() };
			Object[] params3 = new Object[] {location.getShortName(),location.getLandMark(),location.getType(),location.getLatitude(),location.getLongitude(),location.getDescription(),location.getCountryId(),userDetails.getUserId(),location.getLocationId() };

			
			String locationName = location.getLocationName();
			String shortName = location.getShortName();

			if (locationName.equalsIgnoreCase(locationBean.getLocationName()) && shortName.equalsIgnoreCase(locationBean.getShortName())) {
				
					
					location.setTableName("location");
					location.setFormCode("F0248");
				
			      	value = jdbcTemplate.update(LocationQueryUtil.UPDATE_LOCATION, params);
			      	
				    locationBean.setSuccess(true);

			      	
					  userlogDao.userLogForUpdate(oldlocationBean, location, location.getLocationId() + "", userDetails.getUserId());

	      }else if(!locationName.equalsIgnoreCase(locationBean.getLocationName()) && !shortName.equalsIgnoreCase(locationBean.getShortName()))
	      {
	    	  
	    	  
	    	  if(count==0){
	    		  
	    		  
	    			if (count1 == 0){

					location.setTableName("location");
					location.setFormCode("F0248");
					
			      	value = jdbcTemplate.update(LocationQueryUtil.UPDATE_LOCATION1, params1);
			      	
				    locationBean.setSuccess(true);

			      	
					  userlogDao.userLogForUpdate(oldlocationBean, location, location.getLocationId() + "", userDetails.getUserId());
					
	    			  }
					else
					{
						locationBean.setShortNameErrorMessage(true);

					}
				}
				else
				{
					locationBean.setLocationErrorMessage(true);

				}
	    	  
	      }
			
	      else if(!locationName.equalsIgnoreCase(locationBean.getLocationName()))
	      {
	    	  
	    	  if(count==0){
	    		  
					location.setTableName("location");
					location.setFormCode("F0248");
					
			      	value = jdbcTemplate.update(LocationQueryUtil.UPDATE_LOCATION2, params2);
			      	
				    locationBean.setSuccess(true);

			      	
					  userlogDao.userLogForUpdate(oldlocationBean, location, location.getLocationId() + "", userDetails.getUserId());
	    			
	    	  }
				else
				{
					locationBean.setLocationErrorMessage(true);

				}
	    	  
	      }
			
	      else if(!shortName.equalsIgnoreCase(locationBean.getShortName()))
	      {
	    	  
	    	  if(count1==0){
	    		  
					location.setTableName("location");
					location.setFormCode("F0248");
					
			      	value = jdbcTemplate.update(LocationQueryUtil.UPDATE_LOCATION3, params3);
			      	
				    locationBean.setSuccess(true);

			      	
					  userlogDao.userLogForUpdate(oldlocationBean, location, location.getLocationId() + "", userDetails.getUserId());
	    			
	    	  }
				else
				{
					locationBean.setShortNameErrorMessage(true);

				}
	    	  
	      }
			
		
		//	value = jdbcTemplate.update(LocationQueryUtil.UPDATE_LOCATION,  new Object[] {location.getLocationName(),location.getShortName(),location.getLandMark(),location.getType(),location.getLatitude(),location.getLongitude(),location.getDescription(),userDetails.getUserId(),location.getLocationId()});

			}
		
		 catch (DataAccessException e) {
			LOGGER.error("Error in update Location", e);
		}
		return locationBean;
	}
	

	@Override
	public boolean deleteLocation(int locationId) throws Exception {
		
		boolean issucces = false;
		int value= 0;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		LocationBean locationBean = new LocationBean();
		
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			locationBean = jdbcTemplate.queryForObject(LocationQueryUtil.EDIT_LOCATION,new Object[]{locationId}, new BeanPropertyRowMapper<LocationBean>(LocationBean.class) );
			
			locationBean.setTableName("location");
			locationBean.setFormCode("F0248");
			
			value = jdbcTemplate.update(LocationQueryUtil.DELETE_LOCATION,locationId);
			issucces = true;
			
			  userlogDao.userLogForDelete(locationBean, locationId + "", userDetails.getUserId());

			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return issucces;
	}


	@Override
	public  LocationBean getLocationById(int locationId) throws Exception{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		LocationBean location=new LocationBean();
		try{
			
			location = jdbcTemplate.queryForObject(LocationQueryUtil.EDIT_LOCATION,new Object[]{locationId}, new BeanPropertyRowMapper<LocationBean>(LocationBean.class) );
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return location;
	}

	@Override
	public LocationResultBean getCountryList() throws CustomException {
		
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	
	LocationResultBean locationResultBean = new LocationResultBean();
	
		
		List<SelectivityBean> countryList = new ArrayList<SelectivityBean>();
		
		countryList = jdbcTemplate.query(LocationQueryUtil.COUNTRY_LIST, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		
		locationResultBean.setCountryList(countryList);
		
		try {

		} catch (DataAccessException e) {
		}
		return locationResultBean;
	}
	
	@Override
	public LocationResultBean getPort() {
		LocationResultBean resultBean = new LocationResultBean();
		List<SelectivityBean> portList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			portList = jdbcTemplate.query(LocationQueryUtil.sPortDropDown, new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
			resultBean.setPortList(portList);
		} catch (Exception e1) {
			LOGGER.error("Error in ", e1);
	//		resultBean.setMessage("failure");
		}

		return resultBean;
	}
}


