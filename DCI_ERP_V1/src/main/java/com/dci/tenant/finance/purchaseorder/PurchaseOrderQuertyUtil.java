package com.dci.tenant.finance.purchaseorder;

public class PurchaseOrderQuertyUtil {

	public static final String GET_FORM_FIELD_VALUES = "select def_table_id as id,value as text from def_table inner join form_field ff on ff.form_field_id  = def_table.form_field_id where def_table.form_field_id = ? and is_active = true";

	public static final String GET_FORM_FIELD_VALUES_PURCHASE_ORDER = "select def_table_id as id,value as text from def_table inner join form_field ff on ff.form_field_id  = def_table.form_field_id where def_table.form_field_id = ?";

	// for company rights
	// public static final String GET_COMPANY_NAMES =
	// "select distinct company_code as id,company_name as text from
	// company_user cu
	// inner join company c on cu.company_code = c.company_id where c.company_id
	// = ?
	// order by company_name";

	public static final String GET_COMPANY_NAMES = "select distinct cu.company_code as id,company_name as text from company_user cu inner join company_master c on cu.company_code = c.company_code   order by company_name";

	// public static final String GET_VENDOR_NAMES =
	// " select distinct entity.entity_id as id,entity.vendor_payment_terms
	// paymentTerms, "
	// +
	// " entity_name as text,street as address,city_name as city ,
	// state.state_name as state,country_name as country,city.pincode as zipCode
	// "
	// +
	// " from entity inner join address on address.address_id =
	// entity.address_id "
	// + " inner join employee em on em.employee_id = entity.created_by "
	// +
	// " inner join branch_department bd on bd.branch_department_id =
	// em.branch_department_id inner join branch b on b.branch_id = bd.branch_id
	// "
	// +
	// " inner join city on city.city_id = address.city_id inner join state on
	// state.state_code = city.state_code "
	// + " inner join country on country.country_code = state.country_code " +
	// " left join purchase_quote pq on pq.entity_id = entity.entity_id " +
	// " and pq.payment_terms is not null where is_vendor = true and
	// b.company_id = ? and entity_name <> ''";
	// public static final String GET_VENDOR_NAMES =
	// " select supplier_acct_code as id, entity_name as text ,vendor_address as
	// address FROM entity where is_vendor='t' and (supplier_acct_code!=NULL OR
	// supplier_acct_code!='')";
	public static final String GET_VENDOR_NAMES = " select supplier_acct_code as id, entity_name as text FROM entity where is_vendor='t' and  (supplier_acct_code!=NULL OR supplier_acct_code!='')";

	public static final String GET_PURCHASE_REQ_DROPDOWN = "select purchase_requisition_id as id, concat(requisition_number,' - ',pr_request_number) as text FROM purchase_requisition pr order by  purchase_requisition_id desc";

	public static final String GET_PURCHASE_ORDER_DROPDOWN = "select purchase_order_id as id, purchase_order_no as text FROM purchase_order order by  purchase_order_id desc";

	public static final String GET_PURCHASE_INVOICE_DROPDOWN = "select invoice_no as id, invoice_no as text FROM purchase_invoice_hdr order by  invoice_dt,invoice_no desc";

	public static final String GET_MATERIL_ISSUE_DROPDOWN = "select stock_transfer_id as id, stock_transfer_number as text FROM stock_transfer order by  stock_transfer_id desc";

	public static final String GET_PURCHASE_ORDER_STATUS_DROPDOWN = "select def_table_id as id, value as text FROM def_table where form_field_id=17 and def_table_id in (46,47,48,49,167,138) order by  value asc";

	public static final String GET_GRN_STATUS_DROPDOWN = "select def_table_id as id, value as text FROM def_table where form_field_id=13 order by value asc";

	public static final String GET_LOCATION_NAMES = "SELECT location_id as id,location_name as text,street as address,cty_nam as city , state.stt_nam as state,cntry_nam as country ,zp_cd as zipCode from location  left join address on address.address_id = location.address_id  left  join city on city.cty_id = address.city_id  left join state on state.stt_id = city.stt_id left join country on country.cntry_id =  state.cntry_id  where location_id not in (?,?) and is_active = 't'";

	public static final String GET_ITEM_LIST = "select item_id as id , concat(item.item_code,'-', item.item_name) as text from item_new item where company_id = ? ";

	// public static final String GET_PURCHASE_ORDER_LIST = "select * from( " +
	// "SELECT purchase_order_id as purchaseOrderId, purchase_order_no as
	// purchaseOrderNum, to_char(purchase_date,'dd/mm/yyyy') as
	// purchaseOrderDate, "
	// +
	// "dftyp.value as purchaseForName, dftyp.value as purchaseTypeName,
	// company.short_name as companyName, entity.entity_name as vendorName,
	// purchase_order.company_id, "
	// +
	// "location.location_name as locationName , terms_condition as
	// termsCondition,
	// remarks as remarks,sub_total as subTotal, "
	// +
	// "total_discount as totalDiscount, total_tax as totalTax ,freight as
	// freight,po_status as statusId,dfs.value as purchaseStatus "
	// +
	// "FROM purchase_order inner join company on company.company_id =
	// purchase_order.company_id "
	// +
	// "inner join entity on entity.supplier_acct_code =
	// purchase_order.vendor_id "
	// +
	// "Left join location on location.location_id = purchase_order.location_id
	// "
	// +
	// "left join def_table dfs on dfs.def_table_id = purchase_order.po_status "
	// +
	// "left join def_table dftyp on dftyp.def_table_id =
	// purchase_order.purchase_type "
	// + "where purchase_order.purchase_type = ? " + ") t inner join " +
	// "(select distinct cu.company_code, isedit,isdelete,isview,isprint from
	// vw_rights_for_list rl inner join company_user cu on cu.user_id =
	// rl.user_id
	// where rl.form_code=? and rl.user_id = ?) t1 "
	// + "on t1.company_code = t.company_id order by purchaseOrderId desc";

	/*
	 * public static final String GET_PURCHASE_ORDER_LIST = "select * from( " +
	 * "SELECT purchase_order_id as purchaseOrderId, purchase_order_no as purchaseOrderNum, to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, "
	 * +
	 * "company.short_name as companyName, entity.entity_name as vendorName, purchase_order.company_id, "
	 * +
	 * "location.location_name as locationName ,     terms_condition as termsCondition, remarks as remarks,sub_total as subTotal, "
	 * +
	 * "total_discount as totalDiscount,    total_tax as totalTax ,freight as freight,po_status as statusId,dfs.value as purchaseStatus ,case when po_amendment is null then 'false' else 'true' end as poAmendmentNovalid, po_amendment as  poAmendmentNo, case when request_type='PO' then 'Purchase Order' when request_type='WO' then 'Work Order' else null end as reqType  "
	 * +
	 * " FROM purchase_order    inner join company on company.company_id = purchase_order.company_id "
	 * +
	 * "inner join entity on entity.supplier_acct_code = purchase_order.vendor_id "
	 * + "Left join location on location.location_id = purchase_order.location_id "
	 * + "left join def_table dfs on   dfs.def_table_id = purchase_order.po_status "
	 * + " order by purchase_order_id desc " + ") t";
	 */

	public static final String GET_PURCHASE_ORDER_LIST = "select * from( SELECT purchase_order_id as purchaseOrderId, purchase_order_no as purchaseOrderNum, (select value  from def_table inner join form_field ff on ff.form_field_id  = def_table.form_field_id where def_table_id = purchase_type)purchaseTypeName, to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, company.short_name as companyName, entity.entity_name as vendorName, purchase_order.company_id, location.location_name as locationName , terms_condition as termsCondition, remarks as remarks,sub_total as subTotal, "
			+ "			total_discount as totalDiscount, total_tax as totalTax ,freight as freight,po_status as statusId,  case when  (select sum(quantity) from purchase_order_detail where purchase_order_id = purchase_order.purchase_order_id) =    (select sum(quantity) from grn_detail where grn_detail.purchase_order_detail_id in (select purchase_order_detail_id from purchase_order_detail where purchase_order_id = purchase_order.purchase_order_id))  then 'GRN Done'    else dfs.value end    as purchaseStatus , "
			+ "			(select sum(quantity) from purchase_order_detail where purchase_order_id = purchase_order.purchase_order_id) poqty,  (select sum(quantity) from grn_detail where grn_detail.purchase_order_detail_id in (select purchase_order_detail_id from purchase_order_detail where purchase_order_id = purchase_order.purchase_order_id)) grnqty, "
			+ "			case when po_amendment is null then 'false' else 'true' end as poAmendmentNovalid, po_amendment as poAmendmentNo, case when request_type='PO' then 'Purchase Order' when request_type='WO' then 'Work Order' else null end as reqType FROM purchase_order inner join company_master  company on company.company_code = purchase_order.company_id inner join entity on entity.supplier_acct_code = purchase_order.vendor_id  Left join location on location.location_id = purchase_order.location_id "
			+ "			left join def_table dfs on dfs.def_table_id = purchase_order.po_status order by purchase_order_id desc ) t";

	// + " inner join " +
	// "(select distinct cu.company_code, isedit,isdelete,isview,isprint from
	// vw_rights_for_list rl inner join company_user cu on cu.user_id =
	// rl.user_id
	// where rl.form_code=? and rl.user_id = ?) t1 "
	// + "on t1.company_code = t.company_id order by purchaseOrderId desc";

	// public static final String GET_TOTAL_PURCHASE_ORDER_LIST =
	// "SELECT purchase_order_id as purchaseOrderId, purchase_order_no as" +
	// " purchaseOrderNum, " +
	// " to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate,dftyp.value as
	// purchaseForName,"
	// + " dftyp.value as purchaseTypeName, " +
	// " company.short_name as companyName, entity.entity_name as vendorName," +
	// " location.location_name as locationName , " +
	// " terms_condition as termsCondition, remarks as remarks,sub_total as
	// subTotal,"
	// + " total_discount as totalDiscount, "
	// +
	// " total_tax as totalTax ,freight as freight,po_status as
	// statusId,dfs.value
	// as purchaseStatus, "
	// + "purchase_order.purchase_type as purchaseType " +
	// " FROM purchase_order " +
	// " inner join company on company.company_id = purchase_order.company_id" +
	// " inner join entity on entity.entity_id = purchase_order.vendor_id " +
	// " Left join location on location.location_id = purchase_order.location_id
	// "
	// +
	// " left join def_table dfs on dfs.def_table_id = purchase_order.po_status
	// "
	// +
	// " left join def_table dftyp on dftyp.def_table_id =
	// purchase_order.purchase_type "
	// +
	// "where purchase_order. po_status != all( ?::int[] ) and
	// company.company_id =
	// ?"
	// + " order by purchase_order_id desc";

	public static final String GET_TOTAL_PURCHASE_ORDER_LIST = "SELECT purchase_order_id as purchaseOrderId,   purchase_order_no as purchaseOrderNum, to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate,dftyp.value as purchaseForName,   dftyp.value as purchaseTypeName, company.short_name as companyName, location.location_name as locationName ,terms_condition as termsCondition,   remarks as remarks,sub_total as subTotal,total_discount as totalDiscount, total_tax as totalTax ,freight as freight,po_status as statusId, "
			+ "			 dfs.value as purchaseStatus, purchase_order.purchase_type as purchaseType ,entity.entity_name as vendorName,case when request_type='PO' then 'Purchase Order'   when request_type='WO' then 'Work Order' else null end as reqType FROM purchase_order inner join company_master   company on company.company_code = purchase_order.company_id   Left join location on location.location_id = purchase_order.location_id  left join def_table dfs on dfs. def_table_id = purchase_order.po_status "
			+ "			 left join def_table dftyp on dftyp.def_table_id = purchase_order.purchase_type  inner join entity on entity.supplier_acct_code = purchase_order.vendor_id   where purchase_order. po_status != all(?::int[] ) order by purchase_order_id desc";

	// command for user rights company

	// public static final String GET_TOTAL_PURCHASE_ORDER_LIST =
	// "SELECT purchase_order_id as purchaseOrderId, purchase_order_no as" +
	// " purchaseOrderNum, " +
	// " to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate,dftyp.value as
	// purchaseForName,"
	// + " dftyp.value as purchaseTypeName, " +
	// " company.short_name as companyName, " +
	// " location.location_name as locationName , " +
	// " terms_condition as termsCondition, remarks as remarks,sub_total as
	// subTotal,"
	// + " total_discount as totalDiscount, "
	// +
	// " total_tax as totalTax ,freight as freight,po_status as
	// statusId,dfs.value
	// as purchaseStatus, "
	// + "purchase_order.purchase_type as purchaseType " +
	// " FROM purchase_order " +
	// " inner join company on company.company_id = purchase_order.company_id" +
	// " Left join location on location.location_id = purchase_order.location_id
	// "
	// +
	// " left join def_table dfs on dfs.def_table_id = purchase_order.po_status
	// "
	// +
	// " left join def_table dftyp on dftyp.def_table_id =
	// purchase_order.purchase_type "
	// +
	// "where purchase_order. po_status != all( ?::int[] ) and
	// company.company_id =
	// ?"
	// + " order by purchase_order_id desc";

	// public static final String INSERT_PURCHASE_ORDER =
	// "INSERT INTO purchase_order( purchase_order_no, purchase_date, " +
	// "purchase_for,purchase_type, company_id, vendor_id, location_id,
	// terms_condition,remarks,"
	// +
	// " po_status, created_by,
	// created_date,sub_total,total_discount,total_tax,total_amount,freight,payment_terms,cost_center_id,advanceamt,po_type,total_cgst,total_sgst,total_igst,other_charges,currency_code,remarks_othercharges,budget_type_id)
	// "
	// +
	// "VALUES (?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?,?,?,
	// current_date,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning
	// purchase_order_id";

	public static final String INSERT_PURCHASE_ORDER = "INSERT INTO purchase_order( purchase_order_no, purchase_date, " + "purchase_for,purchase_type, company_id, vendor_id, location_id, terms_condition,remarks," + " po_status, created_by, created_date,sub_total,total_discount,total_tax,total_amount,freight,freight_tax,freight_amount,payment_terms,cost_center_id,advanceamt,po_type,total_cgst,total_sgst,total_igst,other_charges,currency_code,remarks_othercharges,budget_type_id,request_type) "
			+ "VALUES (?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?,?,?, current_date,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning purchase_order_id";

