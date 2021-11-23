package com.dci.tenant.finance.purchasequotation;

public class PurchaseQuotationQueryUtil {

	public static final String SELECT_VENDOR_LIST = "SELECT e.entity_id entityId, e.entity_name entityName from entity e  inner join employee_master em on em.emp_id = e.created_by inner join branch_department bd on bd.branch_department_id = em.branch_department_id inner join branch b on b.branch_id = bd.branch_id where e.is_vendor = true and b.company_id = ? ORDER BY e.entity_name";

	// public static final String SELECT_APPROVED_REQUISITION_LIST =
	// "SELECT distinct pr.purchase_requisition_id purchaseRequisitionId,
	// concat(pr.requisition_number ,'-', pr.pr_request_number)
	// requisitionNumber
	// from purchase_requisition pr inner join (SELECT
	// r.purchase_requisition_id,r.requisition_number from purchase_requisition
	// r
	// left join company com on com .company_id = r.company_id inner join
	// purchase_requisition_detail pd on pd.purchase_requisition_id =
	// r.purchase_requisition_id where r.requisition_type in ('118','126') and
	// requisition_status in (?,?) and com.company_id = ? and
	// pd.purchase_requisition_detail_id not in (select distinct
	// purchase_requisition_detail_id from purchase_quote_detail pq inner join
	// purchase_requisition_detail pr on pq.purchase_requisition_id =
	// pr.purchase_requisition_id and pq.item_id = pr.item_id and pr.quantity =
	// pq.quantity)) dtl on dtl.purchase_requisition_id =
	// pr.purchase_requisition_id
	// left join employee on employee_id = pr.requested_by order by
	// pr.purchase_requisition_id desc ";

	// public static final String SELECT_APPROVED_REQUISITION_LIST =
	// "SELECT distinct pr.purchase_requisition_id purchaseRequisitionId,
	// concat(pr.requisition_number ,'-', pr.pr_request_number)
	// requisitionNumber
	// from purchase_requisition pr inner join (SELECT
	// r.purchase_requisition_id,r.requisition_number from purchase_requisition
	// r
	// left join company com on com .company_id = r.company_id inner join
	// purchase_requisition_detail pd on pd.purchase_requisition_id =
	// r.purchase_requisition_id where r.requisition_type in ('118','126') and
	// requisition_status in (?,?) and com.company_id = ? and (select
	// sum(pq.quantity) from purchase_quote_detail pq where
	// pq.purchase_requisition_id =pd.purchase_requisition_id and pq.item_id =
	// pd.item_id ) != pd.quantity and pd.purchase_requisition_detail_id not in
	// (select distinct purchase_requisition_detail_id from
	// purchase_quote_detail pq
	// inner join purchase_requisition_detail pr on pq.purchase_requisition_id =
	// pr.purchase_requisition_id and pq.item_id = pr.item_id )) dtl on
	// dtl.purchase_requisition_id = pr.purchase_requisition_id left join
	// employee
	// on employee_id = pr.requested_by order by pr.purchase_requisition_id desc
	// ";

	// public static final String SELECT_APPROVED_REQUISITION_LIST =
	// "SELECT distinct pr.purchase_requisition_id purchaseRequisitionId,
	// concat(pr.requisition_number ,'-', pr.pr_request_number)
	// requisitionNumber
	// from purchase_requisition pr inner join (SELECT
	// r.purchase_requisition_id,r.requisition_number from purchase_requisition
	// r
	// left join company com on com .company_id = r.company_id inner join
	// purchase_requisition_detail pd on pd.purchase_requisition_id =
	// r.purchase_requisition_id where r.requisition_type in ('118','126') and
	// requisition_status in (?,?) and com.company_id = ? and COALESCE((select
	// sum(pq.quantity) from purchase_quote_detail pq where
	// pq.purchase_requisition_id =pd.purchase_requisition_id and pq.item_id =
	// pd.item_id ),0) != pd.quantity and pd.purchase_requisition_detail_id not
	// in
	// (select distinct purchase_requisition_detail_id from
	// purchase_quote_detail pq
	// inner join purchase_requisition_detail pr on pq.purchase_requisition_id =
	// pr.purchase_requisition_id and pq.item_id = pr.item_id and pr.quantity =
	// pq.quantity)) dtl on dtl.purchase_requisition_id =
	// pr.purchase_requisition_id
	// left join employee on employee_id = pr.requested_by order by
	// pr.purchase_requisition_id desc ";

