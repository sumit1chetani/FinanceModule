package com.dci.tenant.finance.purchaseInvoice;

public class PurchaseInvoiceQueryUtil {

	public static String GET_COMPANY_LIST = "select company_code as id, company_name as text from company_master company where company.company_code = ? Order by company_name asc";

	// public static String GET_GRN_LIST =
	// "select grn_id as id, grn_number as text from grn where grn_id not in
	// (select distinct grn_id from purchase_invoice_hdr where grn_id is not
	// null) ORDER BY grn_number desc";

	// public static String GET_GRN_LIST =
	// " select grn_id as id,concat(grn_number,' - ',vendor_invoice_no) as text
	// from grn where grn_id not in (select distinct grn_id from
	// purchase_invoice_hdr "
	// + " where grn_id is not null) ORDER BY grn_number desc ";

	public static String GET_GRN_LIST = "select grn_id as id,concat(grn_number,' - ',vendor_invoice_no) as text from grn g where   g.entity_id = (select entity_id  from entity  where  supplier_acct_code = ?  limit 1 ) " + " and grn_id not in(select grn_id from purchase_invoice_hdr where grn_id is not null) ";

	public static String GET_CHARGE_LIST = "select acct_head_code as id,TRIM(acct_head_name) as text from account_head_master";

	public static String GET_ITEM_LIST = "select item_id as id,concat(item_code,' - ',item_name) as text from item_new order by item_name asc";

	// public static String GET_SUPPLIER_LIST =
	// "select entity_id as id, entity_name as text FROM entity where
	// is_vendor='t'and (supplier_acct_code!=NULL OR supplier_acct_code!='')
	// order by entity_name asc";
	// public static String GET_SUPPLIER_LIST = "select entity_id as
	// id,concat(supplier_acct_code,' - ',entity_name) as text from entity where
	// is_vendor='t' ";
	public static String GET_SUPPLIER_LIST = "select entity_id as id,entity_name as text from entity where is_vendor='t'";

	// public static String GET_PURCHASE_INVOICE_LIST = "select invoice_no as
	// puchaseInvoiceNo,to_char(invoice_dt,'DD/MM/YYYY') as
	// puchaseInvoiceDate,e.entity_name as supplier, " + " description as
	// description,amount as amount,COALESCE(payment_status,'') paymentStatus
	// from
	// purchase_invoice_hdr pih " + " left join entity e on e.supplier_acct_code
	// =
	// pih.supplier order by invoice_no desc";
	//public static String GET_PURCHASE_INVOICE_LIST =" select b.srvc_prtnr_bin id,concat(b.srvc_prtnr_cd,'-',b.srvc_prtnr_nam) as text from vendor_master_new b where  actv_bt='1' ORDER BY b.srvc_prtnr_nam";
	public static String GET_PURCHASE_INVOICE_LIST = " select invoice_no as puchaseInvoiceNo,to_char(invoice_dt,'DD/MM/YYYY') as puchaseInvoiceDate,e.entity_name as  supplier, " + "	 pih.description as description,amount as amount,COALESCE(payment_status,'') paymentStatus,g.grn_number as grnNumber from purchase_invoice_hdr pih  " + "	 left join entity e on pih.supplier=e.supplier_acct_code::varchar " + "	 left join grn g on pih.grn_id=g.grn_id " + "	  order by invoice_no desc ";

	public static String SAVE_PURCHASE_INVOICE_LIST = "INSERT INTO purchase_invoice_hdr(potype,budgetType,invoice_no, invoice_dt, supplier, due_dt, description, " + " partyinvoice_no, partyinvoice_dt,currency,ex_rate, created_by, created_dt,company_code, grn_id, " + " amount,tc_amount,bc_amount,payment_status,cost_center" + ",total_tax) VALUES(?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_date, ?, ?, ?, ?,?, ?,? ,?)";

	public static String SAVE_PURCHASE_INVOICE_DTL = " INSERT INTO purchase_invoice_dtl(purchase_inv_no, sht_details, subgroup_code, " + " sl_no, charge_code, amount,employee,dept_code,location,customer,supplier,designation,company,asset,cost_center) VALUES(?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?) ";

