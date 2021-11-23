package com.dci.tenant.domain.model;

public class DashboardQueryUtil {

	public static final String Get_Desc_count = "select description,to_char(sum(count),'99,99,99,999') countActivity,orderby from "
		
			+ "(select 1 as orderby ,'Booking' as description,"

			+ "created_date,Month,year,day,count(*) from (select created_date created_date,created_date as Month,"

			+ "created_date as year,created_date as day  from booking ) a  group by created_date,Month,year,day "
		
	
			+ "union select 2 as orderby ,"

			+ "'Delivery Order' as description,created_date,Month,year,day,count(*) from (select created_date created_date,created_date as Month,created_date as year,"

			+ "created_date as day from deliverorder ) a  group by created_date,Month,year,day "
			
		
		/*	+ "union select 3 as orderby ,"

			+ "'Bl Charges' as description,created_date,Month,year,day,count(*) from ( select created_date created_date,created_date as Month,created_date as year,created_date as day  "

			+ "from blcharges_header ) a  group by created_date,Month,year,day "
		*/	
			
			+ "union select 3 as orderby ,'Invoice' as description,created_on,Month,year,day,count(*)"
		
			+ "from (select created_on created_on,created_on as Month,created_on as year,created_on as day  "

			+ "from invoice_hdr ) a  group by created_on,Month,year,day "
			
			
			+ "union select 4 " 

			+"as orderby ,'Quotation' as description,created_date,Month,year,day,count(*) from " 

			+"(select created_date created_date,created_date as Month,created_date as year,created_date as day "
			

			+"from quotation_hdr ) a group by created_date,Month,year,day) a";

	public static String list = "SELECT user_ip_logs.user_id as userId,user_name as userName,"

			+ " action as action,ip_addrs as ipAddrs,to_char(user_ip_logs.created_dt,'dd-mm-yyyy HH12:MIPM') as createdDt,active_inactive as active"

			+ " FROM user_ip_logs INNER JOIN user_master ON user_master.user_id = user_ip_logs.user_id where user_ip_logs.created_dt::date = now()::date order by user_ip_logs.created_dt desc";

}
