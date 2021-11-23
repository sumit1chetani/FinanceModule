package com.dci.finance.travelBookingRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/finance/travelbookingrequest")
public class TravelBookingRequestController {

	@Autowired
	public TravelBookingRequestService trainingBookingRequestService;

	@RequestMapping(value = "/list")
	public TravelBookingRequestResultBean getTravelList() {
		TravelBookingRequestResultBean travelBookingRequestList = new TravelBookingRequestResultBean();
		try {
			travelBookingRequestList.setTravelBookingList(trainingBookingRequestService.getTravelList());
			travelBookingRequestList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return travelBookingRequestList;
	}

	@RequestMapping(value = "/getRequestEmpList")
	public TravelBookingRequestResultBean getRequestForList() {
		TravelBookingRequestResultBean empList = new TravelBookingRequestResultBean();
		try {
			empList = trainingBookingRequestService.getRequestForList();
			empList.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

	@RequestMapping(value = "/save")
	public  @ResponseBody TravelBookingRequestResultBean saveTrainingScheduleList(@RequestBody TravelBookingRequest travelBookingRequest) {
		TravelBookingRequestResultBean travelBookingRequestResultBean = new TravelBookingRequestResultBean();
		try {
			travelBookingRequestResultBean=trainingBookingRequestService.saveTravelBookingRequestList(travelBookingRequest);
		}	
		 catch (Exception e) {
			e.printStackTrace();
		}
		return travelBookingRequestResultBean;
	}

	@RequestMapping(value = "/checkTravellingDate")
	public int checkTravellingDate(@RequestBody TravelBookingRequest travelBookingRequest) {
		int count = 0;
		try {
			count = trainingBookingRequestService.checkTravellingDate(travelBookingRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@RequestMapping(value = "/checkAirBookingDate")
	public int checkAirBookingDate(@RequestBody TravelBookingRequest travelBookingRequest) {
		int count = 0;
		try {
			count = trainingBookingRequestService.checkAirBookingDate(travelBookingRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@RequestMapping(value = "/checkHotelBookingDate")
	public int checkHotelBookingDate(@RequestBody TravelBookingRequest travelBookingRequest) {
		int count = 0;
		try {
			count = trainingBookingRequestService.checkHotelBookingDate(travelBookingRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@RequestMapping(value = "/checkTravellingDateEdit")
	public int checkTravellingDateEdit(@RequestBody TravelBookingRequest travelBookingRequest) {
		int count = 0;
		try {
			count = trainingBookingRequestService.checkTravellingDateEdit(travelBookingRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@RequestMapping(value = "/checkAirBookingDateEdit")
	public int checkAirBookingDateEdit(@RequestBody TravelBookingRequest travelBookingRequest) {
		int count = 0;
		try {
			count = trainingBookingRequestService.checkAirBookingDateEdit(travelBookingRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@RequestMapping(value = "/checkHotelBookingDateEdit")
	public int checkHotelBookingDateEdit(@RequestBody TravelBookingRequest travelBookingRequest) {
		int count = 0;
		try {
			count = trainingBookingRequestService.checkHotelBookingDateEdit(travelBookingRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@RequestMapping(value = "/edit")
	public TravelBookingRequestResultBean editScheduleValue(@RequestBody int travelBookingRequestId) {
		TravelBookingRequestResultBean travelBookingRequestEdit = new TravelBookingRequestResultBean();
		try {
			TravelBookingRequest travelBookingRequest = trainingBookingRequestService.getTravelBookingEdit(travelBookingRequestId);
			travelBookingRequestEdit.setTravelBookingRequest(travelBookingRequest);
			travelBookingRequestEdit.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return travelBookingRequestEdit;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody TravelBookingRequestResultBean updateTravelBookingValue(@RequestBody TravelBookingRequest travelBookingRequest) {
		TravelBookingRequestResultBean travelBookingRequestResultBean = new TravelBookingRequestResultBean();
		try {
			travelBookingRequestResultBean=trainingBookingRequestService.updateTravelBookingRequestList(travelBookingRequest);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return travelBookingRequestResultBean;
	}

	/* List function for Travel request Approval */
	@RequestMapping(value = "/approvalList")
	public TravelBookingRequestResultBean getApprovalList() {
		TravelBookingRequestResultBean travelBookingRequestList = new TravelBookingRequestResultBean();
		try {
			travelBookingRequestList.setTravelBookingList(trainingBookingRequestService.getApprovalList());
			travelBookingRequestList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return travelBookingRequestList;
	}

	/* Update function for Travel request Approval */
	@RequestMapping(value = "/approvalUpdate")
	public TravelBookingRequestResultBean approvalUpdateValue(@RequestBody TravelBookingRequest travelBookingRequest) {
		TravelBookingRequestResultBean travelBookingRequestResultBean = new TravelBookingRequestResultBean();
		try {
			travelBookingRequestResultBean=trainingBookingRequestService.approvalUpdateValue(travelBookingRequest);
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return travelBookingRequestResultBean;
	}

	/* List function for Travel Booking Details */
	@RequestMapping(value = "/BookingDetailList")
	public TravelBookingRequestResultBean getBookingDetailList() {
		TravelBookingRequestResultBean travelBookingRequestList = new TravelBookingRequestResultBean();
		try {
			travelBookingRequestList.setTravelBookingList(trainingBookingRequestService.getBookingDetailList());
			travelBookingRequestList.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return travelBookingRequestList;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody TravelBookingRequest id) {
		boolean success = true;
		try {
			success = trainingBookingRequestService.deleteBookingRequest(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

}
