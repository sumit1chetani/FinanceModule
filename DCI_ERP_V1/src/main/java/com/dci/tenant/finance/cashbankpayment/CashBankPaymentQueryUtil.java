package com.dci.tenant.finance.cashbankpayment;

public class CashBankPaymentQueryUtil {

	public static final String GET_BANK_ACCOUNT_HEAD_LIST_DUBAI ="select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName, 'INR' as currencyCode, 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.crrncy_cd = ahm.acct_currency  where SUBGROUP_ACCT_CODE = ?  ORDER BY ACCT_HEAD_NAME ASC";
//"select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName, " + "'INR' as currencyCode, 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.currency_code = ahm.acct_currency  " + "where SUBGROUP_ACCT_CODE = ?  ORDER BY ACCT_HEAD_NAME ASC";

	public static final String GET_BANK_ACCOUNT_HEAD_LIST_RECO ="select bank_acct as id , "
			+ "ac.acct_head_name as text, "
			+ "bank_acct as acctHeadCode, "
			+ "ac.acct_head_name as accountName from bank_company_master b "
			+ "	left join account_head_master ac on bank_acct=ac.acct_head_code "
			+ "	 "
			+ "	where b.acct_head_status ='Y' and  payment_type='bank' and ac.acct_head_name is not null";
			//"select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName,'INR' as currencyCode, 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.crrncy_cd = ahm.acct_currency  where SUBGROUP_ACCT_CODE = ? and   ahm.Acct_Head_Code in ('10060027','10060023','10060026','10060018','10060034','10060032','10060019','10060028','10060033','10060031','10060012') ORDER BY ACCT_HEAD_NAME ASC";
			//"select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName, " + "'INR' as currencyCode, 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.currency_code = ahm.acct_currency  " + "where SUBGROUP_ACCT_CODE = ? and   ahm.Acct_Head_Code in ('10060027','10060023','10060026','10060018','10060034','10060032','10060019','10060028','10060033','10060031','10060012') ORDER BY ACCT_HEAD_NAME ASC";

	// modified query
	/*public static final String GET_CASH_ACCOUNT_HEAD_LIST_DUBAI = "	select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName, 'INR' as currencyCode, 1 AS exchangeRate  from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.crrncy_cd = ahm.acct_currency  where ahm.Acct_Head_Code in('10000026','10000051','10050001') ORDER BY ACCT_HEAD_NAME ASC";*/
	public static final String GET_CASH_ACCOUNT_HEAD_LIST_DUBAI = "	select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName, 'INR' as currencyCode, 1 AS exchangeRate  from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.crrncy_cd = ahm.acct_currency  where ahm.Acct_Head_Code in('10020001') ORDER BY ACCT_HEAD_NAME ASC";		
	
			//"select ahm.Acct_Head_Code AS id,ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode,ahm.Acct_Head_Name accountName, " + "'INR' as currencyCode, 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm left join currency  curr on  curr.currency_code = ahm.acct_currency  " + "where ahm.Acct_Head_Code in('10000026','10000051') ORDER BY ACCT_HEAD_NAME ASC";

	public static final String GET_EXCHANGE_RATE_WITH_CURRENCY = "select currency_default exchangeRate,CURRENCY_CONVER_FROM from Currency, CURRENCY_CONVER_TO to Currency from currency_master  where currency_code=? ";

	public static final String getVoyageVesselSectorList = "SELECT voy.VOYAGE_ID voyageCode, vessel.VESSEL_CODE vesselCode,vessel.vessel_name vesselName, " + "voy.SECTOR_ID sectorId, sector.SECTOR_NAME sectorName FROM VOYAGE voy " + "left join vessel_master vessel on vessel.VESSEL_CODE = voy.VESSEL_ID " + "left join SECTOR_MASTER sector on sector.SECTOR_CODE = voy.SECTOR_ID where rownum<100";

	public static final String GET_LOCATION_WITH_COMPANY_ID = "select location from company_master where company_code = ? ";

	public static final String AUTOGEN_CASHBANK_VOUCHER_NO = "SELECT CASE WHEN MAX(VOUCHER_NO) IS NULL  THEN  ?  ELSE rpad(MAX (VOUCHER_NO),5,?)|| " + "lpad(cast(cast((SUBSTRING(MAX(VOUCHER_NO),5)) as int)+1 " + "as text),4,'0')  END AS VOUCHER_NO FROM CASHBANK_PAY_HDR where VOUCHER_NO like ?;";

	public static final String AUTOGEN_CASHBANK_VOUCHER_NO_DUBAI = " select ? || nvl(lpad(to_char(max(to_number(substr(VOUCHER_NO,?)))+1), " + " decode(length(to_char(max(to_number(substr(VOUCHER_NO,?)))+1)),1,5,2,5,3,5,4,5,5,5, " + " length(to_char(max(to_number(substr(VOUCHER_NO,?)))+1))),'0'),'00001') AS VOUCHER_NO " + " from CASHBANK_PAY_HDR	where VOUCHER_NO like ? AND VOUCHER_DT > TO_DATE('01/01/2008','DD/MM/YYYY')";

	public static final String SAVE_CASH_BANK_PMT_HDR = "INSERT into CASHBANK_PAY_HDR (VOUCHER_NO, VOUCHER_DT,PAYMENT_TYPE, BANK_ACCT, EXCHANGE_RATE,CHEQUE_NO, CHEQUE_DT, AMT_LOCAL,AMT_USD, " + "NARRATION, created_by,created_dt,Paid_to, COMPANY_CODE,cost_center,cash_deno,approval_note) values(?,?,?,?,?,?,?,?,?,?,?,current_date,?,?,?,?,?)";

	/*public static final String GET_CASHBANK_PMT_HDR_LIST = "select  cbp.VOUCHER_NO as  cbVoucherNo, cbp.VOUCHER_NO as id, cbp.VOUCHER_NO as text, TO_CHAR(cbp.VOUCHER_DT, 'DD/MM/YYYY') cashbankPmtDate,  ahm.acct_head_code acctHeadCode, ahm.acct_head_name accountName,  cbp.AMT_LOCAL bcAmountHdr, cbp.AMT_USD tcAmountHdr ,  case when invoices=',' then '' else invoices end as  invoices,cbp.reverse_bb reverseCb,cpd.sub_account_code,   case when sub_account_code like '%S0%' =  true  then (select string_agg(entity_name,',')from entity where supplier_acct_code   = sub_account_code limit 1)   when sub_account_code like  '%C0%' =  true  then (select  string_agg(entity_name,',') from customer_entity where customer_acct_code   = SUB_ACCOUNT_CODE limit 1)   else  Ahm.Acct_Head_Name   end as subAccountName from  CASHBANK_PAY_HDR cbp "
			+ "					    left join account_head_master ahm on ahm.ACCT_HEAD_CODE=cbp.BANK_ACCT     left join cashbank_pay_dtl cpd on cpd.voucher_no=cbp.voucher_no "
			+ " "
			+ "					    left join (SELECT VOUCHER_NO,string_agg(allocated_bill, ',') invoices 			 FROM cashbank_pay_dtl group by VOUCHER_NO ) dtl  on dtl.VOUCHER_NO = cbp.VOUCHER_NO group by cbp.VOUCHER_NO,ahm.acct_head_code,dtl.invoices,cpd.sub_account_code order by cbp.VOUCHER_DT  desc";*/
			
