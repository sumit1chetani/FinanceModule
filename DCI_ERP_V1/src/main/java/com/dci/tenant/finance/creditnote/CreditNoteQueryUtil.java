package com.dci.tenant.finance.creditnote;

public class CreditNoteQueryUtil {

	public static final String sGetAcctHeadDropDown = "select NAME,ACCT_HEAD_CODE, CURR, RATE, MLO_NAME from VIEW_TOLIST_PAYER_CNDN where rownum < 200  ORDER BY MLO_NAME DESC";

	public static final String sGetInvoiceNumber = "SELECT invoice_no id,invoice_no as text,entity_name as entityName,invoice_no as invoiceNo,to_char(inv.invoice_dt,'DD/MM/YYYY') invoiceDate,inv.company,com.company_name   FROM general_invoice_hdr inv    left join company_master com on com.company_code = inv.company left join currency on currency.crrncy_cd = inv.currency inner join customer_entity e on e.customer_acct_code = inv.customer "
			+ " where inv.customer=? "
			+ " "
			+ " "
			+ " "
			+ " "
			+ "union "
			+ "   			 SELECT cbdtl.voucher_no id,cbdtl.voucher_no as text,'' ,  cbdtl.voucher_no as invoiceNo  ,to_char(cbh.voucher_dt,'DD/MM/YYYY') invoiceDate , cbh.company_code ,com.company_name FROM cashbank_pay_dtl cbdtl  left join cashbank_pay_hdr cbh on cbh.voucher_no = cbdtl.voucher_no    left join company_master com on com.company_code = cbh.company_code "
			+ " 			 			  left join entity e on e.supplier_acct_code = sub_account_code "
			+ "			 		            left join customer_entity ce on ce.customer_acct_code = sub_account_code "
			+ "			 			  			  where sub_account_code =  ? "
			+ " 			 union "
			+ " 			 SELECT cbrdtl.voucher_no id,cbrdtl.voucher_no as text,'' ,cbrdtl.voucher_no as invoiceNo ,to_char(cbr.voucher_dt,'DD/MM/YYYY') invoiceDate , cbr.company_code ,com.company_name FROM cashbank_receipt_dtl cbrdtl  left join cashbank_receipt_hdr cbr on cbr.voucher_no = cbrdtl.voucher_no    left join company_master com on com.company_code = cbr.company_code "
			+ " 			 			  left join entity e on e.supplier_acct_code = sub_account_code "
			+ "			 		            left  join customer_entity ce on ce.customer_acct_code = sub_account_code "
			+ "			 			  			   where sub_account_code =  ?    ";
			//"SELECT invoice_no id,invoice_no as text,entity_name as entityName,invoice_no as invoiceNo,to_char(inv.invoice_dt,'DD/MM/YYYY') invoiceDate,inv.company,com.company_name,  COALESCE(inv.currency,'') as currencyCode,COALESCE(inv.ex_rate,0) as exgRate FROM general_invoice_hdr inv    left join company_master com on com.company_code = inv.company left join currency on currency.crrncy_cd = inv.currency inner join entity e on e.customer_acct_code = inv.customer  where inv.customer=? ORDER BY invoice_no desc";

	public static final String sGetCreditNoteList = 
			"SELECT  cnhdr.creditnote_no creditNoteCode, to_char(CREDITNOTE_DATE, 'dd/mm/yyyy') creditNoteDate, COALESCE(entsup.entity_name,'') || COALESCE(entcus.entity_name,'') accountName, CREDITNOTE_INVOICE_NO invoiceNo, approve_status approveStatus, cnhdr.company_code companyCode, comp.company_name company,  coalesce(SUM(cndtl.CREDITNOTE_AMOUNT),0)creditAmount,coalesce(SUM(cndtl.CREDITNOTE_AMOUNTUSD),0) creditAmountUSD FROM creditnote_temp_hdr cnhdr\r\n" + 
			"LEFT JOIN CREDITNOTE_TEMP_DTL cndtl on cndtl.CREDITNOTE_NO = cnhdr.CREDITNOTE_NO\r\n" + 
			"LEFT JOIN customer_ENTITY entcus on entcus.customer_acct_code=cndtl.sub_account_code   \r\n" + 
			"LEFT JOIN ENTITY entsup on entsup.supplier_acct_code=cndtl.sub_account_code \r\n" + 
			"LEFT JOIN company_master comp on comp.company_code = cnhdr.company_code INNER JOIN branch brn on brn.cmpny_id = comp.company_code INNER JOIN branch_department brndept on brndept.branch_id = brn.brnch_id::text INNER JOIN employee_master e on e.branch_department_id = brndept.branch_department_id  where e.company_code =  ? GROUP BY cnhdr.creditnote_no,to_char(CREDITNOTE_DATE, 'dd/mm/yyyy'),accountName,CREDITNOTE_INVOICE_NO,approve_status,cnhdr.company_code, comp.company_name, cnhdr.CREDITNOTE_DATE  ORDER BY cnhdr.creditnote_no desc";
			
