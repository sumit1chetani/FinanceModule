package com.dci.finance.travelBookingRequest;

public class TravelBookingRequestQueryUtil {


	public static final String INSERT_DEPATURE_DTL = " insert into travel_departure_arrival_dtl(air_depature, air_arrival, air_depature_time, air_arrival_time, air_depature_date, air_arrival_date,request_id) values(?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?)";

	public static final String GET_DEPRT_ATRRIVE_LIST =" select dept_arrive_details_id, air_depature, air_arrival,air_depature_time, air_arrival_time,TO_CHAR(air_depature_date,'dd/mm/yyyy') as air_depature_date,TO_CHAR(air_arrival_date,'dd/mm/yyyy') as air_arrival_date from travel_departure_arrival_dtl where request_id = ?";

	public static final String INSERT_TRAIN_DEPATURE_DTL =" insert into train_travel_departure_arrival_dtl(train_depature, train_arrival, train_depature_time, train_arrival_time,train_arrival_date, train_depature_date, request_id) values(?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?)";

	public static final String GET_DEPRT_ATRRIVE_LIST_TRAIN = "select train_dept_arrive_details_id,train_depature,train_arrival,train_depature_time,train_arrival_time,TO_CHAR(train_depature_date,'dd/mm/yyyy') as train_depature_date,TO_CHAR(train_arrival_date,'dd/mm/yyyy') as train_arrival_date from train_travel_departure_arrival_dtl "
		+ "	 where request_id =? ";

	public static String get_travelBookingRequest_List = "SELECT request_id as requestId, TO_CHAR(requested_date,'dd/mm/yyyy') as requestDate, (select concat(employee_master.first_name,' ',employee_master.middle_name,' ',employee_master.surname) from employee_master where emp_id=requested_for) as requestForName,request_type as requestType, "
 //+ " case when request_type=1 then 'TRAIN'  when  request_type=2 then 'AIR'  else 'HOTEL' end as  requestType, "
 + " travel_booking_request.status as status,reason as reason  From travel_booking_request "
 + " inner join user_master e on  e.user_id =travel_booking_request.requested_by where e.user_id=? ORDER BY requested_date DESC ";

	//public static String get_RequestFor_List = "select concat(first_name,' ',surname) as empName, concat(first_name,' ',surname) as text , employee_id as empId , employee_id as id from employee join branch_department on employee.branch_department_id=branch_department.branch_department_id inner join branch on branch.branch_id = branch_department.branch_id inner join company c on c.company_id = branch.company_id where  employee.status = true and c.company_id = ?";
	
	public static String get_RequestFor_List = "select concat(first_name,' ',surname) as empName, concat(first_name,' ',surname) as text , "
	         + " emp_id as empId , emp_id as id from employee_master e "
	         + " left join branch on branch.branch_code = e.branch_department_id  "
	         + " left join company_master c on c.company_code= e.company_code "
             + " where  e.status = 'Y'  and c.company_code =? ";

	public static String travelReqIdAutoGen = "SELECT CASE WHEN MAX(request_id) IS NULL THEN '1' ELSE MAX(request_id)+1 END FROM travel_booking_request";

	public static String insert_travelBookingRequest_Data = "INSERT INTO travel_booking_request(request_id, requested_by, requested_date, reason, requested_for, request_type, status, booked_by, booked_date) values (?,?,?,?,?,?,?,?,now())";

	public static String insert_trainTravelBookingRequest_Data = "INSERT INTO travel_train_booking_request (request_id, prefer_berth, arrival_to, depature_from, is_pickup_required, is_return, quota, travelling_date, no_of_passengers, prefer_train_no, prefer_train_name, class, arrival_time, depature_time, meal_prefer, return_date, return_arrival_to, return_depature_from, return_arrival_time, return_depature_time,train_travel_type)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,to_timestamp(?,'HH24:MI'),to_timestamp(?,'HH24:MI'),?,?,?,?,to_timestamp(?,'HH24:MI'),to_timestamp(?,'HH24:MI'),?)";

	public static String insert_airTravelBookingRequest_Data = "INSERT INTO travel_air_booking_request (request_id, travelling_date, is_return, return_date, class, prefer_flight_name, no_of_passengers, meal_prefer, is_multicity, is_pickup_required, arrival_to, depature_from, arrival_time, depature_time, return_arrival_to, return_depature_from, return_arrival_time, return_depature_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,to_timestamp(?,'HH24:MI'),to_timestamp(?,'HH24:MI'),?,?,to_timestamp(?,'HH24:MI'),to_timestamp(?,'HH24:MI'))";