	public static final String GET_CASHBANK_PMT_HDR_LIST = "select cbp.VOUCHER_NO as cbVoucherNo, cbp.VOUCHER_NO as id, cbp.VOUCHER_NO as text, TO_CHAR(cbp.VOUCHER_DT, 'DD/MM/YYYY') cashbankPmtDate, ahm.acct_head_code acctHeadCode, ahm.acct_head_name accountName,  cbp.AMT_LOCAL bcAmountHdr, cbp.AMT_USD tcAmountHdr , case when invoices=',' then '' else invoices end as  invoices,cbp.reverse_bb reverseCb, Ahm.Acct_Head_Name  as subAccountName from  CASHBANK_PAY_HDR cbp left join account_head_master ahm on ahm.ACCT_HEAD_CODE=cbp.BANK_ACCT left join cashbank_pay_dtl cpd on cpd.voucher_no=cbp.voucher_no left join (SELECT VOUCHER_NO,string_agg(allocated_bill, ',') invoices FROM cashbank_pay_dtl group by VOUCHER_NO ) dtl  on dtl.VOUCHER_NO = cbp.VOUCHER_NO group by cbp.VOUCHER_NO,ahm.acct_head_code,dtl.invoices order by cbp.VOUCHER_DT  desc";	
	
			/*" select  cbp.VOUCHER_NO as  cbVoucherNo, cbp.VOUCHER_NO as id, cbp.VOUCHER_NO as text, TO_CHAR(cbp.VOUCHER_DT, 'DD/MM/YYYY') cashbankPmtDate,  ahm.acct_head_code acctHeadCode, ahm.acct_head_name accountName,  cbp.AMT_LOCAL bcAmountHdr, cbp.AMT_USD tcAmountHdr ,  case when invoices=',' then '' else invoices end as  invoices,cbp.reverse_bb reverseCb,cpd.sub_account_code,string_agg(en.entity_name,',') as subAccountName from  CASHBANK_PAY_HDR cbp\n"
			+ "			    left join account_head_master ahm on ahm.ACCT_HEAD_CODE=cbp.BANK_ACCT     left join cashbank_pay_dtl cpd on cpd.voucher_no=cbp.voucher_no    left join entity en on en.supplier_acct_code=cpd.sub_account_code     			left join (SELECT VOUCHER_NO,string_agg(allocated_bill, ',') invoices 			 FROM cashbank_pay_dtl group by VOUCHER_NO ) dtl  on dtl.VOUCHER_NO = cbp.VOUCHER_NO group by cbp.VOUCHER_NO,ahm.acct_head_code,dtl.invoices,cpd.sub_account_code order by cbp.VOUCHER_DT  desc";
	
			*/
	//Modified here
	public static final String GET_CASHBANK_PMT_HDR_LIST1 = "select cbp.VOUCHER_NO cbVoucherNo, cbp.VOUCHER_NO as id, cbp.VOUCHER_NO as text, TO_CHAR(cbp.VOUCHER_DT, 'DD/MM/YYYY') cashbankPmtDate, ahm.acct_head_code acctHeadCode, ahm.acct_head_name accountName,cbp.AMT_LOCAL bcAmountHdr, cbp.AMT_USD tcAmountHdr ,case when invoices=',' then '' else invoices end as  invoices,cbp.reverse_bb reverseCb, "
					+ " case when sub_account_code like '%S0%' =  true  then (select entity_name from entity where supplier_acct_code   = sub_account_code limit 1)   when sub_account_code like  '%C0%' =  true  then (select  entity_name from customer_entity where customer_acct_code   = SUB_ACCOUNT_CODE limit 1)   else  Ahm.Acct_Head_Name   end as subAccountName "
					+ "   from  CASHBANK_PAY_HDR cbp    left join account_head_master ahm on ahm.ACCT_HEAD_CODE=cbp.BANK_ACCT "
					+ "			   left join CASHBANK_PAY_dtl cbpdtl on cbpdtl.voucher_no = cbp.voucher_no       left join (SELECT VOUCHER_NO,string_agg(allocated_bill, ',') invoices FROM cashbank_pay_dtl group by VOUCHER_NO ) dtl      on dtl.VOUCHER_NO = cbp.VOUCHER_NO    order by voucher_dt desc";
					
					/*"select cbp.VOUCHER_NO cbVoucherNo, cbp.VOUCHER_NO as id, cbp.VOUCHER_NO as text, TO_CHAR(cbp.VOUCHER_DT, 'DD/MM/YYYY') cashbankPmtDate, ahm.acct_head_code acctHeadCode, " + "ahm.acct_head_name accountName,cbp.AMT_LOCAL bcAmountHdr, cbp.AMT_USD tcAmountHdr ,case when invoices=',' then '' else invoices end as  invoices,cbp.reverse_bb reverseCb,ent.entity_name as subAccountName " + "   from  CASHBANK_PAY_HDR cbp " + "   left join account_head_master ahm on ahm.ACCT_HEAD_CODE=cbp.BANK_ACCT "
			+ "   left join CASHBANK_PAY_dtl cbpdtl on cbpdtl.voucher_no = cbp.voucher_no " + "   left join  entity ent on ent.supplier_acct_code= cbpdtl.sub_account_code " + "   left join (SELECT VOUCHER_NO,string_agg(allocated_bill, ',') invoices FROM cashbank_pay_dtl group by VOUCHER_NO ) dtl      on dtl.VOUCHER_NO = cbp.VOUCHER_NO " + "   order by voucher_dt desc";
*/
	/*
	 * public static final String GET_CASHBANK_PMT_HDR_LIST1 =
	 * "select distinct cbp.VOUCHER_NO cbVoucherNo, cbp.VOUCHER_NO as id, cbp.VOUCHER_NO as text, TO_CHAR(cbp.VOUCHER_DT, 'DD/MM/YYYY') cashbankPmtDate, "
	 * +
	 * " ahm.acct_head_code acctHeadCode,ahm.acct_head_name accountName,cbp.AMT_LOCAL bcAmountHdr, cbp.AMT_USD tcAmountHdr , "
	 * +
	 * " case when invoices=',' then '' else invoices end as  invoices,cbp.reverse_bb reverseCb,sub_account_code as subAccountName ,sub_group_acct_name as subacctname "
	 * +
	 * "  from  CASHBANK_PAY_HDR cbp   left join account_head_master ahm on ahm.ACCT_HEAD_CODE=cbp.BANK_ACCT "
	 * + "left join CASHBANK_PAY_dtl cbpdtl on cbpdtl.voucher_no = cbp.voucher_no "
	 * +
	 * "left join sub_group_acct_master sub on sub_account_code=sub.sub_group_acct_code "
	 * +
	 * " left join  entity ent on ent.supplier_acct_code= cbpdtl.sub_account_code "
	 * +
	 * "   left join (SELECT VOUCHER_NO,string_agg(allocated_bill, ',') invoices FROM cashbank_pay_dtl group by VOUCHER_NO ) dtl "
	 * + "      on dtl.VOUCHER_NO = cbp.VOUCHER_NO";	 * 
	 */
			
	public static final String ACCT_HEAD_CODE =	"select sub_group_acct_code from sub_group_acct_master where sub_group_acct_name=?";
   // public static final String ACCT_HEAD_CODE = "select acct_head_code from account_head_master where acct_head_name =?";
    
	public static final String SAVE_CASH_BANK_PMT_DTL = "INSERT into CASHBANK_PAY_DTL (VOUCHER_NO," + " ACCT_HEAD, ALLOCATED_BILL, CURRENCY, CONVERSION_RATE," + " AMT_LOCAL, AMT_USD,dept_code, " + "" + "SUB_GROUP_CODE, SL_NO,SUB_ACCOUNT_CODE," + "EMPLOYEE,LOCATION,CUSTOMER,SUPPLIER," + "DESIGNATION,COMPANY,COST_CENTER,PATIENT, BUDGET_DEFN_ID,short_detail,payment_dtl) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning cashbank_pay_dtl_id";

