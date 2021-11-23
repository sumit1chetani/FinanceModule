package com.dci.tenant.finance.cashbankreceipt;

public class CashBankReceiptQueryUtil {

	public static final String bankAccountDub = "select Acct_Head_Code as id,Acct_Head_Name as text from ACCOUNT_HEAD_MASTER  where SUBGROUP_ACCT_CODE=? ";

	// modified query
	/*public static final String cashAccountDub = 			"	select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName,'INR' as currencyCode, 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.crrncy_cd = ahm.acct_currency  where ahm.Acct_Head_Code in('10000026','10000051','10050001') ORDER BY ACCT_HEAD_NAME ASC";*/
	public static final String cashAccountDub = 			"	select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName,'INR' as currencyCode, 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.crrncy_cd = ahm.acct_currency  where ahm.Acct_Head_Code in('10020001') ORDER BY ACCT_HEAD_NAME ASC";

			//"	select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName,'INR' as currencyCode, 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.crrncy_cd = ahm.acct_currency  where ahm.Acct_Head_Code in('10000026','10000051') and  subgroup_acct_code = ? ORDER BY ACCT_HEAD_NAME ASC";

	public static final String bankAccountSNG = "select ACCT_HEAD_CODE,ACCT_HEAD_NAME from " + "ACCOUNT_HEAD_MASTER where SUBGROUP_ACCT_CODE = 'A0206' " + "OR ACCT_HEAD_CODE = 'A020306'";

	public static final String bankAccountMA = "select ACCT_HEAD_CODE,ACCT_HEAD_NAME from " + "ACCOUNT_HEAD_MASTER where SUBGROUP_ACCT_CODE = 'A0207' " + "OR ACCT_HEAD_CODE = 'A020306'";

	public static final String bankAccountMUM = "select Acct_Head_Code,Acct_Head_Name from ACCOUNT_HEAD_MASTER" + " where SUBGROUP_ACCT_CODE like 'A0204%'";

	public static final String cashAccountSNG = "select ACCT_HEAD_CODE,ACCT_HEAD_NAME from" + " ACCOUNT_HEAD_MASTER where SUBGROUP_ACCT_CODE = 'A0210'";

	public static final String cashAccountMA = "select ACCT_HEAD_CODE,ACCT_HEAD_NAME from" + " ACCOUNT_HEAD_MASTER where SUBGROUP_ACCT_CODE = 'A0211'";

	public static final String cashAccountMUM = "select Acct_Head_Code,Acct_Head_Name from ACCOUNT_HEAD_MASTER " + "where SUBGROUP_ACCT_CODE like 'A0209%'";

	public static final String onSelectAc = "select trim('INR') as acctCurrency, cast(1.0 as double precision) as exchangeRate from ACCOUNT_HEAD_MASTER  left join currency on currency.crrncy_cd = ACCOUNT_HEAD_MASTER.acct_currency where acct_Head_code=? ";

			//+ "select trim('INR') as acctCurrency, cast(1.0 as double precision) as exchangeRate from ACCOUNT_HEAD_MASTER " + "left join currency on currency.currency_code = ACCOUNT_HEAD_MASTER.acct_currency where acct_Head_code=? ";

	public static final String sGetLocation = "select location from company_master where company_code =?";

	public static final String SAVE_CASHBANK_RECEIPT_HDR = "insert into CASHBANK_RECEIPT_HDR (VOUCHER_NO," + " VOUCHER_DT,Receipt_TYPE,BANK_ACCT,EXCHANGE_RATE,narration,created_by,created_dt,CHEQUE_NO,AMT_LOCAL,AMT_USD,received_from,CHEQUE_DT,COMPANY_CODE,COST_CENTER,receipt_from,approval_note) " + " values(?,?,?,?,?,?,?,current_date,?,?,?,?,?,?,?,?,?)";

	public static final String SAVE_CASHBANK_RECEIPT_DTL = "insert into cashbank_receipt_dtl (VOUCHER_NO,ACCT_HEAD,SHORT_DTL,CHEQUE_NO," + "CHEQUE_DT,CURRENCY,CONVERSION_RATE,AMT_LOCAL,AMT_USD, " + "DEPT_CODE,SUB_GROUP_CODE,SL_NO,SUB_ACCOUNT_CODE," + "EMPLOYEE,LOCATION, CUSTOMER,SUPPLIER,DESIGNATION,COMPANY,COST_CENTER,PATIENT,receipt_dtl) " + "values (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?) returning cashbankreceipt_dtl_id";

