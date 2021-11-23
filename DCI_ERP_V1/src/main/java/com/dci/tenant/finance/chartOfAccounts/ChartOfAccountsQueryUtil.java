package com.dci.tenant.finance.chartOfAccounts;

public class ChartOfAccountsQueryUtil {

	public static final String GET_GROUP_HEAD_LIST = "select GROUP_HEAD_CODE groupHeadCode,GROUP_HEAD_NAME groupHeadName from group_head_master order by group_head_id asc";
	public static final String GET_SUB_GROUP_HEAD_LIST = "select SUB_GROUP_ACCT_CODE subGroupAcctCode, SUB_GROUP_ACCT_NAME subGroupAcctName from SUB_GROUP_ACCT_MASTER where group_head_code=? ";
	public static final String GET_ACCOUNT_HEAD_LIST = "select ACCT_HEAD_CODE accountHeadCode,ACCT_HEAD_NAME accountHeadName from ACCOUNT_HEAD_MASTER where SUBGROUP_ACCT_CODE=? ";

}
