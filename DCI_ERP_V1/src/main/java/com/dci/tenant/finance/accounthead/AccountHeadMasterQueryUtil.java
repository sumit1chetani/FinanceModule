package com.dci.tenant.finance.accounthead;

public class AccountHeadMasterQueryUtil {
	
	public static final String GET_FINANCIAL_YEAR_ID = "select financial_year_id from financial_year where is_current ='t'";

	public static final String GET_FIN_YEAR_ID = "select max(finyear_id) FIN_YEAR_ID from finyear_defn";

	public static final String AUTOGENERATE_OF_ACCT_HEAD_CODE_WITHOUT_ZERO = "select CASE WHEN MAX(acct_head_code) IS NULL THEN ? ELSE rpad(MAX(acct_head_code),4) || lpad(cast(cast((SUBSTRING(MAX(acct_head_code),5)) as int)+1 as text),4,'0') end from account_head_master where acct_head_code like ?";

	public static final String sAttributeList = "select ATTRIBUTE_NAME as attributeName from attribute";

	public static final String sInsertAccountAttributeMapping = "insert into account_attribute_mapping (account_code, attribute_name) values (?,?)";

	public static final String sCurrencyDropDown = "select crrncy_cd currencyCode,crrncy_nam currencyName from currency order by crrncy_nam";

	public static final String ACCONUTLISTEXCEL = "select s.acct_head_code as accountHeadCode, s.subgroup_acct_code as subGroupAccountCode,sub.sub_group_acct_name as subGroupAccountName, " + " s.acct_head_name as accountHeadName, acct_currency , " + " case when acct_head_status='Y' then 'YES' when   acct_head_status='N' then 'NO' end as acctHeadStatus, " + " case when ACCT_HEAD_FOR='A' then 'Administrative Related' when   type='P' then 'Operations Related' " + "when   ACCT_HEAD_FOR='R' then 'Student Related' "
			+ "when   ACCT_HEAD_FOR='S' then 'Staff Related' " + "when   ACCT_HEAD_FOR='O' then 'Others' " + " end as grpHd,c.crrncy_nam as currencyName, " + "	s.acct_head_desc as description, s.ACCT_HEAD_FOR as type,sub_group_acct_name as subname from account_head_master s " + "	left join sub_group_acct_master sub on s.subgroup_acct_code=sub.sub_group_acct_code " + "	left join currency c on c.crrncy_cd=acct_currency " + "	 order by acct_head_code";

	public static String sInsertSubGroup = "INSERT INTO account_head_master(acct_head_code, subgroup_acct_code, acct_head_name, acct_head_desc, ACCT_HEAD_FOR, created_by, created_dt,ACCT_CURRENCY,FINYEAR_ID,ACCT_HEAD_STATUS) VALUES ( ?, ?, ?, ?, ?, ?, current_date,?,?,?)";

	public static String sUpdateSubGroup = "UPDATE account_head_master SET acct_head_name=?, acct_head_desc=?, ACCT_HEAD_FOR=?, ACCT_CURRENCY=?,ACCT_HEAD_STATUS=? ,subgroup_acct_code = ? WHERE acct_head_code=?";

	public static String sAccountHeadList = " select s.acct_head_code as accountHeadCode, s.subgroup_acct_code as subGroupAccountCode, s.acct_head_name as accountHeadName, " + "	s.acct_head_desc as description, s.ACCT_HEAD_FOR as type,sub_group_acct_name as subname from account_head_master s " + "left join sub_group_acct_master sub on s.subgroup_acct_code=sub.sub_group_acct_code " + "order by acct_head_code ";

	// public static String sGroupHeadDropDown =
	// "select sub_group_acct_code as subGroupAccountCode,sub_group_acct_name as
	// subGroupAccountName from SUB_GROUP_ACCT_MASTER";

	//modified Query
	//public static String sGroupHeadDropDown = "select sub_group_acct_code as subGroupAccountCode, concat(sub_group_acct_code,'-',sub_group_acct_name,'-',  case when group_head_code = 'A' then 'Asset'   when group_head_code = 'L' then 'Liabilities'   when group_head_code = 'I' then 'Income'  when group_head_code = 'E' then 'Expenses' else '' end) as subGroupAccountName  from SUB_GROUP_ACCT_MASTER";
	public static String sGroupHeadDropDown = "select sub_group_acct_code as subGroupAccountCode, sub_group_acct_name as subGroupAccountName  from SUB_GROUP_ACCT_MASTER";
	
	public static String sEditAccHeadValues = "select a.acct_head_code as accountHeadCode, a.acct_head_name as accountHeadName , a.subgroup_acct_code as subGroupAccountCode, a.acct_head_desc as description, a.ACCT_HEAD_FOR as type, s.sub_group_acct_name as subGroupAccountName, a.ACCT_CURRENCY currencyCode, coalesce(a.ACCT_HEAD_STATUS,'N') acctHeadStatus from account_head_master a left join SUB_GROUP_ACCT_MASTER s on s.sub_group_acct_code = a.subgroup_acct_code where acct_head_code = ?";

	public static String sDeleteAccount = " delete from account_head_master where acct_head_code = ? ";

	public static String GETACCOUNTATTRIBUTEMAPPING = "select ATTRIBUTE_NAME as attributeName from ACCOUNT_ATTRIBUTE_MAPPING where ACCOUNT_CODE =?";

	public static String sDeleteAccountAttributeMapping = "DELETE from ACCOUNT_ATTRIBUTE_MAPPING where ACCOUNT_CODE =?";

	public static String sGetSGAccountAttributeMapping = " select ATTRIBUTE_NAME as attributeName from ACCOUNT_ATTRIBUTE_MAPPING where ACCOUNT_CODE=substring(?,1,4)";
	public static String validatehead = " select acct_head_name as accountHeadName from account_head_master     ";
	public static String count = " select count(*) from account_head_master where UPPER(acct_head_name)=UPPER(?) and acct_head_code not in(?)    ";
}
