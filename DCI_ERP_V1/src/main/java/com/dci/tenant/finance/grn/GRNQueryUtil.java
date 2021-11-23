package com.dci.tenant.finance.grn;

public class GRNQueryUtil {

	public static final String GET_LOCATION_LIST = "select location_id as id,location_name as text,location_id locID,location_name locName from location order by location_name";

	public static final String GET_VENDOR_LIST = "select entity_id as id,entity_name as text,entity_id vendorId,entity_name vendorName,supplier_acct_code vendorCode from entity where is_vendor = true order by entity_name";

	// public static final String GET_PO_LIST =
	// "select purchase_order_id as id,po.location_id as locId,
	// purchase_order_no as text, value poType,po.vendor_id
	// vendorId,po.company_id companyId,stock_transfer_number
	// conTransferNo,coalesce(freight,0) poFreight,en.vendor_location as
	// sourceLocationId from purchase_order po left join def_table def on
	// def.def_table_id = po.purchase_type left join stock_transfer st on
	// st.stock_transfer_id = po.consignment_transfer_id left join entity en on
	// en.entity_id = po.vendor_id where po_status in (?, ?) and po.company_id =
	// ? order by purchase_order_no desc";

	// public static final String GET_PO_LIST =
	// "select purchase_order_id as id,po.location_id as locId,
	// purchase_order_no as text, value poType,po.vendor_id
	// vendorId,po.company_id companyId,stock_transfer_number
	// conTransferNo,location_id as sourceLocationId,coalesce(freight,0)
	// poFreight from purchase_order po left join def_table def on
	// def.def_table_id = po.purchase_type left join stock_transfer st on
	// st.stock_transfer_id = po.consignment_transfer_id where po_status in (?,
	// ?) and po.company_id = ? order by purchase_order_no desc";
	public static final String GET_PO_LIST = "select purchase_order_id as id,po.location_id as locId, purchase_order_no as text, value poType, en.entity_id  vendorId,po.company_id companyId,stock_transfer_number conTransferNo,location_id as sourceLocationId,coalesce(freight,0) poFreight,remarks_othercharges as remarksforother,COALESCE(freight,0) as freight,COALESCE(other_charges,0) as otherCharges  from purchase_order po left join def_table def on def.def_table_id = po.purchase_type left join stock_transfer st on st.stock_transfer_id = po.consignment_transfer_id left join entity en on  en.supplier_acct_code = po.vendor_id  where po_status in (?, ?)  order by purchase_order_id desc";
	// for user rights cmpany
	// public static final String GET_PO_LIST =
	// "select purchase_order_id as id,po.location_id as locId,
	// purchase_order_no as text, value poType, en.entity_id
	// vendorId,po.company_id companyId,stock_transfer_number
	// conTransferNo,location_id as sourceLocationId,coalesce(freight,0)
	// poFreight from purchase_order po left join def_table def on
	// def.def_table_id = po.purchase_type left join stock_transfer st on
	// st.stock_transfer_id = po.consignment_transfer_id left join entity en on
	// en.supplier_acct_code = po.vendor_id where po_status in (?, ?) and
	// po.company_id = ? order by purchase_order_no desc";

	// public static final String GET_PO_LIST_COM_BASED =
	// "select purchase_order_id as id,po.location_id as locId,
	// purchase_order_no as
	// text, value poType, en.entity_id vendorId,po.company_id
	// companyId,stock_transfer_number conTransferNo,location_id as
	// sourceLocationId,coalesce(freight,0) poFreight from purchase_order po
	// left
	// join def_table def on def.def_table_id = po.purchase_type left join
	// stock_transfer st on st.stock_transfer_id = po.consignment_transfer_id
	// left
	// join entity en on en.supplier_acct_code = po.vendor_id where po_status in
	// (?,
	// ?) and po.company_id = ? and po.vendor_id =(select supplier_acct_code
	// from
	// entity where entity_id = ?) and (po.request_type !='WO' or
	// po.request_type is
	// null) order by purchase_order_no desc";
	public static final String GET_PO_LIST_COM_BASED = "select po.purchase_order_id as id,po.location_id as locId, purchase_order_no as text, value poType, en.entity_id vendorId,po.company_id companyId,stock_transfer_number conTransferNo,location_id as sourceLocationId,coalesce(freight,0) poFreight from purchase_order po left join def_table def on def.def_table_id = po.purchase_type left join stock_transfer st on st.stock_transfer_id = po.consignment_transfer_id left join entity en on en.supplier_acct_code = po.vendor_id where po.po_status in (?, ?) and po.company_id = ? and po.vendor_id =(select supplier_acct_code from entity where entity_id = ?) and (po.request_type !='WO' or po.request_type is null) and ((select sum(quantity) from purchase_order_detail where purchase_order_id = po.purchase_order_id) > coalesce((select sum(grn_detail.quantity) from grn left join grn_detail on grn_detail.grn_id = grn.grn_id where grn.Purchase_order_id = po.purchase_order_id),0)) and  purchase_order_no  not in ( select distinct po_amendment from purchase_order where null_or_empty(po_amendment) = false ) order by purchase_order_no desc";

	public static final String GET_PO_EDIT_LIST = "select purchase_order_id as id,purchase_order_no as text,po.location_id as locId,value poType,stock_transfer_number conTransferNo from purchase_order po  left join def_table def on def.def_table_id = po.purchase_type left join stock_transfer st on st.stock_transfer_id = po.consignment_transfer_id order by purchase_order_no desc";