	// public static final String INSERT_PURCHASE_ORDER_AMENDMENT =
	// "INSERT INTO purchase_order( purchase_order_no, purchase_date, " +
	// "purchase_for,purchase_type, company_id, vendor_id, location_id,
	// terms_condition,remarks,"
	// +
	// " po_status, created_by,
	// created_date,sub_total,total_discount,total_tax,total_amount,freight,payment_terms,cost_center_id,advanceamt,po_type,total_cgst,total_sgst,total_igst,other_charges,currency_code,remarks_othercharges,budget_type_id,po_amendment,reason_for_amendment)
	// "
	// +
	// "VALUES (?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?,?,?,
	// current_date,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning
	// purchase_order_id";

	public static final String INSERT_PURCHASE_ORDER_AMENDMENT = "INSERT INTO purchase_order( purchase_order_no, purchase_date, " + "purchase_for,purchase_type, company_id, vendor_id, location_id, terms_condition,remarks," + " po_status, created_by, created_date,sub_total,total_discount,total_tax,total_amount,freight,payment_terms,cost_center_id,advanceamt,po_type,total_cgst,total_sgst,total_igst,other_charges,currency_code,remarks_othercharges,budget_type_id,po_amendment,reason_for_amendment,freight_tax,freight_amount,request_type) "
			+ "VALUES (?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?,?,?, current_date,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning purchase_order_id";
	// public static final String UPDATE_PURCHASE_ORDER =
	// "UPDATE purchase_order SET purchase_date=to_date(?,'dd/mm/yyyy'),
	// purchase_for=?, "
	// + "purchase_type=?, company_id=?," +
	// " vendor_id=?, location_id=?, terms_condition=?,remarks=?,sub_total=?,
	// modified_by= ?,total_discount=?,total_tax=?,total_amount = ?,"
	// +
	// " po_status=?,modified_date = current_date,freight = ?,payment_terms =
	// ?,cost_center_id = ? "
	// + "WHERE purchase_order_id = ?";
	// public static final String UPDATE_PURCHASE_ORDER =
	// "UPDATE purchase_order SET purchase_date=to_date(?,'dd/mm/yyyy'),
	// purchase_for=?, "
	// + "purchase_type=?, company_id=?," +
	// " vendor_id=?, location_id=?, terms_condition=?,remarks=?,sub_total=?,
	// modified_by= ?,total_discount=?,total_tax=?,total_amount = ?,"
	// +
	// " po_status=?,modified_date = current_date,freight = ?,payment_terms =
	// ?,cost_center_id = ?,advanceamt=?, po_type=?, total_cgst=?, total_sgst=?,
	// total_igst=?, other_charges=?, currency_code=?,remarks_othercharges = ?
	// ,budget_type_id = ? "
	// + "WHERE purchase_order_id = ?";

	public static final String UPDATE_PURCHASE_ORDER = "UPDATE purchase_order SET purchase_date=to_date(?,'dd/mm/yyyy'), purchase_for=?, " + "purchase_type=?, company_id=?," + " vendor_id=?, location_id=?, terms_condition=?,remarks=?,sub_total=?, modified_by= ?,total_discount=?,total_tax=?,total_amount = ?,"
			+ " po_status=?,modified_date = current_date,freight = ?,freight_tax=?,freight_amount=?,payment_terms = ?,cost_center_id = ?,advanceamt=?, po_type=?, total_cgst=?, total_sgst=?, total_igst=?, other_charges=?, currency_code=?,remarks_othercharges = ? ,budget_type_id = ? , request_type = ? " + "WHERE purchase_order_id = ?";
	public static final String DELETE_PURCHASE_ORDER = "DELETE FROM purchase_order WHERE purchase_order_id = ?";

	public static final String GET_PURCHASE_ORDER_DETAIL_LIST = "SELECT purchase_order_detail_id as purchaseOrderDetailId, " + "item.item_id as purchaseItemId,item.item_code as purchaseItemCode,concat(item.item_code,'-', item.item_name) as purchaseItemName, " + "purchase_quote_detail_id as purchaseQuoteDetailId, quantity as quantity, def_table.value as purchaseStatus," + " unit_price as unitPrice, purchase_order_id as purchaseOrderId,true as edit FROM purchase_order_detail "
			+ "inner join item_new item on item.item_id = purchase_order_detail.item_id  " + "inner join def_table on  def_table.def_table_id = purchase_order_detail.po_status where purchase_order_detail.purchaseOrderId = ?";

	public static final String INSERT_PURCHASE_ORDER_DETAIL = "INSERT INTO purchase_order_detail(item_id, purchase_quote_detail_id,quantity," + " po_status, unit_price, purchase_order_id,discount,purchase_requisition_number,tax_cgst,tax_sgst,tax_igst,item_description,discount_percent,discount_amount,tax_cgst_percent,tax_sgst_percent,tax_igst_percent,discount_type,cost_center,purchase_uom,purchase_qty,vendor_uom) " + "VALUES (?, ?,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

	public static final String INSERT_RATE_CONTRACT_DETAIL = "INSERT INTO purchase_order_detail(item_id, purchase_quote_detail_id,quantity," + " po_status, unit_price, purchase_order_id,discount,tax_amount) " + "VALUES (?, ?,?, ?, ?, ?,?,?) returning purchase_order_detail_id ";

	public static final String DELETE_PURCHASE_ORDER_DETAIL = "DELETE FROM purchase_order_detail WHERE purchase_order_id = ?";

	public static final String DELETE_SELECTED_PURCHASE_ORDER_DETAIL = "DELETE FROM purchase_order_detail WHERE purchase_order_detail_id = ?";

	public static final String DELETE_SELECTED_PURCHASE_ORDER_DETAIL_BASED_PURCHASE_ORDER = "DELETE FROM purchase_order_detail WHERE purchase_order_id = ?";

	// public static final String UPDATE_PURCHASE_ORDER_DETAIL =
	// "UPDATE purchase_order_detail SET item_id=?, purchase_quote_detail_id=?,
	// "
	// +
	// "quantity=?, po_status=?, unit_price=?, purchase_order_id=?,discount =
	// ?,tax_amount=? WHERE purchase_order_detail_id = ?";
	public static final String UPDATE_PURCHASE_ORDER_DETAIL = "UPDATE purchase_order_detail SET item_id=?, purchase_quote_detail_id=?, quantity=?, po_status=?, unit_price=?, purchase_order_id=?,discount = ?,tax_amount=?,tax_cgst  =? , tax_sgst  =? ,tax_igst  =?,discount_percent = ? ,discount_amount = ?, tax_cgst_percent = ? ,tax_sgst_percent = ? ,tax_igst_percent = ?,cost_center = ?, discount_type = ?, purchase_uom = ? ,purchase_qty = ? , vendor_uom = ? WHERE purchase_order_detail_id = ?";

	// public static final String EDIT_PURCHASE_ORDER =
	// "SELECT purchase_order_id as purchaseOrderId, " +
	// "purchase_order_no as purchaseOrderNum,
	// to_char(purchase_date,'dd/mm/yyyy')
	// as purchaseOrderDate, "
	// +
	// "purchase_for as purchaseFor, purchase_type as purchaseType, company_id
	// as
	// companyId, vendor_id as vendorId, "
	// +
	// "location_id as locationId, terms_condition as termsCondition, remarks as
	// remarks, po_status as statusId,dft.value as purchaseTypeName, "
	// +
	// " freight as freight,K(freight,0) as
	// duplicateFreight,COALESCE(other_charges,0) as
	// otherCharges,consignment_transfer_id as conTransNo,payment_terms as
	// paymentTerms,cost_center_id as
	// costcenter,to_char(recommended_date,'dd/mm/yyyy') as recmndDate,"
	// +
	// " recommended_remarks as recmndremarks,employee.first_name as
	// recmmendedBy,reason_for_amendment as reason_for_amendment, advanceamt as
	// advanceamt, po_type as potype , currency_code as currency
	// ,remarks_othercharges as remarksforother,COALESCE(budget_type_id,0) as
	// budgetType FROM "
	// + "purchase_order " +
	// " left join def_table dft on dft.def_table_id =
	// purchase_order.purchase_type"
	// +
	// " left join employee on employee.employee_id =
	// purchase_order.recommended_by
	// "
	// + " where purchase_order_id = ? ";

	/*
	 * public static final String EDIT_PURCHASE_ORDER =
	 * "SELECT purchase_order_id as purchaseOrderId, " +
	 * "purchase_order_no as purchaseOrderNum, to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, "
	 * +
	 * "purchase_for as purchaseFor, purchase_type as purchaseType, company_id as companyId, vendor_id as vendorId, "
	 * +
	 * "location_id as locationId, terms_condition as termsCondition,  remarks as remarks,  po_status as statusId,dft.value as purchaseTypeName, "
	 * +
	 * " round(freight::decimal,2) as  freightAmount,freight_tax as freightTax,round(freight_amount::decimal,2) as freight,round(COALESCE(freight,0)::decimal,2) as duplicateFreight,round(COALESCE(other_charges,0)::decimal,2) as otherCharges,consignment_transfer_id as conTransNo,payment_terms as paymentTerms,cost_center_id as costcenter,to_char(recommended_date,'dd/mm/yyyy') as recmndDate,"
	 * +
	 * " recommended_remarks as recmndremarks,employee.first_name  as recmmendedBy,reason_for_amendment as reason_for_amendment, advanceamt as advanceamt, po_type as potype  , currency_code as currency ,remarks_othercharges as remarksforother,COALESCE(budget_type_id,0) as budgetType , round(total_cgst::decimal,2) totalTaxCGST , round(total_sgst::decimal,2) totalTaxSGST , round(total_igst::decimal,2) totalTaxIGST, round(total_discount::decimal,2) as totalDiscount ,round(sub_total::decimal,2) as subTotal,round(total_amount::decimal,2) as totalAmount ,request_type as req_type  FROM "
	 * + "purchase_order " +
	 * " left join def_table dft on dft.def_table_id = purchase_order.purchase_type"
	 * +
	 * " left join employee on employee.employee_id  = purchase_order.recommended_by "
	 * + " where purchase_order_id = ? ";
	 * 
	 */

	public static final String EDIT_PURCHASE_ORDER ="SELECT purchase_order_id as purchaseOrderId, purchase_order_no as purchaseOrderNum, to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, purchase_for as purchaseFor, purchase_type as purchaseType, company_id as companyId, vendor_id as vendorId, location_id as locationId, terms_condition as termsCondition,  remarks as remarks,  po_status as statusId,dft.value as purchaseTypeName, case when "
			+ "			(select sum(quantity) from purchase_order_detail where purchase_order_id = purchase_order.purchase_order_id) =    (select sum(quantity) from grn_detail where grn_detail.purchase_order_detail_id in (select purchase_order_detail_id from purchase_order_detail where purchase_order_id = purchase_order.purchase_order_id))  then 'GRN Done'    else dfs.value end    as purchaseStatus ,  (select sum(quantity) from purchase_order_detail where purchase_order_id = purchase_order.purchase_order_id) poqty, "
			+ "			(select sum(quantity) from grn_detail where grn_detail.purchase_order_detail_id in (select purchase_order_detail_id from purchase_order_detail where purchase_order_id = purchase_order.purchase_order_id)) grnqty, "
			+ "						 round(freight::decimal,2) as  freightAmount,freight_tax as freightTax,round(freight_amount::decimal,2) as freight,round(COALESCE(freight,0)::decimal,2) as duplicateFreight,round(COALESCE(other_charges,0)::decimal,2) as otherCharges,consignment_transfer_id as conTransNo,payment_terms as paymentTerms,cost_center_id as costcenter,to_char(recommended_date,'dd/mm/yyyy') as recmndDate, "
			+ "						 recommended_remarks as recmndremarks,employee.first_name  as recmmendedBy,reason_for_amendment as reason_for_amendment, advanceamt as advanceamt, po_type as potype  , currency_code as currency ,remarks_othercharges as remarksforother,COALESCE(budget_type_id,0) as budgetType , round(total_cgst::decimal,2) totalTaxCGST , round(total_sgst::decimal,2) totalTaxSGST , round(total_igst::decimal,2) totalTaxIGST, round(total_discount::decimal,2) as totalDiscount ,round(sub_total::decimal,2) as subTotal,round(total_amount::decimal,2) as totalAmount ,request_type as req_type  FROM "
			+ "						purchase_order  left join def_table dft on dft.def_table_id = purchase_order.purchase_type left join employee_master employee on employee.emp_id  = purchase_order.recommended_by  left join def_table dfs on dfs.def_table_id = purchase_order.po_status where purchase_order_id = ?";

