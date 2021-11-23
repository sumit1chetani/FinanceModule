package com.dci.finance.travelBookingRequest;

import java.util.List;


public class TravelBookingRequest {

	private int requestId;
	private int requestType;
	private String requestDate;
	private int requestFor;
	private String requestForName;
	private int Status;
	private String empId;
	private String empName;
	private String requestBy;
	private String approvedBy;
	private String approvedDate;

	private String requestTypeName;
	private String statusName;

	private String trainRequestFor;
	private String trainRequestedBy;
	private String trainRequestDate;
	private String trainReason;
	private int trainPreferBerth;
	private String trainArrival;
	private String trainDeparture;
	private boolean trainPickUpReq;
	private boolean trainReturnTicket;
	private String trainQuota;
	private String trainTravelDate;
	private int trainNoOfPass;
	private int trainReqStatus;
	private String trainPreferTrainNo;
	private String trainPreferTrainName;
	private int trainClass;
	private String trainArrivalTime;
	private String trainDepartureTime;
	private int trainMealPrefer;
	private String trainReturnDate;
	private String trainReturnArr;
	private String trainReturnDep;
	private String trainRetArrTime;
	private String trainRetDepTime;
	private String trainReqRemarks;

	private String airRequestFor;
	private String airRequestedBy;
	private String airRequestDate;
	private String airReason;
	private String airArrival;
	private String airDeparture;
	private boolean airPickUpReq;
	private boolean airReturnTicket;
	private String airTravelDate;
	private int airNoOfPass;
	private int airReqStatus;
	private String airPreferFlight;
	private int airTravelClass;
	private String airArrivalTime;
	private String airDepartureTime;
	private int airMealPrefer;
	private String airReturnDate;
	private String airReturnArr;
	private String airReturnDep;
	private String airRetArrTime;
	private String airRetDepTime;
	private String airReqRemarks;

	private String hotelRequestFor;
	private String hotelRequestedBy;
	private int hotelReqStatus;
	private String hotelRequestDate;
	private String hotelDoB;
	private String hotelDoL;
	private String hotelReason;
	private int hotelFacility;
	private int hotelPreferOption;
	private int hotelNoOfAdults;
	private int hotelNoOfChild;
	private int hotelCategory;
	private int hotelPreferRoom;
	private String hotelCheckInTime;
	private String hotelCheckOutTime;
	private int hotelCheckOut;
	private boolean hotelRestFacility;
	private int hotelMealPrefer;
	private int hotelPaymentMode;
	private String hotelReqRemarks;

	private int passengerId;
	private String firstName;
	private String lastName;
	private int sex;
	private int age;
	private String id;
	private String text;

	private List trainPassengerTables;
	private List airPassengerTables;
	private List hotelPassengerTables;
	private List<TravelBookingRequest> travelPassList;
	private List<TravelBookingRequest> objdetailList;
	private List<TravelBookingRequest> objtraindetailList;

	private int deptarrivdtlId;
	private List<TravelBookingRequest> tables;
	
	private List<TravelBookingRequest> workFlowList;
	
	
	public List<TravelBookingRequest> getWorkFlowList() {
		return workFlowList;
	}

	public void setWorkFlowList(List<TravelBookingRequest> workFlowList) {
		this.workFlowList = workFlowList;
	}

	private int deptarrivdtlIdtrain;
	
	private int trainTraveltype;
	private int hotelRequestType;
	
	private Integer stepOrder;
	private String stepName;
	private String approveType;
	private String stepRemarks;
	private String stepStatus;
	
	
	
	
	public String getStepRemarks() {
		return stepRemarks;
	}

	public void setStepRemarks(String stepRemarks) {
		this.stepRemarks = stepRemarks;
	}

	public String getStepStatus() {
		return stepStatus;
	}

	public void setStepStatus(String stepStatus) {
		this.stepStatus = stepStatus;
	}

	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public Integer getStepOrder() {
		return stepOrder;
	}

	public void setStepOrder(Integer stepOrder) {
		this.stepOrder = stepOrder;
	}

	public int getTrainTraveltype() {
		return trainTraveltype;
	}

	public void setTrainTraveltype(int trainTraveltype) {
		this.trainTraveltype = trainTraveltype;
	}

