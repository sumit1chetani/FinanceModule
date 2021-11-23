package com.dci.tenant.finance.trialBalance;

public class TrialBalanceQueryUtil {
	public static final String GET_VIEW_REPORT2_QUERY = " select account_code as acctHeadCode,coalesce(AH.acct_head_name,'')  || coalesce(cust.entity_name,'') || coalesce(supp.entity_name,'') as acctHeadName," + "  SUM(TC_DEBIT) as tcDebit, SUM(TC_CREDIT) as tcCredit,SUM(BC_DEBIT) as debitAmount, " + "  SUM(BC_CREDIT) as creditAmount,  (SUM(bc_debit) - SUM(bc_credit)) as currentBalance, (SUM(TC_DEBIT)- SUM(TC_CREDIT)) as currentBalance " + " from general_ledger gl left join account_head_master AH on AH.acct_head_code = gl.account_code "
			+ " left join entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code " + "  where  gl.company_id in (?) and   ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and " + "   ledger_date::date <= TO_DATE(?,'DD-MM-YYYY') and parent_code like ? and gl.parent_code=? and gl.account_code=? and gl.sub_account_code=? group by account_code,AH.acct_head_name, " + "  cust.entity_name,supp.entity_name order by account_code ";
	/*
	 * public static final String GET_VIEW_REPORT2_QUERY = "" +
	 * "select  * from crosstab( " + "$$"
	 * 
	 * + "SELECT account_code as acctHeadCode, " +
	 * "   unnest(array[concat(gl.company_id,'_tcDebit'), concat(gl.company_id,'_tcCredit'),  "
	 * +
	 * "   concat(gl.company_id,'_debitAmount'),concat(gl.company_id,'_creditAmount') "
	 * + "   ,concat(gl.company_id,'_currentBalance')]) AS \"Values\", " +
	 * "   unnest(array[sum(TC_DEBIT), SUM(TC_CREDIT) ,SUM(BC_DEBIT), SUM(BC_CREDIT),(SUM(bc_debit) - SUM(bc_credit))]) AS \"Count\" "
	 * +
	 * "from   general_ledger gl left join account_head_master AH on AH.acct_head_code = gl.account_code "
	 * +
	 * "left join entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code where gl.company_id in (?) and ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and ledger_date::date <= TO_DATE(?,'DD-MM-YYYY') and parent_code like ?  group by account_code,gl.company_id,AH.acct_head_name, cust.entity_name,supp.entity_name order by account_code "
	 * + "  $$, " +
	 * "$$VALUES ('C0008_tcDebit'),('C0008_tcCredit'),('C0008_debitAmount'),('C0008_creditAmount') "
	 * +
	 * ",  ('C0008_currentBalance'),('C0009_tcDebit'),('C0009_tcCredit'),('C0009_debitAmount'),('C0009_creditAmount') "
	 * + ",  ('C0009_currentBalance'), " +
	 * "('C0010_tcDebit'),('C0010_tcCredit'),('C0010_debitAmount'),('C0010_creditAmount') "
	 * + ",  ('C0010_currentBalance') , " +
	 * "('C0011_tcDebit'),('C0011_tcCredit'),('C0011_debitAmount'),('C0011_creditAmount') "
	 * + ",  ('C0011_currentBalance') , " +
	 * "('C0012_tcDebit'),('C0012_tcCredit'),('C0012_debitAmount'),('C0012_creditAmount') "
	 * + ",  ('C0012_currentBalance') " + " " + " " + "$$ )as " +
	 * "ct(subGroupCode character varying,\"C0008_tcDebit\" character varying,\"C0008_tcCredit\" character varying, "
	 * +
	 * "\"C0008_debitAmount\" character varying,\"C0008_creditAmount\" character varying,\"C0008_currentBalance\" character varying, "
	 * +
	 * "\"C0009_tcDebit\" character varying,\"C0009_tcCredit\" character varying,\"C0009_debitAmount\" character varying,\"C0009_creditAmount\" character varying, "
	 * + "\"C0009_currentBalance\" character varying, " +
	 * "\"C0010_tcDebit\" character varying,\"C0010_tcCredit\" character varying, "
	 * +
	 * "\"C0010_debitAmount\" character varying,\"C0010_creditAmount\" character varying,\"C0010_currentBalance\" character varying,\"C0011_tcDebit\" character varying,\"C0011_tcCredit\" character varying, "
	 * +
	 * "\"C0011_debitAmount\" character varying,\"C0011_creditAmount\" character varying,\"C0011_currentBalance\" character varying , "
	 * +
	 * "\"C0012_tcDebit\" character varying,\"C0012_tcCredit\" character varying, "
	 * +
	 * "\"C0012_debitAmount\" character varying,\"C0012_creditAmount\" character varying,\"C0012_currentBalance\" character varying)"
	 * ;
	 */
	public static final String GET_VIEW_REPORT3_QUERY = "Select TO_CHAR(LEDGER_DATE,'DD-MM-YYYY') as ledgerDate,general_ledger_id ledgerNo,account_code as accountHeadCode,   transaction_no as transactionNo, " + "   coalesce(GL.narration , '') as narration,CURRENCY_CODE as currency,   exchange_rate as exchangeRate,  SUB_ACCOUNT_CODE as subAccountCode, " + "   GL.parent_code as subgroup ,   SUM(COALESCE(TC_DEBIT,0)) as tcDebit,SUM(COALESCE(TC_CREDIT,0)) as tcCredit,SUM(COALESCE(BC_DEBIT,0)) as debitAmount, "
			+ "   SUM(COALESCE(BC_CREDIT,0)) as creditAmount,e.entity_name as subAccountName " + "from general_ledger GL " + "left join entity e on SUB_ACCOUNT_CODE=e.supplier_acct_code " + " where company_id in (?) " + " and account_code=? " + " and  ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and " + " ledger_date::date <= TO_DATE(?,'DD-MM-YYYY') " + " group  by LEDGER_DATE,general_ledger_id,e.entity_name ";