	public static final String getPmtOrderNoList = "select DISTINCT a.payment_order_no pmtOrderNo,a.payment_order_dt pmtOrderDate " + ",(select pay_amount from payment_order b " + "where b.payment_order_no=a.payment_order_no and pur_inv_no=invoice_no)as pmtOrderAmount,COMPANY_name pmtOrderName,Acct_head_Code acctHeadCode " + "from payment_order a,VBUSINESS_ASSOCIATE V ,purchase_invoice_hdr " + "where " + "a.approved_by is not null and " + "a.payment_order_no in(select ALLOCATED_BILL from CASHBANK_PAY_DTL) "
			+ "and V.COMPANY_code=supplier and pur_inv_no=invoice_no";

	/*
	 * public static final String GET_PAYMENT_VOUCHER_HDR =
	 * "select COALESCE(cd.chq_book_id,0) as chequeNoId, CASHBANK_PAY_HDR.VOUCHER_NO as cbVoucherNo, "
	 * +
	 * " to_char(CASHBANK_PAY_HDR.VOUCHER_DT,'dd/mm/yyyy') as cashbankPmtDate,CASHBANK_PAY_HDR.PAYMENT_TYPE as pmtType, "
	 * +
	 * " CASHBANK_PAY_HDR.COMPANY_CODE as companyName,CASHBANK_PAY_HDR.BANK_ACCT as accountName,CASHBANK_PAY_HDR.EXCHANGE_RATE as exchangeRate,PAID_TO as paidTo, "
	 * +
	 * " CASHBANK_PAY_HDR.CHEQUE_NO as chequeNo,to_char(CASHBANK_PAY_HDR.CHEQUE_DT,'dd/mm/yyyy') as chequeDate,CASHBANK_PAY_HDR.AMT_LOCAL as bcAmountHdr, "
	 * +
	 * " CASHBANK_PAY_HDR.NARRATION as narration,CASHBANK_PAY_HDR.AMT_USD as tcAmountHdr  ,cost_center as costCenter,a.acct_head_name as acctheadName, "
	 * +
	 * " (select company_name from company where company_id = CASHBANK_PAY_HDR.COMPANY_CODE) as company1 from CASHBANK_PAY_HDR  "
	 * +
	 * " left join  cheque_details as cd on cd.bank_account=CASHBANK_PAY_HDR.bank_acct and cd.cheque_number=cheque_no "
	 * +
	 * " left join account_head_master a on CASHBANK_PAY_HDR.BANK_ACCT=a.acct_head_code "
	 * + " where VOUCHER_NO= ? ";
	 */
	/*
	 * public static final String GET_PAYMENT_VOUCHER_HDR =
	 * "select  CASHBANK_PAY_HDR.VOUCHER_NO as cbVoucherNo, " +
	 * "	  to_char(CASHBANK_PAY_HDR.VOUCHER_DT,'dd/mm/yyyy') as cashbankPmtDate,CASHBANK_PAY_HDR.PAYMENT_TYPE as pmtType, "
	 * +
	 * "	   CASHBANK_PAY_HDR.COMPANY_CODE as companyName,CASHBANK_PAY_HDR.BANK_ACCT as accountName,CASHBANK_PAY_HDR.EXCHANGE_RATE as exchangeRate, "
	 * + "	   PAID_TO as paidTo, " +
	 * "	 CASHBANK_PAY_HDR.CHEQUE_NO as chequeNo,to_char(CASHBANK_PAY_HDR.CHEQUE_DT,'dd/mm/yyyy') as chequeDate,CASHBANK_PAY_HDR.AMT_LOCAL as bcAmountHdr, "
	 * +
	 * "	CASHBANK_PAY_HDR.NARRATION as narration,CASHBANK_PAY_HDR.AMT_USD as tcAmountHdr  ,cost_center as costCenter,a.acct_head_name as acctheadName, "
	 * +
	 * "	 (select company_name from company where company_id = CASHBANK_PAY_HDR.COMPANY_CODE) as company1 from CASHBANK_PAY_HDR "
	 * +
	 * "	 left join  cheque_details as cd on cd.bank_account=CASHBANK_PAY_HDR.bank_acct and cd.cheque_number=cheque_no "
	 * +
	 * "	 left join account_head_master a on CASHBANK_PAY_HDR.BANK_ACCT=a.acct_head_code  where VOUCHER_NO=?"
	 * ;
	 */

	public static final String GET_PAYMENT_VOUCHER_HDR = "\n" + "select CASHBANK_PAY_HDR.VOUCHER_NO as cbVoucherNo1, approval_note as  approvenote ,to_char(CASHBANK_PAY_HDR.VOUCHER_DT,'dd/mm/yyyy') as cashbankPmtDate,CASHBANK_PAY_HDR.PAYMENT_TYPE as pmtType,  	   CASHBANK_PAY_HDR.COMPANY_CODE as companyName,CASHBANK_PAY_HDR.BANK_ACCT as accountName,CASHBANK_PAY_HDR.EXCHANGE_RATE as exchangeRate,  	   PAID_TO as paidTo, \n"
			+ "			CASHBANK_PAY_HDR.CHEQUE_NO as chequeNo,to_char(CASHBANK_PAY_HDR.CHEQUE_DT,'dd/mm/yyyy') as chequeDate,CASHBANK_PAY_HDR.AMT_LOCAL as bcAmountHdr,  	CASHBANK_PAY_HDR.NARRATION as narration,CASHBANK_PAY_HDR.AMT_USD as tcAmountHdr  ,cost_center as costCenter,a.acct_head_name as acctheadName,  	 (select company_name from company_master where company_code = CASHBANK_PAY_HDR.COMPANY_CODE) as company1,cc.cost_center_name as costName from CASHBANK_PAY_HDR \n"
			+ "			 left join account_head_master a on CASHBANK_PAY_HDR.BANK_ACCT=a.acct_head_code  \n" + "			 left join cost_center cc on cc.cost_center_id::text=cost_center \n" + "			  where VOUCHER_NO=?";

	public static final String GET_PAYMENT_VOUCHER_DTL = "select cashbank_pay_dtl_id as cashBankPmtDtlId,payment_dtl as cbpdtlpaymentHead, SUB_GROUP_CODE as cbpdtlSubgroupCode,ACCT_HEAD as cbpdtlAccountHead,  SUB_ACCOUNT_CODE as cbdtlsubAccountCode,ALLOCATED_BILL as purInvoiceNo, " + "CURRENCY as cbpdtlCurrencyCode,CONVERSION_RATE as cbpdtlExgRate,AMT_LOCAL as cbpDtlBcAmount,  AMT_USD as cbpDtlTcAmount,  EMPLOYEE as employeeCode,   "
			+ "LOCATION as countryCode,CUSTOMER as customerCode,SUPPLIER as supplierCode, DESIGNATION as designationCode, COMPANY as companyCode,COST_CENTER as costCenter, " + "DEPT_CODE AS departmentCode, COALESCE(patient,0) patientCode, budget_defn_id as budgetDefnId, ( select project_name from budget_definition  where   budget_definition_id  = budget_defn_id limit 1) as budgetDefnName from  CASHBANK_PAY_DTL where VOUCHER_NO=?";

	public static final String DELETE_CBPAYMENT_DTL = " DELETE FROM CASHBANK_PAY_DTL where VOUCHER_NO=?";

	public static final String DELETE_CBPAYMENT_HDR = " DELETE FROM CASHBANK_PAY_HDR where VOUCHER_NO=?";