	// public static final String SELECT_APPROVED_REQUISITION_LIST =
	// "SELECT distinct pr.purchase_requisition_id purchaseRequisitionId,
	// concat(pr.requisition_number ,'-', pr.pr_request_number)
	// requisitionNumber
	// from purchase_requisition pr inner join (SELECT
	// r.purchase_requisition_id,r.requisition_number from purchase_requisition
	// r
	// left join company com on com .company_id = r.company_id inner join
	// purchase_requisition_detail pd on pd.purchase_requisition_id =
	// r.purchase_requisition_id where r.requisition_type in ('118','126') and
	// requisition_status in (?,?) and com.company_id = ? and COALESCE((select
	// sum(pq.quantity) from purchase_quote_detail pq where
	// pq.purchase_requisition_id =pd.purchase_requisition_id and pq.item_id =
	// pd.item_id ),0) != pd.quantity and pd.purchase_requisition_detail_id not
	// in
	// (select distinct purchase_requisition_detail_id from
	// purchase_quote_detail pq
	// inner join purchase_requisition_detail pr on pq.purchase_requisition_id =
	// pr.purchase_requisition_id and pq.item_id = pr.item_id )) dtl on
	// dtl.purchase_requisition_id = pr.purchase_requisition_id left join
	// employee
	// on employee_id = pr.requested_by order by pr.purchase_requisition_id desc
	// ";

	// public static final String SELECT_APPROVED_REQUISITION_LIST =
	// "SELECT distinct pr.purchase_requisition_id purchaseRequisitionId,
	// concat(pr.requisition_number ,'-', pr.pr_request_number)
	// requisitionNumber
	// from purchase_requisition pr inner join (SELECT
	// r.purchase_requisition_id,r.requisition_number from purchase_requisition
	// r
	// left join company com on com .company_id = r.company_id inner join
	// purchase_requisition_detail pd on pd.purchase_requisition_id =
	// r.purchase_requisition_id where r.requisition_type in ('118','126') and
	// requisition_status in (?,?) and com.company_id = ? and COALESCE((select
	// sum(pq.quantity) from purchase_quote_detail pq where
	// pq.purchase_requisition_id =pd.purchase_requisition_id and pq.item_id =
	// pd.item_id ),0) != pd.quantity ) dtl on dtl.purchase_requisition_id =
	// pr.purchase_requisition_id left join employee on employee_id =
	// pr.requested_by order by pr.purchase_requisition_id desc ";

	public static final String SELECT_APPROVED_REQUISITION_LIST = "SELECT distinct pr.purchase_requisition_id purchaseRequisitionId, concat(pr.requisition_number ,'-', pr.pr_request_number) requisitionNumber from purchase_requisition pr  inner join (SELECT r.purchase_requisition_id,r.requisition_number from purchase_requisition r  left join company_master com on com .company_code = r.company_id  inner join purchase_requisition_detail pd on pd.purchase_requisition_id = r.purchase_requisition_id where r.requisition_type in ('118','126') and requisition_status in (?,?) and com.company_code = ?  and COALESCE((select  case when  sum(quantity) is null then 0 else sum(quantity) end  from purchase_order_detail  pod left join purchase_order po on po.purchase_order_id = pod.purchase_order_id where purchase_requisition_number = (select concat(requisition_number,'-',pr_request_number) from purchase_requisition  where purchase_requisition_id   = pd.purchase_requisition_id  and  (mpo_flag = '' or mpo_flag is null)) and item_id = pd.item_id),0) != pd.pending_quantity ) dtl on dtl.purchase_requisition_id = pr.purchase_requisition_id left join employee_master on emp_id = pr.requested_by  where request_type_flag = true order by pr.purchase_requisition_id desc ";

	public static final String SELECT_APPROVED_REQUISITION_LIST1 = "SELECT distinct pr.purchase_requisition_id purchaseRequisitionId, pr.requisition_number requisitionNumber from purchase_requisition pr " + "inner join (SELECT r.purchase_requisition_id,r.requisition_number from purchase_requisition r " + "		inner join purchase_requisition_detail pd on pd.purchase_requisition_id = r.purchase_requisition_id left join company_master com on com.company_code = r.company_id"
			+ "		where r.requisition_type = ? and requisition_status=? and com.company_code = ? and pd.purchase_requisition_detail_id " + "not in (select distinct purchase_requisition_detail_id from purchase_quote_detail pq " + "	inner join purchase_requisition_detail pr on pq.purchase_requisition_id = pr.purchase_requisition_id " + "	inner join purchase_quote p on 	p.purchase_quote_id=pq.purchase_quote_id where p.entity_id=(select entity_id from entity where  supplier_acct_code=? limit 1) " + "	 and pq.item_id = pr.item_id)) dtl on "
			+ "dtl.purchase_requisition_id = pr.purchase_requisition_id order by pr.requisition_number desc";

