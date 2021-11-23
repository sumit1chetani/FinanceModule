package com.dci.tenant.finance.TdsReport;

public class TdsReportQueryUtil {
	/*
	 * public static String list =
	 * "select acct_head_name as acctName ,to_char(ledger_date,'dd/mm/yyyy') as ledgerdate,b.company_id as companyName,transaction_no as particulars,bc_credit as bccredit,tc_credit as tc_credit,b.status as status,company_name as companyCode,account_code as accountCode from general_ledger b 	left join  company c on c.company_id =b.company_id	left join  account_head_master a on a.acct_head_code =account_code where   account_code='20000025' or account_code ='20000024' or  account_code ='10030011' or "
	 * +
	 * " account_code ='10030013' or	 account_code ='10030014' or   account_code ='20000023' or    account_code ='20000026' or  account_code ='20000028'    or "
	 * + " account_code ='20000029' or	 account_code ='50000011' and 1=1 ";
	 * 
	 */
	public static String list = "select acct_head_name as acctName ,to_char(ledger_date,'dd/mm/yyyy') as ledgerdate,b.company_id as companyName,transaction_no as particulars,bc_credit as bccredit,bc_credit as bccreditamount,tc_credit as tc_credit,b.status as status,company_name as companyCode,account_code as accountCode,sub_account_code,e.entity_name as entity,e.pan_number as panno from general_ledger b 	left join  company_master c on c.company_code =b.company_id	left join  account_head_master a on a.acct_head_code =account_code left join  entity e on e.supplier_acct_code =b.sub_account_code  where  1=1";
}
