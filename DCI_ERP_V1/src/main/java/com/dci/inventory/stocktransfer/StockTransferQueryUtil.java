package com.dci.inventory.stocktransfer;

public class StockTransferQueryUtil {

	public static final String GET_BATCH_DETAILS_DATA = "SELECT A.item_id as dtlItemId, A.lotNo,A.mrp,A.expiryDate,A.destinationLocation,A.dtlItemName, coalesce(A.destinationQty,0)-coalesce(B.sourceQty,0) as batchQty, coalesce(B.sourceQty,0), " + "coalesce(A.destinationQty,0) " + "FROM  ( " + "select sld.batch_no lotNo,coalesce(sum(sld.source_qty),0) sourceQty, coalesce(sum(sld.destination_qty),0) destinationQty ,coalesce(sld.source_location,0) sourceLocation, "
			+ "coalesce(sld.destination_location,0) destinationLocation,sld.item_id,coalesce(sld.mrp_price,0.0) mrp, TO_CHAR(sld.expiry_date,'dd/mm/yyyy') as expiryDate,it.item_name as dtlItemName " + "from  stock_ledger_detail as sld inner join item_new it on it.item_id = sld.item_id " + "inner join stock_ledger as sl on sl.stock_ledger_id=sld .stock_ledger_id " + "where sld.item_id=? and sld.destination_location = ?  and sl.doc_ref not like  'CNI%' "
			+ " group by sld.item_id,sld.batch_no,sld.mrp_price,sld.expiry_date,sld.destination_location,sld.source_location,it.item_name " + ") AS A " + " LEFT OUTER JOIN " + "( " + "select sld1.batch_no lotNo, coalesce(sum(sld1.source_qty),0) sourceQty, coalesce(sum(sld1.destination_qty),0) destinationQty,coalesce(sld1.source_location,0) sourceLocation, " + " coalesce(sld1.destination_location,0) destinationLocation, sld1.item_id,coalesce(sld1.mrp_price,0.0) mrp,TO_CHAR(sld1.expiry_date,'dd/mm/yyyy') as expiryDate, "
			+ "it.item_name as dtlItemName  from  stock_ledger_detail as sld1 inner join item_new it on it.item_id = sld1.item_id " + "inner join stock_ledger as sl on sl.stock_ledger_id=sld1.stock_ledger_id " + " where sld1.item_id=? and sld1.source_location = ?   and sl.doc_ref not like  'CNI%' " + "group by sld1.item_id,sld1.batch_no ,sld1.mrp_price,sld1.expiry_date,sld1.source_location,sld1.destination_location,it.item_name " + " " + ") AS B " + "ON B.lotno=A.lotno "
			+ "AND A.item_id=B.item_id where coalesce(A.destinationQty,0)-coalesce(B.sourceQty,0) > 0";

	public static final String GET_BATCH_DETAILS = "SELECT A.item_id as dtlItemId, A.lotNo,A.destinationLocation,A.dtlItemName, coalesce(A.destinationQty,0)-coalesce(B.sourceQty,0) as batchQty, coalesce(B.sourceQty,0),  coalesce(A.destinationQty,0)  FROM  (  select sld.batch_no lotNo,coalesce(sum(sld.source_qty),0) sourceQty, coalesce(sum(sld.destination_qty),0) destinationQty ,coalesce(sld.source_location,0) sourceLocation, "
			+ "			   coalesce(sld.destination_location,0) destinationLocation,sld.item_id,it.item_name as dtlItemName  from  stock_ledger_detail as sld inner join item_new it on it.item_id = sld.item_id  inner join stock_ledger as sl on sl.stock_ledger_id=sld .stock_ledger_id     where sld.item_id=?  and sl.doc_ref not like  'CNI%'     group by sld.item_id,sld.batch_no,sld.destination_location,sld.source_location,it.item_name  ) AS A "
			+ "			     LEFT OUTER JOIN  (  select sld1.batch_no lotNo, coalesce(sum(sld1.source_qty),0) sourceQty, coalesce(sum(sld1.destination_qty),0)      destinationQty,coalesce(sld1.source_location,0) sourceLocation,   coalesce(sld1.destination_location,0) destinationLocation, sld1.item_id,     it.item_name as dtlItemName  from  stock_ledger_detail as sld1 inner join item_new it on it.item_id = sld1.item_id "
			+ "			   inner join stock_ledger as sl on sl.stock_ledger_id=sld1.stock_ledger_id   where sld1.item_id=?    and sl.doc_ref not like  'CNI%'    group by sld1.item_id,sld1.batch_no ,sld1.source_location,sld1.destination_location,it.item_name    ) AS B  ON B.lotno=A.lotno    AND A.item_id=B.item_id where coalesce(A.destinationQty,0)-coalesce(B.sourceQty,0) > 0";

