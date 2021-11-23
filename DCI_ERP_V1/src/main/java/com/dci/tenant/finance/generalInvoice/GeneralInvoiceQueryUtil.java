package com.dci.tenant.finance.generalInvoice;

public class GeneralInvoiceQueryUtil {

	// public static String GET_COMPANY_LIST = "select company_id as id,
	// company_name as text from company where company.company_id = ?";
	public static String GET_COMPANY_LIST = "select company_code as id, company_name as text from company_master ";

	public static String GET_INVOICE_LIST = " SELECT distinct on (invoice_no) invoice_no invoiceNo, TO_CHAR(invoice_dt,'DD/MM/YYYY') as invoiceDate, entity_name as customer, " + " sales_order_no as salesOrderNo,amount, received_status receivedStatus FROM public.general_invoice_hdr " + " left join customer_entity e on customer_acct_code = customer order by invoice_no desc";

	public static String GET_CUSTOMER_LIST = "select supplier_acct_code as id, entity_name as text, coalesce(customer_payment_terms,0) customerPaymentTerms  FROM entity where is_customer='f'and  (supplier_acct_code!=NULL OR supplier_acct_code!='') order by entity_name asc";

	public static String GET_CURRENCY_LIST = "select crrncy_cd as id,crrncy_nam as text from currency order by crrncy_nam asc";

	public static String GET_EXCHANGE_RATE = " select max(ex_date) exDate, value from exchange_rate_table where currency=? group by value ";

	public static String GET_ACCOUNTHEAD_LIST = "  select acct_head_code as id,concat(acct_head_code,'-',acct_head_name) as text from account_head_master ";

	// public static String SAVE_GENERAL_INVOICE_HDR = "INSERT INTO
	// public.general_invoice_hdr(invoice_no, invoice_dt, customer,
	// sales_order_no,
	// company, " + " manual_inv_no, due_date, remarks,currency,ex_rate,
	// amount,tc_amount,received_status,gin_id) VALUES(?, ?, ?, ? ,?, ?, ?, ?,
	// ?, ?,
	// ?, ?, ?,?)";

	public static String SAVE_GENERAL_INVOICE_HDR = "INSERT INTO public.general_invoice_hdr(invoice_no, invoice_dt, customer, sales_order_no, company, " + " manual_inv_no, due_date, remarks,currency,ex_rate, amount,tc_amount,received_status,gin_id,created_by,created_dt) VALUES(?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,current_date)";
	public static String GET_INVOICE_NO = " SELECT CASE WHEN MAX(invoice_no) IS NULL " + " THEN ? ELSE rpad(MAX(invoice_no),5,'IN')||  " + " lpad(cast(cast((SUBSTRING(MAX(invoice_no),5)) as int)+1  " + " as text),4,'0') END FROM general_invoice_hdr where invoice_no like ?";

	public static String SAVE_GENERAL_INVOICE_DTL = " " + "INSERT INTO public.general_invoice_dtl(invoice_no, sht_details, " + "subgroup_code, sl_no, charge_code, amount, tax,employee_id, student_id,cost_center) " + " VALUES(?, ?, ?, ?, ?, ?,?,?,?,?)";

	public static String SAVE_INVOICE_PROD_DTL = " INSERT INTO public.general_invoice_prod_dtl(invoice_no, si_no, item_id, quantity, unit_price, amount,cost_center, tax_amount) " + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	public static String GET_SALES_ORDER_LIST = "select sales_order_id as id,sales_order_code as text from sales_order where sales_order_id not in (select distinct sales_order_no from general_invoice_hdr) ORDER BY sales_order_code DESC";

	public static String UPDATE_INVOICE_PROD_DTL = "update public.general_invoice_dtl set cost_center=? where invoice_no=?";

	public static String DELETE_GENERAL_INVOICE_DTL = "delete from general_invoice_dtl where invoice_no=?";

	public static final String DELETE_GENERAL_INVOICE_PROD_DTL = "delete from general_invoice_prod_dtl where invoice_no=?";

	public static final String DELETE_GENERAL_LEDGER = "delete from general_ledger where transaction_no=?";

	public static final String GET_CUSTOMER_True_LIST = "select customer_acct_code as id, entity_name as text, coalesce(customer_payment_terms,0) customerPaymentTerms \n" + " FROM customer_entity where is_customer='t'and  (customer_acct_code!=NULL OR customer_acct_code!='') order by entity_name asc\n" + "\n" + "";