	public static String insert_hotelTravelBookingRequest_Data = "INSERT INTO travel_hotel_booking_request (request_id, checkin_date, checkout_date, checkin_time, checkout_time, class, payment_option, payment_mode, no_of_adults, no_of_childs, is_restaurant_required, prefer_category, prefer_room_type, restaurant_type, prefer_checkout_time,hotel_request_type) VALUES (?,?,?,to_timestamp(?,'HH24:MI'),to_timestamp(?,'HH24:MI'),?,?,?,?,?,?,?,?,?,?,?)";

	public static String getTravelTrainBookingEditList = "select travel_booking_request.request_id as requestId, travel_booking_request.request_type as requestType, travel_booking_request.requested_for as trainRequestFor, "
			+ "TO_CHAR(travel_booking_request.requested_date,'dd/mm/yyyy') as trainRequestDate, travel_booking_request.status as trainReqStatus, travel_booking_request.remarks as trainReqRemarks, "
			+ "concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) as trainRequestedBy, "
			+ "travel_booking_request.reason as trainReason, prefer_berth as trainPreferBerth, arrival_to as trainArrival, depature_from as trainDeparture, is_pickup_required as trainPickUpReq, "
			+ "is_return as trainReturnTicket, quota as trainQuota, TO_CHAR(travelling_date,'dd/mm/yyyy') as trainTravelDate, no_of_passengers as trainNoOfPass, prefer_train_no as trainPreferTrainNo, "
			+ " prefer_train_name as trainPreferTrainName, class as trainClass, TO_CHAR(arrival_time,'HH24:MI') as trainArrivalTime, TO_CHAR(depature_time,'HH24:MI') as trainDepartureTime, "
			+ "  meal_prefer as trainMealPrefer,train_travel_type as trainTraveltype, "
			+ "TO_CHAR(return_date,'dd/mm/yyyy') as trainReturnDate, return_arrival_to as trainReturnArr, return_depature_from as trainReturnDep, "
			+ " TO_CHAR(return_arrival_time,'HH24:MI') as trainRetArrTime, TO_CHAR(return_depature_time,'HH24:MI') as trainRetDepTime From travel_train_booking_request "
			+ "  inner join travel_booking_request on travel_train_booking_request.request_id = travel_booking_request.request_id "
			+ "  inner join user_master on travel_booking_request.requested_by = user_master.user_id  where travel_booking_request.request_id =?";
	
	public static String getTravelAirBookingEditList ="select travel_booking_request.request_id as requestId, travel_booking_request.request_type as requestType, travel_booking_request.requested_for as airRequestFor, "
			+ " TO_CHAR(travel_booking_request.requested_date,'dd/mm/yyyy') as airRequestDate, travel_booking_request.status as airReqStatus, travel_booking_request.remarks as airReqRemarks, "
			+ " concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) as airRequestedBy, "
			+ "			 travel_booking_request.reason as airReason, TO_CHAR(travelling_date,'dd/mm/yyyy') as airTravelDate, is_return as airReturnTicket, "
			+ "			  TO_CHAR(return_date,'dd/mm/yyyy') as airReturnDate, class as airTravelClass, prefer_flight_name as airPreferFlight, no_of_passengers as airNoOfPass, "
			+ "			  meal_prefer as airMealPrefer, is_pickup_required as airPickUpReq, arrival_to as airArrival, depature_from as airDeparture, "
			+ "			TO_CHAR(arrival_time,'HH24:MI') as airArrivalTime, TO_CHAR(depature_time,'HH24:MI') as airDepartureTime, return_arrival_to as airReturnArr, "
			+ "			return_depature_from as airReturnDep, TO_CHAR(return_arrival_time,'HH24:MI') as airRetArrTime, "
			+ "			 TO_CHAR(return_depature_time,'HH24:MI') as airRetDepTime From travel_air_booking_request "
			+ "			 inner join travel_booking_request on travel_air_booking_request.request_id = travel_booking_request.request_id "
			+ "			 inner join user_master on travel_booking_request.requested_by = user_master.user_id  where travel_booking_request.request_id =?";
	
