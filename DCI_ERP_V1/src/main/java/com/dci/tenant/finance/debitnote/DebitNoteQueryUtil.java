package com.dci.tenant.finance.debitnote;

public class DebitNoteQueryUtil {

	public static String saveDebitNoteData = "Insert into debitnote_hdr (debitnote_no,debitnote_date,debitnote_account_head,debitnote_currency,debitnote_exchange_rate,debitnote_invoice_no,debitnote_narration, company_code,created_by,created_date) values (?,?,?,?,?,?,?,?,?,current_date)";

	public static final String saveDebitNoteDetailData = "insert into debitnote_dtl (debitnote_no,debitnote_account_head,debitnote_amount, debitnote_narration,debitnote_amountusd, " + "debitnote_currency,debitnote_exchange_rate, debitnote_slno,SUB_ACCOUNT_CODE, " + "EMPLOYEE,LOCATION,CUSTOMER,SUPPLIER,DESIGNATION,COMPANY,COST_CENTER,DEPARTMENT,PATIENT,payment_receipt_dtl) " + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static String sDeleteDebitNote = "delete from DEBITNOTE_hdr where debitnote_no=?";

	public static String sDeleteDebitNoteDtl = "delete from DEBITNOTE_dtl where debitnote_no=?";

	public static String sGetDebitNoteDatas = "SELECT dnhdr.debitnote_no debitNoteNo, to_char(debitnote_date, 'dd/mm/yyyy') debitNoteDate, COALESCE(custent.entity_name,'') || COALESCE(supent.entity_name,'') as acctName, DEBITNOTE_INVOICE_NO invoiceNo, dnhdr.company_code companyCode, comp.company_name company,COALESCE(SUM(dndtl.DEBITNOTE_AMOUNT),0) amount,COALESCE(SUM(dndtl.DEBITNOTE_AMOUNTUSD),0) amountUSD FROM debitnote_hdr dnhdr  LEFT JOIN DEBITNOTE_DTL dndtl on dndtl.debitnote_no = dnhdr.debitnote_no  LEFT JOIN customer_ENTITY custent on custent.customer_acct_code=dndtl.sub_account_code LEFT JOIN ENTITY supent on supent.supplier_acct_code=dndtl.sub_account_code LEFT JOIN company_master comp on comp.company_code = dnhdr.company_code INNER JOIN branch brn on brn.cmpny_id = comp.company_code INNER JOIN branch_department brndept on brndept.branch_id = brn.brnch_id::text INNER JOIN employee_master e on e.branch_department_id = brndept.branch_department_id  where e.company_code = ? GROUP BY dnhdr.debitnote_no,to_char(debitnote_date, 'dd/mm/yyyy'),acctName, DEBITNOTE_INVOICE_NO,dnhdr.company_code,comp.company_name, dnhdr.debitnote_date ORDER BY dnhdr.debitnote_no DESC";
			//"SELECT dnhdr.debitnote_no debitNoteNo, to_char(debitnote_date, 'dd/mm/yyyy') debitNoteDate, COALESCE(custent.entity_name,'') || COALESCE(supent.entity_name,'') as acctName, DEBITNOTE_INVOICE_NO invoiceNo, dnhdr.company_code companyCode, comp.company_name company,COALESCE(SUM(dndtl.DEBITNOTE_AMOUNT),0) amount,COALESCE(SUM(dndtl.DEBITNOTE_AMOUNTUSD),0) amountUSD FROM debitnote_hdr dnhdr LEFT JOIN ENTITY custent on custent.customer_acct_code=dnhdr.debitnote_account_head LEFT JOIN ENTITY supent on supent.supplier_acct_code=dnhdr.debitnote_account_head  LEFT JOIN company comp on comp.company_id = dnhdr.company_code  inner join branch brn on brn.company_id = comp.company_id inner join branch_department brndept on brndept.branch_id = brn.branch_id inner join employee e on e.branch_department_id = brndept.branch_department_id LEFT JOIN DEBITNOTE_DTL dndtl on dndtl.debitnote_no = dnhdr.debitnote_no  where e.retailer_id = ? GROUP BY dnhdr.debitnote_no,to_char(debitnote_date, 'dd/mm/yyyy'),acctName, DEBITNOTE_INVOICE_NO,dnhdr.company_code,comp.company_name, dnhdr.debitnote_date ORDER BY dnhdr.debitnote_no DESC";

