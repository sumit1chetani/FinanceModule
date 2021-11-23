package com.dci.operation.voyage.thirdPartyVoyage;


public class ThirdPartyVoyageQueryUtil {

	public static final String GET_VOYAGE_LIST = " select   v.voyage_id as voyageId  from   voyage v   where "
			+ " upper(v.third_party)='T' ";

//	public static final String GET_THIRD_PARTY_VOYAGE_LIST = "select distinct v.voyage_id as voyageId,ve.vesselname as vesselName ,\n" + 
//			"to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate,  to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate, \n" + 
//			"s.sector_name as sectorName,  s.sector_code as sectorId, v.created_date , vesselcode vesselCode, v.vessel_optr as vesselOperator  from \n" + 
//			"voyage v,sector_master s,tb_vessels ve , VIEW_USER_RIGHTS_FOR_LIST ur where v.sector_id = s.sector_code and  v.vessel_id = ve.vesselcode and ur.company_code = s.sec_company_code  and v.created_date is not null and ur.form_code = ? and ur.user_id = ?  ";
	public static final String GET_THIRD_PARTY_VOYAGE_LIST = "select distinct v.voyage_id as voyageId,ve.vesselname as vesselName ,   \r\n" + 
			"			  to_char(v.sch_start_date,'dd/mm/yyyy hh24:mi') as schStartDate,  to_char(v.sch_end_date,'dd/mm/yyyy hh24:mi') as schEndDate,    \r\n" + 
			"			  s.sector_name as sectorName,  s.sector_code as sectorId, v.created_date , vesselcode vesselCode, v.vessel_optr as vesselOperator , (select opr_code from vessel_operator where id = v.vessel_optr::integer limit 1) as vesselOperatorName from    \r\n" + 
			"			  voyage v,sector_master s,tb_vessels ve\r\n" + 
			"			where v.sector_id = s.sector_code and  v.vessel_id = ve.vesselcode ";
			/*"select "
			+ "v.voyage_id as voyageId,ve.vessel_name as vesselName,ac.activity_name activityName, "
			+ "to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate, " + "to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate, "
			+ "s.sector_name as sectorName, " + "s.sector_code as sectorId, " + "vessel_code vesselCode, v.vessel_optr as vesselOperator " + "from "
			+ "voyage v,sector_master s,vessel_master ve , VIEW_USER_RIGHTS_FOR_LIST ur,activity_master ac  " + "where "
			+ "v.sector_id = s.sector_code and " + "v.vessel_id = ve.vessel_code and ur.company_code = s.sec_company_code  and "
			+ "v.activity_code=ac.activity_code and " + " v.third_party = 'T'  and v.created_date is not null and ur.form_code = ? and ur.user_id = ? ";
*/

	public static final String GET_THIRD_PARTY_VOYAGE_LIST_SINGAPORE_OLD = "select "
			+ " v.voyage_id as voyageId,ve.vessel_name as vesselName,ac.activity_name activityName,"
			+ " to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate,  to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate," 
			+ " s.sector_name as sectorName,  s.sector_code as sectorId,  vessel_code vesselCode, v.vessel_optr as vesselOperator  from  "
			+ " voyage v,sector_master s,vessel_master ve ,activity_master ac,VIEW_USER_RIGHTS_FOR_LIST ur inner join employee_master emp on  emp.emp_id = ur.user_id  where "
			+ " v.sector_id = s.sector_code and  v.vessel_id = ve.vessel_code and ve.vessel_code=v.vessel_id and v.company_wise = emp.company_code  and "
			+ " v.activity_code=ac.activity_code and   v.third_party = 'T'  and v.created_date is not null and ur.form_code = ?  and ur.user_id = ?";
	
	public static final String GET_THIRD_PARTY_VOYAGE_LIST_SINGAPORE = "select distinct "
			+ " v.voyage_id as voyageId,ve.vessel_name as vesselName,ac.activity_name activityName,"
			+ " to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate,  to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate," 
			+ " s.sector_name as sectorName,  s.sector_code as sectorId,  vessel_code vesselCode, v.vessel_optr as vesselOperator,v.created_date  from  "
			+ " voyage v,sector_master s,vessel_master ve ,activity_master ac,VIEW_USER_RIGHTS_FOR_LIST ur "
			+ " inner join employee_master emp on  emp.emp_id = ur.user_id  where "
			+ " v.sector_id = s.sector_code and  v.vessel_id = ve.vessel_code and ve.vessel_code=v.vessel_id "
			+ " and v.voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where (v.sector_id in('GALEX') or from_port_id in ('PSA') or to_port_id in  ('PSA')))  and "
			+ " v.activity_code=ac.activity_code and   v.third_party = 'T'  and v.created_date is not null and ur.form_code = ?  and ur.user_id = ?";
	