	public static String getTravelHotelBookingEditList =  "select travel_booking_request.request_id as requestId, travel_booking_request.request_type as requestType, travel_booking_request.requested_for as hotelRequestFor, "
			+ " TO_CHAR(travel_booking_request.requested_date,'dd/mm/yyyy') as hotelRequestDate, travel_booking_request.status as hotelReqStatus, travel_booking_request.remarks as hotelReqRemarks, "
			+ "  concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) as hotelRequestedBy, travel_booking_request.reason as hotelReason, TO_CHAR(checkin_date,'dd/mm/yyyy') as hotelDoB, "
			+ "TO_CHAR(checkout_date,'dd/mm/yyyy') as hotelDoL, TO_CHAR(checkin_time,'HH24:MI') as hotelCheckInTime, TO_CHAR(checkout_time,'HH24:MI') as hotelCheckOutTime, class as hotelFacility, "
			+ " payment_option as hotelPreferOption, travel_hotel_booking_request.payment_mode as hotelPaymentMode, no_of_adults as hotelNoOfAdults, no_of_childs as hotelNoOfChild, is_restaurant_required as hotelRestFacility, "
			+ " prefer_category as hotelCategory,hotel_request_type as hotelRequestType, "
			+ "prefer_room_type as hotelPreferRoom, restaurant_type as hotelMealPrefer, prefer_checkout_time as hotelCheckOut From travel_hotel_booking_request "
			+ "inner join travel_booking_request on travel_hotel_booking_request.request_id = travel_booking_request.request_id "
			+ "inner join user_master on travel_booking_request.requested_by = user_master.user_id where travel_booking_request.request_id = ?;";
	
	public static String update_travelBookingRequest_Data = "UPDATE travel_booking_request SET requested_by=?, requested_date=?, reason=?, requested_for=?, request_type=?, status=? WHERE request_id=?";

	public static String update_trainTravelBookingRequest_Data = "UPDATE travel_train_booking_request SET train_travel_type=?, prefer_berth=?, arrival_to=?, depature_from=?, is_pickup_required=?, is_return=?, quota=?, travelling_date=?, no_of_passengers=?, prefer_train_no=?, prefer_train_name=?, class=?, arrival_time=to_timestamp(?,'HH24:MI'), depature_time=to_timestamp(?,'HH24:MI'), meal_prefer=?, return_date=?, return_arrival_to=?, return_depature_from=?, return_arrival_time=to_timestamp(?,'HH24:MI'), return_depature_time=to_timestamp(?,'HH24:MI') WHERE request_id=?";

	public static String update_airTravelBookingRequest_Data = "UPDATE travel_air_booking_request SET travelling_date=?, is_return=?, return_date=?, class=?, prefer_flight_name=?, no_of_passengers=?, meal_prefer=?, is_multicity=?, is_pickup_required=?, arrival_to=?, depature_from=?, arrival_time=to_timestamp(?,'HH24:MI'), depature_time=to_timestamp(?,'HH24:MI'), return_arrival_to=?, return_depature_from=?, return_arrival_time=to_timestamp(?,'HH24:MI'), return_depature_time=to_timestamp(?,'HH24:MI') WHERE request_id=?";

	public static String update_hotelTravelBookingRequest_Data = "UPDATE travel_hotel_booking_request SET hotel_request_type=?, checkin_date=?, checkout_date=?, checkin_time=to_timestamp(?,'HH24:MI'), checkout_time=to_timestamp(?,'HH24:MI'), class=?, payment_option=?, payment_mode=?, no_of_adults=?, no_of_childs=?, is_restaurant_required=?, prefer_category=?, prefer_room_type=?, restaurant_type=?, prefer_checkout_time=? WHERE request_id=?";

	public static String travelPassengerIdAutoGen = "SELECT CASE WHEN MAX(passenger_details_id) IS NULL THEN '1' ELSE MAX(passenger_details_id)+1 END FROM travel_passenger_details";

	public static String travelPassengerDetails = "insert into travel_passenger_details(request_id, passenger_first_name, passenger_last_name, passenger_gender, age, passenger_details_id) values(?,?,?,?,?,?)";

	public static String getPassengerDetailsList = "select passenger_details_id, passenger_first_name, passenger_last_name, passenger_gender, age from travel_passenger_details where request_id = ?";

	public static String updateTravelPassengerDetails = "UPDATE travel_passenger_details SET request_id=?, passenger_first_name=?, passenger_last_name=?, passenger_gender=?, age=? WHERE passenger_details_id=?";

	public static String deletetravelPassengerDetails = "delete from travel_passenger_details where request_id=?";


	public static String update_travelBookingRequestApprove = "update travel_booking_request set status=?, remarks=?, approved_by=?, approved_date=now() where request_id=?";