	public static String SAVE_PURCHASE_INVOICE_PROD_DTL = " INSERT INTO purchase_invoice_prod_dtl(purchase_inv_no, si_no, item_id, quantity, unit_price, amount,cost_center,unit_tax_amount,unit_discount_amount,tax_amount,discount_amount,tax_account_code,employee,dept_code,location,customer,supplier,designation,company,asset,taxtotal_po) VALUES(?, ?, ?, ?, ?, ?, ? ,? ,? ,?, ?, ?,?,?,?,?,?,?,?,?,?) ";

	public static String SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL_ID = "INSERT INTO public.general_ledger(ledger_date, account_code, " + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + " exchange_rate, company_id,parent_code,item_id,cost_center,created_by,created_date) " + " VALUES(?, ?, ?, ?, ?, ?, ? ,? ,? ,?, ?, ?,?,? ,?,current_date) ";
	public static String SAVE_GENERAL_LEDGER_HDR = "INSERT INTO public.general_ledger(ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, exchange_rate, company_id,parent_code,created_by,created_date,sub_account_code,party_inv_no,cost_center,budget) \n"
			+ " (select invoice_dt,'20090001',invoice_no,amount as bc_credit,0.0 as bc_debit,amount as tc_credit,0.0 as tc_debit, description,currency,ex_rate,company_code,'2009' as parent_code,created_by,created_dt,supplier,partyinvoice_no,cost_center,case when null_or_empty(budgettype) = false then budgettype::integer else 0 end from purchase_invoice_hdr where invoice_no=?)";
	// public static String SAVE_GENERAL_LEDGER_HDR = " INSERT INTO
	// public.general_ledger(ledger_date, account_code, " + " transaction_no,
	// bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + "
	// exchange_rate, company_id,parent_code) " + " (select
	// invoice_dt,'10030023',invoice_no,amount as bc_credit,0.0 as
	// bc_debit,amount
	// as tc_credit,0.0 as tc_debit, " + "
	// description,currency,ex_rate,company_code,'2008' as parent_code " + "
	// from
	// purchase_invoice_hdr where invoice_no=?)";
	public static String SAVE_GENERAL_LEDGER_HDR1 = " INSERT INTO public.general_ledger(ledger_date, account_code,  transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, exchange_rate, company_id,parent_code) (select invoice_dt,supplier,invoice_no,amount as bc_credit,0.0 as bc_debit,amount as tc_credit,0.0 as tc_debit,  description,currency,ex_rate,company_code,'2000' as parent_code from general_purchase_invoice_hdr where invoice_no= ? )";
	/*
	 * public static String SAVE_GENERAL_LEDGER_CHARGE_DTL =
	 * " INSERT INTO public.general_ledger(ledger_date, account_code, " +
	 * " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, "
	 * + " exchange_rate, company_id,parent_code)  " +
	 * " (select pih.invoice_dt,charge_code,pid.purchase_inv_no,0.0 as bc_credit,pid.amount as bc_debit,0.0 as tc_credit, "
	 * +
	 * " pid.amount as tc_debit,pid.sht_details,'INR' as currency,1.0 as exchange_rate,pih.company_code, "
	 * + " pid.subgroup_code from purchase_invoice_dtl pid " +
	 * " left join purchase_invoice_hdr pih on pih.invoice_no = pid.purchase_inv_no "
	 * + " where purchase_inv_no =?)";
	 */

	public static String SAVE_GENERAL_LEDGER_CHARGE_DTL = "\n" + "INSERT INTO public.general_ledger(ledger_date, account_code,  transaction_no, bc_credit,\n" + " bc_debit, tc_credit, tc_debit, narration, currency_code,  exchange_rate, company_id,parent_code,created_by,created_date)   (select pih.invoice_dt,charge_code,\n" + " pid.purchase_inv_no,0.0 as bc_credit,pid.amount as bc_debit,0.0 as tc_credit,  pid.amount as tc_debit,pid.sht_details,'INR' as currency,1.0 as exchange_rate,\n"
			+ " pih.company_code,  pid.subgroup_code,pih.created_by,pih.created_dt from purchase_invoice_dtl pid \n" + "			 left join purchase_invoice_hdr pih on pih.invoice_no = pid.purchase_inv_no  where purchase_inv_no =?)";

