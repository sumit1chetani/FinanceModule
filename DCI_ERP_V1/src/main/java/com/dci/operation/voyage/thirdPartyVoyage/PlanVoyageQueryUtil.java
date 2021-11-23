package com.dci.operation.voyage.thirdPartyVoyage;



public class PlanVoyageQueryUtil {

	// Committed For Sending Whatsapp Message
	public static final String VOYAGE_SEND_MESSAGE = "INSERT INTO MSG_NOTIFICATION(DATETIME, TO_NUMBER, MESSAGE, STATUS) VALUES (?, ?, ?, ?)";

	public static final String GET_VOYAGE_LIST = "select   v.voyage_id as voyageId   from   voyage v   where "
			+ "upper(v.third_party)='S' ";

	public static final String GET_PLAN_VOYAGE_LIST = "select * from (select  ve.vessel_name as vesselName, "
			+ "s.sector_name as sectorName, "
			+ "v.voyage_id as voyageId, "
			+ "ac.activity_name activityName,"
			+ "ac.activity_code, "
			+ "to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate, "
			+ "to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate, "
			+ "s.sector_code as sectorId, "
			+ "vessel_code vesselCode,v.created_date,v.vessel_optr as vesselOperator  from "
			+ "voyage v,sector_master s,vessel_master ve,activity_master ac , VIEW_USER_RIGHTS_FOR_LIST ur   where   v.sector_id = s.sector_code and   v.vessel_id = ve.vessel_code and "
			+ "v.activity_code=ac.activity_code  and ur.company_code= s.sec_company_code and "
			+ "v.third_party = 'S' and ur.form_code = ? and user_id = ?) t1 "
			+ "where vesselCode is not null ";
	
	public static final String GET_PLAN_VOYAGE_LIST_SINGAPORE = "select distinct * from (select distinct ve.vessel_name as vesselName, "
			+ "s.sector_name as sectorName, "
			+ "v.voyage_id as voyageId, "
			+ "ac.activity_name activityName,"
			+ "ac.activity_code, "
			+ "to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate, "
			+ "to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate, "
			+ "s.sector_code as sectorId, "
			+ "vessel_code vesselCode,v.created_date,v.vessel_optr as vesselOperator  from "
			+ "voyage v,sector_master s,vessel_master ve,activity_master ac , VIEW_USER_RIGHTS_FOR_LIST ur "
			+ " inner join employee_master emp on emp.emp_id = ur.user_id "
			+ " where   v.sector_id = s.sector_code and   v.vessel_id = ve.vessel_code and "
			+ "v.activity_code=ac.activity_code  and v.voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where ((from_port_id in ('PSA') or to_port_id in  ('PSA')) or (v.vessel_id = 'NWIN') or (v.sector_id in('GALEX')) )) and "
			+ "v.third_party = 'S' and ur.form_code = ? and user_id = ?) t1 "
			+ "where vesselCode is not null ";
	
	public static final String GET_PLAN_VOYAGE_LIST_MY = "select * from (select  ve.vessel_name as vesselName, "
			+ "s.sector_name as sectorName, "
			+ "v.voyage_id as voyageId, "
			+ "ac.activity_name activityName,"
			+ "ac.activity_code, "
			+ "to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate, "
			+ "to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate, "
			+ "s.sector_code as sectorId, "
			+ "vessel_code vesselCode,v.created_date,v.vessel_optr as vesselOperator  from "
			+ "voyage v,sector_master s,vessel_master ve,activity_master ac , VIEW_USER_RIGHTS_FOR_LIST ur "
			+ " inner join employee_master emp on emp.emp_id = ur.user_id "
			+ " where   v.sector_id = s.sector_code and   v.vessel_id = ve.vessel_code and "
			+ "v.activity_code=ac.activity_code  and v.voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where (from_port_id in ('MYPKL','MYPKG') or to_port_id in  ('MYPKL','MYPKG'))) and "
			+ "v.third_party = 'S' and ur.form_code = ? and user_id = ?) t1 "
			+ "where vesselCode is not null ";	
	
	
	public static final String GET_PLAN_VOYAGE_LIST_MALAYSIA= "select * from (select  ve.vessel_name as vesselName, "
			+ "s.sector_name as sectorName, "
			+ "v.voyage_id as voyageId, "
			+ "ac.activity_name activityName,"
			+ "ac.activity_code, "
			+ "to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate, "
			+ "to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate, "
			+ "s.sector_code as sectorId, "
			+ "vessel_code vesselCode,v.created_date,v.vessel_optr as vesselOperator  from "
			+ "voyage v,sector_master s,vessel_master ve,activity_master ac , VIEW_USER_RIGHTS_FOR_LIST ur  inner join employee_master emp on emp.emp_id = ur.user_id  where   v.sector_id = s.sector_code and   v.vessel_id = ve.vessel_code and "
			+ "v.activity_code=ac.activity_code  and  v.company_wise = 'C0028' and "
			+ "v.third_party = 'S' and ur.form_code = ? and user_id = ?) t1 "
			+ "where vesselCode is not null ";

