package com.dci.mobileApp;

public class MobileAppQueryUtil {
	public static String GET_EMP_CNT = "select count(*) from employee_master where emp_id = ? and password = ?";

public static String GET_EMP_INFO = "select emp_id as userId,emp_name as username,password as password,company_code as companyCode,dept as departmentName,designation as designationName,email_id as email,vendor as isVendor, vendor_name as vendorName,profile_img as profileImg from employee_master where emp_id = ? and password = ?";

public static String INSERT_BOOKING = "insert into mbk_booking (booking_no, pol,  pod, customer,booking_date, vehicle_no, driver_name,mobile_no,container_no,opening_km,closing_km,user_id) values " + 
		"(?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) returning mbk_booking_id";

public static String GET_MAX_BOOKING = "select coalesce(max(mbk_booking_id),0) from mbk_booking";

public static String GET_LOCATION_DETAILS = "select location_name locationName, location_code locationCode,location_id locationId from location order by location_name";

public static String GET_CUSTOMER_DETAILS = "select mlo_code as custId,mlo_name as custName from mlo_master order by mlo_name";

public static String INSERT_EXPENSES = "insert mbk_trip_expenses (booking_id,expenses,amount) values (?,?,?)";

public static String GET_BOOKING_DETAILS = "select mbk_booking_id as bookingId, booking_no as bookingNo, pol,  pod, customer,booking_date as date, vehicle_no as vehicleNo, driver_name as driverName,mobile_no as driverMobileNo,container_no as containerNo,opening_km as openingKm,closing_km as closingKm from mbk_booking where user_id = ? order by booking_date desc";

public static String GET_EXPENSES_DETAILS = "select expenses as expenses,amount as expAmount from mbk_trip_expenses where booking_id = ?";

public static String EDIT_BOOKING_DETAILS = "select mbk_booking_id as bookingId, booking_no as bookingNo, pol,  pod, customer,booking_date as date, vehicle_no as vehicleNo, driver_name as driverName,mobile_no as driverMobileNo,container_no as containerNo,opening_km as openingKm,closing_km as closingKm from mbk_booking where mbk_booking_id = ?";




}