	/*
	 * public static final String GET_PO_DTL_LIST =
	 * "select pod.purchase_order_detail_id dtlPODtlId,pod.cost_center as costcenter,pod.cost_center as costcenter, po.purchase_order_id poId,po.purchase_order_no poNo ,to_char(po.purchase_date,'dd/mm/yyyy') poDate,pod.item_id dtlItemId, coalesce(pod.quantity,0) dtlQty,coalesce(pod.unit_price,0) dtlPrice, itm.item_code dtlItemCode,itm.item_name dtlItemName,pqd.item_description dtlItemDesc, case when quality_check is null then false  else quality_check end qualityCheck,coalesce(pod.discount,0) dtlDisc,coalesce(pod.tax_Amount,0) dtlTax,coalesce(pqd.vendor_uom,0) dtlUom,coalesce(pod.quantity,0) receivedQty, coalesce((coalesce(pod.quantity,0)-coalesce(grnQty.qty,0)),0) pendingQty,pod.quantity as originalConvertedQty,coalesce(pqd.purchase_quantity,0) as purReqQuantity,coalesce(pqd.quantity,0) as vendorQuantity , case when itm.is_auto = true then 'Y' else 'N' end as autoIssue, pred.purchase_requisition_detail_id as reqDetailId,  coalesce(ga.batch_no,'0') as batchNoExist,coalesce(pod.discount,0) discountAmount, coalesce(pod.tax_cgst,0) as taxCGST, coalesce(pod.tax_sgst,0) as taxSGST, coalesce(pod.tax_igst,0) as taxIGST, coalesce(pod.tax_cgst_percent,0) as taxCGSTinPercent, coalesce(pod.tax_sgst_percent,0) as taxSGSTinPercent, coalesce(pod.tax_igst_percent,0) as taxIGSTinPercent ,coalesce(pod.discount_type,0) as discountType , coalesce(pod.discount_percent,0) as discountPercentage, coalesce(pod.purchase_uom,0)::text as purchaseUOM, coalesce(pod.purchase_qty,0) as purchaseQty , (select uom from uom where uom_id = pod.purchase_uom limit 1)  as purchaseUOMName,case when null_or_empty(pod.vendor_uom::text) = false then coalesce(pod.vendor_uom,0) else  coalesce(pqd.vendor_uom) end  as vendorUOM, coalesce(pod.quantity,0) as vendorQty , (select uom from uom where uom_id = case when null_or_empty(pod.vendor_uom::text) = false then coalesce(pod.vendor_uom,0) else  coalesce(pqd.vendor_uom,0) end  limit 1)  as vendorUOMName   from purchase_order po inner join purchase_order_detail pod on po.purchase_order_id = pod.purchase_order_id inner join item_new itm on pod.item_id = itm.item_id left join item_category itc on itm.item_category = itc.item_category_id  left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id left join purchase_requisition prd on prd.purchase_requisition_id = pqd.purchase_requisition_id left join item_grn_attribute ga on ga.item_id = itm.item_id left join purchase_requisition_detail pred  on pred.purchase_requisition_id = prd .purchase_requisition_id  left join (select  grn.item_id, grn.qty,pd.purchase_order_id,grn.purchase_order_detail_id from (select item_id,sum(quantity) qty,purchase_order_detail_id from grn_detail group by item_id,purchase_order_detail_id having purchase_order_detail_id in (select purchase_order_detail_id from purchase_order_detail where purchase_order_id =?)) grn left join purchase_order_detail pd on grn.purchase_order_detail_id = pd.purchase_order_detail_id) grnQty on grnQty.purchase_order_detail_id = pod.purchase_order_detail_id where pod.po_status in (72,144,143) and pred.Item_id = pqd.item_id and po.purchase_order_id =? order by pod.purchase_order_detail_id asc"
	 * ;
	 */
	public static final String GET_PO_DTL_LIST = "select coalesce(convertedQtyNew,0) as convertedQtyNew,coalesce(convertedQtyNew,0) as conqty,case when coalesce(balanceconvertedQtyNew,0)= 0 then coalesce(pod.purchase_qty,0) else coalesce(balanceconvertedQtyNew,0) end as balanceconvertedQtyNew,pod.purchase_order_detail_id dtlPODtlId,pod.cost_center as costcenter,pod.cost_center as costcenter, po.purchase_order_id poId,po.purchase_order_no poNo ,to_char(po.purchase_date,'dd/mm/yyyy') poDate,pod.item_id dtlItemId, coalesce(pod.quantity,0) dtlQty,coalesce(pod.unit_price,0) dtlPrice, itm.item_code dtlItemCode,itm.item_name dtlItemName,pqd.item_description dtlItemDesc, case when quality_check is null then false  else quality_check end qualityCheck,coalesce(pod.discount,0) dtlDisc,coalesce(pod.tax_Amount,0) dtlTax,coalesce(pqd.vendor_uom,0) dtlUom,coalesce(pod.quantity,0) receivedQty, coalesce((coalesce(pod.quantity,0)-coalesce(grnQty.qty,0)),0) pendingQty,pod.quantity as originalConvertedQty,coalesce(pqd.purchase_quantity,0) as purReqQuantity,coalesce(pqd.quantity,0) as vendorQuantity , case when itm.is_auto = true then 'Y' else 'N' end as autoIssue, pred.purchase_requisition_detail_id as reqDetailId,  coalesce(ga.batch_no,'0') as batchNoExist,coalesce(pod.discount,0) discountAmount, coalesce(pod.tax_cgst,0) as taxCGST, coalesce(pod.tax_sgst,0) as taxSGST, coalesce(pod.tax_igst,0) as taxIGST, coalesce(pod.tax_cgst_percent,0) as taxCGSTinPercent, coalesce(pod.tax_sgst_percent,0) as taxSGSTinPercent, coalesce(pod.tax_igst_percent,0) as taxIGSTinPercent ,coalesce(pod.discount_type,0) as discountType , coalesce(pod.discount_percent,0) as discountPercentage, coalesce(pod.purchase_uom,0)::text as purchaseUOM, coalesce(pod.purchase_qty,0) as purchaseQty , (select uom from uom where uom_id = pod.purchase_uom limit 1)  as purchaseUOMName,case when null_or_empty(pod.vendor_uom::text) = false then coalesce(pod.vendor_uom,0) else  coalesce(pqd.vendor_uom) end  as vendorUOM, coalesce(pod.quantity,0) as vendorQty , (select uom from uom where uom_id = case when null_or_empty(pod.vendor_uom::text) = false then coalesce(pod.vendor_uom,0) else  coalesce(pqd.vendor_uom,0) end  limit 1)  as vendorUOMName   from purchase_order po inner join purchase_order_detail pod on po.purchase_order_id = pod.purchase_order_id inner join item_new itm on pod.item_id = itm.item_id left join item_category itc on itm.item_category = itc.item_category_id  left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id left join purchase_requisition prd on prd.purchase_requisition_id = pqd.purchase_requisition_id left join item_grn_attribute ga on ga.item_id = itm.item_id left join purchase_requisition_detail pred  on pred.purchase_requisition_id = prd .purchase_requisition_id  left join (select  grn.item_id, grn.qty,pd.purchase_order_id,grn.purchase_order_detail_id,coalesce(convertedQtyNew,0) as convertedQtyNew,coalesce(balanceconvertedQtyNew,0) as balanceconvertedQtyNew from (select item_id,sum(quantity) qty,purchase_order_detail_id,sum(coalesce(converted_quantity_new,0)) as convertedQtyNew,sum(coalesce(converted_balance_quantity_new,0)) balanceconvertedQtyNew from grn_detail group by item_id,purchase_order_detail_id having purchase_order_detail_id in (select purchase_order_detail_id from purchase_order_detail where purchase_order_id =?)) grn left join purchase_order_detail pd on grn.purchase_order_detail_id = pd.purchase_order_detail_id) grnQty on grnQty.purchase_order_detail_id = pod.purchase_order_detail_id where pod.po_status in (72,144,143) and pred.Item_id = pqd.item_id and po.purchase_order_id =? order by pod.purchase_order_detail_id asc";