	// public static final String EDIT_PURCHASE_ORDER_LOG =
	// "SELECT purchase_order_id as purchaseOrderId, " +
	// "purchase_order_no as purchaseOrderNum,
	// to_char(purchase_date,'dd/mm/yyyy')
	// as purchaseOrderDate, "
	// +
	// "purchase_for as purchaseFor, purchase_type as purchaseType, company_id
	// as
	// companyId, vendor_id as vendorId, "
	// +
	// "location_id as locationId, terms_condition as termsCondition, remarks as
	// remarks, po_status as statusId,dft.value as purchaseTypeName, "
	// +
	// " freight as freightAmount,freight_tax as freightTax,freight_amount as
	// freight,COALESCE(freight,0) as duplicateFreight,COALESCE(other_charges,0)
	// as
	// otherCharges,consignment_transfer_id as conTransNo,payment_terms as
	// paymentTerms,cost_center_id as
	// costcenter,to_char(recommended_date,'dd/mm/yyyy') as recmndDate,"
	// +
	// " recommended_remarks as recmndremarks,employee.first_name as
	// recmmendedBy,reason_for_amendment as reason_for_amendment, advanceamt as
	// advanceamt, po_type as potype , currency_code as currency
	// ,remarks_othercharges as remarksforother,COALESCE(budget_type_id,0) as
	// budgetType , total_cgst totalTaxCGST , total_sgst totalTaxSGST ,
	// total_igst
	// totalTaxIGST, total_discount as totalDiscount ,sub_total as
	// subTotal,total_amount as totalAmount FROM "
	// + "purchase_order "
	// +
	// " left join def_table dft on dft.def_table_id =
	// purchase_order.purchase_type"
	// +
	// " left join employee on employee.employee_id =
	// purchase_order.recommended_by
	// "
	// + " where purchase_order_no = ? ";
	public static final String EDIT_PURCHASE_ORDER_LOG = "SELECT purchase_order_id as purchaseOrderId,   to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate,  purchase_for as purchaseFor, purchase_type as purchaseType, value as purchaseTypeName,company_id as companyId, vendor_id as vendorId,  location_id as locationId, terms_condition as termsCondition,  remarks as remarks,  po_status as statusId,dft.value as purchaseTypeName,  freight as  freightAmount,freight_tax as freightTax,freight_amount as freight,COALESCE(freight,0) as duplicateFreight,COALESCE(other_charges,0) as otherCharges,consignment_transfer_id as conTransNo,payment_terms as paymentTerms,cost_center_id as costcenter,to_char(recommended_date,'dd/mm/yyyy') as recmndDate,	 recommended_remarks as recmndremarks,employee.first_name  as recmmendedBy,reason_for_amendment as reason_for_amendment, advanceamt as advanceamt, po_type as potype  , currency_code as currency ,remarks_othercharges as remarksforother,COALESCE(budget_type_id,0) as budgetType , total_cgst totalTaxCGST , total_sgst totalTaxSGST , total_igst totalTaxIGST, total_discount as totalDiscount ,sub_total as subTotal,total_amount as totalAmount ,(select entity_name from entity where supplier_acct_code = vendor_id ) as vendorName ,(select company_name from company where company_id = purchase_order.company_id ) as companyName ,(select location_name from location where location_id = purchase_order.location_id) as locationName ,(select currency_name from currency where currency_code = purchase_order.currency_code) as currencyName, purchase_order_no as purchaseOrderNum, (select concat(capex_no, '-',project_name) from budget_definition where budget_definition_id = purchase_order. budget_type_id) as budgetTypeName, (select value from def_table  where def_table_id = purchase_order.po_status) as statusName ,(select COST_CENTER_NAME  from COST_CENTER where COST_CENTER_ID = purchase_order.cost_center_id::INT) as costcenterName  FROM  purchase_order left join def_table dft on dft.def_table_id = purchase_order.purchase_type  left join employee on employee.employee_id  = purchase_order.recommended_by   where purchase_order_no = ?";
	// PO get details based on PQ table
	public static final String GET_PURCHASE_ORDER_DETAIL_LOG = "select distinct purchase_order_detail_id as purchaseOrderDetailId,  coalesce(pod.quantity,0) as vendorQuantity, item.item_code as purchaseItemCode,coalesce(pod.tax_cgst,0.0) as taxCGST,coalesce(pod.tax_sgst,0.0) as taxSGST,coalesce(pod.tax_igst,0.0) as taxIGST,coalesce(pod.tax_cgst_percent,0) taxCGSTinPercent,coalesce(pod.tax_sgst_percent,0) taxSGSTinPercent,coalesce(pod.tax_igst_percent,0) taxIGSTinPercent, concat(item.item_code,'-',item.item_name)   as purchaseItemName, pq.fixed_price as fixedPrice,pq.fixed_quantity as fixedQuantity, pqd.item_description as purchaseItemDesc,item.item_id as itemId,  po.vendor_id as vendorId1,to_char(pqd.edd, 'dd/mm/yyyy') as edd,case when null_or_empty(pod.vendor_uom::text) = false then  pod.vendor_uom else pqd.vendor_uom end  as uom,uom.uom as uomName,pod.quantity as quantity, pqd.delivery_lead_time as deliveryLeadTime,pod.unit_price as unitPrice, pq.freight as frieght , pq.purchase_quote_no as purchaseQuoteId , pod.po_status as purchaseStatusId,pod.purchase_order_id as purchaseOrderId, pod.purchase_quote_detail_id as purchaseQuoteDetailId ,0 as edit,def_table.value as purchaseStatus,   ic.vendor_min_qty as vendorMinQty,requested_qty as requestedQty,pod.purchase_requisition_number as requisitionNo ,pqd.purchase_requisition_id as requisitionId  from purchase_order_detail pod left join item_new item on item.item_id = pod.item_id inner join purchase_order po on po.purchase_order_id = pod.purchase_order_id  inner join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id inner join purchase_quote pq on pq.purchase_quote_id = pqd.purchase_quote_id left join def_table on def_table.def_table_id = pod.po_status  left join uom on uom.uom_id = pqd.vendor_uom left join item_vendor ic on ic.entity_id = pq.entity_id and ic.item_id=pqd.item_id where pod.purchase_order_id = ?  order by purchaseItemName asc  ";

	public static final String GET_PURCHASE_ORDER_DETAIL = "select distinct purchase_order_detail_id as purchaseOrderDetailId, pod.cost_center as costcenter,(select cost_center_name from cost_center  where cost_center_id = case when null_or_empty(pod.cost_center) = false then pod.cost_center::integer else 0 end limit 1) as costCenterName, coalesce(pod.quantity,0) as vendorQuantity, item.item_code as purchaseItemCode,coalesce(pod.tax_cgst,0.0) as taxCGST,coalesce(pod.tax_sgst,0.0) as taxSGST,coalesce(pod.tax_igst,0.0) as taxIGST,coalesce(pod.tax_cgst_percent,0) taxCGSTinPercent,coalesce(pod.tax_sgst_percent,0) taxSGSTinPercent,coalesce(pod.tax_igst_percent,0) taxIGSTinPercent, concat(item.item_code,'-',item.item_name)   as purchaseItemName, pq.fixed_price as fixedPrice,pq.fixed_quantity as fixedQuantity, pqd.item_description as purchaseItemDesc,item.item_id as itemId,  po.vendor_id as vendorId1,to_char(pqd.edd, 'dd/mm/yyyy') as edd,case when null_or_empty(pod.vendor_uom::text) = false then  pod.vendor_uom else pqd.vendor_uom end  as uom,uom.uom as uomName,pod.quantity as quantity, pqd.delivery_lead_time as deliveryLeadTime,pod.unit_price as unitPrice, pq.freight as frieght , pq.purchase_quote_no as purchaseQuoteId , pod.po_status as purchaseStatusId,pod.purchase_order_id as purchaseOrderId, pod.purchase_quote_detail_id as purchaseQuoteDetailId ,0 as edit,def_table.value as purchaseStatus,   ic.vendor_min_qty as vendorMinQty,requested_qty as requestedQty,pod.purchase_requisition_number as requisitionNo ,pqd.purchase_requisition_id as requisitionId, case when null_or_empty(pod.purchase_uom::text) = true then case when null_or_empty(pod.vendor_uom::text) = false then  pod.vendor_uom else pqd.vendor_uom end else pod.purchase_uom end as purchaseUOM , (select uom from uom where uom_id =case when null_or_empty(pod.purchase_uom::text) = true then case when null_or_empty(pod.vendor_uom::text) = false then  pod.vendor_uom else pqd.vendor_uom end else pod.purchase_uom end limit 1)  as purchaseUOMName  ,coalesce(pod.purchase_qty,0) as purchaseQty  from purchase_order_detail pod left join item_new item on item.item_id = pod.item_id left join purchase_order po on po.purchase_order_id = pod.purchase_order_id  left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id left join purchase_quote pq on pq.purchase_quote_id = pqd.purchase_quote_id left join def_table on def_table.def_table_id = pod.po_status  left join uom on uom.uom_id = pqd.vendor_uom left join item_vendor ic on ic.entity_id = pq.entity_id and ic.item_id=pqd.item_id where pod.purchase_order_id = ?  order by purchase_order_detail_id desc";
	// PO get details Without PQ table
	// public static final String GET_PURCHASE_ORDER_DETAIL =
	// "select distinct purchase_order_detail_id as purchaseOrderDetailId,
	// item.item_code as purchaseItemCode,
	// concat(item.item_code,'-',item.item_name)
	// as purchaseItemName, item.item_description as
	// purchaseItemDesc,item.item_id
	// as itemId, po.vendor_id as vendorId1, pod.quantity as quantity,
	// pod.unit_price as unitPrice, pod.po_status as
	// purchaseStatusId,pod.purchase_order_id as purchaseOrderId,
	// pod.purchase_quote_detail_id as purchaseQuoteDetailId ,0 as
	// edit,def_table.value as purchaseStatus, ic.vendor_min_qty as
	// vendorMinQty,requested_qty as requestedQty ,tax_cgst as taxCGST,tax_sgst
	// as
	// taxSGST,tax_igst as taxIGST from purchase_order_detail pod left join
	// item_new
	// item on item.item_id = pod.item_id inner join purchase_order po on
	// po.purchase_order_id = pod.purchase_order_id left join def_table on
	// def_table.def_table_id = pod.po_status left join item_vendor ic on
	// ic.entity_id = (select entity_id from entity where supplier_acct_code =
	// po.vendor_id) and ic.item_id=pod.item_id where pod.purchase_order_id = ?
	// order by purchase_order_detail_id";
	public static final String GET_PURCHASE_ORDER_ID = "select purchase_order_id from purchase_order where purchase_order_no = ?";

	// public static final String GET_PURCHASE_ORDER_NUMBER =
	// "SELECT CASE WHEN MAX(purchase_order_no) IS NULL THEN 'PO0001' ELSE
	// 'PO'||
	// lpad(cast(max(cast(SUBSTRING(purchase_order_no,3,10) as int)+1) as
	// text),4,'0') END from purchase_order where purchase_order_no like 'PO%'";

	// public static final String GET_PURCHASE_ORDER_NUMBER_CAPX =
	// "SELECT CASE WHEN MAX(purchase_order_no) IS NULL THEN 'CX-PO0001' ELSE
	// 'CX-PO'|| lpad(cast(max(cast(SUBSTRING(purchase_order_no,6,13) as int)+1)
	// as
	// text),4,'0') END from purchase_order where purchase_order_no like
	// 'CX-PO%' ";
	// for different seq
	// public static final String GET_PURCHASE_ORDER_NUMBER_CAPX_1 =
	// "SELECT CASE WHEN MAX(purchase_order_no) IS NULL THEN 'CX-PO0001' ELSE
	// 'CX-PO'|| lpad(cast(max(cast(SUBSTRING(purchase_order_no,6,4) as int)+2)
	// as
	// text),4,'0') END from purchase_order where purchase_order_no like
	// 'CX-PO%'
	// and company_id = ? ";
	public static final String GET_PURCHASE_ORDER_NUMBER_CAPX = "SELECT CASE WHEN MAX(purchase_order_no) IS NULL  THEN 'CX-PO0001' ELSE 'CX-PO'|| lpad(cast(max(cast(SUBSTRING(purchase_order_no,6,4) as int)+1) as text),4,'0') END from purchase_order where purchase_order_no like 'CX-PO%' and company_id = ? ";

	public static final String GET_PURCHASE_ORDER_NUMBER_CAPX1 = "SELECT CASE WHEN MAX(purchase_order_no) IS NULL  THEN 'CPO-PO0001' ELSE 'CPO-PO'|| lpad(cast(max(cast(RIGHT(purchase_order_no,4) as int)+1) as text),4,'0') END from purchase_order where purchase_order_no like ? and po_amendment is  null";

	public static final String GET_PO_NO = "select MAX( purchase_order_no) from purchase_order  where purchase_order_no like ? ";

	public static final String GET_PURCHASE_ORDER_NUMBER = "SELECT CASE WHEN MAX(purchase_order_no) IS NULL  THEN ? ELSE 'PO'|| lpad(cast(max(cast(SUBSTRING(purchase_order_no,6,4) as int)+1) as text),4,'0') END from purchase_order where purchase_order_no like '%PO%'";

	public static final String GET_PURCHASE_ORDER_NUMBER_EXIST = "SELECT CASE WHEN MAX(purchase_order_no) IS NULL  THEN ? ELSE  lpad(cast(max(cast(SUBSTRING(purchase_order_no,6,4) as int)+1) as text),4,'0') END from purchase_order where purchase_order_no like '%?%'";

	public static final String GET_PURCHASE_ORDER_AMENDMENT_EXIST = "select count(purchase_order_no) from purchase_order where po_amendment = ? ";

	// public static final String GET_PURCHASE_ORDER_AMENDMENT_EXIST =
	// "select count(purchase_order_no) from purchase_order where
	// purchase_order_no
	// = ? ";

	public static final String GET_PURCHASE_ORDER_NO_EXIST = "select purchase_order_no from purchase_order where purchase_order_no = ?";

	public static final String GET_PURCHASE_ORDER_NO_EXIST1 = "select count(purchase_order_no) from purchase_order where purchase_order_no = ?";

	public static final String GET_PURCHASE_ORDER_NO = "select purchase_order_no from purchase_order where purchase_order_id = ?";

	// public static final String GET_PURCHASE_ORDER_NUMBER_REVEX =
	// "SELECT CASE WHEN MAX(purchase_order_no) IS NULL THEN 'RX-PO0001' ELSE
	// 'RX-PO'|| lpad(cast(max(cast(SUBSTRING(purchase_order_no,6,13) as int)+1)
	// as
	// text),4,'0') END from purchase_order where purchase_order_no like
	// 'RX-PO%'";

	// for different seq

	public static final String GET_PURCHASE_ORDER_NUMBER_REVEX = "SELECT CASE WHEN MAX(purchase_order_no) IS NULL  THEN 'RX-PO0001' ELSE 'RX-PO'|| lpad(cast(max(cast(SUBSTRING(purchase_order_no,6,4) as int)+1) as text),4,'0') END from purchase_order where purchase_order_no like 'RX-PO%' and company_id = ? ";

	public static final String GET_PURCHASE_ORDER_NUMBER_REVEX1 = "SELECT CASE WHEN MAX(purchase_order_no) IS NULL  THEN 'RPO-PO0001' ELSE 'RPO-PO'|| lpad(cast(max(cast(RIGHT(purchase_order_no,4) as int)+1) as text),4,'0') END from purchase_order where purchase_order_no like ? and po_amendment is  null";