	public static final String GET_GENERALINV_GIN_HDR_Print = "SELECT invoice_no invoiceNo, to_char(invoice_dt,'DD/MM/YYYY') invoiceDate, c.pan as compGst,cu.pan_number as custgst,customer customer, company company, manual_inv_no manualInvoiceNo,   to_char(due_date,'DD/MM/YYYY') dueDate, COALESCE(inv.currency,'') AS currency, COALESCE(ex_rate,0) exchangeRate,   COALESCE(amount,0) as amount,COALESCE(tc_amount,0) as tcamount, inv.gin_id as ginId, COALESCE(gin_number,'') as ginCode,remarks as remarks,c.company_name as companyName ,cu.entity_name as customerName,\r\n" + 
			"cu.address_id,a.street as custAddress,a.city_id,cy.cty_nam as cityName  FROM general_invoice_hdr inv  \r\n" + 
			" left join gin g on g.gin_id = inv.gin_id \r\n" + 
			" left join company_master c on c.company_code = inv.company \r\n" + 
			" left join customer_entity cu on cu.customer_acct_code = inv.customer\r\n" + 
			"  left join address a on a.address_id = cu.address_id \r\n" + 
			"  left join city cy on cy.cty_id = a.city_id\r\n" + 
			"where invoice_no =?";
			
			/*"SELECT invoice_no invoiceNo,"
			+ " to_char(invoice_dt,'DD/MM/YYYY') invoiceDate, c.pan_no as compGst,cu.pan_number as custgst,customer customer, company company, manual_inv_no manualInvoiceNo,   to_char(due_date,'DD/MM/YYYY') dueDate, COALESCE(inv.currency,'') AS currency, COALESCE(ex_rate,0) exchangeRate,   COALESCE(amount,0) as amount,COALESCE(tc_amount,0) as tcamount, inv.gin_id as ginId, COALESCE(gin_number,'') as ginCode,remarks as remarks,c.company_name as companyName ,cu.entity_name as customerName,\n"
			+ "cu.address_id,a.street as custAddress,a.city_id,cy.city_name as cityName  FROM general_invoice_hdr inv  \n" + " left join gin g on g.gin_id = inv.gin_id \n" + " left join company_master c on c.company_code = inv.company \n" + " left join customer_entity cu on cu.customer_acct_code = inv.customer\n" + "  left join address a on a.address_id = cu.address_id \n" + "  left join city cy on cy.city_id = a.city_id\n" + "where invoice_no =?";*/
	public static final String GET_SALES_ORDER_LIST_PRINT = "\n" + " select sl_no as siNo,charge_code as accountHeadCode,sht_details as shortDetail,amount as amount,\n" + " subgroup_code as subGrpCode,ac.acct_head_name as accountName,sg.sub_group_acct_name as subGroupName,tax as tax from general_invoice_dtl 	\n" + " left join account_head_master ac on ac.acct_head_code = charge_code\n" + " left join sub_group_acct_master sg on sg.sub_group_acct_code = subgroup_code\n" + " where invoice_no=? ";

	public static final String SAVE_GENERAL_TAX_INSERT = "select * from sp_add_gi_taxinsert(?)";
	public static String GET_ITEM_LIST = "select item_id as id,concat(item_code, ' - ', item_name) as text from item_new ORDER BY item_name asc";

	public static String DELETE_GENERAL_INVOICE_HDR = "delete from general_invoice_hdr where invoice_no=?";

	public static String GET_GENERALINV_HDR = "SELECT invoice_no invoiceNo, to_char(invoice_dt,'DD/MM/YYYY') invoiceDate, customer customer, company company, manual_inv_no manualInvoiceNo, " + "to_char(due_date,'DD/MM/YYYY') dueDate, COALESCE(currency,'') AS currency, COALESCE(ex_rate,0) exchangeRate, " + "COALESCE(amount,0) as amount,COALESCE(tc_amount,0) as tcamount, sales_order_no as salesOrderNo,COALESCE(sales_order_code,'') as salesOrderCode,remarks as remarks "
			+ "FROM general_invoice_hdr inv left join sales_order so on so.sales_order_id = inv.sales_order_no where invoice_no = ?";

	public static String GET_GENERALINV_GIN_HDR = "SELECT invoice_no invoiceNo, to_char(invoice_dt,'DD/MM/YYYY') invoiceDate, customer customer, company company, manual_inv_no manualInvoiceNo, " + "to_char(due_date,'DD/MM/YYYY') dueDate, COALESCE(currency,'') AS currency, COALESCE(ex_rate,0) exchangeRate, " + "COALESCE(amount,0) as amount,COALESCE(tc_amount,0) as tcamount, inv.gin_id as ginId, COALESCE(gin_number,'') as ginCode,remarks as remarks " + "FROM general_invoice_hdr inv " + "left join gin g on g.gin_id = inv.gin_id "
			+ "where invoice_no = ?";