	public static String SAVE_GENERAL_LEDGER_CHARGE_DTL1 = "INSERT INTO public.general_ledger(ledger_date, account_code,   transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code,   exchange_rate, company_id)    (select pih.invoice_dt,account_head_code,pid.invoice_no,0.0 as bc_credit,pid.amount as bc_debit,0.0 as tc_credit,   pid.amount as tc_debit,'','INR' as currency,1.0 as exchange_rate,pih.company_code from general_purchase_invoice_dtl pid 	left join general_purchase_invoice_hdr pih on pih.invoice_no = pid.invoice_no   where pih.invoice_no = ? ) ";
	public static String SAVE_GENERAL_LEDGER_PRODUCT_DTL = " INSERT INTO public.general_ledger(ledger_date, account_code, " + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + " exchange_rate, company_id,parent_code,item_id,cost_center) " + " select pih.invoice_dt,'40090001' as account_code,purchase_inv_no,0.0 as bc_credit,pipd.amount - pipd.discount_amount as bc_debit, " + "  0.0 as tc_credit,pipd.amount - -pipd.discount_amount as tc_debit,'Operational Expense' as narration,'INR' as currency, "
			+ "  1.0 as exchange_rate,pih.company_code,'4009' as parent_code ,pipd.item_id,pipd.cost_center " + "  from purchase_invoice_prod_dtl pipd  " + " left join purchase_invoice_hdr pih on pih.invoice_no = purchase_inv_no " + "  where purchase_inv_no=?";

	public static String SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL = " INSERT INTO public.general_ledger(ledger_date, account_code, " + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + " exchange_rate, company_id,parent_code,item_id,cost_center) " + "select pih.invoice_dt,pipd.tax_account_code as account_code,purchase_inv_no,0.0 as bc_credit,pipd.tax_amount as bc_debit, " + "0.0 as tc_credit,pipd.tax_amount as tc_debit,'Purchase Tax' as narration,'INR' as currency,1.0 as exchange_rate,pih.company_code, "
			+ "substring(pipd.tax_account_code from 0 for 5) parent_code ,pipd.item_id,pipd.cost_center " + " from purchase_invoice_prod_dtl pipd left join purchase_invoice_hdr pih on pih.invoice_no = purchase_inv_no " + "where purchase_inv_no =?";

	// public static String SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL_ID = "INSERT
	// INTO
	// public.general_ledger(ledger_date, account_code, " + " transaction_no,
	// bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + "
	// exchange_rate, company_id,parent_code,item_id,cost_center) " + "
	// VALUES(?, ?,
	// ?, ?, ?, ?, ? ,? ,? ,?, ?, ?,?,?) ";
	/*
	 * public static String GET_GRN_HDR =
	 * "select po.cost_center_id as costCenterId,case when po.payment_terms is null then coalesce(e.vendor_payment_terms,0) else coalesce(po.payment_terms,0) end as paymentTerms , vendor_invoice_no as partyInvoiceNo,to_char(vendor_invoice_date,'DD/MM/YYYY') as partyInvoiceDate , e.currency , e.supplier_acct_code "
	 * +
	 * "as supplier,g.company_id as company,to_char(invoice_due_date,'DD/MM/YYYY') as dueDate,description as description from grn g "
	 * + "left join  entity e on  e.entity_id=g.entity_id " +
	 * "left join purchase_order po on po.purchase_order_id=g.purchase_order_id " +
	 * "where grn_id = ?";
	 */
	/*
	 * public static String GET_GRN_DTL =
	 * "select coalesce(pqd.percentage,0) as discountPercentage, tmp.itemId,tmp.quantity,pd.unit_price unitprice,pqd.tax_id as taxCode,coalesce(tmp.converted_quantity,0) convertedQuantity ,coalesce(pqd.quantity,0) as vendorQuantity,coalesce(pd.tax_amount,0) taxAmount, "
	 * +
	 * "coalesce((pd.unit_price*pd.quantity),0) productAmount,coalesce(pqd.purchase_quantity,0) as purchaseQuanity, coalesce(pqd.discount_type,0) as discountType,coalesce(pqd.discount_amount,0) discountAmount, "
	 * +
	 * "coalesce((pd.discount/pd.quantity),0) as unitdiscountAmount,pd.tax_cgst+pd.tax_sgst+pd.tax_igst  as totalTaxPo from purchase_order_detail pd "
	 * +
	 * "left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id=pd.purchase_quote_detail_id "
	 * + " inner join ( " +ok
	 * 
	 * "select item_id as itemId,quantity,coalesce(mrp_price,0) unitprice,converted_quantity, "
	 * + "purchase_order_detail_id " +
	 * "from grn_detail where grn_id= ?) tmp on tmp.purchase_order_detail_id = pd.purchase_order_detail_id order by tmp.itemId"
	 * ;
	 * 
	 */