	public static final String GET_APPROVED_PURCHASE_REQUEST = "select coalesce(purchase_quote_detail.quantity,0) vendorQuantity, purchase_quote_detail_id as purchaseQuoteDetailId,pq.fixed_price as fixedPrice,pq.fixed_quantity as fixedQuantity,to_char(purchase_quote_detail.edd, 'dd/mm/yyyy') as edd,item.item_code as purchaseItemCode,def_table.value as purchaseStatus,concat(item.item_code,'-', item.item_name) as purchaseItemName,pq.payment_terms as paymentTerms ,tax_amount as tax ,item.item_description as purchaseItemDesc, pr.requisition_number as purchaseRequestNum,purchase_quote_detail.quantity as quantity ,purchase_quote_detail.delivery_lead_time as deliveryLeadTime,purchase_quote_detail.unit_price as unitPrice ,item.item_id as itemId ,purchase_quote_detail.quote_status as  purchaseStatusId,purchase_quote_detail.vendor_uom as uom,uom.uom as uomName,entity.entity_name as vendorName, 1 as edit,pq.freight as frieght,ic.vendor_min_qty as vendorMinQty,pq.valid_to_date as quoteMaxDate,purchase_quote_detail.purchase_quantity as quantity from purchase_quote_detail inner join purchase_quote pq on  pq.purchase_quote_id = purchase_quote_detail.purchase_quote_id inner join purchase_requisition pr on pr.purchase_requisition_id =  purchase_quote_detail.purchase_requisition_id left join entity on entity.entity_id = pq.entity_id left join item_new item on item.item_id = purchase_quote_detail.item_id left join def_table on def_table.def_table_id = purchase_quote_detail.quote_status left join uom on uom.uom_id = purchase_quote_detail.vendor_uom left join item_vendor ic on ic.entity_id = pq.entity_id and ic.item_id=purchase_quote_detail.item_id where def_table.def_table_id = ? and  ( pq.valid_from_date, pq.valid_to_date) OVERLAPS ( to_date(?,'dd/mm/yyyy') -interval '1'day,to_date(?,'dd/mm/yyyy') +interval '1'day) and pq.entity_id =(select entity_id from entity where  supplier_acct_code=? limit 1) and pq.purchase_type = ? and purchase_quote_detail_id not in (select pod.purchase_quote_detail_id from purchase_order_detail pod where purchase_quote_detail_id is not null) order by pr.requisition_number desc";
	// public static final String GET_PURCHASE_ORDER_NUMBER_REVEX_1 =
	// "SELECT CASE WHEN MAX(purchase_order_no) IS NULL THEN 'RX-PO0001' ELSE
	// 'RX-PO'|| lpad(cast(max(cast(SUBSTRING(purchase_order_no,6,4) as int)+2)
	// as
	// text),4,'0') END from purchase_order where purchase_order_no like
	// 'RX-PO%'
	// and company_id = ? ";

	// public static final String GET_APPROVED_PURCHASE_REQUEST1 =
	// "select coalesce(purchase_quote_detail.quantity,0) vendorQuantity,
	// purchase_quote_detail_id as purchaseQuoteDetailId,pq.purchase_quote_no as
	// purchaseQuoteId,pq.fixed_price as fixedPrice,pq.fixed_quantity as
	// fixedQuantity,to_char(purchase_quote_detail.edd, 'dd/mm/yyyy') as
	// edd,item.item_code as purchaseItemCode,def_table.value as
	// purchaseStatus,concat(item.item_code,'-', item.item_name) as
	// purchaseItemName,pq.payment_terms as paymentTerms ,tax_amount as tax
	// ,tax_cgst as taxCGST,tax_sgst as taxSGST,tax_igst as
	// taxIGST,discount_amount
	// as discount,item.item_description as purchaseItemDesc,
	// pr.requisition_number
	// as purchaseRequestNum,purchase_quote_detail.quantity as quantity ,
	// purchase_quote_detail.delivery_lead_time as
	// deliveryLeadTime,purchase_quote_detail.unit_price as unitPrice ,
	// item.item_id
	// as itemId ,purchase_quote_detail.quote_status as
	// purchaseStatusId,purchase_quote_detail.vendor_uom as uom, uom.uom as
	// uomName,entity.entity_name as vendorName, 1 as edit,pq.freight as
	// frieght,ic.vendor_min_qty as vendorMinQty, pq.valid_to_date as
	// quoteMaxDate,purchase_quote_detail.purchase_quantity as
	// quantityId,pr.requisition_number as requisitionNo from
	// purchase_quote_detail
	// inner join purchase_quote pq on pq.purchase_quote_id =
	// purchase_quote_detail.purchase_quote_id inner join purchase_requisition
	// pr on
	// pr.purchase_requisition_id =
	// purchase_quote_detail.purchase_requisition_id
	// left join entity on entity.entity_id = pq.entity_id left join item_new
	// item
	// on item.item_id = purchase_quote_detail.item_id left join def_table on
	// def_table.def_table_id = purchase_quote_detail.quote_status left join uom
	// on
	// uom.uom_id = purchase_quote_detail.vendor_uom left join item_vendor ic on
	// ic.entity_id = pq.entity_id and ic.item_id=purchase_quote_detail.item_id
	// where def_table.def_table_id = ? and pq.entity_id =(select entity_id from
	// entity where supplier_acct_code=? limit 1) and pq.purchase_type =? and
	// purchase_quote_detail_id not in (select pod.purchase_quote_detail_id from
	// purchase_order_detail pod where purchase_quote_detail_id is not null)
	// order
	// by purchase_quote_detail_id desc ";

	// select itemdesc from pr table
	// public static final String GET_APPROVED_PURCHASE_REQUEST1 =
	// "select coalesce(purchase_quote_detail.quantity,0) vendorQuantity,
	// purchase_quote_detail_id as purchaseQuoteDetailId,pq.purchase_quote_no as
	// purchaseQuoteId,pq.fixed_price as fixedPrice,pq.fixed_quantity as
	// fixedQuantity,to_char(purchase_quote_detail.edd, 'dd/mm/yyyy') as
	// edd,item.item_code as purchaseItemCode,def_table.value as
	// purchaseStatus,concat(item.item_code,'-', item.item_name) as
	// purchaseItemName,pq.payment_terms as paymentTerms ,tax_amount as tax
	// ,tax_cgst as taxCGST,tax_sgst as taxSGST,tax_igst as
	// taxIGST,discount_amount
	// as discount,(select pr.item_desc itemDescription from
	// purchase_requisition_detail pr, item_new i left JOIN UOM ON uom.uom_id =
	// i.uom left join item_vendor iv on iv.item_id = i.item_id left join uom u
	// on
	// u.uom_id = iv.vendor_uom_id where pr.item_id = item.item_id and
	// pr.purchase_requisition_id =
	// purchase_quote_detail.purchase_requisition_id
	// limit 1) as purchaseItemDesc , pr.requisition_number as
	// purchaseRequestNum,purchase_quote_detail.quantity as quantity ,
	// purchase_quote_detail.delivery_lead_time as
	// deliveryLeadTime,purchase_quote_detail.unit_price as unitPrice ,
	// item.item_id
	// as itemId ,purchase_quote_detail.quote_status as
	// purchaseStatusId,purchase_quote_detail.vendor_uom as uom, uom.uom as
	// uomName,entity.entity_name as vendorName, 1 as edit,pq.freight as
	// frieght,ic.vendor_min_qty as vendorMinQty, pq.valid_to_date as
	// quoteMaxDate,purchase_quote_detail.purchase_quantity as
	// quantityId,pr.requisition_number as requisitionNo from
	// purchase_quote_detail
	// inner join purchase_quote pq on pq.purchase_quote_id =
	// purchase_quote_detail.purchase_quote_id inner join purchase_requisition
	// pr on
	// pr.purchase_requisition_id =
	// purchase_quote_detail.purchase_requisition_id
	// left join entity on entity.entity_id = pq.entity_id left join item_new
	// item
	// on item.item_id = purchase_quote_detail.item_id left join def_table on
	// def_table.def_table_id = purchase_quote_detail.quote_status left join uom
	// on
	// uom.uom_id = purchase_quote_detail.vendor_uom left join item_vendor ic on
	// ic.entity_id = pq.entity_id and ic.item_id=purchase_quote_detail.item_id
	// where def_table.def_table_id = ? and pq.entity_id =(select entity_id from
	// entity where supplier_acct_code=? limit 1) and pq.purchase_type =? and
	// purchase_quote_detail_id not in (select pod.purchase_quote_detail_id from
	// purchase_order_detail pod where purchase_quote_detail_id is not null)
	// order
	// by purchase_quote_detail_id desc ";

	public static final String GET_APPROVED_PURCHASE_REQUEST1 = "select coalesce(purchase_quote_detail.quantity,0) vendorQuantity, purchase_quote_detail_id as purchaseQuoteDetailId,pq.purchase_quote_no as purchaseQuoteId,pq.fixed_price as fixedPrice,pq.fixed_quantity as fixedQuantity,to_char(purchase_quote_detail.edd, 'dd/mm/yyyy') as edd,item.item_code as purchaseItemCode,def_table.value as purchaseStatus,concat(item.item_code,'-', item.item_name) as purchaseItemName,pq.payment_terms as paymentTerms ,purchase_quote_detail.cost_center as costcenter,tax_amount as tax ,round (tax_cgst::DECIMAL, 2) as taxCGST,round (tax_sgst::DECIMAL, 2) as taxSGST,round (tax_igst::DECIMAL, 2)  as taxIGST,coalesce(tax_cgst_percent,0) taxCGSTinPercent,coalesce(tax_sgst_percent,0) taxSGSTinPercent,coalesce(tax_igst_percent,0) taxIGSTinPercent,round (discount_amount::DECIMAL, 2) as discount,discount_type as discountType ,purchase_quote_detail.item_description as purchaseItemDesc , pr.requisition_number as purchaseRequestNum,purchase_quote_detail.quantity as quantity , purchase_quote_detail.delivery_lead_time as deliveryLeadTime,purchase_quote_detail.unit_price as unitPrice , item.item_id as itemId ,purchase_quote_detail.quote_status as  purchaseStatusId,purchase_quote_detail.vendor_uom as uom, uom.uom as uomName,entity.entity_name as vendorName, 1 as edit,pq.freight as frieght,ic.vendor_min_qty as vendorMinQty, pq.valid_to_date as quoteMaxDate,purchase_quote_detail.purchase_quantity as purchaseQuantity,concat(pr.requisition_number,'-',pr.pr_request_number) as requisitionNo, pr.purchase_requisition_id as requisitionId,coalesce((select pending_quantity from purchase_requisition_detail where purchase_requisition_id = pr.purchase_requisition_id and item_id = item.item_id limit 1),0) as pendingQty ,(select quantity from purchase_requisition_detail prd where prd.purchase_requisition_id = purchase_quote_detail.purchase_requisition_id and prd.item_id = purchase_quote_detail.item_id limit 1) as requestedQty  ,COALESCE((select sum(quantity) from purchase_quote_detail prd where prd.purchase_requisition_id = purchase_quote_detail.purchase_requisition_id and prd.item_id = purchase_quote_detail.item_id),0) + COALESCE((select sum(quantity) from stock_transfer_detail std inner join stock_transfer st on purchase_requisition_id = st.purchase_requisition_id where purchase_requisition_id =purchase_quote_detail.purchase_requisition_id  and item_id = purchase_quote_detail.item_id),0) as pqQuantity,purchase_uom::text  as purchaseUOM, (select uom from uom where uom_id = purchase_uom limit 1)  as purchaseUOMName ,coalesce(purchase_qty,0) as purchaseQty   from purchase_quote_detail  inner join purchase_quote pq on  pq.purchase_quote_id = purchase_quote_detail.purchase_quote_id inner join purchase_requisition pr on pr.purchase_requisition_id =  purchase_quote_detail.purchase_requisition_id  left join entity on entity.entity_id = pq.entity_id left join item_new item  on item.item_id = purchase_quote_detail.item_id  left join def_table on def_table.def_table_id = purchase_quote_detail.quote_status  left join uom on uom.uom_id = purchase_quote_detail.vendor_uom  left join item_vendor ic on ic.entity_id = pq.entity_id and ic.item_id=purchase_quote_detail.item_id  where def_table.def_table_id = ? and pq.entity_id =(select entity_id from entity where  supplier_acct_code=? limit 1) and pq.purchase_type =? and  po_number = ? and purchase_quote_detail_id not in (select pod.purchase_quote_detail_id from purchase_order_detail pod where purchase_quote_detail_id is not null)  order by purchase_quote_detail_id asc ";

	public static final String GET_TAX_AMOUNT_DETAILS_PQ = "select dt_dis.value  discountType, pod.percentage dicountPercentage,pod.discount_amount discountAmount, " + "pod.tax_percentage taxPercentage,pod.tax_amount taxAmount ,round (pod.tax_cgst::DECIMAL, 2)  as taxCGST ,round (pod.tax_sgst::DECIMAL, 2)  as taxSGST ,round (pod.tax_igst::DECIMAL, 2)  as taxIGST,pod.tax_cgst_percent as taxCGSTinPercent,pod.tax_sgst_percent as taxSGSTinPercent,pod.tax_igst_percent as taxIGSTinPercent from purchase_quote_detail pod "
			+ " left join def_table dt_dis on dt_dis.def_table_id =  pod.discount_type " + "where pod.purchase_quote_detail_id = ?";
	public static final String GET_TAX_AMOUNT_DETAILS_PO = "select dt_dis.value  discountType, pod.discount_percent dicountPercentage,pod.discount_amount discountAmount, " + "pod.tax_amount taxAmount ,pod.tax_cgst as taxCGST ,pod.tax_sgst as taxSGST ,pod.tax_igst as taxIGST,pod.tax_cgst_percent as taxCGSTinPercent,pod.tax_sgst_percent as taxSGSTinPercent,pod.tax_igst_percent as taxIGSTinPercent from purchase_order_detail pod " + " left join def_table dt_dis on dt_dis.def_table_id =  pod.discount_type " + "where pod.purchase_order_detail_id = ?";
	// public static final String GET_TAX_AMOUNT_DETAILS =
	// "select pod.discount discountAmount, pod.tax_amount taxAmount
	// ,coalesce(pod.tax_cgst,0.0) as taxCGST, coalesce(pod.tax_sgst,0.0) as
	// taxSGST
	// ,coalesce(pod.tax_igst,0.0) as taxIGST ,pod.tax_cgst_percent as
	// taxCGSTinPercent,pod.tax_sgst_percent as
	// taxSGSTinPercent,pod.tax_igst_percent as taxIGSTinPercent from
	// purchase_order_detail pod where pod.purchase_order_detail_id = ?";

