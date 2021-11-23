package com.dci.tenant.finance.inventoryRprt;

public class InventoryRprtQueryUtil {

	public static final String INV_MASTER_LIST = "select distinct inv.inventory_id invId,to_char(inv.inventory_date ,'dd/mm/yyyy') invDate,inv.location_id locationId,inv.item_id itemId,inv.quantity_available qty,pro.item_code item,pro.item_name itemName,pro.item_description itemDesc,loc.location_name locationName " + " from inventory inv " + " left join item_new pro on inv.item_id = pro.item_id " + " left join location loc on loc.location_id = inv.location_id where pro.item_type!=18  and pro.company_id = ? order by invdate";

	public static final String INV_MASTER_LIST_WITH_ITM_LOC = "select P.item_id,P.item_code,P.item_name, sum(InQty) InQty, sum(outQty) outQty,loc.location_id,loc.location_name " + " from item_new P left outer join (select stock_ledger_id,item_id,destination_location,doc_type,doc_Ref,doc_date," + " case doc_type when 'GRN' then destination_qty else 0  end  as InQty," + " case doc_type when 'Stock Transfer' then destination_qty else 0 end  as outQty"
			+ " from stock_ledger sl left join inventory inv on sl.inventory_id = inv.inventory_id) T on P.item_id = T.item_id " + " left outer join location loc on loc.location_id= T.destination_location" + " left outer join item_new itm on itm.item_id= T.item_id" + " where case when ?>0 then loc.location_id=? else loc.location_id=ANY (select location_id from location ) end " + " and case when ?>0 then itm.item_id=? else itm.item_id=ANY ( select item_id from item_new) end" + " group by P.item_id,loc.location_id,loc.location_name	";

	public static final String INV_SUB_LIST = "select L.stock_ledger_id ledgerId,L.item_id itemId,coalesce(L.source_location,0) srcLoc,L.srcLocation srcLocation,coalesce(L.destination_location,0) locId,L.dstLocation,L.doc_type docType,  L.doc_Ref refDoc,to_char(L.doc_date,'dd/mm/yyyy') inventoryDate,coalesce(L.InQty,0) inQty, coalesce(L.outQty,0) outQty,itm.item_code itemCode,itm.item_name itemDesc from  (select stock_ledger_id,item_id,source_location,destination_location,dtable.value doc_type,doc_Ref,doc_date,sloc.location_name srcLocation,dloc.location_name dstLocation,"
			+ " source_qty as outQty,destination_qty as inQty from  stock_ledger sl left join inventory inv on sl.inventory_id = inv.inventory_id left join location sloc on sloc.location_id = sl.source_location left join  location dloc on dloc.location_id = sl.destination_location left join def_table dtable on sl.doc_type = dtable.def_table_id where doc_date <= to_date(?,'dd/mm/yyyy')) L left outer join item_new itm on itm.item_id= L.item_id  where L.item_id = ? and L.destination_location=? union "
			+ " select L.stock_ledger_id ledgerId,L.item_id itemId,coalesce(L.source_location,0) srcLoc,L.srcLocation,coalesce(L.destination_location,0) locId,L.dstLocation,L.doc_type docType,  L.doc_Ref refDoc,to_char(L.doc_date,'dd/mm/yyyy') inventoryDate,coalesce(L.InQty,0) inQty, coalesce(L.outQty,0) outQty,itm.item_code itemCode,itm.item_name itemDesc from  (select stock_ledger_id,item_id,source_location,destination_location,dtable.value doc_type,doc_Ref,doc_date,sloc.location_name srcLocation,dloc.location_name dstLocation, "
			+ " source_qty as outQty,destination_qty inQty from  stock_ledger sl left join inventory inv on sl.inventory_id = inv.inventory_id left join location sloc on sloc.location_id = sl.source_location left join  location dloc on dloc.location_id = sl.destination_location left join def_table dtable on sl.doc_type = dtable.def_table_id where doc_date <= to_date(?,'dd/mm/yyyy')) L left outer join item_new itm on itm.item_id= L.item_id where L.item_id =? and L.source_location=?";

	public static final String INV_SUB_LIST1 = "select L.stock_ledger_id ledgerId,L.item_id itemId,coalesce(L.source_location,0) srcLoc,L.srcLocation srcLocation,coalesce(L.destination_location,0) locId,L.dstLocation,L.doc_type docType,  L.doc_Ref refDoc,to_char(L.doc_date,'dd/mm/yyyy') inventoryDate,coalesce(L.InQty,0) inQty, coalesce(L.outQty,0) outQty,itm.item_code itemCode,itm.item_name itemDesc from  (select stock_ledger_id,item_id,source_location,destination_location,dtable.value doc_type,doc_Ref,doc_date,sloc.location_name srcLocation,dloc.location_name dstLocation,"
			+ " source_qty as outQty,destination_qty as inQty from  stock_ledger sl left join inventory inv on sl.inventory_id = inv.inventory_id left join location sloc on sloc.location_id = sl.source_location left join  location dloc on dloc.location_id = sl.destination_location left join def_table dtable on sl.doc_type = dtable.def_table_id) L left outer join item_new itm on itm.item_id= L.item_id  where L.item_id = ? and L.destination_location=? union "
			+ " select L.stock_ledger_id ledgerId,L.item_id itemId,coalesce(L.source_location,0) srcLoc,L.srcLocation,coalesce(L.destination_location,0) locId,L.dstLocation,L.doc_type docType,  L.doc_Ref refDoc,to_char(L.doc_date,'dd/mm/yyyy') inventoryDate,coalesce(L.InQty,0) inQty, coalesce(L.outQty,0) outQty,itm.item_code itemCode,itm.item_name itemDesc from  (select stock_ledger_id,item_id,source_location,destination_location,dtable.value doc_type,doc_Ref,doc_date,sloc.location_name srcLocation,dloc.location_name dstLocation, "
			+ " source_qty as outQty,destination_qty inQty from  stock_ledger sl left join inventory inv on sl.inventory_id = inv.inventory_id left join location sloc on sloc.location_id = sl.source_location left join  location dloc on dloc.location_id = sl.destination_location left join def_table dtable on sl.doc_type = dtable.def_table_id) L left outer join item_new itm on itm.item_id= L.item_id where L.item_id =? and L.source_location=?";