	public static final String SELECT_ITEM_LIST = "select rd.item_id itemId, concat(i.item_code,' - ',i.item_name) itemCode from purchase_requisition_detail rd, item_new i where rd.item_id = i.item_id and rd.purchase_requisition_id = ? and rd.item_id not in (select pqd.item_id from purchase_quote_detail pqd where pqd.purchase_requisition_id=?) order by item_code ";

	public static final String SELECT_ITEM_LIST_BY_VENDOR = "select rd.item_id itemId, concat(i.item_code,' - ',i.item_name) itemCode " + "from purchase_requisition_detail rd, item_new i " + "where rd.item_id = i.item_id and rd.purchase_requisition_id = ? and rd.item_id " + "  not in (select pqd.item_id from purchase_quote_detail  pqd  inner join purchase_quote as puq on puq.purchase_quote_id =pqd.purchase_quote_id where pqd.purchase_requisition_id=? and puq.entity_id=? ) order by item_code";

	// public static final String SELECT_ITEM_LIST_BY_VENDOR_MIN_QUANTITY =
	// "select COALESCE(vendor_min_qty,0) vendor_min_qty, rd.item_id itemId,
	// concat(i.item_code,' - ',i.item_name) itemCode from "
	// +
	// "item_new i, purchase_requisition_detail rd left outer join item_vendor
	// as e
	// "
	// + " on e.item_id = rd.item_id and " +
	// " e.entity_id =(select entity_id from entity where supplier_acct_code=?
	// limit
	// 1) where rd.item_id = i.item_id and rd.purchase_requisition_id = ? and
	// rd.item_id "
	// + " not in (select pqd.item_id from purchase_quote_detail pqd "
	// +
	// "inner join purchase_quote as puq on puq.purchase_quote_id
	// =pqd.purchase_quote_id where pqd.purchase_requisition_id=? "
	// +
	// " and puq.entity_id=(select entity_id from entity where
	// supplier_acct_code=?
	// limit 1) ) order by item_code ";
	
	/* 27/05/2021 aarthi
	 * select COALESCE(vendor_min_qty,0) vendor_min_qty, rd.item_id itemId,
	 * concat(item_code,' - ',item_name) itemCode ,rd.item_desc itemDesc from
	 * item_new , purchase_requisition_detail rd left outer join item_vendor as e on
	 * e.item_id = rd.item_id and e.entity_id =(select entity_id from entity)
	 */

	
	
	public static final String SELECT_ITEM_LIST_BY_VENDOR_MIN_QUANTITY = "select COALESCE(vendor_min_qty,0) vendor_min_qty, rd.item_id itemId, concat(i.item_code,' - ',i.item_name) itemCode ,rd.item_desc  itemDesc   from " + "item_new i, purchase_requisition_detail rd      left outer join item_vendor as e " + " on e.item_id = rd.item_id and " + " e.entity_id =(select entity_id from entity where  supplier_acct_code=? limit 1) where rd.item_id = i.item_id and rd.purchase_requisition_id = ? order by  purchase_requisition_detail_id asc ";

	public static final String SELECT_WO_ITEM_LIST = "select COALESCE(vendor_min_qty,0) vendor_min_qty, wod.item_name::int itemId, concat(i.item_code,' - ',i.item_name) itemCode from item_new i, work_order_dtl wod left outer join item_vendor as e  on e.item_id = wod.item_name::int and  e.entity_id =(select entity_id from entity where  supplier_acct_code=? limit 1) where rd.item_id = i.item_id and wod.wrk_no = ? and rd.item_id  not in (select pqd.item_id from purchase_quote_detail  pqd inner join purchase_quote as puq on puq.purchase_quote_id =pqd.purchase_quote_id where pqd.purchase_requisition_id=?    and puq.entity_id=(select entity_id from entity where  supplier_acct_code=?  limit 1) and rd.quantity = pqd.quantity ) order by item_code";

	public static final String get_entity_id = "select entity_id from entity where  supplier_acct_code=? limit 1";

	public static final String SELECT_TAX_LIST = "select tax_id id, tax_code || '-'||tax_name as text from tax where is_active=true order by tax_code";

	public static final String INSERT_PURCHASE_QUOTAION = "insert into purchase_quote(purchase_quote_no, purchase_quote_date,purchase_for, purchase_type, entity_id, remarks, created_by, created_date, sub_total, " + "total_discount, total_tax, freight, other_charges,grand_total,fixed_price,fixed_quantity,valid_from_date,valid_to_date,payment_terms,company_id,cost_center_id) values(:quoteNo,to_date(:quoteDate,'DD/MM/YYYY'), :purchaseFor, :purchaseType, :entityId, :remarks, :createdBy, now(), :subTotal, "
			+ ":totalDiscount, :totalTax, :freight, :otherCharges, :grandTotal, :fixedPrice, :fixedQty, :validFromDate, :validToDate, :paymentTerms, :company, :costcenter) returning purchase_quote_id";