	public static final String UPDATE_CBPAYMENT_HDR = " UPDATE CASHBANK_PAY_HDR SET VOUCHER_DT =?,PAYMENT_TYPE=?,BANK_ACCT=?,EXCHANGE_RATE=?, " + " CHEQUE_NO =?,CHEQUE_DT=to_date(? ,'DD/MM/YYYY'),AMT_LOCAL=?,AMT_USD=?,NARRATION=?,MODIFIED_BY=?,MODIFIED_DT=current_date, " + " PAID_TO=?,COMPANY_CODE=? ,COST_CENTER=?  where VOUCHER_NO=? ";

	public static final String UPDATE_CBPAYMENT_DTL = "UPDATE CASHBANK_PAY_DTL SET VOUCHER_NO=?, ACCT_HEAD=?, ALLOCATED_BILL=?, CURRENCY=?, CONVERSION_RATE=?, AMT_LOCAL=?, AMT_USD=?,dept_code=?, " + "SUB_GROUP_CODE=?, SL_NO=?,SUB_ACCOUNT_CODE=?,EMPLOYEE=?,LOCATION=?,CUSTOMER=?,SUPPLIER=?,DESIGNATION=?,COMPANY=?,COST_CENTER=?,PATIENT=? ,payment_dtl = ?" + "WHERE cashbank_pay_dtl_id=? returning cashbank_pay_dtl_id";

	public static final String getAttributeList = "SELECT ACCOUNT_CODE acctHeadCode, ATTRIBUTE_NAME attributeName FROM ACCOUNT_ATTRIBUTE_MAPPING WHERE ACCOUNT_CODE=? ";

	public static final String INSERT_GENERAL_LEDGER_CREDIT_ENTRY_PAYMENT = "INSERT INTO general_ledger (ledger_date, account_code, transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration, " + "currency_code, exchange_rate, company_id, status, financial_year_id, acct_Balance, parent_code, cost_center,item_id,created_date,created_by) " + "select voucher_dt, bank_acct, voucher_no, amt_local, 0,amt_local,0,narration,'INR',exchange_rate, company_code, null, null,null, " + "substr(bank_acct,0,5), cost_center, NULL,voucher_dt ,created_by "
			+ "from cashbank_pay_hdr  where voucher_no=?";

	public static final String INSERT_GENERAL_LEDGER_DEBIT_ENTRY_PAYMENT = "INSERT INTO general_ledger (ledger_date, account_code," + " transaction_no, bc_credit, bc_debit, tc_credit, tc_debit, narration," + " " + "currency_code, exchange_rate, company_id, status, financial_year_id, " + "acct_Balance, parent_code, cost_center,item_id,sub_account_code," + "created_date,created_by,pay_receipt_dtl)  " + " " + "select phdr.voucher_dt, pdtl.acct_head, pdtl.voucher_no, 0, pdtl.amt_local,0,pdtl.amt_usd, null,pdtl.currency,  "
			+ "pdtl.conversion_rate,phdr.company_code,null,null,null, pdtl.sub_group_code, phdr.cost_center,null, sub_account_code,phdr.voucher_dt,phdr.created_by,pdtl.payment_dtl " + "from cashbank_pay_dtl pdtl " + "left join cashbank_pay_hdr phdr on phdr.voucher_no= pdtl.voucher_no WHERE phdr.voucher_no=? ";

	public static final String DELETE_GENERAL_LEDGER = "delete from general_ledger where transaction_no=?";

	public static final String GET_PENDING_INVOICE_DETAILS = "select COALESCE(pur_invoice_no,'') as pInvoiceNo, COALESCE(inv_amt_bc,0) bcInvAmt, COALESCE(inv_amt_tc,0) tcInvAmt, COALESCE(currency,'') currency, " + "COALESCE(exg_rate,0) exchangeRate, COALESCE(paid_amt_bc,0) bcPaidAmt, COALESCE(paid_amt_tc,0) tcPaidAmt, COALESCE(bc_balance_amt,0) bcBalanceAmt, " + "COALESCE(tc_balance_amt,0) tcBalanceAmt from (select aaa.pur_invoice_no, aaa.inv_amt_bc,aaa.inv_amt_tc, aaa.currency, aaa.exg_rate, "
			+ "(aaa.inv_amt_bc-aaa.paid_amt_bc) as paid_amt_bc, (aaa.inv_amt_tc - aaa.paid_amt_tc) as paid_amt_tc, (aaa.inv_amt_bc-aaa.paid_amt_bc)  bc_balance_amt, (aaa.inv_amt_tc - aaa.paid_amt_tc) tc_balance_amt " + "from (select  cbpinv.pur_invoice_no, cbpinv.inv_amt_bc,cbpinv.inv_amt_tc,cbpinv.currency, cbpinv.exg_rate, sum(cbpinv.paid_amt_bc) paid_amt_bc, " + "sum(cbpinv.paid_amt_tc) paid_amt_tc from cashbank_pay_inv_dtl cbpinv left join purchase_invoice_hdr pih on pih.invoice_no = cbpinv.pur_invoice_no "
			+ "group by cbpinv.pur_invoice_no,cbpinv.inv_amt_bc,cbpinv.inv_amt_tc,cbpinv.currency,cbpinv.exg_rate) aaa where aaa.pur_invoice_no in (select invoice_no " + "from purchase_invoice_hdr where supplier=?  and payment_status not like 'Fully Paid%') and (aaa.inv_amt_bc-aaa.paid_amt_bc)>0 group by pur_invoice_no,inv_amt_bc,inv_amt_tc,currency,exg_rate, " + "paid_amt_bc,paid_amt_tc union select pih.invoice_no,  pih.amount as inv_amt_bc, pih.tc_amount as inv_amt_tc,pih.currency, pih.ex_rate as exg_rate, "
			+ "pih.amount as paid_amt_bc,pih.tc_amount as paid_amt_tc,pih.amount as bc_balance_amt, pih.tc_amount as tc_balance_amt from purchase_invoice_hdr pih where pih.supplier=? and payment_status not like 'Fully Paid%' " + "and pih.invoice_no not in(select pur_invoice_no from cashbank_pay_inv_dtl)) T1 order by pur_invoice_no desc";

	public static final String GET_PAID_TO_LIST = "select supplier_acct_code as id,entity_name as text from entity where is_vendor='t' order by entity_name asc";

	public static final String SAVE_CASH_BANK_PMT_INVOICE_DTL = "INSERT INTO cashbank_pay_inv_dtl  (cashbank_pay_dtl_id, pur_invoice_no, inv_amt_bc, inv_amt_tc, paid_amt_bc, paid_amt_tc, currency, exg_rate) " + "values (?,?,?,?,?,?,?,?)";

	public static final String GET_PAYMENT_INVOICE_DTL = "select  cashbank_pay_dtl_id cashBankPmtDtlId, pur_invoice_no pInvoiceNo, " + "inv_amt_bc bcInvAmt, inv_amt_tc tcInvAmt, paid_amt_bc bcPaidAmt, paid_amt_tc tcPaidAmt, currency, exg_rate exchangeRate  from cashbank_pay_inv_dtl  where cashbank_pay_dtl_id=?";

	public static final String DELETE_CBPAYMENT_INVOICE_DTL = "delete from cashbank_pay_inv_dtl  where cashbank_pay_dtl_id  in (select cashbank_pay_dtl_id from cashbank_pay_dtl  where voucher_no=?)";

	public static final String DELETE_CB_PAYMENT_INV_DTL = "delete from cashbank_pay_inv_dtl  where payment_inv_dtl_id=?";

	public static final String DELETE_CB_PAYMENT_INV_DTL_WITH_PMT_DTL_ID = "delete from cashbank_pay_inv_dtl  where cashbank_pay_dtl_id=?";