	public static String GET_GENERALINV_DTL = " select sl_no as siNo," + "charge_code " + "as accountHeadCode,sht_details as shortDetail," + "amount as amount, " + "" + " subgroup_code as subGrpCode ,employee_id as employeeCode , " + "student_id as departmentCode," + " cost_center as costCenter,tax as tax from general_invoice_dtl where invoice_no= ? ";

	public static String GET_GENERALINV_PROD_DTL = "select coalesce(inv_prod_dtl_id,0) as invoiceProdDtl, si_no as siNo,g.item_id as itemId,quantity as quantity,unit_price as unitprice,amount as amount, coalesce(tax_amount,0) taxAmount, cost_center as costCenter,coalesce(ac.item_name,act.acct_head_name) as productItem from  general_invoice_prod_dtl g left join item_new ac on ac.item_id = g.item_id left join account_head_master act on act.acct_head_code=g.item_id ::text   where invoice_no=?";

	// "\n" + "select coalesce(inv_prod_dtl_id,0) as invoiceProdDtl, si_no as
	// siNo,g.item_id as itemId,quantity as quantity,unit_price as
	// unitprice,amount
	// as amount, coalesce(tax_amount,0) taxAmount, cost_center as
	// costCenter,ac.item_name as productItem from general_invoice_prod_dtl g
	// \n" +
	// "left join item_new ac on ac.item_id = g.item_id\n" + "where
	// invoice_no=?";

	public static String UPDATE_GENERAL_INV_HDR = "update general_invoice_hdr set invoice_dt=?, customer=?, sales_order_no=?, company=?, " + "manual_inv_no=?, due_date=?, remarks=?,currency=?,ex_rate=?, amount=?,tc_amount=? where invoice_no=?";

	public static String UPDATE_GENERAL_INV_GIN_HDR = "update general_invoice_hdr set invoice_dt=?, customer=?, sales_order_no=?, company=?, " + "manual_inv_no=?, due_date=?, remarks=?,currency=?,ex_rate=?, amount=?,tc_amount=? where invoice_no=?";

	// public static String SAVE_GENERAL_LEDGER_HDR = " INSERT INTO
	// public.general_ledger(ledger_date, account_code, transaction_no, " + "
	// bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code,
	// exchange_rate,company_id, parent_code) " + " (select
	// invoice_dt,10050003,invoice_no,0.0 as bc_credit,amount as bc_debit,0.0 as
	// tc_credit,amount as tc_debit, " + " remarks,'INR' as currency ,1 as
	// exchange_rt ,company,'1005' as parent_code from general_invoice_hdr where
	// invoice_no=?)";

	public static String SAVE_GENERAL_LEDGER_HDR = " INSERT INTO public.general_ledger(ledger_date," + "" + " account_code, transaction_no, " + " bc_credit, bc_debit, " + "tc_credit," + " tc_debit, narration, currency_code, " + "exchange_rate,company_id, " + "parent_code," + "created_by,created_date,sub_account_code) " + " (select " + "invoice_dt,10040001," + "invoice_no,0.0 as bc_credit,amount as bc_debit,0.0 as tc_credit," + "amount as tc_debit, " + " remarks,'INR' as currency ," + "1 as exchange_rt ,company,'1005' as parent_code,"
			+ "created_by,created_dt,customer from general_invoice_hdr where invoice_no=?)";
	/*
	 * public static String SAVE_GENERAL_LEDGER_PRODUCT_DTL =
	 * " INSERT INTO public.general_ledger(ledger_date, account_code,transaction_no, bc_credit, bc_debit, tc_credit, "
	 * +
	 * " tc_debit, narration, currency_code, exchange_rate, company_id,parent_code,item_id,cost_center) "
	 * +
	 * " (select gih.invoice_dt,'30030002' as account_code,ipd.invoice_no,ipd.amount as bc_credit,"
	 * + " 0.0 as bc_debit,ipd.amount as tc_credit,0.0 as tc_debit, " +
	 * "  'Operational Income' as narration,'INR' as currency,  1.0 as exchange_rate,gih.company, "
	 * +
	 * "  '3003' as parent_code,ipd.item_id,ipd.cost_center  from general_invoice_prod_dtl ipd  "
	 * +
	 * " left join general_invoice_hdr gih on gih.invoice_no = ipd.invoice_no  where ipd.invoice_no=? )"
	 * ;
	 */

