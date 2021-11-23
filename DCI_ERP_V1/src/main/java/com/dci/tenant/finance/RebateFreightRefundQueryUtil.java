package com.dci.tenant.finance;

public class RebateFreightRefundQueryUtil {
	public static final String selectCustomerList = "select * from (select mlo_code as id,mlo_name as text from mlo_master order by mlo_name) where rownum<1000";

	public static final String searchCustomerList = "select mlo_code as id,mlo_name as text from mlo_master ";

	public static final String selectPorts = "select port_code as id,port_code as text from port_master order by port_code";

	public static final String searchPorts = "select port_code from port_master ";

	public static final String selectVslVoyage = "select * from (select voyage_id as id,voyage_id as text,SECTOR_ID from voyage order by voyage_id) where rownum<1000 ";

	public static final String searchVoyage = "select voyage_id,SECTOR_ID from voyage ";
	// "select * from (select mlo_code,mlo_name from mlo_master order by
	// mlo_name) where rownum<1000
	// Query to select the invoice no and date
	// public static final String getMloInvoice =
	// "Select  invoice_no,to_char(invoice_dt,'mm/dd/yyyy') from VIEW_SIGICNDNGRP where rownum < 21 and ";

	public static final String getMloInvoice = "select invoice_no,to_char(invoice_dt,'dd/mm/yyyy') from VIEW_SIGICNDNGRP " + " where mlo in ('?') and invoice_dt between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') and rownum < 21 ";
	public static final String getInvoiceNo = "select invoice_no as id,invoice_no as text,to_char(invoice_dt,'dd/mm/yyyy') from VIEW_SIGICNDNGRP where mlo in (?)";
	public static final String getInvoiceForDate = "select invoice_no,to_char(invoice_dt,'dd/mm/yyyy') from VIEW_SIGICNDNGRP where ";

	public static final String getInvoiceForNo = "select invoice_no,to_char(invoice_dt,'dd/mm/yyyy') from VIEW_SIGICNDNGRP where ";

	public static final String selectCurrencyList = "select currency_code as id,currency_name as text from CURRENCY_MASTER";

	public static final String generateRebateId = "SELECT CASE WHEN MAX(rebate_id) " + " IS NULL THEN 'RI00001'  ELSE rpad(to_char(rPAD('RI',2)),2)" + " ||lpad(to_char(MAX(TO_NUMBER(SUBSTR(rebate_id,3))+1)),5,0)" + " END FROM REBATE_REFUND_HDR";

	public static final String insertIntoHdr = "insert into rebate_refund_hdr " + " values(?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String insertSlabsDtl = "insert into rebate_refund_slabs_dtl " + " values(?,?,?,?,?,?)";

	public static final String insertExcepDtl = "insert into rebate_refund_excep_dtl " + " values(?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?)";

	public static final String getRateList = "select * from (select qpp.QUOTATION_NO as id,qpp.QUOTATION_NO as text,qpp.pol,qpp.pod,q.REMARKS " + " from QUOTATION q,QUOTATION_PORT_PAIR qpp " + " where qpp.QUOTATION_NO = q.QUOTATION_NO) where rownum<1000 order by 1";

	public static final String getRateListSearch = "select qpp.QUOTATION_NO,qpp.pol,qpp.pod,q.REMARKS " + " from QUOTATION q,QUOTATION_PORT_PAIR qpp " + " where qpp.QUOTATION_NO = q.QUOTATION_NO ";