	public static final String pendingPaymentPopUpSIN = "select invoice_no,curr,rate,amttotal,total,balance,balance_usd from" + " vpending_invoices_link_tab where acct_head_code=? " + "order by invoice_dt";

	public static final String subGroupB = "select sub_group_acct_code,sub_group_acct_name " + "from SUB_GROUP_ACCT_MASTER ";

	public static final String GET_CASHBANK_RCPT_HDR_LIST = "select  company_code,(select company_name from company_master where company_code = company_code limit 1) as companyName,c.VOUCHER_NO voucherNo, c.VOUCHER_NO as id, c.VOUCHER_NO as text, to_char(c.VOUCHER_DT,'dd/mm/yyyy') as cbReceiptDate, c.COST_CENTER as costCenter, ahm.acct_head_name accountName,c.approved_by approvedBy, c.amt_local bcAmountHdr,c.amt_usd tcAmountHdr,c.reverse_br referenceNo,(select string_agg(en.entity_name,',') from cashbank_receipt_dtl cbrd left join entity en on en.supplier_acct_code=cbrd.sub_account_code where cbrd.voucher_no = c.voucher_no and cbrd.sub_account_code!='') as subaccountname from CASHBANK_RECEIPT_HDR c left join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=c.BANK_ACCT order by c.VOUCHER_NO desc";
	// public static final String GET_CASHBANK_RCPT_HDR_LIST =
	// "select c.voucher_no as voucherNo,to_char(VOUCHER_DT,'dd/mm/yyyy') as
	// cbReceiptDate,bank_acct as bankAcc,c.amt_local as bcAmountHdr,c.amt_usd as
	// tcAmountHdr, "
	// +
	// "company_code as companyCode,ahm.acct_head_name accountName from
	// cashbank_receipt_hdr c "
	// + "left join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=c.bank_acct ";
	public static final String DELETE_CASHBANK_RCPT_DTL = "DELETE FROM CASHBANK_RECEIPT_DTL WHERE VOUCHER_NO=?";

	public static final String DELETE_CASHBANK_RCPT_HDR = "DELETE FROM CASHBANK_RECEIPT_HDR  WHERE VOUCHER_NO=?";

	public static final String GET_RECEIPT_VOUCHER_HDR = "select VOUCHER_NO as cbReceiptNo,VOUCHER_NO as voucherNo1, approval_note as approvenote ,   to_char(VOUCHER_DT,'dd/mm/yyyy') as cbReceiptDate, " + "RECEIPT_TYPE as paymentMode, BANK_ACCT as accountName,EXCHANGE_RATE as exchangeRate,CHEQUE_NO as chequeNO,  " + "to_char(CHEQUE_DT,'dd/mm/yyyy') as chequeDate,AMT_LOCAL as bcAmountHdr,AMT_USD as tcAmountHdr,NARRATION as narration, " + "cbr.COMPANY_CODE as companyCode, comp.company_name compLocationName, RECEIVED_FROM as receivedFrom,COST_CENTER as costCenter,receipt_from as receiptfrom  "
			+ "from CASHBANK_RECEIPT_HDR cbr " + "LEFT JOIN COMPANY_master comp on comp.company_code = cbr.company_code " + "where VOUCHER_NO= ? order by VOUCHER_NO";

	public static final String GET_RECEIPT_VOUCHER_DTL = "SELECT cashbankreceipt_dtl_id cashBankRcptDtlId,receipt_dtl as receipt, ACCT_HEAD as acctName,SHORT_DTL as genInvoiceNo,CURRENCY as currency,CONVERSION_RATE as exgRate,AMT_LOCAL as bcamount, AMT_USD as tcamount,DEPT_CODE as departmentCode, SUB_GROUP_CODE as subgroupcode,SL_NO as siNo,SUB_ACCOUNT_CODE as subAccountCode, EMPLOYEE as employeeCode,  LOCATION as countryCode,CUSTOMER as customerCode,SUPPLIER as supplierCode, e.DESIGNATION as designationCode,\r\n" + 
			"			COMPANY as companyCode,COST_CENTER as costCenter, COALESCE(patient,0) patientCode,e.first_name as employeeName\r\n" + 
			"			 FROM CASHBANK_RECEIPT_DTL \r\n" + 
			"			left join employee_master e on e.emp_id=EMPLOYEE\r\n" + 
			"			--left join sc_student_info s on s.student_id=DEPT_CODE\r\n" + 
			"			WHERE VOUCHER_NO = ? order by SL_NO ASC";
			
