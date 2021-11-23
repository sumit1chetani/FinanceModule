package com.dci.tenant.finance.reports.sailings;

public class SailingsReportQueryUtil {
	public static final String GET_COMPANY_LIST = "select company_code as id, company_name as company ,location as text from company_master order by location";
	// public static final String GET_SAILING_REPORT_LIST =
	// " select * from (SELECT distinct LOADING.COMPANY_CODE as
	// companyCode,to_char( LOADING.SAILING_DT+1, 'IW' ) as
	// week,LOADING.VOYAGE_ID as voyage,"
	// +
	// " LOADING.POL as pol, to_char(LOADING.SAILING_DT,'DD/MM/YYYY' )as
	// sailingDate, LOADING.POD as pod, LOADING.SECTOR_NAME as sectorName,
	// LOADING.THIRD_PARTY as thirdPartyOrSsf,"
	// +
	// " LOADING.ACTIVITY_NAME as activityType, LOADING.VESSEL_OPERATOR as
	// vesselOperator "
	// + " FROM VIEW_SAILINGS LOADING where ";
	public static final String GET_SAILING_REPORT_LIST = "SELECT distinct LOADING.COMPANY_CODE as companyCode,get_week_no(LOADING.SAILING_DT::date) as week, "
			+ "LOADING.VOYAGE_ID as voyage, LOADING.POL as pol, to_char(LOADING.SAILING_DT,'DD/MM/YYYY' )as sailingDate, "
			+ "LOADING.POD as pod, LOADING.SECTOR_NAME as sectorName, LOADING.THIRD_PARTY as thirdPartyOrSsf, "
			+ "LOADING.ACTIVITY_NAME as activityType,LOADING.VESSEL_OPERATOR as vesselOperator FROM   VIEW_SAILINGS LOADING where ";

	public static final String weeks = "select cast(to_char(w_start_date::timestamp::date,'dd/mm/yyyy') as varchar) fromDate,cast(to_char(w_end_date::timestamp::date,'dd/mm/yyyy') as varchar) toDate from WEEK_DATE where week_no=? and fin_year_id=?";
	
	public static final String GET_WEEKS = "     Select to_char(TRUNC(TO_DATE(?, 'DD/MM/YYYY')+1, 'IW')-1,'DD/MM/YYYY') fromDate,"
			+ " to_char(NEXT_DAY(TRUNC(TO_DATE(?, 'DD/MM/YYYY')+1,'IW'),'SATURDAY'),'DD/MM/YYYY') toDate,to_char( to_date(?,'DD/MM/YYYY')+1, 'IW' ) as week from dual";

	public static final String GET_VOYAGE_COMPLETION_LIST_OLD = "select v.voyage_id as voyage,vs.vessel_name as vesselName,v.sector_id as sectorName,v.company_wise as companyCode,to_char(vah1.VESSEL_ARRIVED_HARBOUR,'DD/MM/YYYY' )  as voyageCommenceDt,"
			+ "to_char(vah2.VESSEL_ARRIVED_HARBOUR,'DD/MM/YYYY' ) AS voyageCompletionDt,"
			+ "case when (select count(*) from ACTUAL_VOYAGE_TIME where voyage_no=v.VOYAGE_ID)=1 then 'Completed' when  (select count(next_voyage) from   VIEW_PREV_NEXT_VOYAGE where voyage_id=v.VOYAGE_ID and next_voyage is not null)=1  then 'Completed' else 'Incomplete' end as voyageStatus "
			+ " from voyage v join vessel_master vs  on v.vessel_id=vs.vessel_code join vessel_arrival_hdr vah1 on v.VOYAGE_ID = vah1.VOYAGE_ID and PORT_SEQUENCE='1' "
			+ " join vessel_arrival_hdr vah2 on v.VOYAGE_ID = vah2.VOYAGE_ID and vah2.PORT_SEQUENCE=( "
			+ " select max(PORT_SEQUENCE) from vessel_arrival_hdr   where VOYAGE_ID = v.VOYAGE_ID  ) and  ";
	
	public static final String GET_VOYAGE_COMPLETION_LIST = " select v.voyage_id as voyage,vs.vessel_name as vesselName,v.sector_id as sectorName,v.company_wise as companyCode,to_char(vah1.commence_date,'DD/MM/YYYY' )  as voyageCommenceDt,"
			+" to_char(vah1.completion_date,'DD/MM/YYYY' ) AS voyageCompletionDt,"
			+" case when (select count(*) from ACTUAL_VOYAGE_TIME where voyage_no=v.VOYAGE_ID)=1 then 'Completed' " 
			+" when  (select count(next_voyage) from "   
			+" VIEW_PREV_NEXT_VOYAGE where voyage_id=v.VOYAGE_ID and next_voyage is not null)=1 " 
			+" then 'Completed' else 'Incomplete' end as voyageStatus " 
			+" from voyage v join vessel_master vs  on v.vessel_id=vs.vessel_code " 
			+" join view_voy_commence_comple_dt vah1 on v.VOYAGE_ID = vah1.VOYAGE_ID  and ";

}
