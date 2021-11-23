package com.dci.tenant.finance.profitAndLoss;

public class ProfitAndLossQueryUtil {

	public static String GET_PL_HDR = " select gh.group_head_code as groupHeadCode,gh.group_head_name as groupHeadName,gh.group_head_code groupHeadType, " + " sum(gl.bc_credit)  as creditAmount, sum(gl.bc_debit) as debitAmount " + " ,gl.company_id from (sub_group_acct_master sga inner join " + " group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl " + " on sga.sub_group_acct_code = gl.parent_code where gl.ledger_date between " + "  ? and ? and gl.company_id = ? and "
			+ " (gh. group_head_code='I' or gh. group_head_code='E') " + " group by gh.group_head_code,gh.group_head_name,gh.group_head_code,gl.company_id " + " order by gh.group_head_code ";

	public static String GET_PL_DTL = " select parent_code as groupHeadCode ,sga.sub_group_acct_name as groupHeadname ,sum(gl.bc_credit) as creditAmount, " + " sum(gl.bc_debit) as debitAmount ,gl.company_id from (sub_group_acct_master sga inner join " + " group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl " + " on sga.sub_group_acct_code = gl.parent_code where gl.ledger_date between " + " ? and ? and gl.company_id = ?  and " + " (gh. group_head_code='I' or gh. group_head_code='E') and  parent_code like ? "
			+ "  group by parent_code,sga.sub_group_acct_name,gl.company_id order by gl.parent_code ";

	public static String GET_PLAH_DTL = " select account_code as groupHeadCode ,ah.acct_head_name as groupHeadname ,sum(gl.bc_credit) as creditAmount, " + "  sum(gl.bc_debit) as debitAmount ,gl.company_id from  general_ledger gl " + " left join account_head_master ah on ah.acct_head_code=gl.account_code " + " where gl.ledger_date between  ? and ? and gl.company_id = ?  and gl.parent_code =? " + " group by account_code,ah.acct_head_name,gl.company_id ";

	public static String getProfitLossTransaction = "select transaction_no as transactionNo,account_code as accountCode,bc_credit as bcCredit,bc_debit as bcDebit,tc_credit as tcCredit,tc_debit as tcDebit,narration as narration from general_ledger where account_code =? and ledger_date between ? and ?";

}