	public static String GET_GRN_DTL = "select coalesce(pqd.percentage,0) as discountPercentage, tmp.costdtl,tmp.itemId,tmp.quantity,pd.unit_price unitprice,pqd.tax_id as taxCode,coalesce(tmp.converted_quantity,0) convertedQuantity ,coalesce(pqd.quantity,0) as vendorQuantity,coalesce(pd.tax_amount,0) taxAmount,      coalesce((pd.unit_price*tmp.quantity),0) productAmount,coalesce(pqd.purchase_quantity,0) as purchaseQuanity, coalesce(pqd.discount_type,0) as discountType, " + " coalesce((pd.discount/pd.quantity),0)*tmp.quantity as discountAmount, "
			+ "			   coalesce((pd.discount/pd.quantity),0) as unitdiscountAmount, " + "((pd.unit_price*tmp.quantity)-coalesce((pd.discount/pd.quantity),0)*tmp.quantity)/100* " + "(pd.tax_cgst_percent+pd.tax_sgst_percent+pd.tax_igst_percent) "
			+ " as totalTaxPo  from purchase_order_detail pd      left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id=pd.purchase_quote_detail_id       inner join (      select item_id as itemId,quantity,coalesce(mrp_price,0) unitprice,converted_quantity,  cost_center as costdtl,purchase_order_detail_id      from grn_detail where grn_id= ?) tmp on tmp.purchase_order_detail_id = pd.purchase_order_detail_id order by tmp.itemId";

	public static String GET_GRN_HDR = "select po.cost_center_id as costCenterId,case when po.payment_terms is null then coalesce(e.vendor_payment_terms,0) else coalesce(po.payment_terms,0) end as paymentTerms , vendor_invoice_no as partyInvoiceNo,to_char(vendor_invoice_date,'DD/MM/YYYY') as partyInvoiceDate , e.currency , e.supplier_acct_code " + "as supplier,g.company_id as company,to_char(invoice_due_date,'DD/MM/YYYY') as dueDate,description as description,po.total_cgst+po.total_sgst+total_igst+total_discount as totalTaxPo  from grn g "
			+ "left join  entity e on  e.entity_id=g.entity_id " + "left join purchase_order po on po.purchase_order_id=g.purchase_order_id " + "where grn_id = ?";
	// changes done

	// public static String GET_PURCHASE_INVOICE_HDR = "select invoice_no
	// puchaseInvoiceNo,to_char(invoice_dt,'dd/mm/yyyy')
	// puchaseInvoiceDate,to_char(due_dt,'dd/mm/yyyy') dueDate, partyinvoice_no
	// partyInvoiceNo, to_char(partyinvoice_dt,'dd/mm/yyyy')
	// partyInvoiceDate,pi.description description, COALESCE(currency,'') AS
	// currency, COALESCE(ex_rate,0) as exchangeRate,COALESCE(amount,0) as
	// amount,COALESCE(tc_amount,0) as tcamount,COALESCE(bc_amount,0) as
	// bcamount,COALESCE(pi.grn_id,0) as grnNo,COALESCE(grn_number,'') as
	// grnCode,company_code company,cost_center as costCenter,(select entity_id
	// from
	// entity where supplier_acct_code = supplier) as supplier from
	// PURCHASE_INVOICE_HDR pi left join grn on grn.grn_id = pi.grn_id where
	// invoice_no=?";

	public static String GET_PURCHASE_INVOICE_HDR = "select potype as potype,budgetType as budgetType,COALESCE(total_tax,0)  as totalTaxPo,invoice_no puchaseInvoiceNo,to_char(invoice_dt,'dd/mm/yyyy') puchaseInvoiceDate,to_char(due_dt,'dd/mm/yyyy') dueDate, " + " partyinvoice_no partyInvoiceNo, to_char(partyinvoice_dt,'dd/mm/yyyy') partyInvoiceDate,pi.description description, " + "  COALESCE(pi.currency,'') AS currency, COALESCE(ex_rate,0) as exchangeRate,COALESCE(amount,0) as amount,COALESCE(tc_amount,0) as tcamount, "
			+ "  COALESCE(bc_amount,0) as bcamount,COALESCE(pi.grn_id,0) as grnNo,COALESCE(grn_number,'') as grnCode,company_code company,cost_center as costCenter,e.supplier_acct_code as  supplier " + "   from PURCHASE_INVOICE_HDR pi " + "   left join grn on grn.grn_id = pi.grn_id " + "   left join entity e on supplier=e.supplier_acct_code::varchar " + "   where invoice_no=?";