	public static final String DELETE_CB_PAYMENT_DTL = "delete from cashbank_pay_dtl  where cashbank_pay_dtl_id=?";

	public static final String GET_CASHBANK_PMT_DTL_LIST = "select allocated_bill purInvoiceNo, currency AS cbpdtlCurrencyCode, conversion_rate AS cbpdtlExgRate, " + "cbpdtl.amt_local AS cbpDtlBcAmount, cbpdtl.amt_usd AS cbpDtlTcAmount ,BUDGET_DEFN_ID as  budgetDefnId " + "from cashbank_pay_dtl cbpdtl left join cashbank_pay_hdr cbphdr on cbphdr.voucher_no = cbpdtl.voucher_no " + "where cbphdr.voucher_no=?";
	public static final String GET_PENDING_PAYMENT_1STLEVEL_LIST = "select * from payment_historyl";
	public static final String GET_PENDING_PAYMENT_2NDLEVEL_LIST = "select * from payment_historydtl(?)";

	// public static final String GET_PENDING_PAYMENT_1STLEVEL_LIST = "select
	// invoice_no purInvoiceNo, to_char(invoice_dt,'DD/MM/YYYY') as
	// purInvoiceDate,
	// " + "entity.supplier_acct_code as supplierCode, entity.entity_name as
	// supplierName, to_char(due_dt, 'DD/MM/YYYY') dueDate, " +
	// "COALESCE(amount,0)
	// as bcAmountHdr, COALESCE(tc_amount,0) as tcAmountHdr from
	// purchase_invoice_hdr " + "left join entity on entity.supplier_acct_code =
	// purchase_invoice_hdr.supplier order by invoice_no desc";

	// public static final String GET_PENDING_PAYMENT_2NDLEVEL_LIST = "select
	// cbphdr.voucher_no, to_char(cbphdr. voucher_dt,'DD/MM/YYYY') voucherDate,
	// ahm.acct_head_code as acctHeadCode, ahm.acct_head_name as accountName, "
	// +
	// "cbpinv.pur_invoice_no, cbpinv.inv_amt_bc invoiceBCAmt, cbpinv.inv_amt_tc
	// invoiceTCAmt, cbpinv.currency as currencyCode,cbpinv.exg_rate as
	// exchangeRate, " + "paid_amt_bc as paidAmountBC, paid_amt_tc as
	// paidAmountTC,
	// (COALESCE(cbpinv.inv_amt_bc,0) - COALESCE(paid_amt_bc,0)) as
	// bcBalanceAmt, "
	// + "(COALESCE(cbpinv.inv_amt_tc,0) - COALESCE(paid_amt_tc,0)) as
	// tcBalanceAmt
	// " + "from cashbank_pay_inv_dtl cbpinv left join cashbank_pay_dtl cbpdtl
	// on
	// cbpdtl.cashbank_pay_dtl_id = cbpinv.cashbank_pay_dtl_id " + "left join
	// cashbank_pay_hdr cbphdr on cbphdr.voucher_no=cbpdtl.voucher_no left join
	// account_head_master ahm on ahm.acct_head_code = cbpdtl.acct_head " +
	// "where
	// cbpinv.pur_invoice_no=? ";

	public static final String GET_PENDING_PAYMENT_3RDLEVEL_LIST = "select cbpinvdtl.pur_invoice_no as purInvoiceNo, cbpinvdtl.inv_amt_bc invoiceBCAmt, cbpinvdtl.paid_amt_bc paidAmountBC,cbpinvdtl.currency currencyCode, " + "cbpinvdtl.exg_rate exchangeRate from cashbank_pay_inv_dtl  cbpinvdtl " + "left join cashbank_pay_dtl cbpdtl on cbpdtl.cashbank_pay_dtl_id = cbpinvdtl.cashbank_pay_dtl_id " + "left join cashbank_pay_hdr cbphdr on cbphdr.voucher_no = cbpdtl.voucher_no " + "where cbpdtl.cashbank_pay_dtl_id=?";

	public static final String GET_PENDING_PAYMENT_INVOICE_DETAILS = "select COALESCE(pur_invoice_no,'') as purInvoiceNo, TO_CHAR(invoice_dt,'DD/MM/YYYY') as purInvoiceDate,COALESCE(inv_amt_bc,0) invoiceBCAmt, " + "COALESCE(inv_amt_tc,0) invoiceTCAmt, COALESCE(currency,'') currencyCode, COALESCE(exg_rate,0) exchangeRate,  " + "COALESCE(paid_amt_bc,0) paidAmountBC, COALESCE(paid_amt_tc,0) paidAmountTC, COALESCE(bc_balance_amt,0) AS bcBalanceAmt,  "
			+ "COALESCE(tc_balance_amt,0) tcBalanceAmt from (select aaa.pur_invoice_no, aaa.invoice_dt, aaa.inv_amt_bc,aaa.inv_amt_tc, aaa.currency, aaa.exg_rate, " + "aaa.paid_amt_bc, aaa.paid_amt_tc, (aaa.inv_amt_bc-aaa.paid_amt_bc)  bc_balance_amt, (aaa.inv_amt_tc - aaa.paid_amt_tc) tc_balance_amt " + "from (select  cbpinv.pur_invoice_no, pih.invoice_dt, cbpinv.inv_amt_bc,cbpinv.inv_amt_tc, cbpinv.currency, cbpinv.exg_rate, sum(cbpinv.paid_amt_bc) paid_amt_bc, "
			+ "sum(cbpinv.paid_amt_tc) paid_amt_tc from cashbank_pay_inv_dtl cbpinv left join purchase_invoice_hdr pih on pih.invoice_no = cbpinv.pur_invoice_no " + "group by cbpinv.pur_invoice_no,pih.invoice_dt,cbpinv.inv_amt_bc,cbpinv.inv_amt_tc,cbpinv.currency,cbpinv.exg_rate) aaa " + "where aaa.pur_invoice_no in (select invoice_no from purchase_invoice_hdr where supplier=? and payment_status not like 'Fully Paid%') and (aaa.inv_amt_bc-aaa.paid_amt_bc)>0 "
			+ "group by pur_invoice_no,invoice_dt,inv_amt_bc,inv_amt_tc,currency,exg_rate, paid_amt_bc,paid_amt_tc union " + "select pih.invoice_no,  pih.invoice_dt,pih.amount as inv_amt_bc, pih.tc_amount as inv_amt_tc,pih.currency, pih.ex_rate as exg_rate, 0 as paid_amt_bc,0 as paid_amt_tc, " + "pih.amount as bc_balance_amt, pih.tc_amount as tc_balance_amt from purchase_invoice_hdr pih where pih.supplier=? and payment_status not like 'Fully Paid%' "
			+ "and pih.invoice_no not in(select pur_invoice_no from cashbank_pay_inv_dtl)) T1 order by purInvoiceNo desc";

	public static final String GET_PAYMENT_STATUS = "select COALESCE(REVERSE_BB,'N') as reverseBB from CASHBANK_PAY_HDR WHERE VOUCHER_NO =?";

	public static final String UPDATE_CBPAYMENT_HDR_STATUS = "UPDATE CASHBANK_PAY_HDR SET REVERSE_BB=? WHERE VOUCHER_NO=?";

