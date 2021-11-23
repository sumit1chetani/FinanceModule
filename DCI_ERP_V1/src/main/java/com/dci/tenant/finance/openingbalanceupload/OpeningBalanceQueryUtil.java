package com.dci.tenant.finance.openingbalanceupload;

public class OpeningBalanceQueryUtil {

	public static final String GET_OpeningBalance_LIST = "select account_head_code as accountHeadName,fin_year as finYear,  (select acct_head_name from account_head_master where acct_head_code = account_head_code) as accountHead, transaction_no as invoiceNo,to_char(transaction_dt,'dd/mm/yyyy') as invoiceDate,bc_amount as bcAmount,tc_amount as tcAmount,transaction_id as transactionid,t.currency as currency,exchange_rate as exchangeRate,payer_short_name as customerName,sundry_status, case when sundry_status='D' then bc_amount  else 0 end as debit, case when sundry_status='C' then bc_amount  else 0 end as credit,t.company_code,c.company_name as companyName  from transactions_in_old t left join company_master c on t.company_code=c.company_code";

	public static final String GETCURRENCY = "select crrncy_cd as id,crrncy_cd as text from currency";
	public static final String GETCOMPANY = "select company_code as id,company_name as text from company_master";

	public static final String GETCUSTOMER = "select * from vw_customer_supplier";

	public static final String SAVE_NEW = "insert into transactions_in_old(transaction_no,transaction_dt,bc_amount,tc_amount,currency,exchange_rate,new_payer_code," + " company_code,sundry_status,account_head_code,fin_year,created_by,created_dt)values(?,to_timestamp(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,now())";

	public static final String SAVE = "insert into transactions_in_old(transaction_no,transaction_dt,bc_amount,tc_amount,currency,exchange_rate,mlo_code,new_mlo_code,new_payer_code,payer_short_name,company_code,sundry_status,account_head_code,sub_account_code,fin_year,created_by,created_dt)values(?,to_timestamp(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
	public static final String CUSTOMER = "" + "  select entity_name  from customer_entity where customer_acct_code=? " + "union all " + "select entity_name from entity where is_vendor='t' and supplier_acct_code=?";

	public static final String CUSTOMER1 = "select  srvc_prtnr_cd  from service_partner where srvc_prtnr_bin =?";
	public static final String EDIT = "select transaction_id as transactionid,transaction_no as invoiceNo,to_char(transaction_dt,'dd/mm/yyyy') as invoiceDate,bc_amount as bcAmount,tc_amount as tcAmount,currency as currency,exchange_rate as exchangeRate,new_payer_code as customer,mlo_code as mloCode,company_code as companyId,sundry_status as sundryStatus,account_head_code as accountHead,sub_account_code  as subAccount  from transactions_in_old where transaction_id=?";

	public static final String Get_Count_With_Sub_Group_Code = "select count(*) from journalvoucher_hdr jh inner join journalvoucher_dtl jd on jd.JOURNAL_NO=jh.JOURNAL_NO where jh.journal_company_code =? and jd.journal_account_head=? and jd.sub_group_code=?";
	public static final String Get_Count_WithOut_Sub_Group_Code = "select count(*) from journalvoucher_hdr jh inner join journalvoucher_dtl jd on jd.JOURNAL_NO=jh.JOURNAL_NO where jh.journal_company_code =? and jd.journal_account_head=? ";
	public static final String Get_JVNo_WithOut_Sub_Group_Code = "	select jh.JOURNAL_NO from journalvoucher_hdr jh inner join journalvoucher_dtl jd on jd.JOURNAL_NO=jh.JOURNAL_NO where jh.journal_company_code =? and jd.journal_account_head=? limit 1";
	public static final String Get_JVNo_With_Sub_Group_Code = "	select jh.JOURNAL_NO from journalvoucher_hdr jh inner join journalvoucher_dtl jd on jd.JOURNAL_NO=jh.JOURNAL_NO where jh.journal_company_code =? and jd.journal_account_head=? and jd.sub_group_code=? limit 1";
	public static final String Update = "update  transactions_in_old  set transaction_no=?,transaction_dt=to_timestamp(?,'dd/MM/yyyy'),bc_amount=?,tc_amount=?,currency=?,exchange_rate=?,mlo_code=?,new_mlo_code=?,new_payer_code=?,payer_short_name=?,company_code=?,sundry_status=?,account_head_code=?,sub_account_code=? where transaction_id=? ";
	public static final String Get_Account_Code = " select customer_acct_code  from customer_entity where customer_acct_code=? " + "union all " + "select supplier_acct_code from entity where is_vendor='t' and supplier_acct_code=?";