	public static final String getRebateList = "select REBATE_ID as rebateRefundId,customer_id as customerCode,mlo_name as customerName,to_char(from_date,'dd/mm/yyyy')  as fromDate,to_char(to_date,'dd/mm/yyyy')   as toDate,PORTS_EXCLD as portsExcluded," + "rh.INVOICE_EXCLD as invoicesExcluded,rh.ONE_OFF_RATE as oneOffRate,rh.ONE_OFF_SAILING as oneOffSailings,rh.APPROVED as rebateApproved " + " from REBATE_REFUND_HDR rh join mlo_master c on rh.customer_id=c.mlo_code order by REBATE_ID desc";
	/*
	 * public static final String tempQuery =
	 * "select z.invoice_no,to_char(z.invoice_dt,'dd/mm/yyyy'),z.loading_no,a.voyage_id,a.vessel_name,a.sector_id,a.pol,a.pod,b.teus20,b.teus40, "
	 * +"a.remarks,to_char(z.invoice_dt,'MON') from " +
	 * "(select c.invoice_no,invoice_dt,d.LOADING_NO from VIEW_SIGICNDNGRP c,VSI_GI_AMOUNT d where "
	 * +"invoice_dt between to_date('1/3/2005','dd/mm/yyyy') and  "
	 * +"to_date('2/8/2005','dd/mm/yyyy') and MLO like 'BA1013'  "
	 * +"and c.INVOICE_NO=d.INVOICE_NO ) z, " +
	 * "(select  loading_id,voyage_id,SIMVesselName(vessel_id) vessel_name,sector_id,pol, pod, "
	 * +"remarks from view_final_loading_hdr )a, " +
	 * "(select loading_id,sum(case group_id when 1 then quantity else 0 end) as teus20, sum (case group_id when 2 then quantity else 0 end) "
	 * +
	 * "as teus40,sum (case group_id when 1 then quantity when 2 then 2 * quantity else 0 end)as total from "
	 * +"view_final_loading_dtl   group by loading_id) b " +
	 * "where a.loading_id=b.loading_id and a.loading_id=z.loading_no order by z.invoice_dt"
	 * ;
	 */
	public static final String getR20R40 = "select * from loading_container_type where CONTAINER_TYPE_ID in('24','26') and loading_id =?";

	public static final String getCRDR = "select debit,credit from general_ledger where account_head ='I010101' and particulars = ? ";

	// public static final String tempQuery1 =
	// "select z.invoice_no,to_char(z.invoice_dt,'dd/mm/yyyy'),z.loading_no,a.voyage_id,a.vessel_name,a.sector_id,a.pol,a.pod,b.teus20,b.teus40, "
	// +"a.remarks,to_char(z.invoice_dt,'MON') from "
	// +"(select c.invoice_no,invoice_dt,d.LOADING_NO from VIEW_SIGICNDNGRP c,VSI_GI_AMOUNT d where "
	// +"invoice_dt between to_date(?,'dd/mm/yyyy') and  "
	// +"to_date(?,'dd/mm/yyyy') and MLO = ?  "
	// +"and c.INVOICE_NO=d.INVOICE_NO ) z, "
	// +"(select  loading_id,voyage_id,SIMVesselName(vessel_id) vessel_name,sector_id,pol, pod, "
	// +"remarks from view_final_loading_hdr )a, "
	// +"(select loading_id,sum(case group_id when 1 then quantity else 0 end) as teus20, sum (case group_id when 2 then quantity else 0 end) "
	// +"as teus40,sum (case group_id when 1 then quantity when 2 then 2 * quantity else 0 end)as total from "
	// +"view_final_loading_dtl   group by loading_id) b "
	// +"where a.loading_id=b.loading_id and a.loading_id=z.loading_no order by z.invoice_dt";
	//
	//
	// public static final String tempQuery2 =
	// "select * from v_rebate_refund where invoice_date between to_date(?,'dd/mm/yyyy') and "
	// +" to_date(?,'dd/mm/yyyy') and MLO = ?";

	public static final String tempQuery3 = "select invoice_no,to_char(invoice_date,'dd/mm/yyyy'),loading_no,voyage_id,vessel_name,sector_id,pol,pod,tues20,tues40,remarks,month, MLO from v_rebate_refund ";

	/*
	 * public static final String getTotalForDateWise =
	 * "select sum(credit)  from v_rebate_refund a,general_ledger b " +
	 * "where a.mlo = ? and a.invoice_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') "
	 * +
	 * " and a.invoice_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') "
	 * +"and account_head ='I010101' and particulars = a.invoice_no "
	 * +" and a.pol not in(?) and a.pod not in (?) and a.INVOICE_NO not in (?) "
	 * +"order by a.invoice_date";
	 */

}