	public static final String REVERSE_GENERAL_LEDGER_RECORDS = "INSERT INTO GENERAL_LEDGER(LEDGER_DATE,ACCOUNT_CODE,TRANSACTION_NO,BC_CREDIT,BC_DEBIT,TC_CREDIT,TC_DEBIT, NARRATION, " + "CURRENCY_CODE,EXCHANGE_RATE,COMPANY_ID,FINANCIAL_YEAR_ID, ACCT_BALANCE,PARENT_CODE)  " + "select LEDGER_DATE,ACCOUNT_CODE,TRANSACTION_NO,BC_DEBIT,BC_CREDIT,TC_DEBIT,TC_CREDIT, NARRATION, " + "CURRENCY_CODE,EXCHANGE_RATE,COMPANY_ID,FINANCIAL_YEAR_ID, ACCT_BALANCE,PARENT_CODE from GENERAL_LEDGER " + "WHERE TRANSACTION_NO= ?";

	public static final String GET_BUDGET_AMNT = "select max(?) from budget_allocation where company=? and status=? and financial_year = (select min(financial_year) from budget_allocation where company=? and status=?)";

	public static final String GET_PAID_FOR_SG = "select coalesce(sum(dtl.amt_local),0) from cashbank_pay_dtl dtl " + "inner join cashbank_pay_hdr hdr on hdr.voucher_no = dtl.voucher_no " + "where(voucher_dt,voucher_dt) OVERLAPS (?::DATE -interval '1'day, ?::DATE +interval '1'day) " + "and sub_group_code =? and company=?";

	public static final String GET_PAYMENT_VOUCHER_VIEW_HDR = "select Cpayhdr.VOUCHER_NO as cbVoucherNo, (select emp_name from employee_master where emp_id = created_by limit 1) as preparedby,to_char(Cpayhdr.VOUCHER_DT,'dd/mm/yyyy') as cashbankPmtDate, (select cost_center_name from cost_center where cost_center_id::text = COST_CENTER limit 1) as costCenter,PAYMENT_TYPE as pmtType, Cpayhdr.COMPANY_CODE as companyCode, Ahm.Acct_Head_Name as accountName, ahm.acct_currency as acctCurrency, comp.company_name as companyName, comp.address compLocationName, coalesce(comp.address,'') ||' '|| coalesce(comp.country,'')  as companyAddress, Comp.ph_no companyPhoneNo,  Comp.email as companyEmail, BANK_ACCT as acctHeadCode,EXCHANGE_RATE as exchangeRate,PAID_TO as paidTo, CHEQUE_NO as chequeNo,to_char(CHEQUE_DT,'dd/mm/yyyy') as chequeDate,amt_local as bcAmountHdr, NARRATION as narration,amt_usd as tcAmountHdr from cashbank_pay_hdr cpayhdr left join account_head_master ahm on ahm.ACCT_HEAD_CODE = Cpayhdr.Bank_Acct LEFT JOIN company_master comp on comp.company_code = Cpayhdr.company_code where VOUCHER_NO=?";
			
		/*	"select Cpayhdr.VOUCHER_NO as cbVoucherNo," + "to_char(Cpayhdr.VOUCHER_DT,'dd/mm/yyyy') as cashbankPmtDate," + "PAYMENT_TYPE as pmtType, " + "Cpayhdr.COMPANY_CODE as companyCode, " + "" + "Ahm.Acct_Head_Name as accountName, ahm.acct_currency as acctCurrency," + " " + "comp.company_name as companyName, comp.address_line1 compLocationName," + " "
			+ "coalesce(comp.address_line2,'') ||' '|| coalesce(comp.city,'') ||' '|| coalesce(comp.state,'') ||' '|| coalesce(comp.country,'')  as companyAddress, " + "Comp.phone companyPhoneNo,  Comp.Email as companyEmail," + " " + "BANK_ACCT as acctHeadCode,EXCHANGE_RATE as exchangeRate,PAID_TO as paidTo," + " " + "CHEQUE_NO as chequeNo,to_char(CHEQUE_DT,'dd/mm/yyyy') as chequeDate," + "amt_local as bcAmountHdr, " + "" + "NARRATION as narration,amt_usd as tcAmountHdr from " + "cashbank_pay_hdr cpayhdr " + "" + "left join account_head_master "
			+ "ahm on ahm.ACCT_HEAD_CODE = Cpayhdr.Bank_Acct " + "LEFT JOIN company_master comp on comp.company_code = Cpayhdr.company_code" + " where VOUCHER_NO=?";*/
	/*
	 * public static final String GET_PAYMENT_VOUCHER_VIEW_DTL =
	 * "select SUB_GROUP_CODE as cbpdtlSubgroupCode,Sg.Sub_Group_Acct_Name as subGroupAcctName, ACCT_HEAD as cbpdtlAccountHead, ahm.ACCT_HEAD_NAME accountHeadName, "
	 * + "SUB_ACCOUNT_CODE as cbdtlsubAccountCode, " +
	 * "COALESCE(cus.entity_name,'') || COALESCE(sup.entity_name,'') || COALESCE(emp.entity_name,'') as subAccountName, "
	 * +
	 * "ALLOCATED_BILL as cbpdtlPmtOrderNo,  CB.CURRENCY as cbpdtlCurrencyCode,CONVERSION_RATE as cbpdtlExgRate,amt_local as cbpDtlBcAmount, "
	 * +
	 * "amt_usd as cbpDtlTcAmount ,EMPLOYEE as employeeCode,CB.LOCATION as countryCode, "
	 * +
	 * "CUSTOMER as customerCode,COALESCE(cus.entity_name,'') customerName, SUPPLIER as supplierCode, COALESCE(sup.entity_name,'') as supplierName, "
	 * +
	 * "DESIGNATION as designationCode, COMPANY as companyCode, CM.company_name as companyName, "
	 * +
	 * "COST_CENTER as costCenter,DEPT_CODE as departmentCode from  CASHBANK_PAY_DTL CB "
	 * + "LEFT JOIN account_head_master ahm ON ahm.ACCT_HEAD_CODE = ACCT_HEAD " +
	 * "LEFT JOIN company CM ON CM.COMPANY_id=CB.COMPANY " +
	 * "LEFT JOIN sub_group_acct_master sg on Sg.Sub_Group_Acct_Code = SUB_GROUP_CODE "
	 * + "LEFT JOIN entity cus on cus.customer_acct_code = SUB_ACCOUNT_CODE " +
	 * "LEFT JOIN entity sup on sup.supplier_acct_code = SUB_ACCOUNT_CODE " +
	 * "LEFT JOIN entity emp on emp.entity_acct_code = SUB_ACCOUNT_CODE " +
	 * "where VOUCHER_NO=? order by SL_NO asc";
	 *//*
		 * public static final String GET_PAYMENT_VOUCHER_VIEW_DTL =
		 * "select SUB_GROUP_CODE as cbpdtlSubgroupCode,ACCT_HEAD as cbpdtlAccountHead,ac.acct_head_name as accountHeadName, "
		 * +
		 * "SUB_ACCOUNT_CODE as cbdtlsubAccountCode,ALLOCATED_BILL as cbpdtlPmtOrderNo, "
		 * +
		 * "CURRENCY as cbpdtlCurrencyCode,CONVERSION_RATE as cbpdtlExgRate,amt_local as cbpDtlBcAmount, "
		 * +
		 * "amt_usd as cbpDtlTcAmount,CUSTOMER as customerCode,SUPPLIER as supplierCode,DESIGNATION as designationCode,COMPANY as companyCode, "
		 * + "COST_CENTER as costCenter,DEPT_CODE as departmentCode " +
		 * "from  cashbank_pay_dtl " +
		 * "inner join account_head_master ac on ac.acct_head_code=ACCT_HEAD " +
		 * "where VOUCHER_NO= ? order by SL_NO asc";
		 */

