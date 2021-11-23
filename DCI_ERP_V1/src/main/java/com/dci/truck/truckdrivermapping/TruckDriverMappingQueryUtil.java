package com.dci.truck.truckdrivermapping;

public class TruckDriverMappingQueryUtil {
	public static String truck="select truck_id as id,license_plate as text from truck_master where is_active= true ";

//	public static String driver="select emp_id as id,concat(emp_id,'-',emp_name) as text  from employee_master  em inner join designation_master dm on dm.desgn_code=em.designation where upper(desgn_name)like '%DRIVER%' order by emp_id asc";
	public static String driver="select emp_id as id,concat(emp_id,'-',emp_name) as text  from employee_master order by emp_id asc ";

	public static final String list ="select truck_driver_mapping_id as truckdriverId,to_char(from_date,'dd/mm/yyyy')fromDate,to_char(to_date,'dd/mm/yyyy')toDate,m.truck_id as truckId ,m.emp_id as driverId,m.sec_emp_id as sdriverId,tc.truck_reg_no as truckName,tc.license_plate as trucklicenseNo, concat(e.emp_id,'-',e.emp_name) as driverName,concat(em.emp_id,'-',em.emp_name) as sdriverName from truck_driver_mapping m inner join truck_master tc on m.truck_id=tc.truck_id inner join employee_master e on e.emp_id=m.emp_id left join employee_master em on em.emp_id=m.sec_emp_id order by truck_driver_mapping_id desc ";
    public static String add="insert into truck_driver_mapping(truck_id,emp_id,from_date,to_date,sec_emp_id,created_by,created_on)values(?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,now())";
	public static String COUNT7="select count(*) from truck_driver_mapping where sec_emp_id=? and  (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day)  or  emp_id=? and  (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) ";
	public static String COUNT8="select count(*) from truck_driver_mapping where sec_emp_id=? AND  (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day)  or  emp_id=? AND  (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) ";

	public static String COUNT6="select count(*) from truck_driver_mapping where (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_id=?  ";
	//public static String COUNT2= "select count(*) from truck_driver_mapping where truck_id=? and emp_id=?";

	public static String COUNT0="select count(*) from truck_driver_mapping where (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_id=? and  truck_driver_mapping_id<>?  ";
	public static String COUNT1="select count(*) from truck_driver_mapping where sec_emp_id=?  and (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_driver_mapping_id<>? or emp_id=? AND (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_driver_mapping_id<>? ";
	public static String COUNT2="select count(*) from truck_driver_mapping where sec_emp_id=?   and (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_driver_mapping_id<>? or emp_id=? AND  (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_driver_mapping_id<>? ";

	
	public static String COUNT3= "select count(*) from truck_driver_mapping where truck_id=? and emp_id=? and truck_driver_mapping_id<>? ";

	public static String delete="delete from truck_driver_mapping where truck_driver_mapping_id=?";
	public static String update="update truck_driver_mapping set truck_id =?,emp_id=?,from_date =to_date(?,'dd/mm/yyyy'),to_date =to_date(?,'dd/mm/yyyy'),sec_emp_id=?,modified_by=?,modified_on=now() where truck_driver_mapping_id=? ";
	public static String edit="select truck_driver_mapping_id as truckdriverId,m.truck_id as truckId,m.emp_id as driverId,m.sec_emp_id as sdriverId ,concat(tc.truck_reg_no,'-',tc.license_plate)  as truckName,e.emp_name as driverName ,em.emp_name as sdriverName,to_char(from_date,'dd/mm/yyyy') fromDate,to_char(to_date,'dd/mm/yyyy') toDate from truck_driver_mapping m  inner join truck_master tc on m.truck_id=tc.truck_id  inner join employee_master e on e.emp_id=m.emp_id left join employee_master em on em.emp_id=m.sec_emp_id where truck_driver_mapping_id=?";

//elect count(*) from truck_driver_mapping where (from_date,to_date) overlaps (to_date('04/04/2018','dd/mm/yyyy')-interval '1' day,to_date('17/04/2018','dd/mm/yyyy')+interval '1' day) and truck_id=42 and  truck_driver_mapping_id<>129 or (sec_emp_id='E0052' or emp_id='E0053'  and (from_date,to_date) overlaps  (to_date('04/04/2018','dd/mm/yyyy')-interval '1' day,to_date('17/04/2018','dd/mm/yyyy')+interval '1' day)  and truck_driver_mapping_id<>129) 

