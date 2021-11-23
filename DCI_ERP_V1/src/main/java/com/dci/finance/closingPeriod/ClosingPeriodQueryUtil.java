package com.dci.finance.closingPeriod;

public class ClosingPeriodQueryUtil {

	public static final String GETCLOSINGACCOUNTLIST = "\n" + "			select distinct closing_acc_code,to_char(from_date,'dd/mm/yyyy') fromDate,to_char(to_date,'dd/mm/yyyy') toDate, \n" + "			 short_name companyName,a.created_by closedBy from closing_account_head A \n" + "			 inner join company c  on c.company_id=A.company_code   order by closing_acc_code asc \n" + "";
	public static final String DELETECLOSINGACCOUNT = "delete from closing_account where" + "fromDate " + "  <= to_date(?,'dd/mm/yyyy') and toDate >= to_date(?,'dd/mm/yyyy') ";

	public static final String SAVE_CLOSING_ACCOUNT_HEAD = "insert into closing_account " + "  (fromDate,toDate" + ",created_by,company_code,created_dt,status) values(to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,now(),?)";

	public static final String CHK = "select count(*) from closing_account  where fromDate " + "  <= to_date(?,'dd/mm/yyyy') and toDate >= to_date(?,'dd/mm/yyyy') ";

}