package com.dci.finance.travelBookingRequest;

import java.util.List;

import com.dci.common.util.CustomException;


public interface TravelBookingRequestDAO {

	public List<TravelBookingRequest> getTravelList() throws CustomException;

	public TravelBookingRequestResultBean getRequestForList() throws CustomException;

	public TravelBookingRequestResultBean saveTravelBookingRequestList(TravelBookingRequest travelBookingRequest) throws CustomException;

	public TravelBookingRequest getTravelBookingEdit(int travelBookingRequestId) throws CustomException;

	public TravelBookingRequestResultBean updateTravelBookingRequestList(TravelBookingRequest travelBookingRequest) throws CustomException;

	public List<TravelBookingRequest> getApprovalList() throws CustomException;

	public TravelBookingRequestResultBean approvalUpdateValue(TravelBookingRequest travelBookingRequest) throws CustomException;

	public List<TravelBookingRequest> getBookingDetailList() throws CustomException;

	public boolean deleteBookingRequest(TravelBookingRequest id) throws Exception;

	public int checkTravellingDate(TravelBookingRequest bookingRequest) throws Exception;

	public int checkAirBookingDate(TravelBookingRequest bookingRequest) throws Exception;

	public int checkHotelBookingDate(TravelBookingRequest bookingRequest) throws Exception;

	public int checkTravellingDateEdit(TravelBookingRequest bookingRequest) throws Exception;

	public int checkAirBookingDateEdit(TravelBookingRequest bookingRequest) throws Exception;

	public int checkHotelBookingDateEdit(TravelBookingRequest bookingRequest) throws Exception;

}