	public static final String INSERT_PURCHASE_QUOTATION_DETAIL = "insert into purchase_quote_detail(purchase_quote_id, purchase_requisition_id, item_id, quantity, edd, tax_id, discount_type, percentage, amount, delivery_lead_time,quote_status, unit_price,discount_amount,tax_percentage,tax_amount,vendor_uom,purchase_quantity,tax_cgst,tax_sgst,tax_igst,item_description,tax_cgst_percent,tax_sgst_percent,tax_igst_percent,cost_center, po_number,purchase_uom,purchase_qty) values(:quotationId, :requisitionId, :itemId, :vendorQuantity, to_date(:edd,'DD/MM/YYYY'), :taxId, :discountType, :percentage, :amount, :deliveryLeadTime, :status, :unitPrice,:disAmount, :taxPercentage, :taxAmount,:vendoruom,:quantityId,:taxAmountCGST,:taxAmountSGST,:taxAmountIGST,:itemDescirption,:taxAmountCGSTinPercent,:taxAmountSGSTinPercent,:taxAmountIGSTinPercent,:costcenter,:poNumber,:purchaseuom,:purchaseqty)";

	public static final String DELETE_PURCHASE_QUOTATION_DETAIL_BY_QUOTID = "delete from purchase_quote_detail where purchase_quote_id = ?";

	public static final String DELETE_PURCHASE_QUOTATION_BY_QUOTID = "delete from purchase_quote where purchase_quote_id = ?";

	public static final String SELECT_PURCHASE_QUOTATION_NUMBER = "SELECT nextval('purchase_quotation_no_seq')";

	public static final String SELECT_PURCHASE_QUOTATION_LIST = "select company_id companyId,q.purchase_quote_id quotationId, q.purchase_quote_no quotationNo, to_char(q.purchase_quote_date,'DD/MM/YYYY') quoteDate, d.value purchaseForValue, e.entity_name entityName " + "from purchase_quote q, entity e, def_table d where q.entity_id = e.entity_id and d.def_table_id = q.purchase_for and company_id = ? and purchase_quote_no like 'PQ%' order by purchase_quote_id desc";

	public static final String SELECT_PURCHASE_REQUISITION = "select concat(requisition_number,'-',pr_request_number) requisitionNumber,  to_char(requisition_date,'DD/MM/YYYY') requisitionDate,l.location_name locationName, COALESCE(add.city_id,0) city, ci.cty_nam cityName, add.street, ci.stt_id stateCode,"
			+ "			 st.stt_nam stateName, ci.zp_cd, co.cntry_nam countryName from purchase_requisition pr  left join location l on pr.destination_location = l.location_id  left join "
			+ "			 address add on add.address_id = l.address_id left join city ci on ci.cty_id = add.city_id left join state st on st.stt_id = ci.stt_id  left join country co on co.cntry_id = st.cntry_id "
			+ "			 where pr.purchase_requisition_id = ?";

	
	
	// public static final String SELECT_REQUISITION_ITEM =
	// "select distinct on (i.item_id) i.item_id , i.item_code itemCode,
	// i.item_name
	// itemName,pr.item_desc itemDescription, to_char(pr.edd,'DD/MM/YYYY')
	// eddDate,
	// pr.quantity,coalesce(pr.pending_quantity,0) pedningQuantity,
	// coalesce(uom.uom_id,0) uom, uom.uom uomName,coalesce(u.uom_id,0)
	// vendoruom,
	// u.uom vendorUomName,coalesce(i.cgst,0.00) taxCGST ,coalesce(i.sgst,0.00)
	// taxSGST, coalesce(i.igst,0.00) taxIGST ,pr.purchase_requisition_id as
	// requisitionId ,purchase_requisition_detail_id as quotationDetailId from
	// purchase_requisition_detail pr, item_new i left JOIN UOM ON uom.uom_id =
	// i.uom left join item_vendor iv on iv.item_id = i.item_id left join uom u
	// on
	// u.uom_id = iv.vendor_uom_id where pr.item_id = i.item_id and
	// pr.purchase_requisition_id = ? and i.item_id = ?";

	public static final String SELECT_WO_DETAILS = "select concat(wo.wrk_no) requisitionNumber,  to_char(date,'DD/MM/YYYY') requisitionDate,l.location_name locationName, COALESCE(add.city_id,0) city, ci.city_name cityName, add.street, ci.state_code stateCode, st.state_name stateName, ci.pincode, co.country_name countryName from work_order_hdr wo  left join location l on wo.destination::int = l.location_id  left join address add on add.address_id = l.address_id left join city ci on ci.city_id = add.city_id left join state st on st.state_code = ci.state_code  left join country co on co.country_code = st.country_code where wo.wrk_no=?";