	public static final String GET_PAYMENT_VOUCHER_VIEW_DTL = "(select SUB_GROUP_CODE as cbpdtlSubgroupCode,ACCT_HEAD as cbpdtlAccountHead, case when sub_account_code like '%S0%' =  true  then (select concat( 'Dr',' ', entity_name )from entity where supplier_acct_code   = sub_account_code limit 1)   when sub_account_code like  '%C0%' =  true  then (select  concat( 'Dr',' ',entity_name) from customer_entity where customer_acct_code   = SUB_ACCOUNT_CODE limit 1)   else  concat( 'Dr',' ', ac.acct_head_name ) end as accountHeadName , "
			+ "SUB_ACCOUNT_CODE as cbdtlsubAccountCode,ALLOCATED_BILL as cbpdtlPmtOrderNo,  cp.CURRENCY as cbpdtlCurrencyCode,CONVERSION_RATE as cbpdtlExgRate, 0 as cbpDtlBcAmount,  cp.amt_usd as cbpDtlTcAmount,CUSTOMER as customerCode,SUPPLIER as supplierCode,DESIGNATION as designationCode,COMPANY as companyCode, "
			+ "					   cp.COST_CENTER as costCenter,DEPT_CODE as departmentCode,cph.narration as narration ,e.entity_name as subAccountName,cp.short_detail as dtlnarration , (select  pr_name as  cbpdtlpaymentHead  from  cashpayment_receipt_master  where pr_code = payment_dtl limit 1),SL_NO from  cashbank_pay_dtl cp  left join account_head_master ac on ac.acct_head_code=ACCT_HEAD   left join  entity e on SUB_ACCOUNT_CODE=e.supplier_acct_code  left join cashbank_pay_hdr cph on cph.voucher_no= cp.voucher_no "
			+ "					    where cp.VOUCHER_NO=  ? "
			+ "			  "
			+ "			union "
			+ "			  "
			+ "			select '','', concat( 'Cr',' ', ahm.Acct_Head_Name) as accountHeadName,'','','',0,sum(amt_local) as bcAmountHdr,0 as cbpDtlTcAmount,'','',0,'',0,'','','','','',0 from cashbank_pay_hdr   left join account_head_master ahm on ahm.ACCT_HEAD_CODE = Bank_Acct "
			+ "			where voucher_no  =  ? "
			+ "			group by amt_local,accountHeadName )order by SL_NO desc";
			
			
			
			
			/*"(select SUB_GROUP_CODE as cbpdtlSubgroupCode,ACCT_HEAD as cbpdtlAccountHead, concat( 'Cr' ,' ',ac.acct_head_name )as accountHeadName,  SUB_ACCOUNT_CODE as cbdtlsubAccountCode,ALLOCATED_BILL as cbpdtlPmtOrderNo,  cp.CURRENCY as cbpdtlCurrencyCode,CONVERSION_RATE as cbpdtlExgRate, 0 as cbpDtlBcAmount,  cp.amt_usd as cbpDtlTcAmount,CUSTOMER as customerCode,SUPPLIER as supplierCode,DESIGNATION as designationCode,COMPANY as companyCode, "
			+ "			   cp.COST_CENTER as costCenter,DEPT_CODE as departmentCode,cph.narration as narration ,e.entity_name as subAccountName,cp.short_detail as dtlnarration ,SL_NO from  cashbank_pay_dtl cp  left join account_head_master ac on ac.acct_head_code=ACCT_HEAD   left join  entity e on SUB_ACCOUNT_CODE=e.supplier_acct_code  left join cashbank_pay_hdr cph on cph.voucher_no= cp.voucher_no   where cp.VOUCHER_NO=  ? "
			+ " "
			+ "union "
			+ " "
			+ "select '','', concat( 'Dr',' ', ahm.Acct_Head_Name) as accountHeadName,'','','',0,sum(amt_local) as bcAmountHdr,0 as cbpDtlTcAmount,'','',0,'',0,'','','','',0 from cashbank_pay_hdr   left join account_head_master ahm on ahm.ACCT_HEAD_CODE = Bank_Acct  where voucher_no  =  ? group by amt_local,accountHeadName )order by SL_NO asc";
			*/
			
			/*"select SUB_GROUP_CODE as cbpdtlSubgroupCode,ACCT_HEAD as cbpdtlAccountHead, " + " ac.acct_head_name as accountHeadName,  SUB_ACCOUNT_CODE as cbdtlsubAccountCode,ALLOCATED_BILL as cbpdtlPmtOrderNo, " + " cp.CURRENCY as cbpdtlCurrencyCode,CONVERSION_RATE as cbpdtlExgRate, cp.amt_local as cbpDtlBcAmount,  cp.amt_usd as cbpDtlTcAmount,CUSTOMER as customerCode,SUPPLIER as supplierCode,DESIGNATION as designationCode,COMPANY as companyCode, "
			+ " cp.COST_CENTER as costCenter,DEPT_CODE as departmentCode,cph.narration as narration ,e.entity_name as subAccountName,cp.short_detail as dtlnarration from  cashbank_pay_dtl cp " + " left join account_head_master ac on ac.acct_head_code=ACCT_HEAD  " + " left join  entity e on SUB_ACCOUNT_CODE=e.supplier_acct_code " + " left join cashbank_pay_hdr cph on cph.voucher_no= cp.voucher_no  " + " where cp.VOUCHER_NO= ? order by SL_NO asc ";
*/
	public static final String GET_PAID_INVOICE_DTLS = "select pur_INVOICE_no as pInvoiceNo," + "" + " paid_amt_bc as bcPaidAmt from cashbank_pay_inv_dtl" + " cpi " + "inner join cashbank_pay_dtl dtl" + " on dtl.cashbank_pay_dtl_id = cpi.cashbank_pay_dtl_id WHERE voucher_no=?";

	public static final String GET_FIN_YEAR_FOR_COMPANY = "select max(financial_year) from budget_allocation where company=? and status=?";
	public static final String GET_FIN_YEAR_FOR_COMPANY1 = "select count(*) from budget_allocation where company=? and status=?";


	public static final String GET_FIN_YEAR_FOR_COMPANY_NEW = "select financial_year_id from financial_year where is_current =true limit 1 ";

	public static final String UPDATE_PAYMENT_STATUS_PIN_HDR = "update purchase_invoice_hdr set payment_status = ? where invoice_no=?";

	public static final String GET_BUDGET_ACCOUNTS = "SELECT array_to_string( array_agg(expenses),',' ) as expenses FROM budget_type";

	public static final String GET_BUDGET_AMOUNT = "select round(coalesce(bam.amount,0)::decimal,2)  from budget_allocation ba inner join budget_allocation_account_mapping bam on bam.budget_allocation_id = ba.budget_allocation_id where company=? and financial_year = ?  and status = ? and sub_group_account =?";

	public static final String GET_BUDGET_DEFN_AMOUNT = "select round(coalesce(amount,0)::decimal,2)  from budget_definition where 1 =1  ";

	public static final String GET_BUDGET_DEFN_AMOUNT_COUNT = "select count(*)  from budget_definition where 1 = 1  ";

	public static final String GET_INVOICE_DTL = "select allocated_bill from CASHBANK_PAY_DTL WHERE VOUCHER_NO =?";

	public static final String UPDATE_INVOICE_STATUS = "update purchase_invoice_hdr set payment_status = 'Not Paid' where invoice_no=?";

	// public static final String GET_CHEQUE_NO_LIST = "select chq_book_id as
	// id,cheque_number as text from cheque_details where bank_account = ? and
	// cheque_status=? and cheque_number not in (select cheque_no from
	// cashbank_pay_hdr where cheque_no is not null ) order by chq_book_id asc
	// ";

