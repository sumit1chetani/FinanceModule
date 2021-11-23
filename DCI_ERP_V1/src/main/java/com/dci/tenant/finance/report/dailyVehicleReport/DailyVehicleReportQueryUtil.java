package com.dci.tenant.finance.report.dailyVehicleReport;

public class DailyVehicleReportQueryUtil {

	public static final String TRUCK_LIST = "select truck_id as id,license_plate as text from truck_master";
	
	public static final String TRIP_LIST = "select plan_trip_id as id,trip_no as text from plan_trip";
	
	public static final String TRUCK_LIST_BY_TRIP = "select tm.truck_id as id,tm.license_plate as text from plan_trip pt inner join truck_trailer_mapping ttm on ttm.truck_trailer_mapping_id = pt.truck_trailer_mapping_id inner join truck_master tm on tm.truck_id=ttm.truck_id where pt.plan_trip_id = ?";

	public static final String TRUCK_NAME = "select license_plate as truckName from truck_master where truck_id = ?::int";
	
	public static final String IDLE_HOUR = "select round(EXTRACT(EPOCH FROM to_timestamp(?,'dd/Mon/yyyy hh24:mi:ss') - to_timestamp(?,'dd/Mon/yyyy hh24:mi:ss') )/3600)::text  ||':' || to_char(to_timestamp(?,'dd/Mon/yyyy hh24:mi:ss') - to_timestamp(?,'dd/Mon/yyyy hh24:mi:ss'), 'MI:SS') as idleHour";
	
	public static final String  DAILY_VEHICLE_REPORT = "select m.mlo_name as customer, lol.location_name || ' - '|| lod.location_name as location,  to_char(tsl.status_datetime,'dd/Mon/yyyy hh24:mi:ss') as timeStart, (case when tsl.trip_status_id =11 then to_char(tsl.status_datetime,'dd/Mon/yyyy hh24:mi:ss') else to_char(tsl.next_status_dt,'dd/Mon/yyyy hh24:mi:ss') end) as timeEnd, coalesce ((case when tsl.next_status_dt is not null then round(EXTRACT(EPOCH FROM tsl.next_status_dt - tsl.status_datetime )/3600)::text else '-' end) ||':' || to_char(tsl.next_status_dt - tsl.status_datetime, 'MI:SS'),'00:00:00') as hour,d.trip_status_value as status, trip_no as tripNo , allocate_trip_id from trip_allocation ta inner join trip_status_log tsl on tsl.allocate_trip_id = ta.trip_id inner join trip_status d on d.trip_status_id = tsl.trip_status_id inner join booking_dtl bd on bd.booking_dtl_id = ta.booking_dtl_id inner join booking b on b.booking_id = bd.booking_id inner join plan_trip pt on pt.plan_trip_id = ta.trip_id inner join location lol on lol.location_id = b.lol_id inner join location lod on lod.location_id = b.lod_id inner join mlo_master m on m.mlo_code = b.mlo_code inner join truck_trailer_mapping ttm on ttm.truck_trailer_mapping_id=pt.truck_trailer_mapping_id where tsl.status_datetime::date between to_date(?, 'dd/mm/yyyy') and  to_date(?, 'dd/mm/yyyy') and ttm.truck_id = ?::int order by mlo_name, trip_id, tsl.status_datetime ";
	
	public static final String  DAILY_VEHICLE_REPORT_BY_TRIP = "select m.mlo_name as customer, lol.location_name || ' - '|| lod.location_name as location,  to_char(tsl.status_datetime,'dd/Mon/yyyy hh24:mi:ss') as timeStart, (case when tsl.trip_status_id =11 then to_char(tsl.status_datetime,'dd/Mon/yyyy hh24:mi:ss') else to_char(tsl.next_status_dt,'dd/Mon/yyyy hh24:mi:ss') end) as timeEnd, coalesce ((case when tsl.next_status_dt is not null then round(EXTRACT(EPOCH FROM tsl.next_status_dt - tsl.status_datetime )/3600)::text else '-' end) ||':' || to_char(tsl.next_status_dt - tsl.status_datetime, 'MI:SS'),'00:00:00') as hour,d.trip_status_value as status, trip_no as tripNo , allocate_trip_id from trip_allocation ta inner join trip_status_log tsl on tsl.allocate_trip_id = ta.trip_id inner join trip_status d on d.trip_status_id = tsl.trip_status_id inner join booking_dtl bd on bd.booking_dtl_id = ta.booking_dtl_id inner join booking b on b.booking_id = bd.booking_id inner join plan_trip pt on pt.plan_trip_id = ta.trip_id inner join location lol on lol.location_id = b.lol_id inner join location lod on lod.location_id = b.lod_id inner join mlo_master m on m.mlo_code = b.mlo_code inner join truck_trailer_mapping ttm on ttm.truck_trailer_mapping_id=pt.truck_trailer_mapping_id where tsl.status_datetime::date between to_date(?, 'dd/mm/yyyy') and  to_date(?, 'dd/mm/yyyy') and ttm.truck_id = ?::int  and pt.plan_trip_id = ? order by mlo_name, trip_id, tsl.status_datetime ";

	

}