	public static final String SELECT_REQUISITION_ITEM = "select distinct on (i.item_id)  i.item_id itemId , i.item_code itemCode, i.item_name itemName,pr.item_desc itemDescription, to_char(pr.edd,'DD/MM/YYYY') eddDate, pr.quantity,coalesce(pr.pending_quantity,0) pedningQuantity, coalesce(uom.uom_id,0) uom, uom.uom uomName,coalesce(u.uom_id,0) vendoruom, u.uom vendorUomName,coalesce(i.cgst,0.00) taxCGST ,coalesce(i.sgst,0.00) taxSGST, coalesce(i.igst,0.00) taxIGST ,pr.purchase_requisition_id as requisitionId ,purchase_requisition_detail_id as quotationDetailId,case when null_or_empty(pr.altuom::text) = false then pr.altuom else uom.uom_id end as altuom ,case when  coalesce(pr.altqty,0) = 0 then pr.quantity else  pr.altqty end as altqty from purchase_requisition_detail pr, item_new i left JOIN UOM ON uom.uom_id = i.uom left join item_vendor iv on iv.item_id = i.item_id left join uom u on u.uom_id = iv.vendor_uom_id where pr.item_id = i.item_id and pr.purchase_requisition_id = ? and i.item_id = ?";

	/**
	 * Modified @author raghavan
	 * 
	 */
	public static final String GET_VENDOR_DETAILS = "select  address.street vendorAddress,  city.city_id city, city.city_name cityName, state.state_code stateCode, state.state_name state, " + "city.pincode zipcode, country.country_name country, entity.vendor_payment_terms pmtTermsId, location.location_id vendorLocId, " + "location.location_name vendorLocName from entity left join location on location.location_id = entity.vendor_location "
			+ "left join address on address.address_id = entity.address_id left join city on city.city_id = address.city_id " + "left join state on state.state_code = city.state_code left join country on country.country_code = state.country_code where entity_id=(select entity_id from entity where  supplier_acct_code=? limit 1)";

	public static final String GET_TAX_DETAILS = "select tax.tax_id,  tax_account_id taxAccountId, tax.tax_code taxCode, tax.tax_name taxName, taxtype.value taxType, tax_percentage taxPercentage,tax_amount taxAmount " + "from tax left join def_table taxtype on taxtype.def_table_id = tax.tax_method  " + "where tax.tax_id=? ";

	public static final String GET_SUB_TAX_DETAILS = "select subtaxtype.value subTaxType, st.sub_tax_percentage subTaxPercentage, st.sub_tax_amount subTaxAmount from tax " + "left join def_table taxtype on taxtype.def_table_id = tax.tax_method left join tax_subtax tst on tst.tax_id=tax.tax_id  " + "left join sub_tax st on st.sub_tax_id = tst.sub_tax_id left join def_table subtaxtype on subtaxtype.def_table_id = st.sub_tax_method " + "where tax.tax_id=?";

	public static final String GET_PURCHASE_QUOTATION_HDR_LIST_ON_EDIT = "select q.purchase_quote_id quotationId, COALESCE(q.company_id,'') companyId," + "q.purchase_quote_no quotationNo,to_char(q.purchase_quote_date,'DD/MM/YYYY') quoteDate, " + "q.purchase_for purchaseFor, dpf.value purchaseForValue, q.purchase_type purchaseType, " + "dpt.value purchaseTypeValue, e.entity_id vendorId, e.entity_name vendorName," + "lo.location_name as vendorLocName,address.street vendorAddress,  city.city_id city, "
			+ "city.city_name cityName, state.state_code stateCode, state.state_name state,   " + "city.pincode zipcode, country.country_name country, q.remarks, q.freight totalFreight,q.other_charges totalOtherCharges , q.fixed_price fixedPrice, q.fixed_quantity fixedQty, TO_CHAR(q.valid_from_date, 'DD/MM/YYYY') validFromDate, " + "TO_CHAR(q.valid_to_date, 'DD/MM/YYYY') validToDate, COALESCE(q.payment_terms,0) as paymentTerms, cost_center_id as costcenter " + "from purchase_quote q " + "left join entity e on e.entity_id = q.entity_id "
			+ "left join def_table dpf on dpf.def_table_id = q.purchase_for " + "left join def_table dpt on dpt.def_table_id = q.purchase_type " + "left join location lo on lo.location_id = e.vendor_location " + "left join address on address.address_id = lo.address_id " + "left join city on city.city_id = address.city_id " + "left join state on state.state_code = city.state_code " + "left join country on country.country_code = state.country_code " + "where purchase_quote_id=?";