	public static final String SAVE_GRN_HDR = "INSERT INTO grn(grn_number, grn_date, purchase_order_id, purchase_requisition_id,entity_id, vendor_delivery_order_no, vendor_delivery_order_date,"
			+ " vendor_invoice_no, vendor_invoice_date, delivery_method, mode_of_transport,location_id,dest_location_id,qc_location_id,company_id,invoice_due_date,description,freight ,other_charges,created_by, created_date) VALUES (?, TO_DATE(?,'DD-MM-YY'), ?, ?, ?,?, TO_DATE(?,'DD-MM-YY'), ?, TO_DATE(?,'DD-MM-YY'), ?, ?,?,?,?,?,TO_DATE(?,'DD-MM-YY'),?,?,?,?,now()) returning grn_id";

	public static final String SAVE_GRN_DTL = "INSERT INTO grn_detail(grn_id, item_id,cost_center, quantity, pending_qty,converted_quantity,purchase_order_detail_id,converted_quantity_new,converted_quantity_flag,converted_balance_quantity_new) VALUES (?,?,?,?,?,?,?,?,?,?) returning grn_detail_id ";

	public static final String GRN_AUTO_GENERATE = "SELECT CASE WHEN MAX(grn_number) IS NULL  THEN 'GRN0001' ELSE rpad(MAX(grn_number),3,'GRN')|| lpad(cast(cast((SUBSTRING(MAX(grn_number),4)) as int)+1  as text),4,'0') END FROM grn";

	public static final String GRN_REQUISITION = "select purchase_requisition_id poRequisitionId,concat(requisition_number,'-',pr_request_number) poRequisition,to_char(requisition_date,'dd/mm/yyyy') poRequisitionDate from purchase_requisition where purchase_requisition_id in (select purchase_requisition_id from purchase_quote_detail where purchase_quote_detail_id in (select distinct podtl.purchase_quote_detail_id from purchase_order_detail podtl where podtl.purchase_order_id =?))";

	public static final String GRN_REQ_DTL = "select po.purchase_requisition_id poId,po.requisition_number poNo ,to_char(requisition_date,'dd/mm/yyyy') poDate,pod.item_id dtlItemId, coalesce(pod.quantity,0) dtlQty,itm.item_code dtlItemCode,itm.item_name dtlItemName,itm.item_description dtlItemDesc,coalesce(itm.uom,0) dtlUom from purchase_requisition po inner join purchase_requisition_detail pod on po.purchase_requisition_id = pod.purchase_requisition_id left join item_new itm on pod.item_id = itm.item_id where po.purchase_requisition_id in (select distinct purchase_requisition_id from purchase_quote_detail where purchase_quote_detail_id in (select distinct podtl.purchase_quote_detail_id from purchase_order_detail podtl where podtl.purchase_order_id =?))";

	public static final String GRN_LIST = "select grn_number grnCode,to_char(grn_date,'dd/mm/yyyy') grnDate,entity_name vendorName,purchase_order_no poNo,purchase_requisition_id poRequisition,g.purchase_order_id poId,coalesce(po.purchase_type ,0) as purchaseType, (select first_name from employee_master where emp_id = g.created_by limit 1) as preparedBy from grn g left join entity en on g.entity_id = en.entity_id left join purchase_order po on g.purchase_order_id = po.purchase_order_id order by grn_number desc";