			/*"SELECT cashbankreceipt_dtl_id cashBankRcptDtlId, ACCT_HEAD as acctName,SHORT_DTL as genInvoiceNo,CURRENCY as currency,CONVERSION_RATE as exgRate,AMT_LOCAL as bcamount, AMT_USD as tcamount,DEPT_CODE as departmentCode, SUB_GROUP_CODE as subgroupcode,SL_NO as siNo,SUB_ACCOUNT_CODE as subAccountCode, EMPLOYEE as employeeCode,  LOCATION as countryCode,CUSTOMER as customerCode,SUPPLIER as supplierCode, DESIGNATION as designationCode,\n"
			+ "			COMPANY as companyCode,COST_CENTER as costCenter, COALESCE(patient,0) patientCode,e.first_name as employeeName,\n" + "			s.child_name as studentName FROM CASHBANK_RECEIPT_DTL \n" + "			left join employee e on e.employee_id=EMPLOYEE\n" + "			left join sc_student_info s on s.student_id=DEPT_CODE\n" + "			WHERE VOUCHER_NO = ? order by SL_NO ASC";*/
	public static final String UPDATE_CBRECEIPT_HDR = " UPDATE CASHBANK_RECEIPT_HDR SET VOUCHER_DT =?,RECEIPT_TYPE =?,BANK_ACCT=?,EXCHANGE_RATE=?, " + " CHEQUE_NO =?,CHEQUE_DT=?,AMT_LOCAL=?,AMT_USD=?,NARRATION=?,COMPANY_CODE=?,cost_center=?,RECEIVED_FROM=?, " +  " receipt_from = ?,MODIFIED_BY=?,MODIFIED_DT=current_date where VOUCHER_NO =?";

	public static final String GET_COMPANY_LIST_WITH_USER = "select company_code companyCode, company_name companyName, location compLocationName from company_master where company_code in " + "(select company_code from COMPANY_USER where USER_ID = ? AND IS_PRIMARY = 1) order by company_code ";

	public static final String AUTOGEN_RECEIPT_VOUCHER_NO = "SELECT CASE WHEN MAX(VOUCHER_NO) IS NULL  THEN  ?  ELSE rpad(MAX (VOUCHER_NO),5,?)|| " + " lpad(cast(cast((SUBSTRING(MAX(VOUCHER_NO),5)) as int)+1 as text),4,'0')  END AS VOUCHER_NO FROM CASHBANK_RECEIPT_HDR where VOUCHER_NO like ? ";

	public static final String GET_RECEIVED_FROM_LIST = "select customer_acct_code as id,entity_name as text from entity where is_customer='t' order by entity_name asc";