	public static final String GET_PURCHASE_QUOTATION_DTL_LIST_ON_EDIT = "select pqd.purchase_quote_detail_id quotationDetailId,pqd.purchase_quote_id quotationId, pqd.purchase_requisition_id requisitionId,pr.requisition_number requisitionNo, item.item_id itemId,   item.item_code as itemCode, item.item_name as itemName, item.item_description itemDescription,to_char(pqd.edd,'DD/MM/YYYY') eddDate, COALESCE(pqd.vendor_uom,0) as vendoruom, uom.uom as vendorUomName, pqd.discount_type discountTypeId, def_table.value discountType,COALESCE(pqd.percentage,0) discountPercent, amount, pqd.delivery_lead_time deliveryLeadTime,status.def_table_id queryStatus, status.value status, pqd.unit_price unitPrice, pqd.purchase_quantity as quantity,pqd.quantity as vendorQuantity,COALESCE(pqd.discount_amount,0) disAmt,pqd.tax_id ltaxIds,COALESCE(pqd.tax_percentage,0) taxPercentage, COALESCE(pqd.tax_amount,0) taxAmt from purchase_quote_detail pqd left join item_new item on item.item_id = pqd.item_id left join uom on uom.uom_id = pqd.vendor_uom LEFT JOIN def_table on def_table.def_table_id = pqd.discount_type LEFT JOIN def_table status on status.def_table_id = pqd.quote_status left join purchase_requisition pr on pr.purchase_requisition_id = pqd.purchase_requisition_id where purchase_quote_id=?";

	public static final String UPDATE_PURCHASE_QUOTAION_HDR = "UPDATE purchase_quote SET purchase_quote_no=:quoteNo, purchase_quote_date=to_date(:quoteDate,'DD/MM/YYYY'),purchase_for=:purchaseFor, " + "purchase_type=:purchaseType,remarks=:remarks, entity_id=:entityId, modified_by=:modifiedBy, modified_date=now(), sub_total=:subTotal, total_discount=:totalDiscount,  "
			+ "total_tax=:totalTax, freight=:freight,other_charges=:otherCharges, grand_total=:grandTotal, fixed_price=:fixedPrice, fixed_quantity=:fixedQty, valid_from_date=:validFromDate,valid_to_date=:validToDate,payment_terms=:paymentTerms,company_id = :company,cost_center_id = :costcenter where purchase_quote_id=:quotationId  returning purchase_quote_id";

	public static final String UPDATE_PURCHASE_QUOTATION_DETAIL = "UPDATE purchase_quote_detail set purchase_quote_id=:quotationId, purchase_requisition_id=:requisitionId, item_id=:itemId, quantity=:vendorQuantity, " + "edd=to_date(:edd,'DD/MM/YYYY'), " + "discount_type=:discountType, percentage=:percentage, amount=:amount, delivery_lead_time=:deliveryLeadTime,  quote_status=:status, "
			+ "unit_price=:unitPrice, discount_amount=:disAmount, tax_percentage= :taxPercentage,tax_amount=:taxAmount,vendor_uom=:vendoruom where purchase_quote_detail_id=:quotationDetailId";

	public static final String AUTO_GEN_PURCHASE_QUOTE_NO = "SELECT CASE WHEN MAX(purchase_quote_no) IS NULL THEN ? ELSE rpad(MAX(purchase_quote_no),3,'PQ')|| " + "lpad(cast(cast((SUBSTRING(MAX(purchase_quote_no),3)) as int)+1 as text),4,'0') END AS purchase_quote_no " + "FROM purchase_quote where purchase_quote_no like  'PQ%' ";

	public static final String deletePurchaseQuotationDetail = "delete from purchase_quote_detail where purchase_quote_id=?";

	public static final String sDeleteQuotationDetail = "delete from purchase_quote_detail where purchase_quote_detail_id=?";

	public static final String checkQuotationDetail = "select count(*) from purchase_order_detail where purchase_quote_detail_id=:puchaseDetailId and item_id=:itemId";

	public static final String getTaxCodeName = "select tax_code as taxCode from tax where tax_id=?";

	public static final String NEW_QUERY_FOR_PURCHASE = "select def_table_id defTableId from def_table where is_active=true and form_field_id = 11 and value=?";

	public static final String NEW_QUERY_FOR_PURCHASE_TYPE = "select def_table_id defTableId from def_table where is_active=true and form_field_id = 12 and value=?";

	public static final String NEW_QUERY_FOR_VENDOR_TYPE = "select entity_id from entity where entity_name=?";

	public static final String NEW_COMPANY_LIST = "select company_id from company where company_name=?";

	public static final String NEW_COST_CENTER_LIST = "select cost_center_id from cost_center where cost_center_name=?";