	public static String GET_PURCHASE_INVOICE_DTL = "select COALESCE(pur_inv_dtl_id,0) as purDtlId, sl_no as siNo,charge_code as accountHeadCode,sht_details as shortDetail,subgroup_code subGrpCode,amount as amount ,employee as employeeCode, location as countryCode, " + "customer as customerCode,supplier as supplierCode,designation as designationCode,cost_center as costCenter,company as companyCode,COALESCE(asset,0) as  assetCode , dept_code as departmentCode " + "from PURCHASE_INVOICE_DTL  where purchase_inv_no=? order by SL_NO";

	public static String GET_PURCHASE_PROD_INVOICE_DTL = "select COALESCE(taxtotal_po,0) as totalTaxPo,COALESCE(pi_prod_dtl_id,0) as prodDtlId, si_no as siNo,item_id as itemId,quantity as quantity,unit_price as unitprice,COALESCE(amount+taxtotal_po,0) as amount, "
			+ "			 cost_center as costdtl ,COALESCE(unit_discount_amount,0) as unitDiscountAmount,COALESCE(unit_tax_amount,0) as unitTaxAmount,COALESCE(tax_amount,0) as taxAmount ,COALESCE(discount_amount,0) as discountAmount,employee as employeeCode, location as countryCode, customer as customerCode,supplier as supplierCode,designation as designationCode, company as companyCode, asset as  assetCode , dept_code as departmentCode from purchase_invoice_prod_dtl where purchase_inv_no =? order by si_no";
	public static String sUpdatePurchaseInvoice = " UPDATE purchase_invoice_hdr SET potype=?,budgetType=?,invoice_no=?, invoice_dt=?, supplier=?, due_dt=?, description=?, " + "partyinvoice_no=?, partyinvoice_dt=?,currency=?,ex_rate=?, modified_by=?, modified_dt=current_date,company_code=?, grn_id=?,  amount=?,tc_amount=?,bc_amount=?,cost_center=?  where invoice_no=?";

	public static String GET_PURCHASE_INVOICE_NO = " SELECT CASE WHEN MAX(invoice_no) IS NULL " + " THEN ? ELSE rpad(MAX(invoice_no),5,'PIN')|| " + " lpad(cast(cast((SUBSTRING(MAX(invoice_no),6)) as int)+1 " + " as text),5,'0') END FROM purchase_invoice_hdr where invoice_no like ?";

	public static final String sAddPurchaseInvoice = "INSERT INTO PURCHASE_INVOICE_HDR (INVOICE_NO, INVOICE_DT,PURCHASE_NO,SUPPLIER, DUE_DT, CURRENCY,EXCHANGE_RATE, " + " CREATED_BY, CREATED_DT,PARTYINVOICE_NO,PARTYINVOICE_DT,bc_amount,tc_amount,STATUS,COMPANY_CODE,DESCRIPTION)  " + " VALUES(?,?,?, ?,?,?,?,'C01',current_date,?,?,?,?,'T',?,?)";

	public static final String sAddPurchaseInvoiceDetail = "INSERT INTO PURCHASE_INVOICE_DTL (PURCHASE_INV_NO, ACT_NAME,SHT_DETAILS, EXCHANGE_RATE," + " CURRENCY, AMOUNT_LC," + " AMOUNT_USD,VESSEL,VOYAGE,SECTOR,SUBGROUP_CODE,SL_NO) VALUES(" + " 'PIN000SAM1',:acctName, :shortDetail,:exgRate,:currency," + " :amount,:amountUsd,:vesselCode,:voyageCode,:service,'A0101',1)";

	public static final String deletePurchaseItemInvoiceDtl = "delete from purchase_invoice_prod_dtl where purchase_inv_no=?";

	public static final String deletePurchaseInvoiceDtl = "delete from PURCHASE_INVOICE_DTL where purchase_inv_no=?";