			//"SELECT cnhdr.creditnote_no creditNoteCode, to_char(CREDITNOTE_DATE, 'dd/mm/yyyy') creditNoteDate, COALESCE(entsup.entity_name,'') || COALESCE(entcus.entity_name,'') accountName, CREDITNOTE_INVOICE_NO invoiceNo, approve_status approveStatus, cnhdr.company_code companyCode, comp.company_name company,  coalesce(SUM(cndtl.CREDITNOTE_AMOUNT),0)creditAmount,coalesce(SUM(cndtl.CREDITNOTE_AMOUNTUSD),0) creditAmountUSD FROM creditnote_temp_hdr cnhdr LEFT JOIN customer_ENTITY entcus on entcus.customer_acct_code=cnhdr.creditnote_account_head LEFT JOIN ENTITY entsup on entsup.supplier_acct_code=cnhdr.creditnote_account_head LEFT JOIN company_master comp on comp.company_code = cnhdr.company_code INNER JOIN branch brn on brn.cmpny_id = comp.company_code INNER JOIN branch_department brndept on brndept.branch_id = brn.brnch_id::text INNER JOIN employee_master e on e.branch_department_id = brndept.branch_department_id LEFT JOIN CREDITNOTE_TEMP_DTL cndtl on cndtl.CREDITNOTE_NO = cnhdr.CREDITNOTE_NO where e.company_code = ? GROUP BY cnhdr.creditnote_no,to_char(CREDITNOTE_DATE, 'dd/mm/yyyy'),accountName,CREDITNOTE_INVOICE_NO,approve_status,cnhdr.company_code, comp.company_name, cnhdr.CREDITNOTE_DATE  ORDER BY cnhdr.creditnote_no desc";

	public static final String autoGenCreditNoteNo = "SELECT CASE WHEN MAX(CREDITNOTE_NO) IS NULL " + "THEN ? ELSE rpad(MAX(CREDITNOTE_NO),5,'CN')||  " + "lpad(cast(cast((SUBSTRING(MAX(CREDITNOTE_NO),5)) as int)+1 " + "as text),4,'0') END AS CREDITNOTE_NO FROM CREDITNOTE_TEMP_HDR where CREDITNOTE_NO like ?";

	public static final String saveCreditNoteData = "Insert into creditnote_temp_hdr (creditnote_no,creditnote_date,creditnote_account_head, " + "creditnote_currency,creditnote_exchange_rate,creditnote_invoice_no,creditnote_narration," + "company_code,created_By,created_Date,approve_status,reverse_cn) " + " values (?,?,?,?,?,?,?,?,?,current_date,?,'N')";

	public static final String sGetLocationWithInvoiceNo = "select COMPANY_CODE,LOCATION from invoices_location where INVOICE_NO=?";