	public static String SAVE_GENERAL_LEDGER_PRODUCT_DTL = " INSERT INTO public.general_ledger(ledger_date, account_code,transaction_no, bc_credit, bc_debit, tc_credit, " + " tc_debit, narration, currency_code, exchange_rate, company_id,parent_code,item_id,cost_center,created_by,created_date) " + " (select gih.invoice_dt,'30030002' as account_code,ipd.invoice_no,ipd.amount as bc_credit," + " 0.0 as bc_debit,ipd.amount as tc_credit,0.0 as tc_debit, " + "  'Operational Income' as narration,'INR' as currency,  1.0 as exchange_rate,gih.company, "
			+ "  '3003' as parent_code,ipd.item_id,ipd.cost_center,gih.created_by,gih.created_dt  from general_invoice_prod_dtl ipd  " + " left join general_invoice_hdr gih on gih.invoice_no = ipd.invoice_no  where ipd.invoice_no=? )";
	/*
	 * public static String SAVE_GENERAL_LEDGER_CHARGE_DTL =
	 * " INSERT INTO public.general_ledger(ledger_date, account_code, " +
	 * " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, "
	 * + " exchange_rate, company_id,parent_code)" +
	 * " (select gih.invoice_dt,charge_code,gid.invoice_no,gid.amount as bc_credit,0.0 as bc_debit,gid.amount as tc_credit, "
	 * +
	 * " 0.0 as tc_debit,gid.sht_details,'INR' as currency,1.0 as exchange_rate,gih.company, "
	 * + " gid.subgroup_code from general_invoice_dtl gid " +
	 * " left join general_invoice_hdr gih on gih.invoice_no = gid.invoice_no "
	 * + " where gid.invoice_no =?)";
	 */

	public static String SAVE_GENERAL_LEDGER_CHARGE_DTL = " INSERT INTO public.general_ledger(ledger_date, " + "account_code, " + " transaction_no, bc_credit, bc_debit," + " tc_credit, tc_debit, narration, currency_code, " + "" + " exchange_rate, company_id,parent_code,created_by," + "created_date,sub_account_code)" + " " + "(select gih.invoice_dt," + "charge_code,gid.invoice_no,gid.amount as bc_credit,0.0 as bc_debit,gid.amount as tc_credit, " + " 0.0 as tc_debit,gid.sht_details,'INR' as currency,1.0 as exchange_rate,gih.company, "
			+ " gid.subgroup_code,gih.created_by,gih.created_dt,gih.customer from general_invoice_dtl gid " + " left join general_invoice_hdr gih on gih.invoice_no = gid.invoice_no " + " where gid.invoice_no =?)";
	public static String GET_SO_HDR = " select customer_acct_code as customer,company_code as company from sales_order left join entity e on  e.entity_id = customer_id " + " where sales_order_id =?";

	public static String GET_SO_DTL = " select item_id as itemId,quantity,tax_amount taxAmount,unit_price as unitprice from sales_order_detail where sales_order_id =? ";

	public static String GET_GIN_DTL = "select gin_id as id, gin_number as text from gin where gin_id not in (select distinct gin_id from general_invoice_hdr where gin_id is not null) ORDER BY gin_id DESC";

	public static String GET_GIN_ITEM_DTL = "select coalesce(sod.sales_order_dtl_id,0)" + " as soDtlId, gd.item_id as itemId,gd.quantity,gd.price as unitprice,coalesce(sod.tax_amount,0) " + "taxAmount,tax.tax_account_id taxAccountId, " + "coalesce(sales_tax,0) as taxId from gin_detail as gd " + "left join sales_order_detail as sod on sod.sales_order_dtl_id=gd.sales_order_detail_id " + "inner join item_new i on  i.item_Id=gd.item_id left join item_category_account ica on ica.item_category_id = i.item_category "
			+ "left join tax on tax.tax_id = ica.sales_tax where gin_id =?";

	public static String GET_GIN_HDR = "select e.customer_acct_code as customer, coalesce(e.customer_payment_terms,0) customerPaymentTerms, g.company_id as company from gin as g left join entity e on  e.entity_id = g.entity_id where gin_id =?";

	public static String SAVE_GENERAL_LEDGER_PRODUCT_TAX_DTL_ID = " INSERT INTO public.general_ledger(ledger_date, account_code, " + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + " exchange_rate, company_id,parent_code,item_id,cost_center) " + " VALUES(?, ?, ?, ?, ?, ?, ? ,? ,? ,?, ?, ?,?,?) ";

}