	public static final String GET_QC_BATCH_DETAILS = "select gbd.batch_no lotNo, grn_detail.item_id as itemId, sum(coalesce(gbd.converted_quantity,0)) batchQty from grn_detail " + "inner join grn on grn.grn_id= grn_detail.grn_id " + "inner join  grn_batch_detail gbd on gbd.grn_detail_id = grn_detail.grn_detail_id " + "where grn_detail.item_id=? and grn.qc_location_id=? and  grn_detail.qc_status is null " + "group by grn_detail.item_id,grn.qc_location_id,gbd.batch_no";

	// public static final String INSERT_STOCK_BATCH_DTL =
	// "insert into
	// stock_transfer_batch_detail(stock_transfer_detail_id,item_id,batch_no,batch_qty,expiry_date,manufacturer,mrp_price,transfer_qty,pending_qty,receive_qty)
	// values(?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?)";
	public static final String INSERT_STOCK_BATCH_DTL = "insert into stock_transfer_batch_detail(stock_transfer_detail_id,item_id,batch_no,batch_qty,manufacturer,mrp_price,transfer_qty,pending_qty,receive_qty) values(?,?,?,?,?,?,?,?,?)";

	public static final String GET_STOCK_TRANSFER_BATCH_DTLS = "select stock_transfer_batch_detail_id as stockTransferBatchDetailId,it.item_id as dtlItemId,batch_no lotNo,coalesce(batch_qty,0) batchQty,coalesce(transfer_qty,0) transferQty, it.item_name as dtlItemName,TO_CHAR(expiry_date,'dd/mm/yyyy') as expiryDate,manufacturer manufactureDef,coalesce(mrp_price,0.0) mrp from stock_transfer_batch_detail inner join item_new it on it.item_id = stock_transfer_batch_detail.item_id where stock_transfer_detail_id = ? ";

	public static final String GET_ASSET_ID = "select item_id from asset where asset_id=?";

	public static final String GET_OLD_QUANTITY = "select stock_transfer_detail.quantity from  stock_transfer " + "inner join stock_transfer_detail on stock_transfer_detail.stock_transfer_id=stock_transfer.stock_transfer_id " + "where stock_transfer.stock_transfer_id=? and stock_transfer_detail.item_id=?";

	public static final String MAX_DETAIL_ID = "select max(stock_transfer_detail_id) from stock_transfer_detail where stock_transfer_id =?";

	public static final String GET_CONSIGNMENT_IN_BATCH_DTLS = "select stock_transfer_batch_detail_id as stockTransferBatchDetailId,it.item_id as dtlItemId,batch_no lotNo,coalesce(transfer_qty,0) batchQty,coalesce(transfer_qty,0) transferQty, it.item_name as dtlItemName,TO_CHAR(expiry_date,'dd/mm/yyyy') as expiryDate,manufacturer manufactureDef,coalesce(mrp_price,0.0) mrp from stock_transfer_batch_detail inner join item_new it on it.item_id = stock_transfer_batch_detail.item_id where stock_transfer_detail_id = ? ";

	public static String GET_LOACATION = "WITH RECURSIVE q AS (SELECT location_id ,cast(location_name as varchar(255)) as path FROM location WHERE parent_location_id is null UNION ALL SELECT ic.location_id,cast( q.path ||' / ' || cast(ic.location_name as varchar(255)) as  varchar(255)) FROM location ic JOIN q ON  ic.parent_location_id =  q.location_id ) SELECT location_id,path as location_name FROM q";

	// public static String GET_ITEM_CODE =
	// "select coalesce(quantity,0) as originalQty, item.item_id,item.item_id as
	// id,concat(item.item_code,' - ',item.item_name) as text , "
	// +
	// "item_code,item_name,item_desc,quantity,uom.uom as
	// uom,purchase_requisition_detail_id, coalesce(ga.batch_no,false) as
	// isBatchNoExist "
	// + "from purchase_requisition_detail " +
	// "left join item_new item on
	// item.item_id=purchase_requisition_detail.item_id "
	// + "left join uom on uom.uom_id=item.uom " +
	// "left join item_grn_attribute ga on ga.item_id = item.item_id "
	// + "where purchase_requisition_id=?";
	public static String GET_ITEM_LIST = " select item_id as id ,item_name as text from item_new where company_id=?";

