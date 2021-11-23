package com.dci.tenant.region;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;










@Repository
@Transactional("tenantTransactionManager")

public  class RegionDAOImpl implements RegionDAO{
	
	private final static Logger LOGGER = Logger.getLogger(RegionDAOImpl.class);
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public List<RegionBean> getRegionList() {

		List<RegionBean> list = new ArrayList<RegionBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(RegionQueryUtil.list,new BeanPropertyRowMapper<RegionBean>(RegionBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getRegionList", e);
		}

		return list;
	}
	
	@Override
	public RegionBean insert(RegionBean region) throws Exception {
		Boolean isSuccess = false;
		RegionBean regionBean = new RegionBean();
		
		try {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			
		//	i = jdbcTemplate.update(RegionQueryUtil.INSERT,region.getRegion_Code(),region.getName(),region.getArea(),region.getAddress(),region.getCity(),region.getCountry(),region.getPincode(),region.getEmail(),region.getPhone_No(),region.getLocal_Currency());

		//	i = jdbcTemplate.update(RegionQueryUtil.INSERT,region.getRegion_Code(),region.getName());
			int i= jdbcTemplate.update(RegionQueryUtil.INSERT,region.getRegion_Code(),region.getName(),region.getArea(),region.getAddress(),region.getCity(),region.getCountry(),region.getPincode(),region.getEmail(),region.getPhone_No(),region.getLocal_Currency());
			 if(i>0) {
				isSuccess = true;
				regionBean.setIsSuccess(isSuccess);
			 }

		}catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
			regionBean.setIsSuccess(isSuccess);
			
			regionBean.setMessage("Error in save :" + e.getMessage());
			LOGGER.error("Error in save", e);
		}
		return regionBean;
	}
	
	
	@Override
	public RegionBean update(RegionBean region) throws Exception {
		RegionBean bean  = new RegionBean();
		Boolean isSuccess = false;
	
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			
			int i=jdbcTemplate.update(RegionQueryUtil.UPDATE,region.getName(),
					region.getArea(),region.getAddress(),region.getCity(),region.getCountry(),region.getPincode(),region.getEmail(),region.getPhone_No(),region.getLocal_Currency(),region.getRegion_Code());
			if(i>0) {
	        	isSuccess = true;
	        	bean.setIsSuccess(isSuccess);
			}
	}catch (DataAccessException e) {
		e.printStackTrace();
		isSuccess = false;
		bean.setIsSuccess(isSuccess);
		bean.setMessage("Error in Update :" + e.getMessage());
		LOGGER.error("Error in update", e);
		}
		return bean;
	}
	
	@Override
	public RegionBean delete(String region_Code ){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		RegionBean regionBean = new RegionBean();
		boolean isSuccess = false;


		try {
			jdbcTemplate.update(RegionQueryUtil.delete, region_Code);

			
			isSuccess = true;
			regionBean.setIsSuccess(isSuccess);
		} catch (DataAccessException e) {
			e.printStackTrace();
		isSuccess = false;
		regionBean.setIsSuccess(isSuccess);
		regionBean.setMessage("Error in Delete :" + e.getMessage());
		LOGGER.error("Error in delete", e);	
			
		}

		return regionBean;
	}
	
	@Override
	public RegionBean getRegionEdit(String region_Code) {
		// TODO Auto-generated method stub
		RegionBean regionBean =new RegionBean();
		try {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			regionBean = jdbcTemplate.queryForObject(RegionQueryUtil.GET_REGION,
					new Object[] { region_Code },
					new BeanPropertyRowMapper<RegionBean>(RegionBean.class));

		}catch (DataAccessException e) {
			LOGGER.error("Error in edit", e);
			e.printStackTrace();
			
		}
		return regionBean;
	}

	
	
		
}