	public static final String GRN_LIST2 = "select grn_number grnCode ,to_char(g.created_date,'dd/mm/yyyy') createdDate,purchase_order_no poNo,to_char(grn_date,'dd/mm/yyyy') grnDate,def.value poType,company_name as companyId,purchase_requisition_id poRequisition,entity_name vendorName,  mode_of_transport transMode,(select concat(address.street,', ',city.city_name,' - ', state.state_code,', ', state.state_name,' - ', city.pincode,', ', country.country_name) as address from entity left join location on location.location_id = entity.vendor_location left join address on address.address_id = entity.address_id left join city on city.city_id = address.city_id left join state on state.state_code = city.state_code left join country on country.country_code = state.country_code where entity_id=(select entity_id from entity where  entity_id=g.entity_id limit 1)) as vendorAddress,vendor_invoice_no invoiceNo, to_char(vendor_invoice_date,'dd/mm/yyyy') invoiceDate,to_char(invoice_due_date,'DD/MM/YYYY')  as dueDate,loc.location_name locName,dloc.location_name dstLocName,to_char(vendor_delivery_order_date,'dd/mm/yyyy') delOrderDate,vendor_delivery_order_no delOrderNo,description as description, "
			+ "g.purchase_order_id poId,  coalesce(po.purchase_type ,0) as purchaseType, (select first_name from employee where employee_id = g.created_by limit 1) as preparedBy   from grn g left join entity en on g.entity_id = en.entity_id left join purchase_order po on g.purchase_order_id = po.purchase_order_id "
			+ " left join def_table def on def.def_table_id = po.purchase_type inner join company c on c.company_id = g.company_id inner join location loc on loc.location_id = g.location_id inner join location dloc on dloc.location_id = g.dest_location_id " + "order by grn_number desc";
	/*
	 * public static final String GET_VENDOR_ADDRESS =
	 * "select coalesce(vendor_location,0) vendorLoc,street as address,city_name as city ,"
	 * +
	 * " state.state_name as state,country_name as country,pincode as zipCode from entity "
	 * + " left join address on address.address_id = entity.address_id " +
	 * " left  join city on city.city_id = address.city_id " +
	 * " left join state on state.state_code = city.state_code " +
	 * " left join country on country.country_code =  state.country_code where is_vendor = true and entity_id=?"
	 * ;
	 */
	
	public static final String GET_VENDOR_ADDRESS ="select coalesce(vendor_location,0) vendorLoc,street as address,cty_nam as city , state.stt_nam as state,cntry_nam as country,zp_cd as zipCode from entity  left join address on address.address_id = entity.address_id\r\n"
			+ "  left  join city on city.cty_id = address.city_id  left join state on state.stt_id = city.stt_id  left join country on country.cntry_id =  state.cntry_id\r\n"
			+ "where is_vendor = true and entity_id=? ";
	
