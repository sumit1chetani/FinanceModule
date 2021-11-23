package com.dci.tenant.master.trucktrailermapping;

public class TruckTrailerMappingQueryUtil {
	public static String truck = "select truck_id as id,license_plate as text from truck_master";

	public static String trailer = "select trailer_id as id,trailer_no as text from trailer";

	public static final String list = "select truck_trailer_mapping_id as trucktrailerId,to_char(from_date,'dd/mm/yyyy')fromDate,to_char(to_date,'dd/mm/yyyy')toDate,m.truck_id as truckId ,m.trailer_id as trailerId,tc.truck_reg_no as truckName,tc.license_plate as trucklicenseNo,trailer_no as trailerName from truck_trailer_mapping m inner join truck_master tc on m.truck_id=tc.truck_id inner join trailer tr on tr.trailer_id=m.trailer_id ORDER BY truck_trailer_mapping_id  desc";

	public static final String Truck_mapping = "select count(*) from plan_trip where truck_trailer_mapping_id=?";
	public static final String Truck_mapping1 = "select to_char(trip_start_date,'dd/mm/yyyy')startDate from plan_trip where truck_trailer_mapping_id=?";
	public static final String GET_Date_LIST1 = "select to_char(eta,'dd/mm/yyyy') as startDate  from  plan_trip where truck_trailer_mapping_id=? order by eta desc limit 1";

	public static String add = "insert into truck_trailer_mapping(truck_id,trailer_id,from_date,to_date,created_by,created_on)values(?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,now())";

	public static String COUNT = "select count(*) from truck_trailer_mapping where (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_id=? or trailer_id=? and (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day)";

	public static String COUNT1 = "select count(*) from truck_trailer_mapping where (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_id=? and truck_trailer_mapping_id<>? or trailer_id=? and (from_date,to_date) overlaps (to_date(?,'dd/mm/yyyy')-interval '1' day,to_date(?,'dd/mm/yyyy')+interval '1' day) and truck_trailer_mapping_id<>?";

	public static String delete = "delete from truck_trailer_mapping where truck_trailer_mapping_id=?";
	public static String update = "update truck_trailer_mapping set truck_id =?,trailer_id=?,from_date =to_date(?,'dd/mm/yyyy'),to_date =to_date(?,'dd/mm/yyyy'),modified_by=?,modified_on=now() where truck_trailer_mapping_id=? ";
	public static String edit = "select truck_trailer_mapping_id as trucktrailerId,m.truck_id as truckId,m.trailer_id as trailerId,concat(tc.truck_reg_no,'-',tc.license_plate)  as truckName,tr.trailer_no as trailerName ,to_char(from_date,'dd/mm/yyyy') fromDate,to_char(to_date,'dd/mm/yyyy') toDate from truck_trailer_mapping m inner join truck_master tc on m.truck_id=tc.truck_id  inner join trailer tr on tr.trailer_id=m.trailer_id where truck_trailer_mapping_id=?";

	public static String SELECT_PREVIOUS_ID = "select max(truck_trailer_mapping_id) as trucktrailerId from truck_trailer_mapping";

	public static String SELECT_TRUCK_BY_ID = "select ttm.truck_trailer_mapping_id as trucktrailerId,ttm.truck_id as truckId,ttm.trailer_id as trailerId,ttm.from_date as fromDate,ttm.to_date as toDate,tm.license_plate as truckName,tl.trailer_no as trailerName  from truck_trailer_mapping ttm inner join truck_master tm on ttm.truck_id=tm.truck_id inner join trailer tl on ttm.trailer_id=tl.trailer_id where ttm.truck_id=?";

	public static String SELECT_TRAILER_BY_ID = "select ttm.truck_trailer_mapping_id as trucktrailerId,ttm.truck_id as truckId,ttm.trailer_id as trailerId,ttm.from_date as fromDate,ttm.to_date as toDate,tm.license_plate as truckName,tl.trailer_no as trailerName  from truck_trailer_mapping ttm inner join truck_master tm on ttm.truck_id=tm.truck_id inner join trailer tl on ttm.trailer_id=tl.trailer_id where ttm.trailer_id=?";

	public static String SELECT_TRK_TRAILMAPID = "select truck_trailer_mapping_id as trucktrailerId,to_char(from_date,'dd/MM/yyyy') as fromDate,to_char(to_date,'dd/MM/yyyy') as toDate from truck_trailer_mapping  where truck_id=? and trailer_id=? and from_date <=to_date(?,'dd/MM/yyyy') and to_date>=to_date(?,'dd/MM/yyyy') ";
	
	public static String SELECT_TRK_TRAILID ="select truck_id as truckId, trailer_id as trailerId from truck_trailer_mapping  where truck_trailer_mapping_id=?";

}