	public static final String GET_VESSEL_LIST = "select * from (select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed,"
			+ "v.flag flag  "
			+ "from vessel_master v, vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur  where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and "
			+ "sm.sec_company_code = ur.company_code and ur.form_code = ? and ur.user_id = ? and v.FLAG !='T' and "
			+ "v.FLAG !='O' and v.VESSEL_ACTIVE='Y' and v.vessel_name is not null and v.vessel_code is not null "
			+ " union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed, "
			+ "v.flag flag from vessel_master v, vessel_service_master vsm, sector_master sm, "
			+ "VIEW_USER_RIGHTS_FOR_LIST ur  where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and "
			+ "sm.sec_company_code = ur.company_code and ur.form_code =  ?  and ur.user_id = ? and upper(v.vessel_code)='BVR' "
			+ "union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed,v.flag flag "
			+ "from vessel_master v, vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur  where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and "
			+ "sm.sec_company_code = ur.company_code and ur.form_code = ? and ur.user_id = ? and  "
			+ "v.vessel_code in (select distinct vessel_id from voyage v inner join voyage_port vp on "
			+ "v.voyage_id=vp.voyage_id where upper(third_party) !='T')) t1 order by vessel_code";
	
	
	public static final String GET_VESSEL_LIST_OTHER_THAN_DUBAI = "select * from (select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed,"
			+ "v.flag flag  "
			+ "from vessel_master v, vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur left join employee_master emp on emp.emp_id=ur.user_id  where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and "
			+ "sm.sec_company_code = emp.company_code and ur.form_code = ? and ur.user_id = ? and v.FLAG !='T' and "
			+ "v.FLAG !='O' and v.VESSEL_ACTIVE='Y' and v.vessel_name is not null and v.vessel_code is not null "
			+ " union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed, "
			+ "v.flag flag from vessel_master v, vessel_service_master vsm, sector_master sm, "
			+ "VIEW_USER_RIGHTS_FOR_LIST ur  left join employee_master emp on emp.emp_id=ur.user_id where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and "
			+ "sm.sec_company_code = emp.company_code and ur.form_code =  ?  and ur.user_id = ? and upper(v.vessel_code)='BVR' "
			+ "union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed,v.flag flag "
			+ "from vessel_master v, vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur left join employee_master emp on emp.emp_id=ur.user_id where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and "
			+ "sm.sec_company_code = emp.company_code and ur.form_code = ? and ur.user_id = ? and  "
			+ "v.vessel_code in (select distinct vessel_id from voyage v inner join voyage_port vp on "
			+ "v.voyage_id=vp.voyage_id where upper(third_party) !='T')) t1 order by vessel_code";
	
	
	public static final String GET_VESSEL_LIST_MALAYSIA= "select * from (select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed,"
			+ "v.flag flag  "
			+ "from vessel_master v, vessel_service_master vsm, sector_master sm, voyage voy,VIEW_USER_RIGHTS_FOR_LIST ur left join employee_master emp on emp.emp_id=ur.user_id  where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and voy.vessel_id=v.vessel_code  and voy.company_wise ='C0028' "
			+ " and ur.form_code = ? and ur.user_id = ? and v.FLAG !='T' and "
			+ "v.FLAG !='O' and v.VESSEL_ACTIVE='Y' and v.vessel_name is not null and v.vessel_code is not null "
			+ " union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed, "
			+ "v.flag flag from vessel_master v, vessel_service_master vsm, sector_master sm,voyage voy, "
			+ "VIEW_USER_RIGHTS_FOR_LIST ur  left join employee_master emp on emp.emp_id=ur.user_id where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and voy.vessel_id=v.vessel_code and voy.company_wise ='C0028' "
			+ " and ur.form_code =  ?  and ur.user_id = ? and upper(v.vessel_code)='BVR' "
			+ "union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed,v.flag flag "
			+ "from vessel_master v, vessel_service_master vsm, sector_master sm, voyage voy,VIEW_USER_RIGHTS_FOR_LIST ur left join employee_master emp on emp.emp_id=ur.user_id where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and "
			+ " voy.vessel_id=v.vessel_code  and voy.company_wise ='C0028' and ur.form_code = ? and ur.user_id = ? and  "
			+ " v.vessel_code in (select distinct vessel_id from voyage v inner join voyage_port vp on "
			+ " v.voyage_id=vp.voyage_id where upper(third_party) !='T')) t1 order by vessel_code";