	public static final String GET_GRN_HDR =  "select grn_id grnId,grn_number grnCode,coalesce(grn.company_id,'') companyId, to_char(grn_date,'dd/mm/yyyy') grnDate, grn.purchase_order_id as poId,po.purchase_order_no poNo, CASE WHEN po_amendment IS NULL THEN '' ELSE po_amendment END  as poAmendNo, st.stock_transfer_number as conTransferNo, grn.purchase_requisition_id poRequisitionId,grn.purchase_requisition_id poRequisition, en.entity_id  vendorId, en.entity_name vendorName ,vendor_delivery_order_no delOrderNo, to_char(vendor_delivery_order_date,'dd/mm/yyyy') delOrderDate, vendor_invoice_no invoiceNo, to_char(vendor_invoice_date,'dd/mm/yyyy') invoiceDate, grn.delivery_method deliveryMthd, mode_of_transport transMode,grn.location_id locId,loc.location_name locName, coalesce(grn.qc_location_id,0) qcLocationId,qloc.location_name qcLocationName, coalesce(grn.dest_location_id,0) dstLocId,dloc.location_name dstLocName, def.value poType, coalesce(grn_status,0) grnStatus,to_char(invoice_due_date,'DD/MM/YYYY')  as dueDate ,remarks_othercharges as remarksforother,COALESCE(po.freight,0) as freight,COALESCE(po.other_charges,0) as otherCharges,company_name as entity, (select entity_name from entity where entity_id= grn.entity_id) as vendorName,(select concat(address.street,', ',city.cty_nam,' - ', state.stt_cd,', ', state.stt_nam,' - ', city.zp_cd,', ', country.cntry_nam) as address from entity left join location on location.location_id = entity.vendor_location left join address on address.address_id = entity.address_id left join city on city.cty_id = address.city_id left join state on state.stt_id = city.stt_id left join country on country.cntry_id = state.cntry_id where entity_id=(select entity_id from entity where  entity_id=grn.entity_id limit 1)) as address  , (select contact_mobile from entity where entity_id=grn.entity_id) as vendorPhone  , (select project_name from budget_definition where budget_definition_id = po.budget_type_id),(select first_name from  employee_master employee where emp_id = grn.created_by ),COALESCE(grn.freight,0) as grnfreight ,COALESCE(grn.other_charges,0) as grnOtherCharnge from grn grn  inner join purchase_order po on po.purchase_order_id = grn.purchase_order_id  left join stock_transfer st on st.stock_transfer_id=po.consignment_transfer_id inner join location loc on loc.location_id = grn.location_id inner join location dloc on dloc.location_id = grn.dest_location_id  left join location qloc on qloc.location_id = grn.qc_location_id left join def_table def on def.def_table_id = po.purchase_type  inner join entity en on grn.entity_id = en.entity_id inner join company_master c on c.company_code = grn.company_id  where grn.grn_number =?";
	public static final String GET_GRN_HDR_PRINT =  "select grn_id grnId,grn_number grnCode,coalesce(grn.company_id,'') companyId, to_char(grn_date,'dd/mm/yyyy') grnDate, grn.purchase_order_id as poId,po.purchase_order_no poNo,CASE WHEN po_amendment IS NULL THEN '' ELSE po_amendment END  as poAmendNo, st.stock_transfer_number as conTransferNo, grn.purchase_requisition_id poRequisitionId,grn.purchase_requisition_id poRequisition, en.entity_id  vendorId, en.entity_name vendorName ,vendor_delivery_order_no delOrderNo, to_char(vendor_delivery_order_date,'dd/mm/yyyy') delOrderDate, vendor_invoice_no invoiceNo, to_char(vendor_invoice_date,'dd/mm/yyyy') invoiceDate, grn.delivery_method deliveryMthd, mode_of_transport transMode,grn.location_id locId,loc.location_name locName, coalesce(grn.qc_location_id,0) qcLocationId,qloc.location_name qcLocationName, coalesce(grn.dest_location_id,0) dstLocId,dloc.location_name dstLocName, def.value poType, coalesce(grn_status,0) grnStatus,to_char(invoice_due_date,'DD/MM/YYYY')  as dueDate ,remarks_othercharges as remarksforother,COALESCE(po.freight,0) as freight,COALESCE(freight_amount,0) as freightAmount,COALESCE(freight_tax,0) as freightTax,COALESCE(po.other_charges,0) as otherCharges,company_name as entity, (select entity_name from entity where entity_id= grn.entity_id) as vendorName,(select concat(address.street,', ',city.cty_nam,' - ', state.stt_cd,', ', state.stt_nam,' - ', city.zp_cd,', ', country.cntry_nam) as address from entity left join location on location.location_id = entity.vendor_location left join address on address.address_id = entity.address_id left join city on city.cty_id = address.city_id left join state on state.stt_id = city.stt_id left join country on country.cntry_id = state.cntry_id where entity_id=(select entity_id from entity where  entity_id=grn.entity_id limit 1)) as address  , (select contact_mobile from entity where entity_id=grn.entity_id) as vendorPhone  , (select project_name from budget_definition where budget_definition_id = po.budget_type_id),(select first_name from  employee_master employee where emp_id = grn.created_by ),remarks,remarks_othercharges,(select case when email is null then 'null' else email end from entity where entity_id=grn.entity_id) as vendorEmail ,COALESCE(grn.freight,0) as grnfreight,COALESCE(grn.other_charges,0) as grnOtherCharnge from grn grn  inner join purchase_order po on po.purchase_order_id = grn.purchase_order_id  left join stock_transfer st on st.stock_transfer_id=po.consignment_transfer_id inner join location loc on loc.location_id = grn.location_id inner join location dloc on dloc.location_id = grn.dest_location_id  left join location qloc on qloc.location_id = grn.qc_location_id left join def_table def on def.def_table_id = po.purchase_type  inner join entity en on grn.entity_id = en.entity_id inner join company_master c on c.company_code = grn.company_id  where grn.grn_number =?";

	public static final String GET_GRN_DTL = "select grn_id grnId, grn.grn_detail_id grnDtlId,grn.cost_center as costcenter,grn.item_id dtlItemId, coalesce(grn.quantity,0) dtlQty,coalesce(grn.pending_qty,0) pendingQty,coalesce(grn.quantity,0) dtlQty, " + "coalesce(grn.pending_qty,0) pendingQty,grn.purchase_order_detail_id dtlPODtlId,coalesce(pqd.quantity,0) vendorQuantity,coalesce(pqd.purchase_quantity,0) purchaseQuantity, " + "coalesce(pod.unit_price,0) dtlPrice,itm.item_code dtlItemCode,itm.item_name dtlItemName,pqd.item_description dtlItemDesc, "
			+ "case when quality_check is null then false else quality_check end qualityCheck, " + "coalesce(itm.uom,0) dtlUom,coalesce(sample_qty,0) sampleQty, " + "coalesce(qc_status,0) qcStatus,qc_remarks qcRemarks,coalesce(status,0) dtlStatus,qc_status as status, "
			+ "coalesce(grn.converted_quantity_new,0) convertedQty ,coalesce(pod.discount,0) discountAmount,coalesce(pod.tax_cgst,0) as taxCGST,coalesce(pod.tax_sgst,0) as taxSGST,coalesce(pod.tax_igst,0) as taxIGST,coalesce(pod.tax_cgst_percent,0) as taxCGSTinPercent,coalesce(pod.tax_sgst_percent,0) as taxSGSTinPercent,coalesce(pod.tax_igst_percent,0) as taxIGSTinPercent,coalesce(pod.discount_type,0) as discountType,coalesce(pod.discount_percent,0) as discountPercentage ,pod.quantity as originalConvertedQty , coalesce(grn.converted_quantity_new,0) as cnvtQty  from grn_detail grn "
			+ "left join purchase_order_detail pod on grn.purchase_order_detail_id = pod.purchase_order_detail_id " + "left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id " + "left join purchase_quote pq on pq.purchase_quote_id = pqd.purchase_quote_detail_id " + "left join item_new itm on grn.item_id = itm.item_id " + "left  join item_category itc on itm.item_category = itc.item_category_id " + "where grn_id=(select grn_id from grn where grn_number =? ) " + "order by grn.grn_detail_id";