	public static final String NEW_REQUISITION_LIST = "select purchase_requisition_id from purchase_requisition where requisition_number=?";

	public static final String NEW_ITEM_LIST = "select item_id from item_new where lower(item_name)=lower(?)";

	public static final String NEW_UOM_LIST = "select uom_id from uom where lower(uom)=lower(?)";

	public static final String STATUS_TYPE = "select def_table_id defTableId from def_table where is_active=true and form_field_id = 13 and value=?";

	public static final String DISCOUNT_TYPE = "select def_table_id defTableId from def_table where is_active=true and form_field_id = 28 and value=?";

	public static final String TAX = "select tax_id id  from tax where is_active=true and tax_name=?";

	public static final String Get_PurchaseQuoteId = "select purchase_quote_id from purchase_quote_detail where purchase_quote_detail_id = ?";

	public static final String Get_COUNT = "select count(*) from purchase_quote_detail where purchase_quote_id = ? ";

	public static final String delete_purchase_quote_detail = "delete from purchase_quote_detail where purchase_quote_id = ?";

	public static final String delete_purchase_quote_detail_1 = "delete from purchase_quote_detail where purchase_quote_detail_id = ?";

	public static final String delete_purchase_quote = "delete from purchase_quote where purchase_quote_id = ?";

	public static String GET_PENDING_QTY_PQ = "select COALESCE(pending_quantity,0) from purchase_requisition_detail where purchase_requisition_id=? and item_id = ? ";

	public static String UPDATE_PENDING_QTY_PQ = "update purchase_requisition_detail set pending_quantity = ? where purchase_requisition_id=? and item_id = ?";

	public static String UPDATE_PENDING_QTY = "update purchase_quote_detail set quantity = ? where purchase_quote_detail_id = ? and item_id = ?";

	public static String GET_GRN_QTY = "select COALESCE(sum(converted_quantity_new),0) from grn_detail  where item_id = ?";

	public static String GET_MI_QTY = "select COALESCE(sum(quantity),0) from stock_transfer_detail  where item_id = ? ";

	public static String GET_OPENING_QTY = " select COALESCE(opening_qty,0) from item_new  where item_id = ? ";

	public static final String SELECT_WORK_ORDER_REQUISITION_LIST = "SELECT distinct pr.purchase_requisition_id purchaseRequisitionId, concat(pr.requisition_number ,'-', pr.pr_request_number) requisitionNumber from purchase_requisition pr inner join (SELECT r.purchase_requisition_id,r.requisition_number from purchase_requisition r  left join company_master com on com .company_code = r.company_id   inner join purchase_requisition_detail pd on pd.purchase_requisition_id = r.purchase_requisition_id   where r.requisition_type in ('118','126') and  requisition_status not in (?) and com.company_code =? and  pd.purchase_requisition_detail_id not in (select distinct purchase_requisition_detail_id from purchase_quote_detail pq inner join  purchase_requisition_detail pr on pq.purchase_requisition_id = pr.purchase_requisition_id and pq.item_id = pr.item_id and pr.quantity = pq.quantity)  ) dtl on dtl.purchase_requisition_id = pr.purchase_requisition_id left join employee_master on emp_id = pr.requested_by where request_type_flag =false order by pr.purchase_requisition_id desc";

	public static final String GET_ISSUE_TYPE_LIST = "select def_table_id as id , value as text from def_table where form_field_id  = ? ";

	public static String GATEPASSOUT_QTY = "select case when null_or_empty(sum(coalesce(quantity,0))::text) = true then 0 else sum(coalesce(quantity,0)) end \n" + " from gate_pass_item join gate_pass on gate_pass_item.gate_pass_id = gate_pass.gate_pass_id where item_id  = ?::text ";

	public static String GATEPASSIN_QTY = "select case when null_or_empty(sum(coalesce(conv_purchase_qty,0))::text) = true then 0 else sum(coalesce(conv_purchase_qty,0)) end \n" + " from gate_pass_item join gate_pass on gate_pass_item.gate_pass_id = gate_pass.gate_pass_id where conv_item_id  = ?::text ";

	// public static final String GET_ITEM_LIST =
	// "select prd.item_id as id ,item_name as text,quantity as
	// quantity,COALESCE(pending_quantity,0) as pendingQuantity,item_desc as
	// description,purchase_requisition_detail_id as requisitionDetailId from
	// purchase_requisition_detail prd left join item_new item on item.item_id =
	// prd.item_id";