	public static String sGetDebitNoteCode = "select distinct debitnote_no as id , debitnote_no as text from debitnote_hdr order by debitnote_no desc  ";

	public static String UPDATE_DEBIT_HDR_STATUS = "UPDATE debitnote_hdr SET REVERSE_DN=? WHERE debitnote_no = ?";

	public static String REVERSE_DEBIT_NOTE = "select * from debit_note_reverse(?,?,?,?) limit 1";

	public static final String autoGenDebitNoteNo = "SELECT CASE WHEN MAX(DEBITNOTE_NO) IS NULL THEN ? ELSE rpad(MAX(DEBITNOTE_NO),5,'DN')|| " + "lpad(cast(cast((SUBSTRING(MAX(DEBITNOTE_NO),5)) as int)+1 as text),4,'0') END AS DEBITNOTE_NO  " + "FROM DEBITNOTE_HDR where DEBITNOTE_NO like ?";

	public static final String sGetLocationWithInvoiceNo = "select COMPANY_CODE,LOCATION from invoices_location where INVOICE_NO=?";

	public static final String GET_DEBIT_HDR_EDIT = "select dnhdr.debitnote_no debitNoteNo, to_char(debitnote_date, 'dd/mm/yyyy') debitNoteDate,COALESCE(entsup.supplier_acct_code,'') || COALESCE(entcus.customer_acct_code,'') as  acctHeadName,dnhdr.debitnote_currency currencyCode, dnhdr.debitnote_exchange_rate exchangeRate, dnhdr.debitnote_invoice_no invoiceNo, dnhdr.debitnote_narration narration, dnhdr.company_code companyCode, company.company_name company,  COALESCE(to_char(gih.invoice_dt, 'dd/mm/yyyy'),'') || COALESCE(to_char(pih.invoice_dt, 'dd/mm/yyyy'),'') invoiceDate from DEBITNOTE_hdr dnhdr     LEFT JOIN debitnote_dtl cndtl on cndtl.debitnote_no = dnhdr.debitnote_no "
			+ "LEFT JOIN customer_ENTITY entcus on entcus.customer_acct_code=cndtl.sub_account_code "
			+ "LEFT JOIN ENTITY entsup on entsup.supplier_acct_code=cndtl.sub_account_code     left join company on company.company_id = dnhdr.company_code left join general_invoice_hdr gih on gih.invoice_no = dnhdr.debitnote_invoice_no left join purchase_invoice_hdr pih on pih.invoice_no = dnhdr.debitnote_invoice_no where dnhdr.debitnote_no = ?";
			
			/*"select dnhdr.debitnote_no debitNoteNo, to_char(debitnote_date, 'dd/mm/yyyy') debitNoteDate,COALESCE(entsup.entity_name,'') || COALESCE(entcus.entity_name,'') as  acctHeadName,debitnote_currency currencyCode, debitnote_exchange_rate exchangeRate, debitnote_invoice_no invoiceNo, dnhdr.debitnote_narration narration, dnhdr.company_code companyCode, "
			+ "company.company_name company,  COALESCE(to_char(gih.invoice_dt, 'dd/mm/yyyy'),'') || COALESCE(to_char(pih.invoice_dt, 'dd/mm/yyyy'),'') invoiceDate from DEBITNOTE_hdr dnhdr     LEFT JOIN creditnote_dtl cndtl on cndtl.CREDITNOTE_NO = cnhdr.CREDITNOTE_NO\r\n" + 
			"LEFT JOIN customer_ENTITY entcus on entcus.customer_acct_code=cndtl.sub_account_code   \r\n" + 
			"LEFT JOIN ENTITY entsup on entsup.supplier_acct_code=cndtl.sub_account_code     left join company on company.company_id = dnhdr.company_code " + "left join general_invoice_hdr gih on gih.invoice_no = dnhdr.debitnote_invoice_no left join purchase_invoice_hdr pih on pih.invoice_no = dnhdr.debitnote_invoice_no where dnhdr.debitnote_no = ?";*/