	public static final String UPDATE_GRN = "UPDATE grn SET grn_date=TO_DATE(?,'DD-MM-YY'), purchase_requisition_id=?, entity_id=?, vendor_delivery_order_no=?, vendor_delivery_order_date=TO_DATE(?,'DD-MM-YY'), vendor_invoice_no=?, vendor_invoice_date=TO_DATE(?,'DD-MM-YY'), delivery_method=?, mode_of_transport=?, purchase_order_id=?, location_id=?,dest_location_id=?,qc_location_id=?,company_id=? WHERE grn_number=?";

	public static final String UPDATE_GRN_DTL = "UPDATE grn_detail SET item_id=?, quantity=?, pending_qty=?, purchase_order_detail_id=?,lot_no=?, expiry_date=TO_DATE(?,'DD-MM-YY'), manufacturer=?, mrp_price=? WHERE grn_detail_id=?";

	public static final String DELETE_GRN_DTL = "Delete from grn_detail where grn_id=?";

	public static final String DELETE_GRN = "Delete from grn where grn_id=?";

	public static final String GET_GRN_ID = "Select grn_id from grn where grn_number = ?";

	public static final String GET_PO_LIST_WITH_ID = "select purchase_order_id as id,purchase_order_no as text, value poType,stock_transfer_number conTransferNo,coalesce(freight,0) poFreight from purchase_order po left join def_table def on def.def_table_id = po.purchase_type left join stock_transfer st on st.stock_transfer_id = po.consignment_transfer_id where po.vendor_id = (select supplier_acct_code from entity where entity_id = ?) and po_status in (?,?,?) order by purchase_order_no desc";

	public static final String UPDATE_PO_STATUS = "update purchase_order set po_status =? where purchase_order_id =?";

	public static final String GET_PO_STATUS = "select min(po_status) from purchase_order_detail where purchase_order_id =?";

	public static final String UPDATE_PO_DTL_STATUS = "update purchase_order_detail set po_status =? where purchase_order_detail_id =?";

	public static String UPDATE_INVENTORY = "update inventory set inventory_date=TO_DATE(?,'DD-MM-YY'), quantity_available=? where item_id=? and location_id=? ";

	public static String SAVE_INVENTORY = "INSERT INTO inventory( inventory_date, location_id, item_id,quantity_available) VALUES( TO_DATE(?,'DD-MM-YY'), ?, ?, ?)";

	public static String SAVE_STOCK_LEDGER = "INSERT INTO stock_ledger( inventory_id, source_location, destination_location, source_qty, destination_qty, doc_date,doc_type,doc_ref) VALUES( ?, ?, ?,?,?,TO_DATE(?,'DD-MM-YY'),?,?)";

	public static String SAVE_STOCK_LEDGER_NEW = "INSERT INTO stock_ledger( inventory_id, source_location, destination_location, source_qty, destination_qty, doc_date,doc_type,doc_ref) VALUES( ?, ?, ?,?,?,TO_DATE(?,'DD-MM-YY'),?,?) returning stock_ledger_id";

	public static String SAVE_STOCK_LEDGER_BATCH = "INSERT INTO stock_ledger_detail(stock_ledger_id, item_id, batch_no, batch_qty, expiry_date, manufacturer, mrp_price, source_location,destination_location,destination_qty,source_qty) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

	public static String SAVE_STOCK_LEDGER_BATCH_ASSET = "INSERT INTO stock_ledger_detail(stock_ledger_id, item_id, batch_no, batch_qty, source_location,destination_location,destination_qty,source_qty) VALUES(?,?,?,?,?,?,?,?)";

	public static String GET_LOCATION_VENDOR = "select location_id from location where address_id =(select address_id from address where address_id = (select address_id from entity e inner join grn g on e.entity_id =g.entity_id where grn_number =?))";

	public static String getUOMITEMID = "select uom from item_new where item_id = ?";

	public static final String PO_SCHEDULE = "select ds.purchase_delivery_schedule_id scheduleId,ds.item_id scheduleItemId,itm.item_code scheduleItemCode,itm.item_name scheduleItemName,ds.item_qty scheduleQty,coalesce(ds.pending_qty,0) as scheduleItemQty,coalesce(ds.item_qty,0) - coalesce(ds.pending_qty,0) as scheduleReceivedQty,coalesce(ds.pending_qty,0) schedulePendingQty,to_char(ds.delivery_date,'dd/mm/yyyy') scheduleItemDate from purchase_order_delivery_schedule ds left join item_new itm on ds.item_id = itm.item_id where ds.purchase_order_detail_id = ? ";

	// public static final String SAVE_GRN_BATCH_DTL =
	// "INSERT INTO grn_batch_detail(grn_detail_id, item_id, batch_no,
	// batch_qty,expiry_date, manufacturer, mrp_price,converted_quantity) VALUES
	// (?, ?, ?, ?, TO_DATE(?,'DD-MM-YY'), ?, ?,?)";
	public static final String SAVE_GRN_BATCH_DTL = "INSERT INTO grn_batch_detail(grn_detail_id, item_id, batch_no, batch_qty, manufacturer, mrp_price,converted_quantity) VALUES (?, ?, ?, ?,?, ?,?)";

	public static final String GET_GRN_BATCH_DTL = "select grn.item_id batchItemId ,itm.item_name batchItemName,grn.batch_no lotNo,grn.batch_qty batchQty,to_char(grn.expiry_date,'dd/mm/yyyy') expiryDate,grn.manufacturer manufactureDef,grn.mrp_price mrp,grnd.qc_status status from grn_batch_detail grn left join item_new itm on grn.item_id = itm.item_id left join grn_detail grnd on grnd.grn_detail_id = grn.grn_detail_id where grn.grn_detail_id =?";