	public static final String GET_ACTIVITY_TYPES = "select " + "activity_code," + "activity_name " + "from "
			+ "activity_master where upper(applicablefor)=upper('Own Vessel') order by activity_name ";
	/*
	 * public static final String GET_SERVICE_LIST ="select " + "s.sector_code,"
	 * + "s.sector_name " + "from " +
	 * "vessel_master v,sector_master s,vessel_sector vs " + "where " +
	 * "v.vessel_code = vs.vessel and " + "vs.sector = s.sector_code and " +
	 * "v.vessel_code = ? ";
	 */

	public static final String GET_SERVICE_LIST = "	select distinct " + "s.sector_code, s.sector_name from "
			+ " vessel_master v,sector_master s,vessel_service_master vs,VIEW_USER_RIGHTS_FOR_LIST ur  where " + " v.vessel_code = vs.vessel_code and "
			+ " vs.sector_code = s.sector_code and v.vessel_code = ? and s.sec_company_code = ur.company_code ";
	
	

	public static final String GET_PORT_LIST = " select " + "sp.PORT_ID," + "sp.TO_PORT," + "sp.SL_NO,"
			+ "(select distance from distance_master where from_port=sp.PORT_ID and to_port=sp.TO_PORT)as distance " + "from " + "SECTOR_PORT sp "
			+ "where " + "SECTOR_ID =? " + "ORDER BY SL_NO";

	public static final String GET_SCHEDULE_VOYAGE_DTL = "with t_voyage as ( "
			+ "(select eta from VSL_VOYAGE_SCHEDULE_dtl d "
			+ "inner join VSL_VOYAGE_SCHEDULE s on s.vsl_voyage_schedule_id = d.vsl_voyage_schedule_id "
			+ "inner join vessel_schedule tv on tv.vessel_schedule_id = s.vessel_schedule_id "
			+ "where voyage_id = (select voyage_id from voyage where vessel_id =? and sector_id = ? order by "
			+ "created_date desc limit 1) and port_sequence=1 and tv.SERVICE_CODE =? limit 1) "
			+ "union  "
			+ " (select eta from voyage_port  where is_next_voyage ='N' and voyage_id  in(select voyage_id  from voyage where vessel_id  = ? and  sector_id =? ) order by eta desc limit 1)  ) "
			+ "select  vvs.VOYAGE_ID as voyageId, vvsd.PORT_CODE as fromPort, "
			+ "to_char(vvsd.ETA,'dd/mm/yyyy hh24:mi') as eta, "
			+ "vvsd.berth_hour berthingHour, "
			+ "vvsd.berth_min berthingMin, "
			+ "vvsd.PORT_STAY_HOUR as portStayHour, vvsd.PORT_STAY_MIN as portStayMin, "
			+ "vvsd.END_PORT as toPort, vvsd.port_sequence as portSequence, vvsd.DISTANCE as distance, vvsd.SPEED as speed, "
			+ "vvsd.STEAMING_HOUR as steamingHour, vvsd.STEAMING_MIN as steamingMin, vvsd.ROTATION_NO as rotationId, "
			+ "vvsd.out_value outValue,vvsd.zone_value zoneValue,vvsd.leg_dec leg  from "
			+ "vessel_schedule vs,  VSL_VOYAGE_SCHEDULE vvs,  VSL_VOYAGE_SCHEDULE_DTL vvsd  where "
			+ "vs.vessel_schedule_id = vvs.vessel_schedule_id and  vvs.VSL_VOYAGE_SCHEDULE_ID = vvsd.VSL_VOYAGE_SCHEDULE_ID "
			+ "and vs.VESSEL_CODE =? and vs.SERVICE_CODE =? and vvs.approved_by is not null  "
			+ "and  ((select count(*) from t_voyage) = 0 or eta > (select min(eta) from t_voyage)) "
			+ "and voyage_id not in (select voyage_id from voyage where vessel_id =? and sector_id = ?) "
			+ "order by vvsd.ETA";

