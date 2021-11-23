package com.dci.tenant.finance.reports.csr;

public class CsrReportsQueryUtil {
	public static final String SELECT_VOL_BY_COMPANY_ID_SLOT_AC = " SELECT SUM(NO_OF_TEUS) as total, EXTRACT(Year from sailing_dt) as year  FROM  loading_summary ls inner join voyage v on v.VOYAGE_ID=ls.VOYAGE_ID "
			+" WHERE  v.COMPANY_WISE='C0001'  AND ( GET_COMPANY(slot_code)='SFPL' OR  GET_COMPANY(slot_code)='IWS')  GROUP BY EXTRACT(Year from sailing_dt) ORDER BY year";
	
	public static final String SELECT_IWS_BY_COMPANY_ID_SLOT_AC = "SELECT SUM(NO_OF_TEUS) as total, "
			+ " EXTRACT(Year from sailing_dt) as year,GET_COMPANY(slot_code) as slotAc  FROM loading_summary ls inner join voyage v on v.VOYAGE_ID=ls.VOYAGE_ID "
			+ "      WHERE  v.COMPANY_WISE='C0001'  AND ( GET_COMPANY(slot_code)='SFPL' OR  GET_COMPANY(slot_code)='IWS') "
			+ "      AND EXTRACT(Year from sailing_dt)=(SELECT max(EXTRACT(Year from sailing_dt)) FROM loading_summary ls inner join voyage v on v.VOYAGE_ID=ls.VOYAGE_ID "
			+ "      WHERE v.COMPANY_WISE='C0001' AND ( GET_COMPANY(slot_code)='SFPL' OR  GET_COMPANY(slot_code)='IWS') ) GROUP BY slot_code,EXTRACT(Year from sailing_dt) ORDER BY YEAR";
	
	public static final String SELECT_SSF_TS_MOVES = "SELECT SUM(totalEmptyMoves+totalLatentMoves)AS total ,YEAR FROM(SELECT SUM(M20+ M40 +M45)as totalEmptyMoves,SUM(D20+R20+R40+OOG20+D40+D45+R40+OOG40+RI20+RI40+FLEXI_20+FLEXI_40) as totalLatentMoves, "
			+ "EXTRACT (YEAR FROM SAILING_DT)AS YEAR FROM LOADING_SUMMARY WHERE BOOK_DTL_ID IN "
			+ "(SELECT BOOK_DTL_ID FROM BOOKING_REQUEST_DETAIL WHERE STACK='VERESK' AND SLOT='BA1000')GROUP BY EXTRACT(YEAR FROM SAILING_DT))as temp GROUP BY YEAR order by YEAR";
	
	public static final String SELECT_TOP_TEN_NVO = "select * from "
			+ "(select sum(NO_OF_TEUS) as value,MLO_SHORT_NAME as nvo,to_char(sum(total_weight),'99,99,99,999.999') as weight,to_char(sum(total_weight)/case when sum(NO_OF_TEUS)=0 then 1 else sum(NO_OF_TEUS) end,'99,99,99,999.999') as avg from loading_summary inner join MLO_MASTER on "
			+ "loading_summary.mlo=MLO_MASTER.MLO_CODE "
			+ "where EXTRACT(Year from sailing_dt)=? and (IS_VSL_OPERATOR<>'Y' or IS_VSL_OPERATOR is null) "
			+ "group by MLO_SHORT_NAME order by value desc)t "
			+ "limit 10";
	
	public static final String SELECT_TOP_TEN_MLO = "select * from "
			+ "(select sum(NO_OF_TEUS) as value,MLO_SHORT_NAME as mlo,to_char(sum(total_weight),'99,99,99,999.999') as weight,to_char(sum(total_weight)/case when sum(NO_OF_TEUS)=0 then 1 else sum(NO_OF_TEUS) end,'99,99,99,999.999') as avg from loading_summary inner join MLO_MASTER on "
			+ "loading_summary.mlo=MLO_MASTER.MLO_CODE "
			+ "where EXTRACT(Year from sailing_dt)=? group by MLO_SHORT_NAME order by value desc)t "
			+ "limit 10";
	