	public static final String GET_TAX_AMOUNT_DETAILS = "select dt_dis.value  discountType,  pod.discount discountAmount, pqd.percentage  dicountPercentage, pod.tax_amount taxAmount ,coalesce(pod.tax_cgst,0.0) as taxCGST, coalesce(pod.tax_sgst,0.0) as taxSGST ,coalesce(pod.tax_igst,0.0) as taxIGST ,pqd.tax_cgst_percent as taxCGSTinPercent,pqd.tax_sgst_percent as taxSGSTinPercent,pqd.tax_igst_percent as taxIGSTinPercent from purchase_order_detail pod   left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id left join def_table dt_dis on dt_dis.def_table_id =  pqd.discount_type   where pod.purchase_order_detail_id = ?";

	public static final String GET_TAX_AMOUNT_DETAILS1 = "select dt_dis.value  discountType, pod.percentage dicountPercentage,pod.discount_amount discountAmount, " + "pod.tax_percentage taxPercentage,pod.tax_amount taxAmount ,tax_cgst as taxCGST ,tax_sgst as taxSGST ,tax_igst as taxIGST from purchase_quote_detail pod " + " left join def_table dt_dis on dt_dis.def_table_id =  pod.discount_type " + "where pod.purchase_quote_detail_id = ?";

	public static final String UPDATE_PURCHASE_ORDER_STATUS = "UPDATE purchase_order SET " + " po_status=?,po_approved_by=?,po_approved_by_name=? WHERE purchase_order_id = ?";

	public static final String INSERT_RATE_CONTRACT_DELIVERY_SCHEDULE = "INSERT INTO purchase_order_delivery_schedule" + "(item_id, item_qty,delivery_date,purchase_order_detail_id,pending_qty,  " + " created_by, created_date) " + "VALUES (?, ?,to_date(?,'dd/mm/yyyy'),?,?,?, current_date)  ";

	public static final String DELETE_RATE_CONTRACT_DELIVERY_SCHEDULE = "DELETE FROM purchase_order_delivery_schedule WHERE " + "purchase_order_detail_id = ?";

	public static final String DELETE_RATE_CONTRACT_DELIVERY_SCHEDULE_ID = "DELETE FROM purchase_order_delivery_schedule WHERE " + "purchase_delivery_schedule_id = ?";

	public static final String DELETE_RATE_CONTRACT_DELIVERY_SCHEDULE_BY_ITEM = "DELETE FROM purchase_order_delivery_schedule WHERE " + "purchase_order_detail_id = ? and purchase_delivery_schedule_id=?";

	public static final String UPDATE_RATE_CONTRACT_DELIVERY_SCHEDULE = "UPDATE purchase_order_delivery_schedule SET item_id=?, item_qty=?, pending_qty=?, " + "delivery_date=to_date(?,'dd/mm/yyyy'),modified_by=?," + "modified_on=current_date WHERE purchase_delivery_schedule_id = ?";

	public static final String CHECK_RATE_CONTRACT_DELIVERY_SCHEDULE = "select * from purchase_order_delivery_schedule where purchase_delivery_schedule_id=?";

	public static final String GET_PURCHASE_ORDER_DELIVERY_STATUS = "select purchase_delivery_schedule_id as purchaseDeliveryId," + " item_id as itemId,item_qty as quantity, coalesce(pending_qty,0) as pendingQty, " + " to_char(delivery_date, 'dd/mm/yyyy') as purchaseOrderDeliveryDate,purchase_order_detail_id as purchaseOrderDetailId,0 as edit" + " from purchase_order_delivery_schedule where purchase_order_detail_id in (select purchase_order_detail_id" + " from purchase_order_detail"
			+ " where purchase_order_id = ?) order by purchase_order_detail_id";

	public static final String DELETE_PURCHASE_DELIVERY_SCHEDULE = "DELETE FROM purchase_order_delivery_schedule " + " WHERE purchase_order_detail_id in (select purchase_order_detail_id " + " from purchase_order_detail where purchase_order_id = ?)";

	public static final String GET_PURCHASE_ORDER_AMENDMENT_LIST = "SELECT purchase_order_id as purchaseOrderId,   purchase_order_no as purchaseOrderNum,   to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, company.short_name as companyName, entity.entity_name as vendorName,   location.location_name as locationName ,  terms_condition as termsCondition, remarks as remarks,sub_total as subTotal,   total_discount as totalDiscount,   total_tax as totalTax ,freight as freight,po_status as statusId,\n"
			+ "case when   (select sum(quantity) from purchase_order_detail where purchase_order_id = purchase_order.purchase_order_id) = (select sum(quantity) from grn_detail where grn_detail.purchase_order_detail_id in (select purchase_order_detail_id from purchase_order_detail where purchase_order_id =purchase_order.purchase_order_id)) then 'GRN Done'  else dfs.value end  as purchaseStatus,case when request_type='PO' then 'Purchase Order' when request_type='WO' then 'Work Order' else null end as reqType ,(select value  from def_table inner join form_field ff on ff.form_field_id  = def_table.form_field_id where def_table_id = purchase_type)purchaseTypeName FROM purchase_order   inner join company on company.company_id = purchase_order.company_id   inner join entity on entity.supplier_acct_code = purchase_order.vendor_id    Left join location on location.location_id=purchase_order.location_id   left join def_table dfs on   dfs.def_table_id = purchase_order.po_status  where purchase_order.po_status != all( ?::int[] ) order by purchase_order_id desc";

	public static final String GET_PURCHASE_DETAIL_FOR_AUTO_JV = "select vendor_id as vendorId,company_id as companyId,total_amount as totalAmount,TO_CHAR(purchase_date,'dd-mm-yyyy') purchaseOrderDate,purchase_order_no as purchaseOrderNum from purchase_order where purchase_order_id =?";

	// public static final String GET_PURCHASE_ORDER_AMENDMENT_DETAIL =
	// "select coalesce(pqd.purchase_quantity,0) purchaseQuantity
	// ,coalesce(pqd.quantity,0) vendorQuantity, item.item_code as
	// purchaseItemCode,coalesce(pod.tax_amount ,0.0)as tax,
	// coalesce(pod.tax_cgst
	// ,0.0)as taxCGST, coalesce(pod.tax_sgst ,0.0)as taxSGST,
	// coalesce(pod.tax_igst
	// ,0.0)as taxIGST, "
	// + " concat(item.item_code,'-',item.item_name) " +
	// " as purchaseItemName, pq.fixed_price as fixedPrice,pq.fixed_quantity as
	// fixedQuantity, "
	// +
	// " item.item_description as purchaseItemDesc,item.item_id as
	// itemId,entity.entity_name as vendorName, "
	// +
	// " po.vendor_id as vendorId,to_char(pqd.edd, 'dd/mm/yyyy') as
	// edd,pqd.vendor_uom as uom,uom.uom as uomName,pod.quantity as quantity, "
	// +
	// " pqd.delivery_lead_time as deliveryLeadTime,pod.unit_price as
	// unitPrice,pod.po_status as purchaseStatusId, "
	// +
	// " pod.purchase_order_detail_id as
	// purchaseOrderDetailId,pod.purchase_order_id
	// as purchaseOrderId, "
	// +
	// " pod.purchase_quote_detail_id as purchaseQuoteDetailId ,0 as
	// edit,def_table.value as purchaseStatus,ic.vendor_min_qty as vendorMinQty,
	// "
	// + " case when grnQty.qty is not null and coalesce(grnQty.qty,0) > 0 " +
	// " then coalesce((coalesce(pod.quantity,0)-coalesce(grnQty.qty,0)),0) " +
	// " when grnQty.qty is not null and coalesce(grnQty.qty,0) = 0 then
	// coalesce(grnQty.qty,0) else null end as "
	// + " pendingQnty " + " from purchase_order_detail pod " +
	// " left join item on item.item_id = pod.item_id inner join purchase_order
	// po
	// on "
	// +
	// " po.purchase_order_id = pod.purchase_order_id left join entity on
	// entity_id
	// =(select entity_id from entity where supplier_acct_code = po.vendor_id)"
	// +
	// " inner join purchase_quote_detail pqd on pqd.purchase_quote_detail_id =
	// pod.purchase_quote_detail_id "
	// +
	// " inner join purchase_quote pq on pq.purchase_quote_id =
	// pqd.purchase_quote_id "
	// + " left join def_table on def_table.def_table_id = pod.po_status " +
	// " left join uom on uom.uom_id = pqd.vendor_uom " +
	// " left join item_vendor ic on ic.entity_id = pq.entity_id and
	// ic.item_id=pqd.item_id "
	// +
	// " left join (select grn.item_id,
	// grn.qty,pd.purchase_order_id,grn.purchase_order_detail_id from "
	// +
	// " (select item_id,sum(quantity) qty,purchase_order_detail_id from
	// grn_detail
	// "
	// +
	// " group by item_id,purchase_order_detail_id having
	// purchase_order_detail_id
	// in "
	// +
	// " (select purchase_order_detail_id from purchase_order_detail where
	// purchase_order_id = ? )) grn "
	// +
	// " left join purchase_order_detail pd on grn.purchase_order_detail_id =
	// pd.purchase_order_detail_id) grnQty "
	// + " on grnQty.purchase_order_detail_id = pod.purchase_order_detail_id "
	// + " where pod.purchase_order_id = ? ";

	public static final String GET_PURCHASE_ORDER_AMENDMENT_DETAIL = "select coalesce(pqd.purchase_quantity,0) purchaseQuantity , pod.cost_center as costcenter,coalesce(pod.quantity,0) vendorQuantity, item.item_code as purchaseItemCode,coalesce(pod.tax_amount ,0.0)as tax, coalesce(pod.tax_cgst ,0.0)as taxCGST, coalesce(pod.tax_sgst ,0.0)as taxSGST, coalesce(pod.tax_igst ,0.0)as taxIGST, coalesce(pod.tax_cgst_percent,0) taxCGSTinPercent,coalesce(pod.tax_sgst_percent,0) taxSGSTinPercent,coalesce(pod.tax_igst_percent,0) taxIGSTinPercent, concat(item.item_code,'-',item.item_name)   as purchaseItemName, pq.fixed_price as fixedPrice,pq.fixed_quantity as fixedQuantity,  item.item_description as purchaseItemDesc,item.item_id as itemId,entity.entity_name as vendorName,  po.vendor_id as vendorId,to_char(pqd.edd, 'dd/mm/yyyy') as edd,pqd.vendor_uom as uom,uom.uom as uomName,pod.quantity as quantity,  pqd.delivery_lead_time as deliveryLeadTime,pod.unit_price as unitPrice,pod.po_status as purchaseStatusId,  pod.purchase_order_detail_id as purchaseOrderDetailId,pod.purchase_order_id as purchaseOrderId,  pod.purchase_quote_detail_id as purchaseQuoteDetailId ,0 as edit,def_table.value as purchaseStatus,ic.vendor_min_qty as vendorMinQty,  case when grnQty.qty is not null and coalesce(grnQty.qty,0) > 0   then coalesce((coalesce(pod.quantity,0)-coalesce(grnQty.qty,0)),0)  when grnQty.qty is not null and coalesce(grnQty.qty,0) = 0 then coalesce(grnQty.qty,0) else null end as  pendingQnty ,pod.purchase_requisition_number as requisitionNo,pqd.purchase_requisition_id as requisitionId, pod.purchase_uom as purchaseUOM , (select uom from uom where uom_id = pod.purchase_uom limit 1)  as purchaseUOMName ,coalesce(pod.purchase_qty,0) as purchaseQty   from purchase_order_detail pod  left join item_new item on item.item_id = pod.item_id inner join purchase_order po on  po.purchase_order_id = pod.purchase_order_id  left join entity on entity_id = (select entity_id from entity where supplier_acct_code = po.vendor_id limit 1) inner join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id inner join purchase_quote pq on pq.purchase_quote_id = pqd.purchase_quote_id left join def_table on def_table.def_table_id = pod.po_status left join uom on uom.uom_id = pqd.vendor_uom left join item_vendor ic on ic.entity_id = pq.entity_id and ic.item_id=pqd.item_id left join (select  grn.item_id, grn.qty,pd.purchase_order_id,grn.purchase_order_detail_id from  (select item_id,sum(quantity) qty,purchase_order_detail_id from grn_detail  group by item_id,purchase_order_detail_id having purchase_order_detail_id in  (select purchase_order_detail_id from purchase_order_detail where purchase_order_id = ? )) grn  left join purchase_order_detail pd on grn.purchase_order_detail_id = pd.purchase_order_detail_id) grnQty  on grnQty.purchase_order_detail_id = pod.purchase_order_detail_id   where pod.purchase_order_id = ?";

	public static final String INSERT_PURCHASE_ORDER_AMENDMENT_DETAIL = "INSERT INTO purchase_order_detail(item_id, purchase_quote_detail_id,quantity," + " po_status, unit_price, purchase_order_id,discount,tax_amount,amended_po_number,tax_cgst,tax_sgst,tax_igst) " + "VALUES (?, ?,?, ?, ?, ?,?,?,?,?,?,?) returning purchase_order_detail_id ";
	public static final String UPDATE_MPO_FLAG = "update purchase_order set mpo_flag = 'Y' where purchase_order_no = ?";
	// public static final String UPDATE_PURCHASE_ORDER_AMENDMENT_DETAIL =
	// "UPDATE purchase_order_detail SET item_id=?," +
	// " purchase_quote_detail_id=?, " +
	// "quantity=?, po_status=?, unit_price=?, purchase_order_id=?,discount =
	// ?,tax_amount=?,amended_po_number=? "
	// + "WHERE purchase_order_detail_id = ?";