	public static final String GET_CHEQUE_NO_LIST = "select chq_book_id as id,cheque_number as text from cheque_details\r\n" + "where bank_account = ?  and cheque_status=? and cheque_number not in (select cheque_no from cashbank_pay_hdr where cheque_no <> '' and bank_acct = ?) order by chq_book_id asc";
	public static final String UPDATE_CHQ_BOOK = "update cheque_details set cheque_date = to_date(:chequeDate,'dd/mm/yyyy'),narration=:narration,cheque_status=:chequeStatus,cheque_amount=:bcAmountHdr where chq_book_id= :chqBookId";

	public static final String UPDATE_CHQ_BOOK_STATUS = "update cheque_details set cheque_status=? where chq_book_id = ?";

	public static final String GET_CHEQUE_NO_EDIT_LIST = "select chq_book_id as id,cheque_number as text from  cheque_details where bank_account=? and cheque_status=? UNION " + "select cd.chq_book_id as id ,cd.cheque_number as text  from  cashbank_pay_hdr " + "inner join  cheque_details as cd on cd.bank_account=cashbank_pay_hdr.bank_acct and cd.cheque_number=cheque_no " + "where voucher_no=? and cashbank_pay_hdr.bank_acct=?";

	public static final String GET_CASH_ACCOUNT_HEAD_LIST_DUBAI_C0010 = "select ahm.Acct_Head_Code AS id," + "ahm.Acct_Head_Name AS text,ahm.Acct_Head_Code acctHeadCode, " + " ahm.Acct_Head_Name accountName,'INR' as currencyCode, " + " 1 AS exchangeRate from ACCOUNT_HEAD_MASTER ahm  " + " left join currency  curr on  curr.currency_code = ahm.acct_currency  where Acct_Head_Code = '10000020' ORDER BY ACCT_HEAD_NAME ASC";

	public static final String GET_BANK_COMPANY = "select bank_acct as id,bank_code as bankcode ,ac.acct_head_name as text,	b.company_code as companyName,company_name as companyCode from bank_company_master b 	left join account_head_master ac on bank_acct=ac.acct_head_code 	left join company_master c on b.company_code=c.company_code 	where  c.company_code=? ";
			
			//"select bank_acct as id,bank_code as bankcode ,ac.acct_head_name as text," + "	b.company_code as companyName,company_name as companyCode from bank_company_master b " + "	left join account_head_master ac on bank_acct=ac.acct_head_code " + "	left join company_master c on company_code=c.company_code " + "	where  company_code=? ";

	public static String getbankcode = "select concat((select company_name  from company_master where company_name='LMOIS'),'LMOIS/KVB') as branch";

	public static final String GET_PURCHASE_ORDER_NUMBER_CAPX1 = "SELECT CASE WHEN MAX(VOUCHER_NO) IS NULL  THEN ? ELSE ?|| lpad(cast(max(cast(RIGHT(VOUCHER_NO,4) as int)+1) as text),4,'0') END from CASHBANK_PAY_HDR where VOUCHER_NO like ? ";

	public static final String GET_PURCHASE_ORDER_NUMBER_CAPX1CP = "SELECT CASE WHEN MAX(VOUCHER_NO) IS NULL  THEN 'CP-20-21-0001' ELSE 'CP-20-21-'|| lpad(cast(max(cast(RIGHT(VOUCHER_NO,4) as int)+1) as text),4,'0') END from CASHBANK_PAY_HDR where VOUCHER_NO like ? ";

	public static final String GET_SUPPLIER = "select sub_group_acct_code as id,sub_group_acct_name as text from sub_group_acct_master";

	public static final String GET_SUBEMP = "select employee_id as id,first_name as text from employee order by first_name asc";

	public static final String SAVE_CASH_BANK_PMT_DTL_cash = "insert into cashbank_pay_dtl_cash (VOUCHER_NO,cash_deno,count,rupes)values(?,?,?,?) returning cashbank_pay_dtl_cash_id";

	public static final String GET_PAYMENT_VOUCHER_DTL_cash = " select d.cashbank_pay_dtl_cash_id as cashBankPmtDtlId,d.cash_deno as denomAmt,d.count as countamt,d.rupes as rupessAmt,c.amt_local as totalCashAmount from cashbank_pay_dtl_cash d 	inner join cashbank_pay_hdr c on c.voucher_no=d.voucher_no where d.voucher_no=? ";

	public static final String UPDATE_CBPAYMENT_DTL_cash = "UPDATE cashbank_pay_dtl_cash SET  voucher_no=? ,cash_deno=?, count=?, rupes=? WHERE cashbank_pay_dtl_cash_id=? ";

	public static final String DELETE_CB_PAYMENT_INV_DTL_WITH_PMT_DTL_ID_cash = "delete from cashbank_pay_dtl_cash  where cashbank_pay_dtl_cash_id=?";

	public static final String DELETE_CB_PAYMENT_DTL_cash = " delete from cashbank_pay_dtl_cash  where cashbank_pay_dtl_cash_id=? ";

	public static final String GET_BUDGET_UTILIZED_AMOUNT_COUNT = "select round(sum(total_amount)::decimal,2) from purchase_order where po_status = 47 ";

	public static final String GET_BUDGET_UTILIZED_AMOUNT_COUNT1 = "select Count(*) from purchase_order where po_status = 47 ";

	public static final String GET_LOCATION_WITH_COMPANY_ID_nEW = "\n" + "select country from company_master  where company_id= ?";

	public static final String REVERSE_CBP = "select * from cash_bank_receipt_payment(?,?,?,?)";

	public static final String GET_PAID_INVOICE_ALLOC_DTLS = "\r\n" + "select pur_invoice_no as invoiceNo,paid_amt_bc as amount from cashbank_pay_inv_dtl alloc left join cashbank_pay_dtl dtl on dtl.cashbank_pay_dtl_id=alloc.cashbank_pay_dtl_id where voucher_no=?";

	public static final String GET_BANK_COMPANY_NEW = "	select bank_acct as id,bank_code as bankcode ,ac.acct_head_name as text,payment_type, 	b.company_code as companyName,company_name as companyCode from bank_company_master b 	left join account_head_master ac on bank_acct=ac.acct_head_code 		left join company_master c on b.company_code=c.company_code	where b.company_code=? and cash_bankfalg='Y' and b.acct_head_status ='Y' and  payment_type='bank'  and ac.acct_head_name is not null";
			//"select bank_acct as id,bank_code as bankcode ,ac.acct_head_name as text,payment_type, " + "	company_code as companyName,company_name as companyCode from bank_company_master b " + "	left join account_head_master ac on bank_acct=ac.acct_head_code " + "		left join company c on company_code=c.company_id 	where company_code=? and cash_bankfalg='Y' and b.acct_head_status ='Y' and  payment_type='bank' ";

	public static final String GET_BANK_COMPANY_NEW_CASH = "select bank_acct as id,bank_code as bankcode ,ac.acct_head_name as text,payment_type, " + "	b.company_code as companyName,company_name as companyCode from bank_company_master b " + "	left join account_head_master ac on bank_acct=ac.acct_head_code " + "		left join company_master c on b.company_code=c.company_code 	where b.company_code=? and cash_bankfalg='Y' and b.acct_head_status ='Y' and  payment_type='cash' and ac.acct_head_name is not null ";

	public static final String REVERSE_CBR_GL = "select * from cashbankpay_reversal_gl(?)";

	public static final String GET_PAyment = "select pr_code as id,pr_name as text  from  cashpayment_receipt_master where  payment_status = 'Y'" ;
	public static final String GET_receipt = "select pr_code as id,pr_name as text  from  cashpayment_receipt_master where  receipt_status = 'Y'" ;

	public static final String GET_receipt_payment = "select pr_code as id,pr_name as text  from  cashpayment_receipt_master ";
	

}