	/*
	 * public static final String GET_VIEW_REPORT3_QUERY =
	 * 
	 * "" + "select  * from crosstab( " + "$$"
	 * 
	 * +
	 * "SELECT account_code as acctHeadCode, SUB_ACCOUNT_CODE as subAccountCode,    GL.parent_code as subgroup, "
	 * +
	 * "   unnest(array[concat(gl.company_id,'_tcDebit'), concat(gl.company_id,'_tcCredit'),  "
	 * +
	 * "   concat(gl.company_id,'_debitAmount'),concat(gl.company_id,'_creditAmount') "
	 * + "   ,concat(gl.company_id,'_currentBalance')]) AS \"Values\", " +
	 * "   unnest(array[sum(TC_DEBIT), SUM(TC_CREDIT) ,SUM(BC_DEBIT), SUM(BC_CREDIT),(SUM(bc_debit) - SUM(bc_credit))]) AS \"Count\" "
	 * +
	 * "from   general_ledger gl left join account_head_master AH on AH.acct_head_code = gl.account_code "
	 * +
	 * "left join entity cust on cust.customer_acct_code = gl.account_code left join entity supp on supp.supplier_acct_code = gl.account_code where "
	 * + "  gl.account_code=? and " +
	 * "gl.company_id in (?) and ledger_date::date >= TO_DATE(?,'DD-MM-YYYY') and ledger_date::date <= TO_DATE(?,'DD-MM-YYYY')  group by account_code,gl.company_id,AH.acct_head_name, cust.entity_name,supp.entity_name,SUB_ACCOUNT_CODE,GL.parent_code order by account_code "
	 * + "  $$, " +
	 * "$$VALUES ('C0008_tcDebit'),('C0008_tcCredit'),('C0008_debitAmount'),('C0008_creditAmount') "
	 * +
	 * ",  ('C0008_currentBalance'),('C0009_tcDebit'),('C0009_tcCredit'),('C0009_debitAmount'),('C0009_creditAmount') "
	 * + ",  ('C0009_currentBalance'), " +
	 * "('C0010_tcDebit'),('C0010_tcCredit'),('C0010_debitAmount'),('C0010_creditAmount') "
	 * + ",  ('C0010_currentBalance'), " +
	 * "('C0011_tcDebit'),('C0011_tcCredit'),('C0011_debitAmount'),('C0011_creditAmount') "
	 * + ",  ('C0011_currentBalance'), " +
	 * "('C0012_tcDebit'),('C0012_tcCredit'),('C0012_debitAmount'),('C0012_creditAmount') "
	 * + ",  ('C0012_currentBalance')  $$ )as " +
	 * "ct(subGroupCode character varying,subAccountCode character varying ,subgroup character varying,\"C0008_tcDebit\" character varying,\"C0008_tcCredit\" character varying, "
	 * +
	 * "\"C0008_debitAmount\" character varying,\"C0008_creditAmount\" character varying,\"C0008_currentBalance\" character varying, "
	 * +
	 * "\"C0009_tcDebit\" character varying,\"C0009_tcCredit\" character varying,\"C0009_debitAmount\" character varying,\"C0009_creditAmount\" character varying,\"C0009_currentBalance\" character varying, "
	 * +
	 * "\"C0010_tcDebit\" character varying,\"C0010_tcCredit\" character varying,\"C0010_debitAmount\" character varying,\"C0010_creditAmount\" character varying,\"C0010_currentBalance\" character varying, "
	 * +
	 * "\"C0011_tcDebit\" character varying,\"C0011_tcCredit\" character varying,\"C0011_debitAmount\" character varying,\"C0011_creditAmount\" character varying,\"C0011_currentBalance\" character varying , "
	 * +
	 * "\"C0012_tcDebit\" character varying,\"C0012_tcCredit\" character varying,\"C0012_debitAmount\" character varying,\"C0012_creditAmount\" character varying,\"C0012_currentBalance\" numeric   )"
	 * ;
	 */
	public static final String Sub_QUERY = ""
			+ "ORDER BY 1 ,2$$, $$VALUES ('C0008_openingbalancebc'),('C0008_totalbcdebit'),('C0008_totalbccredit'),('C0008_closingbalancebc') ,  ('C0009_openingbalancebc'),('C0009_totalbcdebit'),('C0009_totalbccredit'),('C0009_closingbalancebc') ,   ('C0010_openingbalancebc'),('C0010_totalbcdebit'),('C0010_totalbccredit'),('C0010_closingbalancebc') ,  ('C0011_openingbalancebc'),('C0011_totalbcdebit'),('C0011_totalbccredit'),('C0011_closingbalancebc') ,  ('C0012_openingbalancebc'),('C0012_totalbcdebit'),('C0012_totalbccredit'),('C0012_closingbalancebc') $$ )as  ct(  subGroupCode character varying,subGroupName  character varying, "
			+ "C0008_openingbalancebc numeric,C0008_totalbcdebit numeric, C0008_totalbccredit numeric,C0008_closingbalancebc numeric,C0009_openingbalancebc numeric, C0009_totalbcdebit numeric,C0009_totalbccredit numeric, C0009_closingbalancebc numeric , C0010_openingbalancebc numeric, C0010_totalbcdebit numeric,C0010_totalbccredit numeric, C0010_closingbalancebc numeric, C0011_openingbalancebc numeric, C0011_totalbcdebit numeric,C0011_totalbccredit numeric, C0011_closingbalancebc numeric ,C0012_openingbalancebc numeric, C0012_totalbcdebit numeric,C0012_totalbccredit numeric, C0012_closingbalancebc numeric)";
	public static String GET_COMPANY_LIST = "select company_code as id, company_name as text,location as company from company_user";