	public static final String deletePurchaseInvoiceHdr = "delete from PURCHASE_INVOICE_HDR where invoice_no=?";

	public static final String sGetPurchaseInvoiceDtlList = "select ACT_NAME,SHT_DETAILS,CURRENCY,EXCHANGE_RATE,AMOUNT_LC,AMOUNT_USD,VESSEL,VOYAGE,SECTOR,SUBGROUP_CODE,SL_NO,SUB_ACCOUNT_CODE from PURCHASE_INVOICE_DTL where PURCHASE_INV_NO=?";

	public static final String deletePurchaseInvoiceProductDtl = "delete from purchase_invoice_prod_dtl where purchase_inv_no=?";

	public static final String updatePurchaseInvoiceProductDtl = "UPDATE purchase_invoice_prod_dtl SET employee=?, location=?, customer=?, supplier=?, designation=?, company=?, asset=?, dept_code=?   where purchase_inv_no=?";

	public static final String updatePurchaseInvoiceDtl = "UPDATE purchase_invoice_dtl SET employee=?, location=?, customer=?, supplier=?, designation=?, company=?, asset=?, dept_code=? , cost_center=?  where pur_inv_dtl_id=?";

	public static final String DELETE_GENERAL_LEDGER = "delete from general_ledger where transaction_no=?";

	public static final String CHECK_FRIEGHT_TOTAL = "select po.freight as frieghtTotal from purchase_invoice_hdr as pih inner join grn as g on g.grn_id=pih.grn_id inner join purchase_order as po on po.purchase_order_id=g.purchase_order_id where g.grn_id=?";

	public static final String CHECK_FRIEGHT_VALUE = "select COALESCE(po.freight,0) as frieghtTotal,coalesce(po.total_amount,0) poTotalAmount, po.purchase_order_Id as purchaseOrderId from grn as g inner join purchase_order as po on po.purchase_order_id=g.purchase_order_id where  g.grn_id=?";

	public static final String GET_GRNID_LIST = "select g.grn_id as grnNo from grn as g left join  purchase_order as po on po.purchase_order_id= g.purchase_order_id where po.purchase_order_id=?";

	public static final String GET_TOTAL_CHARGES_LIST = "select coalesce(sum(pid.amount),0) as amount from purchase_invoice_hdr as pih inner join  purchase_invoice_dtl as pid on pid.purchase_inv_no=pih.invoice_no where grn_id=?";

	public static final String GET_COST_LIST = "select cost_center_id as id,cost_center_name as text from cost_center order by cost_center_code asc";
	public static final String GET_COST_LIST_1 = "select cost_center_id as id,cost_center_name as text from cost_center order by cost_center_code asc";

	public static final String GET_COMPANY_COST = "select  cost_center_id as id,cost_center_name as text ,cc.company_id from cost_center cc " + " left join company c on cc.company_id=c.company_id where cc.company_id=?";
	public static final String GET_COMPANY_COST_ALL = "select  cost_center_id as id,cost_center_name as text ,cc.company_id from cost_center cc " + " left join company c on cc.company_id=c.company_id ";

	public static final String GET_SUpplier_GRN = "select grn_id as id,concat(grn_id,' - ',vendor_invoice_no) as text from grn where entity_id=?::int";

	public static final String GET_PURCHASE_INVOICE_DTL_VIEW = "select purchase_inv_no as puchaseInvoiceNo,sht_details as shortDetail, subgroup_code as subGrpCode,charge_code as chargecode ,a.acct_head_name as accountHeadName, " + " amount as amount,pur_inv_dtl_id as purDtlId from purchase_invoice_dtl " + " left join account_head_master  a on  charge_code=a.acct_head_code " + "   where purchase_inv_no=? ";
	/*
	 * public static final String GET_PURCHASE_INVOICE_HDR_VIEW =
	 * "select invoice_no as puchaseInvoiceNo,invoice_dt as puchaseInvoiceDate, " +
	 * " supplier as supplier,description as description,partyinvoice_no as partyInvoiceNo, "
	 * +
	 * "partyinvoice_dt as partyInvoiceDate,company_code as company,grn_id as grnNo,amount as amount, "
	 * + "tc_amount as tcamount,currency as currency,c.short_name as companyName, "
	 * +
	 * "ex_rate as exchangeRate,bc_amount as bcamount,cost_center as costCenter from purchase_invoice_hdr "
	 * + "left join company c on company_code=c.company_id " +
	 * "where invoice_no=? ";
	 */

