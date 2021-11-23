package com.dci.tenant.finance.generalpurchaseInvoice;

public class GeneralPurchaseInvoiceQueryUtil {

	public static String GET_COMPANY_LIST = "select company_id as id, company_name as text from company where company.company_id = ? Order by company_name asc";

	public static String GET_GRN_LIST = "select grn_id as id, grn_number as text from grn where  grn_id not in (select distinct grn_id from purchase_invoice_hdr where grn_id is not null) ORDER BY grn_number desc";

	public static String GET_CHARGE_LIST = "select acct_head_code as id,acct_head_name as text from account_head_master";

	public static String GET_ITEM_LIST = "select acct_head_code as id,concat(acct_head_code,' - ',acct_head_name) as text from account_head_master order by acct_head_name asc";

	public static String GET_SUPPLIER_LIST = "select supplier_acct_code as id, entity_name as text FROM entity where is_vendor='t'and  (supplier_acct_code!=NULL OR supplier_acct_code!='') order by entity_name asc";

	public static String GET_PURCHASE_INVOICE_LIST = "select invoice_no as puchaseInvoiceNo,to_char(invoice_dt,'DD/MM/YYYY') as puchaseInvoiceDate,e.entity_name as supplier,description as description, " + " amount as amount from general_purchase_invoice_hdr pih  left join entity e on pih.supplier=e.entity_id::varchar order by created_dt  desc ";

	// public static String SAVE_PURCHASE_INVOICE_LIST =
	// "INSERT INTO
	// general_purchase_invoice_hdr(invoice_no,invoice_dt,supplier,description,partyinvoice_no,currency,ex_rate,created_by,created_dt,company_code,amount,wotype,budget_type_id)
	// VALUES(?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,now(),?,?,?,?)";
	public static String SAVE_PURCHASE_INVOICE_LIST = "INSERT INTO general_purchase_invoice_hdr(invoice_no,invoice_dt,invoice_due_dt,supplier,description,partyinvoice_no,currency,ex_rate,created_by,created_dt,company_code,amount,wotype,wonumber,costCenter,budget_type_id, non_po) VALUES(?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,now(),?,?,?,?,?,?,?)";

	public static String SAVE_PURCHASE_INVOICE_DTL = "insert into general_purchase_invoice_dtl (invoice_no,sl_no,account_head_code,tax_amount,amount,total_amount,service_detail,cost_center,employee_id,student_id) values(?,?,?,?,?,?,?,?,?,?)";

	public static String SAVE_PURCHASE_INVOICE_PROD_DTL = " INSERT INTO purchase_invoice_prod_dtl(purchase_inv_no, si_no, item_id, quantity, unit_price, amount,cost_center,unit_tax_amount,unit_discount_amount,tax_amount,discount_amount,tax_account_code,employee,dept_code,location,customer,supplier,designation,company,asset) VALUES(?, ?, ?, ?, ?, ?, ? ,? ,? ,?, ?, ?,?,?,?,?,?,?,?,?) ";

	public static String SAVE_GENERAL_LEDGER_HDR = " INSERT INTO public.general_ledger(ledger_date, account_code, " + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + " exchange_rate, company_id,parent_code) " + " (select invoice_dt,supplier,invoice_no,amount as bc_credit,0.0 as bc_debit,amount as tc_credit,0.0 as tc_debit, " + " description,currency,ex_rate,company_code,'2000' as parent_code " + " from general_purchase_invoice_hdr where invoice_no=?)";

	public static String SAVE_GENERAL_LEDGER_CHARGE_DTL = " INSERT INTO public.general_ledger(ledger_date, account_code, " + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + " exchange_rate, company_id,parent_code)  " + " (select pih.invoice_dt,charge_code,pid.purchase_inv_no,0.0 as bc_credit,pid.amount as bc_debit,0.0 as tc_credit, " + " pid.amount as tc_debit,pid.sht_details,'INR' as currency,1.0 as exchange_rate,pih.company_code, " + " pid.subgroup_code from purchase_invoice_dtl pid "
			+ " left join purchase_invoice_hdr pih on pih.invoice_no = pid.purchase_inv_no " + " where purchase_inv_no =?)";

	public static String SAVE_GENERAL_LEDGER_PRODUCT_DTL = "INSERT INTO public.general_ledger(ledger_date, account_code,transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code,exchange_rate, company_id,parent_code) select pih.invoice_dt,account_head_code as account_code,pipd.invoice_no,0.0 as bc_credit,total_amount as bc_debit,0.0 as tc_credit,total_amount as tc_debit,'Operational Expense' as narration,'INR' as currency,1.0 as exchange_rate,pih.company_code,ah.subgroup_acct_code as parent_code from general_purchase_invoice_dtl pipd left join general_purchase_invoice_hdr pih on pih.invoice_no = pipd.invoice_no left join account_head_master ah on ah.acct_head_code=pipd.account_head_code where pipd.invoice_no=?";