	public static String GET_SUBGRP_LIST = "select SUB_GROUP_ACCT_CODE as id,SUB_GROUP_ACCT_NAME as text from SUB_GROUP_ACCT_MASTER";

	public static String GET_TB_SG_LEVEL_LIST_NEW = " select SUB_GROUP_CODE as subGroupCode,sub_group_name as subGroupName,openingbalancebc as openingBalance,totalbcdebit as debitAmount, " + " totalbccredit as creditAmount, closingbalancebc as currentBalance ";

	public static String GET_TB_SG_LEVEL_LIST = ""
			+ "select subGroupCode,subGroupName,coalesce(C0002_openingbalancebc,0) as C0002_openingbalancebc,coalesce(C0008_totalbcdebit,0) as C0008_totalbcdebit ,coalesce(C0008_totalbccredit,0) as C0008_totalbccredit,coalesce(C0008_closingbalancebc,0) as C0008_closingbalancebc,coalesce(C0009_openingbalancebc,0) as C0009_openingbalancebc ,coalesce(C0009_totalbcdebit,0) as C0009_totalbcdebit ,coalesce(C0009_totalbccredit,0) as C0009_totalbccredit,coalesce(C0009_closingbalancebc,0) as C0009_closingbalancebc , coalesce(C0010_openingbalancebc,0) as C0010_openingbalancebc ,coalesce(C0010_totalbcdebit,0) as C0010_totalbcdebit, coalesce(C0010_totalbccredit,0) as C0010_totalbccredit,coalesce(C0010_closingbalancebc,0) as C0010_closingbalancebc,coalesce(C0011_openingbalancebc,0) as C0011_openingbalancebc,coalesce(C0011_totalbcdebit,0)as C0011_totalbcdebit, coalesce(C0011_totalbccredit,0) as C0011_totalbccredit, coalesce(C0011_closingbalancebc,0)as C0011_closingbalancebc,coalesce(C0012_openingbalancebc,0) as C0012_openingbalancebc,coalesce(C0012_totalbcdebit,0) as C0012_totalbcdebit,coalesce(C0012_totalbccredit,0)asC0012_totalbccredit ,coalesce(C0012_closingbalancebc,0) as C0012_closingbalancebc "
			+ " from crosstab( $$"

