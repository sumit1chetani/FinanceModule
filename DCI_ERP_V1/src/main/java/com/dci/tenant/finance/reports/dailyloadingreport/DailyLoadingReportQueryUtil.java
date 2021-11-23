package com.dci.tenant.finance.reports.dailyloadingreport;

public class DailyLoadingReportQueryUtil {
	
	
	public static final String MONTH_LIST = "select '01' as id ,'January' as text union select'02' as id,'February' as text union select'03' as id,'March' as text union select'04' as id,'April' as text union select'05' as id,'May' as text union select'06' as id,'June' as text union select'07' as id,'July' as text union select'08' as id,'August ' as text union select'09' as id,'September' as text union select'10' as id,'October' as text union select'11' as id,'November' as text union select'12' as id,'December' as text order by id";

	public static final String YEAR_LIST = "SELECT extract(year from dt) as id, extract(year from dt) as text FROM generate_series( now() - interval '9 year', now(), '1 year'::interval) dt order by dt desc";

	
	public static final String DAILY_LOADING_REPORT = " with load_trip_allocation as( "
   +" select allocate_trip_id, trip_status_id, status_datetime, prev_status_dt from trip_status_log tsl where allocate_trip_id in ( "
   +" select allocate_trip_id from trip_status_log tsl where tsl.trip_status_id = 2 and to_char(tsl.status_datetime,'MM') = ? and to_char(tsl.status_datetime,'yyyy') = ?)), "
   +" loading_summary as(select tsl.status_datetime as loading, tsl.status_datetime as dispatch, "
   +" (select status_datetime from load_trip_allocation where trip_status_id = 10 and allocate_trip_id=ta.trip_id) as ereturn, tm.truck_reg_no, trip_no, emp_name as driver, "
   +" m.mlo_name, lol.location_name fromloc, lod.location_name as toloc, String_agg(bcd.description,',') description, String_agg(bcd.container_no,'/') conNo, "
   +" string_agg(bcd.seal_no,'/') sealNo, sum(bcd.no_of_packages) packcount, con_size ,cih.tc_amount as ksh, '' as usd,cih.total_tc_amount as netIncome, string_agg(eh.eir_code,'/') eircode, string_agg(to_char(eh.eir_date,'dd/Mon/yyyy'),'/') as erdate,cih.invoice_no as invoiceNo,fv.fuel_voucher_entry_code as fueloNO,fv.fuel_litres as fuelLitter,pt.remarks as remark "

   +" from trip_allocation ta inner join (select * from load_trip_allocation where trip_status_id = 2) tsl on tsl.allocate_trip_id = ta.trip_id "
   +" inner join trip_status d on d.trip_status_id = tsl.trip_status_id "
   +" inner join booking_dtl bd on bd.booking_dtl_id = ta.booking_dtl_id "
   +" inner join booking_con_cargo_dtl bcd on bcd.booking_dtl_id = bd.booking_dtl_id "
   +" inner join booking b on b.booking_id = bd.booking_id "
   +" inner join plan_trip pt on pt.plan_trip_id = ta.trip_id "
   +" inner join location lol on lol.location_id = b.lol_id "
   +" inner join location lod on lod.location_id = b.lod_id "
   +" inner join mlo_master m on m.mlo_code = b.mlo_code "
   +" inner join truck_trailer_mapping ttm on ttm.truck_trailer_mapping_id = pt.truck_trailer_mapping_id "
   +" inner join truck_master tm on tm.truck_id = ttm.truck_id "
   +" inner join truck_driver_mapping tdm on tdm.truck_id = tm.truck_id "
   +" inner join employee_master e on e.emp_id = tdm.emp_id "
   +" inner join container_size cs on cs.con_size_id = bd.con_size_id "
   +" left join customer_invoice_hdr cih on cih.trip_id= pt.plan_trip_id "
   +" left join eir_hdr eh on eh.trip_id=pt.plan_trip_id "
   +" left join fuelvoucherentry fv on fv.plan_trip_id=pt.plan_trip_id "

   +" where to_char(tsl.status_datetime,'MM') = ? and to_char(tsl.status_datetime,'yyyy') = ? and tsl.trip_status_id = 2 "
   +" group by tsl.status_datetime,ta.trip_id, trip_no, e.emp_name, tm.truck_reg_no, m.mlo_name, lol.location_name, lod.location_name, con_size,cih.tc_amount, usd,netIncome,invoiceNo,fueloNO,fuelLitter,remark "
   +" order by tsl.status_datetime) "
   +" select to_char(loading,'dd/Mon/yyyy hh24:mi:ss') as loadDate , to_char(dispatch,'dd/Mon/yyyy hh24:mi:ss') as dispatchDate, to_char(ereturn,'dd/Mon/yyyy hh24:mi:ss') as returnDate, (case when ereturn is not null then round(EXTRACT(EPOCH FROM ereturn - loading )/3600)::text else '-' end) ||':'|| to_char(ereturn - loading, 'MI:SS') as duration, truckno as truckNo, trip_no as uniqueTripNo, driver as driverName, mlo_name as clientName, fromloc as fromLocation, toloc as toLocation, string_agg(description,'&') as goodsDescription, "
   +" string_agg(conno,'/') as containerNo, string_agg(sealno,'/') sealNo, sum(packcount) as bundles, string_agg(con20,'') as twenty, string_agg(con40,'') as fourty, "
   +" string_agg(ksh::text,'/') as incomeKsh,  string_agg(usd,'/') as incomeUsd,netIncome as netIncome, string_agg(eircode,'/') as eirNo, string_agg(erdate,'/') as eirDate,invoiceNo as invoiceNo,fueloNO,fuelLitter,remark as remark "
   +" from(select loading, dispatch, ereturn,  truck_reg_no as truckno, trip_no, driver, mlo_name, "
   +" fromloc, toloc, description, conno, sealno, packcount, con_size as con20, ''::text as con40,ksh,usd,netIncome,eircode,erdate,invoiceNo,fueloNO,fuelLitter,remark "
   +" from loading_summary where con_size='20' union "
   +" select loading, dispatch, ereturn, truck_reg_no as truckno, trip_no, driver, mlo_name, "
   +" fromloc, toloc, description, conno, sealno, packcount, ''::text as con20, con_size as con40,ksh,usd,netIncome,eircode,erdate,invoiceNo,fueloNO,fuelLitter,remark "
   +" from loading_summary where con_size='40') as t "
   +" group by loading, dispatch, ereturn, truckno, trip_no, driver, mlo_name, fromloc, toloc,invoiceNo,fueloNO,fuelLitter,netIncome,remark "
   +" order by loading desc";
	
	
	
	public static final String GET_DEPT_CODE = "select coalesce(em.dept,'0') from employee_master em inner join department_master dm on dm.dept_code=em.dept where emp_id= ?";


}