	public static String SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL = " INSERT INTO public.general_ledger(ledger_date, account_code, " + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + " exchange_rate, company_id,parent_code,item_id,cost_center) " + "select pih.invoice_dt,pipd.tax_account_code as account_code,purchase_inv_no,0.0 as bc_credit,pipd.tax_amount as bc_debit, " + "0.0 as tc_credit,pipd.tax_amount as tc_debit,'Purchase Tax' as narration,'INR' as currency,1.0 as exchange_rate,pih.company_code, "
			+ "substring(pipd.tax_account_code from 0 for 5) parent_code ,pipd.item_id,pipd.cost_center " + " from purchase_invoice_prod_dtl pipd left join purchase_invoice_hdr pih on pih.invoice_no = purchase_inv_no " + "where purchase_inv_no =?";

	public static String SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL_ID = " INSERT INTO public.general_ledger(ledger_date, account_code, " + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + " exchange_rate, company_id,parent_code,item_id,cost_center) " + " VALUES(?, ?, ?, ?, ?, ?, ? ,? ,? ,?, ?, ?,?,?) ";

	public static String GET_GRN_HDR = "select case when po.payment_terms is null then coalesce(e.vendor_payment_terms,0) else coalesce(po.payment_terms,0) end as paymentTerms , vendor_invoice_no as partyInvoiceNo,to_char(vendor_invoice_date,'DD/MM/YYYY') as partyInvoiceDate , e.currency , e.supplier_acct_code " + "as supplier,g.company_id as company,to_char(invoice_due_date,'DD/MM/YYYY') as dueDate from grn g " + "left join  entity e on  e.entity_id=g.entity_id " + "left join purchase_order po on po.purchase_order_id=g.purchase_order_id "
			+ "where grn_id = ?";

	public static String GET_GRN_DTL = "select coalesce(pqd.percentage,0) as discountPercentage, tmp.itemId,tmp.quantity,pd.unit_price unitprice,pqd.tax_id as taxCode,coalesce(tmp.converted_quantity,0) convertedQuantity ,coalesce(pqd.quantity,0) as vendorQuantity,coalesce(pd.tax_amount,0) taxAmount, " + "coalesce((pd.unit_price*pd.quantity),0) productAmount,coalesce(pqd.purchase_quantity,0) as purchaseQuanity, coalesce(pqd.discount_type,0) as discountType,coalesce(pqd.discount_amount,0) discountAmount, "
			+ "coalesce((pd.discount/pd.quantity),0) as unitdiscountAmount from purchase_order_detail pd " + "left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id=pd.purchase_quote_detail_id " + " inner join ( " + "select item_id as itemId,quantity,coalesce(mrp_price,0) unitprice,converted_quantity, " + "purchase_order_detail_id " + "from grn_detail where grn_id= ?) tmp on tmp.purchase_order_detail_id = pd.purchase_order_detail_id order by tmp.itemId";
	// changes yet to done
	public static String GET_PURCHASE_INVOICE_HDR = " select invoice_no puchaseInvoiceNo,to_char(invoice_dt,'dd/mm/yyyy') puchaseInvoiceDate,to_char(invoice_due_dt,'dd/mm/yyyy') invoiceDueDate, " + "	partyinvoice_no partyInvoiceNo,description description,supplier supplier,   COALESCE(currency,'') AS currency, COALESCE(ex_rate,0) as exchangeRate, " + "	COALESCE(amount,0) as bcamount,COALESCE(amount,0) as productwithTaxTotal,company_code company ,wotype as wotype,wonumber as wonumber,costCenter as costCenter, "
			+ "	 COALESCE(budget_type_id,0) as budgetType,   COALESCE(non_po,false) as nonPo   from general_purchase_invoice_hdr pi where invoice_no=? ";

	public static String GET_PURCHASE_INVOICE_DTL = "select COALESCE(pur_inv_dtl_id,0) as purDtlId, sl_no as siNo,charge_code as accountHeadCode,sht_details as shortDetail,subgroup_code subGrpCode,amount as amount ,employee as employeeCode, location as countryCode, " + "customer as customerCode,supplier as supplierCode,designation as designationCode,cost_center as costCenter,company as companyCode,COALESCE(asset,0) as  assetCode , dept_code as departmentCode " + "from PURCHASE_INVOICE_DTL  where purchase_inv_no=? order by SL_NO";

