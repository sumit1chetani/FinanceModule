package com.dci.tenant.finance.cashbankbook;

public class CashBankBookQueryUtil {

	public static String GET_BANK_ACCOUNT = "select  gl.parent_code,gl.account_code,coalesce(ah.acct_head_name,s.entity_name,c.entity_name) account_name,sum(gl.bc_credit) credit,sum(gl.bc_debit) debit, " + " sum(gl.bc_debit)-sum(gl.bc_credit) AS diffe from general_ledger gl " + " left join account_head_master ah on ah.acct_head_code= gl.account_code " + " left join entity s on gl.account_code = s.supplier_acct_code and  s.is_vendor=true " + " left join entity c on gl.account_code = c.customer_acct_code and  c.is_customer=true "
			+ "where 1=1  group by gl.parent_code,gl.account_code,ah.acct_head_name,s.entity_name,c.entity_name " + " having gl.parent_code = ? order by gl.account_code ";

	public static String GET_BANK_ACCOUNT_filter = "select  gl.parent_code,gl.account_code,coalesce(ah.acct_head_name,s.entity_name,c.entity_name) account_name,sum(gl.bc_credit) credit,sum(gl.bc_debit) debit, " + " sum(gl.bc_debit)-sum(gl.bc_credit) AS diffe from general_ledger gl " + " left join account_head_master ah on ah.acct_head_code= gl.account_code " + " left join entity s on gl.account_code = s.supplier_acct_code and  s.is_vendor=true " + " left join entity c on gl.account_code = c.customer_acct_code and  c.is_customer=true "
			+ "where 1=1   ";

	public static String GET_CASH_ACCOUNT = "select  gl.parent_code,gl.account_code,coalesce(ah.acct_head_name,s.entity_name,c.entity_name) account_name,sum(gl.bc_credit) credit,sum(gl.bc_debit) debit, " + " sum(gl.bc_debit)-sum(gl.bc_credit) AS diffe from general_ledger gl " + " left join account_head_master ah on ah.acct_head_code= gl.account_code " + " left join entity s on gl.account_code = s.supplier_acct_code and  s.is_vendor=true " + " left join entity c on gl.account_code = c.customer_acct_code and  c.is_customer=true "
			+ " group by gl.parent_code,gl.account_code,ah.acct_head_name,s.entity_name,c.entity_name " + " having gl.parent_code = ? order by gl.account_code ";

	public static String GET_CASH_ACCOUNT_filter = "select  gl.parent_code,gl.account_code,coalesce(ah.acct_head_name,s.entity_name,c.entity_name) account_name,sum(gl.bc_credit) credit,sum(gl.bc_debit) debit, " + " sum(gl.bc_debit)-sum(gl.bc_credit) AS diffe from general_ledger gl " + " left join account_head_master ah on ah.acct_head_code= gl.account_code " + " left join entity s on gl.account_code = s.supplier_acct_code and  s.is_vendor=true " + " left join entity c on gl.account_code = c.customer_acct_code and  c.is_customer=true "
			+ "where 1=1";

	public static String GET_SUB_DATA = " select account_code,to_char(ledger_date,'dd/mm/yyyy') ledger_date,transaction_no,sum(bc_credit) credit," + " sum(bc_debit) debit from general_ledger  " + " group by parent_code,account_code,transaction_no,ledger_date having account_code = ? and parent_code = ? order by transaction_no,ledger_date";
	
	public static String GET_SUBGROUP_DATA = "with GL as ( \n" + 
			"    (select LEDGER_DATE::date, PARENT_CODE,  COALESCE(TC_DEBIT,0) LOCAL_DEBIT, COALESCE(TC_CREDIT,0) LOCAL_CREDIT,\n" + 
			"      COALESCE(BC_DEBIT,0) DEBIT, COALESCE(BC_CREDIT,0) CREDIT, SUB_ACCOUNT_CODE, COMPANY_ID, ACCOUNT_CODE ,COST_CENTER\n" + 
			"    from GENERAL_LEDGER))\n" + 
			"select GL.PARENT_CODE as subGroupCode,SG.SUB_GROUP_ACCT_NAME as subGroupName, \n" + 
			"    SUM(DEBIT) as debit,  SUM(CREDIT) as credit, \n" + 
			"       SUM(DEBIT)- SUM(CREDIT) as diffe, (SUM(LOCAL_DEBIT)- SUM(LOCAL_CREDIT)) as balance \n" + 
			"from  GL \n" + 
			"LEFT JOIN SUB_GROUP_ACCT_MASTER SG ON SG.SUB_GROUP_ACCT_CODE = GL.PARENT_CODE where  GL.PARENT_CODE=? ";


}