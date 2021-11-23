package com.dci.master.vesselMaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")
public class VesselMasterDAOImpl  implements VesselMasterDAO {
	private final static Logger LOGGER = Logger.getLogger(VesselMasterDAOImpl.class);
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	
	@Override
	public List<VesselMasterBean> getVesselList() {

		List<VesselMasterBean> list = new ArrayList<VesselMasterBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(VesselMasterQueryUtil.list,new BeanPropertyRowMapper<VesselMasterBean>(VesselMasterBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getVesselList", e);
		}

		return list;
	}
	
	@Override
	public VesselMasterBean insert(VesselMasterBean vessel) throws Exception {
		// TODO Auto-generated method stub
		Boolean isSuccess = false;
		VesselMasterBean vesselBean = new VesselMasterBean();
//		String VesselId="";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			
//			String vesselcode="";
//			
//			
//			vesselcode = jdbcTemplate.queryForObject(VesselQueryUtil.GENERATE_VESSEL_CODE, new Object[] { "V","V" },
//					String.class);
//			vesselcode = "V" + vesselcode;
//			 VesselId=UUID.randomUUID().toString();
//			
			String vesl=vessel.getVesselCode().toUpperCase();
			String vessl=vessel.getVesselName().toUpperCase();
            int i= 	jdbcTemplate.update(VesselMasterQueryUtil.INSERT,vesl,vessl, vessel.getGrossTonnage(),vessel.getNetTonnage(),vessel.getCallSign(),
					vessel.getMainLineService(),vessel.getVesselOwner(),vessel.getVesselFlag(),userDetails.getUserId());
			 if(i>0) {
	            	isSuccess = true;
	            	vesselBean.setIsSuccess(isSuccess);
	            	UserLog userLog = userlogDao.userLogForInsert(vessel, vessel.getVesselCode(), userDetails.getUserId());
					auditLogDao.auditLogForInsert(vessel, userLog, null);
	            	System.out.println("Vessel Master Inserted Successfully");
	            }
		}catch (DataAccessException e) {
			LOGGER.error("Error in insert", e);
			e.printStackTrace();
			isSuccess = false;
			vesselBean.setIsSuccess(isSuccess);
			vesselBean.setMessage("Error in save :" + e.getMessage());
		}
		return vesselBean;
	}
	
	@Override
	public VesselMasterBean delete(Integer vesselID) throws CustomException  {
		boolean isDeleted = false;
		Boolean isSuccess = false;
		VesselMasterBean vesselBean = new VesselMasterBean();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			VesselMasterBean oldbean = getVesselEdit(vesselID); 
			jdbcTemplate.update(VesselMasterQueryUtil.delete, vesselID);
			isSuccess = true;
			vesselBean.setIsSuccess(isSuccess);
			UserLog userLog = userlogDao.userLogForDelete(oldbean, oldbean.getVesselCode(), userDetails.getUserId());
			auditLogDao.auditLogForDelete(oldbean, userLog, null);
		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			vesselBean.setIsSuccess(isSuccess);	
			LOGGER.error("Error in delete", e);
		}
		return vesselBean;
	}

	@Override
	public VesselMasterBean getVesselEdit(Integer vesselID) {
		VesselMasterBean damagebean =new VesselMasterBean();
		Boolean isEdit = false;
		try {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			damagebean = jdbcTemplate.queryForObject(VesselMasterQueryUtil.GET_VESSEL,
					new Object[] { vesselID },
					new BeanPropertyRowMapper<VesselMasterBean>(VesselMasterBean.class));
			damagebean.setIsEdit(true);
		}catch (DataAccessException e) {
			LOGGER.error("Error in getVesselEdit", e);
		}
		return damagebean;
	}

	@Override
	public VesselMasterBean update(VesselMasterBean vessel) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Boolean isSuccess = false;
		VesselMasterBean vesselBean = new VesselMasterBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			VesselMasterBean oldbean = getVesselEdit(vessel.getVesselID()); 
			
		int i =	jdbcTemplate.update(VesselMasterQueryUtil.UPDATE, vessel.getVesselCode(),vessel.getVesselName(),vessel.getGrossTonnage(),vessel.getNetTonnage(),vessel.getVesselFlag(),vessel.getMainLineService(),vessel.getVesselOwner(),vessel.getCallSign(),
				userDetails.getUserId(),vessel.getVesselID());
		if(i>0) {
        	isSuccess = true;
        	vesselBean.setIsSuccess(isSuccess);
        	
        	UserLog userLog = userlogDao.userLogForUpdate(oldbean, vessel, vessel.getVesselCode(), userDetails.getUserId());
			auditLogDao.auditLogForUpdate(oldbean, vessel, userLog, null);
        }
		}catch (DataAccessException e) {
			LOGGER.error("Error in update", e);
			e.printStackTrace();
			isSuccess = false;
			vesselBean.setIsSuccess(isSuccess);
			vesselBean.setMessage("Error in save :" + e.getMessage());
		}
		return vesselBean;
	}
	@Override
	public List<VesselMasterBean> getDropDown() {
		
		List <VesselMasterBean> nationalityList = new ArrayList();
		VesselMasterBean ddbean = null;
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(VesselMasterQueryUtil.getLineList);

			for (Map<String, Object> row : rows) {
				ddbean = new VesselMasterBean();
				ddbean.setId(row.get("id").toString());
				ddbean.setText(row.get("text").toString());
				nationalityList.add(ddbean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getDropDown", e);
		}
		return nationalityList;
	}


}
