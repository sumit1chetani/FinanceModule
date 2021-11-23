package com.dci.tenant.finance.subgroupaccount;

public class SubGroupAccountQueryUtil {

	public static String grpHeadDrpDwn = "select group_head_code as id,group_head_name as text,group_head_code grpHeadCode from group_head_master";

	public static String sAddSubGroupDuplicateCount = "select count(*) from SUB_GROUP_ACCT_MASTER where UPPER(trim(SUB_GROUP_ACCT_NAME)) = ? ";

	public static String sAddSubGroup = "INSERT INTO SUB_GROUP_ACCT_MASTER (sub_Head_Code,SUB_GROUP_ACCT_CODE, SUB_GROUP_ACCT_NAME, GROUP_HEAD_CODE, SUB_GROUP_ACCT_DESC, CREATED_BY, CREATED_DT, TYPE) VALUES(?,?,?,?,?,?,?,?)";

	public static String sGetSubGroup = "SELECT (select sub_group_acct_name from sub_head_group_acct_master where sub_group_acct_code = sub_Head_Code) subHeadCode,SUB_GROUP_ACCT_CODE subGroupCode, SUB_GROUP_ACCT_NAME subGroupName, GROUP_HEAD_CODE grpHeadCode, SUB_GROUP_ACCT_DESC subGroupDesc FROM SUB_GROUP_ACCT_MASTER order by SUB_GROUP_ACCT_CODE";

	public static String sUpdateSubGroup = "UPDATE SUB_GROUP_ACCT_MASTER SET SUB_GROUP_ACCT_NAME=?, GROUP_HEAD_CODE=?, SUB_GROUP_ACCT_DESC=?, MODIFIED_BY=?, MODIFIED_DT=current_date, TYPE=?,sub_Head_Code =?  WHERE SUB_GROUP_ACCT_CODE=?";

	public static String sDeleteSubGroup = "DELETE  FROM SUB_GROUP_ACCT_MASTER WHERE SUB_GROUP_ACCT_CODE=?";

	public static String sGetSubGroupCode = "SELECT CASE WHEN MAX(SUB_GROUP_ACCT_CODE) IS NULL THEN ? ELSE rpad(MAX(SUB_GROUP_ACCT_CODE),1) || lpad(cast(cast((SUBSTRING(MAX(SUB_GROUP_ACCT_CODE),3)) as int)+1 as text),3,'0') END FROM SUB_GROUP_ACCT_MASTER WHERE GROUP_HEAD_CODE = ?";

	public static String sGetSubGroupAcctEdit = "SELECT sub_Head_Code subHeadCode,SUB_GROUP_ACCT_CODE subGroupCode, SUB_GROUP_ACCT_NAME subGroupName, GROUP_HEAD_CODE grpHeadCode, SUB_GROUP_ACCT_DESC subGroupDesc, TYPE sgType FROM SUB_GROUP_ACCT_MASTER where SUB_GROUP_ACCT_CODE=?";

	public static String validatehead = " select SUB_GROUP_ACCT_NAME as subGroupName from SUB_GROUP_ACCT_MASTER     ";

	public static String count = " select count(*) from SUB_GROUP_ACCT_MASTER where SUB_GROUP_ACCT_NAME=? and SUB_GROUP_ACCT_NAME not in(?)    ";

	public static String subHeadGrpList = "select sub_group_acct_code as id,sub_group_acct_name as text,group_head_code grpHeadCode from SUB_HEAD_GROUP_ACCT_MASTER where group_head_code=?";

}
