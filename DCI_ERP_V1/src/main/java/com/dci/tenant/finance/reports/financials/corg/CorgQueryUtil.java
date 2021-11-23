package com.dci.tenant.finance.reports.financials.corg;

public class CorgQueryUtil {

	public static String GET_CORG_LIST = "select YR as year, wk as week, TTL as totalAmount, "
			+ "CO30 as CO30,CO30_PER as CO30PER, "
			+ "CO30PLUS as CO30to45,CO30PLUS_PER as CO30to45Per, "
			+ "CO45  as CO45to60, CO45_PER as CO45to60Per, "
			+ "CO60  as CO60Plus, "
			+ "CO60_PER as CO60PlusPer from vw_corg_report(?,?) WHERE YR is not null";
	
	
	public static String GET_CORG_LIST_AS_ON_DATE= "select YR as year, wk as week, TTL as totalAmount, "
			+ "CO30 as CO30,CO30_PER as CO30PER, "
			+ "CO30PLUS as CO30to45,CO30PLUS_PER as CO30to45Per, "
			+ "CO45  as CO45to60, CO45_PER as CO45to60Per, "
			+ "CO60  as CO60Plus, "
			+ "CO60_PER as CO60PlusPer from vw_corg_report_as_on_date(?,?) WHERE YR is not null";


	public static String GET_WEEK_END_DATE = " select to_char(w_end_date,'DD-MM-YYYY') as endDate from week_date where week_no=? and fin_year_id=? " ;
	

}