	public static String GET_ITEM_CODE = "select coalesce(quantity,0) as originalQty, item.item_id,item.item_id as id,concat(item.item_code,' - ',item.item_name) as text , " + "item_code,item_name,item_desc,quantity,coalesce(pending_quantity,0) as pending_quantity,uom.uom as uom,purchase_requisition_detail_id, coalesce(ga.batch_no,false) as isBatchNoExist,(select concat(requisition_number,'-',pr_request_number) from purchase_requisition where purchase_requisition_id = ?) as requisitionNo " + "from purchase_requisition_detail "
			+ "left join item_new item on item.item_id=purchase_requisition_detail.item_id " + "left join uom on uom.uom_id=item.uom " + "left join item_grn_attribute ga on ga.item_id = item.item_id " + "where purchase_requisition_id=?";

	public static String GET_REQUISITION = "select purchase_requisition_id,concat(requisition_number,'-',pr_request_number) as requisition_number,to_char(requisition_date,'DD/MM/YYYY')requisition_date,(select first_name as requested_by from employee_master where emp_id = requested_by),s.location_id source_id,d.location_id destination_id ,s.location_name source_name,d.location_name destination_name,company_id from purchase_requisition left join location s on s.location_id=source_location left join location d on  d.location_id=destination_location where  requisition_status!=68 order by requisition_number desc";
	public static String GET_REQUISITION_COMPANY_BASED = "select purchase_requisition_id,concat(requisition_number,'-',pr_request_number) as requisition_number,to_char(requisition_date,'DD/MM/YYYY')requisition_date,(select first_name as requested_by from employee_master where emp_id = requested_by),s.location_id source_id,d.location_id destination_id ,s.location_name source_name,d.location_name destination_name,company_id from purchase_requisition left join location s on s.location_id=source_location left join location d on  d.location_id=destination_location where  requisition_status!=68 and company_id = ? order by requisition_number desc";

	public static String GET_DEFAULT_VALUE = "select def_table_id,value from def_table  where form_field_id=(select form_field_id from form_field where form_field_id=?)";

	public static String INSERT_STOCK_HDR = "INSERT INTO stock_transfer(" + "     stock_transfer_number, stock_transfer_date, " + "   purchase_requisition_id,transport_Type,service_name,person_name,delivery_method,Status,stock_transfer_type,source_location,destination_location,company_id,issue_slip,issue_type)" + " VALUES (?, ?, ?,?, ?, ?, ?, ?,106,?,?,?,?,?)";

	public static String INSERT_STOCK_HDR_AUTO_ISSUE = "INSERT INTO stock_transfer(" + "     stock_transfer_number, stock_transfer_date, " + "   purchase_requisition_id,transport_Type,service_name,person_name,delivery_method,Status,stock_transfer_type,source_location,destination_location,company_id,issue_slip,issue_type)" + " VALUES (?, ?, ?,?, ?, ?, ?, ?,106,?,?,?,?,?)";

	public static String MAX_ID = "select max(stock_transfer_id) from stock_transfer where stock_transfer_number =?";

	public static String CHECK_REQUISITION_QTY = "select  coalesce(sum(quantity),0) from purchase_requisition_detail where purchase_requisition_id = ? ";

	public static String CHECK_STOCK_QTY = "select  coalesce(sum(quantity),0) from stock_transfer_detail std inner join stock_transfer st on st.stock_transfer_id = std.stock_transfer_id where purchase_requisition_id = ? ";

	public static String INSERT_STOCK_DTL = "INSERT INTO stock_transfer_detail( stock_transfer_id, purchase_requisition_detail_id, item_id," + "quantity, pending_qty,prquantity)" + "VALUES (?,?, ?, ?,?,?)";

	public static String INSERT_STOCK_HDR_KITCHEN = "INSERT INTO stock_transfer(" + "     stock_transfer_number, stock_transfer_date, " + "   transport_Type,service_name,person_name,delivery_method,Status,stock_transfer_type,source_location,destination_location,company_id,issue_slip,issue_type)" + " VALUES (?, ?, ?,?, ?, ?, ?,106,?,?,?,?,?) ";

