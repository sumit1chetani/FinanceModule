package com.dci.tenant.truck.location;



public class LocationQueryUtil {
	
	public static String LOCATION_CODE = "SELECT CASE WHEN MAX(location_code) IS NULL  THEN 'LN0001' ELSE rpad(MAX(location_code),2,'CB')|| lpad(cast(cast((SUBSTRING(MAX(location_code),4)) as int)+1  as text),4,'0') END FROM location";
	
    public static String CHECK_LOC_NAME = "select count(*)from location where location_name Ilike ?";
	 
    public static String CHECK_LOC_SHORT_NAME = "select count(*)from location where loc_short_name Ilike ?";
	
    public static String INSERT = "insert into location(location_code,location_name,loc_short_name,land_mark,location_type,latitude,longitude,description,created_by,created_dt,country_id)values(?,?,?,?,?,?,?,?,?,now(),?)";

    public static String LOCATION_LIST="select location_id as locationId,location_code as locationCode,location_name as locationName,loc_short_name as shortName,land_mark as landMark,location_type as type,latitude as latitude,longitude as longitude,description as description,(select country_name from country_master where country_code=l.country_id) as countryName from location l order by location_id desc";
    
    public static String EDIT_LOCATION="select location_id as locationId,location_code as locationCode,location_name as locationName,loc_short_name as shortName,land_mark as landMark,location_type as type,latitude as latitude,longitude as longitude,description as description,country_id as countryId from location where location_id = ?";

    public static String UPDATE_LOCATION = "update location set location_name = ?,loc_short_name = ?,land_mark = ?,location_type = ?,latitude = ?,longitude = ?,description = ?,country_id = ?,modified_by = ?,modified_dt = now() where location_id = ?";

    public static String UPDATE_LOCATION1 = "update location set location_name = ?,loc_short_name = ?,land_mark = ?,location_type = ?,latitude = ?,longitude = ?,description = ?,country_id = ?,modified_by = ?,modified_dt = now() where location_id = ?";

    public static String UPDATE_LOCATION2 = "update location set location_name = ?,land_mark = ?,location_type = ?,latitude = ?,longitude = ?,description = ?,country_id= ?,modified_by = ?,modified_dt = now() where location_id = ?";

    public static String UPDATE_LOCATION3 = "update location set loc_short_name = ?,land_mark = ?,location_type = ?,latitude = ?,longitude = ?,description = ?,country_id = ?,modified_by = ?,modified_dt = now() where location_id = ?";

    public static String DELETE_LOCATION ="delete from  location where location_id = ?";
    
    public static String SELECT_PREVIOUS_ID = "select max(location_id) as taxid from location";

    public static String COUNTRY_LIST = "select country_code as id,country_name as text from country_master order by country_name asc";
    
//	public static String sPortDropDown = "select location_id as fromPort, location_id as id,loc_short_name as text from location order by location_code asc";

    public static String sPortDropDown=" select prt_icd_id as fromPort,prt_icd_id as id,concat(prt_icd_cd,'-',prt_icd_nam) as text from port_icd where actv_bt ='1' order by prt_icd_nam asc ";  
    		
    
}