	public static final String CHECK_PLAN_VOYAGE = "select " + "count(*) " + "from " + "voyage where voyage_id=? and sector_id=?";
	
	public static final String CHECK_VOYAGE = "select " + "count(*) " + "from " + "voyage where voyage_id=? ";

	public static final String GET_PRE_VOYAGE = "SELECT " + "VOYAGE_ID " + "FROM "
			+ "(select distinct v.VOYAGE_ID,v.created_date from voyage v inner join voyage_port vp on vp.voyage_id=v.VOYAGE_ID "  
			+ " where v.VESSEL_ID =?  order by v.created_date desc) temp " + " limit 1";

//	public static final String GET_DISTANCE = "select " + "distance " + "from " + "distance_master " + "where from_port =? and to_port =?";

//	public static final String GET_DISTANCE = "select "
//			+ "case when distance is null then "
//			+ "(select coalesce(distance,0)  from distance_master where from_port=sp.PORT_ID and to_port=sp.TO_PORT) else "
//			+ "sp.distance end as distance from   SECTOR_PORT sp "
//			+ "where port_id=? and to_port=? and SECTOR_ID=?";
	
	public static final String GET_DISTANCE = "with t as( select distinct distance,SECTOR_ID  from SECTOR_PORT sp where port_id=? and to_port=? and  SECTOR_ID=? ) "
			+ " select  case when ((select distance from t) is null or (select count(*)from t) =0) then (select coalesce(distance,0)  from distance_master where from_port=? and to_port=?) else (select distance from t) end as distance";
	
