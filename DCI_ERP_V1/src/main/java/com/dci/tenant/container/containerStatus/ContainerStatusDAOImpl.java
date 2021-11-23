package com.dci.tenant.container.containerStatus;

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

public class ContainerStatusDAOImpl implements ContainerStatusDAO {
	
	private final static Logger LOGGER = Logger.getLogger(ContainerStatusDAOImpl.class);
	
	@Autowired
	DataSource dataSource;
	

	@Override
	public List<ContainerStatusBean> getContainerStatusList() {
		List<ContainerStatusBean> list = new ArrayList<ContainerStatusBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(ContainerStatusQueryUtil.list,new BeanPropertyRowMapper<ContainerStatusBean>(ContainerStatusBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getContainerStatusFormList", e);
		}

		return list;
	}

	@Override
	public ContainerStatusBean insert(ContainerStatusBean containerStatus, String userId) throws Exception {
		Boolean isSuccess = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {						
			int i=jdbcTemplate.update(ContainerStatusQueryUtil.INSERT,containerStatus.getContainerStatusCode(),containerStatus.getContainerStatusDescription(),containerStatus.isDepot(),containerStatus.isCustomer(),containerStatus.isShipper(),
					containerStatus.isConsignee(),containerStatus.isVessel(),containerStatus.isVoyage(),containerStatus.isPol(),containerStatus.isPod(),containerStatus.getSubCode(),containerStatus.getSubCodeDesc(),userId);
			
			 if(i>0) {
	            	isSuccess = true;
					containerStatus.setIsSuccess(isSuccess);
	            }
			}catch (DataAccessException e) {
				e.printStackTrace();
				isSuccess = false;
				containerStatus.setIsSuccess(isSuccess);
				LOGGER.error("Error in save", e);
				containerStatus.setMessage("Error in save :" + e.getMessage());
			}
		return containerStatus;
		}

	@Override
	public ContainerStatusBean delete(String containerStatusCode) {
		ContainerStatusBean containerStatusbean =new ContainerStatusBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		Boolean isSuccess = false;
		try {
			int i= jdbcTemplate.update(ContainerStatusQueryUtil.delete, containerStatusCode);
			isSuccess = true;
			containerStatusbean.setIsSuccess(isSuccess);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			containerStatusbean.setIsSuccess(isSuccess);
			containerStatusbean.setMessage("Error in Delete :" + e.getMessage());
			LOGGER.error("Error in delete", e);
		}

		return containerStatusbean;

	}

	@Override
	public ContainerStatusBean getContainerStatusEdit(String containerStatusCode) {
		ContainerStatusBean containerStatusbean =new ContainerStatusBean();
		try {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			containerStatusbean = jdbcTemplate.queryForObject(ContainerStatusQueryUtil.GET_Edit,
					new Object[] { containerStatusCode },
					new BeanPropertyRowMapper<ContainerStatusBean>(ContainerStatusBean.class));

		}catch (DataAccessException e) {
			LOGGER.error("Error in edit", e);
			
		}
		return containerStatusbean;
	}

	@Override
	public ContainerStatusBean update(ContainerStatusBean containerStatus) throws Exception {
		Boolean isSuccess = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			int i=jdbcTemplate.update(ContainerStatusQueryUtil.UPDATE,containerStatus.getContainerStatusDescription(),containerStatus.isDepot(),containerStatus.isCustomer(),containerStatus.isShipper(),
					containerStatus.isConsignee(),containerStatus.isVessel(),containerStatus.isVoyage(),containerStatus.isPol(),containerStatus.isPod(),containerStatus.getSubCode(),containerStatus.getSubCodeDesc(),containerStatus.getContainerStatusCode());

		
		if(i>0) {
        	isSuccess = true;
			containerStatus.setIsSuccess(isSuccess);
			
        }
		}
	catch (DataAccessException e) {
		e.printStackTrace();
		isSuccess = false;
		containerStatus.setIsSuccess(isSuccess);
		containerStatus.setMessage("Error in Update :" + e.getMessage());
		LOGGER.error("Error in update", e);
	}	
		return containerStatus;
	}

}