package com.dci.tenant.finance.reports.customeranalysis;


public class CustomerAnalysisQueryUtil {
	public static String MLO_MASTER= "SELECT mlo_code  , MLO_SHORT_NAME ||'-'||MLO_NAME as text, MLO_SHORT_NAME as id FROM MLO_MASTER WHERE MLO_OR_PAYER = 'MLO' ORDER BY MLO_SHORT_NAME";
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
	//public static final String GET_CUSTOMER_ANALYSIS_REPORT_LIST = "select * from vw_customer_analysis2016(?,?)  limit 30 ";
	
	public static final String GET_CUSTOMER_ANALYSIS_REPORT_LIST = "select * from vw_customer_analysis2016(?,?,?,?,?,?) order by ? limit ?";

	public static final String weeks = "select cast(to_char(w_start_date::timestamp::date,'dd/mm/yyyy') as varchar) fromDate,cast(to_char(w_end_date::timestamp::date,'dd/mm/yyyy') as varchar) toDate from WEEK_DATE where week_no=? and fin_year_id=?";
	
	public static final String GET_WEEKS = "     Select to_char(TRUNC(TO_DATE(?, 'DD/MM/YYYY')+1, 'IW')-1,'DD/MM/YYYY') fromDate,"
			+ " to_char(NEXT_DAY(TRUNC(TO_DATE(?, 'DD/MM/YYYY')+1,'IW'),'SATURDAY'),'DD/MM/YYYY') toDate,to_char( to_date(?,'DD/MM/YYYY')+1, 'IW' ) as week from dual";

	public static final String GET_VOYAGE_COMPLETION_LIST = "select v.voyage_id as voyage,vs.vessel_name as vesselName,v.sector_id as sectorName,v.company_wise as companyCode,to_char(vah1.VESSEL_ARRIVED_HARBOUR,'DD/MM/YYYY' )  as voyageCommenceDt,"
			+ "to_char(vah2.VESSEL_ARRIVED_HARBOUR,'DD/MM/YYYY' ) AS voyageCompletionDt,"
			+ "case when (select count(*) from ACTUAL_VOYAGE_TIME where voyage_no=v.VOYAGE_ID)=1 then 'Completed' when  (select count(next_voyage) from   VIEW_PREV_NEXT_VOYAGE where voyage_id=v.VOYAGE_ID and next_voyage is not null)=1  then 'Completed' else 'Incomplete' end as voyageStatus "
			+ " from voyage v join vessel_master vs  on v.vessel_id=vs.vessel_code join vessel_arrival_hdr vah1 on v.VOYAGE_ID = vah1.VOYAGE_ID and PORT_SEQUENCE='1' "
			+ " join vessel_arrival_hdr vah2 on v.VOYAGE_ID = vah2.VOYAGE_ID and vah2.PORT_SEQUENCE=( "
			+ " select max(PORT_SEQUENCE) from vessel_arrival_hdr   where VOYAGE_ID = v.VOYAGE_ID  ) and  ";

	
	public static final String GET_LOADAGENT_DATA=  "select  sum(janteus) janteus ,sum(febteus) febteus, "
+ "sum(marteus) marteus,sum(aprteus) aprteus,sum(mayteus) mayteus,sum(junteus) junteus,sum(julteus) julteus, "
+ "sum(augteus) augteus,sum(septeus) septeus, "
+ "sum(octteus) octteus,sum(novteus) novteus,sum(decteus) decteus, "
+ "sum(janteus+febteus+marteus+aprteus+mayteus+junteus+julteus+augteus+septeus+octteus+novteus+decteus) as grandtotal, "
+ "(sum(janteus+febteus+marteus+aprteus+mayteus+junteus+julteus+augteus+septeus+octteus+novteus+decteus)/max(currentmonth)) "
+ " as avg,sector,mloshortname customer,pol,pod,coalesce(rated20,0) rated20,coalesce(rated40,0) rated40,coalesce(ratem20,0) ratem20,coalesce(ratem40,0) ratem40,"
+ "coalesce(rater20,0) rater20 ,coalesce(rater40,0)  rater40,sum(coalesce(total,0))  amount,sum(coalesce(amttotal,0)) amountusd "
+ " from RATES_AGAINST_LOADING_AVGS where year=?";
	
	
	public static final String GET_LOADAGENT_JV_DATA=  	" select pol,pod,mlo,get_company(mlo) as mloname,sum(ssf_d20) l_ssf_d20,sum(ssf_d40) l_ssf_d40,sum(ssf_d45) l_ssf_d45, sum(ssf_m20) l_ssf_m20,sum(ssf_m40) l_ssf_m40,sum(ssf_m45) l_ssf_m45,sum(xcl_d20) l_xcl_d20,sum(xcl_d40) l_xcl_d40,sum(xcl_d45) l_xcl_d45,sum(xcl_m20) l_xcl_m20,sum(xcl_m40) l_xcl_m40,sum(xcl_m45) l_xcl_m45,"+
     " sum(oel_d20) l_oel_d20,sum(oel_d40) l_oel_d40, sum(oel_d45) l_oel_d45,"+
     " sum(oel_m20) l_oel_m20,sum(oel_m40) l_oel_m40, sum(oel_m45) l_oel_m45,sum(total_teus) total_teus , qm20rate,qm40rate,qm45rate,qd20rate,qd40rate,qd45rate ,  j_maxi_d20,j_maxi_d40,j_maxi_m20,j_maxi_m40, j_nyk_d20,j_nyk_d40,j_nyk_m20,j_nyk_m40,j_oel_d20,  j_oel_d40,j_oel_m20,j_oel_m40, j_oss_d20,j_oss_d40,j_oss_m20,j_oss_m40,"
     + " j_sci_d20,j_sci_d40,j_sci_m20,j_sci_m40, j_ssf_d20,j_ssf_d40,j_ssf_m20,j_ssf_m40,j_star_d20,j_star_d40,j_star_m20,j_star_m40,j_xcl_d20,j_xcl_d40,j_xcl_m20,j_xcl_m40   from  fn_rate_jv_against_loading(?) where  to_char(sailing_dt,'YYYY')::int =?" ;

      
}