	public static final String saveCreditNoteDetailData = "insert into creditnote_temp_dtl (creditnote_no,creditnote_account_head,creditnote_amount, " + "creditnote_narration,creditnote_amountusd,CREDITNOTE_CURRENCY,CREDITNOTE_EXCHNAGE_RATE,CREDITNOTE_SLNO,SUB_ACCOUNT_CODE, " + "EMPLOYEE,LOCATION,CUSTOMER,SUPPLIER,DESIGNATION,COMPANY,COST_CENTER,DEPARTMENT,PATIENT,payment_receipt_dtl) " + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String saveCreditNoteMainHdrData = "INSERT INTO CREDITNOTE_HDR (CREDITNOTE_NO, CREDITNOTE_DATE, CREDITNOTE_ACCOUNT_HEAD, CREDITNOTE_CURRENCY, CREDITNOTE_EXCHANGE_RATE, " + "CREDITNOTE_INVOICE_NO,CREDITNOTE_NARRATION, CREATED_BY, CREATED_DATE,modified_by,modified_date,APPROVED_BY,APPROVED_DATE, COMPANY_CODE)  " + "SELECT CREDITNOTE_NO, CREDITNOTE_DATE, CREDITNOTE_ACCOUNT_HEAD, CREDITNOTE_CURRENCY, CREDITNOTE_EXCHANGE_RATE,  "
			+ "CREDITNOTE_INVOICE_NO,CREDITNOTE_NARRATION, created_by, created_date,modified_by,modified_date,?, current_date,COMPANY_CODE " + "FROM CREDITNOTE_TEMP_HDR WHERE CREDITNOTE_NO=?";

	public static final String saveCreditNoteMainDtlData = "INSERT INTO CREDITNOTE_DTL (CREDITNOTE_NO, CREDITNOTE_ACCOUNT_HEAD, CREDITNOTE_CURRENCY, " + "CREDITNOTE_EXCHNAGE_RATE, CREDITNOTE_AMOUNT, CREDITNOTE_NARRATION, CREDITNOTE_AMOUNTUSD, CREDITNOTE_SLNO,SUB_ACCOUNT_CODE, " + "employee, location, customer,supplier, designation, company,cost_center,department,patient,payment_receipt_dtl)  " + "SELECT CREDITNOTE_NO, CREDITNOTE_ACCOUNT_HEAD, CREDITNOTE_CURRENCY, CREDITNOTE_EXCHNAGE_RATE, CREDITNOTE_AMOUNT, CREDITNOTE_NARRATION, "
			+ "CREDITNOTE_AMOUNTUSD, CREDITNOTE_SLNO,SUB_ACCOUNT_CODE,employee, location, customer,supplier, designation, company,cost_center,department,patient ,payment_receipt_dtl  FROM creditnote_temp_DTL WHERE CREDITNOTE_NO=?";

	public static final String updateStatusCreditNoteTempHdrData = "UPDATE CREDITNOTE_TEMP_HDR set APPROVE_STATUS=?,APPROVED_BY=?, APPROVED_DATE=current_date where CREDITNOTE_NO=? ";

	public static final String insertcnApp = "insert into CREDITNOTE_APPROVED(CR_NOTE_APPRV_NUMBER,CREDITNOTE_NO," + " CREDITNOTE_DT,CUSTOMER,INVOICE_NUMBERS,LOCATION,AMOUNT_USD,CREATED_BY,CREATED_DATE)values(?,?,to_date(?,'dd-mm-yyyy'),?,?,?,?,?,sysdate)";