	public static final String UPDATE_PURCHASE_ORDER_AMENDMENT_DETAIL = "UPDATE purchase_order_detail SET item_id=?, purchase_quote_detail_id=?, quantity=?, po_status=?, unit_price=?, purchase_order_id=?,discount = ?,tax_amount=?,amended_po_number=?,tax_cgst  =? , tax_sgst  =? ,tax_igst  =? WHERE purchase_order_detail_id = ?";

	// Commend for GST update
	// public static final String UPDATE_PURCHASE_ORDER_AMENDMENT =
	// "UPDATE purchase_order SET sub_total=?, modified_by=
	// ?,total_discount=?,total_tax=?,total_amount = ?,modified_date =
	// current_date,freight = ?,po_status=?,reason_for_amendment=? WHERE
	// purchase_order_id = ?";

	public static final String UPDATE_PURCHASE_ORDER_AMENDMENT = "UPDATE purchase_order SET sub_total=?, modified_by= ?,total_discount=?,total_tax=?,total_amount = ?,modified_date = current_date,freight = ?,po_status=?,total_cgst =?, total_sgst =? , total_igst = ?, other_charges=?, reason_for_amendment=? WHERE purchase_order_id = ?";

	public static final String GET_STOCK_TRANSFER_NUMBER_EDIT = "select stock_transfer_id as id,stock_transfer_number as text from " + "stock_transfer where stock_transfer_type = ? order by stock_transfer_id desc";

	public static final String GET_STOCK_TRANSFER_NUMBER = "SELECT distinct stock.stock_transfer_id as id, stock.stock_transfer_number as text " + "from stock_transfer stock " + "inner join (select st.stock_transfer_id,st.stock_transfer_number " + "from stock_transfer st " + "inner join stock_transfer_detail std on std.stock_transfer_id = st.stock_transfer_id " + "where st.stock_transfer_type = ? " + "and st.status in ('Approved','Received','Partially Received') "
			+ "and std.stock_transfer_detail_id not in (select distinct stock_transfer_detail_id from stock_transfer_detail stdl " + "inner join purchase_order po on po.consignment_transfer_id = stdl.stock_transfer_id " + "inner join purchase_order_detail pod on pod.purchase_order_id = po.purchase_order_id " + "inner join purchase_order_detail prd on prd.item_id = stdl.item_id)) dtl on dtl.stock_transfer_id = stock.stock_transfer_id " + "order by stock.stock_transfer_number desc";

	public static final String GET_STOCK_TRANSFER_ITEM_DETAILS = "select item_id as itemId,quantity as quantity from stock_transfer_detail" + " where stock_transfer_id in(?)";

	public static final String GET_APPROVED_PURCHASE_REQUEST_FOR_CONSIGNMENT = "select purchase_quote_detail_id as purchaseQuoteDetailId,pq.purchase_quote_no as purchaseQuoteId,pq.fixed_price as fixedPrice,pq.fixed_quantity as fixedQuantity,to_char(purchase_quote_detail.edd, 'dd/mm/yyyy') as edd,item.item_code as purchaseItemCode,def_table.value as purchaseStatus,concat(item.item_code,'-', item.item_name) as purchaseItemName,pq.payment_terms as paymentTerms, "
			+ " tax.tax_amount as tax ,item.item_description as purchaseItemDesc,pr.requisition_number as purchaseRequestNum,purchase_quote_detail.quantity as quantity ,purchase_quote_detail.delivery_lead_time as deliveryLeadTime, purchase_quote_detail.unit_price as unitPrice ,item.item_id as itemId ,purchase_quote_detail.quote_status as  purchaseStatusId ,item.uom as uom,uom.uom as uomName,entity.entity_name as vendorName, 1 as edit, false as transfered,pq.freight as freight,ic.vendor_min_qty as vendorMinQty "
			+ " from purchase_quote_detail inner join purchase_quote pq on  pq.purchase_quote_id = purchase_quote_detail.purchase_quote_id inner join purchase_requisition pr on pr.purchase_requisition_id =  purchase_quote_detail.purchase_requisition_id left join entity on entity.entity_id = pq.entity_id left join item_new item on item.item_id = purchase_quote_detail.item_id left join def_table on def_table.def_table_id = purchase_quote_detail.quote_status left join tax on tax.tax_id = purchase_quote_detail.tax_id "
			+ " left join uom on uom.uom_id = item.uom left join item_vendor ic on ic.entity_id = pq.entity_id and ic.item_id=purchase_quote_detail.item_id where  def_table.def_table_id = ? and ( pq.valid_from_date, pq.valid_to_date) OVERLAPS ( to_date(?,'dd/mm/yyyy') -interval '1'day, to_date(?,'dd/mm/yyyy') +interval '1'day) and pq.entity_id = ? and pq.purchase_type = ? " + "and purchase_quote_detail_id not in (select pod.purchase_quote_detail_id from purchase_order_detail pod where purchase_quote_detail_id is not null) "
			+ "order by purchase_quote_detail_id desc";

	public static final String INSERT_CONSIGNMENT_ORDER = "INSERT INTO purchase_order( purchase_order_no, purchase_date, " + "purchase_for,purchase_type, company_id, vendor_id, location_id, terms_condition,remarks," + " po_status, created_by, created_date,sub_total,total_discount,total_tax,total_amount,freight,consignment_transfer_id,payment_terms) " + "VALUES (?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?,?,?, current_date,?,?,?,?,?,?,?) returning purchase_order_id  ";

	public static final String UPDATE_CONSIGNMENT_ORDER = "UPDATE purchase_order SET purchase_date=to_date(?,'dd/mm/yyyy'), purchase_for=?, " + "purchase_type=?, company_id=?," + " vendor_id=?, location_id=?, terms_condition=?,remarks=?,sub_total=?, modified_by= ?,total_discount=?,total_tax=?,total_amount = ?," + " po_status=?,modified_date = current_date,freight = ?,consignment_transfer_id = ? ,payment_terms = ? " + "WHERE purchase_order_id = ?";

	public static final String GET_TOTAL_PURCHASE_ORDER_FOR_CANCEL = "SELECT purchase_order_id as purchaseOrderId, purchase_order_no as" + " purchaseOrderNum,  " + "to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate,dftyp.value as purchaseForName," + "dftyp.value as purchaseTypeName, " + "company.short_name as companyName, entity.entity_name as vendorName," + "location.location_name as locationName ,  " + "terms_condition as termsCondition, remarks as remarks,sub_total as subTotal," + "total_discount as totalDiscount, "
			+ "total_tax as totalTax ,freight as freight,po_status as statusId,dfs.value as purchaseStatus," + "purchase_order.purchase_type as purchaseType  " + "FROM purchase_order  " + "inner join company on company.company_id = purchase_order.company_id " + "inner join entity on entity.supplier_acct_code = purchase_order.vendor_id  " + "Left join location on location.location_id = purchase_order.location_id " + "left join def_table dfs on   dfs.def_table_id = purchase_order.po_status "
			+ "left join def_table dftyp on dftyp.def_table_id = purchase_order.purchase_type " + "where purchase_order. po_status != all( ?::int[] ) and company.company_id = ? order by purchase_order_id desc ";

	public static final String GET_PURCHASE_ORDER_FILTERED_LIST = "SELECT purchase_order.purchase_order_id as purchaseOrderId, " + " purchase_order_no as purchaseOrderNum, " + " to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate,dftyp.value as purchaseForName, " + " dftyp.value as purchaseTypeName, " + " company.short_name as companyName, entity.entity_name as vendorName, " + " location.location_name as locationName ,  " + " terms_condition as termsCondition, remarks as remarks,sub_total as subTotal, " + " total_discount as totalDiscount, "
			+ " total_tax as totalTax ,freight as freight,purchase_order.po_status as statusId,dfs.value as purchaseStatus, " + " pod.quantity as detailQuantity,concat(item_code,'-',item_name) as detailItemName  " + " FROM purchase_order " + " inner join company on company.company_id = purchase_order.company_id " + " inner join entity on entity.supplier_acct_code = purchase_order.vendor_id  " + " inner join location on location.location_id = purchase_order.location_id " + " inner join def_table dfs on   dfs.def_table_id = purchase_order.po_status "
			+ " inner join def_table dftyp on dftyp.def_table_id = purchase_order.purchase_type " + " inner join purchase_order_detail pod  on pod.purchase_order_id = purchase_order.purchase_order_id " + "  inner join item on item.item_id = pod.item_id ";

	public static final String GET_SPLIT_PURCHASE_ORDER_LIST = "SELECT purchase_order_id as purchaseOrderId, " + "  purchase_order_no as purchaseOrderNum, " + "  to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate,dftyp.value as purchaseForName, " + "  dftyp.value as purchaseTypeName, " + "  company.short_name as companyName, entity.entity_name as vendorName, " + "  location.location_name as locationName ,  " + "  terms_condition as termsCondition, remarks as remarks,sub_total as subTotal, " + "  total_discount as totalDiscount, "
			+ "  total_tax as totalTax ,freight as freight,po_status as statusId,dfs.value as purchaseStatus " + "  FROM purchase_order " + "  inner join company on company.company_id = purchase_order.company_id " + "  inner join entity on entity.supplier_acct_code = purchase_order.vendor_id  " + "  Left join location on location.location_id = purchase_order.location_id " + "  left join def_table dfs on   dfs.def_table_id = purchase_order.po_status " + "  left join def_table dftyp on dftyp.def_table_id = purchase_order.purchase_type "
			+ "  where purchase_order.po_status != all( ?::int[] ) and purchase_order.purchase_type = ? order by purchase_order_id desc";

	public static final String UPDATE_PURCHASE_ORDER_CANCEL = "UPDATE purchase_order SET po_status=?,remarks = ?,po_approved_by=?,po_approved_by_name=? WHERE purchase_order_id = ?";

	public static final String UPDATE_PURCHASE_ORDER_CANCEL_BY_ITEM = "UPDATE purchase_order_detail SET po_status=? WHERE purchase_order_id = ?";

	public static final String GET_PURCHASE_ORDER_MERGE_LIST = "SELECT purchase_order_id as purchaseOrderId, " + " purchase_order_no as purchaseOrderNum, " + " to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, " + " company.short_name as companyName, entity.entity_name as vendorName, " + " location.location_name as locationName ,  " + " dfs.value as purchaseStatus,dftyp.value as purchaseTypeName,po_status as statusId, " + " purchase_order.location_id as locationId,purchase_order.vendor_id as vendorId, "
			+ " purchase_order.company_id as companyId  " + " FROM purchase_order " + " inner join company on company.company_id = purchase_order.company_id " + " inner join entity on entity.supplier_acct_code = purchase_order.vendor_id  " + " inner join location on location.location_id = purchase_order.location_id " + " inner join def_table dfs on   dfs.def_table_id = purchase_order.po_status " + " inner join def_table dftyp on dftyp.def_table_id = purchase_order.purchase_type "
			+ " where purchase_order.po_status != all( ?::int[] ) and company.company_id = ? " + " order by purchase_order.purchase_type ,po_status, " + " purchase_order.company_id,purchase_order.location_id,purchase_order_id  desc ";

	public static final String MERGE_PURCHASE_ORDER = "update purchase_order_detail set purchase_order_id = ? " + "where purchase_order_id = ?";

	public static final String UPDATE_PURCHASE_ORDER_RECOMMEND_STATUS = "UPDATE purchase_order SET " + " po_status=?,recommended_by=?,recommended_date=to_date(?,'dd/mm/yyyy'),recommended_remarks=?,total_amount=? WHERE purchase_order_id = ?";

	public static final String UPDATE_PURCHASE_ORDER_DETAIL_RECOMMEND_STATUS = "UPDATE purchase_order_detail SET item_id=?," + " purchase_quote_detail_id=?, " + " quantity=?,	unit_price=?,discount = ?,tax_amount=?,requested_qty=? WHERE purchase_order_detail_id = ?";

	public static final String deletePurchaseOrderDetail = "delete from purchase_order_detail where purchase_order_id = ?";

	public static final String GET_CANCELLED_PO_TOTAL = "select total_amount from purchase_order where purchase_order_id = ? ";

	public static final String GET_MERGED_PO_TOTAL = "select total_amount from purchase_order where purchase_order_id = ? ";

	public static final String UPDATE_MERGED_PO_TOTAL = "update purchase_order set total_amount = ?,freight=? where purchase_order_id = ? ";

	public static final String GET_APPROVED_CONSIGNMENT_REQUEST = "select coalesce(pqd.purchase_quantity,0) purchaseQuantity,coalesce(pqd.quantity,0) as vendorQuantity,std.stock_transfer_id, std.stock_transfer_detail_id, pqd.purchase_quote_detail_id as purchaseQuoteDetailId,  pq.purchase_quote_no as purchaseQuoteId,pq.fixed_price as fixedPrice, " + "pq.fixed_quantity as fixedQuantity,  to_char(pqd.edd, 'dd/mm/yyyy') as edd,item.item_code as purchaseItemCode,  def_table.value as purchaseStatus, "
			+ "concat(item.item_code,'-', item.item_name) as purchaseItemName,  pq.payment_terms as paymentTerms ,pqd.tax_amount as tax , " + "item.item_description as purchaseItemDesc,pr.requisition_number as purchaseRequestNum,std.quantity as quantity , " + "COALESCE(std.quantity,0) as duplicateQuantity, pqd.delivery_lead_time as deliveryLeadTime,pqd.unit_price as unitPrice , " + "std.item_id as itemId , pqd.quote_status as purchaseStatusId,pqd.vendor_uom as uom,uom.uom as uomName,entity.entity_name as vendorName,1 as edit, "
			+ "pq.freight as frieght,ic.vendor_min_qty as vendorMinQty,pq.valid_to_date as quoteMaxDate  from stock_transfer_detail std " + "inner join stock_transfer_detail stdb on stdb.stock_transfer_detail_id = std.batch_no_id " + "inner join stock_transfer stock on stock.stock_transfer_id = stdb.stock_transfer_id " + "inner join purchase_quote_detail pqd on pqd.purchase_quote_id = stock.purchase_quote_id  and pqd.item_id = std.item_id " + "inner join purchase_quote pq on  pq.purchase_quote_id = pqd.purchase_quote_id "
			+ "inner join purchase_requisition pr on pr.purchase_requisition_id =  pqd.purchase_requisition_id " + "left join entity on entity.entity_id = pq.entity_id " + "left join item_new item on item.item_id = std.item_id " + "left join def_table on def_table.def_table_id = pqd.quote_status " + "left join uom on uom.uom_id = pqd.vendor_uom " + "left join item_vendor ic on ic.entity_id = pq.entity_id and ic.item_id=std.item_id  where std.stock_transfer_id=? order by std.stock_transfer_detail_id asc";

