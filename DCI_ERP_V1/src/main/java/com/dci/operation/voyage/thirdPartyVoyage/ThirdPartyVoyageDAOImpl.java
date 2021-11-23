package com.dci.operation.voyage.thirdPartyVoyage;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CommonExcelUtils;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

@Repository
@Transactional
public class ThirdPartyVoyageDAOImpl implements ThirdPartyVoyageDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;
	
	@Autowired
	DataSource dataSource;

	private final static Logger LOGGER = LoggerFactory.getLogger(ThirdPartyVoyageDAOImpl.class);

	@Override
	public List<ThirdPartyVoyageBean> getVoyageList(ThirdPartyVoyageBean thirdPartyVoyageBean, String userId) throws Exception {
		List<ThirdPartyVoyageBean> voyageList = new ArrayList<>();
		String sql = "";
		try {
			sql = ThirdPartyVoyageQueryUtil.GET_VOYAGE_LIST;
			if (thirdPartyVoyageBean.getVesselCode() != null && !thirdPartyVoyageBean.getVesselCode().isEmpty()) {
				sql += "  and v.vessel_id ='" + thirdPartyVoyageBean.getVesselCode() + "' order by v.voyage_id";
			}
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			for (Map<String, Object> row : rows) {
				if (row.get("voyageId") != null) {
					ThirdPartyVoyageBean ThirdPartyVoyageBean = new ThirdPartyVoyageBean();
					ThirdPartyVoyageBean.setText(row.get("voyageId").toString());
					ThirdPartyVoyageBean.setId(row.get("voyageId").toString());
					voyageList.add(ThirdPartyVoyageBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voyageList;
	}

	@Override
	public List<ThirdPartyVoyageBean> getThirdPartyVoyageList(ThirdPartyVoyageBean thirdPartyVoyageBean, String formCode, String userId)
			throws Exception {
		List<ThirdPartyVoyageBean> thirdPartyVoyageList = new ArrayList<>();
		String query = "";
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int i = 0;
		try {
			String voyage = "";
			if(thirdPartyVoyageBean.getVoyageIdnew().size() > 0) {
			for(String voyageNew:thirdPartyVoyageBean.getVoyageIdnew()) {
				int size = thirdPartyVoyageBean.getVoyageIdnew().size();
				i++;
				if(i == size ) {
					voyage +=  "'"+voyageNew+"'";

				}
				else
				voyage +=   "'"+voyageNew+"'"+",";
			}
			}
			
			if(userDetails.getCompanyCode().equalsIgnoreCase("C0001")){
			query = ThirdPartyVoyageQueryUtil.GET_THIRD_PARTY_VOYAGE_LIST;
			if (thirdPartyVoyageBean.getVesselCode() != null && !thirdPartyVoyageBean.getVesselCode().isEmpty()) {
				query += " and v.vessel_id='" + thirdPartyVoyageBean.getVesselCode() + "'";
			}
			if (thirdPartyVoyageBean.getVoyageIdnew() != null && !thirdPartyVoyageBean.getVoyageIdnew().isEmpty()) {
				query += " and v.voyage_id in (" + voyage + ")";
			}
			if (thirdPartyVoyageBean.getActivityCode() != null && !thirdPartyVoyageBean.getActivityCode().isEmpty()) {
				query += " and v.activity_code='" + thirdPartyVoyageBean.getActivityCode() + "'";
			}
			if (thirdPartyVoyageBean.getSectorId() != null && !thirdPartyVoyageBean.getSectorId().isEmpty()) {
				query += " and v.sector_id='" + thirdPartyVoyageBean.getSectorId() + "'";
			}
			if (thirdPartyVoyageBean.getSectorId() != null && !thirdPartyVoyageBean.getSectorId().isEmpty()) {
				query += " and v.sector_id='" + thirdPartyVoyageBean.getSectorId() + "'";
			}
			if (thirdPartyVoyageBean.getVesselOperator() != null && !thirdPartyVoyageBean.getVesselOperator().isEmpty()) {
				query += " and v.vessel_optr='" + thirdPartyVoyageBean.getVesselOperator() + "'";
			}
			if (thirdPartyVoyageBean.getFromDate() != null && !thirdPartyVoyageBean.getFromDate().isEmpty()) {
				query += " and v.created_date::date >= to_date('" + thirdPartyVoyageBean.getFromDate() + "','dd/mm/yyyy')";
			}
			if (thirdPartyVoyageBean.getToDate() != null && !thirdPartyVoyageBean.getToDate().isEmpty()) {
				query += " and v.created_date::date <= to_date('" + thirdPartyVoyageBean.getToDate() + "','dd/mm/yyyy')";
			}
			query+=" order by v.created_date desc";
			thirdPartyVoyageList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ThirdPartyVoyageBean.class));
			}
			else if(userDetails.getCompanyCode().equalsIgnoreCase("C0028")){/*
				query = ThirdPartyVoyageQueryUtil.GET_THIRD_PARTY_VOYAGE_LIST_SINGAPORE;
				if (thirdPartyVoyageBean.getVesselCode() != null && !thirdPartyVoyageBean.getVesselCode().isEmpty()) {
					query += " and v.vessel_id='" + thirdPartyVoyageBean.getVesselCode() + "'";
				}
				if (thirdPartyVoyageBean.getVoyageId() != null && !thirdPartyVoyageBean.getVoyageId().isEmpty()) {
					query += " and v.voyage_id='" + thirdPartyVoyageBean.getVoyageId() + "'";
				}
				if (thirdPartyVoyageBean.getActivityCode() != null && !thirdPartyVoyageBean.getActivityCode().isEmpty()) {
					query += " and v.activity_code='" + thirdPartyVoyageBean.getActivityCode() + "'";
				}
				query+=" order by v.created_date desc";
				thirdPartyVoyageList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ThirdPartyVoyageBean.class), formCode,
						userId);
			*/}
			else if(userDetails.getCompanyCode().equalsIgnoreCase("C0029")){/*
				query = ThirdPartyVoyageQueryUtil.GET_THIRD_PARTY_VOYAGE_LIST_MY;
				if (thirdPartyVoyageBean.getVesselCode() != null && !thirdPartyVoyageBean.getVesselCode().isEmpty()) {
					query += " and v.vessel_id='" + thirdPartyVoyageBean.getVesselCode() + "'";
				}
				if (thirdPartyVoyageBean.getVoyageId() != null && !thirdPartyVoyageBean.getVoyageId().isEmpty()) {
					query += " and v.voyage_id='" + thirdPartyVoyageBean.getVoyageId() + "'";
				}
				if (thirdPartyVoyageBean.getActivityCode() != null && !thirdPartyVoyageBean.getActivityCode().isEmpty()) {
					query += " and v.activity_code='" + thirdPartyVoyageBean.getActivityCode() + "'";
				}
				query+=" order by v.created_date desc";
				thirdPartyVoyageList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ThirdPartyVoyageBean.class), formCode,
						userId);
			*/}
		} catch (Exception e) {
			LOGGER.error("Error", e);
 		}
		return thirdPartyVoyageList;
	}

	@Override
	public List<ThirdPartyVoyageBean> getVesselList(String formCode, String userId) throws Exception {
		List<ThirdPartyVoyageBean> voyageList = new ArrayList<>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			if(userDetails.getCompanyCode().equalsIgnoreCase("C0001")){

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.GET_VESSEL_LIST);
			for (Map<String, Object> row : rows) {
				ThirdPartyVoyageBean ThirdPartyVoyageBean = new ThirdPartyVoyageBean();
				if (row.get("vesselcode") != null && row.get("vessel_name") != null) {
					ThirdPartyVoyageBean.setId(row.get("vesselcode").toString());
					ThirdPartyVoyageBean.setText(row.get("vessel_name").toString());
				}
				if (row.get("vessel_speed") != null)
					ThirdPartyVoyageBean.setSpeed(row.get("vessel_speed").toString());
				voyageList.add(ThirdPartyVoyageBean);
			}
			}
			else if(userDetails.getCompanyCode().equalsIgnoreCase("C0028")){/*
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.GET_VESSEL_LIST_SINGAPORE, new Object[] { formCode, userId , formCode, userId });
				for (Map<String, Object> row : rows) {
					ThirdPartyVoyageBean ThirdPartyVoyageBean = new ThirdPartyVoyageBean();
					if (row.get("vessel_code") != null && row.get("vessel_name") != null) {
						ThirdPartyVoyageBean.setId(row.get("vessel_code").toString());
						ThirdPartyVoyageBean.setText(row.get("vessel_name").toString());
					}
					if (row.get("vessel_speed") != null)
						ThirdPartyVoyageBean.setSpeed(row.get("vessel_speed").toString());
					voyageList.add(ThirdPartyVoyageBean);
				}
			*/}else if(userDetails.getCompanyCode().equalsIgnoreCase("C0029")){/*
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.GET_VESSEL_LIST_MY, new Object[] { formCode, userId , formCode, userId });
				for (Map<String, Object> row : rows) {
					ThirdPartyVoyageBean ThirdPartyVoyageBean = new ThirdPartyVoyageBean();
					if (row.get("vessel_code") != null && row.get("vessel_name") != null) {
						ThirdPartyVoyageBean.setId(row.get("vessel_code").toString());
						ThirdPartyVoyageBean.setText(row.get("vessel_name").toString());
					}
					if (row.get("vessel_speed") != null)
						ThirdPartyVoyageBean.setSpeed(row.get("vessel_speed").toString());
					voyageList.add(ThirdPartyVoyageBean);
				}
			*/}
		

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return voyageList;
	}

	@Override
	public List<ThirdPartyVoyageBean> getActivityTypes() throws Exception {
		List<ThirdPartyVoyageBean> activityTypes = new ArrayList<>();
		try {
			/*List<Map<String, Object>> rows = jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.GET_ACTIVITY_TYPES);
			for (Map<String, Object> row : rows) {
				ThirdPartyVoyageBean ThirdPartyVoyageBean = new ThirdPartyVoyageBean();
				if (row.get("activity_code") != null)
					ThirdPartyVoyageBean.setId(row.get("activity_code").toString());
				if (row.get("activity_name") != null)
					ThirdPartyVoyageBean.setText(row.get("activity_name").toString());
				activityTypes.add(ThirdPartyVoyageBean);
			}*/
		} catch (Exception e) {
 			throw new CustomException();
		}
		return activityTypes;
	}

	@Override
	public List<ThirdPartyVoyageBean> getServiceList(ThirdPartyVoyageBean ThirdPartyVoyageBean, String companyCode) throws Exception {
		List<ThirdPartyVoyageBean> serviceList = new ArrayList<>();
		try {
			if (ThirdPartyVoyageBean.getVesselCode() != null) {
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.GET_SERVICE_LIST);
				for (Map<String, Object> row : rows) {
					ThirdPartyVoyageBean objThirdPartyVoyageBean = new ThirdPartyVoyageBean();
					if (row.get("sector_code") != null)
						objThirdPartyVoyageBean.setId(row.get("sector_code").toString());
					if (row.get("sector_name") != null)
						objThirdPartyVoyageBean.setText(row.get("sector_name").toString());
					System.out.println("sector :" + row.get("sector_code").toString());
					serviceList.add(objThirdPartyVoyageBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceList;
	}

	@Override
	public List<ThirdPartyVoyagePortBean> getPortList(ThirdPartyVoyageBean ThirdPartyVoyageBean) throws Exception {
		List<ThirdPartyVoyagePortBean> portList = new ArrayList<>();
		
		String sectorId = "";int seq=1;
		if (ThirdPartyVoyageBean.getSectorId() != null) {
			sectorId = ThirdPartyVoyageBean.getSectorId();
		}
		try {
//			if(sectorId.equalsIgnoreCase("ADHOC-SIN")){
			if(sectorId.matches("ADHOC-SIN|ADHOC AGI|ADHOCFME|ADHOCCISC")){	
				List<Map<String, Object>> portRows=jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.SELECT_PORT_MASTER);
				for(Map<String, Object> row:portRows){
					ThirdPartyVoyagePortBean voyagePortBean = new ThirdPartyVoyagePortBean();
					voyagePortBean.setFromPort(row.get("fromPort").toString());
					if(seq>1){
						voyagePortBean.setToPort(row.get("fromPort").toString());
					}
					voyagePortBean.setPortSequence(seq);
					seq++;
					portList.add(voyagePortBean);
				}
			}else{
				List<Map<String, Object>> portRow = jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.GET_PORT_LIST, sectorId);
				for (Map<String, Object> row : portRow) {
					ThirdPartyVoyagePortBean voyaggePortBean = new ThirdPartyVoyagePortBean();
					if (row.get("PORT_ID") != null)
						voyaggePortBean.setFromPort(row.get("PORT_ID").toString());
					if (row.get("to_port") != null)
						voyaggePortBean.setToPort(row.get("to_port").toString());
					if (row.get("distance") != null) {
						voyaggePortBean.setDistance(row.get("distance").toString());
					} else {
						voyaggePortBean.setDistance("0");
					}
					if (row.get("SL_NO") != null)
						voyaggePortBean.setPortSequence(Integer.parseInt(row.get("SL_NO").toString()));
					
					voyaggePortBean.setBerthingHour(CommonExcelUtils.checkEmptyString(String.valueOf(row.get("berth_hour"))));
					voyaggePortBean.setBerthingMin(CommonExcelUtils.checkEmptyString(String.valueOf(row.get("berth_min"))));
					voyaggePortBean.setPortStayHour(CommonExcelUtils.checkEmptyString(String.valueOf(row.get("port_stay_hour"))));
					voyaggePortBean.setPortStayMin(CommonExcelUtils.checkEmptyString(String.valueOf(row.get("port_stay_min"))));
					voyaggePortBean.setSpeed(Math.round((int)CommonExcelUtils.convertStringToDouble(String.valueOf(row.get("speed")))));
					if (!voyaggePortBean.getDistance().isEmpty() && voyaggePortBean.getDistance() != null)
						voyaggePortBean.setDistance(Math.round(Float.parseFloat(voyaggePortBean.getDistance())) + "");
					
					portList.add(voyaggePortBean);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return portList;
	}

	@Override
	public String getDistance(String fromPort, String toPort) throws Exception {
		String distance = "0";
		try {
			Map dist = jdbcTemplate.queryForMap(ThirdPartyVoyageQueryUtil.GET_DISTANCE, fromPort, toPort);
			if (dist.get("distance") != null)
				distance = dist.get("distance").toString();
		} catch (Exception e) {

		}
		return distance;
	}

	private String prevVoyage(String vessel, String sector) {

		String prevoyage = "";
		try {
			if (vessel.indexOf("-") != -1) {
				vessel = vessel.replace("-", "");
			}
			prevoyage = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_PRE_VOYAGE, new Object[] { vessel, sector }, String.class);

		} catch (Exception e) {

		}
		return prevoyage;

	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ThirdPartyVoyagePortBean> getVoyageDtlList(ThirdPartyVoyageBean thirdPartyVoyageBean, List<ThirdPartyVoyagePortBean> portList)
			throws Exception {
		List<ThirdPartyVoyagePortBean> voyageDtlList = new ArrayList<>();
		int rowIndex = 1;
		int speed = 14;
		try {
			/*
			 * speed = jdbcTemplate.queryForInt(ThirdPartyVoyageQueryUtil.
			 * GET_SPEED_FOR_VESSEL, thirdPartyVoyageBean.getVesselCode());
			 */
			for (ThirdPartyVoyagePortBean thirdPartyVoyagePortBean : portList) {
				thirdPartyVoyagePortBean.setVesselCode(thirdPartyVoyageBean.getVesselCode1().concat("-"));
				thirdPartyVoyagePortBean.setBerthingHour(CommonExcelUtils.checkEmptyString(thirdPartyVoyagePortBean.getBerthingHour()).equals("") ? "2" : thirdPartyVoyagePortBean.getBerthingHour());
				thirdPartyVoyagePortBean.setBerthingMin(CommonExcelUtils.checkEmptyString(thirdPartyVoyagePortBean.getBerthingMin()).equals("") ? "0" : thirdPartyVoyagePortBean.getBerthingMin());
				thirdPartyVoyagePortBean.setPortStayHour(CommonExcelUtils.checkEmptyString(thirdPartyVoyagePortBean.getPortStayHour()).equals("") ? "2" : thirdPartyVoyagePortBean.getPortStayHour());
				thirdPartyVoyagePortBean.setPortStayMin(CommonExcelUtils.checkEmptyString(thirdPartyVoyagePortBean.getPortStayMin()).equals("") ? "0" : thirdPartyVoyagePortBean.getPortStayMin());
//				thirdPartyVoyagePortBean.setPortStayContHour("2");
				thirdPartyVoyagePortBean.setSpeed(thirdPartyVoyagePortBean.getSpeed() == 0  ? speed :thirdPartyVoyagePortBean.getSpeed());
				if (!thirdPartyVoyagePortBean.getDistance().isEmpty() && thirdPartyVoyagePortBean.getDistance() != null)
					thirdPartyVoyagePortBean.setDistance(Math.round(Float.parseFloat(thirdPartyVoyagePortBean.getDistance())) + "");
				if (speed != 0) {
					thirdPartyVoyagePortBean.setSteamingHour("=QUOTIENT(L" + rowIndex + ",M" + rowIndex + ")");
					thirdPartyVoyagePortBean.setSteamingMin("=MOD(L" + rowIndex + ",M" + rowIndex + ")");
//					thirdPartyVoyagePortBean.setSteamingHour("=QUOTIENT(M" + rowIndex + ",N" + rowIndex + ")");
//					thirdPartyVoyagePortBean.setSteamingMin("=MOD(M" + rowIndex + ",N" + rowIndex + ")");
				
				} else {
					thirdPartyVoyagePortBean.setSteamingHour("=QUOTIENT(0,1)");
					thirdPartyVoyagePortBean.setSteamingMin("=MOD(0,1)");
				}

//				thirdPartyVoyagePortBean.setSteamingContHour("2");
				voyageDtlList.add(thirdPartyVoyagePortBean);
				rowIndex++;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voyageDtlList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public synchronized String saveThirdPartyVoyage(ThirdPartyVoyageResultBean ThirdPartyVoyageResultBean) {
		String result = "false";
		int thirdPartyVoyageCount = 0;
		int portSequence = 1;
		String companyCode="C0001";
		ThirdPartyVoyageBean thirdPartyHeader = new ThirdPartyVoyageBean();
		List<ThirdPartyVoyagePortBean> voyageDtlList = new ArrayList<>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String restrictPol = "";
		Boolean insertCheck = true;
		try {
			
			String mktgFlag ="";
			
			thirdPartyHeader = ThirdPartyVoyageResultBean.getThirtyPartyVoyageHeader();

			if(thirdPartyHeader.getCompanyCode().equalsIgnoreCase("C0001")){
				//companyCode=userDetails.getCompanyCode();
				mktgFlag = "CORDELIA";
			} else if(thirdPartyHeader.getCompanyCode().equalsIgnoreCase("C0028")){
				//companyCode =thirdPartyHeader.getCompanyCode();
				mktgFlag = "F";
			}
			voyageDtlList = ThirdPartyVoyageResultBean.getVoyageDtlList();
			for (ThirdPartyVoyagePortBean ThirdPartyVoyagePortBean : voyageDtlList) {
				if(ThirdPartyVoyagePortBean.getNextVoyage() != null) {
				if(ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("true")) {
					ThirdPartyVoyagePortBean.setNextVoyage("Y");
				}else {
					ThirdPartyVoyagePortBean.setNextVoyage("N");
				}}
				else {
					ThirdPartyVoyagePortBean.setNextVoyage("N");

				}
				if(ThirdPartyVoyagePortBean.getToPort()!=null && ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("N")){
					if(restrictPol.contains(ThirdPartyVoyagePortBean.getFromPort())   ){
						insertCheck = false;
						break;
					}else{
						restrictPol = restrictPol+"-"+	ThirdPartyVoyagePortBean.getFromPort();				
					}
				}
			}
//			if(insertCheck==false){
//				if( !(thirdPartyHeader.getSectorId().equals("UAE-UMQ") && thirdPartyHeader.getMloShortName().equals("TEHEMA")) 
//						&& (thirdPartyHeader.getSectorId().matches("JKS|CCG SERVICE|UAE-UMQ|KDS|PGS|IQX|NDX") || thirdPartyHeader.getActivityCode().equals("A0002")  ) 
//						&& !thirdPartyHeader.getActivityCode().equals("A0003") 
//						&& !(thirdPartyHeader.getSectorId().equals("IWCS")) ){
//					insertCheck = true;
//				}
//				else{
//					
//				}
//			}else{
				
//			}
			System.out.println("TP validation add repeat port check "+insertCheck);
//			if (insertCheck) {
				if (voyageDtlList.size() > 0) {
					thirdPartyHeader.setVesselCode(thirdPartyHeader.getVesselCode1());
					if (thirdPartyHeader.getVesselCode1() != null && thirdPartyHeader.getVoyageId() != null && thirdPartyHeader.getSectorId() != null
							 ) {
						if (thirdPartyHeader.getVesselCode1().indexOf("-") == -1) {
							thirdPartyHeader.setVesselCode1(thirdPartyHeader.getVesselCode1().concat("-"));
						}
						String voyageId = thirdPartyHeader.getVesselCode1().trim().concat(thirdPartyHeader.getVoyageId().trim());
						thirdPartyVoyageCount = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.CHECK_THIRD_PARTY_VOYAGE,Integer.class, voyageId, thirdPartyHeader.getSectorId());
						
						String PreVoyage="";
						
						if(thirdPartyHeader.getVoyageNo()!=null && !thirdPartyHeader.getVoyageNo().equalsIgnoreCase("")){
							PreVoyage=thirdPartyHeader.getVoyageNo();
							
						}else{
							PreVoyage=prevVoyage(thirdPartyHeader.getVesselCode(), thirdPartyHeader.getSectorId());
						}
						

						if (thirdPartyVoyageCount == 0) {
							String vesselCode = thirdPartyHeader.getVesselCode().trim().substring(0, thirdPartyHeader.getVesselCode().length() - 1);
							String vesselCode1 = thirdPartyHeader.getVesselCode();
							Object[] headerParams = new Object[] { voyageId, vesselCode1, thirdPartyHeader.getSectorId(), thirdPartyHeader.getSchStartDate(),
									thirdPartyHeader.getSchEndDate(), thirdPartyHeader.getActivityCode(), "T", userDetails.getUserId(), companyCode,
									PreVoyage, thirdPartyHeader.getMloShortName(),
									thirdPartyHeader.getPortCost(), thirdPartyHeader.getHireCost(), thirdPartyHeader.getAgencyCost(), thirdPartyHeader.getMiscCost(),
									thirdPartyHeader.getOtherExpenses(), thirdPartyHeader.getProformaInsurance(), thirdPartyHeader.getFoBunkerCost(),
									thirdPartyHeader.getGobunkerCost(), thirdPartyHeader.getReasonId(), thirdPartyHeader.getCharterLiability(), thirdPartyHeader.getAwrp(),
									thirdPartyHeader.getAddComm(), thirdPartyHeader.getEwri(), mktgFlag,thirdPartyHeader.getIsFirstVoyage(),vesselCode1,thirdPartyHeader.getVlsfobunkerCost(),thirdPartyHeader.getLsmgobunkerCost() };
							int[] headerTypes = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
									Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER,
									Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
							jdbcTemplate.update(ThirdPartyVoyageQueryUtil.INSERT_VOYAGE_HEADER, headerParams, headerTypes);
							ThirdPartyVoyageBean header = thirdPartyHeader;
							header.setVoyageId(voyageId);
							/*UserLog userLog = userlogDao.userLogForInsert(header, voyageId, userDetails.getUserId());
							auditLogDao.auditLogForInsert(header, userLog, null);*/

							for (ThirdPartyVoyagePortBean ThirdPartyVoyagePortBean : voyageDtlList) {
								if(ThirdPartyVoyagePortBean.getNextVoyage() != null) {
									if(ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("true") || ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("Y") ) {
										ThirdPartyVoyagePortBean.setNextVoyage("Y");
									}else {
										ThirdPartyVoyagePortBean.setNextVoyage("N");
									}}
									else {
										ThirdPartyVoyagePortBean.setNextVoyage("N");

									}
								
								if (ThirdPartyVoyagePortBean.getVoyageId() != null && ThirdPartyVoyagePortBean.getFromPort() != null) {
									int[] dtlTypes = new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER,
											Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR , 
											Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
//									Object[] dtlParams = new Object[] { voyageId, portSequence, ThirdPartyVoyagePortBean.getFromPort(), ThirdPartyVoyagePortBean.getEta(),
//											ThirdPartyVoyagePortBean.getRotationId(), ThirdPartyVoyagePortBean.getPortStayHour(), ThirdPartyVoyagePortBean.getPortStayMin(),
//											ThirdPartyVoyagePortBean.getPortStayContHour(), ThirdPartyVoyagePortBean.getSpeed(), ThirdPartyVoyagePortBean.getSteamingHour(),
//											ThirdPartyVoyagePortBean.getSteamingMin(), ThirdPartyVoyagePortBean.getSteamingContHour(), ThirdPartyVoyagePortBean.getToPort(),
//											ThirdPartyVoyagePortBean.getBerthingHour(), ThirdPartyVoyagePortBean.getBerthingMin(), ThirdPartyVoyagePortBean.getNextVoyage() ,ThirdPartyVoyagePortBean.getRemarks()};
									Object[] dtlParams = new Object[] { voyageId, portSequence, ThirdPartyVoyagePortBean.getFromPort(), ThirdPartyVoyagePortBean.getEta(),
											ThirdPartyVoyagePortBean.getRotationId(),0, 0,
											0, ThirdPartyVoyagePortBean.getSpeed(), 0,
											0, 0, ThirdPartyVoyagePortBean.getToPort(),
											0, 0, ThirdPartyVoyagePortBean.getNextVoyage() ,ThirdPartyVoyagePortBean.getRemarks() ,ThirdPartyVoyagePortBean.getEtb(),
											 ThirdPartyVoyagePortBean.getEtd(),ThirdPartyVoyagePortBean.getCutoffdt()};
									
									jdbcTemplate.update(ThirdPartyVoyageQueryUtil.INSERT_VOYAGE_PORT_DTL, dtlParams, dtlTypes);
									ThirdPartyVoyagePortBean dtlBean = ThirdPartyVoyagePortBean;
									dtlBean.setVoyageId(voyageId);
									/*userLog = userlogDao.userLogForInsert(dtlBean, voyageId, userDetails.getUserId());
									auditLogDao.auditLogForInsert(dtlBean, userLog, null);*/
									portSequence++;
								}
							}
							result = "true";
							// Vessel -Type Of Operation
							String vesselTypeFlag = "";
							try {
								vesselTypeFlag = jdbcTemplate.queryForObject(PlanVoyageQueryUtil.GET_VESSEL_FLAG, new Object[] { vesselCode }, String.class);
							} catch (EmptyResultDataAccessException e) {
								vesselTypeFlag = "";
							}
							if (!CommonExcelUtils.isEmpty(vesselTypeFlag)) {
								jdbcTemplate.update(PlanVoyageQueryUtil.UPDATE_VESSEL_FLAG, new Object[] { vesselTypeFlag, voyageId });
							}

						} else {
							result = "Exist";
						}
					}else{
						result ="false";
					}

				}
//			}else{
//				result = "RepeatPort";
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ThirdPartyVoyageBean> getEditVoyageHeader(ThirdPartyVoyageBean ThirdPartyVoyageBean) throws Exception {
		List<ThirdPartyVoyageBean> editVoyageHeader = new ArrayList<>();
		SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat cFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		try {
			editVoyageHeader = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.EDIT_VOYAGE_HEADER_DTL,
					new Object[] { ThirdPartyVoyageBean.getVoyageId() }, new BeanPropertyRowMapper<>(ThirdPartyVoyageBean.class));

			long bookingCount = (long) jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.GET_BOOKING_REQUEST_COUNT,Integer.class, ThirdPartyVoyageBean.getVoyageId());
			for (ThirdPartyVoyageBean bean : editVoyageHeader) {
				if (bean.getSchStartDate() != null) {
					Date schDate = sformat.parse(bean.getSchStartDate());
					bean.setSchStartDate(cFormat.format(schDate));
				}
				if (bean.getSchEndDate() != null) {
					Date schDate = sformat.parse(bean.getSchEndDate());
					bean.setSchEndDate(cFormat.format(schDate));
				}
				bean.setVoyageId(ThirdPartyVoyageBean.getVoyageId());
				// bean.setSectorId(ThirdPartyVoyageBean.getSectorId());
				bean.setBookingCount((int) bookingCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editVoyageHeader;
	}

	@Override
	public List<ThirdPartyVoyagePortBean> getEditVoyageDtlList(ThirdPartyVoyageBean ThirdPartyVoyageBean) throws Exception {
		int rowIndex = 1;
		List<ThirdPartyVoyagePortBean> editVoyageDtlList = new ArrayList<>();
		List<ThirdPartyVoyagePortBean> tempEditVoyageDtlList = new ArrayList<>();
		try {		
			
			if(ThirdPartyVoyageBean.getFlag() != null){
				if(ThirdPartyVoyageBean.getFlag().equalsIgnoreCase("COPY") || ThirdPartyVoyageBean.getFlag().equalsIgnoreCase("null") || ThirdPartyVoyageBean.getFlag().isEmpty() ){
					tempEditVoyageDtlList = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.GET_THIRD_PARTY_VOYAGE_DTL_FOR_COPY, new Object[] { ThirdPartyVoyageBean
							.getVoyageId() }, new BeanPropertyRowMapper<>(ThirdPartyVoyagePortBean.class));
				}}
				else{
					tempEditVoyageDtlList = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.GET_THIRD_PARTY_VOYAGE_DTL, new Object[] { ThirdPartyVoyageBean
							.getVoyageId() }, new BeanPropertyRowMapper<>(ThirdPartyVoyagePortBean.class));
				}
			for (ThirdPartyVoyagePortBean thirdPartyVoyageDtlBean : tempEditVoyageDtlList) {
				
//				thirdPartyVoyageDtlBean.setEtb("=FEEDERFORMATTEDMOMENT(MOMENTADD(MOMENTADD(D" + rowIndex + ",'MINUTES',F" + rowIndex + "),'HOURS',E"
//						+ rowIndex + "))");
//				thirdPartyVoyageDtlBean.setEtd("=FEEDERFORMATTEDMOMENT(MOMENTADD(MOMENTADD(G" + rowIndex + ",'MINUTES',I" + rowIndex
//						+ "),'HOURS',H" + rowIndex + "))");
//				thirdPartyVoyageDtlBean.setOldVoyageId(thirdPartyVoyageDtlBean.getVoyageId());
//				if (thirdPartyVoyageDtlBean.getVoyageId().indexOf("-") != -1) {
					// String vesselVoyage[] =
					// thirdPartyVoyageDtlBean.getVoyageId().split("-");
//					thirdPartyVoyageDtlBean.setVesselCode(thirdPartyVoyageDtlBean.getVesselCode().concat("-"));
//					thirdPartyVoyageDtlBean.setVoyageId(thirdPartyVoyageDtlBean.getVoyageId().replaceFirst(thirdPartyVoyageDtlBean.getVesselCode(),
//							""));
//				}
				// thirdPartyVoyageDtlBean.setPortStayContHour("2");
				// thirdPartyVoyageDtlBean.setSteamingContHour("2");
//				thirdPartyVoyageDtlBean.setSteamingHour("=QUOTIENT(L" + rowIndex + ",M" + rowIndex + ")");
//				thirdPartyVoyageDtlBean.setSteamingMin("=MOD(L" + rowIndex + ",M" + rowIndex + ")");
//				if (thirdPartyVoyageDtlBean.getSpeed() != 0) {
//					thirdPartyVoyageDtlBean.setSteamingHour("=QUOTIENT(L" + rowIndex + ",M" + rowIndex + ")");
//					thirdPartyVoyageDtlBean.setSteamingMin("=MOD(L" + rowIndex + ",M" + rowIndex + ")");
//				} else {
//					thirdPartyVoyageDtlBean.setSteamingHour("=QUOTIENT(0,1)");
//					thirdPartyVoyageDtlBean.setSteamingMin("=MOD(0,1)");
//				}
//				if (thirdPartyVoyageDtlBean.getDistance() == null)
//					thirdPartyVoyageDtlBean.setDistance("0");
				editVoyageDtlList.add(thirdPartyVoyageDtlBean);
				rowIndex++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editVoyageDtlList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ThirdPartyVoyageResultBean updateThirdPartyVoyage(ThirdPartyVoyageResultBean ThirdPartyVoyageResultBean) {
		ThirdPartyVoyageResultBean resultBean=new ThirdPartyVoyageResultBean();
		int portSeq = 1;
		int thirdPartyVoyageCount = 0;
		ThirdPartyVoyageBean thirdPartyHeader = new ThirdPartyVoyageBean();
		List<ThirdPartyVoyagePortBean> voyageDtlList = new ArrayList<>();
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ListMultimap<String, Integer> oldPortMap=ArrayListMultimap.create();
		ListMultimap<String,Integer> newPortMap=ArrayListMultimap.create();
		String oldPorts="";String newPorts="";
		String restrictPol = "";
		Boolean updateCheck = true;
		try {
			thirdPartyHeader = ThirdPartyVoyageResultBean.getThirtyPartyVoyageHeader();
			voyageDtlList = ThirdPartyVoyageResultBean.getVoyageDtlList();
			for (ThirdPartyVoyagePortBean ThirdPartyVoyagePortBean : voyageDtlList) {

				if(ThirdPartyVoyagePortBean.getNextVoyage() != null) {
				if(ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("true")) {
					ThirdPartyVoyagePortBean.setNextVoyage("Y");
				}else {
					ThirdPartyVoyagePortBean.setNextVoyage("N");
				}}
				else {
					ThirdPartyVoyagePortBean.setNextVoyage("N");

				}
				if(ThirdPartyVoyagePortBean.getToPort()!=null && ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("N")){
					if(restrictPol.contains(ThirdPartyVoyagePortBean.getFromPort())   ){
						updateCheck = false;
						break;
					}else{
						restrictPol = restrictPol+"-"+	ThirdPartyVoyagePortBean.getFromPort();				
					}
				}
			}
			
//			if(updateCheck==false){
//				if( !(thirdPartyHeader.getSectorId().equals("UAE-UMQ") && thirdPartyHeader.getMloShortName().equals("TEHEMA")) 
//						&& (thirdPartyHeader.getSectorId().matches("JKS|CCG SERVICE|UAE-UMQ|KDS|PGS|IQX|NDX|GALEX|CIX") || thirdPartyHeader.getActivityCode().equals("A0002")  ) 
//						&& !thirdPartyHeader.getActivityCode().equals("A0003") 
//						&& !(thirdPartyHeader.getSectorId().equals("IWCS")) ){
//					updateCheck = true;
//				}
//				else{
//					
//				}
//			}else{
				
//			}
			System.out.println("TP update Validation check -"+ updateCheck);
//			if(updateCheck){
			ThirdPartyVoyageBean partyVoyageBean = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.EDIT_VOYAGE_HEADER_DTL,new Object[] { thirdPartyHeader.getOldVoyageId() }, new BeanPropertyRowMapper<>(ThirdPartyVoyageBean.class));

			
			if (thirdPartyHeader.getVesselCode().indexOf("-") == -1) {
				thirdPartyHeader.setVesselCode(thirdPartyHeader.getVesselCode().concat("-"));
			}
			List<ThirdPartyVoyagePortBean> detail = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.GET_THIRD_PARTY_VOYAGE_DTL,new Object[] { thirdPartyHeader.getOldVoyageId() }, new BeanPropertyRowMapper<>(ThirdPartyVoyagePortBean.class));
		/*	for (ThirdPartyVoyagePortBean partyVoyagePortBean : detail) {
				if(voyageDtlList.size() == detail.size()){
					partyVoyagePortBean.setDeleteStatus("Deleted by system for update");
				}else{
					partyVoyagePortBean.setDeleteStatus("Deleted by user");
				}
				oldPortMap.put(partyVoyagePortBean.getFromPort(),partyVoyagePortBean.getPortSequence());
				oldPorts+=partyVoyagePortBean.getFromPort() +"->";
				UserLog userLog = userlogDao.userLogForDelete(partyVoyagePortBean, thirdPartyHeader.getOldVoyageId(), userDetail.getUserId());
				auditLogDao.auditLogForDelete(partyVoyagePortBean, userLog, thirdPartyHeader.getOldVoyageId());
			}*/
			jdbcTemplate.update(ThirdPartyVoyageQueryUtil.DELETE_VOYAGE_PORT_DTL, thirdPartyHeader.getOldVoyageId());

			String voyageId = thirdPartyHeader.getVesselCode().trim().concat(thirdPartyHeader.getVoyageId());
			Object[] hdrParams = new Object[] { thirdPartyHeader.getSchStartDate(), thirdPartyHeader.getSchEndDate(),
					thirdPartyHeader.getMloShortName(), thirdPartyHeader.getPortCost(), thirdPartyHeader.getHireCost(),
					thirdPartyHeader.getAgencyCost(), thirdPartyHeader.getMiscCost(), thirdPartyHeader.getOtherExpenses(),
					thirdPartyHeader.getProformaInsurance(), thirdPartyHeader.getFoBunkerCost(), thirdPartyHeader.getGobunkerCost(),
					thirdPartyHeader.getReasonId() ,thirdPartyHeader.getCharterLiability(),thirdPartyHeader.getAwrp(),thirdPartyHeader.getAddComm(),thirdPartyHeader.getEwri(), voyageId,thirdPartyHeader.getVoyageNo(),thirdPartyHeader.getIsFirstVoyage(),thirdPartyHeader.getVlsfobunkerCost(),thirdPartyHeader.getLsmgobunkerCost(), thirdPartyHeader.getOldVoyageId() };
			jdbcTemplate.update(ThirdPartyVoyageQueryUtil.UPDATE_VOYAGE_HEADER, hdrParams);

			partyVoyageBean.setVoyageId(thirdPartyHeader.getOldVoyageId());
			ThirdPartyVoyageBean newHeader = ThirdPartyVoyageResultBean.getThirtyPartyVoyageHeader();
			newHeader.setVoyageId(voyageId);
			//UserLog userLog = userlogDao.userLogForUpdate(partyVoyageBean, newHeader, thirdPartyHeader.getOldVoyageId(), userDetail.getUserId());
			//auditLogDao.auditLogForUpdate(partyVoyageBean, newHeader, userLog, thirdPartyHeader.getOldVoyageId());

			for (ThirdPartyVoyagePortBean ThirdPartyVoyagePortBean : voyageDtlList) {
				if(ThirdPartyVoyagePortBean.getNextVoyage() != null) {
					if(ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("true") || ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("Y") ) {
						ThirdPartyVoyagePortBean.setNextVoyage("Y");
					}else {
						ThirdPartyVoyagePortBean.setNextVoyage("N");
					}}
					else {
						ThirdPartyVoyagePortBean.setNextVoyage("N");

					}
				if (ThirdPartyVoyagePortBean.getVoyageId() != null && ThirdPartyVoyagePortBean.getFromPort() != null) {
					int[] dtlTypes = new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
							Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.INTEGER,
							Types.INTEGER, Types.VARCHAR, Types.VARCHAR , Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
					Object[] dtlParams = new Object[] { voyageId, portSeq, ThirdPartyVoyagePortBean.getFromPort(), ThirdPartyVoyagePortBean.getEta(),
							ThirdPartyVoyagePortBean.getRotationId(), ThirdPartyVoyagePortBean.getPortStayHour(),
							ThirdPartyVoyagePortBean.getPortStayMin(), ThirdPartyVoyagePortBean.getPortStayContHour(),
							ThirdPartyVoyagePortBean.getSpeed(), 0,
							0, 0,
							ThirdPartyVoyagePortBean.getToPort(), ThirdPartyVoyagePortBean.getBerthingHour(),
							ThirdPartyVoyagePortBean.getBerthingMin(), ThirdPartyVoyagePortBean.getNextVoyage(),ThirdPartyVoyagePortBean.getRemarks(), ThirdPartyVoyagePortBean.getEtb(),
							 ThirdPartyVoyagePortBean.getEtd(),ThirdPartyVoyagePortBean.getCutoffdt()};
					jdbcTemplate.update(ThirdPartyVoyageQueryUtil.INSERT_VOYAGE_PORT_DTL, dtlParams, dtlTypes);
				//	userLog = userlogDao.userLogForInsert(ThirdPartyVoyagePortBean, voyageId, userDetail.getUserId());
					//auditLogDao.auditLogForInsert(ThirdPartyVoyagePortBean, userLog, voyageId);
				}
				newPortMap.put(ThirdPartyVoyagePortBean.getFromPort(), portSeq);
				newPorts+=ThirdPartyVoyagePortBean.getFromPort() +"->";
				portSeq++;
			}
			System.out.println(oldPortMap);
			System.out.println(newPortMap);
			if(oldPorts.length() >0 && newPorts.length() >0){
				oldPorts=oldPorts.substring(0,oldPorts.length()-2);
				newPorts=newPorts.substring(0,newPorts.length()-2);
				int bookingCount=jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.SELECT_BOOKING_COUNT_FOR_VOYAGE, new Object[]{voyageId},Integer.class);
				if(bookingCount > 0){
					boolean isUpdateable=updatePortRotation(newPortMap,oldPortMap,voyageId);
					if(!isUpdateable)
						resultBean.setMessage("Old Ports : "+oldPorts+"<br>New Ports : "+newPorts+
								"<br>Please use Shift Booking to change the ports that will reflect in Booking,Transhipment,Loading,Slot Message,Vessel Arrival and Vessel Departure.");
				}
			}
			resultBean.setSuccess(true);
//		}else{
//			resultBean.setSuccess(false);
//			resultBean.setMessage("Repeated ports are not allowed in Third party!");
//		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean updatePortRotation(ListMultimap<String, Integer> newPortMap,ListMultimap<String, Integer> oldPortMap,String voyageId){
		
		boolean isUpdateable=true;
		try{
		 Set oldPortSet = oldPortMap.keySet();
		    Iterator oldPortIterator = oldPortSet.iterator();
		    while( oldPortIterator.hasNext( ) ) {
		        String key = (String) oldPortIterator.next( );
		        if(!newPortMap.containsKey(key) || oldPortMap.get(key).size() > newPortMap.get(key).size()){
		        	isUpdateable=false;
		        }
		    }
		    if(isUpdateable){
		    	 Set oldPortkeySet = oldPortMap.keySet();
				    Iterator oldPorts = oldPortkeySet.iterator();
		    while( oldPorts.hasNext() ) {
		        String port = (String) oldPorts.next();
		        List<Integer> oldPortSeqList=oldPortMap.get(port);
		        List<Integer> newPortSeqList=newPortMap.get(port);
		        for(int i=0;i<oldPortSeqList.size();i++){/*
					String updateVoyageSeq = "{call UPDATE_PORT_SEQUENCE(?,?,?,?)}";
					CallableStatement cs = connection.prepareCall(updateVoyageSeq);
					cs.setInt(1, Integer.parseInt(voyageId));
					cs.setInt(2, Integer.parseInt(port));
					cs.setInt(3, oldPortSeqList.get(i));
					cs.setInt(4, newPortSeqList.get(i));
					cs.executeUpdate();
					cs.close();
		        */
		        	jdbcTemplate.queryForList(PlanVoyageQueryUtil.CALL_UPDATE_PORT_SEQ_FUNCTION, new Object[]{voyageId,port,Integer.parseInt(oldPortSeqList.get(i).toString()),
		        			Integer.parseInt(newPortSeqList.get(i).toString())});		
		        }
		    }
		    }
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		  return isUpdateable;
	}


	@Override
	public boolean deleteThirdPartyVoyage(String voyageId) {
		boolean result = false;
		try {
			int bookingCount=jdbcTemplate.queryForObject(PlanVoyageQueryUtil.SELECT_BOOKING_COUNT_FOR_VOYAGE,new Object[]{voyageId},Integer.class);
			if(bookingCount==0){
			UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ThirdPartyVoyageBean thirdPartyVoyageBean = new ThirdPartyVoyageBean();
			thirdPartyVoyageBean.setVoyageId(voyageId);
			List<ThirdPartyVoyageBean> header = getEditVoyageHeader(thirdPartyVoyageBean);
			List<ThirdPartyVoyagePortBean> detail = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.GET_THIRD_PARTY_VOYAGE_DTL,
					new Object[] { voyageId }, new BeanPropertyRowMapper<>(ThirdPartyVoyagePortBean.class));
			jdbcTemplate.update(ThirdPartyVoyageQueryUtil.DELETE_VOYAGE_PORT_DTL, voyageId);
			jdbcTemplate.update(ThirdPartyVoyageQueryUtil.DELETE_THIRD_PARTY_VOYAGE, voyageId);
			//jdbcTemplate.update(ThirdPartyVoyageQueryUtil.DELETE_transhipment_req_header,voyageId,voyageId);

			UserLog userLog = null;
			for (ThirdPartyVoyageBean thirdPartyVoyage : header) {
				userLog = userlogDao.userLogForDelete(thirdPartyVoyage, voyageId, userDetail.getUserId());
				auditLogDao.auditLogForDelete(header, userLog, voyageId);
			}
			for (ThirdPartyVoyagePortBean partyVoyagePortBean : detail) {
				partyVoyagePortBean.setDeleteStatus("Whole voyage deleted by user");
				userlogDao.userLogForDelete(partyVoyagePortBean, voyageId, userDetail.getUserId());
				auditLogDao.auditLogForDelete(partyVoyagePortBean, userLog, voyageId);
			}
			result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public List<ThirdPartyVoyageBean> getMloList() throws Exception {
		List<ThirdPartyVoyageBean> mloList = new ArrayList<>();
		try {
			mloList = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.SELECT_MLO_SHORT_NAME, new BeanPropertyRowMapper<>(
					ThirdPartyVoyageBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mloList;
	}
	@Override
	public List<ThirdPartyVoyageBean> getMloList(String voyageID) throws Exception {
		List<ThirdPartyVoyageBean> mloList = new ArrayList<>();
		try {
//			mloList = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.SELECT_MLO_SHORT_NAME_union,new Object[]{voyageID}, new BeanPropertyRowMapper<>(
//					ThirdPartyVoyageBean.class));

			mloList = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.SELECT_MLO_SHORT_NAME_union,new Object[]{voyageID}, new BeanPropertyRowMapper<>(
					ThirdPartyVoyageBean.class));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mloList;
	}

	public void updateVoyageSequence(String voyage) {
		try {
			Connection connection = null;
			connection = jdbcTemplate.getDataSource().getConnection();
			String updateVoyageSeq = "{call UPDATE_VOYAGE_SEQUENCE(?)}";
			CallableStatement cs = connection.prepareCall(updateVoyageSeq);
			cs.setString(1, voyage);
			cs.executeUpdate();
			cs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean checkServiceExist(ThirdPartyVoyageBean partyVoyageBean, String companyCode) {
		boolean result=false;int count=0;
		try{
//			String branchId = jdbcTemplate.queryForObject(PlanVoyageQueryUtil.GET_BRANCH,new Object[]{companyCode},String.class);
			 count=jdbcTemplate.queryForObject(PlanVoyageQueryUtil.CHECK_SERVICE_EXIST,new Object[]{partyVoyageBean.getSectorId()},Integer.class);
			 if(count > 0)
				 result=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getLocationOfService(String serviceId) {
		String location="";
		try{
			location=jdbcTemplate.queryForObject(PlanVoyageQueryUtil.SELECT_LOCATION_OF_SERVICE,new Object[]{serviceId},String.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return location;
	}

	@Override
	public ThirdPartyVoyageResultBean checkPurchaseQuotValid(ThirdPartyVoyageResultBean thirdPartyVoyageResultBean) {
		ThirdPartyVoyageResultBean resultBean=thirdPartyVoyageResultBean;
		ThirdPartyVoyageBean thirdPartyHeader =thirdPartyVoyageResultBean.getThirtyPartyVoyageHeader();
		List<Integer> removedIndex=new ArrayList<>();
		int avalCount=0;StringBuffer sb=new StringBuffer();int index=0;String lastFromPort="";StringBuffer mailMsg=new StringBuffer();
		boolean isSave=true;
		try{
			List<ThirdPartyVoyagePortBean> voyageDtlList=new ArrayList<>(thirdPartyVoyageResultBean.getVoyageDtlList());
			for(ThirdPartyVoyagePortBean portBean:thirdPartyVoyageResultBean.getVoyageDtlList()){
				if(!CommonUtil.returnEmptyForNull(portBean.getFromPort()).isEmpty() && 
						!CommonUtil.returnEmptyForNull(portBean.getToPort()).isEmpty()){
					
				int count=jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.CHECK_PURCHASE_QUOT,
						new Object[]{portBean.getFromPort(),portBean.getToPort(),thirdPartyHeader.getMloShortName(),portBean.getEtd()},Integer.class);
				int samePortCount=jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.CHECK_SAME_PORTS_ISO,new Object[]{portBean.getFromPort(),portBean.getToPort()},Integer.class);
				if(count ==0 && samePortCount == 0){
					//voyageDtlList.remove(portBean);
					//removedIndex.add(index);
					isSave=false;
					sb.append("Purchase quotations are not available for "+portBean.getFromPort() +" and "+portBean.getToPort() +" port pairs  <br>");
					mailMsg.append("Purchase quotations are not available for the below port <br>");
					mailMsg.append("From port - "+portBean.getFromPort()+" and ");
					mailMsg.append("To port - "+portBean.getToPort()+"<br>");
					mailMsg.append("Service - "+thirdPartyHeader.getSectorId()+"<br>");
					mailMsg.append("ETD - "+portBean.getEtd()+"<br>");
					mailMsg.append("Vessel Operator - "+thirdPartyHeader.getMloShortName()+"<br>");
				}else{
					avalCount++;
				}
				}/*else{
					if(avalCount > 0 && !voyageDtlList.get(avalCount-1).getToPort().equals(portBean.getFromPort())){
						voyageDtlList.remove(portBean);
						removedIndex.add(index);
					}
					
				}*/
				index++;
			}
			if(avalCount >0){
				//resultBean.setSuccess(true);
				resultBean.setMessage(sb.toString());
			}else{
				//mailMsg=new StringBuffer();
				//mailMsg.append("Purchase quotations are not available for all the port pairs.");
				resultBean.setMessage("Purchase quotations are not available for all the port pairs.");
			}
			resultBean.setSuccess(isSave);
			//resultBean.setVoyageDtlList(voyageDtlList);
			//resultBean.setRemovedIndex(removedIndex);
			//resultBean.setPurchaseQuotMailMsg(mailMsg.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public boolean checkValidationDate(String voyageId) {
		// TODO Auto-generated method stub
		boolean result=false;
		try{
			int count=jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.CHECK_VOYAGE_CREATION_DATE,new Object[]{voyageId},Integer.class);
			if(count >0){
				result=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getCompanyOfService(ThirdPartyVoyageBean thirtyPartyVoyageHeader) {
		String companyCode="";
		try{
			companyCode=jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.SELECT_COMPANY_OF_SERVICE,new Object[]{thirtyPartyVoyageHeader.getSectorId()},String.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return companyCode;
	}

	@Override
	public List<ThirdPartyVoyageBean> getVesselListWithOutOwnParty(String formCode, String userId) throws Exception {
		List<ThirdPartyVoyageBean> voyageList = new ArrayList<>();
		try {
//			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.GET_VESSEL_LIST_WOOWN, new Object[] { formCode, userId  });
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.GET_VESSEL_LIST_WOOWN);

			for (Map<String, Object> row : rows) {
				ThirdPartyVoyageBean ThirdPartyVoyageBean = new ThirdPartyVoyageBean();
				if (row.get("vessel_code") != null && row.get("vessel_name") != null) {
					ThirdPartyVoyageBean.setId(row.get("vessel_code").toString());
					ThirdPartyVoyageBean.setText(row.get("vessel_name").toString());
				}
				if (row.get("vessel_speed") != null)
					ThirdPartyVoyageBean.setSpeed(row.get("vessel_speed").toString());
				voyageList.add(ThirdPartyVoyageBean);
			}
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return voyageList;
	}
	@Override
	public List<ThirdPartyVoyageBean> getVesselListWithOutOwnParty1(String formCode, String userId) throws Exception {
		List<ThirdPartyVoyageBean> voyageList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ThirdPartyVoyageQueryUtil.GET_VESSEL_LIST_WOOWN1, new Object[] { formCode, userId  });
			for (Map<String, Object> row : rows) {
				ThirdPartyVoyageBean ThirdPartyVoyageBean = new ThirdPartyVoyageBean();
				if (row.get("vessel_code") != null && row.get("vessel_name") != null) {
					ThirdPartyVoyageBean.setId(row.get("vessel_code").toString());
					ThirdPartyVoyageBean.setText(row.get("vessel_name").toString());
				}
				if (row.get("vessel_speed") != null)
					ThirdPartyVoyageBean.setSpeed(row.get("vessel_speed").toString());
				voyageList.add(ThirdPartyVoyageBean);
			}
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return voyageList;
	}

	@Override
	public List<ThirdPartyVoyageBean> geList(ThirdPartyVoyageBean thirdPartyVoyageBean) throws Exception {
		List<ThirdPartyVoyageBean> List = new ArrayList<>();
		int i =0;	
		String query = "";
		try {
//			if(thirdPartyVoyageBean.getVesselCode()!=null && thirdPartyVoyageBean.getVesselCode()!="" && thirdPartyVoyageBean.getVoyageIdnew().size() == 0) {
//				List = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.EXPORT_LIST1,
//						 new BeanPropertyRowMapper<>(ThirdPartyVoyageBean.class),thirdPartyVoyageBean.getVesselCode());
//		
//			} else if(thirdPartyVoyageBean.getVoyageIdnew()!=null && thirdPartyVoyageBean.getVoyageIdnew().size() != 0 && thirdPartyVoyageBean.getVesselCode()!=null && thirdPartyVoyageBean.getVesselCode()!="") {
//				String voyage = "";
//				for(String voyageNew:thirdPartyVoyageBean.getVoyageIdnew()) {
//					int size = thirdPartyVoyageBean.getVoyageIdnew().size();
//					i++;
//					if(i == size ) {
//						voyage +=  "'"+voyageNew+"'";
//
//					}
//					else
//					voyage +=   "'"+voyageNew+"'"+",";
//				}
//				String query = "  where vp.voyage_id = v.voyage_id AND v.vessel_id = '"+thirdPartyVoyageBean.getVesselCode()+ "'  and v.voyage_id in ("+voyage+")  order by v.vessel_id";
//				List = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.EXPORT_LIST2+query,new BeanPropertyRowMapper<>(ThirdPartyVoyageBean.class));
//						
//			}else {
//
//				List = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.EXPORT_LIST,
//						 new BeanPropertyRowMapper<>(ThirdPartyVoyageBean.class));
//			}
			String voyage = "";
			if(thirdPartyVoyageBean.getVoyageIdnew().size() > 0) {
			for(String voyageNew:thirdPartyVoyageBean.getVoyageIdnew()) {
				int size = thirdPartyVoyageBean.getVoyageIdnew().size();
				i++;
				if(i == size ) {
					voyage +=  "'"+voyageNew+"'";

				}
				else
				voyage +=   "'"+voyageNew+"'"+",";
			}
			}
			
			
			query = ThirdPartyVoyageQueryUtil.EXPORT_LIST;
			if (thirdPartyVoyageBean.getVesselCode() != null && !thirdPartyVoyageBean.getVesselCode().isEmpty()) {
				query += " and v.vessel_id='" + thirdPartyVoyageBean.getVesselCode() + "'";
			}
			if (thirdPartyVoyageBean.getVoyageIdnew() != null && !thirdPartyVoyageBean.getVoyageIdnew().isEmpty()) {
				query += " and v.voyage_id in (" + voyage + ")";
			}
			if (thirdPartyVoyageBean.getActivityCode() != null && !thirdPartyVoyageBean.getActivityCode().isEmpty()) {
				query += " and v.activity_code='" + thirdPartyVoyageBean.getActivityCode() + "'";
			}
			if (thirdPartyVoyageBean.getSectorId() != null && !thirdPartyVoyageBean.getSectorId().isEmpty()) {
				query += " and v.sector_id='" + thirdPartyVoyageBean.getSectorId() + "'";
			}
			if (thirdPartyVoyageBean.getSectorId() != null && !thirdPartyVoyageBean.getSectorId().isEmpty()) {
				query += " and v.sector_id='" + thirdPartyVoyageBean.getSectorId() + "'";
			}
			if (thirdPartyVoyageBean.getVesselOperator() != null && !thirdPartyVoyageBean.getVesselOperator().isEmpty()) {
				query += " and v.vessel_optr='" + thirdPartyVoyageBean.getVesselOperator() + "'";
			}
			if (thirdPartyVoyageBean.getFromDate() != null && !thirdPartyVoyageBean.getFromDate().isEmpty()) {
				query += " and v.created_date::date >= to_date('" + thirdPartyVoyageBean.getFromDate() + "','dd/mm/yyyy')";
			}
			if (thirdPartyVoyageBean.getToDate() != null && !thirdPartyVoyageBean.getToDate().isEmpty()) {
				query += " and v.created_date::date <= to_date('" + thirdPartyVoyageBean.getToDate() + "','dd/mm/yyyy')";
			}
			query+=" order by v.created_date desc";
			List = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ThirdPartyVoyageBean.class));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return List;
	
	}




	@Override
	public List<ThirdPartyVoyageBean> searchfindshed(ThirdPartyVoyageBean searchBean) {
		Boolean isSuccess = false;
		ThirdPartyVoyageBean bean =new ThirdPartyVoyageBean();
		List<ThirdPartyVoyageBean> searchList = new ArrayList<ThirdPartyVoyageBean>();
		try{
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			//searchList = jdbcTemplate.query(CustomerSaleQueryUtil.GET_CUSTOMER_SEARCH_LIST(custsearchBean.getSearchstr(),custsearchBean.getFromDate(),custsearchBean.getToDate()), new BeanPropertyRowMapper<CustomerSaleBean>(CustomerSaleBean.class));
			searchList = jdbcTemplate.query(ThirdPartyVoyageQueryUtil.GET_Findshed_LIST(searchBean.getPol(),searchBean.getPod(),searchBean.getFpod()), new BeanPropertyRowMapper<ThirdPartyVoyageBean>(ThirdPartyVoyageBean.class));
			isSuccess = true;
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return searchList;
	}
	
	@Override
	public String saveThirdPartyVoyageImport(List<ThirdPartyVoyageResultBean> ThirdPartyVoyageResultBean1) {
		String result = "false";
		ThirdPartyVoyageResultBean ThirdPartyVoyageResultBean= null;
//		for(ThirdPartyVoyageResultBean ThirdPartyVoyageResultBean:ThirdPartyVoyageResultBean1) {
		for(int i = 0;i<ThirdPartyVoyageResultBean1.size(); i++) {
			ThirdPartyVoyageResultBean = new ThirdPartyVoyageResultBean();
			ThirdPartyVoyageResultBean = ThirdPartyVoyageResultBean1.get(i);
			int thirdPartyVoyageCount = 0;
			int portSequence = 1;
			String companyCode="C0001";
			ThirdPartyVoyageBean thirdPartyHeader = new ThirdPartyVoyageBean();
			List<ThirdPartyVoyagePortBean> voyageDtlList = new ArrayList<>();
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String restrictPol = "";
			Boolean insertCheck = true;
		try {
			
			String mktgFlag ="";
			
			thirdPartyHeader = ThirdPartyVoyageResultBean.getThirtyPartyVoyageHeader();

			if(thirdPartyHeader.getCompanyCode().equalsIgnoreCase("C0001")){
				//companyCode=userDetails.getCompanyCode();
				mktgFlag = "CORDELIA";
			} else if(thirdPartyHeader.getCompanyCode().equalsIgnoreCase("C0028")){
				//companyCode =thirdPartyHeader.getCompanyCode();
				mktgFlag = "F";
			}
			voyageDtlList = ThirdPartyVoyageResultBean.getVoyageDtlList();
			for (ThirdPartyVoyagePortBean ThirdPartyVoyagePortBean : voyageDtlList) {
				if(ThirdPartyVoyagePortBean.getNextVoyage() != null) {
				if(ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("true")) {
					ThirdPartyVoyagePortBean.setNextVoyage("Y");
				}else {
					ThirdPartyVoyagePortBean.setNextVoyage("N");
				}}
				else {
					ThirdPartyVoyagePortBean.setNextVoyage("N");

				}
				if(ThirdPartyVoyagePortBean.getToPort()!=null && ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("N")){
					if(restrictPol.contains(ThirdPartyVoyagePortBean.getFromPort())   ){
						insertCheck = false;
						break;
					}else{
						restrictPol = restrictPol+"-"+	ThirdPartyVoyagePortBean.getFromPort();				
					}
				}
			}
//			if(insertCheck==false){
//				if( !(thirdPartyHeader.getSectorId().equals("UAE-UMQ") && thirdPartyHeader.getMloShortName().equals("TEHEMA")) 
//						&& (thirdPartyHeader.getSectorId().matches("JKS|CCG SERVICE|UAE-UMQ|KDS|PGS|IQX|NDX") || thirdPartyHeader.getActivityCode().equals("A0002")  ) 
//						&& !thirdPartyHeader.getActivityCode().equals("A0003") 
//						&& !(thirdPartyHeader.getSectorId().equals("IWCS")) ){
//					insertCheck = true;
//				}
//				else{
//					
//				}
//			}else{
				
//			}
			System.out.println("TP validation add repeat port check "+insertCheck);
//			if (insertCheck) {
				if (voyageDtlList.size() > 0) {
					thirdPartyHeader.setVesselCode(thirdPartyHeader.getVesselCode1());
					if (thirdPartyHeader.getVesselCode1() != null && thirdPartyHeader.getVoyageId() != null && thirdPartyHeader.getSectorId() != null
							 ) {
						if (thirdPartyHeader.getVesselCode1().indexOf("-") == -1) {
							thirdPartyHeader.setVesselCode1(thirdPartyHeader.getVesselCode1().concat("-"));
						}
						String voyageId = thirdPartyHeader.getVesselCode1().trim().concat(thirdPartyHeader.getVoyageId().trim());
						thirdPartyVoyageCount = jdbcTemplate.queryForObject(ThirdPartyVoyageQueryUtil.CHECK_THIRD_PARTY_VOYAGE,Integer.class, voyageId, thirdPartyHeader.getSectorId());
						
						String PreVoyage="";
						
						if(thirdPartyHeader.getVoyageNo()!=null && !thirdPartyHeader.getVoyageNo().equalsIgnoreCase("")){
							PreVoyage=thirdPartyHeader.getVoyageNo();
							
						}else{
							PreVoyage=prevVoyage(thirdPartyHeader.getVesselCode(), thirdPartyHeader.getSectorId());
						}
						

						if (thirdPartyVoyageCount == 0) {
							String vesselCode = thirdPartyHeader.getVesselCode().trim().substring(0, thirdPartyHeader.getVesselCode().length() - 1);
							String vesselCode1 = thirdPartyHeader.getVesselCode();
							Object[] headerParams = new Object[] { voyageId, vesselCode1, thirdPartyHeader.getSectorId(), thirdPartyHeader.getSchStartDate(),
									thirdPartyHeader.getSchEndDate(), thirdPartyHeader.getActivityCode(), "T", userDetails.getUserId(), companyCode,
									PreVoyage, thirdPartyHeader.getMloShortName(),
									thirdPartyHeader.getPortCost(), thirdPartyHeader.getHireCost(), thirdPartyHeader.getAgencyCost(), thirdPartyHeader.getMiscCost(),
									thirdPartyHeader.getOtherExpenses(), thirdPartyHeader.getProformaInsurance(), thirdPartyHeader.getFoBunkerCost(),
									thirdPartyHeader.getGobunkerCost(), thirdPartyHeader.getReasonId(), thirdPartyHeader.getCharterLiability(), thirdPartyHeader.getAwrp(),
									thirdPartyHeader.getAddComm(), thirdPartyHeader.getEwri(), mktgFlag,thirdPartyHeader.getIsFirstVoyage(),vesselCode1,thirdPartyHeader.getVlsfobunkerCost(),thirdPartyHeader.getLsmgobunkerCost() };
							int[] headerTypes = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
									Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER,
									Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
							jdbcTemplate.update(ThirdPartyVoyageQueryUtil.INSERT_VOYAGE_HEADER, headerParams, headerTypes);
							ThirdPartyVoyageBean header = thirdPartyHeader;
							header.setVoyageId(voyageId);
							/*UserLog userLog = userlogDao.userLogForInsert(header, voyageId, userDetails.getUserId());
							auditLogDao.auditLogForInsert(header, userLog, null);*/

							for (ThirdPartyVoyagePortBean ThirdPartyVoyagePortBean : voyageDtlList) {
								if(ThirdPartyVoyagePortBean.getNextVoyage() != null) {
									if(ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("true") || ThirdPartyVoyagePortBean.getNextVoyage().equalsIgnoreCase("Y") ) {
										ThirdPartyVoyagePortBean.setNextVoyage("Y");
									}else {
										ThirdPartyVoyagePortBean.setNextVoyage("N");
									}}
									else {
										ThirdPartyVoyagePortBean.setNextVoyage("N");

									}
								
								if (ThirdPartyVoyagePortBean.getVoyageId() != null && ThirdPartyVoyagePortBean.getFromPort() != null) {
									int[] dtlTypes = new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER,
											Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR , 
											Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
//									Object[] dtlParams = new Object[] { voyageId, portSequence, ThirdPartyVoyagePortBean.getFromPort(), ThirdPartyVoyagePortBean.getEta(),
//											ThirdPartyVoyagePortBean.getRotationId(), ThirdPartyVoyagePortBean.getPortStayHour(), ThirdPartyVoyagePortBean.getPortStayMin(),
//											ThirdPartyVoyagePortBean.getPortStayContHour(), ThirdPartyVoyagePortBean.getSpeed(), ThirdPartyVoyagePortBean.getSteamingHour(),
//											ThirdPartyVoyagePortBean.getSteamingMin(), ThirdPartyVoyagePortBean.getSteamingContHour(), ThirdPartyVoyagePortBean.getToPort(),
//											ThirdPartyVoyagePortBean.getBerthingHour(), ThirdPartyVoyagePortBean.getBerthingMin(), ThirdPartyVoyagePortBean.getNextVoyage() ,ThirdPartyVoyagePortBean.getRemarks()};
									Object[] dtlParams = new Object[] { voyageId, portSequence, ThirdPartyVoyagePortBean.getFromPort(), ThirdPartyVoyagePortBean.getEta(),
											ThirdPartyVoyagePortBean.getRotationId(),0, 0,
											0, ThirdPartyVoyagePortBean.getSpeed(), 0,
											0, 0, ThirdPartyVoyagePortBean.getToPort(),
											0, 0, ThirdPartyVoyagePortBean.getNextVoyage() ,ThirdPartyVoyagePortBean.getRemarks() ,ThirdPartyVoyagePortBean.getEtb(),
											 ThirdPartyVoyagePortBean.getEtd(),ThirdPartyVoyagePortBean.getCutoffdt()};
									
									jdbcTemplate.update(ThirdPartyVoyageQueryUtil.INSERT_VOYAGE_PORT_DTL, dtlParams, dtlTypes);
									ThirdPartyVoyagePortBean dtlBean = ThirdPartyVoyagePortBean;
									dtlBean.setVoyageId(voyageId);
									/*userLog = userlogDao.userLogForInsert(dtlBean, voyageId, userDetails.getUserId());
									auditLogDao.auditLogForInsert(dtlBean, userLog, null);*/
									portSequence++;
								}
							}
							result = "true";
							// Vessel -Type Of Operation
							String vesselTypeFlag = "";
							try {
								vesselTypeFlag = jdbcTemplate.queryForObject(PlanVoyageQueryUtil.GET_VESSEL_FLAG, new Object[] { vesselCode }, String.class);
							} catch (EmptyResultDataAccessException e) {
								vesselTypeFlag = "";
							}
							if (!CommonExcelUtils.isEmpty(vesselTypeFlag)) {
								jdbcTemplate.update(PlanVoyageQueryUtil.UPDATE_VESSEL_FLAG, new Object[] { vesselTypeFlag, voyageId });
							}

						} else {
							result = "Exist";
						}
					}else{
						result ="false";
					}

				}
//			}else{
//				result = "RepeatPort";
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		return result;
	}
}