	public static String GET_PURCHASE_PROD_INVOICE_DTL = " select COALESCE(invoice_no_dtl_id,0) as prodDtlId,sl_no as siNo,account_head_code as accountHeadCode,amount as amount,tax_amount as taxAmount, " + " total_amount as totalAmount,service_detail as servicedetail,a.acct_head_name as accountHeadName ,cost_center as costCenter , student_id as departmentCode , employee_id as employeeCode from general_purchase_invoice_dtl " + " left join account_head_master a on account_head_code=a.acct_head_code where invoice_no =? order by sl_no ";

	public static String sUpdatePurchaseInvoice = "UPDATE general_purchase_invoice_hdr SET invoice_dt=to_date(?,'dd/mm/yyyy'),invoice_due_dt=to_date(?,'dd/mm/yyyy'),supplier=?,costCenter=?,description=?,partyinvoice_no=?,currency=?,ex_rate=?, modified_by=?, modified_dt=now(),company_code=?,amount=?, non_po = ?,wotype = ? , wonumber = ?  where invoice_no=?";
	// public static final String GET_PURCHASE_ORDER_NUMBER_CAPX =
	// "SELECT CASE WHEN MAX(purchase_order_no) IS NULL THEN 'CX/PO0001' ELSE
	// 'CX/PO'|| lpad(cast(max(cast(SUBSTRING(purchase_order_no,6,13) as int)+1)
	// as text),4,'0') END from purchase_order where purchase_order_no like
	// 'CX/PO%' ";

	public static String GET_PURCHASE_INVOICE_NO = "SELECT CASE WHEN MAX(invoice_no) IS NULL " + " THEN ? ELSE rpad(MAX(invoice_no),6,'GPI')|| " + " lpad(cast(cast((SUBSTRING(MAX(invoice_no),6)) as int)+1 " + " as text),4,'0') END FROM general_purchase_invoice_hdr where invoice_no like ?";
	// public static String GET_PURCHASE_INVOICE_NO_CAPX =
	// "SELECT CASE WHEN MAX(invoice_no) IS NULL " +
	// " THEN ? ELSE rpad(MAX(invoice_no),7,'CX/GPI')|| " +
	// " lpad(cast(cast((SUBSTRING(MAX(invoice_no),7)) as int)+1 " +
	// " as text),4,'0') END FROM general_purchase_invoice_hdr where invoice_no
	// like ?";
	// public static String GET_PURCHASE_INVOICE_NO_REVEX =
	// "SELECT CASE WHEN MAX(invoice_no) IS NULL " +
	// " THEN ? ELSE rpad(MAX(invoice_no),7,'RX/GPI')|| " +
	// " lpad(cast(cast((SUBSTRING(MAX(invoice_no),7)) as int)+1 " +
	// " as text),4,'0') END FROM general_purchase_invoice_hdr where invoice_no
	// like ?";
	public static final String GET_PURCHASE_INVOICE_NO_CAPX = "SELECT CASE WHEN MAX(invoice_no) IS NULL  THEN 'CWO-GPI00001' ELSE 'CWO-GPI'|| lpad(cast(max(cast(SUBSTRING(invoice_no,8,14) as int)+1) as text),5,'0') END from general_purchase_invoice_hdr where invoice_no like 'CWO-GPI%' ";
	public static final String GET_PURCHASE_INVOICE_NO_REVEX = "SELECT CASE WHEN MAX(invoice_no) IS NULL  THEN 'RWO-GPI00001' ELSE 'RWO-GPI'|| lpad(cast(max(cast(SUBSTRING(invoice_no,8,14) as int)+1) as text),5,'0') END from general_purchase_invoice_hdr where invoice_no like 'RWO-GPI%' ";
	public static final String sAddPurchaseInvoice = "INSERT INTO PURCHASE_INVOICE_HDR (INVOICE_NO, INVOICE_DT,PURCHASE_NO,SUPPLIER, DUE_DT, CURRENCY,EXCHANGE_RATE, " + " CREATED_BY, CREATED_DT,PARTYINVOICE_NO,PARTYINVOICE_DT,bc_amount,tc_amount,STATUS,COMPANY_CODE,DESCRIPTION)  " + " VALUES(?,?,?, ?,?,?,?,'C01',current_date,?,?,?,?,'T',?,?)";

	public static final String sAddPurchaseInvoiceDetail = "INSERT INTO PURCHASE_INVOICE_DTL (PURCHASE_INV_NO, ACT_NAME,SHT_DETAILS, EXCHANGE_RATE," + " CURRENCY, AMOUNT_LC," + " AMOUNT_USD,VESSEL,VOYAGE,SECTOR,SUBGROUP_CODE,SL_NO) VALUES(" + " 'PIN000SAM1',:acctName, :shortDetail,:exgRate,:currency," + " :amount,:amountUsd,:vesselCode,:voyageCode,:service,'A0101',1)";

	public static final String deletePurchaseItemInvoiceDtl = "delete from purchase_invoice_prod_dtl where purchase_inv_no=?";