	public static final String GET_THIRD_PARTY_VOYAGE_LIST_MY = "select "
			+ " v.voyage_id as voyageId,ve.vessel_name as vesselName,ac.activity_name activityName,"
			+ " to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate,  to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate," 
			+ " s.sector_name as sectorName,  s.sector_code as sectorId,  vessel_code vesselCode, v.vessel_optr as vesselOperator  from  "
			+ " voyage v,sector_master s,vessel_master ve ,activity_master ac,VIEW_USER_RIGHTS_FOR_LIST ur "
			+ " inner join employee_master emp on  emp.emp_id = ur.user_id  where "
			+ " v.sector_id = s.sector_code and  v.vessel_id = ve.vessel_code and ve.vessel_code=v.vessel_id "
			+ " and v.voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where (from_port_id in ('MYPKL','MYPKG') or to_port_id in  ('MYPKL','MYPKG')))  and "
			+ " v.activity_code=ac.activity_code and   v.third_party = 'T'  and v.created_date is not null and ur.form_code = ?  and ur.user_id = ?";



	public static final String GET_THIRD_PARTY_VOYAGE_LIST_MALAYSIA = "select "
			+ " v.voyage_id as voyageId,ve.vessel_name as vesselName,ac.activity_name activityName,"
			+ " to_char(v.sch_start_date,'dd/mm/yyyy hh24:mm') as schStartDate,  to_char(v.sch_end_date,'dd/mm/yyyy hh24:mm') as schEndDate," 
			+ " s.sector_name as sectorName,  s.sector_code as sectorId,  vessel_code vesselCode, v.vessel_optr as vesselOperator  from  "
			+ " voyage v,sector_master s,vessel_master ve ,activity_master ac,VIEW_USER_RIGHTS_FOR_LIST ur inner join employee_master emp on  emp.emp_id = ur.user_id  where "
			+ " v.sector_id = s.sector_code and  v.vessel_id = ve.vessel_code and ve.vessel_code=v.vessel_id and v.company_wise = 'C0028'  and "
			+ " v.activity_code=ac.activity_code and   v.third_party = 'T'  and v.created_date is not null and ur.form_code = ?  and ur.user_id = ?";

//	public static final String GET_VESSEL_LIST = "select distinct v.vesselcode as vesselcode ,v.vesselcode || '-' || v.vesselname as vessel_name, v.speed  as vessel_speed from tb_vessels v, vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur  \n" + 
//			"where vsm.vessel_code = v.vesselcode and vsm.sector_code = sm.sector_code \n" + 
//			" and sm.sec_company_code = ur.company_code and ur.form_code = ?  and ur.user_id =? ";

	public static final String GET_VESSEL_LIST = "select distinct v.vesselcode as vesselcode ,v.vesselcode || '-' || v.vesselname as vessel_name, v.speed  as vessel_speed from tb_vessels v";
			/*" select * from ("
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur  where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code "
			+ "and sm.sec_company_code = ur.company_code and ur.form_code = ?  and ur.user_id =? and (v.FLAG='T' OR V.FLAG='O') and v.VESSEL_ACTIVE='Y'  "
			+ "and v.vessel_code not in (select vessel_code from VESSEL_APPROVAL_CHRTRHIRE_HDR where upper(charterer_code) like '%SIMA%') "
			+ "union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur  where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code "
			+ "and sm.sec_company_code = ur.company_code and ur.form_code = ? and ur.user_id =? and v.VESSEL_ACTIVE='Y' "
			+ "and v.vessel_code in (select distinct vessel_id from voyage where upper(third_party) ='T')) as vslList order by vessel_name";
*/
	
	public static final String GET_VESSEL_LIST_SINGAPORE_OLD = " select * from ("
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm,voyage voy,VIEW_USER_RIGHTS_FOR_LIST ur  inner join employee_master emp on  emp.emp_id = ur.user_id where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code  "
			+ "and  voy.company_wise = emp.company_code and ur.form_code = ?  and ur.user_id =? and (v.FLAG='T' OR V.FLAG='O') and v.VESSEL_ACTIVE='Y'  and v.vessel_code=voy.vessel_id  "
			+ "and v.vessel_code not in (select vessel_code from VESSEL_APPROVAL_CHRTRHIRE_HDR where upper(charterer_code) like '%SIMA%') "
			+ "union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm,voyage voy, VIEW_USER_RIGHTS_FOR_LIST ur  inner join employee_master emp on emp.emp_id = ur.user_id where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code  "
			+ "and  voy.company_wise = emp.company_code and ur.form_code = ? and ur.user_id =? and v.VESSEL_ACTIVE='Y' and v.vessel_code=voy.vessel_id  "
			+ "and v.vessel_code in (select distinct vessel_id from voyage where upper(third_party) ='T')) as vslList order by vessel_name";
	
