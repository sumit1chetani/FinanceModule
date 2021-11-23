package com.dci.tenant.finance.grouphead;

public class GroupHeadMasterQueryUtil {
	public static final String sGetGroupHeadList = "select GROUP_HEAD_CODE groupHeadCode,GROUP_HEAD_NAME groupHeadName from GROUP_HEAD_MASTER WHERE ACCT_CODE IS NULL";
}