	public static final String SELECT_IAL_SSF_VOL_BY_COMPANY_ID_SLOT_AC = "SELECT SUM(NO_OF_TEUS) as total, cast(EXTRACT(Year from sailing_dt) as varchar)as year  FROM  loading_summary ls inner join voyage v on v.VOYAGE_ID=ls.VOYAGE_ID " 
			 +"WHERE  v.COMPANY_WISE='C0001' AND GET_COMPANY(slot_code)='SFPL' AND GET_COMPANY(MLO)='IAL'  GROUP BY EXTRACT(Year from sailing_dt) ORDER BY YEAR";
	
	public static final String SELECT_IAL_XCL_VOL_BY_COMPANY_ID_SLOT_AC = "SELECT SUM(NO_OF_TEUS) as total, cast(EXTRACT(Year from sailing_dt) as varchar)as year  FROM  loading_summary ls inner join voyage v on v.VOYAGE_ID=ls.VOYAGE_ID "
+ "WHERE  v.COMPANY_WISE='C0001' AND GET_COMPANY(slot_code)='XCL' AND GET_COMPANY(MLO)='IAL'  GROUP BY EXTRACT(Year from sailing_dt) ORDER BY YEAR";
	
	public static final String SELECT_TOP_FIFTEEN_SSF = "SELECT * FROM ( "
			+ "  SELECT  GET_COMPANY(mlo) as sfpl, SUM(NO_OF_TEUS) as value  FROM  loading_summary ttg "
			+ "  INNER JOIN  MLO_MASTER mm  ON  ttg.mlo=mm.MLO_CODE  WHERE EXTRACT(Year from sailing_dt)=? AND GET_COMPANY(ttg.slot_code)='SFPL' "
			+ "  GROUP BY mlo  ORDER BY value DESC) as temp limit 15";
	
	public static final String SELECT_TOP_FIFTEEN_XCL = "SELECT  * FROM ( "
			+ " SELECT GET_COMPANY(mlo) as xcl,  SUM(NO_OF_TEUS) as value FROM  loading_summary ttg  INNER JOIN mlo_master mm "
			+ " ON ttg.mlo=mm.MLO_CODE WHERE EXTRACT(Year from sailing_dt)=? "
			+ " AND GET_COMPANY(ttg.slot_code)='XCL' "
			+ " GROUP BY mlo ORDER BY  value DESC) as temp limit 15";
	
	public static final String SELECT_TOP_FIFTEEN_OEL = "SELECT * FROM ( "
			+ " SELECT GET_COMPANY(mlo) as oel, SUM(NO_OF_TEUS) as value  FROM loading_summary ttg "
			+ " INNER JOIN  mlo_master mm ON ttg.mlo=mm.MLO_CODE WHERE EXTRACT(Year from sailing_dt)=? "
			+ " AND GET_COMPANY(ttg.slot_code)='OEL' "
			+ " GROUP BY mlo ORDER BY value DESC) as temp limit 15";
	
	public static final String GET_TRANSASIA_VOL_OEL="select * from ( "
			+ "       SELECT SUM(NO_OF_TEUS) as value, EXTRACT(Year from sailing_dt) as year  FROM  loading_summary ls inner join voyage v on v.VOYAGE_ID=ls.VOYAGE_ID "
			+ "        WHERE  v.COMPANY_WISE='C0001' AND GET_COMPANY(slot_code)='OEL' AND  MLO=? GROUP BY  EXTRACT(Year from sailing_dt) ORDER BY YEAR desc "
			+ "       ) as temp order by year limit 6 ";
	
	public static final String GET_TRANSASIA_VOL_SSF="select * from ( "
			+ "	SELECT  SUM(NO_OF_TEUS) as value, EXTRACT(Year from sailing_dt) as year FROM	 loading_summary ls inner join voyage v on v.VOYAGE_ID=ls.VOYAGE_ID "
			+ "	WHERE  v.COMPANY_WISE='C0001' AND GET_COMPANY(slot_code)='SFPL' AND MLO=? GROUP BY  EXTRACT(Year from sailing_dt) ORDER BY YEAR desc "
			+ "  ) as temp order by year limit 6 ";
	