	// public static final String GET_ITEM_LIST =
	// "select prd.item_id as id ,item_name as text,quantity as quantity,CASE
	// when
	// COALESCE((prd.quantity -(select coalesce(sum(quantity),0) from
	// stock_transfer_detail where purchase_requisition_detail_id =
	// prd.purchase_requisition_detail_id)) = 0) then prd.quantity else
	// (prd.quantity -(select coalesce(sum(quantity),0) from
	// stock_transfer_detail
	// where purchase_requisition_detail_id =
	// prd.purchase_requisition_detail_id))
	// end as pendingQuantity, CASE when COALESCE((select
	// COALESCE(sum(quantity),0)
	// from grn_detail where item_id = prd.item_id) - (select
	// COALESCE(sum(quantity),0) from stock_transfer_detail where item_id =
	// prd.item_id) < 0 ) THEN 0 ELSE COALESCE ( (select
	// COALESCE(sum(quantity),0)
	// from grn_detail where item_id = prd.item_id) - (select
	// COALESCE(sum(quantity),0) from stock_transfer_detail where item_id =
	// prd.item_id)) end as availableQTY, item_desc as
	// description,purchase_requisition_detail_id as requisitionDetailId from
	// purchase_requisition_detail prd left join item_new item on item.item_id =
	// prd.item_id left join purchase_requisition pr on
	// pr.purchase_requisition_id =
	// prd.purchase_requisition_id where pr.destination_location = ? ";
	// public static final String GET_ITEM_LIST =
	// "select distinct prd.item_id as id ,item_name as text,(select
	// sum(quantity)
	// from purchase_requisition_detail where item_id = prd.item_id) as
	// quantity,
	// CASE when COALESCE((select COALESCE(sum(quantity),0) from grn_detail
	// where
	// item_id = prd.item_id) - (select COALESCE(sum(quantity),0) from
	// stock_transfer_detail where item_id = prd.item_id) < 0 ) THEN 0 ELSE
	// COALESCE
	// ( (select COALESCE(sum(quantity),0) from grn_detail where item_id =
	// prd.item_id) - (select COALESCE(sum(quantity),0) from
	// stock_transfer_detail
	// where item_id = prd.item_id)) end as availableQTY, item_desc as
	// description
	// ,string_agg(distinct purchase_requisition_detail_id::varchar,',') as
	// requisitionDetailId ,string_agg(distinct
	// prd.purchase_requisition_id::varchar,',') as requisitionId from
	// purchase_requisition_detail prd left join item_new item on item.item_id =
	// prd.item_id left join purchase_requisition pr on
	// pr.purchase_requisition_id =
	// prd.purchase_requisition_id where pr.destination_location = ? group by
	// prd.item_id,item_name,item_desc";
	public static final String GET_ITEM_LIST = "select  distinct prd.item_id as id ,concat(item_code,'-',item_name) as text ,uom.uom as uom ,(select sum(quantity) from purchase_requisition_detail where item_id = prd.item_id)  as quantity ,(select sum(quantity) from purchase_requisition_detail where item_id = prd.item_id)  as originalQty  from purchase_requisition_detail prd  left join item_new item on  item.item_id = prd.item_id left join purchase_requisition pr on pr.purchase_requisition_id = prd.purchase_requisition_id  left join uom on uom.uom_id=item.uom where pr.destination_location = ? and pr.requisition_status not in (33,214) and pr.company_id = ?";
	// public static String GET_SUM_QTY =
	// "select coalesce(sum(quantity),0) from stock_transfer_detail where
	// purchase_requisition_detail_id = ? ";
	public static String GET_SUM_QTY = "select  COALESCE(sum(pending_quantity),0)  from purchase_requisition_detail where item_id = ? and pending_quantity != 0";

	// public static String GET_SUM_ST_QTY =
	// "select COALESCE(sum(quantity),0) from stock_transfer_detail where
	// item_id =
	// ?";

	public static String GET_SUM_ST_QTY = "select COALESCE(sum(std.quantity),0) from stock_transfer_detail std left join   stock_transfer st on st.stock_transfer_id = std.stock_transfer_id left join purchase_requisition_detail prd on prd.purchase_requisition_detail_id = std.purchase_requisition_detail_id 	left join purchase_requisition pr on pr.purchase_requisition_id = prd.purchase_requisition_id 		where std.item_id = ? and pr.destination_location = ? and pr.company_id = ?  and pr.requisition_status not in (214,33)";
	// public static String GET_SUM_PR_QTY =
	// "select COALESCE(sum(quantity),0) from purchase_requisition_detail where
	// item_id = ?";
	public static String GET_SUM_PR_QTY = "select COALESCE(sum(quantity),0) from purchase_requisition_detail prd left join purchase_requisition pr on pr.purchase_requisition_id = prd.purchase_requisition_id 	where item_id = ? and destination_location = ? and company_id = ?  and pr.requisition_status not in (214,33)";

}