			+ "SELECT SUB_GROUP_CODE as subGroupCode,sub_group_name as subGroupName,    unnest(array[concat(company_id,'_openingbalancebc'), concat(company_id,'_totalbcdebit'),     concat(company_id,'_totalbccredit'),concat(company_id,'_closingbalancebc')]) AS Values,    unnest(array[openingbalancebc, totalbcdebit, totalbccredit,closingbalancebc]) AS Count";

	// public static String GET_TB_SG_LEVEL_LIST =
	// " select SUB_GROUP_CODE as subGroupCode,sub_group_name as
	// subGroupName,openingbalancebc as openingBalance,totalbcdebit as
	// debitAmount,
	// "
	// + " totalbccredit as creditAmount, closingbalancebc as currentBalance ";

	public static String GET_TB_AH_LEVEL_LIST = " select acct_head_code as acctHeadCode, acct_head_name as acctHeadName,openingbalancebc as openingBalance, " + " totalbcdebit as debitAmount, totalbccredit as creditAmount, closingbalancebc as currentBalance";

	public static String GET_TB_SA_LEVEL_LIST = " select accountheadcode as acctHeadCode,subaccountcode as subAccountCode,subaccountname as subAccountName , " + " openingbalancebc as openingBalance, totalbcdebit as debitAmount, totalbccredit as creditAmount, closingbalancebc as currentBalance ";

	public static String GET_TB_TRANSACTION_LEVEL_LIST = "  WITH T1 as (select   particulars, Dt,  sum(Dr) DR,  sum(Cr) CR  from ( " + "  select  particulars ,  LEDGER_DT  as Dt, coalesce(DEBIT,0) Dr, coalesce(CREDIT,0) Cr " + " from general_ledger  where company_code = ?  and account_head = ? ) T " + " group by particulars, Dt ), T2 as (SELECT  particulars, Dt, Dr,  Cr,  SUM(Dr-Cr) over (order by Dt, particulars)  Cb " + "  FROM T1 ),T3 as (select particulars, Dt,  coalesce( LAG(Cb) over( ORDER BY Dt, particulars),0) Ob,  Dr,  Cr, Cb from T2 ) "
			+ " select particulars as transactionNo,TO_CHAR(DT,'DD/MM/YYYY') as ledgerDate,OB as OpeningBalance,DR as debitAmount,CR as creditAmount, " + " CB as currentBalance from T3 where Dt between TO_DATE (?, 'DD-MM-YYYY') and  TO_DATE (?, 'DD-MM-YYYY') ";

	public static String GET_TB_TRANSACTION_LEVEL_LIST_ALL_COMPANY = "  WITH T1 as (select   particulars, Dt,  sum(Dr) DR,  sum(Cr) CR  from ( " + "  select  particulars ,  LEDGER_DT  as Dt, coalesce(DEBIT,0) Dr, coalesce(CREDIT,0) Cr " + " from general_ledger  where account_head = ? ) T " + " group by particulars, Dt ), T2 as (SELECT  particulars, Dt, Dr,  Cr,  SUM(Dr-Cr) over (order by Dt, particulars)  Cb " + "  FROM T1 ),T3 as (select particulars, Dt,  coalesce( LAG(Cb) over( ORDER BY Dt, particulars),0) Ob,  Dr,  Cr, Cb from T2 ) "
			+ " select particulars as transactionNo,TO_CHAR(DT,'DD/MM/YYYY') as ledgerDate,OB as OpeningBalance,DR as debitAmount,CR as creditAmount, " + " CB as currentBalance from T3 where Dt between TO_DATE (?, 'DD-MM-YYYY') and  TO_DATE (?, 'DD-MM-YYYY') ";