	public static final String UPDATE_PURCHASE_ORDER_DETAIL_FOR_SPLIT = "UPDATE purchase_order_detail set quantity = ? where purchase_order_detail_id = ?";

	public static final String UPDATE_PURCHASE_ORDER_DETAIL_SPLIT = "UPDATE purchase_order_detail set quantity = ?, discount=? , tax_amount=?,unit_price=? where purchase_order_detail_id = ?";

	public static final String GET_CANCELLED_PO_FREIGHT = "select COALESCE(freight,0) as freight from purchase_order where purchase_order_id = ?";

	public static final String GET_MERGED_PO_FREIGHT = "select COALESCE(freight,0) as freight from purchase_order where purchase_order_id = ?";

	public static final String UPDATE_CANCELLED_PO_TOTAL = "update purchase_order set total_amount = ?,freight=? where purchase_order_id = ? ";

	public static final String GET_CANCEL_PURCHASE_ORDER_FREIGHT = "select COALESCE(freight,0) as freight from purchase_order where purchase_order_id = ?";

	public static final String GET_MERGE_PURCHASE_ORDER_FREIGHT = "select COALESCE(freight,0) as freight from purchase_order where purchase_order_id = ?";

	public static final String UPDATE_PURCHASE_ORDER_FREIGHT_MERGED = "update purchase_order set freight=? where purchase_order_id = ?";

	public static final String UPDATE_SPLIT_PO_FREIGHT_CHARGES = "update purchase_order set freight=? where purchase_order_id = ?";

	public static final String getTaxCodeName = "select tax_code as taxCode from tax where tax_id=?";

	public static final String getNotDeliveredSchedule = "select count(*) quantity from purchase_order as po " + "inner join purchase_order_detail as pod on  pod.purchase_order_id=po.purchase_order_id " + "where po.vendor_id=? and pod.item_id=? and po.purchase_type=? and ( pod.po_status=72 or pod.po_status=144)";

	public static final String getNotDeliveredPOList = "select po.purchase_order_no as purchaseOrderNum from purchase_order as po " + "inner join purchase_order_detail as pod on  pod.purchase_order_id=po.purchase_order_id " + "where po.vendor_id=? and pod.item_id=? and po.purchase_type=? and " + "( pod.po_status=72 or pod.po_status=144)";

	public static final String GET_PURCHASE_ORDER_DETAIL_PRICE = "select coalesce(unit_price,0) as oldUnitPrice from purchase_order_detail where purchase_order_detail_id =(select coalesce(max(podtl.purchase_order_detail_id),0) purchase_order_detail_id from purchase_order_detail podtl inner join purchase_order por on por.purchase_order_id = podtl.purchase_order_id where item_id= ? )";
	public static final String GET_PURCHASE_ORDER_DETAIL_PRICE_WITH_DESC = "select coalesce(unit_price,0) as oldUnitPrice from purchase_order_detail where purchase_order_detail_id =(select coalesce(max(podtl.purchase_order_detail_id),0) purchase_order_detail_id from purchase_order_detail podtl inner join purchase_order por on por.purchase_order_id = podtl.purchase_order_id where item_id=?  and purchase_order_detail.item_description = ? )";
	// public static final String GET_PURCHASE_ORDER_DETAIL_PRICE =
	// "select coalesce(unit_price,0) as oldUnitPrice from purchase_order_detail
	// where item_id= ? and purchase_order_detail_id = ? ";
	public static final String GET_PURCHASE_ORDER_DETAIL_PRICE_NULL = "select coalesce(podtl.unit_price,0) as oldUnitPrice from purchase_order_detail podtl inner join purchase_order por on por.purchase_order_id = podtl.purchase_order_id where item_id=? and purchase_order_detail_id = (select max(pod.purchase_order_detail_id) from purchase_order_detail pod inner join purchase_order po on po.purchase_order_id = pod.purchase_order_id where item_id=?)";

	public static final String UPDATE_PURCHASE_ORDER_TOTAL = "update purchase_order set sub_total=?,total_discount=?,total_tax=?,freight=?,total_amount=? where purchase_order_id=?";

	public static final String GET_ADDRESS_ID = "select address_id from entity where supplier_acct_code  = ?";

	public static final String GET_ADDRESS_DETAIL = "select city_id as vendorCityId, street as VendorAddress from address where address_id = ?";

	public static final String UPDATE_STATUS_IN_PURCHASE_REQUISITION = "update purchase_requisition set requisition_status = ? where requisition_number = ?";

	public static final String CHECK_PO_ITEM_ALREADY_EXIST = " select purchase_order_detail_id  from purchase_order_detail where  purchase_requisition_number = ?";
	// public static final String CHECK_PO1_ITEM_ALREADY_EXIST =
	// " select purchase_requisition_number as prnumber ,item_id as itemId from
	// purchase_order_detail where purchase_requisition_number = ? and item_id =
	// ?";

	// public static final String CHECK_PQ_ITEM_ALREADY_EXIST =
	// " select purchase_requisition_id as prnumber ,item_id as itemId
	// ,item_description as itemDescription from purchase_quote_detail where
	// purchase_requisition_id = ? and item_id = ?";
	// public static final String CHECK_PQ_ITEM_ALREADY_EXIST =
	// " select purchase_requisition_id as prnumber ,item_id as itemId
	// ,item_description as itemDescription from purchase_quote_detail where
	// purchase_requisition_id = ? and item_id = ? and (select pr.quantity from
	// purchase_quote_detail pq inner join purchase_requisition_detail pr on
	// pq.purchase_requisition_id = pr.purchase_requisition_id and pq.item_id =
	// pr.item_id where pr.purchase_requisition_id = ? and pr.item_id = ? limit
	// 1)
	// between ? and (select pr.quantity from purchase_quote_detail pq inner
	// join
	// purchase_requisition_detail pr on pq.purchase_requisition_id =
	// pr.purchase_requisition_id and pq.item_id = pr.item_id where
	// pr.purchase_requisition_id = ? and pr.item_id =? limit 1)";

	public static final String CHECK_PQ_ITEM_ALREADY_EXIST = "select purchase_requisition_id as prnumber ,item_id as itemId ,item_description as itemDescription from purchase_quote_detail where purchase_requisition_id = 76 and item_id = 39 and (select sum(pq.quantity) from purchase_quote_detail pq  where pq.purchase_requisition_id =?   and pq.item_id = ? ) != (select pr.quantity from purchase_requisition_detail pr   where pr.purchase_requisition_id =? and pr.item_id = ?)";

	public static final String CHECK_PR_ITEM_ALREADY_EXIST = " select purchase_requisition_detail_id from purchase_requisition_detail  pr inner join purchase_requisition prd on prd.purchase_requisition_id = pr.purchase_requisition_id where prd.requisition_number  = ?";

	public static final String getcurrecy = "select crrncy_cd as id , crrncy_nam as text from currency ";

	public static final String BUDGET_TYPE_LIST = "select budget_definition_id as id , concat(capex_no ,'-',project_name) as text  from budget_definition  where flag =  ? and approve_status =  'Approved' ";

	public static final String get_purchase_order_pdf_header_values =  "SELECT coalesce(e.first_name,'') preparedBy,purchase_order_id as purchaseOrderId, purchase_order_no as purchaseOrderNo, to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, purchase_for as purchaseFor, purchase_type as purchaseType,CASE WHEN po_amendment IS NULL THEN '' ELSE po_amendment END  as poAmendNo, purchase_order.company_id as companyId,vendor_id as vendorID, (select entity_name from entity where supplier_acct_code=vendor_id) as vendorName,(select concat(address.street,', ',city.cty_nam,' - ', state.stt_cd,', ', state.stt_nam,' - ', city.zp_cd,', ', country.cntry_nam) as address from entity left join location on location.location_id = entity.vendor_location left join address on address.address_id = entity.address_id left join city on city.cty_id = address.city_id left join state on state.stt_id = city.stt_id left join country on country.cntry_id = state.cntry_id where entity_id=(select entity_id from entity where  supplier_acct_code=vendor_id limit 1)) as vendorAddress,(select contact_mobile from entity where supplier_acct_code=vendor_id) as vendorPhone,c.company_name as entity,(select email from entity where supplier_acct_code=vendor_id) as vendorEmail, location_id as locationId, terms_condition as terms_Condition,  remarks as remarks,  po_status as statusId,dft.value as purchaseTypeName,  COALESCE(freight_amount,0) as freightAmount, COALESCE(freight,0) as freightCharges,COALESCE(freight_tax::int,0) as freightTax,COALESCE(freight,0) as duplicateFreight,COALESCE(other_charges,0) as otherCharges,consignment_transfer_id as conTransNo,COALESCE(payment_terms,0) as paymentTerms,to_char(recommended_date,'dd/mm/yyyy') as recmndDate, recommended_remarks as recmndremarks,employee.first_name  as recmmendedBy,reason_for_amendment as reason_for_amendment, advanceamt as advanceamt, case when po_type = 'Capex PO' then concat(po_type, '-',bd.project_name) else po_type end as purchaseOrderType  , currency_code as currencyType ,remarks_othercharges as otherChargesRemarks,(select location_name as locationName from location where location_id  = purchase_order.location_id),coalesce(advanceamt,0) as advanceAmount,coalesce(po_approved_by_name,'') approvedName,(select cost_center_name from cost_center where cost_center_id= purchase_order.cost_center_id::int) as costcenter,request_type as reqType,total_cgst taxCGST,total_sgst taxSGST,total_igst taxIGST FROM purchase_order  left join def_table dft on dft.def_table_id = purchase_order.purchase_type left join employee_master  employee on employee.emp_id  = purchase_order.recommended_by left join budget_definition bd on bd.budget_definition_id = purchase_order.budget_type_id  left join employee_master e on e.emp_id  = purchase_order.created_by left join company_master c on c.company_code  = purchase_order.company_id where purchase_order_id =?";
			
			//"SELECT coalesce(e.first_name,'') preparedBy,purchase_order_id as purchaseOrderId, purchase_order_no as purchaseOrderNo, to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, purchase_for as purchaseFor, purchase_type as purchaseType,CASE WHEN po_amendment IS NULL THEN '' ELSE po_amendment END  as poAmendNo, purchase_order.company_id as companyId,vendor_id as vendorID, (select entity_name from entity where supplier_acct_code=vendor_id) as vendorName,(select concat(address.street,', ',city.city_name,' - ', state.state_code,', ', state.state_name,' - ', city.pincode,', ', country.country_name) as address from entity left join location on location.location_id = entity.vendor_location left join address on address.address_id = entity.address_id left join city on city.city_id = address.city_id left join state on state.state_code = city.state_code left join country on country.country_code = state.country_code where entity_id=(select entity_id from entity where  supplier_acct_code=vendor_id limit 1)) as vendorAddress,(select contact_mobile from entity where supplier_acct_code=vendor_id) as vendorPhone,c.company_name as entity,(select email from entity where supplier_acct_code=vendor_id) as vendorEmail, location_id as locationId, terms_condition as terms_Condition,  remarks as remarks,  po_status as statusId,dft.value as purchaseTypeName,  COALESCE(freight_amount,0) as freightAmount, COALESCE(freight,0) as freightCharges,COALESCE(freight_tax::int,0) as freightTax,COALESCE(freight,0) as duplicateFreight,COALESCE(other_charges,0) as otherCharges,consignment_transfer_id as conTransNo,COALESCE(payment_terms,0) as paymentTerms,to_char(recommended_date,'dd/mm/yyyy') as recmndDate, recommended_remarks as recmndremarks,employee.first_name  as recmmendedBy,reason_for_amendment as reason_for_amendment, advanceamt as advanceamt, case when po_type = 'Capex PO' then concat(po_type, '-',bd.project_name) else po_type end as purchaseOrderType  , currency_code as currencyType ,remarks_othercharges as otherChargesRemarks,(select location_name as locationName from location where location_id  = purchase_order.location_id),coalesce(advanceamt,0) as advanceAmount,coalesce(po_approved_by_name,'') approvedName,(select cost_center_name from cost_center where cost_center_id= purchase_order.cost_center_id::int) as costcenter,request_type as reqType,total_cgst taxCGST,total_sgst taxSGST,total_igst taxIGST FROM purchase_order  left join def_table dft on dft.def_table_id = purchase_order.purchase_type left join employee on employee.employee_id  = purchase_order.recommended_by left join budget_definition bd on bd.budget_definition_id = purchase_order.budget_type_id  left join employee e on e.employee_id  = purchase_order.created_by left join company c on c.company_id  = purchase_order.company_id where purchase_order_id =?";

	public static final String get_purchase_order_pdf_detail_values = "select distinct purchase_order_detail_id as purchaseOrderDetailId,  coalesce(pod.quantity,0) as vendorQuantity, item.item_code as purchaseItemCode, item.item_name   as purchaseItemName, pq.fixed_price as fixedPrice,pq.fixed_quantity as fixedQuantity, pqd.item_description as purchaseItemDesc,item.item_id as itemId,pod.item_description as itemDescription,  po.vendor_id as vendorId1,to_char(pqd.edd, 'dd/mm/yyyy') as edd,pqd.vendor_uom as uom,uom.uom as uomName,CAST(pod.quantity AS INT) as quantity, pqd.delivery_lead_time as deliveryLeadTime,pod.unit_price as rate, pq.freight as frieght , pq.purchase_quote_no as purchaseQuoteId , pod.po_status as purchaseStatusId,pod.purchase_order_id as purchaseOrderId, pod.purchase_quote_detail_id as purchaseQuoteDetailId ,0 as edit,def_table.value as purchaseStatus,   ic.vendor_min_qty as vendorMinQty,requested_qty as requestedQty,pod.purchase_requisition_number as purchaseReqNo, coalesce(pqd.percentage,0) as percentage ,coalesce(pod.discount_amount,0.0) as discount_amount,coalesce(pod.tax_cgst, 2,0.0) as taxCGST ,coalesce(pod.tax_sgst, 2,0.0) as taxSGST ,coalesce(pod.tax_igst,0.0) as taxIGST,coalesce(pod.tax_cgst_percent,0) as taxCGSTinPercent,coalesce(pod.tax_sgst_percent,0) as taxSGSTinPercent,coalesce(pod.tax_igst_percent,0) as taxIGSTinPercent from purchase_order_detail pod left join item_new item on item.item_id = pod.item_id left join purchase_order po on po.purchase_order_id = pod.purchase_order_id  left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id left join purchase_quote pq on pq.purchase_quote_id = pqd.purchase_quote_id left join def_table on def_table.def_table_id = pod.po_status  left join uom on uom.uom_id = pqd.vendor_uom left join item_vendor ic on ic.entity_id = pq.entity_id and ic.item_id=pqd.item_id where pod.purchase_order_id =? order by purchase_order_detail_id";