	public static String get_travelBookingDetails_List = "SELECT request_id as requestId, TO_CHAR(requested_date,'dd/mm/yyyy') as requestDate, (select concat(employee_master.first_name,' ',employee_master.middle_name,' ',employee_master.surname) from employee_master where emp_id=requested_for) as requestForName,request_type as requestType,travel_booking_request.status as status, (select concat(first_name,' ',middle_name,' ',surname) from user_master where user_id=requested_by) as approvedBy,(select concat(first_name,' ',middle_name,' ',surname) from user_master where user_id=requested_by) as requestBy,TO_CHAR(travel_booking_request.approved_date,'dd/mm/yyyy') as approvedDate From travel_booking_request inner join user_master on travel_booking_request.requested_by = user_master.user_id ORDER BY requested_date DESC";
	
	public static String delete_request_details = "delete from travel_passenger_details where request_id=?";

	public static String delete_header_air_details = "delete from travel_air_booking_request where request_id=?";

	public static String delete_header_hotel_details = "delete from travel_hotel_booking_request where request_id=?";

	public static String delete_header_train_details = "delete from travel_train_booking_request where request_id=?";

	public static String delete_header_main_details = "delete from travel_booking_request where request_id=?";

	public static String check_Travelliing_Date = "select  count(*) from travel_train_booking_request " + "inner join travel_booking_request on travel_booking_request.request_id=travel_train_booking_request.request_id " + "where travel_train_booking_request.travelling_date = to_date(? ,'DD/MM/YYYY') " + "and (travel_train_booking_request.depature_time, travel_train_booking_request.arrival_time) OVERLAPS (to_timestamp(?,'HH24:MI'), to_timestamp(?,'HH24:MI')) " + "and travel_booking_request.requested_for=?";

	public static String check_Air_booking_DAate = "select  count(*) from travel_air_booking_request " + "inner join travel_booking_request on travel_booking_request.request_id=travel_air_booking_request.request_id " + "where travel_air_booking_request.travelling_date = to_date(? ,'DD/MM/YYYY') " + "and (travel_air_booking_request.depature_time, travel_air_booking_request.arrival_time) OVERLAPS (to_timestamp(?,'HH24:MI'), to_timestamp(?,'HH24:MI')) " + "and travel_booking_request.requested_for=?";

	public static String check_hotel_booking_Date = "select  count(*) from travel_hotel_booking_request " + "inner join travel_booking_request on travel_booking_request.request_id=travel_hotel_booking_request.request_id " + "where travel_hotel_booking_request.checkin_date = to_date(? ,'DD/MM/YYYY') " + "and (travel_hotel_booking_request.checkin_time, travel_hotel_booking_request.checkout_time) OVERLAPS (to_timestamp(?,'HH24:MI'), to_timestamp(?,'HH24:MI')) " + "and travel_booking_request.requested_for=?";

	public static String check_Travelliing_Date_Edit = "select  count(*) from travel_train_booking_request " + "inner join travel_booking_request on travel_booking_request.request_id=travel_train_booking_request.request_id " + "where travel_train_booking_request.travelling_date = to_date(? ,'DD/MM/YYYY') " + "and (travel_train_booking_request.depature_time, travel_train_booking_request.arrival_time) OVERLAPS (to_timestamp(?,'HH24:MI'), to_timestamp(?,'HH24:MI')) "
			+ "and travel_booking_request.requested_for=? and travel_booking_request.request_id!=?";

	public static String check_Air_booking_DAate_Edit = "select  count(*) from travel_air_booking_request " + "inner join travel_booking_request on travel_booking_request.request_id=travel_air_booking_request.request_id " + "where travel_air_booking_request.travelling_date = to_date(? ,'DD/MM/YYYY') " + "and (travel_air_booking_request.depature_time, travel_air_booking_request.arrival_time) OVERLAPS (to_timestamp(?,'HH24:MI'), to_timestamp(?,'HH24:MI')) " + "and travel_booking_request.requested_for=? and travel_booking_request.request_id!=?";

	public static String check_hotel_booking_Date_Edit = "select  count(*) from travel_hotel_booking_request " + "inner join travel_booking_request on travel_booking_request.request_id=travel_hotel_booking_request.request_id " + "where travel_hotel_booking_request.checkin_date = to_date(? ,'DD/MM/YYYY') " + "and (travel_hotel_booking_request.checkin_time, travel_hotel_booking_request.checkout_time) OVERLAPS (to_timestamp(?,'HH24:MI'), to_timestamp(?,'HH24:MI')) "
			+ "and travel_booking_request.requested_for=? and travel_booking_request.request_id!=?";
	
	
	public static String delete_Air_DEPATURE_DETAILS="delete from travel_departure_arrival_dtl where request_id =?";
	