	public static final String GET_ITEM_LIST = "select item_id itemId,item_name itemName from item_new where item_type!=18 and item_new.company_id = ? order by item_name";

	public static final String GET_LOCATION_LIST = "WITH RECURSIVE q AS (SELECT location_id ,cast(location_name as varchar(255)) as path FROM location WHERE parent_location_id is null and is_active='t' UNION ALL SELECT ic.location_id,cast( q.path ||' / ' || cast(ic.location_name as varchar(255)) as  varchar(255)) FROM location ic JOIN q ON  ic.parent_location_id =  q.location_id where ic.is_active='t') SELECT location_id as locationId,path as locationName  FROM q ";

	public static final String GET_TOTAL_QTY = "select sum(quantity_available) as totQty from inventory";

	public static final String GET_INVENTORY_REPORT_LIST_BELOW_ROL = "select item_id As itemId, itemName, item_type AS itemType, quantity_available AS qty, reorder_level reorderLevel " + "from (select inventory_id, inventory_date, inventory.location_id, inventory.item_id, " + "concat(item.item_code,' - ',item.item_name) itemName, def_table.value as item_type, " + "CAST(nullif(item.reorder_level, '') AS integer) reorder_level, inventory.quantity_available, " + "CASE WHEN (quantity_available < CAST(nullif(item.reorder_level, '') AS integer)) "
			+ "THEN (quantity_available) end as reorderQty from inventory " + "left join item_new item on item.item_id = inventory.item_id " + "left join def_table on def_table.def_table_id = item.item_type " + "where def_table.value='Consumable' or def_table.value='Stockable Product' ) AS I1 " + " where reorderQty is not null";

	public static final String GET_INVENTORY_BATCH_LIST = "select sld.batch_no as batchNo,it.item_id as itemId,it.item_name as itemName,sld.source_qty as outQty,sld.destination_qty inQty from stock_ledger_detail sld inner join item_new it on it.item_id = sld.item_id where sld.stock_ledger_id = ?";

	public static final String INV_MASTER_LIST_NEW = "select * from vw_get_inventory_search4_new('','','','')  ";
	public static final String GET_CATEGORY_LIST = "select item_category_id as categoryid ,category_name as categoryname  from item_category ";

	public static final String INV_NEW_SUB_LIST = "(select to_char(grn_date,'dd/mm/yyyy') as refDate,grn_number as refNo,(select Item_name from Item_new where item_id = gd.item_id limit 1) as itemName, (select location_name from location where location_id  = grn.location_id limit 1) as locationName, 'GRN' as reasons, 0 as Opening,coalesce(sum(converted_quantity_new),0)::numeric as Received, 0 as Issued from grn   left join  grn_detail gd on gd.grn_id = grn.grn_id where gd.item_id = ? and grn_date<= to_date(?,'dd/mm/yyyy') group by grn_date,grn_number,gd.item_id,grn.location_id)  \r\n"
			+ " union  (select  to_char(stock_transfer_date,'dd/mm/yyyy') as refDate,stock_transfer_number as refNo,(select Item_name from Item_new where item_id = std.item_id limit 1) as itemName, (select location_name from location where location_id  = st.destination_location  limit 1) as locationName, 'Stock Transfer' as reasons, 0 as Opening, 0 as Received,  sum(quantity)::numeric as Issued from stock_transfer  st  left join stock_transfer_detail std on std.stock_transfer_id = st.stock_transfer_id where std.item_id = ? and stock_transfer_date<= to_date(?,'dd/mm/yyyy')  group by stock_transfer_date,stock_transfer_number,std.item_id,st.destination_location )";

	public static final String INV_NEW_SUB_LIST_NEW = "select * from vw_get_inventory_sub_list(?,?)";

	public static String GET_INVENTORY_SEARCH_LIST(String item, String location, String fromdate, String todate, String category) {

		if (item == null || item.equals("null") || item == "") {
			item = null;
		}
		if (location == null || location.equals("null") || location == "") {
			location = null;
		}

		if (fromdate == null || fromdate.equals("null") || fromdate == "") {
			fromdate = null;
		}
		if (todate == null || todate.equals("null") || todate == "") {
			todate = null;
		}

		if (category == null || category.equals("null") || category == "") {
			category = null;
		}

		String str2 = "select * from vw_get_inventory_search4_new('" + item + "','" + fromdate + "','" + todate + "','" + category + "') order by to_date(invdate,'dd/mm/yyyy' ) DESC";
		System.out.println("" + str2);
		return str2;
	}

	public static String GET_INVENTORY_SEARCH_LIST1 = "select * from vw_get_inventory_search4_new(?,?,?,?)";

}