	public static final String UPDATE_PO_SCHEDULE_STATUS = "update purchase_order_delivery_schedule set pending_qty=? where purchase_delivery_schedule_id =?";

	public static final String GET_TRANSIT_LOCATION = "select min(location_id) from location where location_name like ?";

	public static final String GET_ITEM_ATTRIBUTES = "select batch_no itemBatch,mrp itemMrp,expiry_date itemExpDate,manufacture_details itemManufacture from item_grn_attribute where item_id = ?";

	/************************************
	 * Asset Items QC Check **************************************
	 */

	public static final String GRN_LIST_WITH_QC = "select grn_number grnCode,to_char(grn_date,'dd/mm/yyyy') grnDate,entity_name vendorName,purchase_order_no poNo,purchase_requisition_id poRequisition,coalesce(grn_status,0) grnStatus,coalesce(def.value,'') statusVal from grn g left join def_table def on def.def_table_id = grn_status left join entity en on g.entity_id = en.entity_id left join purchase_order po on g.purchase_order_id = po.purchase_order_id inner join (select distinct grn_id from grn_detail where item_id in (select it.item_id from item_category ic inner join item_new it on ic.item_category_id = it.item_category where quality_check =true)) qc on g.grn_id =qc.grn_id order by grn_number desc";

	public static final String UPDATE_GRN_ITEM_QC = "update grn_detail set sample_qty =?, qc_status=?,qc_remarks=?,status=? where grn_detail_id=?";

	public static final String CHECK_QC_FOR_ITEM = "select case when quality_check is null then false  else quality_check end qualityCheck from item_category ic inner join item_new it on ic.item_category_id = it.item_category where item_id =?";

	public static final String UPDATE_GRN_STATUS = "update grn set grn_status=? where grn_id=?";

	public static final String GET_QC_LOCATION = "select coalesce(qc_location_id,0) qcLocation from grn where grn_number =?";

	public static final String GET_VENDOR_ACCT_CODE = "select supplier_acct_code from entity where entity_id = ?";

	public static final String GET_VENDOR_ACCT_CODE1 = "select coalesce(entity_name,'') from entity where supplier_acct_code = ?";

	public static final String budgetId = "select budget_type_id from budget_definition where budget_definition_id=?";

	public static final String budgetName = "select expenses  from budget_type where budget_type_id=?";

	// capex_no||'-'||project_name =
	// select budget_type as budgetTypeName from budget_type where
	// budget_type_id
	public static final String GET_PO_CNT_IN_GRN = "select count(*) from grn where purchase_order_id = ?";

	public static final String GET_PO_DTL_QTY = "select count(*) from grn_detail where purchase_order_detail_id = ?";

	public static final String GET_PO_DETAIL_QTY = "";

	public static final String GET_OLD_BATCH = "select g.dest_location_id, gd.item_id, gbd.mrp_price mrp,gbd.manufacturer,TO_CHAR(gbd.expiry_date,'DD/MM/YYYY') expiryDate from grn_batch_detail as gbd " + "inner join grn_detail gd on  gd.grn_detail_id=gbd.grn_detail_id " + "inner join grn as g on g.grn_id=gd.grn_id " + "where g.location_id=? and gd.item_id=?";

	public static final String GET_BATCH_DETAILLIST = "select grn_batch_detail.item_id batchItemId ,itm.item_name batchItemName,grn_batch_detail.batch_no lotNo,grn_batch_detail.batch_qty batchQty, " + "to_char(grn_batch_detail.expiry_date,'dd/mm/yyyy') expiryDate,grn_batch_detail.manufacturer manufactureDef,grn_batch_detail.mrp_price mrp from grn " + "inner join grn_detail on grn.grn_id=grn_detail.grn_id " + "inner join grn_batch_detail on grn_detail.grn_detail_id= grn_batch_detail.grn_detail_id and grn_detail.item_id=grn_batch_detail.item_id "
			+ "inner join item_new itm on grn_detail.item_id=itm.item_id " + "where grn.grn_number=?";

	public static final String CHECK_CONSIGNMENT_LIST = "select count(*) from stock_transfer_batch_detail as stbd " + "inner join stock_transfer_detail as std on std.stock_transfer_detail_id=stbd.stock_transfer_detail_id " + "inner join stock_transfer as st on st.stock_transfer_id=std.stock_transfer_id " + "where stbd.batch_no=?  and st.source_location=? and stbd.item_id=? " + "and st.stock_transfer_number  like 'CNI%'";

	public static final String GET_PO_MAX_STATUS = "select max(po_status) from purchase_order_detail where purchase_order_id =?";

	public static final String GET_OLD_STOCK_IN_BATCH = "select sld.source_location, sld.item_id, sld.mrp_price mrp,sld.manufacturer,TO_CHAR(sld.expiry_date,'DD/MM/YYYY') expiryDate from stock_ledger_detail sld inner join stock_ledger st on st.stock_ledger_id = sld.stock_ledger_id sld.source_location=? and sld.item_id=? and st.doc_ref like 'SKI%'  ";

	public static final String GET_BATCH_DETAILS = "select * from stock_transfer_batch_detail as stbd " + "inner join stock_transfer_detail as std on std.stock_transfer_detail_id=stbd.stock_transfer_detail_id " + "inner join stock_transfer as st on st.stock_transfer_id=std.stock_transfer_id " + "where stbd.batch_no=?  and st.source_location=? and stbd.item_id=? " + "and st.stock_transfer_number not like 'CNI%'";

