package com.dci.tenant.finance.reports.schedule.inventry;

public class InventryQueryUtill {
/*
	public static String sGetInventryValues = " with OpStock as(select VESSEL, FO_OPENING_STOCK, GO_OPENING_STOCK, COMPLETION_DT from ( select VESSEL, FO_OPENING_STOCK, GO_OPENING_STOCK, COMPLETION_DT, ROW_NUMBER() OVER (PARTITION BY VESSEL ORDER BY COMPLETION_DT) AS rownumber from voyage_details ) WHERE rownumber = 1), FO as ( select VESSEL_ID, Purchase_order_dt, round(AMOUNT_USD / QUANTITY,2) FO_Rate from PO_bunker_supplied S, PO_bunker_supplied_dtl D where S.PURCHASE_ORDER_NO = D.PURCHASE_ORDER_NO and Bunker_Type_id = 'BT001' and QUANTITY > 0), GO as ( select VESSEL_ID, Purchase_order_dt,  round(AMOUNT_USD / QUANTITY,2) GO_Rate from PO_bunker_supplied S, PO_bunker_supplied_dtl D  where S.PURCHASE_ORDER_NO = D.PURCHASE_ORDER_NO and Bunker_Type_id = 'BT002' and QUANTITY > 0 ),T1 as ( select * from OpStock O Cross Apply (select Purchase_order_dt FO_Last_Supplied_dt, FO_Rate from FO where VESSEL_ID = O.VESSEL and Purchase_order_dt = (select max(Purchase_order_dt) from FO where Purchase_order_dt < O.COMPLETION_DT))) select * from T1 Cross Apply (select Purchase_order_dt GO_Last_Supplied_dt, GO_Rate from GO where VESSEL_ID = T1.VESSEL and"
			+ "Purchase_order_dt = (select max(Purchase_order_dt) from GO where Purchase_order_dt < T1.COMPLETION_DT))";

	*/
	
	
	public static String sGetInventryValues = "select to_char(fuel_voucher_entry_date,'dd/mm/yyyy') as fuelDate,dt.value as fuelType,  truck_reg_no as truck, "
			+ "fuel_litres as units from fuelvoucherentry fv  inner join truck_master tm on tm.truck_id = fv.truck_id inner join def_table dt on tm.fuel_type = dt.def_table_id where fv.truck_id = ? and fuel_voucher_entry_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy')";
}