	public static final String GET_CREDIT_HDR_EDIT = "select cnhdr.creditnote_no as creditNoteCode,TO_CHAR(creditnote_DATE,'DD/MM/YYYY') as creditNoteDate, COALESCE(entsup.supplier_acct_code,'') || COALESCE(entcus.customer_acct_code,'') as accountName, "
			+ "			    creditnote_invoice_no as invoiceNo, (select to_char(invoice_dt,'DD/MM/YYYY')  FROM purchase_invoice_hdr where invoice_no = creditnote_invoice_no limit 1) as invoiceDate, cnhdr.creditnote_narration as narration, cnhdr.company_code as companyCode, company.company_name as company,approve_status approveStatus "
			+ "			   from creditnote_temp_hdr cnhdr "
			+ "			   LEFT JOIN CREDITNOTE_TEMP_DTL cndtl on cndtl.CREDITNOTE_NO = cnhdr.CREDITNOTE_NO "
			+ "LEFT JOIN customer_ENTITY entcus on entcus.customer_acct_code=cndtl.sub_account_code "
			+ "LEFT JOIN ENTITY entsup on entsup.supplier_acct_code=cndtl.sub_account_code "
			+ " "
			+ "			   left join company on company.company_id = cnhdr.company_code left join general_invoice_hdr gih on gih.invoice_no = cnhdr.creditnote_invoice_no where cnhdr.creditnote_no= ?";
			
/*			"select creditnote_no as creditNoteCode,TO_CHAR(creditnote_DATE,'DD/MM/YYYY') as creditNoteDate, creditnote_account_head as accountName, "
			+ " creditnote_invoice_no as invoiceNo, (select to_char(invoice_dt,'DD/MM/YYYY')  FROM purchase_invoice_hdr where invoice_no = creditnote_invoice_no limit 1) as invoiceDate, creditnote_narration as narration, cnhdr.company_code as companyCode, company.company_name as company,approve_status approveStatus "
			+ "from creditnote_temp_hdr cnhdr left join company on company.company_id = cnhdr.company_code left join general_invoice_hdr gih on gih.invoice_no = cnhdr.creditnote_invoice_no where creditnote_no=?";
*/
	public static final String GET_CREDIT_DTL_EDIT = "select CREDITNOTE_ACCOUNT_HEAD as crdtlAccountHead,   payment_receipt_dtl as  cbpdtlpaymentreceipt ,CREDITNOTE_AMOUNT as bcamount,CREDITNOTE_NARRATION as narration, CREDITNOTE_AMOUNTUSD as tcamount, " + "CREDITNOTE_SLNO as slNo,SUB_ACCOUNT_CODE as subAcctCode,EMPLOYEE as employeeCode,  " + "LOCATION as countryCode,CUSTOMER as customerCode,SUPPLIER as supplierCode, DESIGNATION as designationCode,COMPANY as companyCode,COST_CENTER as costCenter, " + "DEPARTMENT as departmentCode FROM CREDITNOTE_TEMP_DTL WHERE CREDITNOTE_NO=?";

	public static final String UPDATE_CREDIT_HDR = "update creditnote_temp_hdr set creditnote_date =?,creditnote_account_head =?,creditnote_currency =?,creditnote_exchange_rate =?,creditnote_invoice_no =?,creditnote_narration =?,company_code =?,MODIFIED_BY=?,MODIFIED_DATE=current_date where creditnote_no =?";

	public static final String sDeleteCreditNoteDtl = "delete from creditnote_temp_dtl where CREDITNOTE_NO =?";

	public static final String sDeleteCreditNote = "delete from creditnote_temp_hdr where CREDITNOTE_NO =?";

	public static final String INSERT_GENERAL_LEDGER_CREDIT_ENTRY_CREDITNOTE = "INSERT INTO general_ledger (ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, " + "currency_code, exchange_rate, company_id, status, financial_year_id, acct_Balance, parent_code, cost_center,item_id,created_date,created_by) " + "select creditnote_date, cnhdr.creditnote_account_head, cnhdr.creditnote_no, sum(cndtl.creditnote_amount) creditnote_amount, 0, "
			+ "sum(cndtl.creditnote_amount)  creditnote_amount,0,cnhdr.creditnote_narration, cnhdr.creditnote_currency, " + "cnhdr.creditnote_exchange_rate,cnhdr.company_code, approve_status, null,null,CASE WHEN substr(cnhdr.creditnote_account_head,0,2)='C' THEN ? ELSE ? END, null,null,now(),cnhdr.created_by " + "from creditnote_temp_hdr as cnhdr inner join creditnote_temp_dtl as cndtl on cndtl.creditnote_no = cnhdr.creditnote_no " + "where cnhdr.creditnote_no=? group by cnhdr.creditnote_no,creditnote_date,cnhdr.creditnote_account_head,cnhdr.creditnote_narration, "
			+ "cnhdr.creditnote_currency, cnhdr.creditnote_exchange_rate,cnhdr.company_code,approve_status,cnhdr.created_by";

	public static final String INSERT_GENERAL_LEDGER_DEBIT_ENTRY_CREDITNOTE = "INSERT INTO general_ledger (ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, " + "currency_code, exchange_rate, company_id, status, financial_year_id, acct_Balance, parent_code, cost_center,item_id,created_date,created_by) " + "select cnhdr.creditnote_date, cndtl.creditnote_account_head, cnhdr.creditnote_no, 0,cndtl.creditnote_amount,0,cndtl.creditnote_amount, "
			+ "cndtl.creditnote_narration,cndtl.creditnote_currency,cndtl.creditnote_exchnage_rate, cnhdr.company_code,null,null,null, " + "substr(cndtl.creditnote_account_head,0,5), null,null,now(),cnhdr.created_by " + "from creditnote_temp_dtl cndtl " + "inner join creditnote_temp_hdr cnhdr on cnhdr.creditnote_no = cndtl.creditnote_no " + "where cnhdr.creditnote_no=?";

