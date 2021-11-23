package com.dci.reports.quotationsummary;

public class QuotationsummaryQueryUtil {
	
	
	
	public static final String GETCUSTOMERLIST="select distinct cust_code as id ,concat(cust_short_name,' - ',cust_name) as text from customer_master";

	/*
	public static final String GET_SEARCH="select booking_id as bookingId,booking_no as bookingNum,quotation,"
                                     +" agent, customer as customer, customer_type customerType, vessel, voyage, origin, pol, pod"
                                     + " from booking where customer=? ";
	*/
	
	
	public static final String GET_SEARCH=" SELECT b.booking_no,qo.quotation_no,cu.cust_short_name as customer, qo.agre_party_id as agreParty,"
			+ " b.booking_date, qo.currency_code,tb.vesselname as vessel, b.voyage, qo.pod_id,b.pol, b.origin FROM booking b "
			+ "INNER JOIN quotation_hdr qo ON b.quotation=qo.quotation_no "
	+"inner join customer_master cu on cu.cust_code=b.customer inner join tb_vessels tb on tb.vesselcode=b.vessel where customer=? ";

	
	public static final String list="select booking_id as bookingId,booking_no as bookingNum,quotation,"
        +" agent, customer as customer,pol as pol, pod as pod"
        + " from booking ";

	
}