	public static String GET_SUB_GROUP_ACCT_NAME = "select SUB_GROUP_ACCT_CODE,SUB_GROUP_ACCT_NAME from SUB_GROUP_ACCT_MASTER where type=? order by SUB_GROUP_ACCT_NAME asc";

	public static String GET_TB_TRANSACTION_LEVEL_EXCL_RP = "WITH T1 as (select   particulars, Dt,  sum(Dr) DR,  sum(Cr) CR  from ( " + "  select  particulars ,  TO_CHAR(LEDGER_DT,'DD/MM/YYYY')  as Dt, coalesce(DEBIT,0) Dr, coalesce(CREDIT,0) Cr " + " from general_ledger  where company_code = ?  and account_head = ? " + "  AND (SUB_ACCOUNT_CODE NOT IN (select MLO_CODE FROM MLO_MASTER WHERE RELATED_PARTY='Y') " + " OR SUB_ACCOUNT_CODE IS NULL )) T "
			+ " group by particulars, Dt ), T2 as (SELECT  particulars, Dt, Dr,  Cr,  SUM(Dr-Cr) over (order by Dt, particulars)  Cb " + "  FROM T1 ),T3 as (select particulars, Dt,  coalesce( LAG(Cb) over( ORDER BY Dt, particulars),0) Ob,  Dr,  Cr, Cb from T2 ) " + " select particulars as transactionNo,DT as ledgerDate,OB as OpeningBalance,DR as debitAmount,CR as creditAmount, " + " CB as currentBalance from T3 " + " where Dt between TO_DATE (?, 'DD-MM-YYYY') and  TO_DATE (?, 'DD-MM-YYYY')";

	public static String GET_TB_TRANSACTION_LEVEL_EXCL_RP_ALL_COMPANY = "WITH T1 as (select   particulars, Dt,  sum(Dr) DR,  sum(Cr) CR  from ( " + "  select  particulars ,  TO_CHAR(LEDGER_DT,'DD/MM/YYYY')  as Dt, coalesce(DEBIT,0) Dr, coalesce(CREDIT,0) Cr " + " from general_ledger  where company_code = ?  and account_head = ? " + "  AND (SUB_ACCOUNT_CODE NOT IN (select MLO_CODE FROM MLO_MASTER WHERE RELATED_PARTY='Y') " + " OR SUB_ACCOUNT_CODE IS NULL )) T "
			+ " group by particulars, Dt ), T2 as (SELECT  particulars, Dt, Dr,  Cr,  SUM(Dr-Cr) over (order by Dt, particulars)  Cb " + "  FROM T1 ),T3 as (select particulars, Dt,  coalesce( LAG(Cb) over( ORDER BY Dt, particulars),0) Ob,  Dr,  Cr, Cb from T2 ) " + " select particulars as transactionNo,DT as ledgerDate,OB as OpeningBalance,DR as debitAmount,CR as creditAmount, " + " CB as currentBalance from T3 " + " where Dt between TO_DATE (?, 'DD-MM-YYYY') and  TO_DATE (?, 'DD-MM-YYYY')";

	public static String GET_TB_TRANSACTION_LEVEL_ONLY_RP = "WITH T1 as (select   particulars, Dt,  sum(Dr) DR,  sum(Cr) CR  from ( " + "  select  particulars ,  TO_CHAR(LEDGER_DT,'DD/MM/YYYY')  as Dt, coalesce(DEBIT,0) Dr, coalesce(CREDIT,0) Cr " + " from general_ledger  where company_code = ?  and account_head = ? " + "  AND SUB_ACCOUNT_CODE IN (select MLO_CODE FROM MLO_MASTER WHERE RELATED_PARTY='Y')) T " + " group by particulars, Dt ), T2 as (SELECT  particulars, Dt, Dr,  Cr,  SUM(Dr-Cr) over (order by Dt, particulars)  Cb "
			+ "  FROM T1 ),T3 as (select particulars, Dt,  coalesce( LAG(Cb) over( ORDER BY Dt, particulars),0) Ob,  Dr,  Cr, Cb from T2 ) " + " select particulars as transactionNo,DT as ledgerDate,OB as OpeningBalance,DR as debitAmount,CR as creditAmount, " + " CB as currentBalance from T3   where Dt between TO_DATE (?, 'DD-MM-YYYY') and  TO_DATE (?, 'DD-MM-YYYY')";

