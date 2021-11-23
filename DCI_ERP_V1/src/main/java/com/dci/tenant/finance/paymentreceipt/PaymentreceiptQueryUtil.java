package com.dci.tenant.finance.paymentreceipt;

public class PaymentreceiptQueryUtil {

	public static final String GET_FIN_YEAR_ID = "select max(finyear_id) FIN_YEAR_ID from finyear_defn";

	public static final String AUTOGENERATE_OF_ACCT_HEAD_CODE_WITHOUT_ZERO = "SELECT  case when (select max(pr_code)from cashpayment_receipt_master where pr_code~*?) is null then '0001' ELSE   lpad(cast(cast((SUBSTRING((select max(pr_code) from cashpayment_receipt_master where pr_code~*?),3)) as int)+1  as text),4,'0')  END";
			
			//"select CASE WHEN MAX(acct_head_code) IS NULL THEN ? ELSE rpad(MAX(acct_head_code),4) || lpad(cast(cast((SUBSTRING(MAX(acct_head_code),5)) as int)+1 as text),4,'0') end from account_head_master where acct_head_code like ?";

	public static final String sAttributeList = "select ATTRIBUTE_NAME as attributeName from attribute";

	public static final String sInsertAccountAttributeMapping = "insert into account_attribute_mapping (account_code, attribute_name) values (?,?)";

	public static final String sCurrencyDropDown = "select crrncy_cd currencyCode,crrncy_nam currencyName from currency order by crrncy_nam";

	public static final String ACCONUTLISTEXCEL = "select s.pr_code as accountHeadCode, s.pr_name as subGroupAccountCode,sub.sub_group_acct_name as subGroupAccountName, " + " s.acct_head_name as accountHeadName, acct_currency , " + " case when acct_head_status='Y' then 'YES' when   acct_head_status='N' then 'NO' end as acctHeadStatus, " + " case when ACCT_HEAD_FOR='A' then 'Administrative Related' when   type='P' then 'Operations Related' " + "when   ACCT_HEAD_FOR='R' then 'Student Related' "
			+ "when   ACCT_HEAD_FOR='S' then 'Staff Related' " + "when   ACCT_HEAD_FOR='O' then 'Others' " + " end as grpHd,c.crrncy_nam as currencyName, " + "	s.acct_head_desc as description, s.ACCT_HEAD_FOR as type,sub_group_acct_name as subname from account_head_master s " + "	left join sub_group_acct_master sub on s.subgroup_acct_code=sub.sub_group_acct_code " + "	left join currency c on c.crrncy_cd=acct_currency " + "	 order by acct_head_code";

	public static String sInsertSubGroup = "INSERT INTO cashpayment_receipt_master(pr_code, pr_name, acct_head_desc, created_by, created_dt,payment_status,receipt_status) VALUES ( ?, ?, ?, ?, current_date, ?,?)";

			//"INSERT INTO account_head_master(acct_head_code, subgroup_acct_code, acct_head_name, acct_head_desc, ACCT_HEAD_FOR, created_by, created_dt,ACCT_CURRENCY,FINYEAR_ID,ACCT_HEAD_STATUS) VALUES ( ?, ?, ?, ?, ?, ?, current_date,?,?,?)";

	public static String sUpdateSubGroup = "UPDATE cashpayment_receipt_master SET pr_name=?, acct_head_desc=?,payment_STATUS=? ,receipt_status =?  WHERE pr_code=?";

	public static String sAccountHeadList = " \r\n" + 
			"	select s.pr_code as accountHeadCode, s.pr_name as subGroupAccountCode, s.acct_head_desc as description ,payment_status as ispayment,receipt_status as isreceipt from cashpayment_receipt_master s   order by pr_code\r\n  ";

	// public static String sGroupHeadDropDown =
	// "select sub_group_acct_code as subGroupAccountCode,sub_group_acct_name as
	// subGroupAccountName from SUB_GROUP_ACCT_MASTER";

	public static String sGroupHeadDropDown = "select sub_group_acct_code as subGroupAccountCode, concat(sub_group_acct_code,'-',sub_group_acct_name,'-',  case when group_head_code = 'A' then 'Asset'   when group_head_code = 'L' then 'Liabilities'   when group_head_code = 'I' then 'Income'  when group_head_code = 'E' then 'Expenses' else '' end) as subGroupAccountName  from SUB_GROUP_ACCT_MASTER";

	public static String sEditAccHeadValues = "select a.pr_code as accountHeadCode, a.pr_name as subGroupAccountCode , a.acct_head_desc as description, coalesce(a.payment_status,'N') ispayment, coalesce(a.receipt_status,'N') isreceipt  from cashpayment_receipt_master a  where pr_code = ?";

	public static String sDeleteAccount = " delete from cashpayment_receipt_master where pr_code = ? ";

	public static String GETACCOUNTATTRIBUTEMAPPING = "select ATTRIBUTE_NAME as attributeName from ACCOUNT_ATTRIBUTE_MAPPING where ACCOUNT_CODE =?";

	public static String sDeleteAccountAttributeMapping = "DELETE from ACCOUNT_ATTRIBUTE_MAPPING where ACCOUNT_CODE =?";

	public static String sGetSGAccountAttributeMapping = " select ATTRIBUTE_NAME as attributeName from ACCOUNT_ATTRIBUTE_MAPPING where ACCOUNT_CODE=substring(?,1,4)";
	public static String validatehead = " select pr_name as accountHeadName from cashpayment_receipt_master     ";
	public static String count = " select count(*) from cashpayment_receipt_master where UPPER(pr_name)=UPPER(?) and pr_code not in(?)    ";
}