	public static final String GET_CONSIGNMENT_TRANSFER_DETAILS = "select coalesce(purchase_type,0)purchasetype,coalesce(consignment_transfer_id,0)consignmentTransferId from purchase_order where purchase_order_id=?";

	public static final String GET_CONSIGNMETN_BATCH_DETAILS = "select  item.item_code || '-' ||item.item_name  as batchItemName , stbd.batch_no lotNo,coalesce(stbd.transfer_qty,0) batchQty,stbd.item_id as batchItemId from stock_transfer as st " + "inner join stock_transfer_detail as std on std.stock_transfer_id=st.stock_transfer_id " + "inner join stock_transfer_batch_detail as stbd on stbd.stock_transfer_detail_id = std.stock_transfer_detail_id " + "inner join  as  on  std.item_id=item.item_id "
			+ "where std.stock_transfer_detail_id=? and std.item_id=?";

	public static final String GET_CONSIGNEMNT_STOCK_TRANSFER_DETAIL_ID = "select stock_transfer_detail_id as stockTransferDetailId from stock_transfer_detail where stock_transfer_id=? order by stock_transfer_detail_id asc";

	public static final String GET_GRN_DTL_PRINT = "select grn_id grnId, grn.grn_detail_id grnDtlId,grn.item_id dtlItemId, coalesce(grn.quantity,0) dtlQty,coalesce(grn.pending_qty,0) pendingQty,coalesce(grn.quantity,0) dtlQty, coalesce(grn.pending_qty,0) pendingQty,grn.purchase_order_detail_id dtlPODtlId,coalesce(pqd.quantity,0) vendorQuantity,coalesce(pqd.purchase_quantity,0) purchaseQuantity, coalesce(pod.unit_price,0) dtlPrice,itm.item_code dtlItemCode,itm.item_name dtlItemName,pqd.item_description dtlItemDesc, case when quality_check is null then false else quality_check end qualityCheck, coalesce(itm.uom,0) dtlUom,(select uom from uom where uom_id = itm.uom limit 1) as dtlUomName,coalesce(sample_qty,0) sampleQty, coalesce(qc_status,0) qcStatus,qc_remarks qcRemarks,coalesce(status,0) dtlStatus,qc_status as status, coalesce(grn.converted_quantity,0) convertedQty,	coalesce(pod.tax_cgst_percent,0) as taxCGSTinPercent,coalesce(pod.tax_sgst_percent,0) as taxSGSTinPercent,coalesce(pod.tax_igst_percent,0) as taxIGSTinPercent,	coalesce(pod.tax_cgst,0) as taxCGST,coalesce(pod.tax_sgst,0) as taxSGST,coalesce(pod.tax_cgst,0) as taxIGST,coalesce(pod.discount_percent,0) as discountPercentage,coalesce(pod.discount_amount,0) as discountAmount , coalesce(pod.discount_type,0) as discountType	,pod.quantity as originalConvertedQty 	from grn_detail grn left join purchase_order_detail pod on grn.purchase_order_detail_id = pod.purchase_order_detail_id 	left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id 	left join purchase_quote pq on pq.purchase_quote_id = pqd.purchase_quote_detail_id 	left join item_new itm on grn.item_id = itm.item_id left  join item_category itc on itm.item_category = itc.item_category_id where grn_id=(select grn_id from grn where grn_number =? ) order by grn.grn_detail_id";

	public static final String GET_PO_COUNT_IN_GRN = "select  count(*)  from grn  where purchase_order_id  = ?";

	public static final String GET_FREIGHT_OTHER_IN_GRN = "select COALESCE(sum(freight),0) as freight,COALESCE(sum(other_charges),0) as other_charges from grn  where purchase_order_id  = ?";

	public static final String GRN_GST_GROUP_BY = "(select  'Input CGST @' || pod.tax_cgst_percent::text || '% AC' as gstgroupbyPercent,   COALESCE((sum(case  when pod.discount_type !=0  then ((grn.quantity *  pod.unit_price) -  (pod.discount_amount / pod.quantity ) * grn.quantity)   else 0 end )  * pod.tax_cgst_percent/100),0) as gstAmtgroupbyPercent from grn_detail grn left join purchase_order_detail pod on grn.purchase_order_detail_id = pod.purchase_order_detail_id left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id where grn_id=(select grn_id from grn where grn_number =?) group by pod.tax_cgst_percent order by pod.tax_cgst_percent ) union all (select  'Input SGST @' || pod.tax_sgst_percent::text || '% AC' as gstgroupbyPercent,   COALESCE((sum(case  when pod.discount_type !=0  then ((grn.quantity *  pod.unit_price) -  (pod.discount_amount / pod.quantity ) * grn.quantity)   else 0 end )  * pod.tax_sgst_percent/100),0) as gstAmtgroupbyPercent from grn_detail grn left join purchase_order_detail pod on grn.purchase_order_detail_id = pod.purchase_order_detail_id left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id where grn_id=(select grn_id from grn where grn_number =?) group by pod.tax_sgst_percent order by pod.tax_sgst_percent) union all (select  'Input IGST @' || pod.tax_igst_percent::text || '% AC' as gstgroupbyPercent,   COALESCE((sum(case  when pod.discount_type !=0  then ((grn.quantity *  pod.unit_price) -  (pod.discount_amount / pod.quantity ) * grn.quantity)  else 0 end )  * pod.tax_igst_percent/100),0) as gstAmtgroupbyPercent from grn_detail grn left join purchase_order_detail pod on grn.purchase_order_detail_id = pod.purchase_order_detail_id left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id where grn_id=(select grn_id from grn where grn_number =?)  group by pod.tax_igst_percent order by pod.tax_igst_percent )";

}