	public static final String GET_PENDING_INVOICE_DETAILS = "select COALESCE(invoice_no,'') as gInvoiceNo, COALESCE(inv_bc_amt,0) bcInvAmt, COALESCE(inv_tc_amt,0) tcInvAmt, COALESCE(currency_code,'') currency, " + "COALESCE(exchange_rate,0) exchangeRate, COALESCE(paid_amt_bc,0) bcPaidAmt, COALESCE(paid_amt_tc,0) tcPaidAmt,COALESCE(bc_balance_amt,0) bcBalanceAmt, " + "COALESCE(tc_balance_amt,0) tcBalanceAmt from (select aaa.invoice_no, aaa.inv_bc_amt,aaa.inv_tc_amt, aaa.currency_code, aaa.exchange_rate, "
			+ "aaa.paid_amt_bc, aaa.paid_amt_tc, (aaa.inv_bc_amt-aaa.paid_amt_bc) bc_balance_amt, (aaa.inv_tc_amt-aaa.paid_amt_tc) tc_balance_amt " + "from (select invoice_no, inv_bc_amt,inv_tc_amt,currency_code, exchange_rate,sum(paid_bc_amount) paid_amt_bc, " + "sum(paid_tc_amount) paid_amt_tc from cashbank_receipt_invoice group by invoice_no,inv_bc_amt,inv_tc_amt,currency_code,exchange_rate) aaa " + "where aaa.invoice_no in (select invoice_no from general_invoice_hdr where customer=? "
			+ "union select creditnote_no from creditnote_hdr where creditnote_invoice_no in (select invoice_no from general_invoice_hdr where customer=?)) " + "and (aaa.inv_bc_amt-aaa.paid_amt_bc)>0 group by invoice_no,inv_bc_amt,inv_tc_amt,currency_code,exchange_rate,paid_amt_bc,paid_amt_tc " + "union select invoice_no,invoice_bc_amount,invoice_tc_amount, currency,exchange_rate, paid_amt_bc,paid_amt_tc,bc_balance_amt, tc_balance_amount "
			+ " from (select gih.invoice_no, gih.amount as invoice_bc_amount, gih.tc_amount as invoice_tc_amount,gih.currency, gih.ex_rate as exchange_rate, " + "gih.amount as paid_amt_bc,gih.tc_amount as paid_amt_tc,gih.amount as bc_balance_amt, gih.tc_amount as tc_balance_amount " + "from general_invoice_hdr gih where gih.customer=? " + "union select hdr.creditnote_no as invoice_no, sum(creditnote_amount) invoice_bc_amount, sum(creditnote_amountusd) invoice_tc_amount, hdr.creditnote_currency currency, "
			+ "creditnote_exchange_rate exchange_rate,creditnote_amount paid_amt_bc, creditnote_amountusd paid_amt_tc, " + "creditnote_amount bc_balance_amt,creditnote_amountusd tc_balance_amount " + "from creditnote_hdr as hdr, creditnote_dtl as dtl where hdr.creditnote_no = dtl.creditnote_no " + "and creditnote_invoice_no in (select invoice_no from general_invoice_hdr where customer=?) " + "group by hdr.creditnote_no, creditnote_amount, creditnote_amountusd,creditnote_amount,creditnote_amountusd) as cntemp "
			+ "where cntemp.invoice_no not in(select invoice_no from cashbank_receipt_invoice) ) AS T1 " + "where inv_bc_amt>0 order by invoice_no desc";

	/*
	 * 
	 * public static final String GET_PENDING_INVOICE_DETAILS = "select
	 * creditnote_no ,created_date,creditnote_account_head,creditnote_currency,
	 * creditnote_exchange_rate,creditnote_invoice_no,creditnote_narration, +
	 * "company_code from creditnote_temp_hdr where creditnote_no=?
	 */public static final String SAVE_CASH_BANK_RCPT_INVOICE_DTL = "INSERT INTO " + "cashbank_receipt_invoice (cashbankreceipt_dtl_id," + " invoice_no, inv_bc_amt, inv_tc_amt, " + "paid_bc_amount, " + "paid_tc_amount, exchange_rate,  currency_code) VALUES (?, ?, ?, ?, ?, ?, ?,  ?)";

	public static final String DELETE_CASHBANK_RCPT_INVOICE_DTL = "delete from cashbank_receipt_invoice where cashbankreceipt_dtl_id IN (select cashbankreceipt_dtl_id from cashbank_receipt_dtl where voucher_no=?)";