    public static String SELECT_PREVIOUS_ID = "select max(truck_driver_mapping_id) as truckdriverId from truck_driver_mapping";

    public static String Check_Trip_Started_Or_Not = "With tripAlloc as (select distinct on (pt.plan_trip_id) pt.plan_trip_id as planId,trip_allocation_id as tripId,b.booking_id as id,(select contact_no from employee_master where emp_id=tdm.emp_id) as mobileNo, tm.truck_reg_no as vehicleNo, "
			+ " (select location_name from location where location_id=pt.from_location) as source, (select location_name from location where location_id=pt.to_location) as destination,   "
			+ " alloted_on as tripDate, pt.trip_no as tripNo,tdm.truck_driver_mapping_id as driverMappingId from trip_allocation ta inner join plan_trip pt on ta.trip_id=pt.plan_trip_id   "
			+ "  inner join truck_driver_mapping tdm on pt.truck_driver_mapping_id=tdm.truck_driver_mapping_id   "
			+ "   inner join booking_dtl bd on bd.booking_dtl_id=ta.booking_dtl_id  "
			+ "   inner join booking b on b.booking_id=bd.booking_id  "
			+ "   inner join truck_master tm on tm.truck_id=tdm.truck_id)   "
			+ "   select count(*) from tripAlloc where exists(select trip_status_id from trip_status_log   "
			+ "   where allocate_trip_id=tripId and trip_status_id=(select trip_status_id from trip_status where trip_status_value='Drive'))=true  "
			+ "   and driverMappingId=?";


    public static String SELECT_SELECTED_TRUK_DTL = "select tdm.truck_driver_mapping_id as trkDrvMapId,tdm.truck_id as truckId,tm.license_plate truckName,tdm.from_date as fromDate, tdm.to_date as toDate,concat(em1.emp_id,'-',em1.emp_name) as driverName,concat(em2.emp_id,'-',em2.emp_name) as sdriverName from truck_driver_mapping tdm inner join truck_master tm on tdm.truck_id= tm.truck_id inner join employee_master em1 on tdm.emp_id=em1.emp_id left join employee_master em2 on tdm.sec_emp_id=em2.emp_id where tdm.truck_id=? ";
    
    public static String SELECT_SELECTED_PRMDRIVER_DTL="select tdm.truck_driver_mapping_id as trkDrvMapId,tm.license_plate truckName,concat(em1.emp_id,'-',em1.emp_name) as driverName,concat(em2.emp_id,'-',em2.emp_name) as sdriverName,tdm.from_date as fromDate, tdm.to_date as toDate from truck_driver_mapping tdm inner join employee_master em1 on tdm.emp_id=em1.emp_id left join employee_master em2 on tdm.sec_emp_id=em2.emp_id inner join truck_master tm on tdm.truck_id= tm.truck_id where tdm.emp_id=? or tdm.sec_emp_id=?";
    
    public static String SELECT_SELECTED_SECDRIVER_DTL="select tdm.truck_driver_mapping_id as trkDrvMapId,tm.license_plate truckName,concat(em1.emp_id,'-',em1.emp_name) as driverName,concat(em2.emp_id,'-',em2.emp_name) as sdriverName,tdm.from_date as fromDate, tdm.to_date as toDate from truck_driver_mapping tdm inner join employee_master em1 on tdm.emp_id=em1.emp_id left join employee_master em2 on tdm.sec_emp_id=em2.emp_id inner join truck_master tm on tdm.truck_id= tm.truck_id where tdm.sec_emp_id=? or tdm.emp_id=?";
    
    
}
