package com.dci.tenant.finance.profitandlossnew;

public class ProfitAndLossQueryUtilNew {

	public static final String GET_PROFIT_LOSS_EXCEL_HDR_FINANCIAL_YEAR = "select(COALESCE(sum(coalesce(tc_credit,0.0))-sum(coalesce(tc_debit,0.0)),0.0)) as amount , acct_head_code accountHeadCode,ah.acct_head_name as accountHeadName from general_ledger gl  left join account_head_master ah on ah.acct_head_code = gl.account_code  where extract(year from ledger_date) = extract(year from now())";

	public static final String Branch = "	select brnch_nam from branch where brnch_id in (?)";

	public static final String GET_PROFIT_LOSS_EXCEL_HDR_new =  "select abs( (COALESCE(sum(coalesce(tc_credit,0.0))-sum(coalesce(tc_debit,0.0)),0.0))) as amount ," + "" + "" + "parent_code as subGroupCode,account_code accountHeadCode, ah.acct_head_name as accountHeadName," + "" + "sgh.group_head_code,sg.sub_head_code as sgcode from general_ledger gl" + " left join account_head_master ah on ah.acct_head_code = gl.account_code" + "   left join sub_group_acct_master sg on sg.sub_group_acct_code  = gl.parent_code "
			+ "  left join sub_head_group_acct_master sgh on sgh.sub_group_acct_code  = sg.sub_head_code " + " where (gl.ledger_date::date between TO_DATE (?, 'dd/mm/yyyy') and TO_DATE (?, 'dd/mm/yyyy')) and cost_center = ? ";


	public static String GET_PL_HDR_C0017 = " select gh.group_head_code as groupHeadCode,gh.group_head_name as groupHeadName,gh.group_head_code groupHeadType,  " + " COALESCE(sum(gl.LOCAL_CREDIT),0) as creditAmount, " + " COALESCE(sum(gl.LOCAL_DEBIT),0) as debitAmount     ,  " + " ,gl.company_code from (sub_group_acct_master sga inner join " + " group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl "
			+ " on sga.sub_group_acct_code = gl.SUB_GROUP_CODE where gl.ledger_dt::date between   TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and trim(gl.company_code) = ? and " + " (gh. group_head_code='I' or gh. group_head_code='E') " + " group by gh.group_head_code,gh.group_head_name,gh.group_head_code,gl.company_code " + " order by gh.group_head_code ";

	public static String GET_PL_HDR = " select gh.group_head_code as groupHeadCode,gh.group_head_name as groupHeadName,gh.group_head_code groupHeadType, " + " COALESCE(sum(gl.credit),0) as creditAmount, COALESCE(sum(gl.debit),0)  as debitAmount  " + " ,gl.company_code from (sub_group_acct_master sga inner join " + " group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl "
			+ " on sga.sub_group_acct_code = gl.SUB_GROUP_CODE where gl.ledger_dt::date between   TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and trim(gl.company_code) = ? and " + " (gh. group_head_code='I' or gh. group_head_code='E') " + " group by gh.group_head_code,gh.group_head_name,gh.group_head_code,gl.company_code " + " order by gh.group_head_code ";

	public static String GET_PL_DTL_C0017 = " select SUB_GROUP_CODE as groupHeadCode ,sga.sub_group_acct_name as groupHeadname ,"
			// COALESCE(sum(gl.credit),0) as creditAmount, " + "
			// COALESCE(sum(gl.debit),0) as debitAmount ,
			+ " COALESCE(sum(gl.LOCAL_CREDIT),0) as creditAmount, " + " COALESCE(sum(gl.LOCAL_DEBIT),0) as debitAmount     ,  " + " gl.company_code from (sub_group_acct_master sga inner join " + " group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl " + " on sga.sub_group_acct_code = gl.SUB_GROUP_CODE where gl.ledger_dt::date between   TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and trim(gl.company_code) = ? "
			+ " and  (gh. group_head_code='I' or gh. group_head_code='E') and  trim(gl.SUB_GROUP_CODE) like ? " + " group by SUB_GROUP_CODE,sga.sub_group_acct_name,gl.company_code order by gl.SUB_GROUP_CODE ";

