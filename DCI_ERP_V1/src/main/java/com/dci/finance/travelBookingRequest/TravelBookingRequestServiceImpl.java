package com.dci.finance.travelBookingRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;


@Service
public class TravelBookingRequestServiceImpl implements TravelBookingRequestService {

	@Autowired
	public TravelBookingRequestDAO travelBookingRequestDao;

	@Override
	public List<TravelBookingRequest> getTravelList() throws CustomException {
		return travelBookingRequestDao.getTravelList();
	}

	@Override
	public TravelBookingRequestResultBean getRequestForList() throws CustomException {
		return travelBookingRequestDao.getRequestForList();
	}

	@Override
	public TravelBookingRequestResultBean saveTravelBookingRequestList(TravelBookingRequest travelBookingRequest) throws CustomException {
		return travelBookingRequestDao.saveTravelBookingRequestList(travelBookingRequest);
	}

	@Override
	public TravelBookingRequest getTravelBookingEdit(int travelBookingRequestId) throws CustomException {
		return travelBookingRequestDao.getTravelBookingEdit(travelBookingRequestId);
	}

	@Override
	public TravelBookingRequestResultBean updateTravelBookingRequestList(TravelBookingRequest travelBookingRequest) throws CustomException {
		return travelBookingRequestDao.updateTravelBookingRequestList(travelBookingRequest);
	}

	@Override
	public List<TravelBookingRequest> getApprovalList() throws CustomException {
		return travelBookingRequestDao.getApprovalList();
	}

	@Override
	public TravelBookingRequestResultBean approvalUpdateValue(TravelBookingRequest travelBookingRequest) throws CustomException {
		return travelBookingRequestDao.approvalUpdateValue(travelBookingRequest);
	}

	@Override
	public List<TravelBookingRequest> getBookingDetailList() throws CustomException {
		return travelBookingRequestDao.getBookingDetailList();
	}

	@Override
	public boolean deleteBookingRequest(TravelBookingRequest id) throws Exception {
		// TODO Auto-generated method stub
		return travelBookingRequestDao.deleteBookingRequest(id);
	}

	@Override
	public int checkTravellingDate(TravelBookingRequest bookingRequest) throws Exception {
		// TODO Auto-generated method stub
		return travelBookingRequestDao.checkTravellingDate(bookingRequest);
	}

	@Override
	public int checkAirBookingDate(TravelBookingRequest bookingRequest) throws Exception {
		// TODO Auto-generated method stub
		return travelBookingRequestDao.checkAirBookingDate(bookingRequest);
	}

	@Override
	public int checkHotelBookingDate(TravelBookingRequest bookingRequest) throws Exception {
		// TODO Auto-generated method stub
		return travelBookingRequestDao.checkHotelBookingDate(bookingRequest);
	}

	@Override
	public int checkTravellingDateEdit(TravelBookingRequest bookingRequest) throws Exception {
		// TODO Auto-generated method stub
		return travelBookingRequestDao.checkTravellingDateEdit(bookingRequest);
	}

	@Override
	public int checkAirBookingDateEdit(TravelBookingRequest bookingRequest) throws Exception {
		// TODO Auto-generated method stub
		return travelBookingRequestDao.checkAirBookingDateEdit(bookingRequest);
	}

	@Override
	public int checkHotelBookingDateEdit(TravelBookingRequest bookingRequest) throws Exception {
		// TODO Auto-generated method stub
		return travelBookingRequestDao.checkHotelBookingDateEdit(bookingRequest);
	}

}