	public static String INSERT_STOCK_DTL_KITCHEN = "INSERT INTO stock_transfer_detail( stock_transfer_id, purchase_requisition_detail_id, item_id," + "quantity, pending_qty,prquantity,purchase_requisition_number)" + "VALUES (?,?, ?, ?,?,?,?)";

	public static String UPDATE_PENDING_QTY_MR = "update purchase_requisition_detail set pending_quantity = ? where purchase_requisition_detail_id=?";

	public static final String issueStatus = "UPDATE purchase_requisition set  requisition_status= ? WHERE purchase_requisition_id = ?";

	public static String CHECK_QUANTITY = "select coalesce(sum(quantity),0) from stock_transfer_detail where purchase_requisition_detail_id = ?";

	public static String CHECK_QUANTITY_PQ = "select coalesce(sum(quantity),0) from purchase_quote_detail where purchase_requisition_id = ? and item_id = ? ";

	public static String MAX_Detail_ID = "select max(stock_transfer_detail_id) from stock_transfer_detail where stock_transfer_id =? and item_id=?";

	public static String STOCK_LEDGER = "INSERT INTO stock_ledger( " + " inventory_id, source_location, destination_location, " + " source_qty, destination_qty, doc_date,doc_type,doc_ref)" + "VALUES ( ?, ?, ?, " + "       ?, ?,?,?,?)";

	public static String INVENTORY = "INSERT INTO inventory( " + "   inventory_date,  location_id, " + " item_id,  quantity_available)" + " VALUES ( ?, ?, ?, ?)";

	public static String UPDATE_INVENTORY = "update inventory set      " + "   quantity_available=? where item_id=? and inventory_date=? and  location_id=? ";

	public static String INVENTORY_HAND_QUANTITY = "select CASE WHEN sum(quantity_available) IS NULL  THEN 0 ELSE sum(quantity_available) END  from inventory where location_id=? and item_id=? ";

	public static String INVENTORY_EXISTS = "select count(*)  from inventory where location_id=? and item_id=? ";

	public static String MAX_INVENTORY = "select max(inventory_id) from inventory where location_id=? and item_id=?";

	public static String GET_STOCK_NUMBER = "SELECT CASE WHEN MAX(stock_transfer_number) IS NULL  THEN 'STN0001' ELSE rpad(MAX(stock_transfer_number),3,'STN')|| " + " lpad(cast(cast((SUBSTRING(MAX(stock_transfer_number),4)) as int)+1  as text),4,'0') END as stacknumber " + " FROM stock_transfer where stock_transfer_number like  'STN%'";

	// ADD DESCRIPTION :
	// public static String LIST_DATA =
	// "select distinct stock_transfer_id,location_dest.location_name
	// dest_name,location_source.location_name
	// source_name,stock_transfer_number,"
	// +
	// " Status,def_table.value delivery_method,tran.value transport_type from
	// stock_transfer"
	// +
	// " left join purchase_requisition on
	// purchase_requisition.purchase_requisition_id=stock_transfer.purchase_requisition_id"
	// +
	// " left join location location_source on
	// location_source.location_id=purchase_requisition.source_location"
	// +
	// " left join location location_dest on
	// location_dest.location_id=purchase_requisition.destination_location"
	// + " left join def_table on def_table.def_table_id= delivery_method" +
	// " Left join def_table tran on tran.def_table_id= transport_type ";

	public static String LIST_DATA = "select distinct stock_transfer_id,location_dest.location_name dest_name,location_source.location_name source_name,stock_transfer_number,  Status,issue_slip,def_table.value delivery_method,tran.value transport_type , concat(requisition_number,'-',pr_request_number) as requisition_number , reqtype.value as reqType ,issue_type from stock_transfer  left join purchase_requisition on purchase_requisition.purchase_requisition_id=stock_transfer.purchase_requisition_id  left join location location_source  on location_source.location_id=stock_transfer.source_location left join location location_dest on location_dest.location_id=stock_transfer.destination_location  left join def_table on def_table.def_table_id= delivery_method  Left join def_table tran on tran.def_table_id= transport_type   Left join def_table reqtype on reqtype.def_table_id= purchase_requisition.request_type  ORDER by stock_transfer_id desc";

	public static String DELETE_HDR = "delete from stock_transfer where stock_transfer_id=?";

	public static String DELETE_DTL = "delete from stock_transfer_detail where stock_transfer_id=?";