	public static final String SELECT_AVG_POL_JAL = "SELECT "
			+ "    pol, "
			+ "    pod, "
			+ "   CAST( AVG(total_weight) AS DECIMAL (12,2)) AS avg_weight, "
			+ "   CAST( AVG(no_of_teus)AS DECIMAL (12,2)) AS avg_teus "
			+ "    FROM "
			+ "    loading_summary "
			+ "    WHERE "
			+ "    pod in ('JEA1','JEA2','JEA3') "
			+ "    and no_of_teus != 0 "
			+ "    and total_weight != 0 "
			+ "    GROUP BY "
			+ "    pol, pod "
			+ "    ORDER BY "
			+ "    pol";
	
	public static final String SELECT_AVG_POD_JAL = "SELECT "
			+ "    pol, "
			+ "    pod, "
			+ "    CAST( AVG(total_weight)AS DECIMAL (12,2)) AS avg_weight, "
			+ "   CAST( AVG(no_of_teus)AS DECIMAL (12,2)) AS avg_teus "
			+ "    FROM "
			+ "    LOADING_SUMMARY "
			+ "    WHERE "
			+ "    pol in ('JEA1','JEA2','JEA3') "
			+ "    and no_of_teus != 0 "
			+ "    and total_weight != 0 "
			+ "    GROUP BY "
			+ "    pol, pod "
			+ "    ORDER BY "
			+ "    pod";
	
	public static final String GET_SSF_SHARE_LIST = "select "
			  + "* from crosstab "
			  + "('select Sector,sailing_year , sum(no_of_teus) as tues "
			  + "from ( "
			  + "SELECT "
			  + "no_of_teus, " 
			  + "case when voyage.voyage_id like ''%W'' then sector_id||'' WB'' " 
			  + "when voyage.voyage_id like ''%E'' then sector_id||'' EB'' end as Sector, " 
			  + "extract(year from sailing_dt) as sailing_year "
			  + "FROM "
			  + "LOADING_SUMMARY " 
			  + "inner join "
			  + "voyage "
			  + "on LOADING_SUMMARY.voyage_id=voyage.voyage_id " 
			  + ")temp "
			  + "where temp.Sector is not null and " 
			  + "sailing_year>2008 "
			  + "group by Sector,sailing_year " 
			  + "order by sailing_year,sector','select to_char(d,''yyyy'') from generate_series(current_date - interval ''5 year'', current_date, ''1 year'') d') " 
			  + "AS ct(Sector text, ";
	
	public static final String SELECT_THIRD_PARTY_LOADINGS_BY_YEAR = "SELECT l.pol, "
			+ "    l.pod, "
			+ "    SUM(l.NO_OF_TEUS) AS teus, "
			+ "    extract(year from l.sailing_dt) as year "
			+ "    FROM "
			+ "    loading_summary l inner join voyage v  on  l.voyage_id = v.voyage_id "
			+ "       inner join BILL_OF_LADING_HDR bh on bh.LOADING_NO = l.LOADING_ID "
			+ "       inner join SINGLEINVOICE_BL_DTL sb on sb.BL_NO = bh.BL_NO "
			+ "    WHERE "
			+ "     v.third_party ='T' "
			+ "    and EXTRACT(year from  l.sailing_dt) = ? "
			+ "       and (l.pol in ('JEA1','JEA2','JEA3') or l.pod in ('JEA1','JEA2','JEA3')) "
			+ "    GROUP BY "
			+ "    l.pol, "
			+ "    l.pod, "
			+ "    extract(year from l.sailing_dt) "
			+ "    ORDER BY "
			+ "    year, "
			+ "    l.pol";
	
	public static final String SELECT_CURRENT_YEAR = "SELECT "
			+ "EXTRACT(YEAR FROM current_date) "
			+ "FROM DUAL";
	
	public static final String SELECT_PREV_YEAR = "SELECT "
			+ "EXTRACT(YEAR FROM current_date)-1 "
			+ "FROM DUAL";
	public static final String customerList="select MLO_CODE as id,MLO_SHORT_NAME ||'-'||MLO_NAME as text from MLO_MASTER";
}