	public int getHotelRequestType() {
		return hotelRequestType;
	}

	public void setHotelRequestType(int hotelRequestType) {
		this.hotelRequestType = hotelRequestType;
	}

	public int getDeptarrivdtlIdtrain() {
		return deptarrivdtlIdtrain;
	}

	public void setDeptarrivdtlIdtrain(int deptarrivdtlIdtrain) {
		this.deptarrivdtlIdtrain = deptarrivdtlIdtrain;
	}

	public List<TravelBookingRequest> getTables() {
		return tables;
	}

	public void setTables(List<TravelBookingRequest> tables) {
		this.tables = tables;
	}

	private List<TravelBookingRequest> travelDeptArriveList;

	
	
	
	
	public List<TravelBookingRequest> getObjtraindetailList() {
		return objtraindetailList;
	}

	public void setObjtraindetailList(List<TravelBookingRequest> objtraindetailList) {
		this.objtraindetailList = objtraindetailList;
	}

	public List<TravelBookingRequest> getTravelDeptArriveList() {
		return travelDeptArriveList;
	}

	public void setTravelDeptArriveList(List<TravelBookingRequest> travelDeptArriveList) {
		this.travelDeptArriveList = travelDeptArriveList;
	}

	public int getDeptarrivdtlId() {
		return deptarrivdtlId;
	}

	public void setDeptarrivdtlId(int deptarrivdtlId) {
		this.deptarrivdtlId = deptarrivdtlId;
	}

	public List<TravelBookingRequest> getObjdetailList() {
		return objdetailList;
	}

	public void setObjdetailList(List<TravelBookingRequest> objdetailList) {
		this.objdetailList = objdetailList;
	}

	private String airdepartDate;
	private String airarrivalDate;
	
	

	private String trainarrivalDate;
	private String traindepartDate;
	
	
	
	public String getTrainarrivalDate() {
		return trainarrivalDate;
	}

	public void setTrainarrivalDate(String trainarrivalDate) {
		this.trainarrivalDate = trainarrivalDate;
	}

	public String getTraindepartDate() {
		return traindepartDate;
	}

	public void setTraindepartDate(String traindepartDate) {
		this.traindepartDate = traindepartDate;
	}

	public String getAirdepartDate() {
		return airdepartDate;
	}

	public void setAirdepartDate(String airdepartDate) {
		this.airdepartDate = airdepartDate;
	}

	public String getAirarrivalDate() {
		return airarrivalDate;
	}