	public static final String GET_OpeningBalance_LIST_COMPANY_LIST = "select transaction_no as invoiceNo,to_char(transaction_dt,'dd/mm/yyyy') as invoiceDate,bc_amount as bcAmount,coalesce(tc_amount,0) as tcAmount, " + "account_head_code as accountHead,a.acct_head_name as accountHeadName, " + "transaction_id as transactionid,currency as currency,exchange_rate as exchangeRate,payer_short_name as customerName, " + "(select company_name from company_master c  where c.company_code=t.company_code limit 1) as companyName from transactions_in_old t "
			+ "left join account_head_master a on a.acct_head_code=account_head_code " + " order by payer_short_name";
	public static final String NEW_QUERY_FOR_PURCHASE_TYPE = "select customer_acct_code from customer_entity where entity_name=?";
	public static final String NEW_QUERY_FOR_VENDOR_TYPE = "select acct_head_code from account_head_master where acct_head_name= ?";
	public static final String NEW_QUERY_FOR_COMPANY = "select company_id from company where company_name=?";
	public static final String GET_Supplier_LIST = "select customer_acct_code,trim(entity_name) as entity_name from customer_entity where is_customer='t'";
	public static final String CHECK_CREDIT = "with t as ( " + "select case when sundry_status='D' then bc_amount  else 0 end as debit, case when sundry_status='C' then bc_amount  else 0 end as credit ,company_code from transactions_in_old t) " + "select sum(credit) as credit from t";
	public static final String CHECK_DEBIT = "with t as ( " + "select case when sundry_status='D' then bc_amount  else 0 end as debit, case when sundry_status='C' then bc_amount  else 0 end as credit,company_code  from transactions_in_old t) " + "select sum(debit) as debit from t ";

	public static final String GET_OPENING_BALANCE_COMPANY = "select account_head_code as accountHeadName, (select acct_head_name from account_head_master where acct_head_code = account_head_code) as accountHead, transaction_no as invoiceNo,to_char(transaction_dt,'dd/mm/yyyy') as invoiceDate,bc_amount as bcAmount,tc_amount as tcAmount,transaction_id as transactionid,currency as currency,exchange_rate as exchangeRate,payer_short_name as customerName,sundry_status, "
			+ "case when sundry_status='D' then bc_amount  else 0 end as debit, case when sundry_status='C' then bc_amount  else 0 end as credit,company_code,c.company_name as companyName  from transactions_in_old t left join company c on company_id=company_code " + "where company_code=?";

	public static final String ADD_JOURNAL_VOUCHER_DTL = " INSERT INTO JOURNALVOUCHER_DTL (JOURNAL_NO,JOURNAL_ACCOUNT_HEAD,JOURNAL_CURRENCY,JOURNAL_EXCHANGE_RATE,JOURNAL_DEBIT, " + " JOURNAL_CREDIT,JOURNAL_NARRATION,JOURNAL_DEPARTMENT,JOURNAL_VOYAGE,JOURNAL_VESSEL,JOURNAL_SECTOR,SUB_GROUP_CODE, " + " JOURNAL_DEBITUSD,JOURNAL_CREDITUSD,SL_NO,SUB_ACCOUNT_CODE,EMPLOYEE,PORT,AGENT,LOCATION ,CUSTOMER,SUPPLIER,DESIGNATION, " + " COMPANY,COST_CENTER)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

}