	public static final String GET_PURCHASE_INVOICE_HDR_VIEW = "select invoice_no as puchaseInvoiceNo,invoice_dt as puchaseInvoiceDate,description as description,partyinvoice_no as partyInvoiceNo, " + "partyinvoice_dt as partyInvoiceDate,company_code as company,coalesce(grn_id,0) as grnNo,amount as amount, " + "tc_amount as tcamount,p.currency as currency,c.short_name as companyName, " + "ex_rate as exchangeRate,bc_amount as bcamount,cost_center as costCenter,e.entity_name as supplier from purchase_invoice_hdr p "
			+ "left join company c on company_code=c.company_id " + "left join  entity e on supplier=e.supplier_acct_code " + "where invoice_no=?";

	public static String GETCURRENCYCODE = "select currency from entity where supplier_acct_code=?";

	public static String GETEXCHANGERATE = "select value as exchangeRate from exchange_rate_table  where currency=?";

	public static final String CHK_Company = "select count(*) from company c where company_name=?";

	public static final String CHK_Supplier = "select count(*) from entity e where entity_name=?";

	public static final String CHK_CostCenter = "select count(*) from cost_center c where cost_center_name=?";

	public final static String GET_Charges = "select MLO_CODE,MLO_SHORT_NAME  from mlo_master  where (null_or_empty(mlo_or_payer,'MLO') ='MLO' or mlo_or_payer='N' or mlo_or_payer='Y')   and mlo_active='Y' and mlo_code  not in ('C01231','BA1000')  order by MLO_SHORT_NAME asc";

	public static String SAVE_PURCHASE_INVOICE_DTL_UPLOAD = "INSERT INTO purchase_invoice_dtl(purchase_inv_no, sht_details, subgroup_code, sl_no, charge_code, amount) VALUES(?, ?, ?, ?, ?, ?) ";

	public static String GET_Company_LIST = "select company_code,trim(company_name) as company_name from company_master";

	public static String GET_Supplier_LIST = "select entity_id,trim(entity_name) as entity_name from entity where is_vendor='t' ";

	public static String GET_cost_center_LIST = "select cost_center_id,trim(cost_center_name) as cost_center_name from cost_center";

	public static String SAVE_PURCHASE_INVOICE_HEADER_LIST = "INSERT INTO purchase_invoice_hdr(invoice_no, invoice_dt, supplier, description, currency,ex_rate, created_by, created_dt,company_code, amount,tc_amount,bc_amount,cost_center,due_dt) VALUES(?, ?, ?, ?, ?, ?, ?, current_date, ?, ?, ?, ?, ?, current_date)";

	public static String updatePurchaseInvoiceDtl_Acct = "UPDATE purchase_invoice_dtl_acct SET employee=?, location=?, customer=?, supplier=?, designation=?, company=?, asset=?, dept_code=? , cost_center=?  where pur_inv_dtl_id_acct=?";

	public static final String GET_GRN = "select cc.cost_center_id as id ,cc.cost_center_name as text from purchase_order po " + " left join grn grn on grn.purchase_order_id =po.purchase_order_id " + "left  join cost_center cc on po.cost_center_id::int=cc.cost_center_id where grn.grn_id=?";

	public static final String SAVE_PURCHASE_INVOICE_DTL_HEAD = "INSERT INTO purchase_invoice_dtl_acct(purchase_inv_no, sht_details, subgroup_code,  sl_no, charge_code, amount,employee,dept_code,location,customer,supplier,designation, " + " company,asset,cost_center) VALUES(?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?) ";

	public static final String GET_PURCHASE_INVOICE_DTL_ACCT = "select COALESCE(pur_inv_dtl_id_acct,0) as purDtlId, sl_no as siNo,charge_code as ahaccountHeadCode,sht_details as ahshortDetail, " + "subgroup_code subGrpCode,amount as ahamount ,employee as employeeCode, location as countryCode, " + "customer as customerCode,supplier as supplierCode,designation as designationCode,cost_center as costCenter, " + "company as companyCode,COALESCE(asset,0) as  assetCode , dept_code as departmentCode "
			+ "from purchase_invoice_dtl_acct  where purchase_inv_no=? order by SL_NO";

