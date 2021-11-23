package com.dci.tenant.finance.manageitem;

/**
 * 
 * @author Bharath
 */
public class ManageItemQueryTable {

	public static final String GET_ITEM_SPECIFICATION_LIST = "select dynamic_attribute.dynamic_attribute_id as id, value as typeinput,attribute_name as labelName,attribute_defualt_value  as defaultvalue from  item_category_property left join dynamic_attribute on dynamic_attribute.dynamic_attribute_id=item_category_property.dynamic_attribute_id left join def_table on def_table.def_table_id = attribute_type where item_category_id=? and dynamic_attribute.attribute_data_type=110";

	public static String sGetManageItemList = "SELECT item_id as itemId, item_code as itemCode, item_name as itemName, item_description as itemDescription, value as itemType, category_name as itemCategory FROM item_new item LEFT JOIN item_category ic on ic.item_category_id = item.item_category INNER JOIN def_table dt on dt.def_table_id=item_type where item.company_id = ?  order by item_id desc ";

	public static String sGetManageItemList1 = "SELECT item_id as itemId, item_code as itemCode, item_name as itemName, item_description as itemDescription, value as itemType, category_name as itemCategory,uom1.uom as uom FROM item_new item INNER JOIN item_category ic on ic.item_category_id= item.item_category INNER JOIN def_table dt on dt.def_table_id=item_type INNER JOIN uom uom1 on uom1.uom_id=item.uom where item.company_id = ? order by item_id desc ";

	public static String sGetItemCategoryList = "SELECT item_category_id as itemCategoryId,category_name as text,category_type as itemCategorytype FROM item_category";

	public static String sGetUomList = "select  uom_id,uom from uom order by uom asc";

	public static final String sDeleteItemGrnDetails = "DELETE FROM item_grn_attribute   WHERE item_id = ?";

	public static final String sDeleteItemPropertyDetails = "DELETE FROM item_property   WHERE item_id = ?";

	public static String sGetEntityList = "select entity_id,entity_name from entity  WHERE is_vendor=true ORDER BY entity_name";

	public static String sInsertManageItemMasterHDR = "INSERT INTO item_new( item_code,item_name, item_description, item_type, item_category,default_rate,is_saleable, is_purchasable,is_auto,is_service, purchase_method, uom, is_requestable,max_qty,min_qty, reorder_level, costing_method, cost_price,warranty,inventory_valuation,issue_method,created_by, created_date,company_id,supply_lead_time,tax,cgst,sgst,igst,opening_qty,current_qty,altuom,altqty)  VALUES (?,?,?, ?,?,?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?,?, ?, ?,?,?,?,?,?,?,?,?) returning item_id";

	public static String sInsertVendorMasterDetails = "INSERT INTO item_vendor(item_id,entity_id, vendor_item_code, vendor_item_name, vendor_min_qty,vendor_uom_id, pricing_type, delivery_lead_time, created_by, created_date  )  VALUES (?, ?, ?, ?,?,?, ?, ?, ?,?)";

	public static String sUpdateManageItemMasterHDR = "UPDATE item_new  SET  item_code=?, item_name=?, item_description=?, item_type=?, item_category=?,default_rate=?, is_saleable=?, is_purchasable=?,is_auto=?,is_service=?, purchase_method=?, uom=?, is_requestable=?, max_qty=?,min_qty=?, reorder_level=?, costing_method=?, cost_price=?, warranty=?, inventory_valuation=?, issue_method=?,  modified_by=?, modified_date=? ,supply_lead_time=? ,tax = ?,cgst = ?,sgst = ?,igst = ? ,opening_qty = ?, current_qty = ?, altuom = ? , altqty = ? WHERE item_id=?";

	public static String sUpdateVendorMasterDetails = "UPDATE item_vendor  SET item_id=?,entity_id=?, vendor_item_code=?, vendor_item_name=?, vendor_min_qty=?, vendor_uom_id=?, pricing_type=?, delivery_lead_time=?, modified_by=?, modified_date=? WHERE item_vendor_id=?";

	public static final String sDeleteItemvendorDetails = "DELETE FROM item_vendor WHERE item_id = ?";

	public static String sDeletevendorDetails = "DELETE FROM item_vendor   WHERE item_vendor_id = ?";

	public static String sDeleteItemHeader = " DELETE FROM item_new   WHERE item_id = ? ";

	public static String sGetEditList = "SELECT item_id,item_type, item_code , item_name, item_description, item_category ,default_rate,is_saleable , is_purchasable  ,is_service, is_auto, purchase_method , uom  , is_requestable ,CASE WHEN min_qty IS NULL THEN 0.00 ELSE  min_qty  END , CASE WHEN max_qty IS NULL THEN 0.00 ELSE  max_qty  END , reorder_level, costing_method , CASE WHEN cost_price IS NULL THEN 0.00 ELSE cost_price  END ,"
			+ "CASE WHEN warranty IS NULL THEN 0 ELSE warranty  END , CASE WHEN supply_lead_time IS NULL THEN 0 ELSE supply_lead_time  END  ,  " + "CASE WHEN inventory_valuation IS NULL THEN 0 ELSE inventory_valuation  END  ,"
			+ " CASE WHEN issue_method IS NULL THEN 0 ELSE issue_method  END,CASE WHEN tax IS NULL THEN 0 ELSE tax END, CASE WHEN cgst IS NULL THEN 0 ELSE cgst END,CASE WHEN sgst IS NULL THEN 0 ELSE sgst END ,CASE WHEN igst IS NULL THEN 0 ELSE igst END  , CASE WHEN opening_qty IS NULL THEN 0.00 ELSE opening_qty  END  , altuom as altuom, altqty as altqty FROM item_new where item_id= ?";