	public static final String deletePurchaseInvoiceDtl = "delete from PURCHASE_INVOICE_DTL where purchase_inv_no=?";

	public static final String deletePurchaseInvoiceHdr = "delete from PURCHASE_INVOICE_HDR where invoice_no=?";

	public static final String sGetPurchaseInvoiceDtlList = "select ACT_NAME,SHT_DETAILS,CURRENCY,EXCHANGE_RATE,AMOUNT_LC,AMOUNT_USD,VESSEL,VOYAGE,SECTOR,SUBGROUP_CODE,SL_NO,SUB_ACCOUNT_CODE from PURCHASE_INVOICE_DTL where PURCHASE_INV_NO=?";

	public static final String deletePurchaseInvoiceProductDtl = "delete from purchase_invoice_prod_dtl where purchase_inv_no=?";

	public static final String updatePurchaseInvoiceProductDtl = "UPDATE purchase_invoice_prod_dtl SET employee=?, location=?, customer=?, supplier=?, designation=?, company=?, asset=?, dept_code=? , cost_center=?  where purchase_inv_no=?";

	public static final String updatePurchaseInvoiceDtl = "UPDATE purchase_invoice_dtl SET employee=?, location=?, customer=?, supplier=?, designation=?, company=?, asset=?, dept_code=? , cost_center=?  where pur_inv_dtl_id=?";

	public static final String DELETE_GENERAL_LEDGER = "delete from general_ledger where transaction_no=?";

	public static final String CHECK_FRIEGHT_TOTAL = "select po.freight as frieghtTotal from purchase_invoice_hdr as pih inner join grn as g on g.grn_id=pih.grn_id inner join purchase_order as po on po.purchase_order_id=g.purchase_order_id where g.grn_id=?";

	public static final String CHECK_FRIEGHT_VALUE = "select COALESCE(po.freight,0) as frieghtTotal,coalesce(po.total_amount,0) poTotalAmount, po.purchase_order_Id as purchaseOrderId from grn as g inner join purchase_order as po on po.purchase_order_id=g.purchase_order_id where  g.grn_id=?";

	public static final String GET_GRNID_LIST = "select g.grn_id as grnNo from grn as g left join  purchase_order as po on po.purchase_order_id= g.purchase_order_id where po.purchase_order_id=?";

	public static final String GET_TOTAL_CHARGES_LIST = "select coalesce(sum(pid.amount),0) as amount from purchase_invoice_hdr as pih inner join  purchase_invoice_dtl as pid on pid.purchase_inv_no=pih.invoice_no where grn_id=?";

	public static final String GET_PURCHASE_INVOICE_HDR_print = "select invoice_no puchaseInvoiceNo,to_char(invoice_dt,'dd/mm/yyyy') puchaseInvoiceDate,to_char(invoice_due_dt,'dd/mm/yyyy') invoiceDueDate, " + "	partyinvoice_no partyInvoiceNo,description description,  COALESCE(pi.currency,'') AS currency, COALESCE(ex_rate,0) as exchangeRate, " + "		COALESCE(amount,0) as bcamount,COALESCE(amount,0) as productwithTaxTotal,c.company_name company ,wotype as wotype,wonumber as wonumber,costCenter as costCenter, "
			+ "		 COALESCE(budget_type_id,0) as budgetType,e.entity_name as supplier  from general_purchase_invoice_hdr pi " + "		 left join entity e on pi.supplier=e.entity_id::varchar " + "		 left join company c on company_code=c.company_id " + "where invoice_no=?";;

	public static String GETCURRENCYCODE = "select currency from entity where supplier_acct_code=?";

	public static String GETEXCHANGERATE = "select value as exchangeRate from exchange_rate_table  where currency=?";

	// new

	public static String DELETE_GL_ENTRY = "delete from general_ledger where transaction_no =?";

	public static String DELETE_GPI_DTL_ENTRY = "delete from general_purchase_invoice_dtl where invoice_no =?";
	public static String COUNT_GPI_DTL_ENTRY = "select COALESCE(count(*),0) from general_purchase_invoice_dtl where invoice_no =?";

	// / sp
	public static String GET_WO_LIST = "select purchase_requisition_id as id, concat(requisition_number,' - ',pr_request_number)  as text from purchase_requisition where request_type ='216' ORDER BY requisition_number desc";

	public static String GET_COST_CENTER_LIST = "select cc.cost_center_id as id,cc.cost_center_name as text from cost_center cc left join company_master c on cc.company_id=c.company_code where c.company_code=?";

	public static String GET_DTL_LIST = "select concat(item.item_name,' - ',prd.item_desc) as servicedetail,quantity from purchase_requisition_detail prd left join item_new item on item.item_id=prd.item_id left join item_grn_attribute ga on ga.item_id = item.item_id where purchase_requisition_id=?";

}