	public static final String GET_VESSEL_LIST_SINGAPORE = " select * from ("
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm,voyage voy,VIEW_USER_RIGHTS_FOR_LIST ur  inner join employee_master emp on  emp.emp_id = ur.user_id where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code  "
			+ "and  voy.voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where (from_port_id in ('PSA') or to_port_id in  ('PSA')))"
			+ " and ur.form_code = ?  and ur.user_id =? and (v.FLAG='T' OR V.FLAG='O') and v.VESSEL_ACTIVE='Y'  and v.vessel_code=voy.vessel_id  "
			+ "and v.vessel_code not in (select vessel_code from VESSEL_APPROVAL_CHRTRHIRE_HDR where upper(charterer_code) like '%SIMA%') "
			+ "union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm,voyage voy, VIEW_USER_RIGHTS_FOR_LIST ur  inner join employee_master emp on emp.emp_id = ur.user_id where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code  "
			+ "and  voy.voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where (from_port_id in ('PSA') or to_port_id in  ('PSA')))"
			+ " and ur.form_code = ? and ur.user_id =? and v.VESSEL_ACTIVE='Y' and v.vessel_code=voy.vessel_id  "
			+ "and v.vessel_code in (select distinct vessel_id from voyage where upper(third_party) ='T')) as vslList order by vessel_name";	
	
	public static final String GET_VESSEL_LIST_MY = " select * from ("
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm,voyage voy,VIEW_USER_RIGHTS_FOR_LIST ur  inner join employee_master emp on  emp.emp_id = ur.user_id where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code  "
			+ "and  voy.voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where (from_port_id in ('MYPKL','MYPKG') or to_port_id in  ('MYPKL','MYPKG')))"
			+ " and ur.form_code = ?  and ur.user_id =? and (v.FLAG='T' OR V.FLAG='O') and v.VESSEL_ACTIVE='Y'  and v.vessel_code=voy.vessel_id  "
			+ "and v.vessel_code not in (select vessel_code from VESSEL_APPROVAL_CHRTRHIRE_HDR where upper(charterer_code) like '%SIMA%') "
			+ "union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm,voyage voy, VIEW_USER_RIGHTS_FOR_LIST ur  inner join employee_master emp on emp.emp_id = ur.user_id where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code  "
			+ "and  voy.voyage_id in (select distinct voy.voyage_id from voyage_port vp join voyage voy on voy.voyage_id=vp.voyage_id where (from_port_id in ('MYPKL','MYPKG') or to_port_id in  ('MYPKL','MYPKG')))"
			+ " and ur.form_code = ? and ur.user_id =? and v.VESSEL_ACTIVE='Y' and v.vessel_code=voy.vessel_id  "
			+ "and v.vessel_code in (select distinct vessel_id from voyage where upper(third_party) ='T')) as vslList order by vessel_name";		

	
	public static final String GET_VESSEL_LIST_MALAYSIA = " select * from ("
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm,voyage voy,VIEW_USER_RIGHTS_FOR_LIST ur  inner join employee_master emp on  emp.emp_id = ur.user_id where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code  "
			+ "and  voy.company_wise = 'C0028' and ur.form_code = ?  and ur.user_id =? and (v.FLAG='T' OR V.FLAG='O') and v.VESSEL_ACTIVE='Y'  and v.vessel_code=voy.vessel_id  "
			+ "and v.vessel_code not in (select vessel_code from VESSEL_APPROVAL_CHRTRHIRE_HDR where upper(charterer_code) like '%SIMA%') "
			+ "union "
			+ "select distinct v.vessel_code as vessel_code ,v.vessel_code || '-' || v.vessel_name as vessel_name, v.vessel_speed  as vessel_speed from vessel_master v,  "
			+ "vessel_service_master vsm, sector_master sm,voyage voy, VIEW_USER_RIGHTS_FOR_LIST ur  inner join employee_master emp on emp.emp_id = ur.user_id where vsm.vessel_code = v.vessel_code and vsm.sector_code = sm.sector_code  "
			+ "and  voy.company_wise = 'C0028' and ur.form_code = ? and ur.user_id =? and v.VESSEL_ACTIVE='Y'  and v.vessel_code=voy.vessel_id "
			+ "and v.vessel_code in (select distinct vessel_id from voyage where upper(third_party) ='T')) as vslList order by vessel_name";

	public static final String GET_ACTIVITY_TYPES = "select " + "activity_code," + "activity_name " + "from "
			+ "activity_master where upper(applicablefor)=upper('Third party') order by activity_name ";

	/*
	 * public static final String GET_SERVICE_LIST ="select " + "s.sector_code,"
	 * + "s.sector_name " + "from " +
	 * "vessel_master v,sector_master s,vessel_sector vs " + "where " +
	 * "v.vessel_code = vs.vessel and " + "vs.sector = s.sector_code and " +
	 * "v.vessel_code = ?";
	 */
	public static final String GET_SERVICE_LIST = "select distinct  s.sector_code, concat( s.sector_code,' - ',s.sector_name) as sector_name from tb_vessels v,sector_master s,vessel_service_master vs ";
			//old 
//	public static final String GET_SERVICE_LIST = "select distinct  s.sector_code, s.sector_name from tb_vessels v,sector_master s,vessel_service_master vs  \n" + 
//			"where v.vesselcode = vs.vessel_code and vs.sector_code = s.sector_code and v.vesselcode = ? ";
	
	
	/*public static final String GET_PORT_LIST = " select " + "sp.PORT_ID," + "sp.TO_PORT," + "sp.SL_NO,"
			+ "(select distance from distance_master where from_port=sp.PORT_ID and to_port=sp.TO_PORT)as distance " + "from " + "SECTOR_PORT sp "
			+ "where " + "SECTOR_ID =? " + "ORDER BY SL_NO";*/