	public static final String DELETE_STOCK_BATCH = "delete from stock_transfer_batch_detail where stock_transfer_detail_id=?";

	public static final String Print = "select stock_transfer_date as requisitionDate ,stock_transfer_number as stockNumber , service_name as serviceName,person_name as personName,stock.status as status,reason as reason ,l.location_name as sourceLocName ,c.company_name as companyId,concat(pr.requisition_number,'-',pr.pr_request_number) as prNumber,pr.requisition_number as requisitionNumber,pr.requisition_date as reqDate from stock_transfer stock left join  location l on stock.source_location=l.location_id  left join company c on stock.company_id=c.company_id left join  purchase_requisition pr on pr.purchase_requisition_id=stock.purchase_requisition_id   where stock_transfer_id=?";

	// public static final String PrintDTL =
	// "select concat(i.item_code,'-',i.item_name) as itemCode,prquantity as
	// prquantityn,quantity as quantityn,pending_qty as
	// pendingQuantity,coalesce(amount,0) as amount from stock_transfer_detail
	// dtl
	// join item i on i.item_id= dtl.item_id where stock_transfer_id=?";
	// public static final String PrintDTL =
	// "select concat(i.item_code,'-',i.item_name) as
	// itemCode,prd.item_desc,prquantity as prquantityn,dtl.quantity as
	// quantityn,pending_qty as pendingQuantity,coalesce(amount,0) as amount
	// from
	// stock_transfer_detail dtl join item_new i on i.item_id= dtl.item_id left
	// join
	// purchase_requisition_detail prd on prd.item_id=i.item_id where
	// stock_transfer_id=?";

	public static final String PrintDTL = "select concat(i.item_code,'-',i.item_name) as itemCode,prquantity as prquantityn,dtl.quantity as quantityn,pending_qty as pendingQuantity,coalesce(amount,0) as amount,(select coalesce(quantity,0) as originalQty  from purchase_requisition_detail  where purchase_requisition_detail_id = dtl.purchase_requisition_detail_id limit 1) from stock_transfer_detail dtl left join item_new i on i.item_id= dtl.item_id where stock_transfer_id=?";

	public static String DELETE_DETAIL_ID = "delete from stock_transfer_detail where stock_transfer_detail_id=?";

	public static String DELETE_LEDGE = "delete from stock_ledger where doc_ref=(select stock_transfer_number from stock_transfer where stock_transfer_id=? )";

	public static String EDIT_HDR = "SELECT stock_transfer_id,coalesce(st.company_id,'') companyId,company_name companyName,to_char(stock_transfer_date,'DD/MM/YYYY')  stock_transfer_date, purchase_requisition_id,  stock_transfer_number, transport_type, service_name, person_name,  delivery_method, st.status,issue_slip ,coalesce(issue_type,'0') as  issue_type ,(select value from def_table where def_table_id = issue_type::int ) issue_type_name  FROM stock_transfer st left join company c on st.company_id = c.company_id where stock_transfer_id=?";
	public static String EDIT_HDR_KITCHEN = "SELECT stock_transfer_id,coalesce(st.company_id,'') companyId,company_name as  companyName,to_char(stock_transfer_date,'DD/MM/YYYY')  stock_transfer_date, purchase_requisition_id,  stock_transfer_number, transport_type, service_name, person_name,  delivery_method, st.status,issue_slip ,coalesce(issue_type,'0') as  issue_type ,(select value from def_table where def_table_id = issue_type::int ) issue_type_name,(select location_name from location where location_id = source_location) as sourceLocName ,(select location_name from location where location_id = destination_location) as destLocName   FROM stock_transfer st left join company_master c on st.company_id = c.company_code where stock_transfer_id = ? ";

	public static String EDIT_DTL = "SELECT stock_transfer_detail_id, purchase_requisition_detail_id, item_id,  " + "   prquantity,quantity, stock_transfer_id, coalesce((select coalesce(quantity,0) as originalQty  from purchase_requisition_detail  where purchase_requisition_detail_id = stock_transfer_detail.purchase_requisition_detail_id limit 1),0) as originalQty " + " FROM stock_transfer_detail where stock_transfer_id=?";

	public static String EDIT_DTL_update = "SELECT stock_transfer_detail_id, purchase_requisition_detail_id, item_id,  " + "   quantity, stock_transfer_id" + " FROM stock_transfer_detail where stock_transfer_id=? and stock_transfer_detail_id=?";

