package com.dci.inventory.consignmentIn;

public class ConsignmentInQueryUtil {

	public static final String GET_DEFAULT_VALUE = "select def_table_id,value from def_table  where form_field_id=(select form_field_id from form_field where form_field_id=?)";

	public static final String GET_LOACATION = "select location_id,location_name from location order by location_name asc";

	public static final String saveConsignmentInData = "INSERT INTO stock_transfer(stock_transfer_number, stock_transfer_date, transport_Type,service_name,person_name,delivery_method,Status,stock_transfer_type,reason,purchase_quote_id) VALUES (?,?, ?, ?,?, ?, ?, ?, 121,?,?) returning stock_transfer_id";

	public static final String saveConsignmentInDetailData = "INSERT INTO stock_transfer_detail (item_id, quantity,stock_transfer_id) values(?,?,?)";

	public static final String autoGenConsignmentInNo = "SELECT CASE WHEN MAX(stock_transfer_number) IS NULL  THEN ? ELSE rpad(MAX(stock_transfer_number),3,'CNI')|| " + " lpad(cast(cast((SUBSTRING(MAX(stock_transfer_number),4)) as int)+1  as text),4,'0') END as stock_in_number FROM stock_transfer" + " where stock_transfer_number like ? ";

	public static final String SELECT_CONSIGNMENT_IN_HEADER_LIST = "SELECT stock_transfer_id consignmentInId, to_char(stock_transfer_date,'DD/MM/YYYY') consignmentInDate, stock_transfer_number consignmentInNo, " + "transport_type transportType,def_table.value, status, reason stockReason FROM stock_transfer " + "left join def_table on def_table.def_table_id = stock_transfer.transport_type " + "where stock_transfer_type=? and stock_transfer.company_id = ? ORDER BY stock_transfer_number DESC";

	public static final String GET_CONSIGNMENT_IN_HDR_LIST_ON_EDIT = "SELECT coalesce(st.company_id,'') companyId,stock_transfer_id consignmentInId, to_char(stock_transfer_date,'DD/MM/YYYY') consignmentInDate, " + "COALESCE(purchase_requisition_id,0) requisition,stock_transfer_number consignmentInNo,transport_type transportType,st.service_name serviceName, " + "st.person_name personName, status, source_location sourceLocName,destination_location destinationLocName, received_by receivedBy, "
			+ "st.entity_id vendor, entity_name as vendorName ,reason stockReason,st.purchase_quote_id quotation,purchase_quote_no quotationNo FROM stock_transfer st " + "left join def_table on def_table.def_table_id = st.transport_type " + "left join purchase_quote  pq on pq.purchase_quote_id = st.purchase_quote_id " + "left join entity en on en.entity_id = st.entity_id " + "where stock_transfer_id=? ORDER BY stock_transfer_number DESC";

	public static final String GET_CONSIGNMENT_IN_DTL_LIST_ON_EDIT = "select stock_transfer_detail_id consignmentInDetId, batch_number,item.item_id itemId, concat(item.item_code,' - ',item.item_name) itemName, concat(item.item_code,' - ',item.item_name) as text,coalesce(vendor_qty,0) as itemQuantity,coalesce(stock_Transfer_detail.quantity,0) as purchaseQuantity from stock_Transfer_detail left join item_new item on item.item_id =  stock_Transfer_detail.item_id where stock_Transfer_detail.stock_transfer_id=?";

	public static final String GET_QUOTATION1 = "select distinct(purchase_quote_id) purchase_quote_id , purchase_quote_no,entity.entity_id,entity.entity_name from purchase_quote pq" + " left join entity on entity.entity_id = pq.entity_id" + " left join location on location.address_id = entity.address_id" + " left join employee on employee.employee_id = pq.created_by" + " where purchase_type=124 and pq.company_id = ? order by purchase_quote_no desc";

	public static final String sCheckBatchName = "SELECT count(*) FROM stock_transfer_detail   WHERE LOWER(batch_number)=LOWER(?)";

	public static final String GET_QUOTATION = "select distinct(pq.purchase_quote_id) purchase_quote_id , purchase_quote_no,entity.entity_id,entity.entity_name from purchase_quote pq " + "left join entity on entity.entity_id = pq.entity_id " + "left join location on location.address_id = entity.address_id " + "left join employee on employee.employee_id = pq.created_by " + "left join purchase_quote_detail as pqd on pqd.purchase_quote_id = pq.purchase_quote_id "
			+ "where purchase_type=124 and pq.company_id = ? and pqd.quote_status=34 and pq.purchase_quote_id not in (select purchase_quote_id from stock_transfer where purchase_quote_id is not null) order by purchase_quote_no desc";

	public static final String GET_ITEM_CODE = "select item.item_id itemId,concat(item.item_code,' - ',item.item_name) itemName,coalesce(purchase_quote_detail.purchase_quantity ,0) purchaseQuantity, " + "purchase_quote_detail.quantity as itemQuantity,purchase_quote_detail_id purchaseQuotDetId,ga.batch_no as isBatchNoExist " + "from purchase_quote_detail " + "left join item_new item on item.item_id=purchase_quote_detail.item_id " + "left join uom on uom.uom_id=item.uom " + "left join item_grn_attribute ga on ga.item_id = item.item_id "
			+ "where purchase_quote_id=? AND quote_status=34";

	
	public static final String GET_PARENT_LOCATION = "WITH RECURSIVE q AS (SELECT location_id ,cast(location_name as varchar(255)) as path FROM location WHERE parent_location_id is null and is_active='t' UNION ALL SELECT ic.location_id,cast( q.path ||' / ' || cast(ic.location_name " + "as varchar(255)) as  varchar(255)) FROM location ic JOIN q ON  ic.parent_location_id =  q.location_id where ic.is_active='t') SELECT location_id as id,path as text  FROM q where location_id not in(?,?) ";

}