	public static final String sGetPurchaseInvoiceNumber =  "SELECT invoice_no id,invoice_no as text,invoice_no as invoiceNo,entity_name as entityName,to_char(pinv.invoice_dt,'DD/MM/YYYY') invoiceDate,pinv.company_code,com.company_name FROM purchase_invoice_hdr pinv  left join company_master com on com.company_code = pinv.company_code "
			+ "			   left join currency on currency.crrncy_cd = pinv.currency inner join entity e on e.supplier_acct_code = pinv.supplier "
			+ "			   where pinv.supplier= ? "
			+ "union "
			+ " "
			+ " "
			+ " "
			+ "SELECT cbdtl.voucher_no id,cbdtl.voucher_no as text,'' ,  cbdtl.voucher_no as invoiceNo ,to_char(cbh.voucher_dt,'DD/MM/YYYY') invoiceDate , cbh.company_code ,com.company_name FROM cashbank_pay_dtl cbdtl  left join cashbank_pay_hdr cbh on cbh.voucher_no = cbdtl.voucher_no    left join company_master com on com.company_code = cbh.company_code "
			+ " "
			+ "			  left join entity e on e.supplier_acct_code = sub_account_code "
			+ "		            left join customer_entity ce on ce.customer_acct_code = sub_account_code "
			+ "			  			   where sub_account_code =  ? "
			+ " "
			+ "union "
			+ " "
			+ "SELECT cbrdtl.voucher_no id,cbrdtl.voucher_no as text,'' ,cbrdtl.voucher_no as invoiceNo,to_char(cbr.voucher_dt,'DD/MM/YYYY') invoiceDate , cbr.company_code ,com.company_name FROM cashbank_receipt_dtl cbrdtl  left join cashbank_receipt_hdr cbr on cbr.voucher_no = cbrdtl.voucher_no    left join company_master com on com.company_code = cbr.company_code "
			+ " "
			+ "			  left join entity e on e.supplier_acct_code = sub_account_code "
			+ "		            left  join customer_entity ce on ce.customer_acct_code = sub_account_code "
			+ "			  			   where sub_account_code =  ?   ";
			
			/*"SELECT invoice_no id,invoice_no as text,invoice_no as invoiceNo,entity_name as entityName,to_char(pinv.invoice_dt,'DD/MM/YYYY') invoiceDate,pinv.company_code,com.company_name, " + "COALESCE(pinv.currency,'') as currencyCode,COALESCE(pinv.ex_rate,0) as exgRate FROM purchase_invoice_hdr pinv  left join company com on com.company_id = pinv.company_code "
			+ "left join currency on currency.crrncy_cd = pinv.currency inner join entity e on e.supplier_acct_code = pinv.supplier  where pinv.supplier=? ORDER BY invoice_no desc";
*/
	public static String GET_REVERSE_LIST_FOR_AGENTS = " select id,text,t.company_code from (select cn.CREDITNOTE_NO as id,cn.CREDITNOTE_NO as text,c.company_id company_code from creditnote_temp_hdr cn  LEFT JOIN company c ON c.company_id=cn.COMPANY_CODE order by cn.CREDITNOTE_NO desc) t";
	public static String GET_REVERSE_LIST = "select creditnote_no as id,creditnote_no as text from creditnote_temp_hdr";
	public static final String GET_PAYMENT_STATUS = "select COALESCE(REVERSE_CN,'N') as reverseCN from creditnote_temp_hdr WHERE creditnote_no =?";
	public static final String UPDATE_JV_HDR_STATUS = "UPDATE creditnote_temp_hdr SET REVERSE_CN =? WHERE creditnote_no=?";

	public static final String REVERSE_CN = "select * from cn_reverse(?,?,?,?)";
}