	public static final String GET_SCHEDULE_VOYAGE_DTL = "select " + "vvs.VOYAGE_ID as voyageId," + "vvsd.PORT_CODE as fromPort,"
			+ "to_char(vvsd.ETA,'dd/mm/yyyy hh24:mi') as eta," + "vvsd.PORT_STAY_HOUR as portStayHour," + "vvsd.PORT_STAY_MIN as portStayMin,"
			+ "vvsd.END_PORT as toPort," + "vvsd.port_sequence as portSequence," + "vvsd.DISTANCE as distance," + "vvsd.SPEED as speed,"
			+ "vvsd.STEAMING_HOUR as steamingHour," + "vvsd.STEAMING_MIN as steamingMin," + "vvsd.ROTATION_NO as rotationId " + "from "
			+ "vessel_schedule vs, " + "VSL_VOYAGE_SCHEDULE vvs, " + "VSL_VOYAGE_SCHEDULE_DTL vvsd " + "where "
			+ "vs.vessel_schedule_id = vvs.vessel_schedule_id and " + "vvs.VSL_VOYAGE_SCHEDULE_ID = vvsd.VSL_VOYAGE_SCHEDULE_ID "
			+ "and vs.VESSEL_CODE =? and vs.SERVICE_CODE =? and vvs.approved_by is not null " + " order by vvsd.ETA";

	public static final String CHECK_THIRD_PARTY_VOYAGE = "select " + "count(*) " + "from " + "voyage where voyage_id=? and sector_id=?";

	public static final String GET_DISTANCE = "select " + "distance " + "from " + "distance_master " + "where from_port =? and to_port =?";