	public static final String GET_PURCHASE_INVOICE_DTL_VIEW_ACCT = "select purchase_inv_no as puchaseInvoiceNo,sht_details as ahshortDetail, subgroup_code as subGrpCode,charge_code as ahaccountHeadCode , " + "	a.acct_head_name as ahaccountHeadName,  amount as ahamount,pur_inv_dtl_id_acct as purDtlId from purchase_invoice_dtl_acct " + "	 left join account_head_master  a on  charge_code=a.acct_head_code " + "	 where purchase_inv_no=? ";

	public static final String GET_PURCHASE_DETAIL_FOR_AUTO_JV = "select supplier as vendorId,company_code as companyId,amount as totalAmount,TO_CHAR(invoice_dt,'dd-mm-yyyy') purchaseOrderDate,invoice_no as purchaseOrderNum from purchase_invoice_hdr where invoice_no =?";

	public static final String SAVE_GENERAL_LEDGER_DEBITCHARGE_DTL = "INSERT INTO public.general_ledger(ledger_date, account_code,  transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code,  exchange_rate, company_id,parent_code)   (select pih.invoice_dt,charge_code,pid.purchase_inv_no,pid.amount as bc_credit,0.0 as bc_debit,pid.amount as tc_credit, 0.0 as tc_debit,pid.sht_details,'INR' as currency,1.0 as exchange_rate,pih.company_code,  pid.subgroup_code from purchase_invoice_dtl pid \n"
			+ "			 left join purchase_invoice_hdr pih on pih.invoice_no = pid.purchase_inv_no  where purchase_inv_no =?);\n" + "	";

	public static final String SAVE_GENERAL_LEDGERCRDIT_PRODUCT_DTL = " INSERT INTO public.general_ledger(ledger_date, account_code, " + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + " exchange_rate, company_id,parent_code,item_id,cost_center) " + " select pih.invoice_dt,'40090001' as account_code,purchase_inv_no,pipd.amount - pipd.discount_amount as bc_credit,0.0 as bc_debit, " + "  pipd.amount - pipd.discount_amount as tc_credit,0.0 as tc_debit,'Operational Expense' as narration,'INR' as currency, "
			+ "  1.0 as exchange_rate,pih.company_code,'4009' as parent_code ,pipd.item_id,pipd.cost_center " + "  from purchase_invoice_prod_dtl pipd  " + " left join purchase_invoice_hdr pih on pih.invoice_no = purchase_inv_no " + "  where purchase_inv_no=?";

	public static final String SAVE_GL_ACCT_HEAD = "INSERT INTO public.general_ledger(ledger_date, account_code,  transaction_no, bc_credit,\n" + " bc_debit, tc_credit, tc_debit, narration, currency_code,  exchange_rate, company_id,parent_code,created_by,created_date)   (select pih.invoice_dt,charge_code,\n" + " pid.purchase_inv_no,0.0 as bc_credit,pid.amount as bc_debit,0.0 as tc_credit,  pid.amount as tc_debit,pid.sht_details,'INR' as currency,1.0 as exchange_rate,\n"
			+ " pih.company_code,  pid.subgroup_code,pih.created_by,pih.created_dt from purchase_invoice_dtl_acct pid \n" + " left join purchase_invoice_hdr pih on pih.invoice_no = pid.purchase_inv_no  where purchase_inv_no =?)";

	public static String SAVE_GENERAL_PURCHASE_INVOICE_HEADER_LIST = "INSERT INTO general_purchase_invoice_hdr(invoice_no, invoice_dt, supplier, description, currency,ex_rate, created_by, created_dt,company_code, amount, costcenter,invoice_due_dt, non_po) VALUES(?, ?, ?, ?, ?, ?, ?, current_date, ?, ?, ?,  current_date, true)";

	public static String SAVE_GENERAL_PURCHASE_INVOICE_DTL_UPLOAD = "INSERT INTO general_purchase_invoice_dtl(invoice_no, sl_no, account_head_code, tax_amount,amount, total_amount) VALUES(?, ?,?,  ?, ?,?)";
	public static String po = "select po_type potype from  purchase_order  where    purchase_order_id=?";
	public static String bud = "select budget_type_id budgetType  from  purchase_order  where    purchase_order_id=?";
	public static String grn = " select purchase_order_id from grn where grn_id =?";

}