	public static String sGetVendorList = "SELECT  item_vendor_id, vendor_item_name,vendor_item_code, vendor_min_qty,vendor_uom_id, pricing_type, delivery_lead_time,entity_id  FROM item_vendor where item_id= ? ";

	public static String sGetItemBasedLocation = "select inv.location_id as locationId,loc.location_name as locationName,inv.quantity_available as qty from inventory  inv INNER JOIN Location loc on inv.location_id=loc.location_id where item_id=?";

	public static final String sUpdateItemSpecificationDetails = "update item_property set dynamic_attribute_id=?,dynamic_attribute_value=?,item_id=? where item_property_id = ?";

	public static final String sGetSpecificationList = "select item_property_id,dynamic_attribute_id,dynamic_attribute_value from item_property where item_id=?";

	public static final String sInsertItemSpecificationDetails = "insert into item_property(dynamic_attribute_id,dynamic_attribute_value,item_id) values(?,?,?)";

	public static final String sDeletItemSpecification = "delete from  item_property where item_property_id=?";

	public static final String GET_iTEM_CATEGORY_DETAILS = "SELECT batch_no, mrp, expiry_date, manufacture_details  FROM grn_attribute where item_category_id = ?";

	public static final String sInsertGRnAttributeDetails = "INSERT INTO item_grn_attribute(item_id, batch_no, mrp, expiry_date, manufacture_details)   VALUES ( ?, ?, ?, ?, ?)";

	public static final String sUpdateGrnAttributeDetails = "UPDATE item_grn_attribute  SET  batch_no=?, mrp=?, expiry_date=?, manufacture_details=? WHERE item_id=? ";

	public static final String sGetGRNEditDetails = "SELECT  batch_no, mrp, expiry_date, manufacture_details FROM item_grn_attribute where item_id= ?";

	// Line Chart
	public static final String QTY_MASTER_LIST = "SELECT series.date as docDate, coalesce(destination_qty, null) qty FROM ( select to_char(date_trunc('day', (current_date - offs)), 'dd/mm/yyyy') AS date FROM generate_series(0, ?, 1) AS offs ) series LEFT OUTER JOIN ( select to_char(doc_date, 'dd/mm/yyyy') document_date,sum(destination_qty) destination_qty from stock_ledger sl inner join inventory inv on sl.inventory_id = inv.inventory_id inner join item_new it on it.item_id = inv.item_id where item_type=? and inv.item_id = ? group by doc_date ) dtls on dtls.document_date = series.date";

	public static final String QTY_MAX = "select coalesce(max(destination_qty),0) maxQty  from ( select to_char(doc_date, 'dd/mm/yyyy') document_date,destination_qty from stock_ledger sl inner join inventory inv on sl.inventory_id = inv.inventory_id inner join item_new it on it.item_id = inv.item_id where item_type=? and destination_location is not null and inv.item_id = ?) ageQty";

	public static final String QTY_MIN = "select coalesce(min(destination_qty),0) minQty from ( select to_char(doc_date, 'dd/mm/yyyy') document_date,destination_qty from stock_ledger sl inner join inventory inv on sl.inventory_id = inv.inventory_id join item_new it on it.item_id = inv.item_id where item_type=? and destination_location is not null and inv.item_id = ?) ageQty";

	public static final String QTY_AVG = "select coalesce(avg(destination_qty),0):: integer avgQty from (  select to_char(doc_date, 'dd/mm/yyyy') document_date,destination_qty from stock_ledger sl  inner join inventory inv on sl.inventory_id = inv.inventory_id inner join item_new it on it.item_id = inv.item_id where item_type=? and destination_location is not null and inv.item_id = ?) ageQty";

	public static final String GET_ITEM_LIST = "select item_id itemId,item_name itemName from item_new where item_type=16 order by item_name";

	public static final String GET_LOCATION_LIST = "select location_id locationId,location_name locationName from location order BY location_name";

	public static final String GET_TOTAL_QTY = "select sum(quantity_available) as totQty from inventory";

	public static String checkItemDetails = "select item_id from purchase_requisition_detail where item_id=?";

	public static String checkItemName = "SELECT count(*) FROM item_new WHERE LOWER(item_name)=LOWER(?)";

	public static String checkItemCode = "SELECT count(*) FROM item_new WHERE LOWER(item_code)=LOWER(?)";

	public static final String getCategoryBasedUomId = "select coalesce(uom_category_id,0) as uomCategoryId from uom where uom_id = ?";

	public static final String sGetUOMCategoryBasedList = "select uom_id as id,uom as text from uom where uom_category_id = ?";

}