	public static final String INSERT_VOYAGE_HEADER = "insert " + "into voyage " + "(VOYAGE_ID," + "VESSEL_ID," + "SECTOR_ID," + "SCH_START_DATE,"
			+ "SCH_END_DATE," + "ACTIVITY_CODE," + "THIRD_PARTY," + "CREATED_BY," + "CREATED_DATE," + "STATUS," + "COMPANY_WISE,PRE_VOYAGE,"
			+ "vessel_optr," + "Proforma_Port_Cost," + "Chater_Hire_Cost," + "Total_Agency_Cost," + "Misc_Cost," + "Other_Expanses,"
			+ "Proforma_investment," + "FO_RVBUNKER_COST," + "GO_RVBUNKER_COST," + "Reason,Proforma_days,Proforma_hours,Proforma_mins,charter_liability,awrp,add_comm,ewri,nextsector_id,vlsfo_rvbunker_cost ,lsmgo_rvbunker_cost )" + "VALUES(upper(?),?,?,"
			+ "to_timestamp(?,'dd/mm/yyyy hh24:mi'),to_timestamp(?,'dd/mm/yyyy hh24:mi')," + "?,?,?,now(),'A',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String INSERT_VOYAGE_PORT_DTL = "insert " + "into voyage_port " + "(VOYAGE_ID," + "PORT_SEQUENCE," + "FROM_PORT_ID," + "ETA,"
			+ "rotation_no,berth_hour,berth_min, " + "STAY_HRS," + "STAY_MIN," + "STAY_HRS_CON," + "SPEED," + "STEAMING_HOUR," + "STEAMING_MIN," + "STEAMING_CONT_HOUR,"
			+ "TO_PORT_ID,is_next_voyage,out_value,zone_value,leg_dec)" + "values(?,?,?,to_timestamp(?,'dd/mm/yyyy hh24:mi')," + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String EDIT_VOYAGE_HEADER_DTL = "select sch_start_date as schStartDate,CASE WHEN cmp.company_code='C0001' THEN 'DXB-MKTG' WHEN cmp.company_code='C0028' THEN 'SIN-MKTG' ELSE cmp.short_name END as companyCode,"
			+ "sch_end_date as schEndDate, vessel_id vesselCode,sector_id as sectorId, " + "proforma_port_cost as portCost,"
			+ "chater_hire_cost as hireCost," + "total_agency_cost as agencyCost," + "activity_code as activityCode,"
			+ "(select activity_name from activity_master where activity_code=v.activity_code) as activityName," + "misc_cost as miscCost,"
			+ "other_expanses as otherExpenses ," + "proforma_investment as proformaInsurance," + "fo_rvbunker_cost as foBunkerCost,"
			+ "go_rvbunker_cost as gobunkerCost,vlsfo_rvbunker_cost as vlsfobunkerCost, lsmgo_rvbunker_cost as lsmgobunkerCost," + "reason as reasonId, " + "vessel_optr as mloShortName,Proforma_days as proformaDays,Proforma_hours  as proformaHours ,  Proforma_mins as proformaMins, "
+" charter_liability as charterLiability,awrp awrp,add_comm as addComm,ewri,nextsector_id as nextsectorId  "  + "from " + "voyage v  left join company_master cmp on cmp.company_code=v.company_wise"
			+ "  where voyage_id=? ";

	public static final String GET_PLAN_VOYAGE_DTL = "select " + "voyage_id as voyageId, " + "port_sequence as portSequence, "
			+ "from_port_id as fromPort, " + "(select distinct case when approved_by is not null then 'Y' else 'N' end "
			+ "from loading_summary where voyage_id=vp.voyage_id and POL=VP.FROM_PORT_ID  "
			+ "and cast(port_sequence as bigint)=vp.port_sequence and approved_by is not null) as loadingFlag," + "to_char(eta,'dd/mm/yyyy hh24:mi') as eta,"
			+ "coalesce(berth_hour,0) berthingHour,coalesce(berth_min,0) berthingMin, "
			+ "stay_hrs as portStayHour, " + "stay_min as portStayMin, " + "stay_hrs_con as portStayContHour, " + "etd as etd, "
			+ "to_port_id as toPort, "
			+ "(with t as( "
			+ "select distinct distance,SECTOR_ID  from SECTOR_PORT sp where port_id=vp.from_port_id and to_port=vp.to_port_id and  SECTOR_ID=(select sector_id from voyage   where voyage_id =vp.voyage_id) ) " 
			+ "select  case when ((select distance from t) is null or (select count(*)from t) =0) then (select coalesce(distance,0)  from distance_master where from_port=vp.from_port_id and to_port=vp.to_port_id) else (select distance from t) end as distance) as distance," + "speed as speed, "
			+ "rotation_no as rotationId,is_next_voyage as nextVoyage,out_value outValue,zone_value zoneValue,leg_dec leg " + "from voyage_port vp where vp.voyage_id=? order by port_sequence ";

	public static final String DELETE_VOYAGE_PORT_DTL = "DELETE " + "FROM " + "VOYAGE_PORT " + "WHERE VOYAGE_ID=?";
	
	public static final String DELETE_BOOKING_REQ_HEADER = "delete from booking_request_header where voyage_no=? and (case when (select count(book_req_id) from booking_request_detail where book_req_id = (select book_req_id from booking_request_header where voyage_no=?)) = 0 then true else false end) ";
	
	public static final String UPDATE_VOYAGE_HEADER = "update " + "voyage " + "set " + "SCH_START_DATE=to_timestamp(?,'dd/mm/yyyy hh24:mi'),"
			+ "SCH_END_DATE=to_timestamp(?,'dd/mm/yyyy hh24:mi'), " + "vessel_optr =?," + "Proforma_Port_Cost=?," + "Chater_Hire_Cost=?,"
			+ "Total_Agency_Cost=?," + "Misc_Cost=?," + "Other_Expanses=?," + "Proforma_investment=?," + "FO_RVBUNKER_COST=?,"
			+ "GO_RVBUNKER_COST=?," + "Reason=?,Proforma_days=?,Proforma_hours =? ,Proforma_mins=?  ,charter_liability=?,awrp=?,add_comm=?,ewri=?,nextsector_id=?,vlsfo_rvbunker_cost=?,lsmgo_rvbunker_cost=? " + "where voyage_id=?";

	public static final String DELETE_PLAN_VOYAGE = "delete " + "from " + "voyage " + "where " + "voyage_id=?";

	public static final String GET_VOYAGE_COUNT = "select " + "count(*) " + "from " + "voyage " + "where vessel_id=?";

	public static final String GET_MAX_VOYAGE_ID = "select " + "voyage_id " + "from " + "voyage  " + "where "
			+ "CREATED_DATE =(select max(CREATED_DATE) from voyage where vessel_id=?) and  " + "vessel_id=?";

	public static final String CHECK_CLOSED_VOYAGE = "select count(*) " + "from " + "ACTUAL_VOYAGE_TIME " + "where status='Close' and VOYAGE_NO=?";

	public static final String SELECT_TERMINAL_FOR_PORT = "select   port_code terminalCode   from port_master where PORT_ISO_CODE='AEJEA'";

	public static final String SELECT_MLO_SHORT_NAME = " select vendor_short_name as id ,vendor_short_name as text from  vendor_master where vendor_type like '%VO%' and nullif(vendor_short_name,'') is not null     " ;
			// "select mlo_short_name as id ,mlo_short_name as text from   mlo_master,vendor_master where is_vsl_operator='Y' and mlo_short_name is not null and mlo_short_name=vendor_short_name and mlo_active='Y' ";
			//"select mlo_short_name as id ,mlo_short_name as text from mlo_master where is_vsl_operator='Y' and mlo_short_name is not null union  select vendor_short_name as id,vendor_short_name as text from vendor_master where vendor_type  ='VO' and vendor_short_name is not null";

	public static final String CHECK_CHARTER_HIRE_DATE = " select   count(*)   from VESSEL_APPROVAL_CHRTRHIRE_DTL   where CHARTER_HIRE_CODE = (select max(CHARTER_HIRE_CODE) from VESSEL_APPROVAL_CHRTRHIRE_HDR  where VESSEL_CODE = ?  and vessel_flag=?) and to_date(?,'dd/MM/yyyy') between FROM_DATE::date  and  TO_DATE::date " ; 
			
			//"select   count(*)   from VESSEL_APPROVAL_CHRTRHIRE_DTL   where CHARTER_HIRE_CODE = (select CHARTER_HIRE_CODE from VESSEL_APPROVAL_CHRTRHIRE_HDR  "	+ "where VESSEL_CODE = ? and to_date(?,'dd/MM/yyyy') between FROM_DATE::date  and  TO_DATE::date) "; 

	 
	public static final String  GET_CHARTER_CODE =" select max(charter_hire_code) from vessel_approval_chrtrhire_hdr where vessel_code= ?" ;
	
	public static final String GET_CHARTERhIRE_DATES = " select to_char(laycan_date,'dd/mm/yyyy') as fromDate,case when charter_period_max_type='M' then "+ 
          " (select to_char( laycan_date +interval  '1  months'*charter_period_max_count,'dd/mm/yyyy') from vessel_approval_chrtrhire_hdr where "
          + "charter_hire_code=a.charter_hire_code) when "
          + "  charter_period_max_type='D' then (select to_char( laycan_date  +interval '1 day'*charter_period_max_count,'dd/mm/yyyy') from "
          + " vessel_approval_chrtrhire_hdr where charter_hire_code=a.charter_hire_code) end as toDate from vessel_approval_chrtrhire_hdr a where a.charter_hire_code= ? ";

	public static final String checkCharterDtlDates = " select count(*) as cnt from vessel_approval_chrtrhire_dtl a where a.from_date is null and a.to_date is null and charter_hire_code= ? ";

	
	/*
	 * public static final String CHECK_INSURANCE_PI_DATE =
	 * "select count(*) from INSURANCE_MASTER IM inner join  INSURANCE_TYPE_PI PI on  "
	 * + "im.insurance_master_id=pi.insurance_master_id  where VESSEL_CODE=? " +
	 * "and PI.FROM_DATE  <= to_date(?,'dd/mm/yyyy hh24:mi')   and to_date(?,'dd/mm/yyyy hh24:mi') <= PI.TO_DATE "
	 * ;
	 */

	public static final String CHECK_INSURANCE_CL_DATE = "select count(*) from INSURANCE_MASTER IM inner join  Insurance_type_CL CL on "
			+ "im.insurance_master_id=CL.insurance_master_id  where VESSEL_CODE=? "
			+ "and CL.FROM_DATE  <= to_date(?,'dd/mm/yyyy hh24:mi')   and to_date(?,'dd/mm/yyyy hh24:mi') <= CL.TO_DATE ";
	
	public static String SELECT_CUSTOMER_LIST = "select mlo_CODE as id, (MLO_SHORT_NAME || '-' || MLO_NAME) as text  from mlo_master  ORDER BY MLO_SHORT_NAME ASC";

	public static String SELECT_POL_LIST = "select port_code as id,port_code as text from port_master order by port_code ASC";
	
	public static final String INSERT_VOYAGE_SERVICE_ALLOCATION ="insert into "
			+ "VOYAGE_SERVICE_ALLOCATION "
			+ "(VOYAGE_ID,CUSTOMER_CODE,POL,TOTAL_TUES,WEIGHT,PERCENTAGE,CREATED_BY,ALLOC_TYPE,CREATED_DATE,FROM_DATE,TO_DATE) " 
			+ "VALUES(?,?,?,?,?,?,?,?,now(),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'))";
	
	public static final String SELECT_VOYAGE_SERVICE_ALLOCATION_BY_ID ="select "
			+ "CUSTOMER_CODE customerCode,"
			+ "POL,"
			+ "TOTAL_TUES totalTeus,"
			+ "WEIGHT,"
			+ "PERCENTAGE,"
			+ "to_char(FROM_DATE,'dd/mm/yyyy') vesFromDate,"
			+ "to_char(TO_DATE,'dd/mm/yyyy') vesToDate "
			+ "from "
			+ "VOYAGE_SERVICE_ALLOCATION "
			+ "where "
			+ "voyage_id=? and "
			+ "alloc_type=? ";
	
	public static final String DELETE_VOYAGE_SERVICE_ALLOCATION ="delete "
			+ "from "
			+ "VOYAGE_SERVICE_ALLOCATION "
			+ "where voyage_id=? and alloc_type=?";
	
	public static final String SELECT_JV_PARTNER_LIST="select mlo_CODE as id, (MLO_SHORT_NAME || '-' || MLO_NAME) as text  from mlo_master where SLOT_TYPE='Y' ORDER BY MLO_SHORT_NAME ASC";
	
	public static final String SELECT_VESSEL_ALLOCATION_LIST ="select mlo_code as customerCode,teus totalTeus,weight,percentage,to_char(from_date,'dd/mm/yyyy') vesFromDate,"
			+ "to_char(to_date,'dd/mm/yyyy') vesToDate " 
			+"from service_allocation sa inner join VESSEL_SERVICE_MASTER vm on sa.service_id=vm.service_id " 
			+"and VM.SECTOR_CODE=? and vessel_code=? and alloc_type ='V'"; 
	
	public static final String SELECT_PRIORITY_ALLOCATION_LIST ="select mlo_code as customerCode,POL,teus totalTeus,weight,percentage,to_char(from_date,'dd/mm/yyyy') vesFromDate,"
			+ "to_char(to_date,'dd/mm/yyyy') vesToDate " 
			+"from service_allocation sa inner join VESSEL_SERVICE_MASTER vm on sa.service_id=vm.service_id " 
			+"and VM.SECTOR_CODE=? and vessel_code=? and alloc_type ='C'"; 
	
//	public static final String CHECK_SERVICE_EXIST = "select count(*) from  sector_master s  where  s.sec_company_code=? and s.sector_code=?";
	public static final String CHECK_SERVICE_EXIST = "select count(*) from  sector_master s  where  s.sector_code=?";


	public static final String SELECT_LOCATION_OF_SERVICE ="select location "
			+ "from sector_master s inner join company_master c on "
			+ "s.sec_company_code=c.company_code where s.sector_code=?";
	
	public static final String SELECT_VESSEL_TYPE="select flag from VESSEL_MASTER where VESSEL_CODE=?";
	
	public static final String SELECT_BOOKING_COUNT_FOR_VOYAGE ="select count(*) from BOOKING_REQUEST_DETAIL where BOOK_REQ_ID in " 
			+"(select BOOK_REQ_ID from BOOKING_REQUEST_HEADER where voyage_no = ?)";

	public static final String CALL_UPDATE_PORT_SEQ_FUNCTION = "SELECT UPDATE_PORT_SEQUENCE(?,?,?,?) ";

	public static final String CHECK_VESSEL_CODE = "select count(*) from vessel_master where vessel_code=?";

	public static final String SELECT_ALL_SERVICE = "select sector_code as id,sector_name as text from sector_master where sector_code is not null order by sector_code";
	
	public static final String GET_ALL_VESSEL="select vessel_code as id,vessel_code ||'-'||vessel_name as text from vessel_master v where v.VESSEL_ACTIVE='Y' order by vessel_code ";
	
	public static final String GET_ALL_ACTIVITY_TYPES = "select " + "activity_code as id," + "activity_name as text " + "from "
			+ "activity_master order by activity_name ";

	public static final String CHECK_VESSEL_ACTIVE = "select count(*) from vessel_master where vessel_code=? AND VESSEL_ACTIVE='Y'";

	public static final String CHECK_VESSEL_SERVICE_CODE = " select count(*) from vessel_service_master where sector_code =? and vessel_code=?";

	public static final String GET_VESSEL_LIST_WOT = "select * from (select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed,"
			+ "v.flag flag  "
			+ "from vessel_master v, vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur  where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and "
			+ "sm.sec_company_code = ur.company_code and ur.form_code = ? and ur.user_id = ? and v.FLAG !='T'  "
			+ "  and v.VESSEL_ACTIVE='Y' and v.vessel_name is not null and v.vessel_code is not null "
			+ " union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed, "
			+ "v.flag flag from vessel_master v, vessel_service_master vsm, sector_master sm, "
			+ "VIEW_USER_RIGHTS_FOR_LIST ur  where "
			+ "vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code and "
			+ "sm.sec_company_code = ur.company_code and ur.form_code =  ?  and ur.user_id = ? and upper(v.vessel_code)='BVR' ) t1 order by vessel_code";
	
	public static final String GET_VESSEL_FLAG="SELECT vessel_flag FROM tb_vessels WHERE     vesselcode = ?";
	
	public static final String UPDATE_VESSEL_FLAG=" UPDATE voyage SET vsl_operation_flag = ? WHERE VOYAGE_ID = ?";
	
	public static final String UPDATE_PREV_VOYAGE = "update voyage set pre_voyage =(select pre_voyage from voyage where voyage_id =?) where pre_voyage=?";

	public static final String DELETE_transhipment_req_header = "delete from transhipment_request_header where voyage_no=? and (case when (select count(book_req_id) from transhipment_request_detail where book_req_id = (select book_req_id from transhipment_request_header where voyage_no=?)) = 0 then true else false end)";
	
	public static final String sector_id="select distinct   s.sector_code as id , s.sector_name as text from vessel_master v,sector_master s,vessel_service_master vs,VIEW_USER_RIGHTS_FOR_LIST ur  where    v.vessel_code = vs.vessel_code and vs.sector_code = s.sector_code and s.sec_company_code = ur.company_code order by sector_name asc";

	public static final String check_prev_finalETA = "select case when eta<to_timestamp(?,'dd/mm/yyyy hh24:mi') then true else false end from voyage_port where is_next_voyage = 'N' and voyage_id in(SELECT VOYAGE_ID FROM (select distinct v.VOYAGE_ID,v.created_date from voyage v inner join voyage_port vp on vp.voyage_id=v.VOYAGE_ID  where v.VESSEL_ID =? and v.SECTOR_ID =? order by v.created_date desc) temp  limit 1) order by port_sequence desc limit 1";

	public static final String check_prev_finalETA_upd = "select case when eta<to_timestamp(?,'dd/mm/yyyy hh24:mi') then true else false end from voyage_port where is_next_voyage = 'N' and voyage_id in( select distinct pre_voyage from voyage v where voyage_id= ? )  order by port_sequence desc limit 1";
	
	public static final String Check_project_declaration_count = "select count(*) from vessel_service where vessel_id=? and sector_id=?";
	
}
