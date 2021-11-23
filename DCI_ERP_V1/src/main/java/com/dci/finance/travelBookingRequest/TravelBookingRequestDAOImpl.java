package com.dci.finance.travelBookingRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.util.CommonUtilityQueryUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;



@Repository
public class TravelBookingRequestDAOImpl implements TravelBookingRequestDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(TravelBookingRequestDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<TravelBookingRequest> getTravelList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<TravelBookingRequest> travelList = new ArrayList<TravelBookingRequest>();
		try {
			UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			travelList = jdbcTemplate.query(TravelBookingRequestQueryUtil.get_travelBookingRequest_List, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class), empUser.getUserId());

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTravelList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return travelList;
	}

	@Override
	public TravelBookingRequestResultBean getRequestForList() throws CustomException {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		TravelBookingRequestResultBean travelBookingResultBean = new TravelBookingRequestResultBean();
		List<TravelBookingRequest> empList = new ArrayList<TravelBookingRequest>();
		try {
			empList = jdbcTemplate.query(TravelBookingRequestQueryUtil.get_RequestFor_List, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class), userDetail.getCompanyCode());
			travelBookingResultBean.setRequestForList(empList);
			travelBookingResultBean.setSuccess(true);
			return travelBookingResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Travel Request List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public TravelBookingRequestResultBean saveTravelBookingRequestList(TravelBookingRequest travelBookingRequest) throws CustomException {
		
		TravelBookingRequestResultBean resultBean = new TravelBookingRequestResultBean();
		CommonUtilityBean commonBean =new CommonUtilityBean();
		
		DateFormat formatterDate;
		formatterDate = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat formatterTime = new SimpleDateFormat("hh:mm");
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String autoGentravelReqId = "";
		String autoGenPassengerId = "";
		boolean success=false;
		
		try {
			
			//work flow entry checking
			
			String systemModuleName="Business Travel";
			
			commonBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.getEmpDetails, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class), teampUser.getEmpId());
			
			int workFlowCount = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.getWorkFlowCount,new Object []{ systemModuleName,commonBean.getEmpBranch() }, int.class);
			
			if(workFlowCount>0) {
			int travelBooking = travelBookingRequest.getRequestType();
			autoGentravelReqId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelReqIdAutoGen, String.class);
			travelBookingRequest.setRequestId(Integer.parseInt(autoGentravelReqId));

			if (travelBooking == 1) {
				String trainReqDate = travelBookingRequest.getTrainRequestDate();
				Date trainRequestDate = formatterDate.parse(trainReqDate);

				String trainTraDate = travelBookingRequest.getTrainTravelDate();
				Date trainTravelDate = formatterDate.parse(trainTraDate);
				boolean retDate = travelBookingRequest.isTrainReturnTicket();
				Date trainReturnDate = null;
				String trainRetArrivalTime = "";
				String trainRetDepartureTime = "";

				if (retDate == true) {
					String trainRetDate = travelBookingRequest.getTrainReturnDate();
					trainReturnDate = formatterDate.parse(trainRetDate);

					trainRetArrivalTime = travelBookingRequest.getTrainRetArrTime();

					trainRetDepartureTime = travelBookingRequest.getTrainRetDepTime();
				}
				String trainArrivalTime = travelBookingRequest.getTrainArrivalTime();

				String trainDepartureTime = travelBookingRequest.getTrainDepartureTime();

				jdbcTemplate.update(TravelBookingRequestQueryUtil.insert_travelBookingRequest_Data, travelBookingRequest.getRequestId(), teampUser.getUserId(), trainRequestDate, travelBookingRequest.getTrainReason(), travelBookingRequest.getTrainRequestFor(), travelBookingRequest.getRequestType(), travelBookingRequest.getTrainReqStatus(), teampUser.getUserId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.insert_trainTravelBookingRequest_Data, travelBookingRequest.getRequestId(), travelBookingRequest.getTrainPreferBerth(), travelBookingRequest.getTrainArrival(), travelBookingRequest.getTrainDeparture(), travelBookingRequest.isTrainPickUpReq(), travelBookingRequest.isTrainReturnTicket(), travelBookingRequest.getTrainQuota(), trainTravelDate, travelBookingRequest.getTrainNoOfPass(), travelBookingRequest.getTrainPreferTrainNo(), travelBookingRequest.getTrainPreferTrainName(),
						travelBookingRequest.getTrainClass(), trainArrivalTime, trainDepartureTime, travelBookingRequest.getTrainMealPrefer(), trainReturnDate, travelBookingRequest.getTrainReturnArr(), travelBookingRequest.getTrainReturnDep(), trainRetArrivalTime, trainRetDepartureTime,travelBookingRequest.getTrainTraveltype());
				
	          
				for (TravelBookingRequest objDetailBean : travelBookingRequest.getObjtraindetailList()) {
					  String trinarrDate = null; 
					  String traindepartDate =null;
					
		        	   if(!objDetailBean.getTrainarrivalDate().isEmpty() && objDetailBean.getTrainarrivalDate()!=null) {    
							trinarrDate = objDetailBean.getTrainarrivalDate();
				       }
						
		        	  
		             if(!objDetailBean.getTraindepartDate().isEmpty() && objDetailBean.getTraindepartDate()!=null) {	    
							traindepartDate = objDetailBean.getTraindepartDate();  
		        	  }
					
					jdbcTemplate.update(TravelBookingRequestQueryUtil.INSERT_TRAIN_DEPATURE_DTL,objDetailBean.getTrainDeparture(),objDetailBean.getTrainArrival(),objDetailBean.getTrainDepartureTime(),
							objDetailBean.getTrainArrivalTime(),trinarrDate,traindepartDate,travelBookingRequest.getRequestId());	
					
				}
				
				
				
				
/*				for (int itern=0;itern<travelBookingRequest.getObjtraindetailList().size();itern++) {
	        	  Date trinarrDate = null; 
	        	  Date traindepartDate =null;
	        	  
	        	   String airarriDate = travelBookingRequest.getObjtraindetailList().get(itern).getTrainarrivalDate();
	        	   if(!airarriDate.isEmpty()) {    
						trinarrDate = formatterDate.parse(airarriDate);
			       }
					
	        	  
	        	   String traindprtdate = travelBookingRequest.getObjtraindetailList().get(itern).getTraindepartDate();
	             if(!traindprtdate.isEmpty()) {	    
						traindepartDate = formatterDate.parse(traindprtdate);  
	        	  }

					jdbcTemplate.update(TravelBookingRequestQueryUtil.INSERT_TRAIN_DEPATURE_DTL,travelBookingRequest.getObjtraindetailList().get(itern).getTrainDeparture(),travelBookingRequest.getObjtraindetailList().get(itern).getTrainArrival(),travelBookingRequest.getObjtraindetailList().get(itern).getTrainDepartureTime(),
							travelBookingRequest.getObjtraindetailList().get(itern).getTrainArrivalTime(),traindepartDate,trinarrDate,travelBookingRequest.getRequestId());
				}*/
				
				
				List trainTable = travelBookingRequest.getTrainPassengerTables();
				for (int i = 0; i < trainTable.size(); i++) {
					HashMap map = (HashMap) trainTable.get(i);

					ArrayList trainTableRowDetails = (ArrayList) map.get("subTrainRow");
					for (int j = 0; j < trainTableRowDetails.size(); j++) {
						HashMap trainRowMap = (HashMap) trainTableRowDetails.get(j);
						autoGenPassengerId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelPassengerIdAutoGen, String.class);
						travelBookingRequest.setPassengerId(Integer.parseInt(autoGenPassengerId));

						String firstName = (String) trainRowMap.get("firstName");
						String lastName = (String) trainRowMap.get("lastName");
						int sex = Integer.parseInt(trainRowMap.get("sex").toString());
						int age = Integer.parseInt(trainRowMap.get("age").toString());
						jdbcTemplate.update(TravelBookingRequestQueryUtil.travelPassengerDetails, travelBookingRequest.getRequestId(), firstName, lastName, sex, age, travelBookingRequest.getPassengerId());
					}

				}
				success=true;
			}

			if (travelBooking == 2) {
				String airReqDate = travelBookingRequest.getAirRequestDate();
				Date airRequestDate = formatterDate.parse(airReqDate);

				String airTraDate = travelBookingRequest.getAirTravelDate();
				Date airTravelDate = formatterDate.parse(airTraDate);
				

				
		
				
				boolean retDate = travelBookingRequest.isAirReturnTicket();
				Date airReturnDate = null;
				String airRetArrivalTime = "";
				String airRetDepartureTime = "";

				if (retDate == true) {
					String airRetDate = travelBookingRequest.getAirReturnDate();
					airReturnDate = formatterDate.parse(airRetDate);

					airRetArrivalTime = travelBookingRequest.getAirRetArrTime();

					airRetDepartureTime = travelBookingRequest.getAirRetDepTime();
				}
				String airArrivalTime = travelBookingRequest.getAirArrivalTime();

				String airDepartureTime = travelBookingRequest.getAirDepartureTime();

				jdbcTemplate.update(TravelBookingRequestQueryUtil.insert_travelBookingRequest_Data, travelBookingRequest.getRequestId(), teampUser.getUserId(), airRequestDate, travelBookingRequest.getAirReason(), travelBookingRequest.getAirRequestFor(), travelBookingRequest.getRequestType(), travelBookingRequest.getAirReqStatus(), teampUser.getUserId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.insert_airTravelBookingRequest_Data, travelBookingRequest.getRequestId(), airTravelDate, travelBookingRequest.isAirReturnTicket(), airReturnDate, travelBookingRequest.getAirTravelClass(), travelBookingRequest.getAirPreferFlight(), travelBookingRequest.getAirNoOfPass(), travelBookingRequest.getAirMealPrefer(), true, travelBookingRequest.isAirPickUpReq(), travelBookingRequest.getAirArrival(), travelBookingRequest.getAirDeparture(), airArrivalTime, airDepartureTime,
						travelBookingRequest.getAirReturnArr(), travelBookingRequest.getAirReturnDep(), airRetArrivalTime, airRetDepartureTime);

				
				for (TravelBookingRequest objAirDetailBean : travelBookingRequest.getTables()) {
					
					String airarrDate=null;
					String departDate=null;
					
					if(!objAirDetailBean.getAirarrivalDate().isEmpty() && objAirDetailBean.getAirarrivalDate()!=null) {    
						airarrDate = objAirDetailBean.getAirarrivalDate();
			       }
					
	        	  
	             if(!objAirDetailBean.getAirdepartDate().isEmpty() && objAirDetailBean.getAirdepartDate()!=null) {	    
	            	 departDate = objAirDetailBean.getAirdepartDate();  
	        	  }
					
					jdbcTemplate.update(TravelBookingRequestQueryUtil.INSERT_DEPATURE_DTL,objAirDetailBean.getAirDeparture(),objAirDetailBean.getAirArrival(),objAirDetailBean.getAirDepartureTime(),
							objAirDetailBean.getAirArrivalTime(),departDate,airarrDate,travelBookingRequest.getRequestId());
				}

				/*for (int itern=0;itern<travelBookingRequest.getTables().size();itern++) {
					
					String airarriDate = travelBookingRequest.getTables().get(itern).getAirarrivalDate();
					Date airarrDate = formatterDate.parse(airarriDate);
					
					
					String traindprtdate = travelBookingRequest.getTables().get(itern).getAirdepartDate();
					Date departDate = formatterDate.parse(traindprtdate);

					jdbcTemplate.update(TravelBookingRequestQueryUtil.INSERT_DEPATURE_DTL,travelBookingRequest.getTables().get(itern).getAirDeparture(),travelBookingRequest.getTables().get(itern).getAirArrival(),travelBookingRequest.getTables().get(itern).getAirDepartureTime(),
							travelBookingRequest.getTables().get(itern).getAirArrivalTime(),departDate,airarrDate,travelBookingRequest.getRequestId());
				}*/
				
				List airTable = travelBookingRequest.getAirPassengerTables();
				for (int i = 0; i < airTable.size(); i++) {
					HashMap map = (HashMap) airTable.get(i);

					ArrayList trainTableRowDetails = (ArrayList) map.get("subAirRow");
					for (int j = 0; j < trainTableRowDetails.size(); j++) {
						HashMap trainRowMap = (HashMap) trainTableRowDetails.get(j);
						autoGenPassengerId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelPassengerIdAutoGen, String.class);
						travelBookingRequest.setPassengerId(Integer.parseInt(autoGenPassengerId));

						String firstName = (String) trainRowMap.get("firstName");
						String lastName = (String) trainRowMap.get("lastName");
						int sex = Integer.parseInt(trainRowMap.get("sex").toString());
						int age = Integer.parseInt(trainRowMap.get("age").toString());
						jdbcTemplate.update(TravelBookingRequestQueryUtil.travelPassengerDetails, travelBookingRequest.getRequestId(), firstName, lastName, sex, age, travelBookingRequest.getPassengerId());
					}

				}
				success=true;
			}

			if (travelBooking == 3) {
				String hotelReqDate = travelBookingRequest.getHotelRequestDate();
				Date hotelRequestDate = formatterDate.parse(hotelReqDate);

				String hotelDateOfBook = travelBookingRequest.getHotelDoB();
				Date hotelDoB = formatterDate.parse(hotelDateOfBook);

				String hotelDateOfLeave = travelBookingRequest.getHotelDoL();
				Date hotelDoL = formatterDate.parse(hotelDateOfLeave);

				String hotelCheckInTime = travelBookingRequest.getHotelCheckInTime();

				String hotelCheckOutTime = travelBookingRequest.getHotelCheckOutTime();

				jdbcTemplate.update(TravelBookingRequestQueryUtil.insert_travelBookingRequest_Data, travelBookingRequest.getRequestId(), teampUser.getUserId(), hotelRequestDate, travelBookingRequest.getHotelReason(), travelBookingRequest.getHotelRequestFor(), travelBookingRequest.getRequestType(), travelBookingRequest.getHotelReqStatus(), teampUser.getUserId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.insert_hotelTravelBookingRequest_Data, travelBookingRequest.getRequestId(), hotelDoB, hotelDoL, hotelCheckInTime, hotelCheckOutTime, travelBookingRequest.getHotelFacility(), travelBookingRequest.getHotelPreferOption(), travelBookingRequest.getHotelPaymentMode(), travelBookingRequest.getHotelNoOfAdults(), travelBookingRequest.getHotelNoOfChild(), travelBookingRequest.isHotelRestFacility(), travelBookingRequest.getHotelCategory(), travelBookingRequest.getHotelPreferRoom(),
						travelBookingRequest.getHotelMealPrefer(), travelBookingRequest.getHotelCheckOut(),travelBookingRequest.getHotelRequestType());

				List hotelTable = travelBookingRequest.getHotelPassengerTables();
				for (int i = 0; i < hotelTable.size(); i++) {
					HashMap map = (HashMap) hotelTable.get(i);

					ArrayList trainTableRowDetails = (ArrayList) map.get("subHotelRow");
					for (int j = 0; j < trainTableRowDetails.size(); j++) {
						HashMap trainRowMap = (HashMap) trainTableRowDetails.get(j);
						autoGenPassengerId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelPassengerIdAutoGen, String.class);
						travelBookingRequest.setPassengerId(Integer.parseInt(autoGenPassengerId));

						String firstName = (String) trainRowMap.get("firstName");
						String lastName = (String) trainRowMap.get("lastName");
						int sex = Integer.parseInt(trainRowMap.get("sex").toString());
						int age = Integer.parseInt(trainRowMap.get("age").toString());
						jdbcTemplate.update(TravelBookingRequestQueryUtil.travelPassengerDetails, travelBookingRequest.getRequestId(), firstName, lastName, sex, age, travelBookingRequest.getPassengerId());
					}

				}
				success=true;
			}
			resultBean.setSuccess(success);
			}else {
				resultBean.setSuccess(false);
				resultBean.setMessage("Work Flow is not mapped");	
			}
			
		} catch (Exception e) {
			resultBean.setSuccess(false);
			resultBean.setMessage(e.getMessage());
			LOGGER.error("Error in insertTravelBookingRequest", e.getMessage());
		}
		
		return resultBean;
	}

	@Override
	public TravelBookingRequest getTravelBookingEdit(int travelBookingRequestId) throws CustomException {
		TravelBookingRequest travelBookingRequest = null;
		TravelBookingRequest travelBookingRequest1 = null;
		int travelBookingType = 0;
		List<TravelBookingRequest> travelPassenger = new ArrayList<TravelBookingRequest>();
		List<TravelBookingRequest> travelDeptArrive = new ArrayList<TravelBookingRequest>();
		List<TravelBookingRequest> workFlowList = new ArrayList<TravelBookingRequest>();

		try {
			travelBookingType = jdbcTemplate.queryForObject("select request_type from travel_booking_request where request_id =?" ,new Object[] {travelBookingRequestId},Integer.class);
			if (travelBookingType == 1) {

				travelBookingRequest = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.getTravelTrainBookingEditList, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class), travelBookingRequestId);
				List<Map<String, Object>> travelPassengerTrainList = jdbcTemplate.queryForList(TravelBookingRequestQueryUtil.getPassengerDetailsList, new Object[] { travelBookingRequestId });
				for (Map<String, Object> row : travelPassengerTrainList) {
					travelBookingRequest1 = new TravelBookingRequest();
					travelBookingRequest1.setPassengerId(Integer.parseInt(row.get("passenger_details_id").toString()));
					travelBookingRequest1.setFirstName(row.get("passenger_first_name").toString());
					travelBookingRequest1.setLastName(row.get("passenger_last_name").toString());
					travelBookingRequest1.setSex((int) row.get("passenger_gender"));
					travelBookingRequest1.setAge(Integer.parseInt(row.get("age").toString()));
					travelPassenger.add(travelBookingRequest1);
				}
				travelBookingRequest.setTravelPassList(travelPassenger);
				
				
				List<Map<String, Object>> travelAirDepaturAirList = jdbcTemplate.queryForList(TravelBookingRequestQueryUtil.GET_DEPRT_ATRRIVE_LIST_TRAIN, new Object[] { travelBookingRequestId });
				for (Map<String, Object> row : travelAirDepaturAirList) {
					travelBookingRequest1 = new TravelBookingRequest();
					travelBookingRequest1.setDeptarrivdtlIdtrain(Integer.parseInt(row.get("train_dept_arrive_details_id").toString()));
					if(row.get("train_depature")!=null) {
					travelBookingRequest1.setTrainDeparture(row.get("train_depature").toString());
					}
					if(row.get("train_arrival")!=null) {
						travelBookingRequest1.setTrainArrival(row.get("train_arrival").toString());	
					}
					if(row.get("train_depature_time")!=null) {
						travelBookingRequest1.setTrainDepartureTime(row.get("train_depature_time").toString());
					}
					if(row.get("train_arrival_time")!=null) {
						travelBookingRequest1.setTrainArrivalTime(row.get("train_arrival_time").toString());	
					}
					
					if(row.get("train_depature_date")!=null) {
						travelBookingRequest1.setTraindepartDate(row.get("train_depature_date").toString());
					}
					if(row.get("train_arrival_date")!=null) {
						travelBookingRequest1.setTrainarrivalDate(row.get("train_arrival_date").toString());
					}
					
					travelDeptArrive.add(travelBookingRequest1);
				}
				travelBookingRequest.setObjtraindetailList(travelDeptArrive);
				
				List<Map<String, Object>> workFlowList1 = jdbcTemplate.queryForList(TravelBookingRequestQueryUtil.getworkFlowViewList, new Object[] { travelBookingRequestId });
				for (Map<String, Object> row : workFlowList1) {
					travelBookingRequest1 = new TravelBookingRequest();
					
					if(row.get("stepName")!=null) {
						travelBookingRequest1.setStepName(row.get("stepName").toString());	
					}
					if(row.get("approvedBy")!=null) {
						travelBookingRequest1.setApprovedBy(row.get("approvedBy").toString());	
					}
					if(row.get("approvedDate")!=null) {
						travelBookingRequest1.setApprovedDate(row.get("approvedDate").toString());
					}
					if(row.get("stepRemarks")!=null) {
						travelBookingRequest1.setStepRemarks(row.get("stepRemarks").toString());
					}
					if(row.get("stepStatus")!=null) {
						travelBookingRequest1.setStepStatus(row.get("stepStatus").toString());	
					}
					workFlowList.add(travelBookingRequest1);
				}
				travelBookingRequest.setWorkFlowList(workFlowList);
			}
			if (travelBookingType == 2) {

				travelBookingRequest = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.getTravelAirBookingEditList, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class), travelBookingRequestId);
				List<Map<String, Object>> travelPassengerAirList = jdbcTemplate.queryForList(TravelBookingRequestQueryUtil.getPassengerDetailsList, new Object[] { travelBookingRequestId });
				for (Map<String, Object> row : travelPassengerAirList) {
				    travelBookingRequest1 = new TravelBookingRequest();
					travelBookingRequest1.setPassengerId(Integer.parseInt(row.get("passenger_details_id").toString()));
					travelBookingRequest1.setFirstName(row.get("passenger_first_name").toString());
					travelBookingRequest1.setLastName(row.get("passenger_last_name").toString());
					travelBookingRequest1.setSex((int) row.get("passenger_gender"));
					travelBookingRequest1.setAge(Integer.parseInt(row.get("age").toString()));
					travelPassenger.add(travelBookingRequest1);
				}
				travelBookingRequest.setTravelPassList(travelPassenger);
				
				List<Map<String, Object>> travelAirDepaturAirList = jdbcTemplate.queryForList(TravelBookingRequestQueryUtil.GET_DEPRT_ATRRIVE_LIST, new Object[] { travelBookingRequestId });
				for (Map<String, Object> row : travelAirDepaturAirList) {
					travelBookingRequest1 = new TravelBookingRequest();
					travelBookingRequest1.setDeptarrivdtlId(Integer.parseInt(row.get("dept_arrive_details_id").toString()));
					if(row.get("air_depature")!=null) {
						travelBookingRequest1.setAirDeparture(row.get("air_depature").toString());
					}
					if(row.get("air_arrival")!=null) {
						travelBookingRequest1.setAirArrival(row.get("air_arrival").toString());
					}
					if(row.get("air_depature_time")!=null) {
						travelBookingRequest1.setAirDepartureTime(row.get("air_depature_time").toString());	
					}
					if(row.get("air_arrival_time")!=null) {
						travelBookingRequest1.setAirArrivalTime(row.get("air_arrival_time").toString());
					}
				
					if(row.get("air_depature_date")!=null) {
						travelBookingRequest1.setAirdepartDate(row.get("air_depature_date").toString());	
					}
					if(row.get("air_arrival_date")!=null) {
						travelBookingRequest1.setAirarrivalDate(row.get("air_arrival_date").toString());
	
					}
					travelDeptArrive.add(travelBookingRequest1);
				}
				travelBookingRequest.setTables(travelDeptArrive);
				
				
				List<Map<String, Object>> workFlowList1 = jdbcTemplate.queryForList(TravelBookingRequestQueryUtil.getworkFlowViewList, new Object[] { travelBookingRequestId });
				for (Map<String, Object> row : workFlowList1) {
					travelBookingRequest1 = new TravelBookingRequest();
					
					
					if(row.get("stepName")!=null) {
						travelBookingRequest1.setStepName(row.get("stepName").toString());	
					}
					if(row.get("approvedBy")!=null) {
						travelBookingRequest1.setApprovedBy(row.get("approvedBy").toString());	
					}
					if(row.get("approvedDate")!=null) {
						travelBookingRequest1.setApprovedDate(row.get("approvedDate").toString());
					}
					if(row.get("stepRemarks")!=null) {
						travelBookingRequest1.setStepRemarks(row.get("stepRemarks").toString());
					}
					if(row.get("stepStatus")!=null) {
						travelBookingRequest1.setStepStatus(row.get("stepStatus").toString());	
					}
					
					
					
					workFlowList.add(travelBookingRequest1);
				}
				travelBookingRequest.setWorkFlowList(workFlowList);

			}
			if (travelBookingType == 3) {

				travelBookingRequest = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.getTravelHotelBookingEditList, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class), travelBookingRequestId);
				List<Map<String, Object>> travelPassengerHotelList = jdbcTemplate.queryForList(TravelBookingRequestQueryUtil.getPassengerDetailsList, new Object[] { travelBookingRequestId });
				for (Map<String, Object> row : travelPassengerHotelList) {
					travelBookingRequest1 = new TravelBookingRequest();
					travelBookingRequest1.setPassengerId(Integer.parseInt(row.get("passenger_details_id").toString()));
					travelBookingRequest1.setFirstName(row.get("passenger_first_name").toString());
					travelBookingRequest1.setLastName(row.get("passenger_last_name").toString());
					travelBookingRequest1.setSex((int) row.get("passenger_gender"));
					travelBookingRequest1.setAge(Integer.parseInt(row.get("age").toString()));
					travelPassenger.add(travelBookingRequest1);
				}
				travelBookingRequest.setTravelPassList(travelPassenger);
				
				List<Map<String, Object>> workFlowList1 = jdbcTemplate.queryForList(TravelBookingRequestQueryUtil.getworkFlowViewList, new Object[] { travelBookingRequestId });
				for (Map<String, Object> row : workFlowList1) {
					travelBookingRequest1 = new TravelBookingRequest();
					
					if(row.get("stepName")!=null) {
						travelBookingRequest1.setStepName(row.get("stepName").toString());	
					}
					if(row.get("approvedBy")!=null) {
						travelBookingRequest1.setApprovedBy(row.get("approvedBy").toString());	
					}
					if(row.get("approvedDate")!=null) {
						travelBookingRequest1.setApprovedDate(row.get("approvedDate").toString());
					}
					if(row.get("stepRemarks")!=null) {
						travelBookingRequest1.setStepRemarks(row.get("stepRemarks").toString());
					}
					if(row.get("stepStatus")!=null) {
						travelBookingRequest1.setStepStatus(row.get("stepStatus").toString());	
					}
					workFlowList.add(travelBookingRequest1);
				}
				travelBookingRequest.setWorkFlowList(workFlowList);

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTravelBookingEditList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return travelBookingRequest;
	}

	@Override
	public TravelBookingRequestResultBean updateTravelBookingRequestList(TravelBookingRequest travelBookingRequest) throws CustomException {

		TravelBookingRequestResultBean resultBean=new TravelBookingRequestResultBean();
		DateFormat formatterDate;
		formatterDate = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat formatterTime = new SimpleDateFormat("hh:mm");
		int travelBookingType = travelBookingRequest.getRequestType();
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String autoGenTrvlPsngrId = "";
		boolean success=false;
		try {
			if (travelBookingType == 1) {

				String trainReqDate = travelBookingRequest.getTrainRequestDate();
				Date trainRequestDate = formatterDate.parse(trainReqDate);

				String trainTraDate = travelBookingRequest.getTrainTravelDate();
				Date trainTravelDate = formatterDate.parse(trainTraDate);
				boolean retDate = travelBookingRequest.isTrainReturnTicket();
				Date trainReturnDate = null;
				java.sql.Timestamp trainRetArrivalTime = null;
				java.sql.Timestamp trainRetDepartureTime = null;
				String trainRetArrTime = "";
				String trainRetDepTime = "";

				if (retDate == true) {
					String trainRetDate = travelBookingRequest.getTrainReturnDate();
					trainReturnDate = formatterDate.parse(trainRetDate);

					trainRetArrTime = travelBookingRequest.getTrainRetArrTime();

					trainRetDepTime = travelBookingRequest.getTrainRetDepTime();
				}
				String trainArrTime = travelBookingRequest.getTrainArrivalTime();

				String trainDepTime = travelBookingRequest.getTrainDepartureTime();

				int noOfTrainPass = jdbcTemplate.queryForObject("select no_of_passengers from travel_train_booking_request where request_id=?" ,new Object[] { travelBookingRequest.getRequestId()},Integer.class);
				int beanNoOfTrainPass = travelBookingRequest.getTrainNoOfPass();
				List trainTable = travelBookingRequest.getTrainPassengerTables();
				if (beanNoOfTrainPass != noOfTrainPass) {

					for (int i = 0; i < trainTable.size(); i++) {
						HashMap map = (HashMap) trainTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subTrainRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							jdbcTemplate.update(TravelBookingRequestQueryUtil.deletetravelPassengerDetails, travelBookingRequest.getRequestId());
						}
					}
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travelBookingRequest_Data, teampUser.getUserId(), trainRequestDate, travelBookingRequest.getTrainReason(), travelBookingRequest.getTrainRequestFor(), travelBookingRequest.getRequestType(), travelBookingRequest.getTrainReqStatus(), travelBookingRequest.getRequestId());
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_trainTravelBookingRequest_Data,travelBookingRequest.getTrainTraveltype(),travelBookingRequest.getTrainPreferBerth(), travelBookingRequest.getTrainArrival(), travelBookingRequest.getTrainDeparture(), travelBookingRequest.isTrainPickUpReq(), travelBookingRequest.isTrainReturnTicket(), travelBookingRequest.getTrainQuota(), trainTravelDate, travelBookingRequest.getTrainNoOfPass(), travelBookingRequest.getTrainPreferTrainNo(), travelBookingRequest.getTrainPreferTrainName(), travelBookingRequest.getTrainClass(),
							trainArrTime, trainDepTime, travelBookingRequest.getTrainMealPrefer(), trainReturnDate, travelBookingRequest.getTrainReturnArr(), travelBookingRequest.getTrainReturnDep(), trainRetArrTime, trainRetDepTime, travelBookingRequest.getRequestId());
					for (int i = 0; i < trainTable.size(); i++) {
						HashMap map = (HashMap) trainTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subTrainRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							HashMap trainRowMap = (HashMap) trainTableRowDetails.get(j);
							autoGenTrvlPsngrId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelPassengerIdAutoGen, String.class);
							travelBookingRequest.setPassengerId(Integer.parseInt(autoGenTrvlPsngrId));
							String firstName = (String) trainRowMap.get("firstName");
							String lastName = (String) trainRowMap.get("lastName");
							int sex = Integer.parseInt(trainRowMap.get("sex").toString());
							int age = Integer.parseInt(trainRowMap.get("age").toString());
							jdbcTemplate.update(TravelBookingRequestQueryUtil.travelPassengerDetails, travelBookingRequest.getRequestId(), firstName, lastName, sex, age, travelBookingRequest.getPassengerId());
						}

					}
					
					jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_Train_DEPATURE_DETAILS, travelBookingRequest.getRequestId());
					
					for (TravelBookingRequest objDetailBean : travelBookingRequest.getObjtraindetailList()) {
						  String trinarrDate = null; 
						  String traindepartDate =null;
						
			        	   if(!objDetailBean.getTrainarrivalDate().isEmpty() && objDetailBean.getTrainarrivalDate()!=null) {    
								trinarrDate = objDetailBean.getTrainarrivalDate();
					       }
							
			        	  
			             if(!objDetailBean.getTraindepartDate().isEmpty() && objDetailBean.getTraindepartDate()!=null) {	    
								traindepartDate = objDetailBean.getTraindepartDate();  
			        	  }
						
						jdbcTemplate.update(TravelBookingRequestQueryUtil.INSERT_TRAIN_DEPATURE_DTL,objDetailBean.getTrainDeparture(),objDetailBean.getTrainArrival(),objDetailBean.getTrainDepartureTime(),
								objDetailBean.getTrainArrivalTime(),trinarrDate,traindepartDate,travelBookingRequest.getRequestId());	
						
					}
					
					
				} else {
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travelBookingRequest_Data, teampUser.getUserId(), trainRequestDate, travelBookingRequest.getTrainReason(), travelBookingRequest.getTrainRequestFor(), travelBookingRequest.getRequestType(), travelBookingRequest.getTrainReqStatus(), 
							travelBookingRequest.getRequestId());
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_trainTravelBookingRequest_Data,travelBookingRequest.getTrainTraveltype(),travelBookingRequest.getTrainPreferBerth(), travelBookingRequest.getTrainArrival(), travelBookingRequest.getTrainDeparture(), travelBookingRequest.isTrainPickUpReq(), travelBookingRequest.isTrainReturnTicket(), travelBookingRequest.getTrainQuota(), trainTravelDate, travelBookingRequest.getTrainNoOfPass(), travelBookingRequest.getTrainPreferTrainNo(), travelBookingRequest.getTrainPreferTrainName(), travelBookingRequest.getTrainClass(),
							trainArrTime, trainDepTime, travelBookingRequest.getTrainMealPrefer(), trainReturnDate, travelBookingRequest.getTrainReturnArr(), travelBookingRequest.getTrainReturnDep(), trainRetArrTime, trainRetDepTime, travelBookingRequest.getRequestId());

					for (int i = 0; i < trainTable.size(); i++) {
						HashMap map = (HashMap) trainTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subTrainRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							jdbcTemplate.update(TravelBookingRequestQueryUtil.deletetravelPassengerDetails, travelBookingRequest.getRequestId());
						}
					}

					for (int i = 0; i < trainTable.size(); i++) {
						HashMap map = (HashMap) trainTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subTrainRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							HashMap trainRowMap = (HashMap) trainTableRowDetails.get(j);
							autoGenTrvlPsngrId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelPassengerIdAutoGen, String.class);
							travelBookingRequest.setPassengerId(Integer.parseInt(autoGenTrvlPsngrId));
							String firstName = (String) trainRowMap.get("firstName");
							String lastName = (String) trainRowMap.get("lastName");
							int sex = Integer.parseInt(trainRowMap.get("sex").toString());
							int age = Integer.parseInt(trainRowMap.get("age").toString());
							jdbcTemplate.update(TravelBookingRequestQueryUtil.travelPassengerDetails, travelBookingRequest.getRequestId(), firstName, lastName, sex, age, travelBookingRequest.getPassengerId());
						}

					}
					
                    jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_Train_DEPATURE_DETAILS, travelBookingRequest.getRequestId());
					
					for (TravelBookingRequest objDetailBean : travelBookingRequest.getObjtraindetailList()) {
						  String trinarrDate = null; 
						  String traindepartDate =null;
						
			        	   if(!objDetailBean.getTrainarrivalDate().isEmpty() && objDetailBean.getTrainarrivalDate()!=null) {    
								trinarrDate = objDetailBean.getTrainarrivalDate();
					       }
							
			        	  
			             if(!objDetailBean.getTraindepartDate().isEmpty() && objDetailBean.getTraindepartDate()!=null) {	    
								traindepartDate = objDetailBean.getTraindepartDate();  
			        	  }
						
						jdbcTemplate.update(TravelBookingRequestQueryUtil.INSERT_TRAIN_DEPATURE_DTL,objDetailBean.getTrainDeparture(),objDetailBean.getTrainArrival(),objDetailBean.getTrainDepartureTime(),
								objDetailBean.getTrainArrivalTime(),trinarrDate,traindepartDate,travelBookingRequest.getRequestId());	
						
					}
				}
				success=true;
			}

			if (travelBookingType == 2) {
				String airReqDate = travelBookingRequest.getAirRequestDate();
				Date airRequestDate = formatterDate.parse(airReqDate);

				String airTraDate = travelBookingRequest.getAirTravelDate();
				Date airTravelDate = formatterDate.parse(airTraDate);
				boolean retDate = travelBookingRequest.isAirReturnTicket();
				Date airReturnDate = null;
				String airRetArrivalTime = "";
				String airRetDepartureTime = "";

				if (retDate == true) {
					String airRetDate = travelBookingRequest.getAirReturnDate();
					airReturnDate = formatterDate.parse(airRetDate);

					airRetArrivalTime = travelBookingRequest.getAirRetArrTime();

					airRetDepartureTime = travelBookingRequest.getAirRetDepTime();
				}
				String airArrivalTime = travelBookingRequest.getAirArrivalTime();

				String airDepartureTime = travelBookingRequest.getAirDepartureTime();

				int noOfAirPass = jdbcTemplate.queryForObject("select no_of_passengers from travel_air_booking_request where request_id= ?" ,new Object[]{ travelBookingRequest.getRequestId()},Integer.class);
				int beanNoOfAirPass = travelBookingRequest.getAirNoOfPass();
				List airTable = travelBookingRequest.getAirPassengerTables();
				if (beanNoOfAirPass != noOfAirPass) {

					for (int i = 0; i < airTable.size(); i++) {
						HashMap map = (HashMap) airTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subAirRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							jdbcTemplate.update(TravelBookingRequestQueryUtil.deletetravelPassengerDetails, travelBookingRequest.getRequestId());
						}
					}
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travelBookingRequest_Data, teampUser.getUserId(), airRequestDate, travelBookingRequest.getAirReason(), travelBookingRequest.getAirRequestFor(), travelBookingRequest.getRequestType(), travelBookingRequest.getAirReqStatus(), travelBookingRequest.getRequestId());
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_airTravelBookingRequest_Data, airTravelDate, travelBookingRequest.isAirReturnTicket(), airReturnDate, travelBookingRequest.getAirTravelClass(), travelBookingRequest.getAirPreferFlight(), travelBookingRequest.getAirNoOfPass(), travelBookingRequest.getAirMealPrefer(), true, travelBookingRequest.isAirPickUpReq(), travelBookingRequest.getAirArrival(), travelBookingRequest.getAirDeparture(), airArrivalTime, airDepartureTime, travelBookingRequest.getAirReturnArr(),
							travelBookingRequest.getAirReturnDep(), airRetArrivalTime, airRetDepartureTime, travelBookingRequest.getRequestId());
					for (int i = 0; i < airTable.size(); i++) {
						HashMap map = (HashMap) airTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subAirRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							HashMap trainRowMap = (HashMap) trainTableRowDetails.get(j);
							autoGenTrvlPsngrId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelPassengerIdAutoGen, String.class);
							travelBookingRequest.setPassengerId(Integer.parseInt(autoGenTrvlPsngrId));

							String firstName = (String) trainRowMap.get("firstName");
							String lastName = (String) trainRowMap.get("lastName");
							int sex = Integer.parseInt(trainRowMap.get("sex").toString());
							int age = Integer.parseInt(trainRowMap.get("age").toString());
							jdbcTemplate.update(TravelBookingRequestQueryUtil.travelPassengerDetails, travelBookingRequest.getRequestId(), firstName, lastName, sex, age, travelBookingRequest.getPassengerId());
						}

					}
					
					jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_Air_DEPATURE_DETAILS, travelBookingRequest.getRequestId());
					
					for (TravelBookingRequest objAirDetailBean : travelBookingRequest.getTables()) {
						
						String airarrDate=null;
						String departDate=null;
						
						if(!objAirDetailBean.getAirarrivalDate().isEmpty() && objAirDetailBean.getAirarrivalDate()!=null) {    
							airarrDate = objAirDetailBean.getAirarrivalDate();
				       }
						
		        	  
		             if(!objAirDetailBean.getAirdepartDate().isEmpty() && objAirDetailBean.getAirdepartDate()!=null) {	    
		            	 departDate = objAirDetailBean.getAirdepartDate();  
		        	  }
						
						jdbcTemplate.update(TravelBookingRequestQueryUtil.INSERT_DEPATURE_DTL,objAirDetailBean.getAirDeparture(),objAirDetailBean.getAirArrival(),objAirDetailBean.getAirDepartureTime(),
								objAirDetailBean.getAirArrivalTime(),departDate,airarrDate,travelBookingRequest.getRequestId());
					}
					
				} else {
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travelBookingRequest_Data, teampUser.getUserId(), airRequestDate, travelBookingRequest.getAirReason(), travelBookingRequest.getAirRequestFor(), travelBookingRequest.getRequestType(), travelBookingRequest.getAirReqStatus(), travelBookingRequest.getRequestId());
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_airTravelBookingRequest_Data, airTravelDate, travelBookingRequest.isAirReturnTicket(), airReturnDate, travelBookingRequest.getAirTravelClass(), travelBookingRequest.getAirPreferFlight(), travelBookingRequest.getAirNoOfPass(), travelBookingRequest.getAirMealPrefer(), true, travelBookingRequest.isAirPickUpReq(), travelBookingRequest.getAirArrival(), travelBookingRequest.getAirDeparture(), airArrivalTime, airDepartureTime, travelBookingRequest.getAirReturnArr(),
							travelBookingRequest.getAirReturnDep(), airRetArrivalTime, airRetDepartureTime, travelBookingRequest.getRequestId());

					for (int i = 0; i < airTable.size(); i++) {
						HashMap map = (HashMap) airTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subAirRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							jdbcTemplate.update(TravelBookingRequestQueryUtil.deletetravelPassengerDetails, travelBookingRequest.getRequestId());
						}
					}
					for (int i = 0; i < airTable.size(); i++) {
						HashMap map = (HashMap) airTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subAirRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							HashMap trainRowMap = (HashMap) trainTableRowDetails.get(j);
							autoGenTrvlPsngrId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelPassengerIdAutoGen, String.class);
							travelBookingRequest.setPassengerId(Integer.parseInt(autoGenTrvlPsngrId));

							String firstName = (String) trainRowMap.get("firstName");
							String lastName = (String) trainRowMap.get("lastName");
							int sex = Integer.parseInt(trainRowMap.get("sex").toString());
							int age = Integer.parseInt(trainRowMap.get("age").toString());
							jdbcTemplate.update(TravelBookingRequestQueryUtil.travelPassengerDetails, travelBookingRequest.getRequestId(), firstName, lastName, sex, age, travelBookingRequest.getPassengerId());
						}

					}
					
                   jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_Air_DEPATURE_DETAILS, travelBookingRequest.getRequestId());
					
					for (TravelBookingRequest objAirDetailBean : travelBookingRequest.getTables()) {
						
						String airarrDate=null;
						String departDate=null;
						
						if(!objAirDetailBean.getAirarrivalDate().isEmpty() && objAirDetailBean.getAirarrivalDate()!=null) {    
							airarrDate = objAirDetailBean.getAirarrivalDate();
				       }
						
		        	  
		             if(!objAirDetailBean.getAirdepartDate().isEmpty() && objAirDetailBean.getAirdepartDate()!=null) {	    
		            	 departDate = objAirDetailBean.getAirdepartDate();  
		        	  }
						
						jdbcTemplate.update(TravelBookingRequestQueryUtil.INSERT_DEPATURE_DTL,objAirDetailBean.getAirDeparture(),objAirDetailBean.getAirArrival(),objAirDetailBean.getAirDepartureTime(),
								objAirDetailBean.getAirArrivalTime(),departDate,airarrDate,travelBookingRequest.getRequestId());
					}
				}
				success=true;
			}

			if (travelBookingType == 3) {
				String hotelReqDate = travelBookingRequest.getHotelRequestDate();
				Date hotelRequestDate = formatterDate.parse(hotelReqDate);

				String hotelDateOfBook = travelBookingRequest.getHotelDoB();
				Date hotelDoB = formatterDate.parse(hotelDateOfBook);

				String hotelDateOfLeave = travelBookingRequest.getHotelDoL();
				Date hotelDoL = formatterDate.parse(hotelDateOfLeave);

				String hotelCheckInTime = travelBookingRequest.getHotelCheckInTime();

				String hotelCheckOutTime = travelBookingRequest.getHotelCheckOutTime();

				//int noOfMembers = jdbcTemplate.queryForInt("select (no_of_adults+no_of_childs) as members from travel_hotel_booking_request where request_id=" + travelBookingRequest.getRequestId());
				
				int noOfMembers = jdbcTemplate.queryForObject("select (no_of_adults+no_of_childs) as members from travel_hotel_booking_request where request_id=?",new Object[] {travelBookingRequest.getRequestId() }, Integer.class);

			
				int beanNoOfMembers = travelBookingRequest.getHotelNoOfAdults() + travelBookingRequest.getHotelNoOfChild();
				List hotelTable = travelBookingRequest.getHotelPassengerTables();
				if (beanNoOfMembers != noOfMembers) {

					for (int i = 0; i < hotelTable.size(); i++) {
						HashMap map = (HashMap) hotelTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subHotelRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							jdbcTemplate.update(TravelBookingRequestQueryUtil.deletetravelPassengerDetails, travelBookingRequest.getRequestId());
						}
					}
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travelBookingRequest_Data, teampUser.getUserId(), hotelRequestDate, travelBookingRequest.getHotelReason(), travelBookingRequest.getHotelRequestFor(), travelBookingRequest.getRequestType(), travelBookingRequest.getHotelReqStatus(), travelBookingRequest.getRequestId());
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_hotelTravelBookingRequest_Data,travelBookingRequest.getHotelRequestType(),hotelDoB, hotelDoL, hotelCheckInTime, hotelCheckOutTime, travelBookingRequest.getHotelFacility(), travelBookingRequest.getHotelPreferOption(), travelBookingRequest.getHotelPaymentMode(), travelBookingRequest.getHotelNoOfAdults(), travelBookingRequest.getHotelNoOfChild(), travelBookingRequest.isHotelRestFacility(), travelBookingRequest.getHotelCategory(), travelBookingRequest.getHotelPreferRoom(), travelBookingRequest.getHotelMealPrefer(),
							travelBookingRequest.getHotelCheckOut(), travelBookingRequest.getRequestId());
					for (int i = 0; i < hotelTable.size(); i++) {
						HashMap map = (HashMap) hotelTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subHotelRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							HashMap trainRowMap = (HashMap) trainTableRowDetails.get(j);
							autoGenTrvlPsngrId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelPassengerIdAutoGen, String.class);
							travelBookingRequest.setPassengerId(Integer.parseInt(autoGenTrvlPsngrId));

							String firstName = (String) trainRowMap.get("firstName");
							String lastName = (String) trainRowMap.get("lastName");
							int sex = Integer.parseInt(trainRowMap.get("sex").toString());
							int age = Integer.parseInt(trainRowMap.get("age").toString());
							jdbcTemplate.update(TravelBookingRequestQueryUtil.travelPassengerDetails, travelBookingRequest.getRequestId(), firstName, lastName, sex, age, travelBookingRequest.getPassengerId());
						}

					}
				} else {

					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travelBookingRequest_Data, teampUser.getUserId(), hotelRequestDate, travelBookingRequest.getHotelReason(), travelBookingRequest.getHotelRequestFor(), travelBookingRequest.getRequestType(), travelBookingRequest.getHotelReqStatus(), travelBookingRequest.getRequestId());
					jdbcTemplate.update(TravelBookingRequestQueryUtil.update_hotelTravelBookingRequest_Data,travelBookingRequest.getHotelRequestType(), hotelDoB, hotelDoL, hotelCheckInTime, hotelCheckOutTime, travelBookingRequest.getHotelFacility(), travelBookingRequest.getHotelPreferOption(), travelBookingRequest.getHotelPaymentMode(), travelBookingRequest.getHotelNoOfAdults(), travelBookingRequest.getHotelNoOfChild(), travelBookingRequest.isHotelRestFacility(), travelBookingRequest.getHotelCategory(), travelBookingRequest.getHotelPreferRoom(), travelBookingRequest.getHotelMealPrefer(),
							travelBookingRequest.getHotelCheckOut(), travelBookingRequest.getRequestId());

					for (int i = 0; i < hotelTable.size(); i++) {
						HashMap map = (HashMap) hotelTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subHotelRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							jdbcTemplate.update(TravelBookingRequestQueryUtil.deletetravelPassengerDetails, travelBookingRequest.getRequestId());
						}
					}

					for (int i = 0; i < hotelTable.size(); i++) {
						HashMap map = (HashMap) hotelTable.get(i);

						ArrayList trainTableRowDetails = (ArrayList) map.get("subHotelRow");
						for (int j = 0; j < trainTableRowDetails.size(); j++) {
							HashMap trainRowMap = (HashMap) trainTableRowDetails.get(j);
							autoGenTrvlPsngrId = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.travelPassengerIdAutoGen, String.class);
							travelBookingRequest.setPassengerId(Integer.parseInt(autoGenTrvlPsngrId));

							String firstName = (String) trainRowMap.get("firstName");
							String lastName = (String) trainRowMap.get("lastName");
							int sex = Integer.parseInt(trainRowMap.get("sex").toString());
							int age = Integer.parseInt(trainRowMap.get("age").toString());
							jdbcTemplate.update(TravelBookingRequestQueryUtil.travelPassengerDetails, travelBookingRequest.getRequestId(), firstName, lastName, sex, age, travelBookingRequest.getPassengerId());
						}

					}
				}
				success=true;
			}
			
			resultBean.setSuccess(success);

		} catch (Exception e) {
			resultBean.setSuccess(false);
			resultBean.setMessage(e.getMessage());
			LOGGER.error("Error in updateTravelBookingRequest", e);

		}
		
		return resultBean;
	}

	@Override
	public List<TravelBookingRequest> getApprovalList() throws CustomException {
		List<TravelBookingRequest> travelList = new ArrayList<TravelBookingRequest>();
		List<CommonUtilityBean> workBeanlList = new ArrayList<CommonUtilityBean>();
		CommonUtilityBean commonBean =new CommonUtilityBean();
		
		try {
			UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
            //work flow entry checking
			
			String systemModuleName="Business Travel";
			
			commonBean = jdbcTemplate.queryForObject(CommonUtilityQueryUtil.getEmpDetails, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class), empUser.getEmpId());
			
			workBeanlList = jdbcTemplate.query(CommonUtilityQueryUtil.getWorkFlowDetails, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class),new Object[] {systemModuleName,commonBean.getEmpBranch()});
			
			String reportingPersonCode="RA001";
		
			for(CommonUtilityBean bean:workBeanlList) {
				int i=1;
				if(bean.getApproveType().equalsIgnoreCase("Role")) {
					
					//step 1
					if(bean.getStepOrder()<=1) {
						if(bean.getRoleNameUser().equalsIgnoreCase(reportingPersonCode)) {
						
						travelList = jdbcTemplate.query(TravelBookingRequestQueryUtil.get_frst_reporting_manager_approval_List, new BeanPropertyRowMapper<TravelBookingRequest>
						(TravelBookingRequest.class),new Object[] {bean.getStepOrder(),empUser.getEmpId()});	
								
						}
						else if(bean.getRoleNameUser().equalsIgnoreCase(commonBean.getEmpDesignation())) {
							travelList = jdbcTemplate.query(TravelBookingRequestQueryUtil.get_frst_approval_List, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class)
									,new Object[] {bean.getStepOrder()});	
						}
					}else {
                        if(bean.getRoleNameUser().equalsIgnoreCase(reportingPersonCode)) {
                       
                        	int reportingPersonCount = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.get_reportingPersonCount ,new Object[]{ empUser.getEmpId(),bean.getStepOrder()-1},Integer.class);
                        	
                        	if(reportingPersonCount>0) {
                        	travelList = jdbcTemplate.query(TravelBookingRequestQueryUtil.get_nxt_reporting_manager_approval_List, new BeanPropertyRowMapper<TravelBookingRequest>
							(TravelBookingRequest.class),new Object[] {bean.getStepOrder(),empUser.getEmpId(),bean.getStepOrder()-1});	
                        	}
                        	
						}
						else if(bean.getRoleNameUser().equalsIgnoreCase(commonBean.getEmpDesignation())) {
							travelList = jdbcTemplate.query(TravelBookingRequestQueryUtil.get_nxt_approval_List, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class)
									,new Object[] {bean.getStepOrder(),bean.getStepOrder()-1});
						}
					}
					
				}else {

					if(bean.getStepOrder()<=1) {
						if(bean.getRoleNameUser().equalsIgnoreCase(empUser.getEmpId())) {
							
						travelList = jdbcTemplate.query(TravelBookingRequestQueryUtil.get_frst_approval_List, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class)
								,new Object[] {bean.getStepOrder()});	

						}
						
					}else {
						if(bean.getRoleNameUser().equalsIgnoreCase(empUser.getEmpId())) {
							
							travelList = jdbcTemplate.query(TravelBookingRequestQueryUtil.get_nxt_approval_List, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class)
									,new Object[] {bean.getStepOrder(),bean.getStepOrder()-1});	

							}
					}
					
				
				}
			i++;	
			}
			
			

		} catch (DataAccessException e) {
			LOGGER.error("Error in getApprovalTravelList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return travelList;
	}

	@Override
	public TravelBookingRequestResultBean approvalUpdateValue(TravelBookingRequest travelBookingRequest) throws CustomException {
		TravelBookingRequestResultBean resultBean=new TravelBookingRequestResultBean();
		DateFormat formatterDate;
		formatterDate = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat formatterTime = new SimpleDateFormat("hh:mm");
		int travelBookingType = travelBookingRequest.getRequestType();
		UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int workFlowCount=0;
		CommonUtilityBean commonBean =new CommonUtilityBean();
		String systemModuleName="Business Travel";
		Integer status=null;
		String remarks=null;
		boolean success=false;
		try {
			if (travelBookingType == 1) {
				jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travelBookingRequestApprove, travelBookingRequest.getTrainReqStatus(), travelBookingRequest.getTrainReqRemarks(), empUser.getUserId(), travelBookingRequest.getRequestId());
			}

			if (travelBookingType == 2) {
				jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travelBookingRequestApprove, travelBookingRequest.getAirReqStatus(), travelBookingRequest.getAirReqRemarks(), empUser.getUserId(), travelBookingRequest.getRequestId());
			}

			if (travelBookingType == 3) {
				jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travelBookingRequestApprove, travelBookingRequest.getHotelReqStatus(), travelBookingRequest.getHotelReqRemarks(), empUser.getUserId(), travelBookingRequest.getRequestId());
			}
			
			if (travelBookingType == 1) {
				status=travelBookingRequest.getTrainReqStatus();
				remarks=travelBookingRequest.getTrainReqRemarks();
			}

			if (travelBookingType == 2) {
				status=travelBookingRequest.getAirReqStatus();
				remarks=travelBookingRequest.getAirReqRemarks();
			}

			if (travelBookingType == 3) {
				status=travelBookingRequest.getHotelReqStatus();
				remarks=travelBookingRequest.getHotelReqRemarks();
			}
			
			
			workFlowCount= jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.workFlowCountInTravelTable, new Object[] {travelBookingRequest.getRequestId(),travelBookingRequest.getStepOrder()},Integer.class);

			commonBean = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.getWorkFlowDetailsUsingStepsId, new BeanPropertyRowMapper<CommonUtilityBean>(CommonUtilityBean.class),new Object[] {systemModuleName,travelBookingRequest.getStepOrder()});

			
			if(workFlowCount>0) {
				//update
				jdbcTemplate.update(TravelBookingRequestQueryUtil.update_travel_workflow, status, remarks, empUser.getUserId(), travelBookingRequest.getRequestId(),travelBookingRequest.getStepOrder());
	
			}else {
				//insert
				jdbcTemplate.update(TravelBookingRequestQueryUtil.insert_travel_workflow,travelBookingRequest.getRequestId(),travelBookingRequest.getStepOrder(),commonBean.getStepName(),commonBean.getApproveType(),empUser.getUserId(),status, remarks,empUser.getUserId());

			}
			success=true;
			resultBean.setSuccess(success);
		} catch (Exception e) {
			resultBean.setSuccess(false);
			resultBean.setMessage(e.getMessage());
			LOGGER.error("Error in approvalUpdateTravelBookingRequest", e.getMessage());
		}
		return resultBean;
	}

	@Override
	public List<TravelBookingRequest> getBookingDetailList() throws CustomException {
		UserDetail empUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<TravelBookingRequest> travelList = new ArrayList<TravelBookingRequest>();
		try {
			travelList = jdbcTemplate.query(TravelBookingRequestQueryUtil.get_travelBookingDetails_List, new BeanPropertyRowMapper<TravelBookingRequest>(TravelBookingRequest.class));

			for (int i = 0; i < travelList.size(); i++) {
				TravelBookingRequest travelBean = travelList.get(i);

				if (travelBean.getRequestType() == 1) {
					travelBean.setRequestTypeName("Railway Booking");
				} else if (travelBean.getRequestType() == 2) {
					travelBean.setRequestTypeName("Air Booking");
				} else if (travelBean.getRequestType() == 3) {
					travelBean.setRequestTypeName("Hotel Booking");
				}

				if (travelBean.getStatus() == 1) {
					travelBean.setStatusName("Approved");
				} else if (travelBean.getStatus() == 2) {
					travelBean.setStatusName("Cancelled");
				} else if (travelBean.getStatus() == 3) {
					travelBean.setStatusName("Pending");
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTravelBookingDetailList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return travelList;
	}

	@Override
	public boolean deleteBookingRequest(TravelBookingRequest travelBean) throws Exception {
		boolean isSuccess = false;
		try {
			if (travelBean.getRequestType() == 1) {
				jdbcTemplate.update(TravelBookingRequestQueryUtil.deletetravelPassengerDetails, travelBean.getRequestId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_header_train_details, travelBean.getRequestId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_Train_DEPATURE_DETAILS, travelBean.getRequestId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_header_main_details, travelBean.getRequestId());
				int w = jdbcTemplate.update(TravelBookingRequestQueryUtil.DELETE_WORKFLOW_DTL, new Object[] { travelBean.getRequestId() });
				
				isSuccess = true;
			} else if (travelBean.getRequestType() == 2) {
				jdbcTemplate.update(TravelBookingRequestQueryUtil.deletetravelPassengerDetails, travelBean.getRequestId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_header_air_details, travelBean.getRequestId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_Air_DEPATURE_DETAILS, travelBean.getRequestId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_header_main_details, travelBean.getRequestId());
				int w = jdbcTemplate.update(TravelBookingRequestQueryUtil.DELETE_WORKFLOW_DTL, new Object[] { travelBean.getRequestId() });
				isSuccess = true;
			} else if (travelBean.getRequestType() == 3) {
				jdbcTemplate.update(TravelBookingRequestQueryUtil.deletetravelPassengerDetails, travelBean.getRequestId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_header_hotel_details, travelBean.getRequestId());
				jdbcTemplate.update(TravelBookingRequestQueryUtil.delete_header_main_details, travelBean.getRequestId());
				int w = jdbcTemplate.update(TravelBookingRequestQueryUtil.DELETE_WORKFLOW_DTL, new Object[] { travelBean.getRequestId() });
				isSuccess = true;
			}
			
			

		} catch (DataAccessException e) {
			LOGGER.error("test" + e);

		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public int checkTravellingDate(TravelBookingRequest bookingRequest) throws Exception {

		int count = 0;

		count = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.check_Travelliing_Date, new Object[] 
				{ bookingRequest.getTrainTravelDate(), bookingRequest.getTrainDepartureTime(), 
						bookingRequest.getTrainArrivalTime(), bookingRequest.getTrainRequestFor()},Integer.class);


		return count;
	}

	@Override
	public int checkAirBookingDate(TravelBookingRequest bookingRequest) throws Exception {
		int count = 0;

		count = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.check_Air_booking_DAate, new Object[] 
				{ bookingRequest.getAirTravelDate(), bookingRequest.getAirDepartureTime(), bookingRequest.getAirArrivalTime(),
						bookingRequest.getAirRequestFor() },Integer.class);

		return count;
	}

	@Override
	public int checkHotelBookingDate(TravelBookingRequest bookingRequest) throws Exception {
		int count = 0;

		count = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.check_hotel_booking_Date, new Object[]
				{ bookingRequest.getHotelDoB(), bookingRequest.getHotelCheckInTime(), bookingRequest.getHotelCheckOutTime(),
						bookingRequest.getHotelRequestFor() },Integer.class);

		return count;
	}

	@Override
	public int checkTravellingDateEdit(TravelBookingRequest bookingRequest) throws Exception {
		int count = 0;

		count = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.check_Travelliing_Date_Edit,
				new Object[] { bookingRequest.getTrainTravelDate(), bookingRequest.getTrainDepartureTime(),
						bookingRequest.getTrainArrivalTime(), bookingRequest.getTrainRequestFor(), bookingRequest.getRequestId() },Integer.class);

		return count;
	}

	@Override
	public int checkAirBookingDateEdit(TravelBookingRequest bookingRequest) throws Exception {
		int count = 0;

		count = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.check_Air_booking_DAate_Edit, new Object[] { bookingRequest.getAirTravelDate(), bookingRequest.getAirDepartureTime(), bookingRequest.getAirArrivalTime(), bookingRequest.getAirRequestFor(), bookingRequest.getRequestId() },Integer.class);

		return count;
	}

	@Override
	public int checkHotelBookingDateEdit(TravelBookingRequest bookingRequest) throws Exception {
		int count = 0;

		count = jdbcTemplate.queryForObject(TravelBookingRequestQueryUtil.check_hotel_booking_Date_Edit, new Object[] { bookingRequest.getHotelDoB(), bookingRequest.getHotelCheckInTime(), bookingRequest.getHotelCheckOutTime(), bookingRequest.getHotelRequestFor(), bookingRequest.getRequestId() },Integer.class);

		return count;
	}
}
