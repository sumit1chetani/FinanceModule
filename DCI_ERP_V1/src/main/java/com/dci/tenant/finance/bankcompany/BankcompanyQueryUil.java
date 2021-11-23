package com.dci.tenant.finance.bankcompany;

public class BankcompanyQueryUil {

	public static final String AUTOGENERATE_OF_ACCT_HEAD_CODE_WITHOUT_ZERO = "select CASE WHEN MAX(acct_head_code) IS NULL THEN ? ELSE rpad(MAX(acct_head_code),4) || lpad(cast(cast((SUBSTRING(MAX(acct_head_code),5)) as int)+1 as text),4,'0') end from bank_company_master where acct_head_code like ?";

	public static final String GENERATE_CODE = "SELECT  case when (select max(bank_code )from bank_company_master where bank_code~*?)" + " is null then '0001' ELSE   lpad(cast(cast((SUBSTRING((select max(bank_code) from bank_company_master where bank_code~*?),2))" + " as int)+1  as text),4,'0')  END";

	public static String sInsertSubGroup = "insert into bank_company_master (bank_code,company_code,bank_acct,acct_head_code,branch,bank_short,cash_bankfalg,payment_type,acct_head_status)values(?,?,?,?,?,?,?,?,?)";

	public static String sInsertAccountAttributeMapping = "insert into bankcompany_attribute_mapping (company_code, bank_acct) values (?,?)";

	public static String sAccountHeadList = "  select bank_code as bankCode,bank_short as bankshort, c.company_code as companyCode,c.company_name as companyName, bank_acct as accountName,branch as branch ,c.company_name as companyName,ac.acct_head_name as accountHeadName  from bank_company_master 	left join company_master c on bank_company_master.company_code=c.company_code	left join account_head_master ac on bank_acct=ac.acct_head_code ";
			
			//"select bank_code as bankCode,bank_short as bankshort, company_code as companyCode," + " bank_acct as accountName,branch as branch,c.company_name as companyName,ac.acct_head_name as accountHeadName " + " from bank_company_master " + "	left join company c on company_code=c.company_id " + "	left join account_head_master ac on bank_acct=ac.acct_head_code ";
	public static String deletevalues = "delete from bank_company_master where Bank_code=?";
	public static String Editbankcompanyvalues = "select bank_code as bankCode, company_code as companyCode,bank_acct as accountName,branch as branch,c.company_name as companyName, " + "ac.acct_head_name as accountHeadName,b.acct_head_code as accountHeadName,b.bank_short as  bankshort, b.acct_head_status as isActive , " + "payment_type as paymentType,cash_bankfalg as cashbankPayment " + "from bank_company_master b left join company c on company_code=c.company_id "
			+ "left join account_head_master ac on bank_acct=ac.acct_head_code  where bank_code=?";
	public static String delete = "delete from bank_company_master where Bank_code=?";

	public static String sUpdateSubGroup = "update bank_company_master set company_code=? ,bank_acct=? , acct_head_code =? , branch=?,bank_short=?,cash_bankfalg=?,acct_head_status=?,payment_type=?  where bank_code=?";

}