	public void setAirarrivalDate(String airarrivalDate) {
		this.airarrivalDate = airarrivalDate;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public List getTrainPassengerTables() {
		return trainPassengerTables;
	}

	public void setTrainPassengerTables(List trainPassengerTables) {
		this.trainPassengerTables = trainPassengerTables;
	}

	public List getAirPassengerTables() {
		return airPassengerTables;
	}

	public void setAirPassengerTables(List airPassengerTables) {
		this.airPassengerTables = airPassengerTables;
	}

	public List getHotelPassengerTables() {
		return hotelPassengerTables;
	}

	public void setHotelPassengerTables(List hotelPassengerTables) {
		this.hotelPassengerTables = hotelPassengerTables;
	}

	public List<TravelBookingRequest> getTravelPassList() {
		return travelPassList;
	}

	public void setTravelPassList(List<TravelBookingRequest> travelPassList) {
		this.travelPassList = travelPassList;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getRequestForName() {
		return requestForName;
	}

	public void setRequestForName(String requestForName) {
		this.requestForName = requestForName;
	}

	public int getRequestType() {
		return requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public int getRequestFor() {
		return requestFor;
	}

	public void setRequestFor(int requestFor) {
		this.requestFor = requestFor;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTrainRequestFor() {
		return trainRequestFor;
	}

	public void setTrainRequestFor(String trainRequestFor) {
		this.trainRequestFor = trainRequestFor;
	}

	public String getTrainRequestedBy() {
		return trainRequestedBy;
	}

	public void setTrainRequestedBy(String trainRequestedBy) {
		this.trainRequestedBy = trainRequestedBy;
	}

	public String getTrainRequestDate() {
		return trainRequestDate;
	}

	public void setTrainRequestDate(String trainRequestDate) {
		this.trainRequestDate = trainRequestDate;
	}

	public String getTrainReason() {
		return trainReason;
	}

	public void setTrainReason(String trainReason) {
		this.trainReason = trainReason;
	}

	public int getTrainPreferBerth() {
		return trainPreferBerth;
	}

	public void setTrainPreferBerth(int trainPreferBerth) {
		this.trainPreferBerth = trainPreferBerth;
	}

	public String getTrainArrival() {
		return trainArrival;
	}

	public void setTrainArrival(String trainArrival) {
		this.trainArrival = trainArrival;
	}

	public String getTrainDeparture() {
		return trainDeparture;
	}

	public void setTrainDeparture(String trainDeparture) {
		this.trainDeparture = trainDeparture;
	}

	public boolean isTrainPickUpReq() {
		return trainPickUpReq;
	}

	public void setTrainPickUpReq(boolean trainPickUpReq) {
		this.trainPickUpReq = trainPickUpReq;
	}

	public boolean isTrainReturnTicket() {
		return trainReturnTicket;
	}

	public void setTrainReturnTicket(boolean trainReturnTicket) {
		this.trainReturnTicket = trainReturnTicket;
	}

	public String getTrainQuota() {
		return trainQuota;
	}

	public void setTrainQuota(String trainQuota) {
		this.trainQuota = trainQuota;
	}

	public String getTrainTravelDate() {
		return trainTravelDate;
	}

	public void setTrainTravelDate(String trainTravelDate) {
		this.trainTravelDate = trainTravelDate;
	}

	public int getTrainNoOfPass() {
		return trainNoOfPass;
	}

	public void setTrainNoOfPass(int trainNoOfPass) {
		this.trainNoOfPass = trainNoOfPass;
	}

	public int getTrainReqStatus() {
		return trainReqStatus;
	}

	public void setTrainReqStatus(int trainReqStatus) {
		this.trainReqStatus = trainReqStatus;
	}

	public String getTrainPreferTrainNo() {
		return trainPreferTrainNo;
	}

	public void setTrainPreferTrainNo(String trainPreferTrainNo) {
		this.trainPreferTrainNo = trainPreferTrainNo;
	}

	public String getTrainPreferTrainName() {
		return trainPreferTrainName;
	}

	public void setTrainPreferTrainName(String trainPreferTrainName) {
		this.trainPreferTrainName = trainPreferTrainName;
	}

	public int getTrainClass() {
		return trainClass;
	}

	public void setTrainClass(int trainClass) {
		this.trainClass = trainClass;
	}

	public String getTrainArrivalTime() {
		return trainArrivalTime;
	}

	public void setTrainArrivalTime(String trainArrivalTime) {
		this.trainArrivalTime = trainArrivalTime;
	}

	public String getTrainDepartureTime() {
		return trainDepartureTime;
	}

	public void setTrainDepartureTime(String trainDepartureTime) {
		this.trainDepartureTime = trainDepartureTime;
	}

	public int getTrainMealPrefer() {
		return trainMealPrefer;
	}

	public void setTrainMealPrefer(int trainMealPrefer) {
		this.trainMealPrefer = trainMealPrefer;
	}

	public String getTrainReturnDate() {
		return trainReturnDate;
	}

	public void setTrainReturnDate(String trainReturnDate) {
		this.trainReturnDate = trainReturnDate;
	}

	public String getTrainReturnArr() {
		return trainReturnArr;
	}

	public void setTrainReturnArr(String trainReturnArr) {
		this.trainReturnArr = trainReturnArr;
	}

	public String getTrainReturnDep() {
		return trainReturnDep;
	}

	public void setTrainReturnDep(String trainReturnDep) {
		this.trainReturnDep = trainReturnDep;
	}

	public String getTrainRetArrTime() {
		return trainRetArrTime;
	}

	public void setTrainRetArrTime(String trainRetArrTime) {
		this.trainRetArrTime = trainRetArrTime;
	}

	public String getTrainRetDepTime() {
		return trainRetDepTime;
	}

	public void setTrainRetDepTime(String trainRetDepTime) {
		this.trainRetDepTime = trainRetDepTime;
	}

	public String getAirRequestFor() {
		return airRequestFor;
	}

	public void setAirRequestFor(String airRequestFor) {
		this.airRequestFor = airRequestFor;
	}

	public String getAirRequestedBy() {
		return airRequestedBy;
	}

	public void setAirRequestedBy(String airRequestedBy) {
		this.airRequestedBy = airRequestedBy;
	}

	public String getAirRequestDate() {
		return airRequestDate;
	}

	public void setAirRequestDate(String airRequestDate) {
		this.airRequestDate = airRequestDate;
	}

	public String getAirReason() {
		return airReason;
	}

	public void setAirReason(String airReason) {
		this.airReason = airReason;
	}

	public String getAirArrival() {
		return airArrival;
	}

	public void setAirArrival(String airArrival) {
		this.airArrival = airArrival;
	}

	public String getAirDeparture() {
		return airDeparture;
	}

	public void setAirDeparture(String airDeparture) {
		this.airDeparture = airDeparture;
	}

	public boolean isAirPickUpReq() {
		return airPickUpReq;
	}

	public void setAirPickUpReq(boolean airPickUpReq) {
		this.airPickUpReq = airPickUpReq;
	}

	public boolean isAirReturnTicket() {
		return airReturnTicket;
	}

	public void setAirReturnTicket(boolean airReturnTicket) {
		this.airReturnTicket = airReturnTicket;
	}

	public String getAirTravelDate() {
		return airTravelDate;
	}

	public void setAirTravelDate(String airTravelDate) {
		this.airTravelDate = airTravelDate;
	}

	public int getAirNoOfPass() {
		return airNoOfPass;
	}

	public void setAirNoOfPass(int airNoOfPass) {
		this.airNoOfPass = airNoOfPass;
	}

	public int getAirReqStatus() {
		return airReqStatus;
	}

	public void setAirReqStatus(int airReqStatus) {
		this.airReqStatus = airReqStatus;
	}

	public String getAirPreferFlight() {
		return airPreferFlight;
	}

	public void setAirPreferFlight(String airPreferFlight) {
		this.airPreferFlight = airPreferFlight;
	}

	public int getAirTravelClass() {
		return airTravelClass;
	}

	public void setAirTravelClass(int airTravelClass) {
		this.airTravelClass = airTravelClass;
	}

	public String getAirArrivalTime() {
		return airArrivalTime;
	}

	public void setAirArrivalTime(String airArrivalTime) {
		this.airArrivalTime = airArrivalTime;
	}

	public String getAirDepartureTime() {
		return airDepartureTime;
	}

	public void setAirDepartureTime(String airDepartureTime) {
		this.airDepartureTime = airDepartureTime;
	}

	public int getAirMealPrefer() {
		return airMealPrefer;
	}

	public void setAirMealPrefer(int airMealPrefer) {
		this.airMealPrefer = airMealPrefer;
	}

	public String getAirReturnDate() {
		return airReturnDate;
	}

	public void setAirReturnDate(String airReturnDate) {
		this.airReturnDate = airReturnDate;
	}

	public String getAirReturnArr() {
		return airReturnArr;
	}

	public void setAirReturnArr(String airReturnArr) {
		this.airReturnArr = airReturnArr;
	}

	public String getAirReturnDep() {
		return airReturnDep;
	}

	public void setAirReturnDep(String airReturnDep) {
		this.airReturnDep = airReturnDep;
	}

	public String getAirRetArrTime() {
		return airRetArrTime;
	}

	public void setAirRetArrTime(String airRetArrTime) {
		this.airRetArrTime = airRetArrTime;
	}

	public String getAirRetDepTime() {
		return airRetDepTime;
	}

	public void setAirRetDepTime(String airRetDepTime) {
		this.airRetDepTime = airRetDepTime;
	}

	public String getHotelRequestFor() {
		return hotelRequestFor;
	}

	public void setHotelRequestFor(String hotelRequestFor) {
		this.hotelRequestFor = hotelRequestFor;
	}

	public String getHotelRequestedBy() {
		return hotelRequestedBy;
	}

	public void setHotelRequestedBy(String hotelRequestedBy) {
		this.hotelRequestedBy = hotelRequestedBy;
	}

	public int getHotelReqStatus() {
		return hotelReqStatus;
	}

	public void setHotelReqStatus(int hotelReqStatus) {
		this.hotelReqStatus = hotelReqStatus;
	}

	public String getHotelRequestDate() {
		return hotelRequestDate;
	}

	public void setHotelRequestDate(String hotelRequestDate) {
		this.hotelRequestDate = hotelRequestDate;
	}

	public String getHotelDoB() {
		return hotelDoB;
	}

	public void setHotelDoB(String hotelDoB) {
		this.hotelDoB = hotelDoB;
	}

	public String getHotelDoL() {
		return hotelDoL;
	}

	public void setHotelDoL(String hotelDoL) {
		this.hotelDoL = hotelDoL;
	}

	public String getHotelReason() {
		return hotelReason;
	}

	public void setHotelReason(String hotelReason) {
		this.hotelReason = hotelReason;
	}

	public int getHotelFacility() {
		return hotelFacility;
	}

	public void setHotelFacility(int hotelFacility) {
		this.hotelFacility = hotelFacility;
	}

	public int getHotelPreferOption() {
		return hotelPreferOption;
	}

	public void setHotelPreferOption(int hotelPreferOption) {
		this.hotelPreferOption = hotelPreferOption;
	}

	public int getHotelNoOfAdults() {
		return hotelNoOfAdults;
	}

	public void setHotelNoOfAdults(int hotelNoOfAdults) {
		this.hotelNoOfAdults = hotelNoOfAdults;
	}

	public int getHotelNoOfChild() {
		return hotelNoOfChild;
	}

	public void setHotelNoOfChild(int hotelNoOfChild) {
		this.hotelNoOfChild = hotelNoOfChild;
	}

	public int getHotelCategory() {
		return hotelCategory;
	}

	public void setHotelCategory(int hotelCategory) {
		this.hotelCategory = hotelCategory;
	}

	public int getHotelPreferRoom() {
		return hotelPreferRoom;
	}

	public void setHotelPreferRoom(int hotelPreferRoom) {
		this.hotelPreferRoom = hotelPreferRoom;
	}

	public String getHotelCheckInTime() {
		return hotelCheckInTime;
	}

	public void setHotelCheckInTime(String hotelCheckInTime) {
		this.hotelCheckInTime = hotelCheckInTime;
	}

	public String getHotelCheckOutTime() {
		return hotelCheckOutTime;
	}

	public void setHotelCheckOutTime(String hotelCheckOutTime) {
		this.hotelCheckOutTime = hotelCheckOutTime;
	}

	public int getHotelCheckOut() {
		return hotelCheckOut;
	}

	public void setHotelCheckOut(int hotelCheckOut) {
		this.hotelCheckOut = hotelCheckOut;
	}

	public boolean isHotelRestFacility() {
		return hotelRestFacility;
	}

	public void setHotelRestFacility(boolean hotelRestFacility) {
		this.hotelRestFacility = hotelRestFacility;
	}

	public int getHotelMealPrefer() {
		return hotelMealPrefer;
	}

	public void setHotelMealPrefer(int hotelMealPrefer) {
		this.hotelMealPrefer = hotelMealPrefer;
	}

	public int getHotelPaymentMode() {
		return hotelPaymentMode;
	}

	public void setHotelPaymentMode(int hotelPaymentMode) {
		this.hotelPaymentMode = hotelPaymentMode;
	}

	public String getTrainReqRemarks() {
		return trainReqRemarks;
	}

	public void setTrainReqRemarks(String trainReqRemarks) {
		this.trainReqRemarks = trainReqRemarks;
	}

	public String getAirReqRemarks() {
		return airReqRemarks;
	}

	public void setAirReqRemarks(String airReqRemarks) {
		this.airReqRemarks = airReqRemarks;
	}

	public String getHotelReqRemarks() {
		return hotelReqRemarks;
	}

	public void setHotelReqRemarks(String hotelReqRemarks) {
		this.hotelReqRemarks = hotelReqRemarks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRequestTypeName() {
		return requestTypeName;
	}

	public void setRequestTypeName(String requestTypeName) {
		this.requestTypeName = requestTypeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