	public static final String GET_DEBIT_DTL_EDIT = "select DEBITNOTE_ACCOUNT_HEAD drdtlAccountHead, payment_receipt_dtl as cbpdtlpaymentreceipt ,DEBITNOTE_AMOUNT amount, DEBITNOTE_NARRATION dtlNarration, DEBITNOTE_AMOUNTUSD amountUSD, SUB_ACCOUNT_CODE subAcctCode, " + "EMPLOYEE as employeeCode, LOCATION as countryCode,CUSTOMER as customerCode,SUPPLIER as supplierCode, DESIGNATION as designationCode, " + "COMPANY as companyCode,COST_CENTER as costCenter, DEPARTMENT as departmentCode " + "from DEBITNOTE_DTL where DEBITNOTE_NO = ?";

	public static final String UPDATE_DEBIT_HDR = "update debitnote_hdr set debitnote_date=?,debitnote_account_head=?,debitnote_currency=?,debitnote_exchange_rate=?,debitnote_invoice_no=?,debitnote_narration=?, company_code=?,modified_by=?,modified_date=current_date where debitnote_no =?";

	public static final String UPDATE_DEBIT_DTL = "update debitnote_dtl set debitnote_account_head=?, SUB_ACCOUNT_CODE=?, debitnote_narration=?,debitnote_amount=?,debitnote_amountusd=?,debitnote_currency=?,debitnote_exchange_rate=? where debitnote_no=?";

	public static final String CHECK_GL_DEBIT_HDR = "select count(ledger_no) cnt from general_ledger GL where GL.PARTICULARS = ? and GL.ACCOUNT_HEAD = ? and GL.SUB_GROUP_CODE=? and  LEDGER_DT =to_date(?,'DD-MM-YY')";

	public static final String INSERT_GENERAL_LEDGER_DEBIT_ENTRY_DEBITNOTE = "INSERT INTO general_ledger (ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration," + "currency_code, exchange_rate, company_id, status, financial_year_id, acct_Balance, parent_code, cost_center,item_id,created_by, created_date) " + "select debitnote_date, dnhdr.debitnote_account_head, dnhdr.debitnote_no, 0, sum(dndtl.debitnote_amount) debitnote_amount,"
			+ "0,sum(dndtl.debitnote_amount)  debitnote_amount,dnhdr.debitnote_narration, dnhdr.debitnote_currency," + "dnhdr.debitnote_exchange_rate,dnhdr.company_code, null, null,null,CASE WHEN substr(dnhdr.debitnote_account_head,0,2)='C' THEN ? ELSE ? END,null,null,?,now() " + "from debitnote_hdr as dnhdr inner join debitnote_dtl as dndtl on dndtl.debitnote_no = dnhdr.debitnote_no " + "where dnhdr.debitnote_no=? group by dnhdr.debitnote_no,debitnote_date,dnhdr.debitnote_account_head,dnhdr.debitnote_narration,"
			+ "dnhdr.debitnote_currency, dnhdr.debitnote_exchange_rate,dnhdr.company_code";

	public static final String INSERT_GENERAL_LEDGER_CREDIT_ENTRY_DEBITNOTE = "INSERT INTO general_ledger (ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + "exchange_rate, company_id, status, financial_year_id, acct_Balance, parent_code, cost_center,item_id,created_by, created_date)  " + "select dnhdr.debitnote_date, dndtl.debitnote_account_head, dnhdr.debitnote_no, dndtl.debitnote_amount,0,dndtl.debitnote_amount,0, "
			+ "dndtl.debitnote_narration,dndtl.debitnote_currency,dndtl.debitnote_exchange_rate, dnhdr.company_code,null,null,null, " + "substr(dndtl.debitnote_account_head,0,5), null,null,?,now()  from debitnote_dtl dndtl " + "inner join debitnote_hdr dnhdr on dnhdr.debitnote_no = dndtl.debitnote_no where dnhdr.debitnote_no=?";

	public static final String DELETE_GENERAL_LEDGER = "delete from general_ledger where transaction_no=?";

	public static final String GET_DEBITNOTE_STATUS = "select COALESCE(reverse_dn,'N') as reverseDN from debitnote_hdr WHERE debitnote_no =?";

}