	// public static final String get_purchase_order_pdf_detail_values = "select
	// distinct purchase_order_detail_id as purchaseOrderDetailId,
	// coalesce(pqd.quantity,0) as vendorQuantity, item.item_code as
	// purchaseItemCode,TRUNC(coalesce(pod.tax_cgst,0.0)::numeric,2) as
	// taxCGST,TRUNC(coalesce(pod.tax_sgst,0.0)::numeric,2) as
	// taxSGST,TRUNC(coalesce(pod.tax_igst,0.0)::numeric,2) as taxIGST,
	// item.item_name as purchaseItemName, pq.fixed_price as
	// fixedPrice,pq.fixed_quantity as fixedQuantity, pqd.item_description as
	// purchaseItemDesc,item.item_id as itemId,pod.item_description as
	// itemDescription, po.vendor_id as vendorId1,to_char(pqd.edd, 'dd/mm/yyyy')
	// as
	// edd,pqd.vendor_uom as uom,uom.uom as uomName,CAST(pod.quantity AS INT) as
	// quantity, pqd.delivery_lead_time as
	// deliveryLeadTime,TRUNC(pod.unit_price::numeric,2) as rate, pq.freight as
	// frieght , pq.purchase_quote_no as purchaseQuoteId , pod.po_status as
	// purchaseStatusId,pod.purchase_order_id as purchaseOrderId,
	// pod.purchase_quote_detail_id as purchaseQuoteDetailId ,0 as
	// edit,def_table.value as purchaseStatus, ic.vendor_min_qty as
	// vendorMinQty,requested_qty as
	// requestedQty,pod.purchase_requisition_number as
	// purchaseReqNo, coalesce(pqd.percentage,0) as percentage
	// ,TRUNC(coalesce(pqd.discount_amount,0.0)::numeric,2) as
	// discount_amount,coalesce(pqd.tax_cgst_percent,0.0) as
	// taxCGSTinPercent,coalesce(pqd.tax_sgst_percent,0.0) as
	// taxSGSTinPercent,coalesce(pqd.tax_igst_percent,0.0) as taxIGSTinPercent
	// from
	// purchase_order_detail pod left join item_new item on item.item_id =
	// pod.item_id inner join purchase_order po on po.purchase_order_id =
	// pod.purchase_order_id inner join purchase_quote_detail pqd on
	// pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id inner join
	// purchase_quote pq on pq.purchase_quote_id = pqd.purchase_quote_id left
	// join
	// def_table on def_table.def_table_id = pod.po_status left join uom on
	// uom.uom_id = pqd.vendor_uom left join item_vendor ic on ic.entity_id =
	// pq.entity_id and ic.item_id=pqd.item_id where pod.purchase_order_id =?
	// order
	// by purchase_order_detail_id";

	public static final String GET_PQ_DTL_ID = "select purchase_quote_detail_id from purchase_order_detail where purchase_order_id = ? limit 1 ";

	public static final String GET_PQ_ID = "select purchase_quote_id from purchase_quote_detail where purchase_quote_detail_id = ? ";

	public static final String GET_PQ_LIST = "select purchase_quote_detail_id , purchase_quote_id, purchase_requisition_id ,item_id ,case when quantity is null then 0 else quantity end  from purchase_quote_detail where purchase_quote_id = ?";

	public static final String UPDATE_TAX_IN_PQUOTE = "update purchase_quote_detail set tax_cgst_percent = ? ,tax_sgst_percent = ? ,tax_igst_percent = ?  ,percentage  = ? , discount_amount = ? ,discount_type = ? where purchase_quote_detail_id = ?";

	// public static String GROUP_BY_GST_TAX =
	// "(select 'Input CGST @' || tax_cgst_percent::text || '% AC' as
	// gstgroupbyPercent, sum(tax_cgst) as gstAmtgroupbyPercent from
	// purchase_order_detail where purchase_order_id = ? and tax_cgst > 0 group
	// by
	// tax_cgst_percent order by tax_cgst_percent) union all (select 'Input SGST
	// @'
	// || tax_sgst_percent::text || '% AC', sum(tax_sgst) from
	// purchase_order_detail
	// where purchase_order_id = ? and tax_sgst > 0 group by tax_sgst_percent
	// order
	// by tax_sgst_percent) union all (select 'Input IGST @' ||
	// tax_igst_percent::text || '% AC', sum(tax_igst) from
	// purchase_order_detail
	// where purchase_order_id = ? and tax_igst > 0 group by tax_igst_percent
	// order
	// by tax_igst_percent)";
	public static String GROUP_BY_GST_TAX = "(select 'Input CGST @' || tax_cgst_percent::text || '% AC' as gstgroupbyPercent, round (sum(tax_cgst) ::DECIMAL, 2) as gstAmtgroupbyPercent from purchase_order_detail  where purchase_order_id  = ? and tax_cgst > 0 group by tax_cgst_percent order by tax_cgst_percent) union all (select 'Input SGST @' || tax_sgst_percent::text || '% AC', round (sum(tax_sgst) ::DECIMAL, 2) from purchase_order_detail  where purchase_order_id  = ? and tax_sgst > 0 group by tax_sgst_percent order by tax_sgst_percent) union all (select 'Input IGST @' || tax_igst_percent::text || '% AC', round (sum(tax_igst) ::DECIMAL, 2) from purchase_order_detail  where purchase_order_id  = ? and  tax_igst > 0 group by tax_igst_percent order by tax_igst_percent) ";
	public static final String GET_COST_LIST_COMPANY_BASE = "select cost_center_id as id, cost_center_name as text from cost_center  where status=true and company_id = ?";

	public static final String getPOId = "select purchase_order_id from purchase_order where purchase_order_no = ?";

	public static final String GET_WORK_ORDER_NUMBER_RAPX = "SELECT CASE WHEN MAX(purchase_order_no) IS NULL  THEN 'RWO-WO0001' ELSE 'RWO-WO'|| lpad(cast(max(cast(RIGHT(purchase_order_no,4) as int)+1) as text),4,'0') END from purchase_order where purchase_order_no like ? and po_amendment is  null";

	public static final String GET_WORK_ORDER_NUMBER_CAPX = "SELECT CASE WHEN MAX(purchase_order_no) IS NULL  THEN 'CWO-WO0001' ELSE 'CWO-WO'|| lpad(cast(max(cast(RIGHT(purchase_order_no,4) as int)+1) as text),4,'0') END from purchase_order where purchase_order_no like ? and po_amendment is  null";

	public static final String GET_AMENDMENT_NUMBER = "select COALESCE(po_amendment,'notValid') from purchase_order where purchase_order_id  = ? ";

	public static final String UPDATE_FLAG_AMENDMENT_NUMBER = "update purchase_order set mpo_flag = '' where purchase_order_no  = ? ";

	public static final String INSERT_GENERAL_LEDGER_CREDIT_ENTRY_PAYMENT = "INSERT INTO general_ledger (ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, " + "currency_code, exchange_rate, company_id, status, financial_year_id, acct_Balance, parent_code, cost_center,item_id) " + "\n" + "	select purchase_date, null, purchase_order_no, total_amount, 0,total_amount,0,remarks,currency_code,'1', company_id, null, null,null,\n" + "	 null, NULL, NULL  from purchase_order  where purchase_order_id=?";

	public static final String INSERT_GENERAL_LEDGER_DEBIT_ENTRY_PAYMENT = "INSERT INTO general_ledger (ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, " + "currency_code, exchange_rate, company_id, status, financial_year_id, acct_Balance, parent_code, cost_center,item_id,sub_account_code)   " + "select phdr.purchase_date,null, phdr.purchase_order_no, 0, pdtl.unit_price,0,pdtl.unit_price, null,phdr.currency_code,  \n" + "			'1',phdr.company_id,null,null,null, null, null,null,null\n"
			+ "			from purchase_order_detail  pdtl  left join purchase_order phdr on phdr.purchase_order_id= pdtl.purchase_order_id WHERE phdr.purchase_order_id=?";
	public static final String costCenter = "select cost_center_name from cost_center where cost_center_id=?";
	public static final String INSERT_GENERAL_LEDGER_FOR_JV = "INSERT INTO general_ledger(budget,ledger_date, account_code,  transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, " + "narration, currency_code, exchange_rate,cost_center, company_id,parent_code)   " + "select ?,JVH.journal_date,journal_account_head,?,journal_credit,journal_debit,journal_creditusd,journal_debitusd, " + "JVD.journal_narration,'INR' as currency,1.0 as exchangeRate,jvh.cost_center,JVH.journal_company_code,substr(journal_account_head,0,5) "
			+ "from journalvoucher_dtl JVD left join  journalvoucher_hdr JVH on JVH.journal_no = JVD.journal_no where JVH.journal_no =?";

	public static final String INSERT_GENERAL_LEDGER_FOR_JV1 = "INSERT INTO general_ledger(budget,ledger_date, account_code,  transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, " + "narration, currency_code, exchange_rate,cost_center, company_id,parent_code)   " + "select ?,JVH.journal_date,journal_account_head,?,journal_credit,journal_debit,journal_creditusd,journal_debitusd, " + "JVD.journal_narration,'INR' as currency,1.0 as exchangeRate,jvh.cost_center,JVH.journal_company_code,journal_account_head "
			+ "from journalvoucher_dtl JVD left join  journalvoucher_hdr JVH on JVH.journal_no = JVD.journal_no where JVH.journal_no =?";

	public static final String GET_BUDGET_AMOUNT = "select coalesce(amount,0) from budget_definition  where 1= 1  ";

	public static final String GET_PURCHASE_ORDER_LIST_EXPORT = "select * from(   SELECT purchase_order_id as purchaseOrderId, purchase_order_no as purchaseOrderNum, to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, dftyp.value as purchaseForName,   dftyp.value as purchaseTypeName,  company.company_name as companyName, entity.entity_name as vendorName, purchase_order.company_id,   location.location_name as locationName ,   terms_condition as termsCondition, remarks as remarks,sub_total as subTotal,  total_discount as totalDiscount,    total_tax as totalTax ,freight as freight,po_status as statusId,dfs.value as purchaseStatus ,case when po_amendment is null then 'false' else 'true' end as poAmendmentNovalid, po_amendment as  poAmendmentNo, case when request_type='PO' then 'Purchase Order' when request_type='WO' then 'Work Order' else null end as reqType, (select first_name from employee_master where emp_id = purchase_order.created_by limit 1)  as createdBy, (select first_name from employee_master where emp_id = purchase_order.modified_by limit 1)   as modifiedBy , to_char(purchase_order.modified_date,'dd/mm/yyyy') as modifiedDate, to_char(purchase_order.created_date,'dd/mm/yyyy') as createdDate , payment_terms::integer as paymentTerms , coalesce(advanceamt,0) as advanceamt , cost_center_id , (select cost_center_name from cost_center where cost_center_id = purchase_order.cost_center_id::integer) as costcenterName 	  FROM purchase_order    inner join company_master  company on company.company_code = purchase_order.company_id   inner join entity on entity.supplier_acct_code = purchase_order.vendor_id    Left join location on location.location_id = purchase_order.location_id   left join def_table dfs on   dfs.def_table_id = purchase_order.po_status   left join def_table dftyp on dftyp.def_table_id = purchase_order.purchase_type where purchase_order.purchase_type = ? order by purchase_order_id desc    ) t";
			
			//"select * from(   SELECT purchase_order_id as purchaseOrderId, purchase_order_no as purchaseOrderNum, to_char(purchase_date,'dd/mm/yyyy') as purchaseOrderDate, dftyp.value as purchaseForName,   dftyp.value as purchaseTypeName,  company.company_name as companyName, entity.entity_name as vendorName, purchase_order.company_id,   location.location_name as locationName ,   terms_condition as termsCondition, remarks as remarks,sub_total as subTotal,  total_discount as totalDiscount,    total_tax as totalTax ,freight as freight,po_status as statusId,dfs.value as purchaseStatus ,case when po_amendment is null then 'false' else 'true' end as poAmendmentNovalid, po_amendment as  poAmendmentNo, case when request_type='PO' then 'Purchase Order' when request_type='WO' then 'Work Order' else null end as reqType, (select first_name from employee where employee_id = purchase_order.created_by limit 1)  as createdBy, (select first_name from employee where employee_id = purchase_order.modified_by limit 1)   as modifiedBy , to_char(purchase_order.modified_date,'dd/mm/yyyy') as modifiedDate, to_char(purchase_order.created_date,'dd/mm/yyyy') as createdDate , payment_terms::integer as paymentTerms , coalesce(advanceamt,0) as advanceamt , cost_center_id , (select cost_center_name from cost_center where cost_center_id = purchase_order.cost_center_id::integer) as costcenterName 	  FROM purchase_order    inner join company on company.company_id = purchase_order.company_id   inner join entity on entity.supplier_acct_code = purchase_order.vendor_id    Left join location on location.location_id = purchase_order.location_id   left join def_table dfs on   dfs.def_table_id = purchase_order.po_status   left join def_table dftyp on dftyp.def_table_id = purchase_order.purchase_type where purchase_order.purchase_type = ? order by purchase_order_id desc    ) t";

}