	public static String delete_Train_DEPATURE_DETAILS="delete from train_travel_departure_arrival_dtl where request_id =?";
	
	public static String GET_Dept_NO="select dept from user_master where user_id=?";
	
	//work flow approval list
	
	public static String get_frst_approval_List = "SELECT ? as stepOrder,request_id as requestId, TO_CHAR(requested_date,'dd/mm/yyyy') as requestDate, "
			+"  (select employee_master.first_name from employee_master where emp_id=requested_for) as requestForName, "
		    +" request_type as requestType, travel_booking_request.status as status, (select concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) from user_master where user_id=requested_by) as requestBy  "
			+"  From travel_booking_request left join user_master on user_master.user_id =travel_booking_request.requested_by "
			+"  ORDER BY requested_date DESC ";
	
	
	public static String get_frst_reporting_manager_approval_List = "SELECT ? as stepOrder,request_id as requestId, TO_CHAR(requested_date,'dd/mm/yyyy') as requestDate,em.first_name as requestForName,request_type as requestType, tr.status as status, (select concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) from user_master where user_id=requested_by) as requestBy From travel_booking_request tr left join user_master on user_master.user_id =tr.requested_by inner join employee_master em on em.emp_id=tr.requested_for where em.reporting_to=? ORDER BY requested_date DESC";

	public static String get_nxt_reporting_manager_approval_List = "SELECT ? as stepOrder,request_id as requestId, TO_CHAR(requested_date,'dd/mm/yyyy') as requestDate,em.first_name as requestForName,request_type as requestType, tr.status as status, (select concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) from user_master where user_id=requested_by) as requestBy From travel_booking_request tr left join user_master on user_master.user_id =tr.requested_by inner join employee_master em on em.emp_id=tr.requested_for inner join travel_work_flow twf on twf.travel_id=tr.request_id where em.reporting_to=? and twf.step_id=? and twf.status=1 ORDER BY requested_date DESC";

	public static String get_nxt_approval_List = "SELECT ? as stepOrder,request_id as requestId, TO_CHAR(requested_date,'dd/mm/yyyy') as requestDate,em.first_name as requestForName,request_type as requestType, tr.status as status, (select concat(user_master.first_name,' ',user_master.middle_name,' ',user_master.surname) from user_master where user_id=requested_by) as requestBy From travel_booking_request tr left join user_master on user_master.user_id =tr.requested_by inner join employee_master em on em.emp_id=tr.requested_for inner join travel_work_flow twf on twf.travel_id=tr.request_id where twf.step_id=? and twf.status=1 ORDER BY requested_date DESC";


	public static String workFlowCountInTravelTable="select count(*) from travel_work_flow where travel_id=? and step_id=?";
	
	public static String getWorkFlowDetailsUsingStepsId="select step_order as stepOrder,step_name as stepName,approve_type as approveType,role_name_user as roleNameUser from wf_mapping wm inner join wf_steps ws on ws.wf_id=wm.wf_id where wm.system_module=? and ws.step_order=? limit 1";

	public static String insert_travel_workflow="insert into travel_work_flow (travel_id,step_id,step_name,approve_type,role_name_user,status,remarks,created_by,created_on) values (?,?,?,?,?,?,?,?,now())";
	
	public static String update_travel_workflow="update travel_work_flow set status=?,remarks=?,role_name_user=? where travel_id=? and step_id=?";
	
	public static String getworkFlowViewList="select step_name as stepName,um.user_name as approvedBy,to_char(created_on,'dd/mm/yyyy') as approvedDate,remarks as stepRemarks,case when twf.status=1 then 'Approved' when twf.status=2 then 'Cancelled' else 'Pending' end as stepStatus from travel_work_flow twf left join user_master um on um.user_id=twf.role_name_user where travel_id=? order by step_id asc";
	
	public static String get_reportingPersonCount="SELECT count(*) From travel_booking_request tr left join user_master on user_master.user_id =tr.requested_by inner join employee_master em on em.emp_id=tr.requested_for inner join travel_work_flow twf on twf.travel_id=tr.request_id where em.reporting_to=? and twf.step_id=? and twf.status=1";


	public static String DELETE_WORKFLOW_DTL="delete from travel_work_flow where travel_id=?";

}