	public static String UPDATE_STOCK_HDR = "UPDATE stock_transfer set  stock_transfer_date=?,   purchase_requisition_id=?,transport_Type=?,service_name=?,person_name=?,delivery_method=?,status=?,company_id=?,issue_slip=? , issue_type = ?  where stock_transfer_id=?";

	public static String UPDATE_STOCK_DTL = "UPDATE stock_transfer_detail set purchase_requisition_detail_id=?, item_id =?," + "quantity=? where stock_transfer_id=? and stock_transfer_detail_id=?";

	public static String UPDATE_STOCK_SOURCE = "update stock_ledger set  source_location=?,  " + " source_qty=? where doc_ref=? and inventory_id=?";

	public static String UPDATE_STOCK_DEST = "update stock_ledger set  destination_location=?,  " + " destination_qty=? where doc_ref=? and inventory_id=?";

	public static String GET_SOURCE_LEGE = "select sum(source_qty) source_qty,source_location,Inventory_id from stock_ledger where  doc_ref= " + "(select stock_transfer_number from stock_transfer where stock_transfer_id=?) group by source_location,Inventory_id ";

	public static String GET_DEST_LEGE = "select sum(destination_qty) destination_qty,destination_location,Inventory_id from stock_ledger where  doc_ref= " + "   (select stock_transfer_number from stock_transfer where stock_transfer_id=?) group by destination_location,Inventory_id ";

	public static String DELETE_INVOTORY_DATA = "update inventory set quantity_available=quantity_available-? where location_id=? and Inventory_id=?";

	public static String DELETE_INVOTORY_DATA_SO = "update inventory set quantity_available=quantity_available+? where location_id=? and Inventory_id=?";

	public static String GET_ALL_DELETE_STOCK = "select * from stock_transfer_detail where   stock_transfer_id=?";

	// For Asset

	public static String SAVE_STOCK_LEDGER_for_asset = "INSERT INTO stock_ledger( inventory_id, source_location, destination_location, source_qty, destination_qty, doc_date,doc_type,doc_ref) VALUES( ?, ?, ?,?,?,TO_DATE(?,'DD-MM-YY'),?,?) returning stock_ledger_id";

	public static String SAVE_Asset_LEDGER = "INSERT INTO asset_ledger(stock_ledger_id, source_location,destination_location, source_asset_track_id, destination_asset_track_id,doc_date, doc_type, doc_ref,asset_responsible,asset_user)  VALUES (?, ?, ?, ?, ?, TO_DATE(?,'DD-MM-YY'), ?,?,?,?)";

	// For Excel Import

	public static String getPRNUmber = "select purchase_requisition_id from purchase_requisition where requisition_number = ?";

	public static String GET_ITEM_CODE_FOR_EXCEL_IMPORT = "select coalesce(quantity,0) as originalQty, item.item_id,item.item_id as id,concat(item.item_code,' - ',item.item_name) as text , " + "item_code,item_name,item_desc,quantity,coalesce(pending_quantity,0) as pending_quantity,uom.uom as uom,purchase_requisition_detail_id, coalesce(ga.batch_no,false) as isBatchNoExist " + "from purchase_requisition_detail " + "left join item_new item on item.item_id=purchase_requisition_detail.item_id " + "left join uom on uom.uom_id=item.uom "
			+ "left join item_grn_attribute ga on ga.item_id = item.item_id " + "where purchase_requisition_id=? and  item_name=?";

	public static String GET_REQUISITION_FOR_EXCEL_IMPORT = "select purchase_requisition_id,concat(requisition_number,'-',pr_request_number) as requisition_number,to_char(requisition_date,'DD/MM/YYYY')requisition_date,(select first_name as requested_by from employee_master where emp_id = requested_by),s.location_id source_id,d.location_id destination_id ,s.location_name source_name,d.location_name destination_name,company_id from purchase_requisition left join location s on s.location_id=source_location left join location d on  d.location_id=destination_location where  requisition_status!=68 and requisition_number = ? order by requisition_number desc";