	public static String GET_TB_TRANSACTION_LEVEL_ONLY_RP_ALL_COMPANY = "WITH T1 as (select   particulars, Dt,  sum(Dr) DR,  sum(Cr) CR  from ( " + "  select  particulars ,  TO_CHAR(LEDGER_DT,'DD/MM/YYYY')  as Dt, coalesce(DEBIT,0) Dr, coalesce(CREDIT,0) Cr " + " from general_ledger  where account_head = ? " + "  AND SUB_ACCOUNT_CODE IN (select MLO_CODE FROM MLO_MASTER WHERE RELATED_PARTY='Y')) T " + " group by particulars, Dt ), T2 as (SELECT  particulars, Dt, Dr,  Cr,  SUM(Dr-Cr) over (order by Dt, particulars)  Cb "
			+ "  FROM T1 ),T3 as (select particulars, Dt,  coalesce( LAG(Cb) over( ORDER BY Dt, particulars),0) Ob,  Dr,  Cr, Cb from T2 ) " + " select particulars as transactionNo,DT as ledgerDate,OB as OpeningBalance,DR as debitAmount,CR as creditAmount, " + " CB as currentBalance from T3   where Dt between TO_DATE (?, 'DD-MM-YYYY') and  TO_DATE (?, 'DD-MM-YYYY')";

	public static String GET_TRANSACTION_LIST = "select particulars as transactionNo,"
			// COALESCE(debit,0.0) as debitAmount,COALESCE(credit,0.0) as
			// creditAmount
			+ " case when company_code = 'C0017' then COALESCE(LOCAL_CREDIT,0.0) else COALESCE(credit,0.0) end as creditAmount," + " case when company_code = 'C0017' then COALESCE(LOCAL_DEBIT,0.0) else COALESCE(debit,0.0) end as debitAmount  " + " from general_ledger " + "where account_head=? and sub_account_code =? and ledger_dt between to_date(?,'DD-MM-YYYY') and to_date(?,'DD-MM-YYYY')";

	public static String GET_TRANSACTION_LIST_SA = "select particulars as transactionNo,"
			// COALESCE(debit,0.0) as debitAmount,COALESCE(credit,0.0) as
			// creditAmount
			+ " case when company_code = 'C0017' then COALESCE(LOCAL_CREDIT,0.0) else COALESCE(credit,0.0) end as creditAmount," + " case when company_code = 'C0017' then COALESCE(LOCAL_DEBIT,0.0) else COALESCE(debit,0.0) end as debitAmount  " + " from general_ledger " + "where account_head=? and (sub_account_code ='' or sub_account_code is null) and ledger_dt between to_date(?,'DD-MM-YYYY') and to_date(?,'DD-MM-YYYY')";

	public static String GET_TB_WITH_PLAIN = "select sg as sg,ah as ah,sa as sa,openingbalancebc openingBalBC,totalbcdebit totalBCDebit,totalbccredit totalBCCredit,closingbalancebc closingBalBC from fn_trial_balance(?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'))";

	public static String GET_ACCOUNTHEAD_LIST = "select acct_head_code as id,concat(acct_head_code,' - ',acct_head_name) as text from account_head_master where subgroup_acct_code=? order by acct_head_name asc";

	public static String GET_SUBACCOUNT_LIST = "select supplier_acct_code as id,concat(supplier_acct_code,'-',entity_name) as text from entity where supplier_acct_code!='' " + "union " + "select customer_acct_code as id,concat(customer_acct_code,'-',entity_name) as text from customer_entity where customer_acct_code!=''";
	public static String GET_ACCOUNTHEAD_LIST1 = "select acct_head_code as id,concat(acct_head_code,' - ',acct_head_name) as text from account_head_master where acct_head_code is Not null order by acct_head_name asc";

}
