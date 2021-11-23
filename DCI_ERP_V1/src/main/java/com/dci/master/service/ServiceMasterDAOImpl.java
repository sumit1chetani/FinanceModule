package com.dci.master.service;

import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;


@Repository
public class ServiceMasterDAOImpl implements ServiceMasterDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ServiceMasterDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@SuppressWarnings("deprecation")
	@Override
	public List<ServiceMasterBean> getServiceMasterList(int limit, int offset) {
		List<ServiceMasterBean> lServiceMasterBean = new ArrayList<>();

		try {

			lServiceMasterBean = jdbcTemplate.query(ServiceMasterQueryUtil.sViewServiceMasterDetails, new BeanPropertyRowMapper<>(
					ServiceMasterBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getVesselSectorList", e);
			// throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return lServiceMasterBean;
	}

	@Override
	public ServiceMasterResultBean getCompanyLocation() {

		ServiceMasterResultBean objResultBean = new ServiceMasterResultBean();
		List<ServiceMasterBean> objCompanyLst = new ArrayList<>();
		List<ServiceMasterBean> objBranchInfo = new ArrayList<>();
		List<ServiceMasterTableDetail> objPortTransmit = new ArrayList<>();
		try {
			objCompanyLst = jdbcTemplate.query(ServiceMasterQueryUtil.sCompanyLocationDropDown, new BeanPropertyRowMapper<>(
					ServiceMasterBean.class));
			objResultBean.setObjCompanyInfo(objCompanyLst);
			
			objBranchInfo = jdbcTemplate.query(ServiceMasterQueryUtil.sBranchDropDown, new BeanPropertyRowMapper<>(
					ServiceMasterBean.class));
			objResultBean.setObjBranchInfo(objBranchInfo);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSector", e);
		}

		try {
			objPortTransmit = jdbcTemplate.query(ServiceMasterQueryUtil.sPortDropDown, new BeanPropertyRowMapper<>(
					ServiceMasterTableDetail.class));
			objResultBean.setObjPortTransmitInfo(objPortTransmit);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSector", e);
		}

		return objResultBean;
	}

	@Override
	public ServiceMasterResultBean getportforEdit(String sectorCode) {

		ServiceMasterResultBean objResultBean = new ServiceMasterResultBean();
		List<ServiceMasterTableDetail> objPortTransmit = new ArrayList<>();
				try {
			objPortTransmit = jdbcTemplate.query(ServiceMasterQueryUtil.sPortDropDownforEdit, new Object[] { sectorCode }, new BeanPropertyRowMapper<>(
					ServiceMasterTableDetail.class));
			objResultBean.setObjPortTransmitInfo(objPortTransmit);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getSector", e);
		}

		return objResultBean;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ServiceMasterBean addServiceMaster(ServiceMasterResultBean objServiceMasterResultBean,String userId) throws Exception {
		ServiceMasterBean res = new ServiceMasterBean();
		// TODO Auto-generated method stub
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSuccess = false;
		List<ServiceMasterTableDetail> objDetailData = objServiceMasterResultBean.getObjPortTransmitInfo();
		ServiceMasterBean objHeaderData = objServiceMasterResultBean.getCompanyInfoHeader();
		String sectorCode = objHeaderData.getSectorCode().trim().toUpperCase();
		String commenceDate = objHeaderData.getCommenceDate();
		String completionDate = objHeaderData.getCompletionDate();
		
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Timestamp timeStampDate2 = null;
		java.sql.Timestamp timeStampDate3=null;
		
		try {
			
			
			String message = "";
			Map<String, Object> hashMap = new HashMap<>();

			hashMap.put("sectorCode", objHeaderData.getSectorCode().trim().toUpperCase());
			hashMap.put("sectorName", objHeaderData.getSectorName().trim().toUpperCase());
			hashMap.put("sectorSlnoNumber", generateSerialNumber());
			hashMap.put("operationSince", objHeaderData.getOperationSince());
			hashMap.put("eqmtCntrlEnable", objHeaderData.getEqmtCntrlEnable());
			hashMap.put("createdBy", userId);
			hashMap.put("isActive", objHeaderData.getIsActive());
			hashMap.put("timeStampcommenceDate", timeStampDate2);
			hashMap.put("timeStampcompletionDate", timeStampDate3);
			hashMap.put("companyCode", objHeaderData.getCompanyCode());
			hashMap.put("vesselOperator", objHeaderData.getVesselOperator());
			hashMap.put("avgtrans", objHeaderData.getAvgtrans());
			hashMap.put("sailingfreq", objHeaderData.getSailingfreq());

			int i = jdbcTemplate.queryForObject(ServiceMasterQueryUtil.sCheckServiceCodeAdd,Integer.class, new Object[] { objHeaderData.getSectorCode().trim().toUpperCase(),objHeaderData.getSectorName().trim().toUpperCase() });

			if (i == 0) {

				namedParameterJdbcTemplate.update(ServiceMasterQueryUtil.sAddServiceMaster, hashMap);
				UserLog userLog = userlogDao.userLogForInsert(objHeaderData, objHeaderData.getSectorCode().trim().toUpperCase(), userDetails.getUserId());
				auditLogDao.auditLogForInsert(objHeaderData, userLog, null);
				isSuccess = true;
			}else{
				message ="Service code / name already exists";
			}
	
			res.setSuccess(isSuccess);
			res.setMessage(message);

		
		}catch (DataAccessException e) {
			LOGGER.error("Error in addServiceMaster", e);
			throw new CustomException(ServiceMasterMsgUtil.ERROR_LIST);
		}

		try {
			
		
		}catch (DataAccessException e) {
			e.printStackTrace();
			LOGGER.error("Error in addServiceMasterDetail", e);
			throw new CustomException(ServiceMasterMsgUtil.ERROR_LIST);
		}

		return res;
	}

	public int generateSerialNumber() throws CustomException {
		int serialNumber;

		try {

			Map slNumber = jdbcTemplate.queryForMap(ServiceMasterQueryUtil.sGetSerialNo);

			serialNumber = Integer.parseInt(slNumber.get("sectorSlnoNumber").toString());

		} catch (DataAccessException e) {
			LOGGER.error("Error in Service Master", e);
			throw new CustomException(ServiceMasterMsgUtil.ERROR_LIST);
		}

		return serialNumber;
	}

	@Override
	public ServiceMasterResultBean editServiceMaster(String sectorCode) throws Exception {
		ServiceMasterResultBean objServiceMasterResultBean = new ServiceMasterResultBean();
		List<ServiceMasterTableDetail> objDetailData = new ArrayList<>();
		ServiceMasterBean objHeaderData = new ServiceMasterBean();
		try {

			int[] types = new int[] { Types.VARCHAR };
			Object[] params = new Object[] { sectorCode };
			Map row = jdbcTemplate.queryForMap(ServiceMasterQueryUtil.sEditServiceMaster, params, types);

			objHeaderData.setSectorCode((String) row.get("sectorCode"));
			objHeaderData.setSectorName((String) row.get("sectorName"));
			objHeaderData.setSectorSlnoNumber((long) row.get("sectorSlnoNumber"));
			objHeaderData.setOperationSince((String) row.get("operationSince"));
			objHeaderData.setEqmtCntrlEnable((String) row.get("eqmtCntrlEnable"));
			objHeaderData.setIsActive((String) row.get("isActive"));
			objHeaderData.setCommenceDate((String) row.get("commenceDate"));
			objHeaderData.setCompletionDate((String) row.get("completionDate"));
			objHeaderData.setCompanyCode((String) row.get("companyCode"));
			objHeaderData.setVesselOperator((String) row.get("vesselOperator"));
			objHeaderData.setAvgtrans((Double) row.get("avgtrans"));
			objHeaderData.setSailingfreq((Double) row.get("sailingfreq"));
			objHeaderData.setVendorName((String) row.get("vendorName"));
			
			objHeaderData.setModifiedBy((String) row.get("modifiedBy"));
			objHeaderData.setCreatedDate((String) row.get("createdDate"));
			objHeaderData.setModifiedDate((String) row.get("modifiedDate"));
			objHeaderData.setCreatedBy((String) row.get("createdBy"));
			//objHeaderData.setBranchName((String) row.get("branchName"));

			// detail
			 //objDetailData = jdbcTemplate.query(ServiceMasterQueryUtil.sEditServiceMasterDetail, params,new BeanPropertyRowMapper<>(ServiceMasterTableDetail.class));
			objHeaderData.setisEdit(true);
			objServiceMasterResultBean.setObjPortTransmitInfo(objDetailData);
			objServiceMasterResultBean.setCompanyInfoHeader(objHeaderData);
		} catch (DataAccessException e) {
			LOGGER.error("Error in EDIT Port", e);
			throw new CustomException("Error in EDIT Port");
		}

		return objServiceMasterResultBean;
	}
	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	@Override
	public ServiceMasterBean updateServiceMaster(ServiceMasterResultBean objServiceMasterResultBean,String userId) throws CustomException, Exception {
		ServiceMasterBean result = new ServiceMasterBean();
		// TODO Auto-generated method stub
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isSuccess = false;
		String message = "";
		List<ServiceMasterTableDetail> objDetailData = objServiceMasterResultBean.getObjPortTransmitInfo();
		ServiceMasterBean objHeaderData = objServiceMasterResultBean.getCompanyInfoHeader();
		
		String sectorCode = objHeaderData.getSectorCode().trim().toUpperCase();
		ServiceMasterResultBean oldService = editServiceMaster(sectorCode);
		ServiceMasterBean oldHeader = oldService.getCompanyInfoHeader();
		List<ServiceMasterTableDetail> oldDetail = oldService.getObjPortTransmitInfo();
		String commenceDate = objHeaderData.getCommenceDate();
		String completionDate = objHeaderData.getCompletionDate();
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Timestamp timeStampDate2 = null;
		java.sql.Timestamp timeStampDate3=null;
		

		try {

			
			Map<String, Object> hashMap = new HashMap<>();

			hashMap.put("sectorCode", objHeaderData.getSectorCode().trim().toUpperCase());
			hashMap.put("sectorName", objHeaderData.getSectorName().trim().toUpperCase());
			hashMap.put("sectorSlnoNumber", generateSerialNumber());
			hashMap.put("operationSince", objHeaderData.getOperationSince());
			hashMap.put("eqmtCntrlEnable", objHeaderData.getEqmtCntrlEnable());
			hashMap.put("modifiedBy", userId);
			hashMap.put("isActive", objHeaderData.getIsActive());
			hashMap.put("timeStampcommenceDate", timeStampDate2);
			hashMap.put("timeStampcompletionDate", timeStampDate3);
			hashMap.put("companyCode", objHeaderData.getCompanyCode());
			hashMap.put("vesselOperator", objHeaderData.getVesselOperator());
			hashMap.put("avgtrans", objHeaderData.getAvgtrans());
			hashMap.put("sailingfreq", objHeaderData.getSailingfreq());
		

			int i = jdbcTemplate.queryForObject(ServiceMasterQueryUtil.sCheckServiceCodeUpdate,Integer.class,
					new Object[] { objHeaderData.getSectorCode().trim().toUpperCase(),objHeaderData.getSectorName().trim().toUpperCase() });

			if (i == 0) {

				namedParameterJdbcTemplate.update(ServiceMasterQueryUtil.sUpdateServiceMaster, hashMap);
				UserLog userLog = userlogDao.userLogForUpdate(oldHeader, objHeaderData, sectorCode, userDetails.getUserId());
				auditLogDao.auditLogForUpdate(oldHeader, objHeaderData, userLog, null);
				isSuccess = true;
				result.setSuccess(isSuccess);
				
			}else{
				message ="Service name already exists";
				isSuccess = false;
				result.setSuccess(isSuccess);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in addServiceMaster", e);
			throw new CustomException(ServiceMasterMsgUtil.ERROR_LIST);
		}
	

		return result;
	}

	@Override
	public boolean deleteServiceMaster(String sectorCode) throws CustomException, Exception {
		boolean isDeleted = false;
		ServiceMasterResultBean oldService = editServiceMaster(sectorCode);
		ServiceMasterBean oldHeader = oldService.getCompanyInfoHeader();
		List<ServiceMasterTableDetail> oldDetail = oldService.getObjPortTransmitInfo();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			int id = jdbcTemplate.queryForObject(ServiceMasterQueryUtil.CHECK_FOREIGN_KEY,new Object[]{sectorCode,sectorCode}, Integer.class);
			if(id==0){
			
			int rowServiceDetail = jdbcTemplate.update(ServiceMasterQueryUtil.sDeleteServiceMasterDetail, sectorCode);
			int rowServiceHeader = jdbcTemplate.update(ServiceMasterQueryUtil.sDeleteServiceMaster, sectorCode);
			UserLog userLog = userlogDao.userLogForDelete(oldHeader, sectorCode, userDetails.getUserId());
			auditLogDao.auditLogForDelete(oldHeader, userLog, null);
			for (int i = 0; i < oldDetail.size(); i++) {
				UserLog userLog1 = userlogDao.userLogForDelete(oldDetail.get(i), sectorCode, userDetails.getUserId());
				auditLogDao.auditLogForDelete(oldHeader, userLog1, null);
			}
			
			isDeleted = true;
			
			}
			
		} catch (DataAccessException e) {
			LOGGER.error("Error in Delete ServiceMaster", e);
			throw new CustomException(ServiceMasterMsgUtil.ERROR_DELETE_SERVICE);
		}

		return isDeleted;
	}

	@Override
	public List getService() throws Exception {
		List lServiceMasterBean = new ArrayList();
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ServiceMasterQueryUtil.sServiceDropDown);

			for (Map row : rows) {
				ServiceMasterBean bean = new ServiceMasterBean();
				bean.setSectorCode((String) row.get("sectorCode"));
				bean.setSectorName((String) row.get("sectorName"));
				lServiceMasterBean.add(bean);
			}
			

		} catch (DataAccessException e) {
			LOGGER.error("Error in getPort", e);
		}
		return lServiceMasterBean;
	}

}