	public static final String GET_SPEED_FOR_VESSEL = "select " + "vessel_speed  " + "from " + "vessel_master " + "where " + "vessel_code=?";
	

	
	public static final String INSERT_VOYAGE_HEADER = "insert " + "into voyage " + "(VOYAGE_ID," + "VESSEL_ID," + "SECTOR_ID," + "SCH_START_DATE,"
			+ "SCH_END_DATE," + "ACTIVITY_CODE," + "THIRD_PARTY," + "CREATED_BY," + "CREATED_DATE," + "STATUS," + "COMPANY_WISE,PRE_VOYAGE,"
			+ "vessel_optr," + "Proforma_Port_Cost," + "Chater_Hire_Cost," + "Total_Agency_Cost," + "Misc_Cost," + "Other_Expanses,"
			+ "Proforma_investment," + "FO_RVBUNKER_COST," + "GO_RVBUNKER_COST," + "Reason,charter_liability,awrp,add_comm,ewri,MKTG_FLAG,is_first_voyage,vessel_id_use,vlsfo_rvbunker_cost ,lsmgo_rvbunker_cost)" + "VALUES(?,?,?,"
			+ "to_timestamp(?,'dd/mm/yyyy hh24:mi'),to_timestamp(?,'dd/mm/yyyy hh24:mi')," + "?,?,?,now(),'A',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String INSERT_VOYAGE_PORT_DTL = "insert " + "into voyage_port " + "(VOYAGE_ID," + "PORT_SEQUENCE," + "FROM_PORT_ID," + "ETA,"
			+ "rotation_no, " + "STAY_HRS," + "STAY_MIN," + "STAY_HRS_CON," + "SPEED," + "STEAMING_HOUR," + "STEAMING_MIN," + "STEAMING_CONT_HOUR,"
			+ "TO_PORT_ID,BERTH_HOUR,BERTH_MIN,IS_NEXT_VOYAGE,REMARKS,etb,etd,cutoff)" + "values(?,?,?,to_timestamp(?,'dd/mm/yyyy hh24:mi')," + "?,?,?,?,?,?,?,?,?,?,?,?,?,to_timestamp(?,'dd/mm/yyyy hh24:mi'),to_timestamp(?,'dd/mm/yyyy hh24:mi'),to_timestamp(?,'dd/mm/yyyy hh24:mi'))";

	public static final String EDIT_VOYAGE_HEADER_DTL = "select sch_start_date as schStartDate,v.MKTG_FLAG as companyCode, sch_end_date as schEndDate,vessel_id vesselCode,sector_id as sectorId,  vessel_optr as mloShortName, vo.opr as mloShortName1 ,proforma_port_cost as portCost, chater_hire_cost as hireCost, total_agency_cost as agencyCost, activity_code as activityCode, misc_cost as miscCost, other_expanses as otherExpenses , proforma_investment as proformaInsurance, fo_rvbunker_cost as foBunkerCost, go_rvbunker_cost as gobunkerCost,vlsfo_rvbunker_cost as vlsfobunkerCost, lsmgo_rvbunker_cost as lsmgobunkerCost, reason as reasonId,charter_liability as charterLiability,awrp awrp,add_comm as addComm,ewri,PRE_VOYAGE as voyageNo,is_first_voyage as isFirstVoyage,vessel_id_use as vesselCode1,vm.vesselname as vesselName1 from  voyage v  \n" + 
			"			left join company_master cm on cm.company_code= v.company_wise  \n" + 
			"			left join tb_vessels vm on v.vessel_id_use=vm.vesselcode  \n" + 
			"			left join vendor_master vem on vem.vendor_code=v.vessel_optr \n" + 
			"			left join Vessel_Operator vo on vo.id::int = v.vessel_optr::int\n" + 
			"			where voyage_id=?   ";
			
			
			
			/*"select sch_start_date as schStartDate,v.MKTG_FLAG as companyCode,\n" + 
			"			sch_end_date as schEndDate,vessel_id vesselCode,sector_id as sectorId,  vessel_optr as mloShortName,\n" + 
			"			proforma_port_cost as portCost, chater_hire_cost as hireCost, total_agency_cost as agencyCost,\n" + 
			"			activity_code as activityCode, \n" + 
			"			misc_cost as miscCost, other_expanses as otherExpenses , proforma_investment as proformaInsurance,\n" + 
			"			fo_rvbunker_cost as foBunkerCost, go_rvbunker_cost as gobunkerCost,vlsfo_rvbunker_cost as vlsfobunkerCost, lsmgo_rvbunker_cost as lsmgobunkerCost, reason as reasonId,charter_liability as charterLiability,awrp awrp,add_comm as addComm,ewri,PRE_VOYAGE as voyageNo,is_first_voyage as isFirstVoyage,vessel_id_use as vesselCode1,vm.vessel_name as vesselName1    from  voyage v \n" + 
			"			left join company_master cm on cm.company_code= v.company_wise left join vessel_master vm on v.vessel_id_use=vm.vessel_code where voyage_id=? ";
			*/
			/*"select sch_start_date as schStartDate,v.MKTG_FLAG as companyCode,"
			+ "sch_end_date as schEndDate,vessel_id vesselCode,sector_id as sectorId, " + "vessel_optr as mloShortName,"
			+ "proforma_port_cost as portCost," + "chater_hire_cost as hireCost," + "total_agency_cost as agencyCost,"
			+ "activity_code as activityCode," + "(select activity_name from activity_master where activity_code=v.activity_code) as activityName,"
			+ "misc_cost as miscCost," + "other_expanses as otherExpenses ," + "proforma_investment as proformaInsurance,"
			+ "fo_rvbunker_cost as foBunkerCost," + "go_rvbunker_cost as gobunkerCost,vlsfo_rvbunker_cost as vlsfobunkerCost, lsmgo_rvbunker_cost as lsmgobunkerCost," + "reason as reasonId,charter_liability as charterLiability,awrp awrp,add_comm as addComm,ewri,PRE_VOYAGE as voyageNo,is_first_voyage as isFirstVoyage,vessel_id_use as vesselCode1,vm.vessel_name as vesselName1   " + "from " + "voyage v "
			+ "left join company_master cm on cm.company_code= v.company_wise left join vessel_master vm on v.vessel_id_use=vm.vessel_code where voyage_id=?";
*/
	public static final String GET_THIRD_PARTY_VOYAGE_DTL = "select " + "vp.voyage_id as voyageId, v.vessel_id as vesselCode, remarks as remarks,"
			+ "port_sequence as portSequence, " + "from_port_id as fromPort, "
			+ " (select distinct case when approved_by is not null then 'Y' else 'N' end from loading_summary "
			+ "where voyage_id=vp.voyage_id and POL=VP.FROM_PORT_ID AND cast(port_sequence as int)=vp.port_sequence and approved_by is not null) as loadingFlag, "
			+ "to_char(eta,'dd/mm/yyyy hh24:mi') as eta, " + "stay_hrs as portStayHour, " + "stay_min as portStayMin, "
			+ "stay_hrs_con as portStayContHour,steaming_cont_hour as steamingContHour," + "to_char(etd,'dd/mm/yyyy hh24:mi') as etd,to_char(etb,'dd/mm/yyyy hh24:mi') as etb, to_char(cutoff,'dd/mm/yyyy hh24:mi') as cutoffdt , " + "to_port_id as toPort, "
			+ "(select distance from distance_master where from_port=vp.from_port_id and to_port=vp.to_port_id) as distance," + "speed as speed, "
			+ "rotation_no as rotationId,berth_hour as berthingHour,berth_min as berthingMin,is_next_voyage as nextVoyage "
			+ "from voyage_port vp, voyage v where vp.voyage_id = v.voyage_id and vp.voyage_id=? order by port_sequence ";

	public static final String DELETE_VOYAGE_PORT_DTL = "DELETE " + "FROM " + "VOYAGE_PORT " + "WHERE VOYAGE_ID=?";

	public static final String UPDATE_VOYAGE_HEADER = "update " + "voyage " + "set " + "SCH_START_DATE=to_timestamp(?,'dd/mm/yyyy hh24:mi'),"
			+ "SCH_END_DATE=to_timestamp(?,'dd/mm/yyyy hh24:mi')," + "vessel_optr =?," + "Proforma_Port_Cost=?," + "Chater_Hire_Cost=?,"
			+ "Total_Agency_Cost=?," + "Misc_Cost=?," + "Other_Expanses=?," + "Proforma_investment=?," + "FO_RVBUNKER_COST=?,"
			+ "GO_RVBUNKER_COST=?," + "Reason=?,charter_liability=?,awrp=?,add_comm=?,ewri=?,voyage_id=?,PRE_VOYAGE=?,is_first_voyage=?,vlsfo_rvbunker_cost=?,lsmgo_rvbunker_cost=? " + "where voyage_id=?";

	public static final String DELETE_THIRD_PARTY_VOYAGE = "delete " + "from " + "voyage " + "where " + "voyage_id=?";

//	public static final String SELECT_MLO_SHORT_NAME = "select vendor_code as id ,coalesce(vendor_shrt_name || '-' ||  vendor_name) as text from vendor_master " ;
	public static final String SELECT_MLO_SHORT_NAME = "select id as id ,coalesce(opr_code || '-' ||  opr) as text from Vessel_Operator  ";
			// select m.mlo_short_name as id ,coalesce(m.mlo_short_name || '-' || vm.vendor_name,m.mlo_short_name) as text from mlo_master m inner join vendor_master vm on m.mlo_short_name=vm.vendor_short_name where is_vsl_operator='Y' and mlo_short_name is not null and  mlo_code not in ('BA1000')";
	/*	"	select mlo_short_name as id ,coalesce(mlo_short_name || '-' || mlo_name)  as text from mlo_master where is_vsl_operator='Y' and mlo_short_name is not null  "+
		"	 union "+ 
		"	 select vendor_short_name as id,coalesce(vendor_short_name || '-' ||  vendor_name )  as text from vendor_master where vendor_type  ='VO' and vendor_short_name is not null ";
*/
	public static final String GET_PRE_VOYAGE = "SELECT VOYAGE_ID FROM (select VOYAGE_ID from voyage  where VESSEL_ID =? and SECTOR_ID =? order by created_date desc) as temp limit 1";

	public static final String GET_BOOKING_REQUEST_COUNT = "SELECT count(book_req_id) from booking_request_header where voyage_no=?";
	
	public static final String SELECT_BOOKING_COUNT_FOR_VOYAGE ="select count(*) from BOOKING_REQUEST_DETAIL where BOOK_REQ_ID in " 
			+"(select BOOK_REQ_ID from BOOKING_REQUEST_HEADER where voyage_no = ?)";
	
	public static final String SELECT_PORT_MASTER="select PORTCODE fromPort from PORT_MASTER where isactive ='Y' and PORTCODE is not null order by PORTCODE";

	public static final String CHECK_VOYAGE_CREATION_DATE = "select count(*) from voyage where created_date::timestamp  >= to_timestamp('15/07/2016 14:00','dd/MM/yyyy hh24:mi') and voyage_id=? ";
	
	public static final String CHECK_PURCHASE_QUOT = "select count(*) from purchase_quotation_port_pair pqr inner join  purchase_quotation pq on "
			+ "pqr.quotation_no=pq.quotation_no "
			+ "inner join vendor_master vm on pq.vendor_id=vm.vendor_code where get_port_iso(pol)=get_port_iso(?)  "
			+ "and get_port_iso(pod)=get_port_iso(?) and vm.vendor_short_name=? and to_date(?,'dd/MM/yyyy') between valid_from::date and valid_till::date";

	public static final String SELECT_COMPANY_OF_SERVICE ="select SEC_COMPANY_CODE "
			+ "from sector_master where sector_code=?";

	public static final String CHECK_SAME_PORTS_ISO = "select count(*) where get_port_iso(?)=get_port_iso(?)";

	public static final String GET_PORT_LIST = " select sp.PORT_ID,sp.TO_PORT,sp.SL_NO,berth_hour,berth_min,port_stay_hour,port_stay_min, case when distance > 0 then  distance  else (select distance from distance_master where from_port=sp.PORT_ID and to_port=sp.TO_PORT)  end as distance,speed from SECTOR_PORT sp "
			+ "where " + "SECTOR_ID =? " + "ORDER BY SL_NO";
	
//	public static final String SELECT_MLO_SHORT_NAME_union ="select vessel_optr as id ,vendor_shrt_name || '-' ||  vendor_name  as text  from voyage voy inner join vendor_master \n" + 
//			"							on vendor_master.vendor_code=voy.vessel_optr  where voyage_id = ? ";

	public static final String SELECT_MLO_SHORT_NAME_union ="select id as id ,coalesce(opr_code || '-' ||  opr)    as text  from voyage voy inner join Vessel_Operator 							on Vessel_Operator.id=voy.vessel_optr::int  where voyage_id = ? ";
			
			/*"select vendor_short_name as id ,coalesce(vendor_short_name || '-' ||  vendor_name) as text from vendor_master  where vendor_type like '%VO%'  and nullif(vendor_short_name,'') is not null and vendor_code not in ('V00622','V00400') "
			+ "				union "
			+ "select vessel_optr as id ,case when vendor_short_name is null or vendor_short_name='' then   coalesce(vendor_short_name || '-' ||  vendor_name)   else vessel_optr end as text  from voyage voy inner join vendor_master "
			+ "				on vendor_master.vendor_short_name=voy.vessel_optr  where voyage_id = ?";*/
			
			
			/*"select m.mlo_short_name as id ,coalesce(m.mlo_short_name || '-' || vm.vendor_name,m.mlo_short_name) as text from mlo_master m left join vendor_master vm " 
				+" on m.mlo_short_name=vm.vendor_short_name where is_vsl_operator='Y' and mlo_short_name is not null and  mlo_code not in ('BA1000') "
				+" union "
				+" select m.mlo_short_name as id ,coalesce(m.mlo_short_name || '-' || vm.vendor_name,m.mlo_short_name) as text from mlo_master m left join vendor_master vm "  
				+" on m.mlo_short_name=vm.vendor_short_name left join voyage voy "
				+" on m.mlo_short_name=voy.vessel_optr where is_vsl_operator='Y' and mlo_short_name is not null  and voyage_id = ?";*/
	
	public static final String GET_VESSEL_LIST_WOOWN = "select distinct v.vesselcode as vessel_code ,v.vesselcode || '-' || v.vesselname as vessel_name, v.speed  as vessel_speed from tb_vessels v";
			
//			"select distinct v.vesselcode as vessel_code ,v.vesselcode || '-' || v.vesselname as vessel_name, v.speed  as vessel_speed from tb_vessels v,  \n" + 
//			"vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur  where vsm.vessel_code = v.vesselcode and vsm.sector_code = sm.sector_code \n" + 
//			"and sm.sec_company_code = ur.company_code and ur.form_code =?  and ur.user_id =?  ";
	
	public static final String GET_VESSEL_LIST_WOOWN1 = " select distinct v.vesselcode as vessel_code ,v.vesselcode || '-' || v.vesselname as vessel_name, v.speed  as vessel_speed from tb_vessels v,  \n" + 
			"vessel_service_master vsm, sector_master sm, VIEW_USER_RIGHTS_FOR_LIST ur  where vsm.vessel_code = v.vesselcode and vsm.sector_code = sm.sector_code \n" + 
			"and sm.sec_company_code = ur.company_code and ur.form_code =?  and ur.user_id =?  ";
	
	public static final String GET_THIRD_PARTY_VOYAGE_DTL_FOR_COPY = "select " + "vp.voyage_id as voyageId, v.vessel_id as vesselCode, " + "port_sequence as portSequence, remarks as remarks,"
			+ "from_port_id as fromPort, " + " (select distinct case when approved_by is not null then ' ' else 'N' end from loading_summary "
			+ "where voyage_id=vp.voyage_id and POL=VP.FROM_PORT_ID AND cast(port_sequence as int)=vp.port_sequence and approved_by is not null) as loadingFlag, "
			+ "to_char(eta,'dd/mm/yyyy hh24:mi') as eta, " + "stay_hrs as portStayHour, " + "stay_min as portStayMin, "
			+ "stay_hrs_con as portStayContHour,steaming_cont_hour as steamingContHour," + "to_char(etd,'dd/mm/yyyy hh24:mi') as etd,to_char(etb,'dd/mm/yyyy hh24:mi') as etb, to_char(cutoff,'dd/mm/yyyy hh24:mi') as cutoffdt , " + "to_port_id as toPort, "
			+ "(select distance from distance_master where from_port=vp.from_port_id and to_port=vp.to_port_id) as distance," + "speed as speed, "
			+ "rotation_no as rotationId,berth_hour as berthingHour,berth_min as berthingMin,is_next_voyage as nextVoyage "
			+ "from voyage_port vp, voyage v where vp.voyage_id = v.voyage_id and vp.voyage_id=? order by port_sequence ";

	public static final String DELETE_transhipment_req_header = "delete from transhipment_request_header where voyage_no=? and (case when (select count(book_req_id) from transhipment_request_detail where book_req_id = (select book_req_id from transhipment_request_header where voyage_no=?)) = 0 then true else false end)";

	public static final String EXPORT_LIST = "\n" + 
			"select    vp.voyage_id as voyageId, v.vessel_id as vesselCode, (select vesselName from tb_vessels where vesselcode = v.vessel_id) vesselCode , remarks as remarks, \n" + 
			"			 port_sequence as portSequence,    from_port_id as fromPort,  \n" + 
			"			  (select distinct case when approved_by is not null then 'Y' else 'N' end from loading_summary  \n" + 
			"			 where voyage_id=vp.voyage_id and POL=VP.FROM_PORT_ID AND cast(port_sequence as int)=vp.port_sequence and approved_by is not null) as loadingFlag,  \n" + 
			"			 to_char(eta,'dd/mm/yyyy hh24:mi') as eta,    stay_hrs as portStayHour,    stay_min as portStayMin,\n" + 
			
			"		 to_char(etb,'dd/mm/yyyy hh24:mi')  as etb,\n" + 
			"			  to_char(etd,'dd/mm/yyyy hh24:mi')  as etd," + 
			"			 stay_hrs_con as portStayContHour,steaming_cont_hour as steamingContHour,    to_port_id as toPort,  \n" + 
			"			 (select distance from distance_master where from_port=vp.from_port_id and to_port=vp.to_port_id) as distance,   speed as speed,  \n" + 
			"			 rotation_no as rotationId,berth_hour as berthingHour,berth_min as berthingMin,is_next_voyage as nextVoyage  \n" + 
			"			 from voyage_port vp, voyage v where vp.voyage_id = v.voyage_id  ";

	public static final String EXPORT_LIST1 = "\n" + 
			"select    vp.voyage_id as voyageId, v.vessel_id as vesselCode, remarks as remarks, \n" + 
			"			 port_sequence as portSequence,    from_port_id as fromPort,  \n" + 
			"			  (select distinct case when approved_by is not null then 'Y' else 'N' end from loading_summary  \n" + 
			"			 where voyage_id=vp.voyage_id and POL=VP.FROM_PORT_ID AND cast(port_sequence as int)=vp.port_sequence and approved_by is not null) as loadingFlag,  \n" + 
			"			 to_char(eta,'dd/mm/yyyy hh24:mi') as eta,    stay_hrs as portStayHour,    stay_min as portStayMin,\n" + 
			
			"		 to_char(etb,'dd/mm/yyyy hh24:mi')  as etb,\n" + 
			"			   to_char(etd,'dd/mm/yyyy hh24:mi')  as etd," + 
			"			 stay_hrs_con as portStayContHour,steaming_cont_hour as steamingContHour,    to_port_id as toPort,  \n" + 
			"			 (select distance from distance_master where from_port=vp.from_port_id and to_port=vp.to_port_id) as distance,   speed as speed,  \n" + 
			"			 rotation_no as rotationId,berth_hour as berthingHour,berth_min as berthingMin,is_next_voyage as nextVoyage  \n" + 
			"			 from voyage_port vp, voyage v where vp.voyage_id = v.voyage_id AND v.vessel_id = ?  order by v.vessel_id";

	public static final String EXPORT_LIST2 = "\n" + 
			"select    vp.voyage_id as voyageId, v.vessel_id as vesselCode, remarks as remarks, \n" + 
			"			 port_sequence as portSequence,    from_port_id as fromPort,  \n" + 
			"			  (select distinct case when approved_by is not null then 'Y' else 'N' end from loading_summary  \n" + 
			"			 where voyage_id=vp.voyage_id and POL=VP.FROM_PORT_ID AND cast(port_sequence as int)=vp.port_sequence and approved_by is not null) as loadingFlag,  \n" + 
			"			 to_char(eta,'dd/mm/yyyy hh24:mi') as eta,    stay_hrs as portStayHour,    stay_min as portStayMin,\n" + 
			
			"		 to_char(etb,'dd/mm/yyyy hh24:mi') as etb,\n" + 
			"			   to_char(etd,'dd/mm/yyyy hh24:mi')  as etd," + 
			"			 stay_hrs_con as portStayContHour,steaming_cont_hour as steamingContHour,    to_port_id as toPort,  \n" + 
			"			 (select distance from distance_master where from_port=vp.from_port_id and to_port=vp.to_port_id) as distance,   speed as speed,  \n" + 
			"			 rotation_no as rotationId,berth_hour as berthingHour,berth_min as berthingMin,is_next_voyage as nextVoyage  \n" + 
			"			 from voyage_port vp, voyage v ";

	public static final String GET_VESSEL_COUNT = "select count(*) from voyage where vessel_id = ? ";
	public static final String GET_VOYAGE_COUNT = "select count(*) from voyage_port where voyage_id = ? ";
	public static String GET_PORTLIST(String service) {
	String GET_PORTLIST = "select sector_id as sectorId ,port_id as fromPort,to_port as toPort from sector_port   where sector_id = ('"+service+"')";
		
		return GET_PORTLIST;
		
	}
	
	public static String GET_Findshed_LIST(String pol, String pod, String fpod) {
		if(pol==null || pol.equals("null"))
			pol="";
		
		if (pod==null || pod.equals("null"))
			pod="";
		
		if (fpod==null || fpod.equals("null"))
			fpod="";
	
		String str1 = "select * from vw_get_findshed('"+pol+"','"+pod+"','"+fpod+"')";
		
		return str1;
		
	}
	
	public static final String GET_VESSELCode_COUNT = "select count(*) from tb_vessels  where vesselcode  = ? ";
	
	public static final String GET_serviceCode_COUNT = "select count(*) from sector_master where sector_code  = ?  ";

	public static final String GET_serviceName_COUNT = "select count(*) from sector_master where sector_name  = ?  ";
	
	public static final String GET_PORT_COUNT = " select count(*) from sector_port where sector_id = ? and port_id = ? ";
	
	public static final String GET_VESSEL_OPR = " select count(*) from vessel_operator  where opr_code  = ? ";


	public static final String GET_PORT_COUNT1 = " select count(*) from port_master where portcode  = ? ";

}