	public static String GET_PL_DTL = " select SUB_GROUP_CODE as groupHeadCode ,sga.sub_group_acct_name as groupHeadname ,COALESCE(sum(gl.credit),0) as creditAmount, " + " COALESCE(sum(gl.debit),0) as debitAmount ,gl.company_code from (sub_group_acct_master sga inner join " + " group_head_master gh on sga.group_head_code =gh.group_head_code) inner join general_ledger gl " + " on sga.sub_group_acct_code = gl.SUB_GROUP_CODE where gl.ledger_dt::date between   TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and trim(gl.company_code) = ? "
			+ " and  (gh. group_head_code='I' or gh. group_head_code='E') and  trim(gl.SUB_GROUP_CODE) like ? " + " group by SUB_GROUP_CODE,sga.sub_group_acct_name,gl.company_code order by gl.SUB_GROUP_CODE ";

	public static String GET_COMPANY_LIST = "select COMPANY_CODE as id,COMPANY_NAME as text from COMPANY_MASTER";

	public static String GET_PLAH_DTL_C0017 = " select ACCOUNT_HEAD as groupHeadCode,AH.ACCT_HEAD_NAME as groupHeadname,"
			// COALESCE(sum(gl.credit),0) as creditAmount, " + "
			// COALESCE(sum(gl.debit),0) as debitAmount
			+ " COALESCE(sum(gl.LOCAL_CREDIT),0)as creditAmount, " + " COALESCE(sum(gl.LOCAL_DEBIT),0) as debitAmount     ,  " + " from GENERAL_LEDGER gl " + " left join ACCOUNT_HEAD_MASTER AH on AH.ACCT_HEAD_CODE = gl.ACCOUNT_HEAD " + " where gl.ledger_dt::date between   TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and trim(gl.company_code) = ? and  SUB_GROUP_CODE=? " + " group by gl.ACCOUNT_HEAD,AH.ACCT_HEAD_NAME ";

	public static String GET_PLAH_DTL = " select ACCOUNT_HEAD as groupHeadCode,AH.ACCT_HEAD_NAME as groupHeadname,COALESCE(sum(gl.credit),0) as creditAmount, " + " COALESCE(sum(gl.debit),0) as debitAmount from GENERAL_LEDGER gl " + " left join ACCOUNT_HEAD_MASTER AH on AH.ACCT_HEAD_CODE = gl.ACCOUNT_HEAD " + " where gl.ledger_dt::date between   TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and trim(gl.company_code) = ? and  SUB_GROUP_CODE=? " + " group by gl.ACCOUNT_HEAD,AH.ACCT_HEAD_NAME ";

	public static String GET_PROFIT_LOSS_EXCEL_HDR_C0017 = "select (COALESCE(sum(coalesce(local_credit,0.0))-sum(coalesce(local_debit,0.0)),0.0))as amount ,sub_group_code as subGroupCode,account_head accountHeadCode, " + "ah.acct_head_name as accountHeadName from general_ledger gl " + "left join account_head_master ah on ah.acct_head_code = gl.account_head " + "where (gl.ledger_dt::date between TO_DATE (?, 'dd/mm/yyyy') and TO_DATE (?, 'dd/mm/yyyy')) ";

	public static String GET_PROFIT_LOSS_EXCEL_HDR = "select abs( (COALESCE(sum(coalesce(tc_credit,0.0))-sum(coalesce(tc_debit,0.0)),0.0))) as amount ," + "" + "" + "parent_code as subGroupCode,account_code accountHeadCode, ah.acct_head_name as accountHeadName," + "" + "sgh.group_head_code,sg.sub_head_code as sgcode from general_ledger gl" + " left join account_head_master ah on ah.acct_head_code = gl.account_code" + "   left join sub_group_acct_master sg on sg.sub_group_acct_code  = gl.parent_code "
			+ "  left join sub_head_group_acct_master sgh on sgh.sub_group_acct_code  = sg.sub_head_code " + " where (gl.ledger_date::date between TO_DATE (?, 'dd/mm/yyyy') and TO_DATE (?, 'dd/mm/yyyy')) ";

}