	public static final String INSERT_GENERAL_LEDGER_DEBIT_ENTRY_FOR_RECEIPT = "INSERT INTO general_ledger (ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + "exchange_rate, company_id, status, financial_year_id, acct_Balance, parent_code, cost_center,item_id,created_date,created_by) " + "select voucher_dt, bank_acct, voucher_no, 0, amt_local,0,amt_usd,narration,'INR',exchange_rate, company_code, "
			+ "null, null, null, substr(bank_acct,0,5), cost_center, NULL ,voucher_dt,created_by from cashbank_receipt_hdr where voucher_no=?";

	public static final String INSERT_GENERAL_LEDGER_CREDIT_ENTRY_FOR_RECEIPT = "INSERT INTO general_ledger (ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, currency_code, " + "exchange_rate, company_id, status, financial_year_id, acct_Balance, parent_code, cost_center,item_id,created_date,created_by,pay_receipt_dtl) " + "select voucher_dt, acct_head, cbrdtl.voucher_no, cbrdtl.amt_local,0,cbrdtl.amt_usd,0, null,currency,conversion_rate,cbrhdr.company_code,null,null,null,substr(acct_head,0,5),cbrhdr.cost_center,null "
			+ ",voucher_dt,cbrhdr.created_by,cbrdtl.receipt_dtl from cashbank_receipt_dtl cbrdtl left join cashbank_receipt_hdr cbrhdr on cbrhdr.voucher_no= cbrdtl.voucher_no WHERE cbrhdr.voucher_no=?";

	public static final String GET_RCPT_INVOICE_DTL = "select cashbankreceipt_invoice_id cbRcptInvDtlId, cashbankreceipt_dtl_id cashBankRcptDtlId, invoice_no gInvoiceNo, " + "inv_bc_amt bcInvAmt, inv_tc_amt tcInvAmt, paid_bc_amount bcPaidAmt, paid_tc_amount tcPaidAmt, currency_code currency, exchange_rate exchangeRate " + "from cashbank_receipt_invoice where cashbankreceipt_dtl_id=?";

	public static final String UPDATE_CBRECEIPT_DTL = "UPDATE cashbank_receipt_dtl SET VOUCHER_NO=?,ACCT_HEAD=?,SHORT_DTL=?,CHEQUE_NO=?, " + "CHEQUE_DT=?,CURRENCY=?,CONVERSION_RATE=?,AMT_LOCAL=?,AMT_USD=?, DEPT_CODE=?,SUB_GROUP_CODE=?,SL_NO=?,SUB_ACCOUNT_CODE=?, " + "EMPLOYEE=?,LOCATION=?, CUSTOMER=?,SUPPLIER=?,DESIGNATION=?,COMPANY=?,COST_CENTER=?,PATIENT=? WHERE cashbankreceipt_dtl_id=? returning cashbankreceipt_dtl_id";

	public static final String DELETE_GENERAL_LEDGER = "DELETE from general_ledger where transaction_no=?";

	public static final String UPDATE_CBRECEIPT_INVOICE_DTL = "UPDATE cashbank_receipt_invoice SET cashbankreceipt_dtl_id=?, invoice_no=?, inv_bc_amt=?, inv_tc_amt=?, " + "paid_bc_amount=?, paid_tc_amount=?, exchange_rate=?,  currency_code=? WHERE cashbankreceipt_invoice_id=?";

	public static final String DELETE_CBRECEIPT_INVOICE_DTL = "delete from cashbank_receipt_invoice WHERE cashbankreceipt_invoice_id=?";

	public static final String GET_RECEIPT_STATUS = "select COALESCE(REVERSE_BR,'N') as reverseBr from CASHBANK_RECEIPT_HDR WHERE VOUCHER_NO=?";

	public static final String UPDATE_CBRECEIPT_HDR_STATUS = "UPDATE CASHBANK_RECEIPT_HDR SET REVERSE_BR=? WHERE VOUCHER_NO=? ";

	public static final String REVERSE_GENERAL_LEDGER_RECORDS = "INSERT INTO GENERAL_LEDGER(LEDGER_DATE,ACCOUNT_CODE,TRANSACTION_NO,BC_CREDIT,BC_DEBIT,TC_CREDIT,TC_DEBIT, NARRATION, " + "CURRENCY_CODE,EXCHANGE_RATE,COMPANY_ID,FINANCIAL_YEAR_ID, ACCT_BALANCE,PARENT_CODE, CREATED_BY, CREATED_DATE)  " + "select LEDGER_DATE,ACCOUNT_CODE,TRANSACTION_NO,BC_DEBIT,BC_CREDIT,TC_DEBIT,TC_CREDIT, NARRATION, " + "CURRENCY_CODE,EXCHANGE_RATE,COMPANY_ID,FINANCIAL_YEAR_ID, ACCT_BALANCE,PARENT_CODE, ?, now() from GENERAL_LEDGER " + "WHERE TRANSACTION_NO= ?  ";

	public static final String DELETE_CASHBANK_RCPT_INV_DTL = "delete from cashbank_receipt_invoice where cashbankreceipt_dtl_id in (select cashbankreceipt_dtl_id from cashbank_receipt_dtl where voucher_no=?)";

	public static final String UPDATE_RECEIVED_STATUS_SALES_INVOICE_HDR = "update general_invoice_hdr set received_status = ? where invoice_no=?";

	public static final String GET_RECEIPT_VOUCHER_DTL1 = "SELECT cashbankreceipt_dtl_id cashBankRcptDtlId, ACCT_HEAD as acctName,SHORT_DTL as genInvoiceNo,crdtl.CURRENCY as currency,CONVERSION_RATE as exgRate,AMT_LOCAL as bcamount, " + "AMT_USD as tcamount,d.department_name as departmentCode, sgam.sub_group_acct_name as subgroupcode,SL_NO as siNo,SUB_ACCOUNT_CODE as subAccountCode,e.first_name as employeeCode, "
			+ "cn.country_name as countryCode,ent.entity_name as customerCode,enti.entity_name as supplierCode, dn.designation_name as designationName, " + "c.company_name as companyCode,cc.cost_center_name as costCenter, p.patient_name as patientName " + "FROM CASHBANK_RECEIPT_DTL crdtl " + "inner join department d on d.department_code=crdtl.DEPT_CODE " + "inner join sub_group_acct_master sgam on sgam.sub_group_acct_code = crdtl.SUB_GROUP_CODE " + "inner join employee e on e.employee_id = crdtl.employee "
			+ "inner join company_master c on c.company_code = crdtl.COMPANY " + "inner join country cn on cn.country_code=crdtl.LOCATION " + "inner join (select customer_acct_code, entity_name from entity ent where is_customer=true) " + "ent on (ent.customer_acct_code = crdtl.CUSTOMER ) " + "inner join (select supplier_acct_code, entity_name from entity enti where is_vendor=true) " + "enti on (enti.supplier_acct_code = crdtl.SUPPLIER ) " + "inner join designation dn on dn.designation_id = crdtl.DESIGNATION "
			+ "inner join cost_center cc on cc.cost_center_code = crdtl.COST_CENTER " + "inner join patient p on p.patient_id = crdtl.patient WHERE VOUCHER_NO = ? order by SL_NO ASC";
	/*
	 * ==============================Print========================================
	 * ==========
	 */

	public static final String GET_RECEIPT_VOUCHER_VIEW_HDR = "select distinct cbr.VOUCHER_NO as voucherNo,to_char(VOUCHER_DT,'dd/mm/yyyy') as cbReceiptDate,RECEIPT_TYPE as paymentMode,(select emp_name from employee_master where emp_id = created_by limit 1) as preparedby, BANK_ACCT as accountId, EXCHANGE_RATE as exchangeRate,cbr.CHEQUE_NO as chequeNO, (select cost_center_name from cost_center where cost_center_id::text = cbr.COST_CENTER limit 1) as costCenter, to_char(cbr.CHEQUE_DT,'dd/mm/yyyy') as chequeDate,cbr.amt_local as bcAmountHdr,cbr.amt_usd as tcAmountHdr,NARRATION as narration,cbr.COMPANY_CODE as companyCode,RECEIVED_FROM as receivedFrom,receipt_from as receiptfrom,Ahm.Acct_Head_Name as accountName, ahm.acct_currency as acctCurrency,comp.company_name as companyName, comp.address compLocationName,      coalesce(comp.address,'') ||' '|| coalesce(comp.country,'')  as companyAddress,Comp.ph_no companyPhoneNo,  Comp.Email as companyEmail,ent.subAccountName as subAccountName from cashbank_receipt_hdr cbr left join account_head_master ahm on ahm.ACCT_HEAD_CODE = Cbr.Bank_Acct left join cashbank_receipt_dtl cbdt on cbdt.voucher_no = cbr.voucher_no  left join (select subAccountCode, subAccountName from (select distinct customer_acct_code subAccountCode, entity_name subAccountName from entity where is_customer=true) AS subacc ORDER BY subaccountname asc) ent on (ent.subAccountCode = cbdt.sub_account_code ) LEFT JOIN company_master comp on comp.company_code = cbr.company_code where cbr.VOUCHER_NO=? \r\n" ; 
			
			
			/*"select distinct cbr.VOUCHER_NO as voucherNo,to_char(VOUCHER_DT,'dd/mm/yyyy') as cbReceiptDate,RECEIPT_TYPE as paymentMode, BANK_ACCT as accountId, EXCHANGE_RATE as exchangeRate,cbr.CHEQUE_NO as chequeNO,to_char(cbr.CHEQUE_DT,'dd/mm/yyyy') as chequeDate,cbr.amt_local as bcAmountHdr,cbr.amt_usd as tcAmountHdr,NARRATION as narration,cbr.COMPANY_CODE as companyCode,RECEIVED_FROM as receivedFrom,Ahm.Acct_Head_Name as accountName, ahm.acct_currency as acctCurrency,comp.company_name as companyName, comp.address_line1 compLocationName,      coalesce(comp.address_line2,'') ||' '|| coalesce(comp.city,'') ||' '|| coalesce(comp.state,'') ||' '|| coalesce(comp.country,'')  as companyAddress,Comp.phone companyPhoneNo,  Comp.Email as companyEmail,ent.subAccountName as subAccountName "
			+ "from cashbank_receipt_hdr cbr " + "left join account_head_master ahm on ahm.ACCT_HEAD_CODE = Cbr.Bank_Acct " + "left join cashbank_receipt_dtl cbdt on cbdt.voucher_no = cbr.voucher_no  " + "left join (select subAccountCode, subAccountName from (select distinct customer_acct_code subAccountCode, entity_name subAccountName from entity where is_customer=true) AS subacc ORDER BY subaccountname asc) ent on (ent.subAccountCode = cbdt.sub_account_code ) "
			+ "LEFT JOIN company_master comp on comp.company_code = cbr.company_code where cbr.VOUCHER_NO=? ";*/

	public static final String GET_RECEIPT_VOUCHER_VIEW_DTL = "(SELECT  voucher_no cbVoucherNo,  case when sub_account_code like '%S0%' =  true  then (select concat( 'Cr',' ', entity_name )from entity where supplier_acct_code   = sub_account_code limit 1)   when sub_account_code like  '%C0%' =  true  then (select  concat( 'Cr',' ',entity_name) from customer_entity where customer_acct_code   = SUB_ACCOUNT_CODE limit 1)   else  concat( 'Cr',' ', Ahm.Acct_Head_Name  )  end as acctName , SHORT_DTL as shortDetail,crd.CURRENCY as currency,  case when COALESCE(crd.CONVERSION_RATE,0) =0 then 1 else COALESCE(crd.CONVERSION_RATE,0) end as exgRate,crd.amt_usd as tcamount, 0 as bcamountNew,crd.DEPT_CODE as departmentCode,   SUB_GROUP_CODE as subgroupcode, SL_NO as siNo, SUB_ACCOUNT_CODE as subAccountCode, crd.LOCATION as countryCode,EMPLOYEE, CUSTOMER as customerCode,SUPPLIER as supplierCode,DESIGNATION as designationCode,   COMPANY as companyCode,COST_CENTER as costCenter,Ahm.Acct_Head_Name as acctName1,CM.company_NAME as companyName,Sg.Sub_Group_Acct_Name as subGroupAcctName,COALESCE(cus.entity_name,'') as subAccountName  ,(select  pr_name as  receipt  from  cashpayment_receipt_master  where pr_code = receipt_dtl limit 1) FROM CASHBANK_RECEIPT_DTL crd LEFT JOIN account_head_master ahm ON ahm.ACCT_HEAD_CODE = ACCT_HEAD LEFT JOIN company_master CM ON CM.COMPANY_code=crd.COMPANY  	LEFT JOIN sub_group_acct_master sg on Sg.Sub_Group_Acct_Code = SUB_GROUP_CODE  LEFT JOIN (select * from customer_entity where customer_acct_code!='') cus on cus.customer_acct_code = SUB_ACCOUNT_CODE  WHERE VOUCHER_NO =  ? "
			+ " "
			+ "	 union "
			+ " "
			+ " "
			+ "		select  '', concat ( 'Dr',' ', Ahm.Acct_Head_Name ) as acctName,'','',0,0 tcamount,sum(amt_local) as bcamountNew,'','',0,'','','','','',0,'','','','','','','' from cashbank_receipt_hdr  LEFT JOIN account_head_master ahm ON ahm.ACCT_HEAD_CODE = bank_acct  where voucher_no  = ? group by amt_local,acctName ) order by siNo";
			
			/*"SELECT  voucher_no cbVoucherNo,  concat ( 'Cr',' ', Ahm.Acct_Head_Name ) as acctName, SHORT_DTL as shortDetail,crd.CURRENCY as currency,  case when COALESCE(crd.CONVERSION_RATE,0) =0 then 1 else COALESCE(crd.CONVERSION_RATE,0) end as exgRate,crd.amt_usd as tcamount, crd.amt_local as bcamount,crd.DEPT_CODE as departmentCode,   SUB_GROUP_CODE as subgroupcode, SL_NO as siNo, SUB_ACCOUNT_CODE as subAccountCode, crd.LOCATION as countryCode,EMPLOYEE, CUSTOMER as customerCode,SUPPLIER as supplierCode,DESIGNATION as designationCode,   COMPANY as companyCode,COST_CENTER as costCenter,Ahm.Acct_Head_Name as acctName1,CM.company_NAME as companyName,Sg.Sub_Group_Acct_Name as subGroupAcctName,COALESCE(cus.entity_name,'') as subAccountName FROM CASHBANK_RECEIPT_DTL crd LEFT JOIN account_head_master ahm ON ahm.ACCT_HEAD_CODE = ACCT_HEAD LEFT JOIN company_master CM ON CM.COMPANY_code=crd.COMPANY "
			+ "			LEFT JOIN sub_group_acct_master sg on Sg.Sub_Group_Acct_Code = SUB_GROUP_CODE  LEFT JOIN (select * from customer_entity where customer_acct_code!='') cus on cus.customer_acct_code = SUB_ACCOUNT_CODE  WHERE VOUCHER_NO =? order by SL_NO ASC";
			*/
			
			/*"SELECT ACCT_HEAD as acctHeadCode, SHORT_DTL as shortDetail,crd.CURRENCY as currency,  case when COALESCE(crd.CONVERSION_RATE,0) =0 then 1 else COALESCE(crd.CONVERSION_RATE,0) end as exgRate,crd.amt_usd as tcamount, crd.amt_local as bcamount,crd.DEPT_CODE as departmentCode,   SUB_GROUP_CODE as subgroupcode, SL_NO as siNo, SUB_ACCOUNT_CODE as subAccountCode, crd.LOCATION as countryCode,EMPLOYEE, CUSTOMER as customerCode,SUPPLIER as supplierCode,DESIGNATION as designationCode,   COMPANY as companyCode,COST_CENTER as costCenter,Ahm.Acct_Head_Name as acctName,CM.company_NAME as companyName,Sg.Sub_Group_Acct_Name as subGroupAcctName,COALESCE(cus.entity_name,'') as subAccountName FROM CASHBANK_RECEIPT_DTL crd LEFT JOIN account_head_master ahm ON ahm.ACCT_HEAD_CODE = ACCT_HEAD LEFT JOIN company_master CM ON CM.COMPANY_code=crd.COMPANY \r\n"
			+ "LEFT JOIN sub_group_acct_master sg on Sg.Sub_Group_Acct_Code = SUB_GROUP_CODE  LEFT JOIN (select * from customer_entity where customer_acct_code!='') cus on cus.customer_acct_code = SUB_ACCOUNT_CODE  WHERE VOUCHER_NO =? order by SL_NO ASC";*/

	public static final String GET_RECEIPT_VOUCHER_VIEW_INVOICE_DTL = "select INVOICE_no as invoiceNo, paid_bc_amount as receivedAmount,voucher_no from cashbank_receipt_invoice cri " + "inner join cashbank_receipt_dtl dtl on dtl.cashbankreceipt_dtl_id = cri.cashbankreceipt_dtl_id WHERE voucher_no=?";

	public static final String GET_ACCOUNT_INTRA = "select company_name from company_master where company_code=?";

	public static final String REVERSE_CBR = "select * from cash_bank_receipt_reverse(?,?,?)";
	/*
	 * ==========================================================================
	 * =========
	 */

	public static final String REVERSE_CBR_GL = "select * from cashbank_reversal_gl()";

}