	public static String getDtlList = "" + "select coalesce(quantity,0) as originalQty, item.item_id,item.item_id as id,concat(item.item_code,' - ',item.item_name) as text ,  item_code, item_name, "
			+ "item_desc,quantity ,coalesce(pending_quantity,0) as pending_quantity ,uom.uom as uom, purchase_requisition_detail_id,  pr.company_id, concat(pr.requisition_number,'-',pr.pr_request_number)  as requisitionNo   from purchase_requisition_detail prd  left join purchase_requisition pr on pr.purchase_requisition_id = prd.purchase_requisition_id	left join item_new item on item.item_id=prd.item_id left join uom on uom.uom_id=item.uom left join item_grn_attribute ga on ga.item_id = item.item_id where item.item_id = ? and prd.pending_quantity != 0 and pr.destination_location = ? and pr.company_id = ? "
			+ "order by requisition_date, pr.purchase_requisition_id limit 1";

	public static String getRequestID = "select purchase_requisition_id from purchase_requisition_detail  where purchase_requisition_detail_id = ?";

	// public static String getQTY_FROM_REQUEST =
	// "select case when coalesce(pending_qty,0) = 0 then prd.quantity else
	// coalesce(pending_qty,0) end from purchase_requisition_detail prd left
	// join
	// stock_transfer_detail std on prd.purchase_requisition_detail_id =
	// std.purchase_requisition_detail_id where
	// prd.purchase_requisition_detail_id =
	// ? order by stock_transfer_detail_id desc limit 1";
	public static String getQTY_FROM_REQUEST = "select prd.quantity from purchase_requisition_detail prd left join stock_transfer_detail std on prd.purchase_requisition_detail_id  = std.purchase_requisition_detail_id where prd.purchase_requisition_detail_id =  ? order by stock_transfer_detail_id desc limit 1";

	public static String getRequest_HDR_ID = "select count(*) from stock_transfer where purchase_requisition_id  = ?";

	public static String GET_LIST = "select (select concat(requisition_number, '-', pr_request_number) from purchase_requisition where purchase_requisition_id = prd.purchase_requisition_id limit 1) as requestNumber, purchase_requisition_detail_id as requsitionDtlId,prd.purchase_requisition_id as requsitionId  ,COALESCE(pending_quantity,0.0) as pendingQuantity from purchase_requisition_detail prd left join purchase_requisition pr on pr.purchase_requisition_id = prd.purchase_requisition_id where item_id = ? and requisition_status not in (33,214) and  pr.destination_location = ?  and pr.company_id = ? order by prd.purchase_requisition_id  asc";

	public static String getIssueType = "select coalesce(issue_type::int,0) from stock_transfer   where stock_transfer_id = ?";

	public static String EDIT_DTL_KITCHEN = "SELECT stock_transfer_detail_id, purchase_requisition_detail_id, stock_transfer_detail.item_id,  concat(item.item_code,' - ',item.item_name) as item_name ,  prquantity,quantity, stock_transfer_id, (select coalesce(quantity,0) as originalQty  from purchase_requisition_detail  where purchase_requisition_detail_id = stock_transfer_detail.purchase_requisition_detail_id limit 1) ,uom.uom as uom, purchase_requisition_number as requestNumber FROM stock_transfer_detail  left join item_new item on item.item_id=stock_transfer_detail.item_id left join uom on uom.uom_id=item.uom   where stock_transfer_id=?";

	public static String GET_REQUISITION_NUMBER_LIST = "select string_agg(purchase_requisition_number,',') from stock_transfer_detail where stock_transfer_id = ?";

	public static String GET_PENDING_QTY = "select coalesce(pending_qty,0) from stock_transfer_detail where purchase_requisition_detail_id = ? order by stock_transfer_detail_id  desc limit 1 ";

	public static String Check_ST = "select count(*) from stock_transfer_detail where purchase_requisition_detail_id = ?";

	public static String GET_PENDING_QTY1 = "select coalesce(quantity,0) from stock_transfer_detail where item_id = ? order by stock_transfer_detail_id  desc limit 1 ";

	public static String Check_ST1 = "select  COUNT(*) as a from stock_transfer_detail where item_id = ? ";

	public static String GET_STOCK_DETAIL_QTY = "select coalesce(sum(std.quantity),0) from purchase_requisition_detail prd left join stock_transfer_detail std on prd.purchase_requisition_detail_id  = std.purchase_requisition_detail_id where prd.purchase_requisition_detail_id =  ? ";

	public static String ITEM_NEW_COUNT = "select count(*) from item_new where item_id = ?";

	public static String ITEM_CURRENT_QTY = "select COALESCE(current_qty,0) from item_new where item_id  = ?";
}
